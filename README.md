##Deploy locally

1. For Windows host you should install vagrant winnfsd plugin
2. Install [scala 2.11.7 and activator](http://www.scala-lang.org/download/2.11.7.html) on host
3. vagrant up
4. Run `activator run` on host

Application will be accessible at http://localhost:9000/

####Why not install scala/sbt inside vagrant VM for development?

Running part of application on host has apparent disadvantages. But there are several
important advantages of running scala application itself from host to:
#####You have full power of you host machine to recompile source files during development.
It may seem not so important, especially if you allow VM to use reasonable amount of machine
resources, but after some experiments it came out that incremental compiling of several changed
files takes about **10 seconds** on VM (when using 2 CPUs and 3 GB RAM) vs **2 seconds** when compilation
is executed on host.

#####Shared folders (NFS/SMB/native VirtualBox) do not work well with sbt file watcher.

SBT uses Inotify on linux to recompile sources during request to application if changes where
done to make development process enjoyable. But listed shared folders file systems do not
generate Inotify events, and automatic incremental project recompiling just does not work.

It could be fixed using other file watchers, which will every N seconds check files for
changes. But for me it seemed not usable too. Anyway sometimes you wait for ~5 seconds
for compilation to start (during this time changes that you made are ignored).
And you cannot make this checks every 1 second, because of high CPU usage and
low filesystem perfomance.


So, for now, it makes sense to run application on host with rest services inside docker
containers on VM during development.


##Deploy to prod
Something like http://www.scala-sbt.org/sbt-native-packager/formats/docker.html

##Running tests
`activator test`

##Create runnable project archive:
`activator dist`

Archive will be created in target/universal/scala-blog-VERSION-SNAPSHOT.zip
To run application, unarchive it and run:
bin/scala-blog -Dapplication.secret=some-secret
or
"bin/scala-blog.bat" -Dapplication.secret=some-secret
