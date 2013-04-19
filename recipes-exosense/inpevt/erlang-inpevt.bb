DESCRIPTION = "Input Event driver and module"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

# DEPENDS += "erlang-xxx"

SRCREV="AUTOINC"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/inpevt.git;protocol=git;protocol=ssh;user=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("inpevt", "inpevt-*", "ebin priv", "c_src src include README LICENSE", d)
}








