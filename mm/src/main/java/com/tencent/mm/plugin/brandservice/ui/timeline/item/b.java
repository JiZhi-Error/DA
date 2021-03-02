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
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.egd;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.happybubble.BubbleLayout;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import com.tencent.mm.ui.widget.happybubble.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0002\u001b\u001cB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog;", "Lcom/tencent/mm/ui/widget/happybubble/BubbleDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "pos", "", "(Landroid/content/Context;Lcom/tencent/mm/storage/BizTimeLineInfo;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;I)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getInfo", "()Lcom/tencent/mm/storage/BizTimeLineInfo;", "mViewHolder", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "getPos", "()I", "initTag", "", "onClick", "v", "Landroid/view/View;", "setRootViewWidth", "rootView", "Companion", "ViewHolder", "plugin-brandservice_release"})
public final class b extends com.tencent.mm.ui.widget.happybubble.b implements View.OnClickListener {
    private static final String TAG = TAG;
    public static final a ptz = new a((byte) 0);
    private final int pos;
    private final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
    private final z psm;
    private final C0877b pty;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "label", "Landroid/widget/TextView;", "position", "", "data", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardTag;", "getLabelText"})
    static final class c<T> implements LabelsView.a<c> {
        public static final c ptC = new c();

        static {
            AppMethodBeat.i(6542);
            AppMethodBeat.o(6542);
        }

        c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.widget.TextView, int, java.lang.Object] */
        @Override // com.tencent.mm.ui.widget.happybubble.LabelsView.a
        public final /* synthetic */ CharSequence a(TextView textView, int i2, c cVar) {
            AppMethodBeat.i(195258);
            c cVar2 = cVar;
            p.g(cVar2, "data");
            String name = cVar2.getName();
            AppMethodBeat.o(195258);
            return name;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, z zVar, com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, int i2) {
        super(context);
        efz efz;
        egd egd;
        anx anx;
        p.h(context, "context");
        p.h(zVar, "info");
        p.h(bVar, "adapter");
        AppMethodBeat.i(6545);
        this.psm = zVar;
        this.psQ = bVar;
        this.pos = i2;
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
        this.pty = new C0877b(inflate);
        View findViewById = inflate.findViewById(R.id.bf7);
        p.g(findViewById, "rootView.findViewById(R.id.content_root_layout)");
        int jn = com.tencent.mm.cb.a.jn(context);
        int jo = com.tencent.mm.cb.a.jo(context);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.width = (jn >= jo ? jo : jn) - com.tencent.mm.cb.a.fromDPToPix(context, 82);
        findViewById.setLayoutParams(layoutParams);
        z zVar2 = this.psm;
        ArrayList<c> arrayList = new ArrayList();
        ege gAD = zVar2.gAD();
        LinkedList<String> linkedList = (gAD == null || (efz = gAD.NfY) == null || (egd = efz.NfU) == null || (anx = egd.NfX) == null) ? null : anx.KWr;
        ege gAD2 = zVar2.gAD();
        if (gAD2 == null) {
            p.hyc();
        }
        LinkedList<String> linkedList2 = gAD2.NfZ;
        if (!Util.isNullOrNil(linkedList)) {
            if (linkedList == null) {
                p.hyc();
            }
            int size = linkedList.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(new c(linkedList.get(i3), i3));
            }
        } else {
            p.g(linkedList2, "negativeFeedbackReason");
            int size2 = linkedList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                arrayList.add(new c(linkedList2.get(i4), i4));
            }
        }
        this.pty.ptA.a(arrayList, c.ptC);
        this.pty.ptA.hbO();
        this.pty.ptA.setOnLabelClickListener(new d(this));
        String str = "";
        for (c cVar : arrayList) {
            if (!Util.isNullOrNil(str)) {
                str = str + "#";
            }
            str = str + cVar.getName();
        }
        h.INSTANCE.a(18644, zVar2.gAC().NfT.UserName, Long.valueOf(zVar2.gAD().MOC), str, Integer.valueOf(ab.getSessionId()), Integer.valueOf(this.pos));
        hx(inflate);
        this.pty.hPX.setOnClickListener(this);
        AppMethodBeat.o(6545);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "label", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "data", "", "position", "", "onLabelClick"})
    static final class d implements LabelsView.b {
        final /* synthetic */ b ptD;

        d(b bVar) {
            this.ptD = bVar;
        }

        @Override // com.tencent.mm.ui.widget.happybubble.LabelsView.b
        public final void j(Object obj, int i2) {
            AppMethodBeat.i(195259);
            this.ptD.pty.hPX.setEnabled(this.ptD.pty.ptA.getSelectLabels().size() > 0);
            AppMethodBeat.o(195259);
        }
    }

    public final void onClick(View view) {
        AppMethodBeat.i(6544);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        p.h(view, "v");
        if (view.getId() == R.id.g3k) {
            List<c> selectLabelDatas = this.pty.ptA.getSelectLabelDatas();
            String str = "";
            if (selectLabelDatas != null) {
                for (c cVar : selectLabelDatas) {
                    if (!Util.isNullOrNil(str)) {
                        str = str + "#";
                    }
                    StringBuilder append = new StringBuilder().append(str);
                    p.g(cVar, "tag");
                    str = append.append(cVar.getName()).toString();
                }
            }
            this.psQ.pqZ.f(this.psm.gAC().NfT.UserName, this.psm.gAD().MOC, str);
            ag.ban().MX(this.psm.field_msgId);
            dismiss();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(6544);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$ViewHolder;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "labelsView", "Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "getLabelsView", "()Lcom/tencent/mm/ui/widget/happybubble/LabelsView;", "setLabelsView", "(Lcom/tencent/mm/ui/widget/happybubble/LabelsView;)V", "okBtn", "Landroid/widget/Button;", "getOkBtn", "()Landroid/widget/Button;", "setOkBtn", "(Landroid/widget/Button;)V", "unLikeTv", "Landroid/widget/TextView;", "getUnLikeTv", "()Landroid/widget/TextView;", "setUnLikeTv", "(Landroid/widget/TextView;)V", "plugin-brandservice_release"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.item.b$b  reason: collision with other inner class name */
    public static final class C0877b {
        Button hPX;
        LabelsView ptA;
        private TextView ptB;

        public C0877b(View view) {
            p.h(view, "rootView");
            AppMethodBeat.i(6540);
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
            AppMethodBeat.o(6540);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizRecCardOperateDialog$Companion;", "", "()V", "TAG", "", "getTAG$plugin_brandservice_release", "()Ljava/lang/String;", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(6546);
        AppMethodBeat.o(6546);
    }
}
