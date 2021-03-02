package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

public final class zzka extends zzhh {
    private static final String[] zzard = {"firebase_", "google_", "ga_"};
    private SecureRandom zzare;
    private final AtomicLong zzarf = new AtomicLong(0);
    private int zzarg;
    private Integer zzarh = null;

    zzka(zzgl zzgl) {
        super(zzgl);
        AppMethodBeat.i(TXLiteAVCode.EVT_HW_DECODER_START_SUCC);
        AppMethodBeat.o(TXLiteAVCode.EVT_HW_DECODER_START_SUCC);
    }

    static MessageDigest getMessageDigest(String str) {
        AppMethodBeat.i(2054);
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    AppMethodBeat.o(2054);
                    return instance;
                }
            } catch (NoSuchAlgorithmException e2) {
            }
        }
        AppMethodBeat.o(2054);
        return null;
    }

    public static zzko zza(zzkn zzkn, String str) {
        AppMethodBeat.i(2066);
        zzko[] zzkoArr = zzkn.zzata;
        for (zzko zzko : zzkoArr) {
            if (zzko.name.equals(str)) {
                AppMethodBeat.o(2066);
                return zzko;
            }
        }
        AppMethodBeat.o(2066);
        return null;
    }

    private static Object zza(int i2, Object obj, boolean z) {
        AppMethodBeat.i(2037);
        if (obj == null) {
            AppMethodBeat.o(2037);
            return null;
        } else if ((obj instanceof Long) || (obj instanceof Double)) {
            AppMethodBeat.o(2037);
            return obj;
        } else if (obj instanceof Integer) {
            Long valueOf = Long.valueOf((long) ((Integer) obj).intValue());
            AppMethodBeat.o(2037);
            return valueOf;
        } else if (obj instanceof Byte) {
            Long valueOf2 = Long.valueOf((long) ((Byte) obj).byteValue());
            AppMethodBeat.o(2037);
            return valueOf2;
        } else if (obj instanceof Short) {
            Long valueOf3 = Long.valueOf((long) ((Short) obj).shortValue());
            AppMethodBeat.o(2037);
            return valueOf3;
        } else if (obj instanceof Boolean) {
            Long valueOf4 = Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
            AppMethodBeat.o(2037);
            return valueOf4;
        } else if (obj instanceof Float) {
            Double valueOf5 = Double.valueOf(((Float) obj).doubleValue());
            AppMethodBeat.o(2037);
            return valueOf5;
        } else if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String zza = zza(String.valueOf(obj), i2, z);
            AppMethodBeat.o(2037);
            return zza;
        } else {
            AppMethodBeat.o(2037);
            return null;
        }
    }

    public static String zza(String str, int i2, boolean z) {
        AppMethodBeat.i(2038);
        if (str.codePointCount(0, str.length()) <= i2) {
            AppMethodBeat.o(2038);
            return str;
        } else if (z) {
            String concat = String.valueOf(str.substring(0, str.offsetByCodePoints(0, i2))).concat("...");
            AppMethodBeat.o(2038);
            return concat;
        } else {
            AppMethodBeat.o(2038);
            return null;
        }
    }

    public static String zza(String str, String[] strArr, String[] strArr2) {
        AppMethodBeat.i(2077);
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i2 = 0; i2 < min; i2++) {
            if (zzs(str, strArr[i2])) {
                String str2 = strArr2[i2];
                AppMethodBeat.o(2077);
                return str2;
            }
        }
        AppMethodBeat.o(2077);
        return null;
    }

    private static void zza(Bundle bundle, Object obj) {
        AppMethodBeat.i(2043);
        Preconditions.checkNotNull(bundle);
        if (obj != null && ((obj instanceof String) || (obj instanceof CharSequence))) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
        AppMethodBeat.o(2043);
    }

    private static boolean zza(Bundle bundle, int i2) {
        AppMethodBeat.i(2042);
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", (long) i2);
            AppMethodBeat.o(2042);
            return true;
        }
        AppMethodBeat.o(2042);
        return false;
    }

    private final boolean zza(String str, String str2, int i2, Object obj, boolean z) {
        AppMethodBeat.i(2035);
        if (obj == null) {
            AppMethodBeat.o(2035);
            return true;
        } else if ((obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            AppMethodBeat.o(2035);
            return true;
        } else if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i2) {
                zzge().zzip().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                AppMethodBeat.o(2035);
                return false;
            }
            AppMethodBeat.o(2035);
            return true;
        } else if ((obj instanceof Bundle) && z) {
            AppMethodBeat.o(2035);
            return true;
        } else if ((obj instanceof Parcelable[]) && z) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            for (Parcelable parcelable : parcelableArr) {
                if (!(parcelable instanceof Bundle)) {
                    zzge().zzip().zze("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str2);
                    AppMethodBeat.o(2035);
                    return false;
                }
            }
            AppMethodBeat.o(2035);
            return true;
        } else if (!(obj instanceof ArrayList) || !z) {
            AppMethodBeat.o(2035);
            return false;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList.get(i3);
                i3++;
                if (!(obj2 instanceof Bundle)) {
                    zzge().zzip().zze("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                    AppMethodBeat.o(2035);
                    return false;
                }
            }
            AppMethodBeat.o(2035);
            return true;
        }
    }

    public static boolean zza(long[] jArr, int i2) {
        return i2 < (jArr.length << 6) && (jArr[i2 / 64] & (1 << (i2 % 64))) != 0;
    }

    static byte[] zza(Parcelable parcelable) {
        AppMethodBeat.i(2075);
        if (parcelable == null) {
            AppMethodBeat.o(2075);
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
            AppMethodBeat.o(2075);
        }
    }

    public static long[] zza(BitSet bitSet) {
        AppMethodBeat.i(2062);
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i2 = 0;
        while (i2 < length) {
            jArr[i2] = 0;
            int i3 = 0;
            while (i3 < 64 && (i2 << 6) + i3 < bitSet.length()) {
                if (bitSet.get((i2 << 6) + i3)) {
                    jArr[i2] = jArr[i2] | (1 << i3);
                }
                i3++;
            }
            i2++;
        }
        AppMethodBeat.o(2062);
        return jArr;
    }

    static zzko[] zza(zzko[] zzkoArr, String str, Object obj) {
        AppMethodBeat.i(2068);
        for (zzko zzko : zzkoArr) {
            if (str.equals(zzko.name)) {
                zzko.zzate = null;
                zzko.zzajf = null;
                zzko.zzarc = null;
                if (obj instanceof Long) {
                    zzko.zzate = (Long) obj;
                } else if (obj instanceof String) {
                    zzko.zzajf = (String) obj;
                } else if (obj instanceof Double) {
                    zzko.zzarc = (Double) obj;
                }
                AppMethodBeat.o(2068);
                return zzkoArr;
            }
        }
        zzko[] zzkoArr2 = new zzko[(zzkoArr.length + 1)];
        System.arraycopy(zzkoArr, 0, zzkoArr2, 0, zzkoArr.length);
        zzko zzko2 = new zzko();
        zzko2.name = str;
        if (obj instanceof Long) {
            zzko2.zzate = (Long) obj;
        } else if (obj instanceof String) {
            zzko2.zzajf = (String) obj;
        } else if (obj instanceof Double) {
            zzko2.zzarc = (Double) obj;
        }
        zzkoArr2[zzkoArr.length] = zzko2;
        AppMethodBeat.o(2068);
        return zzkoArr2;
    }

    public static Object zzb(zzkn zzkn, String str) {
        AppMethodBeat.i(2067);
        zzko zza = zza(zzkn, str);
        if (zza != null) {
            if (zza.zzajf != null) {
                String str2 = zza.zzajf;
                AppMethodBeat.o(2067);
                return str2;
            } else if (zza.zzate != null) {
                Long l = zza.zzate;
                AppMethodBeat.o(2067);
                return l;
            } else if (zza.zzarc != null) {
                Double d2 = zza.zzarc;
                AppMethodBeat.o(2067);
                return d2;
            }
        }
        AppMethodBeat.o(2067);
        return null;
    }

    @VisibleForTesting
    static long zzc(byte[] bArr) {
        int i2 = 0;
        AppMethodBeat.i(2055);
        Preconditions.checkNotNull(bArr);
        Preconditions.checkState(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << i2;
            i2 += 8;
            length--;
        }
        AppMethodBeat.o(2055);
        return j2;
    }

    public static boolean zzc(Context context, String str) {
        AppMethodBeat.i(2058);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                AppMethodBeat.o(2058);
                return false;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0);
            if (serviceInfo != null && serviceInfo.enabled) {
                AppMethodBeat.o(2058);
                return true;
            }
            AppMethodBeat.o(2058);
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
        }
    }

    static boolean zzcc(String str) {
        AppMethodBeat.i(TXLiteAVCode.EVT_AUDIO_JITTER_STATE_PLAYING);
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            AppMethodBeat.o(TXLiteAVCode.EVT_AUDIO_JITTER_STATE_PLAYING);
            return true;
        }
        AppMethodBeat.o(TXLiteAVCode.EVT_AUDIO_JITTER_STATE_PLAYING);
        return false;
    }

    private static int zzch(String str) {
        AppMethodBeat.i(2044);
        if ("_ldl".equals(str)) {
            AppMethodBeat.o(2044);
            return 2048;
        } else if ("_id".equals(str)) {
            AppMethodBeat.o(2044);
            return 256;
        } else {
            AppMethodBeat.o(2044);
            return 36;
        }
    }

    public static boolean zzci(String str) {
        AppMethodBeat.i(2060);
        if (TextUtils.isEmpty(str) || !str.startsWith("_")) {
            AppMethodBeat.o(2060);
            return false;
        }
        AppMethodBeat.o(2060);
        return true;
    }

    static boolean zzck(String str) {
        AppMethodBeat.i(2064);
        if (str == null || !str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") || str.length() > 310) {
            AppMethodBeat.o(2064);
            return false;
        }
        AppMethodBeat.o(2064);
        return true;
    }

    static boolean zzcl(String str) {
        AppMethodBeat.i(2073);
        Preconditions.checkNotEmpty(str);
        char c2 = 65535;
        switch (str.hashCode()) {
            case 94660:
                if (str.equals("_in")) {
                    c2 = 0;
                    break;
                }
                break;
            case 95025:
                if (str.equals("_ug")) {
                    c2 = 2;
                    break;
                }
                break;
            case 95027:
                if (str.equals("_ui")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
                AppMethodBeat.o(2073);
                return true;
            default:
                AppMethodBeat.o(2073);
                return false;
        }
    }

    public static boolean zzd(Intent intent) {
        AppMethodBeat.i(TXLiteAVCode.EVT_MIC_START_SUCC);
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) {
            AppMethodBeat.o(TXLiteAVCode.EVT_MIC_START_SUCC);
            return true;
        }
        AppMethodBeat.o(TXLiteAVCode.EVT_MIC_START_SUCC);
        return false;
    }

    static boolean zzd(zzeu zzeu, zzdz zzdz) {
        AppMethodBeat.i(2072);
        Preconditions.checkNotNull(zzeu);
        Preconditions.checkNotNull(zzdz);
        if (TextUtils.isEmpty(zzdz.zzadm)) {
            AppMethodBeat.o(2072);
            return false;
        }
        AppMethodBeat.o(2072);
        return true;
    }

    @VisibleForTesting
    private final boolean zze(Context context, String str) {
        AppMethodBeat.i(2071);
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                boolean equals = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
                AppMethodBeat.o(2071);
                return equals;
            }
        } catch (CertificateException e2) {
            zzge().zzim().zzg("Error obtaining certificate", e2);
        } catch (PackageManager.NameNotFoundException e3) {
            zzge().zzim().zzg("Package name not found", e3);
        }
        AppMethodBeat.o(2071);
        return true;
    }

    public static Bundle[] zze(Object obj) {
        AppMethodBeat.i(2040);
        if (obj instanceof Bundle) {
            Bundle[] bundleArr = {(Bundle) obj};
            AppMethodBeat.o(2040);
            return bundleArr;
        } else if (obj instanceof Parcelable[]) {
            Bundle[] bundleArr2 = (Bundle[]) Arrays.copyOf((Parcelable[]) obj, ((Parcelable[]) obj).length, Bundle[].class);
            AppMethodBeat.o(2040);
            return bundleArr2;
        } else if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            Bundle[] bundleArr3 = (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
            AppMethodBeat.o(2040);
            return bundleArr3;
        } else {
            AppMethodBeat.o(2040);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object zzf(java.lang.Object r6) {
        /*
            r0 = 0
            r5 = 2076(0x81c, float:2.909E-42)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            if (r6 != 0) goto L_0x000c
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x000b:
            return r0
        L_0x000c:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0039 }
            r1.<init>()     // Catch:{ all -> 0x0039 }
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0039 }
            r3.<init>(r1)     // Catch:{ all -> 0x0039 }
            r3.writeObject(r6)     // Catch:{ all -> 0x0053 }
            r3.flush()     // Catch:{ all -> 0x0053 }
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ all -> 0x0053 }
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0053 }
            byte[] r1 = r1.toByteArray()     // Catch:{ all -> 0x0053 }
            r4.<init>(r1)     // Catch:{ all -> 0x0053 }
            r2.<init>(r4)     // Catch:{ all -> 0x0053 }
            java.lang.Object r1 = r2.readObject()     // Catch:{ all -> 0x0056 }
            r3.close()     // Catch:{ IOException -> 0x004c, ClassNotFoundException -> 0x0051 }
            r2.close()     // Catch:{ IOException -> 0x004c, ClassNotFoundException -> 0x0051 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            r0 = r1
            goto L_0x000b
        L_0x0039:
            r1 = move-exception
            r2 = r0
            r3 = r0
        L_0x003c:
            if (r3 == 0) goto L_0x0041
            r3.close()
        L_0x0041:
            if (r2 == 0) goto L_0x0046
            r2.close()
        L_0x0046:
            r2 = 2076(0x81c, float:2.909E-42)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r1
        L_0x004c:
            r1 = move-exception
        L_0x004d:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x000b
        L_0x0051:
            r1 = move-exception
            goto L_0x004d
        L_0x0053:
            r1 = move-exception
            r2 = r0
            goto L_0x003c
        L_0x0056:
            r1 = move-exception
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzka.zzf(java.lang.Object):java.lang.Object");
    }

    private final boolean zzr(String str, String str2) {
        AppMethodBeat.i(TXLiteAVCode.EVT_MIC_RELEASE_SUCC);
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            AppMethodBeat.o(TXLiteAVCode.EVT_MIC_RELEASE_SUCC);
            return false;
        } else if (str2.length() == 0) {
            zzge().zzim().zzg("Name is required and can't be empty. Type", str);
            AppMethodBeat.o(TXLiteAVCode.EVT_MIC_RELEASE_SUCC);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        zzge().zzim().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        AppMethodBeat.o(TXLiteAVCode.EVT_MIC_RELEASE_SUCC);
                        return false;
                    }
                }
                AppMethodBeat.o(TXLiteAVCode.EVT_MIC_RELEASE_SUCC);
                return true;
            }
            zzge().zzim().zze("Name must start with a letter or _ (underscore). Type, name", str, str2);
            AppMethodBeat.o(TXLiteAVCode.EVT_MIC_RELEASE_SUCC);
            return false;
        }
    }

    public static boolean zzs(String str, String str2) {
        AppMethodBeat.i(2061);
        if (str == null && str2 == null) {
            AppMethodBeat.o(2061);
            return true;
        } else if (str == null) {
            AppMethodBeat.o(2061);
            return false;
        } else {
            boolean equals = str.equals(str2);
            AppMethodBeat.o(2061);
            return equals;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Context getContext() {
        AppMethodBeat.i(2089);
        Context context = super.getContext();
        AppMethodBeat.o(2089);
        return context;
    }

    public final Bundle zza(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        Bundle bundle = null;
        AppMethodBeat.i(TXLiteAVCode.EVT_AUDIO_JITTER_STATE_FIRST_PLAY);
        if (uri == null) {
            AppMethodBeat.o(TXLiteAVCode.EVT_AUDIO_JITTER_STATE_FIRST_PLAY);
        } else {
            try {
                if (uri.isHierarchical()) {
                    str4 = uri.getQueryParameter("utm_campaign");
                    str3 = uri.getQueryParameter("utm_source");
                    str2 = uri.getQueryParameter("utm_medium");
                    str = uri.getQueryParameter("gclid");
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                }
                if (!TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str3) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
                    bundle = new Bundle();
                    if (!TextUtils.isEmpty(str4)) {
                        bundle.putString(FirebaseAnalytics.b.CAMPAIGN, str4);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        bundle.putString("source", str3);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        bundle.putString(FirebaseAnalytics.b.MEDIUM, str2);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        bundle.putString("gclid", str);
                    }
                    String queryParameter = uri.getQueryParameter("utm_term");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        bundle.putString(FirebaseAnalytics.b.TERM, queryParameter);
                    }
                    String queryParameter2 = uri.getQueryParameter("utm_content");
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        bundle.putString("content", queryParameter2);
                    }
                    String queryParameter3 = uri.getQueryParameter(FirebaseAnalytics.b.ACLID);
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        bundle.putString(FirebaseAnalytics.b.ACLID, queryParameter3);
                    }
                    String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.b.CP1);
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString(FirebaseAnalytics.b.CP1, queryParameter4);
                    }
                    String queryParameter5 = uri.getQueryParameter("anid");
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        bundle.putString("anid", queryParameter5);
                    }
                    AppMethodBeat.o(TXLiteAVCode.EVT_AUDIO_JITTER_STATE_FIRST_PLAY);
                } else {
                    AppMethodBeat.o(TXLiteAVCode.EVT_AUDIO_JITTER_STATE_FIRST_PLAY);
                }
            } catch (UnsupportedOperationException e2) {
                zzge().zzip().zzg("Install referrer url isn't a hierarchical URI", e2);
                AppMethodBeat.o(TXLiteAVCode.EVT_AUDIO_JITTER_STATE_FIRST_PLAY);
            }
        }
        return bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0182  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zza(java.lang.String r10, android.os.Bundle r11, java.util.List<java.lang.String> r12, boolean r13, boolean r14) {
        /*
        // Method dump skipped, instructions count: 397
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, android.os.Bundle, java.util.List, boolean, boolean):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    public final <T extends Parcelable> T zza(byte[] bArr, Parcelable.Creator<T> creator) {
        AppMethodBeat.i(2074);
        if (bArr == null) {
            AppMethodBeat.o(2074);
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return creator.createFromParcel(obtain);
        } catch (SafeParcelReader.ParseException e2) {
            zzge().zzim().log("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
            AppMethodBeat.o(2074);
        }
    }

    /* access modifiers changed from: package-private */
    public final zzeu zza(String str, Bundle bundle, String str2, long j2, boolean z, boolean z2) {
        AppMethodBeat.i(2069);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(2069);
            return null;
        } else if (zzcd(str) != 0) {
            zzge().zzim().zzg("Invalid conditional property event name", zzga().zzbl(str));
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(2069);
            throw illegalArgumentException;
        } else {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putString("_o", str2);
            zzeu zzeu = new zzeu(str, new zzer(zzd(zza(str, bundle2, CollectionUtils.listOf("_o"), false, false))), str2, j2);
            AppMethodBeat.o(2069);
            return zzeu;
        }
    }

    public final void zza(int i2, String str, String str2, int i3) {
        AppMethodBeat.i(2050);
        zza((String) null, i2, str, str2, i3);
        AppMethodBeat.o(2050);
    }

    public final void zza(Bundle bundle, String str, Object obj) {
        AppMethodBeat.i(2049);
        if (bundle == null) {
            AppMethodBeat.o(2049);
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            AppMethodBeat.o(2049);
        } else if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            AppMethodBeat.o(2049);
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            AppMethodBeat.o(2049);
        } else {
            if (str != null) {
                zzge().zziq().zze("Not putting event parameter. Invalid value type. name, type", zzga().zzbk(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
            AppMethodBeat.o(2049);
        }
    }

    public final void zza(zzko zzko, Object obj) {
        AppMethodBeat.i(2048);
        Preconditions.checkNotNull(obj);
        zzko.zzajf = null;
        zzko.zzate = null;
        zzko.zzarc = null;
        if (obj instanceof String) {
            zzko.zzajf = (String) obj;
            AppMethodBeat.o(2048);
        } else if (obj instanceof Long) {
            zzko.zzate = (Long) obj;
            AppMethodBeat.o(2048);
        } else if (obj instanceof Double) {
            zzko.zzarc = (Double) obj;
            AppMethodBeat.o(2048);
        } else {
            zzge().zzim().zzg("Ignoring invalid (type) event param value", obj);
            AppMethodBeat.o(2048);
        }
    }

    public final void zza(zzks zzks, Object obj) {
        AppMethodBeat.i(2047);
        Preconditions.checkNotNull(obj);
        zzks.zzajf = null;
        zzks.zzate = null;
        zzks.zzarc = null;
        if (obj instanceof String) {
            zzks.zzajf = (String) obj;
            AppMethodBeat.o(2047);
        } else if (obj instanceof Long) {
            zzks.zzate = (Long) obj;
            AppMethodBeat.o(2047);
        } else if (obj instanceof Double) {
            zzks.zzarc = (Double) obj;
            AppMethodBeat.o(2047);
        } else {
            zzge().zzim().zzg("Ignoring invalid (type) user attribute value", obj);
            AppMethodBeat.o(2047);
        }
    }

    public final void zza(String str, int i2, String str2, String str3, int i3) {
        AppMethodBeat.i(2051);
        Bundle bundle = new Bundle();
        zza(bundle, i2);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i2 == 6 || i2 == 7 || i2 == 2) {
            bundle.putLong("_el", (long) i3);
        }
        this.zzacw.zzfu().logEvent("auto", "_err", bundle);
        AppMethodBeat.o(2051);
    }

    public final boolean zza(long j2, long j3) {
        AppMethodBeat.i(2057);
        if (j2 == 0 || j3 <= 0) {
            AppMethodBeat.o(2057);
            return true;
        } else if (Math.abs(zzbt().currentTimeMillis() - j2) > j3) {
            AppMethodBeat.o(2057);
            return true;
        } else {
            AppMethodBeat.o(2057);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, int i2, String str2) {
        AppMethodBeat.i(2031);
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            AppMethodBeat.o(2031);
            return false;
        } else if (str2.codePointCount(0, str2.length()) > i2) {
            zzge().zzim().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i2), str2);
            AppMethodBeat.o(2031);
            return false;
        } else {
            AppMethodBeat.o(2031);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String[] strArr, String str2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(TXLiteAVCode.EVT_AUDIO_DEVICE_ROUTE_CHANGED);
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            AppMethodBeat.o(TXLiteAVCode.EVT_AUDIO_DEVICE_ROUTE_CHANGED);
            return false;
        }
        Preconditions.checkNotNull(str2);
        int i2 = 0;
        while (true) {
            if (i2 >= zzard.length) {
                z = false;
                break;
            } else if (str2.startsWith(zzard[i2])) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            zzge().zzim().zze("Name starts with reserved prefix. Type, name", str, str2);
            AppMethodBeat.o(TXLiteAVCode.EVT_AUDIO_DEVICE_ROUTE_CHANGED);
            return false;
        }
        if (strArr != null) {
            Preconditions.checkNotNull(strArr);
            int i3 = 0;
            while (true) {
                if (i3 >= strArr.length) {
                    z2 = false;
                    break;
                } else if (zzs(str2, strArr[i3])) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (z2) {
                zzge().zzim().zze("Name is reserved. Type, name", str, str2);
                AppMethodBeat.o(TXLiteAVCode.EVT_AUDIO_DEVICE_ROUTE_CHANGED);
                return false;
            }
        }
        AppMethodBeat.o(TXLiteAVCode.EVT_AUDIO_DEVICE_ROUTE_CHANGED);
        return true;
    }

    public final byte[] zza(byte[] bArr) {
        AppMethodBeat.i(2052);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            AppMethodBeat.o(2052);
            return byteArray;
        } catch (IOException e2) {
            zzge().zzim().zzg("Failed to gzip content", e2);
            AppMethodBeat.o(2052);
            throw e2;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzab() {
        AppMethodBeat.i(2081);
        super.zzab();
        AppMethodBeat.o(2081);
    }

    public final byte[] zzb(zzkp zzkp) {
        AppMethodBeat.i(2056);
        try {
            byte[] bArr = new byte[zzkp.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkp.zza(zzb);
            zzb.zzve();
            AppMethodBeat.o(2056);
            return bArr;
        } catch (IOException e2) {
            zzge().zzim().zzg("Data loss. Failed to serialize batch", e2);
            AppMethodBeat.o(2056);
            return null;
        }
    }

    public final byte[] zzb(byte[] bArr) {
        AppMethodBeat.i(2053);
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(2053);
                    return byteArray;
                }
            }
        } catch (IOException e2) {
            zzge().zzim().zzg("Failed to ungzip content", e2);
            AppMethodBeat.o(2053);
            throw e2;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ Clock zzbt() {
        AppMethodBeat.i(2088);
        Clock zzbt = super.zzbt();
        AppMethodBeat.o(2088);
        return zzbt;
    }

    public final int zzcd(String str) {
        AppMethodBeat.i(2032);
        if (!zzr("event", str)) {
            AppMethodBeat.o(2032);
            return 2;
        } else if (!zza("event", AppMeasurement.Event.zzacx, str)) {
            AppMethodBeat.o(2032);
            return 13;
        } else if (!zza("event", 40, str)) {
            AppMethodBeat.o(2032);
            return 2;
        } else {
            AppMethodBeat.o(2032);
            return 0;
        }
    }

    public final int zzce(String str) {
        AppMethodBeat.i(2033);
        if (!zzq("user property", str)) {
            AppMethodBeat.o(2033);
            return 6;
        } else if (!zza("user property", AppMeasurement.UserProperty.zzadb, str)) {
            AppMethodBeat.o(2033);
            return 15;
        } else if (!zza("user property", 24, str)) {
            AppMethodBeat.o(2033);
            return 6;
        } else {
            AppMethodBeat.o(2033);
            return 0;
        }
    }

    public final int zzcf(String str) {
        AppMethodBeat.i(2034);
        if (!zzr("user property", str)) {
            AppMethodBeat.o(2034);
            return 6;
        } else if (!zza("user property", AppMeasurement.UserProperty.zzadb, str)) {
            AppMethodBeat.o(2034);
            return 15;
        } else if (!zza("user property", 24, str)) {
            AppMethodBeat.o(2034);
            return 6;
        } else {
            AppMethodBeat.o(2034);
            return 0;
        }
    }

    public final boolean zzcg(String str) {
        AppMethodBeat.i(2036);
        if (TextUtils.isEmpty(str)) {
            zzge().zzim().log("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            AppMethodBeat.o(2036);
            return false;
        }
        Preconditions.checkNotNull(str);
        if (!str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            zzge().zzim().zzg("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
            AppMethodBeat.o(2036);
            return false;
        }
        AppMethodBeat.o(2036);
        return true;
    }

    public final boolean zzcj(String str) {
        AppMethodBeat.i(2063);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(2063);
            return false;
        }
        boolean equals = zzgg().zzhj().equals(str);
        AppMethodBeat.o(2063);
        return equals;
    }

    /* access modifiers changed from: package-private */
    public final long zzd(Context context, String str) {
        long j2 = -1;
        AppMethodBeat.i(2070);
        zzab();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest messageDigest = getMessageDigest("MD5");
        if (messageDigest == null) {
            zzge().zzim().log("Could not get MD5 instance");
        } else {
            if (packageManager != null) {
                try {
                    if (!zze(context, str)) {
                        PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(getContext().getPackageName(), 64);
                        if (packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                            zzge().zzip().log("Could not get signatures");
                        } else {
                            j2 = zzc(messageDigest.digest(packageInfo.signatures[0].toByteArray()));
                        }
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    zzge().zzim().zzg("Package name not found", e2);
                }
            }
            j2 = 0;
        }
        AppMethodBeat.o(2070);
        return j2;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzd(Bundle bundle) {
        AppMethodBeat.i(2065);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzh = zzh(str, bundle.get(str));
                if (zzh == null) {
                    zzge().zzip().zzg("Param value can't be null", zzga().zzbk(str));
                } else {
                    zza(bundle2, str, zzh);
                }
            }
        }
        AppMethodBeat.o(2065);
        return bundle2;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfr() {
        AppMethodBeat.i(2079);
        super.zzfr();
        AppMethodBeat.o(2079);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ void zzfs() {
        AppMethodBeat.i(2080);
        super.zzfs();
        AppMethodBeat.o(2080);
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzdu zzft() {
        AppMethodBeat.i(2082);
        zzdu zzft = super.zzft();
        AppMethodBeat.o(2082);
        return zzft;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        AppMethodBeat.i(2083);
        zzhk zzfu = super.zzfu();
        AppMethodBeat.o(2083);
        return zzfu;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        AppMethodBeat.i(2084);
        zzfb zzfv = super.zzfv();
        AppMethodBeat.o(2084);
        return zzfv;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        AppMethodBeat.i(2085);
        zzeo zzfw = super.zzfw();
        AppMethodBeat.o(2085);
        return zzfw;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzii zzfx() {
        AppMethodBeat.i(2086);
        zzii zzfx = super.zzfx();
        AppMethodBeat.o(2086);
        return zzfx;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzif zzfy() {
        AppMethodBeat.i(2087);
        zzif zzfy = super.zzfy();
        AppMethodBeat.o(2087);
        return zzfy;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        AppMethodBeat.i(2090);
        zzfc zzfz = super.zzfz();
        AppMethodBeat.o(2090);
        return zzfz;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfe zzga() {
        AppMethodBeat.i(2091);
        zzfe zzga = super.zzga();
        AppMethodBeat.o(2091);
        return zzga;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzka zzgb() {
        AppMethodBeat.i(2092);
        zzka zzgb = super.zzgb();
        AppMethodBeat.o(2092);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        AppMethodBeat.i(2093);
        zzjh zzgc = super.zzgc();
        AppMethodBeat.o(2093);
        return zzgc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        AppMethodBeat.i(2094);
        zzgg zzgd = super.zzgd();
        AppMethodBeat.o(2094);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg, com.google.android.gms.internal.measurement.zzec
    public final /* bridge */ /* synthetic */ zzfg zzge() {
        AppMethodBeat.i(2095);
        zzfg zzge = super.zzge();
        AppMethodBeat.o(2095);
        return zzge;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        AppMethodBeat.i(2096);
        zzfr zzgf = super.zzgf();
        AppMethodBeat.o(2096);
        return zzgf;
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final /* bridge */ /* synthetic */ zzef zzgg() {
        AppMethodBeat.i(2097);
        zzef zzgg = super.zzgg();
        AppMethodBeat.o(2097);
        return zzgg;
    }

    public final Object zzh(String str, Object obj) {
        int i2 = 256;
        AppMethodBeat.i(2039);
        if ("_ev".equals(str)) {
            Object zza = zza(256, obj, true);
            AppMethodBeat.o(2039);
            return zza;
        }
        if (!zzci(str)) {
            i2 = 100;
        }
        Object zza2 = zza(i2, obj, false);
        AppMethodBeat.o(2039);
        return zza2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final boolean zzhf() {
        return true;
    }

    public final int zzi(String str, Object obj) {
        AppMethodBeat.i(2045);
        if ("_ldl".equals(str) ? zza("user property referrer", str, zzch(str), obj, false) : zza("user property", str, zzch(str), obj, false)) {
            AppMethodBeat.o(2045);
            return 0;
        }
        AppMethodBeat.o(2045);
        return 7;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzhh
    public final void zzih() {
        AppMethodBeat.i(TXLiteAVCode.EVT_SW_DECODER_START_SUCC);
        zzab();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzge().zzip().log("Utils falling back to Random for random id");
            }
        }
        this.zzarf.set(nextLong);
        AppMethodBeat.o(TXLiteAVCode.EVT_SW_DECODER_START_SUCC);
    }

    public final Object zzj(String str, Object obj) {
        AppMethodBeat.i(2046);
        if ("_ldl".equals(str)) {
            Object zza = zza(zzch(str), obj, true);
            AppMethodBeat.o(2046);
            return zza;
        }
        Object zza2 = zza(zzch(str), obj, false);
        AppMethodBeat.o(2046);
        return zza2;
    }

    public final long zzlb() {
        long andIncrement;
        AppMethodBeat.i(TXLiteAVCode.EVT_AUDIO_JITTER_STATE_FIRST_LOADING);
        if (this.zzarf.get() == 0) {
            synchronized (this.zzarf) {
                try {
                    long nextLong = new Random(System.nanoTime() ^ zzbt().currentTimeMillis()).nextLong();
                    int i2 = this.zzarg + 1;
                    this.zzarg = i2;
                    andIncrement = nextLong + ((long) i2);
                } finally {
                    AppMethodBeat.o(TXLiteAVCode.EVT_AUDIO_JITTER_STATE_FIRST_LOADING);
                }
            }
        } else {
            synchronized (this.zzarf) {
                try {
                    this.zzarf.compareAndSet(-1, 1);
                    andIncrement = this.zzarf.getAndIncrement();
                } finally {
                    AppMethodBeat.o(TXLiteAVCode.EVT_AUDIO_JITTER_STATE_FIRST_LOADING);
                }
            }
        }
        return andIncrement;
    }

    /* access modifiers changed from: package-private */
    public final SecureRandom zzlc() {
        AppMethodBeat.i(TXLiteAVCode.EVT_AUDIO_JITTER_STATE_LOADING);
        zzab();
        if (this.zzare == null) {
            this.zzare = new SecureRandom();
        }
        SecureRandom secureRandom = this.zzare;
        AppMethodBeat.o(TXLiteAVCode.EVT_AUDIO_JITTER_STATE_LOADING);
        return secureRandom;
    }

    public final int zzld() {
        AppMethodBeat.i(2078);
        if (this.zzarh == null) {
            this.zzarh = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(getContext()) / 1000);
        }
        int intValue = this.zzarh.intValue();
        AppMethodBeat.o(2078);
        return intValue;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzq(String str, String str2) {
        AppMethodBeat.i(2028);
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            AppMethodBeat.o(2028);
            return false;
        } else if (str2.length() == 0) {
            zzge().zzim().zzg("Name is required and can't be empty. Type", str);
            AppMethodBeat.o(2028);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                zzge().zzim().zze("Name must start with a letter. Type, name", str, str2);
                AppMethodBeat.o(2028);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    zzge().zzim().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    AppMethodBeat.o(2028);
                    return false;
                }
            }
            AppMethodBeat.o(2028);
            return true;
        }
    }

    public final boolean zzx(String str) {
        AppMethodBeat.i(2059);
        zzab();
        if (Wrappers.packageManager(getContext()).checkCallingOrSelfPermission(str) == 0) {
            AppMethodBeat.o(2059);
            return true;
        }
        zzge().zzis().zzg("Permission not granted", str);
        AppMethodBeat.o(2059);
        return false;
    }
}
