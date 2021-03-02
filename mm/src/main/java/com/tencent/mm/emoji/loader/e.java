package com.tencent.mm.emoji.loader;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.d.j;
import com.tencent.mm.emoji.loader.e.a;
import com.tencent.mm.emoji.loader.e.b;
import com.tencent.mm.emoji.loader.e.c;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.loader.g.a.f;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.pluginsdk.ui.emoji.ChattingEmojiView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u00016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fJ \u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\b\u0010\u000b\u001a\u0004\u0018\u00010$J\u001e\u0010 \u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020&2\u0006\u0010'\u001a\u00020\nJ\u0016\u0010(\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020*J\u001e\u0010(\u001a\u00020+2\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,J\u0018\u0010.\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u000b\u001a\u0004\u0018\u00010$J \u0010.\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010$J\u000e\u00100\u001a\u0002012\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0010`\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, hxF = {"Lcom/tencent/mm/emoji/loader/EmojiLoader;", "", "()V", "MockDownloadFail", "", "getMockDownloadFail", "()Z", "setMockDownloadFail", "(Z)V", "TAG", "", "callback", "com/tencent/mm/emoji/loader/EmojiLoader$callback$1", "Lcom/tencent/mm/emoji/loader/EmojiLoader$callback$1;", "taskMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lkotlin/collections/HashMap;", "taskQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "addTask", "", "key", "task", "async", "buildCoverTask", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "buildTask", "cancel", "view", "Landroid/view/View;", "load", "Lcom/tencent/mm/emoji/loader/request/EmojiViewRequest;", "emojiView", "Lcom/tencent/mm/emoji/view/BaseEmojiView;", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "Lcom/tencent/mm/emoji/loader/request/ChatEmojiViewRequest;", "Lcom/tencent/mm/pluginsdk/ui/emoji/ChattingEmojiView;", "cacheKey", "loadCover", "Lcom/tencent/mm/emoji/loader/request/EmojiCoverRequest;", "Landroid/widget/ImageView;", "Lcom/tencent/mm/emoji/loader/request/EmojiCoverBitmapRequest;", "Lcom/tencent/mm/emoji/loader/request/Request$StateCallback;", "Landroid/graphics/Bitmap;", "loadFile", "Lcom/tencent/mm/emoji/loader/request/EmojiFileRequest;", "loadForRemote", "Lcom/tencent/mm/emoji/loader/request/ProcessRequest;", "notifyTaskResult", "md5", "success", "removeTask", "EmojiLoaderRetryStrategy", "plugin-emojisdk_release"})
public final class e {
    private static final String TAG = TAG;
    private static final HashMap<String, c> gVI = new HashMap<>();
    private static final d<c> gVJ = new d<>(new f(new a(), new g(2, (byte) 0), 2, "EmojiLoader"));
    private static final b gVK = new b();
    private static boolean gVL;
    public static final e gVM = new e();

    static {
        AppMethodBeat.i(105402);
        gVJ.a(gVK);
        AppMethodBeat.o(105402);
    }

    private e() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/emoji/loader/EmojiLoader$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
    public static final class b implements com.tencent.mm.loader.g.f<c> {
        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(c cVar, j jVar) {
            AppMethodBeat.i(105388);
            c cVar2 = cVar;
            p.h(cVar2, "task");
            p.h(jVar, "status");
            e eVar = e.gVM;
            e.gVI.remove(cVar2.auJ());
            AppMethodBeat.o(105388);
        }
    }

    public static boolean auB() {
        return gVL;
    }

    public static void dO(boolean z) {
        gVL = z;
    }

    public static c c(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105389);
        p.h(emojiInfo, "emojiInfo");
        com.tencent.mm.emoji.loader.e.e eVar = gVI.get(emojiInfo.getMd5());
        if (eVar == null) {
            h azG = com.tencent.mm.kernel.g.aAe().azG();
            p.g(azG, "MMKernel.process().current()");
            if (azG.aBb()) {
                eVar = new b(emojiInfo);
            } else {
                eVar = new com.tencent.mm.emoji.loader.e.e(emojiInfo);
            }
        }
        AppMethodBeat.o(105389);
        return eVar;
    }

    public static c d(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105390);
        p.h(emojiInfo, "emojiInfo");
        a aVar = gVI.get(emojiInfo.getMd5() + "_cover");
        if (aVar == null) {
            aVar = new a(emojiInfo);
        }
        AppMethodBeat.o(105390);
        return aVar;
    }

    public static com.tencent.mm.emoji.loader.d.f a(EmojiInfo emojiInfo, BaseEmojiView baseEmojiView, i.a aVar) {
        AppMethodBeat.i(105391);
        p.h(emojiInfo, "emojiInfo");
        p.h(baseEmojiView, "emojiView");
        Log.d(TAG, "load emoji " + emojiInfo.getMd5());
        com.tencent.mm.emoji.loader.d.f fVar = new com.tencent.mm.emoji.loader.d.f(emojiInfo, baseEmojiView, aVar);
        fVar.start(true);
        AppMethodBeat.o(105391);
        return fVar;
    }

    public static com.tencent.mm.emoji.loader.d.a a(EmojiInfo emojiInfo, ChattingEmojiView chattingEmojiView, String str) {
        AppMethodBeat.i(105392);
        p.h(emojiInfo, "emojiInfo");
        p.h(chattingEmojiView, "emojiView");
        p.h(str, "cacheKey");
        Log.d(TAG, "load emoji " + emojiInfo.getMd5());
        com.tencent.mm.emoji.loader.d.a aVar = new com.tencent.mm.emoji.loader.d.a(emojiInfo, chattingEmojiView, str);
        aVar.start(true);
        AppMethodBeat.o(105392);
        return aVar;
    }

    public static com.tencent.mm.emoji.loader.d.e a(EmojiInfo emojiInfo, i.a aVar) {
        AppMethodBeat.i(105393);
        p.h(emojiInfo, "emojiInfo");
        com.tencent.mm.emoji.loader.d.e a2 = a(emojiInfo, true, aVar);
        AppMethodBeat.o(105393);
        return a2;
    }

    public static com.tencent.mm.emoji.loader.d.e a(EmojiInfo emojiInfo, boolean z, i.a aVar) {
        AppMethodBeat.i(105394);
        p.h(emojiInfo, "emojiInfo");
        Log.i(TAG, "load emoji file " + emojiInfo.getMd5());
        com.tencent.mm.emoji.loader.d.e eVar = new com.tencent.mm.emoji.loader.d.e(emojiInfo, aVar);
        eVar.start(z);
        AppMethodBeat.o(105394);
        return eVar;
    }

    public static com.tencent.mm.emoji.loader.d.c a(EmojiInfo emojiInfo, ImageView imageView) {
        AppMethodBeat.i(105395);
        p.h(emojiInfo, "emojiInfo");
        p.h(imageView, "view");
        com.tencent.mm.emoji.loader.d.c cVar = new com.tencent.mm.emoji.loader.d.c(emojiInfo, imageView);
        cVar.start(true);
        AppMethodBeat.o(105395);
        return cVar;
    }

    public static com.tencent.mm.emoji.loader.d.b a(EmojiInfo emojiInfo, i.c<Bitmap> cVar) {
        AppMethodBeat.i(105396);
        p.h(emojiInfo, "emojiInfo");
        com.tencent.mm.emoji.loader.d.b bVar = new com.tencent.mm.emoji.loader.d.b(emojiInfo, cVar);
        bVar.start(true);
        AppMethodBeat.o(105396);
        return bVar;
    }

    public static com.tencent.mm.emoji.loader.d.h e(EmojiInfo emojiInfo) {
        AppMethodBeat.i(105397);
        p.h(emojiInfo, "emojiInfo");
        com.tencent.mm.emoji.loader.d.h hVar = new com.tencent.mm.emoji.loader.d.h(emojiInfo);
        hVar.start(true);
        AppMethodBeat.o(105397);
        return hVar;
    }

    public static void s(String str, boolean z) {
        AppMethodBeat.i(105398);
        p.h(str, "md5");
        c cVar = gVI.get(str);
        if (cVar != null) {
            cVar.dQ(z);
            AppMethodBeat.o(105398);
            return;
        }
        AppMethodBeat.o(105398);
    }

    public static void cl(View view) {
        AppMethodBeat.i(105399);
        p.h(view, "view");
        Log.i(TAG, "cancel: ".concat(String.valueOf(view)));
        j.a aVar = com.tencent.mm.emoji.loader.d.j.gWJ;
        i iVar = (i) view.getTag(com.tencent.mm.emoji.loader.d.j.auI());
        if (iVar != null) {
            iVar.cancel();
            AppMethodBeat.o(105399);
            return;
        }
        AppMethodBeat.o(105399);
    }

    public static void a(String str, c cVar, boolean z) {
        AppMethodBeat.i(105400);
        p.h(str, "key");
        p.h(cVar, "task");
        Log.i(TAG, "addTask: " + str + ' ' + z);
        gVI.put(str, cVar);
        if (z) {
            gVJ.c(cVar);
            AppMethodBeat.o(105400);
            return;
        }
        cVar.run();
        AppMethodBeat.o(105400);
    }

    public static void EN(String str) {
        AppMethodBeat.i(105401);
        p.h(str, "key");
        Log.i(TAG, "removeTask: ".concat(String.valueOf(str)));
        c remove = gVI.remove(str);
        if (remove != null) {
            d<c> dVar = gVJ;
            p.g(remove, LocaleUtil.ITALIAN);
            dVar.d(remove);
            AppMethodBeat.o(105401);
            return;
        }
        AppMethodBeat.o(105401);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/emoji/loader/EmojiLoader$EmojiLoaderRetryStrategy;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "plugin-emojisdk_release"})
    public static final class a implements com.tencent.mm.loader.g.a.c {
        @Override // com.tencent.mm.loader.g.a.c
        public final boolean a(com.tencent.mm.loader.g.c cVar) {
            AppMethodBeat.i(105387);
            p.h(cVar, "task");
            AppMethodBeat.o(105387);
            return true;
        }
    }
}
