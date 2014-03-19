package testutil.fakeentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import model.abstractions.EntityInterface;

@Entity
public class FakeEntity implements EntityInterface {
	public FakeEntity(final long id) {
		super();
		this.id = id;
	}

	public FakeEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String sth;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		FakeEntity other = (FakeEntity) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "FakeEntity [id=" + id + "]";
	}

	public String getSth() {
		return sth;
	}

	public void setSth(final String sth) {
		this.sth = sth;
	}

}