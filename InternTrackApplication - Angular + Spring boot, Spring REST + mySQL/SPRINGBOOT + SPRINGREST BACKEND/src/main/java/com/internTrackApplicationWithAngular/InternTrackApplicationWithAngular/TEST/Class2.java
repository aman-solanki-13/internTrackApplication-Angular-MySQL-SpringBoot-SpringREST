package com.internTrackApplicationWithAngular.InternTrackApplicationWithAngular.TEST;

public class Class2 extends Class1{

    Class2(int num1 ,int num2){
        super(num1, num2);
    }

    @Override
    int sum() {
        return super.num1 + super.num2;
    }

    @Override
    int multiply() {
        return super.num1 * super.num2;
    }
}
