package com.tencent.mm.plugin.finder.preload.worker;

import android.os.SystemClock;
import android.widget.Toast;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.preload.c;
import com.tencent.mm.plugin.finder.preload.model.a;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.plugin.i.a.k;
import com.tencent.mm.plugin.thumbplayer.PluginThumbPlayer;
import com.tencent.mm.plugin.thumbplayer.b.a;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.o;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 M2\u00020\u0001:\u0003MNOB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J6\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u001e\u0010\u001e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001f0 0\u001fH\u0002J\u001a\u0010#\u001a\u0004\u0018\u00010\u00102\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\nH\u0002J\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0010H\u0002J\b\u0010-\u001a\u00020+H\u0002J\u0010\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\"H\u0002J\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100\u001aH\u0002J\u0018\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0010H\u0002J\b\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u0002062\u0006\u0010$\u001a\u00020\u00052\u0006\u00108\u001a\u00020\nH\u0016J\b\u00109\u001a\u000206H\u0016J\b\u0010:\u001a\u000206H\u0016J\b\u0010;\u001a\u000206H\u0016J\b\u0010<\u001a\u000206H\u0002J8\u0010=\u001a\u0002062\u0006\u0010\u001c\u001a\u00020\u001d2\u001e\u0010\u001e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001f0 0\u001f2\u0006\u0010>\u001a\u00020+H\u0016J2\u0010?\u001a\u0002062\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00100@2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00100@H\u0002J\b\u0010C\u001a\u000206H\u0002J\u0018\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020+H\u0002J+\u0010G\u001a\u0002HH\"\u0004\b\u0000\u0010H2\b\b\u0002\u0010I\u001a\u00020\u00052\f\u0010J\u001a\b\u0012\u0004\u0012\u0002HH0KH\u0002¢\u0006\u0002\u0010LR\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010`\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/worker/IPreloadWorker;", "model", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "sceneTag", "", "(Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;Ljava/lang/String;)V", "TAG", "focusedMediaId", "isOpenMultiBitRate", "", "isRelease", "isStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadingMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "mainLock", "Ljava/util/concurrent/locks/ReentrantLock;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "getPreLoadCallbacks", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "waitingList", "Ljava/util/LinkedList;", "buildPreloadList", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "dataList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "cancel", "mediaId", "isIgnorePlaying", "cancelWaitingTask", "createPreloadCDNTask", "detail", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "enqueue", "", "task", "getPreLoadingCount", "isFocusedMedia", "media", "mergePreload", "preloadList", "needToMerge", "new", "old", "onClearAll", "", "onMediaFocus", "isFocused", "onPreloadStart", "onPreloadStop", "onRelease", "pollWaiting", "preload", "source", "printMergeList", "", "rawList", "removeWaitingList", "resetRunningTask", "showErrToast", "stage", "ret", "syncLock", "T", "tag", "handle", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-finder_release"})
public final class b {
    public static final a uVO = new a((byte) 0);
    public final String TAG;
    public AtomicBoolean dxj;
    private final LinkedList<com.tencent.mm.plugin.finder.preload.c> hhn;
    public boolean ife;
    private final ReentrantLock uVH;
    private final HashMap<String, com.tencent.mm.plugin.finder.preload.c> uVI;
    private String uVJ;
    private final boolean uVK;
    public final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> uVL;
    private final com.tencent.mm.plugin.finder.preload.model.a uVM;
    private String uVN;

    static {
        AppMethodBeat.i(249653);
        AppMethodBeat.o(249653);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.preload.c, Boolean> {
        final /* synthetic */ com.tencent.mm.plugin.finder.preload.c uVX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(com.tencent.mm.plugin.finder.preload.c cVar) {
            super(1);
            this.uVX = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.preload.c cVar) {
            AppMethodBeat.i(249631);
            com.tencent.mm.plugin.finder.preload.c cVar2 = cVar;
            p.h(cVar2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(p.j(cVar2.uUe, this.uVX.uUe));
            AppMethodBeat.o(249631);
            return valueOf;
        }
    }

    public /* synthetic */ b(com.tencent.mm.plugin.finder.preload.model.a aVar) {
        this(aVar, "");
        AppMethodBeat.i(249652);
        AppMethodBeat.o(249652);
    }

    public b(com.tencent.mm.plugin.finder.preload.model.a aVar, String str) {
        p.h(aVar, "model");
        p.h(str, "sceneTag");
        AppMethodBeat.i(249651);
        this.uVM = aVar;
        this.uVN = str;
        this.uVH = new ReentrantLock();
        this.uVI = new HashMap<>();
        this.hhn = new LinkedList<>();
        this.uVJ = "";
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.uVK = com.tencent.mm.plugin.finder.storage.c.dsh();
        this.uVL = new ConcurrentLinkedQueue<>();
        this.TAG = "Finder.VideoPreloadWorker_" + this.uVN;
        this.uVL.add(new com.tencent.mm.plugin.finder.preload.b(this) {
            /* class com.tencent.mm.plugin.finder.preload.worker.b.AnonymousClass1 */
            final /* synthetic */ b uVP;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.uVP = r1;
            }

            @Override // com.tencent.mm.plugin.finder.preload.b
            public final void a(String str, int i2, String str2, String str3, com.tencent.mm.plugin.finder.preload.c cVar) {
                AppMethodBeat.i(249614);
                p.h(str, "mediaId");
                p.h(str2, "fileFormat");
                p.h(str3, "codingFormat");
                p.h(cVar, "task");
                AppMethodBeat.o(249614);
            }

            @Override // com.tencent.mm.plugin.finder.preload.b
            public final void dx(String str, int i2) {
                AppMethodBeat.i(249615);
                p.h(str, "mediaId");
                AppMethodBeat.o(249615);
            }

            @Override // com.tencent.mm.plugin.finder.preload.b
            public final void a(String str, boolean z, int i2, com.tencent.mm.plugin.finder.preload.c cVar) {
                AppMethodBeat.i(249616);
                p.h(str, "mediaId");
                p.h(cVar, "task");
                com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                at avH = com.tencent.mm.plugin.finder.storage.logic.d.avH(str);
                if (this.uVP.uVM.uUl) {
                    MediaPreloadCore.a aVar = MediaPreloadCore.uTV;
                    if (!MediaPreloadCore.a.a(avH).uTW && !z) {
                        Log.w(this.uVP.TAG, "Moov failure! try to download all! ".concat(String.valueOf(avH)));
                        b.a(this.uVP, str, false);
                        cVar.gqZ = 100;
                        cVar.field_preloadRatio = 100;
                        b.a(this.uVP, cVar);
                        AppMethodBeat.o(249616);
                        return;
                    }
                }
                if (!avH.field_moovReady && z) {
                    com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                    com.tencent.mm.plugin.finder.storage.logic.d.gU(str, cVar.dlG());
                }
                b.g(this.uVP);
                AppMethodBeat.o(249616);
            }

            @Override // com.tencent.mm.plugin.finder.preload.b
            public final void a(String str, String str2, com.tencent.mm.plugin.finder.preload.c cVar) {
                AppMethodBeat.i(249617);
                p.h(str, "mediaId");
                p.h(str2, "msg");
                p.h(cVar, "task");
                b.g(this.uVP);
                AppMethodBeat.o(249617);
            }

            @Override // com.tencent.mm.plugin.finder.preload.b
            public final void aum(String str) {
                AppMethodBeat.i(249618);
                p.h(str, "mediaId");
                Log.e(this.uVP.TAG, "[onFormatChange] mediaId=".concat(String.valueOf(str)));
                b.a(this.uVP, str, false);
                com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                s.deleteFile(com.tencent.mm.plugin.finder.storage.logic.d.avH(str).getFilePath());
                com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                com.tencent.mm.plugin.finder.storage.logic.d.dH(str, -2);
                AppMethodBeat.o(249618);
            }
        });
        this.dxj = new AtomicBoolean(false);
        AppMethodBeat.o(249651);
    }

    public static final /* synthetic */ int a(b bVar, com.tencent.mm.plugin.finder.preload.c cVar) {
        AppMethodBeat.i(249657);
        int a2 = bVar.a(cVar);
        AppMethodBeat.o(249657);
        return a2;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.finder.preload.c a(b bVar, String str, boolean z) {
        AppMethodBeat.i(249655);
        com.tencent.mm.plugin.finder.preload.c bo = bVar.bo(str, z);
        AppMethodBeat.o(249655);
        return bo;
    }

    public static final /* synthetic */ Object a(b bVar, String str, kotlin.g.a.a aVar) {
        AppMethodBeat.i(249654);
        Object l2 = bVar.l(str, aVar);
        AppMethodBeat.o(249654);
        return l2;
    }

    public static final /* synthetic */ LinkedList b(b bVar, String str) {
        AppMethodBeat.i(249659);
        LinkedList<com.tencent.mm.plugin.finder.preload.c> auv = bVar.auv(str);
        AppMethodBeat.o(249659);
        return auv;
    }

    public static final /* synthetic */ void g(b bVar) {
        AppMethodBeat.i(249661);
        bVar.dlM();
        AppMethodBeat.o(249661);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$Companion;", "", "()V", "ENQUEUE_FAILURE", "", "ENQUEUE_REJECT", "ENQUEUE_SUCCESSFULLY", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(FeedData feedData, List<o<bo, List<cjl>>> list, int i2) {
        AppMethodBeat.i(249639);
        p.h(feedData, "centerFeed");
        p.h(list, "dataList");
        Log.i(this.TAG, "[preload] prevCount=" + this.uVM.uUm + " nextCount=" + this.uVM.uUn + " maxPreloadTaskCount=" + this.uVM.uUq + ' ' + "list=" + list.size() + " center=" + feedData.getId() + " source=" + i2 + ' ' + "isLongVideo=" + feedData.isLongVideo() + " megaVideoPrevCnt=" + this.uVM.uUy + " megaVideoNextCnt=" + this.uVM.uUz);
        Iterator<T> it = as(b(feedData, list)).iterator();
        while (it.hasNext()) {
            a((com.tencent.mm.plugin.finder.preload.c) it.next());
        }
        AppMethodBeat.o(249639);
    }

    public final void bn(String str, boolean z) {
        AppMethodBeat.i(249640);
        p.h(str, "mediaId");
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder("[onMediaFocus] mediaId=");
        c.a aVar = com.tencent.mm.plugin.finder.preload.c.uUg;
        Log.i(str2, sb.append(c.a.aur(str)).append(" isFocused=").append(z).toString());
        if (z) {
            l("onMediaFocus", new j(this, str));
            bo(str, true);
            dlM();
            AppMethodBeat.o(249640);
            return;
        }
        this.uVJ = "";
        AppMethodBeat.o(249640);
    }

    public final void dlM() {
        AppMethodBeat.i(249641);
        l("pollWaiting", new k(this));
        AppMethodBeat.o(249641);
    }

    private final com.tencent.mm.plugin.finder.preload.c bo(String str, boolean z) {
        AppMethodBeat.i(249642);
        com.tencent.mm.plugin.finder.preload.c cVar = (com.tencent.mm.plugin.finder.preload.c) l("cancel", new d(this, str, z));
        AppMethodBeat.o(249642);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.c> {
        final /* synthetic */ String qWs;
        final /* synthetic */ b uVP;
        final /* synthetic */ boolean uVT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar, String str, boolean z) {
            super(0);
            this.uVP = bVar;
            this.qWs = str;
            this.uVT = z;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$cancel$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "onStop", "", "ret", "", "plugin-finder_release"})
        public static final class a implements com.tencent.mm.plugin.thumbplayer.b.f {
            final /* synthetic */ d uVU;

            a(d dVar) {
                this.uVU = dVar;
            }

            @Override // com.tencent.mm.plugin.thumbplayer.b.f
            public final void JR(int i2) {
                AppMethodBeat.i(249627);
                Log.i(this.uVU.uVP.TAG, "preload task on Stop " + this.uVU.qWs + ' ' + i2);
                b.dy("stopPreload", i2);
                AppMethodBeat.o(249627);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0096, code lost:
            if (r0 == null) goto L_0x0098;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ com.tencent.mm.plugin.finder.preload.c invoke() {
            /*
            // Method dump skipped, instructions count: 254
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.preload.worker.b.d.invoke():java.lang.Object");
        }
    }

    private final LinkedList<com.tencent.mm.plugin.finder.preload.c> auv(String str) {
        AppMethodBeat.i(249643);
        LinkedList<com.tencent.mm.plugin.finder.preload.c> linkedList = (LinkedList) l("cancelWaitingTask", new e(this, str));
        AppMethodBeat.o(249643);
        return linkedList;
    }

    private final boolean c(cjl cjl) {
        AppMethodBeat.i(249644);
        String str = this.uVJ;
        String str2 = cjl.mediaId;
        if (str2 == null) {
            str2 = "";
        }
        boolean nm = n.nm(str, str2);
        AppMethodBeat.o(249644);
        return nm;
    }

    private final LinkedList<com.tencent.mm.plugin.finder.preload.c> b(FeedData feedData, List<o<bo, List<cjl>>> list) {
        int i2;
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(249645);
        LinkedList<com.tencent.mm.plugin.finder.preload.c> linkedList = new LinkedList<>();
        int i6 = 0;
        Iterator<o<bo, List<cjl>>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (it.next().first.lT() == feedData.getId()) {
                i2 = i6;
                break;
            }
            i6++;
        }
        if (i2 >= 0) {
            if (feedData.isLongVideo()) {
                i3 = this.uVM.uUy;
            } else {
                i3 = this.uVM.uUm;
            }
            if (feedData.isLongVideo()) {
                i4 = this.uVM.uUz;
            } else {
                i4 = this.uVM.uUn;
            }
            int max = Math.max(i2 - i3, 0);
            int min = Math.min(i2 + i4 + 1, list.size());
            int i7 = 0;
            for (T t : list.subList(max, min)) {
                int i8 = i7 + 1;
                if (i7 < 0) {
                    kotlin.a.j.hxH();
                }
                T t2 = t;
                for (cjl cjl : t2.second) {
                    if (cjl.mediaType == 4 && !c(cjl)) {
                        if (i7 < i2 - max) {
                            i5 = (max - i2) + i7;
                        } else {
                            i5 = (min - max) - i7;
                        }
                        com.tencent.mm.plugin.finder.preload.model.a aVar = this.uVM;
                        t2.first.lT();
                        int i9 = 0;
                        for (T t3 : aVar.a(cjl)) {
                            int i10 = i9 + 1;
                            if (i9 < 0) {
                                kotlin.a.j.hxH();
                            }
                            T t4 = t3;
                            if (i9 == 0) {
                                com.tencent.mm.plugin.finder.preload.c a2 = a((a.b) t4);
                                a2.weight = i5 + 1000;
                                linkedList.add(a2);
                                i9 = i10;
                            } else {
                                com.tencent.mm.plugin.finder.preload.c a3 = a((a.b) t4);
                                a3.weight = i5;
                                linkedList.add(a3);
                                i9 = i10;
                            }
                        }
                    }
                }
                i7 = i8;
            }
        }
        kotlin.a.j.sort(linkedList);
        AppMethodBeat.o(249645);
        return linkedList;
    }

    private final int a(com.tencent.mm.plugin.finder.preload.c cVar) {
        AppMethodBeat.i(249646);
        this.uVH.lock();
        try {
            if (this.ife) {
                Log.i(this.TAG, "[enqueue] VideoPreloadWorker has release. " + cVar + " just return.");
                this.uVH.unlock();
                AppMethodBeat.o(249646);
                return -1;
            } else if (c(cVar.tHN.uIw)) {
                Log.i(this.TAG, "[enqueue] is focused task " + cVar + " just return.");
                this.uVH.unlock();
                AppMethodBeat.o(249646);
                return -1;
            } else {
                com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                at avH = com.tencent.mm.plugin.finder.storage.logic.d.avH(cVar.uUe);
                for (T t : this.uVL) {
                    String str = avH.field_mediaId;
                    p.g(str, "cache.field_mediaId");
                    t.a(str, avH.dkP(), cVar.dlG(), cVar.field_requestVideoFormat == 1 ? "H264" : "H265", cVar);
                }
                if (avH.dkN()) {
                    Log.i(this.TAG, "[enqueue] " + cVar + " has complete file(" + avH.dkP() + "%)! just return.");
                    Iterator<T> it = this.uVL.iterator();
                    while (it.hasNext()) {
                        it.next().a(cVar.uUe, avH.dkP() >= 100, avH.dkP(), cVar);
                    }
                    this.uVH.unlock();
                    AppMethodBeat.o(249646);
                    return 1;
                } else if (avH.dkP() < cVar.gqZ || avH.field_cacheSize < cVar.preloadMinSize) {
                    int size = this.uVI.size();
                    if (this.uVM.uUq <= size || this.dxj.get()) {
                        kotlin.a.j.c((List) this.hhn, (kotlin.g.a.b) new f(cVar));
                        this.hhn.add(cVar);
                        cVar.a(c.b.WAITING);
                        Log.i(this.TAG, "[enqueue] " + cVar + " wait to preLoad, just return. isStop=" + this.dxj + " preLoadingCount=" + size + " waitingSize=" + this.hhn.size());
                        this.uVH.unlock();
                        AppMethodBeat.o(249646);
                        return 1;
                    }
                    cVar.a(c.b.LOADING);
                    com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                    com.tencent.mm.plugin.finder.storage.logic.d.a(cVar.uUe, cVar.uUf, cVar.tHN.getUrl(), cVar.field_requestVideoFormat, cVar.dlG(), avH.field_cacheSize, avH.field_totalSize, 1, cVar.tHN.uIw.videoDuration, cVar.tHN.uIw.url_token, cVar.tHN.uIw.decodeKey);
                    this.uVI.put(cVar.uUe, cVar);
                    com.tencent.mm.plugin.finder.loader.k kVar = new com.tencent.mm.plugin.finder.loader.k(cVar.tHN.uIw, x.THUMB_IMAGE, null, null, 12);
                    com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                    com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> djY = com.tencent.mm.plugin.finder.loader.m.djY();
                    com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                    djY.a(kVar, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE)).aJw();
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.thumbplayer.a.a.class);
                    p.g(ah, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
                    if (((com.tencent.mm.plugin.thumbplayer.a.a) ah).isOpenTPPlayer()) {
                        com.tencent.mm.plugin.thumbplayer.b.a cdnTaskController = ((PluginThumbPlayer) com.tencent.mm.kernel.g.ah(PluginThumbPlayer.class)).getCdnTaskController();
                        com.tencent.mm.plugin.finder.preload.c cVar2 = cVar;
                        g gVar = new g(this, cVar);
                        p.h(cVar2, "task");
                        if (Util.isNullOrNil(((com.tencent.mm.i.h) cVar2).field_mediaId)) {
                            Log.e(cdnTaskController.TAG, "add download task, but task mediaId is null.");
                        } else {
                            Log.i(cdnTaskController.TAG, "startPreloadDownloadTask: " + ((com.tencent.mm.i.h) cVar2).field_mediaId + " current run tasks " + cdnTaskController.Ggv.size());
                            if (((com.tencent.mm.i.h) cVar2).field_fileId == null) {
                                ((com.tencent.mm.i.h) cVar2).field_fileId = "";
                            }
                            if (((com.tencent.mm.i.h) cVar2).field_aesKey == null) {
                                ((com.tencent.mm.i.h) cVar2).field_aesKey = "";
                            }
                            ((com.tencent.mm.i.h) cVar2).ehd = false;
                            com.tencent.mm.ac.d.c("MicroMsg.Cdn.ThreadName", new a.d(cdnTaskController, cVar2, gVar));
                        }
                    } else {
                        com.tencent.mm.an.f.baQ().d(cVar);
                    }
                    Log.i(this.TAG, "[enqueue] begin to preloadVideo... ".concat(String.valueOf(cVar)));
                    this.uVH.unlock();
                    AppMethodBeat.o(249646);
                    return 1;
                } else {
                    Log.i(this.TAG, "[enqueue] " + cVar + " has finish preload(" + avH.dkP() + "%)! just return.");
                    Iterator<T> it2 = this.uVL.iterator();
                    while (it2.hasNext()) {
                        it2.next().a(cVar.uUe, avH.dkP() >= 100, avH.dkP(), cVar);
                    }
                    this.uVH.unlock();
                    AppMethodBeat.o(249646);
                    return 1;
                }
            }
        } catch (Throwable th) {
            this.uVH.unlock();
            AppMethodBeat.o(249646);
            throw th;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$enqueue$5", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StartPreloadDownloadCallback;", "onStart", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "plugin-finder_release"})
    public static final class g implements com.tencent.mm.plugin.thumbplayer.b.d {
        final /* synthetic */ b uVP;
        final /* synthetic */ com.tencent.mm.plugin.finder.preload.c uVX;

        g(b bVar, com.tencent.mm.plugin.finder.preload.c cVar) {
            this.uVP = bVar;
            this.uVX = cVar;
        }

        @Override // com.tencent.mm.plugin.thumbplayer.b.d
        public final void JS(int i2) {
            AppMethodBeat.i(249632);
            Log.i(this.uVP.TAG, "preload task on Start " + this.uVX.field_mediaId + ' ' + i2);
            b.dy("startPreload", i2);
            AppMethodBeat.o(249632);
        }
    }

    private final LinkedList<com.tencent.mm.plugin.finder.preload.c> as(LinkedList<com.tencent.mm.plugin.finder.preload.c> linkedList) {
        AppMethodBeat.i(249648);
        List<com.tencent.mm.plugin.finder.preload.c> v = kotlin.a.j.v((Collection) linkedList);
        LinkedList linkedList2 = new LinkedList();
        LinkedList<com.tencent.mm.plugin.finder.preload.c> auv = auv(null);
        l("mergePreload", new h(this, linkedList, linkedList2, v, auv));
        d(linkedList, v, auv);
        AppMethodBeat.o(249648);
        return linkedList;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J4\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001c\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "expect", "", "preloadMinSize", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "getExpect", "()I", "getPreloadMinSize", "()J", "callback", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
    public final class c implements g.a {
        private final long preloadMinSize;
        private final com.tencent.mm.plugin.finder.loader.s tHN;
        final HashMap<String, com.tencent.mm.plugin.finder.preload.c> uVI;
        private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> uVL;
        final /* synthetic */ b uVP;
        private final int uVQ;

        public c(b bVar, int i2, long j2, HashMap<String, com.tencent.mm.plugin.finder.preload.c> hashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> concurrentLinkedQueue, com.tencent.mm.plugin.finder.loader.s sVar) {
            p.h(hashMap, "loadingMap");
            p.h(concurrentLinkedQueue, "preLoadCallbacks");
            p.h(sVar, "video");
            this.uVP = bVar;
            AppMethodBeat.i(249626);
            this.uVQ = i2;
            this.preloadMinSize = j2;
            this.uVI = hashMap;
            this.uVL = concurrentLinkedQueue;
            this.tHN = sVar;
            AppMethodBeat.o(249626);
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(249624);
            p.h(str, "mediaId");
            AppMethodBeat.o(249624);
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return new byte[0];
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
            int i3;
            String str2;
            AppMethodBeat.i(249625);
            p.h(str, "mediaId");
            if (dVar == null || dVar.field_retCode != -21112) {
                if (cVar != null && cVar.field_toltalLength > 0) {
                    long j2 = cVar.field_finishedLength;
                    long j3 = cVar.field_toltalLength;
                    if (((int) ((((float) j2) / ((float) j3)) * 100.0f)) >= this.uVQ && j2 < j3 && this.preloadMinSize <= j2) {
                        i3 = 2;
                    } else if (j2 >= j3) {
                        i3 = 3;
                    } else {
                        i3 = 1;
                    }
                    com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                    at a2 = com.tencent.mm.plugin.finder.storage.logic.d.a(str, j2, j3, i3);
                    if (dVar == null || (str2 = dVar.field_videoFlag) == null) {
                        str2 = this.tHN.uIx.detail;
                    }
                    a2.field_fileFormat = str2;
                    com.tencent.mm.plugin.finder.storage.logic.d dVar3 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                    com.tencent.mm.plugin.finder.storage.logic.d.avG(str);
                    Iterator<T> it = this.uVL.iterator();
                    while (it.hasNext()) {
                        it.next().dx(str, kotlin.h.a.cR((((float) j2) * 100.0f) / ((float) j3)));
                    }
                } else if (i2 != 0) {
                    Log.e(this.uVP.TAG, "[VideoTaskCallTask] error! startRet=" + i2 + " mediaId=" + str);
                    if (-21006 != i2) {
                        com.tencent.mm.plugin.finder.preload.c cVar2 = (com.tencent.mm.plugin.finder.preload.c) b.a(this.uVP, "callback#2", new C1260b(this, str));
                        com.tencent.mm.plugin.finder.storage.logic.d dVar4 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                        com.tencent.mm.plugin.finder.storage.logic.d.dH(str, -1);
                        if (cVar2 != null) {
                            Iterator<T> it2 = this.uVL.iterator();
                            while (it2.hasNext()) {
                                it2.next().a(str, "UPDATE ERROR", cVar2);
                            }
                        }
                    }
                }
                AppMethodBeat.o(249625);
                return 0;
            }
            b.a(this.uVP, "callback#1", new a(this, str));
            Iterator<T> it3 = this.uVL.iterator();
            while (it3.hasNext()) {
                it3.next().aum(str);
            }
            AppMethodBeat.o(249625);
            return -1;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
        static final class a extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.c> {
            final /* synthetic */ String qWs;
            final /* synthetic */ c uVS;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, String str) {
                super(0);
                this.uVS = cVar;
                this.qWs = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ com.tencent.mm.plugin.finder.preload.c invoke() {
                AppMethodBeat.i(249622);
                com.tencent.mm.plugin.finder.preload.c remove = this.uVS.uVI.remove(this.qWs);
                AppMethodBeat.o(249622);
                return remove;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.preload.worker.b$c$b  reason: collision with other inner class name */
        static final class C1260b extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.c> {
            final /* synthetic */ String qWs;
            final /* synthetic */ c uVS;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1260b(c cVar, String str) {
                super(0);
                this.uVS = cVar;
                this.qWs = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ com.tencent.mm.plugin.finder.preload.c invoke() {
                AppMethodBeat.i(249623);
                com.tencent.mm.plugin.finder.preload.c remove = this.uVS.uVI.remove(this.qWs);
                AppMethodBeat.o(249623);
                return remove;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "expect", "", "startTick", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;)V", "onPreloadCompleted", "", "mediaId", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.preload.worker.b$b  reason: collision with other inner class name */
    public final class C1259b implements g.b {
        private final long gXF;
        final HashMap<String, com.tencent.mm.plugin.finder.preload.c> uVI;
        private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> uVL;
        final /* synthetic */ b uVP;
        private final int uVQ;

        public C1259b(b bVar, int i2, long j2, HashMap<String, com.tencent.mm.plugin.finder.preload.c> hashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> concurrentLinkedQueue) {
            p.h(hashMap, "loadingMap");
            p.h(concurrentLinkedQueue, "preLoadCallbacks");
            this.uVP = bVar;
            AppMethodBeat.i(249621);
            this.uVQ = i2;
            this.gXF = j2;
            this.uVI = hashMap;
            this.uVL = concurrentLinkedQueue;
            AppMethodBeat.o(249621);
        }

        @Override // com.tencent.mm.i.g.b
        public final void b(String str, com.tencent.mm.i.d dVar) {
            boolean z;
            AppMethodBeat.i(249620);
            p.h(str, "mediaId");
            if (dVar != null && dVar.field_retCode == -21112) {
                Iterator<T> it = this.uVL.iterator();
                while (it.hasNext()) {
                    it.next().aum(str);
                }
                AppMethodBeat.o(249620);
            } else if (dVar == null) {
                Log.e(this.uVP.TAG, "[onPreloadCompleted] sceneResult == null");
                AppMethodBeat.o(249620);
            } else {
                long[] jArr = new long[3];
                CdnLogic.queryDownloadedSize(str, jArr);
                long max = Math.max(jArr[0], dVar.field_recvedBytes);
                long j2 = dVar.field_fileLength;
                com.tencent.mm.plugin.finder.preload.c cVar = (com.tencent.mm.plugin.finder.preload.c) b.a(this.uVP, "onPreloadCompleted", new a(this, str));
                com.tencent.mm.an.f.baQ().Oc(str);
                if (max <= 0 || j2 <= 0 || cVar == null) {
                    Log.e(this.uVP.TAG, "[onPreloadCompleted] ERROR! mediaId=" + str + " startTick=" + this.gXF + " recvedBytes=" + max + " fileLength=" + j2 + " fileFormat=" + dVar.field_videoFlag + " videoFormat=" + dVar.field_videoFormat);
                    if (cVar != null) {
                        Iterator<T> it2 = this.uVL.iterator();
                        while (it2.hasNext()) {
                            it2.next().a(str, "onPreloadCompleted error", cVar);
                        }
                    }
                    AppMethodBeat.o(249620);
                    return;
                }
                com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                at a2 = com.tencent.mm.plugin.finder.storage.logic.d.a(str, max, j2, j2 <= max ? 3 : 2);
                if (a2.field_reqFormat != dVar.field_videoFormat) {
                    a2.field_reqFormat = dVar.field_videoFormat;
                }
                String str2 = dVar.field_videoFlag;
                if (str2 == null) {
                    str2 = cVar.dlG();
                }
                a2.field_fileFormat = str2;
                com.tencent.mm.plugin.finder.storage.logic.d dVar3 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                com.tencent.mm.plugin.finder.storage.logic.d.avG(str);
                Log.i(this.uVP.TAG, "[onPreloadCompleted] successfully! mediaId=" + str + " startTick=" + this.gXF + " receivedBytes=" + max + " fileLength=" + j2 + " expect=" + this.uVQ + "% result=" + ((int) ((100.0f * ((float) max)) / ((float) j2))) + "% fileFormat=" + dVar.field_videoFlag + " videoFormat=" + dVar.field_videoFormat);
                for (T t : this.uVL) {
                    if (j2 == max) {
                        z = true;
                    } else {
                        z = false;
                    }
                    t.a(str, z, kotlin.h.a.cR((100.0f * ((float) max)) / ((float) j2)), cVar);
                }
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                ((FinderVideoRecycler) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoRecycler.class)).awV(str);
                AppMethodBeat.o(249620);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.preload.worker.b$b$a */
        static final class a extends q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.preload.c> {
            final /* synthetic */ String qWs;
            final /* synthetic */ C1259b uVR;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1259b bVar, String str) {
                super(0);
                this.uVR = bVar;
                this.qWs = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ com.tencent.mm.plugin.finder.preload.c invoke() {
                AppMethodBeat.i(249619);
                com.tencent.mm.plugin.finder.preload.c remove = this.uVR.uVI.remove(this.qWs);
                AppMethodBeat.o(249619);
                return remove;
            }
        }
    }

    public final <T> T l(String str, kotlin.g.a.a<? extends T> aVar) {
        AppMethodBeat.i(249649);
        long uptimeMillis = SystemClock.uptimeMillis();
        this.uVH.lock();
        try {
            return (T) aVar.invoke();
        } finally {
            this.uVH.unlock();
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            if (uptimeMillis2 > 100) {
                Log.w(this.TAG, "[syncLock] tag=" + str + " so slow! cost=" + uptimeMillis2 + LocaleUtil.MALAY);
            }
            AppMethodBeat.o(249649);
        }
    }

    private final void d(List<com.tencent.mm.plugin.finder.preload.c> list, List<com.tencent.mm.plugin.finder.preload.c> list2, List<com.tencent.mm.plugin.finder.preload.c> list3) {
        AppMethodBeat.i(249650);
        if (list.isEmpty()) {
            Log.i(this.TAG, "[mergePreload] preloadList is empty!");
            AppMethodBeat.o(249650);
            return;
        }
        StringBuilder sb = new StringBuilder("[mergePreload] -> \n");
        Iterator<T> it = list3.iterator();
        while (it.hasNext()) {
            sb.append("(-) ").append((Object) it.next()).append("\n");
        }
        for (T t : list2) {
            if (list.contains(t)) {
                sb.append("(+) ").append((Object) t).append("\n");
            } else {
                sb.append("(~) ").append((Object) t).append("\n");
            }
        }
        Log.i(this.TAG, sb.toString());
        AppMethodBeat.o(249650);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class j extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ String qWs;
        final /* synthetic */ b uVP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(b bVar, String str) {
            super(0);
            this.uVP = bVar;
            this.qWs = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(249635);
            this.uVP.uVJ = this.qWs;
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(249635);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class i extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ b uVP;
        final /* synthetic */ LinkedList uWc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(b bVar, LinkedList linkedList) {
            super(0);
            this.uVP = bVar;
            this.uWc = linkedList;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(249634);
            this.uWc.addAll(this.uVP.uVI.values());
            for (com.tencent.mm.plugin.finder.preload.c cVar : this.uWc) {
                b.a(this.uVP, cVar.uUe, true);
            }
            this.uWc.addAll(this.uVP.hhn);
            this.uVP.uVI.clear();
            this.uVP.hhn.clear();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(249634);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class k extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ b uVP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(b bVar) {
            super(0);
            this.uVP = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(249636);
            if (!this.uVP.hhn.isEmpty()) {
                int f2 = this.uVP.uVM.uUq - b.f(this.uVP);
                Log.i(this.uVP.TAG, "[pollWaiting] continue to preload next video. count=" + f2 + " size=" + this.uVP.hhn.size());
                kotlin.a.j.sort(this.uVP.hhn);
                for (int i2 = 0; i2 < f2; i2++) {
                    com.tencent.mm.plugin.finder.preload.c cVar = (com.tencent.mm.plugin.finder.preload.c) this.uVP.hhn.pollFirst();
                    if (cVar != null) {
                        b.a(this.uVP, cVar);
                    }
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(249636);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class l extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ b uVP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(b bVar) {
            super(0);
            this.uVP = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(249637);
            LinkedList<com.tencent.mm.plugin.finder.preload.c> linkedList = new LinkedList();
            linkedList.addAll(this.uVP.uVI.values());
            for (com.tencent.mm.plugin.finder.preload.c cVar : linkedList) {
                b.a(this.uVP, cVar.uUe, true);
            }
            Boolean valueOf = Boolean.valueOf(this.uVP.hhn.addAll(linkedList));
            AppMethodBeat.o(249637);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<LinkedList<com.tencent.mm.plugin.finder.preload.c>> {
        final /* synthetic */ String qWs;
        final /* synthetic */ b uVP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(b bVar, String str) {
            super(0);
            this.uVP = bVar;
            this.qWs = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinkedList<com.tencent.mm.plugin.finder.preload.c> invoke() {
            AppMethodBeat.i(249630);
            final LinkedList linkedList = new LinkedList();
            com.tencent.mm.ac.d.a(this.uVP.hhn, (kotlin.g.a.b) new kotlin.g.a.b<com.tencent.mm.plugin.finder.preload.c, Boolean>(this) {
                /* class com.tencent.mm.plugin.finder.preload.worker.b.e.AnonymousClass1 */
                final /* synthetic */ e uVV;

                {
                    this.uVV = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.preload.c cVar) {
                    AppMethodBeat.i(249629);
                    com.tencent.mm.plugin.finder.preload.c cVar2 = cVar;
                    p.h(cVar2, LocaleUtil.ITALIAN);
                    boolean z = this.uVV.qWs == null || p.j(cVar2.uUe, this.uVV.qWs);
                    if (z) {
                        linkedList.add(cVar2);
                    }
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(249629);
                    return valueOf;
                }
            });
            AppMethodBeat.o(249630);
            return linkedList;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ b uVP;
        final /* synthetic */ LinkedList uVY;
        final /* synthetic */ LinkedList uVZ;
        final /* synthetic */ List uWa;
        final /* synthetic */ LinkedList uWb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(b bVar, LinkedList linkedList, LinkedList linkedList2, List list, LinkedList linkedList3) {
            super(0);
            this.uVP = bVar;
            this.uVY = linkedList;
            this.uVZ = linkedList2;
            this.uWa = list;
            this.uWb = linkedList3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(249633);
            Iterator it = this.uVY.iterator();
            p.g(it, "preloadList.iterator()");
            while (it.hasNext()) {
                Object next = it.next();
                p.g(next, "iterator.next()");
                com.tencent.mm.plugin.finder.preload.c cVar = (com.tencent.mm.plugin.finder.preload.c) next;
                com.tencent.mm.plugin.finder.preload.c cVar2 = (com.tencent.mm.plugin.finder.preload.c) this.uVP.uVI.get(cVar.uUe);
                if (cVar2 != null) {
                    p.g(cVar2, "old");
                    if (!b.a(cVar, cVar2)) {
                        this.uVZ.add(cVar2.uUe);
                    } else {
                        it.remove();
                    }
                }
            }
            for (Map.Entry entry : this.uVP.uVI.entrySet()) {
                if (!this.uWa.contains(entry.getValue())) {
                    this.uVZ.add(((com.tencent.mm.plugin.finder.preload.c) entry.getValue()).uUe);
                }
            }
            for (String str : this.uVZ) {
                com.tencent.mm.plugin.finder.preload.c a2 = b.a(this.uVP, str, false);
                if (a2 != null) {
                    this.uWb.addFirst(a2);
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(249633);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class m extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ int qWv;
        final /* synthetic */ String uWd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(String str, int i2) {
            super(0);
            this.uWd = str;
            this.qWv = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(249638);
            Toast.makeText(MMApplicationContext.getContext(), this.uWd + ' ' + this.qWv, 0).show();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(249638);
            return xVar;
        }
    }

    private final com.tencent.mm.plugin.finder.preload.c a(a.b bVar) {
        boolean z = true;
        AppMethodBeat.i(249647);
        int i2 = p.j(bVar.uUI, "h265") ? 2 : 1;
        com.tencent.mm.plugin.finder.preload.c cVar = new com.tencent.mm.plugin.finder.preload.c(bVar.uPf);
        cVar.taskName = "task_VideoPreloadWorker";
        cVar.field_mediaId = bVar.uPf.auA();
        cVar.url = bVar.uPf.getUrl() + bVar.uPf.djW();
        cVar.field_fullpath = bVar.uPf.getPath();
        cVar.snsCipherKey = bVar.uPf.djV();
        if (bVar.uPf.uIw.hot_flag != 1) {
            z = false;
        }
        cVar.isHotSnsVideo = z;
        cVar.gqO = 2;
        cVar.gqU = 2;
        cVar.gqP = 8;
        cVar.gqZ = bVar.gqZ;
        cVar.field_preloadRatio = bVar.gqZ;
        cVar.concurrentCount = k.a.wEc;
        cVar.connectionCount = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaPreloadModel().uUr;
        cVar.gqy = new c(this, cVar.gqZ, bVar.preloadMinSize, this.uVI, this.uVL, bVar.uPf);
        cVar.gqQ = new C1259b(this, cVar.gqZ, SystemClock.uptimeMillis(), this.uVI, this.uVL);
        cVar.field_fileType = com.tencent.mm.i.a.gpV;
        cVar.preloadMinSize = bVar.preloadMinSize;
        cVar.grb = 0;
        if (this.uVK) {
            cVar.field_requestVideoFormat = 0;
            cVar.auq(bVar.dVY);
        } else {
            cVar.field_requestVideoFormat = i2;
        }
        Log.i(this.TAG, "[createPreloadCDNTask] isHot=" + cVar.isHotSnsVideo + " mediaId=" + bVar.uPf.auA());
        AppMethodBeat.o(249647);
        return cVar;
    }

    public static final /* synthetic */ int f(b bVar) {
        AppMethodBeat.i(249656);
        int size = bVar.uVI.size();
        AppMethodBeat.o(249656);
        return size;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (com.tencent.mm.util.c.hdf() != false) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void dy(java.lang.String r2, int r3) {
        /*
            r1 = 249658(0x3cf3a, float:3.49845E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.DEBUG
            if (r0 != 0) goto L_0x0012
            com.tencent.mm.util.c r0 = com.tencent.mm.util.c.QYz
            boolean r0 = com.tencent.mm.util.c.hdf()
            if (r0 == 0) goto L_0x001e
        L_0x0012:
            if (r3 == 0) goto L_0x001e
            com.tencent.mm.plugin.finder.preload.worker.b$m r0 = new com.tencent.mm.plugin.finder.preload.worker.b$m
            r0.<init>(r2, r3)
            kotlin.g.a.a r0 = (kotlin.g.a.a) r0
            com.tencent.mm.ac.d.h(r0)
        L_0x001e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.preload.worker.b.dy(java.lang.String, int):void");
    }

    public static final /* synthetic */ boolean a(com.tencent.mm.plugin.finder.preload.c cVar, com.tencent.mm.plugin.finder.preload.c cVar2) {
        AppMethodBeat.i(249660);
        if (cVar.preloadMinSize == cVar2.preloadMinSize && cVar.gqZ == cVar2.gqZ && cVar.field_requestVideoFormat == cVar2.field_requestVideoFormat && p.j(cVar.dlG(), cVar2.dlG())) {
            AppMethodBeat.o(249660);
            return true;
        }
        AppMethodBeat.o(249660);
        return false;
    }
}
