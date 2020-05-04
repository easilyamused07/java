package length;

public class Meter extends Length {

	public Meter(double length) {
		super(length);

	}

	public void add(Length other) {

		double currLength = this.getLength();

		currLength += other.toMeters();

		this.setLength(currLength);
	}

	public String getUnit() {

		if (this.getLength() == 1.0)
			return "meter";
		else
			return "meters";
	}

	public double toMeters() {
		return this.getLength();
	}

}
