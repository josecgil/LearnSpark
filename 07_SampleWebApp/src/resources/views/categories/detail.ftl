<#import "/views/Layout.ftl" as layout />

<@layout.master title="Job Listing">
<div class="add-job">
	<a href="/jobs/create">
	  Post a Job, 90 days for only 400&euro;
	</a>
</div>
<#include "/views/_category.ftl">
<div class="nav">
	<p class="nav-prev"><a href="/">&laquo; Back to all Jobs</a></p>
</div>
</@layout.master>

