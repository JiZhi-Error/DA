package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.feed.av;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0016J \u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0004J@\u0010\"\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00182\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0016J \u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "layoutResId", "", "(I)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "wrapper", "Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;", "getWrapper", "()Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;", "setWrapper", "(Lcom/tencent/mm/plugin/finder/feed/FinderTopicFeedUIContract$FinderTopicInfoWrapper;)V", "bindTopPlace", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "feed", "existCampaignWithCover", "", "item", "getLayoutId", "jumpProfile", "context", "Landroid/content/Context;", "feedId", "", ch.COL_USERNAME, "", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class ae extends e<BaseFinderFeed> {
    public av.c UIe;
    private ValueAnimator luz;
    private final int tDB;

    public ae(int i2) {
        this.tDB = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public /* bridge */ /* synthetic */ void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List list) {
        a(hVar, baseFinderFeed, i2, i3, z, (List<Object>) list);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return this.tDB;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public void a(RecyclerView recyclerView, h hVar, int i2) {
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.tencent.mm.view.recyclerview.h r8, com.tencent.mm.plugin.finder.model.BaseFinderFeed r9, int r10, int r11, boolean r12, java.util.List<java.lang.Object> r13) {
        /*
        // Method dump skipped, instructions count: 856
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.ae.a(com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List):void");
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ ae tDC;

        a(ae aeVar, h hVar, BaseFinderFeed baseFinderFeed) {
            this.tDC = aeVar;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243084);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            ae.a(context, this.tAr.lT(), this.tAr.feedObject.getUserName());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243084);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ BaseFinderFeed tAr;
        final /* synthetic */ ae tDC;

        b(ae aeVar, h hVar, BaseFinderFeed baseFinderFeed) {
            this.tDC = aeVar;
            this.qhp = hVar;
            this.tAr = baseFinderFeed;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243085);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            ae.a(context, this.tAr.lT(), this.tAr.feedObject.getUserName());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedRoundCornerConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243085);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ z.f tDD;

        c(z.f fVar) {
            this.tDD = fVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(243086);
            T t = this.tDD.SYG;
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(243086);
                throw tVar;
            }
            t.setProgress(((Integer) animatedValue).intValue());
            this.tDD.SYG.invalidate();
            AppMethodBeat.o(243086);
        }
    }

    protected static void a(Context context, long j2, String str) {
        p.h(context, "context");
        p.h(str, ch.COL_USERNAME);
        Intent intent = new Intent();
        intent.putExtra("finder_username", str);
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC.a.a(context, intent, j2, 1, false, 64);
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context, intent);
        FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (fH != null) {
            k kVar = k.vfA;
            k.a(4, j2, fH.tCE, 1, str);
        }
    }

    protected static void j(h hVar, BaseFinderFeed baseFinderFeed) {
        p.h(hVar, "holder");
        p.h(baseFinderFeed, "feed");
        LinearLayout linearLayout = (LinearLayout) hVar.Mn(R.id.d3y);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        if (baseFinderFeed.feedObject.getStickyTime() > 0) {
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final boolean y(BaseFinderFeed baseFinderFeed) {
        String str;
        FinderObjectDesc finderObjectDesc;
        bds bds;
        aqk aqk;
        azs azs;
        azs azs2;
        String str2 = null;
        p.h(baseFinderFeed, "item");
        FinderObjectDesc finderObjectDesc2 = baseFinderFeed.feedObject.getFeedObject().objectDesc;
        if (finderObjectDesc2 == null || (azs2 = finderObjectDesc2.event) == null) {
            str = null;
        } else {
            str = azs2.eventName;
        }
        if (!Util.isNullOrNil(str) && ((finderObjectDesc = baseFinderFeed.feedObject.getFeedObject().objectDesc) == null || (azs = finderObjectDesc.event) == null || azs.twd != 0)) {
            av.c cVar = this.UIe;
            if (!(cVar == null || (bds = cVar.dMU) == null || (aqk = bds.LNz) == null)) {
                str2 = aqk.coverImgUrl;
            }
            if (!Util.isNullOrNil(str2)) {
                return true;
            }
        }
        return false;
    }
}
