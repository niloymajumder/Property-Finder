package uap;

import java.time.LocalDate;

public class LeaseRecord {
	private String id;
	private String propertyId;
	private String userId;
	private LocalDate leaseStartDate;
	private LocalDate leaseEndDate;
	private String note;
	private int duration;

	public LeaseRecord(String propertyId, String userId, LocalDate leaseStartDate, int duration) {
		this.propertyId = propertyId;
		this.userId = userId;
		this.leaseStartDate = leaseStartDate;
		this.duration = duration;
		this.note = "";
	}

	public String getId() {
		return id;
	}

	public String getPropertyId() {
		return propertyId;
	}

	public String getUserId() {
		return userId;
	}

	public LocalDate getLeaseStartDate() {
		return leaseStartDate;
	}

	public LocalDate getLeaseEndDate() {
		return leaseEndDate;
	}

	public String getNote() {
		return note;
	}

	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
        this.duration = duration;
    }
	
	public void setNote(String note) {
		this.note = "";
	}
	
	public void setLeaseStartDate(LocalDate leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}
	


}
