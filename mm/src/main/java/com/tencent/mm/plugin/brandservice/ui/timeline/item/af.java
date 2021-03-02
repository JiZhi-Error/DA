package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.v;
import com.tencent.mm.model.o;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\"\u001a\u00020#H\u0002J(\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0016J\b\u0010*\u001a\u00020#H\u0016J\u0010\u0010+\u001a\u00020#2\u0006\u0010)\u001a\u00020\fH\u0016J\u0018\u0010,\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001aH\u0002J(\u0010-\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\f2\u0006\u0010.\u001a\u00020\fH\u0002J \u0010/\u001a\u00020#2\u0006\u0010\u000f\u001a\u0002002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001aH\u0002J(\u00101\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\f2\u0006\u0010.\u001a\u00020\fH\u0002J\b\u00102\u001a\u00020#H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0018R\u00020\u00000\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010 \u001a\f\u0012\b\u0012\u00060\u0018R\u00020\u00000!X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "headerTagLayout", "Landroid/view/View;", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "item", "jumpLinkTv", "Landroid/widget/TextView;", "jumpMore", "recReasonTv", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "getStyle", "()I", "setStyle", "(I)V", "viewClose", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "clearSlotView", "", "filling", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "gone", "inflate", "initCommonSlot", "initContent", "viewParent", "initHead", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "initJumpContent", "show", "BizRecFeedTagCommonSlot", "plugin-brandservice_release"})
public final class af extends ad {
    final Context context;
    final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
    private View puO;
    private LinearLayout puP;
    private LinkedList<a> puQ = new LinkedList<>();
    private final i<a> puR = new i<>(new g(this));
    private View pve;
    private WeImageView pvf;
    private TextView pxg;
    private View pxh;
    private TextView pxi;
    private View pxj;
    private int style = 2002;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "", "opType", "", "invoke"})
    static final class f extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ int gUj;
        final /* synthetic */ z prL;
        final /* synthetic */ af pxk;
        final /* synthetic */ dkr pxn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(af afVar, dkr dkr, z zVar, int i2) {
            super(1);
            this.pxk = afVar;
            this.pxn = dkr;
            this.prL = zVar;
            this.gUj = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(195494);
            int intValue = num.intValue();
            if (!Util.isNullOrNil(this.pxn.Luj)) {
                String str = this.pxn.Luj;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", m.d(str, 169, 200, 0));
                intent.putExtra("geta8key_scene", 56);
                com.tencent.mm.br.c.b(this.pxk.context, "webview", ".ui.tools.WebViewUI", intent);
                o oVar = o.iBV;
                o.Aa(26);
                this.pxk.psQ.pqZ.b(this.prL, 0, intValue);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(195494);
            return xVar;
        }
    }

    public af(com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, Context context2) {
        p.h(bVar, "adapter");
        p.h(context2, "context");
        AppMethodBeat.i(195499);
        this.psQ = bVar;
        this.context = context2;
        AppMethodBeat.o(195499);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final int getStyle() {
        return this.style;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void a(z zVar, int i2, View view, View view2) {
        AppMethodBeat.i(195496);
        p.h(zVar, "info");
        p.h(view, "convertView");
        p.h(view2, "parent");
        p.h(view2, "parent");
        if (this.puO == null) {
            View inflate = ((ViewStub) view2.findViewById(R.id.j7y)).inflate();
            this.pve = inflate.findViewById(R.id.b4i);
            this.pvf = (WeImageView) inflate.findViewById(R.id.b4h);
            this.pxg = (TextView) inflate.findViewById(R.id.e5p);
            this.pxi = (TextView) inflate.findViewById(R.id.gtx);
            this.pxj = inflate.findViewById(R.id.fkj);
            this.puP = (LinearLayout) inflate.findViewById(R.id.a6y);
            this.pxh = inflate.findViewById(R.id.gtw);
            this.puO = inflate;
        }
        dkr dkr = zVar.NQr;
        p.g(dkr, "info.recFeed");
        LinkedList<String> linkedList = dkr.KWr;
        if (linkedList == null || linkedList.isEmpty()) {
            View view3 = this.pve;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        } else {
            View view4 = this.pve;
            if (view4 != null) {
                view4.setVisibility(0);
            }
        }
        View view5 = this.pve;
        if (view5 != null) {
            view5.setOnClickListener(new b(this, zVar, i2));
        }
        LinearLayout linearLayout = this.puP;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        Iterator<T> it = this.puQ.iterator();
        while (it.hasNext()) {
            this.puR.da(it.next());
        }
        this.puQ.clear();
        LinkedList<dlb> linkedList2 = zVar.NQr.MOG;
        p.g(linkedList2, "info.recFeed.RecommendItem");
        int i3 = 0;
        for (T t : linkedList2) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                j.hxH();
            }
            T t2 = t;
            a aVar = this.puR.get();
            LinearLayout linearLayout2 = this.puP;
            if (linearLayout2 != null) {
                linearLayout2.addView(aVar.puS);
            }
            this.puQ.add(aVar);
            p.g(t2, "item");
            p.h(zVar, "info");
            p.h(t2, "itemMsg");
            cdu cdu = t2.MOY;
            String str = cdu.Title;
            String str2 = cdu.KSj;
            int i5 = cdu.iAb;
            aVar.pxp.aw(str);
            MMNeat7extView mMNeat7extView = aVar.pxa;
            if (mMNeat7extView != null) {
                mMNeat7extView.setVisibility(8);
            }
            aVar.pxo.setPadding(0, com.tencent.mm.plugin.brandservice.ui.timeline.b.pry, 0, com.tencent.mm.plugin.brandservice.ui.timeline.b.pry);
            com.tencent.mm.plugin.brandservice.ui.b.d dVar = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
            if (com.tencent.mm.plugin.brandservice.ui.b.d.crj()) {
                com.tencent.mm.plugin.brandservice.ui.b.d dVar2 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
                com.tencent.mm.plugin.brandservice.ui.b.d.c(aVar.pxp);
            }
            aVar.puS.setOnClickListener(new a.View$OnClickListenerC0876a(aVar, zVar, t2, i2, i3));
            if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(1) && !Util.isNullOrNil(str2)) {
                ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(str2, i5, 90, new Object[0]);
            }
            aVar.ptH.type = i5;
            v vVar = aVar.ptH;
            String str3 = cdu.KSm;
            vVar.iAo = str3 == null || n.aL(str3) ? cdu.KSl : cdu.KSm;
            aVar.ptH.url = str2;
            if (aVar.ptH.type == 5) {
                ImageView imageView = aVar.pxu;
                p.g(imageView, "playIcon");
                imageView.setVisibility(0);
                aVar.pxu.setImageResource(R.drawable.ic);
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.e eVar = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.pAN;
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.F(aVar.ptH.url, aVar.ptH.type, "");
            } else {
                ImageView imageView2 = aVar.pxu;
                p.g(imageView2, "playIcon");
                imageView2.setVisibility(8);
            }
            if (aVar.ptH.type == 8) {
                View view6 = aVar.pxv;
                p.g(view6, "coverMaskLayout");
                view6.setVisibility(0);
            } else {
                View view7 = aVar.pxv;
                p.g(view7, "coverMaskLayout");
                view7.setVisibility(8);
            }
            if (!Util.isNullOrNil(aVar.ptH.iAo)) {
                View view8 = aVar.pxr;
                p.g(view8, "coverArea");
                view8.setVisibility(0);
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.d dVar3 = aVar.psQ.prc;
                long j2 = zVar.field_msgId;
                v vVar2 = aVar.ptH;
                String str4 = aVar.ptH.iAo;
                ImageView imageView3 = aVar.ptE;
                int i6 = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
                dVar3.a(j2, i2, vVar2, str4, imageView3, i6, i6, false, (m.a) new a.b(aVar, zVar, i2), zVar.pxD + 1, 2.0f);
            } else if (aVar.ptH.type == 5) {
                View view9 = aVar.pxr;
                p.g(view9, "coverArea");
                view9.setVisibility(0);
                com.tencent.mm.plugin.brandservice.ui.timeline.preload.d dVar4 = aVar.psQ.prc;
                ImageView imageView4 = aVar.ptE;
                int i7 = com.tencent.mm.plugin.brandservice.ui.timeline.b.pru;
                dVar4.a("2131231740", imageView4, i7, i7, zVar.pxD + 1);
            } else {
                View view10 = aVar.pxr;
                p.g(view10, "coverArea");
                view10.setVisibility(8);
            }
            View view11 = aVar.jBI;
            p.g(view11, "topLine");
            view11.setVisibility(0);
            a.c cVar = a.c.pxm;
            switch (i3) {
                case 0:
                    View view12 = aVar.jBI;
                    p.g(view12, "topLine");
                    cVar.invoke(view12, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prC * 2));
                    i3 = i4;
                    break;
                default:
                    View view13 = aVar.jBI;
                    p.g(view13, "topLine");
                    cVar.invoke(view13, Integer.valueOf(com.tencent.mm.plugin.brandservice.ui.timeline.b.prz));
                    i3 = i4;
                    break;
            }
        }
        dkr dkr2 = zVar.NQr;
        TextView textView = this.pxg;
        if (textView != null) {
            textView.setText(dkr2.Luk);
        }
        TextView textView2 = this.pxi;
        if (textView2 != null) {
            textView2.setText(dkr2.MOI);
        }
        com.tencent.mm.plugin.brandservice.ui.b.d dVar5 = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
        com.tencent.mm.plugin.brandservice.ui.b.d.i(this.pxg);
        f fVar = new f(this, dkr2, zVar, i2);
        TextView textView3 = this.pxg;
        if (textView3 != null) {
            textView3.setOnClickListener(new c(fVar));
        }
        View view14 = this.pxh;
        if (view14 != null) {
            view14.setOnClickListener(new d(fVar));
        }
        View view15 = this.pxj;
        if (view15 != null) {
            view15.setOnClickListener(new e(fVar));
            AppMethodBeat.o(195496);
            return;
        }
        AppMethodBeat.o(195496);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ z prL;
        final /* synthetic */ af pxk;

        b(af afVar, z zVar, int i2) {
            this.pxk = afVar;
            this.prL = zVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195490);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ((h) new h(this.pxk.context, this.prL, this.pxk.psQ, this.gUj).hw(this.pxk.pvf)).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195490);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.b pwT;

        c(kotlin.g.a.b bVar) {
            this.pwT = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195491);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initJumpContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.pwT.invoke(24);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initJumpContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195491);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.b pwT;

        d(kotlin.g.a.b bVar) {
            this.pwT = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195492);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initJumpContent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.pwT.invoke(24);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initJumpContent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195492);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.b pwT;

        e(kotlin.g.a.b bVar) {
            this.pwT = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195493);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initJumpContent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.pwT.invoke(25);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$initJumpContent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195493);
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void cmO() {
        AppMethodBeat.i(195497);
        View view = this.puO;
        if (view != null) {
            view.setVisibility(8);
            AppMethodBeat.o(195497);
            return;
        }
        AppMethodBeat.o(195497);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void show() {
        AppMethodBeat.i(195498);
        View view = this.puO;
        if (view != null) {
            view.setVisibility(0);
            AppMethodBeat.o(195498);
            return;
        }
        AppMethodBeat.o(195498);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJ(\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J*\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001dH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "digetst", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "initUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "itemMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "pos", "", FirebaseAnalytics.b.INDEX, "onAppMsgClick", "recommendItem", "setCoverMask", "item", "position", "loadFinish", "", "setLinePaddingMargin", "realIndex", "plugin-brandservice_release"})
    public final class a extends ah {
        final Context context;
        final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
        final v ptH = new v();
        final View puS = View.inflate(this.context, R.layout.kk, null);
        MMNeat7extView pxa;
        final /* synthetic */ af pxk;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<no name provided>", "", "view", "Landroid/view/View;", "margin", "", "invoke"})
        static final class c extends q implements kotlin.g.a.m<View, Integer, x> {
            public static final c pxm = new c();

            static {
                AppMethodBeat.i(195487);
                AppMethodBeat.o(195487);
            }

            c() {
                super(2);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(View view, Integer num) {
                AppMethodBeat.i(195486);
                View view2 = view;
                int intValue = num.intValue();
                p.h(view2, "view");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    AppMethodBeat.o(195486);
                    throw tVar;
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.rightMargin = intValue;
                view2.setLayoutParams(layoutParams2);
                x xVar = x.SXb;
                AppMethodBeat.o(195486);
                return xVar;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(af afVar, com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, Context context2) {
            super(bVar, context2);
            p.h(bVar, "adapter");
            p.h(context2, "context");
            this.pxk = afVar;
            AppMethodBeat.i(195489);
            this.psQ = bVar;
            this.context = context2;
            this.jBI = this.puS.findViewById(R.id.it2);
            this.pxo = this.puS.findViewById(R.id.bf0);
            this.pxp = (MMNeat7extView) this.puS.findViewById(R.id.iqr);
            this.pxa = (MMNeat7extView) this.puS.findViewById(R.id.awm);
            this.pxr = this.puS.findViewById(R.id.bgx);
            this.ptE = (ImageView) this.puS.findViewById(R.id.bh7);
            this.pxu = (ImageView) this.puS.findViewById(R.id.gcf);
            this.pxv = this.puS.findViewById(R.id.gbl);
            this.pxw = this.puS.findViewById(R.id.gbk);
            AppMethodBeat.o(195489);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.item.af$a$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC0876a implements View.OnClickListener {
            final /* synthetic */ z prL;
            final /* synthetic */ int prP;
            final /* synthetic */ dlb puC;
            final /* synthetic */ int puW;
            final /* synthetic */ a pxl;

            View$OnClickListenerC0876a(a aVar, z zVar, dlb dlb, int i2, int i3) {
                this.pxl = aVar;
                this.prL = zVar;
                this.puC = dlb;
                this.prP = i2;
                this.puW = i3;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(195484);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a aVar = this.pxl;
                z zVar = this.prL;
                dlb dlb = this.puC;
                int i2 = this.puW;
                if (dlb == null || zVar.NQr == null || dlb.MOX == null || dlb.MOY == null) {
                    Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
                } else {
                    com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
                    com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(aVar.context, zVar, dlb);
                    aVar.pxk.a(zVar, "PAUSE_FOR_RESUME");
                    aVar.psQ.pqZ.a(zVar, i2, (int) (System.currentTimeMillis() / 1000));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(195484);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot$initUI$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
        public static final class b implements m.a {
            final /* synthetic */ z prL;
            final /* synthetic */ int prP;
            final /* synthetic */ a pxl;

            b(a aVar, z zVar, int i2) {
                this.pxl = aVar;
                this.prL = zVar;
                this.prP = i2;
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onFinish() {
                AppMethodBeat.i(195485);
                this.pxl.a(this.pxl.ptH, true);
                AppMethodBeat.o(195485);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onStart() {
            }
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ah
        public final void a(v vVar, boolean z) {
            AppMethodBeat.i(195488);
            p.h(vVar, "item");
            if (vVar.type == 8) {
                View view = this.pxv;
                p.g(view, "coverMaskLayout");
                view.setVisibility(0);
                if (z) {
                    this.pxw.setBackgroundResource(R.drawable.in);
                    AppMethodBeat.o(195488);
                    return;
                }
                this.pxw.setBackgroundResource(R.drawable.aij);
                AppMethodBeat.o(195488);
                return;
            }
            View view2 = this.pxv;
            p.g(view2, "coverMaskLayout");
            view2.setVisibility(8);
            AppMethodBeat.o(195488);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag$BizRecFeedTagCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedTag;", "invoke"})
    static final class g extends q implements kotlin.g.a.a<a> {
        final /* synthetic */ af pxk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(af afVar) {
            super(0);
            this.pxk = afVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ a invoke() {
            AppMethodBeat.i(195495);
            a aVar = new a(this.pxk, this.pxk.psQ, this.pxk.context);
            AppMethodBeat.o(195495);
            return aVar;
        }
    }
}
