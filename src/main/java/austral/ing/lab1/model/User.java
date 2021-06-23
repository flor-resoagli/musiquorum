package austral.ing.lab1.model;


import austral.ing.lab1.entity.Homeworks;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.*;

import java.util.ArrayList;
import java.util.List;


@Entity
//@Table(name = "USER", indexes = @Index(name = "EMAIL", columnList = "EMAIL", unique = true))
public class User {

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private Long id;

  @Column(name = "PASSWORD")
  private String password;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private List<Address> addresses = new ArrayList<>();

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "IS_ACTIVE")
  private Boolean isActive;

//  @Column(name="picture")
//  private Blob picture;
  @Lob
  @Basic(fetch = FetchType.LAZY)
  private byte[] profilePicture;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Homework> homeworks = new HashSet<>();

  @ManyToMany(mappedBy = "users", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
  private Set<Course> courses = new HashSet<>();

  //FIRST NAME
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //LAST NAME
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //EMAIL
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  //ID
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  //ACTIVE
  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  //PASSWORD
  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  //COURSES
  public Set<Course> getCourses() {
    return courses;
  }

  public void addCourse(Course course){
    courses.add(course);
    course.addUser(this);
  }

  //PROFILE PIC
  public byte[] getProfilePic() {
    return profilePicture;
  }

  public void setProfilePic(byte[] image) {
    this.profilePicture = image;
  }

  //PENDING ASSIGNMENTS
  public boolean isAssignmentPending(Assignment assignment){
    for(Homework h : homeworks){
      if(h.getAssignment().equals(assignment)) return false;
    }
    return true;
  }

  //DELIVERED HOMEWORKS
  public Set<Homework> getHomeworks() {
    return homeworks;
  }

  public void addHomework(Homework homework) {
    homeworks.add(homework);
    homework.setStudentEmail(this.email);
    homework.setUser(this);
  }

  public void removeHomework(Homework homework) {
    homeworks.remove(homework);
  }

  public Homework getHomeworkForAssignment(Assignment assignment) {
    for(Homework h : homeworks){
      if(h.getAssignment().getAssignmentID() == (assignment.getAssignmentID())) return h;
    }
    return null;
  }

  public void setParametersForHomework(Homework homework, String contentType, SerialBlob serialBlob) {
    for(Homework h : homeworks){
      if(h.equals(homework)){
        h.setContentType(contentType);
        h.setData(serialBlob);
      }
    }
  }

  //COMPLETED HOMEWORKS
  /*
  public Set<Homework> getHomeworksCompleted() {
    return homeworksCompleted;
  }

  public void addCompletedHomework(Homework homework) {
    this.homeworksCompleted.add(homework);
    homework.setStudentEmail(this.email);
  }

  public Homework getCompletedHomeworkForAssignment(Assignment assignment) {
    for(Homework h : homeworksCompleted){
      if(h.getAssignment().getAssignmentID() == (assignment.getAssignmentID())) return h;
    }
    return null;
  }
   */

  //ENROLL IN COURSE
  public void enrollInCourse(Course course) {
    addCourse(course);
    //add assignmentsPending

  }

  public void markAsCompleted(Assignment assignment) {
    for(Homework h : homeworks){
      if(h.getAssignment().getAssignmentID() == (assignment.getAssignmentID())){
        //Homework hw = h;
        h.setStatus("completed");
        h.persist();
        //homeworks.remove(h);
        //homeworks.add(hw);
      }
    }
  }
}
