DESCRIPTION = "Can Open module"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

DEPENDS += "erlang-can"
SRCREV="AUTOINC"

PR = "r0"


SRC_URI = "git://github.com/Feuerlabs/canopen.git;protocol=git"


S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("canopen", "canopen-*", "ebin priv", "c_src src include README LICENSE", d)
}









