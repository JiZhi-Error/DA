package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class t extends MAutoStorage<s> implements l {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(s.info, "snsTagInfo2")};
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(s sVar) {
        AppMethodBeat.i(97634);
        boolean a2 = a(sVar);
        AppMethodBeat.o(97634);
        return a2;
    }

    static {
        AppMethodBeat.i(97635);
        AppMethodBeat.o(97635);
    }

    public t(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, s.info, "snsTagInfo2", null);
        this.db = iSQLiteDatabase;
    }

    public final s JL(long j2) {
        AppMethodBeat.i(97624);
        Cursor rawQuery = this.db.rawQuery("select *, rowid from snsTagInfo2 where tagId = ? ", new String[]{String.valueOf(j2)}, 2);
        s sVar = new s();
        if (rawQuery.moveToFirst()) {
            sVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(97624);
        return sVar;
    }

    @Override // com.tencent.mm.plugin.sns.b.l
    public final List<String> IZ(long j2) {
        AppMethodBeat.i(97625);
        s JL = JL(j2);
        if (JL.field_memberList == null || JL.field_memberList.equals("")) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(97625);
            return arrayList;
        }
        ArrayList<String> stringsToList = Util.stringsToList(JL.field_memberList.split(","));
        AppMethodBeat.o(97625);
        return stringsToList;
    }

    @Override // com.tencent.mm.plugin.sns.b.l
    public final String Ja(long j2) {
        AppMethodBeat.i(97626);
        String str = JL(j2).field_tagName;
        AppMethodBeat.o(97626);
        return str;
    }

    public final List<Long> ffg() {
        AppMethodBeat.i(97627);
        Cursor query = this.db.query("snsTagInfo2", new String[]{"tagId"}, null, null, null, null, null, 2);
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            arrayList.add(Long.valueOf(query.getLong(0)));
        }
        query.close();
        AppMethodBeat.o(97627);
        return arrayList;
    }

    public final boolean a(s sVar) {
        AppMethodBeat.i(97628);
        if (sVar.field_tagId == 0) {
            AppMethodBeat.o(97628);
            return false;
        }
        long j2 = sVar.field_tagId;
        Cursor rawQuery = this.db.rawQuery("select *, rowid from snsTagInfo2 where tagId = ? ", new String[]{String.valueOf(j2)}, 2);
        boolean moveToFirst = rawQuery.moveToFirst();
        rawQuery.close();
        if (!moveToFirst) {
            super.insert(sVar);
        } else {
            super.replace(sVar);
        }
        doNotify(new StringBuilder().append(sVar.field_tagId).toString(), 0, sVar);
        AppMethodBeat.o(97628);
        return true;
    }

    public final int JM(long j2) {
        AppMethodBeat.i(97629);
        int delete = this.db.delete("snsTagInfo2", " tagId = ? ", new String[]{String.valueOf(j2)});
        AppMethodBeat.o(97629);
        return delete;
    }

    public final boolean K(long j2, String str) {
        AppMethodBeat.i(97630);
        String str2 = "select tagId, tagName, count, rowid from snsTagInfo2 where tagId > 5 AND  tagName  =\"" + Util.escapeSqlValue(str) + "\" AND  tagId != " + j2;
        Log.d("MicroMsg.SnsTagInfoStorage", "isTagNameExist ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.db.rawQuery(str2, null, 2);
        boolean moveToFirst = rawQuery.moveToFirst();
        rawQuery.close();
        AppMethodBeat.o(97630);
        return moveToFirst;
    }

    public final Cursor getCursor() {
        AppMethodBeat.i(97631);
        Cursor rawQuery = this.db.rawQuery("select *, rowid from snsTagInfo2 where tagId > 5", null);
        AppMethodBeat.o(97631);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.sns.b.l
    public final boolean aKt(String str) {
        AppMethodBeat.i(97632);
        s JL = JL(5);
        if (Util.isNullOrNil(JL.field_memberList)) {
            AppMethodBeat.o(97632);
            return false;
        }
        boolean contains = Util.stringsToList(JL.field_memberList.split(",")).contains(str);
        AppMethodBeat.o(97632);
        return contains;
    }

    @Override // com.tencent.mm.plugin.sns.b.l
    public final boolean eZm() {
        AppMethodBeat.i(97633);
        if (ffg().size() == 0) {
            AppMethodBeat.o(97633);
            return false;
        }
        AppMethodBeat.o(97633);
        return true;
    }
}
