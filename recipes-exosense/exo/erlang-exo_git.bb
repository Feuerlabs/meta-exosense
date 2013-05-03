DESCRIPTION = "Exosense socket library"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://src/exo_app.erl;beginline=1;endline=9;md5=557fd2e6354ea91388b761f32e91a468"

DEPENDS += "erlang-lager"

SRCREV="AUTOINC"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/exo.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("exo", "exo-*", "ebin priv", "src include README", d)
}

