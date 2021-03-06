<div class="jobs">
	<h2>
		<#assign categoryName="${category.getName()}">
		<a href="/categories/${categoryName}">${categoryName}</a> Jobs
		<span>Latest post ${category.getLatestJob().getTimeFromNow()}</span>
	</h2>
	<ul>
	<#list category.getJobs() as job>
		<li>
			<#if job.isNew()>
				<span class="new">New</span>
			</#if>
		  	<a href="/jobs/${job.getId()}">
				<span class="city">${job.getLocation()}</span>
				<span class="title">${job.getTitle()}</span> in <span class="company">${job.getCompany()}</span>
				<span class="date">${job.getShortDate()}</span>
		  	</a>
		</li>
	</#list>
	</ul>
</div><!--end div class="jobs" -->
