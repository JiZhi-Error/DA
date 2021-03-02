package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.smtt.sdk.WebView;

public class TalkRoomVolumeMeter extends FrameLayout {
    private a FRB;
    private ImageView FRC;
    private ImageView FRD;
    private ImageView FRE;
    private FrameLayout FRF;

    public TalkRoomVolumeMeter(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(29649);
        initView();
        AppMethodBeat.o(29649);
    }

    public TalkRoomVolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(29650);
        initView();
        AppMethodBeat.o(29650);
    }

    private void initView() {
        AppMethodBeat.i(29651);
        this.FRB = new a(getContext());
        this.FRC = new ImageView(getContext());
        this.FRC.setScaleType(ImageView.ScaleType.FIT_XY);
        this.FRC.setImageResource(R.drawable.bp5);
        this.FRC.setVisibility(0);
        this.FRD = new ImageView(getContext());
        this.FRD.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.FRD.setImageResource(R.drawable.bp4);
        this.FRD.setVisibility(8);
        this.FRE = new ImageView(getContext());
        this.FRE.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.FRE.setImageResource(R.drawable.bp1);
        this.FRE.setVisibility(8);
        this.FRF = new FrameLayout(getContext());
        this.FRF.addView(this.FRB);
        this.FRF.addView(this.FRD);
        this.FRF.setVisibility(8);
        addView(this.FRF);
        addView(this.FRE);
        addView(this.FRC);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        bringChildToFront(this.FRC);
        AppMethodBeat.o(29651);
    }

    private void setShowErr(boolean z) {
        AppMethodBeat.i(29652);
        this.FRE.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(29652);
    }

    public void setShowFlame(boolean z) {
        Canvas lockCanvas;
        AppMethodBeat.i(29653);
        this.FRF.setVisibility(z ? 0 : 8);
        if (z) {
            a aVar = this.FRB;
            if (!aVar.started) {
                aVar.started = true;
                aVar.FRN.startTimer(100);
            }
            AppMethodBeat.o(29653);
            return;
        }
        a aVar2 = this.FRB;
        if (aVar2.started) {
            aVar2.started = false;
            if (!(aVar2.FRP < aVar2.FRG || aVar2.FRP > aVar2.FRH || aVar2.FRK == null || aVar2.FRJ == null || (lockCanvas = aVar2.FRI.lockCanvas()) == null || aVar2.FRM == null)) {
                lockCanvas.setDrawFilter(aVar2.FRQ);
                aVar2.FRM.set(0, 0, aVar2.CVr, aVar2.CVs + 0);
                lockCanvas.drawBitmap(aVar2.FRR ? aVar2.FRK : aVar2.FRJ, (Rect) null, aVar2.FRM, aVar2.paint);
                aVar2.FRI.unlockCanvasAndPost(lockCanvas);
            }
            aVar2.FRN.stopTimer();
        }
        AppMethodBeat.o(29653);
    }

    private void setShowRed(boolean z) {
        this.FRB.FRR = z;
    }

    public void setMax(int i2) {
        this.FRB.max = i2;
    }

    public void setValue(int i2) {
        a aVar = this.FRB;
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > aVar.max) {
            i2 = aVar.max;
        }
        aVar.value = i2;
        aVar.FRP = aVar.FRH - ((aVar.FRH - aVar.FRG) * ((((float) aVar.value) * 1.0f) / ((float) aVar.max)));
    }

    public void setMinPos(int i2) {
        this.FRB.FRG = (float) i2;
    }

    public void setMaxPos(int i2) {
        this.FRB.FRH = (float) i2;
    }

    /* access modifiers changed from: package-private */
    public class a extends SurfaceView implements SurfaceHolder.Callback {
        int CVr;
        int CVs;
        float FRG = 0.0f;
        float FRH = 0.0f;
        SurfaceHolder FRI = getHolder();
        Bitmap FRJ;
        Bitmap FRK;
        private Bitmap FRL;
        Rect FRM;
        MTimerHandler FRN;
        private float FRO = this.FRH;
        float FRP = this.FRH;
        PaintFlagsDrawFilter FRQ;
        boolean FRR = false;
        private boolean isRefreshing = false;
        private float[] kZF;
        int max = 100;
        Paint paint;
        boolean started = false;
        int value = 0;

        public a(Context context) {
            super(context);
            AppMethodBeat.i(29643);
            this.FRI.addCallback(this);
            this.paint = new Paint();
            this.paint.setAntiAlias(true);
            this.FRQ = new PaintFlagsDrawFilter(0, 3);
            this.FRN = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomVolumeMeter.a.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(29642);
                    a.a(a.this);
                    boolean z = a.this.isRefreshing;
                    AppMethodBeat.o(29642);
                    return z;
                }
            }, true);
            AppMethodBeat.o(29643);
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            AppMethodBeat.i(29644);
            Log.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
            this.FRJ = BitmapFactory.decodeResource(getResources(), R.drawable.bp2);
            this.FRL = BitmapFactory.decodeResource(getResources(), R.drawable.bp1);
            this.FRK = BitmapFactory.decodeResource(getResources(), R.drawable.bp3);
            AppMethodBeat.o(29644);
        }

        private int fuq() {
            AppMethodBeat.i(29645);
            if (this.FRJ == null) {
                AppMethodBeat.o(29645);
                return FacebookRequestErrorClassification.EC_INVALID_TOKEN;
            }
            int height = this.FRJ.getHeight();
            AppMethodBeat.o(29645);
            return height;
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            AppMethodBeat.i(29646);
            Log.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + i3 + " height = " + i4);
            this.FRH = 0.0f;
            this.FRG = (float) (i4 - fuq());
            this.FRO = this.FRH;
            this.FRP = this.FRH;
            this.CVr = i3;
            this.CVs = fuq();
            this.FRM = new Rect(0, (int) this.FRO, this.CVr, ((int) this.FRO) + this.CVs);
            this.isRefreshing = true;
            AppMethodBeat.o(29646);
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            AppMethodBeat.i(29647);
            Log.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
            this.isRefreshing = false;
            this.FRN.stopTimer();
            if (this.FRJ != null) {
                Log.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", this.FRJ.toString());
                this.FRJ.recycle();
                this.FRJ = null;
            }
            if (this.FRL != null) {
                Log.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", this.FRL.toString());
                this.FRL.recycle();
                this.FRL = null;
            }
            if (this.FRK != null) {
                Log.i("MicroMsg.TalkRoomVoiceMeter", "bitmap recycle %s", this.FRK.toString());
                this.FRK.recycle();
                this.FRK = null;
            }
            AppMethodBeat.o(29647);
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(29648);
            if (aVar.FRP < aVar.FRG || aVar.FRP > aVar.FRH) {
                AppMethodBeat.o(29648);
            } else if (aVar.FRK == null || aVar.FRJ == null) {
                AppMethodBeat.o(29648);
            } else {
                Canvas lockCanvas = aVar.FRI.lockCanvas();
                if (!(lockCanvas == null || aVar.FRM == null)) {
                    lockCanvas.setDrawFilter(aVar.FRQ);
                    float f2 = aVar.FRP;
                    if (aVar.kZF == null) {
                        aVar.kZF = new float[]{aVar.FRH, aVar.FRH, aVar.FRH, aVar.FRH, aVar.FRH};
                    }
                    int i2 = 0;
                    while (i2 < aVar.kZF.length - 1) {
                        float[] fArr = aVar.kZF;
                        fArr[i2] = fArr[i2 + 1];
                        i2++;
                    }
                    aVar.kZF[i2] = f2;
                    aVar.FRO = ((((aVar.kZF[0] + (aVar.kZF[1] * 4.0f)) + (aVar.kZF[2] * 6.0f)) + (aVar.kZF[3] * 4.0f)) + (aVar.kZF[4] * 1.0f)) / 16.0f;
                    aVar.FRM.set(0, (int) aVar.FRO, aVar.CVr, ((int) aVar.FRO) + aVar.CVs);
                    lockCanvas.drawBitmap(aVar.FRR ? aVar.FRK : aVar.FRJ, (Rect) null, aVar.FRM, aVar.paint);
                    aVar.FRI.unlockCanvasAndPost(lockCanvas);
                }
                AppMethodBeat.o(29648);
            }
        }
    }
}
