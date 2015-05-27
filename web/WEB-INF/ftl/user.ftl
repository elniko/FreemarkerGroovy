<#import "/spring.ftl" as spring />
<html >
<body>
<@spring.bind "user" />
<form  method="post" >
    <h3>Form</h3>
    <label for="login">Login:</label>
    <@spring.formInput "user.login", "id='login'"/>
    <label for="pass">Password:</label>
    <@spring.formPasswordInput "user.pass", "id='pass'"/>
    <label for="email">Email:</label>
   <@spring.formInput "user.email", "id='email'"/>
    <input type="submit" value="Submit">
</form>
</body>
</html>