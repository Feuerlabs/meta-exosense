DESCRIPTION = "Arygon NFC manager"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRCREV="AUTOINC"
DEPENDS += " erlang-lager"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/arygon_nfc.git;protocol=git;protocol=ssh;user=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("arygon-nfc", "arygon_nfc-*", "ebin priv", "src include README", d)
}

