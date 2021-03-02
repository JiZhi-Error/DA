package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.FinderImageBulletSubtitleLayout;
import com.tencent.mm.plugin.finder.feed.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.report.ag;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.recyclerview.h;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\bH\u0016J@\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00062\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016J \u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\bH\u0016J \u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\"\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "contract", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "safeMode", "", "tabType", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;ZI)V", "isClickMusicTopic", "isClickSwitch", "convertMedia", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "dealWithBgm", "finderObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLayoutId", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaClick", "view", "Landroid/view/View;", "onMediaDoubleClick", "onViewRecycled", "plugin-finder_release"})
public class u extends l<com.tencent.mm.plugin.finder.model.u> {
    private final i tAi;
    private boolean tCT;
    private boolean tCU;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int] */
    @Override // com.tencent.mm.plugin.finder.convert.l
    public final /* synthetic */ void a(h hVar, com.tencent.mm.plugin.finder.model.u uVar, int i2) {
        AppMethodBeat.i(243015);
        com.tencent.mm.plugin.finder.model.u uVar2 = uVar;
        p.h(hVar, "holder");
        p.h(uVar2, "item");
        LinkedList<cjl> mediaList = uVar2.feedObject.getMediaList();
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        RecyclerView.a adapter = finderMediaBanner.getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
            AppMethodBeat.o(243015);
            throw tVar;
        }
        FinderMediaBannerAdapter finderMediaBannerAdapter = (FinderMediaBannerAdapter) adapter;
        finderMediaBannerAdapter.setItems(mediaList);
        FeedData.a aVar = FeedData.Companion;
        FeedData i3 = FeedData.a.i(uVar2.feedObject);
        finderMediaBannerAdapter.feed = i3;
        finderMediaBannerAdapter.dLS = this.dLS;
        azy azy = new azy();
        azy.refObjectId = uVar2.feedObject.getRefObjectId();
        azy.refObjectFlag = uVar2.feedObject.getRefObjectFlag();
        azy.refObjectContact = uVar2.feedObject.getRefObjectContact();
        finderMediaBanner.setRefFeedInfo(azy);
        p.g(finderMediaBanner, "banner");
        a(finderMediaBanner, mediaList, uVar2.feedObject.getId());
        LinearLayout linearLayout = (LinearLayout) hVar.Mn(R.id.jj3);
        if (linearLayout != null) {
            if (uVar2.feedObject.getFeedObject().warnFlag != 0) {
                linearLayout.setVisibility(0);
                TextView textView = (TextView) hVar.Mn(R.id.jj7);
                if (textView != null) {
                    textView.setText(uVar2.feedObject.getFeedObject().warnWording);
                }
            } else {
                linearLayout.setVisibility(8);
            }
        }
        FinderImageBulletSubtitleLayout finderImageBulletSubtitleLayout = (FinderImageBulletSubtitleLayout) hVar.Mn(R.id.dv4);
        if (finderImageBulletSubtitleLayout != null) {
            finderImageBulletSubtitleLayout.tOs.onDetach();
            View Mn = hVar.Mn(R.id.dv3);
            p.g(Mn, "button");
            Mn.setVisibility(8);
            int i4 = this.dLS;
            p.h(i3, "feed");
            finderImageBulletSubtitleLayout.tOs.a(i3, i4);
        }
        a(hVar, uVar2.feedObject);
        AppMethodBeat.o(243015);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.plugin.finder.convert.l
    public /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.plugin.finder.model.u uVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243018);
        a(hVar, uVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(243018);
    }

    @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e
    public /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243017);
        a(hVar, (com.tencent.mm.plugin.finder.model.u) aVar, i2, i3, z, (List<Object>) list);
        AppMethodBeat.o(243017);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(i iVar, boolean z, int i2, int i3) {
        this(iVar, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? 0 : i2);
        AppMethodBeat.i(243021);
        AppMethodBeat.o(243021);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(i iVar, boolean z, int i2) {
        super(iVar, z, i2);
        p.h(iVar, "contract");
        AppMethodBeat.i(165394);
        this.tAi = iVar;
        AppMethodBeat.o(165394);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.s;
    }

    @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(165392);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        super.a(recyclerView, hVar, i2);
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        finderMediaBanner.setAdapter(new FinderMediaBannerAdapter());
        finderMediaBanner.setViewPool(this.tAi.dcf());
        finderMediaBanner.setParentRecyclerView(recyclerView);
        finderMediaBanner.getIndicator().setShowOnlyOneIndicator(true);
        if (finderMediaBanner.getIndicator().getView().getVisibility() == 0 && finderMediaBanner.getStyle() == MediaBanner.d.BOTTOM) {
            finderMediaBanner.getSpaceView().setVisibility(8);
        }
        finderMediaBanner.setPageChangeCallback(new a(hVar));
        FinderImageBulletSubtitleLayout finderImageBulletSubtitleLayout = (FinderImageBulletSubtitleLayout) hVar.Mn(R.id.dv4);
        View Mn = hVar.Mn(R.id.dv3);
        finderImageBulletSubtitleLayout.tOs.a(finderImageBulletSubtitleLayout.tOr);
        Mn.setOnClickListener(new b(this, finderImageBulletSubtitleLayout));
        if (hVar.getContext() instanceof MMActivity) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Context context = hVar.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(165392);
                throw tVar;
            }
            com.tencent.mm.plugin.finder.event.base.c MA = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b((MMActivity) context).get(FinderReporterUIC.class)).MA(this.dLS);
            if (MA != null) {
                MA.a(new c(hVar, finderImageBulletSubtitleLayout, Mn));
                AppMethodBeat.o(165392);
                return;
            }
        }
        AppMethodBeat.o(165392);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
    public static final class a implements MediaBanner.c {
        final /* synthetic */ h qhp;

        a(h hVar) {
            this.qhp = hVar;
        }

        @Override // com.tencent.mm.view.MediaBanner.c
        public final void e(int i2, boolean z, boolean z2) {
            AppMethodBeat.i(243010);
            com.tencent.mm.plugin.finder.model.u uVar = (com.tencent.mm.plugin.finder.model.u) this.qhp.hgv();
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
                    AppMethodBeat.o(243010);
                    return;
                }
            }
            AppMethodBeat.o(243010);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ u tCV;
        final /* synthetic */ FinderImageBulletSubtitleLayout tCW;

        b(u uVar, FinderImageBulletSubtitleLayout finderImageBulletSubtitleLayout) {
            this.tCV = uVar;
            this.tCW = finderImageBulletSubtitleLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243011);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tCV.tCT = true;
            boolean z = !this.tCW.getFunctionSwitch();
            p.g(view, LocaleUtil.ITALIAN);
            view.setSelected(z);
            e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_FEED_BULLET_SUBTITLE_SWITCH_BOOLEAN, Boolean.valueOf(z));
            this.tCW.tOr.L(z, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243011);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0006\u0010\f\u001a\u00020\n¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedImageConvert$onCreateViewHolder$3", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "resetBulletSubtitle", "plugin-finder_release"})
    public static final class c extends d {
        final /* synthetic */ h qhp;
        final /* synthetic */ FinderImageBulletSubtitleLayout tCW;
        final /* synthetic */ View tCX;

        c(h hVar, FinderImageBulletSubtitleLayout finderImageBulletSubtitleLayout, View view) {
            this.qhp = hVar;
            this.tCW = finderImageBulletSubtitleLayout;
            this.tCX = view;
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
            FeedData feedData;
            AppMethodBeat.i(243012);
            p.h(bVar, "ev");
            if (!(bVar instanceof com.tencent.mm.plugin.finder.event.base.h) || (feedData = ((com.tencent.mm.plugin.finder.event.base.h) bVar).tIF) == null || feedData.getMediaType() != 2) {
                this.tCW.tOr.reset(false);
            } else if (this.qhp.lR() != ((com.tencent.mm.plugin.finder.event.base.h) bVar).tID) {
                this.tCW.tOr.reset(false);
                AppMethodBeat.o(243012);
                return;
            } else if (((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 7) {
                this.tCW.tOr.reset(false);
                AppMethodBeat.o(243012);
                return;
            } else if ((((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 0 || ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 5 || ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 6) && this.tCW.getFunctionSwitch() && !this.tCW.tOr.tMF) {
                this.tCW.tOs.bqe();
                this.tCW.tOr.startLoop();
                View view = this.tCX;
                p.g(view, "bulletSubtitleSwitch");
                if (view.getVisibility() == 0) {
                    this.tCW.setBulletSubtitleAlpha(0.3f);
                    AppMethodBeat.o(243012);
                    return;
                }
                this.tCW.setBulletSubtitleAlpha(1.0f);
                AppMethodBeat.o(243012);
                return;
            }
            AppMethodBeat.o(243012);
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final boolean cZD() {
            return false;
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final boolean a(com.tencent.mm.plugin.finder.event.base.c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
            AppMethodBeat.i(243013);
            p.h(cVar, "dispatcher");
            p.h(bVar, "event");
            if (!(bVar instanceof com.tencent.mm.plugin.finder.event.base.h) || !(((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 3 || ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 0 || ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 5 || ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 6 || ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 7)) {
                AppMethodBeat.o(243013);
                return false;
            }
            AppMethodBeat.o(243013);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x018b  */
    @Override // com.tencent.mm.plugin.finder.convert.l
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.view.recyclerview.h r10, android.view.View r11, com.tencent.mm.protocal.protobuf.FinderObject r12) {
        /*
        // Method dump skipped, instructions count: 400
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.u.a(com.tencent.mm.view.recyclerview.h, android.view.View, com.tencent.mm.protocal.protobuf.FinderObject):void");
    }

    public void a(h hVar, com.tencent.mm.plugin.finder.model.u uVar, int i2, int i3, boolean z, List<Object> list) {
        AppMethodBeat.i(243016);
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
        AppMethodBeat.o(243016);
    }

    @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e
    public final void b(h hVar) {
        AppMethodBeat.i(243019);
        p.h(hVar, "holder");
        super.b(hVar);
        y yVar = y.vXH;
        FinderImgFeedMusicTag X = y.X(hVar);
        if (X != null) {
            Log.i("FinderImgFeedMusicPlayer", "[onViewRecycled] viewId:" + X.getId());
            X.dle();
            AppMethodBeat.o(243019);
            return;
        }
        AppMethodBeat.o(243019);
    }

    @Override // com.tencent.mm.plugin.finder.convert.l
    public final void a(h hVar, View view) {
        AppMethodBeat.i(243020);
        p.h(hVar, "holder");
        p.h(view, "view");
        BaseFinderFeed baseFinderFeed = (BaseFinderFeed) hVar.hgv();
        if (!baseFinderFeed.feedObject.isPostFinish()) {
            AppMethodBeat.o(243020);
            return;
        }
        j.a aVar = j.vUw;
        if (!j.vUv.m(baseFinderFeed.feedObject.getFeedObject()).first.booleanValue()) {
            com.tencent.mm.ui.base.u.makeText(view.getContext(), view.getContext().getString(R.string.cn8), 0).show();
        }
        AppMethodBeat.o(243020);
    }
}
