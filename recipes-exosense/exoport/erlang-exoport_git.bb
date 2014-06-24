DESCRIPTION = "ExoPort protocol library"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

DEPENDS += "erlang-kvdb erlang-bert erlang-gsms"

SRCREV="AUTOINC"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/exoport.git;protocol=git"
SRC_REV = "f9dfc1a6a39c2dfe85f8badacb2091b4669b98fc"
S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("exoport", "exoport-*", "ebin priv", "src include README", d)
}

