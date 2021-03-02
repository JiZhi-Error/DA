package com.tencent.mm.plugin.game.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class g extends MAutoStorage<d> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(d.info, "GameSilentDownload")};

    static {
        AppMethodBeat.i(41699);
        AppMethodBeat.o(41699);
    }

    public g(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, d.info, "GameSilentDownload", null);
    }

    public final d aAs(String str) {
        AppMethodBeat.i(41689);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfo: appid is null");
            AppMethodBeat.o(41689);
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", "GameSilentDownload", "appId"), str);
        if (rawQuery == null) {
            Log.i("MicroMsg.GameSilentDownloadStorage", "cursor is null");
            AppMethodBeat.o(41689);
            return null;
        } else if (rawQuery.moveToFirst()) {
            d dVar = new d();
            dVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(41689);
            return dVar;
        } else {
            Log.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfo appid:%s, no record in DB", str);
            rawQuery.close();
            AppMethodBeat.o(41689);
            return null;
        }
    }

    public final List<d> dWc() {
        ArrayList arrayList = null;
        AppMethodBeat.i(41690);
        Cursor rawQuery = rawQuery(String.format("select * from %s", "GameSilentDownload"), new String[0]);
        if (rawQuery == null) {
            Log.i("MicroMsg.GameSilentDownloadStorage", "cursor is null");
            AppMethodBeat.o(41690);
        } else if (rawQuery.moveToFirst()) {
            arrayList = new ArrayList();
            do {
                d dVar = new d();
                dVar.convertFrom(rawQuery);
                arrayList.add(dVar);
            } while (rawQuery.moveToNext());
            rawQuery.close();
            Log.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfoList size:%s", Integer.valueOf(arrayList.size()));
            AppMethodBeat.o(41690);
        } else {
            rawQuery.close();
            Log.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfoList no record");
            AppMethodBeat.o(41690);
        }
        return arrayList;
    }

    public final boolean ay(String str, long j2) {
        AppMethodBeat.i(41691);
        if (Util.isNullOrNil(str) || j2 < 0) {
            Log.i("MicroMsg.GameSilentDownloadStorage", "updateNextCheckTime: appid is null");
            AppMethodBeat.o(41691);
            return false;
        }
        boolean execSQL = execSQL("GameSilentDownload", String.format("update %s set %s=%s where %s='%s'", "GameSilentDownload", "nextCheckTime", String.valueOf(j2), "appId", str));
        Log.i("MicroMsg.GameSilentDownloadStorage", "updateNextCheckTime ret:%b", Boolean.valueOf(execSQL));
        AppMethodBeat.o(41691);
        return execSQL;
    }

    public final boolean bH(String str, boolean z) {
        AppMethodBeat.i(41692);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.GameSilentDownloadStorage", "updateRunningState: appid is null");
            AppMethodBeat.o(41692);
            return false;
        }
        d aAs = aAs(str);
        if (aAs == null) {
            AppMethodBeat.o(41692);
            return false;
        }
        aAs.field_isRunning = z;
        boolean update = super.update(aAs, new String[0]);
        Log.i("MicroMsg.GameSilentDownloadStorage", "updateRunningState, ret:%b", Boolean.valueOf(update));
        AppMethodBeat.o(41692);
        return update;
    }

    public final boolean aAt(String str) {
        AppMethodBeat.i(41693);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.GameSilentDownloadStorage", "updateWifiState: appid is null");
            AppMethodBeat.o(41693);
            return false;
        }
        d aAs = aAs(str);
        if (aAs == null) {
            AppMethodBeat.o(41693);
            return false;
        }
        aAs.field_noWifi = false;
        boolean update = super.update(aAs, new String[0]);
        Log.i("MicroMsg.GameSilentDownloadStorage", "updateWifiState, ret:%b", Boolean.valueOf(update));
        AppMethodBeat.o(41693);
        return update;
    }

    public final boolean aAu(String str) {
        AppMethodBeat.i(41694);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardAvailableState: appid is null");
            AppMethodBeat.o(41694);
            return false;
        }
        d aAs = aAs(str);
        if (aAs == null) {
            AppMethodBeat.o(41694);
            return false;
        }
        aAs.field_noSdcard = false;
        boolean update = super.update(aAs, new String[0]);
        Log.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardAvailableState, ret:%b", Boolean.valueOf(update));
        AppMethodBeat.o(41694);
        return update;
    }

    public final boolean aAv(String str) {
        AppMethodBeat.i(41695);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardSpaceState: appid is null");
            AppMethodBeat.o(41695);
            return false;
        }
        d aAs = aAs(str);
        if (aAs == null) {
            AppMethodBeat.o(41695);
            return false;
        }
        aAs.field_noEnoughSpace = false;
        boolean update = super.update(aAs, new String[0]);
        Log.i("MicroMsg.GameSilentDownloadStorage", "updateSdcardSpaceState, ret:%b", Boolean.valueOf(update));
        AppMethodBeat.o(41695);
        return update;
    }

    public final boolean aAw(String str) {
        AppMethodBeat.i(41696);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.GameSilentDownloadStorage", "updateBatteryState: appid is null");
            AppMethodBeat.o(41696);
            return false;
        }
        d aAs = aAs(str);
        if (aAs == null) {
            AppMethodBeat.o(41696);
            return false;
        }
        aAs.field_lowBattery = false;
        boolean update = super.update(aAs, new String[0]);
        Log.i("MicroMsg.GameSilentDownloadStorage", "updateBatteryState, ret:%b", Boolean.valueOf(update));
        AppMethodBeat.o(41696);
        return update;
    }

    public final boolean aAx(String str) {
        AppMethodBeat.i(41697);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.GameSilentDownloadStorage", "updateDelayState: appid is null");
            AppMethodBeat.o(41697);
            return false;
        }
        d aAs = aAs(str);
        if (aAs == null) {
            AppMethodBeat.o(41697);
            return false;
        }
        aAs.field_continueDelay = false;
        boolean update = super.update(aAs, new String[0]);
        Log.i("MicroMsg.GameSilentDownloadStorage", "updateDelayState, ret:%b", Boolean.valueOf(update));
        AppMethodBeat.o(41697);
        return update;
    }

    public final boolean ej(String str, int i2) {
        AppMethodBeat.i(41698);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.GameSilentDownloadStorage", "updateForceUpdateFlag: appid is null");
            AppMethodBeat.o(41698);
            return false;
        }
        d aAs = aAs(str);
        if (aAs == null) {
            AppMethodBeat.o(41698);
            return false;
        }
        aAs.field_forceUpdateFlag = i2;
        boolean update = super.update(aAs, new String[0]);
        Log.i("MicroMsg.GameSilentDownloadStorage", "updateForceUpdateFlag, ret:%b", Boolean.valueOf(update));
        AppMethodBeat.o(41698);
        return update;
    }
}
