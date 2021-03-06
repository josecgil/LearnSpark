<#import "/views/Layout.ftl" as layout />

<@layout.master title="Job Listing">
	<form id="add-job-form" action="/jobs/create" method="POST">
		<h2>Create a job listing</h2>
		<fieldset>
			<legend>Job Description</legend>
			<input type="text" name="title" />
		</fieldset>
		<fieldset>
			<legend>Category</legend>
			<ul>
				<#list categories.toList() as category>
				<li>
					<#assign categoryName="${category.getName()}">
					<input checked="checked" id="${categoryName}" name="category" type="radio" value="${categoryName}" />
					<label for="${categoryName}">${categoryName}</label>
				</li>
				</#list>
			</ul>
		</fieldset>
		<fieldset>
			<legend>Place</legend>
			<input type="text" name="location" />
		</fieldset>
		<fieldset>
			<legend>Description</legend>
			<textarea name="description" rows="10" cols="80"></textarea>
		</fieldset>
		<fieldset>
			<legend>Company</legend>
			<input type="text" name="company" />
		</fieldset>
		<fieldset>
			<input type="submit" value="Post an ad for 90 days" name="commit" class="button"> or <a href="/">Return to listing</a>
		</fieldset>
	</form>
</@layout.master>