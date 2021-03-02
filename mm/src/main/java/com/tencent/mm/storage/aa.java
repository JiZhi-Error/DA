package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class aa extends MAutoStorage<z> {
    public static final String[] INDEX_CREATE = {"CREATE  INDEX IF NOT EXISTS msg_id_index ON BizTimeLineInfo ( msgId ) ", "CREATE  INDEX IF NOT EXISTS  has_show_talker_index ON BizTimeLineInfo ( hasShow,talker ) ", "CREATE  INDEX IF NOT EXISTS  has_show_place_top_index ON BizTimeLineInfo ( hasShow,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_place_top_index ON BizTimeLineInfo ( orderFlag,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  talker_id_order_flag_index ON BizTimeLineInfo ( talkerId,orderFlag ) "};
    public static final String[] NQs = {"CREATE  INDEX IF NOT EXISTS  biz_status_talker_index ON BizTimeLineInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  biz_msg_svr_id_index ON BizTimeLineInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS  biz_talker_index ON BizTimeLineInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_status_index ON BizTimeLineInfo ( orderFlag,status ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_has_show_index ON BizTimeLineInfo ( orderFlag,hasShow ) ", "CREATE  INDEX IF NOT EXISTS  biz_client_msg_id_index ON BizTimeLineInfo ( bizClientMsgId ) ", "CREATE  INDEX IF NOT EXISTS  is_read_order_flag_index ON BizTimeLineInfo ( isRead,orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  is_read_msg_id_index ON BizTimeLineInfo ( isRead,msgId ) ", "CREATE  INDEX IF NOT EXISTS  biz_type_order_flag_isread_index ON BizTimeLineInfo ( type,orderFlag,isRead ) ", "CREATE  INDEX IF NOT EXISTS  biz_type_is_read_index ON BizTimeLineInfo ( type,isRead ) ", "CREATE  INDEX IF NOT EXISTS  biz_create_time_index ON BizTimeLineInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  recommend_card_id_index ON BizTimeLineInfo ( recommendCardId ) "};
    private static final f<Long, Boolean> NQu = new com.tencent.mm.memory.a.c(30);
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(z.info, "BizTimeLineInfo")};
    private AtomicLong NQA = new AtomicLong(-5000000);
    private final MStorageEvent<c, a> NQt = new MStorageEvent<c, a>() {
        /* class com.tencent.mm.storage.aa.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(c cVar, a aVar) {
            AppMethodBeat.i(124609);
            cVar.a(aa.this, aVar);
            AppMethodBeat.o(124609);
        }
    };
    public boolean NQv = true;
    private AtomicLong NQw = new AtomicLong(10);
    private long NQx = 10;
    private long NQy;
    private final long NQz = -5000000;
    public final h iFy;

    public static class a {
        public b NQE = b.INSERT;
        public boolean NQF = false;
        public List<z> list;
        public z psm;
        public String talker;
    }

    public interface c {
        void a(Object obj, a aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(z zVar) {
        AppMethodBeat.i(124654);
        boolean b2 = b(zVar, true);
        AppMethodBeat.o(124654);
        return b2;
    }

    static {
        AppMethodBeat.i(124655);
        AppMethodBeat.o(124655);
    }

    public enum b {
        INSERT,
        DELETE,
        UPDATE,
        RE_SORT;

        public static b valueOf(String str) {
            AppMethodBeat.i(124619);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(124619);
            return bVar;
        }

        static {
            AppMethodBeat.i(124620);
            AppMethodBeat.o(124620);
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(124621);
        if (this.NQt.event(aVar)) {
            this.NQt.doNotify();
        }
        AppMethodBeat.o(124621);
    }

    public final void a(c cVar, Looper looper) {
        AppMethodBeat.i(124622);
        this.NQt.add(cVar, looper);
        AppMethodBeat.o(124622);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(124623);
        this.NQt.remove(cVar);
        AppMethodBeat.o(124623);
    }

    public aa(h hVar) {
        super(hVar, z.info, "BizTimeLineInfo", INDEX_CREATE);
        AppMethodBeat.i(124624);
        this.iFy = hVar;
        gAU();
        AppMethodBeat.o(124624);
    }

    public final boolean B(z zVar) {
        AppMethodBeat.i(124625);
        boolean b2 = b(zVar, true);
        AppMethodBeat.o(124625);
        return b2;
    }

    public final boolean b(z zVar, boolean z) {
        AppMethodBeat.i(212338);
        boolean insertNotify = super.insertNotify(zVar, false);
        if (z) {
            MY(zVar.gAo());
        }
        a aVar = new a();
        aVar.talker = zVar.field_talker;
        aVar.psm = zVar;
        aVar.NQE = b.INSERT;
        a(aVar);
        AppMethodBeat.o(212338);
        return insertNotify;
    }

    public final boolean C(z zVar) {
        AppMethodBeat.i(124626);
        boolean updateNotify = super.updateNotify(zVar, false, "msgSvrId");
        a aVar = new a();
        aVar.talker = zVar.field_talker;
        aVar.psm = zVar;
        aVar.NQE = b.UPDATE;
        a(aVar);
        AppMethodBeat.o(124626);
        return updateNotify;
    }

    public final boolean c(z zVar, boolean z) {
        AppMethodBeat.i(212339);
        boolean updateNotify = super.updateNotify(zVar, false, "msgId");
        if (z) {
            a aVar = new a();
            aVar.talker = zVar.field_talker;
            aVar.psm = zVar;
            aVar.NQE = b.UPDATE;
            a(aVar);
        }
        AppMethodBeat.o(212339);
        return updateNotify;
    }

    public final boolean D(z zVar) {
        AppMethodBeat.i(212340);
        ContentValues contentValues = new ContentValues();
        contentValues.put("content", zVar.field_content);
        contentValues.put("createTime", Long.valueOf(zVar.field_createTime));
        int update = this.iFy.update("BizTimeLineInfo", contentValues, " msgId = ?", new String[]{new StringBuilder().append(zVar.field_msgId).toString()});
        if (update > 0) {
            a aVar = new a();
            aVar.talker = zVar.field_talker;
            aVar.list = new LinkedList();
            aVar.list.add(zVar);
            aVar.NQE = b.UPDATE;
            a(aVar);
        }
        if (update > 0) {
            AppMethodBeat.o(212340);
            return true;
        }
        AppMethodBeat.o(212340);
        return false;
    }

    public final void biW(String str) {
        int i2;
        AppMethodBeat.i(124627);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(124627);
            return;
        }
        if (((l) g.af(l.class)).aSN().Kn(str).arE()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        this.iFy.execSQL("BizTimeLineInfo", "update BizTimeLineInfo set placeTop = " + i2 + " where status > 4 and talker = '" + str + "'");
        this.iFy.execSQL("BizTimeLineInfo", "update BizTimeLineInfo set placeTop = " + i2 + " where status < 4 and talker = '" + str + "'");
        z gAM = gAM();
        if (gAM != null && str.equals(gAM.field_talker)) {
            gAM.field_placeTop = i2;
            super.updateNotify(gAM, false, "msgSvrId");
        }
        a aVar = new a();
        aVar.NQE = b.UPDATE;
        a(aVar);
        AppMethodBeat.o(124627);
    }

    public final boolean iD(List<z> list) {
        AppMethodBeat.i(212341);
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(212341);
            return false;
        }
        long beginTransaction = this.iFy.beginTransaction(Thread.currentThread().getId());
        for (z zVar : list) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("orderFlag", Long.valueOf(zVar.field_orderFlag));
            contentValues.put("bitFlag", Integer.valueOf(zVar.field_bitFlag));
            contentValues.put("status", (Integer) 3);
            if (zVar.NQl) {
                contentValues.put("hasShow", (Integer) 0);
                contentValues.put("isRead", (Integer) 0);
            }
            contentValues.put("rankSessionId", zVar.field_rankSessionId);
            this.iFy.update("BizTimeLineInfo", contentValues, "msgId = ?", new String[]{new StringBuilder().append(zVar.field_msgId).toString()});
        }
        Log.i("MicroMsg.BizTimeLineInfoStorage", "batResortBizTimeLineInfo ret=%d", Integer.valueOf(this.iFy.endTransaction(beginTransaction)));
        com.tencent.f.h.RTc.aV(new Runnable() {
            /* class com.tencent.mm.storage.aa.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(212336);
                a aVar = new a();
                aVar.NQE = b.RE_SORT;
                aa.this.a(aVar);
                AppMethodBeat.o(212336);
            }
        });
        AppMethodBeat.o(212341);
        return true;
    }

    public final z biX(String str) {
        AppMethodBeat.i(212342);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(212342);
            return null;
        }
        z zVar = new z();
        Cursor query = this.iFy.query("BizTimeLineInfo", null, "bizClientMsgId=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        if (query.moveToFirst()) {
            zVar.convertFrom(query);
            query.close();
            AppMethodBeat.o(212342);
            return zVar;
        }
        query.close();
        AppMethodBeat.o(212342);
        return null;
    }

    public final z ML(long j2) {
        AppMethodBeat.i(124629);
        z R = R(j2, "orderFlag");
        AppMethodBeat.o(124629);
        return R;
    }

    public final z MM(long j2) {
        AppMethodBeat.i(261600);
        z R = R(j2, "msgId");
        AppMethodBeat.o(261600);
        return R;
    }

    public final z R(long j2, String str) {
        AppMethodBeat.i(124631);
        z zVar = new z();
        Cursor query = this.iFy.query("BizTimeLineInfo", null, str + "=?", new String[]{String.valueOf(j2)}, null, null, null, 2);
        if (query.moveToFirst()) {
            zVar.convertFrom(query);
            query.close();
            AppMethodBeat.o(124631);
            return zVar;
        }
        query.close();
        AppMethodBeat.o(124631);
        return null;
    }

    public final List<z> aU(int i2, long j2) {
        AppMethodBeat.i(124632);
        List<z> o = o(this.iFy.query("BizTimeLineInfo", null, "orderFlag<?", new String[]{String.valueOf(j2)}, null, null, "orderFlag DESC limit ".concat(String.valueOf(i2))));
        AppMethodBeat.o(124632);
        return o;
    }

    public final List<z> MN(long j2) {
        AppMethodBeat.i(212344);
        List<z> o = o(this.iFy.query("BizTimeLineInfo", null, "orderFlag>?", new String[]{String.valueOf(j2)}, null, null, "orderFlag DESC limit 5"));
        AppMethodBeat.o(212344);
        return o;
    }

    public final List<z> ajT(int i2) {
        AppMethodBeat.i(124633);
        List<z> o = o(this.iFy.query("BizTimeLineInfo", null, null, null, null, null, "orderFlag DESC limit ".concat(String.valueOf(i2))));
        AppMethodBeat.o(124633);
        return o;
    }

    public final List<z> MO(long j2) {
        AppMethodBeat.i(124634);
        List<z> o = o(this.iFy.query("BizTimeLineInfo", null, "orderFlag>=?", new String[]{String.valueOf(j2)}, null, null, "orderFlag DESC"));
        AppMethodBeat.o(124634);
        return o;
    }

    public final List<z> kL(int i2, int i3) {
        AppMethodBeat.i(212345);
        List<z> o = o(this.iFy.query("BizTimeLineInfo", null, "type=?", new String[]{String.valueOf(i2)}, null, null, "orderFlag DESC limit ".concat(String.valueOf(i3))));
        AppMethodBeat.o(212345);
        return o;
    }

    public final z gAL() {
        z zVar = null;
        AppMethodBeat.i(212346);
        Cursor rawQuery = this.iFy.rawQuery(String.format("SELECT * FROM %s WHERE %s = %d order by %s  DESC limit 1", "BizTimeLineInfo", "type", 637534257, "orderFlag"), null);
        if (rawQuery.moveToFirst()) {
            zVar = new z();
            zVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(212346);
        return zVar;
    }

    public final List<z> ajU(int i2) {
        AppMethodBeat.i(212347);
        long currentTimeMillis = System.currentTimeMillis();
        List<z> o = o(this.iFy.query("BizTimeLineInfo", null, "isRead=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO}, null, null, "orderFlag DESC limit ".concat(String.valueOf(i2))));
        Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnReadList cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(212347);
        return o;
    }

    public final List<z> aV(int i2, long j2) {
        AppMethodBeat.i(212348);
        long currentTimeMillis = System.currentTimeMillis();
        String str = "SELECT * FROM BizTimeLineInfo where  isRead = 0 and orderFlag >= " + (gAS() << 32) + " and createTime >= " + j2 + " and bitFlag&1073741824 = 0 order by orderFlag ASC limit " + i2;
        Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnReadListNew sql = %s", str);
        List<z> o = o(this.iFy.rawQuery(str, null));
        int size = o.size();
        if (size < i2) {
            String str2 = "";
            if (size > 0) {
                String str3 = "and msgId not in (";
                int i3 = 0;
                while (i3 < size) {
                    str3 = str3 + (i3 > 0 ? "," : "") + o.get(i3).field_msgId;
                    i3++;
                }
                str2 = str3 + ")";
            }
            String str4 = "SELECT * FROM BizTimeLineInfo where  isRead = 0 " + str2 + " order by orderFlag DESC limit " + (i2 - size);
            Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnReadListNew sql2 = %s", str4);
            o.addAll(o(this.iFy.rawQuery(str4, null)));
        }
        Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnReadListNew cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(212348);
        return o;
    }

    public static List<z> o(Cursor cursor) {
        AppMethodBeat.i(124635);
        LinkedList linkedList = new LinkedList();
        while (cursor.moveToNext()) {
            z zVar = new z();
            zVar.convertFrom(cursor);
            linkedList.add(zVar);
        }
        cursor.close();
        AppMethodBeat.o(124635);
        return linkedList;
    }

    public final z gAM() {
        z zVar = null;
        AppMethodBeat.i(124636);
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1", null);
        if (rawQuery.moveToFirst()) {
            zVar = new z();
            zVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(124636);
        return zVar;
    }

    public final z gAN() {
        z zVar = null;
        AppMethodBeat.i(212349);
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo order by createTime DESC limit 1", null);
        if (rawQuery.moveToFirst()) {
            zVar = new z();
            zVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(212349);
        return zVar;
    }

    public final long gAO() {
        AppMethodBeat.i(212350);
        Cursor rawQuery = this.iFy.rawQuery("SELECT createTime FROM BizTimeLineInfo order by createTime DESC limit 1", null);
        long j2 = 0;
        if (rawQuery.moveToFirst()) {
            j2 = rawQuery.getLong(0);
        }
        rawQuery.close();
        AppMethodBeat.o(212350);
        return j2;
    }

    public final z MP(long j2) {
        z zVar = null;
        AppMethodBeat.i(124637);
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo where talkerId = " + j2 + "  order by orderFlag DESC limit 1", null);
        if (rawQuery.moveToFirst()) {
            zVar = new z();
            zVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(124637);
        return zVar;
    }

    public final z gAP() {
        z zVar = null;
        AppMethodBeat.i(212351);
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo order by orderFlag asc limit 1", null);
        if (rawQuery.moveToFirst()) {
            zVar = new z();
            zVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(212351);
        return zVar;
    }

    public final void MQ(long j2) {
        AppMethodBeat.i(124638);
        if (MR(j2) > 2000) {
            z ML = ML(j2);
            if (ML != null) {
                ML.field_status = 4;
                C(ML);
            }
            AppMethodBeat.o(124638);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = -4294967296L & j2;
        this.iFy.execSQL("BizTimeLineInfo", "update BizTimeLineInfo set status = 4 where orderFlag >= " + j3 + " and status > 4");
        this.iFy.execSQL("BizTimeLineInfo", "update BizTimeLineInfo set status = 4 where orderFlag >= " + j3 + " and status < 4");
        Log.d("MicroMsg.BizTimeLineInfoStorage", "resetUnread cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        NQu.x(Long.valueOf(j2), Boolean.TRUE);
        AppMethodBeat.o(124638);
    }

    public final int MR(long j2) {
        int i2;
        AppMethodBeat.i(124639);
        Boolean bool = NQu.get(Long.valueOf(j2));
        if (bool == null || !bool.booleanValue()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = -4294967296L & j2;
            Cursor rawQuery = this.iFy.rawQuery("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + j3 + " and status > 4", null);
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            } else {
                i2 = 0;
            }
            rawQuery.close();
            Cursor rawQuery2 = this.iFy.rawQuery("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + j3 + " and status < 4", null);
            if (rawQuery2.moveToFirst()) {
                i2 += rawQuery2.getInt(0);
            }
            rawQuery2.close();
            if (i2 > 2000) {
                i2 = 0;
            }
            if (i2 == 0) {
                NQu.x(Long.valueOf(j2), Boolean.TRUE);
            }
            Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnread cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(124639);
            return i2;
        }
        AppMethodBeat.o(124639);
        return 0;
    }

    public final int MS(long j2) {
        int i2 = 0;
        AppMethodBeat.i(212352);
        Cursor rawQuery = this.iFy.rawQuery("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= ".concat(String.valueOf(j2 << 32)), null);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(212352);
        return i2;
    }

    public final int MT(long j2) {
        int i2 = 0;
        AppMethodBeat.i(212353);
        Cursor rawQuery = this.iFy.rawQuery("SELECT count(*) FROM BizTimeLineInfo where type = 620757041 and orderFlag < " + (j2 << 32) + " and orderFlag >= " + ((j2 - 1) << 32), null);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(212353);
        return i2;
    }

    public final z MU(long j2) {
        AppMethodBeat.i(212354);
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo where orderFlag < " + (j2 << 32) + " ORDER BY orderFlag desc LIMIT 1 ", null);
        z zVar = new z();
        if (rawQuery.moveToFirst()) {
            zVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(212354);
            return zVar;
        }
        rawQuery.close();
        AppMethodBeat.o(212354);
        return null;
    }

    public final void gAQ() {
        AppMethodBeat.i(124640);
        z gAM = gAM();
        if (gAM == null) {
            AppMethodBeat.o(124640);
            return;
        }
        MV(gAM.field_orderFlag);
        AppMethodBeat.o(124640);
    }

    public final void MV(final long j2) {
        AppMethodBeat.i(124641);
        com.tencent.mm.co.g.hio().h(new com.tencent.mm.vending.c.a<Void, Void>() {
            /* class com.tencent.mm.storage.aa.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Void r11) {
                AppMethodBeat.i(124610);
                long currentTimeMillis = System.currentTimeMillis();
                int MW = aa.this.MW(j2);
                if (MW > 2000 || MW <= 0) {
                    AppMethodBeat.o(124610);
                } else {
                    Log.d("MicroMsg.BizTimeLineInfoStorage", "resetUnShow ret = %b, cost = %d", Boolean.valueOf(aa.this.iFy.execSQL("BizTimeLineInfo", "update BizTimeLineInfo set hasShow = 1 where orderFlag >= " + (j2 & -4294967296L) + " and hasShow < 1 ")), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(124610);
                }
                return null;
            }
        }).b(new com.tencent.mm.vending.c.a<Void, Void>() {
            /* class com.tencent.mm.storage.aa.AnonymousClass8 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Void r4) {
                AppMethodBeat.i(124617);
                a aVar = new a();
                aVar.NQE = b.UPDATE;
                aVar.NQF = true;
                aa.this.a(aVar);
                AppMethodBeat.o(124617);
                return null;
            }
        });
        AppMethodBeat.o(124641);
    }

    public final int gAR() {
        AppMethodBeat.i(124642);
        z gAM = gAM();
        if (gAM == null) {
            AppMethodBeat.o(124642);
            return 0;
        }
        int MW = MW(gAM.field_orderFlag);
        AppMethodBeat.o(124642);
        return MW;
    }

    public final int MW(long j2) {
        int i2;
        AppMethodBeat.i(124643);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.iFy.rawQuery("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (-4294967296L & j2) + " and hasShow < 1 ", null);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        } else {
            i2 = 0;
        }
        Log.d("MicroMsg.BizTimeLineInfoStorage", "getUnShowCount count = %d,cost = %d", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        rawQuery.close();
        if (i2 > 2000) {
            if (this.NQy == this.NQw.longValue()) {
                gAT();
            }
            AppMethodBeat.o(124643);
            return 0;
        }
        AppMethodBeat.o(124643);
        return i2;
    }

    public final boolean aEn(String str) {
        AppMethodBeat.i(124644);
        z zVar = new z();
        zVar.field_talker = str;
        boolean delete = super.delete(zVar, false, "talker");
        a aVar = new a();
        aVar.talker = zVar.field_talker;
        aVar.psm = zVar;
        aVar.NQE = b.DELETE;
        a(aVar);
        AppMethodBeat.o(124644);
        return delete;
    }

    public final void MX(long j2) {
        AppMethodBeat.i(124645);
        z zVar = new z();
        zVar.field_msgId = j2;
        super.delete(zVar, false, "msgId");
        a aVar = new a();
        aVar.NQE = b.DELETE;
        a(aVar);
        AppMethodBeat.o(124645);
    }

    private synchronized void MY(long j2) {
        AppMethodBeat.i(124646);
        this.NQx = Math.max(j2, this.NQx);
        AppMethodBeat.o(124646);
    }

    public final synchronized long gAS() {
        return this.NQx;
    }

    public final synchronized long gAo() {
        long longValue;
        AppMethodBeat.i(124647);
        longValue = this.NQw.longValue();
        AppMethodBeat.o(124647);
        return longValue;
    }

    public final synchronized long gAT() {
        long incrementAndGet;
        AppMethodBeat.i(124648);
        incrementAndGet = this.NQw.incrementAndGet();
        AppMethodBeat.o(124648);
        return incrementAndGet;
    }

    private synchronized void gAU() {
        AppMethodBeat.i(124649);
        this.NQx = gAV() >> 32;
        if (this.NQx < 10) {
            this.NQx = 10;
        }
        z gAM = gAM();
        if (gAM == null) {
            Log.w("MicroMsg.BizTimeLineInfoStorage", "initGroupId is null, id %d", Long.valueOf(this.NQx));
            AppMethodBeat.o(124649);
        } else {
            if (gAM.field_status == 4) {
                this.NQw.set(this.NQx + 1);
            } else {
                this.NQw.set(this.NQx);
            }
            this.NQy = this.NQw.longValue();
            Log.i("MicroMsg.BizTimeLineInfoStorage", "initGroupId id %d/%d, status %d", Long.valueOf(this.NQw.longValue()), Long.valueOf(this.NQx), Integer.valueOf(gAM.field_status));
            AppMethodBeat.o(124649);
        }
    }

    public final int cZm() {
        int i2 = 0;
        AppMethodBeat.i(124650);
        Cursor rawQuery = this.iFy.rawQuery("SELECT count(*) FROM BizTimeLineInfo", null);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(124650);
        return i2;
    }

    private synchronized long gAV() {
        long j2;
        AppMethodBeat.i(124651);
        Cursor rawQuery = this.iFy.rawQuery("select max(orderFlag) from BizTimeLineInfo", null, 2);
        j2 = 0;
        if (rawQuery.moveToFirst()) {
            j2 = rawQuery.getLong(0);
            rawQuery.close();
        }
        AppMethodBeat.o(124651);
        return j2;
    }

    public final synchronized long gAW() {
        long incrementAndGet;
        z zVar = null;
        synchronized (this) {
            AppMethodBeat.i(124652);
            if (this.NQA.longValue() == -5000000) {
                Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo where type=620757041 or type=637534257 order by msgId DESC limit 1", null);
                if (rawQuery.moveToFirst()) {
                    zVar = new z();
                    zVar.convertFrom(rawQuery);
                }
                rawQuery.close();
                if (zVar != null) {
                    this.NQA.set(zVar.field_msgId);
                }
            }
            incrementAndGet = this.NQA.incrementAndGet();
            AppMethodBeat.o(124652);
        }
        return incrementAndGet;
    }

    public final z ajV(int i2) {
        z zVar;
        z zVar2 = null;
        AppMethodBeat.i(212355);
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1 offset ".concat(String.valueOf(i2)), null);
        if (rawQuery.moveToFirst()) {
            zVar = new z();
            zVar.convertFrom(rawQuery);
        } else {
            zVar = null;
        }
        rawQuery.close();
        if (zVar == null || zVar.gAo() < gAS()) {
            Cursor rawQuery2 = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo where orderFlag > " + (gAS() << 32) + " order by orderFlag asc limit 1", null);
            if (rawQuery2.moveToFirst()) {
                zVar2 = new z();
                zVar2.convertFrom(rawQuery2);
            }
            rawQuery2.close();
            zVar = zVar2;
        }
        AppMethodBeat.o(212355);
        return zVar;
    }

    public final z MZ(long j2) {
        z zVar = null;
        AppMethodBeat.i(124653);
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo where type=620757041 and orderFlag > ".concat(String.valueOf(j2)), null);
        if (rawQuery.moveToFirst()) {
            zVar = new z();
            zVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(124653);
        return zVar;
    }

    public final z ajW(int i2) {
        z zVar = null;
        AppMethodBeat.i(212356);
        Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1 offset ".concat(String.valueOf(i2)), null);
        if (rawQuery.moveToFirst()) {
            zVar = new z();
            zVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(212356);
        return zVar;
    }

    public final void ajX(int i2) {
        AppMethodBeat.i(212357);
        Log.i("MicroMsg.BizTimeLineInfoStorage", "deleteByType type:%d ret:%b", 637534257, Boolean.valueOf(this.iFy.execSQL("BizTimeLineInfo", String.format("DELETE FROM %s WHERE %s = %d and isRead = %d", "BizTimeLineInfo", "type", 637534257, Integer.valueOf(i2)))));
        a aVar = new a();
        aVar.NQE = b.DELETE;
        a(aVar);
        AppMethodBeat.o(212357);
    }

    public final z biY(String str) {
        z zVar = null;
        AppMethodBeat.i(212358);
        if (str == null) {
            AppMethodBeat.o(212358);
        } else {
            Cursor rawQuery = this.iFy.rawQuery("SELECT * FROM BizTimeLineInfo where type=620757041 and recommendCardId='" + str + "'", null);
            if (rawQuery.moveToFirst()) {
                zVar = new z();
                zVar.convertFrom(rawQuery);
            }
            rawQuery.close();
            AppMethodBeat.o(212358);
        }
        return zVar;
    }

    static /* synthetic */ int ajY(int i2) {
        if (i2 <= 5) {
            return 0;
        }
        if (i2 <= 10) {
            return 1;
        }
        if (i2 <= 20) {
            return 2;
        }
        if (i2 <= 40) {
            return 3;
        }
        return 4;
    }
}
