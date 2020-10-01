package com.stringCalculator.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.stringCalculator.StringCalculator;

public class StringCalculatorTest {
    /*
        아래 이외의 어노테이션
        1. @BeforeClass, @AfterClass
        2. @RunWith : Junit에 내장된 기본 테스트 러너인 BlockJUnit4ClassRunner 대신에 
           @RunWith로 지정된 클래스를 이용해 클래스 내의 테스트 메소드들을 수행하도록 지정해주는 애노테이션.(일종의 JUnit 프레임워크의 확장지점.)
                   즉 다른 테스트 러너를 이용함으로써, 추가적인 테스트 기능을 사용할 수 있다.
        3.  

     */
    private StringCalculator strCal;
    
    @Before
    public void setup() {
        strCal = new StringCalculator();
    }
    
    @Ignore("테스트 안 할 메소드")
    @Test
    public void add_null() {
        assertEquals(0, strCal.add(""));
        assertEquals(0, strCal.add(null));
    }
    
    @Ignore
    @Test
    public void add_oneNum() throws Exception {
        assertEquals(4, strCal.add("4"));
    }
    
    @Ignore
    @Test
    public void add_쉼표구분자() {
        assertEquals(5, strCal.add("2,3"));
    }
    
    @Ignore
    @Test
    public void add_세미콜론구분자() {
        assertEquals(20, strCal.add("4;6,10"));
    }
    
    @Ignore
    @Test
    public void split() {   // 즉 문자 1개 입력받았을 때 spilt 해도 값은 같다.
        assertArrayEquals(new String[] {"1"}, "1".split(","));
    }
    
    @Ignore
    @Test(timeout=1000)
    public void add_커스텀구분자() {
        assertEquals(21, strCal.add("//!\n4!6!10"));
        assertEquals(20, strCal.add("//^\n4^6^10"));
    }
    
    
    @Test(expected = RuntimeException.class) // runtimeException이 나타나면 테스트 성공
    public void negativeRuntime() {
        strCal.add("-1,2,3");
    }

}
