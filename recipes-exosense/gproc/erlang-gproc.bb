DESCRIPTION = "Gproc module"
SECTION = "devel"
LICENSE = "ErlPL-1.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9567c64d58e18a81951c75d00c10fa98"

# DEPENDS += "erlang-genleader"
SRCREV="AUTOINC"

PR = "r0"


SRC_URI = "git://github.com/Feuerlabs/gproc.git;protocol=git;protocol=ssh;user=git "


S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("gproc", "gproc-*", "ebin priv", "patches reference rebar.config* README.md test Makefile examples .gitignore rebar src include README LICENSE", d)
}
