package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J$\u0010\u000f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl;", "Lcom/tencent/mm/plugin/appbrand/service/IWxaPkgStorageExportService;", "()V", "occupiedPkgSet", "Ljava/util/concurrent/ConcurrentSkipListSet;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl$OccupiedPkgKey;", "getOccupiedPkgList", "", "getPkgRecord", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "appId", "", "versionType", "", "version", "insertPkg", "", "filePath", "setPkgIsOccupied", "", "Companion", "OccupiedPkgKey", "plugin-appbrand-integration_release"})
public final class c implements v {
    public static final a kQs = new a((byte) 0);
    private final ConcurrentSkipListSet<b> kQr = new ConcurrentSkipListSet<>();

    static {
        AppMethodBeat.i(228114);
        AppMethodBeat.o(228114);
    }

    public static final c bwU() {
        AppMethodBeat.i(228115);
        c bwU = a.bwU();
        AppMethodBeat.o(228115);
        return bwU;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl$Companion;", "", "()V", "TAG", "", "VERSION_UNDEFINED", "", "INSTANCE", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c bwU() {
            AppMethodBeat.i(228103);
            com.tencent.mm.kernel.c.a af = g.af(v.class);
            if (af == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceImpl");
                AppMethodBeat.o(228103);
                throw tVar;
            }
            c cVar = (c) af;
            AppMethodBeat.o(228103);
            return cVar;
        }
    }

    public c() {
        AppMethodBeat.i(228113);
        AppMethodBeat.o(228113);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.v
    public final boolean s(String str, int i2, String str2) {
        AppMethodBeat.i(228109);
        if (s.YS(str2)) {
            String str3 = str;
            if (!(str3 == null || str3.length() == 0)) {
                String aT = ba.aT(new ad(str).toString(), i2);
                if (!FilesCopy.copy(str2, aT, false)) {
                    Log.e("MicroMsg.WxaPkgStorageExportServiceImpl", "copy pkg failed: appId[%s] version[%d] from %s to %s", str, Integer.valueOf(i2), str2, aT);
                    AppMethodBeat.o(228109);
                    return false;
                }
                bd bdVar = new bd();
                bdVar.field_appId = str;
                bdVar.field_version = i2;
                bdVar.field_debugType = 0;
                bdVar.field_pkgPath = aT;
                if (aT == null) {
                    p.hyc();
                }
                bdVar.field_versionMd5 = WxaPkgWrappingInfo.n(new o(aT));
                boolean b2 = n.buL().b(bdVar);
                AppMethodBeat.o(228109);
                return b2;
            }
        }
        AppMethodBeat.o(228109);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.v
    public final bd VF(String str) {
        boolean z;
        AppMethodBeat.i(228110);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(228110);
            return null;
        }
        bd a2 = n.buL().a(str, 0, new String[0]);
        if (a2 != null) {
            String str3 = a2.field_pkgPath;
            if (str3 == null || str3.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && s.YS(a2.field_pkgPath)) {
                if (bj.a(new o(a2.field_pkgPath), new String[]{a2.field_versionMd5, a2.field_NewMd5}, str, "getPkgRecord")) {
                    AppMethodBeat.o(228110);
                    return a2;
                }
            }
        }
        AppMethodBeat.o(228110);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.v
    public final bd H(String str, int i2, int i3) {
        bd a2;
        boolean z;
        AppMethodBeat.i(228111);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(228111);
            return null;
        }
        if (i3 == 0) {
            a2 = n.buL().a(str, i2, new String[0]);
        } else {
            a2 = n.buL().a(str, i3, i2, new String[0]);
        }
        if (a2 != null) {
            String str3 = a2.field_pkgPath;
            if (str3 == null || str3.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && s.YS(a2.field_pkgPath)) {
                if (bj.a(new o(a2.field_pkgPath), new String[]{a2.field_versionMd5, a2.field_NewMd5}, str, "getPkgRecord")) {
                    AppMethodBeat.o(228111);
                    return a2;
                }
            }
        }
        AppMethodBeat.o(228111);
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0000H\u0002J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/WxaPkgStorageExportServiceImpl$OccupiedPkgKey;", "", "appId", "", "versionType", "", "version", "(Ljava/lang/String;II)V", "getAppId", "()Ljava/lang/String;", "getVersion", "()I", "getVersionType", "compareTo", FacebookRequestErrorClassification.KEY_OTHER, "component1", "component2", "component3", "copy", "equals", "", "", "hashCode", "toString", "plugin-appbrand-integration_release"})
    public static final class b implements Comparable<b> {
        public final String appId;
        public final int iOo = 0;
        public final int version;

        public final String toString() {
            AppMethodBeat.i(228108);
            String str = "OccupiedPkgKey(appId=" + this.appId + ", versionType=" + this.iOo + ", version=" + this.version + ")";
            AppMethodBeat.o(228108);
            return str;
        }

        public b(String str, int i2) {
            p.h(str, "appId");
            AppMethodBeat.i(228107);
            this.appId = str;
            this.version = i2;
            AppMethodBeat.o(228107);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(b bVar) {
            AppMethodBeat.i(228106);
            b bVar2 = bVar;
            p.h(bVar2, FacebookRequestErrorClassification.KEY_OTHER);
            int hashCode = hashCode() - bVar2.hashCode();
            AppMethodBeat.o(228106);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(228104);
            if (this == obj) {
                AppMethodBeat.o(228104);
                return true;
            }
            if (!p.j(getClass(), obj != null ? obj.getClass() : null)) {
                AppMethodBeat.o(228104);
                return false;
            } else if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.appcache.predownload.export.WxaPkgStorageExportServiceImpl.OccupiedPkgKey");
                AppMethodBeat.o(228104);
                throw tVar;
            } else if (!p.j(this.appId, ((b) obj).appId)) {
                AppMethodBeat.o(228104);
                return false;
            } else if (this.iOo != ((b) obj).iOo) {
                AppMethodBeat.o(228104);
                return false;
            } else if (this.version != ((b) obj).version) {
                AppMethodBeat.o(228104);
                return false;
            } else {
                AppMethodBeat.o(228104);
                return true;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(228105);
            int hashCode = (((this.appId.hashCode() * 31) + this.iOo) * 31) + this.version;
            AppMethodBeat.o(228105);
            return hashCode;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.service.v
    public final void bc(String str, int i2) {
        AppMethodBeat.i(228112);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(228112);
            return;
        }
        this.kQr.add(new b(str, i2));
        AppMethodBeat.o(228112);
    }

    public final List<b> bxg() {
        AppMethodBeat.i(258046);
        LinkedList linkedList = new LinkedList(this.kQr);
        AppMethodBeat.o(258046);
        return linkedList;
    }
}
