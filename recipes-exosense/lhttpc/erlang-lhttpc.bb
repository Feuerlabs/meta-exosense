DESCRIPTION = "Lightweight HTTP client"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENCE;md5=a14a6736c56a07d1a148057b952ce370"

# DEPENDS += " "

SRCREV="AUTOINC"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/lhttpc.git;protocol=git;protocol=ssh;user=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("lhttpc", "lhttpc-*", "ebin priv", "rebar.config rebar.config.script Makefile test c_src src include README LICENSE", d)
}








