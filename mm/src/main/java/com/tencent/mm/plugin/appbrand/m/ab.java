package com.tencent.mm.plugin.appbrand.m;

import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007J\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic;", "", "()V", "IGNORE_DIR_NAME_LIST", "", "", "[Ljava/lang/String;", "TAG", "doCleanup", "", "compileStatement", "Lcom/tencent/wcdb/database/SQLiteStatement;", "Lcom/tencent/mm/storagebase/SqliteDB;", SharePluginInfo.ISSUE_KEY_SQL, "isEmptyDirectory", "", "Lcom/tencent/mm/vfs/FileEntry;", "rootDir", "LIB_SCRIPT_HANDLER", "USER_SCRIPT_HANDLER", "plugin-appbrand-integration_release"})
public final class ab {
    private static final String[] mNZ = {"page_scripts"};
    public static final ab mOa = new ab();

    static {
        AppMethodBeat.i(228605);
        AppMethodBeat.o(228605);
    }

    private ab() {
    }

    public static final /* synthetic */ SQLiteStatement c(h hVar, String str) {
        AppMethodBeat.i(228606);
        SQLiteStatement b2 = b(hVar, str);
        AppMethodBeat.o(228606);
        return b2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u000fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$USER_SCRIPT_HANDLER;", "Lkotlin/Function2;", "", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "stmt2", "invoke", "rootDir", SharePatchInfo.OAT_DIR, "(Ljava/lang/String;Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
    public static final class b implements m<String, e, Integer> {
        private final SQLiteStatement mOb;
        private final SQLiteStatement mOc;

        public b(h hVar) {
            p.h(hVar, UserDataStore.DATE_OF_BIRTH);
            AppMethodBeat.i(228602);
            ab abVar = ab.mOa;
            this.mOb = ab.c(hVar, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND versionMd5=? ;");
            ab abVar2 = ab.mOa;
            this.mOc = ab.c(hVar, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND NewMd5=? ;");
            AppMethodBeat.o(228602);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ Integer invoke(String str, e eVar) {
            AppMethodBeat.i(258051);
            Integer a2 = a(str, eVar);
            AppMethodBeat.o(258051);
            return a2;
        }

        private Integer a(String str, e eVar) {
            String[] strArr;
            String str2;
            int i2;
            long j2;
            long j3;
            int i3;
            boolean z;
            AppMethodBeat.i(258050);
            p.h(str, "rootDir");
            p.h(eVar, SharePatchInfo.OAT_DIR);
            if (this.mOb == null) {
                AppMethodBeat.o(258050);
                return 0;
            } else if (this.mOc == null) {
                AppMethodBeat.o(258050);
                return 0;
            } else {
                String str3 = eVar.name;
                if (str3 == null) {
                    strArr = null;
                } else {
                    int length = str3.length();
                    if (length == 0) {
                        strArr = org.apache.commons.b.a.EMPTY_STRING_ARRAY;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        int i4 = 0;
                        boolean z2 = false;
                        int i5 = 0;
                        while (i5 < length) {
                            if (str3.charAt(i5) == '_') {
                                if (z2) {
                                    arrayList.add(str3.substring(i4, i5));
                                    z2 = false;
                                }
                                int i6 = i5 + 1;
                                i4 = i6;
                                i5 = i6;
                            } else {
                                z2 = true;
                                i5++;
                            }
                        }
                        if (z2) {
                            arrayList.add(str3.substring(i4, i5));
                        }
                        strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                    }
                }
                if (strArr != null) {
                    p.h(strArr, "$this$lastOrNull");
                    if (strArr.length == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    str2 = z ? null : strArr[strArr.length - 1];
                } else {
                    str2 = null;
                }
                String str4 = str2;
                if (str4 == null || str4.length() == 0) {
                    AppMethodBeat.o(258050);
                    return 0;
                }
                Iterable<e> dC = s.dC(str + FilePathGenerator.ANDROID_DIR_SEP + eVar.name, false);
                if (dC != null) {
                    i2 = 0;
                    for (e eVar2 : dC) {
                        if (!eVar2.RbJ) {
                            this.mOb.bindString(1, str2 + "%%");
                            this.mOb.bindString(2, eVar2.name);
                            try {
                                j2 = this.mOb.simpleQueryForLong();
                            } catch (SQLiteException e2) {
                                j2 = 0;
                            }
                            this.mOc.bindString(1, str2 + "%%");
                            this.mOc.bindString(2, eVar2.name);
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
                AppMethodBeat.o(258050);
                return valueOf;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u000eR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$LIB_SCRIPT_HANDLER;", "Lkotlin/Function2;", "", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "invoke", "rootDir", SharePatchInfo.OAT_DIR, "(Ljava/lang/String;Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
    public static final class a implements m<String, e, Integer> {
        private final SQLiteStatement mOb;

        public a(h hVar) {
            p.h(hVar, UserDataStore.DATE_OF_BIRTH);
            AppMethodBeat.i(228599);
            ab abVar = ab.mOa;
            this.mOb = ab.c(hVar, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId =? AND version=? ;");
            AppMethodBeat.o(228599);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ Integer invoke(String str, e eVar) {
            AppMethodBeat.i(258049);
            Integer a2 = a(str, eVar);
            AppMethodBeat.o(258049);
            return a2;
        }

        private Integer a(String str, e eVar) {
            int i2;
            int i3;
            long j2;
            int i4 = 0;
            AppMethodBeat.i(258048);
            p.h(str, "rootDir");
            p.h(eVar, SharePatchInfo.OAT_DIR);
            if (this.mOb == null) {
                AppMethodBeat.o(258048);
                return 0;
            }
            Iterable<e> dC = s.dC(str + FilePathGenerator.ANDROID_DIR_SEP + eVar.name, false);
            if (dC != null) {
                Iterator<e> it = dC.iterator();
                while (true) {
                    i2 = i4;
                    if (!it.hasNext()) {
                        break;
                    }
                    e next = it.next();
                    try {
                        String str2 = next.name;
                        p.g(str2, "file.name");
                        if (str2 == null) {
                            t tVar = new t("null cannot be cast to non-null type java.lang.String");
                            AppMethodBeat.o(258048);
                            throw tVar;
                        }
                        String substring = str2.substring(1);
                        p.g(substring, "(this as java.lang.String).substring(startIndex)");
                        i3 = Integer.parseInt(substring, kotlin.n.a.avR(10));
                        if (!(i3 == -1 || i3 == 0 || i3 == 999 || i3 == ay.VERSION)) {
                            this.mOb.bindString(1, "@LibraryAppId");
                            this.mOb.bindLong(2, (long) i3);
                            try {
                                j2 = this.mOb.simpleQueryForLong();
                            } catch (SQLiteException e2) {
                                j2 = 0;
                            }
                            if (j2 <= 0) {
                                next.delete();
                                i2++;
                            }
                        }
                        i4 = i2;
                    } catch (NumberFormatException e3) {
                        i3 = -1;
                    }
                }
            } else {
                i2 = 0;
            }
            Integer valueOf = Integer.valueOf(i2);
            AppMethodBeat.o(258048);
            return valueOf;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void bMJ() {
        /*
        // Method dump skipped, instructions count: 310
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.m.ab.bMJ():void");
    }

    private static SQLiteStatement b(h hVar, String str) {
        SQLiteStatement sQLiteStatement = null;
        AppMethodBeat.i(228604);
        try {
            sQLiteStatement = hVar.gFH().compileStatement(str);
        } catch (SQLiteException e2) {
            Log.e("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "compileStatement with sql:" + str + ", get exception:" + e2);
        } catch (IllegalStateException e3) {
            Log.e("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "compileStatement with sql:" + str + ", get exception:" + e3);
        }
        AppMethodBeat.o(228604);
        return sQLiteStatement;
    }
}
