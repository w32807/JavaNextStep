package com.stringCalculator.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stringCalculator.Calculator;

public class CalculatorTest {
    // Junit을 사용하면, 원하는 메소드를 호출하지 않아도 바로 실행 가능하다.
    
    private Calculator cal;
    
    @Before
    public void setup() {   // 바로 인스턴스 변수로 new 생성하지 말고, before 어노테이션을 주자 (바로 생성하기 / before의 차이는??) 
        cal = new Calculator(); // before 어노테이션을 이용하여, 테스트 메소드에 대한 초기화를 한다.
        System.out.println("Generate cal");
    }
    
    @Test
    public void add() {
        System.out.println(cal.add(6,3));
        assertEquals(9, cal.add(6,3));      //assertEquals은 기대하는 결과값이 같으면 테스트 성공
    }
    
    //@Test
    public void subtract() {
        System.out.println(cal.subtract(6,3));
    }
    
    @Test(timeout=5000) // 5000밀리초 (5초) 를 넘기면 테스트 실패
    public void multiply() {
        System.out.println(cal.multiply(4, 5));
    }
    
    @After
    public void teardown() {
        System.out.println("teardown");
    }
}
