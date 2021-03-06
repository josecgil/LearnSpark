package models;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import models.Job;

public class TestJob {

	@Test
	public void itMustBeNewIfIsFromToday() {
		Job job=new Job();
		Assert.assertTrue(job.isNew());
	}

	@Test
	public void itMustBeNewIfIsFrom15DaysAgo() {
		Job job=new Job();
		job.setDateTime(new DateTime().minusDays(15));
		Assert.assertTrue(job.isNew());
	}

	@Test
	public void itMustBeNewIfIsFromMoreThan15DaysAgo() {
		Job job=new Job();
		job.setDateTime(new DateTime().minusDays(16));
		Assert.assertFalse(job.isNew());
	}

	@Test
	public void itMustBeNewIfIsFromMoreThanAMonth() {
		Job job=new Job();
		job.setDateTime(new DateTime().minusDays(60));
		Assert.assertFalse(job.isNew());
	}

	
}
