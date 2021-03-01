You are inside question view of REST API: Number of Drawn Matches

1. REST API: Number of Drawn Matches
In this challenge, the REST API contains information about football matches. The provided API allows querying matches by teams and year. The task is to get the number of matches for a given year that ended in a draw. A match is drawn when both teams scored the same number of goals.

 

To access a collection of matches played in a given year, perform an HTTP GET request to

https://jsonmock.hackerrank.com/api/football_matches?year=<year>&page=<page>

where <year> is the year of the competition and <page> is the page of the results to request. The results might be divided into several pages. Pages are numbered from 1.

 

For example, a GET request to

https://jsonmock.hackerrank.com/api/football_matches?year=2011&page=2

returns data associated with matches in the year 2011 on the second page of the results.

 

The response to such a request is a JSON with the following 5 fields:

page: The current page of the results.

per_page: The maximum number of matches returned per page.

total: The total number of matches on all pages of the results.

total_pages: The total number of pages with results.

data: An array of objects containing matches information on the requested page.

 

Each match record has several fields:

competition: a string denoting the name of the competition

year: an integer denoting the year when the match took place

round: a string denoting the round the match belongs to (can be an empty string)

team1: a string denoting the name of the first team in the match

team2: a string denoting the name of the second team in the match

team1goals: a string denoting the number of goals scored by team1 in the match

team2goals: a string denoting the number of goals scored by team2 in the match

 

Notice that the number of pages might be in hundreds, and it would take too much time to fetch the results from all of them and examine the scores of every match. In order to overcome this issue, you are allowed to add an exact value of any of the match object fields to the URL query string in order to limit the number of results. This capability, if used correctly, can help you avoid examining individual match objects.

 

For example, performing a request to

https://jsonmock.hackerrank.com/api/football_matches?year=2011&team1goals=1&page=2

returns data associated with matches in the year 2011, where the first team scored 1 goal, on the second page of the results.

 

Function Description

Complete the function getNumDraws in the editor below.

 

getNumDraws has the following parameter:

    int year: the year of the competition

 

The function must return an integer denoting the number of matches in the given year that ended up in a draw.

 

Constraints:

You can safely assume that no team ever scored more than 10 goals.

 

Input Format For Custom Testing
Sample Case 0
Sample Input For Custom Testing

2011
Sample Output

516
Explanation

The year is 2011. There were 516 games in the year 2011 that ended in a draw, so that is the returned answer.

REGEX LINK:
https://regex101.com/r/74hOO1/34
```
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.net.URL;


class Result {

    /*
     * Complete the 'getNumDraws' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER year as parameter.
     */

    public static int getNumDraws(int year) throws IOException{
        int numDraws = 0;
        final String regex = "\"total\":([^,]+)?";
        final Pattern pattern = Pattern.compile(regex);
        for(int goals = 0; goals <= 10; goals++){
            String urlStr = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&team1goals=" + goals + "&team2goals=" + goals;    
            URL url = new URL(urlStr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String json = bufferedReader.readLine();
            Matcher matcher = pattern.matcher(json);
            if(matcher.find()){
                numDraws += Integer.parseInt(matcher.group(1));
            } 
        }
        return numDraws;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.getNumDraws(year);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


```