package ex11.streams;

public class Token {
	private String content;
	private String posTag;
	private String namedEntityType;
	private double logProbability;
	
	/**
	 * Creates a Token instance.
	 * 
	 * @param content The string of the token, e.g. <code>"people"</code>
	 * @param posTag A string representation of the token's part-of-speech
	 *        tag, e.g. <code>"NOUN"</code>
	 * @param namedEntityType A string representation of the token's named
	 *        entity tag, e.g. <code>"PERSON"</code> for the token
	 *        <code>Obama</code>. Should be <code>"NONE"</code> when the 
	 *        token is not a named entity.      
	 * @param logProbability A double value, the log of the probability of 
	 *        the token according to a language model, e.g. -3.214 (a value 
	 *        between minus infinity and 0).
	 */
	public Token(String content, String posTag, String namedEntityType, double logProbability) {
		this.content = content;
		this.posTag = posTag;
		this.namedEntityType = namedEntityType;
		this.logProbability = logProbability;
	}

	public String getContent() {
		return content;
	}

	public String getPosTag() {
		return posTag;
	}

	public String getNamedEntityType() {
		return namedEntityType;
	}

	public double getLogProbability() {
		return logProbability;
	}
	
	@Override
	public String toString() {
		String toReturn = content + ", POS: " + posTag + ", NE-Type: " + namedEntityType + ", log probability: " + logProbability;
		
		return toReturn;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		long temp;
		temp = Double.doubleToLongBits(logProbability);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((namedEntityType == null) ? 0 : namedEntityType.hashCode());
		result = prime * result + ((posTag == null) ? 0 : posTag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (Double.doubleToLongBits(logProbability) != Double.doubleToLongBits(other.logProbability))
			return false;
		if (namedEntityType == null) {
			if (other.namedEntityType != null)
				return false;
		} else if (!namedEntityType.equals(other.namedEntityType))
			return false;
		if (posTag == null) {
			if (other.posTag != null)
				return false;
		} else if (!posTag.equals(other.posTag))
			return false;
		return true;
	}
	
}
