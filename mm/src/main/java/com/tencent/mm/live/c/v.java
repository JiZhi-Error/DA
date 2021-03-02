package com.tencent.mm.live.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.m;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001;B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010 \u001a\u00020\u000bH\u0002J\u0006\u0010!\u001a\u00020\u0017J\b\u0010\"\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\u0012\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J,\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u000bH\u0002J\u0018\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020&2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u0011H\u0016J\u001a\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020\u000bH\u0016R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001eX\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "fetcherListener", "Lkotlin/Function0;", "", "likeBtn", "Landroid/widget/ImageView;", "likeBtnClickArea", "Landroid/widget/RelativeLayout;", "likeCount", "", "likeCountTv", "Landroid/widget/TextView;", "likeLayout", "Landroid/widget/LinearLayout;", "likeTooMuch", "", "liveVisitorMicPlugin", "Lcom/tencent/mm/live/plugin/LiveVisitorMicPlugin;", "needPostLike", "postLikeTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "vibrator", "", "kotlin.jvm.PlatformType", "checkBtnLayout", "isWaitingMic", "mount", "onBackPress", "onClick", "v", "Landroid/view/View;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "postLike", "scaleAnimate", "target", "targetValue", "", "setVisible", "visible", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "Companion", "plugin-logic_release"})
public final class v extends a implements View.OnClickListener, i {
    public static final a hQq = new a((byte) 0);
    private final TextView hOf;
    private final b hOp;
    public final bi hQi;
    private final ImageView hQj;
    private final RelativeLayout hQk;
    private final LinearLayout hQl;
    private boolean hQm = true;
    private final Object hQn;
    private final kotlin.g.a.a<x> hQo;
    private final MTimerHandler hQp;
    private int likeCount;

    static {
        AppMethodBeat.i(208022);
        AppMethodBeat.o(208022);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208021);
        this.hOp = bVar;
        View findViewById = viewGroup.findViewById(R.id.enr);
        p.g(findViewById, "root.findViewById(R.id.live_visitor_mic_parent)");
        this.hQi = new bi((ViewGroup) findViewById, this.hOp);
        View findViewById2 = viewGroup.findViewById(R.id.elb);
        p.g(findViewById2, "root.findViewById(R.id.live_right_panel_like)");
        this.hQj = (ImageView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.elc);
        p.g(findViewById3, "root.findViewById(R.id.l…ht_panel_like_click_area)");
        this.hQk = (RelativeLayout) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.eld);
        p.g(findViewById4, "root.findViewById(R.id.l…ight_panel_like_count_tv)");
        this.hOf = (TextView) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.ehx);
        p.g(findViewById5, "root.findViewById(R.id.live_like_layout)");
        this.hQl = (LinearLayout) findViewById5;
        this.hQn = viewGroup.getContext().getSystemService("vibrator");
        this.hQo = new b(this, viewGroup);
        this.hQp = new MTimerHandler("RoomLiveLike::Timer", (MTimerHandler.CallBack) new e(this), true);
        ImageView imageView = this.hQj;
        Context context = viewGroup.getContext();
        p.g(context, "root.context");
        imageView.setImageDrawable(ar.e(context.getResources().getDrawable(R.raw.icons_filled_call_good), -1));
        this.hQk.setOnTouchListener(new View.OnTouchListener(this) {
            /* class com.tencent.mm.live.c.v.AnonymousClass1 */
            final /* synthetic */ v hQr;

            {
                this.hQr = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(208007);
                p.g(motionEvent, "event");
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        v.s(this.hQr.hQk, 1.7f);
                        this.hQr.hOf.setVisibility(4);
                        this.hQr.hQp.startTimer(0, 200);
                        break;
                    case 1:
                    case 3:
                        this.hQr.hQp.stopTimer();
                        v.s(this.hQr.hQk, 1.0f);
                        this.hQr.hOf.setVisibility(0);
                        if (this.hQr.hQm) {
                            r rVar = r.hIg;
                            r.qR(this.hQr.likeCount);
                            this.hQr.hQm = false;
                            this.hQr.likeCount = 0;
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(208007);
                return true;
            }
        });
        m mVar = m.hGg;
        m.d(name(), this.hQo);
        if (viewGroup.findViewById(R.id.bf8) != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.bottomMargin = au.aD(viewGroup.getContext());
            View findViewById6 = viewGroup.findViewById(R.id.bf8);
            p.g(findViewById6, "root.findViewById<Linear…>(R.id.content_root_view)");
            ((LinearLayout) findViewById6).setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(208021);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveGuestRightPanelPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class e implements MTimerHandler.CallBack {
        final /* synthetic */ v hQr;

        e(v vVar) {
            this.hQr = vVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(208013);
            if (this.hQr.likeCount < 9) {
                v.g(this.hQr);
                AppMethodBeat.o(208013);
                return true;
            }
            AppMethodBeat.o(208013);
            return false;
        }
    }

    public final void onClick(View view) {
        AppMethodBeat.i(208015);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveGuestRightPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.elc) {
            Bundle bundle = new Bundle();
            int[] iArr = {0, 0};
            this.hQk.getLocationOnScreen(iArr);
            int width = iArr[0] + (this.hQk.getWidth() / 2);
            o.b bVar2 = o.b.hGo;
            bundle.putInt("PARAM_LIVE_LIKE_CONFETTI_X", width - (o.b.aFl() / 2));
            int fromDPToPix = iArr[1] - at.fromDPToPix(this.hwr.getContext(), 16);
            o.b bVar3 = o.b.hGo;
            bundle.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", fromDPToPix - o.b.aFl());
            this.hOp.statusChange(b.c.hMa, bundle);
            this.likeCount++;
            if (this.hQm) {
                r rVar = r.hIg;
                r.qR(this.likeCount);
                this.hQm = false;
                this.likeCount = 0;
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveGuestRightPanelPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208015);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208017);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (w.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
                rg(8);
                AppMethodBeat.o(208017);
                return;
            case 3:
                rg(0);
                this.hwr.post(new f(this));
                AppMethodBeat.o(208017);
                return;
            case 4:
                if (bundle == null || !bundle.getBoolean("PARAM_IS_ENTERING_COMMENT")) {
                    rg(0);
                    break;
                } else {
                    rg(8);
                    AppMethodBeat.o(208017);
                    return;
                }
                break;
        }
        AppMethodBeat.o(208017);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ v hQr;

        f(v vVar) {
            this.hQr = vVar;
        }

        public final void run() {
            AppMethodBeat.i(208014);
            v.c(this.hQr);
            AppMethodBeat.o(208014);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void mount() {
        AppMethodBeat.i(208018);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3957, this);
        AppMethodBeat.o(208018);
    }

    @Override // com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(208019);
        com.tencent.mm.kernel.b aAg = g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3957, this);
        AppMethodBeat.o(208019);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(208020);
        if (qVar instanceof com.tencent.mm.live.b.a.q) {
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.ac.d.h(new c(this));
            }
            Log.i("MicroMsg.LiveGuestRightPanelPlugin", "onSceneEnd errType:" + i2 + " errCode:" + i3 + " likeCount:" + this.likeCount);
            if (this.likeCount > 0) {
                r rVar = r.hIg;
                r.qR(this.likeCount);
                this.hQm = false;
                this.likeCount = 0;
                AppMethodBeat.o(208020);
                return;
            }
            this.hQm = true;
            this.likeCount = 0;
        }
        AppMethodBeat.o(208020);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ ViewGroup hOA;
        final /* synthetic */ v hQr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(v vVar, ViewGroup viewGroup) {
            super(0);
            this.hQr = vVar;
            this.hOA = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(208010);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.live.c.v.b.AnonymousClass1 */
                final /* synthetic */ b hQs;

                {
                    this.hQs = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(208009);
                    if (this.hQs.hOA.getVisibility() == 0) {
                        TextView textView = this.hQs.hQr.hOf;
                        com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
                        textView.setText(com.tencent.mm.live.b.x.aHd());
                    }
                    x xVar2 = x.SXb;
                    AppMethodBeat.o(208009);
                    return xVar2;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(208010);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ v hQr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(v vVar) {
            super(0);
            this.hQr = vVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(208012);
            Bundle bundle = new Bundle();
            int[] iArr = {0, 0};
            this.hQr.hQl.getLocationOnScreen(iArr);
            int width = iArr[0] + (this.hQr.hQl.getWidth() / 2);
            o.b bVar = o.b.hGo;
            bundle.putInt("PARAM_LIVE_LIKE_CONFETTI_X", width - (o.b.aFl() / 2));
            bundle.putInt("PARAM_LIVE_LIKE_CONFETTI_Y", (iArr[1] + at.fromDPToPix(this.hQr.hwr.getContext(), 18)) - at.fromDPToPix(this.hQr.hwr.getContext(), 16));
            this.hQr.hOp.statusChange(b.c.hMa, bundle);
            x xVar = x.SXb;
            AppMethodBeat.o(208012);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ v hQr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(v vVar) {
            super(0);
            this.hQr = vVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(208011);
            com.tencent.mm.live.b.x xVar = com.tencent.mm.live.b.x.hJf;
            com.tencent.mm.live.b.x.aGr().LXG++;
            TextView textView = this.hQr.hOf;
            com.tencent.mm.live.b.x xVar2 = com.tencent.mm.live.b.x.hJf;
            textView.setText(com.tencent.mm.live.b.x.aHd());
            x xVar3 = x.SXb;
            AppMethodBeat.o(208011);
            return xVar3;
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(208016);
        this.hwr.setVisibility(i2);
        AppMethodBeat.o(208016);
    }

    public static final /* synthetic */ void c(v vVar) {
        AppMethodBeat.i(208023);
        LinearLayout linearLayout = vVar.hQi.hTf;
        ArrayList<View> arrayList = new ArrayList();
        arrayList.add(linearLayout);
        arrayList.add(vVar.hQl);
        int mZ = j.mZ(vVar.hQl.getWidth(), linearLayout.getWidth());
        for (View view : arrayList) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), ((mZ - view.getWidth()) / 2) + view.getPaddingRight(), view.getPaddingBottom());
        }
        vVar.hwr.requestLayout();
        AppMethodBeat.o(208023);
    }

    public static final /* synthetic */ void g(v vVar) {
        AppMethodBeat.i(208024);
        if (vVar.hQn instanceof Vibrator) {
            ((Vibrator) vVar.hQn).vibrate(10);
        }
        vVar.likeCount++;
        com.tencent.mm.ac.d.h(new d(vVar));
        AppMethodBeat.o(208024);
    }

    public static final /* synthetic */ void s(View view, float f2) {
        AppMethodBeat.i(208025);
        view.animate().setDuration(200).scaleX(f2).scaleY(f2).start();
        AppMethodBeat.o(208025);
    }
}
