DESCRIPTION = "Erlang LevelDB API"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRCREV="36ff24e541cbe24dee3076e1f6e3b4da36b9ad13"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/eleveldb.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("eleveldb", "eleveldb-*", "ebin priv", "src include README", d)
}
