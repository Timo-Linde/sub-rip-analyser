# sub-rip-analyser

A Clojure command line tool designed to analyse Sub Rip Subtitle files.

One goal of this project is to detect important words in some movies or movie categories.
This cli tool is easy to use with .srt files and outputs a simple .txt file.

## Potential future features:
- Remove non-important words. (filler words, non nouns, not names, etc...)
- Sum whole sentences in .srt file
- Sort words based on the screen time duration (givven in the .srt File).

## .srt File Database
https://subask.com/ is a community driven subtitle database which can be used to download subtitles
in many languages.

## Example Usage

```
java -jar .\target\sub-rip-analyser-0.1.0-SNAPSHOT-standalone.jar --input-files '.\data\Der Terminator 1984.srt' --input
-files '.\data\Terminator 2 1991.srt'  --output-file 'out.txt' sum-words --exclude-soundeffects 0
```

## Example Output

```
Wort: 'Sie', Anzahl: 219
Wort: 'Ich', Anzahl: 165
Wort: 'ist', Anzahl: 158
Wort: 'nicht', Anzahl: 134
Wort: 'ich', Anzahl: 119
Wort: 'die', Anzahl: 113
Wort: 'du', Anzahl: 110
...
Wort: 'Sarah', Anzahl: 40
...
Wort: 'John', Anzahl: 29
Wort: 'von', Anzahl: 29
Wort: 'dem', Anzahl: 28
Wort: 'so', Anzahl: 28
Wort: 'Connor', Anzahl: 27
...
Wort: 'Terminator', Anzahl: 17
...
Wort: 'Zukunft', Anzahl: 15
...
Wort: 'Kyle', Anzahl: 15
...
Wort: 'Gott', Anzahl: 12
Wort: 'Mutter', Anzahl: 12
...
Wort: 'Reese', Anzahl: 11
...
Wort: 'Maschine', Anzahl: 10
...
Wort: 'Skynet', Anzahl: 8
```
## License

Copyright © 2023 Timo Linde

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.