package com.tencent.mm.plugin.appbrand.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/complaint/AppBrandComplaintService;", "Lcom/tencent/mm/plugin/appbrand/complaint/IAppBrandComplaintService;", "()V", "TAG", "", "imageCacheDir", "imageSet", "", "cleanCacheDir", "", "cleanCacheDirInMM", "getCacheDir", "registerFileItem", "path", "registerFileItemInMM", "plugin-appbrand-integration_release"})
public final class b implements c {
    public static final b lbA = new b();
    private static final Set<String> lby = new LinkedHashSet();
    private static String lbz;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.d.b$b  reason: collision with other inner class name */
    static final class C0568b<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        public static final C0568b lbC = new C0568b();

        static {
            AppMethodBeat.i(228156);
            AppMethodBeat.o(228156);
        }

        C0568b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, d<IPCVoid> dVar) {
            AppMethodBeat.i(228155);
            b bVar = b.lbA;
            String str = iPCString.value;
            p.g(str, "data.value");
            b.WU(str);
            AppMethodBeat.o(228155);
        }
    }

    static {
        o oVar;
        AppMethodBeat.i(228159);
        try {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            oVar = o.X(context.getExternalCacheDir());
        } catch (Exception e2) {
            oVar = null;
        }
        if (oVar == null) {
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            oVar = new o(context2.getCacheDir());
        }
        String absolutePath = oVar.getAbsolutePath();
        p.g(absolutePath, "cacheDir.absolutePath");
        if (!n.nm(absolutePath, FilePathGenerator.ANDROID_DIR_SEP)) {
            absolutePath = absolutePath + FilePathGenerator.ANDROID_DIR_SEP;
        }
        String str = absolutePath + "wxacomplaint";
        if (s.boN(str)) {
            lbz = str;
        }
        AppMethodBeat.o(228159);
    }

    private b() {
    }

    @Override // com.tencent.mm.plugin.appbrand.d.c
    public final void WT(String str) {
        AppMethodBeat.i(228157);
        p.h(str, "path");
        h.a(MainProcessIPCService.dkO, new IPCString(str), C0568b.lbC.getClass(), null);
        AppMethodBeat.o(228157);
    }

    @Override // com.tencent.mm.plugin.appbrand.d.c
    public final String getCacheDir() {
        return lbz;
    }

    @Override // com.tencent.mm.plugin.appbrand.d.c
    public final void bzB() {
        AppMethodBeat.i(228158);
        h.a(MainProcessIPCService.dkO, new IPCVoid(), a.lbB.getClass(), null);
        AppMethodBeat.o(228158);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "invoke"})
    static final class a<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid> {
        public static final a lbB = new a();

        static {
            AppMethodBeat.i(228154);
            AppMethodBeat.o(228154);
        }

        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, d<IPCVoid> dVar) {
            AppMethodBeat.i(228153);
            b bVar = b.lbA;
            b.bzC();
            AppMethodBeat.o(228153);
        }
    }

    public static final /* synthetic */ void WU(String str) {
        AppMethodBeat.i(228160);
        WebViewJSSDKImageItem webViewJSSDKImageItem = new WebViewJSSDKImageItem();
        webViewJSSDKImageItem.xlR = false;
        webViewJSSDKImageItem.laR = str;
        webViewJSSDKImageItem.lPx = str;
        webViewJSSDKImageItem.dJX = ay.aYY(str);
        g.gdv().a(webViewJSSDKImageItem);
        Log.i("MicroMsg.AppBrandComplaintService", "registerFileItem, filePath:" + str + ", localId:" + webViewJSSDKImageItem.dJX);
        Set<String> set = lby;
        String str2 = webViewJSSDKImageItem.dJX;
        p.g(str2, "fileItem.localId");
        set.add(str2);
        AppMethodBeat.o(228160);
    }

    public static final /* synthetic */ void bzC() {
        AppMethodBeat.i(228161);
        Log.i("MicroMsg.AppBrandComplaintService", "cleanCacheDir, cacheDir:" + lbz);
        s.deleteDir(lbz);
        Iterator<T> it = lby.iterator();
        while (it.hasNext()) {
            g.gdv().aYN(it.next());
        }
        AppMethodBeat.o(228161);
    }
}
