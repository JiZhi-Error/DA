package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.protocal.protobuf.fcu;
import com.tencent.mm.protocal.protobuf.fcx;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class x extends MAutoStorage<WxaAttributes> {
    final ISQLiteDatabase db;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public /* synthetic */ boolean delete(WxaAttributes wxaAttributes, boolean z, String[] strArr) {
        AppMethodBeat.i(146058);
        boolean b2 = b(wxaAttributes, z, strArr);
        AppMethodBeat.o(146058);
        return b2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public /* synthetic */ boolean get(WxaAttributes wxaAttributes, String[] strArr) {
        AppMethodBeat.i(146057);
        boolean a2 = a(wxaAttributes, strArr);
        AppMethodBeat.o(146057);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public /* synthetic */ boolean insertNotify(WxaAttributes wxaAttributes, boolean z) {
        AppMethodBeat.i(146059);
        boolean a2 = a(wxaAttributes, z);
        AppMethodBeat.o(146059);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public /* synthetic */ boolean updateNotify(WxaAttributes wxaAttributes, boolean z, String[] strArr) {
        AppMethodBeat.i(146056);
        boolean a2 = a(wxaAttributes, z, strArr);
        AppMethodBeat.o(146056);
        return a2;
    }

    public x(ISQLiteDatabase iSQLiteDatabase, String str, String[] strArr) {
        super(iSQLiteDatabase, WxaAttributes.kLR, str, strArr);
        this.db = iSQLiteDatabase;
    }

    public final boolean bAh() {
        AppMethodBeat.i(146045);
        if (this.db == null || this.db.isClose()) {
            AppMethodBeat.o(146045);
            return false;
        }
        AppMethodBeat.o(146045);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final long Xo(String str) {
        AppMethodBeat.i(229818);
        WxaAttributes d2 = d(str, "syncTimeSecond");
        if (d2 == null) {
            AppMethodBeat.o(229818);
            return 0;
        }
        long j2 = d2.field_syncTimeSecond;
        AppMethodBeat.o(229818);
        return j2;
    }

    /* access modifiers changed from: package-private */
    public final b Xp(String str) {
        byte[] decodeHexString;
        AppMethodBeat.i(146046);
        WxaAttributes d2 = d(str, "syncVersion");
        if (d2 == null) {
            decodeHexString = new byte[0];
        } else {
            decodeHexString = Util.decodeHexString(Util.nullAsNil(d2.field_syncVersion));
        }
        b bVar = new b(decodeHexString);
        AppMethodBeat.o(146046);
        return bVar;
    }

    private long bAi() {
        AppMethodBeat.i(182788);
        if (this.db instanceof ISQLiteDatabaseEx) {
            long beginTransaction = ((ISQLiteDatabaseEx) this.db).beginTransaction(Thread.currentThread().getId());
            AppMethodBeat.o(182788);
            return beginTransaction;
        }
        AppMethodBeat.o(182788);
        return -1;
    }

    private int endTransaction(long j2) {
        AppMethodBeat.i(182789);
        if (this.db instanceof ISQLiteDatabaseEx) {
            int endTransaction = ((ISQLiteDatabaseEx) this.db).endTransaction(j2);
            AppMethodBeat.o(182789);
            return endTransaction;
        }
        AppMethodBeat.o(182789);
        return -1;
    }

    public final boolean Xq(String str) {
        AppMethodBeat.i(146047);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.WxaAttrStorage", "delete with invalid username");
            AppMethodBeat.o(146047);
            return false;
        }
        WxaAttributes wxaAttributes = new WxaAttributes();
        wxaAttributes.field_username = str;
        boolean b2 = b(wxaAttributes, false, new String[0]);
        AppMethodBeat.o(146047);
        return b2;
    }

    public final WxaAttributes d(String str, String... strArr) {
        WxaAttributes wxaAttributes = null;
        AppMethodBeat.i(146048);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(146048);
        } else if (!str.endsWith("@app")) {
            AppMethodBeat.o(146048);
        } else {
            Cursor query = this.db.query(getTableName(), Util.isNullOrNil(strArr) ? null : strArr, String.format(Locale.US, "%s=?", "usernameHash"), new String[]{String.valueOf(str.hashCode())}, null, null, null, 2);
            if (query == null) {
                AppMethodBeat.o(146048);
            } else {
                if (query.moveToFirst()) {
                    wxaAttributes = new WxaAttributes();
                    wxaAttributes.convertFrom(query);
                    wxaAttributes.field_username = str;
                }
                query.close();
                AppMethodBeat.o(146048);
            }
        }
        return wxaAttributes;
    }

    public final WxaAttributes e(String str, String... strArr) {
        WxaAttributes wxaAttributes = null;
        AppMethodBeat.i(146049);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(146049);
        } else {
            Cursor query = this.db.query(getTableName(), Util.isNullOrNil(strArr) ? null : strArr, String.format(Locale.US, "%s=?", "appId"), new String[]{str}, null, null, null, 2);
            if (query == null) {
                Log.e("MicroMsg.WxaAttrStorage", "queryWithAppId(%s) null==cursor", str);
                AppMethodBeat.o(146049);
            } else {
                if (query.moveToFirst()) {
                    wxaAttributes = new WxaAttributes();
                    wxaAttributes.convertFrom(query);
                    wxaAttributes.field_appId = str;
                } else {
                    Log.e("MicroMsg.WxaAttrStorage", "queryWithAppId(%s) !cursor.moveToFirst()", str);
                }
                query.close();
                AppMethodBeat.o(146049);
            }
        }
        return wxaAttributes;
    }

    /* access modifiers changed from: protected */
    public boolean k(String str, int i2, boolean z) {
        int i3;
        AppMethodBeat.i(146050);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(146050);
            return false;
        }
        WxaAttributes d2 = d(str, "appOpt");
        if (d2 == null) {
            AppMethodBeat.o(146050);
            return false;
        }
        int i4 = d2.field_appOpt;
        if (!z) {
            i3 = i4 & (i2 ^ -1);
        } else {
            i3 = i4 | i2;
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("appOpt", Integer.valueOf(i3));
        if (this.db.update(getTableName(), contentValues, String.format("%s=?", ch.COL_USERNAME), new String[]{str}) > 0) {
            AppMethodBeat.o(146050);
            return true;
        }
        AppMethodBeat.o(146050);
        return false;
    }

    public final boolean a(lm lmVar, List<String> list) {
        AppMethodBeat.i(229819);
        long bAi = bAi();
        LinkedList linkedList = new LinkedList();
        Iterator<fcx> it = lmVar.KPd.iterator();
        boolean z = false;
        while (it.hasNext()) {
            fcx next = it.next();
            Log.i("MicroMsg.WxaAttrStorage", "batchSyncInGroup flushAttrs(%s)", next.Mmv);
            z |= a(next.Mmv, next.KSW, next.KSX, false);
            if (z && !TextUtils.isEmpty(next.Mmv)) {
                linkedList.add(next.Mmv);
            }
        }
        endTransaction(bAi);
        if (linkedList.size() > 0) {
            if (list != null) {
                list.addAll(linkedList);
            }
            doNotify(MStorageEventData.EventType.BATCH, 3, linkedList);
        }
        AppMethodBeat.o(229819);
        return z;
    }

    public boolean a(String str, b bVar, List<fcu> list) {
        AppMethodBeat.i(146051);
        boolean a2 = a(str, bVar, list, true);
        AppMethodBeat.o(146051);
        return a2;
    }

    private boolean a(String str, b bVar, List<fcu> list, boolean z) {
        byte[] bArr;
        AppMethodBeat.i(229820);
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(229820);
            return false;
        }
        WxaAttributes wxaAttributes = new WxaAttributes();
        wxaAttributes.field_username = str;
        boolean z2 = !a(wxaAttributes, new String[]{ch.COL_USERNAME});
        boolean z3 = false;
        for (fcu fcu : list) {
            if (fcu != null) {
                z3 = a(wxaAttributes, fcu) | z3;
            }
        }
        wxaAttributes.field_syncTimeSecond = Util.nowSecond();
        if (bVar == null) {
            bArr = new byte[0];
        } else {
            bArr = bVar.zy;
        }
        wxaAttributes.field_syncVersion = Util.encodeHexString(bArr);
        if (!z3) {
            a(wxaAttributes, false, ch.COL_USERNAME);
        } else if (z2) {
            a(wxaAttributes, z);
        } else {
            a(wxaAttributes, z, ch.COL_USERNAME);
        }
        AppMethodBeat.o(229820);
        return z3;
    }

    /* access modifiers changed from: protected */
    public boolean a(WxaAttributes wxaAttributes, fcu fcu) {
        int i2;
        AppMethodBeat.i(146052);
        if ("NickName".equals(fcu.xMX) && !cT(fcu.Cyk, wxaAttributes.field_nickname)) {
            wxaAttributes.field_nickname = Util.nullAsNil(fcu.Cyk);
            AppMethodBeat.o(146052);
            return true;
        } else if ("BrandIconURL".equals(fcu.xMX) && !cT(fcu.Cyk, wxaAttributes.field_brandIconURL)) {
            wxaAttributes.field_brandIconURL = fcu.Cyk;
            AppMethodBeat.o(146052);
            return true;
        } else if ("BigHeadImgUrl".equals(fcu.xMX) && !cT(fcu.Cyk, wxaAttributes.field_bigHeadURL)) {
            wxaAttributes.field_bigHeadURL = fcu.Cyk;
            AppMethodBeat.o(146052);
            return true;
        } else if ("SmallHeadImgUrl".equals(fcu.xMX) && !cT(fcu.Cyk, wxaAttributes.field_smallHeadURL)) {
            wxaAttributes.field_smallHeadURL = fcu.Cyk;
            AppMethodBeat.o(146052);
            return true;
        } else if ("Signature".equals(fcu.xMX) && !cT(fcu.Cyk, wxaAttributes.field_signature)) {
            wxaAttributes.field_signature = fcu.Cyk;
            AppMethodBeat.o(146052);
            return true;
        } else if ("WxAppOpt".equals(fcu.xMX) && (i2 = Util.getInt(fcu.Cyk, 0)) != wxaAttributes.field_appOpt) {
            wxaAttributes.field_appOpt = i2;
            AppMethodBeat.o(146052);
            return true;
        } else if ("RegisterSource".equals(fcu.xMX) && !cT(fcu.Cyk, wxaAttributes.field_registerSource)) {
            wxaAttributes.field_registerSource = fcu.Cyk;
            AppMethodBeat.o(146052);
            return true;
        } else if ("WxaAppInfo".equals(fcu.xMX) && !cT(fcu.Cyk, wxaAttributes.field_appInfo)) {
            wxaAttributes.field_appInfo = fcu.Cyk;
            try {
                JSONObject jSONObject = new JSONObject(fcu.Cyk);
                wxaAttributes.field_appId = jSONObject.getString("Appid");
                wxaAttributes.field_roundedSquareIconURL = jSONObject.getString("RoundedSquareIconUrl");
                wxaAttributes.field_shortNickname = jSONObject.optString("ShortNickName");
            } catch (Exception e2) {
            }
            AppMethodBeat.o(146052);
            return true;
        } else if ("WxaAppVersionInfo".equalsIgnoreCase(fcu.xMX) && !cT(fcu.Cyk, wxaAttributes.field_versionInfo)) {
            wxaAttributes.field_versionInfo = fcu.Cyk;
            AppMethodBeat.o(146052);
            return true;
        } else if ("BindWxaInfo".equals(fcu.xMX) && !cT(fcu.Cyk, wxaAttributes.field_bindWxaInfo)) {
            wxaAttributes.field_bindWxaInfo = fcu.Cyk;
            AppMethodBeat.o(146052);
            return true;
        } else if ("WxaAppDynamic".equals(fcu.xMX) && !cT(fcu.Cyk, wxaAttributes.field_dynamicInfo)) {
            wxaAttributes.field_dynamicInfo = fcu.Cyk;
            AppMethodBeat.o(146052);
            return true;
        } else if ("MMBizMenu".equals(fcu.xMX) && !cT(fcu.Cyk, wxaAttributes.field_bizMenu)) {
            wxaAttributes.field_bizMenu = fcu.Cyk;
            AppMethodBeat.o(146052);
            return true;
        } else if (!"PassThroughInfo".equals(fcu.xMX) || cT(fcu.xMX, wxaAttributes.field_passThroughInfo)) {
            AppMethodBeat.o(146052);
            return false;
        } else {
            wxaAttributes.field_passThroughInfo = fcu.Cyk;
            AppMethodBeat.o(146052);
            return true;
        }
    }

    private static boolean cT(String str, String str2) {
        AppMethodBeat.i(146053);
        boolean equals = Util.nullAsNil(str).equals(Util.nullAsNil(str2));
        AppMethodBeat.o(146053);
        return equals;
    }

    public final boolean a(WxaAttributes wxaAttributes, String... strArr) {
        AppMethodBeat.i(146054);
        if (!Util.isNullOrNil(strArr)) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    break;
                } else if (strArr[i2].equals(ch.COL_USERNAME)) {
                    strArr[i2] = "usernameHash";
                    wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
                    break;
                } else {
                    i2++;
                }
            }
        }
        boolean z = super.get(wxaAttributes, strArr);
        AppMethodBeat.o(146054);
        return z;
    }

    private boolean a(WxaAttributes wxaAttributes, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(229821);
        wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
        super.insertNotify(wxaAttributes, false);
        if (d(wxaAttributes.field_username, "appId") == null) {
            z2 = false;
        }
        if (z2 && z && !TextUtils.isEmpty(wxaAttributes.field_username)) {
            doNotify(MStorageEventData.EventType.SINGLE, 2, wxaAttributes.field_username);
        }
        AppMethodBeat.o(229821);
        return z2;
    }

    private boolean a(WxaAttributes wxaAttributes, boolean z, String... strArr) {
        AppMethodBeat.i(229822);
        if (!Util.isNullOrNil(strArr)) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    break;
                } else if (strArr[i2].equals(ch.COL_USERNAME)) {
                    strArr[i2] = "usernameHash";
                    wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
                    break;
                } else {
                    i2++;
                }
            }
        }
        boolean updateNotify = super.updateNotify(wxaAttributes, false, strArr);
        if (updateNotify && z && !TextUtils.isEmpty(wxaAttributes.field_username)) {
            doNotify(MStorageEventData.EventType.SINGLE, 3, wxaAttributes.field_username);
        }
        AppMethodBeat.o(229822);
        return updateNotify;
    }

    private boolean b(WxaAttributes wxaAttributes, boolean z, String... strArr) {
        AppMethodBeat.i(146055);
        if (!Util.isNullOrNil(wxaAttributes.field_username)) {
            wxaAttributes.field_usernameHash = wxaAttributes.field_username.hashCode();
        }
        boolean delete = super.delete(wxaAttributes, false, strArr);
        if (delete && z && !TextUtils.isEmpty(wxaAttributes.field_username)) {
            doNotify(MStorageEventData.EventType.SINGLE, 5, wxaAttributes.field_username);
        }
        AppMethodBeat.o(146055);
        return delete;
    }
}
