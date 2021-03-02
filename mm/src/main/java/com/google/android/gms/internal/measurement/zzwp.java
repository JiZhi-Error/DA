package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzwp {
    private static final ConcurrentHashMap<Uri, zzwp> zzbmt = new ConcurrentHashMap<>();
    private static final String[] zzbna = {"key", "value"};
    private final Uri uri;
    private final ContentResolver zzbmu;
    private final ContentObserver zzbmv;
    private final Object zzbmw = new Object();
    private volatile Map<String, String> zzbmx;
    private final Object zzbmy = new Object();
    private final List<zzwr> zzbmz = new ArrayList();

    static {
        AppMethodBeat.i(2282);
        AppMethodBeat.o(2282);
    }

    private zzwp(ContentResolver contentResolver, Uri uri2) {
        AppMethodBeat.i(2276);
        this.zzbmu = contentResolver;
        this.uri = uri2;
        this.zzbmv = new zzwq(this, null);
        AppMethodBeat.o(2276);
    }

    public static zzwp zza(ContentResolver contentResolver, Uri uri2) {
        zzwp zzwp;
        AppMethodBeat.i(2277);
        zzwp zzwp2 = zzbmt.get(uri2);
        if (zzwp2 == null && (zzwp2 = zzbmt.putIfAbsent(uri2, (zzwp = new zzwp(contentResolver, uri2)))) == null) {
            zzwp.zzbmu.registerContentObserver(zzwp.uri, false, zzwp.zzbmv);
            zzwp2 = zzwp;
        }
        AppMethodBeat.o(2277);
        return zzwp2;
    }

    static /* synthetic */ void zza(zzwp zzwp) {
        AppMethodBeat.i(2281);
        zzwp.zzrw();
        AppMethodBeat.o(2281);
    }

    private final Map<String, String> zzrv() {
        AppMethodBeat.i(2279);
        try {
            HashMap hashMap = new HashMap();
            Cursor query = this.zzbmu.query(this.uri, zzbna, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        hashMap.put(query.getString(0), query.getString(1));
                    } catch (Throwable th) {
                        query.close();
                        AppMethodBeat.o(2279);
                        throw th;
                    }
                }
                query.close();
            }
            AppMethodBeat.o(2279);
            return hashMap;
        } catch (SQLiteException | SecurityException e2) {
            AppMethodBeat.o(2279);
            return null;
        }
    }

    private final void zzrw() {
        AppMethodBeat.i(2280);
        synchronized (this.zzbmy) {
            try {
                for (zzwr zzwr : this.zzbmz) {
                    zzwr.zzrx();
                }
            } finally {
                AppMethodBeat.o(2280);
            }
        }
    }

    public final Map<String, String> zzrt() {
        AppMethodBeat.i(2278);
        Map<String, String> zzrv = zzws.zzd("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? zzrv() : this.zzbmx;
        if (zzrv == null) {
            synchronized (this.zzbmw) {
                try {
                    zzrv = this.zzbmx;
                    if (zzrv == null) {
                        zzrv = zzrv();
                        this.zzbmx = zzrv;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(2278);
                    throw th;
                }
            }
        }
        if (zzrv != null) {
            AppMethodBeat.o(2278);
            return zzrv;
        }
        Map<String, String> emptyMap = Collections.emptyMap();
        AppMethodBeat.o(2278);
        return emptyMap;
    }

    public final void zzru() {
        synchronized (this.zzbmw) {
            this.zzbmx = null;
        }
    }
}
