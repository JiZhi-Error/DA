package com.tencent.mm.al.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;

public final class g extends MAutoStorage<ai> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(f.info, "BizChatMyUserInfo")};
    private ISQLiteDatabase db;
    private final MStorageEvent<a, a.b> iNS = new MStorageEvent<a, a.b>() {
        /* class com.tencent.mm.al.a.g.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* bridge */ /* synthetic */ void processEvent(a aVar, a.b bVar) {
        }
    };

    static {
        AppMethodBeat.i(124252);
        AppMethodBeat.o(124252);
    }

    public g(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, f.info, "BizChatMyUserInfo", null);
        AppMethodBeat.i(124246);
        this.db = iSQLiteDatabase;
        iSQLiteDatabase.execSQL("BizChatMyUserInfo", "CREATE INDEX IF NOT EXISTS bizChatbrandUserNameIndex ON BizChatMyUserInfo ( brandUserName )");
        AppMethodBeat.o(124246);
    }

    public interface a {

        public static class b {
            public String brandName;
            public EnumC0250a iQc;
            public f iQd;
        }

        /* renamed from: com.tencent.mm.al.a.g$a$a  reason: collision with other inner class name */
        public enum EnumC0250a {
            INSTERT,
            DELETE,
            UPDATE;

            public static EnumC0250a valueOf(String str) {
                AppMethodBeat.i(124244);
                EnumC0250a aVar = (EnumC0250a) Enum.valueOf(EnumC0250a.class, str);
                AppMethodBeat.o(124244);
                return aVar;
            }

            static {
                AppMethodBeat.i(124245);
                AppMethodBeat.o(124245);
            }
        }
    }

    public final f NO(String str) {
        AppMethodBeat.i(124247);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.BizChatMyUserInfoStorage", "get： wrong argument");
            AppMethodBeat.o(124247);
            return null;
        }
        f fVar = new f();
        fVar.field_brandUserName = str;
        super.get(fVar, new String[0]);
        AppMethodBeat.o(124247);
        return fVar;
    }

    public final boolean NA(String str) {
        boolean z = false;
        AppMethodBeat.i(124248);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.BizChatMyUserInfoStorage", "delete wrong argument");
            AppMethodBeat.o(124248);
        } else {
            f fVar = new f();
            fVar.field_brandUserName = str;
            z = super.delete(fVar, "brandUserName");
            if (z) {
                a.b bVar = new a.b();
                bVar.brandName = fVar.field_brandUserName;
                bVar.iQc = a.EnumC0250a.DELETE;
                bVar.iQd = fVar;
                this.iNS.event(bVar);
                this.iNS.doNotify();
            }
            AppMethodBeat.o(124248);
        }
        return z;
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(124249);
        Log.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert");
        boolean insert = super.insert(fVar);
        if (insert) {
            a.b bVar = new a.b();
            bVar.brandName = fVar.field_brandUserName;
            bVar.iQc = a.EnumC0250a.INSTERT;
            bVar.iQd = fVar;
            this.iNS.event(bVar);
            this.iNS.doNotify();
        } else {
            Log.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert fail");
        }
        AppMethodBeat.o(124249);
        return insert;
    }

    public final boolean b(f fVar) {
        AppMethodBeat.i(124250);
        Log.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update");
        if (fVar == null) {
            Log.w("MicroMsg.BizChatMyUserInfoStorage", "update wrong argument");
            AppMethodBeat.o(124250);
            return false;
        }
        boolean replace = super.replace(fVar);
        if (replace) {
            a.b bVar = new a.b();
            bVar.brandName = fVar.field_brandUserName;
            bVar.iQc = a.EnumC0250a.UPDATE;
            bVar.iQd = fVar;
            this.iNS.event(bVar);
            this.iNS.doNotify();
        } else {
            Log.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update fail");
        }
        AppMethodBeat.o(124250);
        return replace;
    }

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final int getCount() {
        int i2 = 0;
        AppMethodBeat.i(124251);
        Log.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage getCount");
        Cursor rawQuery = this.db.rawQuery("SELECT COUNT(*) FROM BizChatMyUserInfo", null, 2);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(124251);
        return i2;
    }
}
