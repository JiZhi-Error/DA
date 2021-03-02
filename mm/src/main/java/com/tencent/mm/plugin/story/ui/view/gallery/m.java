package com.tencent.mm.plugin.story.ui.view.gallery;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.an.f;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.d.j;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.n;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005hijklB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00062\b\b\u0002\u00107\u001a\u00020\u0004H\u0002J\u001e\u00108\u001a\u0002092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020)0;2\b\b\u0002\u0010<\u001a\u00020\u0004J.\u0010=\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010\u00062\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020\u00042\b\b\u0002\u0010B\u001a\u000204H\u0002J\u0006\u0010C\u001a\u000209J\u000e\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020)J\u0018\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020)2\b\b\u0002\u0010A\u001a\u00020\u0004J\u000e\u0010H\u001a\u0002092\u0006\u0010G\u001a\u00020)J\u000e\u0010I\u001a\u00020J2\u0006\u0010E\u001a\u00020)J0\u0010K\u001a\u00020L2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0002J\u0006\u0010P\u001a\u00020\u0004J\u0006\u0010Q\u001a\u000204J\u0006\u0010B\u001a\u000204J\u0010\u0010R\u001a\u0002042\u0006\u0010E\u001a\u00020)H\u0002J\u000e\u0010S\u001a\u0002092\u0006\u0010T\u001a\u00020\u0015J\u000e\u0010U\u001a\u0002092\u0006\u0010E\u001a\u00020)J\u000e\u0010V\u001a\u0002092\u0006\u0010T\u001a\u00020\u0015J\u0010\u0010W\u001a\u0002042\u0006\u0010E\u001a\u00020)H\u0002J\u0012\u0010X\u001a\u0002092\b\u0010>\u001a\u0004\u0018\u00010\u0006H\u0002J&\u0010Y\u001a\u0002042\u0006\u0010E\u001a\u00020)2\u0006\u0010Z\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u0010[\u001a\u00020,J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002J4\u0010]\u001a\u0002042\u0012\u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0;0;2\u0006\u0010`\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u00042\b\b\u0002\u0010b\u001a\u000204J\u0010\u0010c\u001a\u0002092\u0006\u0010d\u001a\u000204H\u0002J\u0010\u0010e\u001a\u00020\u00042\u0006\u0010f\u001a\u00020\u0004H\u0002J\u0010\u0010g\u001a\u0002092\u0006\u0010>\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060%X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040'X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020)0'X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0004\n\u0002\u0010.R\u000e\u0010/\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000b¨\u0006m"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr;", "", "()V", "MAX_PRELOAD_TASK_LIMIT", "", "TAG", "", "clicfg_story_preload_force_canload", "getClicfg_story_preload_force_canload", "()I", "setClicfg_story_preload_force_canload", "(I)V", "clicfg_story_preload_force_preload", "getClicfg_story_preload_force_preload", "setClicfg_story_preload_force_preload", "clicfg_story_preload_strategy", "getClicfg_story_preload_strategy", "setClicfg_story_preload_strategy", "groupData", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "lastFinishStoryId", "", "getLastFinishStoryId", "()J", "setLastFinishStoryId", "(J)V", "lastStoryId", "getLastStoryId", "setLastStoryId", "playingMediaId", "preLoadConfig", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "getPreLoadConfig", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;", "setPreLoadConfig", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/PreLoadConfig;)V", "preloadFinishSet", "", "preloadInfoRatioSet", "", "preloadInfoSet", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "preloadRunningSet", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "runningMediaId", "Ljava/lang/Long;", "selectMediaId", "totalPreLoadOneItemSelect", "getTotalPreLoadOneItemSelect", "setTotalPreLoadOneItemSelect", "addPreLoadTask", "", "quota", "fromTag", "connectionCount", "addPreloadVideo", "", "videoItemList", "", "downloadExpect", "calcPreloadPercent", "mediaId", "media", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "cacheSecondsDowngrade", "isGoodNetwork", "cancelAllPreloadTask", "cancelPreloadTask", "videoItem", "checkCanPlay", "item", "checkPreLoad", "checkPreloadOnVideoPlay", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "url", "path", "preloadPercent", "getNetworkSpeed", "isBadNetwork", "isLocalVideo", "makrFinish", "storyId", "markCurrentPlay", "markOnVideoFirstFrameDraw", "needPreLoad", "onVideoSourceChange", "preloadVideoWithPercent", "percent", "taskInfo", "queryQuota", "setPreloadQueueFromGallery", "groupItems", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "positionH", "skipPosition", "startPreLoad", "checkNet", "taskConnectionCount", FirebaseAnalytics.b.INDEX, "upgrades", "GroupData", "MoovReadyInfo", "TaskInfo", "VideoPreloadTaskCallback", "VideoTaskCallTask", "plugin-story_release"})
public final class m {
    private static long FHA;
    public static final m FHB = new m();
    private static j FHn = new j();
    private static int FHo;
    private static int FHp;
    private static int FHq;
    private static final Map<String, j> FHr;
    private static final Map<String, Integer> FHs;
    private static final Set<String> FHt;
    private static final List<c> FHu;
    private static int FHv = 3;
    private static a FHw = new a(new ArrayList());
    private static volatile String FHx;
    private static volatile Long FHy;
    private static long FHz;
    private static long Ftw;

    static {
        AppMethodBeat.i(120574);
        Map<String, j> synchronizedMap = Collections.synchronizedMap(new HashMap());
        p.g(synchronizedMap, "Collections.synchronized…tring, StoryVideoItem>())");
        FHr = synchronizedMap;
        Map<String, Integer> synchronizedMap2 = Collections.synchronizedMap(new HashMap());
        p.g(synchronizedMap2, "Collections.synchronized…p(HashMap<String, Int>())");
        FHs = synchronizedMap2;
        Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet());
        p.g(synchronizedSet, "Collections.synchronizedSet(HashSet<String>())");
        FHt = synchronizedSet;
        List<c> synchronizedList = Collections.synchronizedList(new LinkedList());
        p.g(synchronizedList, "Collections.synchronized…t(LinkedList<TaskInfo>())");
        FHu = synchronizedList;
        AppMethodBeat.o(120574);
    }

    private m() {
    }

    public static final /* synthetic */ boolean n(j jVar) {
        AppMethodBeat.i(120577);
        boolean m = m(jVar);
        AppMethodBeat.o(120577);
        return m;
    }

    public static j fsu() {
        return FHn;
    }

    private static List<Integer> fsv() {
        AppMethodBeat.i(120550);
        if (fsy()) {
            List<Integer> list = FHn.FFY;
            AppMethodBeat.o(120550);
            return list;
        }
        List<Integer> list2 = FHn.FFX;
        AppMethodBeat.o(120550);
        return list2;
    }

    public static /* synthetic */ boolean e(List list, int i2, int i3) {
        AppMethodBeat.i(120552);
        boolean d2 = d(list, i2, i3);
        AppMethodBeat.o(120552);
        return d2;
    }

    private static boolean d(List<? extends List<h>> list, int i2, int i3) {
        boolean z;
        h hVar;
        j jVar;
        AppMethodBeat.i(120551);
        p.h(list, "groupItems");
        Log.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery, galleryItems size:" + list.size() + ", positionV:" + i2 + "  positionH:" + i3 + ", skipPosition:true");
        a aVar = FHw;
        p.h(list, "galleryItems");
        if (aVar.hC(list)) {
            z = false;
        } else if (aVar.FHK == i3 && aVar.FHJ == i2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(120551);
        } else {
            if (i2 >= 0 && i3 >= 0 && i2 < list.size() && i3 < ((List) list.get(i2)).size() && (hVar = (h) ((List) list.get(i2)).get(i3)) != null && (jVar = hVar.FoT) != null) {
                FHz = jVar.edx;
            }
            Ftw = 0;
            FHv = 0;
            FHw = new a(list, i2, i3, FHw, true);
            ArrayList arrayList = new ArrayList();
            List<? extends List<h>> list2 = list;
            synchronized (list2) {
                try {
                    int i4 = 0;
                    for (T t : list2) {
                        int i5 = i4 + 1;
                        if (i4 < 0) {
                            kotlin.a.j.hxH();
                        }
                        T t2 = t;
                        if (i4 >= i2 && t2.size() > 0) {
                            arrayList.add(Integer.valueOf(((h) t2.get(0)).FoT.ecf));
                        }
                        i4 = i5;
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(120551);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (i2 < list.size() && i3 < ((List) list.get(i2)).size()) {
                int size = ((List) list.get(i2)).size();
                while (i3 < size) {
                    arrayList2.add(Integer.valueOf(((h) ((List) list.get(i2)).get(i3)).FoT.ecf));
                    i3++;
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (T t3 : FHu) {
                T t4 = t3;
                if (!arrayList.contains(Integer.valueOf(t4.FHP.ecf)) && !arrayList2.contains(Integer.valueOf(t4.FHP.ecf))) {
                    arrayList3.add(t3);
                }
            }
            ArrayList<c> arrayList4 = arrayList3;
            synchronized (arrayList4) {
                try {
                    for (c cVar : arrayList4) {
                        l(cVar.FHP);
                    }
                    x xVar2 = x.SXb;
                } finally {
                    AppMethodBeat.o(120551);
                }
            }
            FHo = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_preload_strategy, 1);
            int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_preload_speed_good, 450);
            int a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_preload_speed_bad, 200);
            FHp = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_preload_force_preload, 0);
            FHq = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_preload_force_canload, 100);
            FHn.FFV = a2;
            FHn.FFW = a3;
            int recentAverageSpeed = CdnLogic.getRecentAverageSpeed(2);
            Log.i("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery clicfg_story_preload_strategy " + FHo + " clicfg_story_preload_speed_good:" + a2 + " clicfg_story_preload_speed_bad:" + a3 + " clicfg_story_preload_force_preload " + FHp + "  clicfg_story_preload_force_canload: " + FHq + " speed:" + recentAverageSpeed);
            if (recentAverageSpeed > 0 && FHq > 0 && recentAverageSpeed < FHq) {
                Log.w("MicroMsg.StoryVideoPreloadMgr", "setPreloadQueueFromGallery speed too low then pass " + recentAverageSpeed + " clicfg_story_preload_force_canload: " + FHq);
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(FHu);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    l(((c) it.next()).FHP);
                }
            }
        }
        return false;
    }

    public final void KD(long j2) {
        AppMethodBeat.i(120553);
        if (Ftw == j2) {
            AppMethodBeat.o(120553);
            return;
        }
        Ftw = j2;
        if (FHo == 0) {
            AppMethodBeat.o(120553);
            return;
        }
        a aVar = FHw;
        if (aVar != null) {
            aVar.fsE();
        }
        wc(true);
        AppMethodBeat.o(120553);
    }

    public final void KE(long j2) {
        AppMethodBeat.i(120554);
        Long l = FHy;
        if (l != null && l.longValue() == j2) {
            FHy = 0L;
        }
        if (FHA == j2) {
            AppMethodBeat.o(120554);
            return;
        }
        FHA = j2;
        if (FHo == 0) {
            AppMethodBeat.o(120554);
        } else if (FHq == 0) {
            AppMethodBeat.o(120554);
        } else if (FHu.size() > 0) {
            AppMethodBeat.o(120554);
        } else {
            a aVar = FHw;
            if (aVar != null) {
                aVar.fsE();
            }
            wc(false);
            AppMethodBeat.o(120554);
        }
    }

    public final void h(j jVar) {
        AppMethodBeat.i(120555);
        p.h(jVar, "item");
        Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad " + jVar + ' ' + MMStack.getCaller());
        if (i(jVar)) {
            Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay isLocalVideo");
            wc(false);
            AppMethodBeat.o(120555);
        } else if (c(jVar) == 1) {
            Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreLoad checkCanPlay true");
            wc(true);
            AppMethodBeat.o(120555);
        } else {
            if (FHp == 1) {
                wc(true);
            }
            Log.i("MicroMsg.StoryVideoPreloadMgr", "nothing can checkPreLoad");
            AppMethodBeat.o(120555);
        }
    }

    private static int c(j jVar) {
        AppMethodBeat.i(120556);
        p.h(jVar, "item");
        s sVar = s.Fny;
        n a2 = s.a(jVar);
        if (a2.frQ()) {
            Log.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay downloadFinish " + jVar.edx);
            AppMethodBeat.o(120556);
            return 1;
        } else if (a2.field_totalSize <= 0) {
            AppMethodBeat.o(120556);
            return 0;
        } else if ((((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) * 100.0f >= ((float) FHn.FFU)) {
            Log.v("MicroMsg.StoryVideoPreloadMgr", "z checkCanPlay cachesize " + a2.field_cacheSize + " totalSize: " + a2.field_totalSize);
            AppMethodBeat.o(120556);
            return 1;
        } else {
            AppMethodBeat.o(120556);
            return 0;
        }
    }

    private final void wc(boolean z) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(120557);
        boolean fsx = fsx();
        boolean fsy = fsy();
        int recentAverageSpeed = CdnLogic.getRecentAverageSpeed(2);
        if (!z || recentAverageSpeed <= 0 || FHq <= 0 || recentAverageSpeed >= FHq) {
            int i4 = 0;
            if (fsy) {
                i2 = 1;
            } else {
                i2 = 3;
            }
            if (FHo != 1) {
                i3 = i2;
            }
            Log.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue, isGoodNetwork:" + fsx + ", isBadNetwork:" + fsy + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + FHu.size() + " maxTaskNum " + i3 + " totalPreLoadOneItemSelect " + FHv + " checkNet " + z + " callerFrom " + MMStack.getCaller());
            List<Integer> fsv = fsv();
            while (FHu.size() < i3 && i4 < fsv.size() && FHv < 3 && u(fsv.get(i4).intValue(), "startPreLoad", abh(i4))) {
                FHv++;
                i4++;
            }
            Log.i("MicroMsg.StoryVideoPreloadMgr", "startPreloadQueue finish loop preload queue, current queue size: " + FHu.size() + ", pullPreloadTaskNum:0, preloadVideoNum:" + i4 + " preloadRunningSet " + FHu.size() + " totalPreLoadOneItemSelect " + FHv + ' ');
            AppMethodBeat.o(120557);
            return;
        }
        Log.w("MicroMsg.StoryVideoPreloadMgr", "speed too low then pass " + recentAverageSpeed + " clicfg_story_preload_force_canload: " + FHq + " callerFrom " + MMStack.getCaller());
        AppMethodBeat.o(120557);
    }

    private static /* synthetic */ boolean a(m mVar, int i2, String str) {
        AppMethodBeat.i(120559);
        boolean u = mVar.u(i2, str, 1);
        AppMethodBeat.o(120559);
        return u;
    }

    private final boolean u(int i2, String str, int i3) {
        T t;
        String str2;
        AppMethodBeat.i(120558);
        while (true) {
            m mVar = this;
            a aVar = FHw;
            o<j, c> oVar = null;
            for (int i4 = 0; i4 < aVar.FHI.size() && oVar == null; i4++) {
                oVar = aVar.fsD();
                Log.i(a.TAG, "produceVideoItem walkVertical:" + aVar.FHD + "  walkHorizontal:" + aVar.FHE + " positionV:" + aVar.FHJ + " positionH:" + aVar.FHK + ", ret:" + oVar);
            }
            if (oVar == null) {
                AppMethodBeat.o(120558);
                return false;
            }
            A a2 = oVar.first;
            String str3 = oVar.second.jpT;
            StringBuilder append = new StringBuilder("try preload mediaId ").append(str3).append(" videoItem:").append((Object) a2).append(" pos:").append((Object) oVar.second).append("  groupinfo ");
            a aVar2 = FHw;
            Log.i("MicroMsg.StoryVideoPreloadMgr", append.append("positionV:" + aVar2.FHJ + ", positionH:" + aVar2.FHK + ", walkVertical:" + aVar2.FHD + ", walkHorizontal:" + aVar2.FHE).append(" quota:").append(i2).append("  fromTag:").append(str).toString());
            Iterator<T> it = FHu.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                if (p.j(next.jpT, str3)) {
                    t = next;
                    break;
                }
            }
            T t2 = t;
            if (t2 == null || i2 > t2.gsw) {
                if (!(str3.length() == 0)) {
                    str2 = str3;
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    int a3 = a(str3, a2.Fpd, i2, fsx());
                    s sVar = s.Fny;
                    n a4 = s.a((j) a2);
                    if (a4.frQ() || (((float) a4.field_cacheSize) / ((float) a4.field_totalSize)) * 100.0f >= ((float) a3)) {
                        Log.i("MicroMsg.StoryVideoPreloadMgr", "pull preload video, " + str3 + ", already reach cache size! cacheSize:" + a4.field_cacheSize + ", totalSize:" + a4.field_totalSize + ", cachePercent:" + ((((float) a4.field_cacheSize) / ((float) a4.field_totalSize)) * 100.0f) + "  fromTag:" + str);
                    } else if (mVar.a(a2, a3, i3, oVar.second)) {
                        oVar.second.gsw = i2;
                        AppMethodBeat.o(120558);
                        return true;
                    }
                } else {
                    continue;
                }
            } else {
                Log.i("MicroMsg.StoryVideoPreloadMgr", "no need add quota " + i2 + " cur:" + t2.gsw + " fromTag:" + str);
            }
        }
    }

    public static /* synthetic */ void a(m mVar, List list) {
        AppMethodBeat.i(222928);
        mVar.C(list, 0);
        AppMethodBeat.o(222928);
    }

    public final void C(List<j> list, int i2) {
        int intValue;
        T t;
        AppMethodBeat.i(120560);
        p.h(list, "videoItemList");
        Log.printInfoStack("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList " + list.size(), new Object[0]);
        Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, isGoodNetwork:" + fsx() + ", isBadNetwork:" + fsy() + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2) + " preloadRunningSet " + FHu.size() + " downloadExpect " + i2);
        List<Integer> fsv = fsv();
        int i3 = 0;
        List<j> list2 = list;
        synchronized (list2) {
            try {
                for (T t2 : list2) {
                    if (m(t2)) {
                        if (i2 > 0) {
                            intValue = i2;
                        } else {
                            intValue = i3 < fsv.size() ? fsv.get(i3).intValue() : ((Number) kotlin.a.j.ku(fsv)).intValue();
                        }
                        int abh = abh(i3);
                        s sVar = s.Fny;
                        String cs = s.cs(t2.iXu, t2.Fpd.Url);
                        int a2 = a(cs, t2.Fpd, intValue, fsx());
                        s sVar2 = s.Fny;
                        n a3 = s.a((j) t2);
                        Iterator<T> it = FHu.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                t = null;
                                break;
                            }
                            t = it.next();
                            if (p.j(t.jpT, cs)) {
                                break;
                            }
                        }
                        if (t != null) {
                            Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + cs + ", already prealoding!");
                        } else if (a3.frQ() || (((float) a3.field_cacheSize) / ((float) a3.field_totalSize)) * 100.0f >= ((float) a2)) {
                            Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo withList, " + cs + ", already reach cache size! cacheSize:" + a3.field_cacheSize + ", totalSize:" + a3.field_totalSize + ", cachePercent:" + ((((float) a3.field_cacheSize) / ((float) a3.field_totalSize)) * 100.0f));
                        } else if (FHB.a(t2, a2, abh, new c(0, i3, t2, intValue, abh))) {
                            i3++;
                        }
                    }
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(120560);
                throw th;
            }
        }
        Log.i("MicroMsg.StoryVideoPreloadMgr", "finish addPreloadVideo withList, total pull video task:" + i3 + " preloadRunningSet " + FHu.size());
        AppMethodBeat.o(120560);
    }

    private static boolean i(j jVar) {
        AppMethodBeat.i(120562);
        if (jVar.foV()) {
            AppMethodBeat.o(120562);
            return true;
        }
        s sVar = s.Fny;
        if (com.tencent.mm.vfs.s.boW(s.a(jVar.Fpd)) > 0) {
            Log.i("MicroMsg.StoryVideoPreloadMgr", "isLocalVideo video downloadDone " + jVar.Fpd.taskId + " username:" + jVar.username);
            AppMethodBeat.o(120562);
            return true;
        }
        s sVar2 = s.Fny;
        if (s.a(jVar).frQ()) {
            Log.i("MicroMsg.StoryVideoPreloadMgr", " isLocalVideo video download finish " + jVar.Fpd.taskId + " username:" + jVar.username);
            AppMethodBeat.o(120562);
            return true;
        }
        AppMethodBeat.o(120562);
        return false;
    }

    private synchronized boolean a(j jVar, int i2, int i3, c cVar) {
        boolean z;
        int i4;
        AppMethodBeat.i(120563);
        p.h(jVar, "videoItem");
        p.h(cVar, "taskInfo");
        if (jVar.foV() || Util.isNullOrNil(jVar.Fpd.Url)) {
            AppMethodBeat.o(120563);
            z = false;
        } else if (i(jVar)) {
            Log.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, isLocalVideo: " + jVar.Fpd.Url);
            AppMethodBeat.o(120563);
            z = false;
        } else {
            String str = jVar.Fpd.Url;
            String str2 = cVar.jpT;
            s sVar = s.Fny;
            n a2 = s.a(jVar);
            Log.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent, " + str2 + ", " + i2 + ", playingMediaId:" + FHx + ", " + a2.field_filePath + ", " + str + "  videoCache " + a2);
            if (str2 == null || kotlin.n.n.I(FHx, str2, false)) {
                AppMethodBeat.o(120563);
                z = false;
            } else {
                s sVar2 = s.Fny;
                com.tencent.mm.vfs.s.boN(s.aSc(jVar.username));
                p.g(str, "url");
                String str3 = a2.field_filePath;
                p.g(str3, "videoCache.field_filePath");
                Log.i("MicroMsg.StoryVideoPreloadMgr", "createVideoPreloadCDNTask, mediaId:" + str2 + ", path:" + str3 + ", url:" + str + ", preloadPercent:" + i2 + ", connectionCount:" + i3);
                com.tencent.mm.i.h hVar = new com.tencent.mm.i.h();
                hVar.taskName = "task_StoryVideoPreloadMgr";
                hVar.field_mediaId = str2;
                hVar.url = str;
                hVar.gqO = 2;
                hVar.gqU = 2;
                hVar.gqP = 6;
                hVar.gqZ = i2;
                hVar.field_preloadRatio = i2;
                hVar.concurrentCount = 4;
                hVar.field_fullpath = str3;
                hVar.gqy = new e();
                hVar.gqQ = new d(Util.currentTicks());
                hVar.connectionCount = i3;
                hVar.field_fileType = com.tencent.mm.i.a.gpV;
                hVar.field_requestVideoFormat = com.tencent.mm.modelcontrol.e.L(2, str3);
                f.baQ().e(hVar);
                Log.i("MicroMsg.StoryVideoPreloadMgr", "preloadVideoWithPercent:" + hVar + ", currentSpeed:" + CdnLogic.getRecentAverageSpeed(2));
                FHr.put(str2, jVar);
                FHs.put(str2, Integer.valueOf(i2));
                Iterator<c> it = FHu.iterator();
                int i5 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i4 = -1;
                        break;
                    } else if (p.j(it.next().jpT, cVar.jpT)) {
                        i4 = i5;
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i4 > 0) {
                    FHu.set(i4, cVar);
                } else {
                    FHu.add(cVar);
                }
                FHt.remove(str2);
                z = true;
                AppMethodBeat.o(120563);
            }
        }
        return z;
    }

    private static int abh(int i2) {
        AppMethodBeat.i(120564);
        Log.i("MicroMsg.StoryVideoPreloadMgr", "taskConnectionCount: ".concat(String.valueOf(i2)));
        List<Integer> list = FHn.FFZ;
        if (i2 >= FHn.FFZ.size()) {
            i2 = FHn.FFZ.size() - 1;
        }
        int intValue = list.get(i2).intValue();
        AppMethodBeat.o(120564);
        return intValue;
    }

    public static void j(j jVar) {
        T t;
        AppMethodBeat.i(120565);
        p.h(jVar, "videoItem");
        s sVar = s.Fny;
        String cs = s.cs(jVar.iXu, jVar.Fpd.Url);
        FHx = cs;
        FHy = Long.valueOf(jVar.edx);
        Log.i("MicroMsg.StoryVideoPreloadMgr", "markCurrentPlay:" + FHx + " then remove it from preload");
        Iterator<T> it = FHu.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (p.j(cs, next.jpT)) {
                t = next;
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            FHu.remove(t2);
            l(t2.FHP);
            AppMethodBeat.o(120565);
            return;
        }
        AppMethodBeat.o(120565);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$MoovReadyInfo;", "", "isMoovReady", "", "offset", "", "length", "preloadFinish", "(ZJJZ)V", "()Z", "getLength", "()J", "getOffset", "getPreloadFinish", "component1", "component2", "component3", "component4", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-story_release"})
    public static final class b {
        final boolean FHO;
        final long length;
        final long offset;
        final boolean uTW;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (!(this.uTW == bVar.uTW && this.offset == bVar.offset && this.length == bVar.length && this.FHO == bVar.FHO)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i2 = 1;
            boolean z = this.uTW;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            long j2 = this.offset;
            long j3 = this.length;
            int i6 = ((((i3 * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            boolean z2 = this.FHO;
            if (!z2) {
                i2 = z2 ? 1 : 0;
            }
            return i6 + i2;
        }

        public final String toString() {
            AppMethodBeat.i(120545);
            String str = "MoovReadyInfo(isMoovReady=" + this.uTW + ", offset=" + this.offset + ", length=" + this.length + ", preloadFinish=" + this.FHO + ")";
            AppMethodBeat.o(120545);
            return str;
        }

        public b(boolean z, long j2, long j3, boolean z2) {
            this.uTW = z;
            this.offset = j2;
            this.length = j3;
            this.FHO = z2;
        }
    }

    public static b k(j jVar) {
        AppMethodBeat.i(120566);
        p.h(jVar, "videoItem");
        s sVar = s.Fny;
        String cs = s.cs(jVar.iXu, jVar.Fpd.Url);
        Log.i("MicroMsg.StoryVideoPreloadMgr", "checkPreloadOnVideoPlay:".concat(String.valueOf(cs)));
        s sVar2 = s.Fny;
        n a2 = s.a(jVar);
        if (a2.field_cacheSize <= 0 || a2.field_totalSize <= 0) {
            Log.i("MicroMsg.StoryVideoPreloadMgr", cs + " not hit cache or moov not ready");
            b bVar = new b(false, 0, 0, false);
            AppMethodBeat.o(120566);
            return bVar;
        }
        Log.i("MicroMsg.StoryVideoPreloadMgr", "hit cache, mediaId:" + cs + ", cachePercent:" + (((float) a2.field_cacheSize) / ((float) a2.field_totalSize)) + ", filePath:" + a2.field_filePath);
        String str = a2.field_filePath;
        CdnLogic.C2CDownloadRequest c2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
        long[] jArr = new long[2];
        c2CDownloadRequest.fileKey = cs;
        c2CDownloadRequest.fileType = 6;
        c2CDownloadRequest.url = jVar.Fpd.Url;
        c2CDownloadRequest.setSavePath(str);
        c2CDownloadRequest.requestVideoFormat = com.tencent.mm.modelcontrol.e.L(1, str);
        Log.i("MicroMsg.StoryVideoPreloadMgr", cs + " queryMoovReady: " + CdnLogic.queryVideoMoovInfo(c2CDownloadRequest, jArr) + ", offset:" + jArr[0] + ", length:" + jArr[1] + ", preloadFinish:" + kotlin.a.j.a(FHt, cs));
        b bVar2 = new b(true, jArr[0], jArr[1], kotlin.a.j.a(FHt, cs));
        AppMethodBeat.o(120566);
        return bVar2;
    }

    private static void l(j jVar) {
        T t;
        AppMethodBeat.i(120567);
        p.h(jVar, "videoItem");
        s sVar = s.Fny;
        String cs = s.cs(jVar.iXu, jVar.Fpd.Url);
        Log.i("MicroMsg.StoryVideoPreloadMgr", "cancelPreloadTask, videoItem:".concat(String.valueOf(cs)));
        f.baQ().Oc(cs);
        Iterator<T> it = FHu.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (p.j(next.jpT, cs)) {
                t = next;
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            FHu.remove(t2);
            if (FHv > 0) {
                FHv--;
            }
            AppMethodBeat.o(120567);
            return;
        }
        AppMethodBeat.o(120567);
    }

    public static void fsw() {
        AppMethodBeat.i(120568);
        Log.printInfoStack("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask", new Object[0]);
        for (String str : FHr.keySet()) {
            Log.i("MicroMsg.StoryVideoPreloadMgr", "cancelAllPreloadTask ".concat(String.valueOf(str)));
            f.baQ().Oc(str);
        }
        FHr.clear();
        FHs.clear();
        FHw = new a(new ArrayList());
        FHu.clear();
        AppMethodBeat.o(120568);
    }

    private static int a(String str, edt edt, int i2, boolean z) {
        int max;
        AppMethodBeat.i(120569);
        float f2 = edt.Ned;
        Log.i("MicroMsg.StoryVideoPreloadMgr", "calcPreloadPercent, cacheSecondsDowngrade:" + i2 + ", mediaId:" + str + ", duration:" + f2 + ", isGoodNetwork:" + z + " media:" + edt.Ned);
        int i3 = z ? 5 : 3;
        if (f2 <= 0.0f) {
            max = FHn.FFU;
        } else if (f2 > ((float) i3) || i2 > 0) {
            max = (int) (((double) (((float) Math.max(3, i2)) / f2)) * 100.0d);
        } else {
            max = 100;
        }
        if (max <= FHn.FFU) {
            max = FHn.FFU;
        }
        AppMethodBeat.o(120569);
        return max;
    }

    private static boolean fsy() {
        AppMethodBeat.i(120571);
        int i2 = FHn.FFW;
        int recentAverageSpeed = CdnLogic.getRecentAverageSpeed(2);
        if (1 <= recentAverageSpeed && i2 >= recentAverageSpeed) {
            AppMethodBeat.o(120571);
            return true;
        }
        AppMethodBeat.o(120571);
        return false;
    }

    public static int fsz() {
        AppMethodBeat.i(259988);
        int recentAverageSpeed = CdnLogic.getRecentAverageSpeed(2);
        AppMethodBeat.o(259988);
        return recentAverageSpeed;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "()V", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
    public static final class e implements g.a {
        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return new byte[0];
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
            String str2;
            String str3;
            AppMethodBeat.i(120549);
            if (dVar == null || dVar.field_retCode != -21112) {
                if (cVar != null && cVar.field_toltalLength > 0) {
                    m mVar = m.FHB;
                    j jVar = (j) m.FHr.get(str);
                    m mVar2 = m.FHB;
                    boolean a2 = kotlin.a.j.a(m.FHt, str);
                    int i3 = (int) ((((float) cVar.field_finishedLength) / ((float) cVar.field_toltalLength)) * 100.0f);
                    m mVar3 = m.FHB;
                    Integer num = (Integer) m.FHs.get(str);
                    int intValue = num != null ? num.intValue() : 0;
                    String str4 = hashCode() + " onPreload, mediaId:" + str + ", startRet:" + i2 + ", preloadOffset:" + cVar.field_finishedLength + ", totalLength: " + cVar.field_toltalLength + " desiredPreloadPercent:" + intValue + ", preloadPercent:" + i3 + " isFinish:" + a2;
                    boolean z2 = false;
                    if (intValue <= 0 || i3 < intValue) {
                        str2 = str4;
                    } else {
                        str2 = str4 + " exceed:true ";
                        z2 = true;
                    }
                    if (jVar != null) {
                        s sVar = s.Fny;
                        n a3 = s.a(jVar);
                        a3.field_cacheSize = (int) cVar.field_finishedLength;
                        a3.field_totalSize = (int) cVar.field_toltalLength;
                        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                        j.b.fog().b(a3);
                        j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
                        com.tencent.mm.plugin.story.i.f aRS = j.b.fod().aRS(jVar.username);
                        if (aRS.field_syncId == jVar.edx && aRS.isValid()) {
                            long j2 = jVar.edx;
                            String str5 = jVar.Fpd.Id;
                            p.g(str5, "videoItem.media.Id");
                            if (aRS.b(j2, str5, a3.field_cacheSize)) {
                                str2 = str2 + " * ext pre update * ";
                                j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
                                j.b.fod().a((long) ((int) aRS.systemRowid), aRS);
                            }
                        }
                        if (z2 && str != null) {
                            m mVar4 = m.FHB;
                            m.FHt.add(str);
                        }
                        str3 = str2 + "update cacheSize done";
                    } else {
                        str3 = str2;
                    }
                    StringBuilder append = new StringBuilder().append(str3).append(", currentSpeed:");
                    m mVar5 = m.FHB;
                    Log.i("MicroMsg.StoryVideoPreloadMgr", append.append(m.fsz()).toString());
                }
                AppMethodBeat.o(120549);
                return 0;
            }
            Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreload, mediaId:" + str + ", video source change!");
            m mVar6 = m.FHB;
            m.aSE(str);
            AppMethodBeat.o(120549);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$VideoPreloadTaskCallback;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "startTick", "", "(J)V", "onPreloadCompleted", "", "mediaId", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-story_release"})
    public static final class d implements g.b {
        private final long gXF;

        public d(long j2) {
            this.gXF = j2;
        }

        @Override // com.tencent.mm.i.g.b
        public final void b(String str, com.tencent.mm.i.d dVar) {
            AppMethodBeat.i(120548);
            Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + str + ", sceneResult:" + dVar);
            if (dVar == null || dVar.field_retCode != -21112) {
                if (!(str == null || dVar == null)) {
                    m mVar = m.FHB;
                    if (m.FHr.containsKey(str)) {
                        m mVar2 = m.FHB;
                        com.tencent.mm.plugin.story.f.d.j jVar = (com.tencent.mm.plugin.story.f.d.j) m.FHr.get(str);
                        if (jVar != null) {
                            if (dVar.field_recvedBytes <= 0 || dVar.field_fileLength <= 0) {
                                Log.e("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted error, recvedBytes:" + dVar.field_recvedBytes + ", fileLength:" + dVar.field_fileLength);
                            } else {
                                s sVar = s.Fny;
                                n a2 = s.a(jVar);
                                a2.field_cacheSize = (int) dVar.field_recvedBytes;
                                a2.field_totalSize = (int) dVar.field_fileLength;
                                j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                                j.b.fog().b(a2);
                                m mVar3 = m.FHB;
                                m.FHt.add(str);
                                Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted update cacheSize:" + a2.field_cacheSize + ", totalSize:" + a2.field_totalSize + ", preloadCost:" + Util.ticksToNow(this.gXF));
                                com.tencent.mm.ac.d.h(new a(str));
                                AppMethodBeat.o(120548);
                                return;
                            }
                        }
                    }
                }
                AppMethodBeat.o(120548);
                return;
            }
            Log.i("MicroMsg.StoryVideoPreloadMgr", hashCode() + " onPreloadCompleted, mediaId:" + str + ", video source change!");
            m mVar4 = m.FHB;
            m.aSE(str);
            AppMethodBeat.o(120548);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ String qWs;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str) {
                super(0);
                this.qWs = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(120547);
                m.a(m.FHB, this.qWs);
                x xVar = x.SXb;
                AppMethodBeat.o(120547);
                return xVar;
            }
        }
    }

    private static boolean m(com.tencent.mm.plugin.story.f.d.j jVar) {
        AppMethodBeat.i(120573);
        if (i(jVar) || jVar.foV()) {
            Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo fail, " + jVar + " isLocalVideo or fake video");
            AppMethodBeat.o(120573);
            return false;
        }
        s sVar = s.Fny;
        String cs = s.cs(jVar.iXu, jVar.Fpd.Url);
        if (Util.isNullOrNil(cs) || Util.isNullOrNil(jVar.Fpd.Url) || kotlin.n.n.I(FHx, cs, false)) {
            Log.i("MicroMsg.StoryVideoPreloadMgr", "addPreloadVideo:" + cs + ", already request preload or url " + jVar.Fpd.Url);
            AppMethodBeat.o(120573);
            return false;
        }
        AppMethodBeat.o(120573);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0006\u0010\u001a\u001a\u00020\u000bR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "", "positionV", "", "positionH", "item", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "quota", "connectionCount", "(IILcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;II)V", "cdnMediaId", "", "getCdnMediaId", "()Ljava/lang/String;", "setCdnMediaId", "(Ljava/lang/String;)V", "getConnectionCount", "()I", "setConnectionCount", "(I)V", "getItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getPositionH", "getPositionV", "getQuota", "setQuota", "info", "plugin-story_release"})
    public static final class c {
        private final int FHJ;
        private final int FHK;
        final com.tencent.mm.plugin.story.f.d.j FHP;
        private int connectionCount;
        int gsw;
        String jpT;

        public /* synthetic */ c(int i2, int i3, com.tencent.mm.plugin.story.f.d.j jVar) {
            this(i2, i3, jVar, 0, 1);
        }

        public c(int i2, int i3, com.tencent.mm.plugin.story.f.d.j jVar, int i4, int i5) {
            p.h(jVar, "item");
            AppMethodBeat.i(120546);
            this.FHJ = i2;
            this.FHK = i3;
            this.FHP = jVar;
            this.gsw = i4;
            this.connectionCount = i5;
            s sVar = s.Fny;
            String cs = s.cs(this.FHP.iXu, this.FHP.Fpd.Url);
            this.jpT = cs == null ? "" : cs;
            AppMethodBeat.o(120546);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B=\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0000\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u001c\u0010\u001b\u001a\u00020\n2\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003H\u0002J*\u0010\u001c\u001a\u00020\n2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0002J\u0016\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0002J\u0016\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0002J\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012J\b\u0010\"\u001a\u00020#H\u0002J\u0006\u0010$\u001a\u00020#R\u000e\u0010\f\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00120\u00110\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000ej\b\u0012\u0004\u0012\u00020\u0004`\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "", "groupItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "", "positionH", "lastGroup", "skipPosition", "", "(Ljava/util/List;IILcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;Z)V", "MAX_PRELOAD_COUNT", "horizontalList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "produceList", "Lkotlin/Function0;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "verticalList", "walkHorizontal", "walkIndex", "walkVertical", "info", "", "isDataChange", "isSame", "galleryItems", "produce", "produceHorizontalVideoItem", "produceVerticalVideoItem", "produceVideoItem", "reset", "", "resetWalk", "Companion", "plugin-story_release"})
    public static final class a {
        public static final C1786a FHM = new C1786a((byte) 0);
        static final String TAG = TAG;
        private final int FHC;
        int FHD;
        int FHE;
        private int FHF;
        private ArrayList<h> FHG;
        private ArrayList<h> FHH;
        List<? extends kotlin.g.a.a<o<com.tencent.mm.plugin.story.f.d.j, c>>> FHI;
        int FHJ;
        int FHK;
        private final boolean FHL;

        public /* synthetic */ a(List list) {
            this(list, 0, 0, null, true);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: java.util.ArrayList<com.tencent.mm.plugin.story.f.d.h> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends List<h>> list, int i2, int i3, a aVar, boolean z) {
            p.h(list, "groupItems");
            AppMethodBeat.i(222927);
            this.FHJ = i2;
            this.FHK = i3;
            this.FHL = true;
            this.FHC = 15;
            this.FHG = new ArrayList<>();
            this.FHH = new ArrayList<>();
            this.FHI = kotlin.a.j.listOf((Object[]) new kotlin.g.a.a[]{new b(this), new c(this), new d(this)});
            if (!(aVar == null || this.FHJ == aVar.FHJ) || (!(aVar == null || this.FHK == aVar.FHK) || hC(list))) {
                reset();
            }
            this.FHG.clear();
            this.FHH.clear();
            List<? extends List<h>> list2 = list;
            synchronized (list2) {
                try {
                    for (T t : list2) {
                        if (!t.isEmpty()) {
                            this.FHH.add(t.get(0));
                        }
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(222927);
                }
            }
            if (this.FHJ < list.size()) {
                Iterable<h> iterable = (Iterable) list.get(this.FHJ);
                synchronized (iterable) {
                    try {
                        for (h hVar : iterable) {
                            this.FHG.add(hVar);
                        }
                        x xVar2 = x.SXb;
                    } finally {
                        AppMethodBeat.o(222927);
                    }
                }
                return;
            }
            AppMethodBeat.o(222927);
        }

        public static final /* synthetic */ o a(a aVar) {
            AppMethodBeat.i(120543);
            o<com.tencent.mm.plugin.story.f.d.j, c> fsF = aVar.fsF();
            AppMethodBeat.o(120543);
            return fsF;
        }

        public static final /* synthetic */ o b(a aVar) {
            AppMethodBeat.i(120544);
            o<com.tencent.mm.plugin.story.f.d.j, c> fsG = aVar.fsG();
            AppMethodBeat.o(120544);
            return fsG;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.m$a$a  reason: collision with other inner class name */
        public static final class C1786a {
            private C1786a() {
            }

            public /* synthetic */ C1786a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(120542);
            AppMethodBeat.o(120542);
        }

        /* access modifiers changed from: package-private */
        public final o<com.tencent.mm.plugin.story.f.d.j, c> fsD() {
            AppMethodBeat.i(120536);
            try {
                if (this.FHF > this.FHC) {
                    Log.i(TAG, "stop preload now " + this.FHF);
                    AppMethodBeat.o(120536);
                    return null;
                }
                o<com.tencent.mm.plugin.story.f.d.j, c> oVar = (o) ((kotlin.g.a.a) this.FHI.get(this.FHF % this.FHI.size())).invoke();
                this.FHF++;
                AppMethodBeat.o(120536);
                return oVar;
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "error on produce", new Object[0]);
                AppMethodBeat.o(120536);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean hC(List<? extends List<h>> list) {
            AppMethodBeat.i(120537);
            if (list.size() == this.FHH.size()) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (((List) list.get(i2)).isEmpty()) {
                        AppMethodBeat.o(120537);
                        return true;
                    } else if (this.FHH.get(i2).FoT.ecf != ((h) ((List) list.get(i2)).get(0)).FoT.ecf) {
                        AppMethodBeat.o(120537);
                        return true;
                    }
                }
                AppMethodBeat.o(120537);
                return false;
            }
            AppMethodBeat.o(120537);
            return true;
        }

        private final void reset() {
            this.FHD = this.FHJ;
            this.FHE = this.FHK;
            this.FHF = 0;
        }

        public final void fsE() {
            AppMethodBeat.i(120538);
            Log.i(TAG, "resetWalk");
            reset();
            AppMethodBeat.o(120538);
        }

        private final o<com.tencent.mm.plugin.story.f.d.j, c> fsF() {
            AppMethodBeat.i(120539);
            while (true) {
                if (this.FHL) {
                    this.FHD++;
                }
                if (this.FHD >= this.FHH.size()) {
                    AppMethodBeat.o(120539);
                    return null;
                }
                try {
                    if (this.FHH.size() > 0) {
                        com.tencent.mm.plugin.story.f.d.j jVar = this.FHH.get(this.FHD).FoT;
                        m mVar = m.FHB;
                        com.tencent.mm.plugin.story.f.d.j jVar2 = m.n(jVar) ? jVar : null;
                        if (jVar2 != null) {
                            return new o<>(jVar2, new c(this.FHD, 0, jVar2));
                        }
                    }
                    if (!this.FHL) {
                        this.FHD++;
                    }
                } finally {
                    if (!this.FHL) {
                        this.FHD++;
                    }
                    AppMethodBeat.o(120539);
                }
            }
        }

        private final o<com.tencent.mm.plugin.story.f.d.j, c> fsG() {
            AppMethodBeat.i(120540);
            while (true) {
                if (this.FHL) {
                    this.FHE++;
                }
                if (this.FHE >= this.FHG.size()) {
                    AppMethodBeat.o(120540);
                    return null;
                }
                try {
                    if (this.FHG.size() > this.FHE) {
                        com.tencent.mm.plugin.story.f.d.j jVar = this.FHG.get(this.FHE).FoT;
                        m mVar = m.FHB;
                        com.tencent.mm.plugin.story.f.d.j jVar2 = m.n(jVar) ? jVar : null;
                        if (jVar2 != null) {
                            return new o<>(jVar2, new c(this.FHD, this.FHE, jVar2));
                        }
                    }
                    if (!this.FHL) {
                        this.FHE++;
                    }
                } finally {
                    if (!this.FHL) {
                        this.FHE++;
                    }
                    AppMethodBeat.o(120540);
                }
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
        static final class b extends q implements kotlin.g.a.a<o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends c>> {
            final /* synthetic */ a FHN;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar) {
                super(0);
                this.FHN = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends c> invoke() {
                AppMethodBeat.i(120533);
                o a2 = a.a(this.FHN);
                AppMethodBeat.o(120533);
                return a2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
        static final class c extends q implements kotlin.g.a.a<o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends c>> {
            final /* synthetic */ a FHN;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(a aVar) {
                super(0);
                this.FHN = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends c> invoke() {
                AppMethodBeat.i(120534);
                o a2 = a.a(this.FHN);
                AppMethodBeat.o(120534);
                return a2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "invoke"})
        static final class d extends q implements kotlin.g.a.a<o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends c>> {
            final /* synthetic */ a FHN;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(a aVar) {
                super(0);
                this.FHN = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ o<? extends com.tencent.mm.plugin.story.f.d.j, ? extends c> invoke() {
                AppMethodBeat.i(120535);
                o b2 = a.b(this.FHN);
                AppMethodBeat.o(120535);
                return b2;
            }
        }
    }

    private static boolean fsx() {
        AppMethodBeat.i(120570);
        if (CdnLogic.getRecentAverageSpeed(2) >= FHn.FFV) {
            AppMethodBeat.o(120570);
            return true;
        }
        AppMethodBeat.o(120570);
        return false;
    }

    public static final /* synthetic */ void aSE(String str) {
        AppMethodBeat.i(120575);
        Log.printInfoStack("MicroMsg.StoryVideoPreloadMgr", "onVideoSourceChange: ".concat(String.valueOf(str)), new Object[0]);
        com.tencent.mm.plugin.story.f.d.j jVar = FHr.get(str);
        if (jVar != null) {
            l(jVar);
            s sVar = s.Fny;
            n a2 = s.a(jVar);
            a2.frR();
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.fog().b(a2);
            com.tencent.mm.vfs.s.deleteFile(a2.field_filePath);
        }
        AppMethodBeat.o(120575);
    }

    public static final /* synthetic */ void a(m mVar, String str) {
        T t;
        int i2;
        String str2;
        Long l;
        boolean z;
        AppMethodBeat.i(120576);
        Iterator<T> it = FHu.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (p.j(str, next.jpT)) {
                t = next;
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            Boolean.valueOf(FHu.remove(t2));
        }
        if (FHo == 1) {
            Log.i("MicroMsg.StoryVideoPreloadMgr", "upgrades mediaId " + str + " runningMediaId " + FHy + " selectMediaId " + FHz);
            Long l2 = FHy;
            long j2 = FHz;
            if (l2 != null && l2.longValue() == j2 && ((l = FHy) == null || l.longValue() != 0)) {
                z = true;
            } else {
                z = false;
            }
            mVar.wc(z);
        }
        if (FHn.FFT) {
            boolean fsx = fsx();
            if (fsy()) {
                if (!FHu.isEmpty()) {
                    Log.i("MicroMsg.StoryVideoPreloadMgr", "isBadNetWork pass " + FHu.size() + " getNetworkSpeed:" + CdnLogic.getRecentAverageSpeed(2));
                    AppMethodBeat.o(120576);
                    return;
                }
            }
            Log.i("MicroMsg.StoryVideoPreloadMgr", "upgrades preloadRunningSet size " + FHu.size());
            List<Integer> fsv = fsv();
            if (!fsv.isEmpty()) {
                int intValue = ((Number) kotlin.a.j.ku(fsv)).intValue();
                if (a(mVar, intValue, "upgrades")) {
                    Log.i("MicroMsg.StoryVideoPreloadMgr", "add new task when upgrades newQuota " + intValue + " then running " + FHu.size());
                }
            }
            int B = kotlin.a.j.B(fsv);
            Integer num = (Integer) kotlin.a.j.w(fsv);
            int intValue2 = num != null ? num.intValue() : 0;
            List<c> list = FHu;
            synchronized (list) {
                try {
                    Iterator<T> it2 = list.iterator();
                    i2 = B;
                    while (it2.hasNext()) {
                        i2 -= it2.next().gsw;
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(120576);
                }
            }
            Log.i("MicroMsg.StoryVideoPreloadMgr", "upgrades quotaList:" + kotlin.a.j.B(fsv) + " totalQuota " + i2 + " maxQuota " + intValue2);
            if (i2 <= 0) {
                String str3 = "";
                List<c> list2 = FHu;
                synchronized (list2) {
                    try {
                        for (T t3 : list2) {
                            str3 = str3 + "mediaId " + t3.jpT + ", quota:" + t3.gsw;
                        }
                        x xVar2 = x.SXb;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Log.i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota no quota left " + i2 + " info: " + str3);
                AppMethodBeat.o(120576);
                return;
            }
            p.h(fsv, "list");
            z.d dVar = new z.d();
            dVar.SYE = 0;
            d.a aVar = new d.a(dVar, fsv);
            LinkedList linkedList = new LinkedList();
            List<c> list3 = FHu;
            synchronized (list3) {
                try {
                    Iterator<T> it3 = list3.iterator();
                    while (it3.hasNext()) {
                        linkedList.add(it3.next());
                    }
                    x xVar3 = x.SXb;
                } finally {
                    AppMethodBeat.o(120576);
                }
            }
            if (t2 != null) {
                if (!(t2.gsw < intValue2)) {
                    t2 = null;
                }
                if (t2 != null) {
                    Log.i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota try add remove which one remove " + intValue2 + "  it.quota " + t2);
                    Boolean.valueOf(linkedList.add(t2));
                }
            }
            x xVar4 = x.SXb;
            LinkedList<c> linkedList2 = linkedList;
            synchronized (linkedList2) {
                try {
                    str2 = "";
                    for (c cVar : linkedList2) {
                        str2 = str2 + "mediaId " + cVar.jpT + ", quota:" + cVar.gsw;
                    }
                    x xVar5 = x.SXb;
                } finally {
                    AppMethodBeat.o(120576);
                }
            }
            Log.i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota quota left " + i2 + " info: " + str2);
            LinkedList<c> linkedList3 = linkedList;
            synchronized (linkedList3) {
                try {
                    for (c cVar2 : linkedList3) {
                        Integer num2 = (Integer) aVar.invoke();
                        Log.i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota getQuota1 " + num2 + " cur: quota " + cVar2.gsw + " cdnMediaId " + cVar2.jpT);
                        if (num2 != null) {
                            int intValue3 = num2.intValue();
                            Integer num3 = intValue3 > 0 && intValue3 > cVar2.gsw ? num2 : null;
                            if (num3 != null) {
                                num3.intValue();
                                String str4 = cVar2.jpT;
                                com.tencent.mm.plugin.story.f.d.j jVar = cVar2.FHP;
                                int a2 = a(str4, jVar.Fpd, num2.intValue(), fsx);
                                s sVar = s.Fny;
                                n a3 = s.a(jVar);
                                Log.i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota getQuota2 mediaId " + str4 + " old " + cVar2.gsw + " newupgradeQuota: " + num2);
                                if (a3.frQ() || (((float) a3.field_cacheSize) / ((float) a3.field_totalSize)) * 100.0f >= ((float) a2)) {
                                    Log.i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota pull preload video, " + str4 + ", already reach cache size! cacheSize:" + a3.field_cacheSize + ", totalSize:" + a3.field_totalSize + ", cachePercent:" + ((((float) a3.field_cacheSize) / ((float) a3.field_totalSize)) * 100.0f));
                                } else if (FHB.a(jVar, a2, 1, cVar2)) {
                                    cVar2.gsw = num2.intValue();
                                    Log.i("MicroMsg.StoryVideoPreloadMgr", "upgradeQuota ok! mediaId ".concat(String.valueOf(str4)));
                                }
                                x xVar6 = x.SXb;
                            }
                        }
                    }
                    x xVar7 = x.SXb;
                } finally {
                    AppMethodBeat.o(120576);
                }
            }
            return;
        }
        AppMethodBeat.o(120576);
    }
}
