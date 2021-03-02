package com.tencent.mm.pluginsdk.model.app;

import android.net.Uri;

public final class aq {
    public static aq JXv = null;
    public static long JXw = -1;
    public String JXt = "";
    public String[] JXu = null;
    public int code = -1;
    public String[] projection = null;
    public String selection = "";
    public String[] selectionArgs = null;
    public Uri uri = null;

    public aq(Uri uri2, String[] strArr, String str, String[] strArr2, String str2, int i2, String[] strArr3) {
        this.uri = uri2;
        this.projection = strArr;
        this.selection = str;
        this.selectionArgs = strArr2;
        this.JXt = str2;
        this.code = i2;
        this.JXu = strArr3;
    }
}
