DESCRIPTION = "tetrapak is an extensible build system for Erlang/OTP applications."
SCTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/tetrapak.erl;beginline=1;endline=19;md5=300d83493c235b71e1a4d58e25379bc5"
SRCREV="1d409835ae37fc2028b456a6cd56f2c27fbff57c"

PR = "r1"

SRC_URI = "git://github.com/travelping/tetrapak.git;protocol=git"

S = "${WORKDIR}/git"

inherit native erlangnative

do_install() {
    install -d -m755 ${D}${libdir}/erlang/lib/tetrapak
    install -d -m755 ${D}${bindir}
    cp -a ${S}/* ${D}${libdir}/erlang/lib/tetrapak
    ln -sf ../lib/erlang/lib/tetrapak/bin/tetrapak ${D}${bindir}/tetrapak
}
