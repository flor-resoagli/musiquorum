<jsp:useBean id="course" scope="request" type="austral.ing.lab1.model.Course"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Class Creation</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>


<style>
    body {
        background-color: white;
        font-family: 'Century Gothic';
    }

    button {

        background-color: white;
        color: cornflowerblue;
        padding: 5px 5px;
        text-align: center;
        display: inline-block;
        font-size: 17px;
        border: none;
        border-radius: 8px;
        cursor: pointer;
        margin: 5px;
    }

    button:hover {
        background-color: cornflowerblue; /* Green */
        color: white;
    }

    button:active {
        background-color: cornflowerblue;
        box-shadow: 0 5px #666;
        transform: translateY(4px);
    }

    h1{
        color: black;
        padding-top: 30px;
        font-size: 35px;
        padding-bottom: 20px;

    }

    label{
        color: #2c3034;
        font-size: 20px;
    }

    p{
        font-size: 12px;
    }
</style>


<body>

<div class="jumbotron-fluid"
     style="background-color: cornflowerblue; color: white; margin-bottom: 20px; padding: 20px" >
    <h2> Musiquorum </h2>
</div>

<form method="post" action="${pageContext.request.contextPath}/secure/createClass.do?courseID=${course.courseID}" enctype='multipart/form-data'>
    <div class="container">


        <div class="shadow-sm p-3 mb-5 bg-white rounded">

            <h1>Create a new class!</h1>

            <div class="form-group">
                <label for="name">Class Name</label>
                <input type="text" name="name" class = "form-control" id= "name" placeholder="Name" required/>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Please fill out this field.</div>
            </div>

            <div class="form-group">
                <label for="duration">Duration</label>
                <input type="text" name="duration" class = "form-control" id= "duration" placeholder="Duration" required/>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Please fill out this field.</div>
            </div>

            <div class="form-group">
                <label for="fileName">File Name</label>
                <input type="text" name="fileName" class = "form-control" id= "fileName" placeholder="File Name" required/>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Please fill out this field.</div>
            </div>

            <div class="form-group">
                <label for="file">Material</label>
                <input type="file" name="file" class = "form-control" id= "file" placeholder="Material" required/>
                <div class="valid-feedback">Valid.</div>
                <div class="invalid-feedback">Please fill out this field.</div>
            </div>



            <button type="Create class" class="btn btn-success btn-block">Submit</button>
            <button class="btn-light btn-block" onclick="document.location = 'courseProfile.jsp'"> Cancel</button>

        </div>
    </div>
</form>
</body>
</html>
