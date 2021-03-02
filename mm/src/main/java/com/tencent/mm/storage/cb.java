package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import junit.framework.Assert;

public final class cb extends MStorage implements i {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS " + "message" + " ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status" + " INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker" + " TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer" + " BLOB, transContent TEXT,transBrandWording TEXT ,talkerId INTEGER, bizClientMsgId" + " TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT, msgSeq INTEGER, flag" + " INT, solitaireFoldInfo BLOB, historyId TEXT) "};
    private final MStorageEvent<i.a, i.c> NQt = new MStorageEvent<i.a, i.c>() {
        /* class com.tencent.mm.storage.cb.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(i.a aVar, i.c cVar) {
            AppMethodBeat.i(117188);
            aVar.a(cb.this, cVar);
            AppMethodBeat.o(117188);
        }

        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final void handleNotify(List<i.c> list) {
            AppMethodBeat.i(117187);
            if (!isLocked() && cb.this.oQy != null) {
                for (i.c cVar : list) {
                    if (cVar != null) {
                        cb.this.oQy.b(cb.this, cVar);
                    }
                }
            }
            AppMethodBeat.o(117187);
        }
    };
    private boolean Orf = false;
    private final List<e> Org = new CopyOnWriteArrayList();
    private List<i.b> Orh;
    private final f<Integer, ca.c> Ori = new c(100);
    private final f<Integer, ca.d> Orj = new c(100);
    private final f<Integer, ca.a> Ork = new c(100);
    private final f<Integer, ca.b> Orl = new c(100);
    private final f<Integer, Object> Orm = new c(100);
    private final f<String, Long> Orn = new c(100);
    private bc Oro = new bc();
    private final Map<String, i.c> Orp = new HashMap();
    private boolean Orq = false;
    private String Orr = "";
    private long Ors = 0;
    private final long SECONDS_OF_DAY = 86400;
    private final h iFy;
    private bv oQw;
    private bw oQy;

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void a(e eVar) {
        AppMethodBeat.i(117189);
        if (!this.Org.contains(eVar)) {
            Log.i("MicroMsg.MsgInfoStorage", "addMessageStorageImpl %s", eVar);
            this.Org.add(eVar);
        }
        AppMethodBeat.o(117189);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final h getDB() {
        return this.iFy;
    }

    static {
        AppMethodBeat.i(117320);
        AppMethodBeat.o(117320);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void a(i.c cVar) {
        AppMethodBeat.i(117190);
        if (this.NQt.event(cVar)) {
            this.NQt.doNotify();
        }
        AppMethodBeat.o(117190);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void a(i.a aVar, Looper looper) {
        AppMethodBeat.i(117191);
        this.NQt.add(aVar, looper);
        AppMethodBeat.o(117191);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void a(i.a aVar) {
        AppMethodBeat.i(117192);
        this.NQt.remove(aVar);
        AppMethodBeat.o(117192);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public final void lock() {
        AppMethodBeat.i(117193);
        Assert.assertTrue("lock deprecated, use lockForSync instead.", false);
        AppMethodBeat.o(117193);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public final void unlock() {
        AppMethodBeat.i(117194);
        Assert.assertTrue("unlock deprecated, use lockForSync instead.", false);
        AppMethodBeat.o(117194);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void aEs(String str) {
        AppMethodBeat.i(117195);
        Log.i("MicroMsg.MsgInfoStorage", "lockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.Orq), Integer.valueOf(super.lockCount()), Integer.valueOf(this.NQt.lockCount()), Integer.valueOf(this.Orp.size()), this.Orr, Long.valueOf(Util.milliSecondsToNow(this.Ors)));
        if (Util.isNullOrNil(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (this.Orq) {
            Log.w("MicroMsg.MsgInfoStorage", "lockForSync, has been locked by :%s  time:%d", this.Orr, Long.valueOf(Util.milliSecondsToNow(this.Ors)));
            AppMethodBeat.o(117195);
            return;
        }
        this.Orr = str;
        this.Ors = Util.nowMilliSecond();
        this.Orq = true;
        super.lock();
        this.NQt.lock();
        AppMethodBeat.o(117195);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void aEt(String str) {
        AppMethodBeat.i(117196);
        Log.i("MicroMsg.MsgInfoStorage", "unlockForSync tag:%s islock:%b lockCnt[%d,%d] notifyCnt:%d last:[%s,%d]", str, Boolean.valueOf(this.Orq), Integer.valueOf(super.lockCount()), Integer.valueOf(this.NQt.lockCount()), Integer.valueOf(this.Orp.size()), this.Orr, Long.valueOf(Util.milliSecondsToNow(this.Ors)));
        if (Util.isNullOrNil(str)) {
            Assert.assertTrue("lockForSync, do not call me by null tag.", false);
        }
        if (!this.Orq) {
            Log.w("MicroMsg.MsgInfoStorage", "unlockForSync, No one Locking Now , why this fucking tag:%s call it ! [%s]", str, Util.getStack());
            AppMethodBeat.o(117196);
        } else if (!str.equals(this.Orr)) {
            Log.w("MicroMsg.MsgInfoStorage", "unlockForSync locking[%s] diff:%d, but unlock[%s] , Ignore this call.", this.Orr, Long.valueOf(Util.milliSecondsToNow(this.Ors)), str);
            AppMethodBeat.o(117196);
        } else {
            this.Orq = false;
            this.Ors = 0;
            this.Orr = "";
            synchronized (this.Orp) {
                try {
                    for (String str2 : this.Orp.keySet()) {
                        a(this.Orp.get(str2));
                    }
                    this.Orp.clear();
                } catch (Throwable th) {
                    AppMethodBeat.o(117196);
                    throw th;
                }
            }
            super.unlock();
            this.NQt.unlock();
            doNotify();
            AppMethodBeat.o(117196);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void aEu(String str) {
        AppMethodBeat.i(117197);
        if (!this.Orq) {
            AppMethodBeat.o(117197);
            return;
        }
        i.c cVar = null;
        synchronized (this.Orp) {
            try {
                if (this.Orp.containsKey(str)) {
                    cVar = this.Orp.get(str);
                }
            } finally {
                AppMethodBeat.o(117197);
            }
        }
        if (cVar == null) {
            Log.w("MicroMsg.MsgInfoStorage", "statusNotify, No one Locking info Now , why this fucking talker:%s call it ! [%s]", str, Util.getStack());
            AppMethodBeat.o(117197);
            return;
        }
        if (cVar.zqn != null && cVar.zqn.equals("insert") && cVar.tYD > 0) {
            Log.i("MicroMsg.MsgInfoStorage", "statusNotify talker[%s] insertCount[%d]", str, Integer.valueOf(cVar.tYD));
            cVar.tYD = 0;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void e(h hVar, String str) {
        AppMethodBeat.i(117198);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        Cursor rawQuery = hVar.rawQuery("PRAGMA table_info( " + str + " )", null, 2);
        int columnIndex = rawQuery.getColumnIndex("name");
        while (rawQuery.moveToNext()) {
            if (columnIndex >= 0) {
                String string = rawQuery.getString(columnIndex);
                if ("lvbuffer".equalsIgnoreCase(string)) {
                    z = true;
                } else if ("transContent".equalsIgnoreCase(string)) {
                    z2 = true;
                } else if ("transBrandWording".equalsIgnoreCase(string)) {
                    z3 = true;
                } else if ("talkerId".equalsIgnoreCase(string)) {
                    z4 = true;
                } else if ("bizClientMsgId".equalsIgnoreCase(string)) {
                    z5 = true;
                } else if ("bizChatId".equalsIgnoreCase(string)) {
                    z6 = true;
                } else if ("bizChatUserId".equalsIgnoreCase(string)) {
                    z7 = true;
                } else if ("msgSeq".equalsIgnoreCase(string)) {
                    z8 = true;
                } else if ("flag".equalsIgnoreCase(string)) {
                    z9 = true;
                } else if ("solitaireFoldInfo".equalsIgnoreCase(string)) {
                    z10 = true;
                } else if ("historyId".equalsIgnoreCase(string)) {
                    z11 = true;
                }
            }
        }
        rawQuery.close();
        long beginTransaction = hVar.beginTransaction(Thread.currentThread().getId());
        if (!z) {
            hVar.execSQL(str, "Alter table " + str + " add lvbuffer BLOB ");
        }
        if (!z2) {
            hVar.execSQL(str, "Alter table " + str + " add transContent TEXT ");
        }
        if (!z3) {
            hVar.execSQL(str, "Alter table " + str + " add transBrandWording TEXT ");
        }
        if (!z4) {
            hVar.execSQL(str, "Alter table " + str + " add talkerId INTEGER ");
        }
        if (!z5) {
            hVar.execSQL(str, "Alter table " + str + " add bizClientMsgId TEXT ");
        }
        if (!z6) {
            hVar.execSQL(str, "Alter table " + str + " add bizChatId INTEGER DEFAULT -1");
        }
        if (!z7) {
            hVar.execSQL(str, "Alter table " + str + " add bizChatUserId TEXT ");
        }
        if (!z8) {
            hVar.execSQL(str, "Alter table " + str + " add msgSeq INTEGER ");
        }
        if (!z9) {
            hVar.execSQL(str, "Alter table " + str + " add flag INT DEFAULT 0 ");
        }
        if (!z10) {
            hVar.execSQL(str, "Alter table " + str + " add solitaireFoldInfo BLOB ");
        }
        if (!z11) {
            hVar.execSQL(str, "Alter table " + str + " add historyId TEXT ");
        }
        hVar.endTransaction(beginTransaction);
        AppMethodBeat.o(117198);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void aI(String str, long j2) {
        AppMethodBeat.i(117199);
        i.b bkK = bkK(str);
        long j3 = bkK.iXv;
        Random random = new Random();
        this.iFy.execSQL("message", "BEGIN;");
        ca caVar = new ca(str);
        for (int i2 = 0; ((long) i2) < j2; i2++) {
            caVar.setCreateTime(System.currentTimeMillis());
            caVar.setType(1);
            caVar.setContent("纵观目前国内手游市场，大量同质类手游充斥玩家的视野，而在主机和PC平台上经久不衰的体育类游戏，却鲜有佳作。在获得了NBA官方认可以后。" + Util.random());
            caVar.setMsgId(j3);
            caVar.setStatus(random.nextInt(4));
            caVar.nv(random.nextInt(1));
            j3++;
            bkK.iXv++;
            caVar.yF(System.currentTimeMillis() + ((long) Util.random()));
            this.iFy.execSQL("message", "INSERT INTO " + aEO(caVar.field_talker) + " (msgid,msgSvrid,type,status,createTime,talker,content,talkerid)  VALUES(" + caVar.field_msgId + "," + caVar.field_msgSvrId + "," + caVar.getType() + "," + caVar.field_status + "," + caVar.field_createTime + ",'" + caVar.field_talker + "','" + caVar.field_content + "'," + bkF(str) + ");");
            if (i2 % 10000 == 0) {
                this.iFy.execSQL("message", "COMMIT;");
                this.iFy.execSQL("message", "BEGIN;");
            }
        }
        this.iFy.execSQL("message", "COMMIT;");
        this.oQy.bjZ(str);
        caVar.setMsgId(1 + j3);
        c(caVar, false);
        AppMethodBeat.o(117199);
    }

    private void gEe() {
        AppMethodBeat.i(117200);
        long currentTimeMillis = System.currentTimeMillis();
        long beginTransaction = this.iFy.beginTransaction(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"CREATE INDEX IF NOT EXISTS " + "message" + "IdIndex ON message ( msgId )", "CREATE INDEX IF NOT EXISTS " + "message" + "SvrIdIndex ON message ( msgSvrId )", "CREATE INDEX IF NOT EXISTS " + "message" + "SendCreateTimeIndex ON message ( status,isSend,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + "message" + "CreateTimeIndex ON message ( createTime )", "CREATE INDEX IF NOT EXISTS " + "message" + "TaklerIdTypeCreateTimeIndex ON message ( talkerId,type,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdStatusIndex ON message ( talkerId,status )", "CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdCreateTimeIsSendIndex ON message ( talkerId,isSend,createTime" + " )", "CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdCreateTimeIndex ON message ( talkerId,createTime )", "CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdSvrIdIndex ON message ( talkerId,msgSvrId )", "CREATE INDEX IF NOT EXISTS " + "message" + "TalkerIdTypeIndex ON message ( talkerId,type )", "CREATE INDEX IF NOT EXISTS " + "message" + "TalkerTypeIndex ON message ( talker,type )", "CREATE INDEX IF NOT EXISTS " + "message" + "messageTalkerMsgSeqIndex ON message ( talker,msgSeq )", "CREATE INDEX IF NOT EXISTS " + "message" + "messageTalkerFlagMsgSeqIndex ON message ( talker,flag,msgSeq" + " )"};
        if (!this.Orf) {
            strArr[4] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTypeTimeIndex ON message ( talker,type,createTime )";
            strArr[5] = "CREATE INDEX IF NOT EXISTS  messageTalkerStatusIndex ON message ( talker,status )";
            strArr[6] = "CREATE INDEX IF NOT EXISTS  messageTalkerCreateTimeIsSendIndex ON message ( talker,isSend,createTime )";
            strArr[7] = "CREATE INDEX IF NOT EXISTS  messageCreateTaklerTimeIndex ON message ( talker,createTime )";
            strArr[8] = "CREATE INDEX IF NOT EXISTS  messageTalkerSvrIdIndex ON message ( talker,msgSvrId )";
        }
        arrayList.addAll(Arrays.asList(strArr));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            this.iFy.execSQL("message", (String) arrayList.get(i2));
        }
        Log.i("MicroMsg.MsgInfoStorage", "build new index last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        this.iFy.endTransaction(beginTransaction);
        Log.i("MicroMsg.MsgInfoStorage", "executeMsgInitSQL last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(117200);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void eiH() {
        AppMethodBeat.i(117201);
        z.aUN();
        AppMethodBeat.o(117201);
    }

    public cb(h hVar, bv bvVar, bw bwVar) {
        AppMethodBeat.i(117202);
        this.iFy = hVar;
        this.oQw = bvVar;
        this.oQy = bwVar;
        if (z.aUP() == 0) {
            Log.i("MicroMsg.MsgInfoStorage", "deleted dirty msg ,count is %d", Integer.valueOf(this.iFy.delete("message", "msgId> ? ", new String[]{"80000000"})));
            z.aUO();
        }
        e(hVar, "message");
        gEe();
        if (this.Orh == null) {
            this.Orh = new LinkedList();
        }
        this.Orh.clear();
        a(new i.b(1, "message", i.b.a(1, TimeUtil.SECOND_TO_US, 10000000, 90000000)));
        AppMethodBeat.o(117202);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void a(i.b bVar) {
        AppMethodBeat.i(117203);
        synchronized (this.Orh) {
            try {
                this.Orh.add(bVar);
            } catch (Throwable th) {
                AppMethodBeat.o(117203);
                throw th;
            }
        }
        b(bVar);
        AppMethodBeat.o(117203);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void eiI() {
        AppMethodBeat.i(117204);
        for (int i2 = 0; i2 < this.Orh.size(); i2++) {
            b(this.Orh.get(i2));
        }
        AppMethodBeat.o(117204);
    }

    private void b(i.b bVar) {
        AppMethodBeat.i(117205);
        Cursor rawQuery = this.iFy.rawQuery("select max(msgid) from " + bVar.name, null, 2);
        if (rawQuery.moveToFirst()) {
            int i2 = rawQuery.getInt(0);
            Log.i("MicroMsg.MsgInfoStorage", "id count is %d, now id:%d tableName: %s", Integer.valueOf(i2), Long.valueOf(bVar.iXv), bVar.name);
            if (((long) i2) >= bVar.iXv) {
                bVar.Qq(i2);
            }
        }
        rawQuery.close();
        Log.w("MicroMsg.MsgInfoStorage", "loading new msg id:" + bVar.iXv);
        AppMethodBeat.o(117205);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void eiJ() {
        int i2;
        AppMethodBeat.i(117206);
        if (!this.Orf) {
            AppMethodBeat.o(117206);
            return;
        }
        Cursor rawQuery = this.iFy.rawQuery("select count(*) from " + "message" + " where talkerId ISNULL ", null, 2);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            } else {
                i2 = 0;
            }
            rawQuery.close();
            if (i2 > 0) {
                Log.i("MicroMsg.MsgInfoStorage", " msg table exists null talkerid ,start translate tableName %s ", "message");
                long currentTimeMillis = System.currentTimeMillis();
                boolean execSQL = this.iFy.execSQL("message", "update " + "message" + " set talkerId=(select rowid from rcontact where rcontact.username" + " = " + "message" + ".talker)");
                Log.i("MicroMsg.MsgInfoStorage", "update result :%b last %d", Boolean.valueOf(execSQL), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (execSQL && this.Orf) {
                    this.iFy.execSQL("message", "DROP INDEX messageCreateTaklerTypeTimeIndex IF EXISTS");
                    this.iFy.execSQL("message", "DROP INDEX messageTalkerStatusIndex IF EXISTS");
                    this.iFy.execSQL("message", "DROP INDEX messageTalkerCreateTimeIsSendIndex IF EXISTS");
                    this.iFy.execSQL("message", "DROP INDEX messageCreateTaklerTimeIndex IF EXISTS");
                    this.iFy.execSQL("message", "DROP INDEX messageTalkerSvrIdIndex IF EXISTS");
                    Log.i("MicroMsg.MsgInfoStorage", "clear talker Name index");
                }
            }
        }
        AppMethodBeat.o(117206);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca Hb(long j2) {
        AppMethodBeat.i(117207);
        ca caVar = new ca();
        Cursor query = this.iFy.query(Nk(j2), null, "msgId=?", new String[]{String.valueOf(j2)}, null, null, null, 2);
        if (query.moveToFirst()) {
            caVar.convertFrom(query);
        }
        query.close();
        AppMethodBeat.o(117207);
        return caVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca aJ(String str, long j2) {
        AppMethodBeat.i(117208);
        ca caVar = new ca();
        Cursor query = this.iFy.query(aEO(str), null, "msgSvrId=?", new String[]{String.valueOf(j2)}, null, null, null, 2);
        if (query.moveToFirst()) {
            caVar.convertFrom(query);
        }
        query.close();
        AppMethodBeat.o(117208);
        return caVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca aK(String str, long j2) {
        AppMethodBeat.i(117209);
        ca caVar = new ca();
        Cursor query = this.iFy.query(aEO(str), null, bkE(str) + " AND msgSeq=?", new String[]{String.valueOf(j2)}, null, null, null, 2);
        if (query.moveToFirst()) {
            caVar.convertFrom(query);
        }
        query.close();
        AppMethodBeat.o(117209);
        return caVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca aL(String str, long j2) {
        AppMethodBeat.i(117210);
        ca caVar = new ca();
        Cursor query = this.iFy.query(aEO(str), null, "createTime=? AND" + bkE(str), new String[]{String.valueOf(j2)}, null, null, null, 2);
        if (query.moveToFirst()) {
            caVar.convertFrom(query);
        }
        query.close();
        AppMethodBeat.o(117210);
        return caVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor aEv(String str) {
        AppMethodBeat.i(117211);
        Cursor query = this.iFy.query(aEO(str), new String[]{"createTime", "msgId"}, biM(str) + bkE(str), null, "createTime", null, "createTime ASC");
        AppMethodBeat.o(117211);
        return query;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final List<ca> f(String str, long j2, int i2) {
        AppMethodBeat.i(187517);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.iFy.rawQuery("Select * From " + aEO(str) + " Where " + bkE(str) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit " + i2, new String[]{String.valueOf(j2)}, 2);
        while (rawQuery.moveToNext()) {
            ca caVar = new ca();
            caVar.convertFrom(rawQuery);
            arrayList.add(caVar);
        }
        rawQuery.close();
        AppMethodBeat.o(187517);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final List<ca> g(String str, long j2, int i2) {
        AppMethodBeat.i(187518);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.iFy.rawQuery("Select * From " + aEO(str) + " Where " + bkE(str) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit " + i2 + ";", new String[]{String.valueOf(j2)}, 2);
        while (rawQuery.moveToNext()) {
            ca caVar = new ca();
            caVar.convertFrom(rawQuery);
            arrayList.add(caVar);
        }
        rawQuery.close();
        AppMethodBeat.o(187518);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca aM(String str, long j2) {
        AppMethodBeat.i(117214);
        ca caVar = new ca();
        Cursor rawQuery = this.iFy.rawQuery("Select * From " + aEO(str) + " Where " + bkE(str) + " AND createTime < ? and not ( type = 10000 and isSend != 2 )  Order By createTime Desc Limit 1;", new String[]{String.valueOf(j2)}, 2);
        if (rawQuery.moveToFirst()) {
            caVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(117214);
        return caVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca aN(String str, long j2) {
        AppMethodBeat.i(117215);
        ca caVar = new ca();
        Cursor rawQuery = this.iFy.rawQuery("Select * From " + aEO(str) + " Where " + bkE(str) + " AND createTime > ? and not ( type = 10000 and isSend != 2 )  Order By createTime ASC Limit 1;", new String[]{String.valueOf(j2)}, 2);
        if (rawQuery.moveToFirst()) {
            caVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(117215);
        return caVar;
    }

    private String bkE(String str) {
        AppMethodBeat.i(117216);
        String aEO = aEO(str);
        if (!this.Orf || !aEO.equals("message")) {
            String str2 = " talker= '" + Util.escapeSqlValue(str) + "' ";
            AppMethodBeat.o(117216);
            return str2;
        }
        String str3 = " talkerId=" + bkF(str) + " ";
        AppMethodBeat.o(117216);
        return str3;
    }

    private long bkF(String str) {
        AppMethodBeat.i(117217);
        long bjM = this.oQw.bjM(str);
        boolean z = bjM < 0;
        if (z && !ab.IN(str) && !ab.IO(str)) {
            as asVar = new as(str);
            asVar.setType(2);
            this.oQw.ap(asVar);
            bjM = this.oQw.bjM(str);
        }
        if (!CrashReportFactory.isBackupMerge()) {
            Log.i("MicroMsg.MsgInfoStorage", "getTalkerIdByTalkerName:%s id:%s needinsert:%s [%s]", str, Long.valueOf(bjM), Boolean.valueOf(z), "");
        }
        AppMethodBeat.o(117217);
        return bjM;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ArrayList<ca> eiK() {
        boolean z;
        AppMethodBeat.i(117218);
        ArrayList<ca> arrayList = new ArrayList<>();
        Cursor query = this.iFy.query("message", null, "createTime>=? AND status=? AND isSend=?", new String[]{String.valueOf(System.currentTimeMillis() - 172800000), "5", "1"}, null, null, "createTime ASC", 2);
        while (query.moveToNext()) {
            ca caVar = new ca();
            caVar.convertFrom(query);
            if (!caVar.isOmittedFailResend()) {
                z = true;
            } else {
                z = false;
            }
            if ((z && true) && !as.bjm(caVar.field_talker) && !as.bjo(caVar.field_talker) && !as.IG(caVar.field_talker)) {
                arrayList.add(caVar);
            }
        }
        query.close();
        AppMethodBeat.o(117218);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void ay(ArrayList<Long> arrayList) {
        AppMethodBeat.i(117219);
        long beginTransaction = this.iFy.beginTransaction(-1);
        try {
            Iterator<Long> it = arrayList.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                ca Hb = Hb(longValue);
                Hb.nc(Hb.fqJ | 32);
                Log.d("MicroMsg.MsgInfoStorage", "msgId:%d, setOmitFailResend", Long.valueOf(longValue));
                a(longValue, Hb);
            }
        } finally {
            this.iFy.endTransaction(beginTransaction);
            AppMethodBeat.o(117219);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final boolean aO(String str, long j2) {
        AppMethodBeat.i(117220);
        if (aL(str, j2).field_msgId > 0) {
            AppMethodBeat.o(117220);
            return true;
        }
        AppMethodBeat.o(117220);
        return false;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int h(String str, long j2, int i2) {
        AppMethodBeat.i(117221);
        String str2 = "SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + "AND createTime < " + j2 + " ORDER BY createTime ASC LIMIT -1 OFFSET " + i2;
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        int count = rawQuery.getCount();
        rawQuery.close();
        Log.d("MicroMsg.MsgInfoStorage", "getPositionByCreateTime talk:" + str + " time:" + j2 + " count " + count + " [" + str2 + "]");
        AppMethodBeat.o(117221);
        return count;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca aEw(String str) {
        AppMethodBeat.i(117222);
        ca caVar = new ca();
        Cursor query = this.iFy.query(aEO(str), null, bkE(str), null, null, null, "msgSvrId  DESC limit 1 ", 2);
        if (query.moveToFirst()) {
            caVar.convertFrom(query);
        }
        query.close();
        AppMethodBeat.o(117222);
        return caVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca aEx(String str) {
        AppMethodBeat.i(117223);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(117223);
            return null;
        }
        ca caVar = new ca();
        Cursor rawQuery = this.iFy.rawQuery("select * from " + aEO(str) + " where" + biM(str) + bkE(str) + "order by createTime DESC limit 1", null, 2);
        if (rawQuery.moveToFirst()) {
            caVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(117223);
        return caVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca aEy(String str) {
        AppMethodBeat.i(187519);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(187519);
            return null;
        }
        ca caVar = new ca();
        Cursor rawQuery = this.iFy.rawQuery("select * from " + aEO(str) + " where" + biM(str) + bkE(str) + "order by createTime ASC limit 1", null, 2);
        if (rawQuery.moveToFirst()) {
            caVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(187519);
        return caVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca aP(String str, long j2) {
        AppMethodBeat.i(117224);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(117224);
            return null;
        }
        ca caVar = new ca();
        String str2 = "select * from " + aEO(str) + " where" + bkE(str) + "AND msgSeq<" + j2 + " order by msgSeq DESC limit 1";
        Cursor rawQuery = this.iFy.rawQuery(str2, null, 2);
        if (rawQuery.moveToFirst()) {
            caVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        Log.d("MicroMsg.MsgInfoStorage", "[getBeforeSeqLastMsg] sql: ".concat(String.valueOf(str2)));
        AppMethodBeat.o(117224);
        return caVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca iG(String str, String str2) {
        AppMethodBeat.i(117225);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.MsgInfoStorage", "getLastMsg failed : talker:%s", str);
            AppMethodBeat.o(117225);
            return null;
        }
        ca caVar = new ca();
        Cursor rawQuery = this.iFy.rawQuery("select * from " + aEO(str) + " where" + bkE(str) + str2 + " order by createTime DESC limit 1", null, 2);
        if (rawQuery.moveToFirst()) {
            caVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        Log.i("MicroMsg.MsgInfoStorage", "getLastMsg talker:%s msgid:%d", str, Long.valueOf(caVar.field_msgId));
        AppMethodBeat.o(117225);
        return caVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca aEz(String str) {
        AppMethodBeat.i(117226);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(117226);
            return null;
        }
        ca caVar = new ca();
        Cursor rawQuery = this.iFy.rawQuery("select * from " + aEO(str) + " where" + bkE(str) + "and isSend = 0  order by createTime DESC limit 1", null, 2);
        if (rawQuery.moveToFirst()) {
            caVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(117226);
        return caVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void aVO() {
        AppMethodBeat.i(117227);
        Cursor rawQuery = this.iFy.rawQuery("select * from MsgInfo wherecontent like '%aaaabbbbbfdf%'", null, 2);
        rawQuery.getCount();
        SystemClock.sleep(5000);
        rawQuery.close();
        AppMethodBeat.o(117227);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final List<ca> ew(String str, int i2) {
        AppMethodBeat.i(117228);
        ArrayList arrayList = new ArrayList();
        Assert.assertTrue(this.Orh != null);
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + "AND status = 3 AND type <> 10000" + " ORDER BY createTime DESC LIMIT " + i2, null, 2);
        while (rawQuery.moveToNext()) {
            ca caVar = new ca();
            caVar.convertFrom(rawQuery);
            arrayList.add(caVar);
        }
        rawQuery.close();
        AppMethodBeat.o(117228);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca Qo(int i2) {
        AppMethodBeat.i(117229);
        if (this.Orh == null) {
            Log.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            AppMethodBeat.o(117229);
            return null;
        }
        ca caVar = new ca();
        long j2 = 0;
        for (int i3 = 0; i3 < this.Orh.size(); i3++) {
            if ((this.Orh.get(i3).zqk & i2) != 0) {
                Cursor rawQuery = this.iFy.rawQuery("select * from " + this.Orh.get(i3).name + "  order by createTime DESC limit 1", null, 2);
                if (rawQuery.moveToFirst()) {
                    long j3 = rawQuery.getLong(rawQuery.getColumnIndex("createTime"));
                    if (j2 < j3) {
                        caVar.convertFrom(rawQuery);
                        j2 = j3;
                    }
                }
                rawQuery.close();
            }
        }
        AppMethodBeat.o(117229);
        return caVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca aEA(String str) {
        String replaceFirst;
        AppMethodBeat.i(117230);
        if (this.Orh == null) {
            Log.e("MicroMsg.MsgInfoStorage", "getLastMsg failed lstTable is null");
            AppMethodBeat.o(117230);
            return null;
        }
        ca caVar = new ca();
        long j2 = 0;
        if (Util.isNullOrNil(str)) {
            replaceFirst = "";
        } else {
            replaceFirst = str.replaceFirst("and", "where");
        }
        for (int i2 = 0; i2 < this.Orh.size(); i2++) {
            if ((this.Orh.get(i2).zqk & 8) != 0) {
                Cursor rawQuery = this.iFy.rawQuery("select * from " + this.Orh.get(i2).name + replaceFirst + "  order by createTime DESC limit 1", null, 2);
                if (rawQuery.moveToFirst()) {
                    long j3 = rawQuery.getLong(rawQuery.getColumnIndex("createTime"));
                    if (j2 < j3) {
                        caVar.convertFrom(rawQuery);
                        j2 = j3;
                    }
                }
                rawQuery.close();
            }
        }
        AppMethodBeat.o(117230);
        return caVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final List<ca> eiL() {
        AppMethodBeat.i(117231);
        List<ca> Qp = Qp(Integer.MAX_VALUE);
        AppMethodBeat.o(117231);
        return Qp;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final List<ca> Qp(int i2) {
        AppMethodBeat.i(187520);
        List<i.b> linkedList = new LinkedList<>();
        for (int i3 = 0; i3 < this.Orh.size(); i3++) {
            String str = this.Orh.get(i3).name;
            if (!str.startsWith("findermessage") && !str.equalsIgnoreCase("gamelifemessage")) {
                linkedList.add(this.Orh.get(i3));
            }
        }
        List<ca> w = w(i2, linkedList);
        AppMethodBeat.o(187520);
        return w;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final List<ca> fw(List<String> list) {
        AppMethodBeat.i(187521);
        List<i.b> linkedList = new LinkedList<>();
        for (int i2 = 0; i2 < this.Orh.size(); i2++) {
            if (list.contains(this.Orh.get(i2).name)) {
                linkedList.add(this.Orh.get(i2));
            }
        }
        List<ca> w = w(Integer.MAX_VALUE, linkedList);
        AppMethodBeat.o(187521);
        return w;
    }

    private List<ca> w(int i2, List<i.b> list) {
        List list2;
        AppMethodBeat.i(187522);
        ArrayList arrayList = new ArrayList();
        ArrayList<ca> arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            Cursor query = this.iFy.query(list.get(i3).name, null, "status=1 and isSend=1 and type IN (1,11,21,31,36,42,66,48," + "55,57)", null, null, null, "createTime", 100);
            while (query.moveToNext()) {
                ca caVar = new ca();
                caVar.convertFrom(query);
                if (bp.aVP() - caVar.field_createTime > Util.MILLSECONDS_OF_DAY) {
                    arrayList2.add(caVar);
                } else {
                    arrayList.add(caVar);
                }
            }
            query.close();
        }
        if (arrayList.size() > i2) {
            list2 = arrayList.subList(0, i2);
        } else {
            list2 = arrayList;
        }
        Log.i("MicroMsg.MsgInfoStorage", "getLastSendingMsgList limit:%s listMsg:%s lstTimeoutMsg:%s limitListMsg:%s", Integer.valueOf(i2), Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(list2.size()));
        if (arrayList2.size() > 0) {
            long beginTransaction = this.iFy.beginTransaction(-1);
            for (ca caVar2 : arrayList2) {
                Log.i("MicroMsg.MsgInfoStorage", "Set msg timtout : id:%d time:%d time:%s talker:%s content:%s", Long.valueOf(caVar2.field_msgId), Long.valueOf(caVar2.field_createTime), Integer.valueOf(caVar2.getType()), caVar2.field_talker, Util.secPrint(caVar2.field_content));
                caVar2.setStatus(5);
                a(caVar2.field_msgId, caVar2);
            }
            this.iFy.endTransaction(beginTransaction);
        }
        AppMethodBeat.o(187522);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final List<ca> ex(String str, int i2) {
        AppMethodBeat.i(117232);
        ArrayList arrayList = new ArrayList();
        Assert.assertTrue(this.Orh != null);
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + i2, null, 2);
        while (rawQuery.moveToNext()) {
            ca caVar = new ca();
            caVar.convertFrom(rawQuery);
            if (caVar.isText() || caVar.gDx() || caVar.gDy()) {
                arrayList.add(caVar);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(117232);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final List<ca> ey(String str, int i2) {
        AppMethodBeat.i(187523);
        ArrayList arrayList = new ArrayList();
        Assert.assertTrue(this.Orh != null);
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + " ORDER BY createTime DESC LIMIT " + i2, null, 2);
        while (rawQuery.moveToNext()) {
            ca caVar = new ca();
            caVar.convertFrom(rawQuery);
            arrayList.add(caVar);
        }
        rawQuery.close();
        AppMethodBeat.o(187523);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final List<ca> k(String str, ArrayList<Long> arrayList) {
        AppMethodBeat.i(187524);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Long> it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append(",");
        }
        ArrayList arrayList2 = new ArrayList();
        String str2 = "SELECT * FROM " + aEO(str) + " WHERE msgId IN (" + stringBuffer.substring(0, stringBuffer.length() - 1) + ") ORDER BY createTime DESC ";
        Log.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", str2);
        Cursor rawQuery = this.iFy.rawQuery(str2, null, 2);
        while (rawQuery.moveToNext()) {
            ca caVar = new ca();
            caVar.convertFrom(rawQuery);
            if (caVar.dOQ()) {
                arrayList2.add(caVar);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(187524);
        return arrayList2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final List<ca> as(String str, int i2, int i3) {
        AppMethodBeat.i(117233);
        ArrayList arrayList = new ArrayList();
        String str2 = "SELECT * FROM " + aEO(str) + " WHERE " + gEf() + " ORDER BY createTime DESC LIMIT " + i2 + " , " + i3;
        Log.d("MicroMsg.MsgInfoStorage", "getAppMsgTypeList sql=%s", str2);
        Cursor rawQuery = this.iFy.rawQuery(str2, null, 2);
        while (rawQuery.moveToNext()) {
            ca caVar = new ca();
            caVar.convertFrom(rawQuery);
            if (caVar.dOQ()) {
                arrayList.add(caVar);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(117233);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int aB(ca caVar) {
        int i2 = 0;
        AppMethodBeat.i(117234);
        if (caVar == null || Util.isNullOrNil(caVar.field_talker)) {
            AppMethodBeat.o(117234);
        } else {
            Cursor rawQuery = this.iFy.rawQuery("SELECT count(msgId) FROM " + aEO(caVar.field_talker) + " WHERE" + bkE(caVar.field_talker) + "AND isSend = 0 AND msgId >= " + caVar.field_msgId + " ORDER BY createTime DESC", null, 2);
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.o(117234);
        }
        return i2;
    }

    private static String bkG(String str) {
        AppMethodBeat.i(117235);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(117235);
            return null;
        }
        try {
            Map<String, String> parseXml = XmlParser.parseXml(str, "msgsource", null);
            if (parseXml == null || parseXml.isEmpty()) {
                AppMethodBeat.o(117235);
                return null;
            }
            String str2 = parseXml.get(".msgsource.bizmsg.msgcluster");
            AppMethodBeat.o(117235);
            return str2;
        } catch (Exception e2) {
            Log.e("MicroMsg.MsgInfoStorage", "exception:%s", Util.stackTraceToString(e2));
            Log.e("MicroMsg.MsgInfoStorage", "Exception in getMsgcluster, %s", e2.getMessage());
            AppMethodBeat.o(117235);
            return null;
        }
    }

    private static void ba(ca caVar) {
        AppMethodBeat.i(117236);
        if (caVar == null || !caVar.dOQ()) {
            AppMethodBeat.o(117236);
            return;
        }
        try {
            String str = caVar.field_content;
            int indexOf = str.indexOf("<msg>");
            if (indexOf > 0 && indexOf < str.length()) {
                str = str.substring(indexOf).trim();
            }
            Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
            if (parseXml != null && parseXml.size() > 0) {
                caVar.CA(SemiXml.encode(parseXml));
            }
            AppMethodBeat.o(117236);
        } catch (Exception e2) {
            Log.e("MicroMsg.MsgInfoStorage", e2.getMessage());
            AppMethodBeat.o(117236);
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final long aC(ca caVar) {
        AppMethodBeat.i(263548);
        long c2 = c(caVar, false);
        AppMethodBeat.o(263548);
        return c2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final long c(ca caVar, boolean z) {
        String str;
        long a2;
        String str2;
        AppMethodBeat.i(117238);
        if (caVar == null || Util.isNullOrNil(caVar.field_talker)) {
            e.INSTANCE.idkeyStat(111, 250, 1, false);
            Object[] objArr = new Object[2];
            objArr[0] = caVar;
            if (caVar == null) {
                str = "-1";
            } else {
                str = caVar.field_talker;
            }
            objArr[1] = str;
            Log.e("MicroMsg.MsgInfoStorage", "Error insert message msg:%s talker:%s", objArr);
            AppMethodBeat.o(117238);
            return -1;
        }
        Log.d("MicroMsg.MsgInfoStorage", "insert lockForSync[%b], message seq[%d]", Boolean.valueOf(this.Orq), Long.valueOf(caVar.field_msgSeq));
        String str3 = null;
        bp.b Ky = bp.Ky(caVar.fqK);
        if (Ky != null) {
            str3 = Ky.iEo;
        }
        if (ab.Jy(str3)) {
            Log.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", str3);
            if (caVar.getType() == 436207665) {
                Log.w("MicroMsg.MsgInfoStorage", "protect:c2c msg should not here");
                AppMethodBeat.o(117238);
                return -1;
            }
            caVar.Cy("notifymessage");
        }
        i.b bkK = bkK(caVar.field_talker);
        if (bkK == null) {
            e.INSTANCE.idkeyStat(111, 249, 1, false);
            Log.e("MicroMsg.MsgInfoStorage", "Error insert message getTableByTalker failed. talker:%s", caVar.field_talker);
            AppMethodBeat.o(117238);
            return -1;
        }
        bkK.aF(caVar);
        Assert.assertTrue(String.format("check table name from id:%d table:%s getTableNameByLocalId:%s", Long.valueOf(caVar.field_msgId), bkK, Nk(caVar.field_msgId)), bkK.name.equals(Nk(caVar.field_msgId)));
        if (caVar.field_msgSvrId != 0) {
            caVar.fQV = 1;
            caVar.fqk = true;
        }
        for (e eVar : this.Org) {
            if (!eVar.a(caVar, Ky)) {
                Log.e("MicroMsg.MsgInfoStorage", "Error dealMsgSource. talker:%s ,msgSouce:%s", caVar.field_talker, caVar.fqK);
                AppMethodBeat.o(117238);
                return -1;
            }
        }
        ba(caVar);
        if (bkK.name.equals("message")) {
            caVar.field_talkerId = (int) bkF(caVar.field_talker);
            caVar.fql = true;
        }
        ContentValues convertTo = caVar.convertTo();
        if (z) {
            com.tencent.mm.storagebase.f gFG = this.iFy.gFG();
            String str4 = bkK.name;
            SQLiteDatabase sQLiteDatabase = gFG.Otb != null ? gFG.Otb : gFG.Otc;
            if (com.tencent.mm.storagebase.f.isMainThread()) {
                com.tencent.mm.storagebase.f.Oth.a(sQLiteDatabase, 32769, str4);
            }
            a2 = sQLiteDatabase.insertOrThrow(str4, "msgId", convertTo);
        } else {
            a2 = this.iFy.a(bkK.name, "msgId", convertTo);
        }
        Log.i("MicroMsg.MsgInfoStorage", "insert:%d talker:%s id:%d type:%d status:%d svrid:%d msgseq:%d flag:%d create:%d issend:%d lockforsync[%s,%d]", Long.valueOf(a2), caVar.field_talker, Long.valueOf(caVar.field_msgId), Integer.valueOf(caVar.getType()), Integer.valueOf(caVar.field_status), Long.valueOf(caVar.field_msgSvrId), Long.valueOf(caVar.field_msgSeq), Integer.valueOf(caVar.field_flag), Long.valueOf(caVar.field_createTime), Integer.valueOf(caVar.field_isSend), this.Orr, Long.valueOf(Util.milliSecondsToNow(this.Ors)));
        if (a2 == -1) {
            e.INSTANCE.idkeyStat(111, 248, 1, false);
            Log.e("MicroMsg.MsgInfoStorage", "insert failed svrid:%d ret:%d", Long.valueOf(caVar.field_msgSvrId), Long.valueOf(a2));
            AppMethodBeat.o(117238);
            return -1;
        }
        if (this.Orq && Util.milliSecondsToNow(this.Ors) > 2000 && caVar.field_isSend == 1 && caVar.field_status == 1) {
            Log.w("MicroMsg.MsgInfoStorage", "insert this fucking tag[%s] lockForSync too long:%d force to release Now.", this.Orr, Long.valueOf(Util.milliSecondsToNow(this.Ors)));
            aEt(this.Orr);
        }
        if (this.Orq) {
            String str5 = null;
            if (e.NOM != null) {
                str5 = e.NOM.am(caVar);
            }
            if (Util.isNullOrNil(str5)) {
                str2 = caVar.field_talker;
            } else {
                str2 = str5;
            }
            i.c cVar = null;
            synchronized (this.Orp) {
                try {
                    if (this.Orp.containsKey(str2)) {
                        cVar = this.Orp.get(str2);
                    }
                    if (cVar == null) {
                        cVar = new i.c(caVar.field_talker, "insert", caVar);
                    } else {
                        cVar.hIs.add(caVar);
                    }
                    if (i.c.aG(caVar)) {
                        cVar.tYD++;
                    }
                    cVar.zqo++;
                    this.Orp.put(str2, cVar);
                } catch (Throwable th) {
                    AppMethodBeat.o(117238);
                    throw th;
                }
            }
        } else {
            i.c cVar2 = new i.c(caVar.field_talker, "insert", caVar);
            if (i.c.aG(caVar)) {
                cVar2.tYD = 1;
            }
            cVar2.zqo = 1;
            doNotify();
            a(cVar2);
        }
        long j2 = caVar.field_msgId;
        AppMethodBeat.o(117238);
        return j2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int Hc(long j2) {
        AppMethodBeat.i(117239);
        ca Hb = Hb(j2);
        String str = Hb.field_talker;
        this.Oro.r((int) (Util.nowSecond() / 86400), Hb.field_msgSvrId, Hb.field_createTime / 1000);
        int delete = this.iFy.delete(Nk(j2), "msgId=?", new String[]{String.valueOf(j2)});
        ((au) g.af(au.class)).Ab(j2);
        if (delete != 0) {
            doNotify("delete_id ".concat(String.valueOf(j2)));
            i.c cVar = new i.c(str, "delete", Hb, 1, (byte) 0);
            cVar.zqq = j2;
            cVar.ppv = Hb.field_bizChatId;
            a(cVar);
        } else {
            e.INSTANCE.idkeyStat(111, 245, 1, false);
        }
        AppMethodBeat.o(117239);
        return delete;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final List<ca> aEB(String str) {
        ArrayList arrayList = null;
        AppMethodBeat.i(117240);
        Cursor rawQuery = this.iFy.rawQuery("select * from ".concat(String.valueOf(str)), null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(117240);
        } else {
            if (rawQuery.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    ca caVar = new ca();
                    caVar.convertFrom(rawQuery);
                    arrayList.add(caVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.o(117240);
        }
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor aQ(String str, long j2) {
        AppMethodBeat.i(177113);
        com.tencent.wcdb.Cursor rawQueryWithFactory = this.iFy.gFH().rawQueryWithFactory(null, "SELECT * FROM " + str + " WHERE createTime < " + j2, null, str);
        AppMethodBeat.o(177113);
        return rawQueryWithFactory;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final long aR(String str, long j2) {
        AppMethodBeat.i(117241);
        long j3 = 0;
        Cursor rawQuery = this.iFy.rawQuery("select createTime from " + aEO(str) + " where msgId = " + j2, null, 2);
        if (rawQuery.moveToFirst()) {
            j3 = rawQuery.getLong(0);
        }
        rawQuery.close();
        AppMethodBeat.o(117241);
        return j3;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final List<ca> f(String str, long j2, boolean z) {
        String str2;
        AppMethodBeat.i(117242);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid, limit = 10");
            AppMethodBeat.o(117242);
            return null;
        }
        long aR = aR(str, j2);
        if (aR == 0) {
            Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, msg is null");
            AppMethodBeat.o(117242);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + aEO(str) + " where" + biM(str) + bkE(str) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime > " + aR + " order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + aEO(str) + " where" + biM(str) + bkE(str) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + aR + " order by createTime DESC limit 10";
        }
        Cursor rawQuery = this.iFy.rawQuery(str2, null, 2);
        while (rawQuery.moveToNext()) {
            ca caVar = new ca();
            caVar.convertFrom(rawQuery);
            arrayList.add(caVar);
        }
        if (!z) {
            Collections.reverse(arrayList);
        }
        rawQuery.close();
        AppMethodBeat.o(117242);
        return arrayList;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor at(String str, int i2, int i3) {
        AppMethodBeat.i(117243);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(117243);
            return null;
        }
        Cursor rawQuery = this.iFy.rawQuery("select * from ( select * from " + aEO(str) + " where" + biM(str) + bkE(str) + " AND type IN (3,39,13,43,62,44,268435505,486539313)  order by createTime DESC limit " + i3 + " OFFSET " + i2 + ") order by createTime ASC ", null, 2);
        AppMethodBeat.o(117243);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor B(String str, long j2, long j3) {
        AppMethodBeat.i(117244);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(117244);
            return null;
        }
        Cursor rawQuery = this.iFy.rawQuery("select * from " + aEO(str) + " where" + bkE(str) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime >= " + j2 + " AND createTime< " + j3 + " order by createTime ASC", null, 2);
        AppMethodBeat.o(117244);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor eB(String str, int i2) {
        AppMethodBeat.i(117245);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
            AppMethodBeat.o(117245);
            return null;
        }
        Cursor rawQuery = this.iFy.rawQuery("select * from ( select * from " + aEO(str) + " where" + bkE(str) + " AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime DESC limit 200 OFFSET " + i2 + ") order by createTime ASC ", null, 2);
        AppMethodBeat.o(117245);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor C(String str, long j2, long j3) {
        AppMethodBeat.i(117246);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.MsgInfoStorage", "getAllFileMessage fail, argument is invalid");
            AppMethodBeat.o(117246);
            return null;
        }
        Cursor rawQuery = this.iFy.rawQuery("select * from " + aEO(str) + " where" + bkE(str) + "AND type IN (3,39,13,43,62,44,49,268435505) AND createTime >= " + j2 + " AND createTime< " + j3 + " order by createTime ASC", null, 2);
        AppMethodBeat.o(117246);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor aEC(String str) {
        AppMethodBeat.i(117247);
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(117247);
            return null;
        }
        String aEO = aEO(str);
        String str2 = "select * from " + aEO + " " + bkH(aEO) + " where" + bkE(str) + "AND type IN (3,39,13,43,62,44,49,268435505)  order by createTime";
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        Log.d("MicroMsg.MsgInfoStorage", "all time: %d, sql: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), str2);
        AppMethodBeat.o(117247);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor ez(String str, int i2) {
        AppMethodBeat.i(117248);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(117248);
            return null;
        }
        Cursor rawQuery = this.iFy.rawQuery("select * from " + aEO(str) + " where" + biM(str) + bkE(str) + " AND " + gEf() + "  order by createTime DESC limit " + i2 + " OFFSET 0", null);
        AppMethodBeat.o(117248);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor eA(String str, int i2) {
        AppMethodBeat.i(117249);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(117249);
            return null;
        }
        StringBuilder append = new StringBuilder("select msgId,msgSvrId,createTime,content,isSend,imgPath from ").append(aEO(str)).append(" where").append(biM(str)).append(bkE(str)).append(" AND ");
        Cursor rawQuery = this.iFy.rawQuery(append.append(" (type = 49" + " or type = 587202609" + " or type = 553648177) ").append(" order by createTime DESC limit 100 OFFSET ").append(i2).toString(), null);
        AppMethodBeat.o(117249);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void c(String str, String str2, String[] strArr) {
        AppMethodBeat.i(117250);
        String str3 = "SELECT msgSvrId,createTime FROM " + str + " WHERE createTime > " + ((Util.nowSecond() - 172800) * 1000);
        if (!Util.isNullOrNil(str2)) {
            str3 = str3 + " AND " + str2;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Cursor rawQuery = this.iFy.rawQuery(str3, strArr, 2);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(Integer.valueOf(rawQuery.getInt(0)));
                arrayList2.add(Long.valueOf(rawQuery.getLong(1) / 1000));
            } while (rawQuery.moveToNext());
            this.Oro.B(arrayList, arrayList2);
        }
        rawQuery.close();
        AppMethodBeat.o(117250);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final boolean Hd(long j2) {
        AppMethodBeat.i(117251);
        boolean Ni = this.Oro.Ni(j2);
        AppMethodBeat.o(117251);
        return Ni;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void aED(String str) {
        AppMethodBeat.i(117252);
        c(str, "", null);
        if (this.iFy.execSQL(str, "delete from ".concat(String.valueOf(str)))) {
            doNotify("delete_all ".concat(String.valueOf(str)));
            AppMethodBeat.o(117252);
            return;
        }
        e.INSTANCE.idkeyStat(111, 247, 1, false);
        AppMethodBeat.o(117252);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b  */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int aS(java.lang.String r11, long r12) {
        /*
        // Method dump skipped, instructions count: 133
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.cb.aS(java.lang.String, long):int");
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int aT(String str, long j2) {
        AppMethodBeat.i(117253);
        ca aJ = aJ(str, j2);
        this.Oro.r((int) (Util.nowSecond() / 86400), aJ.field_msgSvrId, aJ.field_createTime / 1000);
        int delete = this.iFy.delete(aEO(str), "msgSvrId=?", new String[]{String.valueOf(j2)});
        if (delete != 0) {
            doNotify();
            a(new i.c(str, "delete", null, 1, (byte) 0));
        } else {
            e.INSTANCE.idkeyStat(111, 246, 1, false);
        }
        AppMethodBeat.o(117253);
        return delete;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int aEE(String str) {
        AppMethodBeat.i(117254);
        Log.w("MicroMsg.MsgInfoStorage", "deleteByTalker :%s  stack:%s", str, MMStack.getStack(true));
        c(aEO(str), bkE(str), null);
        int delete = this.iFy.delete(aEO(str), bkE(str), null);
        if (delete != 0) {
            doNotify("delete_talker ".concat(String.valueOf(str)));
            i.c cVar = new i.c(str, "delete", null, delete, (byte) 0);
            cVar.zqq = -1;
            a(cVar);
        }
        AppMethodBeat.o(117254);
        return delete;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int aU(String str, long j2) {
        AppMethodBeat.i(117255);
        String str2 = bkE(str) + " and createTime <= " + j2;
        c(aEO(str), str2, null);
        int delete = this.iFy.delete(aEO(str), str2, null);
        if (delete != 0) {
            doNotify("delete_talker ".concat(String.valueOf(str)));
            i.c cVar = new i.c(str, "delete", null, delete, (byte) 0);
            cVar.zqq = -1;
            a(cVar);
        }
        AppMethodBeat.o(117255);
        return delete;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int eC(String str, int i2) {
        AppMethodBeat.i(117256);
        Log.w("MicroMsg.MsgInfoStorage", "deleteByTalkerFrom :%s  :%d stack:%s", str, Integer.valueOf(i2), MMStack.getStack(true));
        ca aJ = aJ(str, (long) i2);
        Assert.assertTrue(str.equals(aJ.field_talker));
        c(aEO(str), "createTime<=? AND" + bkE(str), new String[]{new StringBuilder().append(aJ.field_createTime).toString()});
        int delete = this.iFy.delete(aEO(str), "createTime<=? AND" + bkE(str), new String[]{new StringBuilder().append(aJ.field_createTime).toString()});
        if (delete != 0) {
            doNotify();
            a(new i.c(str, "delete", null, delete, (byte) 0));
        }
        AppMethodBeat.o(117256);
        return delete;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor eD(String str, int i2) {
        AppMethodBeat.i(117257);
        ca aJ = aJ(str, (long) i2);
        Assert.assertTrue(str.equals(aJ.field_talker));
        Cursor query = this.iFy.query(aEO(str), null, "createTime<=? AND" + bkE(str), new String[]{new StringBuilder().append(aJ.field_createTime).toString()}, null, null, null);
        AppMethodBeat.o(117257);
        return query;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void a(long j2, ca caVar) {
        AppMethodBeat.i(117258);
        if (caVar.gDj()) {
            String bkG = bkG(caVar.fqK);
            if (ab.Jy(bkG)) {
                Log.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", bkG);
                caVar.Cy("notifymessage");
            }
        }
        ba(caVar);
        if (this.iFy.update(Nk(j2), caVar.convertTo(), "msgId=?", new String[]{String.valueOf(j2)}) != 0) {
            doNotify();
            a(new i.c(caVar.field_talker, "update", caVar));
            AppMethodBeat.o(117258);
            return;
        }
        e.INSTANCE.idkeyStat(111, 244, 1, false);
        AppMethodBeat.o(117258);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void aD(ca caVar) {
        AppMethodBeat.i(117259);
        if (caVar == null || caVar.field_status == 4) {
            AppMethodBeat.o(117259);
            return;
        }
        caVar.setStatus(4);
        String Nk = Nk(caVar.field_msgId);
        if (Nk != null && Nk.length() > 0) {
            if (this.iFy.update(Nk, caVar.convertTo(), "msgId=?", new String[]{new StringBuilder().append(caVar.field_msgId).toString()}) != 0) {
                doNotify();
                a(new i.c(caVar.field_talker, "update", caVar, -1));
            }
        }
        AppMethodBeat.o(117259);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void b(long j2, ca caVar) {
        AppMethodBeat.i(117260);
        Assert.assertTrue("no talker set when update by svrid", Util.nullAsNil(caVar.field_talker).length() > 0);
        if (caVar.gDj()) {
            String bkG = bkG(caVar.fqK);
            if (ab.Jy(bkG)) {
                Log.d("MicroMsg.MsgInfoStorage", "msgCluster = %s", bkG);
                caVar.Cy("notifymessage");
            }
        }
        ba(caVar);
        if (j2 == 0) {
            Log.w("MicroMsg.MsgInfoStorage", "invalid svr id %d", Long.valueOf(j2));
            AppMethodBeat.o(117260);
            return;
        }
        if (this.iFy.update(aEO(caVar.field_talker), caVar.convertTo(), "msgSvrId=?", new String[]{String.valueOf(j2)}) != 0) {
            doNotify();
            a(new i.c(caVar.field_talker, "update", caVar));
            AppMethodBeat.o(117260);
            return;
        }
        e.INSTANCE.idkeyStat(111, 243, 1, false);
        AppMethodBeat.o(117260);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int aEF(String str) {
        AppMethodBeat.i(117261);
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        int update = this.iFy.update(aEO(str), contentValues, bkE(str) + "AND isSend=? AND status!=? ", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "4"});
        if (update != 0) {
            doNotify();
            a(new i.c(str, "update", null));
        }
        AppMethodBeat.o(117261);
        return update;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int aE(ca caVar) {
        int i2 = 0;
        AppMethodBeat.i(117262);
        if (caVar != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", caVar.field_content);
            contentValues.put("status", Integer.valueOf(caVar.field_status));
            i2 = this.iFy.update(Nk(caVar.field_msgId), contentValues, "msgId=?", new String[]{String.valueOf(caVar.field_msgId)});
            if (i2 != 0) {
                doNotify();
                a(new i.c(caVar.field_talker, "update", caVar));
            }
        }
        AppMethodBeat.o(117262);
        return i2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor aEG(String str) {
        AppMethodBeat.i(117263);
        Cursor query = this.iFy.query(aEO(str), null, bkE(str), null, null, null, "createTime ASC ");
        AppMethodBeat.o(117263);
        return query;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor G(String str, int i2, long j2) {
        AppMethodBeat.i(117264);
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + " AND createTime <= " + j2 + " order by createTime ASC limit " + i2, null);
        AppMethodBeat.o(117264);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor iH(String str, String str2) {
        AppMethodBeat.i(117265);
        Cursor rawQuery = this.iFy.rawQuery(("SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + "AND content LIKE '%" + str2 + "%' AND type = 1") + " ORDER BY createTime DESC", null);
        AppMethodBeat.o(117265);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor H(String str, int i2, long j2) {
        AppMethodBeat.i(117266);
        String str2 = "SELECT * FROM ( SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + (j2 > 0 ? " AND createTime > ".concat(String.valueOf(j2)) : "") + " ORDER BY createTime DESC LIMIT " + i2 + ") ORDER BY createTime ASC";
        Log.i("MicroMsg.MsgInfoStorage", "getInitCursor1 getCursor talk:%s limitCount:%d [%s]", str, Integer.valueOf(i2), str2);
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        AppMethodBeat.o(117266);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor aEH(String str) {
        AppMethodBeat.i(117267);
        Cursor query = this.iFy.query(aEO(str), null, "isSend=? AND" + bkE(str) + "AND status!=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "4"}, null, null, null);
        AppMethodBeat.o(117267);
        return query;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor eE(String str, int i2) {
        AppMethodBeat.i(117268);
        Cursor query = this.iFy.query(aEO(str), null, "isSend=? AND" + bkE(str) + "AND status!=?  order by msgId DESC limit " + i2, new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "4"}, null, null, null);
        AppMethodBeat.o(117268);
        return query;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor eiM() {
        AppMethodBeat.i(117269);
        Cursor query = this.iFy.query("message", new String[]{"talker", "count(*) as unReadCount"}, "isSend=? AND status!=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, "4"}, "talker", null, null);
        AppMethodBeat.o(117269);
        return query;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca.c aEI(String str) {
        AppMethodBeat.i(117270);
        ca.c cVar = this.Ori.get(Integer.valueOf(str.hashCode()));
        if (cVar == null) {
            cVar = ca.c.bkC(str);
            this.Ori.x(Integer.valueOf(str.hashCode()), cVar);
        }
        AppMethodBeat.o(117270);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca.d aEJ(String str) {
        AppMethodBeat.i(117271);
        ca.d dVar = this.Orj.get(Integer.valueOf(str.hashCode()));
        if (dVar == null) {
            dVar = ca.d.bkD(str);
            this.Orj.x(Integer.valueOf(str.hashCode()), dVar);
        }
        AppMethodBeat.o(117271);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca.a aEK(String str) {
        AppMethodBeat.i(117272);
        ca.a aVar = null;
        if (Util.isNullOrNil(str) || this.Ork == null) {
            Log.e("MicroMsg.MsgInfoStorage", "input text null ???? %B", Boolean.valueOf(Util.isNullOrNil(str)));
            Log.e("MicroMsg.MsgInfoStorage", "[arthurdan.FriendContentCrash] Fatal error!!! cachesForFriend is null!");
        } else {
            aVar = this.Ork.get(Integer.valueOf(str.hashCode()));
        }
        if (aVar == null) {
            aVar = ca.a.bkA(str);
            if (this.Ork != null) {
                this.Ork.x(Integer.valueOf(Util.nullAs(str, "").hashCode()), aVar);
            }
        }
        AppMethodBeat.o(117272);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca.b aEL(String str) {
        AppMethodBeat.i(117273);
        ca.b bVar = this.Orl.get(Integer.valueOf(str.hashCode()));
        if (bVar == null) {
            bVar = ca.b.bkB(str);
            this.Orl.x(Integer.valueOf(str.hashCode()), bVar);
        }
        AppMethodBeat.o(117273);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int aEM(String str) {
        int i2 = 0;
        AppMethodBeat.i(117274);
        if (Kv(str)) {
            int bkq = this.oQy.bkq(str);
            if (bkq > 0) {
                Log.i("MicroMsg.MsgInfoStorage", "getMsgCount conversationStorage.getMsgCountByUsername count:%d", Integer.valueOf(bkq));
                AppMethodBeat.o(117274);
                return bkq;
            }
            Log.i("MicroMsg.MsgInfoStorage", "getMsgCount contactMsgCount is 0 ,go normal %s", str);
        } else if ("appbrandmessage".equals(aEO(str)) || "appbrandnotifymessage".equals(aEO(str))) {
            Cursor rawQuery = this.iFy.rawQuery("SELECT COUNT(*) FROM " + aEO(str) + " WHERE" + bkE(str), null);
            if (rawQuery.moveToLast()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.o(117274);
            return i2;
        } else if ("bottlemessage".equals(aEO(str))) {
            Cursor rawQuery2 = this.iFy.rawQuery("SELECT COUNT(*) FROM " + aEO(str) + " WHERE" + bkE(str), null, 2);
            if (rawQuery2.moveToFirst()) {
                i2 = rawQuery2.getInt(0);
            }
            rawQuery2.close();
            AppMethodBeat.o(117274);
            return i2;
        }
        int Ku = Ku(str);
        AppMethodBeat.o(117274);
        return Ku;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final boolean Kv(String str) {
        AppMethodBeat.i(117275);
        boolean equals = "message".equals(aEO(str));
        AppMethodBeat.o(117275);
        return equals;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int Ku(String str) {
        int i2 = 0;
        AppMethodBeat.i(117276);
        Cursor rawQuery = this.iFy.rawQuery("SELECT COUNT(*) FROM " + aEO(str) + " WHERE" + biM(str) + bkE(str), null, 2);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(117276);
        return i2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final long aEX(String str) {
        int i2 = 0;
        AppMethodBeat.i(187526);
        Cursor rawQuery = this.iFy.rawQuery("SELECT COUNT(*) FROM " + aEO(str) + " WHERE " + bkE(str) + " AND type NOT IN (10000,10002,570425393,64,603979825,855638065,889192497" + ",922746929)", null, 2);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        long j2 = (long) i2;
        AppMethodBeat.o(187526);
        return j2;
    }

    private String bkH(String str) {
        AppMethodBeat.i(117277);
        if (str == null || !str.equals("message")) {
            AppMethodBeat.o(117277);
            return "";
        } else if (this.Orf) {
            AppMethodBeat.o(117277);
            return "INDEXED BY messageTaklerIdTypeCreateTimeIndex";
        } else {
            AppMethodBeat.o(117277);
            return "INDEXED BY messageCreateTaklerTypeTimeIndex";
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int eF(String str, int i2) {
        int i3 = 0;
        AppMethodBeat.i(117278);
        Cursor rawQuery = this.iFy.rawQuery("SELECT COUNT(*) FROM " + aEO(str) + " WHERE" + bkE(str) + "AND type = " + i2, null, 2);
        if (rawQuery.moveToFirst()) {
            i3 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(117278);
        return i3;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int D(String str, long j2, long j3) {
        int i2 = 0;
        AppMethodBeat.i(117279);
        Cursor rawQuery = this.iFy.rawQuery("SELECT COUNT(*) FROM " + aEO(str) + " WHERE" + bkE(str) + "AND type = 50 AND createTime >= " + j2 + " AND createTime <= " + j3 + " LIMIT 1", null, 2);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(117279);
        return i2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int aEN(String str) {
        int i2 = 0;
        AppMethodBeat.i(117280);
        if (str == null) {
            Log.w("MicroMsg.MsgInfoStorage", "getImgVideoMsgCount talker is null!");
            AppMethodBeat.o(117280);
        } else {
            Cursor rawQuery = this.iFy.rawQuery("SELECT COUNT(*) FROM " + aEO(str) + " WHERE " + biM(str) + "talker= '" + Util.escapeSqlValue(str) + "' AND type IN (3,39,13,43,62,44,268435505,486539313)", null, 2);
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.o(117280);
        }
        return i2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int aV(String str, long j2) {
        int i2 = 0;
        AppMethodBeat.i(117281);
        ca Hb = Hb(j2);
        if (Hb.field_msgId == 0) {
            Log.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
            AppMethodBeat.o(117281);
        } else {
            String aEO = aEO(str);
            Cursor rawQuery = this.iFy.rawQuery("SELECT COUNT(*) FROM " + aEO + " " + bkH(aEO) + " WHERE " + biM(str) + bkE(str) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + Hb.field_createTime, null, 2);
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.o(117281);
        }
        return i2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final String aW(String str, long j2) {
        String str2 = null;
        AppMethodBeat.i(117282);
        ca Hb = Hb(j2);
        if (Hb.field_msgId == 0) {
            Log.e("MicroMsg.MsgInfoStorage", "getCountEarlyThan fail, msg does not exist");
            AppMethodBeat.o(117282);
        } else {
            String aEO = aEO(str);
            Cursor rawQuery = this.iFy.rawQuery("EXPLAIN QUERY PLAN SELECT COUNT(*) FROM " + aEO + " " + bkH(aEO) + " WHERE" + biM(str) + bkE(str) + "AND type IN (3,39,13,43,62,44,268435505,486539313) AND createTime < " + Hb.field_createTime, null);
            str2 = "";
            if (rawQuery.moveToFirst()) {
                for (int i2 = 0; i2 < rawQuery.getColumnCount(); i2++) {
                    str2 = str2 + rawQuery.getString(i2) + " ";
                }
            }
            rawQuery.close();
            AppMethodBeat.o(117282);
        }
        return str2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final String eiN() {
        return "type IN (3,39,13,43,62,44,268435505,486539313)";
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final String eiO() {
        return "type IN (3,39,13,43,62,44,49,268435505)";
    }

    private static String gEf() {
        AppMethodBeat.i(187527);
        String sb = new StringBuilder("type & 65535 = 49").toString();
        AppMethodBeat.o(187527);
        return sb;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final String aEO(String str) {
        AppMethodBeat.i(117283);
        Assert.assertTrue("username == null", str != null && str.length() > 0);
        String str2 = bkK(str).name;
        AppMethodBeat.o(117283);
        return str2;
    }

    private i.b bkI(String str) {
        AppMethodBeat.i(117284);
        Assert.assertTrue("tableName == null", str != null && str.length() > 0);
        for (int i2 = 0; i2 < this.Orh.size(); i2++) {
            if (str.equals(this.Orh.get(i2).name)) {
                i.b bVar = this.Orh.get(i2);
                AppMethodBeat.o(117284);
                return bVar;
            }
        }
        Assert.assertTrue("no table match", false);
        AppMethodBeat.o(117284);
        return null;
    }

    private String bkJ(String str) {
        AppMethodBeat.i(117285);
        Assert.assertTrue(str != null && str.length() > 0);
        for (e eVar : this.Org) {
            String avu = eVar.avu(str);
            if (!Util.isNullOrNil(avu)) {
                AppMethodBeat.o(117285);
                return avu;
            }
        }
        AppMethodBeat.o(117285);
        return "message";
    }

    private i.b bkK(String str) {
        AppMethodBeat.i(117286);
        Assert.assertTrue("username == null", str != null && str.length() > 0);
        i.b bkI = bkI(bkJ(str));
        AppMethodBeat.o(117286);
        return bkI;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final boolean He(long j2) {
        AppMethodBeat.i(117287);
        for (int i2 = 0; i2 < this.Orh.size(); i2++) {
            if (this.Orh.get(i2).Hg(j2)) {
                AppMethodBeat.o(117287);
                return true;
            }
        }
        AppMethodBeat.o(117287);
        return false;
    }

    private String Nk(long j2) {
        AppMethodBeat.i(117288);
        if (j2 == 0 || j2 == -1) {
            AppMethodBeat.o(117288);
            return null;
        }
        ca.Nj(j2);
        for (int i2 = 0; i2 < this.Orh.size(); i2++) {
            if (this.Orh.get(i2).Hg(j2)) {
                String str = this.Orh.get(i2).name;
                AppMethodBeat.o(117288);
                return str;
            }
        }
        Assert.assertTrue(String.format("getTableNameByLocalId failed:%d", Long.valueOf(j2)), false);
        AppMethodBeat.o(117288);
        return null;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final long aEP(String str) {
        AppMethodBeat.i(117289);
        String str2 = "select createTime from message where" + bkE(str) + "order by createTime LIMIT 1 OFFSET 0";
        Log.d("MicroMsg.MsgInfoStorage", "get first message create time: ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.iFy.rawQuery(str2, null, 2);
        if (rawQuery == null) {
            Log.e("MicroMsg.MsgInfoStorage", "get first message create time failed: ".concat(String.valueOf(str)));
            AppMethodBeat.o(117289);
            return -1;
        } else if (rawQuery.moveToFirst()) {
            long j2 = rawQuery.getLong(0);
            rawQuery.close();
            AppMethodBeat.o(117289);
            return j2;
        } else {
            rawQuery.close();
            AppMethodBeat.o(117289);
            return -1;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final long aEQ(String str) {
        AppMethodBeat.i(117290);
        String str2 = "select createTime from message where" + biM(str) + bkE(str) + "order by createTime DESC LIMIT 1 ";
        Log.d("MicroMsg.MsgInfoStorage", "get last message create time: ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.iFy.rawQuery(str2, null, 2);
        if (rawQuery == null) {
            Log.e("MicroMsg.MsgInfoStorage", "get last message create time failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(117290);
            return -1;
        } else if (rawQuery.moveToFirst()) {
            long j2 = rawQuery.getLong(0);
            rawQuery.close();
            AppMethodBeat.o(117290);
            return j2;
        } else {
            rawQuery.close();
            AppMethodBeat.o(117290);
            return -1;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final long aER(String str) {
        AppMethodBeat.i(117291);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(117291);
            return 0;
        }
        String str2 = "select msgSeq from message where" + bkE(str) + "order by msgSeq DESC LIMIT 1 ";
        Log.i("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq: ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.iFy.rawQuery(str2, null, 2);
        if (rawQuery == null) {
            Log.e("MicroMsg.MsgInfoStorage", "summerbadcr get last message msgseq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(117291);
            return 0;
        } else if (rawQuery.moveToFirst()) {
            long j2 = rawQuery.getLong(0);
            rawQuery.close();
            AppMethodBeat.o(117291);
            return j2;
        } else {
            rawQuery.close();
            AppMethodBeat.o(117291);
            return 0;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca aX(String str, long j2) {
        AppMethodBeat.i(117292);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(117292);
            return null;
        }
        String str2 = "select * from message where" + bkE(str) + " and msgSeq < " + j2 + " order by msgSeq DESC LIMIT 1 ";
        Log.i("MicroMsg.MsgInfoStorage", "summerbadcr getOlderMsgByMsgSeq: ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        if (rawQuery == null) {
            Log.e("MicroMsg.MsgInfoStorage", "summerbadcr getNewerMsgByMsgSeq failed ".concat(String.valueOf(str)));
            AppMethodBeat.o(117292);
            return null;
        } else if (rawQuery.moveToFirst()) {
            ca caVar = new ca();
            caVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(117292);
            return caVar;
        } else {
            rawQuery.close();
            AppMethodBeat.o(117292);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca aES(String str) {
        AppMethodBeat.i(117293);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(117293);
            return null;
        }
        Log.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg talker[%s], onlyCache[%b]", str, Boolean.FALSE);
        Long l = this.Orn.get(str);
        if (l == null || l.longValue() <= 0) {
            Log.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg not hit cache");
            ca caVar = new ca();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + "AND flag %2 = 1  ORDER BY msgSeq DESC LIMIT 1 ", null, 2);
            Log.d("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg take %dms, tid[%d]", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(Thread.currentThread().getId()));
            if (rawQuery == null) {
                Log.e("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg failed ".concat(String.valueOf(str)));
                AppMethodBeat.o(117293);
                return caVar;
            }
            if (rawQuery.moveToFirst()) {
                caVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            this.Orn.x(str, Long.valueOf(caVar.field_msgId));
            AppMethodBeat.o(117293);
            return caVar;
        }
        Log.i("MicroMsg.MsgInfoStorage", "summerbadcr getLastFaultMsg hit cache msgid[%d]", Long.valueOf(l.longValue()));
        ca Hb = Hb(l.longValue());
        if ((Hb.field_flag & 1) != 0) {
            AppMethodBeat.o(117293);
            return Hb;
        }
        this.Orn.remove(str);
        AppMethodBeat.o(117293);
        return null;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int E(String str, long j2, long j3) {
        long j4;
        long j5;
        AppMethodBeat.i(117294);
        if (j3 < j2) {
            j4 = j2;
            j5 = j3;
        } else {
            j4 = j3;
            j5 = j2;
        }
        Log.d("MicroMsg.MsgInfoStorage", "talker %s, get count fromCreateTime %d, toCreateTime %d", str, Long.valueOf(j5), Long.valueOf(j4));
        String str2 = "SELECT COUNT(msgId) FROM " + aEO(str) + " WHERE" + biM(str) + bkE(str) + "AND createTime >= " + j5 + " AND createTime <= " + j4;
        Log.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.iFy.rawQuery(str2, null, 2);
        if (rawQuery == null) {
            Log.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
            AppMethodBeat.o(117294);
            return 0;
        } else if (rawQuery.moveToFirst()) {
            int i2 = rawQuery.getInt(0);
            Log.d("MicroMsg.MsgInfoStorage", "result msg count %d", Integer.valueOf(i2));
            rawQuery.close();
            AppMethodBeat.o(117294);
            return i2;
        } else {
            rawQuery.close();
            AppMethodBeat.o(117294);
            return 0;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int eiP() {
        AppMethodBeat.i(117295);
        Log.d("MicroMsg.MsgInfoStorage", "get count sql: ".concat(String.valueOf("SELECT COUNT(msgId) FROM message")));
        Cursor rawQuery = this.iFy.rawQuery("SELECT COUNT(msgId) FROM message", null, 2);
        if (rawQuery == null) {
            Log.w("MicroMsg.MsgInfoStorage", "get count error, cursor is null");
            AppMethodBeat.o(117295);
            return 0;
        } else if (rawQuery.moveToFirst()) {
            int i2 = rawQuery.getInt(0);
            Log.d("MicroMsg.MsgInfoStorage", "result getAllMsgCount count %d", Integer.valueOf(i2));
            rawQuery.close();
            AppMethodBeat.o(117295);
            return i2;
        } else {
            rawQuery.close();
            AppMethodBeat.o(117295);
            return 0;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor a(String str, long j2, long j3, boolean z) {
        long j4;
        long j5;
        AppMethodBeat.i(117296);
        if (j3 < j2) {
            j4 = j2;
            j5 = j3;
        } else {
            j4 = j3;
            j5 = j2;
        }
        String str2 = "SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + "AND createTime >= " + j5 + " AND createTime <= " + j4 + " AND isSend=" + (z ? 1 : 0) + " LIMIT 1";
        Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        AppMethodBeat.o(117296);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor F(String str, long j2, long j3) {
        long j4;
        long j5;
        AppMethodBeat.i(117297);
        if (j3 < j2) {
            j4 = j2;
            j5 = j3;
        } else {
            j4 = j3;
            j5 = j2;
        }
        String str2 = "SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + "AND createTime >= " + j5 + " AND createTime <= " + j4 + " ORDER BY createTime ASC ";
        Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        AppMethodBeat.o(117297);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor d(String str, long j2, long j3, int i2) {
        long j4;
        long j5;
        AppMethodBeat.i(117298);
        if (j3 < j2) {
            j4 = j2;
            j5 = j3;
        } else {
            j4 = j3;
            j5 = j2;
        }
        String str2 = "SELECT * FROM (SELECT * FROM " + aEO(str) + " WHERE" + biM(str) + bkE(str) + " AND createTime >= " + j5 + " AND createTime <= " + j4 + " ORDER BY createTime DESC LIMIT " + i2 + " ) ORDER BY createTime ASC";
        Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        AppMethodBeat.o(117298);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor b(String str, long j2, long j3, int i2) {
        long j4;
        long j5;
        AppMethodBeat.i(117299);
        if (j3 < j2) {
            j4 = j2;
            j5 = j3;
        } else {
            j4 = j3;
            j5 = j2;
        }
        String str2 = "SELECT * FROM ( SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + (j5 > 0 ? " AND createTime >= ".concat(String.valueOf(j5)) : "") + (j4 > 0 ? " AND createTime <= ".concat(String.valueOf(j4)) : "") + " ORDER BY createTime DESC LIMIT " + i2 + ") ORDER BY createTime ASC";
        Log.d("MicroMsg.MsgInfoStorage", "getCursorAfterStratTimeBeforeEndTimeLimit talk:%s limitCount:%d [%s]", str, Integer.valueOf(i2), str2);
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        AppMethodBeat.o(117299);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int G(String str, long j2, long j3) {
        long j4;
        long j5;
        AppMethodBeat.i(117300);
        if (j3 < j2) {
            j4 = j2;
            j5 = j3;
        } else {
            j4 = j3;
            j5 = j2;
        }
        String str2 = "SELECT COUNT(*) FROM ( SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + (j5 > 0 ? " AND createTime >= ".concat(String.valueOf(j5)) : "") + (j4 > 0 ? " AND createTime <= ".concat(String.valueOf(j4)) : "") + " ORDER BY createTime)";
        Log.d("MicroMsg.MsgInfoStorage", "getCountAfterStratTimeBeforeEndTime talk:%s [%s]", str, str2);
        Cursor rawQuery = this.iFy.rawQuery(str2, null, 2);
        int i2 = 0;
        try {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MsgInfoStorage", e2, "", new Object[0]);
            rawQuery.close();
        } catch (Throwable th) {
            rawQuery.close();
            AppMethodBeat.o(117300);
            throw th;
        }
        AppMethodBeat.o(117300);
        return i2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor c(String str, long j2, long j3, int i2) {
        long j4;
        long j5;
        AppMethodBeat.i(117301);
        if (j3 == 0) {
            String str2 = "SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + "AND createTime > " + j2 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + i2;
            Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
            Cursor rawQuery = this.iFy.rawQuery(str2, null);
            AppMethodBeat.o(117301);
            return rawQuery;
        }
        if (j3 < j2) {
            j4 = j2;
            j5 = j3;
        } else {
            j4 = j3;
            j5 = j2;
        }
        String str3 = "SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + "AND createTime > " + j5 + " AND createTime < " + j4 + " ORDER BY createTime ASC  LIMIT 50 OFFSET " + i2;
        Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str3)));
        Cursor rawQuery2 = this.iFy.rawQuery(str3, null);
        AppMethodBeat.o(117301);
        return rawQuery2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int H(String str, long j2, long j3) {
        long j4;
        long j5;
        int i2;
        AppMethodBeat.i(117302);
        if (j3 < j2) {
            j4 = j2;
            j5 = j3;
        } else {
            j4 = j3;
            j5 = j2;
        }
        Cursor rawQuery = this.iFy.rawQuery("SELECT COUNT(*) FROM " + aEO(str) + " WHERE" + bkE(str) + "AND createTime > " + j5 + " AND createTime < " + j4, null, 2);
        try {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            } else {
                i2 = 0;
            }
            rawQuery.close();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MsgInfoStorage", e2, "", new Object[0]);
            rawQuery.close();
            i2 = 0;
        } catch (Throwable th) {
            rawQuery.close();
            AppMethodBeat.o(117302);
            throw th;
        }
        AppMethodBeat.o(117302);
        return i2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor aY(String str, long j2) {
        AppMethodBeat.i(187528);
        String str2 = "SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + "AND createTime > " + j2 + " ORDER BY createTime ASC ";
        Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        AppMethodBeat.o(187528);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor I(String str, long j2, long j3) {
        long j4;
        long j5;
        AppMethodBeat.i(117303);
        if (j3 < j2) {
            j4 = j2;
            j5 = j3;
        } else {
            j4 = j3;
            j5 = j2;
        }
        String str2 = "SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + "AND createTime >= " + j5 + " AND createTime <= " + j4;
        Log.d("MicroMsg.MsgInfoStorage", "get cursor: ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        AppMethodBeat.o(117303);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor ae(String str, String str2, int i2) {
        AppMethodBeat.i(117304);
        String str3 = " SELECT * FROM " + aEO(str) + " WHERE" + biM(str) + bkE(str) + "AND content LIKE '" + str2 + "%' ORDER BY createTime DESC LIMIT " + i2;
        Log.d("MicroMsg.MsgInfoStorage", "getInitCursorByMember getCursor talk:%s member:%s,limitCount:%d [%s]", str, str2, Integer.valueOf(i2), str3);
        Cursor rawQuery = this.iFy.rawQuery(str3, null);
        AppMethodBeat.o(117304);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor eG(String str, int i2) {
        AppMethodBeat.i(117305);
        String str2 = " SELECT * FROM " + aEO(str) + " WHERE" + biM(str) + bkE(str) + "AND isSend=1 ORDER BY createTime DESC LIMIT " + i2;
        Log.d("MicroMsg.MsgInfoStorage", "[getInitCursorBySelf] getCursor talk:%s,limitCount:%d [%s]", str, Integer.valueOf(i2), str2);
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        AppMethodBeat.o(117305);
        return rawQuery;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int iI(String str, String str2) {
        int i2;
        AppMethodBeat.i(117306);
        String str3 = " SELECT COUNT(*) FROM " + aEO(str) + " WHERE" + biM(str) + bkE(str) + "AND content LIKE '" + str2 + "%' ";
        Cursor rawQuery = this.iFy.rawQuery(str3, null, 2);
        try {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            } else {
                i2 = 0;
            }
            rawQuery.close();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MsgInfoStorage", e2, "", new Object[0]);
            rawQuery.close();
            i2 = 0;
        } catch (Throwable th) {
            rawQuery.close();
            AppMethodBeat.o(117306);
            throw th;
        }
        Log.d("MicroMsg.MsgInfoStorage", "getMsgCountByMember getCursor talk:%s member:%s,count:%s,[%s]", str, str2, Integer.valueOf(i2), str3);
        AppMethodBeat.o(117306);
        return i2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final int aET(String str) {
        int i2;
        AppMethodBeat.i(117307);
        String str2 = " SELECT COUNT(*) FROM " + aEO(str) + " WHERE" + biM(str) + bkE(str) + "AND isSend=1";
        Cursor rawQuery = this.iFy.rawQuery(str2, null, 2);
        try {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            } else {
                i2 = 0;
            }
            rawQuery.close();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MsgInfoStorage", e2, "", new Object[0]);
            rawQuery.close();
            i2 = 0;
        } catch (Throwable th) {
            rawQuery.close();
            AppMethodBeat.o(117307);
            throw th;
        }
        Log.d("MicroMsg.MsgInfoStorage", "[getMsgCountBySelf] getCursor talk:%s,count:%s,[%s]", str, Integer.valueOf(i2), str2);
        AppMethodBeat.o(117307);
        return i2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final long i(String str, long j2, int i2) {
        AppMethodBeat.i(117308);
        Log.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j2), Integer.valueOf(i2));
        if (i2 <= 0) {
            Log.w("MicroMsg.MsgInfoStorage", "error target inc count");
            AppMethodBeat.o(117308);
            return j2;
        }
        String str2 = "SELECT createTime FROM " + aEO(str) + " WHERE" + biM(str) + bkE(str) + "AND createTime < " + j2 + " ORDER BY createTime DESC  LIMIT " + i2;
        Log.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", str2);
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        if (rawQuery == null) {
            Log.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
            AppMethodBeat.o(117308);
            return j2;
        } else if (rawQuery.moveToLast()) {
            long j3 = rawQuery.getLong(0);
            Log.d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(j3));
            rawQuery.close();
            AppMethodBeat.o(117308);
            return j3;
        } else {
            rawQuery.close();
            Log.w("MicroMsg.MsgInfoStorage", "get result fail");
            AppMethodBeat.o(117308);
            return j2;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca aZ(String str, long j2) {
        AppMethodBeat.i(117309);
        Log.d("MicroMsg.MsgInfoStorage", "get up inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j2), 1);
        ca caVar = new ca();
        String str2 = "SELECT * FROM " + aEO(str) + " WHERE" + bkE(str) + "AND createTime < " + j2 + " AND isSend = 0 ORDER BY createTime DESC  LIMIT 1";
        Log.d("MicroMsg.MsgInfoStorage", "get up inc msg create time sql: %s", str2);
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        if (rawQuery == null) {
            Log.w("MicroMsg.MsgInfoStorage", "get inc msg create time error, cursor is null");
            AppMethodBeat.o(117309);
        } else if (rawQuery.moveToLast()) {
            caVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(117309);
        } else {
            rawQuery.close();
            Log.w("MicroMsg.MsgInfoStorage", "get result fail");
            AppMethodBeat.o(117309);
        }
        return caVar;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final long j(String str, long j2, int i2) {
        AppMethodBeat.i(117310);
        Log.d("MicroMsg.MsgInfoStorage", "get down inc create time, talker %s, fromCreateTime %d, targetIncCount %d", str, Long.valueOf(j2), Integer.valueOf(i2));
        if (i2 <= 0) {
            Log.w("MicroMsg.MsgInfoStorage", "error target inc count");
            AppMethodBeat.o(117310);
            return j2;
        }
        String str2 = "SELECT createTime FROM " + aEO(str) + " WHERE" + bkE(str) + "AND createTime > " + j2 + " ORDER BY createTime ASC  LIMIT " + i2;
        Log.d("MicroMsg.MsgInfoStorage", "get down inc msg create time sql: %s", str2);
        Cursor rawQuery = this.iFy.rawQuery(str2, null);
        if (rawQuery == null) {
            Log.w("MicroMsg.MsgInfoStorage", "get down inc msg create time error, cursor is null");
            AppMethodBeat.o(117310);
            return j2;
        } else if (rawQuery.moveToLast()) {
            long j3 = rawQuery.getLong(0);
            Log.d("MicroMsg.MsgInfoStorage", "result msg create time %d", Long.valueOf(j3));
            rawQuery.close();
            AppMethodBeat.o(117310);
            return j3;
        } else {
            rawQuery.close();
            Log.w("MicroMsg.MsgInfoStorage", "get result fail");
            AppMethodBeat.o(117310);
            return j2;
        }
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final ca[] eH(String str, int i2) {
        AppMethodBeat.i(117311);
        if (str == null || str.length() == 0 || i2 <= 0) {
            Log.e("MicroMsg.MsgInfoStorage", "getLastMsgList, invalid argument, talker = " + str + ", limit = " + i2);
            AppMethodBeat.o(117311);
            return null;
        }
        Cursor rawQuery = this.iFy.rawQuery("select * from " + aEO(str) + " where" + bkE(str) + "order by createTime DESC limit " + i2, null, 2);
        if (rawQuery.moveToFirst()) {
            ArrayList arrayList = new ArrayList();
            do {
                ca caVar = new ca();
                caVar.convertFrom(rawQuery);
                arrayList.add(caVar);
            } while (rawQuery.moveToNext());
            rawQuery.close();
            Log.d("MicroMsg.MsgInfoStorage", "getLastMsgList, talker = " + str + ", limit = " + i2 + ", count = " + arrayList.size());
            Collections.reverse(arrayList);
            ca[] caVarArr = (ca[]) arrayList.toArray(new ca[arrayList.size()]);
            AppMethodBeat.o(117311);
            return caVarArr;
        }
        Log.w("MicroMsg.MsgInfoStorage", "getLastMsgList, cursor is empty");
        rawQuery.close();
        AppMethodBeat.o(117311);
        return null;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final LinkedList<ca> iJ(String str, String str2) {
        LinkedList<ca> linkedList = null;
        AppMethodBeat.i(117312);
        Cursor query = this.iFy.query(aEO(str), null, "talker=? AND bizClientMsgId=?", new String[]{str, str2}, null, null, null, 2);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    linkedList = new LinkedList<>();
                    do {
                        ca caVar = new ca();
                        caVar.convertFrom(query);
                        linkedList.add(caVar);
                    } while (query.moveToNext());
                    query.close();
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.o(117312);
                    return linkedList;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MsgInfoStorage", e2, "getLastDayC2CMsgByTalker error: %s", e2.getMessage());
                linkedList = new LinkedList<>();
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(117312);
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
                AppMethodBeat.o(117312);
                throw th;
            }
        }
        Log.e("MicroMsg.MsgInfoStorage", "getByBizClientMsgId fail");
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(117312);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final void Hf(long j2) {
        AppMethodBeat.i(117313);
        this.Oro.b(0, j2, 0, false);
        AppMethodBeat.o(117313);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075  */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.storage.ca> aEU(java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 130
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.cb.aEU(java.lang.String):java.util.List");
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor aEW(String str) {
        AppMethodBeat.i(117315);
        try {
            Cursor query = this.iFy.query(aEO(str), null, bkE(str) + " AND createTime>=? AND type IN (436207665,419430449" + ")", new String[]{String.valueOf(System.currentTimeMillis() - Util.MILLSECONDS_OF_DAY)}, null, null, "createTime ASC", 2);
            AppMethodBeat.o(117315);
            return query;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MsgInfoStorage", e2, "getLastDayC2CMsgByTalker error: %s", e2.getMessage());
            AppMethodBeat.o(117315);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f  */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.storage.ca> eiQ() {
        /*
        // Method dump skipped, instructions count: 123
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.cb.eiQ():java.util.List");
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final long aEV(String str) {
        AppMethodBeat.i(117317);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(117317);
            return 0;
        }
        i.b bkI = bkI(str);
        if (bkI == null) {
            AppMethodBeat.o(117317);
            return 0;
        }
        long j2 = bkI.iXv;
        AppMethodBeat.o(117317);
        return j2;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor k(String str, long j2, int i2) {
        Cursor cursor = null;
        AppMethodBeat.i(117318);
        try {
            cursor = this.iFy.rawQuery("select * from " + str + " where " + "type IN (3,39,13,43,62,44,49,268435505,34)" + " AND msgId >= " + j2 + "  order by msgId ASC  limit " + i2, null);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(117318);
        return cursor;
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    public final Cursor eI(String str, int i2) {
        AppMethodBeat.i(117319);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.MsgInfoStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(117319);
            return null;
        }
        Cursor rawQuery = this.iFy.rawQuery("select * from " + aEO(str) + " where" + biM(str) + bkE(str) + " AND type IN (436207665,419430449)  order by createTime" + " DESC limit " + i2 + " OFFSET 0", null);
        AppMethodBeat.o(117319);
        return rawQuery;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0089  */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tencent.mm.storage.ca> J(java.lang.String r13, long r14, long r16) {
        /*
        // Method dump skipped, instructions count: 153
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.cb.J(java.lang.String, long, long):java.util.List");
    }

    private static String biM(String str) {
        AppMethodBeat.i(177115);
        long aEk = ((l) g.af(l.class)).aTq().aEk(str);
        if (aEk > 0) {
            String str2 = " createTime > " + aEk + " AND ";
            AppMethodBeat.o(177115);
            return str2;
        }
        AppMethodBeat.o(177115);
        return "";
    }
}
