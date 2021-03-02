package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.op;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.fcu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class z extends x {
    public z(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, "WxaAttributesTable", WxaAttributes.INDEX_CREATE);
        AppMethodBeat.i(44905);
        if (bAh()) {
            ISQLiteDatabaseEx iSQLiteDatabaseEx = (ISQLiteDatabaseEx) iSQLiteDatabase;
            if (!g.aAh().azQ().getBoolean(ar.a.APPBRAND_SHORTCUT_URL_UPGRADE_FIXED_BOOLEAN_SYNC, false)) {
                Log.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "before fix");
                Cursor rawQuery = iSQLiteDatabaseEx.rawQuery("select appInfo from WxaAttributesTable", null, 2);
                if (rawQuery == null || rawQuery.isClosed()) {
                    Log.e("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "try fix but db not working");
                    AppMethodBeat.o(44905);
                    return;
                }
                if (rawQuery.moveToFirst()) {
                    LinkedList<Pair> linkedList = new LinkedList();
                    do {
                        String string = rawQuery.getString(0);
                        if (!Util.isNullOrNil(string)) {
                            try {
                                JSONObject jSONObject = new JSONObject(string);
                                String optString = jSONObject.optString("Appid");
                                String optString2 = jSONObject.optString("RoundedSquareIconUrl");
                                if (!Util.isNullOrNil(optString) && !Util.isNullOrNil(optString2)) {
                                    ContentValues contentValues = new ContentValues(1);
                                    contentValues.put("roundedSquareIconURL", optString2);
                                    linkedList.add(Pair.create(optString, contentValues));
                                }
                            } catch (Exception e2) {
                            }
                        }
                    } while (rawQuery.moveToNext());
                    rawQuery.close();
                    long beginTransaction = iSQLiteDatabaseEx.beginTransaction(Thread.currentThread().getId());
                    for (Pair pair : linkedList) {
                        iSQLiteDatabaseEx.update("WxaAttributesTable", (ContentValues) pair.second, "appId=?", new String[]{(String) pair.first});
                    }
                    iSQLiteDatabaseEx.endTransaction(beginTransaction);
                    Log.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "fix done");
                } else {
                    Log.i("MicroMsg.AppBrand.WxaAttributeDesktopURLFix", "no contacts available");
                }
                if (!rawQuery.isClosed()) {
                    rawQuery.close();
                }
                g.aAh().azQ().set(ar.a.APPBRAND_SHORTCUT_URL_UPGRADE_FIXED_BOOLEAN_SYNC, Boolean.TRUE);
            }
        }
        AppMethodBeat.o(44905);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage, com.tencent.mm.sdk.storage.IStorage
    public void add(MStorage.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(226475);
        super.add("MicroMsg.WxaAttrStorageWC.WORKER", iOnStorageChange);
        AppMethodBeat.o(226475);
    }

    @Override // com.tencent.mm.plugin.appbrand.config.x
    public final boolean a(String str, b bVar, List<fcu> list) {
        bh buL;
        AppMethodBeat.i(44906);
        if (!g.aAf().hpY) {
            Log.e("MicroMsg.WxaAttrStorageWC", "flushAttrs username[%s], account().isInitializedNotifyAllDone()==FALSE", str);
            AppMethodBeat.o(44906);
            return false;
        }
        boolean a2 = super.a(str, bVar, list);
        final WxaAttributes d2 = super.d(str, "appId", "versionInfo", "nickname", "bigHeadURL", "smallHeadURL");
        if (d2 == null) {
            Log.e("MicroMsg.WxaAttrStorageWC", "flushAttrs, get NULL record with username[%s]", str);
            AppMethodBeat.o(44906);
            return a2;
        }
        WxaAttributes.WxaVersionInfo bAp = d2.bAp();
        if (!(bAp == null || bAp.cyu != 0 || (buL = n.buL()) == null)) {
            buL.a(d2.field_appId, d2.bAp());
        }
        if (a2) {
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.config.z.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(44903);
                    try {
                        z.f(d2);
                        AppMethodBeat.o(44903);
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.WxaAttrStorageWC", e2, "flushContactInMainDB", new Object[0]);
                        AppMethodBeat.o(44903);
                    }
                }
            }, "MicroMsg.WxaAttrStorageWCTHREAD_TAG_POST_FLUSH_ATTRS");
        }
        AppMethodBeat.o(44906);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.config.x
    public final boolean k(String str, int i2, boolean z) {
        AppMethodBeat.i(44907);
        boolean k = super.k(str, i2, z);
        if (k) {
            WxaAttributes d2 = d(str, "appOpt");
            op opVar = new op();
            opVar.dUD.dCl = str;
            opVar.dUD.dUE = d2.field_appOpt;
            EventCenter.instance.publish(opVar);
        }
        AppMethodBeat.o(44907);
        return k;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.config.x
    public final boolean a(WxaAttributes wxaAttributes, fcu fcu) {
        AppMethodBeat.i(44908);
        boolean a2 = super.a(wxaAttributes, fcu);
        if (a2 && "WxaAppInfo".equals(fcu.xMX)) {
            final String str = wxaAttributes.field_appId;
            final String str2 = fcu.Cyk;
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.config.z.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(44904);
                    try {
                        q.b(str, u.E(new JSONObject(str2)).KIo);
                        AppMethodBeat.o(44904);
                    } catch (Exception e2) {
                        AppMethodBeat.o(44904);
                    }
                }
            }, "MicroMsg.WxaAttrStorageWCTHREAD_TAG_POST_FLUSH_ATTRS");
        }
        AppMethodBeat.o(44908);
        return a2;
    }

    static /* synthetic */ void f(WxaAttributes wxaAttributes) {
        boolean z;
        as asVar;
        boolean z2 = false;
        boolean z3 = true;
        AppMethodBeat.i(44909);
        if (g.aAc()) {
            String str = wxaAttributes.field_username;
            String str2 = wxaAttributes.field_nickname;
            String str3 = wxaAttributes.field_bigHeadURL;
            String str4 = wxaAttributes.field_smallHeadURL;
            i Mx = p.aYB().Mx(str);
            if (Mx == null) {
                Mx = new i();
                z = true;
            } else {
                z = false;
            }
            if (!Util.nullAsNil(str4).equals(Mx.aYu())) {
                Mx.iKW = str4;
                z = true;
            }
            if (!Util.nullAsNil(str3).equals(Mx.aYt())) {
                Mx.iKX = str3;
                z = true;
            }
            if (z) {
                Mx.username = str;
                Mx.fv(true);
                Mx.cSx = 31;
                p.aYB().b(Mx);
            }
            as Kn = ((l) g.af(l.class)).aSN().Kn(str);
            if (Kn == null) {
                asVar = new as();
            } else {
                asVar = Kn;
            }
            if (((int) asVar.gMZ) == 0) {
                asVar.setUsername(str);
                z2 = true;
            }
            if (!str2.equals(asVar.field_nickname)) {
                asVar.setNickname(str2);
                try {
                    asVar.BF(f.Si(str2));
                } catch (UnsatisfiedLinkError e2) {
                }
                try {
                    asVar.BG(f.Sh(str2));
                } catch (UnsatisfiedLinkError e3) {
                }
            } else {
                z3 = z2;
            }
            if (z3) {
                ((l) g.af(l.class)).aSN().an(asVar);
            }
        }
        AppMethodBeat.o(44909);
    }
}
