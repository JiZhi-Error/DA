package com.tencent.mm.plugin.finder.view.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.feed.d;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.FinderVideoSeekBar;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.video.q;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.vfs.s;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 Q2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001QB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00022\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020(H\u0016J\u0018\u0010G\u001a\u0002072\u0006\u0010H\u001a\u00020I2\u0006\u0010F\u001a\u00020(H\u0016J\u0018\u0010J\u001a\u0002072\u0006\u0010H\u001a\u00020I2\u0006\u0010F\u001a\u00020(H\u0016J\u0018\u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020(H\u0014J\u0018\u0010O\u001a\u00020\u00032\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020(H\u0016J\u0010\u0010P\u001a\u0002072\u0006\u0010H\u001a\u00020IH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010!\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010#\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010%\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,RN\u00100\u001a6\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u000105¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u000207\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000RN\u0010<\u001a6\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u000105¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(6\u0012\u0004\u0012\u000207\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00109\"\u0004\b?\u0010;¨\u0006R"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/adapter/FinderMediaBannerAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "Landroid/view/View;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;)V", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setBanner", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "forbidVideoLayoutClickable", "", "getForbidVideoLayoutClickable", "()Z", "setForbidVideoLayoutClickable", "(Z)V", "fullVideoSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "getFullVideoSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "setFullVideoSeekBar", "(Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;)V", "isEnableFullScreenEnjoy", "setEnableFullScreenEnjoy", "isLongVideo", "setLongVideo", "isSupportBulletSubtitle", "setSupportBulletSubtitle", "isSupportVideoProgress", "setSupportVideoProgress", "pos", "", "getPos", "()I", "setPos", "(I)V", "tabType", "getTabType", "setTabType", "thumbShowCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isShow", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "playInfo", "", "getThumbShowCallback", "()Lkotlin/jvm/functions/Function2;", "setThumbShowCallback", "(Lkotlin/jvm/functions/Function2;)V", "videoPauseCallback", "isPause", "getVideoPauseCallback", "setVideoPauseCallback", "attachFinderImage", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "mediaObj", "type", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "getItemViewType", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "onBindViewHolderImpl", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "onCreateItemViewImpl", "onViewRecycled", "Companion", "plugin-finder_release"})
public class FinderMediaBannerAdapter extends com.tencent.mm.ui.base.a.a<cjl, View> {
    public static final a wrr = new a((byte) 0);
    public int dLS;
    public FeedData feed;
    public boolean isLongVideo;
    public int pos;
    private final k tCD;
    public boolean wfg;
    public m<? super Boolean, ? super FinderVideoLayout.b, x> wfs;
    public m<? super Boolean, ? super FinderVideoLayout.b, x> wft;
    public FinderMediaBanner wrm;
    private boolean wrn;
    public boolean wro;
    public boolean wrp;
    public FinderFullSeekBarLayout wrq;

    static {
        AppMethodBeat.i(168454);
        AppMethodBeat.o(168454);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    public static final class b<T, R> implements e<o, Bitmap> {
        final /* synthetic */ cjl wrs;

        b(cjl cjl) {
            this.wrs = cjl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<o> aVar, g gVar, Bitmap bitmap) {
            AppMethodBeat.i(255155);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                pw pwVar = new pw();
                int boW = (int) s.boW(aVar.value().getPath());
                pw.a aVar2 = pwVar.dVW;
                aVar2.mediaId = this.wrs.mediaId;
                aVar2.type = 2;
                aVar2.size = boW;
                EventCenter.instance.publish(pwVar);
                Log.i("Finder.MediaBannerAdapter", this.wrs.mediaId + " [" + bitmap2.getWidth() + ':' + bitmap2.getHeight() + "] fileLength=" + Util.getSizeKB((long) boW) + " allocationByteCount=" + Util.getSizeKB((long) bitmap2.getAllocationByteCount()));
                AppMethodBeat.o(255155);
                return;
            }
            AppMethodBeat.o(255155);
        }
    }

    public /* synthetic */ FinderMediaBannerAdapter() {
        this(null);
    }

    public FinderMediaBannerAdapter(k kVar) {
        this.tCD = kVar;
        this.wro = true;
        this.wrp = true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(com.tencent.mm.ui.base.a.b bVar) {
        String str;
        FinderVideoLayout.b bVar2;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(255156);
        com.tencent.mm.ui.base.a.b bVar3 = bVar;
        p.h(bVar3, "holder");
        super.a(bVar3);
        FinderVideoLayout finderVideoLayout = (FinderVideoLayout) bVar3.Mn(R.id.ckd);
        if (finderVideoLayout != null) {
            StringBuilder sb = new StringBuilder("[onViewRecycled] ");
            FinderVideoLayout.b bVar4 = finderVideoLayout.wfp;
            if (bVar4 != null) {
                str = bVar4.mediaId;
            } else {
                str = null;
            }
            Log.i("Finder.VideoLayout", sb.append(str).toString());
            FinderVideoLayout.b bVar5 = finderVideoLayout.wfp;
            if (bVar5 != null && bVar5.wbG && (bVar2 = finderVideoLayout.wfp) != null && bVar2.wfz) {
                FinderVideoStateCacheVM finderVideoStateCacheVM = finderVideoLayout.wfe;
                FinderVideoLayout.b bVar6 = finderVideoLayout.wfp;
                if (bVar6 == null) {
                    p.hyc();
                }
                String str2 = bVar6.mediaId;
                q qVar = finderVideoLayout.wfq;
                if (qVar != null) {
                    i2 = qVar.getCurrentProgress();
                } else {
                    i2 = 0;
                }
                r rVar = finderVideoLayout.wfl;
                if (rVar != null) {
                    i3 = rVar.getCurrentPlaySecond();
                }
                finderVideoStateCacheVM.ah(str2, i2, i3);
            }
            finderVideoLayout.pause(true);
            d dVar = finderVideoLayout.tOs;
            if (dVar != null) {
                dVar.onDetach();
                AppMethodBeat.o(255156);
                return;
            }
            AppMethodBeat.o(255156);
            return;
        }
        AppMethodBeat.o(255156);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // com.tencent.mm.ui.base.a.a, android.support.v7.widget.RecyclerView.a
    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.ui.base.a.b bVar, int i2) {
        AppMethodBeat.i(168452);
        a(bVar, i2);
        AppMethodBeat.o(168452);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/adapter/FinderMediaBannerAdapter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.base.a.a
    public final View l(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(168449);
        p.h(viewGroup, "parent");
        p.h(viewGroup, "parent");
        if (i2 == 4 || i2 == 9) {
            View inflate = aa.jQ(viewGroup.getContext()).inflate(R.layout.agj, viewGroup, false);
            if (inflate == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.FinderVideoLayout");
                AppMethodBeat.o(168449);
                throw tVar;
            }
            FinderVideoLayout finderVideoLayout = (FinderVideoLayout) inflate;
            k kVar = this.tCD;
            if (kVar == null) {
                p.hyc();
            }
            finderVideoLayout.setVideoCore(kVar);
            AppMethodBeat.o(168449);
            return inflate;
        } else if (i2 == 2 || i2 == 7) {
            View inflate2 = aa.jQ(viewGroup.getContext()).inflate(R.layout.agh, viewGroup, false);
            p.g(inflate2, "MMLayoutInflater.getInfl…container, parent, false)");
            AppMethodBeat.o(168449);
            return inflate2;
        } else {
            View view = new View(viewGroup.getContext());
            AppMethodBeat.o(168449);
            return view;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(168450);
        int i3 = ((cjl) this.cvc.get(i2)).mediaType;
        AppMethodBeat.o(168450);
        return i3;
    }

    @Override // com.tencent.mm.ui.base.a.a
    public final void a(com.tencent.mm.ui.base.a.b bVar, int i2) {
        FinderLongVideoPlayerSeekBar longVideoSeekBar;
        int i3;
        com.tencent.mm.loader.d<o> djZ;
        i kVar;
        com.tencent.mm.loader.e.d dVar;
        com.tencent.mm.loader.c.e a2;
        AppMethodBeat.i(168451);
        p.h(bVar, "holder");
        super.a(bVar, i2);
        bVar.et(getItemAtPosition(i2));
        p.h(bVar, "holder");
        switch (getItemViewType(i2)) {
            case 2:
            case 7:
                cjl cjl = (cjl) getItemAtPosition(i2);
                ImageView imageView = (ImageView) bVar.Mn(R.id.ckc);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                p.g(imageView, "imageView");
                imageView.setLayoutParams(layoutParams);
                layoutParams.gravity = 17;
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                if (this.wfg) {
                    com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                    djZ = com.tencent.mm.plugin.finder.loader.m.djY();
                } else {
                    com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                    djZ = com.tencent.mm.plugin.finder.loader.m.djZ();
                }
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                p.g(cjl, "item");
                com.tencent.mm.plugin.finder.storage.x xVar = com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE;
                if (this.wfg) {
                    kVar = new i(cjl, xVar);
                } else {
                    kVar = new com.tencent.mm.plugin.finder.loader.k(cjl, xVar, null, null, 12);
                }
                com.tencent.mm.loader.a.b<o, Bitmap> bQ = djZ.bQ(kVar);
                c cVar = c.vCb;
                if (c.dtK().value().intValue() > 0) {
                    dVar = new com.tencent.mm.loader.e.d(null, null, 3);
                } else {
                    dVar = null;
                }
                com.tencent.mm.loader.b<o, Bitmap> a3 = bQ.a(dVar);
                if (this.wfg) {
                    com.tencent.mm.plugin.finder.loader.m mVar3 = com.tencent.mm.plugin.finder.loader.m.uJa;
                    a2 = com.tencent.mm.plugin.finder.loader.m.a(m.a.DARK_TIMELINE);
                } else {
                    com.tencent.mm.plugin.finder.loader.m mVar4 = com.tencent.mm.plugin.finder.loader.m.uJa;
                    a2 = com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE);
                }
                a3.a(a2).a(new b(cjl)).c(imageView);
                AppMethodBeat.o(168451);
                return;
            case 4:
                FinderVideoLayout finderVideoLayout = (FinderVideoLayout) bVar.Mn(R.id.ckd);
                finderVideoLayout.setLongVideo(this.isLongVideo);
                FeedData feedData = this.feed;
                if (feedData != null) {
                    if (this.isLongVideo) {
                        FinderMediaBanner finderMediaBanner = this.wrm;
                        finderVideoLayout.setLongVideoSeekBar(finderMediaBanner != null ? finderMediaBanner.getLongVideoSeekBar() : null);
                        FinderVideoLayout.a(finderVideoLayout, i2, feedData, this.dLS, this.wfg, false, 192);
                        FinderMediaBanner finderMediaBanner2 = this.wrm;
                        if (!(finderMediaBanner2 == null || (longVideoSeekBar = finderMediaBanner2.getLongVideoSeekBar()) == null)) {
                            cjl cjl2 = (cjl) j.kt(feedData.getMediaList());
                            if (cjl2 != null) {
                                i3 = cjl2.videoDuration;
                            } else {
                                i3 = 0;
                            }
                            longVideoSeekBar.setVideoTotalTime(i3);
                        }
                    } else {
                        FinderMediaBanner finderMediaBanner3 = this.wrm;
                        finderVideoLayout.a(i2, feedData, this.wrq == null ? finderMediaBanner3 != null ? (FinderVideoSeekBar) finderMediaBanner3.findViewById(R.id.ggr) : null : this.wrq, this.dLS, this.wfg, this.wro, this.wfs, this.wft);
                    }
                }
                if (this.wrn) {
                    p.g(finderVideoLayout, "videoContainer");
                    finderVideoLayout.setClickable(false);
                    finderVideoLayout.setLongClickable(false);
                    AppMethodBeat.o(168451);
                    return;
                }
                break;
            case 9:
                FinderVideoLayout finderVideoLayout2 = (FinderVideoLayout) bVar.Mn(R.id.ckd);
                FeedData feedData2 = this.feed;
                if (feedData2 != null) {
                    finderVideoLayout2.a(i2, feedData2, null, this.dLS, this.wfg, this.wro, this.wfs, this.wft);
                    AppMethodBeat.o(168451);
                    return;
                }
                break;
        }
        AppMethodBeat.o(168451);
    }
}
