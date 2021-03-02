package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class zzei extends zzjq {
    private static final String[] zzaev = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};
    private static final String[] zzaew = {FirebaseAnalytics.b.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzaex = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;"};
    private static final String[] zzaey = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzaez = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzafa = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzel zzafb = new zzel(this, getContext(), "google_app_measurement.db");
    private final zzjm zzafc = new zzjm(zzbt());

    zzei(zzjr zzjr) {
        super(zzjr);
        AppMethodBeat.i(1161);
        AppMethodBeat.o(1161);
    }

    private final long zza(String str, String[] strArr) {
        AppMethodBeat.i(1165);
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(1165);
                return j2;
            }
            SQLiteException sQLiteException = new SQLiteException("Database returned empty set");
            AppMethodBeat.o(1165);
            throw sQLiteException;
        } catch (SQLiteException e2) {
            zzge().zzim().zze("Database error", str, e2);
            AppMethodBeat.o(1165);
            throw e2;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(1165);
            throw th;
        }
    }

    private final long zza(String str, String[] strArr, long j2) {
        AppMethodBeat.i(1166);
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(1166);
            } else {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(1166);
            }
            return j2;
        } catch (SQLiteException e2) {
            zzge().zzim().zze("Database error", str, e2);
            AppMethodBeat.o(1166);
            throw e2;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(1166);
            throw th;
        }
    }

    @VisibleForTesting
    private final Object zza(Cursor cursor, int i2) {
        AppMethodBeat.i(1199);
        int type = cursor.getType(i2);
        switch (type) {
            case 0:
                zzge().zzim().log("Loaded invalid null value from database");
                AppMethodBeat.o(1199);
                return null;
            case 1:
                Long valueOf = Long.valueOf(cursor.getLong(i2));
                AppMethodBeat.o(1199);
                return valueOf;
            case 2:
                Double valueOf2 = Double.valueOf(cursor.getDouble(i2));
                AppMethodBeat.o(1199);
                return valueOf2;
            case 3:
                String string = cursor.getString(i2);
                AppMethodBeat.o(1199);
                return string;
            case 4:
                zzge().zzim().log("Loaded invalid blob type value, ignoring it");
                AppMethodBeat.o(1199);
                return null;
            default:
                zzge().zzim().zzg("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                AppMethodBeat.o(1199);
                return null;
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        AppMethodBeat.i(1198);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
            AppMethodBeat.o(1198);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
            AppMethodBeat.o(1198);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
            AppMethodBeat.o(1198);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid value type");
            AppMethodBeat.o(1198);
            throw illegalArgumentException;
        }
    }

    static void zza(zzfg zzfg, SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(1216);
        if (zzfg == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Monitor must not be null");
            AppMethodBeat.o(1216);
            throw illegalArgumentException;
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            zzfg.zzip().log("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzfg.zzip().log("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzfg.zzip().log("Failed to turn on database read permission for owner");
        }
        if (!file.setWritable(true, true)) {
            zzfg.zzip().log("Failed to turn on database write permission for owner");
        }
        AppMethodBeat.o(1216);
    }

    static void zza(zzfg zzfg, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) {
        AppMethodBeat.i(1215);
        if (zzfg == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Monitor must not be null");
            AppMethodBeat.o(1215);
            throw illegalArgumentException;
        }
        if (!zza(zzfg, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        if (zzfg == null) {
            try {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Monitor must not be null");
                AppMethodBeat.o(1215);
                throw illegalArgumentException2;
            } catch (SQLiteException e2) {
                zzfg.zzim().zzg("Failed to verify columns on table that was just created", str);
                AppMethodBeat.o(1215);
                throw e2;
            }
        } else {
            Set<String> zzb = zzb(sQLiteDatabase, str);
            String[] split = str3.split(",");
            for (String str4 : split) {
                if (!zzb.remove(str4)) {
                    SQLiteException sQLiteException = new SQLiteException(new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str4).length()).append("Table ").append(str).append(" is missing required column: ").append(str4).toString());
                    AppMethodBeat.o(1215);
                    throw sQLiteException;
                }
            }
            if (strArr != null) {
                for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                    if (!zzb.remove(strArr[i2])) {
                        sQLiteDatabase.execSQL(strArr[i2 + 1]);
                    }
                }
            }
            if (!zzb.isEmpty()) {
                zzfg.zzip().zze("Table has extra columns. table, columns", str, TextUtils.join(", ", zzb));
            }
            AppMethodBeat.o(1215);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zza(com.google.android.gms.internal.measurement.zzfg r11, android.database.sqlite.SQLiteDatabase r12, java.lang.String r13) {
        /*
            r8 = 0
            r9 = 0
            r10 = 1213(0x4bd, float:1.7E-42)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r10)
            if (r11 != 0) goto L_0x0015
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Monitor must not be null"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r10)
            throw r0
        L_0x0015:
            java.lang.String r1 = "SQLITE_MASTER"
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x003f, all -> 0x0055 }
            r0 = 0
            java.lang.String r3 = "name"
            r2[r0] = r3     // Catch:{ SQLiteException -> 0x003f, all -> 0x0055 }
            java.lang.String r3 = "name=?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x003f, all -> 0x0055 }
            r0 = 0
            r4[r0] = r13     // Catch:{ SQLiteException -> 0x003f, all -> 0x0055 }
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r12
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x003f, all -> 0x0055 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0062 }
            if (r1 == 0) goto L_0x003b
            r1.close()
        L_0x003b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r10)
        L_0x003e:
            return r0
        L_0x003f:
            r0 = move-exception
            r1 = r9
        L_0x0041:
            com.google.android.gms.internal.measurement.zzfi r2 = r11.zzip()     // Catch:{ all -> 0x005f }
            java.lang.String r3 = "Error querying for table"
            r2.zze(r3, r13, r0)     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x0050
            r1.close()
        L_0x0050:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r10)
            r0 = r8
            goto L_0x003e
        L_0x0055:
            r0 = move-exception
        L_0x0056:
            if (r9 == 0) goto L_0x005b
            r9.close()
        L_0x005b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r10)
            throw r0
        L_0x005f:
            r0 = move-exception
            r9 = r1
            goto L_0x0056
        L_0x0062:
            r0 = move-exception
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zza(com.google.android.gms.internal.measurement.zzfg, android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    private final boolean zza(String str, int i2, zzke zzke) {
        AppMethodBeat.i(1192);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzke);
        if (TextUtils.isEmpty(zzke.zzarq)) {
            zzge().zzip().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzfg.zzbm(str), Integer.valueOf(i2), String.valueOf(zzke.zzarp));
            AppMethodBeat.o(1192);
            return false;
        }
        try {
            byte[] bArr = new byte[zzke.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzke.zza(zzb);
            zzb.zzve();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i2));
            contentValues.put("filter_id", zzke.zzarp);
            contentValues.put("event_name", zzke.zzarq);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                    zzge().zzim().zzg("Failed to insert event filter (got -1). appId", zzfg.zzbm(str));
                }
                AppMethodBeat.o(1192);
                return true;
            } catch (SQLiteException e2) {
                zzge().zzim().zze("Error storing event filter. appId", zzfg.zzbm(str), e2);
                AppMethodBeat.o(1192);
                return false;
            }
        } catch (IOException e3) {
            zzge().zzim().zze("Configuration loss. Failed to serialize event filter. appId", zzfg.zzbm(str), e3);
            AppMethodBeat.o(1192);
            return false;
        }
    }

    private final boolean zza(String str, int i2, zzkh zzkh) {
        AppMethodBeat.i(1193);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzkh);
        if (TextUtils.isEmpty(zzkh.zzasf)) {
            zzge().zzip().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzfg.zzbm(str), Integer.valueOf(i2), String.valueOf(zzkh.zzarp));
            AppMethodBeat.o(1193);
            return false;
        }
        try {
            byte[] bArr = new byte[zzkh.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkh.zza(zzb);
            zzb.zzve();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i2));
            contentValues.put("filter_id", zzkh.zzarp);
            contentValues.put("property_name", zzkh.zzasf);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) == -1) {
                    zzge().zzim().zzg("Failed to insert property filter (got -1). appId", zzfg.zzbm(str));
                    AppMethodBeat.o(1193);
                    return false;
                }
                AppMethodBeat.o(1193);
                return true;
            } catch (SQLiteException e2) {
                zzge().zzim().zze("Error storing property filter. appId", zzfg.zzbm(str), e2);
                AppMethodBeat.o(1193);
                return false;
            }
        } catch (IOException e3) {
            zzge().zzim().zze("Configuration loss. Failed to serialize property filter. appId", zzfg.zzbm(str), e3);
            AppMethodBeat.o(1193);
            return false;
        }
    }

    private final boolean zza(String str, List<Integer> list) {
        AppMethodBeat.i(1196);
        Preconditions.checkNotEmpty(str);
        zzch();
        zzab();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            long zza = zza("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzgg().zzb(str, zzew.zzahn)));
            if (zza <= ((long) max)) {
                AppMethodBeat.o(1196);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num = list.get(i2);
                if (num == null || !(num instanceof Integer)) {
                    AppMethodBeat.o(1196);
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            String sb = new StringBuilder(String.valueOf(join).length() + 2).append("(").append(join).append(")").toString();
            if (writableDatabase.delete("audience_filter_values", new StringBuilder(String.valueOf(sb).length() + 140).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(sb).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(max)}) > 0) {
                AppMethodBeat.o(1196);
                return true;
            }
            AppMethodBeat.o(1196);
            return false;
        } catch (SQLiteException e2) {
            zzge().zzim().zze("Database error querying filters. appId", zzfg.zzbm(str), e2);
            AppMethodBeat.o(1196);
            return false;
        }
    }

    private static Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        AppMethodBeat.i(1214);
        HashSet hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(1214);
        }
    }

    private final boolean zzhv() {
        AppMethodBeat.i(1212);
        boolean exists = getContext().getDatabasePath("google_app_measurement.db").exists();
        AppMethodBeat.o(1212);
        return exists;
    }

    public final void beginTransaction() {
        AppMethodBeat.i(1162);
        zzch();
        getWritableDatabase().beginTransaction();
        AppMethodBeat.o(1162);
    }

    public final void endTransaction() {
        AppMethodBeat.i(1164);
        zzch();
        getWritableDatabase().endTransaction();
        AppMethodBeat.o(1164);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final SQLiteDatabase getWritableDatabase() {
        AppMethodBeat.i(1167);
        zzab();
        try {
            SQLiteDatabase writableDatabase = this.zzafb.getWritableDatabase();
            AppMethodBeat.o(1167);
            return writableDatabase;
        } catch (SQLiteException e2) {
            zzge().zzip().zzg("Error opening database", e2);
            AppMethodBeat.o(1167);
            throw e2;
        }
    }

    public final void setTransactionSuccessful() {
        AppMethodBeat.i(1163);
        zzch();
        getWritableDatabase().setTransactionSuccessful();
        AppMethodBeat.o(1163);
    }

    public final long zza(zzkq zzkq) {
        long zzc;
        AppMethodBeat.i(TXLiteAVCode.WARNING_MICROPHONE_NOT_AUTHORIZED);
        zzab();
        zzch();
        Preconditions.checkNotNull(zzkq);
        Preconditions.checkNotEmpty(zzkq.zzti);
        try {
            byte[] bArr = new byte[zzkq.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkq.zza(zzb);
            zzb.zzve();
            zzka zzgb = zzgb();
            Preconditions.checkNotNull(bArr);
            zzgb.zzab();
            MessageDigest messageDigest = zzka.getMessageDigest("MD5");
            if (messageDigest == null) {
                zzgb.zzge().zzim().log("Failed to get MD5");
                zzc = 0;
            } else {
                zzc = zzka.zzc(messageDigest.digest(bArr));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzkq.zzti);
            contentValues.put("metadata_fingerprint", Long.valueOf(zzc));
            contentValues.put("metadata", bArr);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                AppMethodBeat.o(TXLiteAVCode.WARNING_MICROPHONE_NOT_AUTHORIZED);
                return zzc;
            } catch (SQLiteException e2) {
                zzge().zzim().zze("Error storing raw event metadata. appId", zzfg.zzbm(zzkq.zzti), e2);
                AppMethodBeat.o(TXLiteAVCode.WARNING_MICROPHONE_NOT_AUTHORIZED);
                throw e2;
            }
        } catch (IOException e3) {
            zzge().zzim().zze("Data loss. Failed to serialize event metadata. appId", zzfg.zzbm(zzkq.zzti), e3);
            AppMethodBeat.o(TXLiteAVCode.WARNING_MICROPHONE_NOT_AUTHORIZED);
            throw e3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzkn, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
        // Method dump skipped, instructions count: 175
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x015b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzej zza(long r12, java.lang.String r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19) {
        /*
        // Method dump skipped, instructions count: 360
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zza(long, java.lang.String, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.internal.measurement.zzej");
    }

    public final void zza(zzdy zzdy) {
        AppMethodBeat.i(1181);
        Preconditions.checkNotNull(zzdy);
        zzab();
        zzch();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzdy.zzah());
        contentValues.put("app_instance_id", zzdy.getAppInstanceId());
        contentValues.put("gmp_app_id", zzdy.getGmpAppId());
        contentValues.put("resettable_device_id_hash", zzdy.zzgi());
        contentValues.put("last_bundle_index", Long.valueOf(zzdy.zzgq()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzdy.zzgk()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzdy.zzgl()));
        contentValues.put("app_version", zzdy.zzag());
        contentValues.put("app_store", zzdy.zzgn());
        contentValues.put("gmp_version", Long.valueOf(zzdy.zzgo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzdy.zzgp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzdy.isMeasurementEnabled()));
        contentValues.put("day", Long.valueOf(zzdy.zzgu()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzdy.zzgv()));
        contentValues.put("daily_events_count", Long.valueOf(zzdy.zzgw()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzdy.zzgx()));
        contentValues.put("config_fetched_time", Long.valueOf(zzdy.zzgr()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzdy.zzgs()));
        contentValues.put("app_version_int", Long.valueOf(zzdy.zzgm()));
        contentValues.put("firebase_instance_id", zzdy.zzgj());
        contentValues.put("daily_error_events_count", Long.valueOf(zzdy.zzgz()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzdy.zzgy()));
        contentValues.put("health_monitor_sample", zzdy.zzha());
        contentValues.put("android_id", Long.valueOf(zzdy.zzhc()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzdy.zzhd()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzdy.zzhe()));
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (((long) writableDatabase.update("apps", contentValues, "app_id = ?", new String[]{zzdy.zzah()})) == 0 && writableDatabase.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update app (got -1). appId", zzfg.zzbm(zzdy.zzah()));
            }
            AppMethodBeat.o(1181);
        } catch (SQLiteException e2) {
            zzge().zzim().zze("Error storing app. appId", zzfg.zzbm(zzdy.zzah()), e2);
            AppMethodBeat.o(1181);
        }
    }

    public final void zza(zzeq zzeq) {
        long j2 = null;
        AppMethodBeat.i(1169);
        Preconditions.checkNotNull(zzeq);
        zzab();
        zzch();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzeq.zzti);
        contentValues.put("name", zzeq.name);
        contentValues.put("lifetime_count", Long.valueOf(zzeq.zzafr));
        contentValues.put("current_bundle_count", Long.valueOf(zzeq.zzafs));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzeq.zzaft));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzeq.zzafu));
        contentValues.put("last_sampled_complex_event_id", zzeq.zzafv);
        contentValues.put("last_sampling_rate", zzeq.zzafw);
        if (zzeq.zzafx != null && zzeq.zzafx.booleanValue()) {
            j2 = 1L;
        }
        contentValues.put("last_exempt_from_sampling", j2);
        try {
            if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update event aggregates (got -1). appId", zzfg.zzbm(zzeq.zzti));
            }
            AppMethodBeat.o(1169);
        } catch (SQLiteException e2) {
            zzge().zzim().zze("Error storing event aggregates. appId", zzfg.zzbm(zzeq.zzti), e2);
            AppMethodBeat.o(1169);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzkd[] zzkdArr) {
        boolean z;
        AppMethodBeat.i(1191);
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzkdArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzch();
            zzab();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase writableDatabase2 = getWritableDatabase();
            writableDatabase2.delete("property_filters", "app_id=?", new String[]{str});
            writableDatabase2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzkd zzkd : zzkdArr) {
                zzch();
                zzab();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzkd);
                Preconditions.checkNotNull(zzkd.zzarn);
                Preconditions.checkNotNull(zzkd.zzarm);
                if (zzkd.zzarl == null) {
                    zzge().zzip().zzg("Audience with no ID. appId", zzfg.zzbm(str));
                } else {
                    int intValue = zzkd.zzarl.intValue();
                    zzke[] zzkeArr = zzkd.zzarn;
                    int length = zzkeArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            zzkh[] zzkhArr = zzkd.zzarm;
                            int length2 = zzkhArr.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= length2) {
                                    zzke[] zzkeArr2 = zzkd.zzarn;
                                    int length3 = zzkeArr2.length;
                                    int i4 = 0;
                                    while (true) {
                                        if (i4 >= length3) {
                                            z = true;
                                            break;
                                        } else if (!zza(str, intValue, zzkeArr2[i4])) {
                                            z = false;
                                            break;
                                        } else {
                                            i4++;
                                        }
                                    }
                                    if (z) {
                                        zzkh[] zzkhArr2 = zzkd.zzarm;
                                        int length4 = zzkhArr2.length;
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 >= length4) {
                                                break;
                                            } else if (!zza(str, intValue, zzkhArr2[i5])) {
                                                z = false;
                                                break;
                                            } else {
                                                i5++;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzch();
                                        zzab();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase writableDatabase3 = getWritableDatabase();
                                        writableDatabase3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                                        writableDatabase3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                                    }
                                } else if (zzkhArr[i3].zzarp == null) {
                                    zzge().zzip().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", zzfg.zzbm(str), zzkd.zzarl);
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                        } else if (zzkeArr[i2].zzarp == null) {
                            zzge().zzip().zze("Event filter with no ID. Audience definition ignored. appId, audienceId", zzfg.zzbm(str), zzkd.zzarl);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzkd zzkd2 : zzkdArr) {
                arrayList.add(zzkd2.zzarl);
            }
            zza(str, arrayList);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
            AppMethodBeat.o(1191);
        }
    }

    public final boolean zza(zzed zzed) {
        AppMethodBeat.i(1175);
        Preconditions.checkNotNull(zzed);
        zzab();
        zzch();
        if (zzh(zzed.packageName, zzed.zzaep.name) == null) {
            if (zza("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzed.packageName}) >= 1000) {
                AppMethodBeat.o(1175);
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzed.packageName);
        contentValues.put(FirebaseAnalytics.b.ORIGIN, zzed.origin);
        contentValues.put("name", zzed.zzaep.name);
        zza(contentValues, "value", zzed.zzaep.getValue());
        contentValues.put("active", Boolean.valueOf(zzed.active));
        contentValues.put("trigger_event_name", zzed.triggerEventName);
        contentValues.put("trigger_timeout", Long.valueOf(zzed.triggerTimeout));
        zzgb();
        contentValues.put("timed_out_event", zzka.zza(zzed.zzaeq));
        contentValues.put("creation_timestamp", Long.valueOf(zzed.creationTimestamp));
        zzgb();
        contentValues.put("triggered_event", zzka.zza(zzed.zzaer));
        contentValues.put("triggered_timestamp", Long.valueOf(zzed.zzaep.zzaqz));
        contentValues.put("time_to_live", Long.valueOf(zzed.timeToLive));
        zzgb();
        contentValues.put("expired_event", zzka.zza(zzed.zzaes));
        try {
            if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update conditional user property (got -1)", zzfg.zzbm(zzed.packageName));
            }
        } catch (SQLiteException e2) {
            zzge().zzim().zze("Error storing conditional user property", zzfg.zzbm(zzed.packageName), e2);
        }
        AppMethodBeat.o(1175);
        return true;
    }

    public final boolean zza(zzep zzep, long j2, boolean z) {
        AppMethodBeat.i(1211);
        zzab();
        zzch();
        Preconditions.checkNotNull(zzep);
        Preconditions.checkNotEmpty(zzep.zzti);
        zzkn zzkn = new zzkn();
        zzkn.zzatc = Long.valueOf(zzep.zzafp);
        zzkn.zzata = new zzko[zzep.zzafq.size()];
        Iterator<String> it = zzep.zzafq.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String next = it.next();
            zzko zzko = new zzko();
            zzkn.zzata[i2] = zzko;
            zzko.name = next;
            zzgb().zza(zzko, zzep.zzafq.get(next));
            i2++;
        }
        try {
            byte[] bArr = new byte[zzkn.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkn.zza(zzb);
            zzb.zzve();
            zzge().zzit().zze("Saving event, name, data size", zzga().zzbj(zzep.name), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzep.zzti);
            contentValues.put("name", zzep.name);
            contentValues.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(zzep.timestamp));
            contentValues.put("metadata_fingerprint", Long.valueOf(j2));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (getWritableDatabase().insert("raw_events", null, contentValues) == -1) {
                    zzge().zzim().zzg("Failed to insert raw event (got -1). appId", zzfg.zzbm(zzep.zzti));
                    AppMethodBeat.o(1211);
                    return false;
                }
                AppMethodBeat.o(1211);
                return true;
            } catch (SQLiteException e2) {
                zzge().zzim().zze("Error storing raw event. appId", zzfg.zzbm(zzep.zzti), e2);
                AppMethodBeat.o(1211);
                return false;
            }
        } catch (IOException e3) {
            zzge().zzim().zze("Data loss. Failed to serialize event params/data. appId", zzfg.zzbm(zzep.zzti), e3);
            AppMethodBeat.o(1211);
            return false;
        }
    }

    public final boolean zza(zzjz zzjz) {
        AppMethodBeat.i(1171);
        Preconditions.checkNotNull(zzjz);
        zzab();
        zzch();
        if (zzh(zzjz.zzti, zzjz.name) == null) {
            if (zzka.zzcc(zzjz.name)) {
                if (zza("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzjz.zzti}) >= 25) {
                    AppMethodBeat.o(1171);
                    return false;
                }
            } else {
                if (zza("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzjz.zzti, zzjz.origin}) >= 25) {
                    AppMethodBeat.o(1171);
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzjz.zzti);
        contentValues.put(FirebaseAnalytics.b.ORIGIN, zzjz.origin);
        contentValues.put("name", zzjz.name);
        contentValues.put("set_timestamp", Long.valueOf(zzjz.zzaqz));
        zza(contentValues, "value", zzjz.value);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update user property (got -1). appId", zzfg.zzbm(zzjz.zzti));
            }
        } catch (SQLiteException e2) {
            zzge().zzim().zze("Error storing user property. appId", zzfg.zzbm(zzjz.zzti), e2);
        }
        AppMethodBeat.o(1171);
        return true;
    }

    public final boolean zza(zzkq zzkq, boolean z) {
        AppMethodBeat.i(1185);
        zzab();
        zzch();
        Preconditions.checkNotNull(zzkq);
        Preconditions.checkNotEmpty(zzkq.zzti);
        Preconditions.checkNotNull(zzkq.zzatm);
        zzhp();
        long currentTimeMillis = zzbt().currentTimeMillis();
        if (zzkq.zzatm.longValue() < currentTimeMillis - zzef.zzhh() || zzkq.zzatm.longValue() > zzef.zzhh() + currentTimeMillis) {
            zzge().zzip().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzfg.zzbm(zzkq.zzti), Long.valueOf(currentTimeMillis), zzkq.zzatm);
        }
        try {
            byte[] bArr = new byte[zzkq.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkq.zza(zzb);
            zzb.zzve();
            byte[] zza = zzgb().zza(bArr);
            zzge().zzit().zzg("Saving bundle, size", Integer.valueOf(zza.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzkq.zzti);
            contentValues.put("bundle_end_timestamp", zzkq.zzatm);
            contentValues.put("data", zza);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzkq.zzauj != null) {
                contentValues.put("retry_count", zzkq.zzauj);
            }
            try {
                if (getWritableDatabase().insert("queue", null, contentValues) == -1) {
                    zzge().zzim().zzg("Failed to insert bundle (got -1). appId", zzfg.zzbm(zzkq.zzti));
                    AppMethodBeat.o(1185);
                    return false;
                }
                AppMethodBeat.o(1185);
                return true;
            } catch (SQLiteException e2) {
                zzge().zzim().zze("Error storing bundle. appId", zzfg.zzbm(zzkq.zzti), e2);
                AppMethodBeat.o(1185);
                return false;
            }
        } catch (IOException e3) {
            zzge().zzim().zze("Data loss. Failed to serialize bundle. appId", zzfg.zzbm(zzkq.zzti), e3);
            AppMethodBeat.o(1185);
            return false;
        }
    }

    public final boolean zza(String str, Long l, long j2, zzkn zzkn) {
        AppMethodBeat.i(1210);
        zzab();
        zzch();
        Preconditions.checkNotNull(zzkn);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        try {
            byte[] bArr = new byte[zzkn.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkn.zza(zzb);
            zzb.zzve();
            zzge().zzit().zze("Saving complex main event, appId, data size", zzga().zzbj(str), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("event_id", l);
            contentValues.put("children_to_process", Long.valueOf(j2));
            contentValues.put("main_event", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                    zzge().zzim().zzg("Failed to insert complex main event (got -1). appId", zzfg.zzbm(str));
                    AppMethodBeat.o(1210);
                    return false;
                }
                AppMethodBeat.o(1210);
                return true;
            } catch (SQLiteException e2) {
                zzge().zzim().zze("Error storing complex main event. appId", zzfg.zzbm(str), e2);
                AppMethodBeat.o(1210);
                return false;
            }
        } catch (IOException e3) {
            zzge().zzim().zzd("Data loss. Failed to serialize event params/data. appId, eventId", zzfg.zzbm(str), l, e3);
            AppMethodBeat.o(1210);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzab(long r8) {
        /*
        // Method dump skipped, instructions count: 117
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzab(long):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<android.util.Pair<com.google.android.gms.internal.measurement.zzkq, java.lang.Long>> zzb(java.lang.String r13, int r14, int r15) {
        /*
        // Method dump skipped, instructions count: 295
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzb(java.lang.String, int, int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0125, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0126, code lost:
        r10 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x012e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012f, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0125 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x008c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzjz> zzb(java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 305
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x018b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzed> zzb(java.lang.String r24, java.lang.String[] r25) {
        /*
        // Method dump skipped, instructions count: 414
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzb(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzjz> zzbb(java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzbb(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0250  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzdy zzbc(java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 603
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzbc(java.lang.String):com.google.android.gms.internal.measurement.zzdy");
    }

    public final long zzbd(String str) {
        AppMethodBeat.i(1182);
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        try {
            long delete = (long) getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzgg().zzb(str, zzew.zzagx))))});
            AppMethodBeat.o(1182);
            return delete;
        } catch (SQLiteException e2) {
            zzge().zzim().zze("Error deleting over the limit events. appId", zzfg.zzbm(str), e2);
            AppMethodBeat.o(1182);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzbe(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzbe(java.lang.String):byte[]");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzkr> zzbf(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzbf(java.lang.String):java.util.Map");
    }

    public final long zzbg(String str) {
        AppMethodBeat.i(1206);
        Preconditions.checkNotEmpty(str);
        long zza = zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
        AppMethodBeat.o(1206);
        return zza;
    }

    public final List<zzed> zzc(String str, String str2, String str3) {
        AppMethodBeat.i(1178);
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        List<zzed> zzb = zzb(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
        AppMethodBeat.o(1178);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzc(List<Long> list) {
        AppMethodBeat.i(1190);
        zzab();
        zzch();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (!zzhv()) {
            AppMethodBeat.o(1190);
            return;
        }
        String join = TextUtils.join(",", list);
        String sb = new StringBuilder(String.valueOf(join).length() + 2).append("(").append(join).append(")").toString();
        if (zza(new StringBuilder(String.valueOf(sb).length() + 80).append("SELECT COUNT(1) FROM queue WHERE rowid IN ").append(sb).append(" AND retry_count =  2147483647 LIMIT 1").toString(), (String[]) null) > 0) {
            zzge().zzip().log("The number of upload retries exceeds the limit. Will remain unchanged.");
        }
        try {
            getWritableDatabase().execSQL(new StringBuilder(String.valueOf(sb).length() + TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH).append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ").append(sb).append(" AND (retry_count IS NULL OR retry_count < 2147483647)").toString());
            AppMethodBeat.o(1190);
        } catch (SQLiteException e2) {
            zzge().zzim().zzg("Error incrementing retry count. error", e2);
            AppMethodBeat.o(1190);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzeq zzf(java.lang.String r19, java.lang.String r20) {
        /*
        // Method dump skipped, instructions count: 333
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzf(java.lang.String, java.lang.String):com.google.android.gms.internal.measurement.zzeq");
    }

    public final void zzg(String str, String str2) {
        AppMethodBeat.i(1170);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            zzge().zzit().zzg("Deleted user attribute rows", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
            AppMethodBeat.o(1170);
        } catch (SQLiteException e2) {
            zzge().zzim().zzd("Error deleting user attribute. appId", zzfg.zzbm(str), zzga().zzbl(str2), e2);
            AppMethodBeat.o(1170);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzjz zzh(java.lang.String r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 193
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzh(java.lang.String, java.lang.String):com.google.android.gms.internal.measurement.zzjz");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzjq
    public final boolean zzhf() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzhn() {
        /*
            r6 = this;
            r0 = 0
            r5 = 1186(0x4a2, float:1.662E-42)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            android.database.sqlite.SQLiteDatabase r1 = r6.getWritableDatabase()
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            r3 = 0
            android.database.Cursor r2 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x002f, all -> 0x0048 }
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0056 }
            if (r1 == 0) goto L_0x0026
            r1 = 0
            java.lang.String r0 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x0056 }
            if (r2 == 0) goto L_0x0022
            r2.close()
        L_0x0022:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x0025:
            return r0
        L_0x0026:
            if (r2 == 0) goto L_0x002b
            r2.close()
        L_0x002b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0025
        L_0x002f:
            r1 = move-exception
            r2 = r0
        L_0x0031:
            com.google.android.gms.internal.measurement.zzfg r3 = r6.zzge()     // Catch:{ all -> 0x0053 }
            com.google.android.gms.internal.measurement.zzfi r3 = r3.zzim()     // Catch:{ all -> 0x0053 }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzg(r4, r1)     // Catch:{ all -> 0x0053 }
            if (r2 == 0) goto L_0x0044
            r2.close()
        L_0x0044:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0025
        L_0x0048:
            r1 = move-exception
            r2 = r0
        L_0x004a:
            if (r2 == 0) goto L_0x004f
            r2.close()
        L_0x004f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            throw r1
        L_0x0053:
            r0 = move-exception
            r1 = r0
            goto L_0x004a
        L_0x0056:
            r1 = move-exception
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzhn():java.lang.String");
    }

    public final boolean zzho() {
        AppMethodBeat.i(1187);
        if (zza("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0) {
            AppMethodBeat.o(1187);
            return true;
        }
        AppMethodBeat.o(1187);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void zzhp() {
        int delete;
        AppMethodBeat.i(1189);
        zzab();
        zzch();
        if (!zzhv()) {
            AppMethodBeat.o(1189);
            return;
        }
        long j2 = zzgf().zzajx.get();
        long elapsedRealtime = zzbt().elapsedRealtime();
        if (Math.abs(elapsedRealtime - j2) > zzew.zzahg.get().longValue()) {
            zzgf().zzajx.set(elapsedRealtime);
            zzab();
            zzch();
            if (zzhv() && (delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzbt().currentTimeMillis()), String.valueOf(zzef.zzhh())})) > 0) {
                zzge().zzit().zzg("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
        AppMethodBeat.o(1189);
    }

    public final long zzhq() {
        AppMethodBeat.i(1200);
        long zza = zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
        AppMethodBeat.o(1200);
        return zza;
    }

    public final long zzhr() {
        AppMethodBeat.i(TXLiteAVCode.WARNING_SPEAKER_DEVICE_EMPTY);
        long zza = zza("select max(timestamp) from raw_events", (String[]) null, 0);
        AppMethodBeat.o(TXLiteAVCode.WARNING_SPEAKER_DEVICE_EMPTY);
        return zza;
    }

    public final boolean zzhs() {
        AppMethodBeat.i(TXLiteAVCode.WARNING_MICROPHONE_DEVICE_ABNORMAL);
        if (zza("select count(1) > 0 from raw_events", (String[]) null) != 0) {
            AppMethodBeat.o(TXLiteAVCode.WARNING_MICROPHONE_DEVICE_ABNORMAL);
            return true;
        }
        AppMethodBeat.o(TXLiteAVCode.WARNING_MICROPHONE_DEVICE_ABNORMAL);
        return false;
    }

    public final boolean zzht() {
        AppMethodBeat.i(TXLiteAVCode.WARNING_SPEAKER_DEVICE_ABNORMAL);
        if (zza("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0) {
            AppMethodBeat.o(TXLiteAVCode.WARNING_SPEAKER_DEVICE_ABNORMAL);
            return true;
        }
        AppMethodBeat.o(TXLiteAVCode.WARNING_SPEAKER_DEVICE_ABNORMAL);
        return false;
    }

    public final long zzhu() {
        long j2 = -1;
        Cursor cursor = null;
        AppMethodBeat.i(1208);
        try {
            cursor = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(1208);
            } else {
                j2 = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(1208);
            }
        } catch (SQLiteException e2) {
            zzge().zzim().zzg("Error querying raw events", e2);
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(1208);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(1208);
            throw th;
        }
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0170  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzed zzi(java.lang.String r22, java.lang.String r23) {
        /*
        // Method dump skipped, instructions count: 387
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzi(java.lang.String, java.lang.String):com.google.android.gms.internal.measurement.zzed");
    }

    public final int zzj(String str, String str2) {
        int i2 = 0;
        AppMethodBeat.i(1177);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            i2 = getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
            AppMethodBeat.o(1177);
        } catch (SQLiteException e2) {
            zzge().zzim().zzd("Error deleting conditional property", zzfg.zzbm(str), zzga().zzbl(str2), e2);
            AppMethodBeat.o(1177);
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzke>> zzk(java.lang.String r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzk(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzkh>> zzl(java.lang.String r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzl(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final long zzm(String str, String str2) {
        SQLiteException e2;
        long j2;
        AppMethodBeat.i(TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            j2 = zza(new StringBuilder(String.valueOf(str2).length() + 32).append("select ").append(str2).append(" from app2 where app_id=?").toString(), new String[]{str}, -1);
            if (j2 == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", (Integer) 0);
                contentValues.put("previous_install_count", (Integer) 0);
                if (writableDatabase.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    zzge().zzim().zze("Failed to insert column (got -1). appId", zzfg.zzbm(str), str2);
                    writableDatabase.endTransaction();
                    AppMethodBeat.o(TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY);
                    return -1;
                }
                j2 = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + j2));
                if (((long) writableDatabase.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    zzge().zzim().zze("Failed to update column (got 0). appId", zzfg.zzbm(str), str2);
                    writableDatabase.endTransaction();
                    AppMethodBeat.o(TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY);
                    return -1;
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                AppMethodBeat.o(TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY);
                return j2;
            } catch (SQLiteException e3) {
                e2 = e3;
                try {
                    zzge().zzim().zzd("Error inserting column. appId", zzfg.zzbm(str), str2, e2);
                    writableDatabase.endTransaction();
                    AppMethodBeat.o(TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY);
                    return j2;
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    AppMethodBeat.o(TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY);
                    throw th;
                }
            }
        } catch (SQLiteException e4) {
            e2 = e4;
            j2 = 0;
            zzge().zzim().zzd("Error inserting column. appId", zzfg.zzbm(str), str2, e2);
            writableDatabase.endTransaction();
            AppMethodBeat.o(TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY);
            return j2;
        }
    }
}
