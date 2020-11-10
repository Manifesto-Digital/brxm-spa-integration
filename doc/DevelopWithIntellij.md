### Develop with IntelliJ configuration
When working with brXM, we can run it using maven cargo profile `mvn -P cargo.run` or docker plugin `mvn -P docker.run`.
Beside that, we also are able to run project with embedded tomcat server. This option makes the coding, building, 
hot reloading, debugging processes much easier and quicker.

The idea is that we run project with cargo one time, get the tomcat binary, configuration then use these binary/configuration
to create embedded Tomcat instance

#### Step 1: Run project with cargo
Run it as usual using command `mvn -P cargo.run`
After this command, we have 2 Tomcat related folders 
`target\cargo\installs\apache-tomcat-9.0.37\apache-tomcat-9.0.37` and `target\tomcat9x`

#### Step 2: Clone these 2 Tomcat folders
We should not use those 2 folders directly to setup embedded Tomcat because the `target` folder can be erased with maven 
clean process. To make it use for long term we copy those 2 folders into different place.
As convention, we can create folder name `tomcat_binary` and copy these folders into this new parent folder.
Add `tomcat_binary` into .gitignore

### Step 3: Create embedded Tomcat Application
With IntelliJ, create new Tomcat Application instance as usual but with Tomcat home and Tomcat base folder using 2 above 
folder. Here are my screenshot of the creation dialog.
![Image of creation dialog](https://raw.githubusercontent.com/Manifesto-Digital/brxm-spa-integration/dev/doc/images/CreateTomcatApplication.png)

### Step 4: Configure Tomcat instance
After the Tomcat Application sever created, we can create the Tomcat instance to run project easily as we did with any
Java Web application. 

Add CMS and Site deployment with their application context to be `/cms` and `/site`.
![Image of configure deployment](https://raw.githubusercontent.com/Manifesto-Digital/brxm-spa-integration/dev/doc/images/ConfigureDeployment.png)

Configure VM Options using the same attributes in which cargo passing to its JVM
![Image of configure VM Options](https://raw.githubusercontent.com/Manifesto-Digital/brxm-spa-integration/dev/doc/images/ConfigureVMOption.png)


