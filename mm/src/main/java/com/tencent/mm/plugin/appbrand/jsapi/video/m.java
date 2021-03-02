package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.s.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class m implements h {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.h
    public final int a(String str, d dVar) {
        int i2 = -1;
        AppMethodBeat.i(46962);
        AppBrandVideoDownLoadMgr appBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.mvG;
        if (str == null || Util.isNullOrNil(str)) {
            Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad illegal url or preLoadCallback");
            AppMethodBeat.o(46962);
            return -1;
        }
        a aVar = new a();
        aVar.url = str;
        aVar.mvC = dVar;
        Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad  videoUrl = %s, preLoadVideoStat = %s", str, aVar.url);
        String genAdFileExist = appBrandVideoDownLoadMgr.genAdFileExist("gamead", aVar);
        if (Util.isNullOrNil(genAdFileExist)) {
            String genAdFilePath = appBrandVideoDownLoadMgr.genAdFilePath("gamead", aVar);
            if (!Util.isNullOrNil(genAdFilePath)) {
                d dVar2 = AppBrandVideoDownLoadMgr.mvH;
                String str2 = aVar.url;
                if (d.gRd != null) {
                    i2 = d.gRd.a(str2, genAdFilePath, dVar2);
                }
                Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo path=%s, ret=%d", genAdFilePath, Integer.valueOf(i2));
                if (i2 != 0) {
                    AppMethodBeat.o(46962);
                    return -3;
                }
                AppBrandVideoDownLoadMgr.mvF.put(aVar.url, aVar);
            } else {
                AppMethodBeat.o(46962);
                return -4;
            }
        } else if (!genAdFileExist.equalsIgnoreCase("downloading")) {
            AppBrandVideoDownLoadMgr.mvF.put(aVar.url, aVar);
            AppBrandVideoDownLoadMgr.at(aVar.url, true);
            aVar.mvC.dN(aVar.url, genAdFileExist);
        } else {
            AppMethodBeat.o(46962);
            return -2;
        }
        AppMethodBeat.o(46962);
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.h
    public final void report(String str) {
        AppMethodBeat.i(46963);
        AppBrandVideoDownLoadMgr.mvG.report(str);
        AppMethodBeat.o(46963);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.h
    public final String aaT(String str) {
        AppMethodBeat.i(46964);
        AppBrandVideoDownLoadMgr appBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.mvG;
        a aVar = new a();
        aVar.url = str;
        aVar.mvC = null;
        String genAdFileExist = appBrandVideoDownLoadMgr.genAdFileExist("gamead", aVar);
        if (Util.isNullOrNil(genAdFileExist)) {
            AppMethodBeat.o(46964);
            return null;
        } else if (!genAdFileExist.equalsIgnoreCase("downloading")) {
            AppMethodBeat.o(46964);
            return genAdFileExist;
        } else {
            AppMethodBeat.o(46964);
            return null;
        }
    }
}
