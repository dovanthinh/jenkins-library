class jenkinsPkg implements Serializable {
    def whiteList = []
    def typeList = []
    def allowList = [
        "ADM-tools": ["PKGALLOWLIST": "trungop", "SRVALLOWLIST": "fw-web-dev"]
    ]
}
