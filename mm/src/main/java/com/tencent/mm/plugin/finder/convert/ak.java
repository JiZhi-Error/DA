package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0004J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nH\u0002J\u001c\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 H\u0016J@\u0010!\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\b2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0016J \u0010&\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010(\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "finalize", "getLayoutId", "jumpToFullVideo", "context", "Landroid/content/Context;", "jumpToMegaVideo", "makeTimeString", "", "d", "onAttachedToRecyclerView", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "onDetachedFromRecyclerView", "onMediaClick", "view", "Landroid/view/View;", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onViewRecycled", "plugin-finder_release"})
public class ak extends l<ad> {
    private final i tAi;
    private final k tCD;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int] */
    @Override // com.tencent.mm.plugin.finder.convert.l
    public final /* synthetic */ void a(h hVar, ad adVar, int i2) {
        LinkedList<BaseFinderFeed> rvFeedList;
        AppMethodBeat.i(243114);
        ad adVar2 = adVar;
        p.h(hVar, "holder");
        p.h(adVar2, "item");
        FinderItem finderItem = adVar2.feedObject;
        List<cjl> subList = (adVar2.feedObject.getId() == 0 ? adVar2.feedObject.getMediaExtList() : adVar2.feedObject.getMediaList()).subList(0, 1);
        p.g(subList, "(if (item.feedObject.get….mediaList).subList(0, 1)");
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        RecyclerView.a adapter = finderMediaBanner.getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
            AppMethodBeat.o(243114);
            throw tVar;
        }
        FinderMediaBannerAdapter finderMediaBannerAdapter = (FinderMediaBannerAdapter) adapter;
        finderMediaBannerAdapter.wrm = finderMediaBanner;
        finderMediaBannerAdapter.setItems(subList);
        FeedData.a aVar = FeedData.Companion;
        finderMediaBannerAdapter.feed = FeedData.a.i(adVar2.feedObject);
        FeedData feedData = finderMediaBannerAdapter.feed;
        if (!(feedData == null || (rvFeedList = feedData.getRvFeedList()) == null)) {
            rvFeedList.add(adVar2);
        }
        finderMediaBannerAdapter.dLS = this.dLS;
        azy azy = new azy();
        azy.refObjectId = adVar2.feedObject.getRefObjectId();
        azy.refObjectFlag = adVar2.feedObject.getRefObjectFlag();
        azy.refObjectContact = adVar2.feedObject.getRefObjectContact();
        finderMediaBanner.setRefFeedInfo(azy);
        p.g(finderMediaBanner, "banner");
        a(finderMediaBanner, subList, adVar2.feedObject.getId());
        LinearLayout linearLayout = (LinearLayout) hVar.Mn(R.id.jj3);
        if (linearLayout != null) {
            if (adVar2.feedObject.getFeedObject().warnFlag != 0) {
                linearLayout.setVisibility(0);
                TextView textView = (TextView) hVar.Mn(R.id.jj7);
                if (textView != null) {
                    textView.setText(adVar2.feedObject.getFeedObject().warnWording);
                }
            } else {
                linearLayout.setVisibility(8);
            }
        }
        a(hVar, finderItem);
        View Mn = hVar.Mn(R.id.esv);
        p.g(Mn, "button");
        Mn.setVisibility(8);
        y yVar = y.vXH;
        if (y.D(adVar2.feedObject)) {
            View Mn2 = hVar.Mn(R.id.clz);
            if (Mn2 != null) {
                Mn2.setVisibility(8);
            }
            View findViewById = hVar.aus.findViewById(R.id.a38);
            p.g(findViewById, "holder.itemView.findViewById<View>(R.id.bgm_iv)");
            findViewById.setVisibility(8);
            TextView textView2 = (TextView) hVar.Mn(R.id.esy);
            p.g(textView2, "tv");
            ao.a(textView2.getPaint(), 0.8f);
            cjl cjl = (cjl) j.kt(adVar2.feedObject.getLongVideoMediaList());
            int i3 = cjl != null ? cjl.videoDuration : 0;
            c cVar = c.vCb;
            if (((long) i3) >= ((long) c.drG()) * 1000) {
                i3 /= 1000;
            }
            textView2.setText(xt(i3 / 60) + ":" + xt(i3 % 60));
            Mn.setVisibility(0);
            Mn.setOnClickListener(new a(this, adVar2, hVar));
        }
        AppMethodBeat.o(243114);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.plugin.finder.convert.l
    public /* bridge */ /* synthetic */ void a(h hVar, ad adVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243117);
        a(hVar, adVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(243117);
    }

    @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e
    public /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243116);
        a(hVar, (ad) aVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(243116);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ak(k kVar, i iVar, boolean z, int i2, int i3) {
        this(kVar, iVar, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? 0 : i2);
        AppMethodBeat.i(243120);
        AppMethodBeat.o(243120);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ak(k kVar, i iVar, boolean z, int i2) {
        super(iVar, z, i2);
        p.h(kVar, "videoCore");
        p.h(iVar, "contract");
        AppMethodBeat.i(165434);
        this.tCD = kVar;
        this.tAi = iVar;
        AppMethodBeat.o(165434);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.z;
    }

    @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(165431);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        super.a(recyclerView, hVar, i2);
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        finderMediaBanner.setAdapter(new FinderMediaBannerAdapter(this.tCD));
        finderMediaBanner.setViewPool(this.tAi.dcf());
        finderMediaBanner.setParentRecyclerView(recyclerView);
        finderMediaBanner.getIndicator().setShowOnlyOneIndicator(false);
        AppMethodBeat.o(165431);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, WxRecyclerAdapter<?> wxRecyclerAdapter) {
        AppMethodBeat.i(243111);
        p.h(recyclerView, "recyclerView");
        p.h(wxRecyclerAdapter, "adapter");
        super.a(recyclerView, wxRecyclerAdapter);
        Log.i("Finder.FeedConvert", "[onAttachedToRecyclerView]...");
        AppMethodBeat.o(243111);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void c(RecyclerView recyclerView) {
        AppMethodBeat.i(243112);
        p.h(recyclerView, "recyclerView");
        super.c(recyclerView);
        Log.i("Finder.FeedConvert", "[onDetachedFromRecyclerView]...");
        AppMethodBeat.o(243112);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(243113);
        Log.d("Finder.FeedConvert", "finalize");
        AppMethodBeat.o(243113);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert$convertMedia$1$3"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ ak tEg;
        final /* synthetic */ ad tEh;
        final /* synthetic */ h tzq;

        a(ak akVar, ad adVar, h hVar) {
            this.tEg = akVar;
            this.tEh = adVar;
            this.tzq = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243110);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert$convertMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ak akVar = this.tEg;
            Context context = this.tzq.getContext();
            p.g(context, "holder.context");
            ak.a(akVar, context, this.tzq);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert$convertMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243110);
        }
    }

    public void a(h hVar, ad adVar, int i2, int i3, boolean z, List<Object> list) {
        AppMethodBeat.i(243115);
        p.h(hVar, "holder");
        p.h(adVar, "item");
        super.a(hVar, (BaseFinderFeed) adVar, i2, i3, z, list);
        if (adVar.isPreview) {
            int n = com.tencent.mm.cb.a.n(hVar.getContext(), R.color.pk);
            View Mn = hVar.Mn(R.id.x1);
            p.g(Mn, "holder.getView<View>(R.id.avatar_iv)");
            Mn.setEnabled(false);
            View Mn2 = hVar.Mn(R.id.fzc);
            p.g(Mn2, "holder.getView<View>(R.id.nickname)");
            Mn2.setEnabled(false);
            a(false, hVar);
            View Mn3 = hVar.Mn(R.id.gdy);
            p.g(Mn3, "holder.getView<TextView>(R.id.poi_name)");
            ((TextView) Mn3).setEnabled(false);
            ((TextView) hVar.Mn(R.id.gdy)).setTextColor(n);
            ((WeImageView) hVar.Mn(R.id.gdq)).setIconColor(n);
            ((TextView) hVar.Mn(R.id.cbj)).setTextColor(n);
            ((WeImageView) hVar.Mn(R.id.cbi)).setIconColor(n);
            View Mn4 = hVar.Mn(R.id.ccn);
            p.g(Mn4, "holder.getView<View>(R.id.fav_op_layout)");
            Mn4.setEnabled(false);
            ((TextView) hVar.Mn(R.id.hpz)).setTextColor(n);
            ((WeImageView) hVar.Mn(R.id.dtu)).setIconColor(n);
            View Mn5 = hVar.Mn(R.id.hph);
            p.g(Mn5, "holder.getView<View>(R.id.share_icon_container)");
            Mn5.setEnabled(false);
            ((TextView) hVar.Mn(R.id.cf2)).setTextColor(n);
            ((WeImageView) hVar.Mn(R.id.dts)).setIconColor(n);
            View Mn6 = hVar.Mn(R.id.xk);
            p.g(Mn6, "holder.getView<View>(R.id.awesome_icon_container)");
            Mn6.setEnabled(false);
            ((TextView) hVar.Mn(R.id.ceh)).setTextColor(n);
            ((WeImageView) hVar.Mn(R.id.dtq)).setIconColor(n);
            View Mn7 = hVar.Mn(R.id.b8z);
            p.g(Mn7, "holder.getView<View>(R.id.comment_icon_container)");
            Mn7.setEnabled(false);
            View Mn8 = hVar.Mn(R.id.ik5);
            p.g(Mn8, "collapseTextLayout");
            Mn8.setEnabled(false);
        }
        AppMethodBeat.o(243115);
    }

    @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e
    public final void b(h hVar) {
        AppMethodBeat.i(243118);
        p.h(hVar, "holder");
        super.b(hVar);
        y yVar = y.vXH;
        FinderImgFeedMusicTag X = y.X(hVar);
        if (X != null) {
            Log.i("FinderImgFeedMusicPlayer", "[onViewRecycled] viewId:" + X.getId());
            X.dle();
            AppMethodBeat.o(243118);
            return;
        }
        AppMethodBeat.o(243118);
    }

    @Override // com.tencent.mm.plugin.finder.convert.l
    public final void a(h hVar, View view, FinderObject finderObject) {
        View view2;
        AppMethodBeat.i(165433);
        p.h(hVar, "holder");
        p.h(view, "view");
        p.h(finderObject, ch.COL_FINDEROBJECT);
        super.a(hVar, view, finderObject);
        View findViewById = view.findViewById(R.id.h5r);
        p.g(findViewById, "view.findViewById<View>(R.id.retry_btn)");
        if (findViewById.getVisibility() == 0) {
            AppMethodBeat.o(165433);
        } else if (this.tCD.weV != finderObject.id) {
            AppMethodBeat.o(165433);
        } else {
            y yVar = y.vXH;
            FinderImgFeedMusicTag X = y.X(hVar);
            if (!(X == null || X.getVisibility() != 0 || (view2 = hVar.aus) == null)) {
                view2.findViewById(R.id.ckd);
            }
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.h(finderObject);
            AppMethodBeat.o(165433);
        }
    }

    private static String xt(int i2) {
        AppMethodBeat.i(243119);
        if (i2 < 10) {
            String concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2));
            AppMethodBeat.o(243119);
            return concat;
        }
        String str = String.valueOf(i2);
        AppMethodBeat.o(243119);
        return str;
    }

    public static final /* synthetic */ void a(ak akVar, Context context, h hVar) {
        long j2;
        long j3;
        String str;
        int i2;
        String str2;
        String str3;
        String str4;
        String str5;
        AppMethodBeat.i(243121);
        ad adVar = (ad) hVar.hgv();
        if (adVar.feedObject.isPostFinish()) {
            Intent intent = new Intent();
            intent.putExtra("KEY_ROUTER_UI", 5);
            y yVar = y.vXH;
            y.a(0, j.listOf(new bm(adVar.feedObject.getFeedObject())), (com.tencent.mm.bw.b) null, intent);
            FinderVideoLayout finderVideoLayout = (FinderVideoLayout) hVar.Mn(R.id.ckd);
            if (finderVideoLayout != null) {
                j2 = finderVideoLayout.getCurrentPosMs();
            } else {
                j2 = 0;
            }
            if (adVar.uOr) {
                c cVar = c.vCb;
                j3 = ((long) c.drG()) * 1000;
            } else {
                j3 = j2;
            }
            intent.putExtra("KEY_VIDEO_START_PLAY_TIME_MS", j3);
            if (akVar.tAi.dbZ()) {
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
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(243121);
                throw tVar;
            }
            ((Activity) context).overridePendingTransition(R.anim.ei, R.anim.s);
            cjl cjl2 = (cjl) j.kt(adVar.feedObject.getLongVideoMediaList());
            int i3 = cjl2 != null ? cjl2.videoDuration : 0;
            c cVar2 = c.vCb;
            if (((long) i3) >= ((long) c.drG()) * 1000) {
                i2 = i3 / 1000;
            } else {
                i2 = i3;
            }
            af afVar2 = af.viA;
            String zs = d.zs(adVar.lT());
            cng megaVideo = adVar.feedObject.getMegaVideo();
            String zs2 = d.zs(megaVideo != null ? megaVideo.id : 0);
            if (dIx == null || (str2 = dIx.sessionId) == null) {
                str2 = "";
            }
            if (dIx == null || (str3 = dIx.sGQ) == null) {
                str3 = "";
            }
            if (dIx == null || (str4 = dIx.sGE) == null) {
                str4 = "";
            }
            af.a(zs, zs2, str2, str3, str4, (long) i2, adVar.uOp, j3);
            AppMethodBeat.o(243121);
            return;
        }
        cjk cjk = new cjk();
        cjk.mediaList.addAll(adVar.feedObject.getLongVideoMediaList());
        com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
        if (context == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(243121);
            throw tVar2;
        }
        com.tencent.mm.plugin.finder.utils.a.a((Activity) context, (ViewAnimHelper.ViewInfo) null, cjk, (azy) null, true, 8);
        AppMethodBeat.o(243121);
    }
}
