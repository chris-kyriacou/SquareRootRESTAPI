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

    @PostMapping("/sqrtcontent")
    public ResponseEntity<SqrtContent> get(@RequestBody SqrtContent data)
    {
        ArrayList<Integer> maxVals = new ArrayList<Integer>();
        int i = 3;
        int[] tArray = data.getData();
        IntStream.of(data.getData())
                .sorted()
                .skip(tArray.length-i)
                .boxed()
                .forEach(big ->
                {
                    int t = big * big;
                    maxVals.add(t);

                });
    double finalVal = 0;
    for (int j = 0; j <maxVals.size(); j++)
        finalVal += maxVals.get(j);
    finalVal = Math.sqrt(finalVal);

    System.out.println(finalVal);

    return new ResponseEntity(finalVal, HttpStatus.OK);
    }

}
