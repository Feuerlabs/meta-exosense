DESCRIPTION = "Erlang sext module"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ff253ad767462c46be284da12dda33e8"

# DEPENDS += ""

SRCREV="80dca684bbbbd5bc12c18a0a9d2bf4021d0b5eac"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/sext.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("sext", "sext-*", "ebin priv", "src include README", d)
}

