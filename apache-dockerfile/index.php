<!DOCTYPE html>
<html>
<body align="center">
<h1>Apache, PHP - Docker</h1>
server time: <?php echo date("c")?> <br/>
server load: <?php 
$load = sys_getloadavg();
echo $load[0]
?>
</body>
</html>