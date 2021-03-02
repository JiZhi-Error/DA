package com.tencent.mm.plugin.appbrand.jsapi.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.o;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/AppBrandResCacheChecker;", "", "()V", "INVALID_LAST_MODIFIED", "", "MMKV_KEY_PREFIX_META_DATA_DIR", "", "MMKV_KEY_PREFIX_META_DATA_FILE", "MMKV_NAME_RES_CACHE_META", "getDirMeta", "file", "Lcom/tencent/mm/vfs/VFSFile;", "getFileLastModified", "isValid", "", "cacheFile", "record", "recordDir", "cacheDir", "recordFile", "saveDirMeta", "", SharePatchInfo.OAT_DIR, "dirMeta", "saveFileLastModified", "validateDir", "validateFile", "validateMeta", "metaData", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "parentDir", "luggage-xweb-ext_release"})
public final class d {
    public static final d mJM = new d();

    static {
        AppMethodBeat.i(215990);
        AppMethodBeat.o(215990);
    }

    private d() {
    }

    public static boolean C(o oVar) {
        boolean z;
        AppMethodBeat.i(215986);
        p.h(oVar, "cacheFile");
        if (oVar.isDirectory()) {
            Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, cacheDir: ".concat(String.valueOf(oVar)));
            g.a aVar = g.mJU;
            g G = g.a.G(oVar);
            if (G == null) {
                Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, metaData is null");
                AppMethodBeat.o(215986);
                return false;
            }
            JSONObject json = G.toJson();
            String jSONObject = json != null ? json.toString() : null;
            String str = jSONObject;
            if (str == null || str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, metaDataStr is empty");
                AppMethodBeat.o(215986);
                return false;
            }
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
            String str2 = "metaData_dir_" + oVar.getAbsolutePath();
            Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "saveDirMeta, key: ".concat(String.valueOf(str2)));
            mmkv.putString(str2, jSONObject);
            AppMethodBeat.o(215986);
            return true;
        }
        MultiProcessMMKV mmkv2 = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
        String str3 = "metaData_file_" + oVar.getAbsolutePath();
        long lastModified = oVar.lastModified();
        Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "saveFileLastModified, key: " + str3 + ", lastModified: " + lastModified);
        mmkv2.putLong(str3, lastModified);
        AppMethodBeat.o(215986);
        return true;
    }

    public static boolean D(o oVar) {
        AppMethodBeat.i(215987);
        p.h(oVar, "cacheFile");
        if (oVar.isDirectory()) {
            boolean E = E(oVar);
            AppMethodBeat.o(215987);
            return E;
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
        String str = "metaData_file_" + oVar.getAbsolutePath();
        Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "getFileLastModified, key: ".concat(String.valueOf(str)));
        long j2 = mmkv.getLong(str, -1);
        long lastModified = oVar.lastModified();
        Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateFile, cacheFile: " + oVar + ", savedLastModified: " + j2 + ", realLastModified: " + lastModified);
        if (j2 == lastModified) {
            AppMethodBeat.o(215987);
            return true;
        }
        AppMethodBeat.o(215987);
        return false;
    }

    private static boolean E(o oVar) {
        h hVar;
        AppMethodBeat.i(215988);
        Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, cacheDir: ".concat(String.valueOf(oVar)));
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
        String str = "metaData_dir_" + oVar.getAbsolutePath();
        Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "getDirMeta, key: ".concat(String.valueOf(str)));
        String string = mmkv.getString(str, null);
        String str2 = string;
        if (str2 == null || str2.length() == 0) {
            Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, metaDataStr is empty");
            AppMethodBeat.o(215988);
            return false;
        }
        try {
            h.a aVar = h.mJV;
            hVar = h.a.aj(new JSONObject(string));
        } catch (Exception e2) {
            Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, get metaData fail since ".concat(String.valueOf(e2)));
            hVar = null;
        }
        if (hVar == null) {
            Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, metaData is null");
            AppMethodBeat.o(215988);
            return false;
        }
        o heq = oVar.heq();
        if (heq == null) {
            p.hyc();
        }
        if (!a(hVar, heq)) {
            Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, validateMeta fail");
            AppMethodBeat.o(215988);
            return false;
        }
        AppMethodBeat.o(215988);
        return true;
    }

    private static boolean a(h hVar, o oVar) {
        AppMethodBeat.i(215989);
        o oVar2 = new o(oVar, hVar.name);
        Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateMeta, unzipFile: ".concat(String.valueOf(oVar2)));
        if (hVar instanceof g) {
            List<h> list = ((g) hVar).mJT;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (!a(it.next(), oVar2)) {
                        AppMethodBeat.o(215989);
                        return false;
                    }
                }
            }
            AppMethodBeat.o(215989);
            return true;
        } else if (!oVar2.exists() || !oVar2.isFile()) {
            AppMethodBeat.o(215989);
            return false;
        } else if (hVar.kSb == oVar2.lastModified()) {
            AppMethodBeat.o(215989);
            return true;
        } else {
            AppMethodBeat.o(215989);
            return false;
        }
    }
}
