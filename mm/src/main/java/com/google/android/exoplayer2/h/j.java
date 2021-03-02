package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class j {
    public final byte[] bEO;
    public final long bEP;
    public final int flags;
    public final String key;
    public final long length;
    public final long position;
    public final Uri uri;

    public j(Uri uri2) {
        this(uri2, 0);
    }

    public j(Uri uri2, int i2) {
        this(uri2, 0, -1, null, i2);
    }

    public j(Uri uri2, long j2, long j3, String str) {
        this(uri2, j2, j2, j3, str, 0);
        AppMethodBeat.i(93043);
        AppMethodBeat.o(93043);
    }

    public j(Uri uri2, long j2, long j3, String str, int i2) {
        this(uri2, j2, j2, j3, str, i2);
        AppMethodBeat.i(93044);
        AppMethodBeat.o(93044);
    }

    public j(Uri uri2, long j2, long j3, long j4, String str, int i2) {
        this(uri2, null, j2, j3, j4, str, i2);
    }

    public j(Uri uri2, byte[] bArr, long j2, long j3, long j4, String str, int i2) {
        AppMethodBeat.i(93045);
        a.checkArgument(j2 >= 0);
        a.checkArgument(j3 >= 0);
        a.checkArgument(j4 > 0 || j4 == -1);
        this.uri = uri2;
        this.bEO = bArr;
        this.bEP = j2;
        this.position = j3;
        this.length = j4;
        this.key = str;
        this.flags = i2;
        AppMethodBeat.o(93045);
    }

    public final boolean eW(int i2) {
        return (this.flags & i2) == i2;
    }

    public final String toString() {
        AppMethodBeat.i(93046);
        String str = "DataSpec[" + this.uri + ", " + Arrays.toString(this.bEO) + ", " + this.bEP + ", " + this.position + ", " + this.length + ", " + this.key + ", " + this.flags + "]";
        AppMethodBeat.o(93046);
        return str;
    }

    public final j al(long j2) {
        long j3 = -1;
        AppMethodBeat.i(93047);
        if (this.length != -1) {
            j3 = this.length - j2;
        }
        j j4 = j(j2, j3);
        AppMethodBeat.o(93047);
        return j4;
    }

    private j j(long j2, long j3) {
        AppMethodBeat.i(93048);
        if (j2 == 0 && this.length == j3) {
            AppMethodBeat.o(93048);
            return this;
        }
        j jVar = new j(this.uri, this.bEO, this.bEP + j2, this.position + j2, j3, this.key, this.flags);
        AppMethodBeat.o(93048);
        return jVar;
    }
}
