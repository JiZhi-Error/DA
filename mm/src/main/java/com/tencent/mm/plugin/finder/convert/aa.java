package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.report.ag;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.recyclerview.h;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J \u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nH\u0016J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "getLayoutId", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaClick", "view", "Landroid/view/View;", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "plugin-finder_release"})
public class aa extends l<com.tencent.mm.plugin.finder.model.aa> {
    public static final a tDy = new a((byte) 0);
    private final i tAi;
    private final k tCD;

    static {
        AppMethodBeat.i(165404);
        AppMethodBeat.o(165404);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int] */
    @Override // com.tencent.mm.plugin.finder.convert.l
    public final /* synthetic */ void a(h hVar, com.tencent.mm.plugin.finder.model.aa aaVar, int i2) {
        AppMethodBeat.i(243075);
        com.tencent.mm.plugin.finder.model.aa aaVar2 = aaVar;
        p.h(hVar, "holder");
        p.h(aaVar2, "item");
        LinkedList<cjl> mediaExtList = aaVar2.feedObject.getId() == 0 ? aaVar2.feedObject.getMediaExtList() : aaVar2.feedObject.getMediaList();
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        RecyclerView.a adapter = finderMediaBanner.getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
            AppMethodBeat.o(243075);
            throw tVar;
        }
        FinderMediaBannerAdapter finderMediaBannerAdapter = (FinderMediaBannerAdapter) adapter;
        finderMediaBannerAdapter.setItems(mediaExtList);
        FeedData.a aVar = FeedData.Companion;
        finderMediaBannerAdapter.feed = FeedData.a.i(aaVar2.feedObject);
        azy azy = new azy();
        azy.refObjectId = aaVar2.feedObject.getRefObjectId();
        azy.refObjectFlag = aaVar2.feedObject.getRefObjectFlag();
        azy.refObjectContact = aaVar2.feedObject.getRefObjectContact();
        finderMediaBanner.setRefFeedInfo(azy);
        p.g(finderMediaBanner, "banner");
        a(finderMediaBanner, mediaExtList, aaVar2.feedObject.getId());
        AppMethodBeat.o(243075);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ aa(k kVar, i iVar, boolean z, int i2, int i3) {
        this(kVar, iVar, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? 0 : i2);
        AppMethodBeat.i(243076);
        AppMethodBeat.o(243076);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private aa(k kVar, i iVar, boolean z, int i2) {
        super(iVar, z, i2);
        p.h(kVar, "videoCore");
        p.h(iVar, "contract");
        AppMethodBeat.i(165402);
        this.tCD = kVar;
        this.tAi = iVar;
        AppMethodBeat.o(165402);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.w;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(165399);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        super.a(recyclerView, hVar, i2);
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        finderMediaBanner.setAdapter(new FinderMediaBannerAdapter(this.tCD));
        finderMediaBanner.setViewPool(this.tAi.dcf());
        finderMediaBanner.setParentRecyclerView(recyclerView);
        finderMediaBanner.setPageChangeCallback(new b(hVar));
        AppMethodBeat.o(165399);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedMixConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
    public static final class b implements MediaBanner.c {
        final /* synthetic */ h qhp;

        b(h hVar) {
            this.qhp = hVar;
        }

        @Override // com.tencent.mm.view.MediaBanner.c
        public final void e(int i2, boolean z, boolean z2) {
            c a2;
            AppMethodBeat.i(243074);
            com.tencent.mm.plugin.finder.model.aa aaVar = (com.tencent.mm.plugin.finder.model.aa) this.qhp.hgv();
            cjl cjl = aaVar.feedObject.getMediaList().get(i2);
            p.g(cjl, "feed.feedObject.mediaList[position]");
            cjl cjl2 = cjl;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (fH == null || (a2 = FinderReporterUIC.a(fH)) == null) {
                AppMethodBeat.o(243074);
                return;
            }
            ag.a doV = new ag(a2).doV();
            long id = aaVar.feedObject.getId();
            String objectNonceId = aaVar.feedObject.getObjectNonceId();
            LinkedList<cjl> linkedList = new LinkedList<>(aaVar.feedObject.getMediaList());
            p.g(aaVar, "feed");
            doV.a(id, cjl2, objectNonceId, i2, linkedList, aaVar, z2);
            AppMethodBeat.o(243074);
        }
    }

    @Override // com.tencent.mm.plugin.finder.convert.l
    public final void a(h hVar, View view, FinderObject finderObject) {
        AppMethodBeat.i(165401);
        p.h(hVar, "holder");
        p.h(view, "view");
        p.h(finderObject, ch.COL_FINDEROBJECT);
        super.a(hVar, view, finderObject);
        View findViewById = view.findViewById(R.id.gcc);
        if (p.j(findViewById != null ? findViewById.getTag() : null, Boolean.FALSE)) {
            AppMethodBeat.o(165401);
            return;
        }
        View findViewById2 = view.findViewById(R.id.h5r);
        if (findViewById2 != null && findViewById2.getVisibility() == 0) {
            AppMethodBeat.o(165401);
        } else if (this.tCD.weV != finderObject.id) {
            AppMethodBeat.o(165401);
        } else {
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.h(finderObject);
            AppMethodBeat.o(165401);
        }
    }
}
