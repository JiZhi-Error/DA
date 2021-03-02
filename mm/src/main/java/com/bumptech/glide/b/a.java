package com.bumptech.glide.b;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

public interface a {

    /* renamed from: com.bumptech.glide.b.a$a  reason: collision with other inner class name */
    public interface AbstractC0062a {
        Bitmap a(int i2, int i3, Bitmap.Config config);

        byte[] de(int i2);

        int[] df(int i2);

        void f(Bitmap bitmap);

        void k(byte[] bArr);

        void p(int[] iArr);
    }

    void a(Bitmap.Config config);

    void advance();

    void clear();

    ByteBuffer getData();

    int getFrameCount();

    int of();

    int og();

    void oh();

    int oi();

    Bitmap oj();
}
