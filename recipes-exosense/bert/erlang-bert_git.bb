DESCRIPTION = "Erlang BERT module"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

DEPENDS += "erlang-lager erlang-exo"

SRCREV="HEAD"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/bert.git;protocol=git;protocol=ssh;user=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("bert", "bert-*", "ebin priv", "src include README", d)
}

