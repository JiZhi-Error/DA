package com.tencent.mm.plugin.emojicapture.model.b;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.loader.g.a.f;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.a;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000bJH\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\r0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager;", "", "()V", "mixCallback", "com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1;", "mixQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "mixTasks", "", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "kotlin.jvm.PlatformType", "", "stopServiceRunnable", "Lkotlin/Function0;", "", "waitingQueue", "Ljava/util/LinkedList;", "addTask", "info", "scene", "", "timeEnter", "", "videoPath", "", "retriever", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiFrameRetriever;", "videoPlayRate", "isRemoveBg", "", "stickerPack", "Lcom/tencent/mm/sticker/StickerPack;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emojicapture_release"})
public final class e {
    private static final LinkedList<d> rpO = new LinkedList<>();
    private static final d<h> rpP = new d<>(new f(new com.tencent.mm.loader.g.a.a(20), new g(1, (byte) 0), 1, "EmojiMix"));
    private static kotlin.g.a.a<x> rpQ = b.rpU;
    private static final List<d> rpR = Collections.synchronizedList(new LinkedList());
    private static final a rpS = new a();
    public static final e rpT = new e();

    static {
        AppMethodBeat.i(275);
        rpP.a(rpS);
        AppMethodBeat.o(275);
    }

    private e() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/emojicapture/model/mix/EmojiMixManager$mixCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
    public static final class a implements com.tencent.mm.loader.g.f<h> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(h hVar, j jVar) {
            d dVar;
            AppMethodBeat.i(a.C0691a.CTRL_INDEX);
            h hVar2 = hVar;
            p.h(hVar2, "task");
            p.h(jVar, "status");
            e eVar = e.rpT;
            List list = e.rpR;
            p.g(list, "mixTasks");
            List<d> list2 = list;
            synchronized (list2) {
                try {
                    dVar = null;
                    for (d dVar2 : list2) {
                        if (dVar2.hdz == hVar2.hdz) {
                            dVar = dVar2;
                        }
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(a.C0691a.CTRL_INDEX);
                    throw th;
                }
            }
            if (dVar != null) {
                e eVar2 = e.rpT;
                e.rpR.remove(dVar);
            }
            e eVar3 = e.rpT;
            if (e.rpR.isEmpty()) {
                e eVar4 = e.rpT;
                com.tencent.mm.ac.d.a(1000, e.rpQ);
            }
            String auD = f.auD();
            StringBuilder append = new StringBuilder("onLoaderFin: ").append(jVar).append(", ");
            e eVar5 = e.rpT;
            Log.i(auD, append.append(e.rpR.size()).toString());
            AppMethodBeat.o(a.C0691a.CTRL_INDEX);
        }
    }

    public static d a(int i2, long j2, String str, a aVar, int i3, boolean z, com.tencent.mm.sticker.f fVar, EmojiInfo emojiInfo) {
        Object obj;
        AppMethodBeat.i(a.C0693a.CTRL_INDEX);
        p.h(str, "videoPath");
        p.h(aVar, "retriever");
        p.h(emojiInfo, "emojiInfo");
        d.a aVar2 = com.tencent.mm.plugin.emojicapture.model.d.roA;
        String str2 = d.a.cIJ() + "temp_gif" + Util.nowMilliSecond();
        d.a aVar3 = com.tencent.mm.plugin.emojicapture.model.d.roA;
        d dVar = new d(i2, j2, str, str2, aVar, i3, z, fVar, !(com.tencent.mm.plugin.emojicapture.model.d.rot), emojiInfo);
        p.h(dVar, "info");
        rpR.add(dVar);
        rpP.c(new h(dVar));
        rpO.add(dVar);
        kotlin.g.a.a<x> aVar4 = rpQ;
        if (aVar4 != null) {
            obj = new g(aVar4);
        } else {
            obj = aVar4;
        }
        MMHandlerThread.removeRunnable((Runnable) obj);
        c.m(new Intent(MMApplicationContext.getContext(), EmojiCaptureService.class), "tools");
        AppMethodBeat.o(a.C0693a.CTRL_INDEX);
        return dVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        public static final b rpU = new b();

        static {
            AppMethodBeat.i(273);
            AppMethodBeat.o(273);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(272);
            c.o(new Intent(MMApplicationContext.getContext(), EmojiCaptureService.class), "tools");
            x xVar = x.SXb;
            AppMethodBeat.o(272);
            return xVar;
        }
    }
}
