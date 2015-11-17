<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
	"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es">
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="css/master.css" type="text/css" />
		<title>Job Listing - Pro Job Seeker</title>
	</head>
	<body>
		<div id="page">
			<div id="header" >
				<h1><a href="index.html">Pro Job Seeker</a></h1>
				<p>Industry leaders <strong>since 2006</strong>. The best companies use our system to find the <strong>best and brightest<strong> professionals.</p>
			</div>
			<div id="content">

				<div class="add-job">
					<a href="addjob.html">
					  Post a Job, 90 days for only 400&euro;
					</a>
				</div>

				<#list jobsGroupedByCategory?keys as jobCategoryName>
					<#assign jobs = jobsGroupedByCategory[jobCategoryName]>
					<div class="views.jobs">
						<h2>
							<a href="category.html">${jobCategoryName}</a> Jobs
							<span>Latest post about 20 hours ago</span>
						</h2>
						<ul>
							<#list jobs as job>
								<li>
									<#if job.isNew()>
										<span class="new">New</span>
									</#if>
									<a href="onejob.html">
										<span class="city">${job.getLocation()}</span>
										<span class="title">${job.getTitle()}</span> in
										<span class="company">${job.getCompany()}</span>
										<span class="date">${job.getDateFormat()}</span>
									</a>
								</li>
							</#list>
						</ul>
					</div><!--end div class="views.jobs" -->
				</#list>

				<div style="clear:both" ></div>
			</div> <!--end div id="content" -->

			<div id="footer">
				<p>&copy; 2011 Job Listing Company International</p>
			</div>

		</div>
	</body>
</html>