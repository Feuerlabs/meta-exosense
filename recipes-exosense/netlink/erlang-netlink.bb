DESCRIPTION = "Netlink top level build"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

DEPENDS += "erlang-pppd-mgr"

SRCREV="AUTOINC"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/netlink.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak


python () {
    erlang_def_package("netlink", "netlink-*", "ebin priv", "libnl* src include README", d)
}

