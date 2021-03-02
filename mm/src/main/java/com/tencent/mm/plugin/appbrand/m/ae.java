package com.tencent.mm.plugin.appbrand.m;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007J\u0016\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0014\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8WasmCacheCleanupLogic;", "", "()V", "TAG", "", "clearByAppId", "", "appId", "doCleanup", "compileStatement", "Lcom/tencent/wcdb/database/SQLiteStatement;", "Lcom/tencent/mm/storagebase/SqliteDB;", SharePluginInfo.ISSUE_KEY_SQL, "isEmptyDirectory", "", "Lcom/tencent/mm/vfs/FileEntry;", "rootDir", "USER_SCRIPT_HANDLER", "plugin-appbrand-integration_release"})
public final class ae {
    public static final ae mOe = new ae();

    static {
        AppMethodBeat.i(228614);
        AppMethodBeat.o(228614);
    }

    private ae() {
    }

    public static final /* synthetic */ SQLiteStatement d(h hVar, String str) {
        AppMethodBeat.i(228615);
        SQLiteStatement b2 = b(hVar, str);
        AppMethodBeat.o(228615);
        return b2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0010R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8WasmCacheCleanupLogic$USER_SCRIPT_HANDLER;", "Lkotlin/Function3;", "", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/WasmCacheDirHandler;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "stmt2", "invoke", "appId", "rootDir", SharePatchInfo.OAT_DIR, "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
    public static final class a implements q<String, String, e, Integer> {
        private final SQLiteStatement mOb;
        private final SQLiteStatement mOc;

        public a(h hVar) {
            p.h(hVar, UserDataStore.DATE_OF_BIRTH);
            AppMethodBeat.i(228609);
            ae aeVar = ae.mOe;
            this.mOb = ae.d(hVar, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND versionMd5=? ;");
            ae aeVar2 = ae.mOe;
            this.mOc = ae.d(hVar, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND NewMd5=? ;");
            AppMethodBeat.o(228609);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ Integer d(String str, String str2, e eVar) {
            AppMethodBeat.i(258053);
            Integer a2 = a(str, str2, eVar);
            AppMethodBeat.o(258053);
            return a2;
        }

        public final Integer a(String str, String str2, e eVar) {
            int i2;
            String str3;
            long j2;
            long j3;
            int i3;
            AppMethodBeat.i(258052);
            p.h(str, "appId");
            p.h(str2, "rootDir");
            p.h(eVar, SharePatchInfo.OAT_DIR);
            if (this.mOb == null) {
                AppMethodBeat.o(258052);
                return 0;
            } else if (this.mOc == null) {
                AppMethodBeat.o(258052);
                return 0;
            } else {
                Iterable<e> dC = s.dC(str2 + FilePathGenerator.ANDROID_DIR_SEP + eVar.name, false);
                if (dC != null) {
                    i2 = 0;
                    for (e eVar2 : dC) {
                        if (!eVar2.RbJ) {
                            String str4 = eVar2.name;
                            String str5 = eVar2.name;
                            p.g(str5, "file.name");
                            if (n.e(str5, ".")) {
                                String str6 = eVar2.name;
                                p.g(str6, "file.name");
                                str3 = (String) n.b(str6, new String[]{"."}).get(0);
                            } else {
                                str3 = str4;
                            }
                            this.mOb.bindString(1, str + "%%");
                            this.mOb.bindString(2, str3);
                            try {
                                j2 = this.mOb.simpleQueryForLong();
                            } catch (SQLiteException e2) {
                                j2 = 0;
                            }
                            this.mOc.bindString(1, str + "%%");
                            this.mOc.bindString(2, str3);
                            try {
                                j3 = this.mOc.simpleQueryForLong();
                            } catch (SQLiteException e3) {
                                j3 = 0;
                            }
                            if (j2 + j3 <= 0) {
                                eVar2.delete();
                                i3 = i2 + 1;
                            } else {
                                i3 = i2;
                            }
                            i2 = i3;
                        }
                    }
                } else {
                    i2 = 0;
                }
                Integer valueOf = Integer.valueOf(i2);
                AppMethodBeat.o(258052);
                return valueOf;
            }
        }
    }

    public static final void WY(String str) {
        AppMethodBeat.i(228610);
        p.h(str, "appId");
        Iterable<e> dC = s.dC(af.bDt(), false);
        if (dC != null) {
            for (e eVar : dC) {
                if (eVar.RbJ && p.j(str, eVar.name)) {
                    if (s.dy(af.bDt() + FilePathGenerator.ANDROID_DIR_SEP + eVar.name, true)) {
                        Log.d("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "wasm cache %s removed.", str);
                        AppMethodBeat.o(228610);
                        return;
                    }
                    Log.e("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "wasm cache %s remove failed.", str);
                    AppMethodBeat.o(228610);
                    return;
                }
            }
            AppMethodBeat.o(228610);
            return;
        }
        AppMethodBeat.o(228610);
    }

    public static final void bMJ() {
        int i2;
        int i3;
        AppMethodBeat.i(228611);
        r.a buy = com.tencent.mm.plugin.appbrand.app.n.buy();
        if (buy != null) {
            a aVar = new a(buy);
            long currentTicks = Util.currentTicks();
            Iterable<e> dC = s.dC(af.bDt(), false);
            if (dC != null) {
                i3 = 0;
                i2 = 0;
                for (e eVar : dC) {
                    if (eVar.RbJ) {
                        String str = eVar.name;
                        String str2 = af.bDt() + FilePathGenerator.ANDROID_DIR_SEP + eVar.name;
                        Iterable<e> dC2 = s.dC(str2, false);
                        if (dC2 != null) {
                            int i4 = i3;
                            int i5 = i2;
                            for (e eVar2 : dC2) {
                                if (eVar2.RbJ) {
                                    i5++;
                                    p.g(str, "appId");
                                    p.g(eVar2, "subDir");
                                    int intValue = aVar.a(str, str2, eVar2).intValue() + i4;
                                    if (a(eVar2, str2)) {
                                        eVar2.delete();
                                    }
                                    i4 = intValue;
                                }
                            }
                            i3 = i4;
                            i2 = i5;
                        }
                        p.g(eVar, SharePatchInfo.OAT_DIR);
                        String bDt = af.bDt();
                        p.g(bDt, "V8WasmCachePathRetriever.retrieve()");
                        if (a(eVar, bDt)) {
                            Log.i("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "delete appID %s relPath %s", str, eVar.NGP);
                            eVar.delete();
                        }
                    }
                }
            } else {
                i3 = 0;
                i2 = 0;
            }
            Log.i("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "doCleanup() cost:" + (Util.currentTicks() - currentTicks) + "ms, dirVisitedCount:" + i2 + ", fileDeletedCount:" + i3);
            AppMethodBeat.o(228611);
            return;
        }
        AppMethodBeat.o(228611);
    }

    private static boolean a(e eVar, String str) {
        AppMethodBeat.i(258054);
        if (eVar.RbJ) {
            Iterable<e> dC = s.dC(str + FilePathGenerator.ANDROID_DIR_SEP + eVar.name, false);
            List p = dC != null ? j.p(dC) : null;
            if (p == null || p.isEmpty()) {
                AppMethodBeat.o(258054);
                return true;
            }
        }
        AppMethodBeat.o(258054);
        return false;
    }

    private static SQLiteStatement b(h hVar, String str) {
        SQLiteStatement sQLiteStatement = null;
        AppMethodBeat.i(228613);
        try {
            sQLiteStatement = hVar.gFH().compileStatement(str);
        } catch (SQLiteException e2) {
            Log.e("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "compileStatement with sql:" + str + ", get exception:" + e2);
        } catch (IllegalStateException e3) {
            Log.e("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "compileStatement with sql:" + str + ", get exception:" + e3);
        }
        AppMethodBeat.o(228613);
        return sQLiteStatement;
    }
}
