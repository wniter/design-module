package DesignModule.AbstractFactoryPattern.CreateEntity;

import DesignModule.AbstractFactoryPattern.Shape;

public class Rectangle implements Shape {


    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}