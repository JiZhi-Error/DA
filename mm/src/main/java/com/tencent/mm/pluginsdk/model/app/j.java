package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.g.c.y;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class j extends MAutoStorage<g> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(g.info, "AppInfo")};
    public final f<String, g> JWf = new c(50);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean delete(g gVar, String[] strArr) {
        AppMethodBeat.i(151749);
        boolean b2 = b(gVar, strArr);
        AppMethodBeat.o(151749);
        return b2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(g gVar) {
        AppMethodBeat.i(151750);
        boolean r = r(gVar);
        AppMethodBeat.o(151750);
        return r;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean update(g gVar, String[] strArr) {
        AppMethodBeat.i(151748);
        boolean a2 = a(gVar, strArr);
        AppMethodBeat.o(151748);
        return a2;
    }

    static {
        AppMethodBeat.i(151751);
        AppMethodBeat.o(151751);
    }

    public j(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, g.info, "AppInfo", y.INDEX_CREATE);
        AppMethodBeat.i(151735);
        g gVar = new g();
        gVar.field_appId = "wx4310bbd51be7d979";
        if (!super.get(gVar, new String[0])) {
            g gVar2 = new g();
            gVar2.field_appId = "wx4310bbd51be7d979";
            gVar2.field_appName = "weixinfile";
            gVar2.field_packageName = "com.tencent.mm.openapi";
            gVar2.field_status = -1;
            super.insert(gVar2);
        }
        AppMethodBeat.o(151735);
    }

    private void q(g gVar) {
        AppMethodBeat.i(151736);
        if (gVar == null || gVar.field_appId == null) {
            AppMethodBeat.o(151736);
            return;
        }
        this.JWf.x(gVar.field_appId, gVar);
        AppMethodBeat.o(151736);
    }

    private void ayf(String str) {
        AppMethodBeat.i(151737);
        if (!Util.isNullOrNil(str)) {
            this.JWf.remove(str);
        }
        AppMethodBeat.o(151737);
    }

    public final boolean r(g gVar) {
        AppMethodBeat.i(151738);
        if (gVar == null || Util.isNullOrNil(gVar.field_appId)) {
            AppMethodBeat.o(151738);
            return false;
        }
        if (g.JVR.equals(gVar.field_appId) || g.JVT.equals(gVar.field_appId)) {
            Log.i("MicroMsg.AppInfoStorage", "insert appinfo: %s, %s, %s, %s, %s", gVar.field_appId, gVar.field_appName, Integer.valueOf(gVar.field_serviceShowFlag), Integer.valueOf(gVar.field_appInfoFlag), Util.getStack());
        }
        if (super.insertNotify(gVar, false)) {
            doNotify(gVar.field_appId, 2, gVar.field_appId);
            q(gVar);
            AppMethodBeat.o(151738);
            return true;
        }
        AppMethodBeat.o(151738);
        return false;
    }

    public final boolean a(g gVar, String... strArr) {
        boolean z = false;
        AppMethodBeat.i(151739);
        if (gVar == null || Util.isNullOrNil(gVar.field_appId)) {
            AppMethodBeat.o(151739);
        } else {
            if (g.JVR.equals(gVar.field_appId) || g.JVT.equals(gVar.field_appId)) {
                Log.i("MicroMsg.AppInfoStorage", "update appinfo: %s, %s, %s, %s, %s", gVar.field_appId, gVar.field_appName, Integer.valueOf(gVar.field_serviceShowFlag), Integer.valueOf(gVar.field_appInfoFlag), Util.getStack());
            }
            ayf(gVar.field_appId);
            z = super.updateNotify(gVar, false, strArr);
            if (z) {
                doNotify(gVar.field_appId, 3, gVar.field_appId);
            }
            AppMethodBeat.o(151739);
        }
        return z;
    }

    public final boolean b(g gVar, String... strArr) {
        boolean z = false;
        AppMethodBeat.i(151740);
        if (gVar == null || Util.isNullOrNil(gVar.field_appId)) {
            AppMethodBeat.o(151740);
        } else {
            if (g.JVR.equals(gVar.field_appId) || g.JVT.equals(gVar.field_appId)) {
                Log.i("MicroMsg.AppInfoStorage", "delete appinfo: %s, %s, %s, %s, %s", gVar.field_appId, gVar.field_appName, Integer.valueOf(gVar.field_serviceShowFlag), Integer.valueOf(gVar.field_appInfoFlag), Util.getStack());
            }
            ayf(gVar.field_appId);
            z = super.delete(gVar, false, strArr);
            if (z) {
                doNotify(gVar.field_appId, 5, gVar.field_appId);
            }
            AppMethodBeat.o(151740);
        }
        return z;
    }

    public final List<String> gmW() {
        AppMethodBeat.i(151741);
        Log.d("MicroMsg.AppInfoStorage", "getNullOpenIdList, maxCount = -1");
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = rawQuery("select appId from AppInfo where openId is NULL ", new String[0]);
        if (rawQuery == null) {
            Log.e("MicroMsg.AppInfoStorage", "get null cursor");
            AppMethodBeat.o(151741);
        } else {
            int count = rawQuery.getCount();
            if (count <= 0) {
                Log.w("MicroMsg.AppInfoStorage", "getNullOpenIdList fail, cursor count = ".concat(String.valueOf(count)));
                rawQuery.close();
                AppMethodBeat.o(151741);
            } else {
                if (rawQuery.moveToFirst()) {
                    while (!rawQuery.isAfterLast()) {
                        int columnIndex = rawQuery.getColumnIndex("appId");
                        if (columnIndex >= 0) {
                            String string = rawQuery.getString(columnIndex);
                            if (!Util.isNullOrNil(string)) {
                                arrayList.add(string);
                            }
                        }
                        rawQuery.moveToNext();
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(151741);
            }
        }
        return arrayList;
    }

    public final g bdG(String str) {
        AppMethodBeat.i(151742);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AppInfoStorage", "appId is null");
            AppMethodBeat.o(151742);
            return null;
        }
        g aT = this.JWf.aT(str);
        if (aT == null) {
            aT = null;
        }
        if (aT == null || Util.isNullOrNil(aT.field_appId)) {
            g gVar = new g();
            gVar.field_appId = str;
            if (super.get(gVar, new String[0])) {
                q(gVar);
                AppMethodBeat.o(151742);
                return gVar;
            }
            AppMethodBeat.o(151742);
            return null;
        }
        AppMethodBeat.o(151742);
        return aT;
    }

    public final Cursor hG(int i2, int i3) {
        AppMethodBeat.i(151743);
        StringBuilder sb = new StringBuilder(256);
        sb.append("select * from AppInfo");
        sb.append(" where ");
        if (i2 != 0) {
            sb.append(" ( serviceAppInfoFlag & ").append(i2).append(" ) != 0 and ");
        }
        sb.append(" ( serviceShowFlag & ").append(i3).append(" ) != 0");
        Cursor rawQuery = rawQuery(sb.toString(), new String[0]);
        if (rawQuery == null) {
            Log.e("MicroMsg.AppInfoStorage", "getServiceByAppInfoFlagAndShowFlag : cursor is null");
            AppMethodBeat.o(151743);
            return null;
        }
        AppMethodBeat.o(151743);
        return rawQuery;
    }

    public final Cursor gmX() {
        AppMethodBeat.i(151744);
        Cursor rawQuery = rawQuery("select * from AppInfo where appType like '%1,%'", new String[0]);
        if (rawQuery == null) {
            Log.e("MicroMsg.AppInfoStorage", "getGameApp : cursor is null");
            AppMethodBeat.o(151744);
            return null;
        }
        AppMethodBeat.o(151744);
        return rawQuery;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String gF(java.lang.String r11, int r12) {
        /*
        // Method dump skipped, instructions count: 402
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.model.app.j.gF(java.lang.String, int):java.lang.String");
    }

    public final boolean u(String str, Bitmap bitmap) {
        AppMethodBeat.i(151746);
        if (str == null || str.length() == 0 || bitmap == null || bitmap.isRecycled()) {
            Log.e("MicroMsg.AppInfoStorage", "saveIcon : invalid argument");
            AppMethodBeat.o(151746);
            return false;
        }
        String gF = gF(str, 1);
        if (gF == null) {
            Log.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
            AppMethodBeat.o(151746);
            return false;
        }
        o oVar = new o(gF);
        if (oVar.exists()) {
            oVar.delete();
        }
        try {
            OutputStream ap = s.ap(oVar);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, ap);
            ap.close();
            doNotify(str);
            AppMethodBeat.o(151746);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppInfoStorage", e2, "", new Object[0]);
            Log.e("MicroMsg.AppInfoStorage", "saveIcon : compress occurs an exception");
            AppMethodBeat.o(151746);
            return false;
        }
    }

    public final boolean d(String str, byte[] bArr, int i2) {
        AppMethodBeat.i(151747);
        if (str == null || str.length() == 0 || bArr == null || bArr.length == 0) {
            Log.e("MicroMsg.AppInfoStorage", "saveIcon, invalid argument");
            AppMethodBeat.o(151747);
            return false;
        }
        String gF = gF(str, i2);
        if (gF == null) {
            Log.e("MicroMsg.AppInfoStorage", "saveIcon fail, iconPath is null");
            AppMethodBeat.o(151747);
            return false;
        }
        o oVar = new o(gF);
        if (oVar.exists()) {
            oVar.delete();
        }
        OutputStream outputStream = null;
        try {
            outputStream = s.ap(oVar);
            outputStream.write(bArr);
            outputStream.close();
            doNotify(str);
            AppMethodBeat.o(151747);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppInfoStorage", e2, "", new Object[0]);
            Log.e("MicroMsg.AppInfoStorage", "saveIcon, exception, e = " + e2.getMessage());
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.o(151747);
            return false;
        }
    }
}
