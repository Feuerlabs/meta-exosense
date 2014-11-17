DESCRIPTION = "Resource tracking nif"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRCREV="a20202ee15ed65d6a88d37e9e0883b0d16a8d940"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/resource.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("resource", "resource-*", "ebin priv", "src Makefile rebar* c_src README", d)
}
