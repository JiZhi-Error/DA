package com.tencent.mm.plugin.xlabeffect;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.s;
import com.tencent.mm.xeffect.c;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u001e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/xlabeffect/XLabFileUtil;", "", "()V", "TAG", "", "assetsRoot", "filterPath", "getFilterPath", "()Ljava/lang/String;", "imageLabelName", "getImageLabelName", "localRoot", "getLocalRoot", "modelRoot", "getModelRoot", "versionFile", "checkFile", "", "checkFileMd5", "checkFileMd5Match", "", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "checkVersionMatch", "copyAssets", "plugin-xlabeffect_release"})
public final class e {
    private static final String JRD = (hiv + "/Models");
    private static final String JRE = JRE;
    public static final e JRF = new e();
    private static final String TAG = TAG;
    private static final String hDj = (hiv + "/filters");
    private static final String hiv = (com.tencent.mm.loader.j.b.aKC() + "xlab");

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "invoke"})
    public static final class a extends q implements kotlin.g.a.b<com.tencent.mm.plugin.expansions.b, x> {
        public static final a JRG = new a();

        static {
            AppMethodBeat.i(90534);
            AppMethodBeat.o(90534);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.plugin.expansions.b bVar) {
            AppMethodBeat.i(90533);
            com.tencent.mm.plugin.expansions.b bVar2 = bVar;
            p.h(bVar2, "$receiver");
            AnonymousClass1 r0 = AnonymousClass1.JRH;
            p.h(r0, "block");
            bVar2.rNC = r0;
            AnonymousClass2 r02 = AnonymousClass2.JRI;
            p.h(r02, "block");
            bVar2.rNA = r02;
            x xVar = x.SXb;
            AppMethodBeat.o(90533);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(90537);
        AppMethodBeat.o(90537);
    }

    private e() {
    }

    public static final /* synthetic */ boolean c(AssetManager assetManager, String str, String str2) {
        AppMethodBeat.i(261708);
        boolean b2 = b(assetManager, str, str2);
        AppMethodBeat.o(261708);
        return b2;
    }

    public static final /* synthetic */ boolean gly() {
        AppMethodBeat.i(215245);
        boolean glx = glx();
        AppMethodBeat.o(215245);
        return glx;
    }

    public static String glt() {
        return hiv;
    }

    public static String glu() {
        return JRD;
    }

    public static String glv() {
        return JRE;
    }

    public static void glw() {
        AppMethodBeat.i(90535);
        if (!glx()) {
            s.deleteDir(hiv);
            s.boN(hiv);
            d dVar = d.rNG;
            if (!d.aob("xlab")) {
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                AssetManager assets = context.getAssets();
                p.g(assets, "MMApplicationContext.getContext().assets");
                a(assets, "xlab", hiv);
                AppMethodBeat.o(90535);
                return;
            }
            d dVar2 = d.rNG;
            d.z(a.JRG);
        }
        AppMethodBeat.o(90535);
    }

    public static void hXZ() {
        AppMethodBeat.i(261706);
        com.tencent.mm.ac.d.b("XLabFileUtil_checkFile", b.VhZ);
        AppMethodBeat.o(261706);
    }

    public static void a(AssetManager assetManager, String str, String str2) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        Throwable th4 = null;
        AppMethodBeat.i(90536);
        p.h(assetManager, "assets");
        p.h(str, "assetsPath");
        p.h(str2, "localPath");
        Log.i(TAG, "copyAssets: " + str + "; " + str2);
        try {
            String[] list = assetManager.list(str);
            if (list == null) {
                AppMethodBeat.o(90536);
                return;
            }
            p.g(list, "assets.list(assetsPath) ?: return");
            if (list.length == 0) {
                InputStream open = assetManager.open(str);
                try {
                    InputStream inputStream = open;
                    OutputStream LM = s.LM(str2);
                    try {
                        OutputStream outputStream = LM;
                        p.g(inputStream, "input");
                        p.g(outputStream, "output");
                        kotlin.f.a.f(inputStream, outputStream);
                        kotlin.f.b.a(LM, null);
                        kotlin.f.b.a(open, null);
                    } catch (Throwable th5) {
                        th2 = th5;
                        th3 = th;
                        kotlin.f.b.a(LM, th3);
                        AppMethodBeat.o(90536);
                        throw th2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    th4 = th;
                    kotlin.f.b.a(open, th4);
                    AppMethodBeat.o(90536);
                    throw th;
                }
            } else {
                s.boN(str2);
                for (String str3 : list) {
                    a(assetManager, str + '/' + str3, str2 + '/' + str3);
                }
            }
            c cVar = c.RxL;
            byte[] bytes = c.his().getBytes(kotlin.n.d.UTF_8);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            s.C(hiv + "/version.txt", bytes);
            AppMethodBeat.o(90536);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "copyAssets", new Object[0]);
            AppMethodBeat.o(90536);
        }
    }

    private static boolean glx() {
        String str;
        AppMethodBeat.i(215244);
        String str2 = hiv + "/version.txt";
        if (s.YS(str2)) {
            str = s.boY(str2);
        } else {
            str = "";
        }
        String str3 = TAG;
        StringBuilder append = new StringBuilder("checkVersionMatch: ").append(str).append(", ");
        c cVar = c.RxL;
        Log.i(str3, append.append(c.his()).toString());
        c cVar2 = c.RxL;
        p.g(str, "localVersion");
        boolean bpD = c.bpD(str);
        AppMethodBeat.o(215244);
        return bpD;
    }

    private static boolean b(AssetManager assetManager, String str, String str2) {
        AppMethodBeat.i(261707);
        try {
            String[] list = assetManager.list(str);
            if (list == null) {
                AppMethodBeat.o(261707);
                return true;
            }
            p.g(list, "assets.list(assetsPath) ?: return true");
            if (list.length == 0) {
                String bhK = s.bhK("assets:///".concat(String.valueOf(str)));
                String bhK2 = s.bhK(str2);
                if (!p.j(bhK, bhK2)) {
                    Log.i(TAG, "checkFileMd5Match: " + str + " is " + bhK + "; " + str2 + " is " + bhK2);
                    a(assetManager, str, str2);
                    AppMethodBeat.o(261707);
                    return false;
                }
                AppMethodBeat.o(261707);
                return true;
            }
            s.boN(str2);
            for (String str3 : list) {
                b(assetManager, str + '/' + str3, str2 + '/' + str3);
            }
            AppMethodBeat.o(261707);
            return false;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "checkFileMd5Match", new Object[0]);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        public static final b VhZ = new b();

        static {
            AppMethodBeat.i(261705);
            AppMethodBeat.o(261705);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(261704);
            e eVar = e.JRF;
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            AssetManager assets = context.getAssets();
            p.g(assets, "MMApplicationContext.getContext().assets");
            e eVar2 = e.JRF;
            e.c(assets, "xlab", e.glt());
            x xVar = x.SXb;
            AppMethodBeat.o(261704);
            return xVar;
        }
    }
}
