DESCRIPTION = "GSMS manager"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

SRCREV="f3a96e58a66608b602e6ba86a05ebb6ec228858a"

PR = "r2"

SRC_URI = "git://github.com/tolbrino/gsms.git;protocol=git;branch=integr"

S = "${WORKDIR}/git"

DEPENDS = "erlang-lager erlang-uart"

inherit tetrapak

python () {
    erlang_def_package("gsms", "gsms-*", "ebin", "src include README* rebar* sys.config LICENSE", d)
}

