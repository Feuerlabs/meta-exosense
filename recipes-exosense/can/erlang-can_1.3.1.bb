DESCRIPTION = "can port driver and module"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

SRCREV="6e4b214d3b9a571695f02d6e8d6185c1d0040e5d"

PR = "r0"

SRC_URI = "git://github.com/tolbrino/can.git;protocol=git;branch=integr"

S = "${WORKDIR}/git"

DEPENDS = "erlang-lager erlang-uart"

inherit tetrapak

python () {
    erlang_def_package("can", "can-*", "ebin priv", "c_src src include README LICENSE rebar*", d)
}
