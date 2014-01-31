package testutil.fem;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Parameter;
import javax.persistence.Query;
import javax.persistence.TemporalType;

public class FakeQuery implements Query {

	@Override
	public int executeUpdate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFirstResult() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FlushModeType getFlushMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getHints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LockModeType getLockMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxResults() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Parameter<?> getParameter(final String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parameter<?> getParameter(final int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Parameter<T> getParameter(final String name, final Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Parameter<T> getParameter(final int position, final Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getParameterValue(final Parameter<T> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getParameterValue(final String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getParameterValue(final int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Parameter<?>> getParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getResultList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getSingleResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBound(final Parameter<?> param) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Query setFirstResult(final int startPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query setFlushMode(final FlushModeType flushMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query setHint(final String hintName, final Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query setLockMode(final LockModeType lockMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query setMaxResults(final int maxResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Query setParameter(final Parameter<T> param, final T value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query setParameter(final String name, final Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query setParameter(final int position, final Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query setParameter(final Parameter<Calendar> param,
			final Calendar value, final TemporalType temporalType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query setParameter(final Parameter<Date> param, final Date value,
			final TemporalType temporalType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query setParameter(final String name, final Calendar value,
			final TemporalType temporalType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query setParameter(final String name, final Date value,
			final TemporalType temporalType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query setParameter(final int position, final Calendar value,
			final TemporalType temporalType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Query setParameter(final int position, final Date value,
			final TemporalType temporalType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(final Class<T> cls) {
		// TODO Auto-generated method stub
		return null;
	}

}
