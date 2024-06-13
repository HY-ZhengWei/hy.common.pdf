

del /Q hy.common.pdf.jar
del /Q hy.common.pdf-sources.jar


call mvn clean package
cd .\target\classes


rd /s/q .\org\hy\common\pdf\junit


jar cvfm hy.common.pdf.jar META-INF/MANIFEST.MF META-INF org

copy hy.common.pdf.jar ..\..
del /q hy.common.pdf.jar
cd ..\..





cd .\src\main\java
xcopy /S ..\resources\* .
jar cvfm hy.common.pdf-sources.jar META-INF\MANIFEST.MF META-INF org 
copy hy.common.pdf-sources.jar ..\..\..
del /Q hy.common.pdf-sources.jar
rd /s/q META-INF
cd ..\..\..

pause
