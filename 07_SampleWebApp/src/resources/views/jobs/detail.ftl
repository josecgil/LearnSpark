<#import "/views/Layout.ftl" as layout />

<@layout.master title="Job Listing">
	<div class="nav">
		<#assign categoryName="${job.getCategoryName()}">
		<p class="nav-next"><a href="/categories/${categoryName}">See more ${categoryName} jobs &raquo;</a></p>	
		<p class="nav-prev"><a href="/">&laquo; Back to all offers</a></p>
	</div>

	<div id="job-details">
		<h1>${job.getTitle()}</h1>
		<h3>Posted on ${job.getShortDate()}</h3>
		<h2>
		  <span class="company">${job.getCompany()}</span>
		  <span class="location">Location: ${job.getLocation()}</span>
		</h2>
	</div>
	<div id="job-description">
		<p>${job.getDescription()}</p>
	</div>
	<div class="apply">
		<h3>APPLY FOR THIS POSITION</h3>
		<p>Please email your resume with cover letter and salary requirements to <strong>job${job.getId()}@projobseeker.com</strong>. You can use the body of email as your cover letter or attach it separately. No recruiters please.</p>
	</div>
</@layout.master>