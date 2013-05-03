DESCRIPTION = "Yang parser and validator"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

DEPENDS += " erlang-parse-trans erlang-lager"

SRCREV="AUTOINC"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/yang.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("yang", "yang-*", "ebin priv", "rebar.config rebar.config.script Makefile test c_src src include README LICENSE", d)
}








