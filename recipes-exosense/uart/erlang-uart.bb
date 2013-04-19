DESCRIPTION = "UART driver and manager"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

DEPENDS += "erlang-dthread"
SRCREV="AUTOINC"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/uart.git;protocol=git;protocol=ssh;user=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("uart", "uart-*", "ebin priv", "src include README", d)
}
