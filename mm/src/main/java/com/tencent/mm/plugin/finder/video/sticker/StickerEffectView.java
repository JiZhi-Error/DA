package com.tencent.mm.plugin.finder.video.sticker;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.video.sticker.e;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.c;
import com.tencent.mm.sticker.f;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.sticker.loader.g;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002;<B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u00107\u001a\u00020\u001dJ\u0010\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020:H\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R>\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0017X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015R\u0012\u0010'\u001a\u00060(R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R9\u0010,\u001a!\u0012\u0015\u0012\u0013\u0018\u00010+¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u001d\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "downloadCallback", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "historyDiffCallback", "Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "getHistoryDiffCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;", "setHistoryDiffCallback", "(Lcom/tencent/mm/plugin/finder/video/sticker/DiffCallbackHolder;)V", "itemClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Lcom/tencent/mm/sticker/LensItem;", "info", "", "loadMoreCallback", "Lkotlin/Function0;", "getLoadMoreCallback", "()Lkotlin/jvm/functions/Function0;", "setLoadMoreCallback", "(Lkotlin/jvm/functions/Function0;)V", "moreDiffCallback", "getMoreDiffCallback", "setMoreDiffCallback", "pagerAdapter", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView$StickerEffectPagerAdapter;", "requestLensId", "requestLensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "selectionCallback", "Lkotlin/Function1;", "lensInfo", "getSelectionCallback", "()Lkotlin/jvm/functions/Function1;", "setSelectionCallback", "(Lkotlin/jvm/functions/Function1;)V", "tabView", "Landroid/support/design/widget/TabLayout;", "viewPager", "Landroid/support/v4/view/ViewPager;", "destroy", "notifyStatus", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "PageItemHolder", "StickerEffectPagerAdapter", "plugin-finder_release"})
public final class StickerEffectView extends ConstraintLayout {
    private final String TAG;
    private final m<Integer, c, x> rsD;
    private chz rtC;
    private String rtD;
    private kotlin.g.a.b<? super chz, x> rtN;
    private kotlin.g.a.a<x> rtP;
    private final ViewPager uO;
    private final TabLayout wjr;
    private final b wjs;
    final f<g> wjt;
    private a wju;
    private a wjv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StickerEffectView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(254612);
        this.TAG = "MicroMsg.StickerEffectView";
        View.inflate(context, R.layout.a_g, this);
        setBackgroundResource(R.drawable.yt);
        View findViewById = findViewById(R.id.byc);
        p.g(findViewById, "findViewById(R.id.effect_sticker_tab)");
        this.wjr = (TabLayout) findViewById;
        View findViewById2 = findViewById(R.id.byd);
        p.g(findViewById2, "findViewById(R.id.effect_sticker_view_pager)");
        this.uO = (ViewPager) findViewById2;
        this.wjr.setupWithViewPager(this.uO);
        this.wjs = new b();
        this.uO.setAdapter(this.wjs);
        this.uO.setCurrentItem(1);
        this.rsD = new m<Integer, c, x>(this) {
            /* class com.tencent.mm.plugin.finder.video.sticker.StickerEffectView.AnonymousClass1 */
            final /* synthetic */ StickerEffectView wjw;

            {
                this.wjw = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(Integer num, c cVar) {
                j d2;
                e eVar;
                e eVar2;
                AppMethodBeat.i(254603);
                num.intValue();
                c cVar2 = cVar;
                p.h(cVar2, "lensItem");
                this.wjw.rtC = cVar2.NMJ;
                this.wjw.rtD = cVar2.NMJ.Lso;
                for (T t : this.wjw.wjs.wjz) {
                    if (!(t == null || (eVar2 = t.wiV) == null)) {
                        String str = this.wjw.rtD;
                        if (!p.j(eVar2.rpt, str)) {
                            eVar2.rpt = str;
                            Iterator<c> it = eVar2.rsC.iterator();
                            int i2 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i2 = -1;
                                    break;
                                } else if (p.j(it.next().NMJ.Lso, str)) {
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                            if (eVar2.va != i2) {
                                eVar2.wiR = false;
                                eVar2.ci(eVar2.va);
                                eVar2.va = i2;
                                eVar2.ci(eVar2.va);
                            }
                        }
                    }
                }
                if (this.wjw.rtD == null) {
                    d2 = j.OK;
                } else {
                    e eVar3 = e.NNN;
                    d2 = e.d(cVar2.NMJ);
                }
                if (d2 == j.OK) {
                    StickerEffectView.a(this.wjw, d2);
                } else {
                    for (T t2 : this.wjw.wjs.wjz) {
                        if (!(t2 == null || (eVar = t2.wiV) == null)) {
                            eVar.bx(this.wjw.rtD, true);
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(254603);
                return xVar;
            }
        };
        this.wjt = new f<g>(this) {
            /* class com.tencent.mm.plugin.finder.video.sticker.StickerEffectView.AnonymousClass2 */
            final /* synthetic */ StickerEffectView wjw;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.wjw = r1;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
            @Override // com.tencent.mm.loader.g.f
            public final /* synthetic */ void a(g gVar, j jVar) {
                e eVar;
                AppMethodBeat.i(254604);
                g gVar2 = gVar;
                p.h(gVar2, "task");
                p.h(jVar, "status");
                if (p.j(this.wjw.rtD, gVar2.NNU.rnS)) {
                    Log.i(this.wjw.TAG, "onLoaderFin: " + this.wjw.rtD + ", " + jVar);
                    StickerEffectView.a(this.wjw, jVar);
                    for (T t : this.wjw.wjs.wjz) {
                        if (!(t == null || (eVar = t.wiV) == null)) {
                            eVar.bx(this.wjw.rtD, false);
                        }
                    }
                }
                AppMethodBeat.o(254604);
            }
        };
        e eVar = e.NNN;
        e.a(this.wjt);
        AppMethodBeat.o(254612);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StickerEffectView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(254613);
        AppMethodBeat.o(254613);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StickerEffectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(254614);
        AppMethodBeat.o(254614);
    }

    public final a getMoreDiffCallback() {
        return this.wju;
    }

    public final void setMoreDiffCallback(a aVar) {
        this.wju = aVar;
    }

    public final a getHistoryDiffCallback() {
        return this.wjv;
    }

    public final void setHistoryDiffCallback(a aVar) {
        this.wjv = aVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super com.tencent.mm.protocal.protobuf.chz, kotlin.x>, kotlin.g.a.b<com.tencent.mm.protocal.protobuf.chz, kotlin.x> */
    public final kotlin.g.a.b<chz, x> getSelectionCallback() {
        return this.rtN;
    }

    public final void setSelectionCallback(kotlin.g.a.b<? super chz, x> bVar) {
        this.rtN = bVar;
    }

    public final kotlin.g.a.a<x> getLoadMoreCallback() {
        return this.rtP;
    }

    public final void setLoadMoreCallback(kotlin.g.a.a<x> aVar) {
        this.rtP = aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView$PageItemHolder;", "", "itemView", "Landroid/view/View;", "needMore", "", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView;Landroid/view/View;Z)V", "adapter", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectAdapter;", "getItemView", "()Landroid/view/View;", "getNeedMore", "()Z", "recycler", "Landroid/support/v7/widget/RecyclerView;", "getRecycler", "()Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
    public final class a {
        private final View aus;
        final RecyclerView gTW;
        final e wiV = new e();
        final /* synthetic */ StickerEffectView wjw;
        private final boolean wjx;

        public a(StickerEffectView stickerEffectView, View view, boolean z) {
            p.h(view, "itemView");
            this.wjw = stickerEffectView;
            AppMethodBeat.i(254606);
            this.aus = view;
            this.wjx = z;
            View findViewById = this.aus.findViewById(R.id.byb);
            p.g(findViewById, "itemView.findViewById(R.….effect_sticker_recycler)");
            this.gTW = (RecyclerView) findViewById;
            this.wiV.rsD = stickerEffectView.rsD;
            if (this.wjx) {
                this.wiV.rsE = new kotlin.g.a.b<Integer, x>(this) {
                    /* class com.tencent.mm.plugin.finder.video.sticker.StickerEffectView.a.AnonymousClass1 */
                    final /* synthetic */ a wjy;

                    {
                        this.wjy = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(Integer num) {
                        kotlin.g.a.a<x> loadMoreCallback;
                        AppMethodBeat.i(254605);
                        if (num.intValue() >= this.wjy.wiV.getItemCount() - 4 && (loadMoreCallback = this.wjy.wjw.getLoadMoreCallback()) != null) {
                            loadMoreCallback.invoke();
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(254605);
                        return xVar;
                    }
                };
            }
            this.gTW.setAdapter(this.wiV);
            RecyclerView recyclerView = this.gTW;
            this.aus.getContext();
            recyclerView.setLayoutManager(new GridLayoutManager(5));
            this.gTW.setItemAnimator(null);
            AppMethodBeat.o(254606);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R-\u0010\u0003\u001a\u001e\u0012\n\u0012\b\u0018\u00010\u0005R\u00020\u00060\u0004j\u000e\u0012\n\u0012\b\u0018\u00010\u0005R\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView$StickerEffectPagerAdapter;", "Landroid/support/v4/view/PagerAdapter;", "(Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView;)V", "itemHolder", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView$PageItemHolder;", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerEffectView;", "Lkotlin/collections/ArrayList;", "getItemHolder", "()Ljava/util/ArrayList;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "obj", "", "getCount", "getPageTitle", "", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "plugin-finder_release"})
    public final class b extends q {
        final ArrayList<a> wjz = new ArrayList<>(2);

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            AppMethodBeat.i(254611);
            this.wjz.add(null);
            this.wjz.add(null);
            AppMethodBeat.o(254611);
        }

        @Override // android.support.v4.view.q
        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            boolean z = true;
            AppMethodBeat.i(254607);
            p.h(viewGroup, "container");
            if (i2 != 1) {
                z = false;
            }
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a_h, viewGroup, false);
            StickerEffectView stickerEffectView = StickerEffectView.this;
            p.g(inflate, "itemView");
            a aVar = new a(stickerEffectView, inflate, z);
            if (z) {
                a moreDiffCallback = StickerEffectView.this.getMoreDiffCallback();
                if (moreDiffCallback != null) {
                    moreDiffCallback.a(new e.c(aVar.wiV));
                }
            } else {
                a historyDiffCallback = StickerEffectView.this.getHistoryDiffCallback();
                if (historyDiffCallback != null) {
                    historyDiffCallback.a(new e.c(aVar.wiV));
                }
            }
            this.wjz.set(i2, aVar);
            viewGroup.addView(aVar.gTW);
            RecyclerView recyclerView = aVar.gTW;
            AppMethodBeat.o(254607);
            return recyclerView;
        }

        @Override // android.support.v4.view.q
        public final CharSequence getPageTitle(int i2) {
            AppMethodBeat.i(254608);
            if (i2 == 0) {
                String string = StickerEffectView.this.getContext().getString(R.string.fwt);
                AppMethodBeat.o(254608);
                return string;
            }
            String string2 = StickerEffectView.this.getContext().getString(R.string.fwu);
            AppMethodBeat.o(254608);
            return string2;
        }

        @Override // android.support.v4.view.q
        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            AppMethodBeat.i(254609);
            p.h(viewGroup, "container");
            p.h(obj, "obj");
            viewGroup.removeView((View) obj);
            AppMethodBeat.o(254609);
        }

        @Override // android.support.v4.view.q
        public final boolean isViewFromObject(View view, Object obj) {
            AppMethodBeat.i(254610);
            p.h(view, "view");
            p.h(obj, "obj");
            boolean j2 = p.j(view, obj);
            AppMethodBeat.o(254610);
            return j2;
        }

        @Override // android.support.v4.view.q
        public final int getCount() {
            return 2;
        }
    }

    public static final /* synthetic */ void a(StickerEffectView stickerEffectView, j jVar) {
        AppMethodBeat.i(254615);
        if (stickerEffectView.rtD == null || jVar != j.OK) {
            kotlin.g.a.b<? super chz, x> bVar = stickerEffectView.rtN;
            if (bVar != null) {
                bVar.invoke(null);
                AppMethodBeat.o(254615);
                return;
            }
            AppMethodBeat.o(254615);
            return;
        }
        com.tencent.mm.sticker.loader.e eVar = com.tencent.mm.sticker.loader.e.NNN;
        String str = stickerEffectView.rtD;
        if (str == null) {
            p.hyc();
        }
        String biw = com.tencent.mm.sticker.loader.e.biw(str);
        f.a aVar = com.tencent.mm.sticker.f.NNw;
        com.tencent.mm.sticker.f bit = f.a.bit(biw);
        if (bit.isValid()) {
            if (Util.isNullOrNil(bit.rnS)) {
                String str2 = stickerEffectView.rtD;
                if (str2 == null) {
                    p.hyc();
                }
                bit.biq(str2);
            }
            kotlin.g.a.b<? super chz, x> bVar2 = stickerEffectView.rtN;
            if (bVar2 != null) {
                bVar2.invoke(stickerEffectView.rtC);
                AppMethodBeat.o(254615);
                return;
            }
            AppMethodBeat.o(254615);
            return;
        }
        Log.i(stickerEffectView.TAG, "onLoaderFin: sticker is not valid");
        s.deleteDir(biw);
        AppMethodBeat.o(254615);
    }
}
