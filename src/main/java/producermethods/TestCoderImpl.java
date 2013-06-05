package producermethods;


public class TestCoderImpl implements Coder {
	private static final CoderType CODER_TYPE = CoderType.TEST;

	@Override
	public String codeString(String s, int tval) {
		return ("input string is " + s + ", shift value is " + tval);
	}

	@Override
	public CoderType getCoderType() {
		return CODER_TYPE;
	}

}
