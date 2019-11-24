import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;

import au.kyriacou.chris.com.medium.SqrtController;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class TestRunnerController{

    private MockMvc testMvc;

    @InjectMocks
    private SqrtController sqrtController;

    @Before
    public void setUp() throws Exception {
        testMvc = MockMvcBuilders.standaloneSetup(sqrtController)
                .build();
    }
    /*
    very basic testing to ensure that the module returns a successful HTTP request and the controller produces the expected result.
    I would definitely expand testing here to include strict integration testing methods and more complex testing around the request body (data types,
    incorrect input...)
     */
    @Test
    public void testSqrt() throws Exception {
        String testArray = "{\"data\":[5,4,6,1]}";

        testMvc.perform(MockMvcRequestBuilders.post("/sqrtcontent").contentType(MediaType.APPLICATION_JSON_VALUE).content(testArray))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"Output\": 8.774964387392123\n" +
                        "}"));

    }
}
