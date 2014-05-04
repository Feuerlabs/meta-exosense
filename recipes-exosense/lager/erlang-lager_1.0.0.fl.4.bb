DESCRIPTION = "Erlang logging module"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ff253ad767462c46be284da12dda33e8"

SRCREV="e5881d84cc06ec45e2bdddf68cc512f0e9cf9dab"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/lager.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("lager", "lager-*", "ebin priv", "src include README", d)
}

