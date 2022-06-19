package com.interceptor;

import java.io.Serializable;
import java.util.Arrays;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;


public class CustomInterceptor extends EmptyInterceptor{

	
	
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("----------------------------");
		System.out.println("onSave method Executed.");
		int index =Arrays.asList(propertyNames).indexOf("createdBy");
		System.out.println(index);
		state[index] = "ABCD";					//here state index value = propertyNames index property  
		//state[0] = "arin";
		System.out.println("--------------------------------");
		return true;
	}
	
	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		System.out.println("-----------------------------");
		System.out.println("onLoad method executed.");
		System.out.println("--------------------------------");
		return super.onLoad(entity, id, state, propertyNames, types);
	}
	
	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		System.out.println("----------------------------");
		System.out.println("onFlushDirty method execute.");
		int index = Arrays.asList(propertyNames).indexOf("updatedBy");
		currentState[index] = "RST";
		System.out.println("--------------------------------");
		return true;
	}

}
