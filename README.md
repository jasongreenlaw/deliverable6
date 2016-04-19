# deliverable6

# Java Fuzzer
A Java-based fuzz testing application

## Background
The fuzzer is based on a lecture on fuzzing by security researcher Charlie Miller.

Internet lectures:
```
https://www.youtube.com/watch?v=Xnwodi2CBws
https://www.youtube.com/watch?v=lK5fgCvS2N4
```
Here are a couple lines of code that can be found in the lectures
```
numwrites = random.randrange(math.ceil((float(len(buf)) / FuzzFactor))) + 1
for j in range(numwrites):
  rbyte = random.randrange(256)
  rn = random.randrange(len(buf))
  buf[rn] = "%c"%(rbyte)
```

## How to use
Simply, run the FuzzerDriver.java program to test the files provided or use the Fuzzer.java program with the following command: java Fuzzer [file location] [fuzz factor] [iterations]
