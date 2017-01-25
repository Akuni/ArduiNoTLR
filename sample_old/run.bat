cp Database.java ..
rm *.java
rm *.class
rm *.tokens
rm ../out/ -rfd
cp ../Database.java .

./antlr.bat Hello.g4
