import base.boot.RabbitmqDemoBoot;
import base.demo.TopicProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitmqDemoBoot.class)
public class RabbitmqTest {

    @Autowired
    private TopicProvider topicProvider;
    
    @Test
    public void testTopic() throws InterruptedException {
        while (true){
            topicProvider.send();
            Thread.sleep(1000);
        }
    }
}
