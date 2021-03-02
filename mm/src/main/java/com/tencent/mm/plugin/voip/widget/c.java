package com.tencent.mm.plugin.voip.widget;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ar;

public final class c extends BaseSmallView {
    private TextView BgP;
    private boolean ECo = false;
    private int GUK = 0;
    private int GUL = 0;
    private int HdK;
    private int HiE = 0;
    boolean HpO;
    RelativeLayout HpP;
    boolean HpQ = false;
    private Runnable HpR = new Runnable() {
        /* class com.tencent.mm.plugin.voip.widget.c.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(115758);
            c cVar = c.this;
            if (!cVar.HpO && cVar.HpQ) {
                cVar.HpO = true;
                cVar.HpQ = false;
                cVar.Hqj.setVisibility(0);
                cVar.Hqj.setAlpha(0.0f);
                cVar.Hqj.animate().alpha(1.0f).setDuration(500).start();
                cVar.Hql.setAlpha(1.0f);
                cVar.Hql.animate().alpha(0.0f).setDuration(500).setListener(new Animator.AnimatorListener() {
                    /* class com.tencent.mm.plugin.voip.widget.c.AnonymousClass5 */

                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(235971);
                        c.this.Hql.xv(true);
                        c.this.Hqj.setAlpha(1.0f);
                        c.this.eoL();
                        AppMethodBeat.o(235971);
                    }

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                }).start();
            }
            AppMethodBeat.o(115758);
        }
    };
    private OpenGlRender Hqi;
    OpenGlView Hqj;
    private OpenGlRender Hqk;
    OpenGlView Hql;
    private int[] Hqm = null;
    private int Hqn = 0;
    private int Hqo = 0;
    ImageView gBZ;
    private IListener hvF = new IListener<ma>() {
        /* class com.tencent.mm.plugin.voip.widget.c.AnonymousClass2 */

        {
            AppMethodBeat.i(161662);
            this.__eventId = ma.class.getName().hashCode();
            AppMethodBeat.o(161662);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ma maVar) {
            AppMethodBeat.i(115760);
            if (maVar instanceof ma) {
                Log.i("MicroMsg.Voip.TalkingSmallView", "summerkick LogoutEvent thread name[%s]", Thread.currentThread().getName());
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.widget.c.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(115759);
                        if (!(c.this.Hen == null || c.this.Hen.get() == null)) {
                            Log.i("MicroMsg.Voip.TalkingSmallView", "summerkick LogoutEvent ret[%b, %b, %b]", Boolean.valueOf(((com.tencent.mm.plugin.voip.ui.c) c.this.Hen.get()).fFB()), Boolean.valueOf(((com.tencent.mm.plugin.voip.ui.c) c.this.Hen.get()).fFA()), Boolean.valueOf(((com.tencent.mm.plugin.voip.ui.c) c.this.Hen.get()).fFt()));
                        }
                        AppMethodBeat.o(115759);
                    }
                });
            }
            AppMethodBeat.o(115760);
            return false;
        }
    };
    private boolean mIsStarted;
    private int mStatus = -1;
    private float radius = ((float) a.fromDPToPix(MMApplicationContext.getContext(), 12));
    public com.tencent.mm.plugin.voip.ui.a zTN = null;
    TextView zTe;

    public c(Context context) {
        super(context, null);
        AppMethodBeat.i(235973);
        LayoutInflater.from(context).inflate(R.layout.c79, this);
        setClipToOutline(true);
        setOutlineProvider(new e(this.radius));
        this.HpP = (RelativeLayout) findViewById(R.id.jbb);
        this.HpP.setVisibility(4);
        this.gBZ = (ImageView) findViewById(R.id.jb_);
        this.zTe = (TextView) findViewById(R.id.jba);
        this.Hqj = (OpenGlView) findViewById(R.id.g3j);
        this.Hqi = new OpenGlRender(this.Hqj, OpenGlRender.RenderRemote);
        this.BgP = (TextView) findViewById(R.id.ior);
        this.BgP.setTextSize(1, 12.0f);
        this.Hqj.setRenderer(this.Hqi);
        this.Hqj.setRenderMode(0);
        this.Hqj.setClipToOutline(true);
        this.Hqj.setOutlineProvider(new e(this.radius));
        this.Hqi.HiQ = new OpenGlRender.b() {
            /* class com.tencent.mm.plugin.voip.widget.c.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void fJD() {
                AppMethodBeat.i(235963);
                if (!(c.this.Hen == null || c.this.Hen.get() == null)) {
                    ((com.tencent.mm.plugin.voip.ui.c) c.this.Hen.get()).ah(0, 3);
                }
                AppMethodBeat.o(235963);
            }

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void Lj(long j2) {
                AppMethodBeat.i(235964);
                if (!(c.this.Hen == null || c.this.Hen.get() == null)) {
                    ((com.tencent.mm.plugin.voip.ui.c) c.this.Hen.get()).ah(j2, 2);
                }
                AppMethodBeat.o(235964);
            }

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void Lk(long j2) {
                AppMethodBeat.i(235965);
                if (!(c.this.Hen == null || c.this.Hen.get() == null || j2 <= 0)) {
                    ((com.tencent.mm.plugin.voip.ui.c) c.this.Hen.get()).ah(j2, 0);
                }
                AppMethodBeat.o(235965);
            }

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void Ll(long j2) {
                AppMethodBeat.i(235966);
                if (!(c.this.Hen == null || c.this.Hen.get() == null || j2 <= 0)) {
                    ((com.tencent.mm.plugin.voip.ui.c) c.this.Hen.get()).ah(j2, 1);
                }
                AppMethodBeat.o(235966);
            }
        };
        this.Hqj.xv(true);
        this.Hql = (OpenGlView) findViewById(R.id.g3i);
        this.Hqk = new OpenGlRender(this.Hql, OpenGlRender.RenderLocal);
        this.Hql.setClipToOutline(true);
        this.Hql.setOutlineProvider(new e(this.radius));
        this.Hqk.HiQ = new OpenGlRender.b() {
            /* class com.tencent.mm.plugin.voip.widget.c.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void fJD() {
                AppMethodBeat.i(235967);
                if (!(c.this.Hen == null || c.this.Hen.get() == null)) {
                    ((com.tencent.mm.plugin.voip.ui.c) c.this.Hen.get()).ah(0, 3);
                }
                AppMethodBeat.o(235967);
            }

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void Lj(long j2) {
                AppMethodBeat.i(235968);
                if (!(c.this.Hen == null || c.this.Hen.get() == null)) {
                    ((com.tencent.mm.plugin.voip.ui.c) c.this.Hen.get()).ah(j2, 2);
                }
                AppMethodBeat.o(235968);
            }

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void Lk(long j2) {
                AppMethodBeat.i(235969);
                if (!(c.this.Hen == null || c.this.Hen.get() == null || j2 <= 0)) {
                    ((com.tencent.mm.plugin.voip.ui.c) c.this.Hen.get()).ah(j2, 0);
                }
                AppMethodBeat.o(235969);
            }

            @Override // com.tencent.mm.plugin.voip.video.OpenGlRender.b
            public final void Ll(long j2) {
                AppMethodBeat.i(235970);
                if (!(c.this.Hen == null || c.this.Hen.get() == null || j2 <= 0)) {
                    ((com.tencent.mm.plugin.voip.ui.c) c.this.Hen.get()).ah(j2, 1);
                }
                AppMethodBeat.o(235970);
            }
        };
        this.Hql.setVisibility(0);
        this.Hql.setRenderer(this.Hqk);
        this.Hql.setRenderMode(0);
        this.mIsStarted = false;
        this.HpO = false;
        EventCenter.instance.addListener(this.hvF);
        setContentDescription(context.getString(R.string.b39));
        AppMethodBeat.o(235973);
    }

    public final void onViewAdded(View view) {
        AppMethodBeat.i(235974);
        super.onViewAdded(view);
        if (this.Hen != null) {
            Log.i("MicroMsg.Voip.TalkingSmallView", "view added");
            if (!(this.Hen == null || this.Hen.get() == null)) {
                ((com.tencent.mm.plugin.voip.ui.c) this.Hen.get()).aE(false, (260 == this.mStatus || 6 == this.mStatus) ? false : true);
                this.Hqk.HiO = true;
                this.Hqi.HiO = true;
                AppMethodBeat.o(235974);
                return;
            }
        } else {
            this.ECo = true;
        }
        AppMethodBeat.o(235974);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void fMf() {
        AppMethodBeat.i(184094);
        if (this.mStatus == 2 || this.mStatus == 256 || this.HpQ) {
            this.Hql.xv(false);
        } else {
            this.Hql.xv(true);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        layoutParams.width = -1;
        layoutParams.height = -1;
        setLayoutParams(layoutParams);
        AppMethodBeat.o(184094);
    }

    private void fMm() {
        AppMethodBeat.i(115765);
        if (!this.mIsStarted) {
            Log.i("MicroMsg.Voip.TalkingSmallView", "startRenderForVideoDisplay, voipBeauty: %s", Integer.valueOf(this.Hqo));
            this.mIsStarted = true;
            this.Hqi.onStarted();
            this.Hqk.onStarted();
            this.Hqk.setVoipBeauty(this.Hqo);
            this.Hqi.setVoipBeauty(this.Hqo);
            this.Hqk.setSpatiotemporalDenosing(this.HiE);
            this.Hqi.setSpatiotemporalDenosing(this.HiE);
            if (!(this.GUK == 0 || this.GUL == 0)) {
                jA(this.GUK, this.GUL);
            }
        }
        AppMethodBeat.o(115765);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void f(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(115766);
        if (!this.HpO && this.HpQ) {
            h.RTc.aV(this.HpR);
        }
        fMm();
        if (OpenGlRender.His == 1) {
            this.Hqi.a(bArr, i2, i3, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false, 1);
            AppMethodBeat.o(115766);
            return;
        }
        this.Hqi.a(bArr, i2, i3, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false, 1);
        AppMethodBeat.o(115766);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void a(SurfaceTexture surfaceTexture, d dVar) {
        AppMethodBeat.i(115767);
        if (this.Hqk == null || this.Hqi == null) {
            AppMethodBeat.o(115767);
            return;
        }
        fMm();
        this.surfaceTexture = surfaceTexture;
        this.GgP = dVar;
        this.Hqk.a(this.surfaceTexture, this.GgP);
        this.Hqi.a(this.surfaceTexture, this.GgP);
        AppMethodBeat.o(115767);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void requestRender() {
        AppMethodBeat.i(115768);
        this.Hqj.HhI.requestRender();
        AppMethodBeat.o(115768);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void fJx() {
        AppMethodBeat.i(115769);
        if (!(!this.mIsStarted || this.Hqk == null || this.Hqi == null)) {
            this.Hqk.fKN();
            this.Hqi.fKN();
        }
        AppMethodBeat.o(115769);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void setVoipBeauty(int i2) {
        AppMethodBeat.i(115770);
        Log.i("MicroMsg.Voip.TalkingSmallView", "setVoipBeauty, mIsStarted:%b, isON:%d", Boolean.valueOf(this.mIsStarted), Integer.valueOf(i2));
        this.Hqo = i2;
        if (!(!this.mIsStarted || this.Hqk == null || this.Hqi == null)) {
            this.Hqk.setVoipBeauty(i2);
            this.Hqi.setVoipBeauty(i2);
        }
        AppMethodBeat.o(115770);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void setSpatiotemporalDenosing(int i2) {
        AppMethodBeat.i(235975);
        Log.i("MicroMsg.Voip.TalkingSmallView", "setSpatiotemporalDenosining, mIsStarted:%b, isON:%d", Boolean.valueOf(this.mIsStarted), Integer.valueOf(i2));
        this.HiE = i2;
        if (!(!this.mIsStarted || this.Hqk == null || this.Hqi == null)) {
            this.Hqk.setSpatiotemporalDenosing(i2);
            this.Hqi.setSpatiotemporalDenosing(i2);
        }
        AppMethodBeat.o(235975);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void jA(int i2, int i3) {
        AppMethodBeat.i(115771);
        Log.i("MicroMsg.Voip.TalkingSmallView", "adjustHWViewAspectRatio, mIsStarted:%b, HWDecsize:%dx%d", Boolean.valueOf(this.mIsStarted), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 || i3 == 0) {
            AppMethodBeat.o(115771);
            return;
        }
        this.GUK = i2;
        this.GUL = i3;
        if (!(!this.mIsStarted || this.Hqk == null || this.Hqi == null)) {
            this.Hqk.jA(i2, i3);
            this.Hqi.jA(i2, i3);
        }
        AppMethodBeat.o(115771);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void releaseSurfaceTexture() {
        AppMethodBeat.i(115772);
        this.Hqk.releaseSurfaceTexture();
        this.Hqi.releaseSurfaceTexture();
        AppMethodBeat.o(115772);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void setHWDecMode(int i2) {
        AppMethodBeat.i(115773);
        this.HdK = i2;
        Log.i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, hwdec: %d, before changeSurfaceRender", Integer.valueOf(this.HdK));
        if (!(this.Hqk == null || this.Hqi == null)) {
            this.Hqk.setShowMode(0);
            if ((this.HdK & 1) != 0) {
                this.Hqi.setShowMode(1);
            } else {
                this.Hqi.setShowMode(0);
            }
            Log.i("MicroMsg.Voip.TalkingSmallView", "changeSurfaceRender, bigViewMode: %d, smallViewMode: %d, after changeSurfaceRender", Integer.valueOf(this.Hqk.HiI), Integer.valueOf(this.Hqi.HiI));
        }
        fMm();
        AppMethodBeat.o(115773);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void a(byte[] bArr, long j2, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(115774);
        if (8 == this.Hql.getVisibility()) {
            AppMethodBeat.o(115774);
            return;
        }
        fMm();
        if (OpenGlRender.His == 1) {
            if (this.Hqn < i2 * i3) {
                this.Hqm = null;
            }
            if (this.Hqm == null) {
                this.Hqn = i2 * i3;
                this.Hqm = new int[this.Hqn];
            }
            if (com.tencent.mm.plugin.voip.c.fFg().a(bArr, (int) j2, i4 & 31, i2, i3, this.Hqm, false) < 0 || this.Hqm == null) {
                AppMethodBeat.o(115774);
                return;
            }
            this.Hqk.a(this.Hqm, i2, i3, OpenGlRender.FLAG_RGBAClip + i5 + i6, true);
            AppMethodBeat.o(115774);
            return;
        }
        if (OpenGlRender.His == 2) {
            this.Hqk.a(bArr, i2, i3, OpenGlRender.FLAG_NV21 + i5 + i6, true, 3);
        }
        AppMethodBeat.o(115774);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void uninit() {
        AppMethodBeat.i(115775);
        super.uninit();
        EventCenter.instance.removeListener(this.hvF);
        setVisibility(4);
        if (this.mIsStarted) {
            this.Hqi.fKM();
            this.Hqk.fKM();
        }
        AppMethodBeat.o(115775);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void onAnimationEnd() {
        AppMethodBeat.i(115779);
        this.Hqi.onStarted();
        this.Hqk.onStarted();
        AppMethodBeat.o(115779);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final OpenGlRender getBeautyData() {
        return this.Hqk;
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void setVoipUIListener(com.tencent.mm.plugin.voip.ui.c cVar) {
        AppMethodBeat.i(235977);
        super.setVoipUIListener(cVar);
        if (!(!this.ECo || this.Hen == null || this.Hen.get() == null)) {
            ((com.tencent.mm.plugin.voip.ui.c) this.Hen.get()).aE(false, (260 == this.mStatus || 6 == this.mStatus) ? false : true);
            this.Hqk.HiO = true;
            this.Hqi.HiO = true;
            this.ECo = false;
        }
        AppMethodBeat.o(235977);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final OpenGlRender getSpatioTemporalFilterData() {
        return this.Hqk;
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void setStatus(int i2) {
        AppMethodBeat.i(115780);
        this.mStatus = i2;
        if (this.mStatus == 2 || this.mStatus == 256 || this.mStatus == 0) {
            this.HpQ = true;
            this.Hqj.xv(true);
            this.Hql.setVisibility(0);
            this.Hql.xv(false);
            this.BgP.setVisibility(0);
        }
        this.czp.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.voip.widget.c.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(235972);
                if (c.this.findViewById(R.id.jb9) != null) {
                    c.this.findViewById(R.id.jb9).setVisibility(8);
                }
                AppMethodBeat.o(235972);
            }
        }, 3000);
        if (!(this.mStatus == 2 || this.mStatus == 256 || this.mStatus == 0)) {
            this.Hqj.setVisibility(0);
            this.Hqj.xv(false);
            this.Hql.xv(true);
            this.BgP.setText("");
            this.BgP.setVisibility(8);
        }
        AppMethodBeat.o(115780);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void aGy(String str) {
        AppMethodBeat.i(184095);
        AppMethodBeat.o(184095);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void aGx(String str) {
        AppMethodBeat.i(184096);
        if (this.BgP != null) {
            this.BgP.setTextSize(1, 12.0f);
            this.BgP.setText(str);
        }
        AppMethodBeat.o(184096);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final boolean eoK() {
        AppMethodBeat.i(184097);
        super.eoK();
        fMg();
        this.HpP.setVisibility(0);
        this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_call_end, Color.parseColor("#FFFFFF")));
        this.zTe.setVisibility(0);
        this.zTe.setText(R.string.i3b);
        this.zTe.requestLayout();
        this.BgP.setVisibility(8);
        AppMethodBeat.o(184097);
        return true;
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void setVoicePlayDevice(int i2) {
        AppMethodBeat.i(184098);
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
            this.zTe.requestLayout();
            this.BgP.setVisibility(8);
            super.setVoicePlayDevice(i2);
        }
        AppMethodBeat.o(184098);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void enR() {
        AppMethodBeat.i(184099);
        fMg();
        this.HpP.setVisibility(0);
        this.gBZ.setImageDrawable(ar.m(getContext(), R.raw.icon_filled_mike_off, Color.parseColor("#FFFFFF")));
        this.zTe.setText(R.string.i4h);
        this.zTe.requestLayout();
        super.enR();
        AppMethodBeat.o(184099);
    }

    private void fMg() {
        AppMethodBeat.i(184100);
        this.BgP.setVisibility(8);
        AppMethodBeat.o(184100);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void xm(boolean z) {
        AppMethodBeat.i(184101);
        if (z) {
            this.BgP.setVisibility(0);
            this.BgP.setText(R.string.i3n);
            AppMethodBeat.o(184101);
            return;
        }
        super.xm(false);
        AppMethodBeat.o(184101);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void eoL() {
        AppMethodBeat.i(184102);
        this.BgP.setVisibility(8);
        this.HpP.setVisibility(8);
        AppMethodBeat.o(184102);
    }

    @Override // com.tencent.mm.plugin.voip.widget.BaseSmallView
    public final void setCaptureView(CaptureView captureView) {
        AppMethodBeat.i(235976);
        Log.printDebugStack("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
        if (this.qsJ != null) {
            removeView(this.qsJ);
            this.qsJ = null;
        }
        if (captureView != null) {
            this.qsJ = captureView;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
            layoutParams.leftMargin = 20;
            layoutParams.topMargin = 20;
            addView(captureView, layoutParams);
            captureView.setVisibility(0);
            Log.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
        }
        AppMethodBeat.o(235976);
    }
}
