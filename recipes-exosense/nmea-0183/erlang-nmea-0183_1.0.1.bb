DESCRIPTION = "NMEA 0183 manager"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

SRCREV="0ddff3ce8732a7ead71868c81803b89696873626"

PR = "r0"

SRC_URI = "git://github.com/tolbrino/nmea_0183.git;protocol=git;branch=integr"

S = "${WORKDIR}/git"

DEPENDS = "erlang-uart"

inherit tetrapak

python () {
    erlang_def_package("nmea-0183", "nmea_0183-*", "ebin priv", "src include rebar* LICENSE Makefile README", d)
}
