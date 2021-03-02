package com.tencent.mm.plugin.subapp.d;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.g.c.hb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class k extends MAutoStorage<g> {
    private static long FKp = 0;
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(g.info, "VoiceRemindInfo")};
    private Map<String, c> FKq = new HashMap();
    ISQLiteDatabase db;

    static {
        AppMethodBeat.i(29002);
        AppMethodBeat.o(29002);
    }

    public k(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, g.info, "VoiceRemindInfo", hb.INDEX_CREATE);
        AppMethodBeat.i(28995);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(28995);
    }

    public static String Qv(String str) {
        AppMethodBeat.i(28996);
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(currentTimeMillis));
        if (str != null && str.length() > 1) {
            format = format + g.getMessageDigest(str.getBytes()).substring(0, 7);
        }
        StringBuilder append = new StringBuilder().append(format + (currentTimeMillis % 10000));
        long j2 = FKp;
        FKp = 1 + j2;
        String sb = append.append(j2).toString();
        AppMethodBeat.o(28996);
        return sb;
    }

    public final boolean gC(String str) {
        AppMethodBeat.i(28997);
        Assert.assertTrue(str.length() > 0);
        if (this.db.delete("VoiceRemindInfo", "filename= ?", new String[]{str}) <= 0) {
            Log.w("MicroMsg.VoiceRemindStorage", "delete failed, no such file:".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(28997);
        return true;
    }

    public final c aSO(String str) {
        AppMethodBeat.i(28998);
        if (this.FKq.get(str) == null) {
            this.FKq.put(str, new c(str));
        }
        c cVar = this.FKq.get(str);
        AppMethodBeat.o(28998);
        return cVar;
    }

    public final void Rg(String str) {
        AppMethodBeat.i(28999);
        c cVar = this.FKq.get(str);
        if (cVar != null) {
            cVar.bhP();
            this.FKq.remove(str);
        }
        AppMethodBeat.o(28999);
    }

    public final g aSP(String str) {
        AppMethodBeat.i(29000);
        g gVar = null;
        Cursor rawQuery = this.db.rawQuery("SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo WHERE filename= ?", new String[]{str}, 2);
        if (rawQuery.moveToFirst()) {
            gVar = new g();
            gVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(29000);
        return gVar;
    }

    public final boolean a(String str, g gVar) {
        boolean z;
        AppMethodBeat.i(29001);
        Assert.assertTrue(str.length() > 0);
        if (gVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues convertTo = gVar.convertTo();
        if (convertTo.size() <= 0) {
            Log.e("MicroMsg.VoiceRemindStorage", "update failed, no values set");
        } else {
            if (this.db.update("VoiceRemindInfo", convertTo, "filename= ?", new String[]{str}) > 0) {
                doNotify();
                AppMethodBeat.o(29001);
                return true;
            }
        }
        AppMethodBeat.o(29001);
        return false;
    }
}
