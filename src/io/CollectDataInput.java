package io;

public class CollectDataInput implements CollectDataInputRole {

	private InputRole input;
	
	public CollectDataInput(InputRole otherInput) {
		this.input = otherInput;
	}

	@Override
	public void collectData() {
		input.readFieldDimensions();
		input.readPrizesPositions();
		input.readPlayersPositions();
	}

}
