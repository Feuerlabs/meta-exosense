SUMMARY = "Exosense Device packages"
DESCRIPTION = "Packages required to provide Exosense Device functionality"
LICENSE = "MPL-2.0"
PR = "r1"

inherit packagegroup

# For backwards compatibility after rename
RPROVIDES_${PN} = "exosense"
RREPLACES_${PN} = "exosense"
RCONFLICTS_${PN} = "exosense"

RDEPENDS_${PN} = "\
    erlang \
    erlang-ssl \
    erlang-crypto \
    erlang-public-key \
    erlang-lager \
    erlang-arygon-nfc \
    erlang-exo \
    erlang-pppd-mgr \
    erlang-netlink \
    erlang-fnotify \
    erlang-inpevt \
    erlang-nmea-0183 \
    erlang-sext \
    erlang-bert \
    erlang-kvdb \
    erlang-parse-trans \
    erlang-uart \
    erlang-can \
    erlang-gpio \
    erlang-yang \
    erlang-canopen \
    erlang-dthread \
    erlang-exoport \
    erlang-gproc \
    erlang-setup \
"

PACKAGES = "${PN} \
"
