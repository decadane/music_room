#!/usr/bin/env bash

case $1 in
    -local) ./scripts/local_deploy.sh
    ;;
    -dev) scripts/dev_deploy.sh sbc_dev22 45.12.73.17522 902222
    ;;
    *) echo "usage: ./deploy [ -local | -dev ], settings in scripts folder"
    ;;
esac