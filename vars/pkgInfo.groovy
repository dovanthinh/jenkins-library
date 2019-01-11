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

