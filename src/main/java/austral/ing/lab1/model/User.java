package austral.ing.lab1.model;


import austral.ing.lab1.entity.Homeworks;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

  @OneToMany(orphanRemoval=true)
  @JoinColumn(name="USER_ID") // como un curso tiene mucho material, el id del curso debe estar en la tabla de material
  private Set<Homework> homeworks = new HashSet<>();


  @ManyToMany(mappedBy = "users", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
  private Set<Course> courses = new HashSet<>();

  //@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  //private List<Assignment> assignment = new ArrayList<>();

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  private List<Address> addresses = new ArrayList<>();


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public Set<Course> getCourses() {
    return courses;
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public byte[] getProfilePic() {
    return profilePicture;
  }

  public void setProfilePic(byte[] image) {
    this.profilePicture = image;
  }

  public void enrollIncourse(Course course) {
    courses.add(course);
    course.getUsers().add(this);
  }

  public Set<Homework> getHomeworks() {
    return homeworks;
  }



  public byte[] getProfilePicture() {
    return profilePicture;
  }

  public void setProfilePicture(byte[] profilePicture) {
    this.profilePicture = profilePicture;
  }

  public void addHomework(Homework homework) {
    this.homeworks.add(homework);
    Homeworks.persist(homework);
  }

  //  public Blob getPicture() {
//    return picture;
//  }
//
//
//  public void setPicture(Blob picture) {
//    this.picture = picture;
//  }

//  @Transient
//  public String getBase64Image() {
//    base64Image = Base64.getEncoder().encodeToString(this.profilePicture);
//    return base64Image;
//  }
}
