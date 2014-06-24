FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
            file://can_support.cfg \
            tt3201-can-cape.patch \
"
