DESCRIPTION = "GSMS manager"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

SRCREV="684663ad8cc6da6e3277e1bd4df9932171278eed"

PR = "r4"

SRC_URI = "git://github.com/tolbrino/gsms.git;protocol=git;branch=integr"

S = "${WORKDIR}/git"

DEPENDS = "erlang-lager erlang-uart"

inherit tetrapak

python () {
    erlang_def_package("gsms", "gsms-*", "ebin", "src include README* rebar* sys.config LICENSE", d)
}

