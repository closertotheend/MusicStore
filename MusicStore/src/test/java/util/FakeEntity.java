package util;

import javax.persistence.Entity;
import javax.persistence.Id;

import model.abstractions.EntityInterface;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@Entity
@RunWith(MockitoJUnitRunner.class)
public class FakeEntity implements EntityInterface {
	public FakeEntity(final long id) {
		super();
		this.id = id;
	}

	public FakeEntity() {
		super();
	}

	@Id
	private long id;

	@Override
	public Long getId() {
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

}