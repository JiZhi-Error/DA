package com.tencent.mm.live.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.b.d;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.d.c;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u001fH\u0016J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u001dJ\u001a\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveVideoMicPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "blankArea", "Landroid/view/View;", "cancelBtn", "Landroid/widget/Button;", "dialogGroup", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "okBtn", "previewLayout", "Landroid/widget/RelativeLayout;", "previewView", "Landroid/view/SurfaceView;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "setStatusMonitor", "(Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "switchCameraBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getCameraSurface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", "cancel", "", "onBackPress", "setupConfig", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "show", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class bc extends a {
    b hOp;
    private final Button hPX;
    private View hRx;
    private ViewGroup hSO;
    private RelativeLayout hSP;
    private final WeImageView hSQ;
    private SurfaceView hSR;
    public com.tencent.mm.live.core.core.trtc.a hSS;
    private final Button hSq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bc(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208206);
        this.hOp = bVar;
        View findViewById = viewGroup.findViewById(R.id.en4);
        p.g(findViewById, "root.findViewById(R.id.l…eo_mic_dialog_blank_area)");
        this.hRx = findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.en6);
        p.g(findViewById2, "root.findViewById(R.id.l…mic_dialog_content_group)");
        this.hSO = (ViewGroup) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.eq1);
        p.g(findViewById3, "root.findViewById(R.id.local_camera_view)");
        this.hSP = (RelativeLayout) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.en8);
        p.g(findViewById4, "root.findViewById(R.id.l…_video_mic_dialog_ok_btn)");
        this.hPX = (Button) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.en5);
        p.g(findViewById5, "root.findViewById(R.id.l…eo_mic_dialog_cancel_btn)");
        this.hSq = (Button) findViewById5;
        this.hSQ = (WeImageView) viewGroup.findViewById(R.id.en9);
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.b1x, (ViewGroup) null);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.SurfaceView");
            AppMethodBeat.o(208206);
            throw tVar;
        }
        this.hSR = (SurfaceView) inflate;
        this.hPX.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.bc.AnonymousClass1 */
            final /* synthetic */ bc hST;

            {
                this.hST = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208196);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.C0376b.a(this.hST.hOp, b.c.hMi);
                this.hST.eQ(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208196);
            }
        });
        this.hSq.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.bc.AnonymousClass2 */
            final /* synthetic */ bc hST;

            {
                this.hST = r1;
            }

            public final void onClick(View view) {
                g gVar;
                AppMethodBeat.i(208197);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.hST.eQ(true);
                com.tencent.mm.live.core.core.trtc.a aVar = this.hST.hSS;
                if (!(aVar == null || (gVar = aVar.hAz) == null || gVar.aDt())) {
                    c.aIl();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208197);
            }
        });
        this.hRx.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.bc.AnonymousClass3 */
            final /* synthetic */ bc hST;

            {
                this.hST = r1;
            }

            public final void onClick(View view) {
                g gVar;
                AppMethodBeat.i(208198);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.hST.eQ(true);
                com.tencent.mm.live.core.core.trtc.a aVar = this.hST.hSS;
                if (!(aVar == null || (gVar = aVar.hAz) == null || gVar.aDt())) {
                    c.aIl();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208198);
            }
        });
        this.hSQ.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.bc.AnonymousClass4 */
            final /* synthetic */ bc hST;

            {
                this.hST = r1;
            }

            public final void onClick(View view) {
                d dVar;
                boolean z;
                boolean z2;
                d dVar2;
                AppMethodBeat.i(208199);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVideoMicPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.C0376b.a(this.hST.hOp, b.c.hLE);
                x xVar = x.hJf;
                f aGv = x.aGv();
                if (!(aGv == null || (dVar = aGv.hzt) == null)) {
                    x xVar2 = x.hJf;
                    f aGv2 = x.aGv();
                    if (aGv2 == null || (dVar2 = aGv2.hzt) == null) {
                        z = true;
                    } else {
                        z = dVar2.hzh;
                    }
                    if (!z) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    dVar.hzh = z2;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVideoMicPlugin$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208199);
            }
        });
        this.hSO.setTranslationY((float) au.az(viewGroup.getContext()).y);
        if (viewGroup.findViewById(R.id.bf8) != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            if (!isLandscape()) {
                layoutParams.bottomMargin = au.aD(viewGroup.getContext());
            }
            layoutParams.width = au.az(viewGroup.getContext()).y;
            layoutParams.addRule(14);
            View findViewById6 = viewGroup.findViewById(R.id.bf8);
            p.g(findViewById6, "root.findViewById<Relati…>(R.id.content_root_view)");
            ((RelativeLayout) findViewById6).setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(208206);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/live/plugin/LiveVideoMicPlugin$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ bc hST;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(bc bcVar) {
            this.hST = bcVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(208201);
            this.hST.rg(8);
            AppMethodBeat.o(208201);
        }
    }

    public final void eQ(boolean z) {
        AppMethodBeat.i(208202);
        this.hSO.animate().translationY((float) au.az(this.hwr.getContext()).y).setListener(new a(this)).start();
        if (z) {
            b.C0376b.a(this.hOp, b.c.hMh);
        }
        this.hSP.removeView(this.hSR);
        AppMethodBeat.o(208202);
    }

    public final com.tencent.mm.live.core.b.l aHL() {
        AppMethodBeat.i(208203);
        com.tencent.mm.live.core.b.l lVar = new com.tencent.mm.live.core.b.l(this.hSR.getHolder());
        AppMethodBeat.o(208203);
        return lVar;
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        g gVar;
        g gVar2;
        g gVar3;
        AppMethodBeat.i(208204);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (bd.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                rg(0);
                ViewParent parent = this.hSR.getParent();
                if (parent != null) {
                    if (parent == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                        AppMethodBeat.o(208204);
                        throw tVar;
                    }
                    ((ViewGroup) parent).removeView(this.hSR);
                }
                this.hSP.addView(this.hSR);
                this.hSQ.bringToFront();
                this.hSO.animate().translationY(0.0f).setListener(null).start();
                AppMethodBeat.o(208204);
                return;
            case 2:
                x xVar = x.hJf;
                x.eN(true);
                AppMethodBeat.o(208204);
                return;
            case 3:
                com.tencent.mm.live.core.core.trtc.a aVar = this.hSS;
                if (aVar == null || (gVar3 = aVar.hAz) == null) {
                    AppMethodBeat.o(208204);
                    return;
                } else if (gVar3.aDt()) {
                    c.aIr();
                    AppMethodBeat.o(208204);
                    return;
                }
                break;
            case 4:
                com.tencent.mm.live.core.core.trtc.a aVar2 = this.hSS;
                if (aVar2 == null || (gVar2 = aVar2.hAz) == null) {
                    AppMethodBeat.o(208204);
                    return;
                } else if (gVar2.aDt()) {
                    c.aIq();
                    AppMethodBeat.o(208204);
                    return;
                }
                break;
            case 5:
                com.tencent.mm.live.core.core.trtc.a aVar3 = this.hSS;
                if (aVar3 == null || (gVar = aVar3.hAz) == null || !gVar.aDt()) {
                    c.aIm();
                    break;
                } else {
                    c.aIn();
                    AppMethodBeat.o(208204);
                    return;
                }
                break;
        }
        AppMethodBeat.o(208204);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(208205);
        if (this.hwr.getVisibility() == 0) {
            eQ(true);
            AppMethodBeat.o(208205);
            return true;
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(208205);
        return onBackPress;
    }
}
