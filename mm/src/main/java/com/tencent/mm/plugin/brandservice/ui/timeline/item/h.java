package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.model.p;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dkq;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.happybubble.BubbleLayout;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import com.tencent.mm.ui.widget.happybubble.b;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "showPos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog$ViewHolder;", "recCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "getRecCard", "()Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "getShowPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "ViewHolder", "plugin-brandservice_release"})
public final class h extends com.tencent.mm.ui.widget.happybubble.b implements View.OnClickListener {
    private final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
    private final z psm;
    private final int ptN;
    private final a puf;
    private final dkr pug;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
    static final class b<T> implements LabelsView.a<c> {
        public static final b puh = new b();

        static {
            AppMethodBeat.i(195278);
            AppMethodBeat.o(195278);
        }

        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.widget.TextView, int, java.lang.Object] */
        @Override // com.tencent.mm.ui.widget.happybubble.LabelsView.a
        public final /* synthetic */ CharSequence a(TextView textView, int i2, c cVar) {
            AppMethodBeat.i(195277);
            c cVar2 = cVar;
            p.g(cVar2, "data");
            String name = cVar2.getName();
            AppMethodBeat.o(195277);
            return name;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Context context, z zVar, com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, int i2) {
        super(context);
        int i3 = 0;
        p.h(context, "context");
        p.h(zVar, "info");
        p.h(bVar, "adapter");
        AppMethodBeat.i(195281);
        this.psm = zVar;
        this.psQ = bVar;
        this.ptN = i2;
        dkr dkr = this.psm.NQr;
        p.g(dkr, "info.recFeed");
        this.pug = dkr;
        a(b.a.BOTTOM, b.a.TOP);
        BubbleLayout bubbleLayout = new BubbleLayout(context);
        bubbleLayout.setBubbleColor(context.getResources().getColor(R.color.BW_100));
        bubbleLayout.setBubbleRadius(com.tencent.mm.cb.a.fromDPToPix(context, 8));
        bubbleLayout.setShadowColor(0);
        bubbleLayout.setLookWidth(com.tencent.mm.cb.a.fromDPToPix(context, 14));
        bubbleLayout.setLookLength(com.tencent.mm.cb.a.fromDPToPix(context, 7));
        a(bubbleLayout);
        View inflate = LayoutInflater.from(context).inflate(R.layout.kg, (ViewGroup) null);
        p.g(inflate, "rootView");
        this.puf = new a(inflate);
        View findViewById = inflate.findViewById(R.id.bf7);
        p.g(findViewById, "rootView.findViewById(R.id.content_root_layout)");
        int jn = com.tencent.mm.cb.a.jn(context);
        int jo = com.tencent.mm.cb.a.jo(context);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.width = (jn >= jo ? jo : jn) - com.tencent.mm.cb.a.fromDPToPix(context, 82);
        findViewById.setLayoutParams(layoutParams);
        LinkedList<c> linkedList = new LinkedList();
        LinkedList<String> linkedList2 = this.pug.KWr;
        if (linkedList2 != null) {
            for (T t : linkedList2) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    j.hxH();
                }
                linkedList.add(new c(t, i3));
                i3 = i4;
            }
        }
        this.puf.ptA.a(linkedList, b.puh);
        this.puf.ptA.hbO();
        this.puf.ptA.setOnLabelClickListener(new c(this));
        String str = "";
        for (c cVar : linkedList) {
            if (!Util.isNullOrNil(str)) {
                str = str + "#";
            }
            str = str + cVar.getName();
        }
        hx(inflate);
        this.puf.hPX.setOnClickListener(this);
        AppMethodBeat.o(195281);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
    static final class c implements LabelsView.b {
        final /* synthetic */ h pui;

        c(h hVar) {
            this.pui = hVar;
        }

        @Override // com.tencent.mm.ui.widget.happybubble.LabelsView.b
        public final void j(Object obj, int i2) {
            AppMethodBeat.i(195279);
            this.pui.puf.hPX.setEnabled(this.pui.puf.ptA.getSelectLabels().size() > 0);
            AppMethodBeat.o(195279);
        }
    }

    public final void onClick(View view) {
        String str;
        AppMethodBeat.i(195280);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        p.h(view, "v");
        if (view.getId() == R.id.g3k) {
            LinkedList<String> linkedList = new LinkedList<>();
            List<c> selectLabelDatas = this.puf.ptA.getSelectLabelDatas();
            String str2 = "";
            if (selectLabelDatas != null) {
                for (c cVar : selectLabelDatas) {
                    if (!Util.isNullOrNil(str2)) {
                        str2 = str2 + "#";
                    }
                    StringBuilder append = new StringBuilder().append(str2);
                    p.g(cVar, "tag");
                    str2 = append.append(cVar.getName()).toString();
                    linkedList.add(cVar.getName());
                }
                str = str2;
            } else {
                str = str2;
            }
            dlb dlb = this.pug.MOG.get(0);
            cdu cdu = dlb.MOY;
            mr mrVar = dlb.MOX;
            String str3 = cdu.KSj;
            p.g(str3, "appMsg.ContentUrl");
            String[] bjc = af.bjc(str3);
            this.psQ.pqZ.a(mrVar != null ? mrVar.UserName : null, Util.getLong(bjc[0], 0), Util.getInt(bjc[1], 0), str, this.pug.KUk, this.pug.KUh, dlb.KWw, af.G(this.psm));
            p.a aVar = com.tencent.mm.model.p.iCa;
            z zVar = this.psm;
            kotlin.g.b.p.h(zVar, "info");
            kotlin.g.b.p.h(linkedList, "negativeFeedbackReason");
            d.a aVar2 = new d.a();
            dkv dkv = new dkv();
            dkv.MaI = new LinkedList<>();
            LinkedList<dkq> linkedList2 = dkv.MaI;
            dkq dkq = new dkq();
            dkq.KWr = linkedList;
            dkq.KWA = zVar.NQr.KWA;
            dkq.MOF = zVar.field_orderFlag;
            linkedList2.add(dkq);
            aVar2.c(dkv);
            aVar2.d(new bub());
            aVar2.MB("/cgi-bin/mmbiz-bin/timeline/recommendfeedsfeedback");
            aVar2.sG(5198);
            aa.a(aVar2.aXF(), p.a.b.iCe);
            this.psQ.c(this.psm);
            dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195280);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecFeedNegativeDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
    public static final class a {
        Button hPX;
        LabelsView ptA;
        private TextView ptB;

        public a(View view) {
            kotlin.g.b.p.h(view, "rootView");
            AppMethodBeat.i(195276);
            View findViewById = view.findViewById(R.id.g3k);
            kotlin.g.b.p.g(findViewById, "rootView.findViewById(R.id.ok_btn)");
            this.hPX = (Button) findViewById;
            View findViewById2 = view.findViewById(R.id.ih5);
            kotlin.g.b.p.g(findViewById2, "rootView.findViewById(R.id.tag_layout)");
            this.ptA = (LabelsView) findViewById2;
            View findViewById3 = view.findViewById(R.id.a6w);
            kotlin.g.b.p.g(findViewById3, "rootView.findViewById(R.id.biz_rec_card_reason_tv)");
            this.ptB = (TextView) findViewById3;
            TextPaint paint = this.ptB.getPaint();
            kotlin.g.b.p.g(paint, "unLikeTv.paint");
            paint.setFakeBoldText(true);
            AppMethodBeat.o(195276);
        }
    }
}
