package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J@\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00072\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0016J \u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0014H\u0016R\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderProfileGridConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", ch.COL_USERNAME, "", "isSelfFlag", "", "isShowLikeCount", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;Ljava/lang/String;ZZ)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "jumpAtTimeline", "", "context", "Landroid/content/Context;", "pos", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class bz extends ae {
    private String TAG;
    final BaseFinderFeedLoader tFM;
    final boolean tFN;
    private final boolean tFO;
    final String username;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.plugin.finder.convert.ae, com.tencent.mm.view.recyclerview.e
    public final /* bridge */ /* synthetic */ void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243248);
        a(hVar, baseFinderFeed, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(243248);
    }

    public /* synthetic */ bz(BaseFinderFeedLoader baseFinderFeedLoader, String str, boolean z, byte b2) {
        this(baseFinderFeedLoader, str, z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private bz(BaseFinderFeedLoader baseFinderFeedLoader, String str, boolean z) {
        super(R.layout.ac3);
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(243249);
        this.tFM = baseFinderFeedLoader;
        this.username = str;
        this.tFN = z;
        this.tFO = false;
        this.TAG = "Finder.FinderFeedGridConvert";
        AppMethodBeat.o(243249);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ RecyclerView tDJ;
        final /* synthetic */ bz tFP;

        a(bz bzVar, h hVar, RecyclerView recyclerView) {
            this.tFP = bzVar;
            this.qhp = hVar;
            this.tDJ = recyclerView;
        }

        public final void onClick(View view) {
            int i2;
            DataBuffer dataListJustForAdapter;
            DataBuffer dataListJustForAdapter2;
            AppMethodBeat.i(243245);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderProfileGridConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            BaseFinderFeed baseFinderFeed = (BaseFinderFeed) this.qhp.hgv();
            bz bzVar = this.tFP;
            Context context = this.tDJ.getContext();
            p.g(context, "recyclerView.context");
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFP.tFM;
            if (baseFinderFeedLoader == null || (dataListJustForAdapter2 = baseFinderFeedLoader.getDataListJustForAdapter()) == null) {
                i2 = 0;
            } else {
                i2 = dataListJustForAdapter2.indexOf(baseFinderFeed);
            }
            p.g(baseFinderFeed, "item");
            Intent intent = new Intent();
            BaseFinderFeedLoader baseFinderFeedLoader2 = bzVar.tFM;
            if (baseFinderFeedLoader2 != null) {
                BaseFeedLoader.saveCache$default(baseFinderFeedLoader2, intent, i2, null, 4, null);
            }
            BaseFinderFeedLoader baseFinderFeedLoader3 = bzVar.tFM;
            if (!(baseFinderFeedLoader3 == null || (dataListJustForAdapter = baseFinderFeedLoader3.getDataListJustForAdapter()) == null)) {
                y yVar = y.vXH;
                y.a(i2, dataListJustForAdapter, bzVar.tFM.getLastBuffer(), intent);
            }
            intent.putExtra("KEY_FROM_SCENE", 1);
            intent.putExtra("KEY_USERNAME", bzVar.username);
            intent.putExtra("KEY_FINDER_SELF_FLAG", bzVar.tFN);
            intent.putExtra("KEY_TITLE", context.getResources().getString(R.string.ci5));
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC.a.a(context, intent, 0, 0, false, 124);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.ab(context, intent);
            k kVar = k.vfA;
            k.J(baseFinderFeed.lT(), 1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileGridConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243245);
        }
    }

    @Override // com.tencent.mm.plugin.finder.convert.ae, com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243246);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        hVar.aus.setOnClickListener(new a(this, hVar, recyclerView));
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        WeImageView weImageView = (WeImageView) view.findViewById(R.id.xi);
        p.g(weImageView, "holder.itemView.awesomeIv");
        weImageView.setEnabled(false);
        AppMethodBeat.o(243246);
    }

    @Override // com.tencent.mm.plugin.finder.convert.ae
    public final void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List<Object> list) {
        AppMethodBeat.i(243247);
        p.h(hVar, "holder");
        p.h(baseFinderFeed, "item");
        cjl cjl = (cjl) j.ks(baseFinderFeed.feedObject.getMediaList());
        ImageView imageView = (ImageView) hVar.Mn(R.id.cma);
        if (cjl.mediaType == 4) {
            com.tencent.mm.plugin.finder.loader.k kVar = new com.tencent.mm.plugin.finder.loader.k(cjl, x.THUMB_IMAGE, null, null, 12);
            m mVar = m.uJa;
            d<o> djY = m.djY();
            p.g(imageView, "imageView");
            m mVar2 = m.uJa;
            djY.a(kVar, imageView, m.a(m.a.TIMELINE));
        } else {
            m mVar3 = m.uJa;
            d<o> djY2 = m.djY();
            com.tencent.mm.plugin.finder.loader.k kVar2 = new com.tencent.mm.plugin.finder.loader.k(cjl, x.THUMB_IMAGE, null, null, 12);
            p.g(imageView, "imageView");
            m mVar4 = m.uJa;
            djY2.a(kVar2, imageView, m.a(m.a.TIMELINE));
        }
        if (!this.tFO || baseFinderFeed.feedObject.getLikeCount() <= 0) {
            View Mn = hVar.Mn(R.id.e2s);
            p.g(Mn, "holder.getView<View>(R.id.item_like_count_layout)");
            Mn.setVisibility(8);
        } else {
            View Mn2 = hVar.Mn(R.id.e2s);
            p.g(Mn2, "holder.getView<View>(R.id.item_like_count_layout)");
            Mn2.setVisibility(0);
            View Mn3 = hVar.Mn(R.id.e2t);
            p.g(Mn3, "holder.getView<TextView>(R.id.item_like_count_tv)");
            ((TextView) Mn3).setText(com.tencent.mm.plugin.finder.utils.k.gm(2, baseFinderFeed.feedObject.getLikeCount()));
        }
        View Mn4 = hVar.Mn(R.id.dun);
        p.g(Mn4, "holder.getView<ImageView>(R.id.if_item_image)");
        ((ImageView) Mn4).setVisibility(baseFinderFeed instanceof u ? 0 : 8);
        AppMethodBeat.o(243247);
    }
}
