package com.stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String text) {
        if(isBlack(text)){ // 같은 or 조건 앞에서도 먼저 쓴 조건부터 필터링 된다.
            return 0;
        }
        
        int result = addNum(toInt(split(text)));
        return result;
    }
    
    private int addNum(int[] numArr) {
        int sum = 0;
        for(int tempNum : numArr) {
            sum += tempNum;
        }
        return sum;
    }
    
    private int[] toInt(String[] strArr) {
        int[] numArr = new int[strArr.length];
        
        for(int i = 0; i < numArr.length; i++) {
            numArr[i] = toPositive(strArr[i]);
        }
        
        return numArr;
    }
    
    private int toPositive(String str) {
        int number = Integer.parseInt(str);
        if(number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
    
    private boolean isBlack(String text) {
        return text == null || text.isEmpty();
    }
    
    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        // 1. compile : 새로운 패턴을 만듦
        // 2. matcher : 앞선 정규식의 패턴과 매개변수 text의 Matcher 를 만든다.
        // 3. "//(.)\n(.*)" 정규식 분석
        // 3-1. . 은 1개의 문자를 의미
        // 3-2. 그룹을 지정해주기 위해서는 ()를 통해 그룹을 설정해주면 되고, () 갯수만큼 그룹이 만들어진다.
        // 3-3. .* 은 문자 1개 이상이 나옴을 의미
        if(m.find()) {// 패턴이 일치하는 경우 true를 반환하고, 그 위치로 이동
            String customDelimeter = "\\"+m.group(1); // ^같은 문자로 split를 바로 처리할 수 없기에 Escape처리.
            System.out.println("group 1 : " + m.group(1));
            System.out.println("group 2 : " + m.group(2));
            System.out.println("return : " + m.group(2).split(customDelimeter)[0]);
            System.out.println("return : " + m.group(2).split(customDelimeter)[1]);
            System.out.println("return : " + m.group(2).split(customDelimeter)[2]);
            return m.group(2).split(customDelimeter);
        }
        return text.split(",|:");
    }
}// Class End
