def getPkgInfo(PKG) {
    def pkgInfo = []
    if (PKG.find("=")) {
        pkgName = PKG.tokenize("=")[0]
        pkgVer = PKG.tokenize("=")[1]		
	} else {
        pkgName = PKG.tokenize("/").last().tokenize("_")[0]
        pkgVer = PKG.tokenize("/").last().tokenize("_")[1].split(".deb")[0] 
    }
    pkgInfo.add(pkgName)
    pkgInfo.add(pkgVer)
    return pkgInfo
}
