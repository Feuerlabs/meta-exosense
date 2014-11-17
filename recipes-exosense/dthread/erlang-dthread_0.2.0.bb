DESCRIPTION = "Erlang Dthread plugin"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

SRCREV="ec226d84dce2a98064e8e7ed96d9d9512269dab1"

PR = "r0"

SRC_URI = "git://github.com/tolbrino/dthread.git;protocol=git;branch=integr"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("dthread", "dthread-*", "ebin include priv", "src README LICENSE rebar* c_src", d)
}

do_install_append() {
    install -d 0755 ${D}${includedir}
    install -m 0755 include/*.h ${D}${includedir}
}
