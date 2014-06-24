DESCRIPTION = "fnotify port driver and module"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRCREV="8a9d5dffa81d7206f40cb4441cb3162478837e62"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/fnotify.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("fnotify", "fnotify-*", "ebin priv", "c_src src include README LICENSE Makefile rebar*", d)
}
