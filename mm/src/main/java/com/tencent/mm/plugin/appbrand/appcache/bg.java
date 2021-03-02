package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bg implements r {
    private static final Map<AppBrandRuntime, bg> kNE = new HashMap();
    private final q kNF;
    private final LinkedList<String> kNG = new LinkedList<>();
    private final String mAppId;

    public static String h(AppBrandRuntime appBrandRuntime, String str) {
        AppMethodBeat.i(134699);
        if (Vr(str)) {
            AppMethodBeat.o(134699);
            return null;
        }
        q.a UV = b(appBrandRuntime, false).UV(str);
        if (UV != null) {
            String a2 = ab.a(UV.kKH, UV.fileName);
            AppMethodBeat.o(134699);
            return a2;
        }
        AppMethodBeat.o(134699);
        return null;
    }

    static {
        AppMethodBeat.i(134709);
        AppMethodBeat.o(134709);
    }

    public static r M(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(259546);
        r b2 = b(appBrandRuntime, false);
        AppMethodBeat.o(259546);
        return b2;
    }

    public static r b(AppBrandRuntime appBrandRuntime, boolean z) {
        bg bgVar;
        AppMethodBeat.i(219303);
        if (appBrandRuntime == null || appBrandRuntime.isDestroyed()) {
            r rVar = r.a.kKL;
            AppMethodBeat.o(219303);
            return rVar;
        } else if (appBrandRuntime.OT() == null) {
            Log.e("MicroMsg.WxaPkgRuntimeReader", "obtainReader with runtime(%s) sysConfig(NULL), stack=%s", appBrandRuntime.mAppId, android.util.Log.getStackTraceString(new Throwable()));
            r rVar2 = r.a.kKL;
            AppMethodBeat.o(219303);
            return rVar2;
        } else {
            synchronized (kNE) {
                try {
                    bgVar = kNE.get(appBrandRuntime);
                    if (bgVar == null || z) {
                        if (z) {
                            N(appBrandRuntime);
                        }
                        bgVar = new bg(appBrandRuntime);
                        kNE.put(appBrandRuntime, bgVar);
                    }
                } finally {
                    AppMethodBeat.o(219303);
                }
            }
            return bgVar;
        }
    }

    public static boolean N(AppBrandRuntime appBrandRuntime) {
        bg remove;
        AppMethodBeat.i(219304);
        synchronized (kNE) {
            try {
                remove = kNE.remove(appBrandRuntime);
            } catch (Throwable th) {
                AppMethodBeat.o(219304);
                throw th;
            }
        }
        if (remove != null) {
            remove.close();
            AppMethodBeat.o(219304);
            return true;
        }
        AppMethodBeat.o(219304);
        return false;
    }

    private bg(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(134701);
        this.mAppId = appBrandRuntime.mAppId;
        Log.i("MicroMsg.WxaPkgRuntimeReader", "<init> appId[%s] sysConfig.class[%s], stacktrace=%s", this.mAppId, appBrandRuntime.OT().getClass().getName(), android.util.Log.getStackTraceString(new Throwable()));
        this.kNF = bo.a(appBrandRuntime, this);
        this.kNF.bvy();
        AppMethodBeat.o(134701);
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final boolean UW(String str) {
        AppMethodBeat.i(134702);
        try {
            boolean UW = this.kNF.UW(UX(str));
            AppMethodBeat.o(134702);
            return UW;
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(134702);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final List<ModulePkgInfo> bvz() {
        AppMethodBeat.i(134703);
        List<ModulePkgInfo> bvz = this.kNF.bvz();
        AppMethodBeat.o(134703);
        return bvz;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final List<String> bvA() {
        AppMethodBeat.i(219305);
        List<String> bvA = this.kNF.bvA();
        AppMethodBeat.o(219305);
        return bvA;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v19, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.appbrand.appcache.r
    public final <T> T f(String str, Class<T> cls) {
        int i2;
        AppMethodBeat.i(134704);
        try {
            String UX = UX(str);
            long currentTimeMillis = System.currentTimeMillis();
            T t = null;
            InputStream UU = UU(UX);
            if (UU != null) {
                try {
                    i2 = UU.available();
                } catch (IOException e2) {
                    Log.e("MicroMsg.WxaPkgRuntimeReader", "openRead, appId = %s, reqURL = %s, access stream.available e = %s", this.mAppId, UX, e2);
                    i2 = -1;
                }
                t = b.a.kNH.get(cls).b(UX, UU);
            } else {
                i2 = -1;
            }
            Object[] objArr = new Object[6];
            objArr[0] = this.mAppId;
            objArr[1] = UX;
            objArr[2] = Boolean.valueOf(t == null);
            objArr[3] = cls.getName();
            objArr[4] = Integer.valueOf(i2);
            objArr[5] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            Log.i("MicroMsg.WxaPkgRuntimeReader", "openRead, appId = %s, reqURL = %s, null(%B), type = %s, length = %d, cost = %dms", objArr);
            AppMethodBeat.o(134704);
            return t;
        } catch (IllegalArgumentException e3) {
            AppMethodBeat.o(134704);
            return null;
        }
    }

    public final void Vq(String str) {
        AppMethodBeat.i(178547);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(178547);
            return;
        }
        this.kNG.add(str);
        AppMethodBeat.o(178547);
    }

    public final q bwy() {
        return this.kNF;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.r
    public final String UX(String str) {
        AppMethodBeat.i(134705);
        Iterator<String> it = this.kNG.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                AppMethodBeat.o(134705);
                return str;
            }
        }
        if (Vr(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid URL");
            AppMethodBeat.o(134705);
            throw illegalArgumentException;
        }
        String We = n.We(str);
        if (We.startsWith("/__APP__")) {
            We = n.We(We.substring(8));
        }
        AppMethodBeat.o(134705);
        return We;
    }

    private static boolean Vr(String str) {
        AppMethodBeat.i(134706);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(134706);
            return true;
        } else if (URLUtil.isAboutUrl(str)) {
            AppMethodBeat.o(134706);
            return true;
        } else if (com.tencent.mm.plugin.appbrand.ac.d.afC(str)) {
            AppMethodBeat.o(134706);
            return true;
        } else if (URLUtil.isFileUrl(str)) {
            AppMethodBeat.o(134706);
            return true;
        } else {
            AppMethodBeat.o(134706);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final InputStream UU(String str) {
        AppMethodBeat.i(134707);
        try {
            InputStream UU = this.kNF.UU(UX(str));
            AppMethodBeat.o(134707);
            return UU;
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(134707);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final q.a UV(String str) {
        AppMethodBeat.i(178548);
        try {
            q.a UV = this.kNF.UV(UX(str));
            AppMethodBeat.o(178548);
            return UV;
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(178548);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final WxaPkg UT(String str) {
        AppMethodBeat.i(178550);
        try {
            WxaPkg UT = this.kNF.UT(UX(str));
            AppMethodBeat.o(178550);
            return UT;
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(178550);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final void bvy() {
        AppMethodBeat.i(178551);
        this.kNF.bvy();
        AppMethodBeat.o(178551);
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final void close() {
        AppMethodBeat.i(178552);
        this.kNF.close();
        AppMethodBeat.o(178552);
    }

    interface b<T> {
        T b(String str, InputStream inputStream);

        public static class a {
            static final Map<Class, b> kNH;

            static {
                AppMethodBeat.i(134691);
                HashMap hashMap = new HashMap();
                kNH = hashMap;
                hashMap.put(InputStream.class, new c((byte) 0));
                kNH.put(WebResourceResponse.class, new e((byte) 0));
                kNH.put(String.class, new d((byte) 0));
                kNH.put(byte[].class, new a((byte) 0));
                AppMethodBeat.o(134691);
            }
        }
    }

    static final class c implements b<InputStream> {
        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.plugin.appbrand.appcache.bg.b
        public final /* bridge */ /* synthetic */ InputStream b(String str, InputStream inputStream) {
            return inputStream;
        }
    }

    static final class e implements b<WebResourceResponse> {
        private e() {
        }

        /* synthetic */ e(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.plugin.appbrand.appcache.bg.b
        public final /* synthetic */ WebResourceResponse b(String str, InputStream inputStream) {
            AppMethodBeat.i(134693);
            WebResourceResponse webResourceResponse = new WebResourceResponse(MimeTypeUtil.getMimeTypeByFilePath(str), MimeTypeUtil.ContentType.DEFAULT_CHARSET, inputStream);
            AppMethodBeat.o(134693);
            return webResourceResponse;
        }
    }

    static final class d implements b<String> {
        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.plugin.appbrand.appcache.bg.b
        public final /* synthetic */ String b(String str, InputStream inputStream) {
            AppMethodBeat.i(134692);
            String convertStreamToString = com.tencent.mm.plugin.appbrand.ac.d.convertStreamToString(inputStream);
            AppMethodBeat.o(134692);
            return convertStreamToString;
        }
    }

    static final class a implements b<byte[]> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.plugin.appbrand.appcache.bg.b
        public final /* synthetic */ byte[] b(String str, InputStream inputStream) {
            AppMethodBeat.i(134690);
            byte[] H = com.tencent.mm.plugin.appbrand.ac.d.H(inputStream);
            AppMethodBeat.o(134690);
            return H;
        }
    }

    public static void L(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(134694);
        b(appBrandRuntime, false).bvy();
        AppMethodBeat.o(134694);
    }

    public static String d(AppBrandRuntime appBrandRuntime, String str) {
        AppMethodBeat.i(134696);
        String nullAsNil = Util.nullAsNil((String) b(appBrandRuntime, false).f(str, String.class));
        AppMethodBeat.o(134696);
        return nullAsNil;
    }

    public static WebResourceResponse e(AppBrandRuntime appBrandRuntime, String str) {
        AppMethodBeat.i(134697);
        WebResourceResponse webResourceResponse = (WebResourceResponse) b(appBrandRuntime, false).f(str, WebResourceResponse.class);
        AppMethodBeat.o(134697);
        return webResourceResponse;
    }

    public static InputStream f(AppBrandRuntime appBrandRuntime, String str) {
        AppMethodBeat.i(134698);
        InputStream inputStream = (InputStream) b(appBrandRuntime, false).f(str, InputStream.class);
        AppMethodBeat.o(134698);
        return inputStream;
    }

    public static boolean g(AppBrandRuntime appBrandRuntime, String str) {
        AppMethodBeat.i(176544);
        boolean UW = b(appBrandRuntime, false).UW(str);
        AppMethodBeat.o(176544);
        return UW;
    }
}
