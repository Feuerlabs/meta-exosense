DESCRIPTION = "Netlink top level build"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

# erlang-pppdmgr should really go into ../tasks//tasks/task-core-exosense.bb,
# Bit that gices a weird error about unresolved dependencies, probably to
# do with the fact that the checked out git repo has an underscore in it
# (pppd_mgr).

# Add libnl_3.x.x dependency when this becomes available under yocto 1.4
# Also remove self-contained libnl-3 from Feuerlabs/netlink.git
DEPENDS += "libnl erlang-pppd-mgr"

SRCREV="AUTOINC"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/netlink.git;protocol=git;protocol=ssh;user=git"

S = "${WORKDIR}/git"

inherit tetrapak


python () {
    erlang_def_package("netlink", "netlink-*", "ebin priv", "libnl* src include README", d)
}

