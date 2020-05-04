package length;

public class Foot extends Length {

	// 1 foot = 0.3048
	public static final double METERS_PER_FOOT = 0.3048;

	public Foot(double length) {
		super(length);

	}

	public void add(Length other) {

		double currLength = this.getLength();

		currLength += (other.toMeters() / Foot.METERS_PER_FOOT);

		this.setLength(currLength);
	}

	public String getUnit() {

		if (this.getLength() == 1.0)
			return "foot";
		else
			return "feet";
	}

	public double toMeters() {
		return this.getLength() * Foot.METERS_PER_FOOT;
	}
}
