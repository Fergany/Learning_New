Apache Maven
============
- Software project management and comprehensive tool.
- Focused around Project Object Model (POM).
- Original focus was on building software.
- Easy-to-use tool for most software build needs.

Maven Objectives
================
- Easy build process.
- Support migration to new features.

Why Use Maven?
==============
- Works well with basic to complex builds.
- Easy to use.
- Great support in the community.
- Reliable.

Java Project structure
======================

root
|__ src
	|__ main
		|__ java
		|__ resources
	|__ test	
		|__ java
		|__ resources	
|__ pom.xml

POM file
========
- Project Object Model. 
- Contains all the details of the project (Dependency definitions, build details, reporting details).

Project Information
-------------------
- groupId
- artifactId
- version

Other Sections
--------------
- Properties
- Dependencies
- Build
- Reporting

Additional Sections
-------------------
- Repositories
- pluginRepositories
- Profiles

POM properties
==============
Properties Purpose
------------------
- Reduces duplication.
- Streamlines configuration.
- Helps keep items in sync.

   <properties>
        <jackson.version>2.9.8</jackson.version>

   </properties>

   <dependencies>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>${jackson.version}</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>${jackson.version}</version>
        </dependency>
	</dependencies>
	

Dependencies
=============
	<dependency>
        <groupId>top-level organizational structure</groupId>
        <artifactId>how we reference a dependency</artifactId>
        <version>specific build of the artifact that you want to consume</version>
        <scope>test</scope>
    </dependency>

Build
=====

Reporting
=========


Reactors and parents
====================
Parent Pom
-----------
- Provided versioned dependencies and plugins.
- 
- Top-level visibility for approved artifact.

Reactors
--------
- Build on concept of parent POM.
- Often group of related artifacts.
- Commands executed on parent.

Archetypes
==========
- Project template.
- Specified when starting a project.
- Consistency on teams.

Build Lifecycle
===============
Three main lifecycle:
- Default - main lifecycle
- Clean - cleans prj
- Site - gernerates prj doc.

each lifecycle has phases,

Phases
======
- Stages in the lifecycle.
- Default lifecycle - validate, compile, test, package, verify, install, and deploy.
- Phases executed in order.
- Phases made up of goals,

Goals:
======
- Independent tasks in the phase.
- Plugin goals bound to phase of lifecycle.
- Goals can be triggered individually.
- Consider mvn dependency:analyze

Build plugin
============
- Build plugins are part of all lifecycles in some part.
- 
- 3 types of build plugin (Core, packaging, and tools).

Core
----
> Complilation
> Installation
> Deployment
> Validation
















