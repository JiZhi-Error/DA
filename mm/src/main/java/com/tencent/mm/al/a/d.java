package com.tencent.mm.al.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ah;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import java.util.concurrent.atomic.AtomicLong;

public final class d extends MAutoStorage<ah> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "BizChatInfo")};
    public ISQLiteDatabase db;
    final MStorageEvent<a, a.b> iNS = new MStorageEvent<a, a.b>() {
        /* class com.tencent.mm.al.a.d.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(a aVar, a.b bVar) {
            AppMethodBeat.i(124199);
            aVar.a(bVar);
            AppMethodBeat.o(124199);
        }
    };
    private AtomicLong iPI = new AtomicLong(-1);

    static {
        AppMethodBeat.i(124212);
        AppMethodBeat.o(124212);
    }

    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "BizChatInfo", null);
        AppMethodBeat.i(124203);
        this.db = iSQLiteDatabase;
        iSQLiteDatabase.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
        iSQLiteDatabase.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
        iSQLiteDatabase.execSQL("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
        synchronized (this.iPI) {
            try {
                Cursor rawQuery = this.db.rawQuery("select max(bizChatLocalId) from BizChatInfo", null, 2);
                long j2 = 0;
                if (rawQuery.moveToFirst()) {
                    j2 = (long) rawQuery.getInt(0);
                    if (j2 > this.iPI.get()) {
                        this.iPI.set(j2);
                    }
                }
                rawQuery.close();
                Log.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id:".concat(String.valueOf(j2)));
            } finally {
                AppMethodBeat.o(124203);
            }
        }
    }

    public interface a {

        public static class b {
            public String brandName;
            public long iPE;
            public EnumC0249a iPO;
            public c iPP;
        }

        void a(b bVar);

        /* renamed from: com.tencent.mm.al.a.d$a$a  reason: collision with other inner class name */
        public enum EnumC0249a {
            INSTERT,
            DELETE,
            UPDATE;

            public static EnumC0249a valueOf(String str) {
                AppMethodBeat.i(124201);
                EnumC0249a aVar = (EnumC0249a) Enum.valueOf(EnumC0249a.class, str);
                AppMethodBeat.o(124201);
                return aVar;
            }

            static {
                AppMethodBeat.i(124202);
                AppMethodBeat.o(124202);
            }
        }
    }

    public final void a(a aVar, Looper looper) {
        AppMethodBeat.i(124204);
        this.iNS.add(aVar, looper);
        AppMethodBeat.o(124204);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(124205);
        if (this.iNS != null) {
            this.iNS.remove(aVar);
        }
        AppMethodBeat.o(124205);
    }

    public final c bs(long j2) {
        AppMethodBeat.i(124206);
        c cVar = new c();
        cVar.field_bizChatLocalId = j2;
        super.get(cVar, new String[0]);
        AppMethodBeat.o(124206);
        return cVar;
    }

    public final c NE(String str) {
        AppMethodBeat.i(124207);
        c cVar = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select * ");
        sb.append(" from BizChatInfo");
        sb.append(" where bizChatServId = '").append(str).append("' ");
        sb.append(" limit 1");
        String sb2 = sb.toString();
        Log.d("MicroMsg.BizChatInfoStorage", "getByServId sql %s", sb2);
        Cursor rawQuery = rawQuery(sb2, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                cVar = new c();
                cVar.convertFrom(rawQuery);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(124207);
        return cVar;
    }

    public final boolean Am(long j2) {
        AppMethodBeat.i(124208);
        c bs = bs(j2);
        boolean delete = super.delete(bs, "bizChatLocalId");
        if (delete) {
            a.b bVar = new a.b();
            bVar.iPE = bs.field_bizChatLocalId;
            bVar.brandName = bs.field_brandUserName;
            bVar.iPO = a.EnumC0249a.DELETE;
            bVar.iPP = bs;
            this.iNS.event(bVar);
            this.iNS.doNotify();
        }
        AppMethodBeat.o(124208);
        return delete;
    }

    public final boolean a(c cVar) {
        AppMethodBeat.i(124209);
        if (cVar == null) {
            Log.w("MicroMsg.BizChatInfoStorage", "insert wrong argument");
            AppMethodBeat.o(124209);
            return false;
        } else if (Util.isNullOrNil(cVar.field_bizChatServId)) {
            Log.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid null");
            AppMethodBeat.o(124209);
            return false;
        } else {
            c NE = NE(cVar.field_bizChatServId);
            if (NE != null) {
                cVar.field_bizChatLocalId = NE.field_bizChatLocalId;
                Log.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
                AppMethodBeat.o(124209);
                return true;
            }
            cVar.field_bizChatLocalId = baz();
            boolean insert = super.insert(cVar);
            if (insert) {
                a.b bVar = new a.b();
                bVar.iPE = cVar.field_bizChatLocalId;
                bVar.brandName = cVar.field_brandUserName;
                bVar.iPO = a.EnumC0249a.INSTERT;
                bVar.iPP = cVar;
                this.iNS.event(bVar);
                this.iNS.doNotify();
            }
            AppMethodBeat.o(124209);
            return insert;
        }
    }

    public final boolean b(c cVar) {
        boolean z = false;
        AppMethodBeat.i(124210);
        if (cVar == null) {
            Log.w("MicroMsg.BizChatInfoStorage", "update wrong argument");
            AppMethodBeat.o(124210);
        } else if (cVar.field_bizChatLocalId < 0) {
            Log.e("MicroMsg.BizChatInfoStorage", "update bizchat localid neg");
            AppMethodBeat.o(124210);
        } else {
            c bs = bs(cVar.field_bizChatLocalId);
            if (Util.isNullOrNil(bs.field_bizChatServId) || bs.field_bizChatServId.equals(cVar.field_bizChatServId)) {
                if (cVar == null || Util.isNullOrNil(cVar.field_chatName)) {
                    Log.i("MicroMsg.BizChatInfoStorage", "dealWithChatNamePY null");
                } else {
                    cVar.field_chatNamePY = f.Sh(cVar.field_chatName);
                }
                z = super.replace(cVar);
                if (z) {
                    e.g(cVar);
                    a.b bVar = new a.b();
                    bVar.iPE = cVar.field_bizChatLocalId;
                    bVar.brandName = cVar.field_brandUserName;
                    bVar.iPO = a.EnumC0249a.UPDATE;
                    bVar.iPP = cVar;
                    this.iNS.event(bVar);
                    this.iNS.doNotify();
                }
                AppMethodBeat.o(124210);
            } else {
                Log.e("MicroMsg.BizChatInfoStorage", "update bizchat servid nequal");
                AppMethodBeat.o(124210);
            }
        }
        return z;
    }

    private long baz() {
        long incrementAndGet;
        AppMethodBeat.i(124211);
        synchronized (this.iPI) {
            try {
                incrementAndGet = this.iPI.incrementAndGet();
                Log.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d  ", Long.valueOf(incrementAndGet));
            } finally {
                AppMethodBeat.o(124211);
            }
        }
        return incrementAndGet;
    }
}
