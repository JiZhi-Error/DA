package com.tencent.mm.al.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.sdk.storage.MStorageEx;
import java.util.ArrayList;
import java.util.List;

public final class b extends MAutoStorage<a> implements MStorageEx.IOnStorageChange {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "BizChatConversation")};
    public ISQLiteDatabase db;
    private final MStorageEvent<a, a.C0248b> iNS = new MStorageEvent<a, a.C0248b>() {
        /* class com.tencent.mm.al.a.b.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(a aVar, a.C0248b bVar) {
            AppMethodBeat.i(212196);
            aVar.a(bVar);
            AppMethodBeat.o(212196);
        }
    };

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(a aVar) {
        AppMethodBeat.i(124197);
        boolean a2 = a(aVar);
        AppMethodBeat.o(124197);
        return a2;
    }

    static {
        AppMethodBeat.i(124198);
        AppMethodBeat.o(124198);
    }

    public b(final ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "BizChatConversation", null);
        AppMethodBeat.i(124179);
        this.db = iSQLiteDatabase;
        h.RTc.o(new Runnable() {
            /* class com.tencent.mm.al.a.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(212195);
                iSQLiteDatabase.execSQL("BizChatConversation", "CREATE INDEX IF NOT EXISTS BizChatConv_bizChatIdIndex ON BizChatConversation ( bizChatId )");
                iSQLiteDatabase.execSQL("BizChatConversation", "CREATE INDEX IF NOT EXISTS BizChatConv_brandUserNameIndex ON BizChatConversation ( brandUserName )");
                iSQLiteDatabase.execSQL("BizChatConversation", "CREATE INDEX IF NOT EXISTS unreadCountIndex ON BizChatConversation ( unReadCount )");
                AppMethodBeat.o(212195);
            }
        }, 30000);
        boolean z = false;
        Cursor rawQuery = iSQLiteDatabase.rawQuery("PRAGMA table_info( BizChatConversation)", null, 2);
        while (true) {
            if (rawQuery.moveToNext()) {
                int columnIndex = rawQuery.getColumnIndex("name");
                if (columnIndex >= 0 && "flag".equalsIgnoreCase(rawQuery.getString(columnIndex))) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        rawQuery.close();
        if (!z) {
            iSQLiteDatabase.execSQL("BizChatConversation", "update BizChatConversation set flag = lastMsgTime");
        }
        ((l) g.af(l.class)).aSN().add(this);
        AppMethodBeat.o(124179);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(124180);
        ((l) g.af(l.class)).aSN().remove(this);
        AppMethodBeat.o(124180);
    }

    public interface a {

        /* renamed from: com.tencent.mm.al.a.b$a$b  reason: collision with other inner class name */
        public static class C0248b {
            public String brandName;
            public EnumC0247a iPD;
            public long iPE;
            public a iPF;
        }

        void a(C0248b bVar);

        /* renamed from: com.tencent.mm.al.a.b$a$a  reason: collision with other inner class name */
        public enum EnumC0247a {
            INSTERT,
            DELETE,
            UPDATE;

            public static EnumC0247a valueOf(String str) {
                AppMethodBeat.i(124177);
                EnumC0247a aVar = (EnumC0247a) Enum.valueOf(EnumC0247a.class, str);
                AppMethodBeat.o(124177);
                return aVar;
            }

            static {
                AppMethodBeat.i(124178);
                AppMethodBeat.o(124178);
            }
        }
    }

    public final void a(a aVar, Looper looper) {
        AppMethodBeat.i(124181);
        this.iNS.add(aVar, looper);
        AppMethodBeat.o(124181);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(124182);
        if (this.iNS != null) {
            this.iNS.remove(aVar);
        }
        AppMethodBeat.o(124182);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(124183);
        Log.i("MicroMsg.BizConversationStorage", "onNotifyChange");
        if (obj == null || !(obj instanceof String)) {
            AppMethodBeat.o(124183);
            return;
        }
        String str = (String) obj;
        if (com.tencent.mm.al.g.DQ(str) && !ab.IS(str)) {
            e.P(str, true);
        }
        AppMethodBeat.o(124183);
    }

    public final a Al(long j2) {
        AppMethodBeat.i(124184);
        a aVar = new a();
        aVar.field_bizChatId = j2;
        super.get(aVar, new String[0]);
        AppMethodBeat.o(124184);
        return aVar;
    }

    public final int Nz(String str) {
        int i2 = 0;
        AppMethodBeat.i(212197);
        StringBuilder sb = new StringBuilder();
        sb.append("select count(*) from BizChatConversation");
        sb.append(" where brandUserName = '").append(str).append("' ");
        Cursor rawQuery = this.db.rawQuery(sb.toString(), null, 2);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(212197);
        return i2;
    }

    public final boolean Am(long j2) {
        AppMethodBeat.i(124185);
        a Al = Al(j2);
        boolean delete = super.delete(Al, "bizChatId");
        if (delete) {
            a.C0248b bVar = new a.C0248b();
            bVar.iPE = Al.field_bizChatId;
            bVar.brandName = Al.field_brandUserName;
            bVar.iPD = a.EnumC0247a.DELETE;
            bVar.iPF = Al;
            this.iNS.event(bVar);
            this.iNS.doNotify();
        }
        AppMethodBeat.o(124185);
        return delete;
    }

    public final boolean NA(String str) {
        AppMethodBeat.i(212198);
        StringBuilder sb = new StringBuilder();
        sb.append("delete from BizChatConversation");
        sb.append(" where brandUserName = '").append(str).append("' ");
        String sb2 = sb.toString();
        boolean execSQL = this.db.execSQL("BizChatConversation", sb2);
        Log.i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", sb2, Boolean.valueOf(execSQL));
        if (execSQL) {
            a aVar = new a();
            a.C0248b bVar = new a.C0248b();
            bVar.iPE = -1;
            bVar.brandName = str;
            bVar.iPD = a.EnumC0247a.DELETE;
            bVar.iPF = aVar;
            this.iNS.event(bVar);
            this.iNS.doNotify();
        }
        AppMethodBeat.o(212198);
        return execSQL;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(124186);
        Log.d("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert");
        if (aVar == null) {
            Log.w("MicroMsg.BizConversationStorage", "insert wrong argument");
            AppMethodBeat.o(124186);
            return false;
        }
        boolean insert = super.insert(aVar);
        Log.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert res:%s", Boolean.valueOf(insert));
        if (insert) {
            a.C0248b bVar = new a.C0248b();
            bVar.iPE = aVar.field_bizChatId;
            bVar.brandName = aVar.field_brandUserName;
            bVar.iPD = a.EnumC0247a.INSTERT;
            bVar.iPF = aVar;
            this.iNS.event(bVar);
            this.iNS.doNotify();
        }
        AppMethodBeat.o(124186);
        return insert;
    }

    public final boolean b(a aVar) {
        AppMethodBeat.i(124187);
        if (aVar == null) {
            Log.w("MicroMsg.BizConversationStorage", "update wrong argument");
            AppMethodBeat.o(124187);
            return false;
        }
        boolean replace = super.replace(aVar);
        Log.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage update res:%s", Boolean.valueOf(replace));
        if (replace) {
            e.g(ag.baj().bs(aVar.field_bizChatId));
            a.C0248b bVar = new a.C0248b();
            bVar.iPE = aVar.field_bizChatId;
            bVar.brandName = aVar.field_brandUserName;
            bVar.iPD = a.EnumC0247a.UPDATE;
            bVar.iPF = aVar;
            this.iNS.event(bVar);
            this.iNS.doNotify();
        }
        AppMethodBeat.o(124187);
        return replace;
    }

    public final Cursor NB(String str) {
        AppMethodBeat.i(124188);
        StringBuilder sb = new StringBuilder();
        sb.append("select * from BizChatConversation");
        sb.append(" where brandUserName = '").append(str).append("'");
        sb.append(" order by flag desc , lastMsgTime desc");
        Log.d("MicroMsg.BizConversationStorage", "getBizChatConversationCursor: sql:%s", sb.toString());
        Cursor rawQuery = this.db.rawQuery(sb.toString(), null);
        AppMethodBeat.o(124188);
        return rawQuery;
    }

    public final List<c> bi(String str, String str2) {
        AppMethodBeat.i(124189);
        ArrayList arrayList = new ArrayList();
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(124189);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("select BizChatInfo.*");
            sb.append(" from BizChatConversation , BizChatInfo");
            sb.append(" where BizChatConversation.brandUserName = '").append(str).append("'");
            sb.append(" and BizChatInfo.brandUserName = '").append(str).append("'");
            sb.append(" and BizChatConversation.bizChatId");
            sb.append(" = BizChatInfo.bizChatLocalId");
            sb.append(" and BizChatInfo.chatName like '%").append(str2).append("%'");
            sb.append(" order by BizChatConversation.flag desc");
            sb.append(" , BizChatConversation.lastMsgTime desc");
            Log.d("MicroMsg.BizConversationStorage", "getBizChatConversationSearchCursor: sql:%s", sb.toString());
            Cursor rawQuery = rawQuery(sb.toString(), new String[0]);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        c cVar = new c();
                        cVar.convertFrom(rawQuery);
                        arrayList.add(cVar);
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
            }
            AppMethodBeat.o(124189);
        }
        return arrayList;
    }

    public static void a(a aVar, int i2, int i3) {
        AppMethodBeat.i(124190);
        if (aVar.field_msgCount == 0) {
            aVar.field_msgCount = ((q) g.af(q.class)).aSR().cc(aVar.field_brandUserName, aVar.field_bizChatId);
            Log.i("MicroMsg.BizConversationStorage", "getMsgCount from message table");
        } else if (i2 > 0) {
            aVar.field_msgCount -= i2;
            if (aVar.field_msgCount < 0) {
                Log.e("MicroMsg.BizConversationStorage", "msg < 0 ,some path must be ignore!");
                aVar.field_msgCount = 0;
            }
        } else if (i3 > 0) {
            aVar.field_msgCount += i3;
        }
        Log.i("MicroMsg.BizConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", Integer.valueOf(aVar.field_msgCount), Long.valueOf(aVar.field_bizChatId), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(124190);
    }

    public final boolean An(long j2) {
        AppMethodBeat.i(124191);
        a Al = Al(j2);
        if (Al.field_unReadCount == 0 && Al.field_bizChatId == j2) {
            AppMethodBeat.o(124191);
        } else {
            Al.field_unReadCount = 0;
            Al.field_atCount = 0;
            Al.field_atAll = 0;
            b(Al);
            AppMethodBeat.o(124191);
        }
        return true;
    }

    public static long a(a aVar, int i2, long j2) {
        AppMethodBeat.i(124192);
        if (aVar == null) {
            AppMethodBeat.o(124192);
            return 0;
        }
        if (j2 == 0) {
            j2 = Util.nowMilliSecond();
        }
        switch (i2) {
            case 2:
                long a2 = a(aVar, j2) | 4611686018427387904L;
                AppMethodBeat.o(124192);
                return a2;
            case 3:
                long a3 = a(aVar, j2) & -4611686018427387905L;
                AppMethodBeat.o(124192);
                return a3;
            case 4:
                long a4 = a(aVar, j2) & 4611686018427387904L;
                AppMethodBeat.o(124192);
                return a4;
            default:
                long a5 = a(aVar, j2);
                AppMethodBeat.o(124192);
                return a5;
        }
    }

    private static long a(a aVar, long j2) {
        return (aVar.field_flag & -72057594037927936L) | (72057594037927935L & j2);
    }

    public final boolean Ao(long j2) {
        AppMethodBeat.i(124193);
        boolean c2 = c(Al(j2));
        AppMethodBeat.o(124193);
        return c2;
    }

    public static boolean c(a aVar) {
        AppMethodBeat.i(124194);
        if (aVar == null) {
            Log.e("MicroMsg.BizConversationStorage", "isPlacedTop failed, conversation null");
            AppMethodBeat.o(124194);
            return false;
        } else if (a(aVar, 4, 0L) != 0) {
            AppMethodBeat.o(124194);
            return true;
        } else {
            AppMethodBeat.o(124194);
            return false;
        }
    }

    public final boolean Ap(long j2) {
        AppMethodBeat.i(124195);
        Al(j2);
        a Al = Al(j2);
        boolean execSQL = this.db.execSQL("BizChatConversation", "update BizChatConversation set flag = " + a(Al, 2, Al.field_lastMsgTime) + " where bizChatId = " + Al.field_bizChatId);
        if (execSQL) {
            a Al2 = Al(Al.field_bizChatId);
            a.C0248b bVar = new a.C0248b();
            bVar.iPE = Al2.field_bizChatId;
            bVar.brandName = Al2.field_brandUserName;
            bVar.iPD = a.EnumC0247a.UPDATE;
            bVar.iPF = Al2;
            this.iNS.event(bVar);
            this.iNS.doNotify();
        }
        AppMethodBeat.o(124195);
        return execSQL;
    }

    public final boolean Aq(long j2) {
        AppMethodBeat.i(124196);
        a Al = Al(j2);
        boolean execSQL = this.db.execSQL("BizChatConversation", "update BizChatConversation set flag = " + a(Al, 3, Al.field_lastMsgTime) + " where bizChatId = " + Al.field_bizChatId);
        if (execSQL) {
            a Al2 = Al(Al.field_bizChatId);
            a.C0248b bVar = new a.C0248b();
            bVar.iPE = Al2.field_bizChatId;
            bVar.brandName = Al2.field_brandUserName;
            bVar.iPD = a.EnumC0247a.UPDATE;
            bVar.iPF = Al2;
            this.iNS.event(bVar);
            this.iNS.doNotify();
        }
        AppMethodBeat.o(124196);
        return execSQL;
    }
}
