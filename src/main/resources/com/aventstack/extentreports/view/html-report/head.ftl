<#assign timeStampFormat = config.getValue('timeStampFormat')>
<#assign cdn = config.getValue('cdn')>

<head>
	<meta charset='${ config.getValue('encoding') }' /> 
	<meta name='description' content='' />
	<meta name='robots' content='noodp, noydir' />
	<meta name='viewport' content='width=device-width, initial-scale=1' />
	<meta id="timeStampFormat" name="timeStampFormat" content='${timeStampFormat}'/>
	
	<link href='jsandcss/sans.css' rel='stylesheet' type='text/css' />
	<link href="jsandcss/Icons.css" rel="stylesheet" />

	<#if cdn == 'extentreports'>
		<link href='jsandcss/extent.css' type='text/css' rel='stylesheet' />
	<#else>
		<link href='jsandcss/extent.css' type='text/css' rel='stylesheet' />
	</#if>
	
	<title>${ config.getValue('documentTitle') }</title>

	<style type='text/css'>
		<#if config.containsKey('css')>
			${ config.getValue('css') }
		</#if>
		<#if config.containsKey('styles')>
			${ config.getValue('styles') }
		</#if>
	</style>
</head>
