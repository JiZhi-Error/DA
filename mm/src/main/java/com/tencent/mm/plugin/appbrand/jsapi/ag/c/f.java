package com.tencent.mm.plugin.appbrand.jsapi.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import java.util.zip.ZipInputStream;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tJ\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\tJ \u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/AppBrandUnzipLogic;", "", "()V", "APP_BRAND_CACHE_DIRECTORY_NAME", "", "APP_BRAND_UNZIP_CACHE_DIRECTORY_NAME", "PATH_PREFIX_NETWORK", "PATH_PREFIX_TEMP", "cacheDir", "Lcom/tencent/mm/vfs/VFSFile;", "getCacheDir", "()Lcom/tencent/mm/vfs/VFSFile;", "cacheDir$delegate", "Lkotlin/Lazy;", "generateUnzipPathName", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "zipPath", "getUnzipDir", "isUnzipDirValid", "", "unzipDir", "unzip", "zipInputStream", "Ljava/util/zip/ZipInputStream;", "unzipIfNeed", "luggage-xweb-ext_release"})
public final class f {
    private static final kotlin.f mJQ = g.ah(a.mJS);
    public static final f mJR = new f();

    static {
        AppMethodBeat.i(215996);
        AppMethodBeat.o(215996);
    }

    private f() {
    }

    public static boolean F(o oVar) {
        AppMethodBeat.i(215994);
        p.h(oVar, "unzipDir");
        d dVar = d.mJM;
        boolean D = d.D(oVar);
        AppMethodBeat.o(215994);
        return D;
    }

    public static o a(ZipInputStream zipInputStream, o oVar) {
        AppMethodBeat.i(215995);
        p.h(zipInputStream, "zipInputStream");
        p.h(oVar, "unzipDir");
        int a2 = n.a(zipInputStream, oVar.getAbsolutePath());
        Log.i("MicroMsg.AppBrand.AppBrandUnzipLogic", "unzip, unzipRet: ".concat(String.valueOf(a2)));
        if (a2 != 0) {
            AppMethodBeat.o(215995);
            return null;
        }
        d dVar = d.mJM;
        if (!d.C(oVar)) {
            Log.w("MicroMsg.AppBrand.AppBrandUnzipLogic", "unzip, record fail");
            AppMethodBeat.o(215995);
            return null;
        }
        AppMethodBeat.o(215995);
        return oVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/vfs/VFSFile;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<o> {
        public static final a mJS = new a();

        static {
            AppMethodBeat.i(215992);
            AppMethodBeat.o(215992);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ o invoke() {
            AppMethodBeat.i(215991);
            o oVar = new o(b.aKJ(), "wxacache");
            s.boN(oVar.getAbsolutePath());
            o oVar2 = new o(oVar, "unzip");
            s.boN(oVar2.getAbsolutePath());
            AppMethodBeat.o(215991);
            return oVar2;
        }
    }

    public static o k(com.tencent.mm.plugin.appbrand.jsapi.f fVar, String str) {
        AppMethodBeat.i(215993);
        p.h(fVar, "component");
        p.h(str, "zipPath");
        if (!kotlin.n.n.J(str, "wxfile://", true) && !kotlin.n.n.J(str, "http", true)) {
            str = fVar.getAppId() + '_' + str;
        }
        Log.d("MicroMsg.AppBrand.AppBrandUnzipLogic", "generateUnzipPath, rawUnzipPath: ".concat(String.valueOf(str)));
        Charset charset = d.UTF_8;
        if (str == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(215993);
            throw tVar;
        }
        byte[] bytes = str.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(bytes);
        String str2 = messageDigest;
        if (str2 == null || str2.length() == 0) {
            Log.w("MicroMsg.AppBrand.AppBrandUnzipLogic", "getUnzipDir, unzipPathName is empty");
            AppMethodBeat.o(215993);
            return null;
        }
        o oVar = new o((o) mJQ.getValue(), messageDigest);
        AppMethodBeat.o(215993);
        return oVar;
    }
}
