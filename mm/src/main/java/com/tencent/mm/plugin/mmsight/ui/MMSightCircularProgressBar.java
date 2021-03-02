package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public class MMSightCircularProgressBar extends View {
    int duration = 0;
    private boolean htU = false;
    boolean isStart = false;
    private Context mContext;
    private float offset = 0.0f;
    private Paint paint;
    private float strokeWidth = 0.0f;
    private int zAQ = Color.parseColor("#1AAD19");
    private int zAR = Color.parseColor("#FFFFFF");
    private int zAS = Color.parseColor("#FA5151");
    private RectF zAT;
    private Paint zAU;
    private Paint zAV;
    private int zAW = 153;
    float zAX = 0.0f;
    int zAY = 0;
    int zAZ = 0;
    c zBa;
    private a zBb;
    ArrayList<Float> zBc = new ArrayList<>();
    private ArrayList<Float> zBd = new ArrayList<>();
    private boolean zBe = false;
    private boolean zBf = false;
    boolean zBg = false;

    public interface a {
        void Z(ArrayList<Float> arrayList);

        void lK(boolean z);
    }

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(94519);
        this.mContext = context;
        AppMethodBeat.o(94519);
    }

    public MMSightCircularProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(94520);
        this.mContext = context;
        AppMethodBeat.o(94520);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(187078);
        super.onLayout(z, i2, i3, i4, i5);
        if (!this.htU) {
            this.htU = true;
            float width = (float) getWidth();
            this.strokeWidth = (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.ad2);
            this.offset = this.strokeWidth / 2.0f;
            this.zAT = new RectF(this.offset, this.offset, width - this.offset, width - this.offset);
            this.paint = new Paint();
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(this.strokeWidth);
            this.paint.setColor(this.zAQ);
            this.paint.setAlpha(this.zAW);
            this.paint.setAntiAlias(true);
            this.zAU = new Paint();
            this.zAU.setStyle(Paint.Style.STROKE);
            this.zAU.setStrokeWidth(this.strokeWidth);
            this.zAU.setColor(this.zAR);
            this.zAU.setAlpha(this.zAW);
            this.zAU.setAntiAlias(true);
            this.zAV = new Paint();
            this.zAV.setStyle(Paint.Style.STROKE);
            this.zAV.setStrokeWidth(this.strokeWidth);
            this.zAV.setColor(this.zAS);
            this.zAV.setAntiAlias(true);
        }
        AppMethodBeat.o(187078);
    }

    public int getDrawWidth() {
        AppMethodBeat.i(187079);
        int width = (int) this.zAT.width();
        AppMethodBeat.o(187079);
        return width;
    }

    public void setEnableSubProgress(boolean z) {
        AppMethodBeat.i(187080);
        Log.i("MicroMsg.MMSightCircularProgressBar", "setEnableSubProgress: %s", Boolean.valueOf(z));
        this.zBe = z;
        AppMethodBeat.o(187080);
    }

    public void setMaxProgress(int i2) {
        AppMethodBeat.i(94522);
        Log.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", Integer.valueOf(i2));
        this.zAZ = i2;
        AppMethodBeat.o(94522);
    }

    public void setDuration(int i2) {
        AppMethodBeat.i(94523);
        Log.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", Integer.valueOf(i2));
        this.duration = i2;
        AppMethodBeat.o(94523);
    }

    public void setInitProgress(int i2) {
        AppMethodBeat.i(94524);
        Log.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", Integer.valueOf(i2), Boolean.valueOf(this.isStart));
        if (!this.isStart) {
            this.zAY = i2;
        }
        AppMethodBeat.o(94524);
    }

    public void setCircularColor(int i2) {
        AppMethodBeat.i(94525);
        this.zAQ = i2;
        this.zAW = 255;
        if (!(this.paint == null || i2 == 0)) {
            this.paint.setColor(i2);
        }
        AppMethodBeat.o(94525);
    }

    public void setProgressCallback(a aVar) {
        this.zBb = aVar;
    }

    public ArrayList<Float> getSubProgress() {
        return this.zBc;
    }

    public final void reset() {
        AppMethodBeat.i(187081);
        Log.i("MicroMsg.MMSightCircularProgressBar", "reset");
        this.zBb = null;
        this.zAY = 0;
        this.zAZ = 100;
        this.duration = 0;
        this.isStart = false;
        this.zBc.clear();
        this.zAX = 0.0f;
        if (this.zBa != null) {
            this.zBa.cancel();
            this.zBa = null;
        }
        invalidate();
        AppMethodBeat.o(187081);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(94526);
        canvas.save();
        canvas.translate(this.offset, this.offset);
        canvas.rotate(180.0f, this.zAT.right / 2.0f, this.zAT.bottom / 2.0f);
        if (this.zBe) {
            int i2 = 0;
            float f2 = 0.0f;
            while (i2 < this.zBc.size()) {
                if (!this.zBg || i2 != this.zBc.size() - 1) {
                    canvas.drawArc(this.zAT, 90.0f + ((f2 / ((float) this.zAZ)) * 360.0f), ((this.zBc.get(i2).floatValue() - f2) / ((float) this.zAZ)) * 360.0f, false, this.paint);
                } else {
                    canvas.drawArc(this.zAT, 90.0f + ((f2 / ((float) this.zAZ)) * 360.0f), ((this.zBc.get(i2).floatValue() - f2) / ((float) this.zAZ)) * 360.0f, false, this.zAV);
                }
                float floatValue = this.zBc.get(i2).floatValue();
                canvas.drawArc(this.zAT, 90.0f + (((floatValue - 0.85f) / ((float) this.zAZ)) * 360.0f), (0.85f / ((float) this.zAZ)) * 360.0f, false, this.zAU);
                i2++;
                f2 = floatValue;
            }
            if (this.zAZ > 0) {
                canvas.drawArc(this.zAT, 90.0f + ((f2 / ((float) this.zAZ)) * 360.0f), ((this.zAX - f2) / ((float) this.zAZ)) * 360.0f, false, this.paint);
            }
        } else {
            canvas.drawArc(this.zAT, 90.0f, (this.zAX / ((float) this.zAZ)) * 360.0f, false, this.paint);
        }
        canvas.restore();
        AppMethodBeat.o(94526);
    }
}
