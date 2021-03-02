package com.google.android.gms.internal.measurement;

import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzzr {
    private static final Charset ISO_8859_1 = Charset.forName(KindaConfigCacheStg.SAVE_CHARSET);
    static final Charset UTF_8 = Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
    public static final byte[] zzbsq;
    private static final ByteBuffer zzbsr;
    private static final zzze zzbss;

    static {
        AppMethodBeat.i(40377);
        byte[] bArr = new byte[0];
        zzbsq = bArr;
        zzbsr = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzbsq;
        zzbss = zzze.zza(bArr2, 0, bArr2.length, false);
        AppMethodBeat.o(40377);
    }

    static <T> T checkNotNull(T t) {
        AppMethodBeat.i(40375);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException();
            AppMethodBeat.o(40375);
            throw nullPointerException;
        }
        AppMethodBeat.o(40375);
        return t;
    }

    static int zza(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    static <T> T zza(T t, String str) {
        AppMethodBeat.i(40376);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException(str);
            AppMethodBeat.o(40376);
            throw nullPointerException;
        }
        AppMethodBeat.o(40376);
        return t;
    }
}
