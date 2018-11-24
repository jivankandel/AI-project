/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;





/**
 *
 * @author jivan
 */
public final class State {
    int Cleft;
    int Mleft;
    int Cright;
    int Mright;
    private final Position boat;
    State root=null;
    State(int cleft,int mleft,int cright,int mright,Position cbank){
        this.boat=cbank;
        this.Cleft=cleft;
        this.Mleft=mleft;
        this.Cright=cright;
        this.Mright=mright;
    }
    @Override
   public String toString(){
       if (boat == Position.LEFT) {
			return "(" + Cleft + "," + Mleft + ",L,"
        			+ Cright + "," + Mright + ")";
		} else {
			return "(" + Cleft + "," + Mleft + ",R,"
        			+ Cright + "," + Mright + ")";
		}
   }
   public List<State> child(){
    List<State> children=new ArrayList<>();
    if (boat == Position.LEFT) {
			carry(children, new State(Cleft, Mleft - 2,
					Cright, Mright + 2, Position.RIGHT));
                        System.out.print("");
			carry(children, new State(Cleft - 2, Mleft,
					Cright + 2, Mright, Position.RIGHT)); 
                        System.out.print("");
			carry(children, new State(Cleft - 1, Mleft - 1,
					Cright + 1, Mright + 1, Position.RIGHT)); 
                        System.out.print("");
			carry(children, new State(Cleft, Mleft - 1,
					Cright, Mright + 1, Position.RIGHT)); 
                        System.out.print("");
			carry(children, new State(Cleft - 1, Mleft,
					Cright + 1, Mright, Position.RIGHT));
                                            System.out.print("");
                } else {
			carry(children, new State(Cleft, Mleft + 2,
					Cright, Mright - 2, Position.LEFT)); System.out.print("");
			carry(children, new State(Cleft + 2, Mleft,
					Cright - 2, Mright, Position.LEFT)); System.out.print("");
			carry(children, new State(Cleft + 1, Cleft + 1,
					Cright - 1, Mright - 1, Position.LEFT));System.out.print("");
			carry(children, new State(Cleft, Mleft + 1,
					Cright, Mright - 1, Position.LEFT)); System.out.print("");
			carry(children, new State(Cleft + 1, Mleft,
					Cright - 1, Mright, Position.LEFT)); System.out.print("");
		}
    return children;
}
  public void carry (List<State> children,State s){
    if(s.isPossible()){
        s.root=this;
        children.add(s);
        
    }
         
}
public  boolean isGoal(){
    return Cleft==0&&Mleft==0;
}  
public State getParent() {
		return root;
	}
public  boolean isPossible(){
 if (Mleft >= 0 && Mright >= 0 && Cleft >= 0 && Cright >= 0
	               && (Cleft == 0 || Mleft >= Cleft)
	               && (Mright == 0 || Mright >= Cright)) {
			return true;
		}
		return false;
}
@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof State)) {
			return false;
		}
		State s = (State) obj;
        return (s.Cleft == Cleft && s.Mleft == Mleft
        		&& s.boat == boat && s.Cright == Cright
        		&& s.Mright == Mright);
	}
}


