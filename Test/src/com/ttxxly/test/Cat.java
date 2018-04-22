package com.ttxxly.test;

abstract class Animal {
	abstract void say();
}

public class Cat extends Animal {
	public Cat() {
		System.out.println("I am a cat.");
	}

	public static void main(String[] args) {
		Cat cat = new Cat();
		String string = "Hello World !!";
		string = string + 100;
		System.out.println(string);
	}

	@Override
	void say() {
		// TODO Auto-generated method stub

	}
}