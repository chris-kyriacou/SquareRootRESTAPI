package au.kyriacou.chris.com.medium;

import org.springframework.http.*;
import java.util.*;
import java.util.stream.*;
import org.springframework.web.bind.annotation.*;


@RestController
public class SqrtController {

    @RequestMapping("/")
    public String index() {
        return "Chris Kyriacou, 2019.";
    }

    @PostMapping(value = "/sqrtcontent", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SqrtContent> get(@RequestBody SqrtContent data)
    {
        ArrayList<Integer> maxVals = new ArrayList<Integer>();
        int i = 3;
        int[] tArray = data.getData();
        IntStream.of(data.getData())
                //Sort the stream in natural order
                .sorted()
                //skip to the last i values in the stream
                .skip(tArray.length-i)
                //box the stream back into individual integer values
                .boxed()
                //for each integer, perform our final calcs
                .forEach(maxVal ->
                {
                    int t = maxVal * maxVal;
                    maxVals.add(t);

                });
    double finalVal = 0;
    //sum the integers in our ArrayList and get the square root of our final value
    for (int j = 0; j <maxVals.size(); j++)
        finalVal += maxVals.get(j);
    finalVal = Math.sqrt(finalVal);

    System.out.println("Final Value: " + finalVal);

    String finalJSON = "{\"Output\": " + finalVal + " }";

    return new ResponseEntity(finalJSON, HttpStatus.OK);
    }

}
