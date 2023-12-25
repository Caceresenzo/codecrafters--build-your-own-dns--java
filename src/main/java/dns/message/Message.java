package dns.message;

public record Message(
	Header header,
	Question question
) {
	
	public byte[] encode() {
		final var header = this.header.encode();
		final var question = this.question.encode();
		
		final var bytes = new byte[header.length + question.length];
		System.arraycopy(header, 0, bytes, 0, header.length);
		System.arraycopy(question, 0, bytes, header.length, question.length);
		
		return bytes;
	}
	
}