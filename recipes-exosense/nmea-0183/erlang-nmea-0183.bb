DESCRIPTION = "NMEA 0183 manager"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

SRCREV="AUTOINC"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/nmea_0183.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("nmea-0183", "nmea_0183-*", "ebin priv", "src include README", d)
}

