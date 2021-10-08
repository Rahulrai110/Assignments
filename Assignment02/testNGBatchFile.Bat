set projectLocation=C:\Users\hi\eclipse-workspace\Assignment02
cd %projectLocation%
set classpath=%projectLocation%\target\test-classes;%projectLocation%\libs\*
java org.testng.TestNG %projectLocation%\testng.xml
pause