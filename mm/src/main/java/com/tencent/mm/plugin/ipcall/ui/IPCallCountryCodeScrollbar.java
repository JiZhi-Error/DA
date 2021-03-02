package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.ui.base.p;
import com.tencent.rtmp.sharp.jni.QLog;

public class IPCallCountryCodeScrollbar extends View {
    public static final String[] yuU = {"A", "B", "C", QLog.TAG_REPORTLEVEL_DEVELOPER, QLog.TAG_REPORTLEVEL_USER, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", QLog.TAG_REPORTLEVEL_COLORUSER, "X", "Y", "Z"};
    private int bxP;
    private float haa;
    private Paint paint;
    private float textSize;
    protected float yuV = 1.3f;
    protected int yuW = 79;
    protected String[] yuX = {"↑"};
    private float yuY = 0.0f;
    private p yuZ;
    private TextView yva;
    private int yvb;
    private a yvc;

    public interface a {
        void DP(String str);
    }

    public final void aCk(String str) {
        AppMethodBeat.i(25724);
        boolean z = false;
        for (String str2 : yuU) {
            if (str2.equals(str)) {
                z = true;
            }
        }
        if (!z) {
            str = "#";
        }
        int length = this.yuX.length + 1;
        String[] strArr = new String[length];
        String[] strArr2 = this.yuX;
        int length2 = strArr2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            String str3 = strArr2[i2];
            if (str3.equals(str)) {
                AppMethodBeat.o(25724);
                return;
            }
            strArr[i3] = str3;
            i2++;
            i3++;
        }
        strArr[length - 1] = str;
        this.yuX = strArr;
        AppMethodBeat.o(25724);
    }

    /* access modifiers changed from: protected */
    public int getToastLayoutId() {
        return R.layout.bsf;
    }

    public IPCallCountryCodeScrollbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(25725);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.yvb = BackwardSupportUtil.BitmapFactory.fromDPToPix(context, 3.0f);
        View inflate = inflate(context, getToastLayoutId(), null);
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(context, (float) this.yuW);
        this.yuZ = new p(inflate, fromDPToPix, fromDPToPix);
        this.yva = (TextView) inflate.findViewById(R.id.hqw);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setColor(-11119018);
        this.paint.setTextAlign(Paint.Align.CENTER);
        AppMethodBeat.o(25725);
    }

    public void setOnScrollBarTouchListener(a aVar) {
        this.yvc = aVar;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2 = 0;
        AppMethodBeat.i(25726);
        super.onDraw(canvas);
        final int measuredHeight = getMeasuredHeight();
        final int measuredWidth = getMeasuredWidth();
        this.textSize = ((float) measuredHeight) / (((float) this.yuX.length) * this.yuV);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.is);
        if (this.textSize > ((float) dimensionPixelSize)) {
            this.textSize = (float) dimensionPixelSize;
        }
        this.paint.setTextSize(this.textSize);
        if (this.yuY != this.textSize) {
            this.yuY = this.textSize;
            post(new Runnable() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallCountryCodeScrollbar.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(25723);
                    if (IPCallCountryCodeScrollbar.this.yuX.length <= 0) {
                        AppMethodBeat.o(25723);
                        return;
                    }
                    int measureText = ((int) IPCallCountryCodeScrollbar.this.paint.measureText(IPCallCountryCodeScrollbar.this.yuX[IPCallCountryCodeScrollbar.this.yuX.length - 1])) + com.tencent.mm.cb.a.fromDPToPix(IPCallCountryCodeScrollbar.this.getContext(), 8);
                    if (measureText > measuredWidth) {
                        ViewGroup.LayoutParams layoutParams = IPCallCountryCodeScrollbar.this.getLayoutParams();
                        layoutParams.width = measureText;
                        layoutParams.height = measuredHeight;
                        IPCallCountryCodeScrollbar.this.setLayoutParams(layoutParams);
                    }
                    AppMethodBeat.o(25723);
                }
            });
        }
        if (this.textSize == ((float) dimensionPixelSize)) {
            float length = (((float) measuredHeight) - ((((float) this.yuX.length) * this.textSize) * this.yuV)) / 2.0f;
            while (i2 < this.yuX.length) {
                canvas.drawText(this.yuX[i2], ((float) measuredWidth) / 2.0f, this.textSize + length + (((float) i2) * this.textSize * this.yuV), this.paint);
                i2++;
            }
            AppMethodBeat.o(25726);
            return;
        }
        while (i2 < this.yuX.length) {
            canvas.drawText(this.yuX[i2], ((float) measuredWidth) / 2.0f, this.textSize + (((float) i2) * this.textSize * this.yuV), this.paint);
            i2++;
        }
        AppMethodBeat.o(25726);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(25727);
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            this.haa = motionEvent.getY();
            if (this.haa < 0.0f) {
                this.haa = 0.0f;
            }
            if (this.haa > ((float) getMeasuredHeight())) {
                this.haa = (float) getMeasuredHeight();
            }
            setBackgroundDrawable(com.tencent.mm.cb.a.l(getContext(), R.drawable.as5));
            float f2 = this.haa;
            float f3 = this.textSize * this.yuV;
            int measuredHeight = (int) ((f2 - ((((float) getMeasuredHeight()) - (((float) this.yuX.length) * f3)) / 2.0f)) / f3);
            if (measuredHeight < 0) {
                measuredHeight = 0;
            }
            if (measuredHeight >= this.yuX.length) {
                measuredHeight = this.yuX.length - 1;
            }
            this.bxP = measuredHeight;
            if (this.bxP == -1) {
                this.yva.setText(R.string.gf5);
            } else {
                this.yva.setText(this.yuX[this.bxP]);
            }
            this.yuZ.showAtLocation(this, 17, 0, 0);
            if (this.yvc != null) {
                if (this.bxP == -1) {
                    this.yvc.DP(com.tencent.mm.cb.a.aI(getContext(), R.string.gf5));
                } else {
                    this.yvc.DP(this.yuX[this.bxP]);
                }
            }
            invalidate();
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            setBackgroundResource(0);
            this.yuZ.dismiss();
        }
        AppMethodBeat.o(25727);
        return true;
    }
}
