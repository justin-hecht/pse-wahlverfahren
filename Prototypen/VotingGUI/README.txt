Dieser kleiner Prototyp soll zeigen, dass das aufklappen von Textfeldern möglich ist.
Er ist noch in einer sehr groben Form, und ich verwende im moment keinen Layout-Manager, da die im moment 
ehr gegen mich gearbeitet haben. Aus diesem Grund musste ich die Scrollbar, welche durch die Assertions scrollen kann
selber implementieren, was es gerade etwas verzögert hat.
Auch habe ich noch keine automatische Anpassung an die Größe des Fensters implementiert, was aber auch machbar sein sollte.

Jeder Abschnitt (also die Abschnitte zwischen den Strichen mit einem Knopf) sind normale JPanels, sodass sie komplett verändert
werden können, also gibt es hier beim Design fast keine Grenzen. 

Starten:

Projekt importieren. 
Die main Methode befindet sich in der Klasse "MainGUI.java", also einfach diese Klasse ausführen, und alles startet von alleine.

Die Anzahl an Beispiel assertionfeldern, die eingefügt werden kann verändert werden, dafür in der Klasse 
"AssertionContainer.java" einfach nach der Variable "testAdd" suchen und auf die gewünschte Zahl stellen.
ACHTUNG: da ich danach ein paar Felder einfärbe (das ist auch bis jetzt noch sehr grob gelöst, ich finde das Design auf github
sehr cool, bin aber leider nicht dazu gekommen das nachzubauen) muss man hier vielleicht die Zeilen, die auf "success()" oder "fail" enden 
auskommentieren.

