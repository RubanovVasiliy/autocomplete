# Autocomplete 
## Description
A Java console application (JDK 11) that allows you to quickly search for airport data by the airport name and filters entered by the user.

The data for the program is taken from a file [airports.csv](https://disk.yandex.ru/i/g1riHSgEntfLYQ). It contains a table of airports with properties in CSV format. The name of the airport is column 2.


Filters can be — equality relations: equal to `( = )`, not equal to `( <> )`, greater than `( > )`, less than `( < )`.

The filter is transmitted in the format:
```
column[<column number starts with 1>] <comparison operation> <value>
```

Filters can be connected by the relation `AND ( & )` and `OR ( || )`. Parentheses may also be involved to indicate priority and grouping. The relation AND has a higher priority of the week OR. The filter may not be specified.
## Running
```
$ mvn clean package
$ java -jar app/airports-search-jar-with-dependencies.jar -Xmx7m
```

