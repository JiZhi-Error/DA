package com.tencent.mm.plugin.exdevice.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;

public final class c extends MAutoStorage<b> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(b.info, "HardDeviceInfo")};
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(b bVar) {
        AppMethodBeat.i(23793);
        b bVar2 = bVar;
        if (bVar2 == null || Util.isNullOrNil(bVar2.field_brandName) || Util.isNullOrNil(bVar2.field_deviceID)) {
            Log.w("MicroMsg.exdevice.HardDeviceInfoStorage", "wrong argument");
            AppMethodBeat.o(23793);
            return false;
        }
        boolean z = this.db.replace("HardDeviceInfo", b.info.primaryKey, bVar2.convertTo()) > 0;
        Log.i("MicroMsg.exdevice.HardDeviceInfoStorage", "replace: brandName=%s, deviceId=%s, ret=%s ", bVar2.field_brandName, bVar2.field_deviceID, Boolean.valueOf(z));
        AppMethodBeat.o(23793);
        return z;
    }

    static {
        AppMethodBeat.i(23794);
        AppMethodBeat.o(23794);
    }

    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, b.info, "HardDeviceInfo", null);
        AppMethodBeat.i(23780);
        this.db = iSQLiteDatabase;
        iSQLiteDatabase.execSQL("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceUsernameIndex ON HardDeviceInfo ( brandName )");
        iSQLiteDatabase.execSQL("HardDeviceInfo", "CREATE INDEX IF NOT EXISTS hardDeviceMacIndex ON HardDeviceInfo ( mac )");
        AppMethodBeat.o(23780);
    }

    public final b anI(String str) {
        AppMethodBeat.i(23781);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(23781);
            return null;
        }
        Cursor query = this.db.query("HardDeviceInfo", null, "mac=?", new String[]{str}, null, null, null, 2);
        if (query == null) {
            AppMethodBeat.o(23781);
            return null;
        } else if (!query.moveToFirst()) {
            Log.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:".concat(String.valueOf(str)));
            query.close();
            AppMethodBeat.o(23781);
            return null;
        } else {
            b bVar = new b();
            bVar.convertFrom(query);
            query.close();
            AppMethodBeat.o(23781);
            return bVar;
        }
    }

    public final b Di(long j2) {
        b bVar = null;
        AppMethodBeat.i(23782);
        Cursor query = this.db.query("HardDeviceInfo", null, "mac=?", new String[]{String.valueOf(j2)}, null, null, null);
        if (query == null) {
            AppMethodBeat.o(23782);
        } else {
            if (query.moveToFirst()) {
                bVar = new b();
                bVar.convertFrom(query);
            } else {
                Log.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with mac:".concat(String.valueOf(j2)));
            }
            query.close();
            AppMethodBeat.o(23782);
        }
        return bVar;
    }

    public final b anJ(String str) {
        AppMethodBeat.i(23783);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(23783);
            return null;
        }
        Cursor query = this.db.query("HardDeviceInfo", null, "deviceID=?", new String[]{str}, null, null, null, 2);
        if (query == null) {
            AppMethodBeat.o(23783);
            return null;
        } else if (!query.moveToFirst()) {
            Log.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceId:".concat(String.valueOf(str)));
            query.close();
            AppMethodBeat.o(23783);
            return null;
        } else {
            b bVar = new b();
            bVar.convertFrom(query);
            query.close();
            AppMethodBeat.o(23783);
            return bVar;
        }
    }

    public final b gb(String str, String str2) {
        AppMethodBeat.i(23784);
        if (Util.isNullOrNil(str2) || Util.isNullOrNil(str)) {
            Log.e("MicroMsg.exdevice.HardDeviceInfoStorage", "deviceType(%s) or deviceId(%s) is null or nil.", str2, str);
            AppMethodBeat.o(23784);
            return null;
        }
        Cursor query = this.db.query("HardDeviceInfo", null, "deviceType=? and deviceID=?", new String[]{str2, str}, null, null, null, 2);
        if (query == null) {
            AppMethodBeat.o(23784);
            return null;
        } else if (!query.moveToFirst()) {
            Log.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with deviceType:%s and deviceId:%s", str2, str);
            query.close();
            AppMethodBeat.o(23784);
            return null;
        } else {
            b bVar = new b();
            bVar.convertFrom(query);
            query.close();
            AppMethodBeat.o(23784);
            return bVar;
        }
    }

    public static boolean anK(String str) {
        AppMethodBeat.i(23785);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.exdevice.HardDeviceInfoStorage", "Ability is null or nil.");
            AppMethodBeat.o(23785);
            return false;
        } else if (str.contains("wxmsg_music") || str.contains("wxmsg_poi") || str.contains("wxmsg_image") || str.contains("wxmsg_file") || str.contains("wxmsg_video") || str.contains("wxmsg_url")) {
            AppMethodBeat.o(23785);
            return true;
        } else {
            AppMethodBeat.o(23785);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.plugin.exdevice.i.b> cLA() {
        /*
            r5 = this;
            r4 = 23786(0x5cea, float:3.3331E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            android.database.Cursor r1 = r5.getAll()
            if (r1 == 0) goto L_0x0031
            boolean r2 = r1.moveToFirst()
            if (r2 == 0) goto L_0x0031
        L_0x0016:
            com.tencent.mm.plugin.exdevice.i.b r2 = new com.tencent.mm.plugin.exdevice.i.b
            r2.<init>()
            r2.convertFrom(r1)
            java.lang.String r3 = r2.fMh
            if (r3 == 0) goto L_0x002b
            boolean r3 = anK(r3)
            if (r3 == 0) goto L_0x002b
            r0.add(r2)
        L_0x002b:
            boolean r2 = r1.moveToNext()
            if (r2 != 0) goto L_0x0016
        L_0x0031:
            if (r1 == 0) goto L_0x0036
            r1.close()
        L_0x0036:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.i.c.cLA():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.plugin.exdevice.i.b> cLB() {
        /*
            r9 = this;
            r8 = 23787(0x5ceb, float:3.3333E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            android.database.Cursor r1 = r9.getAll()
            if (r1 == 0) goto L_0x0059
            boolean r2 = r1.moveToFirst()
            if (r2 == 0) goto L_0x0059
        L_0x0016:
            com.tencent.mm.plugin.exdevice.i.b r2 = new com.tencent.mm.plugin.exdevice.i.b
            r2.<init>()
            r2.convertFrom(r1)
            java.lang.String r3 = r2.fMd
            java.lang.String r4 = r2.iconUrl
            java.lang.String r5 = r2.category
            java.lang.String r6 = r2.field_brandName
            boolean r7 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r5)
            if (r7 != 0) goto L_0x0053
            java.lang.String r7 = "1"
            boolean r7 = r5.equals(r7)
            if (r7 != 0) goto L_0x0053
            java.lang.String r7 = "0"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x0053
            boolean r5 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r6)
            if (r5 != 0) goto L_0x0053
            boolean r3 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r3)
            if (r3 != 0) goto L_0x0053
            boolean r3 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r4)
            if (r3 != 0) goto L_0x0053
            r0.add(r2)
        L_0x0053:
            boolean r2 = r1.moveToNext()
            if (r2 != 0) goto L_0x0016
        L_0x0059:
            if (r1 == 0) goto L_0x005e
            r1.close()
        L_0x005e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.i.c.cLB():java.util.List");
    }

    public final b gc(String str, String str2) {
        AppMethodBeat.i(23788);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.exdevice.HardDeviceInfoStorage", "brandName(%s) or deviceId(%s) is null or nil.", str, str2);
            AppMethodBeat.o(23788);
            return null;
        }
        Cursor query = this.db.query("HardDeviceInfo", null, "brandName=? and deviceID=?", new String[]{str, str2}, null, null, null, 2);
        if (query == null) {
            AppMethodBeat.o(23788);
            return null;
        } else if (!query.moveToFirst()) {
            Log.w("MicroMsg.exdevice.HardDeviceInfoStorage", "get null with brandName:".concat(String.valueOf(str)));
            query.close();
            AppMethodBeat.o(23788);
            return null;
        } else {
            b bVar = new b();
            bVar.convertFrom(query);
            query.close();
            AppMethodBeat.o(23788);
            return bVar;
        }
    }

    public final LinkedList<b> anL(String str) {
        AppMethodBeat.i(23789);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.exdevice.HardDeviceInfoStorage", "The given brandName is null or nil.");
            AppMethodBeat.o(23789);
            return null;
        }
        LinkedList<b> linkedList = new LinkedList<>();
        Cursor query = this.db.query("HardDeviceInfo", null, "brandName=?", new String[]{str}, null, null, null, 2);
        if (query == null) {
            AppMethodBeat.o(23789);
            return linkedList;
        }
        if (query.moveToFirst()) {
            do {
                b bVar = new b();
                bVar.convertFrom(query);
                linkedList.add(bVar);
            } while (query.moveToNext());
        }
        query.close();
        AppMethodBeat.o(23789);
        return linkedList;
    }

    public final LinkedList<b> cLC() {
        AppMethodBeat.i(23790);
        LinkedList<b> linkedList = new LinkedList<>();
        Cursor rawQuery = rawQuery("select * from HardDeviceInfo where mac > 0 and connProto like '3'", new String[0]);
        if (rawQuery == null) {
            Log.e("MicroMsg.exdevice.HardDeviceInfoStorage", "get cursor is null");
            AppMethodBeat.o(23790);
        } else {
            if (rawQuery.moveToFirst()) {
                do {
                    b bVar = new b();
                    bVar.convertFrom(rawQuery);
                    linkedList.add(bVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.o(23790);
        }
        return linkedList;
    }

    public final boolean gd(String str, String str2) {
        AppMethodBeat.i(23791);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(23791);
            return false;
        }
        if (this.db.delete("HardDeviceInfo", "deviceID=? and deviceType=? ", new String[]{str, str2}) <= 0) {
            Log.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo fail, deviceId = %s", str);
            AppMethodBeat.o(23791);
            return false;
        }
        Log.i("MicroMsg.exdevice.HardDeviceInfoStorage", "delete hardDeviceInfo ok, deviceId = %s", str);
        AppMethodBeat.o(23791);
        return true;
    }

    public final int e(b bVar) {
        int i2;
        AppMethodBeat.i(23792);
        ContentValues convertTo = bVar.convertTo();
        if (convertTo.size() > 0) {
            i2 = this.db.update("HardDeviceInfo", convertTo, "deviceID = ? and deviceType = ? ", new String[]{bVar.field_deviceID, bVar.field_deviceType});
        } else {
            i2 = 0;
        }
        Log.i("MicroMsg.exdevice.HardDeviceInfoStorage", "update: deviceId = %s, deviceType = %s, ret = %s ", bVar.field_deviceID, bVar.field_deviceType, Integer.valueOf(i2));
        AppMethodBeat.o(23792);
        return i2;
    }
}
