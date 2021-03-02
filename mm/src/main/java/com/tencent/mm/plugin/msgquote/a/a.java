package com.tencent.mm.plugin.msgquote.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;

public final class a extends MAutoStorage<b> {
    public static final String[] INDEX_CREATE = {"CREATE INDEX IF NOT EXISTS quotedMsgSvrIdIndex ON MsgQuote ( quotedMsgSvrId )"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(b.info, "MsgQuote")};
    private ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(b bVar) {
        AppMethodBeat.i(88808);
        boolean b2 = b(bVar);
        AppMethodBeat.o(88808);
        return b2;
    }

    static {
        AppMethodBeat.i(88809);
        AppMethodBeat.o(88809);
    }

    public a(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, b.info, "MsgQuote", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final b Hj(long j2) {
        AppMethodBeat.i(88803);
        if (j2 <= 0) {
            Log.e("MicroMsg.msgquote.MsgQuoteStorage", "getMsgQuteByMsgId:%s", Long.valueOf(j2));
            AppMethodBeat.o(88803);
            return null;
        }
        Cursor query = this.db.query("MsgQuote", b.info.columns, "msgId=?", new String[]{String.valueOf(j2)}, null, null, null);
        if (query == null) {
            AppMethodBeat.o(88803);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            b bVar = new b();
            bVar.convertFrom(query);
            arrayList.add(bVar);
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.o(88803);
            return null;
        }
        b bVar2 = (b) arrayList.get(0);
        AppMethodBeat.o(88803);
        return bVar2;
    }

    public final b Hk(long j2) {
        AppMethodBeat.i(88804);
        if (j2 <= 0) {
            Log.e("MicroMsg.msgquote.MsgQuoteStorage", "quotedMsgSvrId:%s", Long.valueOf(j2));
            AppMethodBeat.o(88804);
            return null;
        }
        Cursor query = this.db.query("MsgQuote", b.info.columns, "quotedMsgSvrId=?", new String[]{String.valueOf(j2)}, null, null, null);
        if (query == null) {
            AppMethodBeat.o(88804);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            b bVar = new b();
            bVar.convertFrom(query);
            arrayList.add(bVar);
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.o(88804);
            return null;
        }
        b bVar2 = (b) arrayList.get(0);
        AppMethodBeat.o(88804);
        return bVar2;
    }

    public final b Hl(long j2) {
        AppMethodBeat.i(88805);
        if (j2 <= 0) {
            Log.e("MicroMsg.msgquote.MsgQuoteStorage", "quotedMsgId:%s", Long.valueOf(j2));
            AppMethodBeat.o(88805);
            return null;
        }
        Cursor query = this.db.query("MsgQuote", b.info.columns, "quotedMsgId=?", new String[]{String.valueOf(j2)}, null, null, null);
        if (query == null) {
            AppMethodBeat.o(88805);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            b bVar = new b();
            bVar.convertFrom(query);
            arrayList.add(bVar);
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.o(88805);
            return null;
        }
        b bVar2 = (b) arrayList.get(0);
        AppMethodBeat.o(88805);
        return bVar2;
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(88806);
        if (bVar == null) {
            AppMethodBeat.o(88806);
            return false;
        }
        boolean update = update(bVar.systemRowid, bVar);
        AppMethodBeat.o(88806);
        return update;
    }

    public final boolean b(b bVar) {
        AppMethodBeat.i(88807);
        if (bVar == null) {
            AppMethodBeat.o(88807);
            return false;
        }
        bVar.field_status = 0;
        boolean insert = super.insert(bVar);
        AppMethodBeat.o(88807);
        return insert;
    }
}
