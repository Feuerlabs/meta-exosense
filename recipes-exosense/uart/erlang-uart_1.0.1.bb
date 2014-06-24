DESCRIPTION = "UART driver and manager"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

SRCREV="c0d7c6181878f0f63e26616ea8bfdf3b34e86766"

PR = "r0"

SRC_URI = "git://github.com/tolbrino/uart.git;protocol=git;branch=integr"

S = "${WORKDIR}/git"

DEPENDS = "erlang-dthread erlang-fnotify"

inherit tetrapak

python () {
    erlang_def_package("uart", "uart-*", "ebin priv", "c_src src include README test LICENSE rebar*", d)
}
