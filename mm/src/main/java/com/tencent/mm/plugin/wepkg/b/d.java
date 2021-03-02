package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public class d extends MAutoStorage<c> {
    private static volatile d JLV = null;
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.iBg, "WepkgPreloadFiles")};
    private final h iFy;
    public final boolean lsb;

    static {
        AppMethodBeat.i(110569);
        AppMethodBeat.o(110569);
    }

    public static d gkE() {
        AppMethodBeat.i(110563);
        if (!g.aAc()) {
            d dVar = new d(null);
            AppMethodBeat.o(110563);
            return dVar;
        }
        if (JLV == null) {
            synchronized (d.class) {
                try {
                    if (JLV == null || !JLV.lsb) {
                        JLV = new d(g.aAh().hqK);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(110563);
                    throw th;
                }
            }
        }
        d dVar2 = JLV;
        AppMethodBeat.o(110563);
        return dVar2;
    }

    private d(h hVar) {
        super(hVar, c.iBg, "WepkgPreloadFiles", c.INDEX_CREATE);
        AppMethodBeat.i(110564);
        this.iFy = hVar;
        this.lsb = hVar != null;
        if (!this.lsb) {
            Log.e("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "storage can not work!!!");
        }
        AppMethodBeat.o(110564);
    }

    public final c mp(String str, String str2) {
        AppMethodBeat.i(110565);
        if (!this.lsb || Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(110565);
            return null;
        }
        String mv = com.tencent.mm.plugin.wepkg.utils.d.mv(str, str2);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", "WepkgPreloadFiles", "key"), mv);
        if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.convertFrom(rawQuery);
            rawQuery.close();
            Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid exist record in DB, pkgid:%s, rid:%s, version:%s", cVar.field_pkgId, cVar.field_rid, cVar.field_version);
            AppMethodBeat.o(110565);
            return cVar;
        }
        Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid pkgid:%s, rid:%s, no record in DB", str, str2);
        rawQuery.close();
        AppMethodBeat.o(110565);
        return null;
    }

    public final List<WepkgPreloadFile> bck(String str) {
        ArrayList arrayList = null;
        AppMethodBeat.i(110566);
        if (!this.lsb || Util.isNullOrNil(str)) {
            AppMethodBeat.o(110566);
        } else {
            String format = String.format("select * from %s where %s=?", "WepkgPreloadFiles", "pkgId");
            Cursor rawQuery = rawQuery(format, str);
            Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getPreLoadFileList queryStr:%s", format);
            if (rawQuery == null) {
                Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
                AppMethodBeat.o(110566);
            } else if (rawQuery.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile();
                    c cVar = new c();
                    cVar.convertFrom(rawQuery);
                    wepkgPreloadFile.a(cVar);
                    arrayList.add(wepkgPreloadFile);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", Integer.valueOf(arrayList.size()));
                AppMethodBeat.o(110566);
            } else {
                rawQuery.close();
                Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
                AppMethodBeat.o(110566);
            }
        }
        return arrayList;
    }

    public final boolean bcl(String str) {
        AppMethodBeat.i(110567);
        if (!this.lsb || Util.isNullOrNil(str)) {
            AppMethodBeat.o(110567);
            return false;
        }
        c cVar = new c();
        cVar.field_pkgId = str;
        boolean delete = super.delete(cVar, "pkgId");
        Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", str, Boolean.valueOf(delete));
        AppMethodBeat.o(110567);
        return delete;
    }

    public final boolean h(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(110568);
        if (!this.lsb || Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(110568);
            return false;
        }
        c mp = mp(str, str2);
        if (mp == null) {
            AppMethodBeat.o(110568);
            return false;
        }
        mp.field_completeDownload = z;
        mp.field_filePath = str3;
        boolean update = super.update(mp, new String[0]);
        Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "updateDownloadCompleteState pkgid:%s, rid:%s, completeDownload:%s, filePath:%s, ret:%s", str, str2, Boolean.valueOf(z), str3, Boolean.valueOf(update));
        AppMethodBeat.o(110568);
        return update;
    }
}
