def fire(glClass, jobName) {
    node("master") {
        sh(script: "/bin/bash /sysadmin/gatling/bin/gatling.sh -s sysadmin.${glClass} -rf /sysadmin/gatling/results/${jobName}/")
    }
}
  
fire("trungop", "trungop")
