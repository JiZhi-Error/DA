package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public abstract class af implements bj.a {
    final boolean hbt;
    final int iOo;
    final aa mVh;

    /* access modifiers changed from: package-private */
    public abstract String bND();

    /* access modifiers changed from: package-private */
    public abstract void d(WxaPkgWrappingInfo wxaPkgWrappingInfo);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, com.tencent.mm.plugin.appbrand.appcache.a.b$a$a, java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
    public final /* synthetic */ void a(String str, b.a.EnumC0543a aVar, bj.b bVar) {
        WxaPkgWrappingInfo Vx;
        bj.b bVar2 = bVar;
        Log.i("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "[%s] onPkgUpdateResult, appId = %s, return = %s", bND(), str, aVar.name());
        if (b.a.EnumC0543a.OK.equals(aVar)) {
            if (Util.isNullOrNil(str) || !str.endsWith(ModulePkgInfo.PLUGIN_CODE)) {
                Vx = WxaPkgWrappingInfo.Vx(bVar2.filePath);
            } else {
                Vx = WxaPkgWrappingInfo.Vy(bVar2.filePath);
            }
            if (Vx == null) {
                Log.e("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "[%s] onPkgUpdateResult, ret=OK but obtain null appPkgInfo");
            } else {
                Vx.pkgVersion = bVar2.version;
                Vx.kNX = f.currentTime();
                Vx.kNW = bVar2.eix;
            }
            d(Vx);
            return;
        }
        if (b.a.EnumC0543a.SEVER_FILE_NOT_FOUND.equals(aVar)) {
            acb(f.getMMString(R.string.pi, new Object[0]));
            i.T(str, 23, this.iOo + 1);
        } else {
            acb(f.getMMString(R.string.pd, 2, Integer.valueOf(aVar.code)));
        }
        d(null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
    public final /* synthetic */ void cr(WxaPkgLoadProgress wxaPkgLoadProgress) {
        WxaPkgLoadProgress wxaPkgLoadProgress2 = wxaPkgLoadProgress;
        Log.i("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "hy: onPkgUpdateProgress: %s", wxaPkgLoadProgress2.toString());
        b(wxaPkgLoadProgress2);
    }

    af(int i2, aa aaVar) {
        this.iOo = i2;
        this.hbt = aaVar.bNh();
        this.mVh = aaVar;
    }

    private void acb(String str) {
        if (this.hbt) {
            ax.a(str, this.mVh);
            return;
        }
        Log.e("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "silent toast: %s", str);
    }

    /* access modifiers changed from: protected */
    public void b(WxaPkgLoadProgress wxaPkgLoadProgress) {
    }
}
