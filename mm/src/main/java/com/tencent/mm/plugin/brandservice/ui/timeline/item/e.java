package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.net.Uri;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.happybubble.BubbleLayout;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import com.tencent.mm.ui.widget.happybubble.b;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "bizInfo", "Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "showPos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getBizInfo", "()Lcom/tencent/mm/protocal/protobuf/BizRecArtCardBizInfo;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog$ViewHolder;", "getShowPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "ViewHolder", "plugin-brandservice_release"})
public final class e extends com.tencent.mm.ui.widget.happybubble.b implements View.OnClickListener {
    private final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
    private final z psm;
    private final a ptL;
    private final pj ptM;
    private final int ptN;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
    static final class b<T> implements LabelsView.a<c> {
        public static final b ptO = new b();

        static {
            AppMethodBeat.i(195267);
            AppMethodBeat.o(195267);
        }

        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.widget.TextView, int, java.lang.Object] */
        @Override // com.tencent.mm.ui.widget.happybubble.LabelsView.a
        public final /* synthetic */ CharSequence a(TextView textView, int i2, c cVar) {
            AppMethodBeat.i(195266);
            c cVar2 = cVar;
            p.g(cVar2, "data");
            String name = cVar2.getName();
            AppMethodBeat.o(195266);
            return name;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Context context, z zVar, com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, pj pjVar, int i2) {
        super(context);
        String str;
        LinkedList<String> linkedList;
        p.h(context, "context");
        p.h(zVar, "info");
        p.h(bVar, "adapter");
        AppMethodBeat.i(195270);
        this.psm = zVar;
        this.psQ = bVar;
        this.ptM = pjVar;
        this.ptN = i2;
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
        this.ptL = new a(inflate);
        View findViewById = inflate.findViewById(R.id.bf7);
        p.g(findViewById, "rootView.findViewById(R.id.content_root_layout)");
        int jn = com.tencent.mm.cb.a.jn(context);
        int jo = com.tencent.mm.cb.a.jo(context);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.width = (jn >= jo ? jo : jn) - com.tencent.mm.cb.a.fromDPToPix(context, 82);
        findViewById.setLayoutParams(layoutParams);
        LinkedList<c> linkedList2 = new LinkedList();
        switch (this.psm.gAD().style) {
            case 102:
                LinkedList<String> linkedList3 = this.psm.gAD().Nga.KWr;
                p.g(linkedList3, "info.tlRecCardWrapper.ex…fo.NegativeFeedbackReason");
                int i3 = 0;
                for (T t : linkedList3) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        j.hxH();
                    }
                    linkedList2.add(new c(t, i3));
                    i3 = i4;
                }
                break;
            default:
                pj pjVar2 = this.ptM;
                if (!(pjVar2 == null || (linkedList = pjVar2.KWr) == null)) {
                    int i5 = 0;
                    for (T t2 : linkedList) {
                        int i6 = i5 + 1;
                        if (i5 < 0) {
                            j.hxH();
                        }
                        linkedList2.add(new c(t2, i5));
                        i5 = i6;
                    }
                    break;
                }
        }
        this.ptL.ptA.a(linkedList2, b.ptO);
        this.ptL.ptA.hbO();
        this.ptL.ptA.setOnLabelClickListener(new c(this));
        String str2 = "";
        for (c cVar : linkedList2) {
            if (!Util.isNullOrNil(str2)) {
                str2 = str2 + "#";
            }
            str2 = str2 + cVar.getName();
        }
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[5];
        pj pjVar3 = this.ptM;
        if (pjVar3 != null) {
            str = pjVar3.UserName;
        } else {
            str = null;
        }
        objArr[0] = str;
        objArr[1] = Long.valueOf(this.psm.gAD().MOC);
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(ab.getSessionId());
        objArr[4] = Integer.valueOf(this.ptN);
        hVar.a(18644, objArr);
        hx(inflate);
        this.ptL.hPX.setOnClickListener(this);
        AppMethodBeat.o(195270);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
    static final class c implements LabelsView.b {
        final /* synthetic */ e ptP;

        c(e eVar) {
            this.ptP = eVar;
        }

        @Override // com.tencent.mm.ui.widget.happybubble.LabelsView.b
        public final void j(Object obj, int i2) {
            AppMethodBeat.i(195268);
            this.ptP.ptL.hPX.setEnabled(this.ptP.ptL.ptA.getSelectLabels().size() > 0);
            AppMethodBeat.o(195268);
        }
    }

    public final void onClick(View view) {
        String str;
        String str2;
        LinkedList<pi> linkedList;
        AppMethodBeat.i(195269);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        p.h(view, "v");
        if (view.getId() == R.id.g3k) {
            LinkedList linkedList2 = new LinkedList();
            List<c> selectLabelDatas = this.ptL.ptA.getSelectLabelDatas();
            String str3 = "";
            if (selectLabelDatas != null) {
                for (c cVar : selectLabelDatas) {
                    if (!Util.isNullOrNil(str3)) {
                        str3 = str3 + "#";
                    }
                    StringBuilder append = new StringBuilder().append(str3);
                    p.g(cVar, "tag");
                    str3 = append.append(cVar.getName()).toString();
                    linkedList2.add(cVar.getName());
                }
                str = str3;
            } else {
                str = str3;
            }
            ege gAD = this.psm.gAD();
            ale ale = gAD.Nga;
            pj pjVar = this.ptM;
            pi piVar = (pjVar == null || (linkedList = pjVar.KWy) == null) ? null : linkedList.get(0);
            String str4 = piVar != null ? piVar.KSj : null;
            int i2 = 0;
            long j2 = 0;
            if (!Util.isNullOrNil(str4)) {
                try {
                    Uri parse = Uri.parse(str4);
                    i2 = Util.getInt(parse.getQueryParameter("idx"), 0);
                    j2 = Util.getLong(parse.getQueryParameter("mid"), 0);
                } catch (Exception e2) {
                }
            }
            f fVar = this.psQ.pqZ;
            pj pjVar2 = this.ptM;
            String str5 = pjVar2 != null ? pjVar2.UserName : null;
            long j3 = gAD.MOC;
            String str6 = ale.KUo;
            String str7 = gAD.event;
            String str8 = ale.KUk;
            int i3 = piVar != null ? piVar.KWv : 0;
            int i4 = gAD.style;
            if (piVar == null || (str2 = piVar.KWw) == null) {
                str2 = "";
            }
            fVar.a(str5, j2, i2, 17, j3, str, 0, str6, str7, str8, i3, i4, str2);
            switch (this.psm.gAD().style) {
                case 102:
                    p.g(gAD, "wrapper");
                    l.a(3, gAD, linkedList2, this.psm);
                    break;
                default:
                    p.g(gAD, "wrapper");
                    l.a(1, gAD, linkedList2, this.psm);
                    break;
            }
            ag.ban().MX(this.psm.field_msgId);
            dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195269);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardUnfollowNegativeDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
    public static final class a {
        Button hPX;
        LabelsView ptA;
        private TextView ptB;

        public a(View view) {
            p.h(view, "rootView");
            AppMethodBeat.i(195265);
            View findViewById = view.findViewById(R.id.g3k);
            p.g(findViewById, "rootView.findViewById(R.id.ok_btn)");
            this.hPX = (Button) findViewById;
            View findViewById2 = view.findViewById(R.id.ih5);
            p.g(findViewById2, "rootView.findViewById(R.id.tag_layout)");
            this.ptA = (LabelsView) findViewById2;
            View findViewById3 = view.findViewById(R.id.a6w);
            p.g(findViewById3, "rootView.findViewById(R.id.biz_rec_card_reason_tv)");
            this.ptB = (TextView) findViewById3;
            TextPaint paint = this.ptB.getPaint();
            p.g(paint, "unLikeTv.paint");
            paint.setFakeBoldText(true);
            AppMethodBeat.o(195265);
        }
    }
}
