package com.lambda.model;

public class Trainer implements Comparable<Trainer>{

	private String name;
	private int id;
	private int age;
	
	public Trainer(int id, int age,String name) {
		this.age = age;
		this.id=id;
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Trainer trainer) {
		return this.name.compareTo(trainer.getName());
	}
	@Override
	public boolean equals(final Object obj) {
		if(obj == null) {
			return false;
		}
		Trainer trainer = (Trainer)obj;
		if(this == trainer) {
			return true;
		} else {
			return (this.name == trainer.getName() && this.age == trainer.getAge());
		}
	}
	@Override
	public int hashCode() {
		int hashNo = 7;
		hashNo = 13 * hashNo + (this.name == null ? 0 : this.name.hashCode());
		return hashNo;
	}
}
