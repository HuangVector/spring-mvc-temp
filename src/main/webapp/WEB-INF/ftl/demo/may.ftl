User:<br/>
${user.name}--->${user.age}<br/>
List:<br/>
<#list list as item >
<span style="color: red; ">${item}</br></span>
</#list>
param:</br>
${RequestParameters.a}&nbsp;a=${param!}