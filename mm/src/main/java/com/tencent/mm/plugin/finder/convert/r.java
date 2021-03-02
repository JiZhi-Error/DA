package com.tencent.mm.plugin.finder.convert;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.FinderFeedLiveNoticeView;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001;B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J(\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0016J@\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\b2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016J \u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\nH\u0017J \u0010#\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J \u0010(\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0016JB\u0010+\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0014J)\u00103\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u00106J\u0018\u00107\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\u0018\u00108\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u00109\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\nH\u0002R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "commentScene", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZII)V", "getCommentScene", "()I", "calculateMediaLayoutParams", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "convertMedia", "position", "type", "enterLiveVisitorUI", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLayoutId", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaClick", "view", "Landroid/view/View;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "e", "Landroid/view/MotionEvent;", "openCommentDrawer", "isSingleMode", "refCommentId", "", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "customBottom", "reason", "refreshFinderLiveNoticeView", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "hasPlayload", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/Boolean;)V", "refreshLiveIcon", "refreshLivingIcon", "refreshMask", "liveStatus", "Companion", "plugin-finder_release"})
public final class r extends o<w> {
    public static final a tCF = new a((byte) 0);
    private final i tAi;
    private final k tCD;
    private final int tCE;

    static {
        AppMethodBeat.i(242991);
        AppMethodBeat.o(242991);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "isShow", "", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "invoke"})
    static final class b extends q implements m<Boolean, FinderVideoLayout.b, x> {
        final /* synthetic */ h qhp;
        final /* synthetic */ FinderMediaBannerAdapter tCG;
        final /* synthetic */ View tzv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderMediaBannerAdapter finderMediaBannerAdapter, View view, h hVar) {
            super(2);
            this.tCG = finderMediaBannerAdapter;
            this.tzv = view;
            this.qhp = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, FinderVideoLayout.b bVar) {
            FinderMediaBanner finderMediaBanner;
            ImageView imageView;
            AppMethodBeat.i(242977);
            boolean booleanValue = bool.booleanValue();
            StringBuilder append = new StringBuilder("isShow=").append(booleanValue).append(" nickName=");
            FeedData feedData = this.tCG.feed;
            Log.i("Finder.FeedFullLiveConvert", append.append(feedData != null ? feedData.getNickName() : null).toString());
            if (!booleanValue) {
                View view = this.tzv;
                if (view != null) {
                    view.setVisibility(8);
                }
                ImageView imageView2 = (ImageView) this.qhp.Mn(R.id.coq);
                if (!(imageView2 == null || imageView2.getVisibility() == 8 || !(!p.j(imageView2.getTag(), Boolean.TRUE)))) {
                    imageView2.setAlpha(1.0f);
                    imageView2.animate().cancel();
                    imageView2.setTag(Boolean.TRUE);
                    imageView2.animate().setStartDelay(300).setDuration(300).alpha(0.0f).setListener(new a(imageView2)).start();
                }
                RecyclerView.a adapter = ((FinderMediaBanner) this.qhp.Mn(R.id.fbd)).getAdapter();
                if (!(adapter instanceof FinderMediaBannerAdapter)) {
                    adapter = null;
                }
                FinderMediaBannerAdapter finderMediaBannerAdapter = (FinderMediaBannerAdapter) adapter;
                if (!(finderMediaBannerAdapter == null || (finderMediaBanner = finderMediaBannerAdapter.wrm) == null || (imageView = (ImageView) finderMediaBanner.findViewById(R.id.imd)) == null)) {
                    imageView.setVisibility(8);
                }
            } else {
                View view2 = this.tzv;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                ImageView imageView3 = (ImageView) this.qhp.Mn(R.id.coq);
                if (imageView3 != null) {
                    imageView3.animate().cancel();
                    imageView3.setVisibility(0);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(242977);
            return xVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$convertMedia$3$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
        public static final class a extends com.tencent.mm.plugin.finder.animation.a {
            final /* synthetic */ ImageView tCH;

            a(ImageView imageView) {
                this.tCH = imageView;
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(242976);
                this.tCH.setVisibility(8);
                this.tCH.setAlpha(1.0f);
                this.tCH.setTag(Boolean.FALSE);
                AppMethodBeat.o(242976);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.plugin.finder.convert.o
    public final /* bridge */ /* synthetic */ void a(h hVar, w wVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(242986);
        a(hVar, wVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(242986);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, boolean, int, int] */
    @Override // com.tencent.mm.plugin.finder.convert.o
    public final /* synthetic */ void a(h hVar, w wVar, boolean z, int i2, int i3) {
        AppMethodBeat.i(260216);
        p.h(hVar, "holder");
        p.h(wVar, "item");
        AppMethodBeat.o(260216);
    }

    @Override // com.tencent.mm.plugin.finder.convert.o, com.tencent.mm.view.recyclerview.e
    public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(242985);
        a(hVar, (w) aVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(242985);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.finder.model.BaseFinderFeed, com.tencent.mm.view.recyclerview.h] */
    @Override // com.tencent.mm.plugin.finder.convert.o
    public final /* synthetic */ void g(w wVar, h hVar) {
        AppMethodBeat.i(242988);
        p.h(wVar, "item");
        p.h(hVar, "holder");
        View Mn = hVar.Mn(R.id.czt);
        p.g(Mn, "livingIcon");
        Mn.setVisibility(8);
        AppMethodBeat.o(242988);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed] */
    @Override // com.tencent.mm.plugin.finder.convert.o
    public final /* synthetic */ void g(h hVar, w wVar) {
        AppMethodBeat.i(242982);
        w wVar2 = wVar;
        p.h(hVar, "holder");
        p.h(wVar2, "item");
        LinkedList<cjl> mediaList = wVar2.feedObject.getMediaList();
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        RecyclerView.a adapter = finderMediaBanner.getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
            AppMethodBeat.o(242982);
            throw tVar;
        }
        FinderMediaBannerAdapter finderMediaBannerAdapter = (FinderMediaBannerAdapter) adapter;
        finderMediaBannerAdapter.wrm = finderMediaBanner;
        for (T t : mediaList) {
            Context context = hVar.getContext();
            p.g(context, "holder.context");
            Resources resources = context.getResources();
            p.g(resources, "holder.context.resources");
            t.height = (float) resources.getDisplayMetrics().heightPixels;
            Context context2 = hVar.getContext();
            p.g(context2, "holder.context");
            Resources resources2 = context2.getResources();
            p.g(resources2, "holder.context.resources");
            t.width = (float) resources2.getDisplayMetrics().widthPixels;
        }
        finderMediaBannerAdapter.setItems(mediaList);
        FeedData.a aVar = FeedData.Companion;
        finderMediaBannerAdapter.feed = FeedData.a.i(wVar2.feedObject);
        finderMediaBannerAdapter.dLS = this.dLS;
        finderMediaBannerAdapter.wfg = true;
        finderMediaBannerAdapter.wro = false;
        finderMediaBannerAdapter.wrp = false;
        azy azy = new azy();
        azy.refObjectId = wVar2.feedObject.getRefObjectId();
        azy.refObjectFlag = wVar2.feedObject.getRefObjectFlag();
        azy.refObjectContact = wVar2.feedObject.getRefObjectContact();
        finderMediaBanner.setRefFeedInfo(azy);
        View Mn = hVar.Mn(R.id.ei5);
        if (Mn != null) {
            Mn.setVisibility(0);
        }
        finderMediaBannerAdapter.wft = new b(finderMediaBannerAdapter, Mn, hVar);
        AppMethodBeat.o(242982);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed] */
    @Override // com.tencent.mm.plugin.finder.convert.o
    public final /* synthetic */ void h(h hVar, w wVar) {
        Context context;
        AppMethodBeat.i(242980);
        w wVar2 = wVar;
        p.h(hVar, "holder");
        p.h(wVar2, "item");
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        if (finderMediaBanner != null) {
            finderMediaBanner.setNeedSpaceView(false);
            if (finderMediaBanner.getContext() instanceof Activity) {
                Context context2 = finderMediaBanner.getContext();
                if (context2 == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(242980);
                    throw tVar;
                }
                context = ((Activity) context2).getBaseContext();
            } else {
                context = finderMediaBanner.getContext();
            }
            p.g(context, "baseContext");
            Resources resources = context.getResources();
            p.g(resources, "baseContext.resources");
            int i2 = resources.getDisplayMetrics().widthPixels;
            int displayHeight = getDisplayHeight();
            LinkedList<cjl> mediaList = wVar2.feedObject.getMediaList();
            mediaList.getFirst();
            Iterator<T> it = mediaList.iterator();
            while (it.hasNext()) {
                it.next();
            }
            finderMediaBanner.getPagerView().getLayoutParams().width = i2;
            finderMediaBanner.getPagerView().getLayoutParams().height = displayHeight;
            ViewGroup.LayoutParams layoutParams = finderMediaBanner.getLayoutParams();
            if (layoutParams == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(242980);
                throw tVar2;
            }
            ((FrameLayout.LayoutParams) layoutParams).topMargin = 0;
            finderMediaBanner.requestLayout();
            AppMethodBeat.o(242980);
            return;
        }
        AppMethodBeat.o(242980);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ r(com.tencent.mm.plugin.finder.video.k r8, com.tencent.mm.plugin.finder.feed.i r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            r6 = 242990(0x3b52e, float:3.40502E-40)
            r3 = 0
            r0 = r12 & 8
            if (r0 == 0) goto L_0x001d
            r4 = r3
        L_0x0009:
            r0 = r12 & 16
            if (r0 == 0) goto L_0x001b
            r5 = r3
        L_0x000e:
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x001b:
            r5 = r11
            goto L_0x000e
        L_0x001d:
            r4 = r10
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.r.<init>(com.tencent.mm.plugin.finder.video.k, com.tencent.mm.plugin.finder.feed.i, int, int, int):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(k kVar, i iVar, boolean z, int i2, int i3) {
        super(iVar, z, i2);
        p.h(kVar, "videoCore");
        p.h(iVar, "contract");
        AppMethodBeat.i(242989);
        this.tCD = kVar;
        this.tAi = iVar;
        this.tCE = i3;
        AppMethodBeat.o(242989);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.p;
    }

    @Override // com.tencent.mm.plugin.finder.convert.o, com.tencent.mm.view.recyclerview.e
    @SuppressLint({"ResourceType"})
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(242979);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        super.a(recyclerView, hVar, i2);
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        finderMediaBanner.setAdapter(new FinderMediaBannerAdapter(this.tCD));
        finderMediaBanner.setViewPool(this.tAi.dcf());
        finderMediaBanner.setParentRecyclerView(recyclerView);
        finderMediaBanner.getIndicator().setShowOnlyOneIndicator(false);
        hVar.mf(R.id.xk, 8);
        hVar.mf(R.id.b8z, 8);
        hVar.mf(R.id.hph, 8);
        RecyclerView recyclerView2 = hVar.getRecyclerView();
        p.g(recyclerView2, "holder.recyclerView");
        if (recyclerView2.getParent() == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.RefreshLoadMoreLayout");
            AppMethodBeat.o(242979);
            throw tVar;
        }
        RecyclerView recyclerView3 = hVar.getRecyclerView();
        p.g(recyclerView3, "holder.recyclerView");
        ViewParent parent = recyclerView3.getParent();
        if (parent == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.view.RefreshLoadMoreLayout");
            AppMethodBeat.o(242979);
            throw tVar2;
        }
        ((RefreshLoadMoreLayout) parent).getActionCallback();
        AppMethodBeat.o(242979);
    }

    @Override // com.tencent.mm.plugin.finder.convert.o
    public final void a(h hVar, FinderItem finderItem, Boolean bool) {
        AppMethodBeat.i(242981);
        p.h(hVar, "holder");
        FinderFeedLiveNoticeView finderFeedLiveNoticeView = (FinderFeedLiveNoticeView) hVar.Mn(R.id.cly);
        if (finderFeedLiveNoticeView != null) {
            finderFeedLiveNoticeView.setVisibility(8);
            AppMethodBeat.o(242981);
            return;
        }
        AppMethodBeat.o(242981);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01b7, code lost:
        if (r3.equals("101") != false) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01b9, code lost:
        r2 = "25";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01d1, code lost:
        if (r3.equals("102") != false) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01db, code lost:
        if (r3.equals("999") != false) goto L_0x01b9;
     */
    @Override // com.tencent.mm.plugin.finder.convert.o
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(com.tencent.mm.view.recyclerview.h r19, android.view.View r20, com.tencent.mm.protocal.protobuf.FinderObject r21) {
        /*
        // Method dump skipped, instructions count: 532
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.r.b(com.tencent.mm.view.recyclerview.h, android.view.View, com.tencent.mm.protocal.protobuf.FinderObject):boolean");
    }

    private void a(h hVar, w wVar, int i2, int i3, boolean z, List<Object> list) {
        String str;
        int i4;
        String str2;
        FinderMediaBanner finderMediaBanner;
        AppMethodBeat.i(242984);
        p.h(hVar, "holder");
        p.h(wVar, "item");
        super.a(hVar, (BaseFinderFeed) wVar, i2, i3, z, list);
        awe liveInfo = wVar.feedObject.getLiveInfo();
        int i5 = liveInfo != null ? liveInfo.liveStatus : 2;
        RecyclerView.a adapter = ((FinderMediaBanner) hVar.Mn(R.id.fbd)).getAdapter();
        if (!(adapter instanceof FinderMediaBannerAdapter)) {
            adapter = null;
        }
        FinderMediaBannerAdapter finderMediaBannerAdapter = (FinderMediaBannerAdapter) adapter;
        ImageView imageView = (finderMediaBannerAdapter == null || (finderMediaBanner = finderMediaBannerAdapter.wrm) == null) ? null : (ImageView) finderMediaBanner.findViewById(R.id.imd);
        ImageView imageView2 = (ImageView) hVar.Mn(R.id.coq);
        TextView textView = (TextView) hVar.Mn(R.id.cpy);
        p.g(textView, "logoWidget");
        ao.a(textView.getPaint(), 0.8f);
        cjl cjl = (cjl) j.kt(wVar.feedObject.getLiveMediaList());
        if (cjl == null) {
            StringBuilder sb = new StringBuilder();
            awe liveInfo2 = wVar.feedObject.getLiveInfo();
            Log.i("Finder.FeedFullLiveConvert", sb.append(liveInfo2 != null ? Long.valueOf(liveInfo2.liveId) : null).append(" firstMedia is empty").toString());
        }
        if (cjl == null || (str = cjl.coverUrl) == null) {
            str = "";
        }
        p.g(str, "firstMedia?.coverUrl ?: \"\"");
        if (Util.isNullOrNil(str)) {
            str = p.I(cjl != null ? cjl.thumbUrl : null, Util.nullAsNil(cjl != null ? cjl.thumb_url_token : null));
        }
        StringBuilder sb2 = new StringBuilder("refreshMask item=");
        g gVar = wVar.contact;
        Log.i("Finder.FeedFullLiveConvert", sb2.append(gVar != null ? gVar.getNickname() : null).toString());
        p.g(imageView2, "blurView");
        imageView2.setVisibility(0);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.h(imageView2, str);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (i5 == 1) {
            View Mn = hVar.Mn(R.id.cw_);
            p.g(Mn, "holder.getView<View>(R.i…inder_live_onlive_widget)");
            Mn.setVisibility(0);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            textView.setText(context.getResources().getString(R.string.cs5));
        } else {
            View Mn2 = hVar.Mn(R.id.cw_);
            p.g(Mn2, "holder.getView<View>(R.i…inder_live_onlive_widget)");
            Mn2.setVisibility(8);
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            textView.setText(context2.getResources().getString(R.string.cs3));
            View Mn3 = hVar.Mn(R.id.ei5);
            if (Mn3 != null) {
                Mn3.setVisibility(8);
            }
        }
        g gVar2 = wVar.contact;
        if (gVar2 != null) {
            i4 = gVar2.field_liveStatus;
        } else {
            i4 = 2;
        }
        awe liveInfo3 = wVar.feedObject.getLiveInfo();
        int i6 = liveInfo3 != null ? liveInfo3.LCy : 0;
        FinderLiveOnliveWidget finderLiveOnliveWidget = (FinderLiveOnliveWidget) hVar.Mn(R.id.cw_);
        StringBuilder sb3 = new StringBuilder("[refreshLiveIcon] username:");
        g gVar3 = wVar.contact;
        Log.i("Finder.FeedFullLiveConvert", sb3.append(gVar3 != null ? gVar3.getNickname() : null).append(",liveStatus:").append(i4).append(",participantCount=").append(i6).append(" onliveView is null:").append(finderLiveOnliveWidget == null).toString());
        if (i4 == 1) {
            if (finderLiveOnliveWidget != null) {
                finderLiveOnliveWidget.setVisibility(0);
            }
            if (finderLiveOnliveWidget != null) {
                finderLiveOnliveWidget.setOnClickListener(new c(hVar, wVar));
            }
            awe liveInfo4 = wVar.feedObject.getLiveInfo();
            if ((liveInfo4 != null ? liveInfo4.Vjg : null) != null) {
                if (finderLiveOnliveWidget != null) {
                    awe liveInfo5 = wVar.feedObject.getLiveInfo();
                    if (liveInfo5 == null || (str2 = liveInfo5.Vjg) == null) {
                        str2 = "";
                    }
                    finderLiveOnliveWidget.setText(str2);
                    AppMethodBeat.o(242984);
                    return;
                }
                AppMethodBeat.o(242984);
            } else if (i6 > 0) {
                if (finderLiveOnliveWidget != null) {
                    Context context3 = MMApplicationContext.getContext();
                    p.g(context3, "MMApplicationContext.getContext()");
                    String string = context3.getResources().getString(R.string.d48, Integer.valueOf(i6));
                    p.g(string, "MMApplicationContext.get…member, participantCount)");
                    finderLiveOnliveWidget.setText(string);
                    AppMethodBeat.o(242984);
                    return;
                }
                AppMethodBeat.o(242984);
            } else if (finderLiveOnliveWidget != null) {
                Context context4 = MMApplicationContext.getContext();
                p.g(context4, "MMApplicationContext.getContext()");
                String string2 = context4.getResources().getString(R.string.d47);
                p.g(string2, "MMApplicationContext.get…ing.finder_onlive_status)");
                finderLiveOnliveWidget.setText(string2);
                AppMethodBeat.o(242984);
            } else {
                AppMethodBeat.o(242984);
            }
        } else if (finderLiveOnliveWidget != null) {
            finderLiveOnliveWidget.setVisibility(8);
            AppMethodBeat.o(242984);
        } else {
            AppMethodBeat.o(242984);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ w tCI;

        c(h hVar, w wVar) {
            this.qhp = hVar;
            this.tCI = wVar;
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.i(242978);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$refreshLiveIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            g gVar = this.tCI.contact;
            if (gVar != null) {
                str = gVar.getUsername();
            } else {
                str = null;
            }
            new com.tencent.mm.plugin.finder.view.r(context, str, this.qhp.lR(), this.tCI.feedObject.isLiveFeed()).dzC();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedFullLiveConvert$refreshLiveIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242978);
        }
    }

    @Override // com.tencent.mm.plugin.finder.convert.o
    public final void a(h hVar, View view, MotionEvent motionEvent) {
        AppMethodBeat.i(242987);
        p.h(hVar, "holder");
        p.h(view, "view");
        p.h(motionEvent, "e");
        AppMethodBeat.o(242987);
    }
}
