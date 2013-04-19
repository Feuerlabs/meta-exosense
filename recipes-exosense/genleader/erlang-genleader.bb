DESCRIPTION = "Genleader library"
SECTION = "devel"
LICENSE = "ErlPL-1.1"
LIC_FILES_CHKSUM = "file://src/gen_leader.erl;beginline=1;endline=14;md5=fb0f91c9705c7d0a2f0878f1a499b218"

SRCREV="AUTOINC"

PR = "r0"

SRC_URI = "git://github.com/Feuerlabs/gen_leader_revival.git;protocol=git;protocol=ssh;user=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("genleader", "genleader-*", "ebin priv", "src include README", d)
}

