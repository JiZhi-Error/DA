package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;

public final class s extends MAutoStorage<o> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(o.info, "GameRawMessage")};

    static {
        AppMethodBeat.i(41499);
        AppMethodBeat.o(41499);
    }

    public s(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, o.info, "GameRawMessage", null);
    }

    public final o GJ(long j2) {
        AppMethodBeat.i(41492);
        o oVar = new o();
        oVar.field_msgId = j2;
        if (get(oVar, new String[0])) {
            AppMethodBeat.o(41492);
            return oVar;
        }
        AppMethodBeat.o(41492);
        return null;
    }

    public final LinkedList<o> b(int i2, long j2, int i3, int i4) {
        String str;
        AppMethodBeat.i(41493);
        String valueOf = j2 == 0 ? "9223372036854775807" : String.valueOf(j2);
        if (i3 == 0) {
            str = "(isRead=1 or isRead=0) ";
        } else if (i3 == 1) {
            str = "isRead=0 ";
        } else if (i3 == 2) {
            str = "isRead=1 ";
        } else {
            AppMethodBeat.o(41493);
            return null;
        }
        String str2 = "";
        if (i2 != 65536) {
            str2 = "msgType=" + i2 + " and ";
        }
        String format = String.format("select * from GameRawMessage where " + str2 + "msgId<%s and " + str + "order by createTime desc limit %s", valueOf, String.valueOf(i4));
        LinkedList<o> linkedList = new LinkedList<>();
        Cursor rawQuery = rawQuery(format, new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(41493);
            return linkedList;
        }
        if (rawQuery.moveToFirst()) {
            do {
                o oVar = new o();
                oVar.convertFrom(rawQuery);
                linkedList.add(oVar);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        AppMethodBeat.o(41493);
        return linkedList;
    }

    public final boolean c(long[] jArr) {
        AppMethodBeat.i(41494);
        if (jArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("msgId in (");
            for (int i2 = 0; i2 < jArr.length; i2++) {
                sb.append(jArr[i2]);
                if (i2 != jArr.length - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            boolean execSQL = execSQL("GameRawMessage", String.format("update GameRawMessage set isRead=1 where %s", sb.toString()));
            AppMethodBeat.o(41494);
            return execSQL;
        }
        AppMethodBeat.o(41494);
        return false;
    }

    public final o aAk(String str) {
        AppMethodBeat.i(184804);
        Cursor rawQuery = rawQuery("select * from GameRawMessage where gameMsgId = \"" + str + "\"", new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(184804);
            return null;
        }
        o oVar = new o();
        if (rawQuery.moveToFirst()) {
            oVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(184804);
        return oVar;
    }

    public final void dVw() {
        AppMethodBeat.i(41495);
        execSQL("GameRawMessage", "update GameRawMessage set isHidden = 0 where isHidden = 1");
        AppMethodBeat.o(41495);
    }

    public final void dVx() {
        AppMethodBeat.i(41496);
        execSQL("GameRawMessage", "update GameRawMessage set isRead=1 where isRead=0 and " + D(2, 5, 6, 10, 11, 100) + " and isHidden = 0");
        AppMethodBeat.o(41496);
    }

    public final void dVy() {
        AppMethodBeat.i(183865);
        String str = "delete from GameRawMessage where createTime < (" + "select createTime from GameRawMessage order by createTime desc limit 100000,1" + ")";
        Log.i("MicroMsg.GameMessageStorage", "clearMessageStorage: [%b], [%s]", Boolean.valueOf(execSQL("GameRawMessage", str)), str);
        AppMethodBeat.o(183865);
    }

    public final Cursor On(int i2) {
        AppMethodBeat.i(183866);
        Cursor rawQuery = rawQuery("select * from GameRawMessage where showType = " + i2 + " and showInMsgList = 1 and isHidden = 0" + " order by isRead, createTime desc", new String[0]);
        AppMethodBeat.o(183866);
        return rawQuery;
    }

    public final int Oo(int i2) {
        int i3 = 0;
        AppMethodBeat.i(184805);
        Cursor On = On(i2);
        if (On == null) {
            AppMethodBeat.o(184805);
        } else {
            if (On.moveToFirst()) {
                i3 = On.getInt(0);
            }
            On.close();
            AppMethodBeat.o(184805);
        }
        return i3;
    }

    public final int Op(int i2) {
        int i3 = 0;
        AppMethodBeat.i(183867);
        Cursor rawQuery = rawQuery("select count(*) from GameRawMessage where showType = " + i2 + " and isRead=0 and showInMsgList = 1 and isHidden" + " = 0", new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(183867);
        } else {
            if (rawQuery.moveToFirst()) {
                i3 = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.o(183867);
        }
        return i3;
    }

    public final int dVz() {
        int i2 = 0;
        AppMethodBeat.i(41497);
        Cursor rawQuery = rawQuery("select count(*) from GameRawMessage where " + D(2, 5, 6, 10, 11, 100) + " and isRead=0 and showInMsgList = 1 and isHidden" + " = 0", new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(41497);
        } else {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.o(41497);
        }
        return i2;
    }

    public static String D(int... iArr) {
        AppMethodBeat.i(41498);
        String str = "" + "(";
        for (int i2 = 0; i2 < 5; i2++) {
            str = str + "msgType=" + iArr[i2] + " or ";
        }
        String str2 = (str + "msgType=" + iArr[5]) + ")";
        AppMethodBeat.o(41498);
        return str2;
    }

    public final void dVA() {
        AppMethodBeat.i(204168);
        execSQL("GameRawMessage", "delete from GameRawMessage");
        AppMethodBeat.o(204168);
    }

    public final boolean d(long[] jArr) {
        AppMethodBeat.i(204169);
        if (jArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("msgId in (");
            for (int i2 = 0; i2 < jArr.length; i2++) {
                sb.append(jArr[i2]);
                if (i2 != jArr.length - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            boolean execSQL = execSQL("GameRawMessage", String.format("delete from GameRawMessage where %s", sb.toString()));
            AppMethodBeat.o(204169);
            return execSQL;
        }
        AppMethodBeat.o(204169);
        return false;
    }

    public final boolean Oq(int i2) {
        AppMethodBeat.i(204170);
        boolean execSQL = execSQL("GameRawMessage", "delete from GameRawMessage where showType = ".concat(String.valueOf(i2)));
        AppMethodBeat.o(204170);
        return execSQL;
    }

    public final c.b dVB() {
        int i2;
        AppMethodBeat.i(204171);
        c.b bVar = new c.b();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Cursor rawQuery = rawQuery("select count(*) from GameRawMessage where rawXML like \"%<chatmsg%\" and isRead=0", new String[0]);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst() && (i2 = rawQuery.getInt(0)) > 0) {
                    bVar.xtZ = true;
                    bVar.xua = i2;
                }
                rawQuery.close();
                if (bVar.xtZ) {
                    Log.i("MicroMsg.GameMessageStorage", "unread logic costtime:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(204171);
                    return bVar;
                }
            }
            Cursor rawQuery2 = rawQuery("select count(*) from GameRawMessage where rawXML like \"%<chatmsg%\"", new String[0]);
            if (rawQuery2 == null) {
                AppMethodBeat.o(204171);
                return bVar;
            }
            if (rawQuery2.moveToFirst() && rawQuery2.getInt(0) > 0) {
                bVar.xtZ = true;
            }
            rawQuery2.close();
            Log.i("MicroMsg.GameMessageStorage", "loop logic costtime:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(204171);
            return bVar;
        } catch (Exception e2) {
            Log.i("MicroMsg.GameMessageStorage", "errMsg:%s", e2.getMessage());
        }
    }
}
