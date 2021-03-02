package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010J\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u0002012\u0006\u0010N\u001a\u00020\u00112\u0006\u0010O\u001a\u00020\u0011H\u0016J\n\u0010P\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010Q\u001a\u00020\u000bH&J\u0018\u0010R\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u00112\u0006\u0010S\u001a\u000201H\u0016J\u0010\u0010T\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020VH\u0016J \u0010W\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020L2\u0006\u0010X\u001a\u00020Y2\u0006\u0010M\u001a\u000201H\u0016J\b\u0010Z\u001a\u00020\u000bH\u0016J\u0018\u0010[\u001a\u00020\u000b2\b\u0010\\\u001a\u0004\u0018\u00010\u00112\u0006\u0010]\u001a\u000201R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u0010\u0015R\u001c\u00109\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001e\"\u0004\b;\u0010 R\u0011\u0010<\u001a\u00020=¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010'\"\u0004\bB\u0010)R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00103\"\u0004\bG\u00105R\u0011\u0010H\u001a\u000201¢\u0006\b\n\u0000\u001a\u0004\bI\u00103¨\u0006^"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "clickCallback", "Lkotlin/Function0;", "", "getClickCallback", "()Lkotlin/jvm/functions/Function0;", "setClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "setClickView", "(Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "coverContainer", "getCoverContainer", "setCoverContainer", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "setCoverIv", "(Landroid/widget/ImageView;)V", "coverMaskIv", "getCoverMaskIv", "setCoverMaskIv", "digest", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getDigest", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setDigest", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "digestLayout", "Landroid/widget/LinearLayout;", "getDigestLayout", "()Landroid/widget/LinearLayout;", "setDigestLayout", "(Landroid/widget/LinearLayout;)V", "itemShowType", "", "getItemShowType", "()I", "setItemShowType", "(I)V", "itemView", "getItemView", "setItemView", "pressMask", "getPressMask", "setPressMask", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "title", "getTitle", "setTitle", "txtJumpLink", "Landroid/widget/TextView;", "viewId", "getViewId", "setViewId", "width", "getWidth", "filling", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "position", "convertView", "parent", "getViewContainer", "gone", "inflate", "id", "initReaderItem", "itemInfo", "Lcom/tencent/mm/protocal/protobuf/ItemMsg;", "onAppMsgClick", "recommendItem", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "onInflate", "setCoverHeight", "view", "height", "plugin-brandservice_release"})
public abstract class n {
    View aus;
    final Context context;
    private int iwc = -1;
    final b psQ;
    final v ptH = new v();
    private View ptQ;
    MMNeat7extView ptR;
    ImageView ptS;
    kotlin.g.a.a<x> ptZ;
    private TextView puA;
    View puc;
    ImageView puw;
    private ImageView pux;
    private MMNeat7extView puy;
    private LinearLayout puz;
    private int viewId;
    final int width;

    public abstract void cmO();

    public n(Context context2, b bVar) {
        p.h(context2, "context");
        p.h(bVar, "adapter");
        this.context = context2;
        this.psQ = bVar;
        this.width = com.tencent.mm.cb.a.jn(context2) - (b.prw * 2);
    }

    public int getItemShowType() {
        return this.iwc;
    }

    public int getViewId() {
        return this.viewId;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0114, code lost:
        if ((r0 == null || kotlin.n.n.aL(r0)) != false) goto L_0x0116;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.tencent.mm.storage.z r10, int r11, android.view.View r12, android.view.View r13) {
        /*
        // Method dump skipped, instructions count: 321
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.item.n.a(com.tencent.mm.storage.z, int, android.view.View, android.view.View):void");
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ z prL;
        final /* synthetic */ n puB;
        final /* synthetic */ dlb puC;

        a(n nVar, z zVar, dlb dlb, int i2) {
            this.puB = nVar;
            this.prL = zVar;
            this.puC = dlb;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195306);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem$filling$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> aVar = this.puB.ptZ;
            if (aVar != null) {
                aVar.invoke();
            }
            n nVar = this.puB;
            z zVar = this.prL;
            dlb dlb = this.puC;
            p.g(dlb, "itemMsg");
            p.h(zVar, "info");
            p.h(dlb, "recommendItem");
            if (zVar.NQr == null || dlb.MOX == null || dlb.MOY == null) {
                Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
            } else {
                com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
                com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(nVar.context, zVar, dlb);
                nVar.psQ.pqZ.a(zVar, 0, (int) (System.currentTimeMillis() / 1000));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem$filling$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195306);
        }
    }

    public static void V(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = i2;
        }
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
    }

    public void a(cdu cdu) {
        p.h(cdu, "itemInfo");
        this.ptH.type = cdu.iAb;
        this.ptH.iAo = cdu.KSl;
        this.ptH.iAD = cdu.KSm;
        this.ptH.url = cdu.KSj;
    }

    public void cmP() {
    }
}
