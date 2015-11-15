package infrastructure;

import java.util.Random;

import org.joda.time.DateTime;

import models.CategoryCollection;
import models.Job;

public class RandomJobCreator {

	public static CategoryCollection create(int count) {
		CategoryCollection categories=new CategoryCollection();
		for (int i = 0; i < count; i++) {
			Job randomJob=createRandomJob();
			categories.addJob(randomJob);
		}
		categories.sortJobs();
		return categories;
	}

	private static Job createRandomJob() {
		Job job = new Job();
		String[] randomTitleAndCategory=randomTitleAndCategory();
		job.setTitle(randomTitleAndCategory[0]);
		job.setDateTime(randomDate());
		job.setCompany(randomCompany());
		job.setDescription(randomDescription());
		job.setLocation(randomLocation());
		job.setCategoryName(randomTitleAndCategory[1]);
		return job;
	}

	private static Random random = new Random();

	private static int generateRandomInt(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}

	private static String randomLocation() {
		switch (generateRandomInt(1, 7)) {
		case 1:
			return "Barcelona";
		case 2:
			return "Berlin";
		case 3:
			return "NY city";
		case 4:
			return "Chicago";
		case 5:
			return "San Francisco";
		case 6:
			return "Moscow";
		}
		return "London";
	}


	private static String randomDescription() {
		switch (generateRandomInt(1, 3)) {
			case 1:
				return "We are in the search of a highly talented, skilled and passionate person";
			case 2:
				return "The ideal candidate for this position will be able to create fantastic solutions that can be turned into excellents products";
		}
		return "The candidate needs to be able to interact with our customers to identify their real needs and problems and come up with solutions that are not only simple but beautiful";
	}
	
	private static DateTime randomDate() {
		int ageOfTheJobInDays=generateRandomInt(0, 90);
		return new DateTime().minusDays(ageOfTheJobInDays);
	}

	private static String randomCompany() {
		switch (generateRandomInt(1, 9)) {
			case 1:
				return "Netologies Inc";
			case 2:
				return "Funk";
			case 3:
				return "Soyuz Films";
			case 4:
				return "lukiluk.com";
			case 5:
				return "Experts & Co";
			case 6:
				return "Bulltop.com";
			case 7:
				return "RatCo Solutions";
			case 8:
				return "Freesoft";
		}
		return "TuxDev";
	}

	private static String[] randomTitleAndCategory() {
		switch (generateRandomInt(1, 13)) {
			case 1:
				return new String[]{"Front-end Expert (jQuery, Angular)", Job.CATEGORY_DESIGN};
			case 2:
				return new String[]{"UI Designer", Job.CATEGORY_DESIGN};
			case 3:
				return new String[]{"CSS Ninja", Job.CATEGORY_DESIGN};
			case 4:
				return new String[]{"UX Expert", Job.CATEGORY_DESIGN};
			case 5:
				return new String[]{"LAMP developer", Job.CATEGORY_PROGRAMMING};
			case 6:
				return new String[]{"Java wizard", Job.CATEGORY_PROGRAMMING};
			case 7:
				return new String[]{"Spark Framework Expert", Job.CATEGORY_PROGRAMMING};
			case 8:
				return new String[]{".Net Developer", Job.CATEGORY_PROGRAMMING};
			case 9:
				return new String[]{"CTO", Job.CATEGORY_EXECUTIVE};
			case 10:
				return new String[]{"Director", Job.CATEGORY_EXECUTIVE};
			case 11:
				return new String[]{"CEO", Job.CATEGORY_EXECUTIVE};
			case 12:
				return new String[]{"Musician", Job.CATEGORY_OTHER};
		}
		return new String[]{"Tree hugger", Job.CATEGORY_OTHER};
	}

}
