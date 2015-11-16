<#import "/views/Layout.ftl" as layout />

<@layout.master title="Job Listing">
<div class="add-job">
	<a href="/jobs/create">
	  Post a Job, 90 days for only 400&euro;
	</a>
</div>
<#list categories.toList() as category>
	<#include "/views/_category.ftl">
</#list>
</@layout.master>

