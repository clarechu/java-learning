package cn.learning.hikaricp;

import cn.learning.hikaricp.thread.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HikaricpApplicationTests {

    @Autowired
    private AsyncService asyncService;

    private static final int id= 13;

    @Test
    public void readCommit() throws InterruptedException {
        asyncService.readCommit(id);
        asyncService.readCommit(id);
        Thread.sleep(100000 );
    }

    @Test
    public void readUnCommit() throws InterruptedException {
        asyncService.readUnCommit(id);
        asyncService.readUnCommit(id);
        Thread.sleep(10000);
    }


    @Test
    public void repeatable() throws InterruptedException {
        asyncService.repeatable(id);
        asyncService.repeatable(id);
        Thread.sleep(10000);
    }

    @Test
    public void serializable() throws InterruptedException {
        asyncService.serializable(id);
        asyncService.serializable(id);
        Thread.sleep(100000);
    }
}
