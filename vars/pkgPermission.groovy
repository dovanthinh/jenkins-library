// The function will check the condition that the pkg can be deployed on server?
def checkPkgPermission(pkgName, srv) {
    String jobName = env.JOB_NAME
    def pkgAllowList
    def allowFlag = 0
    try {
        pkgAllowList = jenkinsPkg.allowList.get(jobName).get("PKGALLOWLIST").tokenize(" ")
        srvAllowList = jenkinsPkg.allowList.get(jobName).get("SRVALLOWLIST").tokenize(" ")
    } catch(exp) {
        error("Allowlist for this job is NOT set")
    }
    for (pkg_allow in pkgAllowList) {
        if (pkgName == pkg_allow) {
            allowFlag += 1		
        }	
    }
    for (srv_allow in srvAllowList) {
        if (srv == srv_allow) {
            allowFlag += 1
        }
    }
    if (allowFlag < 2) {
        error("$pkgName is not allowded to install on $srv")
    }
    else {
        println "$pkgName is allowed to install on $srv"
    }
}
