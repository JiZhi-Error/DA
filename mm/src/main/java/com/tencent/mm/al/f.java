package com.tencent.mm.al;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class f extends MAutoStorage<c> {
    public static final String[] INDEX_CREATE = {"CREATE  INDEX IF NOT EXISTS type_username_index ON bizinfo ( type,username ) ", "CREATE  INDEX IF NOT EXISTS  username_acceptType_index ON bizinfo ( username,acceptType ) "};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "bizinfo")};
    public static Map<String, String> iOb = new HashMap();
    private final MStorageEvent<a, a.b> iNS = new MStorageEvent<a, a.b>() {
        /* class com.tencent.mm.al.f.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(a aVar, a.b bVar) {
            AppMethodBeat.i(124006);
            aVar.a(bVar);
            AppMethodBeat.o(124006);
        }
    };

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(c cVar) {
        AppMethodBeat.i(124041);
        boolean g2 = g(cVar);
        AppMethodBeat.o(124041);
        return g2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(c cVar) {
        AppMethodBeat.i(124040);
        boolean h2 = h(cVar);
        AppMethodBeat.o(124040);
        return h2;
    }

    static {
        AppMethodBeat.i(124042);
        AppMethodBeat.o(124042);
    }

    public f(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "bizinfo", INDEX_CREATE);
        AppMethodBeat.i(124010);
        AppMethodBeat.o(124010);
    }

    public interface a {

        public static class b {
            public boolean dhM;
            public String iNV;
            public EnumC0255a iOh;
            public c iOi;
        }

        void a(b bVar);

        /* renamed from: com.tencent.mm.al.f$a$a  reason: collision with other inner class name */
        public enum EnumC0255a {
            INSTERT,
            DELETE,
            UPDATE;

            public static EnumC0255a valueOf(String str) {
                AppMethodBeat.i(124008);
                EnumC0255a aVar = (EnumC0255a) Enum.valueOf(EnumC0255a.class, str);
                AppMethodBeat.o(124008);
                return aVar;
            }

            static {
                AppMethodBeat.i(124009);
                AppMethodBeat.o(124009);
            }
        }
    }

    public final void a(a aVar, Looper looper) {
        AppMethodBeat.i(124011);
        this.iNS.add(aVar, looper);
        AppMethodBeat.o(124011);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(124012);
        if (this.iNS != null) {
            this.iNS.remove(aVar);
        }
        AppMethodBeat.o(124012);
    }

    public final c MT(String str) {
        AppMethodBeat.i(124013);
        c cVar = new c();
        cVar.field_username = str;
        super.get(cVar, new String[0]);
        AppMethodBeat.o(124013);
        return cVar;
    }

    public final void delete(String str) {
        AppMethodBeat.i(124014);
        c cVar = new c();
        cVar.field_username = str;
        Log.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", Boolean.valueOf(super.delete(cVar, ch.COL_USERNAME)), str);
        a.b bVar = new a.b();
        bVar.iNV = str;
        bVar.iOh = a.EnumC0255a.DELETE;
        bVar.iOi = cVar;
        this.iNS.event(bVar);
        this.iNS.doNotify();
        AppMethodBeat.o(124014);
    }

    public final void f(c cVar) {
        AppMethodBeat.i(124015);
        Log.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", Boolean.valueOf(super.delete(cVar, ch.COL_USERNAME)), cVar.field_username);
        a.b bVar = new a.b();
        bVar.iNV = cVar.field_username;
        bVar.iOh = a.EnumC0255a.DELETE;
        bVar.iOi = cVar;
        this.iNS.event(bVar);
        this.iNS.doNotify();
        AppMethodBeat.o(124015);
    }

    public final boolean g(c cVar) {
        c.b.C0261b UZ;
        AppMethodBeat.i(124016);
        cVar.field_updateTime = System.currentTimeMillis();
        cVar.UA();
        Log.v("MicroMsg.BizInfoStorage", "username is %s, %s, %d, %s, %s, %s, %d", cVar.field_username, cVar.field_brandList, Integer.valueOf(cVar.field_brandFlag), cVar.field_brandInfo, cVar.field_extInfo, cVar.field_brandIconURL, Long.valueOf(cVar.field_updateTime));
        c.b cG = cVar.cG(false);
        if (!(cG == null || (UZ = cG.UZ()) == null)) {
            cVar.field_specialType = UZ.dih;
        }
        boolean insert = super.insert(cVar);
        if (insert && !ab.Eq(cVar.field_username)) {
            a.b bVar = new a.b();
            bVar.iNV = cVar.field_username;
            bVar.dhM = cVar.UB();
            bVar.iOh = a.EnumC0255a.INSTERT;
            bVar.iOi = cVar;
            this.iNS.event(bVar);
            this.iNS.doNotify();
        }
        AppMethodBeat.o(124016);
        return insert;
    }

    public final boolean h(c cVar) {
        c.b.C0261b UZ;
        AppMethodBeat.i(124017);
        cVar.field_updateTime = System.currentTimeMillis();
        cVar.UA();
        c.b cG = cVar.cG(false);
        if (!(cG == null || (UZ = cG.UZ()) == null)) {
            cVar.field_specialType = UZ.dih;
        }
        boolean replace = super.replace(cVar);
        if (replace && !ab.Eq(cVar.field_username)) {
            a.b bVar = new a.b();
            bVar.iNV = cVar.field_username;
            bVar.dhM = cVar.UB();
            bVar.iOh = a.EnumC0255a.UPDATE;
            bVar.iOi = cVar;
            this.iNS.event(bVar);
            this.iNS.doNotify();
        }
        AppMethodBeat.o(124017);
        return replace;
    }

    public final List<String> sN(int i2) {
        AppMethodBeat.i(124018);
        String format = String.format(Locale.US, "select %s from %s where %s & %d > 0", ch.COL_USERNAME, "bizinfo", "acceptType", Integer.valueOf(i2));
        Log.i("MicroMsg.BizInfoStorage", "getList: sql[%s]", format);
        long currentTicks = Util.currentTicks();
        Cursor rawQuery = rawQuery(format, new String[0]);
        LinkedList linkedList = new LinkedList();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    linkedList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            Log.i("MicroMsg.BizInfoStorage", "getMyAcceptList: type[%d], use time[%d ms]", Integer.valueOf(i2), Long.valueOf(Util.ticksToNow(currentTicks)));
            List<String> iU = ((l) g.af(l.class)).aSN().iU(linkedList);
            AppMethodBeat.o(124018);
            return iU;
        }
        Log.i("MicroMsg.BizInfoStorage", "getMyAcceptList: cursor not null, type[%d], use time[%d ms]", Integer.valueOf(i2), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(124018);
        return linkedList;
    }

    public final int sO(int i2) {
        AppMethodBeat.i(124019);
        List<String> sN = sN(i2);
        if (Util.isNullOrNil(sN)) {
            AppMethodBeat.o(124019);
            return 0;
        }
        int size = sN.size();
        AppMethodBeat.o(124019);
        return size;
    }

    public static String aZD() {
        AppMethodBeat.i(124020);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rcontact.showHead asc, ");
        stringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(rcontact.conRemarkPYFull) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(rcontact.conRemark) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" upper(rcontact.quanPin) asc, ");
        stringBuffer.append(" upper(rcontact.nickname) asc, ");
        stringBuffer.append(" upper(rcontact.username) asc ");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(124020);
        return stringBuffer2;
    }

    private static String aZE() {
        AppMethodBeat.i(124021);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rcontact.type & 2048").append(" desc, ");
        stringBuffer.append("rcontact.showHead asc, ");
        stringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(rcontact.conRemarkPYFull) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(rcontact.conRemark) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" upper(rcontact.quanPin) asc, ");
        stringBuffer.append(" upper(rcontact.nickname) asc, ");
        stringBuffer.append(" upper(rcontact.username) asc ");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(124021);
        return stringBuffer2;
    }

    public static void a(StringBuilder sb) {
        AppMethodBeat.i(124022);
        sb.append("select bizinfo.username ");
        AppMethodBeat.o(124022);
    }

    private static void b(StringBuilder sb) {
        AppMethodBeat.i(124023);
        sb.append("select bizinfo.brandIconURL");
        sb.append(", bizinfo.type");
        sb.append(", bizinfo.status");
        sb.append(", bizinfo.enterpriseFather");
        sb.append(", bizinfo.brandFlag");
        sb.append(", bizinfo.extInfo");
        sb.append(", rcontact.username");
        sb.append(", rcontact.conRemark");
        sb.append(", rcontact.quanPin");
        sb.append(", rcontact.nickname");
        sb.append(", rcontact.alias");
        sb.append(", rcontact.type ");
        AppMethodBeat.o(124023);
    }

    public static void c(StringBuilder sb) {
        AppMethodBeat.i(124024);
        sb.append(" from rcontact, bizinfo");
        sb.append(" where rcontact.username = bizinfo.username");
        sb.append(" and (rcontact.verifyFlag & ").append(as.gBP()).append(") != 0 ");
        sb.append(" and (rcontact.type & 1) != 0 ");
        AppMethodBeat.o(124024);
    }

    public static void d(StringBuilder sb) {
        AppMethodBeat.i(124025);
        sb.append(" and bizinfo.type = 3 ");
        AppMethodBeat.o(124025);
    }

    private static void a(StringBuilder sb, String str) {
        AppMethodBeat.i(124026);
        sb.append(" and bizinfo.type = 3");
        sb.append(" and bizinfo.enterpriseFather = '").append(str).append("' ");
        AppMethodBeat.o(124026);
    }

    public static void a(StringBuilder sb, boolean z) {
        AppMethodBeat.i(124027);
        sb.append(" and (bizinfo.bitFlag & 1) ");
        sb.append(z ? "!=" : "==").append(" 0 ");
        AppMethodBeat.o(124027);
    }

    private static void a(StringBuilder sb, List<String> list) {
        AppMethodBeat.i(212160);
        if (list.isEmpty()) {
            AppMethodBeat.o(212160);
            return;
        }
        sb.append(" and (bizinfo.username NOT IN (");
        int size = list.size();
        int i2 = size - 1;
        for (int i3 = 0; i3 < size; i3++) {
            sb.append("'").append(list.get(i3)).append("'");
            if (i3 != i2) {
                sb.append(",");
            }
        }
        sb.append(")) ");
        AppMethodBeat.o(212160);
    }

    private static void b(StringBuilder sb, boolean z) {
        AppMethodBeat.i(124028);
        sb.append(" and (bizinfo.brandFlag & 1) ");
        sb.append(z ? "==" : "!=").append(" 0 ");
        AppMethodBeat.o(124028);
    }

    public static Cursor aq(String str, int i2) {
        AppMethodBeat.i(124029);
        StringBuilder sb = new StringBuilder();
        b(sb);
        c(sb);
        a(sb, str);
        a(sb, false);
        b(sb, true);
        sb.append(" and (bizinfo.acceptType & ").append(i2).append(") > 0 ");
        sb.append(" order by ");
        sb.append(aZD());
        String sb2 = sb.toString();
        Log.i("MicroMsg.BizInfoStorage", "getEnterpriseChildOfAcceptType sql %s", sb2);
        Cursor rawQuery = g.aAh().hqK.rawQuery(sb2, null);
        AppMethodBeat.o(124029);
        return rawQuery;
    }

    public final Cursor MU(String str) {
        AppMethodBeat.i(124030);
        List<String> MW = MW(str);
        ArrayList arrayList = new ArrayList();
        for (String str2 : MW) {
            if (!Util.isNullOrNil(MT(str2).UM())) {
                arrayList.add(str2);
            }
        }
        if (arrayList.size() <= 0) {
            AppMethodBeat.o(124030);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb);
        c(sb);
        a(sb, str);
        b(sb, true);
        sb.append(" and (");
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str3 = (String) arrayList.get(i2);
            if (i2 > 0) {
                sb.append(" or ");
            }
            sb.append("rcontact.username = '").append(str3).append("'");
        }
        sb.append(") order by ");
        sb.append(aZE());
        String sb2 = sb.toString();
        Log.i("MicroMsg.BizInfoStorage", "getEnterpriseChatConnector sql %s", sb2);
        Cursor rawQuery = g.aAh().hqK.rawQuery(sb2, null);
        AppMethodBeat.o(124030);
        return rawQuery;
    }

    public static List<String> aZF() {
        boolean z;
        int i2;
        AppMethodBeat.i(124031);
        StringBuilder sb = new StringBuilder();
        sb.append("select rcontact.username");
        sb.append(", bizinfo.enterpriseFather");
        sb.append(", bizinfo.bitFlag & 1");
        c(sb);
        d(sb);
        sb.append(" and (");
        sb.append(" (bizinfo.bitFlag & 1) != 0");
        sb.append(" or ");
        sb.append(" (bizinfo.acceptType & 128) > 0 ");
        sb.append(" and (bizinfo.brandFlag & 1) == 0) ");
        String sb2 = sb.toString();
        Log.i("MicroMsg.BizInfoStorage", "getEnterpriseConnectorList sql %s", sb2);
        Cursor rawQuery = g.aAh().hqK.rawQuery(sb2, null, 2);
        ArrayList arrayList = new ArrayList();
        if (rawQuery == null) {
            AppMethodBeat.o(124031);
            return arrayList;
        }
        while (rawQuery.moveToNext()) {
            if (rawQuery.getInt(2) > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            arrayList.add(rawQuery.getString(i2));
        }
        rawQuery.close();
        List<String> iU = ((l) g.af(l.class)).aSN().iU(arrayList);
        AppMethodBeat.o(124031);
        return iU;
    }

    public static Cursor O(String str, boolean z) {
        AppMethodBeat.i(124032);
        StringBuilder sb = new StringBuilder();
        b(sb);
        c(sb);
        a(sb, str);
        b(sb, true);
        if (z) {
            a(sb, false);
        }
        try {
            List<String> Nl = g.Nl(str);
            if (!Nl.isEmpty()) {
                a(sb, Nl);
            }
        } catch (Throwable th) {
        }
        sb.append(" order by ");
        sb.append(aZE());
        String sb2 = sb.toString();
        Log.i("MicroMsg.BizInfoStorage", "getEnterpriseEnableChild sql %s", sb2);
        Cursor rawQuery = g.aAh().hqK.rawQuery(sb2, null);
        AppMethodBeat.o(124032);
        return rawQuery;
    }

    public static Cursor MV(String str) {
        AppMethodBeat.i(124033);
        StringBuilder sb = new StringBuilder();
        b(sb);
        c(sb);
        a(sb, str);
        b(sb, false);
        a(sb, false);
        sb.append(" order by ");
        sb.append(aZE());
        String sb2 = sb.toString();
        Log.i("MicroMsg.BizInfoStorage", "getEnterpriseDisableChild sql %s", sb2);
        Cursor rawQuery = g.aAh().hqK.rawQuery(sb2, null);
        AppMethodBeat.o(124033);
        return rawQuery;
    }

    public static List<String> MW(String str) {
        ArrayList arrayList = null;
        AppMethodBeat.i(124034);
        StringBuilder sb = new StringBuilder();
        a(sb);
        c(sb);
        a(sb, str);
        String sb2 = sb.toString();
        Log.i("MicroMsg.BizInfoStorage", "getEnterpriseChildNameList sql %s", sb2);
        Cursor rawQuery = g.aAh().hqK.rawQuery(sb2, null, 2);
        if (rawQuery == null) {
            AppMethodBeat.o(124034);
        } else {
            arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(0));
            }
            rawQuery.close();
            AppMethodBeat.o(124034);
        }
        return arrayList;
    }

    public static String MX(String str) {
        String str2;
        AppMethodBeat.i(124035);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.BizInfoStorage", "getBizChatBrandUserName userName is null");
            AppMethodBeat.o(124035);
            return null;
        } else if (iOb == null || !iOb.containsKey(str)) {
            StringBuilder sb = new StringBuilder();
            a(sb);
            c(sb);
            a(sb, str);
            a(sb, true);
            String sb2 = sb.toString();
            Log.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatChild sql %s", sb2);
            Cursor rawQuery = g.aAh().hqK.rawQuery(sb2, null, 2);
            if (rawQuery == null) {
                AppMethodBeat.o(124035);
                return null;
            }
            if (rawQuery.moveToFirst()) {
                str2 = rawQuery.getString(0);
                iOb.put(str, str2);
            } else {
                str2 = null;
            }
            rawQuery.close();
            AppMethodBeat.o(124035);
            return str2;
        } else {
            String str3 = iOb.get(str);
            if (Util.isNullOrNil(str3) || !ab.IS(str3)) {
                AppMethodBeat.o(124035);
                return null;
            }
            AppMethodBeat.o(124035);
            return str3;
        }
    }

    public static List<String> aZG() {
        AppMethodBeat.i(124036);
        StringBuilder sb = new StringBuilder();
        sb.append("select bizinfo.username");
        sb.append(" from rcontact, bizinfo");
        sb.append(" where bizinfo.specialType = 1");
        sb.append(" and rcontact.username = bizinfo.username");
        sb.append(" and (rcontact.verifyFlag & ").append(as.gBP()).append(") != 0 ");
        sb.append(" and (rcontact.type & 1) != 0 ");
        String sb2 = sb.toString();
        Log.i("MicroMsg.BizInfoStorage", "getSpecialInternalBizUsernames sql %s", sb2);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = g.aAh().hqK.rawQuery(sb2, null, 2);
        int columnIndex = rawQuery.getColumnIndex(ch.COL_USERNAME);
        while (rawQuery.moveToNext()) {
            arrayList.add(rawQuery.getString(columnIndex));
        }
        rawQuery.close();
        AppMethodBeat.o(124036);
        return arrayList;
    }

    public static boolean MY(String str) {
        az bkm;
        boolean z = false;
        AppMethodBeat.i(124037);
        if (Util.isNullOrNil(str) || !g.Nh(str)) {
            AppMethodBeat.o(124037);
        } else {
            c fJ = g.fJ(str);
            if (fJ.cG(false) != null && fJ.cG(false).Vh() != null && !Util.isNullOrNil(fJ.UN()) && (bkm = ((l) g.af(l.class)).aST().bkm(fJ.UN())) != null && bkm.field_username.equals(str) && bkm.field_unReadCount > 0) {
                ((l) g.af(l.class)).aST().bka(fJ.UN());
            }
            Cursor aEH = ((l) g.af(l.class)).eiy().aEH(str);
            aEH.moveToFirst();
            while (!aEH.isAfterLast()) {
                ca caVar = new ca();
                caVar.convertFrom(aEH);
                caVar.setStatus(4);
                Log.d("MicroMsg.BizInfoStorage", "writeOpLog: msgSvrId = " + caVar.field_msgSvrId + " status = " + caVar.field_status);
                aEH.moveToNext();
                z = true;
            }
            aEH.close();
            if (z) {
                ((l) g.af(l.class)).aST().bka(str);
                ((l) g.af(l.class)).eiy().aEF(str);
            }
            AppMethodBeat.o(124037);
        }
        return z;
    }

    public static void MZ(String str) {
        AppMethodBeat.i(124038);
        if (Util.isNullOrNil(str) || !g.Nh(str)) {
            AppMethodBeat.o(124038);
            return;
        }
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().CY(str);
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().Xc();
        AppMethodBeat.o(124038);
    }

    public static void Na(String str) {
        AppMethodBeat.i(124039);
        if (Util.isNullOrNil(str) || !g.Nh(str)) {
            AppMethodBeat.o(124039);
            return;
        }
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().CY("");
        AppMethodBeat.o(124039);
    }
}
