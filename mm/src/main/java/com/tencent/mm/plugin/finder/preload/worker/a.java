package com.tencent.mm.plugin.finder.preload.worker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J8\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u001e\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00110\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/worker/IPreloadWorker;", "()V", "onClearAll", "", "onMediaFocus", "mediaId", "", "isFocused", "", "onPreloadStart", "onPreloadStop", "onRelease", "preload", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "dataList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "source", "", "Companion", "plugin-finder_release"})
public final class a {
    public static final C1258a uVG = new C1258a((byte) 0);

    static {
        AppMethodBeat.i(249613);
        AppMethodBeat.o(249613);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker$Companion;", "", "()V", "EVER_FEED_COUNT", "", "PRELOAD_FEED_COUNT", "PRELOAD_FEED_PRE_COUNT", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.preload.worker.a$a  reason: collision with other inner class name */
    public static final class C1258a {
        private C1258a() {
        }

        public /* synthetic */ C1258a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062 A[LOOP:0: B:4:0x0025->B:19:0x0062, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x005a A[EDGE_INSN: B:67:0x005a->B:16:0x005a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x008d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.plugin.finder.storage.FeedData r14, java.util.List<kotlin.o<com.tencent.mm.plugin.finder.model.bo, java.util.List<com.tencent.mm.protocal.protobuf.cjl>>> r15) {
        /*
        // Method dump skipped, instructions count: 471
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.preload.worker.a.a(com.tencent.mm.plugin.finder.storage.FeedData, java.util.List):void");
    }

    public static void auu(String str) {
        AppMethodBeat.i(249612);
        p.h(str, "mediaId");
        AppMethodBeat.o(249612);
    }
}
