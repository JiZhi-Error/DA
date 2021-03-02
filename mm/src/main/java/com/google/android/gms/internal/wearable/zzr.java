package com.google.android.gms.internal.wearable;

import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzr {
    private static final Charset ISO_8859_1 = Charset.forName(KindaConfigCacheStg.SAVE_CHARSET);
    protected static final Charset UTF_8 = Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
    public static final Object zzhk = new Object();

    static {
        AppMethodBeat.i(100758);
        AppMethodBeat.o(100758);
    }

    public static boolean equals(float[] fArr, float[] fArr2) {
        AppMethodBeat.i(100752);
        if (fArr != null && fArr.length != 0) {
            boolean equals = Arrays.equals(fArr, fArr2);
            AppMethodBeat.o(100752);
            return equals;
        } else if (fArr2 == null || fArr2.length == 0) {
            AppMethodBeat.o(100752);
            return true;
        } else {
            AppMethodBeat.o(100752);
            return false;
        }
    }

    public static boolean equals(long[] jArr, long[] jArr2) {
        AppMethodBeat.i(100751);
        if (jArr != null && jArr.length != 0) {
            boolean equals = Arrays.equals(jArr, jArr2);
            AppMethodBeat.o(100751);
            return equals;
        } else if (jArr2 == null || jArr2.length == 0) {
            AppMethodBeat.o(100751);
            return true;
        } else {
            AppMethodBeat.o(100751);
            return false;
        }
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        AppMethodBeat.i(100753);
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
                    AppMethodBeat.o(100753);
                    return true;
                } else if (z != z2) {
                    AppMethodBeat.o(100753);
                    return false;
                } else if (!objArr[i3].equals(objArr2[i4])) {
                    AppMethodBeat.o(100753);
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

    public static int hashCode(float[] fArr) {
        AppMethodBeat.i(100755);
        if (fArr == null || fArr.length == 0) {
            AppMethodBeat.o(100755);
            return 0;
        }
        int hashCode = Arrays.hashCode(fArr);
        AppMethodBeat.o(100755);
        return hashCode;
    }

    public static int hashCode(long[] jArr) {
        AppMethodBeat.i(100754);
        if (jArr == null || jArr.length == 0) {
            AppMethodBeat.o(100754);
            return 0;
        }
        int hashCode = Arrays.hashCode(jArr);
        AppMethodBeat.o(100754);
        return hashCode;
    }

    public static int hashCode(Object[] objArr) {
        AppMethodBeat.i(100756);
        int length = objArr == null ? 0 : objArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Object obj = objArr[i2];
            i2++;
            i3 = obj != null ? obj.hashCode() + (i3 * 31) : i3;
        }
        AppMethodBeat.o(100756);
        return i3;
    }

    public static void zza(zzn zzn, zzn zzn2) {
        AppMethodBeat.i(100757);
        if (zzn.zzhc != null) {
            zzn2.zzhc = (zzp) zzn.zzhc.clone();
        }
        AppMethodBeat.o(100757);
    }
}
