public interface TextToSpeechModel extends Model<TextToSpeechPrompt, TextToSpeechResponse>, 
                                           StreamingTextToSpeechModel {

	default byte[] call(String text) {
		TextToSpeechPrompt prompt = new TextToSpeechPrompt(text);
		ModelResult<byte[]> result = call(prompt).getResult();
		if (result == null) {
			return new byte[0];
		}
		byte[] output = result.getOutput();
		return (output != null) ? output : new byte[0];
	}

	@Override
	TextToSpeechResponse call(TextToSpeechPrompt prompt);

	default TextToSpeechOptions getDefaultOptions() {
		return TextToSpeechOptions.builder().build();
	}

}