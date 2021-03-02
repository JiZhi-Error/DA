package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.recyclerview.h;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J@\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0016J \u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "formatSecToMin", "", "second", "getLayoutId", "jumpToMegaVideo", "context", "Landroid/content/Context;", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class t extends o<ad> {
    public static final a tCP = new a((byte) 0);
    private final i tAi;
    private final k tCD;

    static {
        AppMethodBeat.i(243008);
        AppMethodBeat.o(243008);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "isPause", "", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "invoke"})
    static final class e extends q implements m<Boolean, FinderVideoLayout.b, x> {
        final /* synthetic */ FeedData UId;
        final /* synthetic */ h qhp;
        final /* synthetic */ FinderFullSeekBarLayout tCS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FeedData feedData, h hVar, FinderFullSeekBarLayout finderFullSeekBarLayout) {
            super(2);
            this.UId = feedData;
            this.qhp = hVar;
            this.tCS = finderFullSeekBarLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, FinderVideoLayout.b bVar) {
            View Mn;
            boolean z;
            AppMethodBeat.i(243000);
            boolean booleanValue = bool.booleanValue();
            y yVar = y.vXH;
            cjl first = this.UId.getMediaList().getFirst();
            p.g(first, "feedData.mediaList.first");
            if (y.k(first)) {
                Mn = this.qhp.Mn(R.id.d43);
            } else {
                Mn = this.qhp.Mn(R.id.clt);
            }
            if (Mn != null) {
                Mn.setAlpha(1.0f);
                Mn.setVisibility(8);
            }
            FinderFullSeekBarLayout finderFullSeekBarLayout = this.tCS;
            if (!booleanValue) {
                z = true;
            } else {
                z = false;
            }
            finderFullSeekBarLayout.setPlaying(z);
            x xVar = x.SXb;
            AppMethodBeat.o(243000);
            return xVar;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.plugin.finder.convert.o
    public final /* bridge */ /* synthetic */ void a(h hVar, ad adVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243005);
        a(hVar, adVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(243005);
    }

    @Override // com.tencent.mm.plugin.finder.convert.o, com.tencent.mm.view.recyclerview.e
    public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243004);
        a(hVar, (ad) aVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(243004);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed] */
    @Override // com.tencent.mm.plugin.finder.convert.o
    public final /* synthetic */ void g(h hVar, ad adVar) {
        LinkedList<BaseFinderFeed> rvFeedList;
        AppMethodBeat.i(243002);
        ad adVar2 = adVar;
        p.h(hVar, "holder");
        p.h(adVar2, "item");
        FeedData.a aVar = FeedData.Companion;
        FeedData i2 = FeedData.a.i(adVar2.feedObject);
        List<cjl> subList = i2.getMediaList().subList(0, 1);
        p.g(subList, "feedData.mediaList.subList(0, 1)");
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        RecyclerView.a adapter = finderMediaBanner.getAdapter();
        if (adapter == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
            AppMethodBeat.o(243002);
            throw tVar;
        }
        FinderMediaBannerAdapter finderMediaBannerAdapter = (FinderMediaBannerAdapter) adapter;
        finderMediaBannerAdapter.wrm = finderMediaBanner;
        finderMediaBanner.getPagerView().setFrozeTouch(true);
        finderMediaBannerAdapter.setItems(subList);
        finderMediaBannerAdapter.feed = i2;
        FeedData feedData = finderMediaBannerAdapter.feed;
        if (!(feedData == null || (rvFeedList = feedData.getRvFeedList()) == null)) {
            rvFeedList.add(adVar2);
        }
        finderMediaBannerAdapter.dLS = this.dLS;
        finderMediaBannerAdapter.wfg = true;
        finderMediaBannerAdapter.wro = false;
        finderMediaBannerAdapter.wrp = false;
        FinderFullSeekBarLayout finderFullSeekBarLayout = (FinderFullSeekBarLayout) hVar.Mn(R.id.dc5);
        finderMediaBannerAdapter.wrq = finderFullSeekBarLayout;
        finderMediaBanner.getPagerView().setItemViewCacheSize(3);
        azy azy = new azy();
        azy.refObjectId = adVar2.feedObject.getRefObjectId();
        azy.refObjectFlag = adVar2.feedObject.getRefObjectFlag();
        azy.refObjectContact = adVar2.feedObject.getRefObjectContact();
        finderMediaBanner.setRefFeedInfo(azy);
        finderMediaBannerAdapter.wfs = new e(i2, hVar, finderFullSeekBarLayout);
        TextView textView = (TextView) hVar.Mn(R.id.fbv);
        if (textView != null) {
            Context context = hVar.getContext();
            p.g(context, "holder.context");
            textView.setText(context.getResources().getString(R.string.dbb));
        }
        if (adVar2.feedObject.isLongVideo()) {
            View Mn = hVar.Mn(R.id.dbq);
            if (Mn != null) {
                Mn.setVisibility(0);
            }
            View Mn2 = hVar.Mn(R.id.j6k);
            if (Mn2 != null) {
                Mn2.setVisibility(8);
            }
            TextView textView2 = (TextView) hVar.Mn(R.id.et3);
            if (textView2 != null) {
                int i3 = i2.getMediaList().getFirst().videoDuration;
                ae aeVar = ae.SYK;
                String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(((long) i3) / 60), Long.valueOf(((long) i3) % 60)}, 2));
                p.g(format, "java.lang.String.format(format, *args)");
                textView2.setText(format);
            }
        } else {
            View Mn3 = hVar.Mn(R.id.dbq);
            if (Mn3 != null) {
                Mn3.setVisibility(8);
            }
            View Mn4 = hVar.Mn(R.id.j6k);
            if (Mn4 != null) {
                Mn4.setVisibility(0);
            }
        }
        FinderFullSeekBarLayout finderFullSeekBarLayout2 = (FinderFullSeekBarLayout) hVar.Mn(R.id.dc5);
        finderFullSeekBarLayout2.setOnPauseClickListener(new b(this, hVar));
        finderFullSeekBarLayout2.setPlayingCallback(new c(this, hVar));
        finderFullSeekBarLayout2.setOnLongVideoBtnClickListener(new d(this, hVar));
        g(hVar);
        AppMethodBeat.o(243002);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(k kVar, i iVar, boolean z, int i2, int i3) {
        this(kVar, iVar, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? 0 : i2);
        AppMethodBeat.i(243007);
        AppMethodBeat.o(243007);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(k kVar, i iVar, boolean z, int i2) {
        super(iVar, z, i2);
        p.h(kVar, "videoCore");
        p.h(iVar, "contract");
        AppMethodBeat.i(243006);
        this.tCD = kVar;
        this.tAi = iVar;
        AppMethodBeat.o(243006);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.r;
    }

    @Override // com.tencent.mm.plugin.finder.convert.o, com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243001);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        super.a(recyclerView, hVar, i2);
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        finderMediaBanner.setAdapter(new FinderMediaBannerAdapter(this.tCD));
        finderMediaBanner.setViewPool(this.tAi.dcf());
        finderMediaBanner.setParentRecyclerView(recyclerView);
        finderMediaBanner.getIndicator().setShowOnlyOneIndicator(false);
        AppMethodBeat.o(243001);
    }

    private void a(h hVar, ad adVar, int i2, int i3, boolean z, List<Object> list) {
        AppMethodBeat.i(243003);
        p.h(hVar, "holder");
        p.h(adVar, "item");
        super.a(hVar, (BaseFinderFeed) adVar, i2, i3, z, list);
        if (adVar.isPreview) {
            int n = com.tencent.mm.cb.a.n(hVar.getContext(), R.color.pl);
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
                AppMethodBeat.o(243003);
                return;
            }
        }
        AppMethodBeat.o(243003);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$convertMedia$4$1"})
    static final class b extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ t tCQ;
        final /* synthetic */ h tzq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(t tVar, h hVar) {
            super(0);
            this.tCQ = tVar;
            this.tzq = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(242997);
            FinderVideoLayout finderVideoLayout = (FinderVideoLayout) this.tzq.Mn(R.id.ckd);
            if (finderVideoLayout == null) {
                z = true;
            } else if (finderVideoLayout.dFG()) {
                finderVideoLayout.Q(true, true);
                z = true;
            } else {
                finderVideoLayout.Q(false, true);
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(242997);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$convertMedia$4$2"})
    static final class c extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ t tCQ;
        final /* synthetic */ h tzq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(t tVar, h hVar) {
            super(0);
            this.tCQ = tVar;
            this.tzq = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(242998);
            FinderVideoLayout finderVideoLayout = (FinderVideoLayout) this.tzq.Mn(R.id.ckd);
            if (finderVideoLayout == null || !finderVideoLayout.dFG()) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(242998);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedFullVideoConvert$convertMedia$4$3"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ t tCQ;
        final /* synthetic */ h tzq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(t tVar, h hVar) {
            super(0);
            this.tCQ = tVar;
            this.tzq = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(242999);
            t tVar = this.tCQ;
            Context context = this.tzq.getContext();
            p.g(context, "holder.context");
            t.a(tVar, context, this.tzq);
            x xVar = x.SXb;
            AppMethodBeat.o(242999);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(t tVar, Context context, h hVar) {
        String str;
        int i2;
        long j2;
        String str2;
        String str3;
        String str4;
        String str5;
        AppMethodBeat.i(243009);
        ad adVar = (ad) hVar.hgv();
        if (adVar.feedObject.isPostFinish()) {
            Intent intent = new Intent();
            intent.putExtra("KEY_ROUTER_UI", 5);
            y yVar = y.vXH;
            y.a(0, j.listOf(new bm(adVar.feedObject.getFeedObject())), (com.tencent.mm.bw.b) null, intent);
            FinderVideoLayout finderVideoLayout = (FinderVideoLayout) hVar.Mn(R.id.ckd);
            long currentPosMs = finderVideoLayout != null ? finderVideoLayout.getCurrentPosMs() : 0;
            intent.putExtra("KEY_VIDEO_START_PLAY_TIME_MS", currentPosMs);
            if (tVar.tAi.dbZ()) {
                intent.putExtra("finder_username", z.aUg());
                intent.putExtra("KEY_FINDER_SELF_FLAG", true);
            }
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            Context context2 = hVar.getContext();
            p.g(context2, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context2);
            bbn dIx = fH != null ? fH.dIx() : null;
            af afVar = af.viA;
            cjl cjl = (cjl) j.kt(adVar.feedObject.getLongVideoMediaList());
            if (cjl == null || (str5 = cjl.mediaId) == null) {
                str = "";
            } else {
                str = str5;
            }
            af.dB(str, dIx != null ? dIx.tCE : 0);
            com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.ag(context, intent);
            if (context == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(243009);
                throw tVar2;
            }
            ((Activity) context).overridePendingTransition(R.anim.ei, R.anim.s);
            cjl cjl2 = (cjl) j.kt(adVar.feedObject.getLongVideoMediaList());
            int i3 = cjl2 != null ? cjl2.videoDuration : 0;
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (((long) i3) >= ((long) com.tencent.mm.plugin.finder.storage.c.drG()) * 1000) {
                i2 = i3 / 1000;
            } else {
                i2 = i3;
            }
            af afVar2 = af.viA;
            String zs = com.tencent.mm.ac.d.zs(adVar.lT());
            cng megaVideo = adVar.feedObject.getMegaVideo();
            if (megaVideo != null) {
                j2 = megaVideo.id;
            } else {
                j2 = 0;
            }
            String zs2 = com.tencent.mm.ac.d.zs(j2);
            if (dIx == null || (str2 = dIx.sessionId) == null) {
                str2 = "";
            }
            if (dIx == null || (str3 = dIx.sGQ) == null) {
                str3 = "";
            }
            if (dIx == null || (str4 = dIx.sGE) == null) {
                str4 = "";
            }
            af.a(zs, zs2, str2, str3, str4, (long) i2, adVar.uOp, currentPosMs);
            AppMethodBeat.o(243009);
            return;
        }
        cjk cjk = new cjk();
        cjk.mediaList.addAll(adVar.feedObject.getLongVideoMediaList());
        com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
        if (context == null) {
            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(243009);
            throw tVar3;
        }
        com.tencent.mm.plugin.finder.utils.a.a((Activity) context, (ViewAnimHelper.ViewInfo) null, cjk, (azy) null, true, 8);
        AppMethodBeat.o(243009);
    }
}
