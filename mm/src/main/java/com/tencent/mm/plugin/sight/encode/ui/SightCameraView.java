package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.hardware.Camera;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.d;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.plugin.sight.encode.a.a;
import com.tencent.mm.plugin.sight.encode.ui.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public abstract class SightCameraView extends FrameLayout implements d.a {
    protected e Dql;
    protected com.tencent.mm.plugin.sight.encode.a.a Dqm;
    protected ImageView Dqn;
    protected Runnable Dqo;
    protected long Dqp;
    protected b Dqq;
    protected boolean Dqr;
    protected boolean Dqs;
    protected int Dqt;
    protected a Dqu;
    private MTimerHandler Dqv;
    private int Dqw;
    private Runnable Dqx;
    private Runnable Dqy;
    protected int irF;
    private long ofl;
    private d pNk;
    private Animation ywd;

    public interface a {
    }

    /* access modifiers changed from: protected */
    public abstract void ce(String str, boolean z);

    /* access modifiers changed from: protected */
    public abstract void eWq();

    /* access modifiers changed from: protected */
    public abstract Surface getPreviewSurface();

    /* access modifiers changed from: protected */
    public abstract int getSurfaceHeight();

    /* access modifiers changed from: protected */
    public abstract int getSurfaceWidth();

    public abstract boolean isPlaying();

    public abstract void setFixPreviewRate(float f2);

    /* access modifiers changed from: protected */
    public abstract void setIsMute(boolean z);

    protected enum b {
        CREATE,
        CHANGED,
        DESTORY;

        public static b valueOf(String str) {
            AppMethodBeat.i(28788);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(28788);
            return bVar;
        }

        static {
            AppMethodBeat.i(28789);
            AppMethodBeat.o(28789);
        }
    }

    public void setPreviewRate(float f2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (int) (((float) displayMetrics.widthPixels) / f2);
        Log.i("MicroMsg.SightCameraView", "resizeLayout width:%d, height:%d, previewRate %f", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Float.valueOf(f2));
        postInvalidate();
    }

    public void setTargetWidth(int i2) {
        this.irF = i2;
    }

    public void setRecordMaxDuring(int i2) {
        Log.d("MicroMsg.SightCameraView", "setRecordMaxDuring recordMaxDuring : ".concat(String.valueOf(i2)));
        this.Dqt = i2;
    }

    public SightCameraView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Dqp = -1;
        this.Dqq = b.DESTORY;
        this.Dqr = false;
        this.Dqs = false;
        this.irF = 320;
        this.Dqt = 6500;
        this.ofl = 0;
        this.Dqv = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.sight.encode.ui.SightCameraView.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(28780);
                float eVY = ((float) SightCameraView.this.Dqm.eVY()) / ((float) SightCameraView.this.Dqt);
                if (Float.compare(eVY, 0.0f) > 0 || System.currentTimeMillis() - SightCameraView.this.ofl <= 20000) {
                    if (Float.compare(eVY, 1.0f) <= 0 || SightCameraView.this.Dqm.eVZ() != a.EnumC1698a.Start) {
                        SightCameraView.this.bi(eVY);
                    } else if (!SightCameraView.this.Dqm.XB()) {
                        SightCameraView.b(SightCameraView.this);
                    }
                    AppMethodBeat.o(28780);
                    return true;
                }
                Log.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", 20000L);
                SightCameraView.this.cTH();
                AppMethodBeat.o(28780);
                return false;
            }
        }, true);
        this.Dqw = -1;
        this.Dqx = new Runnable() {
            /* class com.tencent.mm.plugin.sight.encode.ui.SightCameraView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(28781);
                AppMethodBeat.o(28781);
            }

            public final String toString() {
                AppMethodBeat.i(28782);
                String str = super.toString() + "|startRecord";
                AppMethodBeat.o(28782);
                return str;
            }
        };
        this.Dqy = new Runnable() {
            /* class com.tencent.mm.plugin.sight.encode.ui.SightCameraView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(28783);
                AppMethodBeat.o(28783);
            }

            public final String toString() {
                AppMethodBeat.i(28784);
                String str = super.toString() + "|cancelRecord";
                AppMethodBeat.o(28784);
                return str;
            }
        };
        this.pNk = new d();
        if (e.eVu()) {
            inflate(getContext(), R.layout.bsq, this);
        } else {
            inflate(getContext(), R.layout.bsp, this);
        }
        this.Dqr = false;
        this.Dqs = false;
        this.Dql = new e();
        e eVar = this.Dql;
        Log.i("MicroMsg.SightCamera", "init needRotate %s", Boolean.FALSE);
        if (ae.gKv.gKa) {
            eVar.Dqi.ifO = ae.gKv.mVideoHeight;
            eVar.Dqi.ifN = ae.gKv.mVideoWidth;
            eVar.Dqi.zuR = ae.gKv.gKc;
        }
        eVar.Dqi.zva = com.tencent.mm.compatible.deviceinfo.d.getNumberOfCameras();
        eVar.Dqi.dYT = 0;
        this.Dqn = (ImageView) findViewById(R.id.gli);
        eWr();
    }

    public SightCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setSightMedia(com.tencent.mm.plugin.sight.encode.a.a aVar) {
        this.Dqm = aVar;
        if (this.Dqm != null && this.Dql != null) {
            this.Dql.Dqj = this.Dqm.eWa();
        }
    }

    public void setSightCameraUIIm(a aVar) {
        this.Dqu = aVar;
    }

    public final void bi(float f2) {
        Log.d("MicroMsg.SightCameraView", "update progress %f", Float.valueOf(f2));
        if (this.Dqw < 0) {
            this.Dqw = getResources().getDisplayMetrics().widthPixels;
        }
        if (f2 < 0.0f) {
            ViewGroup.LayoutParams layoutParams = this.Dqn.getLayoutParams();
            layoutParams.width = this.Dqw;
            this.Dqn.setLayoutParams(layoutParams);
        } else if (f2 > 1.0f) {
            ViewGroup.LayoutParams layoutParams2 = this.Dqn.getLayoutParams();
            layoutParams2.width = this.Dqw - (((this.Dqw / 2) - 1) * 2);
            this.Dqn.setLayoutParams(layoutParams2);
        } else {
            ViewGroup.LayoutParams layoutParams3 = this.Dqn.getLayoutParams();
            layoutParams3.width = this.Dqw - (((int) ((((float) getResources().getDisplayMetrics().widthPixels) * f2) / 2.0f)) * 2);
            this.Dqn.setLayoutParams(layoutParams3);
        }
    }

    private void eWr() {
        if (this.Dqn.getVisibility() != 4) {
            if (this.ywd != null) {
                this.ywd.cancel();
            }
            this.Dqn.setVisibility(4);
        }
    }

    public a.EnumC1698a getCurMediaStatus() {
        return this.Dqm.eVZ();
    }

    /* access modifiers changed from: protected */
    public final void cTH() {
        Log.w("MicroMsg.SightCameraView", "cancel record");
        if (this.Dqm == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        bg.aAk().getWorkerHandler().removeCallbacks(this.Dqx);
        bg.aAk().postToWorker(this.Dqy);
        this.Dqv.stopTimer();
        bi(0.0f);
        eWr();
        setKeepScreenOn(false);
    }

    /* access modifiers changed from: protected */
    public void setStopCallback(Runnable runnable) {
        this.Dqo = runnable;
    }

    /* access modifiers changed from: protected */
    public final void requestAudioFocus() {
        this.pNk.a(this);
    }

    /* access modifiers changed from: protected */
    public final void eWs() {
        this.pNk.fp(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Camera.Parameters parameters;
        boolean z = false;
        if (motionEvent.getAction() == 0 && this.Dqr && this.Dqs) {
            Log.i("MicroMsg.SightCameraView", "check double click %dms", Long.valueOf(SystemClock.elapsedRealtime() - this.Dqp));
            if (SystemClock.elapsedRealtime() - this.Dqp < 400) {
                this.Dql.Dqk.removeMessages(4354);
                e eVar = this.Dql;
                if (!eVar.ztJ) {
                    Log.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
                } else {
                    try {
                        parameters = eVar.gGr.getParameters();
                    } catch (Exception e2) {
                        Log.e("MicroMsg.SightCamera", "getParameters failed %s", e2.getMessage());
                        Log.printErrStackTrace("MicroMsg.SightCamera", e2, "", new Object[0]);
                        parameters = null;
                    }
                    if (parameters != null) {
                        Log.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", Boolean.valueOf(eVar.ztI), Boolean.valueOf(parameters.isZoomSupported()));
                        if (parameters.isZoomSupported()) {
                            eVar.Dqk.removeMessages(4353);
                            if (eVar.ztI) {
                                eVar.Dqk.zul = false;
                                eVar.Dqk.ztI = false;
                                eVar.Dqk.zuk = e.a.e(parameters) * -1;
                                eVar.Dqk.sendMessage(eVar.Dqk.obtainMessage(4353, eVar.gGr));
                            } else {
                                eVar.Dqk.zul = false;
                                eVar.Dqk.ztI = true;
                                eVar.Dqk.zuk = e.a.e(parameters);
                                eVar.Dqk.sendMessage(eVar.Dqk.obtainMessage(4353, eVar.gGr));
                            }
                            if (!eVar.ztI) {
                                z = true;
                            }
                            eVar.ztI = z;
                        }
                    }
                }
            } else {
                e eVar2 = this.Dql;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int surfaceWidth = getSurfaceWidth();
                int surfaceHeight = getSurfaceHeight();
                if (!com.tencent.mm.compatible.util.d.oE(14)) {
                    eVar2.Dqk.removeMessages(4354);
                    eVar2.Dqk.gZZ = x;
                    eVar2.Dqk.haa = y;
                    eVar2.Dqk.imO = surfaceWidth;
                    eVar2.Dqk.imP = surfaceHeight;
                    eVar2.Dqk.sendMessageDelayed(eVar2.Dqk.obtainMessage(4354, eVar2.gGr), 400);
                }
            }
            this.Dqp = SystemClock.elapsedRealtime();
            motionEvent.getX();
            motionEvent.getY();
            com.tencent.mm.compatible.util.d.oE(14);
        }
        return true;
    }

    public String getRecordPath() {
        return this.Dqm.getRecordPath();
    }

    public int getDuration() {
        return this.Dqm.getDuration();
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTw() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTx() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTy() {
    }

    @Override // com.tencent.mm.model.d.a
    public final void aTz() {
    }

    static /* synthetic */ void b(SightCameraView sightCameraView) {
        Log.i("MicroMsg.SightCameraView", "stop record");
        if (sightCameraView.Dqm == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.sight.encode.ui.SightCameraView.AnonymousClass4 */
            final /* synthetic */ Runnable aFE = null;

            public final void run() {
                AppMethodBeat.i(28785);
                AppMethodBeat.o(28785);
            }

            public final String toString() {
                AppMethodBeat.i(28786);
                String str = super.toString() + "|stopRecord";
                AppMethodBeat.o(28786);
                return str;
            }
        });
        sightCameraView.Dqv.stopTimer();
        sightCameraView.bi(0.0f);
        sightCameraView.eWr();
        sightCameraView.setKeepScreenOn(false);
    }
}
