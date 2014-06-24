DESCRIPTION = "Lager trace manager"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

SRCREV="935245d42c89830aa7301334e2bbf788697f16a2"

PR = "r0"

SRC_URI = "git://github.com/tolbrino/ale.git;protocol=git;branch=integr"

S = "${WORKDIR}/git"

DEPENDS = "erlang-lager"

inherit tetrapak

python () {
    erlang_def_package("ale", "ale-*", "ebin", "src test README* .gitignore rebar* sys.config LICENSE", d)
}
