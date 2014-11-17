DESCRIPTION = "PPPD manager"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRCREV="1ea5001de6bde42b20adbd3aea0903dce64bd17e"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/pppd_mgr.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("pppd-mgr", "pppd_mgr-*", "ebin priv", "src include README rebar* LICENSE", d)
}

