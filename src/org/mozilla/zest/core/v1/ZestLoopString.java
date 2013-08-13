/**
/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 * 
 * @author Alessandro Secco: seccoale@gmail.com
 */
package org.mozilla.zest.core.v1;

import java.util.LinkedList;
import java.util.List;
// TODO: Auto-generated Javadoc

/**
 * this class represents a Loop through String values.
 */
public class ZestLoopString extends ZestLoop<String> {
	private static int counter=0;
	/**
	 * Instantiates a new zest loop string.
	 */
	public ZestLoopString(){
		super("LoopString"+counter++, new ZestLoopTokenStringSet(), new LinkedList<ZestStatement>());
	}
	public ZestLoopString(String name, String[] values){
		super(name, new ZestLoopTokenStringSet(values), new LinkedList<ZestStatement>());
	}
	
	public ZestLoopString(List<ZestStatement> stmts){
		super("LoopString"+counter++, new ZestLoopTokenStringSet(), stmts);
	}
	public ZestLoopString(String name,String[] values, List<ZestStatement> stmts){
		super(name, new ZestLoopTokenStringSet(values), stmts);
	}
	
	/**
	 * Instantiates a new zest loop string.
	 *
	 * @param values the values
	 */
	public ZestLoopString(String[] values){
		super("LoopString"+counter++,new ZestLoopTokenStringSet(values), new LinkedList<ZestStatement>());
	}
	
	/**
	 * Instantiates a new zest loop string.
	 *
	 * @param values the values
	 * @param statements the statements
	 */
	public ZestLoopString(String[] values, List<ZestStatement> statements){
		super("LoopString"+counter++,new ZestLoopTokenStringSet(values), statements);
	}
	
	/**
	 * Instantiates a new zest loop string.
	 *
	 * @param index the index
	 */
	public ZestLoopString(int index){
		super(index,"LoopString"+counter++, new ZestLoopTokenStringSet(), new LinkedList<ZestStatement>());
	}
	
	/**
	 * Instantiates a new zest loop string.
	 *
	 * @param index the index
	 * @param values the values
	 * @param statements the statements
	 */
	public ZestLoopString(int index, String[] values, List<ZestStatement> statements){
		super(index,"LoopString"+counter++, new ZestLoopTokenStringSet(values), statements);
	}
	
	/**
	 * Instantiates a new zest loop string.
	 *
	 * @param index the index
	 * @param values the values
	 */
	public ZestLoopString(int index, String[] values){
		super(index, "LoopString"+counter++, new ZestLoopTokenStringSet(), new LinkedList<ZestStatement>());
	}
	public String[] getValues(){
		ZestLoopTokenStringSet set=this.getSet();
		String[] array=new String[set.size()];
		for(int i=0; i<array.length; i++){
			array[i]=set.getToken(i);
		}
		return  array;
	}
	@Override
	public ZestLoopString deepCopy(){
		ZestLoopString copy=new ZestLoopString(this.getIndex());
		copy.setCurrentState(this.getCurrentState().deepCopy());
		copy.setStatements(this.copyStatements());
		return copy;
	}
	@Override
	public ZestLoopStateString getCurrentState(){
		return (ZestLoopStateString) super.getCurrentState();
	}
	@Override
	public ZestLoopTokenStringSet getSet() {
		return (ZestLoopTokenStringSet) super.getSet();
	}
	@Override
	public void setSet(ZestLoopTokenSet<String> set){
		if(set instanceof ZestLoopTokenStringSet){
			super.setSet(set);
		} else{
			System.err.println("The given set is not a "+getSet().getClass().getName());
			System.err.println("Trying an autofix");
			if(set instanceof ZestLoopTokenFileSet){
				ZestLoopTokenFileSet fileSet=(ZestLoopTokenFileSet) set;
				super.setSet(fileSet.getConvertedSet());
			}
			else{
				System.err.println("autofix failed! Nothing will be done!");
			}
		}
	}
}
