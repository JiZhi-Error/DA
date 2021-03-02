package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.k;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.xweb.WebResourceResponse;
import java.io.InputStream;

public final class c {
    private static final String[] kMx = ay.kMx;

    private static WebResourceResponse dd(String str, String str2) {
        WxaPkg wxaPkg;
        InputStream inputStream;
        Exception e2;
        AppMethodBeat.i(121478);
        try {
            wxaPkg = new WxaPkg(str);
            try {
                wxaPkg.bvf();
                inputStream = wxaPkg.UR(str2);
                try {
                    String mimeTypeByFilePath = MimeTypeUtil.getMimeTypeByFilePath(str2);
                    Util.qualityClose(wxaPkg);
                    WebResourceResponse webResourceResponse = new WebResourceResponse(mimeTypeByFilePath, MimeTypeUtil.ContentType.DEFAULT_CHARSET, inputStream);
                    AppMethodBeat.o(121478);
                    return webResourceResponse;
                } catch (Exception e3) {
                    e2 = e3;
                    Log.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile with pkgPath(%s), exp = %s", str, Util.stackTraceToString(e2));
                    Util.qualityClose(wxaPkg);
                    Util.qualityClose(inputStream);
                    AppMethodBeat.o(121478);
                    return null;
                }
            } catch (Exception e4) {
                e2 = e4;
                inputStream = null;
                Log.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile with pkgPath(%s), exp = %s", str, Util.stackTraceToString(e2));
                Util.qualityClose(wxaPkg);
                Util.qualityClose(inputStream);
                AppMethodBeat.o(121478);
                return null;
            }
        } catch (Exception e5) {
            e2 = e5;
            inputStream = null;
            wxaPkg = null;
            Log.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile with pkgPath(%s), exp = %s", str, Util.stackTraceToString(e2));
            Util.qualityClose(wxaPkg);
            Util.qualityClose(inputStream);
            AppMethodBeat.o(121478);
            return null;
        }
    }

    public static String dg(String str, String str2) {
        AppMethodBeat.i(121481);
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(121481);
            return "";
        }
        WebResourceResponse dh = dh(str, str2);
        if (dh == null || dh.mInputStream == null) {
            Log.e("MicroMsg.ResPkgReader", "get cache content for id : %s from url : %s, failed", str, str2);
            AppMethodBeat.o(121481);
            return "";
        }
        try {
            Log.d("MicroMsg.ResPkgReader", "getCacheContent, dataStream available = %d, url = %s", Integer.valueOf(dh.mInputStream.available()), str2);
        } catch (Exception e2) {
            Log.e("MicroMsg.ResPkgReader", "getCacheContent exp = %s, id = %s, url = %s", e2, str, str2);
        }
        String convertStreamToString = d.convertStreamToString(dh.mInputStream);
        AppMethodBeat.o(121481);
        return convertStreamToString;
    }

    public static WebResourceResponse dh(String str, String str2) {
        AppMethodBeat.i(121482);
        Log.i("MicroMsg.ResPkgReader", "getCacheResource called, id = %s, reqURL = %s", str, str2);
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(121482);
            return null;
        } else if (z.C(str2, "about:blank")) {
            AppMethodBeat.o(121482);
            return null;
        } else if (!d.afC(str2)) {
            String We = n.We(str2);
            if (a.contains(kMx, We)) {
                WebResourceResponse df = df(str, We);
                AppMethodBeat.o(121482);
                return df;
            }
            WebResourceResponse de = de(str, We);
            if (de == null) {
                Bundle bundle = new Bundle();
                bundle.putString("id", str);
                bundle.putInt("widgetState", 2102);
                h.a(i.bBL().Yn(str), bundle, f.a.class, null);
            }
            AppMethodBeat.o(121482);
            return de;
        } else {
            AppMethodBeat.o(121482);
            return null;
        }
    }

    private static WebResourceResponse de(String str, String str2) {
        WxaPkgWrappingInfo wxaPkgWrappingInfo;
        AppMethodBeat.i(121479);
        WxaWidgetContext Ys = k.Ys(str);
        if (Ys != null) {
            wxaPkgWrappingInfo = Ys.bBO();
        } else {
            wxaPkgWrappingInfo = null;
        }
        if (wxaPkgWrappingInfo == null) {
            Log.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null appInfo by id %s", str);
            AppMethodBeat.o(121479);
            return null;
        } else if (Util.isNullOrNil(wxaPkgWrappingInfo.pkgPath)) {
            Log.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get Null Or Nil pkgPath[%s] by appId %s", wxaPkgWrappingInfo.pkgPath, str);
            AppMethodBeat.o(121479);
            return null;
        } else {
            String str3 = wxaPkgWrappingInfo.pkgPath;
            if (Util.isNullOrNil(str3)) {
                Log.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null or nil pkgLocalPath");
                AppMethodBeat.o(121479);
                return null;
            }
            Log.d("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, id(%s), fileName(%s)", str, str2);
            WebResourceResponse dd = dd(str3, str2);
            AppMethodBeat.o(121479);
            return dd;
        }
    }

    private static WebResourceResponse df(String str, String str2) {
        WxaPkgWrappingInfo wxaPkgWrappingInfo;
        AppMethodBeat.i(121480);
        WxaWidgetContext Ys = k.Ys(str);
        if (Ys != null) {
            wxaPkgWrappingInfo = Ys.bBP();
        } else {
            wxaPkgWrappingInfo = null;
        }
        if (wxaPkgWrappingInfo == null) {
            AppMethodBeat.o(121480);
            return null;
        } else if (wxaPkgWrappingInfo.kNY) {
            InputStream openRead = ay.openRead(str2);
            if (openRead != null) {
                WebResourceResponse webResourceResponse = new WebResourceResponse(MimeTypeUtil.getMimeTypeByFilePath(str2), MimeTypeUtil.ContentType.DEFAULT_CHARSET, openRead);
                AppMethodBeat.o(121480);
                return webResourceResponse;
            }
            AppMethodBeat.o(121480);
            return null;
        } else if (Util.isNullOrNil(wxaPkgWrappingInfo.pkgPath)) {
            Log.e("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, pkgPath[%s] is Null Or Nil", wxaPkgWrappingInfo.pkgPath);
            AppMethodBeat.o(121480);
            return null;
        } else {
            Log.d("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, id(%s), fileName(%s)", str, str2);
            WebResourceResponse dd = dd(wxaPkgWrappingInfo.pkgPath, str2);
            AppMethodBeat.o(121480);
            return dd;
        }
    }
}
