DESCRIPTION = "ExoPort protocol library"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

DEPENDS += "erlang-kvdb erlang-bert erlang-gsms"

SRCREV="AUTOINC"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/exoport.git;protocol=git;tag=1.1"
SRC_REV = "78fd79e11cbefca8f667ed4357b7f01130a86be1"
S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("exoport", "exoport-*", "ebin priv", "src include README", d)
}

