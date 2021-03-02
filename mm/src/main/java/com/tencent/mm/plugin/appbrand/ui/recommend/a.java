package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.dko;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.aa;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.text.DecimalFormat;
import java.util.LinkedList;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 G2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\nCDEFGHIJKLB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010&\u001a\u00020\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130!J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0014J\b\u0010*\u001a\u00020\u0014H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010)\u001a\u00020\u0014H\u0016J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u0014H\u0016J \u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u0014J0\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u0002062\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u000fJ\u001c\u00108\u001a\u00020\u00152\n\u00109\u001a\u00060\u0002R\u00020\u00002\u0006\u0010)\u001a\u00020\u0014H\u0017J\u001c\u0010:\u001a\u00060\u0002R\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0014H\u0016J\u001e\u0010>\u001a\u00020\u00152\u0006\u00105\u001a\u0002062\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000fJ\u0014\u0010B\u001a\u00020\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130!R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R,\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R,\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R,\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130!8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "df", "Ljava/text/DecimalFormat;", "getDf", "()Ljava/text/DecimalFormat;", "setDf", "(Ljava/text/DecimalFormat;)V", "isEmptyList", "", "()Z", "onBindView", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "", "", "getOnBindView", "()Lkotlin/jvm/functions/Function2;", "setOnBindView", "(Lkotlin/jvm/functions/Function2;)V", "onClickContent", "getOnClickContent", "setOnClickContent", "onClickFooter", "getOnClickFooter", "setOnClickFooter", "wxaList", "Ljava/util/LinkedList;", "getWxaList", "()Ljava/util/LinkedList;", "wxaList$delegate", "Lkotlin/Lazy;", "appendData", "data", "getData", "position", "getItemCount", "getItemId", "", "getItemViewType", "getRecommendStatObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandRecommendStatObj;", "attr", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "itemData", "pos", "jumpProfile", "context", "Landroid/content/Context;", "fromFooter", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAppNameViewMargin", "view", "Landroid/view/View;", "alignTop", "setData", "AppRecommendViewHolder", "AudioRecommendViewHolder", "BaseRecommendViewHolder", "BigVideoRecommendViewHolder", "Companion", "GoodsAppRecommendViewHolder", "ImageTextRecommendViewHolder", "VideoRecommendViewHolder", "WithContentDescViewHolder", "WithFooterViewHolder", "plugin-appbrand-integration_release"})
public final class a extends RecyclerView.a<c> {
    public static final e oeH = new e((byte) 0);
    final Activity activity;
    private DecimalFormat df = new DecimalFormat("0.00");
    private final kotlin.f oeD = kotlin.g.ah(r.ofc);
    kotlin.g.a.m<? super dko, ? super Integer, x> oeE = k.oeV;
    kotlin.g.a.m<? super dko, ? super Integer, x> oeF = q.ofb;
    kotlin.g.a.m<? super dko, ? super Integer, x> oeG = p.ofa;

    static {
        AppMethodBeat.i(51338);
        AppMethodBeat.o(51338);
    }

    /* access modifiers changed from: package-private */
    public final LinkedList<dko> bYP() {
        AppMethodBeat.i(51339);
        LinkedList<dko> linkedList = (LinkedList) this.oeD.getValue();
        AppMethodBeat.o(51339);
        return linkedList;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "<anonymous parameter 1>", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.m<dko, Integer, x> {
        public static final k oeV = new k();

        static {
            AppMethodBeat.i(51327);
            AppMethodBeat.o(51327);
        }

        k() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(dko dko, Integer num) {
            AppMethodBeat.i(51326);
            num.intValue();
            kotlin.g.b.p.h(dko, "<anonymous parameter 0>");
            x xVar = x.SXb;
            AppMethodBeat.o(51326);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "<anonymous parameter 1>", "", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.m<dko, Integer, x> {
        public static final p ofa = new p();

        static {
            AppMethodBeat.i(51333);
            AppMethodBeat.o(51333);
        }

        p() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(dko dko, Integer num) {
            AppMethodBeat.i(51332);
            num.intValue();
            kotlin.g.b.p.h(dko, "<anonymous parameter 0>");
            x xVar = x.SXb;
            AppMethodBeat.o(51332);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "<anonymous parameter 1>", "", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.m<dko, Integer, x> {
        public static final q ofb = new q();

        static {
            AppMethodBeat.i(51335);
            AppMethodBeat.o(51335);
        }

        q() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(dko dko, Integer num) {
            AppMethodBeat.i(51334);
            num.intValue();
            kotlin.g.b.p.h(dko, "<anonymous parameter 0>");
            x xVar = x.SXb;
            AppMethodBeat.o(51334);
            return xVar;
        }
    }

    public a(Activity activity2) {
        kotlin.g.b.p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(51347);
        this.activity = activity2;
        AppMethodBeat.o(51347);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ c a(ViewGroup viewGroup, int i2) {
        d dVar;
        AppMethodBeat.i(51340);
        kotlin.g.b.p.h(viewGroup, "parent");
        LayoutInflater jQ = aa.jQ(viewGroup.getContext());
        switch (i2) {
            case 1:
                View inflate = jQ.inflate(R.layout.f9, viewGroup, false);
                kotlin.g.b.p.g(inflate, "inflater.inflate(R.layou…mage_item, parent, false)");
                dVar = new g(this, inflate);
                break;
            case 2:
                View inflate2 = jQ.inflate(R.layout.f4, viewGroup, false);
                kotlin.g.b.p.g(inflate2, "inflater.inflate(R.layou…udio_item, parent, false)");
                dVar = new b(this, inflate2);
                break;
            case 3:
                View inflate3 = jQ.inflate(R.layout.f_, viewGroup, false);
                kotlin.g.b.p.g(inflate3, "inflater.inflate(R.layou…edio_item, parent, false)");
                dVar = new h(this, inflate3);
                break;
            case 4:
                View inflate4 = jQ.inflate(R.layout.f3, viewGroup, false);
                kotlin.g.b.p.g(inflate4, "inflater.inflate(R.layou…_app_item, parent, false)");
                dVar = new C0810a(this, inflate4);
                break;
            case 5:
                View inflate5 = jQ.inflate(R.layout.f7, viewGroup, false);
                kotlin.g.b.p.g(inflate5, "inflater.inflate(R.layou…oods_item, parent, false)");
                dVar = new f(this, inflate5);
                break;
            case 6:
                View inflate6 = jQ.inflate(R.layout.f5, viewGroup, false);
                kotlin.g.b.p.g(inflate6, "inflater.inflate(R.layou…edio_item, parent, false)");
                dVar = new d(this, inflate6);
                break;
            default:
                View inflate7 = jQ.inflate(R.layout.f9, viewGroup, false);
                kotlin.g.b.p.g(inflate7, "inflater.inflate(R.layou…mage_item, parent, false)");
                dVar = new g(this, inflate7);
                break;
        }
        RecyclerView.v vVar = dVar;
        AppMethodBeat.o(51340);
        return vVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(c cVar, int i2) {
        String str;
        String str2;
        AppMethodBeat.i(51342);
        c cVar2 = cVar;
        kotlin.g.b.p.h(cVar2, "holder");
        dko dko = bYP().get(i2);
        kotlin.g.b.p.g(dko, "wxaList[position]");
        dko dko2 = dko;
        WxaAttributes d2 = com.tencent.mm.plugin.appbrand.app.n.buC().d(dko2.gTT, new String[0]);
        Context context = cVar2.oeO.getContext();
        cVar2.oeN.setText(dko2.qGI);
        if (cVar2 instanceof j) {
            if (!TextUtils.isEmpty(dko2.MOA)) {
                ((j) cVar2).oeT.setText(dko2.MOA);
            } else if (d2 != null) {
                ((j) cVar2).oeT.setText(d2.field_nickname);
            }
            if (!TextUtils.isEmpty(dko2.MOB)) {
                com.tencent.mm.modelappbrand.a.b.aXY().a(((j) cVar2).oeS, dko2.MOB, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
            } else if (d2 != null) {
                com.tencent.mm.modelappbrand.a.b.aXY().a(((j) cVar2).oeS, d2.field_brandIconURL, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
            }
            ((j) cVar2).oeU.setOnClickListener(new l(cVar2, this, dko2, d2, i2, context));
        }
        if (cVar2 instanceof i) {
            ((i) cVar2).oeI.setText(dko2.MOw);
        }
        if (cVar2 instanceof b) {
            ((b) cVar2).oeL.setImageResource(R.raw.app_brand_recommend_music_icon);
        }
        if (cVar2 instanceof h) {
            ((h) cVar2).nNv.setImageResource(R.raw.app_brand_recommend_video_icon);
        }
        if (cVar2 instanceof f) {
            ((f) cVar2).oeP.setText(dko2.MOw);
            if (dko2.MOz == null || (!dko2.MOz.Mfr && !dko2.MOz.Mfq)) {
                ((f) cVar2).oeQ.setVisibility(8);
                ((f) cVar2).oeR.setVisibility(8);
                ((f) cVar2).oeP.setMaxLines(2);
            } else {
                ((f) cVar2).oeP.setMaxLines(1);
                ((f) cVar2).oeQ.setText("");
                ((f) cVar2).oeR.setText("");
                ((f) cVar2).oeQ.setVisibility(0);
                ((f) cVar2).oeR.setVisibility(0);
                if (!dko2.MOz.Mfr) {
                    ((f) cVar2).oeQ.setVisibility(8);
                } else {
                    String format = this.df.format(((double) dko2.MOz.Mfp) / 100.0d);
                    kotlin.g.b.p.g(format, "df.format(discountPrice)");
                    ((f) cVar2).oeQ.setText("¥ ".concat(String.valueOf(format)));
                }
                boolean z = dko2.MOz.Mfq;
                if (!z) {
                    ((f) cVar2).oeR.setVisibility(8);
                } else if (!z || dko2.MOz.Mfr) {
                    TextPaint paint = ((f) cVar2).oeR.getPaint();
                    kotlin.g.b.p.g(paint, "baseViewHolder.originPrice.paint");
                    paint.setAntiAlias(true);
                    TextPaint paint2 = ((f) cVar2).oeR.getPaint();
                    kotlin.g.b.p.g(paint2, "baseViewHolder.originPrice.paint");
                    paint2.setFlags(16);
                    String format2 = this.df.format(((double) dko2.MOz.Mfo) / 100.0d);
                    kotlin.g.b.p.g(format2, "df.format(originPrice)");
                    ((f) cVar2).oeR.setText("¥ ".concat(String.valueOf(format2)));
                } else {
                    ((f) cVar2).oeR.setVisibility(8);
                    ((f) cVar2).oeQ.setVisibility(8);
                    ((f) cVar2).oeP.setMaxLines(2);
                }
            }
        }
        if (cVar2 instanceof C0810a) {
            if (!TextUtils.isEmpty(dko2.MOB)) {
                com.tencent.mm.modelappbrand.a.b.aXY().a(cVar2.oeM, dko2.MOB, b.a(this), com.tencent.mm.modelappbrand.a.g.iJB);
            } else if (d2 != null && !TextUtils.isEmpty(d2.field_bigHeadURL)) {
                com.tencent.mm.modelappbrand.a.b.aXY().a(cVar2.oeM, d2.field_bigHeadURL.toString(), b.a(this), com.tencent.mm.modelappbrand.a.g.iJB);
            } else if (d2 != null && !TextUtils.isEmpty(d2.field_brandIconURL)) {
                com.tencent.mm.modelappbrand.a.b.aXY().a(cVar2.oeM, d2.field_brandIconURL.toString(), b.a(this), com.tencent.mm.modelappbrand.a.g.iJB);
            } else if (!TextUtils.isEmpty(dko2.MOx)) {
                com.tencent.mm.modelappbrand.a.b.aXY().a(cVar2.oeM, dko2.MOx, b.a(this), com.tencent.mm.modelappbrand.a.g.iJB);
            }
            if (!TextUtils.isEmpty(dko2.MOw) || d2 == null || TextUtils.isEmpty(d2.field_signature)) {
                str = dko2.MOw;
            } else {
                str = d2.field_signature.toString();
            }
            if (!TextUtils.isEmpty(str)) {
                ((C0810a) cVar2).oeI.setText(str);
                ((C0810a) cVar2).oeI.setVisibility(0);
                View view = cVar2.aus;
                kotlin.g.b.p.g(view, "baseViewHolder.itemView");
                Context context2 = view.getContext();
                kotlin.g.b.p.g(context2, "baseViewHolder.itemView.context");
                a(context2, (View) ((C0810a) cVar2).oeJ, true);
            } else {
                ((C0810a) cVar2).oeI.setVisibility(8);
                View view2 = cVar2.aus;
                kotlin.g.b.p.g(view2, "baseViewHolder.itemView");
                Context context3 = view2.getContext();
                kotlin.g.b.p.g(context3, "baseViewHolder.itemView.context");
                a(context3, (View) ((C0810a) cVar2).oeJ, false);
            }
            if (!TextUtils.isEmpty(dko2.MOA) || d2 == null) {
                ((C0810a) cVar2).oeJ.setText(dko2.MOA);
            } else {
                TextView textView = ((C0810a) cVar2).oeJ;
                String str3 = d2.field_nickname;
                if (str3 != null) {
                    str2 = str3;
                }
                textView.setText(str2);
            }
        } else {
            int dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(R.dimen.ru);
            int dimensionPixelOffset2 = this.activity.getResources().getDimensionPixelOffset(R.dimen.rt);
            f.ofj.ofi = dimensionPixelOffset;
            f.ofj.iLd = dimensionPixelOffset2;
            com.tencent.mm.modelappbrand.a.b aXY = com.tencent.mm.modelappbrand.a.b.aXY();
            ImageView imageView = cVar2.oeM;
            String str4 = dko2.MOx;
            kotlin.g.b.p.h(this, "$this$getDefaultCardContentImgBg");
            aXY.a(imageView, str4, this.activity.getResources().getDrawable(R.drawable.di), f.ofj);
        }
        if (cVar2 instanceof d) {
            ((d) cVar2).oeL.setImageResource(R.raw.app_brand_recommend_video_icon);
            cVar2.aus.setOnClickListener(new m(this, dko2, d2, i2, context));
        } else {
            cVar2.aus.setOnClickListener(new n(cVar2, this, dko2, d2, i2, context));
        }
        if (BuildInfo.DEBUG) {
            cVar2.aus.setOnLongClickListener(new o(this, dko2, d2, i2, context));
        }
        this.oeE.invoke(dko2, Integer.valueOf(i2));
        AppMethodBeat.o(51342);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$Companion;", "", "()V", "CardType_App", "", "CardType_Audio", "CardType_BigVideo", "CardType_Goods", "CardType_ImageText", "CardType_Video", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class e {
        private e() {
        }

        public /* synthetic */ e(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final long getItemId(int i2) {
        return (long) i2;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(51341);
        int i3 = bYP().get(i2).nHh;
        AppMethodBeat.o(51341);
        return i3;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$1"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ a oeK;
        final /* synthetic */ c oeW;
        final /* synthetic */ dko oeX;
        final /* synthetic */ WxaAttributes oeY;
        final /* synthetic */ int oeZ;

        l(c cVar, a aVar, dko dko, WxaAttributes wxaAttributes, int i2, Context context) {
            this.oeW = cVar;
            this.oeK = aVar;
            this.oeX = dko;
            this.oeY = wxaAttributes;
            this.oeZ = i2;
            this.$context$inlined = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(51328);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a aVar = this.oeK;
            View view2 = this.oeW.aus;
            kotlin.g.b.p.g(view2, "baseViewHolder.itemView");
            Context context = view2.getContext();
            kotlin.g.b.p.g(context, "baseViewHolder.itemView.context");
            aVar.a(context, this.oeY, this.oeX, this.oeZ, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51328);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$4"})
    static final class m implements View.OnClickListener {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ a oeK;
        final /* synthetic */ dko oeX;
        final /* synthetic */ WxaAttributes oeY;
        final /* synthetic */ int oeZ;

        m(a aVar, dko dko, WxaAttributes wxaAttributes, int i2, Context context) {
            this.oeK = aVar;
            this.oeX = dko;
            this.oeY = wxaAttributes;
            this.oeZ = i2;
            this.$context$inlined = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(51329);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(this.oeK.activity, AppBrandRecommendVideoUI.class);
            intent.putExtra("1", this.oeX.MOv);
            Activity activity = this.oeK.activity;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.oeK.oeG.invoke(this.oeX, Integer.valueOf(this.oeZ));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51329);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$5"})
    static final class n implements View.OnClickListener {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ a oeK;
        final /* synthetic */ c oeW;
        final /* synthetic */ dko oeX;
        final /* synthetic */ WxaAttributes oeY;
        final /* synthetic */ int oeZ;

        n(c cVar, a aVar, dko dko, WxaAttributes wxaAttributes, int i2, Context context) {
            this.oeW = cVar;
            this.oeK = aVar;
            this.oeX = dko;
            this.oeY = wxaAttributes;
            this.oeZ = i2;
            this.$context$inlined = context;
        }

        public final void onClick(View view) {
            WxaAttributes wxaAttributes;
            WxaAttributes.WxaVersionInfo bAp;
            AppMethodBeat.i(51330);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.oeX.nHh == 4) {
                a aVar = this.oeK;
                View view2 = this.oeW.aus;
                kotlin.g.b.p.g(view2, "baseViewHolder.itemView");
                Context context = view2.getContext();
                kotlin.g.b.p.g(context, "baseViewHolder.itemView.context");
                aVar.a(context, this.oeY, this.oeX, this.oeZ, false);
            } else {
                String str = this.oeX.nHf;
                if (this.oeX.nHg != null) {
                    String str2 = this.oeX.nHg;
                    kotlin.g.b.p.g(str2, "itemData.page_param");
                    if (!kotlin.n.n.aL(str2)) {
                        str = str + "?" + this.oeX.nHg;
                    }
                }
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = FaceManager.FACE_ACQUIRED_NO_FOCUS;
                appBrandStatObject.ecU = 14;
                if (!TextUtils.isEmpty(this.oeX.nHe)) {
                    appBrandStatObject.dCw = this.oeX.nHd + ":" + this.oeX.nHe.toString();
                    appBrandStatObject.ecV = this.oeX.nHd + ":" + this.oeX.nHe.toString();
                } else {
                    appBrandStatObject.dCw = this.oeX.nHd;
                    appBrandStatObject.ecV = this.oeX.nHd;
                }
                appBrandStatObject.nHv = a.a(this.oeY, this.oeX, this.oeZ);
                if (!(this.oeY == null || (wxaAttributes = this.oeY) == null || (bAp = wxaAttributes.bAp()) == null)) {
                    ((com.tencent.mm.plugin.appbrand.service.r) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(this.$context$inlined, this.oeX.gTT, this.oeY.field_appId, 0, bAp.appVersion, str, appBrandStatObject);
                }
                this.oeK.oeG.invoke(this.oeX, Integer.valueOf(this.oeZ));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51330);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$6"})
    static final class o implements View.OnLongClickListener {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ a oeK;
        final /* synthetic */ dko oeX;
        final /* synthetic */ WxaAttributes oeY;
        final /* synthetic */ int oeZ;

        o(a aVar, dko dko, WxaAttributes wxaAttributes, int i2, Context context) {
            this.oeK = aVar;
            this.oeX = dko;
            this.oeY = wxaAttributes;
            this.oeZ = i2;
            this.$context$inlined = context;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(51331);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            ClipboardHelper.setText(this.oeK.activity, "", this.oeX.nHd.toString() + "," + this.oeX.MOA + "," + this.oeX.gTT);
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(51331);
            return false;
        }
    }

    private static void a(Context context, View view, boolean z) {
        AppMethodBeat.i(51343);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(view, "view");
        if (view instanceof TextView) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                AppMethodBeat.o(51343);
                throw tVar;
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (layoutParams2 != null) {
                if (z) {
                    layoutParams2.topMargin = context.getResources().getDimensionPixelOffset(R.dimen.ri);
                } else {
                    layoutParams2.topMargin = context.getResources().getDimensionPixelOffset(R.dimen.rh);
                }
                view.setLayoutParams(layoutParams2);
            }
        }
        AppMethodBeat.o(51343);
    }

    public final void a(Context context, WxaAttributes wxaAttributes, dko dko, int i2, boolean z) {
        AppMethodBeat.i(51344);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(dko, "itemData");
        String str = dko.nHd;
        if (!TextUtils.isEmpty(dko.nHe)) {
            str = dko.nHd + ":" + dko.nHe.toString();
        }
        WxaExposedParams.a aVar = new WxaExposedParams.a();
        if (wxaAttributes != null) {
            aVar.XN(wxaAttributes.field_appId);
            aVar.XP(wxaAttributes.field_nickname);
        }
        aVar.XO(dko.gTT);
        aVar.XQ(dko.MOB);
        aVar.wh(12);
        AppBrandRecommendStatObj a2 = a(wxaAttributes, dko, i2);
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_recommend_stat_obj", a2);
        AppBrandProfileUI.a(context, dko.gTT, 7, str, aVar.bAv(), bundle, null);
        if (z) {
            this.oeF.invoke(dko, Integer.valueOf(i2));
            AppMethodBeat.o(51344);
            return;
        }
        this.oeG.invoke(dko, Integer.valueOf(i2));
        AppMethodBeat.o(51344);
    }

    public static AppBrandRecommendStatObj a(WxaAttributes wxaAttributes, dko dko, int i2) {
        AppMethodBeat.i(51345);
        kotlin.g.b.p.h(dko, "itemData");
        AppBrandRecommendStatObj appBrandRecommendStatObj = new AppBrandRecommendStatObj();
        appBrandRecommendStatObj.username = dko.gTT;
        appBrandRecommendStatObj.nHd = dko.nHd;
        appBrandRecommendStatObj.nHe = dko.nHe;
        if (wxaAttributes != null) {
            appBrandRecommendStatObj.dNI = wxaAttributes.field_appId;
        }
        appBrandRecommendStatObj.nHf = dko.nHf;
        appBrandRecommendStatObj.nHg = dko.nHg;
        appBrandRecommendStatObj.nHh = dko.nHh;
        appBrandRecommendStatObj.nHi = dko.nHi;
        appBrandRecommendStatObj.position = i2 + 1;
        appBrandRecommendStatObj.dTj = com.tencent.mm.plugin.appbrand.appusage.a.c.getLongitude();
        appBrandRecommendStatObj.latitude = com.tencent.mm.plugin.appbrand.appusage.a.c.getLongitude();
        appBrandRecommendStatObj.sessionId = com.tencent.mm.plugin.appbrand.appusage.a.d.kXh.byM().sessionId;
        AppMethodBeat.o(51345);
        return appBrandRecommendStatObj;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(51346);
        int size = bYP().size();
        AppMethodBeat.o(51346);
        return size;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "content", "Landroid/view/ViewGroup;", "getContent", "()Landroid/view/ViewGroup;", "contentIcon", "Landroid/widget/ImageView;", "getContentIcon", "()Landroid/widget/ImageView;", "recommendReasonTv", "Landroid/widget/TextView;", "getRecommendReasonTv", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
    public class c extends RecyclerView.v {
        final /* synthetic */ a oeK;
        final ImageView oeM;
        final TextView oeN;
        final ViewGroup oeO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, View view) {
            super(view);
            kotlin.g.b.p.h(view, "itemView");
            this.oeK = aVar;
            AppMethodBeat.i(51319);
            View findViewById = view.findViewById(R.id.qh);
            kotlin.g.b.p.g(findViewById, "itemView.findViewById(R.…d_recommend_content_icon)");
            this.oeM = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.qr);
            kotlin.g.b.p.g(findViewById2, "itemView.findViewById(R.…p_brand_recommend_reason)");
            this.oeN = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.qf);
            kotlin.g.b.p.g(findViewById3, "itemView.findViewById(R.…_brand_recommend_content)");
            this.oeO = (ViewGroup) findViewById3;
            AppMethodBeat.o(51319);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "footer", "Landroid/view/ViewGroup;", "getFooter", "()Landroid/view/ViewGroup;", "footerAppName", "Landroid/widget/TextView;", "getFooterAppName", "()Landroid/widget/TextView;", "footerIcon", "Landroid/widget/ImageView;", "getFooterIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
    public class j extends c {
        final /* synthetic */ a oeK;
        final ImageView oeS;
        final TextView oeT;
        final ViewGroup oeU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(a aVar, View view) {
            super(aVar, view);
            kotlin.g.b.p.h(view, "itemView");
            this.oeK = aVar;
            AppMethodBeat.i(51325);
            View findViewById = view.findViewById(R.id.qm);
            kotlin.g.b.p.g(findViewById, "itemView.findViewById(R.…nd_recommend_footer_icon)");
            this.oeS = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.qk);
            kotlin.g.b.p.g(findViewById2, "itemView.findViewById(R.…ecommend_footer_app_name)");
            this.oeT = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.qj);
            kotlin.g.b.p.g(findViewById3, "itemView.findViewById(R.…p_brand_recommend_footer)");
            this.oeU = (ViewGroup) findViewById3;
            AppMethodBeat.o(51325);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "contentDesc", "Landroid/widget/TextView;", "getContentDesc", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
    public class i extends j {
        final TextView oeI;
        final /* synthetic */ a oeK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(a aVar, View view) {
            super(aVar, view);
            kotlin.g.b.p.h(view, "itemView");
            this.oeK = aVar;
            AppMethodBeat.i(51324);
            View findViewById = view.findViewById(R.id.qg);
            kotlin.g.b.p.g(findViewById, "itemView.findViewById(R.…d_recommend_content_desc)");
            this.oeI = (TextView) findViewById;
            AppMethodBeat.o(51324);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$ImageTextRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
    public final class g extends i {
        final /* synthetic */ a oeK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar, View view) {
            super(aVar, view);
            kotlin.g.b.p.h(view, "itemView");
            this.oeK = aVar;
            AppMethodBeat.i(51322);
            AppMethodBeat.o(51322);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "audioIcon", "Landroid/widget/ImageView;", "getAudioIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
    public class b extends i {
        final /* synthetic */ a oeK;
        final ImageView oeL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, View view) {
            super(aVar, view);
            kotlin.g.b.p.h(view, "itemView");
            this.oeK = aVar;
            AppMethodBeat.i(51318);
            View findViewById = view.findViewById(R.id.qp);
            kotlin.g.b.p.g(findViewById, "itemView.findViewById(R.…rand_recommend_play_icon)");
            this.oeL = (ImageView) findViewById;
            AppMethodBeat.o(51318);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$VideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "videoIcon", "Landroid/widget/ImageView;", "getVideoIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
    public class h extends i {
        final ImageView nNv;
        final /* synthetic */ a oeK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(a aVar, View view) {
            super(aVar, view);
            kotlin.g.b.p.h(view, "itemView");
            this.oeK = aVar;
            AppMethodBeat.i(51323);
            View findViewById = view.findViewById(R.id.qp);
            kotlin.g.b.p.g(findViewById, "itemView.findViewById(R.…rand_recommend_play_icon)");
            this.nNv = (ImageView) findViewById;
            AppMethodBeat.o(51323);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "appName", "Landroid/widget/TextView;", "getAppName", "()Landroid/widget/TextView;", "contentDesc", "getContentDesc", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.a$a  reason: collision with other inner class name */
    public final class C0810a extends c {
        final TextView oeI;
        final TextView oeJ;
        final /* synthetic */ a oeK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0810a(a aVar, View view) {
            super(aVar, view);
            kotlin.g.b.p.h(view, "itemView");
            this.oeK = aVar;
            AppMethodBeat.i(51317);
            View findViewById = view.findViewById(R.id.qg);
            kotlin.g.b.p.g(findViewById, "itemView.findViewById(R.…d_recommend_content_desc)");
            this.oeI = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.qk);
            kotlin.g.b.p.g(findViewById2, "itemView.findViewById(R.…ecommend_footer_app_name)");
            this.oeJ = (TextView) findViewById2;
            AppMethodBeat.o(51317);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$GoodsAppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "discountPrice", "Landroid/widget/TextView;", "getDiscountPrice", "()Landroid/widget/TextView;", "goodsName", "getGoodsName", "originPrice", "getOriginPrice", "plugin-appbrand-integration_release"})
    public final class f extends j {
        final /* synthetic */ a oeK;
        final TextView oeP;
        final TextView oeQ;
        final TextView oeR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(a aVar, View view) {
            super(aVar, view);
            kotlin.g.b.p.h(view, "itemView");
            this.oeK = aVar;
            AppMethodBeat.i(51321);
            View findViewById = view.findViewById(R.id.qn);
            kotlin.g.b.p.g(findViewById, "itemView.findViewById(R.…and_recommend_goods_name)");
            this.oeP = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.qi);
            kotlin.g.b.p.g(findViewById2, "itemView.findViewById(R.…recommend_discount_price)");
            this.oeQ = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.qo);
            kotlin.g.b.p.g(findViewById3, "itemView.findViewById(R.…d_recommend_origin_price)");
            this.oeR = (TextView) findViewById3;
            AppMethodBeat.o(51321);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BigVideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
    public final class d extends b {
        final /* synthetic */ a oeK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, View view) {
            super(aVar, view);
            kotlin.g.b.p.h(view, "itemView");
            this.oeK = aVar;
            AppMethodBeat.i(51320);
            AppMethodBeat.o(51320);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "invoke"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<LinkedList<dko>> {
        public static final r ofc = new r();

        static {
            AppMethodBeat.i(51337);
            AppMethodBeat.o(51337);
        }

        r() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinkedList<dko> invoke() {
            AppMethodBeat.i(51336);
            LinkedList linkedList = new LinkedList();
            AppMethodBeat.o(51336);
            return linkedList;
        }
    }
}
