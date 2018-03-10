package converter;

/**
 * Length units.
 * @author kwankaew
 *
 */
public enum Length {
	Meter(1.0),
	centimeter(0.01),
	Kilometer(1000.0),
	Mile(1609.344),
	Foot(0.30480),
	Wa(2.0),
	AU(149597870700.0);
	
	private final double value;
	
	/**
	 * Initialize the length.
	 * @param value is value of that length.
	 */
	private Length(double value) {
		this.value = value;
	}
	
	/**
	 * Get the value of that length unit.
	 * @return the value of the length.
	 */
	public double getValue() {
		return this.value;
	}

}
