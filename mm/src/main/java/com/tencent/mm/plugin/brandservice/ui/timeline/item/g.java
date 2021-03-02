package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.e;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "cover", "Landroid/widget/ImageView;", "coverContainer", "Landroid/view/View;", "icon", "iconContainer", "playTimeTv", "Landroid/widget/TextView;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "filling", "", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "getVideoViewContainer", "inflate", "id", "", "refreshFirstItem", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "refreshVideoIcon", "plugin-brandservice_release"})
public final class g extends f {
    private ImageView kc;
    private ImageView ptE;
    private final v ptH = new v();
    TextView pub;
    View puc;
    private View pud;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context, b bVar) {
        super(context, bVar);
        p.h(context, "context");
        p.h(bVar, "adapter");
        AppMethodBeat.i(195275);
        AppMethodBeat.o(195275);
    }

    public final void a(View view, z zVar, pj pjVar) {
        int i2;
        int i3;
        AppMethodBeat.i(195273);
        p.h(view, "parent");
        p.h(zVar, "info");
        p.h(pjVar, "bizInfo");
        U(view, R.id.j8h);
        if (this.aus == null) {
            AppMethodBeat.o(195273);
            return;
        }
        View view2 = this.aus;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        pi piVar = pjVar.KWy.get(0);
        p.g(piVar, "appMsg");
        a(zVar, pjVar, piVar);
        float f2 = 0.5f;
        MMNeat7extView mMNeat7extView = this.ptR;
        if (mMNeat7extView == null || mMNeat7extView.getVisibility() != 0) {
            View view3 = this.puc;
            if (view3 == null) {
                p.hyc();
            }
            i2 = view3.getLayoutParams().height;
        } else {
            int jn = com.tencent.mm.cb.a.jn(this.context) - com.tencent.mm.cb.a.fromDPToPix(this.context, 48);
            MMNeat7extView mMNeat7extView2 = this.ptR;
            if (mMNeat7extView2 != null) {
                mMNeat7extView2.measure(jn, 0);
            }
            View view4 = this.puc;
            if (view4 == null) {
                p.hyc();
            }
            int i4 = view4.getLayoutParams().height;
            MMNeat7extView mMNeat7extView3 = this.ptR;
            if (mMNeat7extView3 == null) {
                p.hyc();
            }
            f2 = 0.56f;
            i2 = (i4 - mMNeat7extView3.getMeasuredHeight()) - b.prC;
        }
        if (this.pud != null) {
            View view5 = this.pud;
            ViewGroup.LayoutParams layoutParams = view5 != null ? view5.getLayoutParams() : null;
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(195273);
                throw tVar;
            }
            ((RelativeLayout.LayoutParams) layoutParams).topMargin = (int) ((((float) i2) * f2) - ((float) (com.tencent.mm.cb.a.fromDPToPix(this.context, 48) / 2)));
        }
        String rJ = m.rJ(piVar.KSx);
        if (!TextUtils.isEmpty(rJ)) {
            TextView textView = this.pub;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.pub;
            if (textView2 != null) {
                textView2.setText(rJ);
            }
            TextView textView3 = this.pub;
            if (textView3 != null) {
                textView3.setTextColor(this.context.getResources().getColor(R.color.wu));
            }
        } else {
            TextView textView4 = this.pub;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
        }
        TextView textView5 = this.pub;
        if (textView5 != null) {
            textView5.setShadowLayer(10.0f, 0.0f, 0.0f, this.context.getResources().getColor(R.color.BW_0_Alpha_0_5));
        }
        z.a aVar = new z.a();
        aVar.SYB = false;
        switch (zVar.gAD().style) {
            case 101:
                aVar.SYB = pjVar.KWy.size() <= 1;
                break;
            case 102:
                LinkedList<pj> linkedList = zVar.gAD().Nga.KUf;
                p.g(linkedList, "info.tlRecCardWrapper.extraInfo.BizInfo");
                int i5 = 0;
                int i6 = 0;
                for (Object obj : j.b(linkedList, 2)) {
                    int i7 = i5 + 1;
                    if (i5 < 0) {
                        j.hxH();
                    }
                    if (((pj) obj).KHa == 0) {
                        i3 = i6 + 1;
                    } else {
                        i3 = i6;
                    }
                    i5 = i7;
                    i6 = i3;
                }
                aVar.SYB = i6 < 2;
                break;
        }
        this.ptH.type = piVar.iAb;
        this.ptH.iAo = piVar.KSl;
        this.ptH.iAD = piVar.KSl;
        this.ptH.url = piVar.KSj;
        View view6 = this.puc;
        ViewGroup.LayoutParams layoutParams2 = view6 != null ? view6.getLayoutParams() : null;
        if (layoutParams2 != null) {
            layoutParams2.height = b.prs;
        }
        View view7 = this.puc;
        if (view7 != null) {
            view7.setLayoutParams(layoutParams2);
        }
        this.psQ.prc.a(zVar.field_msgId, 0, this.ptH, piVar.KSl, this.ptE, com.tencent.mm.cb.a.jn(this.context) - b.prw, b.prs, false, (m.a) new a(this, aVar, zVar, piVar), false, zVar.pxD);
        b(zVar, pjVar, piVar);
        e eVar = e.pAN;
        e.F(this.ptH.url, this.ptH.type, "");
        AppMethodBeat.o(195273);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowVideo$refreshFirstItem$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class a implements m.a {
        final /* synthetic */ com.tencent.mm.storage.z prL;
        final /* synthetic */ z.a ptJ;
        final /* synthetic */ pi ptK;
        final /* synthetic */ g pue;

        a(g gVar, z.a aVar, com.tencent.mm.storage.z zVar, pi piVar) {
            this.pue = gVar;
            this.ptJ = aVar;
            this.prL = zVar;
            this.ptK = piVar;
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
        public final void onFinish() {
            MMNeat7extView mMNeat7extView;
            AppMethodBeat.i(195272);
            TextView textView = this.pue.ptY;
            if (textView != null) {
                textView.setTextColor(this.pue.context.getResources().getColor(R.color.BW_100_Alpha_0_9));
            }
            ImageView imageView = this.pue.ptS;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (!this.ptJ.SYB && (mMNeat7extView = this.pue.ptR) != null) {
                mMNeat7extView.setTextColor(this.pue.context.getResources().getColor(R.color.ag2));
            }
            this.pue.a(this.prL, this.ptK);
            TextView textView2 = this.pue.pub;
            if (textView2 != null) {
                textView2.setTextColor(this.pue.context.getResources().getColor(R.color.ag2));
                AppMethodBeat.o(195272);
                return;
            }
            AppMethodBeat.o(195272);
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
        public final void onStart() {
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.f
    public final void U(View view, int i2) {
        View view2;
        View view3;
        MMNeat7extView mMNeat7extView;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        MMNeat7extView mMNeat7extView2;
        MMNeat7extView mMNeat7extView3;
        AppMethodBeat.i(195274);
        p.h(view, "parent");
        if (this.aus == null) {
            super.U(view, i2);
            View view4 = this.aus;
            ImageView imageView = view4 != null ? (ImageView) view4.findViewById(R.id.bgv) : null;
            if (imageView == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.ImageView");
                AppMethodBeat.o(195274);
                throw tVar;
            }
            this.ptE = imageView;
            View view5 = this.aus;
            ImageView imageView2 = view5 != null ? (ImageView) view5.findViewById(R.id.j51) : null;
            if (imageView2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.ImageView");
                AppMethodBeat.o(195274);
                throw tVar2;
            }
            this.kc = imageView2;
            View view6 = this.aus;
            TextView textView = view6 != null ? (TextView) view6.findViewById(R.id.gcj) : null;
            if (textView == null) {
                t tVar3 = new t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(195274);
                throw tVar3;
            }
            this.pub = textView;
            View view7 = this.aus;
            if (view7 != null) {
                view2 = view7.findViewById(R.id.ayp);
            } else {
                view2 = null;
            }
            this.puc = view2;
            View view8 = this.aus;
            if (view8 != null) {
                view3 = view8.findViewById(R.id.j52);
            } else {
                view3 = null;
            }
            this.pud = view3;
            cmH();
            this.ptQ = view.findViewById(R.id.avu);
            View view9 = this.aus;
            if (view9 != null) {
                mMNeat7extView = (MMNeat7extView) view9.findViewById(R.id.ir3);
            } else {
                mMNeat7extView = null;
            }
            if (mMNeat7extView == null) {
                t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
                AppMethodBeat.o(195274);
                throw tVar4;
            }
            this.ptR = mMNeat7extView;
            View view10 = this.aus;
            ImageView imageView3 = view10 != null ? (ImageView) view10.findViewById(R.id.ggb) : null;
            if (imageView3 == null) {
                t tVar5 = new t("null cannot be cast to non-null type android.widget.ImageView");
                AppMethodBeat.o(195274);
                throw tVar5;
            }
            this.ptS = imageView3;
            View view11 = this.aus;
            if (view11 != null) {
                linearLayout = (LinearLayout) view11.findViewById(R.id.a94);
            } else {
                linearLayout = null;
            }
            this.ptT = linearLayout;
            View view12 = this.aus;
            if (view12 != null) {
                linearLayout2 = (LinearLayout) view12.findViewById(R.id.hsf);
            } else {
                linearLayout2 = null;
            }
            this.ptU = linearLayout2;
            View view13 = this.aus;
            if (view13 != null) {
                mMNeat7extView2 = (MMNeat7extView) view13.findViewById(R.id.hsc);
            } else {
                mMNeat7extView2 = null;
            }
            this.ptV = mMNeat7extView2;
            View view14 = this.aus;
            if (view14 != null) {
                mMNeat7extView3 = (MMNeat7extView) view14.findViewById(R.id.hsa);
            } else {
                mMNeat7extView3 = null;
            }
            this.ptW = mMNeat7extView3;
        }
        AppMethodBeat.o(195274);
    }
}
