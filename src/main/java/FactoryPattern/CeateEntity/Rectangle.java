package FactoryPattern.CeateEntity;

import FactoryPattern.Shape;

public class Rectangle implements Shape {

//    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}