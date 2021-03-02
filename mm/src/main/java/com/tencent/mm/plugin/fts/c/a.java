package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.List;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    public SQLiteStatement wZA;
    public SQLiteStatement wZB;
    private SQLiteStatement wZC;
    public SQLiteStatement wZD;
    public SQLiteStatement wZE;
    private SQLiteStatement wZF;
    public SQLiteStatement wZG;

    @Override // com.tencent.mm.plugin.fts.a.a
    public final void awY() {
        AppMethodBeat.i(52783);
        if (awZ()) {
            this.wUt.W(-102, 5);
        }
        this.wUt.execSQL("CREATE TABLE IF NOT EXISTS FTS5ChatRoomMembers (chatroom TEXT, member TEXT);");
        this.wUt.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_chatroom ON FTS5ChatRoomMembers(chatroom);");
        this.wUt.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_member ON FTS5ChatRoomMembers(member);");
        this.wUt.execSQL("CREATE TABLE IF NOT EXISTS FTS5ContactLabels (user TEXT, label_id INTEGER);");
        this.wUt.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_user ON FTS5ContactLabels(user);");
        this.wUt.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_label ON FTS5ContactLabels(label_id);");
        this.wZA = this.wUt.compileStatement("INSERT INTO FTS5ChatRoomMembers (chatroom, member) VALUES (?, ?);");
        this.wZB = this.wUt.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=? AND member=?;");
        this.wZC = this.wUt.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=?;");
        this.wZD = this.wUt.compileStatement("INSERT INTO FTS5ContactLabels (user, label_id) VALUES (?, ?);");
        this.wZE = this.wUt.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=? AND label_id=?;");
        this.wZF = this.wUt.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=?;");
        this.wZG = this.wUt.compileStatement("SELECT changes();");
        AppMethodBeat.o(52783);
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final boolean axa() {
        AppMethodBeat.i(52784);
        super.axa();
        this.wZA.close();
        this.wZB.close();
        this.wZC.close();
        this.wZD.close();
        this.wZE.close();
        this.wZF.close();
        this.wZG.close();
        AppMethodBeat.o(52784);
        return true;
    }

    public final void u(String str, List<Long> list) {
        AppMethodBeat.i(52785);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(52785);
            return;
        }
        boolean inTransaction = this.wUt.inTransaction();
        if (!inTransaction) {
            this.wUt.beginTransaction();
        }
        this.wZD.bindString(1, str);
        for (Long l : list) {
            this.wZD.bindLong(2, l.longValue());
            this.wZD.execute();
        }
        if (!inTransaction) {
            this.wUt.commit();
        }
        AppMethodBeat.o(52785);
    }

    public final void ayG(String str) {
        AppMethodBeat.i(52786);
        this.wZF.bindString(1, str);
        this.wZF.execute();
        AppMethodBeat.o(52786);
    }

    public final Cursor ayH(String str) {
        AppMethodBeat.i(52787);
        Cursor rawQuery = this.wUt.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[]{str});
        AppMethodBeat.o(52787);
        return rawQuery;
    }

    public final void k(String str, String[] strArr) {
        AppMethodBeat.i(52788);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(52788);
            return;
        }
        boolean inTransaction = this.wUt.inTransaction();
        if (!inTransaction) {
            this.wUt.beginTransaction();
        }
        this.wZA.bindString(1, str);
        for (String str2 : strArr) {
            this.wZA.bindString(2, str2);
            this.wZA.execute();
        }
        if (!inTransaction) {
            this.wUt.commit();
        }
        AppMethodBeat.o(52788);
    }

    public final void ayI(String str) {
        AppMethodBeat.i(52789);
        this.wZC.bindString(1, str);
        this.wZC.execute();
        AppMethodBeat.o(52789);
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final String getTableName() {
        return AppEventsConstants.EVENT_NAME_CONTACT;
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final String getName() {
        return "FTS5ContactStorage";
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getType() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.fts.a.i
    public final int getPriority() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final String cVp() {
        AppMethodBeat.i(52790);
        String format = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", dOt());
        AppMethodBeat.o(52790);
        return format;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final boolean awZ() {
        AppMethodBeat.i(52791);
        if (!gD(-102, 5)) {
            AppMethodBeat.o(52791);
            return true;
        }
        AppMethodBeat.o(52791);
        return false;
    }

    public final Cursor a(h hVar, String str, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(52792);
        String dOz = hVar.dOz();
        String format = Util.isNullOrNil(str) ? "" : String.format(" AND aux_index = '%s'", str);
        Cursor rawQuery = this.wUt.rawQuery(String.format("SELECT aux_index, type, subtype FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + format + ((iArr == null || iArr.length <= 0) ? "" : " AND type IN " + d.C(iArr)) + ((iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + d.C(iArr2)) + " AND status >= 0 ORDER BY subtype;", dOt(), dOu(), dOt(), dOu(), dOu(), dOz), null);
        AppMethodBeat.o(52792);
        return rawQuery;
    }

    public final boolean b(h hVar) {
        AppMethodBeat.i(52793);
        Object[] objArr = new Object[6];
        objArr[0] = dOt();
        objArr[1] = dOu();
        objArr[2] = dOt();
        objArr[3] = dOu();
        objArr[4] = dOu();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < hVar.wWF.size(); i2++) {
            stringBuffer.append("(");
            stringBuffer.append(hVar.wWF.get(i2).dOB());
            stringBuffer.append(")");
            if (i2 != hVar.wWF.size() - 1) {
                stringBuffer.append(" OR ");
            }
        }
        objArr[5] = stringBuffer.toString();
        Cursor rawQuery = this.wUt.rawQuery(String.format("SELECT 1 FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type=131072 LIMIT 1;", objArr), null);
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        AppMethodBeat.o(52793);
        return moveToNext;
    }

    @Override // com.tencent.mm.plugin.fts.a.a
    public final boolean dOv() {
        return true;
    }
}
