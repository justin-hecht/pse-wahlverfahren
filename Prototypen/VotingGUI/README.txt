Dieser kleiner Prototyp soll zeigen, dass das aufklappen von Textfeldern m�glich ist.
Er ist noch in einer sehr groben Form, und ich verwende im moment keinen Layout-Manager, da die im moment 
ehr gegen mich gearbeitet haben. Aus diesem Grund musste ich die Scrollbar, welche durch die Assertions scrollen kann
selber implementieren, was es gerade etwas verz�gert hat.
Auch habe ich noch keine automatische Anpassung an die Gr��e des Fensters implementiert, was aber auch machbar sein sollte.

Jeder Abschnitt (also die Abschnitte zwischen den Strichen mit einem Knopf) sind normale JPanels, sodass sie komplett ver�ndert
werden k�nnen, also gibt es hier beim Design fast keine Grenzen. 

Starten:

Projekt importieren. 
Die main Methode befindet sich in der Klasse "MainGUI.java", also einfach diese Klasse ausf�hren, und alles startet von alleine.

Die Anzahl an Beispiel assertionfeldern, die eingef�gt werden kann ver�ndert werden, daf�r in der Klasse 
"AssertionContainer.java" einfach nach der Variable "testAdd" suchen und auf die gew�nschte Zahl stellen.
ACHTUNG: da ich danach ein paar Felder einf�rbe (das ist auch bis jetzt noch sehr grob gel�st, ich finde das Design auf github
sehr cool, bin aber leider nicht dazu gekommen das nachzubauen) muss man hier vielleicht die Zeilen, die auf "success()" oder "fail" enden 
auskommentieren.

