package com.tencent.mm.plugin.finder.event;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.protocal.protobuf.cjl;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0007\bB\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PlayEvent", "VideoPlayBehavior", "plugin-finder_release"})
public final class c extends e<b> {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&J4\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\fH&J2\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&J\"\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH&J6\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\fH&J\"\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\tH&J*\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0005H&J*\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0005H&J2\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&J2\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001f2\u0006\u0010\u000b\u001a\u00020\fH&J2\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&J<\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010#H&J2\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001f2\u0006\u0010\u000b\u001a\u00020\fH&J\"\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH&J2\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&J>\u0010)\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010*\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010,\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010-\u001a\u00020\tH&J\"\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\"\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\"\u00100\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH&J\"\u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH&¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "", "checkVideoDataAvailable", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onError", "errCode", "onFirstFrame", "prepareCostTime", "onFirstVideoFrameRendered", "onMoovReady", "onPause", "mediaList", "Ljava/util/LinkedList;", "onPlayProgress", "onPlayerConfigChange", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "position", "bgPreparedStatus", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder_release"})
    public interface b {
        void a(long j2, cjl cjl, int i2);

        void a(long j2, cjl cjl, int i2, int i3, s sVar);

        void a(long j2, cjl cjl, int i2, d dVar, s sVar);

        void a(long j2, cjl cjl, h hVar, d dVar, s sVar);

        void a(long j2, cjl cjl, s sVar);

        void a(long j2, cjl cjl, s sVar, long j3);

        void a(long j2, cjl cjl, com.tencent.mm.plugin.finder.video.s sVar, int i2, s sVar2, int i3);

        void a(long j2, cjl cjl, LinkedList<cjl> linkedList, s sVar);

        void a(long j2, cjl cjl, LinkedList<cjl> linkedList, s sVar, com.tencent.mm.plugin.finder.video.reporter.c cVar);

        void b(long j2, cjl cjl, int i2, int i3, s sVar);

        void b(long j2, cjl cjl, s sVar);

        void b(long j2, cjl cjl, LinkedList<cjl> linkedList, s sVar);

        void c(long j2, cjl cjl, int i2, int i3, s sVar);

        void c(long j2, cjl cjl, s sVar);

        void d(long j2, cjl cjl, int i2, int i3, s sVar);

        void d(long j2, cjl cjl, s sVar);

        void e(long j2, cjl cjl, int i2, int i3, s sVar);

        void e(long j2, cjl cjl, s sVar);

        void f(long j2, cjl cjl, s sVar);

        void g(long j2, cjl cjl, s sVar);
    }

    private /* synthetic */ c() {
        this(null);
    }

    public c(com.tencent.mm.plugin.finder.event.base.c cVar) {
        super(cVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000U\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J4\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0016J2\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J6\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\tH\u0016J*\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J*\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J2\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J2\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J2\u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J<\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J2\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J2\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J<\u0010)\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010-\u001a\u00020\tH\u0016J\"\u0010.\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010/\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u00100\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u00062"}, hxF = {"com/tencent/mm/plugin/finder/event/PlayEventSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "checkVideoDataAvailable", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onError", "errCode", "onFirstFrame", "prepareCostTime", "onFirstVideoFrameRendered", "onMoovReady", "onPause", "mediaList", "Ljava/util/LinkedList;", "onPlayProgress", "onPlayerConfigChange", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "position", "bgPreparedStatus", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.event.c$c  reason: collision with other inner class name */
    public static final class C1109c implements b {
        final /* synthetic */ c tHU;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C1109c(c cVar) {
            this.tHU = cVar;
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void a(long j2, cjl cjl, s sVar) {
            AppMethodBeat.i(243427);
            p.h(sVar, "video");
            a aVar = new a(17);
            aVar.tHM = cjl;
            aVar.feedId = j2;
            aVar.tHN = sVar;
            this.tHU.c(aVar);
            AppMethodBeat.o(243427);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void f(long j2, cjl cjl, s sVar) {
            AppMethodBeat.i(243428);
            p.h(sVar, "video");
            a aVar = new a(16);
            aVar.tHM = cjl;
            aVar.feedId = j2;
            aVar.tHN = sVar;
            this.tHU.c(aVar);
            AppMethodBeat.o(243428);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void a(long j2, cjl cjl, h hVar, d dVar, s sVar) {
            AppMethodBeat.i(243429);
            p.h(sVar, "video");
            a aVar = new a(15);
            aVar.tHM = cjl;
            aVar.feedId = j2;
            aVar.hmq = dVar;
            aVar.tHN = sVar;
            aVar.jqr = hVar;
            this.tHU.c(aVar);
            AppMethodBeat.o(243429);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void a(long j2, cjl cjl, int i2, d dVar, s sVar) {
            AppMethodBeat.i(243430);
            p.h(sVar, "video");
            a aVar = new a(14);
            aVar.tHM = cjl;
            aVar.feedId = j2;
            aVar.ret = i2;
            aVar.tHN = sVar;
            aVar.hmq = dVar;
            this.tHU.c(aVar);
            AppMethodBeat.o(243430);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void e(long j2, cjl cjl, int i2, int i3, s sVar) {
            AppMethodBeat.i(243431);
            p.h(sVar, "video");
            a aVar = new a(13);
            aVar.tHM = cjl;
            aVar.feedId = j2;
            aVar.offset = i2;
            aVar.tHN = sVar;
            aVar.jcu = i3;
            this.tHU.c(aVar);
            AppMethodBeat.o(243431);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void a(long j2, cjl cjl, s sVar, long j3) {
            AppMethodBeat.i(243432);
            p.h(sVar, "video");
            a aVar = new a(12);
            aVar.tHM = cjl;
            aVar.feedId = j2;
            aVar.tHN = sVar;
            aVar.tHR = j3;
            this.tHU.c(aVar);
            AppMethodBeat.o(243432);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void g(long j2, cjl cjl, s sVar) {
            AppMethodBeat.i(243433);
            p.h(sVar, "video");
            a aVar = new a(19);
            aVar.tHM = cjl;
            aVar.feedId = j2;
            aVar.tHN = sVar;
            aVar.tHR = 0;
            this.tHU.c(aVar);
            AppMethodBeat.o(243433);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void b(long j2, cjl cjl, LinkedList<cjl> linkedList, s sVar) {
            AppMethodBeat.i(243434);
            p.h(sVar, "video");
            a aVar = new a(11);
            aVar.tHM = cjl;
            aVar.feedId = j2;
            aVar.mediaList = linkedList;
            aVar.tHN = sVar;
            this.tHU.c(aVar);
            AppMethodBeat.o(243434);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void d(long j2, cjl cjl, int i2, int i3, s sVar) {
            AppMethodBeat.i(243435);
            p.h(sVar, "video");
            a aVar = new a(10);
            aVar.feedId = j2;
            aVar.tHM = cjl;
            aVar.tHO = i2;
            aVar.tHP = i3;
            aVar.tHN = sVar;
            this.tHU.c(aVar);
            AppMethodBeat.o(243435);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void c(long j2, cjl cjl, int i2, int i3, s sVar) {
            AppMethodBeat.i(243436);
            p.h(sVar, "video");
            a aVar = new a(8);
            aVar.offset = i2;
            aVar.jcu = i3;
            aVar.feedId = j2;
            aVar.tHM = cjl;
            aVar.tHN = sVar;
            this.tHU.c(aVar);
            AppMethodBeat.o(243436);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void b(long j2, cjl cjl, int i2, int i3, s sVar) {
            AppMethodBeat.i(243437);
            p.h(sVar, "video");
            a aVar = new a(7);
            aVar.offset = i2;
            aVar.jcu = i3;
            aVar.feedId = j2;
            aVar.tHM = cjl;
            aVar.tHN = sVar;
            this.tHU.c(aVar);
            AppMethodBeat.o(243437);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void e(long j2, cjl cjl, s sVar) {
            AppMethodBeat.i(243438);
            p.h(sVar, "video");
            a aVar = new a(6);
            aVar.feedId = j2;
            aVar.tHM = cjl;
            aVar.tHN = sVar;
            this.tHU.c(aVar);
            AppMethodBeat.o(243438);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void b(long j2, cjl cjl, s sVar) {
            AppMethodBeat.i(243439);
            p.h(sVar, "video");
            a aVar = new a(9);
            aVar.feedId = j2;
            aVar.tHM = cjl;
            aVar.tHN = sVar;
            this.tHU.c(aVar);
            AppMethodBeat.o(243439);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void c(long j2, cjl cjl, s sVar) {
            AppMethodBeat.i(243440);
            p.h(sVar, "video");
            a aVar = new a(5);
            aVar.feedId = j2;
            aVar.tHM = cjl;
            aVar.tHN = sVar;
            this.tHU.c(aVar);
            AppMethodBeat.o(243440);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void a(long j2, cjl cjl, com.tencent.mm.plugin.finder.video.s sVar, int i2, s sVar2, int i3) {
            AppMethodBeat.i(243441);
            p.h(sVar2, "video");
            a aVar = new a(4);
            aVar.tHL = sVar;
            aVar.feedId = j2;
            aVar.tHM = cjl;
            aVar.position = i2;
            aVar.tHN = sVar2;
            aVar.tHQ = i3;
            this.tHU.c(aVar);
            AppMethodBeat.o(243441);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void a(long j2, cjl cjl, int i2, int i3, s sVar) {
            AppMethodBeat.i(243442);
            p.h(sVar, "video");
            a aVar = new a(3);
            aVar.offset = i2;
            aVar.jcu = i3;
            aVar.tHN = sVar;
            aVar.feedId = j2;
            aVar.tHM = cjl;
            this.tHU.c(aVar);
            AppMethodBeat.o(243442);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void d(long j2, cjl cjl, s sVar) {
            AppMethodBeat.i(243443);
            p.h(sVar, "video");
            a aVar = new a(2);
            aVar.feedId = j2;
            aVar.tHN = sVar;
            aVar.tHM = cjl;
            this.tHU.c(aVar);
            AppMethodBeat.o(243443);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void a(long j2, cjl cjl, LinkedList<cjl> linkedList, s sVar) {
            AppMethodBeat.i(243444);
            p.h(sVar, "video");
            a aVar = new a(1);
            aVar.tHM = cjl;
            aVar.tHN = sVar;
            aVar.feedId = j2;
            aVar.mediaList = linkedList;
            this.tHU.c(aVar);
            AppMethodBeat.o(243444);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void a(long j2, cjl cjl, LinkedList<cjl> linkedList, s sVar, com.tencent.mm.plugin.finder.video.reporter.c cVar) {
            AppMethodBeat.i(243445);
            p.h(sVar, "video");
            a aVar = new a(20);
            aVar.tHM = cjl;
            aVar.tHN = sVar;
            aVar.feedId = j2;
            aVar.mediaList = linkedList;
            aVar.tHS = cVar;
            this.tHU.c(aVar);
            AppMethodBeat.o(243445);
        }

        @Override // com.tencent.mm.plugin.finder.event.c.b
        public final void a(long j2, cjl cjl, int i2) {
            AppMethodBeat.i(243446);
            a aVar = new a(18);
            aVar.tHM = cjl;
            aVar.feedId = j2;
            aVar.ret = i2;
            this.tHU.c(aVar);
            AppMethodBeat.o(243446);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 ]2\u00020\u0001:\u0001]B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\u0013\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010ZHÖ\u0003J\t\u0010[\u001a\u00020\u0003HÖ\u0001J\b\u0010\\\u001a\u00020%H\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0007\"\u0004\b,\u0010\u0004R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\u0004R\u001a\u00106\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000f\"\u0004\b8\u0010\u0011R\u001a\u00109\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u0010\u0004R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0007\"\u0004\bD\u0010\u0004R\u001c\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0007\"\u0004\bM\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u0007R\u001c\u0010O\u001a\u0004\u0018\u00010PX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006^"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "bgPreparedStatus", "getBgPreparedStatus", "()I", "setBgPreparedStatus", "currentSec", "getCurrentSec", "setCurrentSec", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "setMedia", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "mediaList", "Ljava/util/LinkedList;", "getMediaList", "()Ljava/util/LinkedList;", "setMediaList", "(Ljava/util/LinkedList;)V", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaSource", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaSource", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "objectNonceId", "", "getObjectNonceId", "()Ljava/lang/String;", "setObjectNonceId", "(Ljava/lang/String;)V", "offset", "getOffset", "setOffset", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "getPlayerConfig", "()Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "setPlayerConfig", "(Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;)V", "position", "getPosition", "setPosition", "prepareCostTime", "getPrepareCostTime", "setPrepareCostTime", "ret", "getRet", "setRet", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "getSceneResult", "()Lcom/tencent/mm/cdn/keep_SceneResult;", "setSceneResult", "(Lcom/tencent/mm/cdn/keep_SceneResult;)V", "seekSec", "getSeekSec", "setSeekSec", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "getTaskInfo", "()Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "setTaskInfo", "(Lcom/tencent/mm/cdn/keep_VideoTaskInfo;)V", "total", "getTotal", "setTotal", "getType", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "setVideo", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;)V", "component1", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "Companion", "plugin-finder_release"})
    public static final class a extends com.tencent.mm.plugin.finder.event.base.b {
        public static final C1108a tHT = new C1108a((byte) 0);
        public long feedId;
        public d hmq;
        public int jcu;
        public h jqr;
        LinkedList<cjl> mediaList;
        private String objectNonceId = "";
        public int offset;
        public int position;
        public int ret;
        public com.tencent.mm.plugin.finder.video.s tHL;
        public cjl tHM;
        public s tHN;
        public int tHO;
        public int tHP;
        public int tHQ;
        public long tHR;
        public com.tencent.mm.plugin.finder.video.reporter.c tHS;
        public final int type;

        static {
            AppMethodBeat.i(165517);
            AppMethodBeat.o(165517);
        }

        public final boolean equals(Object obj) {
            return this == obj || ((obj instanceof a) && this.type == ((a) obj).type);
        }

        public final int hashCode() {
            return this.type;
        }

        public a(int i2) {
            this.type = i2;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final long getFeedId() {
            return this.feedId;
        }

        public final int dam() {
            return this.tHO;
        }

        public final int dan() {
            return this.tHP;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$PlayEvent$Companion;", "", "()V", "VIDEO_CHECK_VIDEO_DATA_AVAILABLE", "", "VIDEO_CLICK_PAUSE", "VIDEO_DOWNLOAD_FINISH", "VIDEO_DOWNLOAD_PROGRESS", "VIDEO_DOWNLOAD_START", "VIDEO_DOWNLOAD_STOP", "VIDEO_FIRST_FRAME", "VIDEO_FIRST_FRAME_RENDERED", "VIDEO_MOOV_READY", "VIDEO_PAUSE", "VIDEO_PLAYER_CONFIG", "VIDEO_PLAY_ERROR", "VIDEO_PROGRESS", "VIDEO_REAL_PLAY", "VIDEO_REPLAY", "VIDEO_SEEK", "VIDEO_START_PLAY", "VIDEO_STOP_PLAY", "VIDEO_WAITING", "VIDEO_WAITING_END", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.event.c$a$a  reason: collision with other inner class name */
        public static final class C1108a {
            private C1108a() {
            }

            public /* synthetic */ C1108a(byte b2) {
                this();
            }
        }

        public final String toString() {
            String str;
            AppMethodBeat.i(165516);
            StringBuilder append = new StringBuilder("(type=").append(this.type).append(", mediaObject=").append(this.tHM).append(", mediaId=");
            cjl cjl = this.tHM;
            if (cjl == null || (str = cjl.mediaId) == null) {
                str = "";
            }
            StringBuilder append2 = append.append(str).append(", offset=").append(this.offset).append(", total=").append(this.jcu).append(", feedId=").append(this.feedId).append(", objectNonceId='").append(this.objectNonceId).append("' mediaListSize=");
            LinkedList<cjl> linkedList = this.mediaList;
            String sb = append2.append(linkedList != null ? Integer.valueOf(linkedList.size()) : null).append(')').toString();
            AppMethodBeat.o(165516);
            return sb;
        }
    }
}
