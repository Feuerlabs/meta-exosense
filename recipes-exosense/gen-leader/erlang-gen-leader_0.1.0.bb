DESCRIPTION = "Genleader library"
SECTION = "devel"
LICENSE = "ErlPL-1.1"
LIC_FILES_CHKSUM = "file://src/gen_leader.erl;beginline=1;endline=14;md5=fb0f91c9705c7d0a2f0878f1a499b218"

SRCREV="318e8e5a279df73009c3fd3a62201de885d0eecd"

PR = "r0"

SRC_URI = "git://github.com/garret-smith/gen_leader_revival.git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("gen-leader", "gen_leader-*", "ebin priv", "src include README* Emakefile .gitignore rebar* Makefile attic examples include", d)
}

