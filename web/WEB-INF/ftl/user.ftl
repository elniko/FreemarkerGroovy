<#import "/spring.ftl" as spring />
<html >
<body>
${message!}
<#if users??>
    <#list users as user >
    <p> ${user}</p>
    </#list>
</#if>
<@spring.bind "user" />

<#if spring.status.error>
    <#list spring.status.errorMessages as error>
    <li>${error}</li>
    </#list>
</#if>

<form  method="post">
    <h3>Form</h3>
    <label for="login">Login:</label>
<@spring.formInput "user.login", "id='login'"/>
<@spring.showErrors "", "error"/>
    <label for="pass">Password:</label>
<@spring.formPasswordInput "user.pass", "id='pass'"/>
<@spring.showErrors "", "error"/>
    <label for="email">Email:</label>
<@spring.formInput "user.email", "id='email'"/>
<@spring.showErrors "", "error"/>
    <label for="user">User</label>
<@spring.formCheckbox path="user.role" attributes="value='user' id='user'" />
<@spring.showErrors "", "error"/>
    <label for="admin">Admin</label>
<@spring.formCheckbox path="user.role" attributes="value='admin' id='admin'" />
<@spring.showErrors "", "error"/>
    <label for="sex">Sex</label>
<#--assign sex={"male":"male", "female":"female"}/-->
<#--@spring.formRadioButtons path="user.sex" options= sex separator="" attributes="id=''sex" /-->
<@spring.formSingleSelect path="user.sex" options=sex attributes="id='sex'"/>
<@spring.showErrors "", "error"/>
    <input type="submit" value="Submit">
</form>
</body>
</html>