package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URL;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzfo implements Runnable {
    private final String packageName;
    private final URL url;
    private final byte[] zzajl;
    private final zzfm zzajm;
    private final Map<String, String> zzajn;
    private final /* synthetic */ zzfk zzajo;

    public zzfo(zzfk zzfk, String str, URL url2, byte[] bArr, Map<String, String> map, zzfm zzfm) {
        this.zzajo = zzfk;
        AppMethodBeat.i(1455);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url2);
        Preconditions.checkNotNull(zzfm);
        this.url = url2;
        this.zzajl = bArr;
        this.zzajm = zzfm;
        this.packageName = str;
        this.zzajn = map;
        AppMethodBeat.o(1455);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045 A[SYNTHETIC, Splitter:B:13:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f2 A[SYNTHETIC, Splitter:B:34:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 332
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfo.run():void");
    }
}
