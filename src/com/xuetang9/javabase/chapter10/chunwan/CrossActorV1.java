package com.xuetang9.javabase.chapter10.chunwan;


public class CrossActorV1 extends Actor {

	public CrossActorV1() {
		super();
	}

	public CrossActorV1(String name) {
		super(name);
	}
	
	@Override
	public void performs() {
		System.out.println(getName() + "£ºÏàÉù½²¾¿ÍÑÐ¬¾Í³ª¡£¡£¡£¡£¡£¡£¡£");
	}
	
}
