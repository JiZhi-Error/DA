package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.e.a;
import com.tencent.luggage.sdk.e.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.launching.d.c;
import com.tencent.mm.plugin.appbrand.launching.d.f;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.cye;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.t;

@Deprecated
abstract class az extends aw<WxaPkgWrappingInfo> implements w {
    static cye a(byy byy, b bVar) {
        f fVar;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(byy.Meg);
        objArr[1] = Boolean.valueOf(bVar == null);
        Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: localOldPkgVersion = %d, parallelCgiLogic is null? = %b", objArr);
        if (bVar != null) {
            c.a aVar = c.mYA;
            p.h(bVar, "parallelTasksCollection");
            a<?> aVar2 = bVar.cCy.get(1);
            if (aVar2 == null) {
                aVar2 = null;
            } else if (aVar2 == null) {
                throw new t("null cannot be cast to non-null type com.tencent.luggage.sdk.tasks.AppBrandBasePreFetchTask<T>");
            }
            if (aVar2 == null) {
                Log.w("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "getPreGetPkgDownloadInfo: ret == null!");
                fVar = null;
            } else {
                fVar = (f) aVar2;
            }
            if (fVar != null) {
                c.a<ddz> yn = fVar.yn(100);
                if (yn == null) {
                    Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preCgiBack is null");
                } else if (yn.iLC == null) {
                    Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preCgiBack.resp is null");
                } else {
                    Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: (%d,%d)", Integer.valueOf(yn.errType), Integer.valueOf(yn.errCode));
                }
                if (yn == null || yn.iLC == null || yn.errType != 0 || yn.errCode != 0) {
                    Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: check cgiBack fail");
                } else {
                    Iterator<cye> it = ((ddz) yn.iLC).MJa.iterator();
                    cye cye = null;
                    cye cye2 = null;
                    cye cye3 = null;
                    while (it.hasNext()) {
                        cye next = it.next();
                        if (Util.isNullOrNil(byy.MbW)) {
                            byy.MbW = "";
                        }
                        if (Util.isNullOrNil(next.MbW)) {
                            next.MbW = "";
                        }
                        if (next.MbZ != byy.MbZ || !byy.MbW.equals(next.MbW)) {
                            next = cye2;
                        } else if (next.LVm) {
                            cye3 = next;
                        } else if (next.LVl) {
                            cye = next;
                        }
                        cye2 = next;
                    }
                    Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "obtainReleaseAppPkgWhenLocalBroken: patchUrl = [%s], zstdUrl = [%s], url = [%s]", cye, cye3, cye2);
                    if (((ddz) yn.iLC).version == byy.KXD) {
                        if (cye != null) {
                            return cye;
                        }
                        return cye3 != null ? cye3 : cye2;
                    }
                }
            } else {
                Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: preFetchGetDownloadInfoTask isnull");
            }
        } else {
            Log.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "getUrlByParallelCgi: parallelCgiLogic is null");
        }
        return null;
    }
}
