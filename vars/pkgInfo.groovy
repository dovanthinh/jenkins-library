import jenkinsPkg

// The funcion will return information of package (pkgName, pkgVer)
def getPkgInfo(pkg) {
    def pkgInfo = []
    if (pkg.find("=")) {
        pkgName = pkg.tokenize("=")[0]
        pkgVer = pkg.tokenize("=")[1]		
	} else {
        pkgName = pkg.tokenize("/").last().tokenize("_")[0]
        pkgVer = pkg.tokenize("/").last().tokenize("_")[1].split(".deb")[0] 
    }
    pkgInfo.add(pkgName)
    pkgInfo.add(pkgVer)
    return pkgInfo
}

// The function will check the condition that the pkg can be deployed on server?
def checkPkgPermission(pkgName, srv) {
    jPkg = new jenkinsPkg()
    //String jobName = env.JOB_NAME
    jobName = "ADM-tools"
    def pkgAllowList
    def allowFlag = 0
    try {
        pkgAllowList = jPkg.allowList.get(jobName).get("PKGALLOWLIST").tokenize(" ")
        srvAllowList = jPkg.allowList.get(jobName).get("SRVALLOWLIST").tokenize(" ")
    } catch(exp) {
        error("Allowlist for this job is NOT set")
    }
    for (pkg_allow in pkgAllowList) {
        if (pkgName == pkg_allow)
            allowFlag += 1			
    }
    for (srv_allow in srvAllowList) {
        if (srv == srv_allow)
            allowFlag += 1
    }
    return allowFlag
//    if (allowFlag == 0) {
//        error("$pkgName is not allowed")
//    }
//    else if (alllowFlag == 1) {
//        eroor("$srv is not allowed")
//    }
}

