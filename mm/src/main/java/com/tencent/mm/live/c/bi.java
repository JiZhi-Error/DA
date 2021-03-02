package com.tencent.mm.live.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.b.b.a;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.live.ui.dialog.LiveVisitorMicTipDialogView;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001PB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ6\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020)2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020'0.H\u0002J<\u0010/\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020)2\f\u00102\u001a\b\u0012\u0004\u0012\u00020'0.2\f\u00103\u001a\b\u0012\u0004\u0012\u00020'0.H\u0002J\b\u00104\u001a\u00020\u0013H\u0002J\b\u00105\u001a\u00020'H\u0002J\u0006\u00106\u001a\u00020\u001bJ\b\u00107\u001a\u00020'H\u0002J\u0016\u00108\u001a\u00020'2\f\u00109\u001a\b\u0012\u0004\u0012\u00020'0.H\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010:\u001a\u00020'H\u0016J\u0012\u0010;\u001a\u00020'2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J,\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020)2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020\u0013H\u0002J\b\u0010G\u001a\u00020'H\u0002J\b\u0010H\u001a\u00020'H\u0002J\b\u0010I\u001a\u00020'H\u0002J\u001a\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010O\u001a\u00020'H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveVisitorMicPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "closeBtn", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/live/ui/dialog/LiveMicDialog;", "isWaitingMic", "", "liveCore", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "micBtn", "micBtnClickArea", "Landroid/widget/RelativeLayout;", "micIcon2", "micLayout", "Landroid/widget/LinearLayout;", "micModeTipTv", "Landroid/widget/TextView;", "micTv", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "switchBottomSheet", "view", "Lcom/tencent/mm/live/ui/dialog/LiveVisitorMicTipDialogView;", "waitingLayout", "waitingLayout2", "buildConfirmDialog", "", "title", "", "item", "titleColor", "itemColor", "click", "Lkotlin/Function0;", "buildSwitchMicModeDialog", "titleIcon", "cancel", "videoClick", "closeClick", "checkPermission", "doMicRequest", "getMicBtnLayout", "hangUpMicForCalling", "hangUpMicForWaiting", "fail", "mount", "onClick", "v", "Landroid/view/View;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setMicBtnEnable", "enable", "showMicCallingView", "showMicIconView", "showMicWaitingView", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"})
public final class bi extends a implements View.OnClickListener, com.tencent.mm.ak.i {
    public static final a hTn = new a((byte) 0);
    private final Context context;
    private final com.tencent.mm.live.ui.dialog.a hON;
    private final b hOp;
    private com.tencent.mm.ui.widget.a.e hOv;
    private final ImageView hTa;
    private final TextView hTb;
    private final ImageView hTc;
    private final ImageView hTd;
    private final RelativeLayout hTe;
    final LinearLayout hTf;
    private final LinearLayout hTg;
    private final LinearLayout hTh;
    private final TextView hTi;
    private final LiveVisitorMicTipDialogView hTj;
    private com.tencent.mm.ui.widget.a.e hTk;
    private final com.tencent.mm.plugin.voip.video.e hTl = new com.tencent.mm.plugin.voip.video.e(MMApplicationContext.getContext());
    public boolean hTm;
    private com.tencent.mm.live.core.core.d.b liveCore;

    static {
        AppMethodBeat.i(208258);
        AppMethodBeat.o(208258);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class m extends q implements kotlin.g.a.a<x> {
        public static final m hTB = new m();

        static {
            AppMethodBeat.i(208245);
            AppMethodBeat.o(208245);
        }

        m() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bi(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208257);
        this.hOp = bVar;
        this.context = viewGroup.getContext();
        View findViewById = viewGroup.findViewById(R.id.ele);
        p.g(findViewById, "root.findViewById(R.id.live_right_panel_mic)");
        this.hTa = (ImageView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.elg);
        p.g(findViewById2, "root.findViewById(R.id.live_right_panel_mic_tv)");
        this.hTb = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.ens);
        p.g(findViewById3, "root.findViewById(R.id.live_visitor_mic_photo2)");
        this.hTc = (ImageView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.eje);
        p.g(findViewById4, "root.findViewById(R.id.live_mic_close)");
        this.hTd = (ImageView) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.elf);
        p.g(findViewById5, "root.findViewById(R.id.l…ght_panel_mic_click_area)");
        this.hTe = (RelativeLayout) findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.ejm);
        p.g(findViewById6, "root.findViewById(R.id.live_mic_layout)");
        this.hTf = (LinearLayout) findViewById6;
        View findViewById7 = viewGroup.findViewById(R.id.ejw);
        p.g(findViewById7, "root.findViewById(R.id.live_mic_waiting_layout)");
        this.hTg = (LinearLayout) findViewById7;
        View findViewById8 = viewGroup.findViewById(R.id.ejx);
        p.g(findViewById8, "root.findViewById(R.id.live_mic_waiting_layout2)");
        this.hTh = (LinearLayout) findViewById8;
        View findViewById9 = viewGroup.findViewById(R.id.ejo);
        p.g(findViewById9, "root.findViewById(R.id.live_mic_mode_tip)");
        this.hTi = (TextView) findViewById9;
        Context context2 = this.context;
        p.g(context2, "context");
        this.hTj = new LiveVisitorMicTipDialogView(context2);
        Context context3 = viewGroup.getContext();
        p.g(context3, "root.context");
        this.hON = new com.tencent.mm.live.ui.dialog.a(context3);
        b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
        viewGroup.getContext();
        this.liveCore = b.a.aEf();
        this.hTj.setOnButtonClickListener(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.live.c.bi.AnonymousClass1 */
            final /* synthetic */ bi hTo;

            {
                this.hTo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(208219);
                if (bool.booleanValue()) {
                    this.hTo.hON.cancel();
                    bi.h(this.hTo);
                } else {
                    this.hTo.hON.cancel();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(208219);
                return xVar;
            }
        });
        this.hON.setContentView(this.hTj);
        eO(false);
        ImageView imageView = this.hTd;
        Context context4 = viewGroup.getContext();
        p.g(context4, "root.context");
        imageView.setImageDrawable(ar.e(context4.getResources().getDrawable(R.raw.icons_filled_close), WebView.NIGHT_MODE_COLOR));
        ImageView imageView2 = this.hTc;
        Context context5 = viewGroup.getContext();
        p.g(context5, "root.context");
        imageView2.setImageDrawable(ar.e(context5.getResources().getDrawable(R.raw.icons_filled_call), WebView.NIGHT_MODE_COLOR));
        this.hTe.setOnClickListener(this);
        this.hTd.setOnClickListener(this);
        aHP();
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aHa().hKN = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.live.c.bi.AnonymousClass2 */
            final /* synthetic */ bi hTo;

            {
                this.hTo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(208221);
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.live.c.bi.AnonymousClass2.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass2 hTp;

                    {
                        this.hTp = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(208220);
                        bi.l(this.hTp.hTo);
                        this.hTp.hTo.hTl.g(R.raw.playend, true, 1);
                        b.C0376b.a(this.hTp.hTo.hOp, b.c.hLI);
                        AppMethodBeat.o(208220);
                    }
                });
                x xVar = x.SXb;
                AppMethodBeat.o(208221);
                return xVar;
            }
        };
        com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aHa().h(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.live.c.bi.AnonymousClass3 */
            final /* synthetic */ bi hTo;

            {
                this.hTo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                String str;
                AppMethodBeat.i(208222);
                if (bool.booleanValue()) {
                    com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                    String aGm = com.tencent.mm.live.b.x.aGm();
                    com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                    long j2 = com.tencent.mm.live.b.x.aGr().hyH;
                    com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                    a.C0371a aVar = com.tencent.mm.live.b.x.aHa().hKU;
                    if (aVar == null || (str = aVar.hFz) == null) {
                        str = "";
                    }
                    com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
                    long aGY = com.tencent.mm.live.b.x.aGY();
                    com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
                    int i2 = com.tencent.mm.live.b.x.aGZ() ? 1 : 0;
                    com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.d.e.a(aGm, j2, str, aGY, 1, i2, com.tencent.mm.live.b.x.aGt());
                    this.hTo.hTl.g(R.raw.playend, true, 1);
                    com.tencent.mm.live.b.x xVar7 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.x.aHa().aHk();
                    bi.b(this.hTo);
                    b.C0376b.a(this.hTo.hOp, b.c.hLL);
                    u.makeText(this.hTo.context, com.tencent.mm.cb.a.aI(this.hTo.context, R.string.ej4), 0).show();
                    com.tencent.mm.live.b.x xVar8 = com.tencent.mm.live.b.x.hJf;
                    String aGm2 = com.tencent.mm.live.b.x.aGm();
                    com.tencent.mm.live.b.x xVar9 = com.tencent.mm.live.b.x.hJf;
                    long j3 = com.tencent.mm.live.b.x.aGr().hyH;
                    com.tencent.mm.live.b.x xVar10 = com.tencent.mm.live.b.x.hJf;
                    String aGt = com.tencent.mm.live.b.x.aGt();
                    String aTY = z.aTY();
                    p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
                    com.tencent.mm.live.b.x xVar11 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.d.e.a(aGm2, j3, aGt, 9, 4, aTY, com.tencent.mm.live.b.x.aGr().LIa);
                } else {
                    com.tencent.mm.live.b.x xVar12 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.x.aHa().hKU = null;
                    b.C0376b.a(this.hTo.hOp, b.c.hLN);
                }
                x xVar13 = x.SXb;
                AppMethodBeat.o(208222);
                return xVar13;
            }
        });
        com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.b.a aHa = com.tencent.mm.live.b.x.aHa();
        AnonymousClass4 r0 = new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.live.c.bi.AnonymousClass4 */
            final /* synthetic */ bi hTo;

            {
                this.hTo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(208224);
                boolean booleanValue = bool.booleanValue();
                if (this.hTo.hTg.getVisibility() == 0) {
                    bi.b(this.hTo);
                    bi.a(this.hTo, AnonymousClass1.hTq);
                }
                if (!booleanValue) {
                    b.C0376b.a(this.hTo.hOp, b.c.hLK);
                    u.makeText(this.hTo.context, com.tencent.mm.cb.a.aI(this.hTo.context, R.string.eig), 0).show();
                }
                bi.a(this.hTo, booleanValue);
                x xVar = x.SXb;
                AppMethodBeat.o(208224);
                return xVar;
            }
        };
        p.h(r0, "observer");
        aHa.hKP = r0;
        com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aHa().hKR = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.live.c.bi.AnonymousClass5 */
            final /* synthetic */ bi hTo;

            {
                this.hTo = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(208225);
                b.C0376b.a(this.hTo.hOp, b.c.hLJ);
                x xVar = x.SXb;
                AppMethodBeat.o(208225);
                return xVar;
            }
        };
        this.hTh.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.bi.AnonymousClass6 */
            final /* synthetic */ bi hTo;

            {
                this.hTo = r1;
            }

            public final void onClick(View view) {
                int i2;
                int i3;
                AppMethodBeat.i(208228);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVisitorMicPlugin$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.hTo.liveCore.hAz.aDu()) {
                    i2 = R.raw.icons_filled_video_call;
                    i3 = R.string.eiz;
                } else {
                    i2 = R.raw.icons_filled_call;
                    i3 = R.string.eiy;
                }
                bi.a(this.hTo, i3, i2, new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.live.c.bi.AnonymousClass6.AnonymousClass1 */
                    final /* synthetic */ AnonymousClass6 hTr;

                    {
                        this.hTr = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(208226);
                        if (this.hTr.hTo.liveCore.hAz.aDu()) {
                            b.C0376b.a(this.hTr.hTo.hOp, b.c.hMg);
                        } else {
                            b.C0376b.a(this.hTr.hTo.hOp, b.c.hMh);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(208226);
                        return xVar;
                    }
                }, new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.live.c.bi.AnonymousClass6.AnonymousClass2 */
                    final /* synthetic */ AnonymousClass6 hTr;

                    {
                        this.hTr = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        String str;
                        AppMethodBeat.i(208227);
                        bi.o(this.hTr.hTo);
                        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                        String aGm = com.tencent.mm.live.b.x.aGm();
                        com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                        long j2 = com.tencent.mm.live.b.x.aGr().hyH;
                        com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                        a.C0371a aVar = com.tencent.mm.live.b.x.aHa().hKU;
                        if (aVar == null || (str = aVar.hFz) == null) {
                            str = "";
                        }
                        com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
                        long aGY = com.tencent.mm.live.b.x.aGY();
                        com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
                        int i2 = com.tencent.mm.live.b.x.aGZ() ? 1 : 0;
                        com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
                        com.tencent.mm.live.d.e.a(aGm, j2, str, aGY, 2, i2, com.tencent.mm.live.b.x.aGt());
                        x xVar7 = x.SXb;
                        AppMethodBeat.o(208227);
                        return xVar7;
                    }
                });
                com.tencent.mm.ui.widget.a.e eVar = this.hTo.hTk;
                if (eVar != null) {
                    eVar.dGm();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorMicPlugin$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208228);
            }
        });
        this.hTg.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.bi.AnonymousClass7 */
            final /* synthetic */ bi hTo;

            {
                this.hTo = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208229);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVisitorMicPlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.hTo.hTd.performClick();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorMicPlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208229);
            }
        });
        AppMethodBeat.o(208257);
    }

    public static final /* synthetic */ void a(bi biVar, kotlin.g.a.a aVar) {
        AppMethodBeat.i(208261);
        biVar.o(aVar);
        AppMethodBeat.o(208261);
    }

    public static final /* synthetic */ void a(bi biVar, boolean z) {
        AppMethodBeat.i(208264);
        biVar.eO(z);
        AppMethodBeat.o(208264);
    }

    public static final /* synthetic */ void b(bi biVar) {
        AppMethodBeat.i(208259);
        biVar.aHP();
        AppMethodBeat.o(208259);
    }

    public static final /* synthetic */ void i(bi biVar) {
        AppMethodBeat.i(208262);
        biVar.aHN();
        AppMethodBeat.o(208262);
    }

    public static final /* synthetic */ void l(bi biVar) {
        AppMethodBeat.i(208263);
        biVar.aHO();
        AppMethodBeat.o(208263);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveVisitorMicPlugin$Companion;", "", "()V", "AUDIO_LINK_MIC", "", "SHEET_CLOSE", "SHEET_REQUEST_MIC", "SHEET_SWITCH_MIC_MODE", "SHEET_TITLE", "TAG", "", "VIDEO_LINK_MIC", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
    public static final class h implements com.tencent.mm.ak.i {
        final /* synthetic */ bi hTo;

        h(bi biVar) {
            this.hTo = biVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00c9  */
        @Override // com.tencent.mm.ak.i
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int r11, int r12, java.lang.String r13, com.tencent.mm.ak.q r14) {
            /*
            // Method dump skipped, instructions count: 484
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.c.bi.h.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
        }
    }

    private final void aHN() {
        AppMethodBeat.i(208246);
        this.hTm = true;
        this.hTf.setVisibility(4);
        this.hTg.setVisibility(0);
        this.hTh.setVisibility(4);
        AppMethodBeat.o(208246);
    }

    private final void aHO() {
        AppMethodBeat.i(208247);
        this.hTm = false;
        this.hTf.setVisibility(4);
        this.hTh.setVisibility(0);
        this.hTg.setVisibility(4);
        AppMethodBeat.o(208247);
    }

    private final void aHP() {
        AppMethodBeat.i(208248);
        this.hTm = false;
        this.hTg.setVisibility(4);
        this.hTh.setVisibility(4);
        this.hTf.setVisibility(0);
        AppMethodBeat.o(208248);
    }

    private final void a(int i2, int i3, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(208249);
        if (this.hOv == null) {
            this.hOv = new com.tencent.mm.ui.widget.a.e(this.context, 1, true);
            com.tencent.mm.ui.widget.a.e eVar = this.hOv;
            if (eVar != null) {
                eVar.hbs();
            }
        }
        View inflate = View.inflate(this.hwr.getContext(), R.layout.b0l, null);
        TextView textView = (TextView) inflate.findViewById(R.id.eg6);
        com.tencent.mm.ui.widget.a.e eVar2 = this.hOv;
        if (eVar2 != null) {
            eVar2.setTitleView(inflate);
        }
        p.g(textView, "bottomSheetTitleTv");
        Context context2 = this.context;
        p.g(context2, "context");
        textView.setText(context2.getResources().getString(i2));
        com.tencent.mm.ui.widget.a.e eVar3 = this.hOv;
        if (eVar3 != null) {
            eVar3.hbr();
        }
        com.tencent.mm.ui.widget.a.e eVar4 = this.hOv;
        if (eVar4 != null) {
            eVar4.Dp(false);
        }
        com.tencent.mm.ui.widget.a.e eVar5 = this.hOv;
        if (eVar5 != null) {
            eVar5.a(new b(this, i3));
        }
        com.tencent.mm.ui.widget.a.e eVar6 = this.hOv;
        if (eVar6 != null) {
            eVar6.a(new c(this, aVar));
        }
        com.tencent.mm.ui.widget.a.e eVar7 = this.hOv;
        if (eVar7 != null) {
            eVar7.b(new d(this));
            AppMethodBeat.o(208249);
            return;
        }
        AppMethodBeat.o(208249);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class b implements o.f {
        final /* synthetic */ int hRC;
        final /* synthetic */ bi hTo;

        b(bi biVar, int i2) {
            this.hTo = biVar;
            this.hRC = i2;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(208231);
            com.tencent.mm.ui.widget.a.e eVar = this.hTo.hOv;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            Context context = this.hTo.context;
            p.g(context, "context");
            mVar.d(1, context.getResources().getString(this.hRC));
            AppMethodBeat.o(208231);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
    public static final class c implements o.g {
        final /* synthetic */ kotlin.g.a.a hRD;
        final /* synthetic */ bi hTo;

        c(bi biVar, kotlin.g.a.a aVar) {
            this.hTo = biVar;
            this.hRD = aVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(208232);
            p.h(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 0:
                    AppMethodBeat.o(208232);
                    return;
                case 1:
                    this.hRD.invoke();
                    com.tencent.mm.ui.widget.a.e eVar = this.hTo.hOv;
                    if (eVar != null) {
                        eVar.bMo();
                        AppMethodBeat.o(208232);
                        return;
                    }
                    AppMethodBeat.o(208232);
                    return;
                default:
                    com.tencent.mm.ui.widget.a.e eVar2 = this.hTo.hOv;
                    if (eVar2 != null) {
                        eVar2.bMo();
                        AppMethodBeat.o(208232);
                        return;
                    }
                    AppMethodBeat.o(208232);
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class d implements e.b {
        final /* synthetic */ bi hTo;

        d(bi biVar) {
            this.hTo = biVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(208233);
            this.hTo.hOv = null;
            AppMethodBeat.o(208233);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class e implements o.f {
        final /* synthetic */ bi hTo;
        final /* synthetic */ int hTs;
        final /* synthetic */ int hTt;
        final /* synthetic */ int hTu = R.string.ejc;

        e(bi biVar, int i2, int i3) {
            this.hTo = biVar;
            this.hTs = i2;
            this.hTt = i3;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(208234);
            com.tencent.mm.ui.widget.a.e eVar = this.hTo.hTk;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            com.tencent.mm.ui.widget.a.e eVar2 = this.hTo.hTk;
            if (eVar2 != null) {
                eVar2.setTitleView(null);
            }
            mVar.clear();
            Context context = this.hTo.context;
            p.g(context, "context");
            String string = context.getResources().getString(this.hTs);
            p.g(string, "context.resources.getString(title)");
            mVar.b(2, string, this.hTt);
            Context context2 = this.hTo.context;
            p.g(context2, "context");
            int color = context2.getResources().getColor(R.color.xq);
            Context context3 = this.hTo.context;
            p.g(context3, "context");
            mVar.a(1, color, context3.getResources().getString(this.hTu));
            AppMethodBeat.o(208234);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
    public static final class f implements o.g {
        final /* synthetic */ bi hTo;
        final /* synthetic */ kotlin.g.a.a hTv;
        final /* synthetic */ kotlin.g.a.a hTw;

        f(bi biVar, kotlin.g.a.a aVar, kotlin.g.a.a aVar2) {
            this.hTo = biVar;
            this.hTv = aVar;
            this.hTw = aVar2;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(208235);
            p.h(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 1:
                    this.hTw.invoke();
                    com.tencent.mm.ui.widget.a.e eVar = this.hTo.hTk;
                    if (eVar != null) {
                        eVar.bMo();
                        AppMethodBeat.o(208235);
                        return;
                    }
                    AppMethodBeat.o(208235);
                    return;
                case 2:
                    this.hTv.invoke();
                    com.tencent.mm.ui.widget.a.e eVar2 = this.hTo.hTk;
                    if (eVar2 != null) {
                        eVar2.bMo();
                        AppMethodBeat.o(208235);
                        return;
                    }
                    AppMethodBeat.o(208235);
                    return;
                default:
                    com.tencent.mm.ui.widget.a.e eVar3 = this.hTo.hTk;
                    if (eVar3 != null) {
                        eVar3.bMo();
                        AppMethodBeat.o(208235);
                        return;
                    }
                    AppMethodBeat.o(208235);
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class g implements e.b {
        final /* synthetic */ bi hTo;

        g(bi biVar) {
            this.hTo = biVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(208236);
            this.hTo.hTk = null;
            AppMethodBeat.o(208236);
        }
    }

    public final void onClick(View view) {
        boolean z;
        AppMethodBeat.i(208250);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVisitorMicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.elf) {
            Context context2 = this.hwr.getContext();
            if (context2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(208250);
                throw tVar;
            }
            if (!com.tencent.mm.pluginsdk.permission.b.a((Activity) context2, "android.permission.CAMERA", 16, "", "")) {
                Log.i("MicroMsg.LiveCoreMic", "not get enough permission checkCamera");
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aGD().hJq = true;
                z = false;
            } else {
                Context context3 = this.hwr.getContext();
                if (context3 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(208250);
                    throw tVar2;
                } else if (!com.tencent.mm.pluginsdk.permission.b.a((Activity) context3, "android.permission.RECORD_AUDIO", 80, "", "")) {
                    Log.i("MicroMsg.LiveCoreMic", "not get enough permission checkMicroPhone");
                    com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.b.x.aGD().hJq = true;
                    z = false;
                } else {
                    z = true;
                }
            }
            if (!z) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorMicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208250);
                return;
            }
            a(R.string.eiw, R.string.eja, new k(this));
            com.tencent.mm.ui.widget.a.e eVar = this.hOv;
            if (eVar != null) {
                eVar.dGm();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.eje) {
            a(R.string.ej6, R.string.eid, new l(this));
            com.tencent.mm.ui.widget.a.e eVar2 = this.hOv;
            if (eVar2 != null) {
                eVar2.dGm();
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorMicPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208250);
    }

    private final void o(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(208251);
        aHP();
        com.tencent.mm.live.core.debug.a aVar2 = com.tencent.mm.live.core.debug.a.hCA;
        StringBuilder sb = new StringBuilder("[cgi]visitor close mic.");
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", sb.append(com.tencent.mm.live.b.x.aHa().hKU).toString());
        com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
        long j2 = com.tencent.mm.live.b.x.aGr().hyH;
        com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
        String aGm = com.tencent.mm.live.b.x.aGm();
        String valueOf = String.valueOf(System.currentTimeMillis());
        com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
        String str = com.tencent.mm.live.b.x.aHa().hKV;
        com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
        String str2 = com.tencent.mm.live.b.x.aGr().MnL;
        p.g(str2, "RoomLiveService.liveInfo.sdk_user_id");
        com.tencent.mm.live.b.a.k kVar = new com.tencent.mm.live.b.a.k(j2, aGm, valueOf, str, str2);
        com.tencent.mm.ak.t azz = com.tencent.mm.kernel.g.azz();
        p.g(azz, "MMKernel.getNetSceneQueue()");
        kVar.doScene(azz.azD(), new j(aVar));
        com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
        String aGm2 = com.tencent.mm.live.b.x.aGm();
        com.tencent.mm.live.b.x xVar7 = com.tencent.mm.live.b.x.hJf;
        long j3 = com.tencent.mm.live.b.x.aGr().hyH;
        com.tencent.mm.live.b.x xVar8 = com.tencent.mm.live.b.x.hJf;
        String aGt = com.tencent.mm.live.b.x.aGt();
        String aTY = z.aTY();
        p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
        com.tencent.mm.live.b.x xVar9 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.d.e.a(aGm2, j3, aGt, 6, 1, aTY, com.tencent.mm.live.b.x.aGr().LIa);
        com.tencent.mm.live.d.c.aIk();
        AppMethodBeat.o(208251);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
    public static final class j implements com.tencent.mm.ak.i {
        final /* synthetic */ kotlin.g.a.a hTz;

        j(kotlin.g.a.a aVar) {
            this.hTz = aVar;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(208241);
            qVar.setHasCallbackToQueue(true);
            com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.GA("close mic errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.x.aHa().aHk();
            if (!(i3 == 0 && i2 == 0)) {
                this.hTz.invoke();
            }
            AppMethodBeat.o(208241);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n¨\u0006\u000b"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "com/tencent/mm/live/plugin/LiveVisitorMicPlugin$hangUpMicForCalling$1$1"})
    public static final class i implements com.tencent.mm.ak.i {
        final /* synthetic */ bi hTo;

        i(bi biVar) {
            this.hTo = biVar;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(208240);
            qVar.setHasCallbackToQueue(true);
            com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
            com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[cgi-ret]user close mic :" + i2 + " errCode:" + i3 + " errMsg:" + str);
            if (i2 == 0 && i3 == 0) {
                this.hTo.hTl.g(R.raw.playend, true, 1);
                u.makeText(this.hTo.context, com.tencent.mm.cb.a.aI(this.hTo.context, R.string.ej4), 0).show();
                com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.aHa().aHk();
                bi.b(this.hTo);
                Bundle bundle = new Bundle();
                bundle.putBoolean("PARAM_HANGUP_SELF", true);
                this.hTo.hOp.statusChange(b.c.hLL, bundle);
            }
            AppMethodBeat.o(208240);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(208252);
        super.mount();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3806, this);
        AppMethodBeat.o(208252);
    }

    @Override // com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(208253);
        super.unMount();
        this.hOv = null;
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3806, this);
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        if (!TextUtils.isEmpty(com.tencent.mm.live.b.x.aHa().hKV)) {
            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
            if (com.tencent.mm.live.b.x.isManualClosed()) {
                o(m.hTB);
            }
        }
        AppMethodBeat.o(208253);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        civ aGr;
        AppMethodBeat.i(208254);
        if (!(qVar instanceof com.tencent.mm.live.b.a.b) || i2 != 0 || i3 != 0 || (aGr = ((com.tencent.mm.live.b.a.b) qVar).aGr()) == null) {
            AppMethodBeat.o(208254);
            return;
        }
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.GA("get live info for mic:" + aGr.Lml);
        eO(aGr.Lml);
        AppMethodBeat.o(208254);
    }

    private final void eO(boolean z) {
        AppMethodBeat.i(208255);
        this.hTe.setEnabled(z);
        this.hTe.setClickable(z);
        if (z) {
            ImageView imageView = this.hTa;
            Context context2 = this.hwr.getContext();
            p.g(context2, "root.context");
            imageView.setImageDrawable(ar.e(context2.getResources().getDrawable(R.raw.icons_filled_call), -1));
            TextView textView = this.hTb;
            Context context3 = this.hwr.getContext();
            p.g(context3, "root.context");
            textView.setText(context3.getResources().getString(R.string.egn));
            AppMethodBeat.o(208255);
            return;
        }
        Drawable drawable = this.hTa.getDrawable();
        if (drawable != null) {
            drawable.clearColorFilter();
        }
        ImageView imageView2 = this.hTa;
        Context context4 = this.hwr.getContext();
        p.g(context4, "root.context");
        imageView2.setImageDrawable(context4.getResources().getDrawable(R.raw.icons_filled_mic_visitor_disable));
        TextView textView2 = this.hTb;
        Context context5 = this.hwr.getContext();
        p.g(context5, "root.context");
        textView2.setText(context5.getResources().getString(R.string.egn));
        AppMethodBeat.o(208255);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208256);
        p.h(cVar, "status");
        switch (bj.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                aHP();
                TextView textView = this.hTi;
                Context context2 = this.hwr.getContext();
                p.g(context2, "root.context");
                textView.setText(context2.getResources().getString(R.string.eje));
                ImageView imageView = this.hTc;
                Context context3 = this.hwr.getContext();
                p.g(context3, "root.context");
                imageView.setImageDrawable(ar.e(context3.getResources().getDrawable(R.raw.icons_filled_call), WebView.NIGHT_MODE_COLOR));
                if (bundle == null) {
                    AppMethodBeat.o(208256);
                    return;
                } else if (bundle.getBoolean("PARAM_HANGUP_SELF", false)) {
                    com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                    String aGm = com.tencent.mm.live.b.x.aGm();
                    com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
                    long j2 = com.tencent.mm.live.b.x.aGr().hyH;
                    com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
                    String aGt = com.tencent.mm.live.b.x.aGt();
                    String aTY = z.aTY();
                    p.g(aTY, "ConfigStorageLogic.getUsernameFromUserInfo()");
                    com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
                    com.tencent.mm.live.d.e.a(aGm, j2, aGt, 9, 4, aTY, com.tencent.mm.live.b.x.aGr().LIa);
                    AppMethodBeat.o(208256);
                    return;
                }
                break;
            case 2:
                TextView textView2 = this.hTi;
                Context context4 = this.hwr.getContext();
                p.g(context4, "root.context");
                textView2.setText(context4.getResources().getString(R.string.eje));
                ImageView imageView2 = this.hTc;
                Context context5 = this.hwr.getContext();
                p.g(context5, "root.context");
                imageView2.setImageDrawable(ar.e(context5.getResources().getDrawable(R.raw.icons_filled_call), WebView.NIGHT_MODE_COLOR));
                AppMethodBeat.o(208256);
                return;
            case 3:
                TextView textView3 = this.hTi;
                Context context6 = this.hwr.getContext();
                p.g(context6, "root.context");
                textView3.setText(context6.getResources().getString(R.string.ejd));
                ImageView imageView3 = this.hTc;
                Context context7 = this.hwr.getContext();
                p.g(context7, "root.context");
                imageView3.setImageDrawable(ar.e(context7.getResources().getDrawable(R.raw.icons_filled_video_call), WebView.NIGHT_MODE_COLOR));
                AppMethodBeat.o(208256);
                return;
            case 4:
                com.tencent.mm.live.b.x xVar5 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.ra(com.tencent.mm.live.b.x.aGS() + 1);
                com.tencent.mm.live.b.x xVar6 = com.tencent.mm.live.b.x.hJf;
                String aGm2 = com.tencent.mm.live.b.x.aGm();
                com.tencent.mm.live.b.x xVar7 = com.tencent.mm.live.b.x.hJf;
                long j3 = com.tencent.mm.live.b.x.aGr().hyH;
                com.tencent.mm.live.b.x xVar8 = com.tencent.mm.live.b.x.hJf;
                String aGt2 = com.tencent.mm.live.b.x.aGt();
                String aTY2 = z.aTY();
                p.g(aTY2, "ConfigStorageLogic.getUsernameFromUserInfo()");
                com.tencent.mm.live.b.x xVar9 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.d.e.a(aGm2, j3, aGt2, 6, 0, aTY2, com.tencent.mm.live.b.x.aGr().LIa);
                com.tencent.mm.live.d.c.aIj();
                AppMethodBeat.o(208256);
                return;
            case 5:
                com.tencent.mm.live.b.x xVar10 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.b.x.rb(com.tencent.mm.live.b.x.aGT() + 1);
                com.tencent.mm.live.b.x xVar11 = com.tencent.mm.live.b.x.hJf;
                String aGm3 = com.tencent.mm.live.b.x.aGm();
                com.tencent.mm.live.b.x xVar12 = com.tencent.mm.live.b.x.hJf;
                long j4 = com.tencent.mm.live.b.x.aGr().hyH;
                com.tencent.mm.live.b.x xVar13 = com.tencent.mm.live.b.x.hJf;
                String aGt3 = com.tencent.mm.live.b.x.aGt();
                String aTY3 = z.aTY();
                p.g(aTY3, "ConfigStorageLogic.getUsernameFromUserInfo()");
                com.tencent.mm.live.b.x xVar14 = com.tencent.mm.live.b.x.hJf;
                com.tencent.mm.live.d.e.a(aGm3, j4, aGt3, 9, 1, aTY3, com.tencent.mm.live.b.x.aGr().LIa);
                com.tencent.mm.live.d.c.aIo();
                AppMethodBeat.o(208256);
                return;
            case 6:
                if (!this.liveCore.hAz.aDt()) {
                    if (this.liveCore.hAz.aDu()) {
                        aHO();
                        TextView textView4 = this.hTi;
                        Context context8 = this.hwr.getContext();
                        p.g(context8, "root.context");
                        textView4.setText(context8.getResources().getString(R.string.eje));
                        ImageView imageView4 = this.hTc;
                        Context context9 = this.hwr.getContext();
                        p.g(context9, "root.context");
                        imageView4.setImageDrawable(ar.e(context9.getResources().getDrawable(R.raw.icons_filled_call), WebView.NIGHT_MODE_COLOR));
                        break;
                    }
                } else {
                    aHO();
                    TextView textView5 = this.hTi;
                    Context context10 = this.hwr.getContext();
                    p.g(context10, "root.context");
                    textView5.setText(context10.getResources().getString(R.string.ejd));
                    ImageView imageView5 = this.hTc;
                    Context context11 = this.hwr.getContext();
                    p.g(context11, "root.context");
                    imageView5.setImageDrawable(ar.e(context11.getResources().getDrawable(R.raw.icons_filled_video_call), WebView.NIGHT_MODE_COLOR));
                    AppMethodBeat.o(208256);
                    return;
                }
                break;
        }
        AppMethodBeat.o(208256);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bi hTo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(bi biVar) {
            super(0);
            this.hTo = biVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(208242);
            bi.h(this.hTo);
            x xVar = x.SXb;
            AppMethodBeat.o(208242);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bi hTo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(bi biVar) {
            super(0);
            this.hTo = biVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(208244);
            bi.a(this.hTo, new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.live.c.bi.l.AnonymousClass1 */
                final /* synthetic */ l hTA;

                {
                    this.hTA = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(208243);
                    b.C0376b.a(this.hTA.hTo.hOp, b.c.hLM);
                    bi.i(this.hTA.hTo);
                    x xVar = x.SXb;
                    AppMethodBeat.o(208243);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(208244);
            return xVar;
        }
    }

    public static final /* synthetic */ void h(bi biVar) {
        AppMethodBeat.i(208260);
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[cgi]doApplyMic start");
        biVar.aHN();
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        long j2 = com.tencent.mm.live.b.x.aGr().hyH;
        com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.a.h hVar = new com.tencent.mm.live.b.a.h(j2, com.tencent.mm.live.b.x.aGm(), String.valueOf(System.currentTimeMillis()));
        com.tencent.mm.ak.t azz = com.tencent.mm.kernel.g.azz();
        p.g(azz, "MMKernel.getNetSceneQueue()");
        hVar.doScene(azz.azD(), new h(biVar));
        AppMethodBeat.o(208260);
    }

    public static final /* synthetic */ void a(bi biVar, int i2, int i3, kotlin.g.a.a aVar, kotlin.g.a.a aVar2) {
        AppMethodBeat.i(208265);
        if (biVar.hTk == null) {
            biVar.hTk = new com.tencent.mm.ui.widget.a.e(biVar.context, 1, true);
            com.tencent.mm.ui.widget.a.e eVar = biVar.hTk;
            if (eVar != null) {
                eVar.hbs();
            }
        }
        com.tencent.mm.ui.widget.a.e eVar2 = biVar.hTk;
        if (eVar2 != null) {
            eVar2.hbr();
        }
        com.tencent.mm.ui.widget.a.e eVar3 = biVar.hTk;
        if (eVar3 != null) {
            eVar3.Dp(true);
        }
        com.tencent.mm.ui.widget.a.e eVar4 = biVar.hTk;
        if (eVar4 != null) {
            eVar4.a(new e(biVar, i2, i3));
        }
        com.tencent.mm.ui.widget.a.e eVar5 = biVar.hTk;
        if (eVar5 != null) {
            eVar5.a(new f(biVar, aVar, aVar2));
        }
        com.tencent.mm.ui.widget.a.e eVar6 = biVar.hTk;
        if (eVar6 != null) {
            eVar6.b(new g(biVar));
            AppMethodBeat.o(208265);
            return;
        }
        AppMethodBeat.o(208265);
    }

    public static final /* synthetic */ void o(bi biVar) {
        AppMethodBeat.i(208266);
        com.tencent.mm.live.core.debug.a aVar = com.tencent.mm.live.core.debug.a.hCA;
        StringBuilder sb = new StringBuilder("[cgi]visitor close mic.");
        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", sb.append(com.tencent.mm.live.b.x.aHa().hKU).toString());
        com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
        a.C0371a aVar2 = com.tencent.mm.live.b.x.aHa().hKU;
        if (aVar2 != null) {
            com.tencent.mm.live.b.x xVar3 = com.tencent.mm.live.b.x.hJf;
            long j2 = com.tencent.mm.live.b.x.aGr().hyH;
            com.tencent.mm.live.b.x xVar4 = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.a.k kVar = new com.tencent.mm.live.b.a.k(j2, com.tencent.mm.live.b.x.aGm(), String.valueOf(System.currentTimeMillis()), aVar2.hFz, aVar2.hFG);
            com.tencent.mm.ak.t azz = com.tencent.mm.kernel.g.azz();
            p.g(azz, "MMKernel.getNetSceneQueue()");
            kVar.doScene(azz.azD(), new i(biVar));
            AppMethodBeat.o(208266);
            return;
        }
        AppMethodBeat.o(208266);
    }
}
