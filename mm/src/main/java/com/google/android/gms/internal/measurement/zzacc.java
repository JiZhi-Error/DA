package com.google.android.gms.internal.measurement;

import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzacc {
    private static final Charset ISO_8859_1 = Charset.forName(KindaConfigCacheStg.SAVE_CHARSET);
    protected static final Charset UTF_8 = Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
    public static final Object zzbxg = new Object();

    static {
        AppMethodBeat.i(40301);
        AppMethodBeat.o(40301);
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        AppMethodBeat.i(40294);
        if (iArr != null && iArr.length != 0) {
            boolean equals = Arrays.equals(iArr, iArr2);
            AppMethodBeat.o(40294);
            return equals;
        } else if (iArr2 == null || iArr2.length == 0) {
            AppMethodBeat.o(40294);
            return true;
        } else {
            AppMethodBeat.o(40294);
            return false;
        }
    }

    public static boolean equals(long[] jArr, long[] jArr2) {
        AppMethodBeat.i(40295);
        if (jArr != null && jArr.length != 0) {
            boolean equals = Arrays.equals(jArr, jArr2);
            AppMethodBeat.o(40295);
            return equals;
        } else if (jArr2 == null || jArr2.length == 0) {
            AppMethodBeat.o(40295);
            return true;
        } else {
            AppMethodBeat.o(40295);
            return false;
        }
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        AppMethodBeat.i(40296);
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= length || objArr[i3] != null) {
                int i4 = i2;
                while (i4 < length2 && objArr2[i4] == null) {
                    i4++;
                }
                boolean z = i3 >= length;
                boolean z2 = i4 >= length2;
                if (z && z2) {
                    AppMethodBeat.o(40296);
                    return true;
                } else if (z != z2) {
                    AppMethodBeat.o(40296);
                    return false;
                } else if (!objArr[i3].equals(objArr2[i4])) {
                    AppMethodBeat.o(40296);
                    return false;
                } else {
                    i2 = i4 + 1;
                    i3++;
                }
            } else {
                i3++;
            }
        }
    }

    public static int hashCode(int[] iArr) {
        AppMethodBeat.i(40297);
        if (iArr == null || iArr.length == 0) {
            AppMethodBeat.o(40297);
            return 0;
        }
        int hashCode = Arrays.hashCode(iArr);
        AppMethodBeat.o(40297);
        return hashCode;
    }

    public static int hashCode(long[] jArr) {
        AppMethodBeat.i(40298);
        if (jArr == null || jArr.length == 0) {
            AppMethodBeat.o(40298);
            return 0;
        }
        int hashCode = Arrays.hashCode(jArr);
        AppMethodBeat.o(40298);
        return hashCode;
    }

    public static int hashCode(Object[] objArr) {
        AppMethodBeat.i(40299);
        int length = objArr == null ? 0 : objArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Object obj = objArr[i2];
            i2++;
            i3 = obj != null ? obj.hashCode() + (i3 * 31) : i3;
        }
        AppMethodBeat.o(40299);
        return i3;
    }

    public static void zza(zzaby zzaby, zzaby zzaby2) {
        AppMethodBeat.i(40300);
        if (zzaby.zzbww != null) {
            zzaby2.zzbww = (zzaca) zzaby.zzbww.clone();
        }
        AppMethodBeat.o(40300);
    }
}
