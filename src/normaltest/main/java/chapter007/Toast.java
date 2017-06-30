package normaltest.main.java.chapter007;

public class Toast {
	
	private Status status = Status.DRY;
	
	private final int id;
	
	public Toast(int id) {
		this.id = id;
	}
	
	public void butter() {
		this.status = Status.BUTTERED;
	}
	
	public void jam() {
		this.status = Status.JAMMED;
	}
	
	public int getId() {
		return id;
	}
	
	public Status status() {
		return status;
	}
	
	@Override
	public String toString() {
		return "toast: id = " + id + ", status = " + status;
	}
}
