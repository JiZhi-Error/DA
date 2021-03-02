package com.tencent.mm.sticker.loader;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.loader.g.a.f;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.f;
import com.tencent.mm.sticker.loader.StickerLoadInfo;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\tH\u0002J\u0006\u0010\"\u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u0004J&\u0010-\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001f\u0018\u00010.J\u0016\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001cJ\u0014\u00102\u001a\u00020\u001f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000e03J\u0014\u00104\u001a\u00020\u001f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000e03R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001aX\u0004¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/sticker/loader/StickerFileManager;", "", "()V", "TAG", "", "callback", "com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/sticker/loader/StickerFileManager$callback$1;", "maxPackageCount", "", "getMaxPackageCount", "()I", "processTaskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "Lkotlin/collections/HashMap;", "stickerDir", "getStickerDir", "()Ljava/lang/String;", "stickerPackage", "getStickerPackage", "stickerTemp", "getStickerTemp", "stickerThumb", "getStickerThumb", "taskQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "checkLocal", "", "lensId", "cleanDir", "", SharePatchInfo.OAT_DIR, "maxCount", "cleanFile", "getPackById", "loadByFileId", "Lcom/tencent/mm/loader/loader/WorkStatus;", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "loadByInfo", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "loadByUrl", "url", "loadFromRemote", "Lkotlin/Function1;", "notifyProcessTask", "taskKey", "success", "register", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "unregister", "plugin-sticker_release"})
public final class e {
    private static final String NNG;
    private static final String NNH = (NNG + "package/");
    private static final String NNI = (NNG + "temp/");
    private static final String NNJ = (NNG + "thumb/");
    private static final int NNK = 50;
    private static final HashMap<String, g> NNL = new HashMap<>();
    private static final a NNM = new a();
    public static final e NNN = new e();
    private static final String TAG = TAG;
    private static final d<g> gVJ = new d<>(new f(new com.tencent.mm.loader.g.a.a((byte) 0), new g(1, (byte) 0), 1, "StickerTask"));

    static {
        AppMethodBeat.i(105939);
        StringBuilder sb = new StringBuilder();
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        File cacheDir = context.getCacheDir();
        p.g(cacheDir, "MMApplicationContext.getContext().cacheDir");
        NNG = sb.append(cacheDir.getAbsolutePath()).append("/sticker/").toString();
        s.boN(NNG);
        s.bpc(NNG);
        gVJ.a(NNM);
        AppMethodBeat.o(105939);
    }

    private e() {
    }

    public static String gyW() {
        return NNG;
    }

    public static String gyX() {
        return NNH;
    }

    public static String gyY() {
        return NNI;
    }

    public static String gyZ() {
        return NNJ;
    }

    public static int gza() {
        return NNK;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/sticker/loader/StickerFileManager$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-sticker_release"})
    public static final class a implements com.tencent.mm.loader.g.f<g> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(g gVar, j jVar) {
            AppMethodBeat.i(105925);
            g gVar2 = gVar;
            p.h(gVar2, "task");
            p.h(jVar, "status");
            String Lb = gVar2.NNU.Lb();
            boolean z = jVar == j.OK;
            e eVar = e.NNN;
            Log.i(e.TAG, "onLoaderFin: " + Lb + ", " + z);
            e eVar2 = e.NNN;
            if (((g) e.NNL.remove(Lb)) != null) {
                h azG = com.tencent.mm.kernel.g.aAe().azG();
                p.g(azG, "MMKernel.process().current()");
                if (azG.aBb()) {
                    new Intent();
                }
            }
            AppMethodBeat.o(105925);
        }
    }

    public static void gzb() {
        AppMethodBeat.i(105929);
        com.tencent.mm.ac.d.b("StickerFileManager_cleanFile", c.NNO);
        AppMethodBeat.o(105929);
    }

    public static void a(com.tencent.mm.loader.g.f<g> fVar) {
        AppMethodBeat.i(105930);
        p.h(fVar, "callback");
        gVJ.a(fVar);
        AppMethodBeat.o(105930);
    }

    public static void b(com.tencent.mm.loader.g.f<g> fVar) {
        AppMethodBeat.i(105931);
        p.h(fVar, "callback");
        gVJ.b(fVar);
        AppMethodBeat.o(105931);
    }

    public static void biv(String str) {
        AppMethodBeat.i(105932);
        p.h(str, "url");
        StickerLoadInfo.a aVar = StickerLoadInfo.NNP;
        p.h(str, "url");
        StickerLoadInfo stickerLoadInfo = new StickerLoadInfo(1);
        p.h(str, "<set-?>");
        stickerLoadInfo.url = str;
        a(stickerLoadInfo);
        AppMethodBeat.o(105932);
    }

    public static j d(chz chz) {
        String str;
        String str2;
        int i2;
        AppMethodBeat.i(105933);
        p.h(chz, "lensInfo");
        Log.i(TAG, "loadByFileId: " + chz.Lso);
        if (Util.isNullOrNil(chz.Lso)) {
            j jVar = j.Fail;
            AppMethodBeat.o(105933);
            return jVar;
        }
        String str3 = chz.Lso;
        p.g(str3, "lensInfo.LensId");
        if (bix(str3)) {
            j jVar2 = j.OK;
            AppMethodBeat.o(105933);
            return jVar2;
        }
        StickerLoadInfo.a aVar = StickerLoadInfo.NNP;
        p.h(chz, "lensInfo");
        StickerLoadInfo stickerLoadInfo = new StickerLoadInfo();
        String str4 = chz.Lso;
        if (str4 == null) {
            str4 = "";
        }
        p.h(str4, "<set-?>");
        stickerLoadInfo.rnS = str4;
        cib cib = chz.Mns;
        if (cib == null || (str = cib.KMl) == null) {
            str = "";
        }
        p.h(str, "<set-?>");
        stickerLoadInfo.fileId = str;
        cib cib2 = chz.Mns;
        if (cib2 == null || (str2 = cib2.AesKey) == null) {
            str2 = "";
        }
        p.h(str2, "<set-?>");
        stickerLoadInfo.aesKey = str2;
        cib cib3 = chz.Mns;
        if (cib3 != null) {
            i2 = cib3.FileSize;
        } else {
            i2 = 0;
        }
        stickerLoadInfo.kKK = i2;
        a(stickerLoadInfo);
        j jVar3 = j.Running;
        AppMethodBeat.o(105933);
        return jVar3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class b<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(105926);
            int a2 = kotlin.b.a.a(Long.valueOf(t2.RbI), Long.valueOf(t.RbI));
            AppMethodBeat.o(105926);
            return a2;
        }
    }

    public static String biw(String str) {
        AppMethodBeat.i(105934);
        p.h(str, "lensId");
        String str2 = NNH + str + '/';
        AppMethodBeat.o(105934);
        return str2;
    }

    public static boolean bix(String str) {
        AppMethodBeat.i(105935);
        p.h(str, "lensId");
        String biw = biw(str);
        f.a aVar = com.tencent.mm.sticker.f.NNw;
        boolean biu = f.a.biu(biw);
        AppMethodBeat.o(105935);
        return biu;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.tencent.mm.loader.g.d<com.tencent.mm.sticker.loader.g> */
    /* JADX WARN: Multi-variable type inference failed */
    private static void a(StickerLoadInfo stickerLoadInfo) {
        f fVar;
        AppMethodBeat.i(105936);
        p.h(stickerLoadInfo, "info");
        if (NNL.containsKey(stickerLoadInfo.Lb())) {
            Log.i(TAG, "loadByInfo: " + stickerLoadInfo.Lb() + " waiting in queue");
            AppMethodBeat.o(105936);
            return;
        }
        h azG = com.tencent.mm.kernel.g.aAe().azG();
        p.g(azG, "MMKernel.process().current()");
        if (!azG.aBb()) {
            f fVar2 = new f(stickerLoadInfo);
            NNL.put(stickerLoadInfo.Lb(), fVar2);
            fVar = fVar2;
        } else if (stickerLoadInfo.type == 1) {
            fVar = new i(stickerLoadInfo);
        } else {
            fVar = new d(stickerLoadInfo);
        }
        gVJ.c((g) fVar);
        AppMethodBeat.o(105936);
    }

    public static /* synthetic */ void b(StickerLoadInfo stickerLoadInfo) {
        AppMethodBeat.i(194226);
        a(stickerLoadInfo, null);
        AppMethodBeat.o(194226);
    }

    public static void a(StickerLoadInfo stickerLoadInfo, kotlin.g.a.b<? super Boolean, x> bVar) {
        g dVar;
        AppMethodBeat.i(194225);
        p.h(stickerLoadInfo, "info");
        Log.i(TAG, "loadFromRemote: " + stickerLoadInfo.Lb());
        if (stickerLoadInfo.type == 1) {
            dVar = new i(stickerLoadInfo);
        } else {
            dVar = new d(stickerLoadInfo);
        }
        if (bVar != null && !dVar.NNT.contains(bVar)) {
            dVar.NNT.add(bVar);
        }
        NNL.put(stickerLoadInfo.Lb(), dVar);
        gVJ.c(dVar);
        AppMethodBeat.o(194225);
    }

    public static void dh(String str, boolean z) {
        AppMethodBeat.i(105938);
        p.h(str, "taskKey");
        Log.i(TAG, "notifyProcessTask: ".concat(String.valueOf(str)));
        g remove = NNL.remove(str);
        if (remove != null) {
            remove.dQ(z);
            AppMethodBeat.o(105938);
            return;
        }
        AppMethodBeat.o(105938);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        public static final c NNO = new c();

        static {
            AppMethodBeat.i(105928);
            AppMethodBeat.o(105928);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(105927);
            e eVar = e.NNN;
            s.deleteDir(e.gyY());
            e eVar2 = e.NNN;
            String gyX = e.gyX();
            e eVar3 = e.NNN;
            e.gN(gyX, e.gza());
            e eVar4 = e.NNN;
            e.gN(e.gyZ(), 150);
            x xVar = x.SXb;
            AppMethodBeat.o(105927);
            return xVar;
        }
    }

    public static final /* synthetic */ void gN(String str, int i2) {
        AppMethodBeat.i(105940);
        LinkedList linkedList = new LinkedList();
        Iterable<com.tencent.mm.vfs.e> dC = s.dC(str, false);
        if (dC != null) {
            kotlin.a.j.a((Collection) linkedList, (Iterable) dC);
            int size = linkedList.size();
            Log.i(TAG, "cleanFile: " + str + " count is " + size);
            if (size > i2) {
                LinkedList linkedList2 = linkedList;
                if (linkedList2.size() > 1) {
                    kotlin.a.j.a((List) linkedList2, (Comparator) new b());
                }
                List<com.tencent.mm.vfs.e> subList = linkedList.subList(i2, size);
                p.g(subList, "lists.subList(maxCount, count)");
                for (com.tencent.mm.vfs.e eVar : subList) {
                    if (eVar.RbJ) {
                        s.deleteDir(str + eVar.name);
                    } else {
                        s.deleteFile(str + eVar.name);
                    }
                }
            }
        }
        AppMethodBeat.o(105940);
    }
}
