/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.project;

import java.util.List;

/**
 *
 * @author jivan
 */
public class DepthLimitedSearch {

	public State exec(State initialState) {
		int limit = 20;
		return recursiveDLS(initialState, limit);
	}

	private State recursiveDLS(State state, int limit) {
		if (state.isGoal()) {
                     System.out.print(state.toString());
			return state;
		} else if (limit == 0) {
			return null;
		} else {
			List<State> successors = state.child();
			for (State child : successors) {
				State result = recursiveDLS(child, limit - 1);
				if (null != result) {
					return result;
				}
			}
			return null;
		}
	}
}
