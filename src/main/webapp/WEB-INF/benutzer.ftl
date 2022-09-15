<html>
<body>
<#assign completedJobs = belist.completedJobs>
<#list 0 ..< completedJobs.length() as i>
  ${completedJobs.get(i).completedTime}
</#list>
</body>
</html>