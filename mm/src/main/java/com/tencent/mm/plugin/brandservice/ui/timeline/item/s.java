package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egb;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0006\u0010\u0018\u001a\u00020\u0011J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\bH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u00060\rR\u00020\u00000\fX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\f\u0012\b\u0012\u00060\rR\u00020\u00000\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "item", "Landroid/view/View;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "filling", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "", "convertView", "parent", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "inflate", "BizRecCardCommonSlot", "plugin-brandservice_release"})
public final class s extends w {
    private View puO;
    private LinearLayout puP;
    private LinkedList<a> puQ = new LinkedList<>();
    private final i<a> puR;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, Context context) {
        super(context, bVar);
        p.h(bVar, "adapter");
        p.h(context, "context");
        AppMethodBeat.i(195350);
        this.puR = new i<>(new b(this, bVar, context));
        AppMethodBeat.o(195350);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad, com.tencent.mm.plugin.brandservice.ui.timeline.item.w
    public final void a(z zVar, int i2, View view, View view2) {
        egb egb;
        String str;
        AppMethodBeat.i(195347);
        p.h(zVar, "info");
        p.h(view, "convertView");
        p.h(view2, "parent");
        super.a(zVar, i2, view, view2);
        efz gAC = zVar.gAC();
        if (gAC != null) {
            egb = gAC.NfT;
        } else {
            egb = null;
        }
        if (egb == null) {
            AppMethodBeat.o(195347);
            return;
        }
        View view3 = this.puO;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        for (T t : this.puQ) {
            LinearLayout linearLayout = this.puP;
            if (linearLayout != null) {
                linearLayout.removeView(t.puS);
            }
            this.puR.da(t);
        }
        this.puQ.clear();
        LinkedList<ega> linkedList = gAC.KWy;
        if (linkedList != null) {
            int i3 = 0;
            for (T t2 : linkedList) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    j.hxH();
                }
                T t3 = t2;
                if (t3 != null && (t3.KHa & 1) == 0) {
                    a aVar = this.puR.get();
                    LinearLayout linearLayout2 = this.puP;
                    if (linearLayout2 != null) {
                        linearLayout2.addView(aVar.puS);
                    }
                    this.puQ.add(aVar);
                    p.h(zVar, "info");
                    p.h(gAC, "recCard");
                    p.h(t3, "appMsg");
                    String str2 = t3.Title;
                    String str3 = t3.KSj;
                    int i5 = t3.iAb;
                    String str4 = t3.KSl;
                    String str5 = t3.KSm;
                    aVar.pxp.aw(str2);
                    aVar.puS.setBackgroundResource(i3 == 0 ? R.drawable.i7 : R.drawable.i1);
                    aVar.puS.setOnClickListener(new a.View$OnClickListenerC0878a(aVar, zVar, t3, i3));
                    if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1) && !Util.isNullOrNil(str3)) {
                        ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(str3, i5, 90, new Object[0]);
                    }
                    aVar.ptH.type = i5;
                    aVar.ptH.iAo = str4;
                    aVar.ptH.iAD = str5;
                    aVar.ptH.url = str3;
                    aVar.a(aVar.ptX, aVar.ptY, zVar, aVar.ptH);
                    ImageView imageView = aVar.pxu;
                    p.g(imageView, "playIcon");
                    imageView.setVisibility(8);
                    View view4 = aVar.pxs;
                    p.g(view4, "voicePlayIconContainer");
                    view4.setVisibility(8);
                    if (aVar.ptH.type == 7) {
                        aVar.ptE.setVisibility(8);
                        p.h(zVar, "info");
                        p.h(t3, "appMsg");
                        ImageView imageView2 = aVar.pxu;
                        p.g(imageView2, "playIcon");
                        imageView2.setVisibility(8);
                        View view5 = aVar.pxs;
                        p.g(view5, "voicePlayIconContainer");
                        view5.setVisibility(0);
                        ImageView imageView3 = aVar.pxt;
                        p.g(imageView3, "voicePlayIcon");
                        Drawable drawable = imageView3.getDrawable();
                        if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                            ((AnimationDrawable) drawable).stop();
                        }
                        if (p.j(String.valueOf(zVar.field_msgId) + "_" + i3, c.crh())) {
                            aVar.pxt.setImageResource(R.drawable.ie);
                            ImageView imageView4 = aVar.pxt;
                            p.g(imageView4, "voicePlayIcon");
                            if (imageView4.getDrawable() instanceof AnimationDrawable) {
                                ImageView imageView5 = aVar.pxt;
                                p.g(imageView5, "voicePlayIcon");
                                Drawable drawable2 = imageView5.getDrawable();
                                if (drawable2 == null) {
                                    t tVar = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                                    AppMethodBeat.o(195347);
                                    throw tVar;
                                }
                                ((AnimationDrawable) drawable2).start();
                            }
                        } else {
                            aVar.pxt.setImageResource(R.drawable.id);
                        }
                        String str6 = t3.KWt;
                        if (Util.isNullOrNil(str6)) {
                            Log.i("MicroMsg.BizTimeLineItem", "BizTLRecCardBizcontent playUrl null");
                        } else {
                            ((com.tencent.mm.plugin.brandservice.a.a) g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a(aVar.pxt, String.valueOf(zVar.field_msgId) + "_" + i3, t3.Title, str6, "", t3.KSl);
                            aVar.pxt.setOnClickListener(new a.e(aVar));
                        }
                    } else if (!Util.isNullOrNil(aVar.ptH.iAo)) {
                        aVar.ptE.setVisibility(0);
                        if (Util.isNullOrNil(aVar.ptH.iAD)) {
                            str = aVar.ptH.iAo;
                        } else {
                            str = aVar.ptH.iAD;
                        }
                        d dVar = aVar.pxE.prc;
                        long j2 = zVar.field_msgId;
                        v vVar = aVar.ptH;
                        ImageView imageView6 = aVar.ptE;
                        int i6 = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
                        dVar.a(j2, i3, vVar, str, imageView6, i6, i6, false, (m.a) new a.b(aVar, zVar, i3), zVar.pxD + 1, 2.0f);
                    } else if (aVar.ptH.type == 5 || aVar.ptH.type == 6) {
                        aVar.ptE.setVisibility(0);
                        d dVar2 = aVar.pxE.prc;
                        ImageView imageView7 = aVar.ptE;
                        int i7 = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
                        dVar2.a("2131231740", imageView7, i7, i7, zVar.pxD + 1);
                    } else {
                        aVar.pxr.setVisibility(8);
                    }
                    a.c cVar = a.c.puY;
                    a.d dVar3 = a.d.puZ;
                    switch (i3) {
                        case 0:
                            View view6 = aVar.pxo;
                            p.g(view6, "content");
                            dVar3.a(view6, 0, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prv), 0, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.pry));
                            View view7 = aVar.jBI;
                            p.g(view7, "topLine");
                            cVar.invoke(view7, Integer.valueOf(com.tencent.mm.cb.a.fromDPToPix(aVar.context, 16.0f)));
                            i3 = i4;
                            break;
                        case 1:
                            View view8 = aVar.pxo;
                            p.g(view8, "content");
                            dVar3.a(view8, 0, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.pry), 0, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prv));
                            View view9 = aVar.jBI;
                            p.g(view9, "topLine");
                            cVar.invoke(view9, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prz));
                        default:
                            i3 = i4;
                            break;
                    }
                } else {
                    h.INSTANCE.idkeyStat(1149, 6, 1, false);
                    i3 = i4;
                }
            }
        }
        c.x(zVar);
        AppMethodBeat.o(195347);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.w
    public final void du(View view) {
        AppMethodBeat.i(195348);
        p.h(view, "parent");
        if (this.puO == null) {
            View inflate = ((ViewStub) view.findViewById(R.id.j7p)).inflate();
            p.g(inflate, "this");
            dv(inflate);
            this.puP = (LinearLayout) inflate.findViewById(R.id.a6i);
            this.puO = inflate;
        }
        AppMethodBeat.o(195348);
    }

    public final void hide() {
        AppMethodBeat.i(195349);
        View view = this.puO;
        if (view != null) {
            view.setVisibility(8);
            AppMethodBeat.o(195349);
            return;
        }
        AppMethodBeat.o(195349);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "refreshUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "recCard", "Lcom/tencent/mm/protocal/protobuf/TLRecCard;", "appMsg", "Lcom/tencent/mm/protocal/protobuf/TLRecCardAppMsg;", FirebaseAnalytics.b.INDEX, "", "setPaddingAndMargin", "setPlayIcon", "position", "plugin-brandservice_release"})
    public final class a extends ah {
        final Context context;
        final v ptH = new v();
        final View puS = View.inflate(this.context, R.layout.k9, null);
        final /* synthetic */ s puT;

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<no name provided>", "", "view", "Landroid/view/View;", "margin", "", "invoke"})
        public static final class c extends q implements kotlin.g.a.m<View, Integer, x> {
            public static final c puY = new c();

            static {
                AppMethodBeat.i(195341);
                AppMethodBeat.o(195341);
            }

            c() {
                super(2);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(View view, Integer num) {
                AppMethodBeat.i(195340);
                View view2 = view;
                int intValue = num.intValue();
                p.h(view2, "view");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    AppMethodBeat.o(195340);
                    throw tVar;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.rightMargin = intValue;
                view2.setLayoutParams(layoutParams2);
                x xVar = x.SXb;
                AppMethodBeat.o(195340);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\n¢\u0006\u0002\b\t"}, hxF = {"<no name provided>", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "invoke"})
        public static final class d extends q implements kotlin.g.a.s<View, Integer, Integer, Integer, Integer, x> {
            public static final d puZ = new d();

            static {
                AppMethodBeat.i(195343);
                AppMethodBeat.o(195343);
            }

            d() {
                super(5);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.s
            public final /* synthetic */ x a(View view, Integer num, Integer num2, Integer num3, Integer num4) {
                AppMethodBeat.i(195342);
                View view2 = view;
                int intValue = num.intValue();
                int intValue2 = num2.intValue();
                int intValue3 = num3.intValue();
                int intValue4 = num4.intValue();
                p.h(view2, "view");
                view2.setPadding(intValue, intValue2, intValue3, intValue4);
                x xVar = x.SXb;
                AppMethodBeat.o(195342);
                return xVar;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(s sVar, com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, Context context2) {
            super(bVar, context2);
            p.h(bVar, "adapter");
            p.h(context2, "context");
            this.puT = sVar;
            AppMethodBeat.i(195345);
            this.context = context2;
            this.jBI = this.puS.findViewById(R.id.it2);
            this.pxo = this.puS.findViewById(R.id.bf0);
            View findViewById = this.puS.findViewById(R.id.iqr);
            if (findViewById == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
                AppMethodBeat.o(195345);
                throw tVar;
            }
            this.pxp = (MMNeat7extView) findViewById;
            this.pxq = (TextView) this.puS.findViewById(R.id.ied);
            this.pxr = this.puS.findViewById(R.id.bgx);
            this.ptE = (ImageView) this.puS.findViewById(R.id.bh7);
            this.pxs = this.puS.findViewById(R.id.a7p);
            this.pxt = (ImageView) this.puS.findViewById(R.id.a97);
            this.pxu = (ImageView) this.puS.findViewById(R.id.gcf);
            this.ptX = this.puS.findViewById(R.id.i4r);
            View findViewById2 = this.puS.findViewById(R.id.daz);
            if (findViewById2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(195345);
                throw tVar2;
            }
            this.ptY = (TextView) findViewById2;
            this.pxv = this.puS.findViewById(R.id.gbl);
            this.pxw = this.puS.findViewById(R.id.gbk);
            this.puD = (TextView) this.puS.findViewById(R.id.gbt);
            AppMethodBeat.o(195345);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.item.s$a$a  reason: collision with other inner class name */
        public static final class View$OnClickListenerC0878a implements View.OnClickListener {
            final /* synthetic */ z prL;
            final /* synthetic */ a puU;
            final /* synthetic */ ega puV;
            final /* synthetic */ int puW;

            View$OnClickListenerC0878a(a aVar, z zVar, ega ega, int i2) {
                this.puU = aVar;
                this.prL = zVar;
                this.puV = ega;
                this.puW = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(195338);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.puU.puT.a(this.prL, this.puV, view, this.puW);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(195338);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$refreshUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
        public static final class b implements m.a {
            final /* synthetic */ z prL;
            final /* synthetic */ a puU;
            final /* synthetic */ int puX;

            b(a aVar, z zVar, int i2) {
                this.puU = aVar;
                this.prL = zVar;
                this.puX = i2;
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onFinish() {
                AppMethodBeat.i(195339);
                this.puU.a(this.puU.ptH, true);
                this.puU.pxE.prc.m(this.prL.field_msgId, this.puX);
                AppMethodBeat.o(195339);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onStart() {
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        public static final class e implements View.OnClickListener {
            final /* synthetic */ a puU;

            e(a aVar) {
                this.puU = aVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(195344);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ((com.tencent.mm.plugin.brandservice.a.a) g.af(com.tencent.mm.plugin.brandservice.a.a.class)).dq(this.puU.pxt);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot$setPlayIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(195344);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent$BizRecCardCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardBizcontent;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<a> {
        final /* synthetic */ Context $context;
        final /* synthetic */ s puT;
        final /* synthetic */ com.tencent.mm.plugin.brandservice.ui.timeline.b pva;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(s sVar, com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, Context context) {
            super(0);
            this.puT = sVar;
            this.pva = bVar;
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ a invoke() {
            AppMethodBeat.i(195346);
            a aVar = new a(this.puT, this.pva, this.$context);
            AppMethodBeat.o(195346);
            return aVar;
        }
    }
}
