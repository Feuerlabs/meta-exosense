LICENSE="custom"

SRC_URI = " \
	file://harvest-startup \
	file://default \
"

inherit update-rc.d

INITSCRIPT_NAME = "harvest-startup"

do_install_append() {
    install -d ${D}${sysconfdir}/init.d/
    install -d ${D}${sysconfdir}/default
    install -m 0755 ${WORKDIR}/${INITSCRIPT_NAME} ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/default ${D}${sysconfdir}/default/${INITSCRIPT_NAME}
}
