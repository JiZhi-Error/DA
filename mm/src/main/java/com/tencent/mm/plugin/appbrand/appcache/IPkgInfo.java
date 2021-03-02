package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcelable;

public interface IPkgInfo extends Parcelable {
    long lastModified();

    String pkgPath();

    int pkgVersion();
}
