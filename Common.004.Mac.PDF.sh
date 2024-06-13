#!/bin/sh

cd ./bin


rm -R ./org/hy/common/pdf/junit


jar cvfm hy.common.pdf.jar MANIFEST.MF META-INF org

cp hy.common.pdf.jar ..
rm hy.common.pdf.jar
cd ..





cd ./src
jar cvfm hy.common.pdf-sources.jar MANIFEST.MF META-INF org 
cp hy.common.pdf-sources.jar ..
rm hy.common.pdf-sources.jar
cd ..
