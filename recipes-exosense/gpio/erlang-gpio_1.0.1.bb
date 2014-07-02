DESCRIPTION = "GPIO driver and module"
SECTION = "devel"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRCREV="aa9df34f4301c2566dc96086d0104f71bda37884"

PR = "r1"

SRC_URI = "git://github.com/tolbrino/gpio.git;protocol=git;branch=integr"

S = "${WORKDIR}/git"

inherit tetrapak

python () {
    erlang_def_package("gpio", "gpio-*", "ebin priv", "c_src src include rebar* NEWAPI.txt README LICENSE", d)
}
