package length;

public class Inch extends Length {

	/**
	 * 1 inch = 0.0254 meters
	 */
	public static final double METERS_PER_INCH = 0.0254;

	public Inch(double length) {
		super(length);

	}

	public void add(Length other) {

		double currLength = this.getLength();

		currLength += (other.toMeters() / Inch.METERS_PER_INCH);

		this.setLength(currLength);
	}

	public String getUnit() {

		if (this.getLength() == 1.0)
			return "inch";
		else
			return "inches";
	}

	public double toMeters() {
		return this.getLength() * Inch.METERS_PER_INCH;
	}

}
