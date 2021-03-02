package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0016J \u0010\"\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u000eH\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowTopView;", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "cover", "Landroid/widget/ImageView;", "getCover", "()Landroid/widget/ImageView;", "setCover", "(Landroid/widget/ImageView;)V", "coverLayout", "Landroid/view/View;", "getCoverLayout", "()Landroid/view/View;", "setCoverLayout", "(Landroid/view/View;)V", "coverMask", "getCoverMask", "setCoverMask", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "filling", "", "parent", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "inflate", "id", "", "refreshFirstItem", "appMsg", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardAppMsg;", "refreshHeight", "v", "plugin-brandservice_release"})
public final class d extends f {
    private ImageView ptE;
    private View ptF;
    private ImageView ptG;
    private final v ptH = new v();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context, b bVar) {
        super(context, bVar);
        p.h(context, "context");
        p.h(bVar, "adapter");
        AppMethodBeat.i(195264);
        AppMethodBeat.o(195264);
    }

    public final void a(View view, z zVar, pj pjVar) {
        int i2;
        AppMethodBeat.i(195261);
        p.h(view, "parent");
        p.h(zVar, "info");
        p.h(pjVar, "bizInfo");
        U(view, R.id.j8b);
        if (this.aus == null) {
            AppMethodBeat.o(195261);
            return;
        }
        View view2 = this.aus;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        pi piVar = pjVar.KWy.get(0);
        p.g(piVar, "appMsg");
        a(zVar, pjVar, piVar);
        View view3 = this.ptF;
        if (view3 == null) {
            p.hyc();
        }
        dt(view3);
        ImageView imageView = this.ptE;
        if (imageView == null) {
            p.hyc();
        }
        dt(imageView);
        z.a aVar = new z.a();
        aVar.SYB = false;
        switch (zVar.gAD().style) {
            case 101:
                aVar.SYB = pjVar.KWy.size() <= 1;
                break;
            case 102:
                LinkedList<pj> linkedList = zVar.gAD().Nga.KUf;
                p.g(linkedList, "info.tlRecCardWrapper.extraInfo.BizInfo");
                int i3 = 0;
                int i4 = 0;
                for (Object obj : j.b(linkedList, 2)) {
                    int i5 = i3 + 1;
                    if (i3 < 0) {
                        j.hxH();
                    }
                    if (((pj) obj).KHa == 0) {
                        i2 = i4 + 1;
                    } else {
                        i2 = i4;
                    }
                    i3 = i5;
                    i4 = i2;
                }
                aVar.SYB = i4 < 2;
                break;
        }
        this.ptH.type = piVar.iAb;
        this.ptH.iAo = piVar.KSl;
        this.ptH.iAD = piVar.KSl;
        this.ptH.url = piVar.KSj;
        this.psQ.prc.a(zVar.field_msgId, 0, this.ptH, piVar.KSl, this.ptE, com.tencent.mm.cb.a.jn(this.context) - b.prw, b.prq, false, (m.a) new a(this, aVar, zVar, piVar), false, zVar.pxD);
        b(zVar, pjVar, piVar);
        AppMethodBeat.o(195261);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowArticle$refreshFirstItem$2", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
    public static final class a implements m.a {
        final /* synthetic */ com.tencent.mm.storage.z prL;
        final /* synthetic */ d ptI;
        final /* synthetic */ z.a ptJ;
        final /* synthetic */ pi ptK;

        a(d dVar, z.a aVar, com.tencent.mm.storage.z zVar, pi piVar) {
            this.ptI = dVar;
            this.ptJ = aVar;
            this.prL = zVar;
            this.ptK = piVar;
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
        public final void onFinish() {
            MMNeat7extView mMNeat7extView;
            AppMethodBeat.i(195260);
            TextView textView = this.ptI.ptY;
            if (textView != null) {
                textView.setTextColor(this.ptI.context.getResources().getColor(R.color.BW_100_Alpha_0_9));
            }
            ImageView imageView = this.ptI.ptS;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (!this.ptJ.SYB && (mMNeat7extView = this.ptI.ptR) != null) {
                mMNeat7extView.setTextColor(this.ptI.context.getResources().getColor(R.color.ag2));
            }
            this.ptI.a(this.prL, this.ptK);
            AppMethodBeat.o(195260);
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
        public final void onStart() {
        }
    }

    private static void dt(View view) {
        AppMethodBeat.i(195263);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = b.prq;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.o(195263);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.f
    public final void U(View view, int i2) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        MMNeat7extView mMNeat7extView;
        MMNeat7extView mMNeat7extView2;
        AppMethodBeat.i(195262);
        p.h(view, "parent");
        if (this.aus == null) {
            super.U(view, i2);
            this.ptE = (ImageView) view.findViewById(R.id.bh7);
            this.ptF = view.findViewById(R.id.bh8);
            this.ptG = (ImageView) view.findViewById(R.id.bh9);
            cmH();
            this.ptQ = view.findViewById(R.id.isg);
            View view2 = this.aus;
            MMNeat7extView mMNeat7extView3 = view2 != null ? (MMNeat7extView) view2.findViewById(R.id.ir3) : null;
            if (mMNeat7extView3 == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
                AppMethodBeat.o(195262);
                throw tVar;
            }
            this.ptR = mMNeat7extView3;
            View view3 = this.aus;
            ImageView imageView = view3 != null ? (ImageView) view3.findViewById(R.id.ggb) : null;
            if (imageView == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.ImageView");
                AppMethodBeat.o(195262);
                throw tVar2;
            }
            this.ptS = imageView;
            View view4 = this.aus;
            if (view4 != null) {
                linearLayout = (LinearLayout) view4.findViewById(R.id.a94);
            } else {
                linearLayout = null;
            }
            this.ptT = linearLayout;
            View view5 = this.aus;
            if (view5 != null) {
                linearLayout2 = (LinearLayout) view5.findViewById(R.id.hse);
            } else {
                linearLayout2 = null;
            }
            this.ptU = linearLayout2;
            View view6 = this.aus;
            if (view6 != null) {
                mMNeat7extView = (MMNeat7extView) view6.findViewById(R.id.hsc);
            } else {
                mMNeat7extView = null;
            }
            this.ptV = mMNeat7extView;
            View view7 = this.aus;
            if (view7 != null) {
                mMNeat7extView2 = (MMNeat7extView) view7.findViewById(R.id.hsa);
            } else {
                mMNeat7extView2 = null;
            }
            this.ptW = mMNeat7extView2;
        }
        AppMethodBeat.o(195262);
    }
}
