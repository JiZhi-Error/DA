package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzjz {
    final String name;
    final String origin;
    final Object value;
    final long zzaqz;
    final String zzti;

    zzjz(String str, String str2, String str3, long j2, Object obj) {
        AppMethodBeat.i(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(obj);
        this.zzti = str;
        this.origin = str2;
        this.name = str3;
        this.zzaqz = j2;
        this.value = obj;
        AppMethodBeat.o(TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES);
    }
}
