package com.tencent.mm.plugin.recordvideo.ui.editor;

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

public class MMEditorCircularProgressBar extends View {
    private a CdF;
    private int duration = 0;
    private boolean htU = false;
    private boolean isStart = false;
    private float lus = 0.0f;
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
    private float zAX = 0.0f;
    private int zAY = 0;
    private ArrayList<Float> zBc = new ArrayList<>();
    private ArrayList<Float> zBd = new ArrayList<>();
    private boolean zBe = false;
    private boolean zBf = false;
    private boolean zBg = false;

    public interface a {
    }

    public MMEditorCircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(237204);
        this.mContext = context;
        AppMethodBeat.o(237204);
    }

    public MMEditorCircularProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(237205);
        this.mContext = context;
        AppMethodBeat.o(237205);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(237206);
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
        AppMethodBeat.o(237206);
    }

    public int getDrawWidth() {
        AppMethodBeat.i(237207);
        int width = (int) this.zAT.width();
        AppMethodBeat.o(237207);
        return width;
    }

    public void setEnableSubProgress(boolean z) {
        AppMethodBeat.i(237208);
        Log.i("MicroMsg.MMSightCircularProgressBar", "setEnableSubProgress: %s", Boolean.valueOf(z));
        this.zBe = z;
        AppMethodBeat.o(237208);
    }

    public void setMaxProgress(float f2) {
        AppMethodBeat.i(237209);
        Log.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", Float.valueOf(f2));
        this.lus = f2;
        AppMethodBeat.o(237209);
    }

    public void setDuration(int i2) {
        AppMethodBeat.i(237210);
        Log.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", Integer.valueOf(i2));
        this.duration = i2;
        AppMethodBeat.o(237210);
    }

    public void setInitProgress(int i2) {
        AppMethodBeat.i(237211);
        Log.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", Integer.valueOf(i2), Boolean.valueOf(this.isStart));
        if (!this.isStart) {
            this.zAY = i2;
        }
        AppMethodBeat.o(237211);
    }

    public void setCurrentProgress(float f2) {
        AppMethodBeat.i(237212);
        this.zAX = f2;
        invalidate();
        AppMethodBeat.o(237212);
    }

    public void setCircularColor(int i2) {
        AppMethodBeat.i(237213);
        this.zAQ = i2;
        this.zAW = 255;
        if (!(this.paint == null || i2 == 0)) {
            this.paint.setColor(i2);
        }
        AppMethodBeat.o(237213);
    }

    public void setProgressCallback(a aVar) {
        this.CdF = aVar;
    }

    public ArrayList<Float> getSubProgress() {
        return this.zBc;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(237214);
        canvas.save();
        canvas.translate(this.offset, this.offset);
        canvas.rotate(180.0f, this.zAT.right / 2.0f, this.zAT.bottom / 2.0f);
        if (this.zBe) {
            int i2 = 0;
            float f2 = 0.0f;
            while (i2 < this.zBc.size()) {
                if (!this.zBg || i2 != this.zBc.size() - 1) {
                    canvas.drawArc(this.zAT, 90.0f + ((f2 / this.lus) * 360.0f), ((this.zBc.get(i2).floatValue() - f2) / this.lus) * 360.0f, false, this.paint);
                } else {
                    canvas.drawArc(this.zAT, 90.0f + ((f2 / this.lus) * 360.0f), ((this.zBc.get(i2).floatValue() - f2) / this.lus) * 360.0f, false, this.zAV);
                }
                float floatValue = this.zBc.get(i2).floatValue();
                canvas.drawArc(this.zAT, 90.0f + (((floatValue - 0.85f) / this.lus) * 360.0f), (0.85f / this.lus) * 360.0f, false, this.zAU);
                i2++;
                f2 = floatValue;
            }
            canvas.drawArc(this.zAT, 90.0f + ((f2 / this.lus) * 360.0f), ((this.zAX - f2) / this.lus) * 360.0f, false, this.paint);
        } else {
            canvas.drawArc(this.zAT, 90.0f, (this.zAX / this.lus) * 360.0f, false, this.paint);
        }
        canvas.restore();
        AppMethodBeat.o(237214);
    }
}
