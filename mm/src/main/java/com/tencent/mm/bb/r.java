package com.tencent.mm.bb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import junit.framework.Assert;

public final class r extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS packageinfo ( id int  PRIMARY KEY, version int  , name text  , size int  , packname text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE TABLE IF NOT EXISTS packageinfo2 ( localId text  PRIMARY KEY , id int  , version int  , name text  , size int  , packname text  , status int  , type int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    public h iFy;

    public r(h hVar) {
        this.iFy = hVar;
    }

    public final boolean a(q qVar) {
        AppMethodBeat.i(150837);
        if (qVar == null) {
            AppMethodBeat.o(150837);
            return false;
        }
        qVar.cSx = -1;
        if (((int) this.iFy.insert("packageinfo2", ch.COL_LOCALID, qVar.convertTo())) != -1) {
            doNotify();
            AppMethodBeat.o(150837);
            return true;
        }
        AppMethodBeat.o(150837);
        return false;
    }

    public final boolean b(q qVar) {
        AppMethodBeat.i(150838);
        Assert.assertTrue(qVar != null);
        ContentValues convertTo = qVar.convertTo();
        if (convertTo.size() > 0) {
            if (this.iFy.update("packageinfo2", convertTo, "id= ? and type =?", new String[]{new StringBuilder().append(qVar.id).toString(), new StringBuilder().append(qVar.dMe).toString()}) > 0) {
                doNotify();
                AppMethodBeat.o(150838);
                return true;
            }
        }
        doNotify();
        AppMethodBeat.o(150838);
        return false;
    }

    public final boolean tH(int i2) {
        AppMethodBeat.i(150839);
        boolean execSQL = this.iFy.execSQL("packageinfo2", "update packageinfo2 set status = 2 where status = 1 and type = " + i2 + ";");
        doNotify();
        AppMethodBeat.o(150839);
        return execSQL;
    }

    public final Cursor ber() {
        AppMethodBeat.i(150840);
        Cursor rawQuery = this.iFy.rawQuery("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=1", null);
        AppMethodBeat.o(150840);
        return rawQuery;
    }

    public final q dt(int i2, int i3) {
        q qVar = null;
        AppMethodBeat.i(150841);
        Cursor rawQuery = this.iFy.rawQuery("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.id = \"" + Util.escapeSqlValue(String.valueOf(i2)) + "\" and packageinfo2.type = \"" + Util.escapeSqlValue(String.valueOf(i3)) + "\"", null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(150841);
        } else {
            if (rawQuery.moveToFirst()) {
                qVar = new q();
                qVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(150841);
        }
        return qVar;
    }

    public final boolean tI(int i2) {
        AppMethodBeat.i(150842);
        if (this.iFy.delete("packageinfo2", "type =?", new String[]{String.valueOf(i2)}) > 0) {
            doNotify();
            AppMethodBeat.o(150842);
            return true;
        }
        AppMethodBeat.o(150842);
        return false;
    }

    public final q[] tJ(int i2) {
        AppMethodBeat.i(150843);
        Cursor rawQuery = this.iFy.rawQuery("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=".concat(String.valueOf(i2)), null, 2);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            q qVar = new q();
            qVar.convertFrom(rawQuery);
            arrayList.add(qVar);
        }
        rawQuery.close();
        q[] qVarArr = (q[]) arrayList.toArray(new q[arrayList.size()]);
        AppMethodBeat.o(150843);
        return qVarArr;
    }

    public static String bes() {
        AppMethodBeat.i(150844);
        String aTf = a.aTf();
        AppMethodBeat.o(150844);
        return aTf;
    }

    public static String du(int i2, int i3) {
        AppMethodBeat.i(150845);
        String str = i2 + "_" + i3 + "_thumb.jpg";
        AppMethodBeat.o(150845);
        return str;
    }

    public final String dv(int i2, int i3) {
        AppMethodBeat.i(150846);
        switch (i3) {
            case 0:
                AppMethodBeat.o(150846);
                return "";
            case 1:
                String str = i2 + "_session_bg.zip";
                AppMethodBeat.o(150846);
                return str;
            case 2:
                String str2 = i2 + "_emoji_art.temp";
                AppMethodBeat.o(150846);
                return str2;
            case 5:
                AppMethodBeat.o(150846);
                return "brand_i18n.apk";
            case 7:
                String str3 = i2 + "_configlist.cfg";
                AppMethodBeat.o(150846);
                return str3;
            case 9:
                AppMethodBeat.o(150846);
                return "_speex_upload.cfg";
            case 12:
                AppMethodBeat.o(150846);
                return "_rcpt_addr";
            case 18:
                String str4 = dt(i2, i3).version + "_feature.zip";
                AppMethodBeat.o(150846);
                return str4;
            case 19:
                AppMethodBeat.o(150846);
                return "_report_reason.temp";
            case 20:
                AppMethodBeat.o(150846);
                return "_pluginDesc.cfg";
            case 21:
                AppMethodBeat.o(150846);
                return "_trace_config.cfg";
            case 23:
                AppMethodBeat.o(150846);
                return "permissioncfg.cfg";
            case 26:
                AppMethodBeat.o(150846);
                return "ipcallCountryCodeConfig.cfg";
            case 36:
                String str5 = i2 + "_sensewhere.xml";
                AppMethodBeat.o(150846);
                return str5;
            default:
                AppMethodBeat.o(150846);
                return "";
        }
    }

    public final String dw(int i2, int i3) {
        AppMethodBeat.i(150847);
        switch (i3) {
            case 0:
                AppMethodBeat.o(150847);
                return "";
            case 1:
                String str = a.aTf() + i2 + "_session_bg/";
                try {
                    o oVar = new o(str);
                    if (!oVar.exists()) {
                        oVar.mkdirs();
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.PackageInfoStorage", "exception:%s", Util.stackTraceToString(e2));
                    Log.e("MicroMsg.PackageInfoStorage", "can not create dir, dir = ".concat(String.valueOf(str)));
                }
                AppMethodBeat.o(150847);
                return str;
            case 2:
                AppMethodBeat.o(150847);
                return "";
            case 18:
                String str2 = a.aTf() + dv(i2, i3).replace(".zip", "");
                AppMethodBeat.o(150847);
                return str2;
            default:
                AppMethodBeat.o(150847);
                return "";
        }
    }

    public final void dx(int i2, int i3) {
        AppMethodBeat.i(150848);
        s.deleteFile(a.aTf() + dv(i2, i3));
        q dt = dt(i2, i3);
        if (dt != null) {
            dt.status = 5;
            v.bev().b(dt);
        }
        AppMethodBeat.o(150848);
    }

    public static int dd(Context context) {
        AppMethodBeat.i(150849);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        boolean z = displayMetrics.heightPixels > displayMetrics.widthPixels;
        if (displayMetrics.density <= 1.0f) {
            if (z) {
                AppMethodBeat.o(150849);
                return 4;
            }
            AppMethodBeat.o(150849);
            return 2;
        } else if (z) {
            AppMethodBeat.o(150849);
            return 3;
        } else {
            AppMethodBeat.o(150849);
            return 1;
        }
    }

    public static String T(String str, boolean z) {
        AppMethodBeat.i(150850);
        if (z) {
            String str2 = a.aTf() + str + "_chatting_bg_vertical.jpg";
            AppMethodBeat.o(150850);
            return str2;
        }
        String str3 = a.aTf() + str + "_chatting_bg_horizontal.jpg";
        AppMethodBeat.o(150850);
        return str3;
    }

    public static String as(String str, int i2) {
        AppMethodBeat.i(150851);
        switch (i2) {
            case 1:
            case 2:
                String T = T(str, false);
                AppMethodBeat.o(150851);
                return T;
            case 3:
            case 4:
                String T2 = T(str, true);
                AppMethodBeat.o(150851);
                return T2;
            default:
                AppMethodBeat.o(150851);
                return null;
        }
    }
}
