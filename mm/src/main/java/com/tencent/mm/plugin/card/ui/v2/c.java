package com.tencent.mm.plugin.card.ui.v2;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020+2\u0006\u00102\u001a\u000203J\u001c\u00104\u001a\u00020+2\f\u00105\u001a\b\u0012\u0004\u0012\u000207062\u0006\u00108\u001a\u00020\u001cR\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "viewType", "", "(Landroid/view/View;I)V", "bgIv", "Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "getBgIv", "()Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;", "setBgIv", "(Lcom/tencent/mm/plugin/card/widget/MemberCardTopCropImageView;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "logoIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "getLogoIv", "()Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "setLogoIv", "(Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;)V", "mViewHeight", "mViewWidth", "rightLabelLayout", "Landroid/widget/LinearLayout;", "getRightLabelLayout", "()Landroid/widget/LinearLayout;", "setRightLabelLayout", "(Landroid/widget/LinearLayout;)V", "shadowIv", "Landroid/widget/ImageView;", "getShadowIv", "()Landroid/widget/ImageView;", "setShadowIv", "(Landroid/widget/ImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "setCardBg", "", "imageView", "url", "", "radius", "", "setModel", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "plugin-card_release"})
public final class c extends RecyclerView.v {
    int aYN;
    int aYO;
    public TextView hPW;
    public CdnImageView qgQ;
    public MemberCardTopCropImageView qgR;
    public LinearLayout qgS;
    public ImageView qgT;
    public TextView titleTv;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view, int i2) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(112556);
        switch (i2) {
            case 0:
                View findViewById = view.findViewById(R.id.anm);
                p.g(findViewById, "itemView.findViewById(R.id.card_list_header_text)");
                this.titleTv = (TextView) findViewById;
                AppMethodBeat.o(112556);
                return;
            case 1:
                View findViewById2 = view.findViewById(R.id.b3x);
                p.g(findViewById2, "itemView.findViewById(R.id.clni_icon_iv)");
                this.qgQ = (CdnImageView) findViewById2;
                View findViewById3 = view.findViewById(R.id.b3y);
                p.g(findViewById3, "itemView.findViewById(R.id.clni_title_tv)");
                this.titleTv = (TextView) findViewById3;
                TextView textView = this.titleTv;
                if (textView == null) {
                    p.btv("titleTv");
                }
                ao.a(textView.getPaint(), 0.8f);
                View findViewById4 = view.findViewById(R.id.b3w);
                p.g(findViewById4, "itemView.findViewById(R.id.clni_desc_tv)");
                this.hPW = (TextView) findViewById4;
                CdnImageView cdnImageView = this.qgQ;
                if (cdnImageView == null) {
                    p.btv("logoIv");
                }
                cdnImageView.setUseSdcardCache(true);
                AppMethodBeat.o(112556);
                return;
            case 2:
                View findViewById5 = view.findViewById(R.id.bj9);
                p.g(findViewById5, "itemView.findViewById(R.id.ctci_logo_iv)");
                this.qgQ = (CdnImageView) findViewById5;
                View findViewById6 = view.findViewById(R.id.bja);
                p.g(findViewById6, "itemView.findViewById(R.id.ctci_title_tv)");
                this.titleTv = (TextView) findViewById6;
                TextView textView2 = this.titleTv;
                if (textView2 == null) {
                    p.btv("titleTv");
                }
                ao.a(textView2.getPaint(), 0.8f);
                View findViewById7 = view.findViewById(R.id.bj8);
                p.g(findViewById7, "itemView.findViewById(R.id.ctci_desc_tv)");
                this.hPW = (TextView) findViewById7;
                View findViewById8 = view.findViewById(R.id.bj6);
                p.g(findViewById8, "itemView.findViewById(R.id.ctci_bg_iv)");
                this.qgR = (MemberCardTopCropImageView) findViewById8;
                View findViewById9 = view.findViewById(R.id.bj7);
                p.g(findViewById9, "itemView.findViewById(R.id.ctci_bg_shadow_iv)");
                this.qgT = (ImageView) findViewById9;
                View findViewById10 = view.findViewById(R.id.bj_);
                p.g(findViewById10, "itemView.findViewById(R.….ctci_right_label_layout)");
                this.qgS = (LinearLayout) findViewById10;
                CdnImageView cdnImageView2 = this.qgQ;
                if (cdnImageView2 == null) {
                    p.btv("logoIv");
                }
                cdnImageView2.setUseSdcardCache(true);
                AppMethodBeat.o(112556);
                return;
            case 3:
                View findViewById11 = view.findViewById(R.id.b3y);
                p.g(findViewById11, "itemView.findViewById(R.id.clni_title_tv)");
                this.titleTv = (TextView) findViewById11;
                TextView textView3 = this.titleTv;
                if (textView3 == null) {
                    p.btv("titleTv");
                }
                ao.a(textView3.getPaint(), 0.8f);
                View findViewById12 = view.findViewById(R.id.b3w);
                p.g(findViewById12, "itemView.findViewById(R.id.clni_desc_tv)");
                this.hPW = (TextView) findViewById12;
                break;
        }
        AppMethodBeat.o(112556);
    }

    public final MemberCardTopCropImageView cxj() {
        AppMethodBeat.i(201427);
        MemberCardTopCropImageView memberCardTopCropImageView = this.qgR;
        if (memberCardTopCropImageView == null) {
            p.btv("bgIv");
        }
        AppMethodBeat.o(201427);
        return memberCardTopCropImageView;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/card/ui/v2/CardTicketVH$setModel$1$2$1", "com/tencent/mm/plugin/card/ui/v2/CardTicketVH$$special$$inlined$apply$lambda$2"})
    static final class b implements Runnable {
        final /* synthetic */ c qgV;
        final /* synthetic */ kotlin.g.a.a qgW;

        b(kotlin.g.a.a aVar, c cVar) {
            this.qgW = aVar;
            this.qgV = cVar;
        }

        public final void run() {
            AppMethodBeat.i(201426);
            c cVar = this.qgV;
            View view = this.qgV.aus;
            p.g(view, "itemView");
            cVar.aYO = view.getHeight();
            c cVar2 = this.qgV;
            View view2 = this.qgV.aus;
            p.g(view2, "itemView");
            cVar2.aYN = view2.getWidth();
            this.qgW.invoke();
            AppMethodBeat.o(201426);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/card/ui/v2/CardTicketVH$setModel$1$2$func$1", "com/tencent/mm/plugin/card/ui/v2/CardTicketVH$$special$$inlined$apply$lambda$1"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ cyp qgU;
        final /* synthetic */ c qgV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(cyp cyp, c cVar) {
            super(0);
            this.qgU = cyp;
            this.qgV = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            AppMethodBeat.i(201425);
            this.qgV.cxj().itemPadding = com.tencent.mm.cb.a.fromDPToPix(this.qgV.cxj().getContext(), 32);
            this.qgV.cxj().kn = this.qgV.aYO;
            this.qgV.cxj().getLayoutParams().height = this.qgV.aYO;
            this.qgV.cxj().setVisibility(0);
            ImageView imageView = this.qgV.qgT;
            if (imageView == null) {
                p.btv("shadowIv");
            }
            imageView.setVisibility(0);
            String str = this.qgU.MDD;
            if (!(str == null || str.length() == 0)) {
                com.tencent.mm.plugin.card.ui.v4.b.a(this.qgV.cxj(), this.qgU.MDD, this.qgV.aYN, this.qgV.aYO);
            } else {
                String str2 = this.qgU.MDC;
                if (str2 == null || str2.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    this.qgV.cxj().setImageDrawable(com.tencent.mm.plugin.card.ui.v4.b.EE(Color.parseColor(this.qgU.MDC)));
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(201425);
            return xVar;
        }
    }
}
