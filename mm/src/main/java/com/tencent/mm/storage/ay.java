package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.a.e;
import com.tencent.mm.storagebase.d;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class ay extends MStorageEx implements bv {
    public static final String[] INDEX_CREATE = {"CREATE UNIQUE INDEX IF NOT EXISTS  contact_username_unique_index ON rcontact ( username )", "CREATE INDEX IF NOT EXISTS  contact_alias_index ON rcontact ( alias )", "CREATE INDEX IF NOT EXISTS  en_username_unique_index ON rcontact ( encryptUsername )", "CREATE UNIQUE INDEX IF NOT EXISTS  bottle_username_unique_index ON bottlecontact ( username )", "CREATE INDEX IF NOT EXISTS type_verifyFlag_index ON rcontact ( type,verifyFlag ) "};
    private static String OoK = "showHead = 32";
    private static String OoL = "type & 64 !=0 ";
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(as.info, "rcontact"), MAutoStorage.getCreateSQLs(as.info, "bottlecontact"), MAutoStorage.getCreateSQLs(at.info, "ContactCmdBuf"), "CREATE TABLE IF NOT EXISTS contact ( contactID INTEGER PRIMARY KEY, sex INT, type INT, showHead INT, username VARCHAR(40), nickname VARCHAR(40), pyInitial VARCHAR(40), quanPin VARCHAR(60), reserved TEXT );", "CREATE TABLE IF NOT EXISTS contact_ext ( username VARCHAR(40), Uin INTEGER DEFAULT 0, Email VARCHAR(128), Mobile VARCHAR(40), ShowFlag INTEGER DEFAULT 0 , ConType INTEGER DEFAULT 0 , ConRemark TEXT, ConRemark_PYShort TEXT, ConRemark_PYFull TEXT, ConQQMBlog TEXT, ConSMBlog TEXT, DomainList TEXT, reserved1 INT DEFAULT 0 , reserved2 INT DEFAULT 0 , reserved3 INT DEFAULT 0 , reserved4 INT DEFAULT 0 , reserved5 INT DEFAULT 0 , reserved6 TEXT, reserved7 TEXT, reserved8 TEXT, reserved9 TEXT, reserved10 TEXT, weiboflag  INT DEFAULT 0 ,weibonickname TEXT  );"};
    private ISQLiteDatabase OoG;
    public final f<String, as> OoH = new c(200);
    public final f<String, Integer> OoI = new c(400);
    private a OoJ = new a((byte) 0);
    private ISQLiteDatabase db;

    private static String bjD(String str) {
        AppMethodBeat.i(116968);
        if (as.IG(str)) {
            String str2 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from " + "bottlecontact";
            AppMethodBeat.o(116968);
            return str2;
        }
        String str3 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from " + "rcontact";
        AppMethodBeat.o(116968);
        return str3;
    }

    private static String bjE(String str) {
        AppMethodBeat.i(116969);
        if (as.IG(str)) {
            AppMethodBeat.o(116969);
            return "bottlecontact";
        }
        AppMethodBeat.o(116969);
        return "rcontact";
    }

    static {
        AppMethodBeat.i(117060);
        AppMethodBeat.o(117060);
    }

    public ay(h hVar) {
        boolean z = true;
        AppMethodBeat.i(116970);
        Cursor rawQuery = hVar.rawQuery("PRAGMA table_info( contact_ext )", null, 2);
        int columnIndex = rawQuery.getColumnIndex("name");
        boolean z2 = false;
        boolean z3 = false;
        while (rawQuery.moveToNext() && (!z3 || !z2)) {
            if (columnIndex >= 0) {
                String string = rawQuery.getString(columnIndex);
                if ("weiboNickname".equalsIgnoreCase(string)) {
                    z2 = true;
                } else if ("weiboFlag".equalsIgnoreCase(string)) {
                    z3 = true;
                }
            }
        }
        rawQuery.close();
        if (!z3) {
            hVar.execSQL("contact_ext", "Alter table contact_ext add weiboFlag INT DEFAULT 0 ");
        }
        if (!z2) {
            hVar.execSQL("contact_ext", "Alter table contact_ext add weiboNickname INT DEFAULT 0 ");
        }
        Cursor rawQuery2 = hVar.rawQuery("PRAGMA table_info( rcontact )", null, 2);
        int columnIndex2 = rawQuery2.getColumnIndex("name");
        while (true) {
            if (!rawQuery2.moveToNext()) {
                z = false;
                break;
            }
            if (columnIndex2 >= 0 && "verifyFlag".equalsIgnoreCase(rawQuery2.getString(columnIndex2))) {
                break;
            }
        }
        rawQuery2.close();
        if (!z) {
            hVar.execSQL("rcontact", "Alter table rcontact add verifyFlag INT DEFAULT 0 ");
        }
        for (String str : MAutoStorage.getUpdateSQLs(com.tencent.mm.contact.c.info, "bottlecontact", hVar)) {
            hVar.execSQL("bottlecontact", str);
        }
        for (String str2 : MAutoStorage.getUpdateSQLs(com.tencent.mm.contact.c.info, "rcontact", hVar)) {
            hVar.execSQL("rcontact", str2);
        }
        for (String str3 : INDEX_CREATE) {
            hVar.execSQL("rcontact", str3);
        }
        this.db = hVar;
        this.OoG = hVar;
        AppMethodBeat.o(116970);
    }

    /* access modifiers changed from: package-private */
    public static final class a implements bv.a {
        ConcurrentHashMap<bv.a, Object> JWm;

        private a() {
            AppMethodBeat.i(187484);
            this.JWm = new ConcurrentHashMap<>();
            AppMethodBeat.o(187484);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.storage.bv.a
        public final void a(bv bvVar, as asVar) {
            AppMethodBeat.i(187485);
            for (bv.a aVar : this.JWm.keySet()) {
                aVar.a(bvVar, asVar);
            }
            AppMethodBeat.o(187485);
        }

        @Override // com.tencent.mm.storage.bv.a
        public final as Kn(String str) {
            AppMethodBeat.i(187486);
            for (bv.a aVar : this.JWm.keySet()) {
                as Kn = aVar.Kn(str);
                if (Kn != null) {
                    Log.i("MicroMsg.ContactStorage", "[get] contact=%s listener=%s", Kn.field_username, aVar);
                    AppMethodBeat.o(187486);
                    return Kn;
                }
            }
            AppMethodBeat.o(187486);
            return null;
        }

        @Override // com.tencent.mm.storage.bv.a
        public final int b(as asVar, boolean z) {
            AppMethodBeat.i(187487);
            for (bv.a aVar : this.JWm.keySet()) {
                int b2 = aVar.b(asVar, z);
                if (b2 > 0) {
                    Log.i("MicroMsg.ContactStorage", "[replace] ret=%s listener=%s", Integer.valueOf(b2), aVar);
                    AppMethodBeat.o(187487);
                    return b2;
                }
            }
            AppMethodBeat.o(187487);
            return -1;
        }
    }

    @Override // com.tencent.mm.storage.bv
    public final void a(bv.a aVar) {
        AppMethodBeat.i(187488);
        this.OoJ.JWm.put(aVar, new Object());
        AppMethodBeat.o(187488);
    }

    @Override // com.tencent.mm.storage.bv
    public final void b(bv.a aVar) {
        AppMethodBeat.i(116972);
        this.OoJ.JWm.remove(aVar);
        AppMethodBeat.o(116972);
    }

    @Override // com.tencent.mm.storage.bv
    public final as bjF(String str) {
        AppMethodBeat.i(116973);
        as aT = this.OoH.aT(str);
        if (aT != null) {
            AppMethodBeat.o(116973);
            return aT;
        }
        AppMethodBeat.o(116973);
        return null;
    }

    @Override // com.tencent.mm.storage.bv
    public final void am(as asVar) {
        AppMethodBeat.i(116974);
        d(asVar, false);
        AppMethodBeat.o(116974);
    }

    @Override // com.tencent.mm.storage.bv
    public final void d(as asVar, boolean z) {
        AppMethodBeat.i(187489);
        if (asVar == null || asVar.field_username == null || (asVar.field_type == 0 && !z)) {
            AppMethodBeat.o(187489);
            return;
        }
        this.OoH.x(asVar.field_username, asVar);
        this.OoI.x(asVar.field_username, Integer.valueOf(asVar.field_type));
        AppMethodBeat.o(187489);
    }

    @Override // com.tencent.mm.storage.bv
    public final void ayf(String str) {
        AppMethodBeat.i(116975);
        if (!Util.isNullOrNil(str)) {
            this.OoH.remove(str);
            this.OoI.remove(str);
        }
        AppMethodBeat.o(116975);
    }

    @Override // com.tencent.mm.storage.bv
    public final boolean bjG(String str) {
        AppMethodBeat.i(116976);
        if (Util.isNullOrNil(str) || (str.contains("@") && !str.endsWith("@stranger"))) {
            AppMethodBeat.o(116976);
            return false;
        }
        Integer num = this.OoI.get(str);
        if (num != null) {
            boolean oR = com.tencent.mm.contact.c.oR(num.intValue());
            AppMethodBeat.o(116976);
            return oR;
        }
        as Kn = Kn(str);
        if (Kn == null || (!Kn.field_username.equals(str) && !str.equals(Kn.field_encryptUsername))) {
            this.OoI.x(str, 0);
            AppMethodBeat.o(116976);
            return false;
        }
        this.OoI.x(str, Integer.valueOf(Kn.field_type));
        boolean oR2 = com.tencent.mm.contact.c.oR(Kn.field_type);
        AppMethodBeat.o(116976);
        return oR2;
    }

    @Override // com.tencent.mm.storage.bv
    public final as bjH(String str) {
        AppMethodBeat.i(116978);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(116978);
            return null;
        }
        as Kn = this.OoJ.Kn(str);
        if (Kn != null) {
            d(Kn, false);
            AppMethodBeat.o(116978);
            return Kn;
        }
        as asVar = new as();
        Cursor rawQuery = this.db.rawQuery("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact where alias=" + h.Fl(str), null, 2);
        if (rawQuery.moveToFirst()) {
            asVar.convertFrom(rawQuery);
            d(asVar, false);
        }
        rawQuery.close();
        asVar.gBS();
        AppMethodBeat.o(116978);
        return asVar;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor a(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2) {
        AppMethodBeat.i(116979);
        String str3 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + f(str, str2, list) + iN(list2) + gCf();
        Log.v("MicroMsg.ContactStorage", str3);
        if (z) {
            com.tencent.mm.storagebase.a.f[] fVarArr = new com.tencent.mm.storagebase.a.f[2];
            Log.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(str3)));
            Cursor rawQuery = this.db.rawQuery("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + y(list, z2) + gCg(), null, 4);
            Cursor rawQuery2 = this.db.rawQuery(str3, null, 4);
            if (!(rawQuery instanceof com.tencent.mm.storagebase.a.f) || !(rawQuery2 instanceof com.tencent.mm.storagebase.a.f)) {
                Cursor gFu = d.gFu();
                AppMethodBeat.o(116979);
                return gFu;
            }
            fVarArr[0] = (com.tencent.mm.storagebase.a.f) rawQuery;
            fVarArr[1] = (com.tencent.mm.storagebase.a.f) rawQuery2;
            e eVar = new e(fVarArr);
            AppMethodBeat.o(116979);
            return eVar;
        }
        Cursor rawQuery3 = this.db.rawQuery(str3, null, 4);
        AppMethodBeat.o(116979);
        return rawQuery3;
    }

    @Override // com.tencent.mm.storage.bv
    public final List<String> gBY() {
        AppMethodBeat.i(116980);
        Cursor rawQuery = this.db.rawQuery(" select openImAppid from rcontact" + gCm() + " group by openImAppid ", null, 4);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            String string = rawQuery.getString(0);
            if (!Util.isNullOrNil(string)) {
                arrayList.add("'" + string + "'");
            }
        }
        rawQuery.close();
        LinkedList linkedList = new LinkedList();
        if (arrayList.size() > 0) {
            Cursor rawQuery2 = this.db.rawQuery(" select acctTypeId from OpenIMAppIdInfo where appid in (" + Util.listToString(arrayList, ",") + ") group by acctTypeId", null, 4);
            if (rawQuery2.moveToFirst()) {
                do {
                    String string2 = rawQuery2.getString(0);
                    if (!Util.isNullOrNil(string2)) {
                        linkedList.add(string2);
                    }
                } while (rawQuery2.moveToNext());
            }
            rawQuery2.close();
        }
        AppMethodBeat.o(116980);
        return linkedList;
    }

    private static String a(String str, List<String> list, String str2, List<String> list2) {
        AppMethodBeat.i(116981);
        String str3 = (str + " and OpenIMWordingInfo.language='" + str2 + "' ") + gCm();
        String str4 = "";
        if (list2 != null && list2.size() > 0) {
            for (String str5 : list2) {
                str4 = (str4.equals("") ? str4 + " and (" : str4 + " or ") + "openImAppid == '" + str5 + "'";
            }
            str4 = str4 + " )";
        }
        String str6 = str3 + str4;
        String str7 = "";
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                str7 = str7 + " and username != '" + it.next() + "'";
            }
            str7 = str7;
        }
        String str8 = str6 + str7;
        Log.v("MicroMsg.ContactStorage", "getOpenIMCursor:%s", str8);
        AppMethodBeat.o(116981);
        return str8;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor a(List<String> list, String str, List<String> list2) {
        AppMethodBeat.i(116982);
        Cursor rawQuery = this.db.rawQuery(a("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", list, str, list2) + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ", null, 4);
        AppMethodBeat.o(116982);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor b(List<String> list, String str, List<String> list2) {
        AppMethodBeat.i(116983);
        String str2 = (a("select count(*)  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", list, str, list2) + "group by OpenIMWordingInfo.wording ") + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ";
        Log.v("MicroMsg.ContactStorage", "getOpenIMHeaderCursor:%s", str2);
        Cursor rawQuery = this.db.rawQuery(str2, null, 4);
        AppMethodBeat.o(116983);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor c(List<String> list, String str, List<String> list2) {
        AppMethodBeat.i(116984);
        String str2 = (a("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId and rcontact.openImAppid = OpenIMWordingInfo.appid ", list, str, list2) + "group by OpenIMWordingInfo.wording ") + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ";
        Log.v("MicroMsg.ContactStorage", "getOpenIMHeaderCursor:%s", str2);
        Cursor rawQuery = this.db.rawQuery(str2, null, 4);
        AppMethodBeat.o(116984);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor bjI(String str) {
        AppMethodBeat.i(116985);
        Cursor rawQuery = this.db.rawQuery(str, null, 4);
        AppMethodBeat.o(116985);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor iJ(List<String> list) {
        AppMethodBeat.i(116986);
        Assert.assertTrue(list.size() > 0);
        String str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,type from rcontact  where ";
        for (int i2 = 0; i2 < list.size(); i2++) {
            str = i2 != list.size() - 1 ? str + "username = '" + list.get(i2) + "' OR " : str + "username = '" + list.get(i2) + "'";
        }
        Cursor rawQuery = this.db.rawQuery(str + gCf(), null);
        AppMethodBeat.o(116986);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor iK(List<String> list) {
        AppMethodBeat.i(116987);
        Assert.assertTrue(list.size() > 0);
        StringBuilder sb = new StringBuilder("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact ");
        sb.append(" where username IN (");
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 == list.size() - 1) {
                sb.append(" '").append(list.get(i2)).append("'");
            } else {
                sb.append(" '").append(list.get(i2)).append("',");
            }
        }
        sb.append(" )").append(gCf());
        Cursor rawQuery = this.db.rawQuery(sb.toString(), null);
        AppMethodBeat.o(116987);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor b(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2) {
        AppMethodBeat.i(116988);
        String str3 = "select username from rcontact " + f(str, str2, list) + iN(list2) + gCf();
        Log.v("MicroMsg.ContactStorage", str3);
        if (z) {
            com.tencent.mm.storagebase.a.f[] fVarArr = new com.tencent.mm.storagebase.a.f[2];
            Log.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(str3)));
            Cursor rawQuery = this.db.rawQuery("select username from rcontact " + y(list, z2) + gCg(), null, 4);
            Cursor rawQuery2 = this.db.rawQuery(str3, null, 4);
            if (!(rawQuery instanceof com.tencent.mm.storagebase.a.f) || !(rawQuery2 instanceof com.tencent.mm.storagebase.a.f)) {
                Cursor gFu = d.gFu();
                AppMethodBeat.o(116988);
                return gFu;
            }
            fVarArr[0] = (com.tencent.mm.storagebase.a.f) rawQuery;
            fVarArr[1] = (com.tencent.mm.storagebase.a.f) rawQuery2;
            e eVar = new e(fVarArr);
            AppMethodBeat.o(116988);
            return eVar;
        }
        Cursor rawQuery3 = this.db.rawQuery(str3, null);
        AppMethodBeat.o(116988);
        return rawQuery3;
    }

    @Override // com.tencent.mm.storage.bv
    public final as bjJ(String str) {
        AppMethodBeat.i(116989);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(116989);
            return null;
        }
        if (as.IG(str)) {
            str = as.bjz(str);
        }
        as bjF = bjF(str);
        if (bjF != null) {
            bjF.gBS();
            AppMethodBeat.o(116989);
            return bjF;
        }
        as Kn = this.OoJ.Kn(str);
        if (Kn != null) {
            d(Kn, false);
            AppMethodBeat.o(116989);
            return Kn;
        }
        as asVar = new as();
        Cursor rawQuery = this.db.rawQuery(bjD(str) + " where username=" + h.Fl(str), null, 2);
        if (rawQuery.moveToFirst()) {
            asVar.convertFrom(rawQuery);
            d(asVar, false);
        }
        rawQuery.close();
        asVar.gBS();
        AppMethodBeat.o(116989);
        return asVar;
    }

    @Override // com.tencent.mm.storage.bv
    public final as bjK(String str) {
        AppMethodBeat.i(116990);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(116990);
            return null;
        }
        if (as.IG(str)) {
            str = as.bjz(str);
        }
        as bjF = bjF(str);
        if (bjF != null) {
            AppMethodBeat.o(116990);
            return bjF;
        }
        as asVar = new as();
        Cursor rawQuery = this.db.rawQuery(bjD(str) + " where username=" + h.Fl(str) + " or encryptUsername=" + h.Fl(str), null, 2);
        if (rawQuery.moveToFirst()) {
            asVar.convertFrom(rawQuery);
            d(asVar, false);
        }
        rawQuery.close();
        AppMethodBeat.o(116990);
        return asVar;
    }

    @Override // com.tencent.mm.storage.bv
    public final as Kn(String str) {
        AppMethodBeat.i(116991);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(116991);
            return null;
        }
        if (as.IG(str)) {
            str = as.bjz(str);
        }
        as bjF = bjF(str);
        if (bjF != null) {
            AppMethodBeat.o(116991);
            return bjF;
        }
        as Kn = this.OoJ.Kn(str);
        if (Kn != null) {
            d(Kn, false);
            AppMethodBeat.o(116991);
            return Kn;
        }
        as bjV = bjV(str);
        AppMethodBeat.o(116991);
        return bjV;
    }

    @Override // com.tencent.mm.storage.bv
    public final as bjL(String str) {
        AppMethodBeat.i(187490);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(187490);
            return null;
        }
        if (as.IG(str)) {
            str = as.bjz(str);
        }
        as asVar = new as();
        Cursor rawQuery = this.db.rawQuery(bjD(str) + " where username=" + h.Fl(str) + " or encryptUsername=" + h.Fl(str), null, 2);
        if (rawQuery.moveToFirst()) {
            asVar.convertFrom(rawQuery);
            asVar.gBS();
        }
        rawQuery.close();
        AppMethodBeat.o(187490);
        return asVar;
    }

    @Override // com.tencent.mm.storage.bv
    public final as Nh(long j2) {
        as asVar = null;
        AppMethodBeat.i(116992);
        if (j2 <= 0) {
            AppMethodBeat.o(116992);
        } else {
            Cursor rawQuery = this.db.rawQuery("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where rowid=".concat(String.valueOf(j2)), null, 2);
            if (rawQuery.moveToFirst()) {
                asVar = new as();
                asVar.convertFrom(rawQuery);
                d(asVar, false);
            }
            rawQuery.close();
            if (asVar != null) {
                asVar.gBS();
            }
            AppMethodBeat.o(116992);
        }
        return asVar;
    }

    @Override // com.tencent.mm.storage.bv
    public final long bjM(String str) {
        AppMethodBeat.i(116993);
        long j2 = -1;
        as Kn = Kn(str);
        if (Kn != null && Kn.gMZ > 0) {
            j2 = (long) ((int) Kn.gMZ);
        }
        AppMethodBeat.o(116993);
        return j2;
    }

    @Override // com.tencent.mm.storage.bv
    public final boolean bjN(String str) {
        AppMethodBeat.i(116994);
        as Kn = Kn(str);
        if (Kn == null || Util.isNullOrNil(Kn.field_username) || !Kn.field_username.equals(str)) {
            AppMethodBeat.o(116994);
            return false;
        }
        AppMethodBeat.o(116994);
        return true;
    }

    @Override // com.tencent.mm.storage.bv
    public final boolean bjO(String str) {
        boolean z = false;
        AppMethodBeat.i(116995);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(116995);
        } else {
            Cursor rawQuery = this.db.rawQuery("select count(*) from " + bjE(str) + " where type & " + com.tencent.mm.contact.c.aro() + " !=0 and username=" + h.Fl(str), null, 2);
            if (rawQuery.moveToFirst() && rawQuery.getInt(0) > 0) {
                z = true;
            }
            rawQuery.close();
            AppMethodBeat.o(116995);
        }
        return z;
    }

    @Override // com.tencent.mm.storage.bv
    public final boolean ao(as asVar) {
        AppMethodBeat.i(116996);
        Assert.assertTrue("contact NULL !", asVar != null);
        if (!ar(asVar)) {
            AppMethodBeat.o(116996);
            return true;
        }
        asVar.nd(asVar.aqN());
        this.OoJ.a(this, asVar);
        boolean z = this.OoJ.b(asVar, false) > 0;
        Log.d("MicroMsg.ContactStorage", "[replace] ret:%s username=%s, showHead=%d, verifyFlag=%d", Boolean.valueOf(z), asVar.field_username, Integer.valueOf(asVar.field_showHead), Integer.valueOf(asVar.field_verifyFlag));
        if (!z) {
            ContentValues convertTo = asVar.convertTo();
            if (((int) asVar.gMZ) > 0) {
                convertTo.put("rowid", Integer.valueOf((int) asVar.gMZ));
            }
            z = this.db.replace(bjE(asVar.field_username), com.tencent.mm.contact.c.info.primaryKey, convertTo) > 0;
        }
        ayf(asVar.field_username);
        if (!Util.isNullOrNil(asVar.field_encryptUsername)) {
            ayf(asVar.field_encryptUsername);
        }
        if (!z) {
            AppMethodBeat.o(116996);
            return false;
        }
        doNotify(4, this, asVar.field_username);
        AppMethodBeat.o(116996);
        return true;
    }

    @Override // com.tencent.mm.storage.bv
    public final boolean ap(as asVar) {
        AppMethodBeat.i(116997);
        if (aq(asVar) > 0) {
            AppMethodBeat.o(116997);
            return true;
        }
        AppMethodBeat.o(116997);
        return false;
    }

    @Override // com.tencent.mm.storage.bv
    public final int B(String str, byte[] bArr) {
        int i2 = -1;
        AppMethodBeat.i(116999);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
            AppMethodBeat.o(116999);
            return -1;
        }
        at atVar = new at();
        atVar.field_cmdbuf = bArr;
        atVar.field_username = str;
        int replace = (int) this.db.replace("ContactCmdBuf", ch.COL_USERNAME, atVar.convertTo());
        Object[] objArr = new Object[3];
        objArr[0] = str;
        if (bArr != null) {
            i2 = bArr.length;
        }
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(replace);
        Log.d("MicroMsg.ContactStorage", "setCmdbuf user:%s buf:%d result:%d", objArr);
        AppMethodBeat.o(116999);
        return replace;
    }

    @Override // com.tencent.mm.storage.bv
    public final byte[] bjP(String str) {
        int length;
        AppMethodBeat.i(117000);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
            AppMethodBeat.o(117000);
            return null;
        }
        at atVar = new at();
        Cursor query = this.db.query("ContactCmdBuf", null, "username=?", new String[]{str}, null, null, null, 2);
        if (query.moveToFirst()) {
            atVar.convertFrom(query);
        }
        query.close();
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (atVar.field_cmdbuf == null) {
            length = -1;
        } else {
            length = atVar.field_cmdbuf.length;
        }
        objArr[1] = Integer.valueOf(length);
        Log.d("MicroMsg.ContactStorage", "getCmdbuf user:%s buf:%d", objArr);
        byte[] bArr = atVar.field_cmdbuf;
        AppMethodBeat.o(117000);
        return bArr;
    }

    @Override // com.tencent.mm.storage.bv
    public final int bjQ(String str) {
        AppMethodBeat.i(117001);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ContactStorage", "delCmdBuf failed user is null");
            AppMethodBeat.o(117001);
            return -1;
        }
        int delete = this.db.delete("ContactCmdBuf", "username=?", new String[]{String.valueOf(str)});
        Log.d("MicroMsg.ContactStorage", "delCmdBuf user:%s ret:%d", str, Integer.valueOf(delete));
        AppMethodBeat.o(117001);
        return delete;
    }

    @Override // com.tencent.mm.storage.bv
    public final int aNa(String str) {
        AppMethodBeat.i(117002);
        Assert.assertTrue(str.length() > 0);
        if (as.IG(str)) {
            str = as.bjz(str);
        }
        ayf(str);
        as asVar = new as(str);
        asVar.setType(0);
        asVar.setUsername("fake_" + Util.nowMilliSecond());
        asVar.BK("fake_" + Util.nowMilliSecond());
        asVar.setSource(0);
        int update = this.db.update(bjE(str), asVar.convertTo(), "username=?", new String[]{String.valueOf(str)});
        bjQ(str);
        Log.w("MicroMsg.ContactStorage", "delete (because the fucking talker id , dk just mark it  disappear .) user:%s res:%s %s", str, Integer.valueOf(update), Util.getStack());
        if (update == 0) {
            AppMethodBeat.o(117002);
        } else {
            doNotify(5, this, str);
            AppMethodBeat.o(117002);
        }
        return update;
    }

    @Override // com.tencent.mm.storage.bv
    public final int c(String str, as asVar) {
        AppMethodBeat.i(117003);
        Log.i("MicroMsg.ContactStorage", "begin to update contact : ".concat(String.valueOf(str)));
        if (!ar(asVar)) {
            AppMethodBeat.o(117003);
            return 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (as.IG(str)) {
            str = as.bjz(str);
        }
        asVar.nd(asVar.aqN());
        this.OoJ.a(this, asVar);
        int b2 = this.OoJ.b(asVar, true);
        if (b2 < 0) {
            ContentValues convertTo = asVar.convertTo();
            if (((int) asVar.gMZ) > 0) {
                convertTo.put("rowid", Integer.valueOf((int) asVar.gMZ));
            }
            if (convertTo.size() > 0) {
                b2 = this.db.update(bjE(str), convertTo, "username=?", new String[]{String.valueOf(str)});
            }
        }
        Log.i("MicroMsg.ContactStorage", "[update] ret=%s username=%s, showHead=%d, verifyFlag=%d, take[%d]ms", Integer.valueOf(b2), asVar.field_username, Integer.valueOf(asVar.field_showHead), Integer.valueOf(asVar.field_verifyFlag), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        ayf(str);
        if (!Util.isNullOrNil(asVar.field_encryptUsername)) {
            ayf(asVar.field_encryptUsername);
        }
        if (b2 != 0) {
            doNotify(4, this, asVar.field_username);
        }
        AppMethodBeat.o(117003);
        return b2;
    }

    @Override // com.tencent.mm.storage.bv
    public final int d(String str, as asVar) {
        int i2 = 0;
        AppMethodBeat.i(117004);
        if (Util.isNullOrNil(str) || asVar == null || Util.isNullOrNil(asVar.field_username)) {
            Log.e("MicroMsg.ContactStorage", "update : wrong input!");
            AppMethodBeat.o(117004);
            return 0;
        }
        Log.d("MicroMsg.ContactStorage", "updateEncryptUser contact: " + asVar.field_username + " enUsername: " + str);
        if (!ar(asVar)) {
            AppMethodBeat.o(117004);
            return 1;
        }
        if (as.IG(asVar.field_username)) {
            asVar.setUsername(as.bjz(asVar.field_username));
        }
        asVar.nd(asVar.aqN());
        this.OoJ.a(this, asVar);
        boolean z = this.OoJ.b(asVar, true) > 0;
        Log.d("MicroMsg.ContactStorage", "[update] ret=%s oldUsername=%s, username=%s, showHead=%d, verifyFlag=%d", Boolean.valueOf(z), str, asVar.field_username, Integer.valueOf(asVar.field_showHead), Integer.valueOf(asVar.field_verifyFlag));
        ContentValues convertTo = asVar.convertTo();
        if (!z && asVar.gMZ <= 0) {
            as asVar2 = new as(str);
            asVar2.setType(0);
            asVar2.setUsername("fake_" + Util.nowMilliSecond());
            asVar2.BK("fake_" + Util.nowMilliSecond());
            Log.d("MicroMsg.ContactStorage", "newContact.contactId <= 0 | delete " + bjE(str) + " user :" + str + ", res:" + this.db.update(bjE(str), asVar2.convertTo(), "username=?", new String[]{String.valueOf(str)}));
            if (convertTo.size() > 0) {
                i2 = (int) this.db.replace(bjE(asVar.field_username), com.tencent.mm.contact.c.info.primaryKey, convertTo);
            }
        } else if (!z) {
            if (!str.equals(asVar.field_username)) {
                as asVar3 = new as(str);
                asVar3.setType(0);
                asVar3.setUsername("fake_" + Util.nowMilliSecond());
                asVar3.BK("fake_" + Util.nowMilliSecond());
                Log.d("MicroMsg.ContactStorage", "delete " + bjE(str) + " user :" + str + ", res:" + this.db.update(bjE(str), asVar3.convertTo(), "username=?", new String[]{String.valueOf(str)}));
                if (convertTo.size() > 0) {
                    i2 = this.db.update(bjE(asVar.field_username), convertTo, "rowid=?", new String[]{new StringBuilder().append(asVar.gMZ).toString()});
                }
            } else if (convertTo.size() > 0) {
                int update = this.db.update(bjE(asVar.field_username), convertTo, "rowid=?", new String[]{new StringBuilder().append(asVar.gMZ).toString()});
                Log.i("MicroMsg.ContactStorage", "summercontact en equal username[%s], result1[%d], contactId[%d]", asVar.field_username, Integer.valueOf(update), Long.valueOf(asVar.gMZ));
                i2 = update;
            }
        }
        ayf(asVar.field_username);
        if (!Util.isNullOrNil(asVar.field_encryptUsername)) {
            ayf(asVar.field_encryptUsername);
        }
        doNotify(3, this, str);
        doNotify(3, this, asVar.field_username);
        AppMethodBeat.o(117004);
        return i2;
    }

    @Override // com.tencent.mm.storage.bv
    public final void e(String str, as asVar) {
        AppMethodBeat.i(117005);
        if (str == null) {
            AppMethodBeat.o(117005);
            return;
        }
        if (as.IG(str)) {
            str = as.bjz(str);
        }
        asVar.nd(asVar.aqN());
        if (ab.p(asVar)) {
            asVar.nd(43);
            asVar.BF(com.tencent.mm.platformtools.f.Si(asVar.arI()));
            asVar.BG(com.tencent.mm.platformtools.f.Sh(asVar.arI()));
            asVar.BI(com.tencent.mm.platformtools.f.Sh(asVar.arJ()));
            asVar.BJ(asVar.arJ());
            AppMethodBeat.o(117005);
            return;
        }
        if (ab.Js(asVar.field_username)) {
            Log.i("MicroMsg.ContactStorage", "update official account helper showhead %d", 31);
            asVar.nd(31);
        }
        this.OoJ.a(this, asVar);
        int b2 = this.OoJ.b(asVar, true);
        Log.d("MicroMsg.ContactStorage", "ret=%s username=%s, showHead=%d, verifyFlag=%d", Integer.valueOf(b2), asVar.field_username, Integer.valueOf(asVar.field_showHead), Integer.valueOf(asVar.field_verifyFlag));
        if (b2 > 0) {
            AppMethodBeat.o(117005);
            return;
        }
        ContentValues convertTo = asVar.convertTo();
        if (((int) asVar.gMZ) > 0) {
            convertTo.put("rowid", Integer.valueOf((int) asVar.gMZ));
        }
        if (convertTo.size() > 0) {
            this.db.update(bjE(str), convertTo, "username=?", new String[]{String.valueOf(str)});
        }
        AppMethodBeat.o(117005);
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor iL(List<String> list) {
        AppMethodBeat.i(117006);
        Assert.assertTrue(list.size() > 0);
        StringBuilder sb = new StringBuilder("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact ");
        sb.append(" where username IN (");
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 == list.size() - 1) {
                sb.append(" '").append(list.get(i2)).append("'");
            } else {
                sb.append(" '").append(list.get(i2)).append("',");
            }
        }
        sb.append(" )").append(gCf());
        Cursor rawQuery = this.db.rawQuery(sb.toString(), null);
        AppMethodBeat.o(117006);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor iM(List<String> list) {
        AppMethodBeat.i(117007);
        Assert.assertTrue(list.size() > 0);
        String str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where (";
        for (int i2 = 0; i2 < list.size(); i2++) {
            str = i2 != list.size() - 1 ? str + "username = '" + list.get(i2) + "' OR " : str + "username = '" + list.get(i2) + "'";
        }
        String str2 = str + ") order by case username ";
        for (int i3 = 0; i3 < list.size(); i3++) {
            str2 = str2 + " when '" + list.get(i3) + "' then " + i3;
        }
        String str3 = str2 + " end";
        Log.d("MicroMsg.ContactStorage", "getCursorByNamesInListOrder sql:".concat(String.valueOf(str3)));
        Cursor rawQuery = this.db.rawQuery(str3, null);
        AppMethodBeat.o(117007);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final List<String> gBZ() {
        AppMethodBeat.i(117008);
        Cursor rawQuery = this.db.rawQuery("select username from rcontact where " + gCj(), null, 2);
        ArrayList arrayList = new ArrayList();
        if (rawQuery == null) {
            AppMethodBeat.o(117008);
        } else {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            AppMethodBeat.o(117008);
        }
        return arrayList;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor gCa() {
        AppMethodBeat.i(117009);
        Cursor rawQuery = this.db.rawQuery("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where " + ("type & " + com.tencent.mm.contact.c.aro() + "=0 and username like '%@chatroom'"), null);
        AppMethodBeat.o(117009);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor gCb() {
        AppMethodBeat.i(186129);
        String str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + gCi() + " AND type & 256 !=0 ";
        Log.v("MicroMsg.ContactStorage", str);
        Cursor rawQuery = this.db.rawQuery(str, null);
        AppMethodBeat.o(186129);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor gCc() {
        AppMethodBeat.i(117011);
        String str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where " + OoL + " and verifyFlag & " + as.gBP() + " !=0 ";
        Log.v("MicroMsg.ContactStorage", "dkbf:".concat(String.valueOf(str)));
        Cursor rawQuery = this.db.rawQuery(str, null);
        AppMethodBeat.o(117011);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor gCd() {
        AppMethodBeat.i(117012);
        String str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + gCi() + " AND " + OoL + " AND " + OoK + gCg();
        Log.v("MicroMsg.ContactStorage", str);
        Cursor rawQuery = this.db.rawQuery(str, null);
        AppMethodBeat.o(117012);
        return rawQuery;
    }

    private static String iN(List<String> list) {
        AppMethodBeat.i(117013);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(117013);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(" or username = '").append(str).append("'");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(117013);
        return sb2;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor c(String str, String str2, List<String> list) {
        AppMethodBeat.i(117014);
        String str3 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + f(str, str2, list) + iN(null) + gCf();
        Log.v("MicroMsg.ContactStorage", str3);
        Cursor rawQuery = this.db.rawQuery(str3, null);
        AppMethodBeat.o(117014);
        return rawQuery;
    }

    private static String iO(List<String> list) {
        AppMethodBeat.i(117015);
        String iN = iN(list);
        int indexOf = iN.indexOf("or");
        if (indexOf <= 2) {
            iN = iN.substring(indexOf + 2);
        }
        AppMethodBeat.o(117015);
        return iN;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor x(List<String> list, boolean z) {
        AppMethodBeat.i(117016);
        String str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where " + iO(list);
        if (z) {
            str = str + " " + gCf();
        }
        Log.d("MicroMsg.ContactStorage", "sql ".concat(String.valueOf(str)));
        Cursor rawQuery = this.db.rawQuery(str, null);
        AppMethodBeat.o(117016);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor iP(List<String> list) {
        AppMethodBeat.i(117017);
        String str = ("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + gCi() + " and ( " + iO(list) + " ) ") + " order by case username ";
        for (int i2 = 0; i2 < list.size(); i2++) {
            str = str + " when '" + list.get(i2) + "' then " + i2;
        }
        String str2 = (str + " end ") + " limit 6";
        Log.d("MicroMsg.ContactStorage", "sql ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.db.rawQuery(str2, null);
        AppMethodBeat.o(117017);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor iQ(List<String> list) {
        AppMethodBeat.i(117018);
        Cursor rawQuery = this.db.rawQuery("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact where (" + OoL + ") and (" + iO(list) + ")" + gCg(), null);
        AppMethodBeat.o(117018);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor iR(List<String> list) {
        AppMethodBeat.i(117019);
        Cursor rawQuery = this.db.rawQuery("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact where (" + OoL + ") and (" + iO(list) + ")" + gCg() + " and (username like  '%@openim' )", null);
        AppMethodBeat.o(117019);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor iS(List<String> list) {
        AppMethodBeat.i(117020);
        String str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + y(list, false) + gCg();
        Log.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(str)));
        Log.i("MicroMsg.ContactStorage", "getFavCursor favourSql = %s", str);
        Cursor rawQuery = this.db.rawQuery(str, null);
        AppMethodBeat.o(117020);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor iT(List<String> list) {
        AppMethodBeat.i(117021);
        String str = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + iX(list) + gCg();
        Log.v("MicroMsg.ContactStorage", "favourSql ".concat(String.valueOf(str)));
        Log.i("MicroMsg.ContactStorage", "getFavCursorWithoutOpenIM favourSql = %s", str);
        Cursor rawQuery = this.db.rawQuery(str, null);
        AppMethodBeat.o(117021);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor d(String str, String str2, List<String> list) {
        AppMethodBeat.i(117022);
        Cursor c2 = c(str, str2, list);
        AppMethodBeat.o(117022);
        return c2;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor e(String str, String str2, List<String> list) {
        AppMethodBeat.i(117023);
        String str3 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + f(str, str2, list) + gCf();
        Log.v("MicroMsg.ContactStorage", str3);
        Cursor rawQuery = this.db.rawQuery(str3, null);
        AppMethodBeat.o(117023);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor mR(String str, String str2) {
        AppMethodBeat.i(185151);
        String str3 = "select username from rcontact " + f(str, str2, null);
        Log.v("MicroMsg.ContactStorage", str3);
        Cursor rawQuery = this.db.rawQuery(str3, null);
        AppMethodBeat.o(185151);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final int gCe() {
        int i2 = 0;
        AppMethodBeat.i(117024);
        String str = "select count(rowid) from rcontact " + f("@biz.contact", null, null);
        Log.v("MicroMsg.ContactStorage", str);
        Cursor rawQuery = this.db.rawQuery(str, null, 2);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(117024);
        return i2;
    }

    @Override // com.tencent.mm.storage.bv
    public final List<String> iU(List<String> list) {
        AppMethodBeat.i(117025);
        if (list.isEmpty()) {
            Log.w("MicroMsg.ContactStorage", "getFilterList: but white list is empty");
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.o(117025);
            return linkedList;
        }
        long currentTicks = Util.currentTicks();
        LinkedList linkedList2 = new LinkedList();
        StringBuilder sb = new StringBuilder();
        sb.append("username='").append(list.get(0)).append("'");
        for (int i2 = 1; i2 < list.size(); i2++) {
            sb.append(" or username='").append(list.get(i2)).append("'");
        }
        String format = String.format("select %s from %s where (%s) and (%s & %d != 0)  order by %s", ch.COL_USERNAME, "rcontact", sb.toString(), "type", Integer.valueOf(com.tencent.mm.contact.c.arn()), "showHead asc, " + "pyInitial asc, " + "quanPin asc, " + "nickname asc, " + "username asc ");
        Log.i("MicroMsg.ContactStorage", "getFilterList: sql is %s", format);
        Cursor rawQuery = this.db.rawQuery(format, null, 2);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                linkedList2.add(rawQuery.getString(0));
            }
            rawQuery.close();
        }
        Log.i("MicroMsg.ContactStorage", "getFilerList: use time[%d ms] whiteList[%s], usernameList[%s]", Long.valueOf(Util.ticksToNow(currentTicks)), list, linkedList2.toString());
        AppMethodBeat.o(117025);
        return linkedList2;
    }

    @Override // com.tencent.mm.storage.bv
    public final int[] b(String str, String str2, String[] strArr, List<String> list) {
        AppMethodBeat.i(117026);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.db.rawQuery("select distinct showHead from rcontact " + f(str, str2, list) + Y(strArr) + gCf(), null);
        Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct db.rawQuery last" + (System.currentTimeMillis() - currentTimeMillis));
        long currentTimeMillis2 = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct  cu.getCount() last" + (System.currentTimeMillis() - currentTimeMillis2));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i2 = 0; i2 < count; i2++) {
                rawQuery.moveToPosition(i2);
                iArr[i2] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(117026);
        return iArr;
    }

    @Override // com.tencent.mm.storage.bv
    public final int[] b(String[] strArr, String str, String str2, String str3, List<String> list) {
        AppMethodBeat.i(187491);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.db.rawQuery("select distinct showHead from rcontact " + f(str, str2, list) + Y(strArr) + bjR(str3) + gCf(), null);
        Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        long currentTimeMillis2 = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis2));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i2 = 0; i2 < count; i2++) {
                rawQuery.moveToPosition(i2);
                iArr[i2] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(187491);
        return iArr;
    }

    @Override // com.tencent.mm.storage.bv
    public final int[] iV(List<String> list) {
        AppMethodBeat.i(117028);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.db.rawQuery("select distinct showHead from rcontact  where (" + iO(list) + ") " + gCf(), null);
        Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        long currentTimeMillis2 = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis2));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i2 = 0; i2 < count; i2++) {
                rawQuery.moveToPosition(i2);
                iArr[i2] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(117028);
        return iArr;
    }

    @Override // com.tencent.mm.storage.bv
    public final int[] c(String[] strArr, String str, String str2, String str3, List<String> list) {
        AppMethodBeat.i(187492);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.db.rawQuery(("select count(*) from rcontact " + f(str, str2, list) + Y(strArr) + bjR(str3)) + " group by showHead", null);
        Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        long currentTimeMillis2 = System.currentTimeMillis();
        int count = rawQuery.getCount();
        Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis2));
        int[] iArr = null;
        if (count > 0) {
            iArr = new int[count];
            for (int i2 = 0; i2 < count; i2++) {
                rawQuery.moveToPosition(i2);
                iArr[i2] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(187492);
        return iArr;
    }

    @Override // com.tencent.mm.storage.bv
    public final int[] iW(List<String> list) {
        int[] iArr = null;
        AppMethodBeat.i(117030);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.db.rawQuery(("select count(*) from rcontact " + "where " + iO(list)) + " group by showHead", null, 2);
        Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        long currentTimeMillis2 = System.currentTimeMillis();
        int count = rawQuery.getCount();
        Log.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis2));
        if (count > 0) {
            iArr = new int[count];
            for (int i2 = 0; i2 < count; i2++) {
                rawQuery.moveToPosition(i2);
                iArr[i2] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(117030);
        return iArr;
    }

    @Override // com.tencent.mm.storage.bv
    public final int[] c(String str, String str2, String[] strArr, List<String> list) {
        int[] iArr = null;
        AppMethodBeat.i(117031);
        Cursor rawQuery = this.db.rawQuery(("select count(*) from rcontact " + f(str, str2, list) + Y(strArr)) + " group by showHead", null);
        if (rawQuery.getCount() > 0) {
            int count = rawQuery.getCount();
            iArr = new int[count];
            for (int i2 = 0; i2 < count; i2++) {
                rawQuery.moveToPosition(i2);
                iArr[i2] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(117031);
        return iArr;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor a(String[] strArr, String str, List<String> list) {
        AppMethodBeat.i(117032);
        String str2 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + f(str, null, list) + Y(strArr);
        if (strArr != null && strArr.length > 0) {
            str2 = str2 + " order by 1=1 ";
            for (int i2 = 0; i2 < strArr.length; i2++) {
                str2 = str2 + ",username='" + strArr[i2] + "' desc";
            }
        }
        Log.v("MicroMsg.ContactStorage", "getSearchCursorByArrOrder sql : ".concat(String.valueOf(str2)));
        Cursor rawQuery = this.db.rawQuery(str2, null);
        AppMethodBeat.o(117032);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor a(String[] strArr, String str, String str2, List<String> list, List<String> list2) {
        AppMethodBeat.i(117033);
        if (strArr == null || strArr.length == 0) {
            Cursor gFu = d.gFu();
            AppMethodBeat.o(117033);
            return gFu;
        }
        String str3 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + f(str, str2, list2) + Y(strArr) + L(str2, list) + gCf();
        Log.i("MicroMsg.ContactStorage", str3);
        Cursor rawQuery = this.db.rawQuery(str3, null);
        AppMethodBeat.o(117033);
        return rawQuery;
    }

    private static String L(String str, List<String> list) {
        AppMethodBeat.i(117034);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(117034);
            return "";
        }
        String str2 = " and (";
        if (!(list == null || list.size() == 0)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                str2 = str2 + "username = '" + it.next() + "' or ";
            }
            str2 = str2;
        }
        String str3 = (((((((str2 + "conRemark like '%" + str + "%' or ") + "conRemarkPYFull like '%" + str + "%' or ") + "conRemarkPYShort like '%" + str + "%' or ") + "alias like '%" + str + "%' or ") + "username like '%" + str + "%' or ") + "nickname like '%" + str + "%' or ") + "pyInitial like '%" + str + "%' or ") + "quanPin like '%" + str + "%' )";
        AppMethodBeat.o(117034);
        return str3;
    }

    private static String Y(String[] strArr) {
        AppMethodBeat.i(117035);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(117035);
            return "";
        }
        String str = " and (";
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (i2 > 0) {
                str = str + " or ";
            }
            str = str + "username = '" + strArr[i2] + "' ";
        }
        String str2 = str + " )";
        AppMethodBeat.o(117035);
        return str2;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor d(String[] strArr, String str, String str2, String str3, List<String> list) {
        AppMethodBeat.i(187493);
        String str4 = "select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact " + f(str2, str3, list) + Y(strArr) + bjR(str) + gCf();
        Log.v("MicroMsg.ContactStorage", str4);
        Cursor rawQuery = this.db.rawQuery(str4, null);
        AppMethodBeat.o(187493);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final String bjR(String str) {
        AppMethodBeat.i(117036);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(117036);
            return "";
        }
        String str2 = (((((((" and (" + "conRemark like '%" + str + "%' or ") + "conRemarkPYFull like '%" + str + "%' or ") + "conRemarkPYShort like '%" + str + "%' or ") + "alias like '%" + str + "%' or ") + "username like '%" + str + "%' or ") + "nickname like '%" + str + "%' or ") + "pyInitial like '%" + str + "%' or ") + "quanPin like '%" + str + "%' )";
        AppMethodBeat.o(117036);
        return str2;
    }

    private static String gCf() {
        AppMethodBeat.i(117037);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" order by showHead asc, ");
        stringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" upper(quanPin) asc, ");
        stringBuffer.append(" upper(nickname) asc, ");
        stringBuffer.append(" upper(username) asc ");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(117037);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.storage.bv
    public final String aZD() {
        AppMethodBeat.i(263546);
        String gCf = gCf();
        AppMethodBeat.o(263546);
        return gCf;
    }

    private static String gCg() {
        AppMethodBeat.i(117039);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" order by case when verifyFlag & " + as.gBP() + " != 0 then 0 else 1 end , showHead asc, ");
        stringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" upper(quanPin) asc, ");
        stringBuffer.append(" upper(nickname) asc, ");
        stringBuffer.append(" upper(username) asc ");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(117039);
        return stringBuffer2;
    }

    private static String aY(boolean z, boolean z2) {
        AppMethodBeat.i(117040);
        String str = "type & " + com.tencent.mm.contact.c.arn() + "!=0";
        if (z) {
            str = str + " or type & " + com.tencent.mm.contact.c.art() + "!=0";
        }
        String str2 = ((" where (" + str + ")") + " and type & " + com.tencent.mm.contact.c.aru() + "=0 ") + " and type & " + com.tencent.mm.contact.c.aro() + " =0 ";
        if (!z2) {
            str2 = str2 + " and verifyFlag & " + as.gBP() + " =0 ";
        }
        AppMethodBeat.o(117040);
        return str2;
    }

    private static String gCh() {
        AppMethodBeat.i(117041);
        String str = ((" where (" + ("type & " + com.tencent.mm.contact.c.arn() + " !=0 ") + ") and ") + "type & " + com.tencent.mm.contact.c.aru() + " =0 and ") + "type & " + com.tencent.mm.contact.c.aro() + " =0";
        AppMethodBeat.o(117041);
        return str;
    }

    private static String gCi() {
        AppMethodBeat.i(117042);
        String str = (" where (" + ("type & " + com.tencent.mm.contact.c.arn() + "!=0") + ") and ") + "type & " + com.tencent.mm.contact.c.aru() + "=0  ";
        AppMethodBeat.o(117042);
        return str;
    }

    private static String gCj() {
        AppMethodBeat.i(117043);
        String str = "( (" + ("type & " + com.tencent.mm.contact.c.arn() + "!=0") + ") and type & " + com.tencent.mm.contact.c.aro() + "=0 and (username like '%@chatroom') or (username like '%@im.chatroom" + "'))";
        AppMethodBeat.o(117043);
        return str;
    }

    private static String gCk() {
        AppMethodBeat.i(117044);
        String str = "( (" + ("type & " + com.tencent.mm.contact.c.arn() + "!=0") + ") and type & " + com.tencent.mm.contact.c.aro() + "=0 and username like '%@talkroom')";
        AppMethodBeat.o(117044);
        return str;
    }

    private static String gCl() {
        AppMethodBeat.i(117045);
        String str = "type & " + com.tencent.mm.contact.c.aro() + "=0 and username like '%@openim'";
        AppMethodBeat.o(117045);
        return str;
    }

    private static String gCm() {
        AppMethodBeat.i(117046);
        String str = gCi() + " and " + gCl();
        AppMethodBeat.o(117046);
        return str;
    }

    private static String y(List<String> list, boolean z) {
        AppMethodBeat.i(117047);
        String str = aY(false, z) + " AND " + OoL;
        String str2 = "";
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                str2 = str2 + " AND username != '" + it.next() + "'";
            }
            str2 = str2;
        }
        String str3 = str + str2;
        AppMethodBeat.o(117047);
        return str3;
    }

    private static String iX(List<String> list) {
        AppMethodBeat.i(117048);
        String str = (aY(false, false) + " AND " + OoL) + " and ( username not like '%@openim')";
        String str2 = "";
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                str2 = str2 + " AND username != '" + it.next() + "'";
            }
            str2 = str2;
        }
        String str3 = str + str2;
        AppMethodBeat.o(117048);
        return str3;
    }

    @Override // com.tencent.mm.storage.bv
    public final String f(String str, String str2, List<String> list) {
        String str3;
        boolean z = true;
        AppMethodBeat.i(117049);
        if (str == null || str.equals("@all.android")) {
            str3 = "" + aY(true, false);
        } else if (str.equals("@all.contact.android")) {
            str3 = "" + gCi();
        } else if (str.equals("@all.chatroom.contact")) {
            str3 = "" + ((" where (" + ("(type & " + com.tencent.mm.contact.c.arn() + "!=0 and (username like '%@chatroom' or username like '%@im.chatroom" + "'))") + ") and ") + "type & " + com.tencent.mm.contact.c.aru() + "=0 ");
        } else if (str.equals("@all.contact.without.chatroom")) {
            StringBuilder append = new StringBuilder().append("");
            String aY = aY(false, false);
            if (aY == null || aY.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(aY + " and ( username not like '%@%'" + (" or (" + gCk() + ')' + " or (" + gCl() + ")") + ")").toString();
        } else if (str.equals("@all.contact.without.chatroom.without.openim") || str.equals("@all.contact.without.chatroom.without.openim.without.openimfavour")) {
            StringBuilder append2 = new StringBuilder().append("");
            String aY2 = aY(false, false);
            if (aY2 == null || aY2.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append2.append(aY2 + " and ( username not like '%@%'" + (" or (" + gCk() + ')') + ")").toString();
        } else if (str.equals("@black.android")) {
            str3 = "" + (" where type & " + com.tencent.mm.contact.c.aro() + "!=0");
        } else if (str.equals("@werun.black.android")) {
            str3 = "" + (" where type & " + com.tencent.mm.contact.c.arp() + "!=0");
        } else if (str.equals("@social.black.android")) {
            str3 = "" + (gCi() + " and type & " + com.tencent.mm.contact.c.arq() + "!=0");
        } else if (str.equals("@finder.block.his.liked.android")) {
            str3 = "" + (gCi() + " and type & " + com.tencent.mm.contact.c.arr() + "!=0");
        } else if (str.equals("@finder.block.my.liked.android")) {
            str3 = "" + (gCi() + " and type & " + com.tencent.mm.contact.c.ars() + "!=0");
        } else if (str.equals("@t.qq.com")) {
            str3 = "" + (" where username like '%" + "@t.qq.com" + "'");
        } else if (str.equals("@domain.android")) {
            StringBuilder append3 = new StringBuilder().append("");
            String aY3 = aY(true, false);
            if (aY3 == null || aY3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append3.append(aY3 + " and domainList like '%" + str2 + "%'").toString();
        } else if (str.equals("@micromsg.qq.com")) {
            StringBuilder append4 = new StringBuilder().append("");
            String aY4 = aY(false, false);
            if (aY4 == null || aY4.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append4.append(aY4 + " and ( username not like '%@%'" + (" or (" + gCj() + ')') + (" or (" + gCk() + ')') + ")").toString();
        } else if (str.equals("@micromsg.no.verify.biz.qq.com")) {
            StringBuilder append5 = new StringBuilder().append("");
            String str4 = (((" where (" + ("type & " + com.tencent.mm.contact.c.arn() + " !=0 ") + ") and ") + "type & " + com.tencent.mm.contact.c.aru() + " =0 and ") + "type & " + com.tencent.mm.contact.c.aro() + " =0 and ") + "verifyFlag & " + as.gBP() + " =0";
            if (str4 == null || str4.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append5.append(str4 + " and ( username not like '%@%'" + (" or (" + gCj() + ')') + ")").toString();
        } else if (str.equals("@micromsg.with.all.biz.qq.com")) {
            StringBuilder append6 = new StringBuilder().append("");
            String gCh = gCh();
            if (gCh == null || gCh.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append6.append(gCh + " and ( username not like '%@%'" + (" or (" + gCj() + ')') + ")").toString();
        } else if (str.equals("@micromsg.with.all.biz.qq.com.openim")) {
            StringBuilder append7 = new StringBuilder().append("");
            String gCh2 = gCh();
            if (gCh2 == null || gCh2.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append7.append(gCh2 + " and ( username not like '%@%'" + (" or (" + gCj() + ')') + " or (username like '%@openim'))").toString();
        } else if (str.equals("@qqim")) {
            StringBuilder append8 = new StringBuilder().append("");
            String aY5 = aY(false, false);
            if (aY5 == null || aY5.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append8.append(aY5 + " and username like '%" + "@qqim" + "'").toString();
        } else if (str.equals("@all.chatroom")) {
            str3 = "" + (" where (" + (((("type & " + com.tencent.mm.contact.c.arn() + " !=0") + " or type & 2 !=0") + " or type & 4 !=0") + " or 1") + ") ");
        } else if (str.equals("@verify.contact")) {
            str3 = "" + (" where (" + (("type & " + com.tencent.mm.contact.c.arn() + " != 0 and ") + "verifyFlag & " + as.gBO() + " != 0") + ") ");
        } else if (str.equals("@biz.contact")) {
            str3 = "" + (" where (" + (("type & " + com.tencent.mm.contact.c.arn() + " != 0 and ") + "verifyFlag & " + as.gBP() + " != 0") + ") ");
        } else if (str.equals("@all.weixin.android")) {
            str3 = "" + (" where (" + ("type & " + com.tencent.mm.contact.c.arn() + " != 0 or  (username not like '%@qqim' and username not like '%@qr" + "' and username not like '%@bottle' and username not like '%@fb" + "' and username not like '%@google' and username not like '%@t.qq.com" + "' and username not like '%@t.sina.com' and username not like '%@t.sina.com" + "')") + ") ");
        } else if (str.equals("@openim.contact")) {
            str3 = "" + gCm();
        } else {
            Log.d("MicroMsg.ContactStorage", "unknow role type");
            str3 = "" + aY(false, false);
        }
        String str5 = "";
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                str5 = str5 + " and username != '" + it.next() + "'";
            }
            str5 = str5;
        }
        String str6 = str3 + str5;
        AppMethodBeat.o(117049);
        return str6;
    }

    @Override // com.tencent.mm.storage.bv
    public final int bjS(String str) {
        int i2;
        AppMethodBeat.i(187495);
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = "select count(username) from rcontact" + f(str, null, null) + bjR(null);
        Cursor rawQuery = this.db.rawQuery(str2, null, 2);
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            i2 = 0;
        } else {
            i2 = rawQuery.getInt(0);
            rawQuery.close();
        }
        Log.i("MicroMsg.ContactStorage", "getCountByFilterType, sql:%s, count:%d, time:%d", str2, Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(187495);
        return i2;
    }

    @Override // com.tencent.mm.storage.bv
    public final int c(String[] strArr, String... strArr2) {
        int i2;
        AppMethodBeat.i(117050);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("select count(username) from rcontact where ");
        sb.append("type & ").append(com.tencent.mm.contact.c.arn()).append(" !=0 and ");
        sb.append("type & ").append(com.tencent.mm.contact.c.aru()).append(" =0 and ");
        sb.append("type & ").append(com.tencent.mm.contact.c.aro()).append(" =0 and ");
        sb.append("verifyFlag & 8 = 0 ");
        sb.append(" and ( username not like '%@%')");
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!"weixin".equals(str)) {
                    sb.append(" and rcontact.username != '").append(str).append("'");
                }
            }
        }
        for (int i3 = 0; i3 < 4; i3++) {
            String str2 = strArr2[i3];
            if (!"weixin".equals(str2)) {
                sb.append(" and rcontact.username != '").append(str2).append("'");
            }
        }
        sb.append(" or username = 'weixin'");
        String sb2 = sb.toString();
        Cursor rawQuery = this.db.rawQuery(sb2, null, 2);
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            i2 = 0;
        } else {
            i2 = rawQuery.getInt(0);
            rawQuery.close();
        }
        Log.i("MicroMsg.ContactStorage", "getNormalContactCount, sql:%s, result:%d, time:%d", sb2, Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(117050);
        return i2;
    }

    @Override // com.tencent.mm.storage.bv
    public final int gCn() {
        int i2;
        AppMethodBeat.i(187496);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("select count(username) from rcontact where ");
        sb.append("type & ").append(com.tencent.mm.contact.c.arn()).append(" !=0 and ");
        sb.append("type & ").append(com.tencent.mm.contact.c.aru()).append(" =0 and ");
        sb.append("type & ").append(com.tencent.mm.contact.c.aro()).append(" =0 ");
        sb.append(" limit 1000 ");
        String sb2 = sb.toString();
        Cursor rawQuery = this.db.rawQuery(sb2, null, 2);
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            i2 = 0;
        } else {
            i2 = rawQuery.getInt(0);
            rawQuery.close();
        }
        Log.i("MicroMsg.ContactStorage", "getNormalContactAndHelperCount, sql:%s, result:%d, time:%d", sb2, Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(187496);
        return i2;
    }

    @Override // com.tencent.mm.storage.bv
    public final int d(String[] strArr, String... strArr2) {
        int i2;
        AppMethodBeat.i(117051);
        StringBuilder sb = new StringBuilder();
        sb.append("select count(username) from rcontact where ");
        sb.append("type & ").append(com.tencent.mm.contact.c.arn()).append(" !=0 and ");
        sb.append("type & ").append(com.tencent.mm.contact.c.aru()).append(" =0 and ");
        sb.append("type & ").append(com.tencent.mm.contact.c.aro()).append(" =0 and ");
        sb.append("verifyFlag & 8 = 0 and ");
        sb.append("(( username like '%@chatroom') or ");
        sb.append("( username like '%@im.chatroom'))");
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                sb.append(" and rcontact.username != '").append(str).append("'");
            }
        }
        for (int i3 = 0; i3 < 4; i3++) {
            sb.append(" and rcontact.username != '").append(strArr2[i3]).append("'");
        }
        String sb2 = sb.toString();
        Cursor rawQuery = this.db.rawQuery(sb2, null, 2);
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            i2 = 0;
        } else {
            i2 = rawQuery.getInt(0);
            rawQuery.close();
        }
        Log.v("MicroMsg.ContactStorage", "getChatroomContactCount, sql:%s, result:%d", sb2, Integer.valueOf(i2));
        AppMethodBeat.o(117051);
        return i2;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor gCo() {
        AppMethodBeat.i(117052);
        Cursor rawQuery = this.db.rawQuery("select  username, alias, conRemark, domainList, nickname, pyInitial, quanPin, showHead, type, weiboFlag, weiboNickname, conRemarkPYFull, conRemarkPYShort, lvbuff, verifyFlag, encryptUsername, chatroomFlag, deleteFlag, contactLabelIds, descWordingId, openImAppid, sourceExtInfo, rowid from rcontact  where rowid = -1", null);
        AppMethodBeat.o(117052);
        return rawQuery;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx
    public final boolean shouldProcessEvent() {
        AppMethodBeat.i(117053);
        if (this.db == null || this.db.isClose()) {
            Object[] objArr = new Object[1];
            objArr[0] = this.db == null ? BuildConfig.COMMAND : Boolean.valueOf(this.db.isClose());
            Log.w("MicroMsg.ContactStorage", "shouldProcessEvent db is close :%s", objArr);
            AppMethodBeat.o(117053);
            return false;
        }
        AppMethodBeat.o(117053);
        return true;
    }

    private static boolean ar(as asVar) {
        boolean z = false;
        AppMethodBeat.i(117054);
        if (asVar == null) {
            AppMethodBeat.o(117054);
        } else {
            int i2 = asVar.versionCode;
            if (i2 > 0) {
                z = true;
            }
            Log.d("MicroMsg.ContactStorage", "it need to update contact: " + z + " version code : " + i2 + " user: " + asVar.field_username);
            AppMethodBeat.o(117054);
        }
        return z;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor gCp() {
        AppMethodBeat.i(117055);
        StringBuilder sb = new StringBuilder();
        sb.append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
        sb.append("type & ").append(com.tencent.mm.contact.c.arn()).append(" !=0 and ");
        sb.append("type & ").append(com.tencent.mm.contact.c.aru()).append(" =0 and ");
        sb.append("type & ").append(com.tencent.mm.contact.c.aro()).append(" =0 and ");
        sb.append("verifyFlag & 8 = 0 and ");
        sb.append("( username not like '%@%')");
        sb.append(" or username = 'weixin'");
        String sb2 = sb.toString();
        Cursor rawQuery = this.db.rawQuery(sb2, null, 2);
        Log.i("MicroMsg.ContactStorage", "[oneliang]getNormalContactCursor, sql:%s", sb2);
        AppMethodBeat.o(117055);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final Cursor gCq() {
        AppMethodBeat.i(117056);
        StringBuilder sb = new StringBuilder();
        sb.append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
        sb.append("type & ").append(com.tencent.mm.contact.c.arn()).append(" !=0 and ");
        sb.append("type & ").append(com.tencent.mm.contact.c.aru()).append(" =0 and ");
        sb.append("type & ").append(com.tencent.mm.contact.c.aro()).append(" =0 and ");
        sb.append("verifyFlag & 8 = 0 and ");
        sb.append("( username not like '%@%')");
        sb.append(" or username = 'weixin'");
        Cursor rawQuery = this.db.rawQuery(sb.toString(), null, 2);
        AppMethodBeat.o(117056);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bv
    public final String bjT(String str) {
        AppMethodBeat.i(117057);
        as bjU = bjU(str);
        if (bjU != null) {
            Log.i("MicroMsg.ContactStorage", "getSendMsgTicket %s %s", Util.nullAs(str, ""), Integer.valueOf(Util.nullAs(bjU.field_ticket, "").length()));
            String str2 = bjU.field_ticket;
            AppMethodBeat.o(117057);
            return str2;
        }
        Log.e("MicroMsg.ContactStorage", "getSendMsgTicket ca == null");
        AppMethodBeat.o(117057);
        return "";
    }

    private as bjU(String str) {
        AppMethodBeat.i(117058);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(117058);
            return null;
        } else if (as.IG(str)) {
            AppMethodBeat.o(117058);
            return null;
        } else {
            as asVar = new as();
            Cursor rawQuery = this.db.rawQuery("select  *,rowid  from rcontact where username=" + h.Fl(str) + " or encryptUsername=" + h.Fl(str), null, 2);
            if (rawQuery.moveToFirst()) {
                asVar.convertFrom(rawQuery);
                rawQuery.close();
                asVar.gBS();
                d(asVar, false);
            } else {
                rawQuery.close();
            }
            AppMethodBeat.o(117058);
            return asVar;
        }
    }

    @Override // com.tencent.mm.storage.bv
    public final int mS(String str, String str2) {
        AppMethodBeat.i(117059);
        Log.i("MicroMsg.ContactStorage", "updateSendMsgTicketByUser %s %s", Util.nullAs(str, ""), Integer.valueOf(Util.nullAs(str2, "").length()));
        as bjU = bjU(str);
        if (bjU == null) {
            AppMethodBeat.o(117059);
            return 0;
        } else if (Util.isEqual(bjU.field_ticket, str2)) {
            AppMethodBeat.o(117059);
            return 0;
        } else {
            bjU.BP(str2);
            int c2 = c(str, bjU);
            AppMethodBeat.o(117059);
            return c2;
        }
    }

    @Override // com.tencent.mm.storage.bv
    public final int ce(String str, long j2) {
        AppMethodBeat.i(169111);
        Log.i("MicroMsg.ContactStorage", "updateSendMsgTicketByUser %s %s", Util.nullAs(str, ""), Long.valueOf(j2));
        as bjJ = bjJ(str);
        if (bjJ == null) {
            AppMethodBeat.o(169111);
            return 0;
        } else if (Util.isEqual(bjJ.fvd, j2)) {
            AppMethodBeat.o(169111);
            return 0;
        } else {
            bjJ.yy(j2);
            int c2 = c(str, bjJ);
            AppMethodBeat.o(169111);
            return c2;
        }
    }

    private as bjV(String str) {
        AppMethodBeat.i(187497);
        as asVar = new as();
        Cursor rawQuery = this.db.rawQuery(bjD(str) + " where username=" + h.Fl(str) + " or encryptUsername=" + h.Fl(str), null, 2);
        if (rawQuery.moveToFirst()) {
            asVar.convertFrom(rawQuery);
            rawQuery.close();
            asVar.gBS();
            d(asVar, false);
        } else {
            rawQuery.close();
        }
        AppMethodBeat.o(187497);
        return asVar;
    }

    @Override // com.tencent.mm.storage.bv
    public final boolean an(as asVar) {
        AppMethodBeat.i(116977);
        if (bjN(asVar.field_username)) {
            if (c(asVar.field_username, asVar) == 0) {
                AppMethodBeat.o(116977);
                return true;
            }
            AppMethodBeat.o(116977);
            return false;
        } else if (aq(asVar) >= 0) {
            AppMethodBeat.o(116977);
            return true;
        } else {
            AppMethodBeat.o(116977);
            return false;
        }
    }

    @Override // com.tencent.mm.storage.bv
    public final int aq(as asVar) {
        AppMethodBeat.i(116998);
        if (Util.nullAsNil(asVar.field_username).length() <= 0) {
            Log.e("MicroMsg.ContactStorage", "FATAL ERROR, invalid contact, empty username");
            AppMethodBeat.o(116998);
            return -1;
        }
        asVar.nd(asVar.aqN());
        this.OoJ.a(this, asVar);
        int b2 = this.OoJ.b(asVar, false);
        Log.i("MicroMsg.ContactStorage", "extensions replace=%s %s", Integer.valueOf(b2), asVar.field_username);
        if (b2 < 0) {
            ContentValues convertTo = asVar.convertTo();
            long currentTimeMillis = System.currentTimeMillis();
            int insert = (int) this.db.insert(bjE(asVar.field_username), com.tencent.mm.contact.c.info.primaryKey, convertTo);
            int milliSecondsToNow = (int) Util.milliSecondsToNow(currentTimeMillis);
            boolean z = CrashReportFactory.foreground;
            com.tencent.mm.plugin.report.e.INSTANCE.b(463, z ? 11 : 14, z ? 12 : 15, milliSecondsToNow, false);
            Log.i("MicroMsg.ContactStorage", "insert : username=%s, showHead=%d, verifyFlag=%d, ret=:%d take[%s]ms fg:%b", asVar.field_username, Integer.valueOf(asVar.field_showHead), Integer.valueOf(asVar.field_verifyFlag), Integer.valueOf(insert), Integer.valueOf(milliSecondsToNow), Boolean.valueOf(z));
            if (insert != -1) {
                asVar.gMZ = (long) insert;
                d(asVar, false);
                doNotify(2, this, asVar.field_username);
                AppMethodBeat.o(116998);
                return insert;
            }
            Log.e("MicroMsg.ContactStorage", "insert failed: username=%s", asVar.field_username);
            b2 = insert;
        }
        AppMethodBeat.o(116998);
        return b2;
    }
}
