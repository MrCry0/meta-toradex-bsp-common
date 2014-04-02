require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM_colibri-vf = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb \
                               file://README;beginline=1;endline=22;md5=78b195c11cb6ef63e6985140db7d7bab"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"

PV = "${PR}+gitr${SRCREV}"
PR = "r0"

S = "${WORKDIR}/git"

SRCREV_colibri-vf = "f624e019a3f37ee4415a407afae0e026dd203714"
SRCREV_apalis-imx6 = "aedaff053151ac4feba223d46f0d04a303a48eee"
SRCBRANCH_colibri-vf = "colibri_vf"   
SRCBRANCH_apalis-imx6 = "toradex_imx6"
SRC_URI = "git://git.toradex.com/u-boot-toradex.git;protocol=git;branch=${SRCBRANCH}"

#FILESPATHPKG =. "git:"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(colibri-vf|apalis-imx6)"
DEFAULT_PREFERENCE_colibri-vf = "1"
DEFAULT_PREFERENCE_apalis-imx6 = "1"

# colibri_vf: build additionally a u-boot binary used for sd-card boot
SPL_BINARY_colibri-vf  = "u-boot.imx"
SPL_IMAGE_colibri-vf   = "u-boot-${MACHINE}-${PV}-${PR}.imx"
SPL_SYMLINK_colibri-vf = "u-boot-${MACHINE}.imx"
do_compile_append_colibri-vf() {
    oe_runmake colibri_vf_sdboot_config
    oe_runmake 
}
