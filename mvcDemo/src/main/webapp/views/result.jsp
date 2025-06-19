<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
        }
        form {
            width: 300px;
            padding: 20px;
            border-radius: 10px;
            background-color: #f2f2f2;
            box-shadow: 0px 0px 10px #ccc;
          
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input, select {
            width: 100%;
            padding: 5px;
            margin-top: 5px;
        }
        .gender-group {
            display: flex;
            gap:20px;
            margin-top: 5px;
        }
         .gender-group label {
            display: flex;
            align-items: center;
            gap: 8px;
        }
         
        button {
            margin-top: 15px;
            padding: 8px;
            width: 100%;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
   <h1>Result is:   ${student}</h1> 
   
   <h1>Welcome ${name}</h1>
   
   
       <h2>Student Information Form</h2>

    <form action="/submitStudent" method="post">
        <label for="name">Name:</label>
        <input type="text" name="name" required>

        <label for="age">Age:</label>
        <input type="number" name="age" required>

        <label>Gender:</label>
        <div class="gender-group">
            <label><input type="radio" name="gender" value="Male" required> Male</label>
            <label><input type="radio" name="gender" value="Female"> Female</label>
            <label><input type="radio" name="gender" value="Other"> Other</label>
        </div>

        <label for="country">Country:</label>
        <select name="country" required>
            <option value="">-- Select Country --</option>
            <option value="India">India</option>
            <option value="USA">USA</option>
            <option value="UK">UK</option>
            <option value="Canada">Canada</option>
        </select>

        <button type="submit">Submit</button>
    </form>
</body>
</html>