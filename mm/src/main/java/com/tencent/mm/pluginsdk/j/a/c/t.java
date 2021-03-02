package com.tencent.mm.pluginsdk.j.a.c;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public final class t extends MAutoStorage<s> {
    private static final String Kaq = (ar.NSe + g.getMessageDigest(String.format(Locale.ENGLISH, "mm%d", Integer.MIN_VALUE).getBytes()) + FilePathGenerator.ANDROID_DIR_SEP);
    @SuppressLint({"UseSparseArrays"})
    private static final HashMap<Integer, h.b> Kar;
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(s.info, "ResDownloaderRecordTable")};
    private final HashMap<String, Object> Kas = new HashMap<>();
    public final h iFy;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(s sVar) {
        AppMethodBeat.i(152079);
        boolean j2 = j(sVar);
        AppMethodBeat.o(152079);
        return j2;
    }

    static {
        AppMethodBeat.i(152080);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        Kar = hashMap;
        hashMap.put(Integer.valueOf("RES_DOWNLOADER_RECORD_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.pluginsdk.j.a.c.t.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                AppMethodBeat.i(152072);
                String[] strArr = t.SQL_CREATE;
                AppMethodBeat.o(152072);
                return strArr;
            }
        });
        Iterator<g> it = r.gob().iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(152080);
    }

    private t(h hVar) {
        super(hVar, s.info, "ResDownloaderRecordTable", null);
        AppMethodBeat.i(152073);
        this.iFy = hVar;
        Iterator<g> it = r.gob().iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(152073);
    }

    static t goc() {
        AppMethodBeat.i(152074);
        try {
            new File(Kaq).mkdirs();
            h hVar = new h();
            String str = Kaq + "ResDown.db";
            String str2 = Kaq + "EnResDown.db";
            q.dr(true);
            if (!hVar.a(str, str2, -2147483648L, Kar)) {
                Log.f("MicroMsg.ResDownloaderStorage", "res downloader db init failed");
                AppMethodBeat.o(152074);
                return null;
            }
            t tVar = new t(hVar);
            AppMethodBeat.o(152074);
            return tVar;
        } catch (Exception e2) {
            Log.e("MicroMsg.ResDownloaderStorage", "new storage failed, exception = %s", e2);
            AppMethodBeat.o(152074);
            return null;
        }
    }

    public final boolean gC(String str) {
        AppMethodBeat.i(152075);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ResDownloaderStorage", "delete with null or nil urlKey, return false");
            AppMethodBeat.o(152075);
            return false;
        }
        s sVar = new s();
        sVar.field_urlKey_hashcode = str.hashCode();
        boolean delete = super.delete(sVar, "urlKey_hashcode");
        AppMethodBeat.o(152075);
        return delete;
    }

    public final boolean i(s sVar) {
        AppMethodBeat.i(152076);
        if (Util.isNullOrNil(sVar.field_urlKey)) {
            AppMethodBeat.o(152076);
            return false;
        }
        sVar.field_urlKey_hashcode = sVar.field_urlKey.hashCode();
        boolean update = super.update(sVar, "urlKey_hashcode");
        AppMethodBeat.o(152076);
        return update;
    }

    public final boolean j(s sVar) {
        AppMethodBeat.i(152077);
        if (Util.isNullOrNil(sVar.field_urlKey)) {
            AppMethodBeat.o(152077);
            return false;
        }
        sVar.field_urlKey_hashcode = sVar.field_urlKey.hashCode();
        boolean insert = super.insert(sVar);
        AppMethodBeat.o(152077);
        return insert;
    }

    public final s beg(String str) {
        boolean z = false;
        AppMethodBeat.i(152078);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ResDownloaderStorage", "query with null or nil urlKey, return null");
            AppMethodBeat.o(152078);
            return null;
        }
        s sVar = new s();
        sVar.field_urlKey_hashcode = str.hashCode();
        try {
            if (super.get(sVar, "urlKey_hashcode")) {
                AppMethodBeat.o(152078);
                return sVar;
            }
            AppMethodBeat.o(152078);
            return null;
        } catch (SQLiteDatabaseCorruptException | com.tencent.wcdb.database.SQLiteDatabaseCorruptException e2) {
            Object[] objArr = new Object[4];
            objArr[0] = str;
            if (this.iFy == null || !this.iFy.isOpen()) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(new File(Kaq + "EnResDown.db").exists());
            objArr[3] = e2;
            Log.e("MicroMsg.ResDownloaderStorage", "query with urlKey[%s], db.isClose[%s], dbFile.exists[%b], e=%s", objArr);
            AppMethodBeat.o(152078);
            return null;
        }
    }
}
