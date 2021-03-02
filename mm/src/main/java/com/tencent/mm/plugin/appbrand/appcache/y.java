package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.b;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public enum y implements b {
    INSTANCE;
    
    private int kLw = -1;
    private String kLx = null;

    private y(String str) {
    }

    public static y valueOf(String str) {
        AppMethodBeat.i(44300);
        y yVar = (y) Enum.valueOf(y.class, str);
        AppMethodBeat.o(44300);
        return yVar;
    }

    static {
        AppMethodBeat.i(44302);
        AppMethodBeat.o(44302);
    }

    /* access modifiers changed from: package-private */
    public final void W(int i2, String str) {
        this.kLw = i2;
        this.kLx = str;
    }

    @Override // com.tencent.mm.plugin.appbrand.api.b
    public final void gB(boolean z) {
        final int i2;
        AppMethodBeat.i(44301);
        Pair<WxaPkgIntegrityChecker.a, WxaPkgWrappingInfo> r = WxaPkgIntegrityChecker.r(z, true);
        if (r.second != null) {
            Log.i("MicroMsg.AppBrand.PkgDownloadService", "checkLibUnbrokenOrDownload, releaseLib:%b, skipLocalDevPack:true, already cached, version:%d", Boolean.valueOf(z), Integer.valueOf(((WxaPkgWrappingInfo) r.second).pkgVersion()));
            AppMethodBeat.o(44301);
            return;
        }
        if (r.first == WxaPkgIntegrityChecker.a.APP_BROKEN) {
            final bd a2 = n.buL().a("@LibraryAppId", z ? 0 : 999, "downloadURL", "version");
            if (a2 != null && !Util.isNullOrNil(a2.field_downloadURL)) {
                if (z) {
                    i2 = a2.field_version;
                } else {
                    i2 = 0;
                }
                AnonymousClass1 r4 = new bj.a() {
                    /* class com.tencent.mm.plugin.appbrand.appcache.y.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                    public final /* bridge */ /* synthetic */ void cr(WxaPkgLoadProgress wxaPkgLoadProgress) {
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, com.tencent.mm.plugin.appbrand.appcache.a.b$a$a, java.lang.Object] */
                    @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                    public final /* synthetic */ void a(String str, b.a.EnumC0543a aVar, bj.b bVar) {
                        AppMethodBeat.i(44297);
                        if (b.a.EnumC0543a.OK == aVar) {
                            as.bvQ();
                        }
                        AppMethodBeat.o(44297);
                    }
                };
                if (z) {
                    if (this.kLw > 0 && !Util.isNullOrNil(this.kLx)) {
                        boolean bvF = v.bvF();
                        Log.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] lib can be patch, abtest open %b", Boolean.valueOf(bvF));
                        if (bvF) {
                            if (WxaPkgIntegrityChecker.D("@LibraryAppId", 0, this.kLw).first == WxaPkgIntegrityChecker.a.APP_READY) {
                                Log.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] start incremental lib download");
                                s.a("@LibraryAppId", this.kLw, a2.field_version, this.kLx, r4);
                                AppMethodBeat.o(44301);
                                return;
                            }
                            Log.e("MicroMsg.AppBrand.PkgDownloadService", "[incremental] OldLibPkg[%d] or PatchUrl[%s] Invalid", Integer.valueOf(this.kLw), this.kLx);
                        }
                    }
                    bj.a(a2.field_downloadURL, a2.field_version, r4);
                    AppMethodBeat.o(44301);
                    return;
                }
                bj.a("@LibraryAppId", 999, a2.field_downloadURL, r4, new a.AbstractC0542a() {
                    /* class com.tencent.mm.plugin.appbrand.appcache.y.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.appbrand.appcache.a.a.AbstractC0542a
                    public final String bvJ() {
                        AppMethodBeat.i(44298);
                        String str = "_" + a2.field_versionMd5;
                        AppMethodBeat.o(44298);
                        return str;
                    }
                });
            }
        }
        AppMethodBeat.o(44301);
    }
}
