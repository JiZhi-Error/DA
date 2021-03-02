package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class l extends MAutoStorage<k> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(k.info, "BizChatUserInfo")};
    public ISQLiteDatabase db;
    final MStorageEvent<a, a.b> iNS = new MStorageEvent<a, a.b>() {
        /* class com.tencent.mm.al.a.l.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* bridge */ /* synthetic */ void processEvent(a aVar, a.b bVar) {
        }
    };
    Map<String, String> iPG = new HashMap();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(k kVar) {
        AppMethodBeat.i(124290);
        boolean a2 = a(kVar);
        AppMethodBeat.o(124290);
        return a2;
    }

    static {
        AppMethodBeat.i(124291);
        AppMethodBeat.o(124291);
    }

    public l(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, k.info, "BizChatUserInfo", null);
        AppMethodBeat.i(124281);
        this.db = iSQLiteDatabase;
        iSQLiteDatabase.execSQL("BizChatUserInfo", "CREATE INDEX IF NOT EXISTS bizUserIdIndex ON BizChatUserInfo ( userId )");
        this.iPG.clear();
        AppMethodBeat.o(124281);
    }

    public interface a {

        public static class b {
            public EnumC0251a iQx;
            public k iQy;
            public String userId;
        }

        /* renamed from: com.tencent.mm.al.a.l$a$a  reason: collision with other inner class name */
        public enum EnumC0251a {
            INSTERT,
            DELETE,
            UPDATE;

            public static EnumC0251a valueOf(String str) {
                AppMethodBeat.i(124279);
                EnumC0251a aVar = (EnumC0251a) Enum.valueOf(EnumC0251a.class, str);
                AppMethodBeat.o(124279);
                return aVar;
            }

            static {
                AppMethodBeat.i(124280);
                AppMethodBeat.o(124280);
            }
        }
    }

    public final k fB(String str) {
        AppMethodBeat.i(124282);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.BizChatUserInfoStorage", "get  wrong argument");
            AppMethodBeat.o(124282);
            return null;
        }
        k kVar = new k();
        kVar.field_userId = str;
        super.get(kVar, new String[0]);
        AppMethodBeat.o(124282);
        return kVar;
    }

    public final boolean a(k kVar) {
        AppMethodBeat.i(124283);
        Log.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo insert");
        if (kVar == null) {
            Log.w("MicroMsg.BizChatUserInfoStorage", "insert wrong argument");
            AppMethodBeat.o(124283);
            return false;
        }
        boolean insert = super.insert(kVar);
        if (insert) {
            a.b bVar = new a.b();
            bVar.userId = kVar.field_userId;
            bVar.iQx = a.EnumC0251a.INSTERT;
            bVar.iQy = kVar;
            this.iNS.event(bVar);
            this.iNS.doNotify();
        }
        AppMethodBeat.o(124283);
        return insert;
    }

    public final boolean b(k kVar) {
        AppMethodBeat.i(124284);
        Log.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo update");
        if (kVar == null) {
            Log.w("MicroMsg.BizChatUserInfoStorage", "update wrong argument");
            AppMethodBeat.o(124284);
            return false;
        }
        if (kVar == null || Util.isNullOrNil(kVar.field_userName)) {
            Log.i("MicroMsg.BizChatUserInfoStorage", "dealWithChatNamePY null");
        } else {
            kVar.field_userNamePY = f.Sh(kVar.field_userName);
        }
        boolean replace = super.replace(kVar);
        if (replace) {
            a.b bVar = new a.b();
            bVar.userId = kVar.field_userId;
            bVar.iQx = a.EnumC0251a.UPDATE;
            bVar.iQy = kVar;
            this.iNS.event(bVar);
            this.iNS.doNotify();
        }
        AppMethodBeat.o(124284);
        return replace;
    }

    public final int NP(String str) {
        AppMethodBeat.i(124285);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion wrong argument");
            AppMethodBeat.o(124285);
            return -1;
        }
        k fB = fB(str);
        if (fB != null) {
            int i2 = fB.field_UserVersion;
            AppMethodBeat.o(124285);
            return i2;
        }
        Log.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion item == null");
        AppMethodBeat.o(124285);
        return -1;
    }

    public final k NQ(String str) {
        AppMethodBeat.i(124286);
        if (str == null) {
            Log.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo brandUserName is null");
            AppMethodBeat.o(124286);
            return null;
        }
        String fC = fC(str);
        if (fC == null) {
            Log.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo myUserIdString is null");
            AppMethodBeat.o(124286);
            return null;
        }
        k fB = fB(fC);
        AppMethodBeat.o(124286);
        return fB;
    }

    public final String fC(String str) {
        AppMethodBeat.i(124287);
        if (str == null) {
            Log.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId brandUserName is null");
            AppMethodBeat.o(124287);
            return null;
        }
        Log.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId:%s", str);
        if (!this.iPG.containsKey(str) || this.iPG.get(str) == null) {
            f NO = ag.bam().NO(str);
            if (NO != null) {
                Log.d("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo brandUserName:%s,%s", str, NO.field_userId);
                this.iPG.put(str, NO.field_userId);
                String str2 = NO.field_userId;
                AppMethodBeat.o(124287);
                return str2;
            }
            Log.w("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo == null brandUserName:%s", str);
            AppMethodBeat.o(124287);
            return null;
        }
        String str3 = this.iPG.get(str);
        AppMethodBeat.o(124287);
        return str3;
    }

    public final void c(k kVar) {
        AppMethodBeat.i(124288);
        Log.i("MicroMsg.BizChatUserInfoStorage", "updateUserName");
        k fB = fB(kVar.field_userId);
        if (fB == null) {
            a(kVar);
        } else if (!Util.isNullOrNil(kVar.field_userName) && !kVar.field_userName.equals(fB.field_userName)) {
            fB.field_userName = kVar.field_userName;
            b(fB);
            AppMethodBeat.o(124288);
            return;
        }
        AppMethodBeat.o(124288);
    }

    public static String a(String[] strArr, List<String> list) {
        AppMethodBeat.i(124289);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(124289);
            return "";
        }
        StringBuilder sb = new StringBuilder(" 1=1 ");
        String str = "";
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                str = str + " and userId != '" + it.next() + "'";
            }
            str = str;
        }
        sb.append(str);
        sb.append(" and ");
        sb.append("userId in(");
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (i2 > 0) {
                sb.append(" , ");
            }
            sb.append(" '").append(strArr[i2]).append("' ");
        }
        sb.append(" )");
        String sb2 = sb.toString();
        AppMethodBeat.o(124289);
        return sb2;
    }
}
