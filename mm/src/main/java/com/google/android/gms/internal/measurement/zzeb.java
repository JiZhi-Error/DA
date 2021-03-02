package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.biometric.FaceManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* access modifiers changed from: package-private */
public final class zzeb extends zzjq {
    zzeb(zzjr zzjr) {
        super(zzjr);
    }

    private final Boolean zza(double d2, zzkg zzkg) {
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_BRIGHT);
        try {
            Boolean zza = zza(new BigDecimal(d2), zzkg, Math.ulp(d2));
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_BRIGHT);
            return zza;
        } catch (NumberFormatException e2) {
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_BRIGHT);
            return null;
        }
    }

    private final Boolean zza(long j2, zzkg zzkg) {
        AppMethodBeat.i(1111);
        try {
            Boolean zza = zza(new BigDecimal(j2), zzkg, 0.0d);
            AppMethodBeat.o(1111);
            return zza;
        } catch (NumberFormatException e2) {
            AppMethodBeat.o(1111);
            return null;
        }
    }

    @VisibleForTesting
    private static Boolean zza(Boolean bool, boolean z) {
        AppMethodBeat.i(1108);
        if (bool == null) {
            AppMethodBeat.o(1108);
            return null;
        }
        Boolean valueOf = Boolean.valueOf(bool.booleanValue() ^ z);
        AppMethodBeat.o(1108);
        return valueOf;
    }

    private final Boolean zza(String str, int i2, boolean z, String str2, List<String> list, String str3) {
        AppMethodBeat.i(1110);
        if (str == null) {
            AppMethodBeat.o(1110);
            return null;
        }
        if (i2 == 6) {
            if (list == null || list.size() == 0) {
                AppMethodBeat.o(1110);
                return null;
            }
        } else if (str2 == null) {
            AppMethodBeat.o(1110);
            return null;
        }
        if (!z && i2 != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i2) {
            case 1:
                try {
                    Boolean valueOf = Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                    AppMethodBeat.o(1110);
                    return valueOf;
                } catch (PatternSyntaxException e2) {
                    zzge().zzip().zzg("Invalid regular expression in REGEXP audience filter. expression", str3);
                    AppMethodBeat.o(1110);
                    return null;
                }
            case 2:
                Boolean valueOf2 = Boolean.valueOf(str.startsWith(str2));
                AppMethodBeat.o(1110);
                return valueOf2;
            case 3:
                Boolean valueOf3 = Boolean.valueOf(str.endsWith(str2));
                AppMethodBeat.o(1110);
                return valueOf3;
            case 4:
                Boolean valueOf4 = Boolean.valueOf(str.contains(str2));
                AppMethodBeat.o(1110);
                return valueOf4;
            case 5:
                Boolean valueOf5 = Boolean.valueOf(str.equals(str2));
                AppMethodBeat.o(1110);
                return valueOf5;
            case 6:
                Boolean valueOf6 = Boolean.valueOf(list.contains(str));
                AppMethodBeat.o(1110);
                return valueOf6;
            default:
                AppMethodBeat.o(1110);
                return null;
        }
    }

    private final Boolean zza(String str, zzkg zzkg) {
        Boolean bool = null;
        AppMethodBeat.i(FaceManager.FACE_ACQUIRED_LEFT);
        if (!zzka.zzck(str)) {
            AppMethodBeat.o(FaceManager.FACE_ACQUIRED_LEFT);
        } else {
            try {
                bool = zza(new BigDecimal(str), zzkg, 0.0d);
                AppMethodBeat.o(FaceManager.FACE_ACQUIRED_LEFT);
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(FaceManager.FACE_ACQUIRED_LEFT);
            }
        }
        return bool;
    }

    @VisibleForTesting
    private final Boolean zza(String str, zzki zzki) {
        List<String> arrayList;
        String str2 = null;
        AppMethodBeat.i(1109);
        Preconditions.checkNotNull(zzki);
        if (str == null) {
            AppMethodBeat.o(1109);
            return null;
        } else if (zzki.zzash == null || zzki.zzash.intValue() == 0) {
            AppMethodBeat.o(1109);
            return null;
        } else {
            if (zzki.zzash.intValue() == 6) {
                if (zzki.zzask == null || zzki.zzask.length == 0) {
                    AppMethodBeat.o(1109);
                    return null;
                }
            } else if (zzki.zzasi == null) {
                AppMethodBeat.o(1109);
                return null;
            }
            int intValue = zzki.zzash.intValue();
            boolean z = zzki.zzasj != null && zzki.zzasj.booleanValue();
            String upperCase = (z || intValue == 1 || intValue == 6) ? zzki.zzasi : zzki.zzasi.toUpperCase(Locale.ENGLISH);
            if (zzki.zzask == null) {
                arrayList = null;
            } else {
                String[] strArr = zzki.zzask;
                if (z) {
                    arrayList = Arrays.asList(strArr);
                } else {
                    arrayList = new ArrayList<>();
                    for (String str3 : strArr) {
                        arrayList.add(str3.toUpperCase(Locale.ENGLISH));
                    }
                }
            }
            if (intValue == 1) {
                str2 = upperCase;
            }
            Boolean zza = zza(str, intValue, z, upperCase, arrayList, str2);
            AppMethodBeat.o(1109);
            return zza;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009c, code lost:
        if (r5 != null) goto L_0x009e;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean zza(java.math.BigDecimal r10, com.google.android.gms.internal.measurement.zzkg r11, double r12) {
        /*
        // Method dump skipped, instructions count: 320
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeb.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzkg, double):java.lang.Boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0477  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0481  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0774  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0777  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0be2  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02b8  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0355  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzkm[] zza(java.lang.String r37, com.google.android.gms.internal.measurement.zzkn[] r38, com.google.android.gms.internal.measurement.zzks[] r39) {
        /*
        // Method dump skipped, instructions count: 3048
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeb.zza(java.lang.String, com.google.android.gms.internal.measurement.zzkn[], com.google.android.gms.internal.measurement.zzks[]):com.google.android.gms.internal.measurement.zzkm[]");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzjq
    public final boolean zzhf() {
        return false;
    }
}
