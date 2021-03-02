package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class ae extends MAutoStorage<z> {
    public static final String[] INDEX_CREATE = {"CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineSingleMsgInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineSingleMsgInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  create_time_index ON BizTimeLineSingleMsgInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineSingleMsgInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_id_index ON BizTimeLineSingleMsgInfo ( status,talkerId ) ", "CREATE  INDEX IF NOT EXISTS  status_create_time_index ON BizTimeLineSingleMsgInfo ( status,createTime ) ", "CREATE  INDEX IF NOT EXISTS  type_order_flag_index ON BizTimeLineSingleMsgInfo ( type,orderFlag ) "};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(z.info, "BizTimeLineSingleMsgInfo")};
    private final MStorageEvent<aa.c, aa.a> NQt = new MStorageEvent<aa.c, aa.a>() {
        /* class com.tencent.mm.storage.ae.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(aa.c cVar, aa.a aVar) {
            AppMethodBeat.i(124687);
            cVar.a(ae.this, aVar);
            AppMethodBeat.o(124687);
        }
    };
    private final long NRt = -50000000;
    private AtomicLong NRu = new AtomicLong(-50000000);
    public final h iFy;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(z zVar) {
        AppMethodBeat.i(124701);
        boolean B = B(zVar);
        AppMethodBeat.o(124701);
        return B;
    }

    static {
        AppMethodBeat.i(124702);
        AppMethodBeat.o(124702);
    }

    public final void a(aa.a aVar) {
        AppMethodBeat.i(124688);
        if (this.NQt.event(aVar)) {
            this.NQt.doNotify();
        }
        AppMethodBeat.o(124688);
    }

    public final void a(aa.c cVar, Looper looper) {
        AppMethodBeat.i(124689);
        this.NQt.add(cVar, looper);
        AppMethodBeat.o(124689);
    }

    public final void a(aa.c cVar) {
        AppMethodBeat.i(124690);
        this.NQt.remove(cVar);
        AppMethodBeat.o(124690);
    }

    public ae(h hVar) {
        super(hVar, z.info, "BizTimeLineSingleMsgInfo", INDEX_CREATE);
        AppMethodBeat.i(124691);
        this.iFy = hVar;
        AppMethodBeat.o(124691);
    }

    public final boolean B(z zVar) {
        AppMethodBeat.i(124692);
        boolean insertNotify = super.insertNotify(zVar, false);
        aa.a aVar = new aa.a();
        aVar.talker = zVar.field_talker;
        aVar.psm = zVar;
        aVar.NQE = aa.b.INSERT;
        a(aVar);
        AppMethodBeat.o(124692);
        return insertNotify;
    }

    public final boolean C(z zVar) {
        AppMethodBeat.i(124693);
        boolean updateNotify = super.updateNotify(zVar, false, "msgSvrId");
        aa.a aVar = new aa.a();
        aVar.talker = zVar.field_talker;
        aVar.psm = zVar;
        aVar.NQE = aa.b.UPDATE;
        a(aVar);
        AppMethodBeat.o(124693);
        return updateNotify;
    }

    public final z MM(long j2) {
        AppMethodBeat.i(261601);
        z R = R(j2, "msgId");
        AppMethodBeat.o(261601);
        return R;
    }

    public final z R(long j2, String str) {
        AppMethodBeat.i(212370);
        z zVar = new z();
        Cursor query = this.iFy.query("BizTimeLineSingleMsgInfo", null, str + "=?", new String[]{String.valueOf(j2)}, null, null, null, 2);
        if (query.moveToFirst()) {
            zVar.convertFrom(query);
            query.close();
            AppMethodBeat.o(212370);
            return zVar;
        }
        query.close();
        AppMethodBeat.o(212370);
        return null;
    }

    public static List<z> o(Cursor cursor) {
        AppMethodBeat.i(124694);
        LinkedList linkedList = new LinkedList();
        while (cursor.moveToNext()) {
            z zVar = new z();
            zVar.convertFrom(cursor);
            linkedList.add(zVar);
        }
        cursor.close();
        AppMethodBeat.o(124694);
        return linkedList;
    }

    public final z gAM() {
        z zVar = null;
        AppMethodBeat.i(124695);
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM BizTimeLineSingleMsgInfo order by createTime DESC limit 1", null);
        if (rawQuery.moveToFirst()) {
            zVar = new z();
            zVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(124695);
        return zVar;
    }

    public final z gBn() {
        z zVar = null;
        AppMethodBeat.i(124696);
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM BizTimeLineSingleMsgInfo where status != 4 order by createTime DESC limit 1", null);
        if (rawQuery.moveToFirst()) {
            zVar = new z();
            zVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(124696);
        return zVar;
    }

    public final int ctM() {
        int i2 = 0;
        AppMethodBeat.i(124697);
        Cursor rawQuery = this.iFy.rawQuery("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4", null);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(124697);
        return i2;
    }

    public final int Ne(long j2) {
        int i2 = 0;
        AppMethodBeat.i(124698);
        Cursor rawQuery = this.iFy.rawQuery("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4 and talkerId = " + j2 + " ", null);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(124698);
        return i2;
    }

    public final boolean aEn(String str) {
        AppMethodBeat.i(124699);
        z zVar = new z();
        zVar.field_talker = str;
        boolean delete = super.delete(zVar, false, "talker");
        aa.a aVar = new aa.a();
        aVar.talker = zVar.field_talker;
        aVar.psm = zVar;
        aVar.NQE = aa.b.DELETE;
        a(aVar);
        AppMethodBeat.o(124699);
        return delete;
    }

    public final void MX(long j2) {
        AppMethodBeat.i(124700);
        z zVar = new z();
        zVar.field_msgId = j2;
        super.delete(zVar, false, "msgId");
        aa.a aVar = new aa.a();
        aVar.NQE = aa.b.DELETE;
        a(aVar);
        AppMethodBeat.o(124700);
    }

    public final synchronized long gBo() {
        long incrementAndGet;
        z zVar = null;
        synchronized (this) {
            AppMethodBeat.i(212371);
            if (this.NRu.longValue() == -50000000) {
                Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM BizTimeLineSingleMsgInfo where type=10100 or type=318767153 order by createTime DESC limit 1", null);
                if (rawQuery.moveToFirst()) {
                    zVar = new z();
                    zVar.convertFrom(rawQuery);
                }
                rawQuery.close();
                if (zVar != null) {
                    this.NRu.set(zVar.field_msgId);
                }
            }
            incrementAndGet = this.NRu.incrementAndGet();
            AppMethodBeat.o(212371);
        }
        return incrementAndGet;
    }
}
