# Exosense Device Build System
(C) 2013 Feuerlabs, inc

# Introduction
This repository contains the Feuerlabs' build system that generates images with erlang and the Exosense Device stack for various hardware targets.

The build system uses yocto (http://www.yoctoproject.org), and provides the following additions:

1. Erlang.
R15B1 is compiled for the given target.

2. Exosense Device
All Exosense Device components are compiled for the target.

3. Reference Hardware Support
The reference hardware supported by Feuerlabs for the Exosense Device
stack is integrated into the exodev repo. Currently, this is limited
to the SBC6845.

# Further documentation


Yocto quick start

    http://www.yoctoproject.org/docs/1.3/yocto-project-qs/yocto-project-qs.html

Yocto reference manual

    http://www.yoctoproject.org/docs/current/poky-ref-manual/poky-ref-manual.html

Yocto developer's guide

    http://www.yoctoproject.org/docs/current/dev-manual/dev-manual.html


# Directory structure overview

There are five directories that will be referenced throughout the
build. These directories can be placed anywhere in the tree, even
inside each other. However, since directories are each maintained by their own
repositories, it is recommended that they are kept in the same parent
directory. 

1. Yocto [$YOCTO]  
This is the stock Yocto distribution that can generate a linux distro
image for a a wide vaiety of target hardware. It is downloaded from
the Yocto project site and will not change during the build process.

2. Exosense Device [$EXOSENSE]  
This is the extensions to Yocto provided by Feurelabs. Included in
these build instructions is an erlang build as well as rebar and
tetrapak integration, all sourced from Travelping's TPLINO
distribution. Also included is the build instructions for all Exosense
Device components. The directory is checked out from the Feuerlabs
github repo and will not change during the build process.

3. SBC6845 support [$SBC6845] *OPTIONAL*  
This directory adds support for the SBC6845 to Yocto through as BSP
layer. It is checked out from the Feuerlabs github repo and will not
change during the build process.

4. Exosense Device Application Build [$DEMOBUILD]  
Contains build instructions for the application running on top of the
Exosense Device stack. The instructions are usually copied from the
Exosense Device demo application in the Feuerlabs github repo and are
then maintained by the developer. Please note that this directory does
not contain the application code itself, which is downloaded from a
git/svn/http/whatever repo by the Yocto build instructions in
`$DEMOBUILD`

5. Build [$BUILD]  
The directory where the build process is executed. Will swell 20+ GB
during the process. The build directory is created through a yocto
initialization command.  Once created, the template configuration
files in the build directories are updated to reference `$YOCTO`,
`$EXOSENSE`, `$DEMOBUILD`, and possibly `$SBC6845`. The configuration
is also updated to reflect the target hardware and which features
(ssh, graphics, etc) to include in the generated image.


In the subsequent instructions, the following directory structure will
be used as an example

    /home/bob/poky-danny-8.0   # The $YOCTO directory
    /home/bob/meta-exosense    # The $EXOSENSE directory
    /home/bob/meta-exodemo     # The $DEMOBUILD direcotry
    /home/bob/meta-sbc6845     # The $SBC6845 direcotry
    /home/bob/build            # The $BUILD direcotry


# Building the Exosense Device demo application (exodemo).

## Preparation of build system

An Ubuntu 12.04 / 12.10 should be used as a host system. Install the necessary support packages using the following commands.

     $ sudo apt-get install gawk wget git-core diffstat unzip texinfo build-essential chrpath libsdl1.2-dev xterm

Please check the Yocto quick start guide for further details if another host environment is desired.


## Download and install the latest Yocto release

1. Download Yocto 1.3
The URL for this Yocto release is 
        cd /tmp
        wget http://downloads.yoctoproject.org/releases/yocto/yocto-1.3/poky-danny-8.0.tar.bz2
This will download the yocto release to /tmp.

2. Unpack the Yocto release into `$YOCTO`
The downloaded file can be unpacked using the following commands:

        cd /home/bob
        tar xf /tmp/poky-danny-8.0.tar.bz2

This will create the Yocto directory structure under `/home/bob/poky-danny-8.0`.

   
## Download and install the latest Exosense Device release

1. Download Exosense 1.0
Clone the git repository into `$EXOSENSE` with:

        cd /home/bob
        git clone --bare -b 1.0 git@github.com:magnusfeuer/exodev.git

This will create the Yocto directory structure under `/home/bob/exodev`.


## Setup an application build system

1. Download the Exosense Device demo application build layer
Checkout the template application with into `$DEMOBUILD` with:

        git clone --bare git@github.com:magnusfeuer/meta-exodemo.git app
	
The git command creates a Yocto layer under `/home/bob/meta-exodemo` (`$DEMOBUILD`)
containing recipes (build instructions) used to compile and package
the Exosense Device Application. 

Please note that this directory only contains Yocto build instructions
; the actual application code itself is managed by its own repository
that is referenced by the recipes.


## Generate a build directory

The build directory, under which the entire build process takes place,
is created through a yocto script. Please see the Yocto quick start
guide for more information.

Generate the build directory, `$BUILD`, using the following commands:

    cd $YOCTO
    . oe-init-build-env $BUILD
	
This will create the `/home/bob/build/conf` (`$BUILD`) directory containing
two files: `bblayers.conf` and `local.conf`. Once this script has
executed, all builds should be executed from the build directory.

If you are using git, svn, p4, or other version control system, you
should add the `$BUILD` directory and its content to it at this
point. Once the build has started $BUILD will get populated with
additional directories and files that should not be version managed.

## Bind $YOCTO, $EXOSENSE, $SBC6845 and $DEMOBUILD together

All directories to use during the build are specified by
`$BUILD/conf/bblayers.conf` The default file, generated by the
`oe-init-build-env` script, looks like this:

    # LAYER_CONF_VERSION is increased each time build/conf/bblayers.conf
    # changes incompatibly
    LCONF_VERSION = "6"

    BBPATH = "${TOPDIR}"
    BBFILES ?= ""

    BBLAYERS ?= " \
      /home/bob/poky-danny-8.0/meta \
      /home/bob/poky-danny-8.0/meta-yocto \
      /home/bob/poky-danny-8.0/meta-yocto-bsp \
    "

The `$EXOSENSE`, `$DEMOBUILD` and `$SBC6845` directories should be added
to the BBLAYERS entry in bblayers.conf, yielding the following file:

    # LAYER_CONF_VERSION is increased each time build/conf/bblayers.conf
    # changes incompatibly
    LCONF_VERSION = "6"

    BBPATH = "${TOPDIR}"
    BBFILES ?= ""

    BBLAYERS ?= " \
      /home/bob/poky-danny-8.0/meta \
      /home/bob/poky-danny-8.0/meta-yocto \
      /home/bob/poky-danny-8.0/meta-yocto-bsp \
      /home/bob/meta-exosense \
      /home/bob/meta-sbc6845 \
      /home/bob/meta-exodemo \
    "

If the SBC6845 is not to be used by the app, the `/home/bob/meta-sbc6845 \` line can be omitted.

## Configure the target image features

The setup of the target image, to be flashed to the device, is
specified by `$BUILD/conf/local.conf`.

The default file, generated by the `oe-init-build-env` script,
contains several entries. Please see the comments of the file for
details.

### BB\_NUMBER_THREADS
This entry specifies how many threads to be used during a
build. Uncomment this and set this to the number of cores that the
host system has:

    BB_NUMBER_THREADS = "8"

### PARALLEL_MAKE
This entry is provided as an argument to make to specify the number of
parallel compiles to run. Uncomment and set to the number of cores
that the hos system has.
	
    PARALLEL_MAKE = "-j 8"

### MACHINE
This entry specifies the target machine (and its architecture) to
generate the image for. See the Yocto Developer's Guide for more
information on this. Set this entry to the target machine:

    MACHINE ??= "sbc6845"

### IMAGE_INSTALL_append
This entry specifies additional packages (generated from recipes), to
include in the image. No default is created in the `local.conf`
file. Add the following line anywhere in `local.conf` to include the
Exosense Device demo application built by the recipes located under
`$DEMOBUILD`.

    IMAGE_INSTALL_append = " erlang-exodemo"


### EXTRA_IMAGE_FEAUTURES

The image built by the `bitbake core-image-minimal` command below is a
barebone distribution.

To add ssh-access, add `ssh-dropbear-server` to the list specified by
`EXTRA_IMAGE_FEATURES`:

    EXTRA_IMAGE_FEATURES = "debug-tweaks ssh-server-dropbear"


## Build the image

Ensure that the oe-build-env script has been executed

    cd $YOCTO
    . oe-init-build-env $BUILD

Since the `$BUILD` directory already exists, the script will only
setup the environment and `cd` to it.

An image is generated using

    bitbake core-image-minimal

See the Yocto quick start guide for a primer on the various images
available. Please note that `$BUILD/conf/local.conf` can be updated to
add features and packages. 


