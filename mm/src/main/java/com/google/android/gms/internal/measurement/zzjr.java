package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.e.a;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzjr implements zzec {
    private zzgl zzacw;
    zzgf zzaqa;
    zzfk zzaqb;
    private zzei zzaqc;
    private zzfp zzaqd;
    private zzjn zzaqe;
    private zzeb zzaqf;
    private boolean zzaqg;
    @VisibleForTesting
    private long zzaqh;
    private List<Runnable> zzaqi;
    private int zzaqj;
    private int zzaqk;
    private boolean zzaql;
    private boolean zzaqm;
    private boolean zzaqn;
    private FileLock zzaqo;
    private FileChannel zzaqp;
    private List<Long> zzaqq;
    private List<Long> zzaqr;
    long zzaqs;
    private boolean zzvo = false;

    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        int i2 = 0;
        AppMethodBeat.i(1992);
        zzab();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzge().zzim().log("Bad channel to read from");
            AppMethodBeat.o(1992);
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            try {
                fileChannel.position(0L);
                int read = fileChannel.read(allocate);
                if (read != 4) {
                    if (read != -1) {
                        zzge().zzip().zzg("Unexpected data length. Bytes read", Integer.valueOf(read));
                    }
                    AppMethodBeat.o(1992);
                } else {
                    allocate.flip();
                    i2 = allocate.getInt();
                    AppMethodBeat.o(1992);
                }
            } catch (IOException e2) {
                zzge().zzim().zzg("Failed to read from channel", e2);
            }
        }
        return i2;
    }

    static /* synthetic */ zzdy zza(zzjr zzjr, zzdz zzdz) {
        AppMethodBeat.i(2008);
        zzdy zzg = zzjr.zzg(zzdz);
        AppMethodBeat.o(2008);
        return zzg;
    }

    private final zzdz zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j2) {
        String str3;
        AppMethodBeat.i(1997);
        String str4 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        String str5 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        int i2 = Integer.MIN_VALUE;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            zzge().zzim().log("PackageManager is null, can not log app install information");
            AppMethodBeat.o(1997);
            return null;
        }
        try {
            str4 = packageManager.getInstallerPackageName(str);
        } catch (IllegalArgumentException e2) {
            zzge().zzim().zzg("Error retrieving installer package name. appId", zzfg.zzbm(str));
        }
        if (str4 == null) {
            str4 = "manual_install";
        } else if ("com.android.vending".equals(str4)) {
            str4 = "";
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str);
                str3 = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                try {
                    str5 = packageInfo.versionName;
                    i2 = packageInfo.versionCode;
                } catch (PackageManager.NameNotFoundException e3) {
                    zzge().zzim().zze("Error retrieving newly installed package info. appId, appName", zzfg.zzbm(str), str3);
                    AppMethodBeat.o(1997);
                    return null;
                }
            }
            long j3 = 0;
            if (zzgg().zzba(str)) {
                j3 = j2;
            }
            zzdz zzdz = new zzdz(str, str2, str5, (long) i2, str4, 12451L, zzgb().zzd(context, str), (String) null, z, false, "", 0L, j3, 0, z2, z3, false);
            AppMethodBeat.o(1997);
            return zzdz;
        } catch (PackageManager.NameNotFoundException e4) {
            str3 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            zzge().zzim().zze("Error retrieving newly installed package info. appId, appName", zzfg.zzbm(str), str3);
            AppMethodBeat.o(1997);
            return null;
        }
    }

    private static void zza(zzjq zzjq) {
        AppMethodBeat.i(1973);
        if (zzjq == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Upload component not created");
            AppMethodBeat.o(1973);
            throw illegalStateException;
        } else if (!zzjq.isInitialized()) {
            String valueOf = String.valueOf(zzjq.getClass());
            IllegalStateException illegalStateException2 = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 27).append("Component not initialized: ").append(valueOf).toString());
            AppMethodBeat.o(1973);
            throw illegalStateException2;
        } else {
            AppMethodBeat.o(1973);
        }
    }

    @VisibleForTesting
    private final boolean zza(int i2, FileChannel fileChannel) {
        AppMethodBeat.i(1993);
        zzab();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzge().zzim().log("Bad channel to read from");
            AppMethodBeat.o(1993);
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i2);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                zzge().zzim().zzg("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            AppMethodBeat.o(1993);
            return true;
        } catch (IOException e2) {
            zzge().zzim().zzg("Failed to write to channel", e2);
            AppMethodBeat.o(1993);
            return false;
        }
    }

    private final boolean zza(String str, zzeu zzeu) {
        long longValue;
        zzjz zzjz;
        AppMethodBeat.i(1979);
        String string = zzeu.zzafq.getString(FirebaseAnalytics.b.CURRENCY);
        if (FirebaseAnalytics.a.ECOMMERCE_PURCHASE.equals(zzeu.name)) {
            double doubleValue = zzeu.zzafq.zzbh("value").doubleValue() * 1000000.0d;
            if (doubleValue == 0.0d) {
                doubleValue = ((double) zzeu.zzafq.getLong("value").longValue()) * 1000000.0d;
            }
            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                zzge().zzip().zze("Data lost. Currency value is too big. appId", zzfg.zzbm(str), Double.valueOf(doubleValue));
                AppMethodBeat.o(1979);
                return false;
            }
            longValue = Math.round(doubleValue);
        } else {
            longValue = zzeu.zzafq.getLong("value").longValue();
        }
        if (!TextUtils.isEmpty(string)) {
            String upperCase = string.toUpperCase(Locale.US);
            if (upperCase.matches("[A-Z]{3}")) {
                String valueOf = String.valueOf("_ltv_");
                String valueOf2 = String.valueOf(upperCase);
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                zzjz zzh = zzix().zzh(str, concat);
                if (zzh == null || !(zzh.value instanceof Long)) {
                    zzei zzix = zzix();
                    int zzb = zzgg().zzb(str, zzew.zzahm) - 1;
                    Preconditions.checkNotEmpty(str);
                    zzix.zzab();
                    zzix.zzch();
                    try {
                        zzix.getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(zzb)});
                    } catch (SQLiteException e2) {
                        zzix.zzge().zzim().zze("Error pruning currencies. appId", zzfg.zzbm(str), e2);
                    }
                    zzjz = new zzjz(str, zzeu.origin, concat, zzbt().currentTimeMillis(), Long.valueOf(longValue));
                } else {
                    zzjz = new zzjz(str, zzeu.origin, concat, zzbt().currentTimeMillis(), Long.valueOf(longValue + ((Long) zzh.value).longValue()));
                }
                if (!zzix().zza(zzjz)) {
                    zzge().zzim().zzd("Too many unique user properties are set. Ignoring user property. appId", zzfg.zzbm(str), zzga().zzbl(zzjz.name), zzjz.value);
                    zzgb().zza(str, 9, (String) null, (String) null, 0);
                }
            }
        }
        AppMethodBeat.o(1979);
        return true;
    }

    private final zzkm[] zza(String str, zzks[] zzksArr, zzkn[] zzknArr) {
        AppMethodBeat.i(Exif.PARSE_EXIF_ERROR_NO_JPEG);
        Preconditions.checkNotEmpty(str);
        zzkm[] zza = zziw().zza(str, zzknArr, zzksArr);
        AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_NO_JPEG);
        return zza;
    }

    private final void zzb(zzdy zzdy) {
        a aVar;
        AppMethodBeat.i(Exif.PARSE_EXIF_ERROR_CORRUPT);
        zzab();
        if (TextUtils.isEmpty(zzdy.getGmpAppId())) {
            zzb(zzdy.zzah(), 204, null, null, null);
            AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_CORRUPT);
            return;
        }
        String gmpAppId = zzdy.getGmpAppId();
        String appInstanceId = zzdy.getAppInstanceId();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder encodedAuthority = builder.scheme(zzew.zzagm.get()).encodedAuthority(zzew.zzagn.get());
        String valueOf = String.valueOf(gmpAppId);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", appInstanceId).appendQueryParameter(TPDownloadProxyEnum.USER_PLATFORM, "android").appendQueryParameter("gmp_version", "12451");
        String uri = builder.build().toString();
        try {
            URL url = new URL(uri);
            zzge().zzit().zzg("Fetching remote configuration", zzdy.zzah());
            zzkk zzbu = zzkm().zzbu(zzdy.zzah());
            String zzbv = zzkm().zzbv(zzdy.zzah());
            if (zzbu == null || TextUtils.isEmpty(zzbv)) {
                aVar = null;
            } else {
                a aVar2 = new a();
                aVar2.put("If-Modified-Since", zzbv);
                aVar = aVar2;
            }
            this.zzaql = true;
            zzfk zzkn = zzkn();
            String zzah = zzdy.zzah();
            zzjt zzjt = new zzjt(this);
            zzkn.zzab();
            zzkn.zzch();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzjt);
            zzkn.zzgd().zzd(new zzfo(zzkn, zzah, url, null, aVar, zzjt));
            AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_CORRUPT);
        } catch (MalformedURLException e2) {
            zzge().zzim().zze("Failed to parse config URL. Not fetching. appId", zzfg.zzbm(zzdy.zzah()), uri);
            AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_CORRUPT);
        }
    }

    private final Boolean zzc(zzdy zzdy) {
        AppMethodBeat.i(1990);
        try {
            if (zzdy.zzgm() != -2147483648L) {
                if (zzdy.zzgm() == ((long) Wrappers.packageManager(getContext()).getPackageInfo(zzdy.zzah(), 0).versionCode)) {
                    Boolean bool = Boolean.TRUE;
                    AppMethodBeat.o(1990);
                    return bool;
                }
            } else {
                String str = Wrappers.packageManager(getContext()).getPackageInfo(zzdy.zzah(), 0).versionName;
                if (zzdy.zzag() != null && zzdy.zzag().equals(str)) {
                    Boolean bool2 = Boolean.TRUE;
                    AppMethodBeat.o(1990);
                    return bool2;
                }
            }
            Boolean bool3 = Boolean.FALSE;
            AppMethodBeat.o(1990);
            return bool3;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(1990);
            return null;
        }
    }

    private final void zzc(zzeu zzeu, zzdz zzdz) {
        zzeq zzac;
        zzep zzep;
        boolean z;
        zzdy zzbc;
        AppMethodBeat.i(1978);
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz.packageName);
        long nanoTime = System.nanoTime();
        zzab();
        zzkq();
        String str = zzdz.packageName;
        zzgb();
        if (!zzka.zzd(zzeu, zzdz)) {
            AppMethodBeat.o(1978);
        } else if (!zzdz.zzadw) {
            zzg(zzdz);
            AppMethodBeat.o(1978);
        } else if (zzkm().zzn(str, zzeu.name)) {
            zzge().zzip().zze("Dropping blacklisted event. appId", zzfg.zzbm(str), zzga().zzbj(zzeu.name));
            boolean z2 = zzkm().zzby(str) || zzkm().zzbz(str);
            if (!z2 && !"_err".equals(zzeu.name)) {
                zzgb().zza(str, 11, "_ev", zzeu.name, 0);
            }
            if (z2 && (zzbc = zzix().zzbc(str)) != null) {
                if (Math.abs(zzbt().currentTimeMillis() - Math.max(zzbc.zzgs(), zzbc.zzgr())) > zzew.zzahh.get().longValue()) {
                    zzge().zzis().log("Fetching config for blacklisted app");
                    zzb(zzbc);
                }
            }
            AppMethodBeat.o(1978);
        } else {
            if (zzge().isLoggable(2)) {
                zzge().zzit().zzg("Logging event", zzga().zzb(zzeu));
            }
            zzix().beginTransaction();
            try {
                zzg(zzdz);
                if (("_iap".equals(zzeu.name) || FirebaseAnalytics.a.ECOMMERCE_PURCHASE.equals(zzeu.name)) && !zza(str, zzeu)) {
                    zzix().setTransactionSuccessful();
                    return;
                }
                boolean zzcc = zzka.zzcc(zzeu.name);
                boolean equals = "_err".equals(zzeu.name);
                zzej zza = zzix().zza(zzkr(), str, true, zzcc, false, equals, false);
                long intValue = zza.zzafe - ((long) zzew.zzags.get().intValue());
                if (intValue > 0) {
                    if (intValue % 1000 == 1) {
                        zzge().zzim().zze("Data loss. Too many events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafe));
                    }
                    zzix().setTransactionSuccessful();
                    zzix().endTransaction();
                    AppMethodBeat.o(1978);
                    return;
                }
                if (zzcc) {
                    long intValue2 = zza.zzafd - ((long) zzew.zzagu.get().intValue());
                    if (intValue2 > 0) {
                        if (intValue2 % 1000 == 1) {
                            zzge().zzim().zze("Data loss. Too many public events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafd));
                        }
                        zzgb().zza(str, 16, "_ev", zzeu.name, 0);
                        zzix().setTransactionSuccessful();
                        zzix().endTransaction();
                        AppMethodBeat.o(1978);
                        return;
                    }
                }
                if (equals) {
                    long max = zza.zzafg - ((long) Math.max(0, Math.min(1000000, zzgg().zzb(zzdz.packageName, zzew.zzagt))));
                    if (max > 0) {
                        if (max == 1) {
                            zzge().zzim().zze("Too many error events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafg));
                        }
                        zzix().setTransactionSuccessful();
                        zzix().endTransaction();
                        AppMethodBeat.o(1978);
                        return;
                    }
                }
                Bundle zzif = zzeu.zzafq.zzif();
                zzgb().zza(zzif, "_o", zzeu.origin);
                if (zzgb().zzcj(str)) {
                    zzgb().zza(zzif, "_dbg", (Object) 1L);
                    zzgb().zza(zzif, "_r", (Object) 1L);
                }
                long zzbd = zzix().zzbd(str);
                if (zzbd > 0) {
                    zzge().zzip().zze("Data lost. Too many events stored on disk, deleted. appId", zzfg.zzbm(str), Long.valueOf(zzbd));
                }
                zzep zzep2 = new zzep(this.zzacw, zzeu.origin, str, zzeu.name, zzeu.zzagb, 0, zzif);
                zzeq zzf = zzix().zzf(str, zzep2.name);
                if (zzf != null) {
                    zzep zza2 = zzep2.zza(this.zzacw, zzf.zzaft);
                    zzac = zzf.zzac(zza2.timestamp);
                    zzep = zza2;
                } else if (zzix().zzbg(str) < 500 || !zzcc) {
                    zzac = new zzeq(str, zzep2.name, 0, 0, zzep2.timestamp, 0, null, null, null);
                    zzep = zzep2;
                } else {
                    zzge().zzim().zzd("Too many event names used, ignoring event. appId, name, supported count", zzfg.zzbm(str), zzga().zzbj(zzep2.name), 500);
                    zzgb().zza(str, 8, (String) null, (String) null, 0);
                    zzix().endTransaction();
                    AppMethodBeat.o(1978);
                    return;
                }
                zzix().zza(zzac);
                zzab();
                zzkq();
                Preconditions.checkNotNull(zzep);
                Preconditions.checkNotNull(zzdz);
                Preconditions.checkNotEmpty(zzep.zzti);
                Preconditions.checkArgument(zzep.zzti.equals(zzdz.packageName));
                zzkq zzkq = new zzkq();
                zzkq.zzath = 1;
                zzkq.zzatp = "android";
                zzkq.zzti = zzdz.packageName;
                zzkq.zzadt = zzdz.zzadt;
                zzkq.zzth = zzdz.zzth;
                zzkq.zzaub = zzdz.zzads == -2147483648L ? null : Integer.valueOf((int) zzdz.zzads);
                zzkq.zzatt = Long.valueOf(zzdz.zzadu);
                zzkq.zzadm = zzdz.zzadm;
                zzkq.zzatx = zzdz.zzadv == 0 ? null : Long.valueOf(zzdz.zzadv);
                Pair<String, Boolean> zzbo = zzgf().zzbo(zzdz.packageName);
                if (zzbo == null || TextUtils.isEmpty((CharSequence) zzbo.first)) {
                    if (!zzfw().zzf(getContext()) && zzdz.zzadz) {
                        String string = Settings.Secure.getString(getContext().getContentResolver(), "android_id");
                        if (string == null) {
                            zzge().zzip().zzg("null secure ID. appId", zzfg.zzbm(zzkq.zzti));
                            string = BuildConfig.COMMAND;
                        } else if (string.isEmpty()) {
                            zzge().zzip().zzg("empty secure ID. appId", zzfg.zzbm(zzkq.zzti));
                        }
                        zzkq.zzaue = string;
                    }
                } else if (zzdz.zzady) {
                    zzkq.zzatv = (String) zzbo.first;
                    zzkq.zzatw = (Boolean) zzbo.second;
                }
                zzfw().zzch();
                zzkq.zzatr = Build.MODEL;
                zzfw().zzch();
                zzkq.zzatq = Build.VERSION.RELEASE;
                zzkq.zzats = Integer.valueOf((int) zzfw().zzic());
                zzkq.zzafn = zzfw().zzid();
                zzkq.zzatu = null;
                zzkq.zzatk = null;
                zzkq.zzatl = null;
                zzkq.zzatm = null;
                zzkq.zzaug = Long.valueOf(zzdz.zzadx);
                if (this.zzacw.isEnabled() && zzef.zzhk()) {
                    zzkq.zzauh = null;
                }
                zzdy zzbc2 = zzix().zzbc(zzdz.packageName);
                if (zzbc2 == null) {
                    zzbc2 = new zzdy(this.zzacw, zzdz.packageName);
                    zzbc2.zzal(this.zzacw.zzfv().zzii());
                    zzbc2.zzao(zzdz.zzado);
                    zzbc2.zzam(zzdz.zzadm);
                    zzbc2.zzan(zzgf().zzbp(zzdz.packageName));
                    zzbc2.zzr(0);
                    zzbc2.zzm(0);
                    zzbc2.zzn(0);
                    zzbc2.setAppVersion(zzdz.zzth);
                    zzbc2.zzo(zzdz.zzads);
                    zzbc2.zzap(zzdz.zzadt);
                    zzbc2.zzp(zzdz.zzadu);
                    zzbc2.zzq(zzdz.zzadv);
                    zzbc2.setMeasurementEnabled(zzdz.zzadw);
                    zzbc2.zzaa(zzdz.zzadx);
                    zzix().zza(zzbc2);
                }
                zzkq.zzadl = zzbc2.getAppInstanceId();
                zzkq.zzado = zzbc2.zzgj();
                List<zzjz> zzbb = zzix().zzbb(zzdz.packageName);
                zzkq.zzatj = new zzks[zzbb.size()];
                for (int i2 = 0; i2 < zzbb.size(); i2++) {
                    zzks zzks = new zzks();
                    zzkq.zzatj[i2] = zzks;
                    zzks.name = zzbb.get(i2).name;
                    zzks.zzaun = Long.valueOf(zzbb.get(i2).zzaqz);
                    zzgb().zza(zzks, zzbb.get(i2).value);
                }
                try {
                    long zza3 = zzix().zza(zzkq);
                    zzei zzix = zzix();
                    if (zzep.zzafq != null) {
                        Iterator<String> it = zzep.zzafq.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if ("_r".equals(it.next())) {
                                    z = true;
                                    break;
                                }
                            } else {
                                boolean zzo = zzkm().zzo(zzep.zzti, zzep.name);
                                zzej zza4 = zzix().zza(zzkr(), zzep.zzti, false, false, false, false, false);
                                if (zzo && zza4.zzafh < ((long) zzgg().zzar(zzep.zzti))) {
                                    z = true;
                                }
                            }
                        }
                    }
                    z = false;
                    if (zzix.zza(zzep, zza3, z)) {
                        this.zzaqh = 0;
                    }
                } catch (IOException e2) {
                    zzge().zzim().zze("Data loss. Failed to insert raw event metadata. appId", zzfg.zzbm(zzkq.zzti), e2);
                }
                zzix().setTransactionSuccessful();
                if (zzge().isLoggable(2)) {
                    zzge().zzit().zzg("Event recorded", zzga().zza(zzep));
                }
                zzix().endTransaction();
                zzku();
                zzge().zzit().zzg("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / TimeUtil.SECOND_TO_US));
                AppMethodBeat.o(1978);
            } finally {
                zzix().endTransaction();
                AppMethodBeat.o(1978);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:114:0x03a2, code lost:
        if (com.google.android.gms.internal.measurement.zzka.zzcl(r0.name) != false) goto L_0x03a4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x055c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x0be7  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0317  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzd(java.lang.String r31, long r32) {
        /*
        // Method dump skipped, instructions count: 3108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjr.zzd(java.lang.String, long):boolean");
    }

    private final zzdy zzg(zzdz zzdz) {
        boolean z = true;
        AppMethodBeat.i(2004);
        zzab();
        zzkq();
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz.packageName);
        zzdy zzbc = zzix().zzbc(zzdz.packageName);
        String zzbp = zzgf().zzbp(zzdz.packageName);
        boolean z2 = false;
        if (zzbc == null) {
            zzbc = new zzdy(this.zzacw, zzdz.packageName);
            zzbc.zzal(this.zzacw.zzfv().zzii());
            zzbc.zzan(zzbp);
            z2 = true;
        } else if (!zzbp.equals(zzbc.zzgi())) {
            zzbc.zzan(zzbp);
            zzbc.zzal(this.zzacw.zzfv().zzii());
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzdz.zzadm) && !zzdz.zzadm.equals(zzbc.getGmpAppId())) {
            zzbc.zzam(zzdz.zzadm);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzdz.zzado) && !zzdz.zzado.equals(zzbc.zzgj())) {
            zzbc.zzao(zzdz.zzado);
            z2 = true;
        }
        if (!(zzdz.zzadu == 0 || zzdz.zzadu == zzbc.zzgo())) {
            zzbc.zzp(zzdz.zzadu);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzdz.zzth) && !zzdz.zzth.equals(zzbc.zzag())) {
            zzbc.setAppVersion(zzdz.zzth);
            z2 = true;
        }
        if (zzdz.zzads != zzbc.zzgm()) {
            zzbc.zzo(zzdz.zzads);
            z2 = true;
        }
        if (zzdz.zzadt != null && !zzdz.zzadt.equals(zzbc.zzgn())) {
            zzbc.zzap(zzdz.zzadt);
            z2 = true;
        }
        if (zzdz.zzadv != zzbc.zzgp()) {
            zzbc.zzq(zzdz.zzadv);
            z2 = true;
        }
        if (zzdz.zzadw != zzbc.isMeasurementEnabled()) {
            zzbc.setMeasurementEnabled(zzdz.zzadw);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzdz.zzaek) && !zzdz.zzaek.equals(zzbc.zzha())) {
            zzbc.zzaq(zzdz.zzaek);
            z2 = true;
        }
        if (zzdz.zzadx != zzbc.zzhc()) {
            zzbc.zzaa(zzdz.zzadx);
            z2 = true;
        }
        if (zzdz.zzady != zzbc.zzhd()) {
            zzbc.zzd(zzdz.zzady);
            z2 = true;
        }
        if (zzdz.zzadz != zzbc.zzhe()) {
            zzbc.zze(zzdz.zzadz);
        } else {
            z = z2;
        }
        if (z) {
            zzix().zza(zzbc);
        }
        AppMethodBeat.o(2004);
        return zzbc;
    }

    private final zzgf zzkm() {
        AppMethodBeat.i(1960);
        zza(this.zzaqa);
        zzgf zzgf = this.zzaqa;
        AppMethodBeat.o(1960);
        return zzgf;
    }

    private final zzfp zzko() {
        AppMethodBeat.i(1963);
        if (this.zzaqd == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Network broadcast receiver not created");
            AppMethodBeat.o(1963);
            throw illegalStateException;
        }
        zzfp zzfp = this.zzaqd;
        AppMethodBeat.o(1963);
        return zzfp;
    }

    private final zzjn zzkp() {
        AppMethodBeat.i(1964);
        zza(this.zzaqe);
        zzjn zzjn = this.zzaqe;
        AppMethodBeat.o(1964);
        return zzjn;
    }

    private final long zzkr() {
        AppMethodBeat.i(1975);
        long currentTimeMillis = zzbt().currentTimeMillis();
        zzfr zzgf = zzgf();
        zzgf.zzch();
        zzgf.zzab();
        long j2 = zzgf.zzajy.get();
        if (j2 == 0) {
            j2 = 1 + ((long) zzgf.zzgb().zzlc().nextInt(Downloads.MAX_RETYR_AFTER));
            zzgf.zzajy.set(j2);
        }
        long j3 = ((((j2 + currentTimeMillis) / 1000) / 60) / 60) / 24;
        AppMethodBeat.o(1975);
        return j3;
    }

    private final boolean zzkt() {
        AppMethodBeat.i(Exif.PARSE_EXIF_ERROR_UNKNOWN_BYTEALIGN);
        zzab();
        zzkq();
        if (zzix().zzhs() || !TextUtils.isEmpty(zzix().zzhn())) {
            AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_UNKNOWN_BYTEALIGN);
            return true;
        }
        AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_UNKNOWN_BYTEALIGN);
        return false;
    }

    private final void zzku() {
        long max;
        long j2;
        AppMethodBeat.i(1987);
        zzab();
        zzkq();
        if (!zzky()) {
            AppMethodBeat.o(1987);
            return;
        }
        if (this.zzaqh > 0) {
            long abs = Util.MILLSECONDS_OF_HOUR - Math.abs(zzbt().elapsedRealtime() - this.zzaqh);
            if (abs > 0) {
                zzge().zzit().zzg("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                zzko().unregister();
                zzkp().cancel();
                AppMethodBeat.o(1987);
                return;
            }
            this.zzaqh = 0;
        }
        if (!this.zzacw.zzjv() || !zzkt()) {
            zzge().zzit().log("Nothing to upload or uploading impossible");
            zzko().unregister();
            zzkp().cancel();
            AppMethodBeat.o(1987);
            return;
        }
        long currentTimeMillis = zzbt().currentTimeMillis();
        long max2 = Math.max(0L, zzew.zzahi.get().longValue());
        boolean z = zzix().zzht() || zzix().zzho();
        if (z) {
            String zzhj = zzgg().zzhj();
            max = (TextUtils.isEmpty(zzhj) || ".none.".equals(zzhj)) ? Math.max(0L, zzew.zzahc.get().longValue()) : Math.max(0L, zzew.zzahd.get().longValue());
        } else {
            max = Math.max(0L, zzew.zzahb.get().longValue());
        }
        long j3 = zzgf().zzaju.get();
        long j4 = zzgf().zzajv.get();
        long max3 = Math.max(zzix().zzhq(), zzix().zzhr());
        if (max3 != 0) {
            long abs2 = currentTimeMillis - Math.abs(max3 - currentTimeMillis);
            long abs3 = currentTimeMillis - Math.abs(j4 - currentTimeMillis);
            long max4 = Math.max(currentTimeMillis - Math.abs(j3 - currentTimeMillis), abs3);
            long j5 = abs2 + max2;
            if (z && max4 > 0) {
                j5 = Math.min(abs2, max4) + max;
            }
            long j6 = !zzgb().zza(max4, max) ? max + max4 : j5;
            if (abs3 != 0 && abs3 >= abs2) {
                int i2 = 0;
                while (true) {
                    if (i2 >= Math.min(20, Math.max(0, zzew.zzahk.get().intValue()))) {
                        j2 = 0;
                        break;
                    }
                    j6 = (Math.max(0L, zzew.zzahj.get().longValue()) * (1 << i2)) + j6;
                    if (j6 > abs3) {
                        j2 = j6;
                        break;
                    }
                    i2++;
                }
            } else {
                j2 = j6;
            }
        } else {
            j2 = 0;
        }
        if (j2 == 0) {
            zzge().zzit().log("Next upload time is 0");
            zzko().unregister();
            zzkp().cancel();
            AppMethodBeat.o(1987);
        } else if (!zzkn().zzex()) {
            zzge().zzit().log("No network");
            zzko().zzeu();
            zzkp().cancel();
            AppMethodBeat.o(1987);
        } else {
            long j7 = zzgf().zzajw.get();
            long max5 = Math.max(0L, zzew.zzagz.get().longValue());
            long max6 = !zzgb().zza(j7, max5) ? Math.max(j2, max5 + j7) : j2;
            zzko().unregister();
            long currentTimeMillis2 = max6 - zzbt().currentTimeMillis();
            if (currentTimeMillis2 <= 0) {
                currentTimeMillis2 = Math.max(0L, zzew.zzahe.get().longValue());
                zzgf().zzaju.set(zzbt().currentTimeMillis());
            }
            zzge().zzit().zzg("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
            zzkp().zzh(currentTimeMillis2);
            AppMethodBeat.o(1987);
        }
    }

    private final void zzkv() {
        AppMethodBeat.i(1989);
        zzab();
        if (this.zzaql || this.zzaqm || this.zzaqn) {
            zzge().zzit().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzaql), Boolean.valueOf(this.zzaqm), Boolean.valueOf(this.zzaqn));
            AppMethodBeat.o(1989);
            return;
        }
        zzge().zzit().log("Stopping uploading service(s)");
        if (this.zzaqi == null) {
            AppMethodBeat.o(1989);
            return;
        }
        for (Runnable runnable : this.zzaqi) {
            runnable.run();
        }
        this.zzaqi.clear();
        AppMethodBeat.o(1989);
    }

    @VisibleForTesting
    private final boolean zzkw() {
        AppMethodBeat.i(1991);
        zzab();
        try {
            this.zzaqp = new RandomAccessFile(new File(getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzaqo = this.zzaqp.tryLock();
            if (this.zzaqo != null) {
                zzge().zzit().log("Storage concurrent access okay");
                AppMethodBeat.o(1991);
                return true;
            }
            zzge().zzim().log("Storage concurrent data access panic");
            AppMethodBeat.o(1991);
            return false;
        } catch (FileNotFoundException e2) {
            zzge().zzim().zzg("Failed to acquire storage lock", e2);
        } catch (IOException e3) {
            zzge().zzim().zzg("Failed to access storage lock file", e3);
        }
    }

    private final boolean zzky() {
        AppMethodBeat.i(1995);
        zzab();
        zzkq();
        if (this.zzaqg) {
            AppMethodBeat.o(1995);
            return true;
        }
        AppMethodBeat.o(1995);
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public Context getContext() {
        AppMethodBeat.i(1967);
        Context context = this.zzacw.getContext();
        AppMethodBeat.o(1967);
        return context;
    }

    /* access modifiers changed from: protected */
    public void start() {
        AppMethodBeat.i(1955);
        zzab();
        zzix().zzhp();
        if (zzgf().zzaju.get() == 0) {
            zzgf().zzaju.set(zzbt().currentTimeMillis());
        }
        zzku();
        AppMethodBeat.o(1955);
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final void zza(int i2, Throwable th, byte[] bArr, String str) {
        AppMethodBeat.i(Exif.PARSE_EXIF_ERROR_NO_EXIF);
        zzab();
        zzkq();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzaqm = false;
                zzkv();
                AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_NO_EXIF);
                throw th2;
            }
        }
        List<Long> list = this.zzaqq;
        this.zzaqq = null;
        if ((i2 == 200 || i2 == 204) && th == null) {
            try {
                zzgf().zzaju.set(zzbt().currentTimeMillis());
                zzgf().zzajv.set(0);
                zzku();
                zzge().zzit().zze("Successful upload. Got network response. code, size", Integer.valueOf(i2), Integer.valueOf(bArr.length));
                zzix().beginTransaction();
                try {
                    for (Long l : list) {
                        try {
                            zzei zzix = zzix();
                            long longValue = l.longValue();
                            zzix.zzab();
                            zzix.zzch();
                            try {
                                if (zzix.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                    SQLiteException sQLiteException = new SQLiteException("Deleted fewer rows from queue than expected");
                                    AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_NO_EXIF);
                                    throw sQLiteException;
                                }
                            } catch (SQLiteException e2) {
                                zzix.zzge().zzim().zzg("Failed to delete a bundle in a queue table", e2);
                                AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_NO_EXIF);
                                throw e2;
                            }
                        } catch (SQLiteException e3) {
                            if (this.zzaqr == null || !this.zzaqr.contains(l)) {
                                AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_NO_EXIF);
                                throw e3;
                            }
                        }
                    }
                    zzix().setTransactionSuccessful();
                    zzix().endTransaction();
                    this.zzaqr = null;
                    if (!zzkn().zzex() || !zzkt()) {
                        this.zzaqs = -1;
                        zzku();
                    } else {
                        zzks();
                    }
                    this.zzaqh = 0;
                } catch (Throwable th3) {
                    zzix().endTransaction();
                    AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_NO_EXIF);
                    throw th3;
                }
            } catch (SQLiteException e4) {
                zzge().zzim().zzg("Database error while trying to delete uploaded bundles", e4);
                this.zzaqh = zzbt().elapsedRealtime();
                zzge().zzit().zzg("Disable upload, time", Long.valueOf(this.zzaqh));
            }
        } else {
            zzge().zzit().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th);
            zzgf().zzajv.set(zzbt().currentTimeMillis());
            if (i2 == 503 || i2 == 429) {
                zzgf().zzajw.set(zzbt().currentTimeMillis());
            }
            if (zzgg().zzax(str)) {
                zzix().zzc(list);
            }
            zzku();
        }
        this.zzaqm = false;
        zzkv();
        AppMethodBeat.o(Exif.PARSE_EXIF_ERROR_NO_EXIF);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgl zzgl) {
        this.zzacw = zzgl;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzjw zzjw) {
        AppMethodBeat.i(1954);
        zzab();
        zzei zzei = new zzei(this.zzacw);
        zzei.zzm();
        this.zzaqc = zzei;
        zzgg().zza(this.zzaqa);
        zzeb zzeb = new zzeb(this.zzacw);
        zzeb.zzm();
        this.zzaqf = zzeb;
        zzjn zzjn = new zzjn(this.zzacw);
        zzjn.zzm();
        this.zzaqe = zzjn;
        this.zzaqd = new zzfp(this.zzacw);
        if (this.zzaqj != this.zzaqk) {
            zzge().zzim().zze("Not all upload components initialized", Integer.valueOf(this.zzaqj), Integer.valueOf(this.zzaqk));
        }
        this.zzvo = true;
        AppMethodBeat.o(1954);
    }

    public final byte[] zza(zzeu zzeu, String str) {
        long j2;
        zzks zzks;
        AppMethodBeat.i(2005);
        zzkq();
        zzab();
        zzgl.zzfr();
        Preconditions.checkNotNull(zzeu);
        Preconditions.checkNotEmpty(str);
        zzkp zzkp = new zzkp();
        zzix().beginTransaction();
        try {
            zzdy zzbc = zzix().zzbc(str);
            if (zzbc == null) {
                zzge().zzis().zzg("Log and bundle not available. package_name", str);
                return new byte[0];
            } else if (!zzbc.isMeasurementEnabled()) {
                zzge().zzis().zzg("Log and bundle disabled. package_name", str);
                byte[] bArr = new byte[0];
                zzix().endTransaction();
                AppMethodBeat.o(2005);
                return bArr;
            } else {
                if (("_iap".equals(zzeu.name) || FirebaseAnalytics.a.ECOMMERCE_PURCHASE.equals(zzeu.name)) && !zza(str, zzeu)) {
                    zzge().zzip().zzg("Failed to handle purchase event at single event bundle creation. appId", zzfg.zzbm(str));
                }
                boolean zzav = zzgg().zzav(str);
                Long l = 0L;
                if (zzav && "_e".equals(zzeu.name)) {
                    if (zzeu.zzafq == null || zzeu.zzafq.size() == 0) {
                        zzge().zzip().zzg("The engagement event does not contain any parameters. appId", zzfg.zzbm(str));
                    } else if (zzeu.zzafq.getLong("_et") == null) {
                        zzge().zzip().zzg("The engagement event does not include duration. appId", zzfg.zzbm(str));
                    } else {
                        l = zzeu.zzafq.getLong("_et");
                    }
                }
                zzkq zzkq = new zzkq();
                zzkp.zzatf = new zzkq[]{zzkq};
                zzkq.zzath = 1;
                zzkq.zzatp = "android";
                zzkq.zzti = zzbc.zzah();
                zzkq.zzadt = zzbc.zzgn();
                zzkq.zzth = zzbc.zzag();
                long zzgm = zzbc.zzgm();
                zzkq.zzaub = zzgm == -2147483648L ? null : Integer.valueOf((int) zzgm);
                zzkq.zzatt = Long.valueOf(zzbc.zzgo());
                zzkq.zzadm = zzbc.getGmpAppId();
                zzkq.zzatx = Long.valueOf(zzbc.zzgp());
                if (this.zzacw.isEnabled() && zzef.zzhk() && zzgg().zzat(zzkq.zzti)) {
                    zzkq.zzauh = null;
                }
                Pair<String, Boolean> zzbo = zzgf().zzbo(zzbc.zzah());
                if (zzbc.zzhd() && zzbo != null && !TextUtils.isEmpty((CharSequence) zzbo.first)) {
                    zzkq.zzatv = (String) zzbo.first;
                    zzkq.zzatw = (Boolean) zzbo.second;
                }
                zzfw().zzch();
                zzkq.zzatr = Build.MODEL;
                zzfw().zzch();
                zzkq.zzatq = Build.VERSION.RELEASE;
                zzkq.zzats = Integer.valueOf((int) zzfw().zzic());
                zzkq.zzafn = zzfw().zzid();
                zzkq.zzadl = zzbc.getAppInstanceId();
                zzkq.zzado = zzbc.zzgj();
                List<zzjz> zzbb = zzix().zzbb(zzbc.zzah());
                zzkq.zzatj = new zzks[zzbb.size()];
                zzjz zzjz = null;
                if (zzav) {
                    zzjz zzh = zzix().zzh(zzkq.zzti, "_lte");
                    zzjz = (zzh == null || zzh.value == null) ? new zzjz(zzkq.zzti, "auto", "_lte", zzbt().currentTimeMillis(), l) : l.longValue() > 0 ? new zzjz(zzkq.zzti, "auto", "_lte", zzbt().currentTimeMillis(), Long.valueOf(((Long) zzh.value).longValue() + l.longValue())) : zzh;
                }
                zzks zzks2 = null;
                int i2 = 0;
                while (i2 < zzbb.size()) {
                    zzks zzks3 = new zzks();
                    zzkq.zzatj[i2] = zzks3;
                    zzks3.name = zzbb.get(i2).name;
                    zzks3.zzaun = Long.valueOf(zzbb.get(i2).zzaqz);
                    zzgb().zza(zzks3, zzbb.get(i2).value);
                    if (!zzav || !"_lte".equals(zzks3.name)) {
                        zzks = zzks2;
                    } else {
                        zzks3.zzate = (Long) zzjz.value;
                        zzks3.zzaun = Long.valueOf(zzbt().currentTimeMillis());
                        zzks = zzks3;
                    }
                    i2++;
                    zzks2 = zzks;
                }
                if (zzav && zzks2 == null) {
                    zzks zzks4 = new zzks();
                    zzks4.name = "_lte";
                    zzks4.zzaun = Long.valueOf(zzbt().currentTimeMillis());
                    zzks4.zzate = (Long) zzjz.value;
                    zzkq.zzatj = (zzks[]) Arrays.copyOf(zzkq.zzatj, zzkq.zzatj.length + 1);
                    zzkq.zzatj[zzkq.zzatj.length - 1] = zzks4;
                }
                if (l.longValue() > 0) {
                    zzix().zza(zzjz);
                }
                Bundle zzif = zzeu.zzafq.zzif();
                if ("_iap".equals(zzeu.name)) {
                    zzif.putLong("_c", 1);
                    zzge().zzis().log("Marking in-app purchase as real-time");
                    zzif.putLong("_r", 1);
                }
                zzif.putString("_o", zzeu.origin);
                if (zzgb().zzcj(zzkq.zzti)) {
                    zzgb().zza(zzif, "_dbg", (Object) 1L);
                    zzgb().zza(zzif, "_r", (Object) 1L);
                }
                zzeq zzf = zzix().zzf(str, zzeu.name);
                if (zzf == null) {
                    zzix().zza(new zzeq(str, zzeu.name, 1, 0, zzeu.zzagb, 0, null, null, null));
                    j2 = 0;
                } else {
                    j2 = zzf.zzaft;
                    zzix().zza(zzf.zzac(zzeu.zzagb).zzie());
                }
                zzep zzep = new zzep(this.zzacw, zzeu.origin, str, zzeu.name, zzeu.zzagb, j2, zzif);
                zzkn zzkn = new zzkn();
                zzkq.zzati = new zzkn[]{zzkn};
                zzkn.zzatb = Long.valueOf(zzep.timestamp);
                zzkn.name = zzep.name;
                zzkn.zzatc = Long.valueOf(zzep.zzafp);
                zzkn.zzata = new zzko[zzep.zzafq.size()];
                Iterator<String> it = zzep.zzafq.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    zzko zzko = new zzko();
                    zzkn.zzata[i3] = zzko;
                    zzko.name = next;
                    zzgb().zza(zzko, zzep.zzafq.get(next));
                    i3++;
                }
                zzkq.zzaua = zza(zzbc.zzah(), zzkq.zzatj, zzkq.zzati);
                zzkq.zzatl = zzkn.zzatb;
                zzkq.zzatm = zzkn.zzatb;
                long zzgl = zzbc.zzgl();
                zzkq.zzato = zzgl != 0 ? Long.valueOf(zzgl) : null;
                long zzgk = zzbc.zzgk();
                if (zzgk != 0) {
                    zzgl = zzgk;
                }
                zzkq.zzatn = zzgl != 0 ? Long.valueOf(zzgl) : null;
                zzbc.zzgt();
                zzkq.zzaty = Integer.valueOf((int) zzbc.zzgq());
                zzkq.zzatu = 12451L;
                zzkq.zzatk = Long.valueOf(zzbt().currentTimeMillis());
                zzkq.zzatz = Boolean.TRUE;
                zzbc.zzm(zzkq.zzatl.longValue());
                zzbc.zzn(zzkq.zzatm.longValue());
                zzix().zza(zzbc);
                zzix().setTransactionSuccessful();
                zzix().endTransaction();
                try {
                    byte[] bArr2 = new byte[zzkp.zzvm()];
                    zzabw zzb = zzabw.zzb(bArr2, 0, bArr2.length);
                    zzkp.zza(zzb);
                    zzb.zzve();
                    byte[] zza = zzgb().zza(bArr2);
                    AppMethodBeat.o(2005);
                    return zza;
                } catch (IOException e2) {
                    zzge().zzim().zze("Data loss. Failed to bundle and serialize. appId", zzfg.zzbm(str), e2);
                    AppMethodBeat.o(2005);
                    return null;
                }
            }
        } finally {
            zzix().endTransaction();
            AppMethodBeat.o(2005);
        }
    }

    public void zzab() {
        AppMethodBeat.i(1971);
        zzgd().zzab();
        AppMethodBeat.o(1971);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzed zzed, zzdz zzdz) {
        boolean z = true;
        AppMethodBeat.i(2002);
        Preconditions.checkNotNull(zzed);
        Preconditions.checkNotEmpty(zzed.packageName);
        Preconditions.checkNotNull(zzed.origin);
        Preconditions.checkNotNull(zzed.zzaep);
        Preconditions.checkNotEmpty(zzed.zzaep.name);
        zzab();
        zzkq();
        if (TextUtils.isEmpty(zzdz.zzadm)) {
            AppMethodBeat.o(2002);
        } else if (!zzdz.zzadw) {
            zzg(zzdz);
            AppMethodBeat.o(2002);
        } else {
            zzed zzed2 = new zzed(zzed);
            zzed2.active = false;
            zzix().beginTransaction();
            try {
                zzed zzi = zzix().zzi(zzed2.packageName, zzed2.zzaep.name);
                if (zzi != null && !zzi.origin.equals(zzed2.origin)) {
                    zzge().zzip().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", zzga().zzbl(zzed2.zzaep.name), zzed2.origin, zzi.origin);
                }
                if (zzi != null && zzi.active) {
                    zzed2.origin = zzi.origin;
                    zzed2.creationTimestamp = zzi.creationTimestamp;
                    zzed2.triggerTimeout = zzi.triggerTimeout;
                    zzed2.triggerEventName = zzi.triggerEventName;
                    zzed2.zzaer = zzi.zzaer;
                    zzed2.active = zzi.active;
                    zzed2.zzaep = new zzjx(zzed2.zzaep.name, zzi.zzaep.zzaqz, zzed2.zzaep.getValue(), zzi.zzaep.origin);
                    z = false;
                } else if (TextUtils.isEmpty(zzed2.triggerEventName)) {
                    zzed2.zzaep = new zzjx(zzed2.zzaep.name, zzed2.creationTimestamp, zzed2.zzaep.getValue(), zzed2.zzaep.origin);
                    zzed2.active = true;
                } else {
                    z = false;
                }
                if (zzed2.active) {
                    zzjx zzjx = zzed2.zzaep;
                    zzjz zzjz = new zzjz(zzed2.packageName, zzed2.origin, zzjx.name, zzjx.zzaqz, zzjx.getValue());
                    if (zzix().zza(zzjz)) {
                        zzge().zzis().zzd("User property updated immediately", zzed2.packageName, zzga().zzbl(zzjz.name), zzjz.value);
                    } else {
                        zzge().zzim().zzd("(2)Too many active user properties, ignoring", zzfg.zzbm(zzed2.packageName), zzga().zzbl(zzjz.name), zzjz.value);
                    }
                    if (z && zzed2.zzaer != null) {
                        zzc(new zzeu(zzed2.zzaer, zzed2.creationTimestamp), zzdz);
                    }
                }
                if (zzix().zza(zzed2)) {
                    zzge().zzis().zzd("Conditional property added", zzed2.packageName, zzga().zzbl(zzed2.zzaep.name), zzed2.zzaep.getValue());
                } else {
                    zzge().zzim().zzd("Too many conditional properties, ignoring", zzfg.zzbm(zzed2.packageName), zzga().zzbl(zzed2.zzaep.name), zzed2.zzaep.getValue());
                }
                zzix().setTransactionSuccessful();
            } finally {
                zzix().endTransaction();
                AppMethodBeat.o(2002);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzeu zzeu, zzdz zzdz) {
        List<zzed> zzb;
        List<zzed> zzb2;
        List<zzed> zzb3;
        AppMethodBeat.i(1977);
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz.packageName);
        zzab();
        zzkq();
        String str = zzdz.packageName;
        long j2 = zzeu.zzagb;
        zzgb();
        if (!zzka.zzd(zzeu, zzdz)) {
            AppMethodBeat.o(1977);
        } else if (!zzdz.zzadw) {
            zzg(zzdz);
            AppMethodBeat.o(1977);
        } else {
            zzix().beginTransaction();
            try {
                zzei zzix = zzix();
                Preconditions.checkNotEmpty(str);
                zzix.zzab();
                zzix.zzch();
                if (j2 < 0) {
                    zzix.zzge().zzip().zze("Invalid time querying timed out conditional properties", zzfg.zzbm(str), Long.valueOf(j2));
                    zzb = Collections.emptyList();
                } else {
                    zzb = zzix.zzb("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j2)});
                }
                for (zzed zzed : zzb) {
                    if (zzed != null) {
                        zzge().zzis().zzd("User property timed out", zzed.packageName, zzga().zzbl(zzed.zzaep.name), zzed.zzaep.getValue());
                        if (zzed.zzaeq != null) {
                            zzc(new zzeu(zzed.zzaeq, j2), zzdz);
                        }
                        zzix().zzj(str, zzed.zzaep.name);
                    }
                }
                zzei zzix2 = zzix();
                Preconditions.checkNotEmpty(str);
                zzix2.zzab();
                zzix2.zzch();
                if (j2 < 0) {
                    zzix2.zzge().zzip().zze("Invalid time querying expired conditional properties", zzfg.zzbm(str), Long.valueOf(j2));
                    zzb2 = Collections.emptyList();
                } else {
                    zzb2 = zzix2.zzb("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j2)});
                }
                ArrayList arrayList = new ArrayList(zzb2.size());
                for (zzed zzed2 : zzb2) {
                    if (zzed2 != null) {
                        zzge().zzis().zzd("User property expired", zzed2.packageName, zzga().zzbl(zzed2.zzaep.name), zzed2.zzaep.getValue());
                        zzix().zzg(str, zzed2.zzaep.name);
                        if (zzed2.zzaes != null) {
                            arrayList.add(zzed2.zzaes);
                        }
                        zzix().zzj(str, zzed2.zzaep.name);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    zzc(new zzeu((zzeu) obj, j2), zzdz);
                }
                zzei zzix3 = zzix();
                String str2 = zzeu.name;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzix3.zzab();
                zzix3.zzch();
                if (j2 < 0) {
                    zzix3.zzge().zzip().zzd("Invalid time querying triggered conditional properties", zzfg.zzbm(str), zzix3.zzga().zzbj(str2), Long.valueOf(j2));
                    zzb3 = Collections.emptyList();
                } else {
                    zzb3 = zzix3.zzb("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j2)});
                }
                ArrayList arrayList3 = new ArrayList(zzb3.size());
                for (zzed zzed3 : zzb3) {
                    if (zzed3 != null) {
                        zzjx zzjx = zzed3.zzaep;
                        zzjz zzjz = new zzjz(zzed3.packageName, zzed3.origin, zzjx.name, j2, zzjx.getValue());
                        if (zzix().zza(zzjz)) {
                            zzge().zzis().zzd("User property triggered", zzed3.packageName, zzga().zzbl(zzjz.name), zzjz.value);
                        } else {
                            zzge().zzim().zzd("Too many active user properties, ignoring", zzfg.zzbm(zzed3.packageName), zzga().zzbl(zzjz.name), zzjz.value);
                        }
                        if (zzed3.zzaer != null) {
                            arrayList3.add(zzed3.zzaer);
                        }
                        zzed3.zzaep = new zzjx(zzjz);
                        zzed3.active = true;
                        zzix().zza(zzed3);
                    }
                }
                zzc(zzeu, zzdz);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList4.get(i3);
                    i3++;
                    zzc(new zzeu((zzeu) obj2, j2), zzdz);
                }
                zzix().setTransactionSuccessful();
            } finally {
                zzix().endTransaction();
                AppMethodBeat.o(1977);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzjq zzjq) {
        this.zzaqj++;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzjx zzjx, zzdz zzdz) {
        int i2 = 0;
        AppMethodBeat.i(1998);
        zzab();
        zzkq();
        if (TextUtils.isEmpty(zzdz.zzadm)) {
            AppMethodBeat.o(1998);
        } else if (!zzdz.zzadw) {
            zzg(zzdz);
            AppMethodBeat.o(1998);
        } else {
            int zzcf = zzgb().zzcf(zzjx.name);
            if (zzcf != 0) {
                zzgb();
                String zza = zzka.zza(zzjx.name, 24, true);
                if (zzjx.name != null) {
                    i2 = zzjx.name.length();
                }
                zzgb().zza(zzdz.packageName, zzcf, "_ev", zza, i2);
                AppMethodBeat.o(1998);
                return;
            }
            int zzi = zzgb().zzi(zzjx.name, zzjx.getValue());
            if (zzi != 0) {
                zzgb();
                String zza2 = zzka.zza(zzjx.name, 24, true);
                Object value = zzjx.getValue();
                if (value != null && ((value instanceof String) || (value instanceof CharSequence))) {
                    i2 = String.valueOf(value).length();
                }
                zzgb().zza(zzdz.packageName, zzi, "_ev", zza2, i2);
                AppMethodBeat.o(1998);
                return;
            }
            Object zzj = zzgb().zzj(zzjx.name, zzjx.getValue());
            if (zzj == null) {
                AppMethodBeat.o(1998);
                return;
            }
            zzjz zzjz = new zzjz(zzdz.packageName, zzjx.origin, zzjx.name, zzjx.zzaqz, zzj);
            zzge().zzis().zze("Setting user property", zzga().zzbl(zzjz.name), zzj);
            zzix().beginTransaction();
            try {
                zzg(zzdz);
                boolean zza3 = zzix().zza(zzjz);
                zzix().setTransactionSuccessful();
                if (zza3) {
                    zzge().zzis().zze("User property set", zzga().zzbl(zzjz.name), zzjz.value);
                } else {
                    zzge().zzim().zze("Too many unique user properties are set. Ignoring user property", zzga().zzbl(zzjz.name), zzjz.value);
                    zzgb().zza(zzdz.packageName, 9, (String) null, (String) null, 0);
                }
            } finally {
                zzix().endTransaction();
                AppMethodBeat.o(1998);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzb(String str, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        boolean z = true;
        AppMethodBeat.i(1986);
        zzab();
        zzkq();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzaql = false;
                zzkv();
                AppMethodBeat.o(1986);
                throw th2;
            }
        }
        zzge().zzit().zzg("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zzix().beginTransaction();
        try {
            zzdy zzbc = zzix().zzbc(str);
            boolean z2 = (i2 == 200 || i2 == 204 || i2 == 304) && th == null;
            if (zzbc == null) {
                zzge().zzip().zzg("App does not exist in onConfigFetched. appId", zzfg.zzbm(str));
            } else if (z2 || i2 == 404) {
                List<String> list = map != null ? map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : list.get(0);
                if (i2 == 404 || i2 == 304) {
                    if (zzkm().zzbu(str) == null && !zzkm().zza(str, null, null)) {
                        zzix().endTransaction();
                        this.zzaql = false;
                        zzkv();
                        AppMethodBeat.o(1986);
                        return;
                    }
                } else if (!zzkm().zza(str, bArr, str2)) {
                    zzix().endTransaction();
                    this.zzaql = false;
                    zzkv();
                    AppMethodBeat.o(1986);
                    return;
                }
                zzbc.zzs(zzbt().currentTimeMillis());
                zzix().zza(zzbc);
                if (i2 == 404) {
                    zzge().zziq().zzg("Config not found. Using empty config. appId", str);
                } else {
                    zzge().zzit().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i2), Integer.valueOf(bArr.length));
                }
                if (!zzkn().zzex() || !zzkt()) {
                    zzku();
                } else {
                    zzks();
                }
            } else {
                zzbc.zzt(zzbt().currentTimeMillis());
                zzix().zza(zzbc);
                zzge().zzit().zze("Fetching config failed. code, error", Integer.valueOf(i2), th);
                zzkm().zzbw(str);
                zzgf().zzajv.set(zzbt().currentTimeMillis());
                if (!(i2 == 503 || i2 == 429)) {
                    z = false;
                }
                if (z) {
                    zzgf().zzajw.set(zzbt().currentTimeMillis());
                }
                zzku();
            }
            zzix().setTransactionSuccessful();
            zzix().endTransaction();
            this.zzaql = false;
            zzkv();
            AppMethodBeat.o(1986);
        } catch (Throwable th3) {
            zzix().endTransaction();
            AppMethodBeat.o(1986);
            throw th3;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public Clock zzbt() {
        AppMethodBeat.i(1968);
        Clock zzbt = this.zzacw.zzbt();
        AppMethodBeat.o(1968);
        return zzbt;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzed zzed, zzdz zzdz) {
        AppMethodBeat.i(2003);
        Preconditions.checkNotNull(zzed);
        Preconditions.checkNotEmpty(zzed.packageName);
        Preconditions.checkNotNull(zzed.zzaep);
        Preconditions.checkNotEmpty(zzed.zzaep.name);
        zzab();
        zzkq();
        if (TextUtils.isEmpty(zzdz.zzadm)) {
            AppMethodBeat.o(2003);
        } else if (!zzdz.zzadw) {
            zzg(zzdz);
            AppMethodBeat.o(2003);
        } else {
            zzix().beginTransaction();
            try {
                zzg(zzdz);
                zzed zzi = zzix().zzi(zzed.packageName, zzed.zzaep.name);
                if (zzi != null) {
                    zzge().zzis().zze("Removing conditional user property", zzed.packageName, zzga().zzbl(zzed.zzaep.name));
                    zzix().zzj(zzed.packageName, zzed.zzaep.name);
                    if (zzi.active) {
                        zzix().zzg(zzed.packageName, zzed.zzaep.name);
                    }
                    if (zzed.zzaes != null) {
                        Bundle bundle = null;
                        if (zzed.zzaes.zzafq != null) {
                            bundle = zzed.zzaes.zzafq.zzif();
                        }
                        zzc(zzgb().zza(zzed.zzaes.name, bundle, zzi.origin, zzed.zzaes.zzagb, true, false), zzdz);
                    }
                } else {
                    zzge().zzip().zze("Conditional user property doesn't exist", zzfg.zzbm(zzed.packageName), zzga().zzbl(zzed.zzaep.name));
                }
                zzix().setTransactionSuccessful();
            } finally {
                zzix().endTransaction();
                AppMethodBeat.o(2003);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzeu zzeu, String str) {
        AppMethodBeat.i(1976);
        zzdy zzbc = zzix().zzbc(str);
        if (zzbc == null || TextUtils.isEmpty(zzbc.zzag())) {
            zzge().zzis().zzg("No app data available; dropping event", str);
            AppMethodBeat.o(1976);
            return;
        }
        Boolean zzc = zzc(zzbc);
        if (zzc == null) {
            if (!"_ui".equals(zzeu.name)) {
                zzge().zzip().zzg("Could not find package. appId", zzfg.zzbm(str));
            }
        } else if (!zzc.booleanValue()) {
            zzge().zzim().zzg("App version does not match; dropping event. appId", zzfg.zzbm(str));
            AppMethodBeat.o(1976);
            return;
        }
        zzb(zzeu, new zzdz(str, zzbc.getGmpAppId(), zzbc.zzag(), zzbc.zzgm(), zzbc.zzgn(), zzbc.zzgo(), zzbc.zzgp(), (String) null, zzbc.isMeasurementEnabled(), false, zzbc.zzgj(), zzbc.zzhc(), 0L, 0, zzbc.zzhd(), zzbc.zzhe(), false));
        AppMethodBeat.o(1976);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzjx zzjx, zzdz zzdz) {
        AppMethodBeat.i(1999);
        zzab();
        zzkq();
        if (TextUtils.isEmpty(zzdz.zzadm)) {
            AppMethodBeat.o(1999);
        } else if (!zzdz.zzadw) {
            zzg(zzdz);
            AppMethodBeat.o(1999);
        } else {
            zzge().zzis().zzg("Removing user property", zzga().zzbl(zzjx.name));
            zzix().beginTransaction();
            try {
                zzg(zzdz);
                zzix().zzg(zzdz.packageName, zzjx.name);
                zzix().setTransactionSuccessful();
                zzge().zzis().zzg("User property removed", zzga().zzbl(zzjx.name));
            } finally {
                zzix().endTransaction();
                AppMethodBeat.o(1999);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzdz zzcb(String str) {
        AppMethodBeat.i(2001);
        zzdy zzbc = zzix().zzbc(str);
        if (zzbc == null || TextUtils.isEmpty(zzbc.zzag())) {
            zzge().zzis().zzg("No app data available; dropping", str);
            AppMethodBeat.o(2001);
            return null;
        }
        Boolean zzc = zzc(zzbc);
        if (zzc == null || zzc.booleanValue()) {
            zzdz zzdz = new zzdz(str, zzbc.getGmpAppId(), zzbc.zzag(), zzbc.zzgm(), zzbc.zzgn(), zzbc.zzgo(), zzbc.zzgp(), (String) null, zzbc.isMeasurementEnabled(), false, zzbc.zzgj(), zzbc.zzhc(), 0L, 0, zzbc.zzhd(), zzbc.zzhe(), false);
            AppMethodBeat.o(2001);
            return zzdz;
        }
        zzge().zzim().zzg("App version does not match; dropping. appId", zzfg.zzbm(str));
        AppMethodBeat.o(2001);
        return null;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzd(zzdz zzdz) {
        AppMethodBeat.i(1996);
        if (this.zzaqq != null) {
            this.zzaqr = new ArrayList();
            this.zzaqr.addAll(this.zzaqq);
        }
        zzei zzix = zzix();
        String str = zzdz.packageName;
        Preconditions.checkNotEmpty(str);
        zzix.zzab();
        zzix.zzch();
        try {
            SQLiteDatabase writableDatabase = zzix.getWritableDatabase();
            String[] strArr = {str};
            int delete = writableDatabase.delete("main_event_params", "app_id=?", strArr) + writableDatabase.delete("apps", "app_id=?", strArr) + 0 + writableDatabase.delete("events", "app_id=?", strArr) + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("queue", "app_id=?", strArr) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr);
            if (delete > 0) {
                zzix.zzge().zzit().zze("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            zzix.zzge().zzim().zze("Error resetting analytics data. appId, error", zzfg.zzbm(str), e2);
        }
        zzdz zza = zza(getContext(), zzdz.packageName, zzdz.zzadm, zzdz.zzadw, zzdz.zzady, zzdz.zzadz, zzdz.zzaem);
        if (!zzgg().zzaz(zzdz.packageName) || zzdz.zzadw) {
            zzf(zza);
        }
        AppMethodBeat.o(1996);
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzdz zzdz) {
        AppMethodBeat.i(1974);
        zzab();
        zzkq();
        Preconditions.checkNotEmpty(zzdz.packageName);
        zzg(zzdz);
        AppMethodBeat.o(1974);
    }

    public final void zzf(zzdz zzdz) {
        int i2;
        ApplicationInfo applicationInfo;
        AppMethodBeat.i(2000);
        zzab();
        zzkq();
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz.packageName);
        if (TextUtils.isEmpty(zzdz.zzadm)) {
            AppMethodBeat.o(2000);
            return;
        }
        zzdy zzbc = zzix().zzbc(zzdz.packageName);
        if (zzbc != null && TextUtils.isEmpty(zzbc.getGmpAppId()) && !TextUtils.isEmpty(zzdz.zzadm)) {
            zzbc.zzs(0);
            zzix().zza(zzbc);
            zzkm().zzbx(zzdz.packageName);
        }
        if (!zzdz.zzadw) {
            zzg(zzdz);
            AppMethodBeat.o(2000);
            return;
        }
        long j2 = zzdz.zzaem;
        if (j2 == 0) {
            j2 = zzbt().currentTimeMillis();
        }
        int i3 = zzdz.zzaen;
        if (i3 == 0 || i3 == 1) {
            i2 = i3;
        } else {
            zzge().zzip().zze("Incorrect app type, assuming installed app. appId, appType", zzfg.zzbm(zzdz.packageName), Integer.valueOf(i3));
            i2 = 0;
        }
        zzix().beginTransaction();
        try {
            zzdy zzbc2 = zzix().zzbc(zzdz.packageName);
            if (!(zzbc2 == null || zzbc2.getGmpAppId() == null || zzbc2.getGmpAppId().equals(zzdz.zzadm))) {
                zzge().zzip().zzg("New GMP App Id passed in. Removing cached database data. appId", zzfg.zzbm(zzbc2.zzah()));
                zzei zzix = zzix();
                String zzah = zzbc2.zzah();
                zzix.zzch();
                zzix.zzab();
                Preconditions.checkNotEmpty(zzah);
                try {
                    SQLiteDatabase writableDatabase = zzix.getWritableDatabase();
                    String[] strArr = {zzah};
                    int delete = writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + writableDatabase.delete("events", "app_id=?", strArr) + 0 + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("apps", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("event_filters", "app_id=?", strArr) + writableDatabase.delete("property_filters", "app_id=?", strArr);
                    if (delete > 0) {
                        zzix.zzge().zzit().zze("Deleted application data. app, records", zzah, Integer.valueOf(delete));
                    }
                } catch (SQLiteException e2) {
                    zzix.zzge().zzim().zze("Error deleting application data. appId, error", zzfg.zzbm(zzah), e2);
                }
                zzbc2 = null;
            }
            if (zzbc2 != null) {
                if (zzbc2.zzgm() != -2147483648L) {
                    if (zzbc2.zzgm() != zzdz.zzads) {
                        Bundle bundle = new Bundle();
                        bundle.putString("_pv", zzbc2.zzag());
                        zzb(new zzeu("_au", new zzer(bundle), "auto", j2), zzdz);
                    }
                } else if (zzbc2.zzag() != null && !zzbc2.zzag().equals(zzdz.zzth)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_pv", zzbc2.zzag());
                    zzb(new zzeu("_au", new zzer(bundle2), "auto", j2), zzdz);
                }
            }
            zzg(zzdz);
            zzeq zzeq = null;
            if (i2 == 0) {
                zzeq = zzix().zzf(zzdz.packageName, "_f");
            } else if (i2 == 1) {
                zzeq = zzix().zzf(zzdz.packageName, "_v");
            }
            if (zzeq == null) {
                long j3 = (1 + (j2 / Util.MILLSECONDS_OF_HOUR)) * Util.MILLSECONDS_OF_HOUR;
                if (i2 == 0) {
                    zzb(new zzjx("_fot", j2, Long.valueOf(j3), "auto"), zzdz);
                    zzab();
                    zzkq();
                    Bundle bundle3 = new Bundle();
                    bundle3.putLong("_c", 1);
                    bundle3.putLong("_r", 1);
                    bundle3.putLong("_uwa", 0);
                    bundle3.putLong("_pfo", 0);
                    bundle3.putLong("_sys", 0);
                    bundle3.putLong("_sysu", 0);
                    if (zzgg().zzaz(zzdz.packageName) && zzdz.zzaeo) {
                        bundle3.putLong("_dac", 1);
                    }
                    if (getContext().getPackageManager() == null) {
                        zzge().zzim().zzg("PackageManager is null, first open report might be inaccurate. appId", zzfg.zzbm(zzdz.packageName));
                    } else {
                        PackageInfo packageInfo = null;
                        try {
                            packageInfo = Wrappers.packageManager(getContext()).getPackageInfo(zzdz.packageName, 0);
                        } catch (PackageManager.NameNotFoundException e3) {
                            zzge().zzim().zze("Package info is null, first open report might be inaccurate. appId", zzfg.zzbm(zzdz.packageName), e3);
                        }
                        if (!(packageInfo == null || packageInfo.firstInstallTime == 0)) {
                            boolean z = false;
                            if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                bundle3.putLong("_uwa", 1);
                            } else {
                                z = true;
                            }
                            zzb(new zzjx("_fi", j2, Long.valueOf(z ? 1 : 0), "auto"), zzdz);
                        }
                        try {
                            applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(zzdz.packageName, 0);
                        } catch (PackageManager.NameNotFoundException e4) {
                            zzge().zzim().zze("Application info is null, first open report might be inaccurate. appId", zzfg.zzbm(zzdz.packageName), e4);
                            applicationInfo = null;
                        }
                        if (applicationInfo != null) {
                            if ((applicationInfo.flags & 1) != 0) {
                                bundle3.putLong("_sys", 1);
                            }
                            if ((applicationInfo.flags & 128) != 0) {
                                bundle3.putLong("_sysu", 1);
                            }
                        }
                    }
                    zzei zzix2 = zzix();
                    String str = zzdz.packageName;
                    Preconditions.checkNotEmpty(str);
                    zzix2.zzab();
                    zzix2.zzch();
                    long zzm = zzix2.zzm(str, "first_open_count");
                    if (zzm >= 0) {
                        bundle3.putLong("_pfo", zzm);
                    }
                    zzb(new zzeu("_f", new zzer(bundle3), "auto", j2), zzdz);
                } else if (i2 == 1) {
                    zzb(new zzjx("_fvt", j2, Long.valueOf(j3), "auto"), zzdz);
                    zzab();
                    zzkq();
                    Bundle bundle4 = new Bundle();
                    bundle4.putLong("_c", 1);
                    bundle4.putLong("_r", 1);
                    if (zzgg().zzaz(zzdz.packageName) && zzdz.zzaeo) {
                        bundle4.putLong("_dac", 1);
                    }
                    zzb(new zzeu("_v", new zzer(bundle4), "auto", j2), zzdz);
                }
                Bundle bundle5 = new Bundle();
                bundle5.putLong("_et", 1);
                zzb(new zzeu("_e", new zzer(bundle5), "auto", j2), zzdz);
            } else if (zzdz.zzael) {
                zzb(new zzeu("_cd", new zzer(new Bundle()), "auto", j2), zzdz);
            }
            zzix().setTransactionSuccessful();
        } finally {
            zzix().endTransaction();
            AppMethodBeat.o(2000);
        }
    }

    public zzeo zzfw() {
        AppMethodBeat.i(1970);
        zzeo zzfw = this.zzacw.zzfw();
        AppMethodBeat.o(1970);
        return zzfw;
    }

    /* access modifiers changed from: package-private */
    public final void zzg(Runnable runnable) {
        AppMethodBeat.i(1988);
        zzab();
        if (this.zzaqi == null) {
            this.zzaqi = new ArrayList();
        }
        this.zzaqi.add(runnable);
        AppMethodBeat.o(1988);
    }

    public zzfe zzga() {
        AppMethodBeat.i(1966);
        zzfe zzga = this.zzacw.zzga();
        AppMethodBeat.o(1966);
        return zzga;
    }

    public zzka zzgb() {
        AppMethodBeat.i(1969);
        zzka zzgb = this.zzacw.zzgb();
        AppMethodBeat.o(1969);
        return zzgb;
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public zzgg zzgd() {
        AppMethodBeat.i(1959);
        zzgg zzgd = this.zzacw.zzgd();
        AppMethodBeat.o(1959);
        return zzgd;
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public zzfg zzge() {
        AppMethodBeat.i(1958);
        zzfg zzge = this.zzacw.zzge();
        AppMethodBeat.o(1958);
        return zzge;
    }

    public zzfr zzgf() {
        AppMethodBeat.i(1957);
        zzfr zzgf = this.zzacw.zzgf();
        AppMethodBeat.o(1957);
        return zzgf;
    }

    public zzef zzgg() {
        AppMethodBeat.i(1956);
        zzef zzgg = this.zzacw.zzgg();
        AppMethodBeat.o(1956);
        return zzgg;
    }

    public final String zzh(zzdz zzdz) {
        AppMethodBeat.i(2006);
        try {
            String str = (String) zzgd().zzb(new zzju(this, zzdz)).get(30000, TimeUnit.MILLISECONDS);
            AppMethodBeat.o(2006);
            return str;
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            zzge().zzim().zze("Failed to get app instance id. appId", zzfg.zzbm(zzdz.packageName), e2);
            AppMethodBeat.o(2006);
            return null;
        }
    }

    public final zzeb zziw() {
        AppMethodBeat.i(1965);
        zza(this.zzaqf);
        zzeb zzeb = this.zzaqf;
        AppMethodBeat.o(1965);
        return zzeb;
    }

    public final zzei zzix() {
        AppMethodBeat.i(1962);
        zza(this.zzaqc);
        zzei zzei = this.zzaqc;
        AppMethodBeat.o(1962);
        return zzei;
    }

    public final zzfk zzkn() {
        AppMethodBeat.i(1961);
        zza(this.zzaqb);
        zzfk zzfk = this.zzaqb;
        AppMethodBeat.o(1961);
        return zzfk;
    }

    /* access modifiers changed from: package-private */
    public final void zzkq() {
        AppMethodBeat.i(1972);
        if (!this.zzvo) {
            IllegalStateException illegalStateException = new IllegalStateException("UploadController is not initialized");
            AppMethodBeat.o(1972);
            throw illegalStateException;
        }
        AppMethodBeat.o(1972);
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0233 A[Catch:{ MalformedURLException -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x023b A[Catch:{ MalformedURLException -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x025a A[Catch:{ MalformedURLException -> 0x02b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzks() {
        /*
        // Method dump skipped, instructions count: 771
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjr.zzks():void");
    }

    /* access modifiers changed from: package-private */
    public final void zzkx() {
        AppMethodBeat.i(1994);
        zzab();
        zzkq();
        if (!this.zzaqg) {
            zzge().zzir().log("This instance being marked as an uploader");
            zzab();
            zzkq();
            if (zzky() && zzkw()) {
                int zza = zza(this.zzaqp);
                int zzij = this.zzacw.zzfv().zzij();
                zzab();
                if (zza > zzij) {
                    zzge().zzim().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza), Integer.valueOf(zzij));
                } else if (zza < zzij) {
                    if (zza(zzij, this.zzaqp)) {
                        zzge().zzit().zze("Storage version upgraded. Previous, current version", Integer.valueOf(zza), Integer.valueOf(zzij));
                    } else {
                        zzge().zzim().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza), Integer.valueOf(zzij));
                    }
                }
            }
            this.zzaqg = true;
            zzku();
        }
        AppMethodBeat.o(1994);
    }

    /* access modifiers changed from: package-private */
    public final void zzkz() {
        this.zzaqk++;
    }

    /* access modifiers changed from: package-private */
    public final zzgl zzla() {
        return this.zzacw;
    }

    public final void zzm(boolean z) {
        AppMethodBeat.i(2007);
        zzku();
        AppMethodBeat.o(2007);
    }
}
