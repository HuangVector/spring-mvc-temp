package cn.vector.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-4-25 8:14
 */
public class ReflectTest {
    private Logger log = LoggerFactory.getLogger(this.getClass().getName());
    @Test
    public void testGetMethod(){
        //log.debug("Process file: {}", file.getOriginalFilename());
        //log.debug(ReflectionToStringBuilder.toString(course));
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        String fileName = Thread.currentThread().getStackTrace()[1].getFileName();
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.debug("className:{},fileName:{},methodName:{}",className,fileName,methodName);
    }
}
