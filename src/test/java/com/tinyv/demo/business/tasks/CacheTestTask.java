package com.tinyv.demo.business.tasks;

import com.tinyv.demo.business.service.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.concurrent.Callable;

/**
 * Created by YMa69 on 2019/11/21.
 */
public class CacheTestTask implements Callable<String> {

    private static Logger logger = LoggerFactory.getLogger(CacheTestTask.class);

    private CacheService cacheService;

    private String param1;

    private String step;

    public CacheTestTask(CacheService cacheService, String param1, String step){
        this.cacheService = cacheService;
        this.param1 = param1;
        this.step = step;
    }

    @Override
    public String call() throws Exception {
        String threadName = Thread.currentThread().getName();
        for(int i=0; i<1000; i++){
            if(step.equals("Cacheable")){
                String result = cacheService.cacheableDemo(param1);
                logger.info("[Cacheable]-["+threadName+"]: result:"+result);
                Thread.sleep(500);
            }else if(step.equals("CachePut")){
                String result = cacheService.cachePutDemo(param1);
                logger.info("[CachePut]-["+threadName+"]: result:"+result);
            }else if(step.equals("CacheEvict")){
                String result = cacheService.cacheEvictDemo(param1);
                logger.info("[CacheEvict]-["+threadName+"]: result:"+result);
            }
            Thread.sleep(100);
        }
        return "";
    }

}
