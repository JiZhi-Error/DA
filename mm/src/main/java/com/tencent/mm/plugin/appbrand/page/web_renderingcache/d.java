package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u0006H\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0002J \u0010\u0012\u001a\u00020\u0006*\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic;", "", "()V", "TAG", "", "clearCache", "", "appId", "versionType", "", "evictExpiredCache", "getCommLibVersionId", "useRelease", "", "getWxaAttrVersion", "toCommLibReader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "transaction", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "block", "Lkotlin/Function1;", "plugin-appbrand-integration_release"})
public final class d {
    public static final d nwd = new d();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.page.web_renderingcache.d$d  reason: collision with other inner class name */
    public static final class C0777d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c nwi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0777d(c cVar) {
            super(0);
            this.nwi = cVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "invoke"})
        /* renamed from: com.tencent.mm.plugin.appbrand.page.web_renderingcache.d$d$a */
        static final class a extends q implements kotlin.g.a.b<String, String> {
            public static final a nwl = new a();

            static {
                AppMethodBeat.i(50961);
                AppMethodBeat.o(50961);
            }

            a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ String invoke(String str) {
                AppMethodBeat.i(50960);
                p.h(str, LocaleUtil.ITALIAN);
                AppMethodBeat.o(50960);
                return " commLibVersionId != ? ";
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(50962);
            LinkedList linkedList = new LinkedList();
            d dVar = d.nwd;
            String iq = d.iq(true);
            if (iq != null) {
                linkedList.add(iq);
            }
            d dVar2 = d.nwd;
            String iq2 = d.iq(false);
            if (iq2 != null) {
                linkedList.add(iq2);
            }
            if (!linkedList.isEmpty()) {
                this.nwi.kOg.delete("WxaAppWebRenderingCacheAccessStatsTable", j.a(linkedList, " and ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, a.nwl, 30), (String[]) linkedList.toArray(new String[0]));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(50962);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$clearCache$1$1"})
    public static final class a extends q implements kotlin.g.a.b<ISQLiteDatabaseEx, x> {
        final /* synthetic */ z.f nwe;
        final /* synthetic */ LinkedList nwf;
        final /* synthetic */ int nwg;
        final /* synthetic */ String nwh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(z.f fVar, LinkedList linkedList, int i2, String str) {
            super(1);
            this.nwe = fVar;
            this.nwf = linkedList;
            this.nwg = i2;
            this.nwh = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(ISQLiteDatabaseEx iSQLiteDatabaseEx) {
            Throwable th;
            Throwable th2;
            AppMethodBeat.i(50955);
            ISQLiteDatabaseEx iSQLiteDatabaseEx2 = iSQLiteDatabaseEx;
            p.h(iSQLiteDatabaseEx2, UserDataStore.DATE_OF_BIRTH);
            Cursor rawQuery = iSQLiteDatabaseEx2.rawQuery("select cacheFilePath from WxaAppWebRenderingCacheAccessStatsTable where " + ((String) this.nwe.SYG), new String[]{this.nwh});
            try {
                Cursor cursor = rawQuery;
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(0);
                        String str = string;
                        if (!(str == null || str.length() == 0)) {
                            this.nwf.add(string);
                        }
                    } while (cursor.moveToNext());
                }
                x xVar = x.SXb;
                kotlin.f.b.a(rawQuery, null);
                iSQLiteDatabaseEx2.delete("WxaAppWebRenderingCacheAccessStatsTable", this.nwe.SYG, new String[]{this.nwh});
                x xVar2 = x.SXb;
                AppMethodBeat.o(50955);
                return xVar2;
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                kotlin.f.b.a(rawQuery, th2);
                AppMethodBeat.o(50955);
                throw th;
            }
        }
    }

    static {
        AppMethodBeat.i(50968);
        AppMethodBeat.o(50968);
    }

    private d() {
    }

    public static final void bSG() {
        AppMethodBeat.i(50966);
        o oVar = new o(h.bSI());
        if (!oVar.exists() || !oVar.isDirectory()) {
            oVar.delete();
            AppMethodBeat.o(50966);
            return;
        }
        Log.i("MicroMsg.AppBrand.WebRenderingCacheCleanupLogic", "evictExpiredCache enter");
        c cVar = (c) n.W(c.class);
        if (cVar != null) {
            new C0777d(cVar).invoke();
            new e(cVar).invoke();
            new b(cVar, oVar).invoke();
            new c(cVar, oVar).invoke();
            AppMethodBeat.o(50966);
            return;
        }
        AppMethodBeat.o(50966);
    }

    public static final void cd(String str, int i2) {
        boolean z;
        AppMethodBeat.i(50967);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(50967);
            return;
        }
        c cVar = (c) n.W(c.class);
        if (cVar != null) {
            try {
                z.f fVar = new z.f();
                fVar.SYG = "  appId=? ";
                switch (i2) {
                    case 1:
                        fVar.SYG = (T) (((String) fVar.SYG) + " and appVersionId = TEST");
                        break;
                    case 2:
                        fVar.SYG = (T) (((String) fVar.SYG) + " and appVersionId = DEMO");
                        break;
                }
                LinkedList<String> linkedList = new LinkedList();
                ISQLiteDatabaseEx iSQLiteDatabaseEx = cVar.kOg;
                Thread currentThread = Thread.currentThread();
                p.g(currentThread, "Thread.currentThread()");
                long beginTransaction = iSQLiteDatabaseEx.beginTransaction(currentThread.getId());
                new a(fVar, linkedList, i2, str).invoke(iSQLiteDatabaseEx);
                iSQLiteDatabaseEx.endTransaction(beginTransaction);
                for (String str3 : linkedList) {
                    s.deleteFile(str3);
                }
                AppMethodBeat.o(50967);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.WebRenderingCacheCleanupLogic", "clearCache with appId[" + str + "] versionType[" + i2 + "], e=" + e2);
                AppMethodBeat.o(50967);
            }
        } else {
            AppMethodBeat.o(50967);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c nwi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(c cVar) {
            super(0);
            this.nwi = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 161
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.e.invoke():java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, hxF = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$evictExpiredCache$1$3"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c nwi;
        final /* synthetic */ o nwj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar, o oVar) {
            super(0);
            this.nwi = cVar;
            this.nwj = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(50958);
            AnonymousClass1 r1 = new kotlin.g.a.b<String, Boolean>(this) {
                /* class com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.b.AnonymousClass1 */
                final /* synthetic */ b nwk;

                {
                    this.nwk = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ Boolean invoke(String str) {
                    AppMethodBeat.i(50956);
                    Boolean valueOf = Boolean.valueOf(aed(str));
                    AppMethodBeat.o(50956);
                    return valueOf;
                }

                public final boolean aed(String str) {
                    boolean z;
                    Throwable th;
                    Throwable th2;
                    boolean z2;
                    AppMethodBeat.i(50957);
                    String str2 = str;
                    if (str2 == null || str2.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        AppMethodBeat.o(50957);
                        return false;
                    }
                    Cursor rawQuery = this.nwk.nwi.kOg.rawQuery("select count(*) from WxaAppWebRenderingCacheAccessStatsTable where cacheFilePath =?", new String[]{str}, 2);
                    try {
                        Cursor cursor = rawQuery;
                        if (cursor == null || !cursor.moveToFirst() || cursor.getInt(0) <= 0) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        kotlin.f.b.a(rawQuery, null);
                        AppMethodBeat.o(50957);
                        return z2;
                    } catch (Throwable th3) {
                        th = th3;
                        th2 = th;
                        kotlin.f.b.a(rawQuery, th2);
                        AppMethodBeat.o(50957);
                        throw th;
                    }
                }
            };
            o[] a2 = this.nwj.a(e.nwm);
            if (a2 != null) {
                for (o oVar : a2) {
                    p.g(oVar, LocaleUtil.ITALIAN);
                    if (!r1.aed(oVar.getAbsolutePath())) {
                        oVar.delete();
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(50958);
                return xVar;
            }
            AppMethodBeat.o(50958);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheCleanupLogic$evictExpiredCache$1$4"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c nwi;
        final /* synthetic */ o nwj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(c cVar, o oVar) {
            super(0);
            this.nwi = cVar;
            this.nwj = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0085  */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke() {
            /*
            // Method dump skipped, instructions count: 205
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.c.invoke():java.lang.Object");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.String iq(boolean r3) {
        /*
            r2 = 50969(0xc719, float:7.1423E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            android.util.Pair r0 = com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.gJ(r3)
            java.lang.Object r0 = r0.second
            com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo r0 = (com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo) r0
            if (r0 == 0) goto L_0x0042
            boolean r1 = r0.kNY
            if (r1 != 0) goto L_0x0023
            java.lang.String r1 = r0.pkgPath
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0020
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0037
        L_0x0020:
            r1 = 1
        L_0x0021:
            if (r1 == 0) goto L_0x0039
        L_0x0023:
            com.tencent.mm.plugin.appbrand.appcache.AssetReader r0 = com.tencent.mm.plugin.appbrand.appcache.AssetReader.kKj
            java.lang.String r1 = "AssetReader.INSTANCE"
            kotlin.g.b.p.g(r0, r1)
            com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader r0 = (com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader) r0
        L_0x002d:
            if (r0 == 0) goto L_0x0042
            java.lang.String r0 = r0.bvc()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0036:
            return r0
        L_0x0037:
            r1 = 0
            goto L_0x0021
        L_0x0039:
            com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader$PkgReader r1 = new com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader$PkgReader
            r1.<init>(r0)
            r0 = r1
            com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader r0 = (com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader) r0
            goto L_0x002d
        L_0x0042:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.page.web_renderingcache.d.iq(boolean):java.lang.String");
    }

    public static final /* synthetic */ int aec(String str) {
        WxaAttributes e2;
        WxaAttributes.WxaVersionInfo bAp;
        AppMethodBeat.i(50970);
        com.tencent.mm.plugin.appbrand.config.z buC = n.buC();
        if (buC == null || (e2 = buC.e(str, "versionInfo")) == null || (bAp = e2.bAp()) == null) {
            AppMethodBeat.o(50970);
            return -1;
        }
        int i2 = bAp.appVersion;
        AppMethodBeat.o(50970);
        return i2;
    }
}
