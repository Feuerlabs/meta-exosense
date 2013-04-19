DESCRIPTION = "Setup module"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

# DEPENDS += "erlang-xxx"
SRCREV="AUTOINC"

PR = "r0"


SRC_URI = "git://github.com/Feuerlabs/setup.git;protocol=git;protocol=ssh;user=git"


S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("setup", "setup-*", "ebin priv", "rebar.config* README.md test Makefile examples .gitignore rebar src include README LICENSE", d)
}









