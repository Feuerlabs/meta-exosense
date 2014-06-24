DESCRIPTION = "parse_trans module"
SECTION = "devel"
LICENSE = "ErlPL-1.1"
LIC_FILES_CHKSUM = "file://src/parse_trans.erl;beginline=1;endline=10;md5=ef6a7d13e7b6ea7138fbb765dde1263f"

SRCREV="763462825e4ce4660d43e6511078489ea50cdeca"

PR = "r0"

SRC_URI = "git://github.com/uwiger/parse_trans.git;protocol=git"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("parse-trans", "parse_trans-*", "ebin priv", "README.md rebar* .gitignore Makefile examples src include README", d)

}

