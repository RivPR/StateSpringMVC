package data;

public interface StateDAO {
	public State getStateByName(String name);
	public State getStateByAbbreviation(String abbreviation);
	public State getStateByOrder(int current);
	public void addState(State state);
}
