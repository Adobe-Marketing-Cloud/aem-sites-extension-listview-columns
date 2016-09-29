# Adobe Experience Manager 6.3 Extension: Adding custom columns to Sites' list view

This is a sample package showing how to configure the list view in Sites administration to display custom columns.

## Contents
 
The package contains the following artifacts:

* ```com.adobe.aem.sites.extension.listview.columns.content```: the content package defining the new column to be added
* ```com.adobe.aem.sites.extension.listview.columns.core```: a bundle providing a service to compute the data for the new column we are going to add
* ```com.adobe.aem.sites.extension.listview.columns.overlay```: a temporary content package for overlaying AEM 6.3 extension capabilities

The package is designed to work for AEM 6.3 GA.


## Build & Install
 
This project uses Maven for building.

1. Start an AEM 6.3 instance
2. From the root directory, run ```mvn clean install```
3. Go to ```overlay``` folder and run ```mvn content-package:install```
4. Go back to root directory
5. Go to ```content``` folder and run ```mvn content-package:install```
6. Go to [Sites](http://localhost:4502/sites.html)
7. Switch to ```List View```
8. Add the ```Created``` column as explained in [AEM documentation](https://docs.adobe.com/docs/en/aem/6-3/author/author-environment/basic-handling.html#List%20View%20-%20Column%20Selection).
