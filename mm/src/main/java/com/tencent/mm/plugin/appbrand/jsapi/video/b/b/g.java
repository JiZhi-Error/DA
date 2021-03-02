package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a;

public final class g {
    public final long bEP;
    public final int flags;
    public final String key;
    public final long length;
    public final long position;
    public final int priority;
    public final Uri uri;
    public final String uuid;

    public g(Uri uri2, long j2) {
        this(uri2, j2, j2, -1, null, 0, null, -1);
        AppMethodBeat.i(234723);
        AppMethodBeat.o(234723);
    }

    public g(Uri uri2, long j2, long j3, long j4, String str, int i2, String str2, int i3) {
        AppMethodBeat.i(234724);
        try {
            a.checkArgument(j2 >= 0);
            a.checkArgument(j3 >= 0);
            a.checkArgument(j4 > 0 || j4 == -1);
            this.uri = uri2;
            this.bEP = j2;
            this.position = j3;
            this.length = j4;
            this.key = str;
            this.flags = i2;
            this.uuid = str2;
            this.priority = i3;
            AppMethodBeat.o(234724);
        } catch (IllegalArgumentException e2) {
            m mVar = new m(e2);
            AppMethodBeat.o(234724);
            throw mVar;
        }
    }

    public final String toString() {
        AppMethodBeat.i(234725);
        String str = "DataSpec[uri=" + this.uri + ", absPos=" + this.bEP + ", pos=" + this.position + ", len=" + this.length + ", key=" + this.key + ", flags=" + this.flags + ", uuid=" + this.uuid + "]";
        AppMethodBeat.o(234725);
        return str;
    }
}
