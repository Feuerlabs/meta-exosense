DESCRIPTION = "KVDB database"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

DEPENDS += "erlang-lager erlang-gproc erlang-parse-trans"

SRCREV="0.8.2"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/kvdb.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("kvdb", "kvdb-*", "ebin priv", "src include README", d)
}
