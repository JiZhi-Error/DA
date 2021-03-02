package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.report.ag;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.view.indictor.FinderMediaGestureIndicator2;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.h;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J(\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J@\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J \u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\bH\u0016J \u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J)\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "isPlayingWhenDown", "adjustIndicator", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "convertMedia", "item", "position", "type", "getLayoutId", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaDoubleClick", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "onPostFinished", "refreshFinderLiveNoticeView", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasPlayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/Boolean;)V", "Companion", "plugin-finder_release"})
public final class q extends o<u> {
    public static final a tCx = new a((byte) 0);
    private final i tAi;
    private boolean tCw;

    static {
        AppMethodBeat.i(242975);
        AppMethodBeat.o(242975);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.plugin.finder.convert.o
    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, u uVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(242971);
        a(hVar, uVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(242971);
    }

    @Override // com.tencent.mm.plugin.finder.convert.o, com.tencent.mm.view.recyclerview.e
    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(242970);
        a(hVar, (u) aVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(242970);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.finder.model.BaseFinderFeed, com.tencent.mm.view.recyclerview.h] */
    @Override // com.tencent.mm.plugin.finder.convert.o
    public final /* synthetic */ void e(u uVar, com.tencent.mm.view.recyclerview.h hVar) {
        AppMethodBeat.i(242965);
        u uVar2 = uVar;
        p.h(uVar2, "item");
        p.h(hVar, "holder");
        super.e(uVar2, hVar);
        i(hVar);
        AppMethodBeat.o(242965);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed] */
    @Override // com.tencent.mm.plugin.finder.convert.o
    public final /* synthetic */ void g(com.tencent.mm.view.recyclerview.h hVar, u uVar) {
        AppMethodBeat.i(242966);
        u uVar2 = uVar;
        p.h(hVar, "holder");
        p.h(uVar2, "item");
        LinkedList<cjl> mediaList = uVar2.feedObject.getMediaList();
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        RecyclerView.a adapter = finderMediaBanner.getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
            AppMethodBeat.o(242966);
            throw tVar;
        }
        FinderMediaBannerAdapter finderMediaBannerAdapter = (FinderMediaBannerAdapter) adapter;
        finderMediaBanner.getIndicator().setOnSelectedPageListener(new e(finderMediaBanner));
        finderMediaBanner.getPagerView().setFrozeTouch(true);
        finderMediaBannerAdapter.wrm = finderMediaBanner;
        finderMediaBannerAdapter.setItems(mediaList);
        finderMediaBanner.getIndicator().setCurrentIndex(0);
        finderMediaBanner.setAutoPlay(false);
        FeedData.a aVar = FeedData.Companion;
        finderMediaBannerAdapter.feed = FeedData.a.i(uVar2.feedObject);
        finderMediaBannerAdapter.dLS = this.dLS;
        finderMediaBannerAdapter.wfg = true;
        finderMediaBannerAdapter.wro = false;
        finderMediaBannerAdapter.wrp = false;
        azy azy = new azy();
        azy.refObjectId = uVar2.feedObject.getRefObjectId();
        azy.refObjectFlag = uVar2.feedObject.getRefObjectFlag();
        azy.refObjectContact = uVar2.feedObject.getRefObjectContact();
        finderMediaBanner.setRefFeedInfo(azy);
        FinderImgFeedMusicTag finderImgFeedMusicTag = (FinderImgFeedMusicTag) hVar.Mn(R.id.a38);
        azk azk = uVar2.musicInfo;
        if (azk != null) {
            finderImgFeedMusicTag.a(azk);
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(ad.class);
            p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            finderImgFeedMusicTag.setTag(R.id.d0m, Boolean.valueOf(!((ad) af).dxX()));
        } else {
            finderImgFeedMusicTag.setTag(R.id.d0m, Boolean.FALSE);
            finderImgFeedMusicTag.dle();
        }
        View Mn = hVar.Mn(R.id.g8t);
        p.g(Mn, "holder.getView<View>(R.id.part_top_layout)");
        Mn.setVisibility(4);
        if (uVar2.feedObject.getMediaList().size() > 1 || uVar2.musicInfo != null) {
            View Mn2 = hVar.Mn(R.id.hgu);
            p.g(Mn2, "holder.getView<View>(R.id.seek_pause_layout)");
            Mn2.setVisibility(0);
        } else {
            View Mn3 = hVar.Mn(R.id.hgu);
            p.g(Mn3, "holder.getView<View>(R.id.seek_pause_layout)");
            Mn3.setVisibility(8);
        }
        FinderFullSeekBarLayout finderFullSeekBarLayout = (FinderFullSeekBarLayout) hVar.Mn(R.id.dc5);
        finderFullSeekBarLayout.setPlayingCallback(new c(finderMediaBanner, finderImgFeedMusicTag));
        finderFullSeekBarLayout.setOnPauseClickListener(new d(finderMediaBanner, finderImgFeedMusicTag));
        i(hVar);
        g(hVar);
        AppMethodBeat.o(242966);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(i iVar, boolean z, int i2, int i3) {
        this(iVar, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? 0 : i2);
        AppMethodBeat.i(242974);
        AppMethodBeat.o(242974);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(i iVar, boolean z, int i2) {
        super(iVar, z, i2);
        p.h(iVar, "contract");
        AppMethodBeat.i(242973);
        this.tAi = iVar;
        AppMethodBeat.o(242973);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.o;
    }

    @Override // com.tencent.mm.plugin.finder.convert.o, com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        AppMethodBeat.i(242964);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        super.a(recyclerView, hVar, i2);
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        finderMediaBanner.setAdapter(new FinderMediaBannerAdapter());
        finderMediaBanner.setViewPool(this.tAi.dcf());
        finderMediaBanner.setParentRecyclerView(recyclerView);
        View Mn = hVar.Mn(R.id.duz);
        FinderMediaGestureIndicator2 finderMediaGestureIndicator2 = (FinderMediaGestureIndicator2) Mn;
        finderMediaGestureIndicator2.setOnSelectedPageListener(new f(this, finderMediaBanner, recyclerView));
        finderMediaGestureIndicator2.setOnTouchListener(new g(this, finderMediaBanner, recyclerView));
        p.g(Mn, "holder.getView<FinderMed…e\n            }\n        }");
        finderMediaBanner.setIndicator((com.tencent.mm.view.h) Mn);
        finderMediaBanner.setPageChangeCallback(new h(hVar));
        finderMediaBanner.getIndicator().setShowOnlyOneIndicator(true);
        AppMethodBeat.o(242964);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$onCreateViewHolder$1$1", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "onSelected", "", FirebaseAnalytics.b.INDEX, "", "plugin-finder_release"})
    public static final class f implements h.a {
        final /* synthetic */ FinderMediaBanner tBM;
        final /* synthetic */ q tCB;
        final /* synthetic */ RecyclerView tCC;

        f(q qVar, FinderMediaBanner finderMediaBanner, RecyclerView recyclerView) {
            this.tCB = qVar;
            this.tBM = finderMediaBanner;
            this.tCC = recyclerView;
        }

        @Override // com.tencent.mm.view.h.a
        public final void Ir(int i2) {
            AppMethodBeat.i(242961);
            MediaBanner.a(this.tBM, i2);
            AppMethodBeat.o(242961);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$onCreateViewHolder$2", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
    public static final class h implements MediaBanner.c {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        h(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        @Override // com.tencent.mm.view.MediaBanner.c
        public final void e(int i2, boolean z, boolean z2) {
            AppMethodBeat.i(242963);
            u uVar = (u) this.qhp.hgv();
            if (i2 < uVar.feedObject.getMediaList().size()) {
                cjl cjl = uVar.feedObject.getMediaList().get(i2);
                p.g(cjl, "feed.feedObject.mediaList[position]");
                cjl cjl2 = cjl;
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                Context context = this.qhp.getContext();
                p.g(context, "holder.context");
                FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
                if (fH != null) {
                    ag.a doV = new ag(FinderReporterUIC.a(fH)).doV();
                    long id = uVar.feedObject.getId();
                    String objectNonceId = uVar.feedObject.getObjectNonceId();
                    LinkedList<cjl> linkedList = new LinkedList<>(uVar.feedObject.getMediaList());
                    p.g(uVar, "feed");
                    doV.a(id, cjl2, objectNonceId, i2, linkedList, uVar, z2);
                    AppMethodBeat.o(242963);
                    return;
                }
            }
            AppMethodBeat.o(242963);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$convertMedia$1", "Lcom/tencent/mm/view/IMediaBannerIndicator$OnSelectedPageListener;", "onSelected", "", FirebaseAnalytics.b.INDEX, "", "plugin-finder_release"})
    public static final class e implements h.a {
        final /* synthetic */ FinderMediaBanner tCA;

        e(FinderMediaBanner finderMediaBanner) {
            this.tCA = finderMediaBanner;
        }

        @Override // com.tencent.mm.view.h.a
        public final void Ir(int i2) {
            AppMethodBeat.i(242960);
            MediaBanner.a(this.tCA, i2);
            AppMethodBeat.o(242960);
        }
    }

    private static void i(com.tencent.mm.view.recyclerview.h hVar) {
        AppMethodBeat.i(242967);
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        View Mn = hVar.Mn(R.id.clr);
        View Mn2 = hVar.Mn(R.id.duz);
        if (Mn2 != null) {
            Mn2.post(new b(Mn2, hVar, finderMediaBanner, Mn));
            AppMethodBeat.o(242967);
            return;
        }
        AppMethodBeat.o(242967);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$adjustIndicator$1$1"})
    public static final class b implements Runnable {
        final /* synthetic */ FinderMediaBanner tBM;
        final /* synthetic */ View tBN;
        final /* synthetic */ View tCy;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;

        b(View view, com.tencent.mm.view.recyclerview.h hVar, FinderMediaBanner finderMediaBanner, View view2) {
            this.tCy = view;
            this.tzq = hVar;
            this.tBM = finderMediaBanner;
            this.tBN = view2;
        }

        public final void run() {
            AppMethodBeat.i(242957);
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.tzq.aus.getLocationInWindow(iArr);
            this.tBM.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - iArr[0];
            iArr2[1] = iArr2[1] - iArr[1];
            this.tBN.getLocationInWindow(iArr3);
            iArr3[0] = iArr3[0] - iArr[0];
            iArr3[1] = iArr3[1] - iArr[1];
            int i2 = iArr3[1];
            View view = this.tBN;
            p.g(view, "view");
            iArr3[1] = i2 + view.getPaddingTop();
            ViewGroup.LayoutParams layoutParams = this.tCy.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(242957);
                throw tVar;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            int i3 = layoutParams2.topMargin;
            Context context = this.tzq.getContext();
            p.g(context, "holder.context");
            context.getResources().getDimension(R.dimen.ct);
            int i4 = iArr2[1];
            FinderMediaBanner finderMediaBanner = this.tBM;
            p.g(finderMediaBanner, "banner");
            if (i4 + finderMediaBanner.getHeight() + this.tCy.getHeight() >= iArr3[1]) {
                layoutParams2.topMargin = iArr3[1] - this.tCy.getHeight();
            } else {
                int i5 = iArr2[1];
                FinderMediaBanner finderMediaBanner2 = this.tBM;
                p.g(finderMediaBanner2, "banner");
                layoutParams2.topMargin = i5 + finderMediaBanner2.getHeight();
            }
            if (layoutParams2.topMargin != i3) {
                this.tCy.requestLayout();
            }
            AppMethodBeat.o(242957);
        }
    }

    @Override // com.tencent.mm.plugin.finder.convert.o
    public final void a(com.tencent.mm.view.recyclerview.h hVar, FinderItem finderItem, Boolean bool) {
        AppMethodBeat.i(242968);
        p.h(hVar, "holder");
        super.a(hVar, finderItem, bool);
        i(hVar);
        AppMethodBeat.o(242968);
    }

    private void a(com.tencent.mm.view.recyclerview.h hVar, u uVar, int i2, int i3, boolean z, List<Object> list) {
        AppMethodBeat.i(242969);
        p.h(hVar, "holder");
        p.h(uVar, "item");
        super.a(hVar, (BaseFinderFeed) uVar, i2, i3, z, list);
        if (uVar.isPreview) {
            int n = com.tencent.mm.cb.a.n(hVar.getContext(), R.color.pk);
            View Mn = hVar.Mn(R.id.x1);
            p.g(Mn, "holder.getView<View>(R.id.avatar_iv)");
            Mn.setEnabled(false);
            View Mn2 = hVar.Mn(R.id.fzc);
            p.g(Mn2, "holder.getView<View>(R.id.nickname)");
            Mn2.setEnabled(false);
            View Mn3 = hVar.Mn(R.id.d8o);
            if (Mn3 != null) {
                ((TextView) Mn3.findViewById(R.id.hp9)).setTextColor(n);
                ((WeImageView) Mn3.findViewById(R.id.dtu)).setIconColor(n);
                View findViewById = Mn3.findViewById(R.id.hph);
                p.g(findViewById, "opLayout.findViewById<Vi….id.share_icon_container)");
                findViewById.setEnabled(false);
                ((TextView) Mn3.findViewById(R.id.eba)).setTextColor(n);
                ((ImageView) Mn3.findViewById(R.id.dts)).setImageDrawable(ar.m(hVar.getContext(), R.raw.finder_full_like, n));
                View findViewById2 = Mn3.findViewById(R.id.xk);
                p.g(findViewById2, "opLayout.findViewById<Vi…d.awesome_icon_container)");
                findViewById2.setEnabled(false);
                ((TextView) Mn3.findViewById(R.id.b8o)).setTextColor(n);
                ((WeImageView) Mn3.findViewById(R.id.dtq)).setIconColor(n);
                View findViewById3 = Mn3.findViewById(R.id.b8z);
                p.g(findViewById3, "opLayout.findViewById<Vi…d.comment_icon_container)");
                findViewById3.setEnabled(false);
                View Mn4 = hVar.Mn(R.id.xj);
                p.g(Mn4, "holder.getView<View>(R.id.awesome_ground_layout)");
                Mn4.setVisibility(4);
                View Mn5 = hVar.Mn(R.id.ik5);
                p.g(Mn5, "collapseTextLayout");
                Mn5.setEnabled(false);
                AppMethodBeat.o(242969);
                return;
            }
        }
        AppMethodBeat.o(242969);
    }

    @Override // com.tencent.mm.plugin.finder.convert.o
    public final void a(com.tencent.mm.view.recyclerview.h hVar, View view, MotionEvent motionEvent) {
        AppMethodBeat.i(242972);
        p.h(hVar, "holder");
        p.h(view, "view");
        p.h(motionEvent, "e");
        BaseFinderFeed baseFinderFeed = (BaseFinderFeed) hVar.hgv();
        Rect rect = new Rect();
        hVar.Mn(R.id.duz).getGlobalVisibleRect(rect);
        if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            AppMethodBeat.o(242972);
        } else if (!baseFinderFeed.feedObject.isPostFinish()) {
            AppMethodBeat.o(242972);
        } else if (baseFinderFeed.isPreview) {
            AppMethodBeat.o(242972);
        } else {
            j.a aVar = j.vUw;
            if (!j.vUv.m(baseFinderFeed.feedObject.getFeedObject()).first.booleanValue()) {
                com.tencent.mm.ui.base.u.makeText(view.getContext(), view.getContext().getString(R.string.cn8), 0).show();
            }
            AppMethodBeat.o(242972);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\u000b¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$onCreateViewHolder$1$2"})
    static final class g implements View.OnTouchListener {
        final /* synthetic */ FinderMediaBanner tBM;
        final /* synthetic */ q tCB;
        final /* synthetic */ RecyclerView tCC;

        g(q qVar, FinderMediaBanner finderMediaBanner, RecyclerView recyclerView) {
            this.tCB = qVar;
            this.tBM = finderMediaBanner;
            this.tCC = recyclerView;
        }

        public final /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(242962);
            p.g(motionEvent, "event");
            if (motionEvent.getAction() == 0) {
                this.tCB.tCw = this.tBM.isAutoPlay;
                this.tBM.setAutoPlay(false);
                RecyclerView.LayoutManager layoutManager = this.tCC.getLayoutManager();
                if (layoutManager != null && (layoutManager instanceof FinderLinearLayoutManager)) {
                    ((FinderLinearLayoutManager) layoutManager).wtl = false;
                }
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.tBM.setAutoPlay(this.tCB.tCw);
                RecyclerView.LayoutManager layoutManager2 = this.tCC.getLayoutManager();
                if (layoutManager2 != null && (layoutManager2 instanceof FinderLinearLayoutManager)) {
                    ((FinderLinearLayoutManager) layoutManager2).wtl = true;
                }
            }
            AppMethodBeat.o(242962);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$convertMedia$5$1"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderMediaBanner tBM;
        final /* synthetic */ FinderImgFeedMusicTag tCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderMediaBanner finderMediaBanner, FinderImgFeedMusicTag finderImgFeedMusicTag) {
            super(0);
            this.tBM = finderMediaBanner;
            this.tCz = finderImgFeedMusicTag;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(242958);
            Boolean valueOf = Boolean.valueOf(this.tBM.isAutoPlay);
            AppMethodBeat.o(242958);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullImageConvert$convertMedia$5$2"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderMediaBanner tBM;
        final /* synthetic */ FinderImgFeedMusicTag tCz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderMediaBanner finderMediaBanner, FinderImgFeedMusicTag finderImgFeedMusicTag) {
            super(0);
            this.tBM = finderMediaBanner;
            this.tCz = finderImgFeedMusicTag;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(242959);
            boolean z = this.tBM.isAutoPlay;
            if (z) {
                this.tCz.bdY();
                this.tBM.setAutoPlay(false);
                this.tCz.setTag(R.id.d0m, Boolean.FALSE);
            } else {
                this.tCz.setTag(R.id.d0m, Boolean.TRUE);
                this.tCz.dlf();
                this.tBM.setAutoPlay(true);
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(242959);
            return valueOf;
        }
    }
}
