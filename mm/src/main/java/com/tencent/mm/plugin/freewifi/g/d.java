package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class d extends MAutoStorage<c> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "FreeWifiInfo"), "CREATE INDEX IF NOT EXISTS freewifi_md5_ssid  on FreeWifiInfo  (  ssidmd5 )"};

    static {
        AppMethodBeat.i(24954);
        AppMethodBeat.o(24954);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "FreeWifiInfo", null);
    }

    public final c axZ(String str) {
        AppMethodBeat.i(24950);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
            AppMethodBeat.o(24950);
            return null;
        }
        String str2 = "select * from FreeWifiInfo where ssidmd5 = '" + MD5Util.getMD5String(str) + "' and wifiType = 1";
        Log.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", str2);
        Cursor rawQuery = rawQuery(str2, new String[0]);
        if (rawQuery == null) {
            Log.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
            AppMethodBeat.o(24950);
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(24950);
            return cVar;
        } else {
            rawQuery.close();
            AppMethodBeat.o(24950);
            return null;
        }
    }

    public final c aya(String str) {
        AppMethodBeat.i(24951);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
            AppMethodBeat.o(24951);
            return null;
        }
        String str2 = "select * from FreeWifiInfo where ssidmd5 = '" + MD5Util.getMD5String(str) + "'";
        Log.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", str2);
        Cursor rawQuery = rawQuery(str2, new String[0]);
        if (rawQuery == null) {
            Log.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
            AppMethodBeat.o(24951);
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(24951);
            return cVar;
        } else {
            rawQuery.close();
            AppMethodBeat.o(24951);
            return null;
        }
    }

    public final c dNN() {
        AppMethodBeat.i(24952);
        Log.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getLastConnectSuccessWifiInfo, sql : %s", "select * from FreeWifiInfo where connectState = 2");
        Cursor rawQuery = rawQuery("select * from FreeWifiInfo where connectState = 2", new String[0]);
        if (rawQuery == null) {
            Log.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "no connected sucess wifi info");
            AppMethodBeat.o(24952);
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(24952);
            return cVar;
        } else {
            rawQuery.close();
            AppMethodBeat.o(24952);
            return null;
        }
    }

    public final void ayb(String str) {
        AppMethodBeat.i(24953);
        String str2 = "update FreeWifiInfo set connectState = -1 where ssidmd5 !='" + MD5Util.getMD5String(str) + "'";
        Log.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "updateOtherAp : %s", str2);
        Log.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "update other ap  ret = %b", Boolean.valueOf(execSQL("FreeWifiInfo", str2)));
        AppMethodBeat.o(24953);
    }
}
