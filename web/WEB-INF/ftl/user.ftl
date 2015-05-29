<#import "/spring.ftl" as spring />
<html >
<body>
${message!}
<#list users as user >
   <p> ${user}</p>
</#list>
<#--@spring.bind "user" /-->
<form  method="post" name="user" >
    <h3>Form</h3>
    <label for="login">Login:</label>
    <@spring.formInput "user.login", "id='login'"/>
    <label for="pass">Password:</label>
    <@spring.formPasswordInput "user.pass", "id='pass'"/>
    <label for="email">Email:</label>
    <@spring.formInput "user.email", "id='email'"/>
    <label for="user">User</label>
    <@spring.formCheckbox path="user.role" attributes="value='user' id='user'" />
    <label for="admin">Admin</label>
    <@spring.formCheckbox path="user.role" attributes="value='admin' id='admin'" />
    <label for="sex">Sex</label>
    <#--assign sex={"male":"male", "female":"female"}/-->
    <#--@spring.formRadioButtons path="user.sex" options= sex separator="" attributes="id=''sex" /-->
    <@spring.formSingleSelect path="user.sex" options=sex attributes="id='sex'"/>
    <input type="submit" value="Submit">
</form>
</body>
</html>