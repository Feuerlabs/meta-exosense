DESCRIPTION = "KVDB database"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

DEPENDS_${PN} += "erlang-lager erlang-gproc erlang-parse-trans erlang-sext erlang-resource erlang-setup erlang-eleveldb"

SRCREV="9d01bb2d0c9ad83da7c86f6f2f19ea6bdb0b18d9"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/kvdb.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("kvdb", "kvdb-*", "ebin priv", "src include README", d)
}
