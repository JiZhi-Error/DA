package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001IB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010.\u001a\u00020/H\u0002J\u0018\u00100\u001a\u00020/2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J(\u00105\u001a\u00020/2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0010H\u0016J\n\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\u0019H\u0016J\n\u0010<\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010=\u001a\u00020/H\u0016J\u0010\u0010>\u001a\u00020/2\u0006\u00108\u001a\u00020\u0010H\u0016J\u0018\u0010?\u001a\u00020/2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u00020\u0019H\u0002J(\u0010@\u001a\u00020/2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u0010H\u0002J \u0010B\u001a\u00020/2\u0006\u0010\u000f\u001a\u00020C2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u00020\u0019H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010D\u001a\u00020/2\u0006\u00101\u001a\u0002022\u0006\u0010E\u001a\u00020\u0001H\u0016J\u0010\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020\u0019H\u0016J\b\u0010H\u001a\u00020/H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\f\u0012\b\u0012\u00060\u0017R\u00020\u00000\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0004¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010(\u001a\f\u0012\b\u0012\u00060\u0017R\u00020\u00000)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardTmpl;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "imgClose", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "isVideoCard", "", "item", "Landroid/view/View;", "nickNameTv", "Landroid/widget/TextView;", "slotContainer", "Landroid/widget/LinearLayout;", "slotView", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "getStyle", "()I", "setStyle", "(I)V", "viewArticle", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedArticle;", "viewClose", "viewHead", "viewItemList", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "[Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedCommBigItem;", "viewPic", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedPic;", "viewPool", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizSimpleViewPool;", "viewText", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedText;", "viewVideo", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLFeedVideo;", "clearSlotView", "", "clickCard", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "extra", "", "filling", "position", "convertView", "parent", "getVideoRelativePos", "", "getVideoStatus", "getVideoView", "gone", "inflate", "initCommonSlot", "initContent", "viewParent", "initHead", "Lcom/tencent/mm/protocal/protobuf/RecommendCardMsg;", "registerCard", "cardTmpl", "setVideoStatus", "status", "show", "BizRecFeedCommonSlot", "plugin-brandservice_release"})
public final class ae extends ad {
    final Context context;
    private TextView kcZ;
    final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
    private View puO;
    private LinearLayout puP;
    private LinkedList<a> puQ = new LinkedList<>();
    private final i<a> puR = new i<>(new e(this));
    private View pvb;
    private View pve;
    private WeImageView pvf;
    private boolean pvi;
    private m pwV = new m(this.context, this.psQ);
    private q pwW = new q(this.context, this.psQ);
    private o pwX = new o(this.context, this.psQ);
    private p pwY = new p(this.context, this.psQ);
    private final n[] pwZ = {this.pwV, this.pwW, this.pwX, this.pwY};
    private int style = 2001;

    public ae(com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, Context context2) {
        p.h(bVar, "adapter");
        p.h(context2, "context");
        AppMethodBeat.i(195483);
        this.psQ = bVar;
        this.context = context2;
        AppMethodBeat.o(195483);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final int getStyle() {
        return this.style;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0262, code lost:
        if ((r4 == null || kotlin.n.n.aL(r4)) != false) goto L_0x0264;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0385  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0389  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0398  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x03a7  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02d5  */
    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.storage.z r19, int r20, android.view.View r21, android.view.View r22) {
        /*
        // Method dump skipped, instructions count: 1004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.item.ae.a(com.tencent.mm.storage.z, int, android.view.View, android.view.View):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ z prL;
        final /* synthetic */ ae pxb;

        d(ae aeVar, z zVar, int i2) {
            this.pxb = aeVar;
            this.prL = zVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(195476);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$initHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ((h) new h(this.pxb.context, this.prL, this.pxb.psQ, this.gUj).hw(this.pxb.pvf)).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$initHead$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(195476);
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void cmO() {
        AppMethodBeat.i(195479);
        View view = this.puO;
        if (view != null) {
            view.setVisibility(8);
            AppMethodBeat.o(195479);
            return;
        }
        AppMethodBeat.o(195479);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void show() {
        AppMethodBeat.i(195480);
        View view = this.puO;
        if (view != null) {
            view.setVisibility(0);
            AppMethodBeat.o(195480);
            return;
        }
        AppMethodBeat.o(195480);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%J(\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002J*\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020-H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006."}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTimeLineCommSlot;", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;Landroid/content/Context;)V", "getAdapter", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "getContext", "()Landroid/content/Context;", "digestLayout", "Landroid/widget/LinearLayout;", "getDigestLayout", "()Landroid/widget/LinearLayout;", "setDigestLayout", "(Landroid/widget/LinearLayout;)V", "digetst", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "slotView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getSlotView", "()Landroid/view/View;", "txtJumpLink", "Landroid/widget/TextView;", "initUI", "", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "itemMsg", "Lcom/tencent/mm/protocal/protobuf/RecommendItemMsg;", "pos", "", FirebaseAnalytics.b.INDEX, "onAppMsgClick", "recommendItem", "setCoverMask", "item", "position", "loadFinish", "", "plugin-brandservice_release"})
    public final class a extends ah {
        final Context context;
        final com.tencent.mm.plugin.brandservice.ui.timeline.b psQ;
        final v ptH = new v();
        TextView puA;
        final View puS = View.inflate(this.context, R.layout.kk, null);
        LinearLayout puz;
        MMNeat7extView pxa;
        final /* synthetic */ ae pxb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ae aeVar, com.tencent.mm.plugin.brandservice.ui.timeline.b bVar, Context context2) {
            super(bVar, context2);
            p.h(bVar, "adapter");
            p.h(context2, "context");
            this.pxb = aeVar;
            AppMethodBeat.i(195473);
            this.psQ = bVar;
            this.context = context2;
            this.pxo = this.puS.findViewById(R.id.bf0);
            this.pxp = (MMNeat7extView) this.puS.findViewById(R.id.iqr);
            this.pxa = (MMNeat7extView) this.puS.findViewById(R.id.awm);
            this.pxr = this.puS.findViewById(R.id.bgx);
            this.ptE = (ImageView) this.puS.findViewById(R.id.bh7);
            this.pxu = (ImageView) this.puS.findViewById(R.id.gcf);
            this.pxv = this.puS.findViewById(R.id.gbl);
            this.pxw = this.puS.findViewById(R.id.gbk);
            this.puA = (TextView) this.puS.findViewById(R.id.e5p);
            this.puz = (LinearLayout) this.puS.findViewById(R.id.a8u);
            AppMethodBeat.o(195473);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.item.ae$a$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC0875a implements View.OnClickListener {
            final /* synthetic */ z prL;
            final /* synthetic */ int prP;
            final /* synthetic */ dlb puC;
            final /* synthetic */ int puW = 0;
            final /* synthetic */ a pxc;

            View$OnClickListenerC0875a(a aVar, z zVar, dlb dlb, int i2) {
                this.pxc = aVar;
                this.prL = zVar;
                this.puC = dlb;
                this.prP = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(195470);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot$initUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                a aVar = this.pxc;
                z zVar = this.prL;
                dlb dlb = this.puC;
                int i2 = this.puW;
                if (dlb == null || zVar.NQr == null || dlb.MOX == null || dlb.MOY == null) {
                    Log.w("MicroMsg.BizTimeLineItem", "onAppMsgClick appMsg is null");
                } else {
                    com.tencent.mm.plugin.brandservice.ui.timeline.a.a aVar2 = com.tencent.mm.plugin.brandservice.ui.timeline.a.a.pyL;
                    com.tencent.mm.plugin.brandservice.ui.timeline.a.a.a(aVar.context, zVar, dlb);
                    aVar.pxb.a(zVar, "PAUSE_FOR_RESUME");
                    aVar.psQ.pqZ.a(zVar, i2, (int) (System.currentTimeMillis() / 1000));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot$initUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(195470);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot$initUI$3", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "plugin-brandservice_release"})
        public static final class b implements m.a {
            final /* synthetic */ z prL;
            final /* synthetic */ int prP;
            final /* synthetic */ a pxc;

            b(a aVar, z zVar, int i2) {
                this.pxc = aVar;
                this.prL = zVar;
                this.prP = i2;
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onFinish() {
                AppMethodBeat.i(195471);
                this.pxc.a(this.pxc.ptH, true);
                AppMethodBeat.o(195471);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onStart() {
            }
        }

        @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ah
        public final void a(v vVar, boolean z) {
            AppMethodBeat.i(195472);
            p.h(vVar, "item");
            if (vVar.type == 8) {
                View view = this.pxv;
                p.g(view, "coverMaskLayout");
                view.setVisibility(0);
                if (z) {
                    this.pxw.setBackgroundResource(R.drawable.in);
                    AppMethodBeat.o(195472);
                    return;
                }
                this.pxw.setBackgroundResource(R.drawable.aij);
                AppMethodBeat.o(195472);
                return;
            }
            View view2 = this.pxv;
            p.g(view2, "coverMaskLayout");
            view2.setVisibility(8);
            AppMethodBeat.o(195472);
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void a(z zVar, ad adVar) {
        AppMethodBeat.i(195481);
        p.h(zVar, "info");
        p.h(adVar, "cardTmpl");
        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
        MPVideoPreviewMgr.a(zVar, adVar);
        AppMethodBeat.o(195481);
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final boolean cmS() {
        return this.pvi;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final View getVideoView() {
        return this.pwW.puc;
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void setVideoStatus(int i2) {
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.item.ad
    public final void a(z zVar, String str) {
        AppMethodBeat.i(195482);
        p.h(zVar, "info");
        p.h(str, "extra");
        MPVideoPreviewMgr mPVideoPreviewMgr = MPVideoPreviewMgr.pJz;
        MPVideoPreviewMgr.a(zVar, str);
        AppMethodBeat.o(195482);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$BizRecFeedCommonSlot;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent;", "invoke"})
    static final class e extends q implements kotlin.g.a.a<a> {
        final /* synthetic */ ae pxb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ae aeVar) {
            super(0);
            this.pxb = aeVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ a invoke() {
            AppMethodBeat.i(195477);
            a aVar = new a(this.pxb, this.pxb.psQ, this.pxb.context);
            AppMethodBeat.o(195477);
            return aVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$initContent$1$1"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int oeZ;
        final /* synthetic */ ae pxb;
        final /* synthetic */ z pxd;
        final /* synthetic */ View pxe;
        final /* synthetic */ View pxf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ae aeVar, z zVar, int i2, View view, View view2) {
            super(0);
            this.pxb = aeVar;
            this.pxd = zVar;
            this.oeZ = i2;
            this.pxe = view;
            this.pxf = view2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(195474);
            this.pxb.a(this.pxd, "");
            x xVar = x.SXb;
            AppMethodBeat.o(195474);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecFeedContent$initContent$1$2"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int oeZ;
        final /* synthetic */ ae pxb;
        final /* synthetic */ z pxd;
        final /* synthetic */ View pxe;
        final /* synthetic */ View pxf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ae aeVar, z zVar, int i2, View view, View view2) {
            super(0);
            this.pxb = aeVar;
            this.pxd = zVar;
            this.oeZ = i2;
            this.pxe = view;
            this.pxf = view2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(195475);
            this.pxb.a(this.pxd, "PAUSE_FOR_RESUME");
            x xVar = x.SXb;
            AppMethodBeat.o(195475);
            return xVar;
        }
    }
}
