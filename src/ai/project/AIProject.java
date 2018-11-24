/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.project;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jivan
 */
public class AIProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        State initial_state= new State(3,3,0,0,Position.LEFT);
        executeDLS(initial_state);
        
    }
    
	private static void executeDLS(State initialState) {
		DepthLimitedSearch search = new DepthLimitedSearch();
		State solution = search.exec(initialState);
		printsolution(solution);
	}
    public static void printsolution(State solution){
       if(null==solution){           
           System.out.println("\n No solution");
       } else{
           System.out.println("\n Solution (Cleft,Mleft,Cright,Mright,Boat");
           List<State> path=new ArrayList<State>();
           State state=solution;
           while(null!=state){
               path.add(state);
               state=state.getParent();
           }
           int depth=path.size()-1;
           for(int i=depth;i>=0;i--){
               state=path.get(i);
               if(state.isGoal()){
                   System.out.print(state.toString());
               }
               else{
                   System.out.print(state.toString()+"--->");
           }
           }
       }
       System.out.println();
    }
  }
