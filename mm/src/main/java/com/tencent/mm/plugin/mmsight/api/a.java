package com.tencent.mm.plugin.mmsight.api;

import android.graphics.Bitmap;

public abstract class a {
    public static b zsW = null;

    /* renamed from: com.tencent.mm.plugin.mmsight.api.a$a  reason: collision with other inner class name */
    public interface AbstractC1479a {
        Bitmap ejs();
    }

    public interface b {
        a a(int i2, String str, String str2, int i3, int i4, int i5, int i6, int i7, int i8);

        a a(int i2, String str, String str2, int i3, int i4, int i5, int i6, long j2, long j3, int i7, int i8);

        a a(String str, String str2, int i2, int i3, int i4, int i5, int i6, int i7);

        a a(String str, String str2, int i2, int i3, int i4, int i5, long j2, long j3, int i6, int i7);
    }

    public abstract void D(Bitmap bitmap);

    public abstract int aMG();

    public abstract int getType();
}
