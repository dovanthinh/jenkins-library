def deploy(server, pkg)
   node("master") {
      ssh(script: "python /sysadmin/jenkins-script/jdeploy.py -m ${server} -p ${pkg}")
   }
}
