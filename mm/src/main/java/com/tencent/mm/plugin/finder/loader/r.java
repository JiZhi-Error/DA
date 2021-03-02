package com.tencent.mm.plugin.finder.loader;

import android.widget.Toast;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoView;
import com.tencent.mm.plugin.finder.video.x;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0003\u0011\u0012\u0013B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "", "preloadCoreCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "getPreloadCoreCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "createVideoProxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "runOnUI", "", "run", "Lkotlin/Function0;", "CdnCallback", "Companion", "VideoProxy", "plugin-finder_release"})
public final class r {
    public static final b uJq = new b((byte) 0);
    final MediaPreloadCore uJp;

    static {
        AppMethodBeat.i(166363);
        AppMethodBeat.o(166363);
    }

    public /* synthetic */ r() {
        this(null);
    }

    public r(MediaPreloadCore mediaPreloadCore) {
        this.uJp = mediaPreloadCore;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$Companion;", "", "()V", "TAG", "", "checkFinishValid", "", "mediaId", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final com.tencent.mm.modelvideo.b a(s sVar, x xVar) {
        AppMethodBeat.i(248239);
        p.h(sVar, "video");
        p.h(xVar, "callback");
        c cVar = new c(this, sVar, xVar);
        AppMethodBeat.o(248239);
        return cVar;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J \u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\nH\u0016J \u0010\"\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001bH\u0016J\u0012\u0010%\u001a\u00020 2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "getEngineCallback", "()Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "setEngineCallback", "(Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;)V", "isHasStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isVideoDataAvailable", "", "mediaId", "", "offset", "", "length", "requestVideoData", "", "setIEngineCallback", "startHttpStream", "filePath", "url", "stop", "plugin-finder_release"})
    public final class c implements com.tencent.mm.modelvideo.b {
        private final Object lock = new Object();
        private b.a qWn;
        final s tHN;
        private final AtomicBoolean uJF = new AtomicBoolean(false);
        private at uJG;
        final x uJr;
        final /* synthetic */ r uJt;

        public c(r rVar, s sVar, x xVar) {
            p.h(sVar, "video");
            this.uJt = rVar;
            AppMethodBeat.i(248238);
            this.tHN = sVar;
            this.uJr = xVar;
            AppMethodBeat.o(248238);
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void p(String str, String str2, String str3) {
            String str4;
            AppMethodBeat.i(166355);
            p.h(str, "mediaId");
            p.h(str2, "filePath");
            p.h(str3, "url");
            synchronized (this.lock) {
                try {
                    this.uJF.set(false);
                    com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                    at avH = com.tencent.mm.plugin.finder.storage.logic.d.avH(str);
                    avH.field_reqFormat = this.tHN.uJN;
                    if (avH.field_fileFormat == null) {
                        str4 = this.tHN.uIx.detail;
                    } else {
                        str4 = avH.field_fileFormat;
                    }
                    avH.field_fileFormat = str4;
                    com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                    String str5 = this.tHN.uIw.mediaId;
                    if (str5 == null) {
                        str5 = "";
                    }
                    int i2 = this.tHN.uJN;
                    String str6 = avH.field_fileFormat;
                    p.g(str6, "this.field_fileFormat");
                    com.tencent.mm.plugin.finder.storage.logic.d.a(str, str5, str3, i2, str6, avH.field_cacheSize, avH.field_totalSize, 1, this.tHN.uIw.videoDuration, this.tHN.djW(), this.tHN.djV());
                    y yVar = y.vXH;
                    int i3 = avH.field_reqFormat;
                    String str7 = avH.field_fileFormat;
                    p.g(str7, "videoCache.field_fileFormat");
                    h a2 = y.a(str, str3, str2, i3, str7, this.tHN.djW(), this.tHN.djV(), this.tHN.uIw.hot_flag == 1, new a(this.uJt, this.uJr, this.qWn, this.tHN, this.uJF, this.lock), "Finder.VideoDownloader");
                    this.uJG = avH;
                    MediaPreloadCore mediaPreloadCore = this.uJt.uJp;
                    if (mediaPreloadCore != null) {
                        mediaPreloadCore.bl(str, true);
                    }
                    Log.i("Finder.VideoDownloader", "[startHttpStream] fallback cancel mediaId=" + str + " isPreLoadCompleted=" + avH.dkO() + ' ' + "isAllCompleted=" + avH.dkN() + " file=" + str2 + ", " + str3 + " isMoovReady=" + avH.field_moovReady);
                    if (avH.dkN()) {
                        Log.i("Finder.VideoDownloader", "[finish] mediaId=" + str + " cacheSize=" + avH.field_cacheSize + " totalSize=" + avH.field_totalSize + '}');
                        a2.gre.a(str, avH.field_cacheSize, avH.field_totalSize, avH.field_fileFormat);
                        a2.gre.i(str, avH.field_cacheSize, avH.field_totalSize);
                        a2.gre.a(str, 0, null);
                        MediaPreloadCore mediaPreloadCore2 = this.uJt.uJp;
                        if (mediaPreloadCore2 != null) {
                            mediaPreloadCore2.bl(str, false);
                        }
                        return;
                    }
                    o.bhk().e(a2);
                    r.S(new a(this, str, str3, str2));
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(166355);
                } finally {
                    AppMethodBeat.o(166355);
                }
            }
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void he(String str) {
            AppMethodBeat.i(166356);
            synchronized (this.lock) {
                try {
                    this.uJF.compareAndSet(false, true);
                    Log.i("Finder.VideoDownloader", "[stop] mediaId=".concat(String.valueOf(str)));
                    if (str != null) {
                        o.bhk().a(str, new b(this, str));
                        MediaPreloadCore mediaPreloadCore = this.uJt.uJp;
                        if (mediaPreloadCore != null) {
                            mediaPreloadCore.bl(str, false);
                            kotlin.x xVar = kotlin.x.SXb;
                        }
                    }
                } finally {
                    AppMethodBeat.o(166356);
                }
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b¨\u0006\r"}, hxF = {"<anonymous>", "", "ret", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "kotlin.jvm.PlatformType", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "isFinish", "", "onStop", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$stop$1$1$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$$special$$inlined$let$lambda$1"})
        static final class b implements e.a {
            final /* synthetic */ c uJH;
            final /* synthetic */ String uJv;

            b(c cVar, String str) {
                this.uJH = cVar;
                this.uJv = str;
            }

            @Override // com.tencent.mm.an.e.a
            public final void a(final h hVar, final com.tencent.mm.i.d dVar) {
                AppMethodBeat.i(166354);
                r.S(new kotlin.g.a.a<kotlin.x>(this) {
                    /* class com.tencent.mm.plugin.finder.loader.r.c.b.AnonymousClass1 */
                    final /* synthetic */ b uJJ;

                    {
                        this.uJJ = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ kotlin.x invoke() {
                        AppMethodBeat.i(166353);
                        x xVar = this.uJJ.uJH.uJr;
                        if (xVar != null) {
                            xVar.a(this.uJJ.uJH.tHN, hVar, dVar);
                        }
                        kotlin.x xVar2 = kotlin.x.SXb;
                        AppMethodBeat.o(166353);
                        return xVar2;
                    }
                });
                AppMethodBeat.o(166354);
            }
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void requestVideoData(String str, int i2, int i3) {
            AppMethodBeat.i(166357);
            p.h(str, "mediaId");
            synchronized (this.lock) {
                try {
                    StringBuilder append = new StringBuilder("[requestVideoData] mediaId=").append(str).append(" offset=").append(i2).append(" length=").append(i3).append(" cacheSize=");
                    at atVar = this.uJG;
                    Log.i("Finder.VideoDownloader", append.append(atVar != null ? Long.valueOf(atVar.field_cacheSize) : null).toString());
                    o.bhk();
                    e.r(str, i2, i3);
                } finally {
                    AppMethodBeat.o(166357);
                }
            }
        }

        @Override // com.tencent.mm.modelvideo.b
        public final boolean isVideoDataAvailable(String str, int i2, int i3) {
            boolean isVideoDataAvailable;
            AppMethodBeat.i(166358);
            p.h(str, "mediaId");
            synchronized (this.lock) {
                try {
                    StringBuilder append = new StringBuilder("[isVideoDataAvailable] mediaId=").append(str).append(" offset=").append(i2).append(" length=").append(i3).append(" cacheSize=");
                    at atVar = this.uJG;
                    Log.i("Finder.VideoDownloader", append.append(atVar != null ? Long.valueOf(atVar.field_cacheSize) : null).toString());
                    x xVar = this.uJr;
                    if (xVar != null) {
                        xVar.ac(str, i2, i3);
                    }
                    isVideoDataAvailable = o.bhk().isVideoDataAvailable(str, i2, i3);
                } finally {
                    AppMethodBeat.o(166358);
                }
            }
            return isVideoDataAvailable;
        }

        @Override // com.tencent.mm.modelvideo.b
        public final void a(b.a aVar) {
            AppMethodBeat.i(166359);
            p.h(aVar, "callback");
            this.qWn = aVar;
            AppMethodBeat.o(166359);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy$startHttpStream$1$1"})
        static final class a extends q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ String pFh;
            final /* synthetic */ c uJH;
            final /* synthetic */ String uJI;
            final /* synthetic */ String uJv;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, String str, String str2, String str3) {
                super(0);
                this.uJH = cVar;
                this.uJv = str;
                this.pFh = str2;
                this.uJI = str3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(166352);
                x xVar = this.uJH.uJr;
                if (xVar != null) {
                    xVar.b(this.uJH.tHN);
                }
                kotlin.x xVar2 = kotlin.x.SXb;
                AppMethodBeat.o(166352);
                return xVar2;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\"\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0016J*\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0016J \u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isStopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/lang/Object;)V", "onDataAvailable", "", "mediaId", "", "offset", "", "total", "onFinish", "ret", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onM3U8Ready", "m3u8", "onMoovReady", "svrflag", "onProgress", "plugin-finder_release"})
    final class a implements h.a {
        private final Object lock;
        final b.a qWn;
        final s tHN;
        final x uJr;
        final AtomicBoolean uJs;
        final /* synthetic */ r uJt;

        public a(r rVar, x xVar, b.a aVar, s sVar, AtomicBoolean atomicBoolean, Object obj) {
            p.h(sVar, "video");
            p.h(atomicBoolean, "isStopped");
            p.h(obj, "lock");
            this.uJt = rVar;
            AppMethodBeat.i(248237);
            this.uJr = xVar;
            this.qWn = aVar;
            this.tHN = sVar;
            this.uJs = atomicBoolean;
            this.lock = obj;
            AppMethodBeat.o(248237);
        }

        @Override // com.tencent.mm.i.h.a
        public final void Ds(String str) {
            AppMethodBeat.i(248235);
            p.h(str, "mediaId");
            AppMethodBeat.o(248235);
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(String str, long j2, long j3, String str2) {
            String str3;
            AppMethodBeat.i(248236);
            p.h(str, "mediaId");
            synchronized (this.lock) {
                try {
                    Log.i("Finder.VideoDownloader", "[onMoovReady] mediaId=" + str + " offset=" + j2 + " total=" + j3 + " fileFormat=[" + this.tHN.uIx + "=>" + str2 + "]} isHasStop=" + this.uJs.get());
                    if (!this.uJs.get()) {
                        z.a aVar = new z.a();
                        aVar.SYB = false;
                        if (this.qWn instanceof FinderVideoView) {
                            aVar.SYB = ((FinderVideoView) this.qWn).Gs(j2);
                        }
                        com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                        boolean z = !com.tencent.mm.plugin.finder.storage.logic.d.avH(str).field_moovReady;
                        com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                        if (str2 == null) {
                            str3 = "";
                        } else {
                            str3 = str2;
                        }
                        com.tencent.mm.plugin.finder.storage.logic.d.gU(str, str3);
                        com.tencent.mm.plugin.finder.storage.logic.d dVar3 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                        com.tencent.mm.plugin.finder.storage.logic.d.avG(str);
                        r.S(new e(aVar, z, this, str, j2, j3, str2));
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                } finally {
                    AppMethodBeat.o(248236);
                }
            }
        }

        @Override // com.tencent.mm.i.h.a
        public final void onDataAvailable(String str, long j2, long j3) {
            AppMethodBeat.i(166346);
            p.h(str, "mediaId");
            synchronized (this.lock) {
                try {
                    if (!this.uJs.get()) {
                        r.S(new C1210a(this, str, j2, j3));
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(166346);
                    throw th;
                }
            }
            Log.i("Finder.VideoDownloader", "[onDataAvailable] mediaId=" + str + " offset=" + j2 + " total=" + j3);
            AppMethodBeat.o(166346);
        }

        @Override // com.tencent.mm.i.h.a
        public final void i(String str, long j2, long j3) {
            AppMethodBeat.i(166347);
            p.h(str, "mediaId");
            synchronized (this.lock) {
                try {
                    if (!this.uJs.get()) {
                        Log.i("Finder.VideoDownloader", "[onProgress] mediaId=" + str + " offset=" + j2 + " total=" + j3);
                        com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                        com.tencent.mm.plugin.finder.storage.logic.d.a(str, j2, j3, 1);
                        com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                        com.tencent.mm.plugin.finder.storage.logic.d.avG(str);
                        r.S(new f(this, str, j2, j3));
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                } finally {
                    AppMethodBeat.o(166347);
                }
            }
        }

        @Override // com.tencent.mm.i.h.a
        public final void a(String str, int i2, com.tencent.mm.i.d dVar) {
            boolean z = true;
            AppMethodBeat.i(166348);
            p.h(str, "mediaId");
            synchronized (this.lock) {
                try {
                    if (!this.uJs.get()) {
                        if (dVar != null) {
                            Log.i("Finder.VideoDownloader", "[onFinish] mediaId=" + str + " ret=" + i2 + " fileLength=" + dVar.field_fileLength + ' ' + "sceneResult=" + dVar.field_retCode + " videoFormat:" + dVar.field_videoFormat + " videoFlag=" + dVar.field_videoFlag);
                            b bVar = r.uJq;
                            p.h(str, "mediaId");
                            long[] jArr = new long[3];
                            CdnLogic.queryDownloadedSize(str, jArr);
                            if (!(jArr[0] == jArr[1] && jArr[1] == jArr[2])) {
                                Log.e("Finder.VideoDownloader", "[checkFinishValid] mediaId=" + str + ' ' + jArr[0] + ':' + jArr[1] + ':' + jArr[2]);
                                z = false;
                            }
                            if (!z && (BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG)) {
                                com.tencent.mm.ac.d.h(d.uJB);
                            }
                            com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                            com.tencent.mm.plugin.finder.storage.logic.d.a(str, dVar.field_fileLength, dVar.field_fileLength, 3);
                            com.tencent.mm.plugin.finder.storage.logic.d dVar3 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                            com.tencent.mm.plugin.finder.storage.logic.d.avG(str);
                            r.S(new b(this, dVar, str, i2));
                        } else {
                            Log.e("Finder.VideoDownloader", "sceneResult is null! mediaId=" + str + " ret=" + i2);
                            r.S(new c(this, this, dVar, str, i2));
                        }
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                } finally {
                    AppMethodBeat.o(166348);
                }
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onMoovReady$1$1"})
        static final class e extends q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ z.a uJC;
            final /* synthetic */ boolean uJD;
            final /* synthetic */ String uJE;
            final /* synthetic */ a uJu;
            final /* synthetic */ String uJv;
            final /* synthetic */ long uJw;
            final /* synthetic */ long uJx;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(z.a aVar, boolean z, a aVar2, String str, long j2, long j3, String str2) {
                super(0);
                this.uJC = aVar;
                this.uJD = z;
                this.uJu = aVar2;
                this.uJv = str;
                this.uJw = j2;
                this.uJx = j3;
                this.uJE = str2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(166343);
                if (!this.uJu.uJs.get()) {
                    com.tencent.mm.ac.c cVar = new com.tencent.mm.ac.c("onMoovReady");
                    if (this.uJu.qWn instanceof FinderVideoView) {
                        ((FinderVideoView) this.uJu.qWn).B(this.uJw, this.uJC.SYB);
                    }
                    x xVar = this.uJu.uJr;
                    if (xVar != null) {
                        xVar.a((int) this.uJw, (int) this.uJx, this.uJu.tHN, this.uJD);
                    }
                    Log.i("Finder.VideoDownloader", "onMoovReady man " + cVar + " mediaId: " + this.uJv);
                } else {
                    Log.w("Finder.VideoDownloader", "has stop!");
                }
                kotlin.x xVar2 = kotlin.x.SXb;
                AppMethodBeat.o(166343);
                return xVar2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onDataAvailable$1$1"})
        /* renamed from: com.tencent.mm.plugin.finder.loader.r$a$a  reason: collision with other inner class name */
        static final class C1210a extends q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ a uJu;
            final /* synthetic */ String uJv;
            final /* synthetic */ long uJw;
            final /* synthetic */ long uJx;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1210a(a aVar, String str, long j2, long j3) {
                super(0);
                this.uJu = aVar;
                this.uJv = str;
                this.uJw = j2;
                this.uJx = j3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(166340);
                b.a aVar = this.uJu.qWn;
                if (aVar != null) {
                    aVar.onDataAvailable(this.uJv, this.uJw, this.uJx);
                }
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(166340);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onProgress$1$1"})
        static final class f extends q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ a uJu;
            final /* synthetic */ String uJv;
            final /* synthetic */ long uJw;
            final /* synthetic */ long uJx;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(a aVar, String str, long j2, long j3) {
                super(0);
                this.uJu = aVar;
                this.uJv = str;
                this.uJw = j2;
                this.uJx = j3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(166344);
                b.a aVar = this.uJu.qWn;
                if (aVar != null) {
                    aVar.i(this.uJv, this.uJw, this.uJx);
                }
                x xVar = this.uJu.uJr;
                if (xVar != null) {
                    xVar.a((int) this.uJw, (int) this.uJx, this.uJu.tHN);
                }
                kotlin.x xVar2 = kotlin.x.SXb;
                AppMethodBeat.o(166344);
                return xVar2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class d extends q implements kotlin.g.a.a<kotlin.x> {
            public static final d uJB = new d();

            static {
                AppMethodBeat.i(248234);
                AppMethodBeat.o(248234);
            }

            d() {
                super(0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(248233);
                Toast.makeText(MMApplicationContext.getContext(), "[checkFinishValid] error!!!", 0).show();
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(248233);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onFinish$1$1$2", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$$special$$inlined$let$lambda$1"})
        static final class b extends q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ a uJu;
            final /* synthetic */ String uJv;
            final /* synthetic */ com.tencent.mm.i.d uJy;
            final /* synthetic */ int uJz;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar, com.tencent.mm.i.d dVar, String str, int i2) {
                super(0);
                this.uJu = aVar;
                this.uJy = dVar;
                this.uJv = str;
                this.uJz = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(166341);
                b.a aVar = this.uJu.qWn;
                if (aVar != null) {
                    aVar.ax(this.uJv, this.uJz);
                }
                x xVar = this.uJu.uJr;
                if (xVar != null) {
                    xVar.a(this.uJz, this.uJu.tHN, this.uJy);
                }
                kotlin.x xVar2 = kotlin.x.SXb;
                AppMethodBeat.o(166341);
                return xVar2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$onFinish$1$2$1", "com/tencent/mm/plugin/finder/loader/FinderVideoDownloader$CdnCallback$$special$$inlined$run$lambda$1"})
        static final class c extends q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ a uJA;
            final /* synthetic */ a uJu;
            final /* synthetic */ String uJv;
            final /* synthetic */ com.tencent.mm.i.d uJy;
            final /* synthetic */ int uJz;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(a aVar, a aVar2, com.tencent.mm.i.d dVar, String str, int i2) {
                super(0);
                this.uJA = aVar;
                this.uJu = aVar2;
                this.uJy = dVar;
                this.uJv = str;
                this.uJz = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(166342);
                b.a aVar = this.uJA.qWn;
                if (aVar != null) {
                    aVar.ax(this.uJv, this.uJz);
                }
                x xVar = this.uJA.uJr;
                if (xVar != null) {
                    xVar.a(this.uJz, this.uJA.tHN, this.uJy);
                }
                kotlin.x xVar2 = kotlin.x.SXb;
                AppMethodBeat.o(166342);
                return xVar2;
            }
        }
    }

    public static void S(kotlin.g.a.a<kotlin.x> aVar) {
        AppMethodBeat.i(166362);
        p.h(aVar, "run");
        com.tencent.mm.ac.d.h(new d(aVar));
        AppMethodBeat.o(166362);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ kotlin.g.a.a uJM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(kotlin.g.a.a aVar) {
            super(0);
            this.uJM = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(166361);
            this.uJM.invoke();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(166361);
            return xVar;
        }
    }
}
