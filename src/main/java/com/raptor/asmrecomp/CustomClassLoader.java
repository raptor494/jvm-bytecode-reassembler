package com.raptor.asmrecomp;

class CustomClassLoader extends ClassLoader {
	
	public Class<?> defineClass(String name, byte[] bytes) {
		return defineClass(name, bytes, 0, bytes.length);
	}
	
}