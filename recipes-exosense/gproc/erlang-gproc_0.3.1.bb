DESCRIPTION = "Gproc module"
SECTION = "devel"
LICENSE = "ErlPL-1.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9567c64d58e18a81951c75d00c10fa98"

SRCREV="14a13b253262fe7f85c86238d08ed28438d846f0"

PR = "r0"

SRC_URI = "git://github.com/tolbrino/gproc.git;protocol=git;branch=fix_xref_error"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("gproc", "gproc-*", "ebin priv", "patches reference rebar.config* README.md test Makefile examples .gitignore rebar src include README LICENSE*", d)
}
