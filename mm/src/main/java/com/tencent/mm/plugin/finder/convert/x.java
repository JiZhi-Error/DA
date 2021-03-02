package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u001c\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0016J(\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J \u0010 \u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\"\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u000bH\u0002J \u0010*\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0014H\u0002J\u0018\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "", "type", "enterLiveVisitorUI", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLayoutId", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindFinish", "onCreateViewHolder", "onDetachedFromRecyclerView", "onMediaClick", "view", "Landroid/view/View;", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onMediaDoubleClick", "refreshFooter", "count", "refreshMask", "liveStatus", "setFooterOpLayoutVisibility", "visibility", "plugin-finder_release"})
public final class x extends l<w> {
    private final String TAG;
    private final i tAi;
    private final k tCD;

    public /* synthetic */ x(k kVar, i iVar) {
        this(kVar, iVar, false);
    }

    public static final /* synthetic */ void a(x xVar, h hVar) {
        AppMethodBeat.i(243042);
        super.c(hVar);
        AppMethodBeat.o(243042);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int] */
    @Override // com.tencent.mm.plugin.finder.convert.l
    public final /* synthetic */ void a(h hVar, w wVar, int i2) {
        AppMethodBeat.i(243035);
        w wVar2 = wVar;
        p.h(hVar, "holder");
        p.h(wVar2, "item");
        LinkedList<cjl> mediaList = wVar2.feedObject.getMediaList();
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        RecyclerView.a adapter = finderMediaBanner.getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
            AppMethodBeat.o(243035);
            throw tVar;
        }
        FinderMediaBannerAdapter finderMediaBannerAdapter = (FinderMediaBannerAdapter) adapter;
        finderMediaBannerAdapter.wrm = finderMediaBanner;
        finderMediaBannerAdapter.setItems(mediaList);
        FeedData.a aVar = FeedData.Companion;
        finderMediaBannerAdapter.feed = FeedData.a.i(wVar2.feedObject);
        finderMediaBannerAdapter.pos = i2;
        p.g(finderMediaBanner, "banner");
        a(finderMediaBanner, mediaList, wVar2.feedObject.getId());
        hVar.Mn(R.id.elm).setOnClickListener(new a(this, wVar2, hVar, i2));
        AppMethodBeat.o(243035);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed] */
    @Override // com.tencent.mm.plugin.finder.convert.l
    public final /* synthetic */ void d(h hVar, w wVar) {
        int i2;
        String str;
        FinderMediaBanner finderMediaBanner;
        AppMethodBeat.i(243040);
        w wVar2 = wVar;
        p.h(hVar, "holder");
        p.h(wVar2, "item");
        View Mn = hVar.Mn(R.id.d8r);
        if (Mn != null) {
            Mn.setVisibility(8);
        }
        View Mn2 = hVar.Mn(R.id.gto);
        if (Mn2 != null) {
            Mn2.setVisibility(8);
        }
        View Mn3 = hVar.Mn(R.id.gvw);
        if (Mn3 != null) {
            Mn3.setVisibility(8);
        }
        View Mn4 = hVar.Mn(R.id.clp);
        if (Mn4 != null) {
            Mn4.setVisibility(8);
        }
        awe liveInfo = wVar2.feedObject.getLiveInfo();
        if (liveInfo != null) {
            i2 = liveInfo.LCy;
        } else {
            i2 = 0;
        }
        String gm = com.tencent.mm.plugin.finder.utils.k.gm(2, i2);
        p.g(gm, "FinderFormatUtil.formatN…nfo?.participantCount?:0)");
        a(hVar, gm);
        awe liveInfo2 = wVar2.feedObject.getLiveInfo();
        int i3 = liveInfo2 != null ? liveInfo2.liveStatus : 2;
        RecyclerView.a adapter = ((FinderMediaBanner) hVar.Mn(R.id.fbd)).getAdapter();
        if (!(adapter instanceof FinderMediaBannerAdapter)) {
            adapter = null;
        }
        FinderMediaBannerAdapter finderMediaBannerAdapter = (FinderMediaBannerAdapter) adapter;
        ImageView imageView = (finderMediaBannerAdapter == null || (finderMediaBanner = finderMediaBannerAdapter.wrm) == null) ? null : (ImageView) finderMediaBanner.findViewById(R.id.imd);
        ImageView imageView2 = (ImageView) hVar.Mn(R.id.coq);
        FinderLiveOnliveWidget finderLiveOnliveWidget = (FinderLiveOnliveWidget) hVar.Mn(R.id.cpx);
        View Mn5 = hVar.Mn(R.id.fbg);
        p.g(Mn5, "holder.getView<HardTouch…ut>(R.id.media_container)");
        ViewGroup.LayoutParams layoutParams = ((HardTouchableLayout) Mn5).getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(243040);
            throw tVar;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        p.g(finderLiveOnliveWidget, "logoWidget");
        ViewGroup.LayoutParams layoutParams3 = finderLiveOnliveWidget.getLayoutParams();
        if (layoutParams3 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(243040);
            throw tVar2;
        }
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        layoutParams4.topMargin = layoutParams2.topMargin;
        if (i3 == 1) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            layoutParams4.bottomMargin = context.getResources().getDimensionPixelOffset(R.dimen.cm);
            layoutParams4.gravity = 81;
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            String string = context2.getResources().getString(R.string.cs5);
            p.g(string, "MMApplicationContext.get…inder_live_entry_wording)");
            finderLiveOnliveWidget.setText(string);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            p.g(imageView2, "blurView");
            imageView2.setVisibility(8);
            AppMethodBeat.o(243040);
            return;
        }
        cjl cjl = (cjl) j.kt(wVar2.feedObject.getLiveMediaList());
        if (cjl == null) {
            String str2 = this.TAG;
            StringBuilder sb = new StringBuilder();
            awe liveInfo3 = wVar2.feedObject.getLiveInfo();
            Log.i(str2, sb.append(liveInfo3 != null ? Long.valueOf(liveInfo3.liveId) : null).append(" firstMedia is empty").toString());
        }
        if (cjl == null || (str = cjl.coverUrl) == null) {
            str = "";
        }
        p.g(str, "firstMedia?.coverUrl ?: \"\"");
        if (Util.isNullOrNil(str)) {
            str = p.I(cjl != null ? cjl.thumbUrl : null, Util.nullAsNil(cjl != null ? cjl.thumb_url_token : null));
        }
        m mVar = m.vVH;
        p.g(imageView2, "blurView");
        m.h(imageView2, str);
        imageView2.setVisibility(0);
        imageView2.setLayoutParams(layoutParams2);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        layoutParams4.gravity = 17;
        Context context3 = MMApplicationContext.getContext();
        p.g(context3, "MMApplicationContext.getContext()");
        String string2 = context3.getResources().getString(R.string.cs3);
        p.g(string2, "MMApplicationContext.get…R.string.finder_live_end)");
        finderLiveOnliveWidget.setText(string2);
        FinderLiveOnliveWidget.a(finderLiveOnliveWidget);
        AppMethodBeat.o(243040);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(k kVar, i iVar, boolean z) {
        super(iVar, z);
        p.h(kVar, "videoCore");
        p.h(iVar, "contract");
        AppMethodBeat.i(243041);
        this.tCD = kVar;
        this.tAi = iVar;
        this.TAG = "FinderFeedLiveConvert";
        AppMethodBeat.o(243041);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.u;
    }

    @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243032);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        super.a(recyclerView, hVar, i2);
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        finderMediaBanner.setAdapter(new FinderMediaBannerAdapter(this.tCD));
        finderMediaBanner.setViewPool(this.tAi.dcf());
        finderMediaBanner.setParentRecyclerView(recyclerView);
        a(hVar, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.o(243032);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, WxRecyclerAdapter<?> wxRecyclerAdapter) {
        AppMethodBeat.i(243033);
        p.h(recyclerView, "recyclerView");
        p.h(wxRecyclerAdapter, "adapter");
        super.a(recyclerView, wxRecyclerAdapter);
        Log.i(this.TAG, "[onAttachedToRecyclerView]...");
        AppMethodBeat.o(243033);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void c(RecyclerView recyclerView) {
        AppMethodBeat.i(243034);
        p.h(recyclerView, "recyclerView");
        super.c(recyclerView);
        Log.i(this.TAG, "[onDetachedFromRecyclerView]...");
        AppMethodBeat.o(243034);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedLiveConvert$convertMedia$1$1"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ int oeZ;
        final /* synthetic */ x tDf;
        final /* synthetic */ w tDg;
        final /* synthetic */ h tzq;

        a(x xVar, w wVar, h hVar, int i2) {
            this.tDf = xVar;
            this.tDg = wVar;
            this.tzq = hVar;
            this.oeZ = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243031);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedLiveConvert$convertMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            x.a(this.tDf, this.tzq);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedLiveConvert$convertMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243031);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0211, code lost:
        if (r3.equals("101") != false) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0213, code lost:
        r2 = "25";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x022b, code lost:
        if (r3.equals("102") != false) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0235, code lost:
        if (r3.equals("999") != false) goto L_0x0213;
     */
    @Override // com.tencent.mm.plugin.finder.convert.l
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.view.recyclerview.h r19, android.view.View r20, com.tencent.mm.protocal.protobuf.FinderObject r21) {
        /*
        // Method dump skipped, instructions count: 632
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.x.a(com.tencent.mm.view.recyclerview.h, android.view.View, com.tencent.mm.protocal.protobuf.FinderObject):void");
    }

    @Override // com.tencent.mm.plugin.finder.convert.l
    public final void a(h hVar, View view) {
        AppMethodBeat.i(243037);
        p.h(hVar, "holder");
        p.h(view, "view");
        AppMethodBeat.o(243037);
    }

    private static void a(h hVar, String str) {
        AppMethodBeat.i(243038);
        View Mn = hVar.Mn(R.id.d8k);
        p.g(Mn, "holder.getView<View>(R.id.footer_live_info_layout)");
        Mn.setVisibility(0);
        ((TextView) hVar.Mn(R.id.eh_)).setText(hVar.getContext().getString(R.string.cwh, str));
        AppMethodBeat.o(243038);
    }

    @Override // com.tencent.mm.plugin.finder.convert.l
    public final void a(int i2, h hVar) {
        AppMethodBeat.i(243039);
        p.h(hVar, "holder");
        hVar.mf(R.id.d8r, 8);
        AppMethodBeat.o(243039);
    }
}
