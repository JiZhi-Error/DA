package com.tencent.mm.plugin.finder.video;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModel;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicPlayerManager;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.ui.FinderHomeUI;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.t;

public final class FinderVideoAutoPlayManager extends com.tencent.mm.plugin.finder.event.base.d implements UILifecycleObserver {
    public static final a weJ = new a((byte) 0);
    private boolean aHY;
    private final int dLS;
    final RecyclerView hak;
    private boolean isResume;
    private final MMHandler mainHandler = new MMHandler(Looper.getMainLooper(), new b(this));
    private final MMFragmentActivity uLr;
    private final Rect vXx;
    private final int[] weB = new int[2];
    private long weC = -1;
    private final int weD;
    private long weE;
    private final HashSet<String> weF;
    private final HashSet<String> weG;
    private final FinderVideoRecycler weH;
    private final FinderImgFeedMusicPlayerManager weI;

    static {
        AppMethodBeat.i(168029);
        AppMethodBeat.o(168029);
    }

    public static final class d extends q implements kotlin.g.a.b<r, Boolean> {
        final /* synthetic */ FinderVideoLayout weL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderVideoLayout finderVideoLayout) {
            super(1);
            this.weL = finderVideoLayout;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(r rVar) {
            boolean z;
            AppMethodBeat.i(254251);
            r rVar2 = rVar;
            p.h(rVar2, "view");
            FinderVideoLayout finderVideoLayout = this.weL;
            if (finderVideoLayout != null) {
                z = !p.j(finderVideoLayout.getVideoView(), rVar2.getVideoView());
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(254251);
            return valueOf;
        }
    }

    public static final class e extends q implements kotlin.g.a.b<View, Boolean> {
        final /* synthetic */ FinderImgFeedMusicTag weM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderImgFeedMusicTag finderImgFeedMusicTag) {
            super(1);
            this.weM = finderImgFeedMusicTag;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(View view) {
            boolean z;
            AppMethodBeat.i(254252);
            View view2 = view;
            p.h(view2, "musicViewInManager");
            FinderImgFeedMusicTag finderImgFeedMusicTag = this.weM;
            if (finderImgFeedMusicTag != null) {
                Log.i("FinderImgFeedMusicPlayer", "focusView:" + this.weM.getId() + ",other:" + view2.getId());
                z = p.j(finderImgFeedMusicTag, view2);
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(254252);
            return valueOf;
        }
    }

    public FinderVideoAutoPlayManager(MMFragmentActivity mMFragmentActivity, RecyclerView recyclerView, FinderVideoRecycler finderVideoRecycler, FinderImgFeedMusicPlayerManager finderImgFeedMusicPlayerManager, int i2) {
        p.h(mMFragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(recyclerView, "recyclerView");
        p.h(finderVideoRecycler, "recycler");
        p.h(finderImgFeedMusicPlayerManager, "musicManager");
        AppMethodBeat.i(254266);
        this.uLr = mMFragmentActivity;
        this.hak = recyclerView;
        this.weH = finderVideoRecycler;
        this.weI = finderImgFeedMusicPlayerManager;
        this.dLS = i2;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.weD = com.tencent.mm.plugin.finder.storage.c.duz().value().intValue();
        this.weE = -1;
        this.weF = new HashSet<>();
        this.vXx = new Rect();
        this.weG = new HashSet<>();
        AppMethodBeat.o(254266);
    }

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public final boolean cZD() {
        return false;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b implements MMHandler.Callback {
        final /* synthetic */ FinderVideoAutoPlayManager weK;

        b(FinderVideoAutoPlayManager finderVideoAutoPlayManager) {
            this.weK = finderVideoAutoPlayManager;
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(168011);
            if (message.what == 1) {
                Log.i("Finder.VideoAutoPlayManager", "data change to check play...");
                FinderVideoAutoPlayManager.a(this.weK, this.weK.hak);
            } else if (message.what == 2) {
                Object obj = message.obj;
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Long");
                    AppMethodBeat.o(168011);
                    throw tVar;
                }
                FinderVideoAutoPlayManager.Gq(((Long) obj).longValue());
            }
            AppMethodBeat.o(168011);
            return true;
        }
    }

    public final void setup() {
        AppMethodBeat.i(168013);
        MMFragmentActivity mMFragmentActivity = this.uLr;
        if (mMFragmentActivity != null) {
            a(mMFragmentActivity, this);
        }
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.c MA = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.uLr).get(FinderReporterUIC.class)).MA(this.dLS);
        if (MA != null) {
            MA.a(this);
        }
        if (!this.mainHandler.hasMessages(1)) {
            this.mainHandler.sendEmptyMessageDelayed(1, 500);
        }
        AppMethodBeat.o(168013);
    }

    public static /* synthetic */ void a(FinderVideoAutoPlayManager finderVideoAutoPlayManager, String str, boolean z) {
        AppMethodBeat.i(254256);
        finderVideoAutoPlayManager.g(str, z, false);
        AppMethodBeat.o(254256);
    }

    public final void g(String str, boolean z, boolean z2) {
        AppMethodBeat.i(254255);
        p.h(str, "scene");
        Log.i("Finder.VideoAutoPlayManager", "[lock] scene=" + str + " isLock=" + z + " lockSize=" + this.weF.size() + " unLockAfterCheck=" + z2);
        if (z) {
            this.weF.add(str);
            this.aHY = true;
        } else {
            this.weF.remove(str);
            if (this.weF.size() <= 0) {
                this.aHY = false;
            }
        }
        this.mainHandler.removeMessages(1);
        if (!this.aHY && z2) {
            this.mainHandler.sendEmptyMessage(1);
        }
        AppMethodBeat.o(254255);
    }

    public final void awI(String str) {
        AppMethodBeat.i(254257);
        p.h(str, "source");
        Log.i("Finder.VideoAutoPlayManager", "[postCheck] source=".concat(String.valueOf(str)));
        this.mainHandler.removeMessages(1);
        this.mainHandler.sendEmptyMessage(1);
        AppMethodBeat.o(254257);
    }

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
        AppMethodBeat.i(168015);
        p.h(bVar, "ev");
        if (bVar instanceof h) {
            this.hak.post(new c(this));
        }
        AppMethodBeat.o(168015);
    }

    static final class c implements Runnable {
        final /* synthetic */ FinderVideoAutoPlayManager weK;

        c(FinderVideoAutoPlayManager finderVideoAutoPlayManager) {
            this.weK = finderVideoAutoPlayManager;
        }

        public final void run() {
            AppMethodBeat.i(254250);
            FinderVideoAutoPlayManager.a(this.weK, this.weK.hak);
            AppMethodBeat.o(254250);
        }
    }

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public final void onRelease() {
        AppMethodBeat.i(168016);
        super.onRelease();
        this.mainHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(168016);
    }

    private final void s(RecyclerView recyclerView) {
        String str;
        com.tencent.mm.view.recyclerview.h hVar;
        com.tencent.mm.view.recyclerview.h hVar2;
        FeedData feedData;
        cjl cjl;
        com.tencent.mm.view.recyclerview.h hVar3;
        FeedData feedData2;
        cjl cjl2;
        FeedData feedData3;
        LinkedList<cjl> mediaList;
        FeedData feedData4;
        LinkedList<cjl> mediaList2;
        y.a aVar;
        AppMethodBeat.i(254259);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            int ks = ((LinearLayoutManager) layoutManager).ks();
            int ku = ((LinearLayoutManager) layoutManager).ku();
            y yVar = y.vXH;
            y.a a2 = y.a(recyclerView, ks, ku, (Set) null, 8);
            Gp(a2.feedId);
            z.a aVar2 = new z.a();
            aVar2.SYB = false;
            y yVar2 = y.vXH;
            com.tencent.mm.view.recyclerview.h hVar4 = a2.tAm;
            FeedData feedData5 = a2.feed;
            if (hVar4 == null || feedData5 == null) {
                str = null;
            } else {
                if (hVar4.lQ() != hVar4.lR()) {
                    String str2 = "[check2Play] holder=" + hVar4 + " centerId=" + a2.feedId + " first=" + ks + " end=" + ku + " adapterPosition=" + hVar4.lR() + " layoutPosition=" + hVar4.lQ() + " isInLayout=" + recyclerView.isInLayout();
                    Log.e("Finder.VideoAutoPlayManager", str2);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20251, 1, str2);
                    String sb = new StringBuilder().append(hVar4.hashCode()).append('_').append(hVar4.lR()).append('_').append(hVar4.lQ()).append('_').append(hVar4.lT()).toString();
                    if (!this.weG.contains(sb)) {
                        recyclerView.post(new f(sb, this, a2, ks, ku, recyclerView, aVar2));
                        AppMethodBeat.o(254259);
                        return;
                    }
                }
                com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                com.tencent.mm.plugin.finder.event.base.f MC = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.uLr).get(FinderReporterUIC.class)).MC(this.dLS);
                if (MC != null) {
                    MC.f(recyclerView, 6);
                }
                FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar4.Mn(R.id.fbd);
                if (finderMediaBanner != null) {
                    finderMediaBanner.getGlobalVisibleRect(this.vXx);
                }
                int height = finderMediaBanner != null ? finderMediaBanner.getHeight() : 0;
                Log.d("Finder.VideoAutoPlayManager", "check2Play bannerHeight:" + height + " mediaRect:" + this.vXx.height());
                if (height > 0 && ((float) this.vXx.height()) >= ((float) height) / 2.5f && (feedData5.getMediaType() == 4 || feedData5.getMediaType() == 9)) {
                    cjl cjl3 = (cjl) j.kt(feedData5.getMediaList());
                    if (cjl3 != null) {
                        Y(hVar4);
                        a(hVar4, cjl3, feedData5.getId());
                    }
                    aVar2.SYB = true;
                } else if (height <= 0 || feedData5.getMediaType() != 2) {
                    a(this);
                } else {
                    Y(hVar4);
                    if (feedData5.getHasBgmInfo() && (hVar = hVar4) != null) {
                        y yVar3 = y.vXH;
                        FinderImgFeedMusicTag X = y.X(hVar);
                        if (X != null) {
                            X.dlf();
                        } else {
                            Log.e("Finder.VideoAutoPlayManager", "playMusicHolder musicContainer is null!");
                        }
                    }
                    if (hVar4 != null) {
                        ((FinderMediaBanner) hVar4.Mn(R.id.fbd)).setAutoPlay(true);
                    }
                    aVar2.SYB = true;
                }
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dxe().value().intValue() == 1) {
                    y.a aVar4 = null;
                    y.a aVar5 = null;
                    int i2 = 0;
                    Iterator<y.a> it = a2.vXI.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            i2 = -1;
                            break;
                        }
                        if (it.next().feedId == a2.feedId) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 != -1) {
                        int i3 = i2 - 1;
                        int i4 = i2 + 1;
                        if (i3 < 0 || i3 >= a2.vXI.size()) {
                            aVar = null;
                        } else {
                            aVar = a2.vXI.get(i3);
                        }
                        if (i4 < 0 || i4 >= a2.vXI.size()) {
                            aVar4 = aVar;
                        } else {
                            aVar5 = a2.vXI.get(i4);
                            aVar4 = aVar;
                        }
                    }
                    Log.d("Finder.VideoAutoPlayManager", "check2Play preFeed:" + (aVar4 != null ? Long.valueOf(aVar4.feedId) : null) + " nextFeed:" + (aVar4 != null ? Long.valueOf(aVar4.feedId) : null));
                    y yVar4 = y.vXH;
                    if (aVar4 != null) {
                        hVar2 = aVar4.tAm;
                    } else {
                        hVar2 = null;
                    }
                    if (aVar4 != null) {
                        feedData = aVar4.feed;
                    } else {
                        feedData = null;
                    }
                    if (aVar4 == null || (feedData4 = aVar4.feed) == null || (mediaList2 = feedData4.getMediaList()) == null) {
                        cjl = null;
                    } else {
                        cjl = (cjl) j.kt(mediaList2);
                    }
                    if (!(hVar2 == null || feedData == null || cjl == null || feedData.getMediaType() != 4)) {
                        b(hVar2, cjl, feedData.getId());
                    }
                    y yVar5 = y.vXH;
                    if (aVar5 != null) {
                        hVar3 = aVar5.tAm;
                    } else {
                        hVar3 = null;
                    }
                    if (aVar5 != null) {
                        feedData2 = aVar5.feed;
                    } else {
                        feedData2 = null;
                    }
                    if (aVar5 == null || (feedData3 = aVar5.feed) == null || (mediaList = feedData3.getMediaList()) == null) {
                        cjl2 = null;
                    } else {
                        cjl2 = (cjl) j.kt(mediaList);
                    }
                    if (!(hVar3 == null || feedData2 == null || cjl2 == null || feedData2.getMediaType() != 4)) {
                        b(hVar3, cjl2, feedData2.getId());
                    }
                }
                str = "ret ok";
            }
            if (str == null) {
                new StringBuilder("error is null ").append(a2.tAm).append(", ").append(a2.feed);
            }
            if (!aVar2.SYB) {
                a(this);
            }
            k kVar = k.vkd;
            k.a(a2);
        }
        AppMethodBeat.o(254259);
    }

    public static final class f implements Runnable {
        final /* synthetic */ String $key;
        final /* synthetic */ RecyclerView tCC;
        final /* synthetic */ FinderVideoAutoPlayManager weK;
        final /* synthetic */ y.a weN;
        final /* synthetic */ int weO;
        final /* synthetic */ int weP;
        final /* synthetic */ z.a weQ;

        f(String str, FinderVideoAutoPlayManager finderVideoAutoPlayManager, y.a aVar, int i2, int i3, RecyclerView recyclerView, z.a aVar2) {
            this.$key = str;
            this.weK = finderVideoAutoPlayManager;
            this.weN = aVar;
            this.weO = i2;
            this.weP = i3;
            this.tCC = recyclerView;
            this.weQ = aVar2;
        }

        public final void run() {
            AppMethodBeat.i(254253);
            this.weK.weG.add(this.$key);
            FinderVideoAutoPlayManager.a(this.weK, this.tCC);
            AppMethodBeat.o(254253);
        }
    }

    public static final class g implements Runnable {
        final /* synthetic */ String $key;
        final /* synthetic */ RecyclerView tDJ;
        final /* synthetic */ FinderVideoAutoPlayManager weK;

        g(FinderVideoAutoPlayManager finderVideoAutoPlayManager, String str, RecyclerView recyclerView) {
            this.weK = finderVideoAutoPlayManager;
            this.$key = str;
            this.tDJ = recyclerView;
        }

        public final void run() {
            AppMethodBeat.i(254254);
            this.weK.weG.add(this.$key);
            FinderVideoAutoPlayManager.a(this.weK, this.tDJ);
            AppMethodBeat.o(254254);
        }
    }

    private final void Gp(long j2) {
        AppMethodBeat.i(254260);
        if (this.weD == 1 && this.weC != j2) {
            this.weC = j2;
            Log.i("Finder.VideoAutoPlayManager", "send show comment msg,feedId:".concat(String.valueOf(j2)));
            this.mainHandler.removeMessages(2);
            Message obtainMessage = this.mainHandler.obtainMessage(2);
            obtainMessage.obj = Long.valueOf(j2);
            this.mainHandler.sendMessageDelayed(obtainMessage, 5000);
        }
        AppMethodBeat.o(254260);
    }

    private final void a(RecyclerView.v vVar, cjl cjl, long j2) {
        AppMethodBeat.i(254261);
        if (vVar != null) {
            FinderVideoLayout finderVideoLayout = (FinderVideoLayout) vVar.aus.findViewById(R.id.ckd);
            if (finderVideoLayout != null) {
                Log.i("Finder.VideoAutoPlayManager", "playFocusHolder videoContainer " + finderVideoLayout.dFJ());
                finderVideoLayout.play(vVar.lR());
                this.weE = j2;
                AppMethodBeat.o(254261);
                return;
            }
            Log.e("Finder.VideoAutoPlayManager", "playFocusHolder videoContainer is null! mediaId=" + cjl.mediaId + "] feedId=" + j2);
        }
        AppMethodBeat.o(254261);
    }

    private static void b(RecyclerView.v vVar, cjl cjl, long j2) {
        AppMethodBeat.i(254262);
        FinderVideoLayout finderVideoLayout = (FinderVideoLayout) vVar.aus.findViewById(R.id.ckd);
        if (finderVideoLayout != null) {
            Log.d("Finder.VideoAutoPlayManager", "prepareToPlay ".concat(String.valueOf(j2)));
            vVar.lR();
            finderVideoLayout.dFA();
            AppMethodBeat.o(254262);
            return;
        }
        Log.e("Finder.VideoAutoPlayManager", "prepareHolder videoContainer is null! mediaId=" + cjl.mediaId + "] feedId=" + j2);
        AppMethodBeat.o(254262);
    }

    private static /* synthetic */ void a(FinderVideoAutoPlayManager finderVideoAutoPlayManager) {
        AppMethodBeat.i(254264);
        finderVideoAutoPlayManager.Y(null);
        AppMethodBeat.o(254264);
    }

    private void Y(RecyclerView.v vVar) {
        View view;
        AppMethodBeat.i(254263);
        this.weH.J(new d((vVar == null || (view = vVar.aus) == null) ? null : (FinderVideoLayout) view.findViewById(R.id.ckd)));
        y yVar = y.vXH;
        this.weI.F(new e(y.X(vVar)));
        Z(vVar);
        AppMethodBeat.o(254263);
    }

    private final void Z(RecyclerView.v vVar) {
        AppMethodBeat.i(254265);
        int childCount = this.hak.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView.v bu = this.hak.bu(this.hak.getChildAt(i2));
            if (bu != null && (bu instanceof com.tencent.mm.view.recyclerview.h) && (!p.j(vVar, bu))) {
                Object hgv = ((com.tencent.mm.view.recyclerview.h) bu).hgv();
                if ((hgv instanceof BaseFinderFeed) && ((BaseFinderFeed) hgv).feedObject.getMediaType() == 2) {
                    ((FinderMediaBanner) ((com.tencent.mm.view.recyclerview.h) bu).Mn(R.id.fbd)).dGZ();
                }
            }
        }
        AppMethodBeat.o(254265);
    }

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public final boolean a(com.tencent.mm.plugin.finder.event.base.c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
        AppMethodBeat.i(168021);
        p.h(cVar, "dispatcher");
        p.h(bVar, "event");
        if (!(bVar instanceof h)) {
            AppMethodBeat.o(168021);
            return false;
        } else if (((h) bVar).type == 3 || ((h) bVar).type == 0 || ((h) bVar).type == 8 || ((h) bVar).type == 5) {
            AppMethodBeat.o(168021);
            return true;
        } else {
            AppMethodBeat.o(168021);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onCreate(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(168022);
        p.h(lifecycleOwner, "var1");
        AppMethodBeat.o(168022);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onStart(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(168023);
        p.h(lifecycleOwner, "var1");
        AppMethodBeat.o(168023);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onResume(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(168024);
        p.h(lifecycleOwner, "var1");
        if (this.uLr instanceof FinderHomeUI) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.b(this.uLr).get(FinderHomeUIC.class);
            p.g(viewModel, "UICProvider.of(activity)…inderHomeUIC::class.java)");
            if (((FinderHomeUIC) viewModel).dIf() == this.dLS && !this.mainHandler.hasMessages(1)) {
                this.mainHandler.sendEmptyMessage(1);
            }
        }
        this.isResume = true;
        AppMethodBeat.o(168024);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onPause(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(168025);
        p.h(lifecycleOwner, "var1");
        this.mainHandler.removeMessages(1);
        this.mainHandler.removeMessages(2);
        this.isResume = false;
        AppMethodBeat.o(168025);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onStop(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(168026);
        p.h(lifecycleOwner, "var1");
        AppMethodBeat.o(168026);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onDestroy(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(168027);
        p.h(lifecycleOwner, "var1");
        AppMethodBeat.o(168027);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x02c5, code lost:
        if (r2 == null) goto L_0x02c7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager r14, android.support.v7.widget.RecyclerView r15) {
        /*
        // Method dump skipped, instructions count: 867
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager.a(com.tencent.mm.plugin.finder.video.FinderVideoAutoPlayManager, android.support.v7.widget.RecyclerView):void");
    }

    public static final /* synthetic */ void Gq(long j2) {
        AppMethodBeat.i(254267);
        y yVar = y.vXH;
        if (j2 == y.dCE()) {
            y yVar2 = y.vXH;
            y yVar3 = y.vXH;
            y.a(y.dCE(), true, 3);
            AppMethodBeat.o(254267);
            return;
        }
        Log.i("Finder.VideoAutoPlayManager", "feedId:" + j2 + " no eqauls current center feed");
        AppMethodBeat.o(254267);
    }
}
