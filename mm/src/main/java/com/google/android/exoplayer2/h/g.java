package com.google.android.exoplayer2.h;

import android.net.Uri;

public interface g {

    public interface a {
        g wG();
    }

    long a(j jVar);

    void close();

    Uri getUri();

    int read(byte[] bArr, int i2, int i3);
}
