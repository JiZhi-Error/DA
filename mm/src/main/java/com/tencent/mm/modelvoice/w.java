package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class w extends MStorage {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS voiceinfo ( FileName TEXT PRIMARY KEY, User TEXT, MsgId INT, NetOffset INT, FileNowSize INT, TotalLen INT, Status INT, CreateTime INT, LastModifyTime INT, ClientId TEXT, VoiceLength INT, MsgLocalId INT, Human TEXT, reserved1 INT, reserved2 TEXT, MsgSource TEXT, MsgFlag INT, MsgSeq INT, MasterBufId INT, checksum INT DEFAULT 0, VoiceFlag INT DEFAULT 0 )", "CREATE INDEX IF NOT EXISTS voiceinfomsgidindex ON voiceinfo ( MsgId ) ", "CREATE UNIQUE INDEX IF NOT EXISTS voiceinfouniqueindex ON voiceinfo ( FileName )", "CREATE INDEX IF NOT EXISTS voice_unfinish_info_index ON voiceinfo ( Status,User,CreateTime )"};
    public h iFy;
    Map<String, a> jvK = new HashMap();
    Map<String, n> jvL = new HashMap();
    Map<String, j> jvM = new HashMap();

    public w(h hVar) {
        AppMethodBeat.i(148504);
        a(hVar);
        this.iFy = hVar;
        AppMethodBeat.o(148504);
    }

    private static void a(h hVar) {
        boolean z;
        AppMethodBeat.i(148505);
        Cursor rawQuery = hVar.rawQuery("PRAGMA table_info(voiceinfo)", null);
        if (rawQuery == null) {
            Log.i("MicroMsg.VoiceStorage", "addNewColIfNeed failed, cursor is null.");
            AppMethodBeat.o(148505);
            return;
        }
        int columnIndex = rawQuery.getColumnIndex("name");
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        while (rawQuery.moveToNext()) {
            if (columnIndex >= 0) {
                String string = rawQuery.getString(columnIndex);
                if ("MsgSource".equals(string)) {
                    z7 = true;
                }
                if ("MsgFlag".equals(string)) {
                    z6 = true;
                }
                if ("MsgSeq".equals(string)) {
                    z5 = true;
                }
                if ("MasterBufId".equals(string)) {
                    z4 = true;
                }
                if ("checksum".equals(string)) {
                    z = true;
                } else {
                    z = z3;
                }
                if ("VoiceFlag".equals(string)) {
                    z2 = true;
                }
                z3 = z;
            }
        }
        rawQuery.close();
        if (!z7) {
            hVar.execSQL("voiceinfo", "Alter table voiceinfo add MsgSource TEXT");
        }
        if (!z6) {
            hVar.execSQL("voiceinfo", "Alter table voiceinfo add MsgFlag INT");
        }
        if (!z5) {
            hVar.execSQL("voiceinfo", "Alter table voiceinfo add MsgSeq INT");
        }
        if (!z4) {
            hVar.execSQL("voiceinfo", "Alter table voiceinfo add MasterBufId INT");
        }
        if (!z3) {
            hVar.execSQL("voiceinfo", "Alter table voiceinfo add checksum INT DEFAULT 0");
        }
        if (!z2) {
            hVar.execSQL("voiceinfo", "Alter table voiceinfo add VoiceFlag INT DEFAULT 0");
        }
        AppMethodBeat.o(148505);
    }

    public static String Rq(String str) {
        AppMethodBeat.i(148506);
        String x = x.x(str, Util.nowMilliSecond());
        AppMethodBeat.o(148506);
        return x;
    }

    public final boolean b(r rVar) {
        AppMethodBeat.i(148507);
        Assert.assertTrue(rVar != null);
        ContentValues convertTo = rVar.convertTo();
        if (convertTo.size() <= 0) {
            Log.e("MicroMsg.VoiceStorage", "insert falied, no values set");
        } else if (this.iFy.insert("voiceinfo", "FileName", convertTo) != -1) {
            doNotify();
            AppMethodBeat.o(148507);
            return true;
        }
        AppMethodBeat.o(148507);
        return false;
    }

    public final boolean gC(String str) {
        AppMethodBeat.i(148508);
        Assert.assertTrue(str.length() > 0);
        if (this.iFy.delete("voiceinfo", "FileName= ?", new String[]{str}) <= 0) {
            Log.w("MicroMsg.VoiceStorage", "delete failed, no such file:".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(148508);
        return true;
    }

    public final boolean a(String str, r rVar) {
        boolean z;
        AppMethodBeat.i(148509);
        Assert.assertTrue(str.length() > 0);
        if (rVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues convertTo = rVar.convertTo();
        if (convertTo.size() <= 0) {
            Log.e("MicroMsg.VoiceStorage", "update failed, no values set");
        } else {
            if (this.iFy.update("voiceinfo", convertTo, "FileName= ?", new String[]{str}) > 0) {
                doNotify();
                AppMethodBeat.o(148509);
                return true;
            }
        }
        AppMethodBeat.o(148509);
        return false;
    }

    public final r AP(long j2) {
        r rVar = null;
        AppMethodBeat.i(148510);
        Cursor rawQuery = this.iFy.rawQuery("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum, VoiceFlag" + " FROM voiceinfo WHERE MsgId=" + j2, null, 2);
        if (rawQuery.moveToFirst()) {
            rVar = new r();
            rVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(148510);
        return rVar;
    }

    public final r uk(int i2) {
        r rVar = null;
        AppMethodBeat.i(148511);
        Cursor rawQuery = this.iFy.rawQuery("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum, VoiceFlag" + " FROM voiceinfo WHERE MsgLocalId=" + i2, null, 2);
        if (rawQuery.moveToFirst()) {
            rVar = new r();
            rVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(148511);
        return rVar;
    }

    public final r Rr(String str) {
        AppMethodBeat.i(148512);
        r rVar = null;
        Cursor rawQuery = this.iFy.rawQuery("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum, VoiceFlag" + " FROM voiceinfo WHERE FileName= ?", new String[]{str}, 2);
        if (rawQuery.moveToFirst()) {
            rVar = new r();
            rVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(148512);
        return rVar;
    }
}
