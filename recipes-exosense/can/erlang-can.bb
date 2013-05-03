DESCRIPTION = "can port driver and module"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

DEPENDS += " erlang-lager erlang-dthread erlang-uart"
SRCREV="AUTOINC"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/can.git;protocol=git"


S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("can", "can-*", "ebin priv", "c_src src include README LICENSE", d)
}
