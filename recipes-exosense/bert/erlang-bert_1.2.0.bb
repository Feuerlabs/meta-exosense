DESCRIPTION = "Erlang BERT module"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRCREV="1199edd6582c27c96eb595d02f1a2723b639d99e"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/bert.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("bert", "bert-*", "ebin priv", "src include README LICENSE", d)
}

