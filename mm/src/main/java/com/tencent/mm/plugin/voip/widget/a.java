package com.tencent.mm.plugin.voip.widget;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ar;

public final class a extends BaseSmallView {
    private TextView BgP;
    private boolean ECo = false;
    VoIPRenderTextureView HpM;
    VoIPRenderTextureView HpN;
    boolean HpO;
    RelativeLayout HpP;
    boolean HpQ = false;
    private Runnable HpR = new Runnable() {
        /* class com.tencent.mm.plugin.voip.widget.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(235913);
            a aVar = a.this;
            if (!aVar.HpO && aVar.HpQ) {
                aVar.HpO = true;
                aVar.HpQ = false;
                aVar.HpM.setVisibility(0);
                aVar.HpM.xv(true);
                aVar.HpN.xv(false);
                aVar.HpN.animate().alpha(0.0f).setDuration(500).setListener(new Animator.AnimatorListener() {
                    /* class com.tencent.mm.plugin.voip.widget.a.AnonymousClass3 */

                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(235917);
                        a.this.HpN.setVisibility(8);
                        a.this.HpM.setAlpha(1.0f);
                        a.this.eoL();
                        AppMethodBeat.o(235917);
                    }

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                }).start();
            }
            AppMethodBeat.o(235913);
        }
    };
    ImageView gBZ;
    private IListener hvF = new IListener<ma>() {
        /* class com.tencent.mm.plugin.voip.widget.a.AnonymousClass2 */

        {
            AppMethodBeat.i(235915);
            this.__eventId = ma.class.getName().hashCode();
            AppMethodBeat.o(235915);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ma maVar) {
            AppMethodBeat.i(235916);
            if (maVar instanceof ma) {
                Log.i("MicroMsg.Voip.TalkingSmallView", "summerkick LogoutEvent thread name[%s]", Thread.currentThread().getName());
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.widget.a.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(235914);
                        if (!(a.this.Hen == null || a.this.Hen.get() == null)) {
                            Log.i("MicroMsg.Voip.TalkingSmallView", "summerkick LogoutEvent ret[%b, %b, %b]", Boolean.valueOf(((c) a.this.Hen.get()).fFB()), Boolean.valueOf(((c) a.this.Hen.get()).fFA()), Boolean.valueOf(((c) a.this.Hen.get()).fFt()));
                        }
                        AppMethodBeat.o(235914);
                    }
                });
            }
            AppMethodBeat.o(235916);
            return false;
        }
    };
    private MMHandler kAn = new MMHandler(Looper.getMainLooper());
    private int mStatus = -1;
    private float radius = ((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 12));
    TextView zTe;

    public a(Context context) {
        super(context, null);
        AppMethodBeat.i(235919);
        LayoutInflater.from(context).inflate(R.layout.c7_, this);
        setClipToOutline(true);
        setOutlineProvider(new e(this.radius));
        this.BgP = (TextView) findViewById(R.id.ior);
        this.HpP = (RelativeLayout) findViewById(R.id.jbb);
        this.HpP.setVisibility(4);
        this.gBZ = (ImageView) findViewById(R.id.jb_);
        this.zTe = (TextView) findViewById(R.id.jba);
        this.HpM = (VoIPRenderTextureView) findViewById(R.id.g3j);
        this.BgP = (TextView) findViewById(R.id.ior);
        this.HpN = (VoIPRenderTextureView) findViewById(R.id.g3i);
        this.HpN.xv(true);
        this.HpM.setClipToOutline(true);
        this.HpM.setOutlineProvider(new e(this.radius));
        this.HpN.setClipToOutline(true);
        this.HpN.setOutlineProvider(new e(this.radius));
        this.HpO = false;
        EventCenter.instance.addListener(this.hvF);
        setContentDescription(context.getString(R.string.b39));
        AppMethodBeat.o(235919);
    }

    public final void onViewAdded(View view) {
        AppMethodBeat.i(235920);
        super.onViewAdded(view);
        if (this.Hen != null) {
            Log.i("MicroMsg.Voip.TalkingSmallView", "view added");
            if (this.HpQ) {
                ((c) this.Hen.get()).a(this.HpN, 0);
            }
            ((c) this.Hen.get()).aE(false, (260 == this.mStatus || 6 == this.mStatus) ? false : true);
            ((c) this.Hen.get()).a(this.HpM, 1);
            this.HpM.fMa();
            this.HpN.fMa();
            AppMethodBeat.o(235920);
            return;
        }
        this.ECo = true;
        AppMethodBeat.o(235920);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void setVoipUIListener(c cVar) {
        AppMethodBeat.i(235921);
        super.setVoipUIListener(cVar);
        if (this.ECo) {
            if (this.HpQ) {
                ((c) this.Hen.get()).a(this.HpN, 0);
            }
            ((c) this.Hen.get()).aE(false, (260 == this.mStatus || 6 == this.mStatus) ? false : true);
            ((c) this.Hen.get()).a(this.HpM, 1);
            this.ECo = false;
            this.HpM.fMa();
            this.HpN.fMa();
        }
        AppMethodBeat.o(235921);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void fMf() {
        AppMethodBeat.i(235922);
        if (this.mStatus == 2 || this.mStatus == 256 || this.HpQ) {
            this.HpN.xv(false);
        } else {
            this.HpN.xv(true);
            this.HpM.xv(false);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        layoutParams.width = -1;
        layoutParams.height = -1;
        setLayoutParams(layoutParams);
        AppMethodBeat.o(235922);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void fJm() {
        AppMethodBeat.i(235923);
        this.kAn.post(this.HpR);
        AppMethodBeat.o(235923);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void uninit() {
        AppMethodBeat.i(235924);
        ((c) this.Hen.get()).a(this.HpN);
        ((c) this.Hen.get()).a(this.HpM);
        super.uninit();
        EventCenter.instance.removeListener(this.hvF);
        setVisibility(4);
        AppMethodBeat.o(235924);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void setStatus(int i2) {
        AppMethodBeat.i(235925);
        this.mStatus = i2;
        if (this.mStatus == 2 || this.mStatus == 256 || this.mStatus == 0) {
            this.HpQ = true;
            this.HpM.xv(true);
            this.HpN.setVisibility(0);
            this.HpN.xv(false);
            this.BgP.setVisibility(0);
        }
        this.czp.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.voip.widget.a.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(235918);
                a.this.findViewById(R.id.jb9).setVisibility(8);
                AppMethodBeat.o(235918);
            }
        }, 3000);
        if (!(this.mStatus == 2 || this.mStatus == 256 || this.mStatus != 0)) {
            this.HpM.setVisibility(0);
            this.HpM.xv(false);
            this.HpN.xv(true);
            this.BgP.setText("");
            this.BgP.setVisibility(8);
        }
        AppMethodBeat.o(235925);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void aGy(String str) {
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void aGx(String str) {
        AppMethodBeat.i(235926);
        this.BgP.setTextSize(1, 12.0f);
        this.BgP.setText(str);
        AppMethodBeat.o(235926);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final boolean eoK() {
        AppMethodBeat.i(235927);
        super.eoK();
        fMg();
        this.HpP.setVisibility(0);
        this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_call_end, Color.parseColor("#FFFFFF")));
        this.zTe.setVisibility(0);
        this.zTe.setText(R.string.i3b);
        this.zTe.requestLayout();
        AppMethodBeat.o(235927);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void setVoicePlayDevice(int i2) {
        AppMethodBeat.i(235928);
        if (this.GUk != i2) {
            fMg();
            this.GUk = i2;
            this.HpP.setVisibility(0);
            switch (i2) {
                case 1:
                    this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_volume_up, Color.parseColor("#FFFFFF")));
                    this.zTe.setText(R.string.i3a);
                    break;
                case 2:
                    this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_ear, Color.parseColor("#FFFFFF")));
                    this.zTe.setText(R.string.i39);
                    break;
                case 3:
                    this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_headset, Color.parseColor("#FFFFFF")));
                    this.zTe.setText(R.string.i3_);
                    break;
                case 4:
                    this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_bluetooth, Color.parseColor("#FFFFFF")));
                    this.zTe.setText(R.string.i38);
                    break;
            }
            this.BgP.setVisibility(8);
            this.zTe.requestLayout();
            super.setVoicePlayDevice(i2);
        }
        AppMethodBeat.o(235928);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void xm(boolean z) {
        AppMethodBeat.i(235929);
        if (z) {
            this.BgP.setVisibility(0);
            this.BgP.setText(R.string.i3n);
            AppMethodBeat.o(235929);
            return;
        }
        super.xm(false);
        AppMethodBeat.o(235929);
    }

    private void fMg() {
        AppMethodBeat.i(235930);
        this.BgP.setVisibility(8);
        AppMethodBeat.o(235930);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void enR() {
        AppMethodBeat.i(235931);
        fMg();
        this.HpP.setVisibility(0);
        this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icon_filled_mike_off, Color.parseColor("#FFFFFF")));
        this.zTe.setText(R.string.i4h);
        this.zTe.requestLayout();
        super.enR();
        AppMethodBeat.o(235931);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void eoL() {
        AppMethodBeat.i(235932);
        this.BgP.setVisibility(8);
        this.HpP.setVisibility(8);
        AppMethodBeat.o(235932);
    }
}
