package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.au;
import com.tencent.smtt.sdk.TbsListener;

public class VoicePrintVolumeMeter extends View {
    private static int GSh = Color.rgb(240, 250, (int) TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL);
    private static int GSi = Color.rgb(210, 240, 200);
    private static int GSj = 100;
    private static float GSq = 1.5f;
    private static float GSr = 2.0f;
    private static float GSs = 0.1f;
    private static float GSt = 0.05f;
    static int yKE = 20;
    private int DCs = -1;
    private int DCt = -1;
    private MMHandlerThread GSf = null;
    MTimerHandler GSg = null;
    private float GSk = 0.0f;
    private float GSl = 0.0f;
    private float GSm = 0.0f;
    private float GSn = 0.0f;
    private float GSo = 0.0f;
    private float GSp = 0.0f;
    private boolean GSu = true;
    boolean gNC = false;
    private Context mContext;
    private Paint mPaint;
    private float mVolume = -1.0f;
    private View yKs;

    static {
        AppMethodBeat.i(29900);
        AppMethodBeat.o(29900);
    }

    public VoicePrintVolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(29892);
        init(context);
        AppMethodBeat.o(29892);
    }

    public VoicePrintVolumeMeter(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(29893);
        init(context);
        AppMethodBeat.o(29893);
    }

    private void init(Context context) {
        AppMethodBeat.i(29894);
        this.mContext = context;
        this.mPaint = new Paint();
        GSh = context.getResources().getColor(R.color.Brand_Alpha_0_1);
        GSi = context.getResources().getColor(R.color.Brand_Alpha_0_3);
        this.GSg = new MTimerHandler("VoicePrintVolumeMeter", (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.voiceprint.ui.VoicePrintVolumeMeter.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(29891);
                VoicePrintVolumeMeter.a(VoicePrintVolumeMeter.this);
                boolean z = VoicePrintVolumeMeter.this.gNC;
                AppMethodBeat.o(29891);
                return z;
            }
        }, true);
        AppMethodBeat.o(29894);
    }

    public void setArchView(View view) {
        this.yKs = view;
    }

    /* access modifiers changed from: package-private */
    public final void fES() {
        AppMethodBeat.i(29895);
        if (this.yKs == null || this.yKs.getVisibility() == 8) {
            AppMethodBeat.o(29895);
            return;
        }
        int[] iArr = new int[2];
        this.yKs.getLocationOnScreen(iArr);
        if (iArr[0] == 0 || iArr[1] == 0) {
            Log.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
            AppMethodBeat.o(29895);
            return;
        }
        int width = this.yKs.getWidth();
        int height = this.yKs.getHeight();
        if (height == 0 || width == 0) {
            Log.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
            AppMethodBeat.o(29895);
            return;
        }
        this.DCs = iArr[0] + (width / 2);
        this.DCt = (iArr[1] + (height / 2)) - au.getStatusBarHeight(this.mContext);
        Log.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", Integer.valueOf(this.DCs), Integer.valueOf(this.DCt));
        this.GSk = ((float) width) / 2.0f;
        this.GSl = this.GSk * GSq;
        this.GSm = this.GSk * GSr;
        this.GSn = this.GSl * GSr;
        this.GSp = this.GSl;
        this.GSo = this.GSk;
        AppMethodBeat.o(29895);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(29896);
        super.onDraw(canvas);
        if (!this.gNC) {
            AppMethodBeat.o(29896);
            return;
        }
        if (this.DCs == -1 || this.DCt == -1) {
            fES();
        }
        this.mPaint.setAlpha(GSj);
        if (this.GSp > this.GSn) {
            this.GSp = this.GSn;
        }
        if (this.GSp < this.GSl) {
            this.GSp = this.GSl;
        }
        this.mPaint.setColor(GSh);
        canvas.drawCircle((float) this.DCs, (float) this.DCt, this.GSp, this.mPaint);
        if (this.GSo > this.GSm) {
            this.GSo = this.GSm;
        }
        if (this.GSo < this.GSk) {
            this.GSo = this.GSk;
        }
        this.mPaint.setColor(GSi);
        canvas.drawCircle((float) this.DCs, (float) this.DCt, this.GSo, this.mPaint);
        AppMethodBeat.o(29896);
    }

    public final void stop() {
        AppMethodBeat.i(29897);
        reset();
        this.gNC = false;
        this.GSg.stopTimer();
        postInvalidate();
        AppMethodBeat.o(29897);
    }

    public void setVolume(float f2) {
        if (f2 > this.mVolume) {
            this.GSu = true;
        } else {
            this.GSu = false;
        }
        this.mVolume = f2;
    }

    public final void reset() {
        AppMethodBeat.i(29898);
        this.GSu = false;
        this.mVolume = -1.0f;
        this.gNC = false;
        this.GSo = 0.0f;
        this.GSp = 0.0f;
        postInvalidate();
        AppMethodBeat.o(29898);
    }

    static /* synthetic */ void a(VoicePrintVolumeMeter voicePrintVolumeMeter) {
        AppMethodBeat.i(29899);
        if (voicePrintVolumeMeter.gNC) {
            if (voicePrintVolumeMeter.GSu) {
                voicePrintVolumeMeter.GSo *= GSs + 1.0f;
                voicePrintVolumeMeter.GSp = voicePrintVolumeMeter.GSo * GSq;
            } else {
                voicePrintVolumeMeter.GSo *= 1.0f - GSt;
                voicePrintVolumeMeter.GSp = voicePrintVolumeMeter.GSo * GSq;
            }
            voicePrintVolumeMeter.postInvalidate();
        }
        AppMethodBeat.o(29899);
    }
}
