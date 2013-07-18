DESCRIPTION = "GSMS manager"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

SRCREV="AUTOINC"

PR = "r0"

SRC_URI = "git://github.com/tonyrog/gsms.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("gsms", "nmea_0183-*", "ebin priv", "src include README", d)
}

