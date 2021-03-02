package com.tencent.mm.plugin.wepkg.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wepkg.model.WePkgDiffInfo;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.utils.b;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;

public class f extends MAutoStorage<e> {
    private static volatile f JLW = null;
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(e.iBg, "WepkgVersion")};
    private final h iFy;
    public final boolean lsb;

    static {
        AppMethodBeat.i(110588);
        AppMethodBeat.o(110588);
    }

    public static f gkF() {
        AppMethodBeat.i(110571);
        if (!g.aAc() || !b.JOe) {
            f fVar = new f(null);
            AppMethodBeat.o(110571);
            return fVar;
        }
        if (JLW == null) {
            synchronized (f.class) {
                try {
                    if (JLW == null || !JLW.lsb) {
                        JLW = new f(g.aAh().hqK);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(110571);
                    throw th;
                }
            }
        }
        f fVar2 = JLW;
        AppMethodBeat.o(110571);
        return fVar2;
    }

    private f(h hVar) {
        super(hVar, e.iBg, "WepkgVersion", e.INDEX_CREATE);
        AppMethodBeat.i(110572);
        this.iFy = hVar;
        this.lsb = hVar != null;
        if (!this.lsb) {
            Log.e("MicroMsg.Wepkg.WepkgVersionStorage", "storage can not work!!!");
        }
        AppMethodBeat.o(110572);
    }

    public final e bcm(String str) {
        AppMethodBeat.i(110573);
        if (!this.lsb || Util.isNullOrNil(str)) {
            AppMethodBeat.o(110573);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", "WepkgVersion", "pkgId"), str);
        if (rawQuery.moveToFirst()) {
            e eVar = new e();
            eVar.convertFrom(rawQuery);
            rawQuery.close();
            Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid exist record in DB, pkgid:%s, version:%s", eVar.field_pkgId, eVar.field_version);
            AppMethodBeat.o(110573);
            return eVar;
        }
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid pkgid:%s, no record in DB", str);
        rawQuery.close();
        AppMethodBeat.o(110573);
        return null;
    }

    public final e bcn(String str) {
        AppMethodBeat.i(110574);
        if (!this.lsb || Util.isNullOrNil(str)) {
            AppMethodBeat.o(110574);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s=0", "WepkgVersion", "pkgId", "disable"), str);
        if (rawQuery.moveToFirst()) {
            e eVar = new e();
            eVar.convertFrom(rawQuery);
            rawQuery.close();
            Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble exist record in DB, pkgid:%s, version:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, domain:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s, disable:%s", eVar.field_pkgId, eVar.field_version, Boolean.valueOf(eVar.field_disableWvCache), Long.valueOf(eVar.field_clearPkgTime), Long.valueOf(eVar.field_checkIntervalTime), eVar.field_domain, Boolean.valueOf(eVar.field_bigPackageReady), Boolean.valueOf(eVar.field_preloadFilesReady), Boolean.valueOf(eVar.field_preloadFilesAtomic), Boolean.valueOf(eVar.field_disable));
            eVar.field_accessTime = d.currentTime();
            super.update(eVar, new String[0]);
            AppMethodBeat.o(110574);
            return eVar;
        }
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble pkgid:%s, no record in DB", str);
        rawQuery.close();
        AppMethodBeat.o(110574);
        return null;
    }

    public final List<String> gkG() {
        AppMethodBeat.i(110575);
        if (!this.lsb) {
            AppMethodBeat.o(110575);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select %s from %s where %s < ?", "pkgId", "WepkgVersion", "nextCheckTime"), String.valueOf(d.currentTime()));
        ArrayList arrayList = new ArrayList();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    String string = rawQuery.getString(0);
                    if (!Util.isNullOrNil(string)) {
                        arrayList.add(string);
                    }
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        AppMethodBeat.o(110575);
        return arrayList;
    }

    public final List<WepkgVersion> gkH() {
        ArrayList arrayList = null;
        AppMethodBeat.i(110577);
        if (!this.lsb) {
            AppMethodBeat.o(110577);
        } else {
            String format = String.format("select * from %s where %s < ? - %s", "WepkgVersion", "accessTime", "clearPkgTime");
            Cursor rawQuery = rawQuery(format, String.valueOf(d.currentTime()));
            Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "getNeedCleanRecords queryStr:%s", format);
            if (rawQuery == null) {
                Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "cursor is null");
                AppMethodBeat.o(110577);
            } else if (rawQuery.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    WepkgVersion wepkgVersion = new WepkgVersion();
                    e eVar = new e();
                    eVar.convertFrom(rawQuery);
                    wepkgVersion.a(eVar);
                    arrayList.add(wepkgVersion);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "record list size:%s", Integer.valueOf(arrayList.size()));
                AppMethodBeat.o(110577);
            } else {
                rawQuery.close();
                Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "no record");
                AppMethodBeat.o(110577);
            }
        }
        return arrayList;
    }

    public final boolean bcl(String str) {
        AppMethodBeat.i(110578);
        if (!this.lsb || Util.isNullOrNil(str)) {
            AppMethodBeat.o(110578);
            return false;
        }
        e eVar = new e();
        eVar.field_pkgId = str;
        boolean delete = super.delete(eVar, new String[0]);
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", str, Boolean.valueOf(delete));
        AppMethodBeat.o(110578);
        return delete;
    }

    public final boolean bco(String str) {
        AppMethodBeat.i(110579);
        if (!this.lsb) {
            AppMethodBeat.o(110579);
            return false;
        }
        e bcm = bcm(str);
        if (bcm == null) {
            AppMethodBeat.o(110579);
            return false;
        }
        bcm.field_nextCheckTime = d.currentTime() + bcm.field_checkIntervalTime;
        boolean update = super.update(bcm, new String[0]);
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCheckTime pkgid:%s, ret:%s", str, Boolean.valueOf(update));
        AppMethodBeat.o(110579);
        return update;
    }

    public final boolean a(String str, boolean z, long j2, long j3) {
        AppMethodBeat.i(110580);
        if (!this.lsb) {
            AppMethodBeat.o(110580);
            return false;
        }
        e bcm = bcm(str);
        if (bcm == null) {
            AppMethodBeat.o(110580);
            return false;
        }
        bcm.field_disableWvCache = z;
        bcm.field_clearPkgTime = j2;
        bcm.field_nextCheckTime = (bcm.field_nextCheckTime - bcm.field_checkIntervalTime) + j3;
        bcm.field_checkIntervalTime = j3;
        bcm.field_disable = false;
        boolean update = super.update(bcm, new String[0]);
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateConfigInfo pkgid:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, ret:%s", str, Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(update));
        AppMethodBeat.o(110580);
        return update;
    }

    public final boolean a(e eVar, WePkgDiffInfo wePkgDiffInfo) {
        e bcm;
        AppMethodBeat.i(110581);
        if (!this.lsb || Util.isNullOrNil(eVar.field_pkgId)) {
            AppMethodBeat.o(110581);
            return false;
        }
        if (wePkgDiffInfo != null && !Util.isNullOrNil(wePkgDiffInfo.downloadUrl) && (bcm = gkF().bcm(eVar.field_pkgId)) != null && s.YS(bcm.field_pkgPath)) {
            wePkgDiffInfo.hhD = bcm.field_pkgId;
            wePkgDiffInfo.oldVersion = bcm.field_version;
            wePkgDiffInfo.JMY = bcm.field_pkgPath;
            b.gkD().gC(wePkgDiffInfo.hhD);
            b gkD = b.gkD();
            a aVar = new a();
            aVar.field_pkgId = wePkgDiffInfo.hhD;
            aVar.field_oldVersion = wePkgDiffInfo.oldVersion;
            aVar.field_oldPath = wePkgDiffInfo.JMY;
            aVar.field_version = wePkgDiffInfo.version;
            aVar.field_downloadUrl = wePkgDiffInfo.downloadUrl;
            aVar.field_md5 = wePkgDiffInfo.md5;
            aVar.field_pkgSize = wePkgDiffInfo.fileSize;
            aVar.field_downloadNetType = wePkgDiffInfo.JMZ;
            gkD.insert(aVar);
            Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "insertDiffPkg");
        }
        gkF().bcl(eVar.field_pkgId);
        d.gkE().bcl(eVar.field_pkgId);
        eVar.field_nextCheckTime = d.currentTime() + eVar.field_checkIntervalTime;
        eVar.field_createTime = d.currentTime();
        eVar.field_accessTime = d.currentTime();
        boolean insert = insert(eVar);
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "insertPkgVersion pkgid:%s, version:%s, ret:%s", eVar.field_pkgId, eVar.field_version, Boolean.valueOf(insert));
        AppMethodBeat.o(110581);
        return insert;
    }

    public final boolean C(String str, String str2, boolean z) {
        AppMethodBeat.i(110582);
        if (!this.lsb || Util.isNullOrNil(str)) {
            AppMethodBeat.o(110582);
            return false;
        }
        e bcm = bcm(str);
        if (bcm == null) {
            AppMethodBeat.o(110582);
            return false;
        }
        bcm.field_bigPackageReady = z;
        bcm.field_pkgPath = str2;
        boolean update = super.update(bcm, new String[0]);
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateBigPackageReady pkgid:%s, pkgPath:%s, bigPackageReady:%b, ret:%s", str, str2, Boolean.valueOf(z), Boolean.valueOf(update));
        AppMethodBeat.o(110582);
        return update;
    }

    public final boolean cV(String str, boolean z) {
        AppMethodBeat.i(110583);
        if (!this.lsb || Util.isNullOrNil(str)) {
            AppMethodBeat.o(110583);
            return false;
        }
        e bcm = bcm(str);
        if (bcm == null) {
            AppMethodBeat.o(110583);
            return false;
        }
        bcm.field_preloadFilesReady = z;
        boolean update = super.update(bcm, new String[0]);
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "updatePreloadFilesReady pkgid:%s, preloadFilesReady:%b, ret:%s", str, Boolean.valueOf(z), Boolean.valueOf(update));
        AppMethodBeat.o(110583);
        return update;
    }

    public final boolean bcp(String str) {
        AppMethodBeat.i(110584);
        if (!this.lsb || Util.isNullOrNil(str)) {
            AppMethodBeat.o(110584);
            return false;
        }
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addAutoDownloadCount ret:%s", Boolean.valueOf(execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", "WepkgVersion", "autoDownloadCount", "autoDownloadCount", "pkgId", str))));
        AppMethodBeat.o(110584);
        return true;
    }

    public final boolean bcq(String str) {
        AppMethodBeat.i(110585);
        if (!this.lsb || Util.isNullOrNil(str)) {
            AppMethodBeat.o(110585);
            return false;
        }
        e bcm = bcm(str);
        if (bcm == null) {
            AppMethodBeat.o(110585);
            return true;
        }
        bcm.field_disable = true;
        boolean update = super.update(bcm, new String[0]);
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "setWepkgDisable pkgid:%s, ret:%s", str, Boolean.valueOf(update));
        AppMethodBeat.o(110585);
        return update;
    }

    public final boolean bcr(String str) {
        AppMethodBeat.i(110586);
        if (!this.lsb || Util.isNullOrNil(str)) {
            AppMethodBeat.o(110586);
            return false;
        }
        e bcm = bcm(str);
        if (bcm == null) {
            AppMethodBeat.o(110586);
            return false;
        }
        bcm.field_createTime = 0;
        boolean update = super.update(bcm, new String[0]);
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCreateTimeToZero pkgid:%s, ret:%s", str, Boolean.valueOf(update));
        AppMethodBeat.o(110586);
        return update;
    }

    public final boolean gkI() {
        AppMethodBeat.i(110587);
        if (!this.lsb) {
            AppMethodBeat.o(110587);
            return false;
        }
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord clearWepkg ret:%s", Boolean.valueOf(execSQL("WepkgVersion", String.format("delete from %s", "WepkgVersion"))));
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord clearWepkg ret:%s", Boolean.valueOf(execSQL("WepkgPreloadFiles", String.format("delete from %s", "WepkgPreloadFiles"))));
        AppMethodBeat.o(110587);
        return true;
    }
}
