Daniel Maloney - G00303381

GitHub: https://github.com/G00303381/Word-Cloud-Api.git


INSTRUCTIONS:
In order to run you must enter eithe a file or a url in the command prompt followed by either true or false:
Enering "true" implies the user wished to parse in a text file of words.
Entering "false" implies the user is entering a url to be parsed.

File:
java –cp ./WordCloud.jar sw.gmit.ie.Runner "/.test.txt" "stopWords.txt" "true"

URL:
java-cp /. WordCloud.jar sw.gmit.ie.Runner "http:www.gmit.ie/" "stopWords.txt" "false"

Other Notes:
The sorting algortihm in the SortMap class can be slow dependant on the amount of words being parsed.
The UML was created using an outside plugin for Eclipse called ObjectAid
The docs folder contains the JavaDocs created for the project.