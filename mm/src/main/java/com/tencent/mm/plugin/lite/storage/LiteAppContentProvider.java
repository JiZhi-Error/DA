package com.tencent.mm.plugin.lite.storage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import java.util.ArrayList;
import java.util.List;

public class LiteAppContentProvider extends ContentProvider {
    public static final String AUTHORITY = WeChatAuthorities.AUTHORITIES_PLUGIN_LITE_LOGIC_LITEAPPINFO();
    private static final UriMatcher rdr;
    private f yFd;
    private d yFe;

    static {
        AppMethodBeat.i(198896);
        UriMatcher uriMatcher = new UriMatcher(-1);
        rdr = uriMatcher;
        uriMatcher.addURI(AUTHORITY, "LiteAppInfo", 1);
        AppMethodBeat.o(198896);
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(198895);
        if (!g.aAi().hrr || !g.aAf().azp()) {
            Log.w("MicroMsg.LiteAppContentProvider", "kernel or account not init.");
            AppMethodBeat.o(198895);
            return null;
        }
        if (this.yFd == null) {
            this.yFd = new f(g.aAh().hqK);
        }
        if (this.yFe == null) {
            this.yFe = new d(g.aAh().hqK);
        }
        Log.i("MicroMsg.LiteAppContentProvider", "call %s %s", str, str2);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -637421891:
                if (str.equals("removeLiteAppInfo")) {
                    c2 = 1;
                    break;
                }
                break;
            case -201266840:
                if (str.equals("insertLiteAppInfo")) {
                    c2 = 2;
                    break;
                }
                break;
            case 402930224:
                if (str.equals("insertLiteAppAuthInfo")) {
                    c2 = 4;
                    break;
                }
                break;
            case 992676011:
                if (str.equals("getLiteAppInfo")) {
                    c2 = 0;
                    break;
                }
                break;
            case 992760987:
                if (str.equals("getLiteAppList")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1924595699:
                if (str.equals("getLiteAppAuthInfo")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                try {
                    e aCV = this.yFd.aCV(str2);
                    if (aCV != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable("LiteApp", aCV.ecG());
                        AppMethodBeat.o(198895);
                        return bundle2;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.LiteAppContentProvider", "getLiteAppInfo failed. :%s", Util.stackTraceToString(e2));
                }
                Log.i("MicroMsg.LiteAppContentProvider", "null == info, appId:".concat(String.valueOf(str2)));
                AppMethodBeat.o(198895);
                return null;
            case 1:
                Log.i("MicroMsg.LiteAppInfoStorage", "remove liteapp: %s, ret:%d", str2, Integer.valueOf(this.yFd.db.delete("LiteAppInfo", "appId=?", new String[]{str2})));
                AppMethodBeat.o(198895);
                return null;
            case 2:
                WxaLiteAppInfo wxaLiteAppInfo = (WxaLiteAppInfo) bundle.getParcelable("LiteApp");
                if (wxaLiteAppInfo == null) {
                    AppMethodBeat.o(198895);
                    return null;
                }
                e eVar = new e();
                eVar.field_appId = wxaLiteAppInfo.appId;
                eVar.field_signatureKey = wxaLiteAppInfo.crh;
                eVar.field_pkgType = wxaLiteAppInfo.type;
                eVar.field_pkgPath = wxaLiteAppInfo.path;
                eVar.field_patchId = wxaLiteAppInfo.cri;
                eVar.field_updateTime = wxaLiteAppInfo.crj;
                eVar.field_url = wxaLiteAppInfo.url;
                eVar.field_md5 = wxaLiteAppInfo.md5;
                eVar.field_lastUseTime = wxaLiteAppInfo.crk;
                eVar.field_groupId = wxaLiteAppInfo.groupId;
                if (this.yFd.aCV(wxaLiteAppInfo.appId) == null) {
                    this.yFd.a(eVar);
                } else {
                    this.yFd.update(eVar, new String[0]);
                }
                AppMethodBeat.o(198895);
                return null;
            case 3:
                List<e> ecD = this.yFd.ecD();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                if (ecD.size() > 0) {
                    for (int i2 = 0; i2 < ecD.size(); i2++) {
                        arrayList.add(ecD.get(i2).ecG());
                    }
                }
                Bundle bundle3 = new Bundle();
                if (!arrayList.isEmpty()) {
                    bundle3.putParcelableArrayList("LiteAppList", arrayList);
                }
                AppMethodBeat.o(198895);
                return bundle3;
            case 4:
                String string = bundle.getString("host");
                if (string == null) {
                    AppMethodBeat.o(198895);
                    return null;
                }
                c cVar = new c();
                cVar.field_host = string;
                cVar.field_param = bundle.getString("param");
                cVar.field_paramMap = bundle.getString("paramMap");
                cVar.field_headerMap = bundle.getString("headerMap");
                cVar.field_updateTime = bundle.getLong(ch.COL_UPDATETIME);
                if (this.yFe.aCU(string) == null) {
                    this.yFe.a(cVar);
                } else {
                    this.yFe.update(cVar, new String[0]);
                }
                AppMethodBeat.o(198895);
                return null;
            case 5:
                try {
                    c aCU = this.yFe.aCU(str2);
                    if (aCU != null) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putString("host", aCU.field_host);
                        bundle4.putString("param", aCU.field_param);
                        bundle4.putString("paramMap", aCU.field_paramMap);
                        bundle4.putString("headerMap", aCU.field_headerMap);
                        bundle4.putLong(ch.COL_UPDATETIME, aCU.field_updateTime);
                        AppMethodBeat.o(198895);
                        return bundle4;
                    }
                } catch (Exception e3) {
                    Log.e("MicroMsg.LiteAppContentProvider", "getLiteAppAuthInfo failed. :%s", Util.stackTraceToString(e3));
                }
                AppMethodBeat.o(198895);
                return null;
            default:
                AppMethodBeat.o(198895);
                return null;
        }
    }
}
