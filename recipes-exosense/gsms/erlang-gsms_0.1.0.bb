DESCRIPTION = "GSMS manager"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

SRCREV="d9a8c226bb3e1f06a0bbabc1cffae9714bd49d97"

PR = "r0"

SRC_URI = "git://github.com/tolbrino/gsms.git;protocol=git;branch=integr"

S = "${WORKDIR}/git"

DEPENDS = "erlang-lager erlang-uart"

inherit tetrapak

python () {
    erlang_def_package("gsms", "gsms-*", "ebin", "src include README* rebar* sys.config LICENSE", d)
}

