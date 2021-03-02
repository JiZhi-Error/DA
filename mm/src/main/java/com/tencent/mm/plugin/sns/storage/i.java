package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gh;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public final class i extends MAutoStorage<h> implements e {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(h.info, "SnsComment")};
    public h iFy;

    static {
        AppMethodBeat.i(97465);
        AppMethodBeat.o(97465);
    }

    public i(h hVar) {
        super(hVar, h.info, "SnsComment", gh.INDEX_CREATE);
        this.iFy = hVar;
    }

    public static String feF() {
        return "select *, rowid from SnsComment";
    }

    @Override // com.tencent.mm.plugin.sns.b.e
    public final int ctM() {
        int i2 = 0;
        AppMethodBeat.i(97454);
        Cursor rawQuery = this.iFy.rawQuery(" select count(*) from SnsComment where isRead = ? and isSilence != ? ", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "1"}, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(97454);
        } else {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.o(97454);
        }
        return i2;
    }

    public final Cursor Zq(int i2) {
        AppMethodBeat.i(97455);
        String str = "select *, rowid from SnsComment where isSend = 0 order by createTime desc LIMIT " + i2;
        Log.v("MicroMsg.SnsCommentStorage", "getCursor sql:".concat(String.valueOf(str)));
        Cursor rawQuery = this.iFy.rawQuery(str, null);
        AppMethodBeat.o(97455);
        return rawQuery;
    }

    public final Cursor feG() {
        AppMethodBeat.i(97456);
        Cursor rawQuery = this.iFy.rawQuery("select *, rowid from SnsComment where isRead = ?  and isSilence != ?  order by createTime desc", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "1"});
        AppMethodBeat.o(97456);
        return rawQuery;
    }

    public final boolean a(long j2, String str, int i2, String str2) {
        String str3;
        AppMethodBeat.i(97457);
        if (Util.isNullOrNil(str2)) {
            str3 = "select count(*) from SnsComment where snsID = " + j2 + " and createTime = " + i2 + " and talker = '" + str + "'";
        } else {
            str3 = "select count(*) from SnsComment where snsID = " + j2 + " and clientId = '" + str2 + "'";
        }
        Cursor rawQuery = rawQuery(str3, new String[0]);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            int i3 = rawQuery.getInt(0);
            rawQuery.close();
            if (i3 > 0) {
                AppMethodBeat.o(97457);
                return true;
            }
            AppMethodBeat.o(97457);
            return false;
        }
        AppMethodBeat.o(97457);
        return false;
    }

    public final int feH() {
        AppMethodBeat.i(97458);
        Cursor rawQuery = rawQuery("select count(*) from SnsComment where isSend = 0", new String[0]);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            int i2 = rawQuery.getInt(0);
            rawQuery.close();
            AppMethodBeat.o(97458);
            return i2;
        }
        AppMethodBeat.o(97458);
        return 0;
    }

    public final h i(long j2, long j3, int i2) {
        h hVar;
        AppMethodBeat.i(97459);
        String str = "";
        if (i2 == 9) {
            str = str + "(2)";
        }
        if (i2 == 10) {
            str = str + "(8,16)";
        }
        Cursor rawQuery = rawQuery("select *, rowid from SnsComment where snsID = " + j2 + " and commentSvrID = " + j3 + " and type in " + str, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                hVar = new h();
                hVar.convertFrom(rawQuery);
            } else {
                hVar = null;
            }
            rawQuery.close();
        } else {
            hVar = null;
        }
        AppMethodBeat.o(97459);
        return hVar;
    }

    public final boolean JI(long j2) {
        AppMethodBeat.i(97460);
        boolean execSQL = this.iFy.execSQL("SnsComment", "delete from SnsComment where snsID = ".concat(String.valueOf(j2)));
        AppMethodBeat.o(97460);
        return execSQL;
    }

    public final boolean j(long j2, long j3, int i2) {
        AppMethodBeat.i(97461);
        String str = "";
        if (i2 == 9) {
            str = str + "(2)";
        }
        if (i2 == 10) {
            str = str + "(8,16)";
        }
        boolean execSQL = this.iFy.execSQL("SnsComment", "delete from SnsComment where snsID = " + j2 + " and commentSvrID = " + j3 + " and type in " + str);
        AppMethodBeat.o(97461);
        return execSQL;
    }

    public final boolean ctN() {
        AppMethodBeat.i(97462);
        boolean execSQL = this.iFy.execSQL("SnsComment", " update SnsComment set isRead = 1 where isRead = 0");
        AppMethodBeat.o(97462);
        return execSQL;
    }

    public final boolean L(long j2, boolean z) {
        AppMethodBeat.i(97463);
        int i2 = z ? 1 : 0;
        String str = " update SnsComment set isSilence = " + i2 + " where isSilence != " + i2 + " and  snsID = " + j2;
        Log.i("MicroMsg.SnsCommentStorage", "updateIsSilence ".concat(String.valueOf(str)));
        boolean execSQL = this.iFy.execSQL("SnsComment", str);
        AppMethodBeat.o(97463);
        return execSQL;
    }

    public final void eIQ() {
        AppMethodBeat.i(97464);
        this.iFy.blB("SnsComment");
        AppMethodBeat.o(97464);
    }
}
