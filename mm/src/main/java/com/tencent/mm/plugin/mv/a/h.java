package com.tencent.mm.plugin.mv.a;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0006\u0010\u001c\u001a\u00020\u0019J\u001e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020$J\u0018\u0010%\u001a\u0004\u0018\u00010!2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0006J\u0010\u0010&\u001a\u0004\u0018\u00010$2\u0006\u0010#\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R*\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017`\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/mv/model/MusicMvCgiRetCache;", "", "()V", "CacheTimeoutMs", "", "TAG", "", "enableCache", "", "getEnableCache", "()Z", "setEnableCache", "(Z)V", "finderFeedDetailCache", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCacheKey;", "Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCache;", "Lkotlin/collections/HashMap;", "musicPlayer", "com/tencent/mm/plugin/mv/model/MusicMvCgiRetCache$musicPlayer$1", "Lcom/tencent/mm/plugin/mv/model/MusicMvCgiRetCache$musicPlayer$1;", "mvRecommendListCache", "Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCacheKey;", "Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCache;", "destroy", "", "evictTimeoutCache", AppMeasurement.Param.TIMESTAMP, APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "putFinderFeedDetail", "feedId", "nonceId", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "putMvRecommendList", "songInfoBase64", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "tryGetCacheFinderFeedDetail", "tryGetCacheMvRecommendList", "plugin-mv_release"})
public final class h {
    public static final HashMap<c, b> Aqf = new HashMap<>();
    public static final HashMap<j, i> Aqg = new HashMap<>();
    private static final a Aqh = new a();
    public static final h Aqi = new h();
    public static boolean mxg = true;

    static {
        AppMethodBeat.i(256801);
        AppMethodBeat.o(256801);
    }

    private h() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x005f, code lost:
        if (r0 == null) goto L_0x0061;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.protocal.protobuf.ars V(long r10, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.a.h.V(long, java.lang.String):com.tencent.mm.protocal.protobuf.ars");
    }

    public final void Hs(long j2) {
        AppMethodBeat.i(256798);
        synchronized (this) {
            try {
                Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "evictTimeoutCache, timestamp:" + j2 + ", finderFeedDetailCache.size:" + Aqf.size() + ", mvRecommendListCache.size:" + Aqg.size());
                ArrayList<c> arrayList = new ArrayList();
                HashMap<c, b> hashMap = Aqf;
                synchronized (hashMap) {
                    try {
                        for (Map.Entry<c, b> entry : hashMap.entrySet()) {
                            if (j2 - entry.getValue().timestamp > 180000) {
                                arrayList.add(entry.getKey());
                            }
                        }
                        x xVar = x.SXb;
                    } finally {
                        AppMethodBeat.o(256798);
                    }
                }
                for (c cVar : arrayList) {
                    Aqf.remove(cVar);
                }
                ArrayList<j> arrayList2 = new ArrayList();
                HashMap<j, i> hashMap2 = Aqg;
                synchronized (hashMap2) {
                    try {
                        for (Map.Entry<j, i> entry2 : hashMap2.entrySet()) {
                            if (j2 - entry2.getValue().timestamp > 180000) {
                                arrayList2.add(entry2.getKey());
                            }
                        }
                        x xVar2 = x.SXb;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                for (j jVar : arrayList2) {
                    Aqg.remove(jVar);
                }
                Log.i("MicroMsg.Mv.MusicMvCgiRetCache", "finished evictTimeoutCache, finderFeedDetailCache.size:" + Aqf.size() + ", mvRecommendListCache.size:" + Aqg.size());
                x xVar3 = x.SXb;
            } finally {
                AppMethodBeat.o(256798);
            }
        }
    }

    public static void init() {
        AppMethodBeat.i(256799);
        Aqh.alive();
        AppMethodBeat.o(256799);
    }

    public static void destroy() {
        AppMethodBeat.i(256800);
        Aqf.clear();
        Aqg.clear();
        Aqh.dead();
        AppMethodBeat.o(256800);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/model/MusicMvCgiRetCache$musicPlayer$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-mv_release"})
    public static final class a extends IListener<mx> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(256797);
            mx mxVar2 = mxVar;
            if (mxVar2 != null && mxVar2.dSE.action == 2) {
                h hVar = h.Aqi;
                h.Aqf.clear();
                h hVar2 = h.Aqi;
                h.Aqg.clear();
            }
            AppMethodBeat.o(256797);
            return false;
        }
    }
}
