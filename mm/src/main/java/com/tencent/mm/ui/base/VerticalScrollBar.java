package com.tencent.mm.ui.base;

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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;

public abstract class VerticalScrollBar extends View {
    View OTO;
    private boolean OWK = false;
    public a OWL;
    protected int OWM;
    private int OWN;
    private int OWO;
    private int OWP = 0;
    protected int backgroundColor;
    private int bxP;
    private float haa;
    private Context mContext;
    private int mEX;
    private int mEY;
    private int maxHeight;
    private Paint paint;
    protected int textColor;
    private float textSize;
    protected float yuV;
    protected int yuW;
    protected String[] yuX;
    private float yuY = 0.0f;
    private p yuZ;
    private TextView yva;
    private int yvb;

    public interface a {
        void DP(String str);
    }

    /* access modifiers changed from: protected */
    public abstract void ann();

    /* access modifiers changed from: protected */
    public abstract int getToastLayoutId();

    public VerticalScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ann();
        this.mContext = context;
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.yvb = BackwardSupportUtil.BitmapFactory.fromDPToPix(context, 3.0f);
        this.OTO = inflate(context, getToastLayoutId(), null);
        this.OWO = BackwardSupportUtil.BitmapFactory.fromDPToPix(context, (float) this.yuW);
        this.mEX = this.mContext.getResources().getDisplayMetrics().widthPixels;
        this.mEY = this.mContext.getResources().getDisplayMetrics().heightPixels;
        this.yuZ = new p(this.OTO, this.OWO, this.OWO);
        this.yva = (TextView) this.OTO.findViewById(R.id.hqw);
        this.textColor = at.aO(this.mContext, R.attr.f3026a);
        this.OWM = this.mContext.getResources().getColor(R.color.ag2);
        this.backgroundColor = context.getResources().getColor(R.color.afp);
        this.OWN = at.fromDPToPix(getContext(), 7);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.maxHeight = (((Math.max(this.mEY, this.mEX) - au.eu(this.mContext)) - au.getStatusBarHeight(this.mContext)) - au.aD(this.mContext)) - ((int) (((float) com.tencent.mm.cb.a.aH(this.mContext, R.dimen.bc)) * com.tencent.mm.cb.a.ji(this.mContext)));
        this.OWP = (int) (((float) this.maxHeight) / (((float) this.yuX.length) * this.yuV));
    }

    public void setOnScrollBarTouchListener(a aVar) {
        this.OWL = aVar;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int measuredHeight = getMeasuredHeight();
        final int measuredWidth = getMeasuredWidth();
        int fromDPToPix = at.fromDPToPix(getContext(), 9);
        this.textSize = (float) at.fromDPToPix(getContext(), 11);
        this.textSize = this.textSize > ((float) this.OWP) ? (float) this.OWP : this.textSize;
        this.textSize = this.textSize < ((float) fromDPToPix) ? (float) fromDPToPix : this.textSize;
        this.paint.setTextSize(this.textSize);
        if (this.yuY != this.textSize) {
            this.yuY = this.textSize;
            post(new Runnable() {
                /* class com.tencent.mm.ui.base.VerticalScrollBar.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(142456);
                    if (VerticalScrollBar.this.yuX.length <= 0) {
                        AppMethodBeat.o(142456);
                        return;
                    }
                    int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(VerticalScrollBar.this.getContext(), 16) + ((int) VerticalScrollBar.this.paint.measureText(VerticalScrollBar.this.yuX[VerticalScrollBar.this.yuX.length - 1]));
                    int length = (int) (((float) VerticalScrollBar.this.yuX.length) * VerticalScrollBar.this.textSize * VerticalScrollBar.this.yuV);
                    Log.i("MicroMsg.VerticalScrollBar", "onDraw newHeight:%s, viewHeight:%s", Integer.valueOf(length), Integer.valueOf(measuredHeight));
                    if (length == 0) {
                        length = measuredHeight;
                    }
                    if (fromDPToPix > measuredWidth) {
                        fromDPToPix = measuredWidth;
                    }
                    ViewGroup.LayoutParams layoutParams = VerticalScrollBar.this.getLayoutParams();
                    layoutParams.width = fromDPToPix;
                    layoutParams.height = length;
                    VerticalScrollBar.this.setLayoutParams(layoutParams);
                    AppMethodBeat.o(142456);
                }
            });
        }
        if (this.OWK && this.bxP != 0) {
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(this.backgroundColor);
            canvas.drawCircle(((float) measuredWidth) / 2.0f, (this.textSize / 2.0f) + (((float) this.bxP) * this.textSize * this.yuV) + ((float) at.fromDPToPix(this.mContext, 1)), (float) this.OWN, this.paint);
        }
        this.paint.setTextAlign(Paint.Align.CENTER);
        for (int i2 = 0; i2 < this.yuX.length; i2++) {
            if (!this.OWK || this.bxP == 0 || this.bxP != i2) {
                this.paint.setColor(this.textColor);
            } else {
                this.paint.setColor(this.OWM);
            }
            canvas.drawText(this.yuX[i2], ((float) measuredWidth) / 2.0f, this.textSize + (((float) i2) * this.textSize * this.yuV), this.paint);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            this.OWK = true;
            this.haa = motionEvent.getY();
            if (this.haa < 0.0f) {
                this.haa = 0.0f;
            }
            if (this.haa > ((float) getMeasuredHeight())) {
                this.haa = (float) getMeasuredHeight();
            }
            int i2 = (int) (this.haa / (this.textSize * this.yuV));
            if (i2 >= this.yuX.length) {
                i2 = this.yuX.length - 1;
            }
            this.bxP = i2;
            if (this.bxP == -1) {
                this.yva.setText(R.string.gf5);
            } else {
                this.yva.setText(this.yuX[this.bxP]);
            }
            int fromDPToPix = this.mEX - at.fromDPToPix(getContext(), 120);
            int rawY = (int) ((((double) ((this.textSize / 2.0f) + ((((float) this.bxP) * this.textSize) * this.yuV))) - (((double) this.OWO) / 2.0d)) + ((double) (motionEvent.getRawY() - motionEvent.getY())));
            if (motionEvent.getAction() == 0) {
                this.yuZ.showAtLocation(this, 0, fromDPToPix, rawY);
            }
            if (motionEvent.getAction() == 2) {
                this.yuZ.update(fromDPToPix, rawY, this.OWO, this.OWO);
            }
            if (this.OWL != null) {
                if (this.bxP == -1) {
                    this.OWL.DP(com.tencent.mm.cb.a.aI(getContext(), R.string.gf5));
                } else {
                    this.OWL.DP(this.yuX[this.bxP]);
                }
            }
            invalidate();
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.yuZ.dismiss();
            this.OWK = false;
        }
        return true;
    }
}
