package com.tencent.mm.plugin.appbrand.appcache.predownload.d;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.b.a.kr;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J:\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0007J6\u0010\u0011\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0014\u001a\u00020\tH\u0007J<\u0010\u0015\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStatStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStats;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "checkReportOnLocalPkgFound", "", "appLaunchInstanceId", "", "appId", "version", "", "packageType", "packageKey", "checkReportOnLocalPkgFoundInternal", "delete", "", "pruneOutdatedRecords", "setSource", "source", "reportId", "Companion", "plugin-appbrand-integration_release"})
public final class a extends c<b> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(b.iBg, "AppBrandWxaPkgPreDownloadStatistics2"), "DROP TABLE IF EXISTS AppBrandWxaPkgPreDownloadStatistics"};
    public static final C0551a kQz = new C0551a((byte) 0);
    private final ISQLiteDatabase db;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, b.iBg, "AppBrandWxaPkgPreDownloadStatistics2", b.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        AppMethodBeat.i(50207);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(50207);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStatStorage$Companion;", "", "()V", "TABLE_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.predownload.d.a$a  reason: collision with other inner class name */
    public static final class C0551a {
        private C0551a() {
        }

        public /* synthetic */ C0551a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(50208);
        AppMethodBeat.o(50208);
    }

    public final boolean gC(String str) {
        boolean z;
        AppMethodBeat.i(50203);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(50203);
            return false;
        }
        if (this.db.delete("AppBrandWxaPkgPreDownloadStatistics2", "appId=?", new String[]{str}) > 0) {
            AppMethodBeat.o(50203);
            return true;
        }
        AppMethodBeat.o(50203);
        return false;
    }

    public final void bwV() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(50204);
        Cursor all = getAll();
        try {
            Cursor cursor = all;
            if (cursor != null && cursor.moveToFirst()) {
                LinkedList<b> linkedList = new LinkedList();
                do {
                    b bVar = new b();
                    bVar.convertFrom(cursor);
                    linkedList.add(bVar);
                } while (cursor.moveToNext());
                for (b bVar2 : linkedList) {
                    ad adVar = new ad(bVar2.field_appId, bVar2.field_packageKey, bVar2.field_packageType);
                    bh buL = n.buL();
                    bd a2 = buL != null ? buL.a(adVar.toString(), bVar2.field_version, 0, "pkgPath") : null;
                    if (a2 != null) {
                        String str = a2.field_pkgPath;
                        if (!(str == null || str.length() == 0)) {
                        }
                    }
                    super.delete(bVar2, new String[0]);
                }
            }
            x xVar = x.SXb;
            kotlin.f.b.a(all, null);
            AppMethodBeat.o(50204);
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            kotlin.f.b.a(all, th2);
            AppMethodBeat.o(50204);
            throw th;
        }
    }

    public final void a(String str, String str2, int i2, int i3, String str3) {
        AppMethodBeat.i(162171);
        d.b("MicroMsg.AppBrand.PredownloadGetCodeStatStorage__report", new b(this, str, str2, i2, i3, str3));
        AppMethodBeat.o(162171);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ String kPQ;
        final /* synthetic */ a kQA;
        final /* synthetic */ String kQB;
        final /* synthetic */ int kQC;
        final /* synthetic */ int kQD;
        final /* synthetic */ String kQE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, String str, String str2, int i2, int i3, String str3) {
            super(0);
            this.kQA = aVar;
            this.kQB = str;
            this.kPQ = str2;
            this.kQC = i2;
            this.kQD = i3;
            this.kQE = str3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(50202);
            a.a(this.kQA, this.kQB, this.kPQ, this.kQC, this.kQD, this.kQE);
            x xVar = x.SXb;
            AppMethodBeat.o(50202);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(a aVar, String str, String str2, int i2, int i3, String str3) {
        b bVar;
        int i4;
        boolean z = true;
        AppMethodBeat.i(50209);
        String str4 = str2;
        if (!(str4 == null || str4.length() == 0)) {
            b bVar2 = new b();
            bVar2.field_appId = str2;
            bVar2.field_version = i2;
            bVar2.field_packageType = i3;
            if (bVar2.field_packageType == 6) {
                bVar = bVar2;
            } else if (bVar2.field_packageType == 12 || bVar2.field_packageType == 13) {
                str2 = "";
                bVar = bVar2;
            } else if (str3 == null) {
                str2 = "";
                bVar = bVar2;
            } else {
                str2 = str3;
                bVar = bVar2;
            }
            bVar.field_packageKey = str2;
            bVar2.field_hitCount = 0;
            bVar2.field_source = 0;
            bVar2.field_reportId = 0;
            if (aVar.get(bVar2, new String[0])) {
                if (bVar2.field_source == 1) {
                    if (bVar2.field_hitCount > 0) {
                        z = false;
                    }
                    if (!z) {
                        i4 = 57;
                    } else {
                        i4 = 56;
                    }
                    com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar2 = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                    com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.dN(bVar2.field_reportId, i4);
                    kr krVar = new kr();
                    krVar.yd(((com.tencent.mm.plugin.appbrand.appstorage.b) n.W(com.tencent.mm.plugin.appbrand.appstorage.b.class)).VI(bVar2.field_appId));
                    krVar.ye(bVar2.field_appId);
                    krVar.tV((long) bVar2.field_version);
                    krVar.tW(z ? 1 : 0);
                    krVar.tX((long) bVar2.field_reportId);
                    krVar.tY((long) bVar2.field_packageType);
                    krVar.yf(bVar2.field_packageKey);
                    krVar.yg(str);
                    krVar.bfK();
                }
                bVar2.field_hitCount++;
                aVar.update(bVar2, new String[0]);
            }
        }
        AppMethodBeat.o(50209);
    }
}
