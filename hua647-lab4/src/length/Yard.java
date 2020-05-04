package length;

public class Yard extends Length {

	// 1 yard = 0.9144 meters

	public static final double METERS_PER_YARD = 0.9144;

	public Yard(double length) {
		super(length);

	}

	public void add(Length other) {

		double currLength = this.getLength();

		currLength += (other.toMeters() / Yard.METERS_PER_YARD);

		this.setLength(currLength);
	}

	public String getUnit() {
		if (this.getLength() == 1.0)
			return "yard";
		else
			return "yards";
	}

	public double toMeters() {
		return this.getLength() * Yard.METERS_PER_YARD;
	}

}
