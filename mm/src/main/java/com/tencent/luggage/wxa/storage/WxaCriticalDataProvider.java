package com.tencent.luggage.wxa.storage;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.launching.ar;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.protocal.protobuf.fcu;
import com.tencent.mm.protocal.protobuf.fcv;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class WxaCriticalDataProvider extends ContentProvider {
    private static final UriMatcher cDG = new UriMatcher(-1);
    private static final SparseArray<String> cDH;
    private final Map<Class<?>, Object> cDI = new HashMap();
    private volatile ISQLiteDatabase db;

    /* access modifiers changed from: protected */
    public abstract ISQLiteDatabase Pp();

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        cDH = sparseArray;
        sparseArray.put(1, "WxaAttributesTable");
        cDH.put(2, "LaunchWxaAppPBTable");
        cDH.put(3, "WxaAppPackageModelTable");
        cDH.put(4, "DevPkgLaunchExtInfo");
        cDH.put(5, "AppBrandWxaPkgManifestRecord");
        for (int i2 = 0; i2 < cDH.size(); i2++) {
            cDG.addURI(a.AUTHORITY, cDH.valueAt(i2), cDH.keyAt(i2));
        }
    }

    private boolean Po() {
        if (this.db == null) {
            this.db = Pp();
        }
        return this.db != null;
    }

    protected static int p(Uri uri) {
        return cDG.match(uri);
    }

    /* access modifiers changed from: protected */
    public final void Pq() {
        try {
            if (this.db instanceof ISQLiteDatabaseEx) {
                ((ISQLiteDatabaseEx) this.db).close();
            }
        } catch (Throwable th) {
            Log.printErrStackTrace("Luggage.WxaCriticalDataProvider", th, "uninstallDatabase", new Object[0]);
        }
        this.db = null;
    }

    /* access modifiers changed from: protected */
    public final void c(Class<?> cls, Object obj) {
        this.cDI.put(cls, obj);
    }

    private <T> T W(Class<T> cls) {
        return (T) this.cDI.get(cls);
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!Po()) {
            return null;
        }
        String str3 = cDH.get(cDG.match(uri));
        if (!TextUtils.isEmpty(str3)) {
            return this.db.query(str3, strArr, str, strArr2, null, null, str2);
        }
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        List<WxaAttributes.WxaVersionModuleInfo> list;
        String str;
        String str2;
        if (!Po()) {
            return null;
        }
        switch (cDG.match(uri)) {
            case 1:
                try {
                    if (!contentValues.containsKey("CONTENT_KEY_SYNC_PROTO")) {
                        if (contentValues.containsKey("CONTENT_KEY_BATCH_SYNC_PROTO")) {
                            ((x) W(x.class)).a((lm) new lm().parseFrom(contentValues.getAsByteArray("CONTENT_KEY_BATCH_SYNC_PROTO")), (List<String>) null);
                            break;
                        }
                    } else {
                        String asString = contentValues.getAsString("CONTENT_KEY_APPID");
                        byte[] asByteArray = contentValues.getAsByteArray("CONTENT_KEY_SYNC_PROTO");
                        x xVar = (x) W(x.class);
                        fcv fcv = (fcv) new fcv().parseFrom(asByteArray);
                        if (Util.isNullOrNil(asString)) {
                            str = null;
                        } else {
                            WxaAttributes e2 = xVar.e(asString, ch.COL_USERNAME);
                            str = e2 == null ? null : e2.field_username;
                        }
                        if (TextUtils.isEmpty(str)) {
                            Iterator<fcu> it = fcv.KSX.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    fcu next = it.next();
                                    if ("UserName".equalsIgnoreCase(next.xMX)) {
                                        str2 = next.Cyk;
                                    }
                                } else {
                                    str2 = str;
                                }
                            }
                            if (TextUtils.isEmpty(str2)) {
                                Log.e("MicroMsg.WxaAttrStorage", "updateAttrsWithProto appId=%s, username EMPTY", asString);
                                break;
                            }
                        } else {
                            str2 = str;
                        }
                        xVar.a(str2, fcv.KSW, fcv.KSX);
                        break;
                    }
                } catch (Exception e3) {
                    Log.e("Luggage.WxaCriticalDataProvider", "insert WxaAttributes, e = %s", e3);
                    break;
                }
                break;
            case 2:
                try {
                    ((ar) W(ar.class)).b(contentValues.getAsString("CONTENT_KEY_APPID"), (che) new che().parseFrom(contentValues.getAsByteArray("CONTENT_KEY_SYNC_PROTO")));
                    break;
                } catch (Exception e4) {
                    Log.e("Luggage.WxaCriticalDataProvider", "insert LaunchWxaAppPB, e = %s", e4);
                    break;
                }
            case 4:
                try {
                    ((t) W(t.class)).A(contentValues.getAsString("CONTENT_KEY_APPID"), contentValues.getAsInteger("CONTENT_KEY_VERSION_TYPE").intValue(), contentValues.getAsString("CONTENT_KEY_EXT_INFO"));
                    break;
                } catch (Exception e5) {
                    Log.e("Luggage.WxaCriticalDataProvider", "insert LaunchExtInfoForDevPkg, e = %s", e5);
                    break;
                }
            case 5:
                String asString2 = contentValues.getAsString("CONTENT_KEY_ACTION");
                char c2 = 65535;
                switch (asString2.hashCode()) {
                    case -1297425212:
                        if (asString2.equals("ACTION_UPDATE_MODULE_LIST")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -946499957:
                        if (asString2.equals("ACTION_FLUSH_WXA_PKG_VERSION_INFO")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -214401522:
                        if (asString2.equals("ACTION_UPDATE_PKG_INFO")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 396944:
                        if (asString2.equals("ACTION_UPDATE_PLUGINCODE_LIST")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 755152062:
                        if (asString2.equals("ACIION_UPDATE_WITHOUT_PLUGINCODE_INFO")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1067970480:
                        if (asString2.equals("ACTION_FLUSH_WXA_DEBUG_PKG_INFO")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        try {
                            String asString3 = contentValues.getAsString("CONTENT_KEY_APPID");
                            int intValue = contentValues.getAsInteger("CONTENT_KEY_PKG_TYPE").intValue();
                            int intValue2 = contentValues.getAsInteger("CONTENT_KEY_PKG_VERSION").intValue();
                            try {
                                list = WxaAttributes.WxaVersionModuleInfo.XK(contentValues.getAsString("CONTENT_KEY_MODULE_LIST_JSON"));
                            } catch (Exception e6) {
                                list = null;
                            }
                            if (!Util.isNullOrNil(list)) {
                                ((bh) W(bh.class)).a(asString3, intValue, intValue2, list);
                                break;
                            }
                        } catch (Exception e7) {
                            Log.e("Luggage.WxaCriticalDataProvider", "insert LaunchExtInfoForDevPkg, e = %s", e7);
                            break;
                        }
                        break;
                    case 1:
                        String asString4 = contentValues.getAsString("CONTENT_KEY_APPID");
                        int intValue3 = contentValues.getAsInteger("CONTENT_KEY_PKG_TYPE").intValue();
                        String asString5 = contentValues.getAsString("CONTENT_KEY_PKG_VERSION_MD5");
                        if (((bh) W(bh.class)).a(asString4, intValue3, contentValues.getAsString("CONTENT_KEY_PKG_DOWNLOAD_URL"), asString5, 0, System.currentTimeMillis())) {
                            return ContentUris.withAppendedId(uri, (long) String.format(Locale.US, "%s_%d_%s", asString4, Integer.valueOf(intValue3), asString5).hashCode());
                        }
                        break;
                    case 2:
                        ((bh) W(bh.class)).d(contentValues.getAsString("CONTENT_KEY_APPID"), contentValues.getAsInteger("CONTENT_KEY_PKG_TYPE").intValue(), contentValues.getAsInteger("CONTENT_KEY_PKG_VERSION").intValue(), contentValues.getAsString("CONTENT_KEY_PKG_VERSION_MD5"), contentValues.getAsString("CONTENT_KEY_PKG_DOWNLOAD_URL"));
                        break;
                    case 3:
                        ((bh) W(bh.class)).be(WxaAttributes.WxaPluginCodeInfo.cz(contentValues.getAsString("CONTENT_KEY_PLUGINCODE_LIST")));
                        break;
                    case 4:
                        ((bh) W(bh.class)).b(contentValues.getAsString("CONTENT_KEY_APPID"), contentValues.getAsString("CONTENT_KEY_MODULE_NAME"), contentValues.getAsInteger("CONTENT_KEY_PKG_VERSION").intValue(), contentValues.getAsInteger("CONTENT_KEY_CODE_TYPE").intValue(), contentValues.getAsString("CONTENT_KEY_PKG_VERSION_MD5"), contentValues.getAsInteger("CONTENT_KEY_PKG_TYPE").intValue());
                        break;
                    case 5:
                        ((bh) W(bh.class)).a(contentValues.getAsString("CONTENT_KEY_APPID"), contentValues.getAsInteger("CONTENT_KEY_PKG_VERSION").intValue(), contentValues.getAsInteger("CONTENT_KEY_CODE_TYPE").intValue(), contentValues.getAsString("CONTENT_KEY_MODULE_NAME"), WxaAttributes.WxaWidgetInfo.XL(contentValues.getAsString("CONTENT_KEY_PKGINFO_LIST")));
                        break;
                }
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        if (!Po()) {
            return -1;
        }
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        char c2 = 65535;
        if (!Po()) {
            return -1;
        }
        switch (cDG.match(uri)) {
            case 5:
                String asString = contentValues.getAsString("CONTENT_KEY_ACTION");
                switch (asString.hashCode()) {
                    case -1582635354:
                        if (asString.equals("ACTION_DELETE_MODULE_LIST")) {
                            c2 = 0;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        if (((bh) W(bh.class)).G(contentValues.getAsString("CONTENT_KEY_APPID"), contentValues.getAsInteger("CONTENT_KEY_PKG_TYPE").intValue(), contentValues.getAsInteger("CONTENT_KEY_PKG_VERSION").intValue())) {
                            return 1;
                        }
                        return 0;
                    default:
                        return 0;
                }
            default:
                return 0;
        }
    }
}
