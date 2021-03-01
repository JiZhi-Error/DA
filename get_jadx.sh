#! /bin/bash
version=$(wget -qO- -t1 -T2 "https://api.github.com/repos/skylot/jadx/releases/latest" | grep "tag_name" | head -n 1 | awk -F ":" '{print $2}' | sed 's/"//g;s/,//g;s/ //g')
wget --no-check-certificate https://github.com/skylot/jadx/releases/download/${version}/jadx-${version#*v}.zip -O jadx.zip
unzip -d ./jadx/ jadx.zip


if ls *.apk >/dev/null 2>&1;then echo "Find File OK"; else exit; fi