REM @ECHO OFF
:compile:
	cls
	javac -d "./classes/" "./csdir/ui/*.java" -Xlint:unchecked
	javac -d "./classes/" "./csdir/EntryPoint.java" -Xlint:unchecked
	pause
	goto run
	
:run:
	cd "classes"
	cls
	java "csdir/EntryPoint"
	
pause
cd "../"
goto compile