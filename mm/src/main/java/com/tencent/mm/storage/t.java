package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.j;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class t extends e {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS bizchatmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT, bizChatId INTEGER DEFAULT -1, bizChatUserId TEXT ) ", "CREATE INDEX IF NOT EXISTS  bizmessageChatIdIndex ON bizchatmessage ( bizChatId )", "CREATE INDEX IF NOT EXISTS  bizmessageSvrIdIndex ON bizchatmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  bizmessageTalkerIndex ON bizchatmessage ( talker )", "CREATE INDEX IF NOT EXISTS  bizmessageTalerStatusIndex ON bizchatmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTimeIndex ON bizchatmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageCreateTaklerTimeIndex ON bizchatmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageBizChatIdTypeCreateTimeIndex ON bizchatmessage ( bizChatId,type,createTime )", "CREATE INDEX IF NOT EXISTS  bizmessageSendCreateTimeIndex ON bizchatmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  bizchatmessageTalkerTypeIndex ON bizchatmessage ( talker,type )"};

    public t(i iVar) {
        super(iVar);
        AppMethodBeat.i(124576);
        e(getDB(), "bizchatmessage");
        a(new i.b(16, "bizchatmessage", i.b.a(2500001, 3000000, 99000001, 102000000)));
        AppMethodBeat.o(124576);
    }

    @Override // com.tencent.mm.storage.e
    public final String avu(String str) {
        AppMethodBeat.i(124577);
        Assert.assertTrue(str != null && str.length() > 0);
        if (g.DQ(str)) {
            AppMethodBeat.o(124577);
            return "bizchatmessage";
        }
        AppMethodBeat.o(124577);
        return null;
    }

    private static String bW(String str, long j2) {
        AppMethodBeat.i(124578);
        String str2 = " bizChatId= " + j2 + " AND talker= '" + str + "'";
        AppMethodBeat.o(124578);
        return str2;
    }

    public final ca bX(String str, long j2) {
        AppMethodBeat.i(124579);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(124579);
            return null;
        }
        ca caVar = new ca();
        Cursor rawQuery = getDB().rawQuery("select * from " + aEO(str) + " where" + bW(str, j2) + "order by createTime DESC limit 1", null);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            caVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(124579);
        return caVar;
    }

    public final List<ca> s(String str, long j2, int i2) {
        AppMethodBeat.i(124580);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = getDB().rawQuery("SELECT * FROM " + aEO(str) + " WHERE" + bW(str, j2) + "AND isSend = 0 ORDER BY createTime DESC LIMIT " + i2, null);
        if (rawQuery.moveToFirst()) {
            while (!rawQuery.isAfterLast()) {
                ca caVar = new ca();
                caVar.convertFrom(rawQuery);
                rawQuery.moveToNext();
                if (caVar.isText()) {
                    arrayList.add(caVar);
                }
            }
        }
        rawQuery.close();
        AppMethodBeat.o(124580);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.storage.e
    public final boolean a(ca caVar, bp.b bVar) {
        AppMethodBeat.i(124581);
        if (caVar == null) {
            Log.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:message == null");
            AppMethodBeat.o(124581);
            return false;
        }
        caVar.yG(-1);
        if (bVar != null) {
            if (g.DQ(caVar.field_talker)) {
                if (Util.isNullOrNil(bVar.iEz)) {
                    Log.w("MicroMsg.BizChatMessageStorage", "EnterpriseChat msgSourceValue error: %s", caVar.fqK);
                    AppMethodBeat.o(124581);
                    return false;
                }
                c cVar = new c();
                cVar.field_bizChatServId = bVar.iEz;
                cVar.field_brandUserName = caVar.field_talker;
                if (!Util.isNullOrNil(bVar.iEA)) {
                    cVar.field_chatVersion = Util.getInt(bVar.iEA, -1);
                }
                if (!Util.isNullOrNil(bVar.iEy)) {
                    cVar.field_chatType = Util.getInt(bVar.iEy, Util.getInt(bVar.iEx, j.BIZ_CHAT_TYPE_UNKNOWN.iQq));
                } else if (!Util.isNullOrNil(bVar.iEx)) {
                    cVar.field_chatType = Util.getInt(bVar.iEx, j.BIZ_CHAT_TYPE_UNKNOWN.iQq);
                }
                Log.d("MicroMsg.BizChatMessageStorage", "bizchatId:%s,userId:%s", bVar.iEz, bVar.userId);
                c e2 = e.e(cVar);
                if (e2 != null) {
                    caVar.yG(e2.field_bizChatLocalId);
                    caVar.field_bizChatUserId = Util.nullAsNil(bVar.userId);
                    caVar.fqR = true;
                    if (bVar.iEC.equals("1")) {
                        caVar.nv(1);
                    }
                    caVar.CC(bVar.iEr);
                    if (!(caVar.field_isSend == 1 || bVar.userId == null)) {
                        if (bVar.userId.equals(ag.bal().fC(caVar.field_talker))) {
                            caVar.nv(1);
                        }
                    }
                    if (!Util.isNullOrNil(bVar.userId)) {
                        k kVar = new k();
                        kVar.field_userId = bVar.userId;
                        kVar.field_userName = bVar.iEB;
                        kVar.field_brandUserName = caVar.field_talker;
                        ag.bal().c(kVar);
                    }
                } else {
                    Log.w("MicroMsg.BizChatMessageStorage", "dealMsgSourceValue:bizChatInfo == null!");
                    AppMethodBeat.o(124581);
                    return false;
                }
            } else if (!Util.isNullOrNil(bVar.iEz)) {
                Log.i("MicroMsg.BizChatMessageStorage", "is EnterpriseChat but contact not ready");
                AppMethodBeat.o(124581);
                return false;
            }
        }
        AppMethodBeat.o(124581);
        return true;
    }

    public final List<ca> b(String str, long j2, long j3, boolean z) {
        String str2;
        AppMethodBeat.i(124582);
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid, limit = 10");
            AppMethodBeat.o(124582);
            return null;
        }
        long aR = this.NOL.aR(str, j3);
        if (aR == 0) {
            Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, msg is null");
            AppMethodBeat.o(124582);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            str2 = "select * from " + aEO(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bW(str, j2) + "AND " + this.NOL.eiN() + " AND createTime > " + aR + "  order by createTime ASC limit 10";
        } else {
            str2 = "select * from " + aEO(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bW(str, j2) + "AND " + this.NOL.eiN() + " AND createTime < " + aR + "  order by createTime DESC limit 10";
        }
        Cursor rawQuery = getDB().rawQuery(str2, null);
        if (rawQuery.moveToFirst()) {
            while (!rawQuery.isAfterLast()) {
                ca caVar = new ca();
                caVar.convertFrom(rawQuery);
                rawQuery.moveToNext();
                if (z) {
                    arrayList.add(caVar);
                } else {
                    arrayList.add(0, caVar);
                }
            }
        }
        rawQuery.close();
        Log.i("MicroMsg.BizChatMessageStorage", "getBizChatImgVideoMessage spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(124582);
        return arrayList;
    }

    public final Cursor bY(String str, long j2) {
        AppMethodBeat.i(124583);
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(124583);
            return null;
        }
        String str2 = "select * from " + aEO(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bW(str, j2) + "AND " + this.NOL.eiO() + "  order by createTime";
        Cursor rawQuery = getDB().rawQuery(str2, null);
        Log.d("MicroMsg.BizChatMessageStorage", "all time: %d, sql: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), str2);
        AppMethodBeat.o(124583);
        return rawQuery;
    }

    public final Cursor b(String str, long j2, int i2, int i3) {
        AppMethodBeat.i(124584);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(124584);
            return null;
        }
        Cursor rawQuery = getDB().rawQuery("select * from ( select * from " + aEO(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + biM(str) + bW(str, j2) + "AND " + this.NOL.eiN() + " order by createTime DESC limit " + i3 + " OFFSET " + i2 + ") order by createTime ASC ", null);
        AppMethodBeat.o(124584);
        return rawQuery;
    }

    public final Cursor d(String str, long j2, long j3, long j4) {
        AppMethodBeat.i(124585);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.BizChatMessageStorage", "getImgMessage fail, argument is invalid");
            AppMethodBeat.o(124585);
            return null;
        }
        Cursor rawQuery = getDB().rawQuery("select * from " + aEO(str) + "  INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  where" + bW(str, j2) + "AND " + this.NOL.eiN() + " AND createTime >= " + j3 + " AND createTime< " + j4 + " order by createTime ASC", null);
        AppMethodBeat.o(124585);
        return rawQuery;
    }

    public final int bZ(String str, long j2) {
        AppMethodBeat.i(124586);
        Log.w("MicroMsg.BizChatMessageStorage", "deleteByTalker :%s  stack:%s", str, MMStack.getStack(true));
        mO(aEO(str), bW(str, j2));
        int delete = getDB().delete(aEO(str), bW(str, j2), null);
        if (delete != 0) {
            this.NOL.doNotify("delete_talker ".concat(String.valueOf(str)));
            i.c cVar = new i.c(str, "delete", null, delete, (byte) 0);
            cVar.zqq = -1;
            a(cVar);
        }
        AppMethodBeat.o(124586);
        return delete;
    }

    public final int aEE(String str) {
        AppMethodBeat.i(124587);
        Log.w("MicroMsg.BizChatMessageStorage", "not attention  deleteEnterpriseMsgByTalker :%s  stack:%s", str, MMStack.getStack(true));
        String str2 = "talker= '" + str + "'";
        mO(aEO(str), str2);
        int delete = getDB().delete(aEO(str), str2, null);
        if (delete != 0) {
            this.NOL.doNotify("delete_talker ".concat(String.valueOf(str)));
            i.c cVar = new i.c(str, "delete", null, delete, (byte) 0);
            cVar.zqq = -1;
            a(cVar);
        }
        AppMethodBeat.o(124587);
        return delete;
    }

    public final Cursor ca(String str, long j2) {
        AppMethodBeat.i(124588);
        Cursor query = getDB().query(aEO(str), null, bW(str, j2), null, null, null, "createTime ASC ");
        AppMethodBeat.o(124588);
        return query;
    }

    public final Cursor t(String str, long j2, int i2) {
        AppMethodBeat.i(124589);
        String str2 = "SELECT * FROM ( SELECT * FROM " + aEO(str) + " WHERE" + bW(str, j2) + "ORDER BY createTime DESC LIMIT " + i2 + ") ORDER BY createTime ASC";
        Log.i("MicroMsg.BizChatMessageStorage", "getBizInitCursor talker:%s, bizChatId:%s, limitCount:%s, sql:[%s]", str, Long.valueOf(j2), Integer.valueOf(i2), str2);
        Cursor rawQuery = getDB().rawQuery(str2, null);
        AppMethodBeat.o(124589);
        return rawQuery;
    }

    public final int cb(String str, long j2) {
        AppMethodBeat.i(124590);
        if (str == null) {
            Log.w("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable talker:%s,bizChatId:%s", str, Long.valueOf(j2));
            AppMethodBeat.o(124590);
            return -1;
        }
        a Al = ag.bak().Al(j2);
        if (Al.field_msgCount != 0) {
            int i2 = Al.field_msgCount;
            AppMethodBeat.o(124590);
            return i2;
        }
        Log.i("MicroMsg.BizChatMessageStorage", "geBiztMsgCount contactMsgCount is 0 ,go normal %s", str);
        int cc = cc(str, j2);
        AppMethodBeat.o(124590);
        return cc;
    }

    public final int cc(String str, long j2) {
        int i2 = 0;
        AppMethodBeat.i(124591);
        String str2 = "SELECT COUNT(*) FROM " + aEO(str) + " WHERE " + bW(str, j2);
        Log.v("MicroMsg.BizChatMessageStorage", "getBizMsgCountFromMsgTable sql:[%s]", str2);
        Cursor rawQuery = getDB().rawQuery(str2, null);
        if (rawQuery.moveToLast()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(124591);
        return i2;
    }

    public final int cd(String str, long j2) {
        int i2 = 0;
        AppMethodBeat.i(124592);
        Cursor rawQuery = getDB().rawQuery("SELECT COUNT(*) FROM " + this.NOL.aEO(str) + " WHERE " + biM(str) + bW(str, j2) + "AND " + this.NOL.eiN(), null);
        if (rawQuery.moveToLast()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(124592);
        return i2;
    }

    public final int M(String str, long j2, long j3) {
        int i2 = 0;
        AppMethodBeat.i(124593);
        ca Hb = this.NOL.Hb(j3);
        if (Hb.field_msgId == 0) {
            Log.e("MicroMsg.BizChatMessageStorage", "getCountEarlyThan fail, msg does not exist");
            AppMethodBeat.o(124593);
        } else {
            Cursor rawQuery = getDB().rawQuery("SELECT COUNT(*) FROM " + aEO(str) + " INDEXED BY bizmessageBizChatIdTypeCreateTimeIndex  WHERE " + biM(str) + bW(str, j2) + "AND " + this.NOL.eiN() + " AND createTime < " + Hb.field_createTime, null);
            if (rawQuery.moveToLast()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.o(124593);
        }
        return i2;
    }

    private static String biM(String str) {
        AppMethodBeat.i(176158);
        long aEk = ((l) com.tencent.mm.kernel.g.af(l.class)).aTq().aEk(str);
        if (aEk > 0) {
            String str2 = " createTime > " + aEk + " AND ";
            AppMethodBeat.o(176158);
            return str2;
        }
        AppMethodBeat.o(176158);
        return "";
    }
}
