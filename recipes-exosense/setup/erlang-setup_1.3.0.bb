DESCRIPTION = "Setup module"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRCREV="29e48cdff30e1154dcd850e90a5cefa2a5e93e22"

PR = "r0"

SRC_URI = "git://github.com/uwiger/setup.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("setup", "setup-*", "ebin priv", "rebar.config* README.md test Makefile examples .gitignore rebar src include README LICENSE", d)
}









