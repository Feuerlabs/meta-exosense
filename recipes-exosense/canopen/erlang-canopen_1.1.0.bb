DESCRIPTION = "Can Open module"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54890ca48e62dae5a971448d09fd3284"

SRCREV="aa1b895515338bac8ba68a3a443d6c07ec0cf3f9"

PR = "r0"

SRC_URI = "git://github.com/tolbrino/canopen.git;protocol=git;branch=integr"

S = "${WORKDIR}/git"

DEPENDS = "erlang-ale erlang-can"

inherit tetrapak

python () {
    erlang_def_package("canopen", "canopen-*", "ebin priv", "c_src src include README* LICENSE rebar* test .gitignore sys.config", d)
}
