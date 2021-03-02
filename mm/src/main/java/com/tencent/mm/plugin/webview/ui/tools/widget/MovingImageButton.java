package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;

public class MovingImageButton extends ImageView {
    private int JAl;
    private int JAm;
    private int JAn = 0;
    private int JAo = 0;
    private ViewGroup.MarginLayoutParams JAp;
    private final int JAq = 100;
    private int JAr;
    private boolean JAs = false;
    private boolean JAt = true;
    private Context mContext;
    private int mEX;
    private int mEY;
    private int nrK;
    private int nrL;
    private int rZ;
    private int x;
    private int y;

    public MovingImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public MovingImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(82287);
        super.onFinishInflate();
        this.JAr = a.fromDPToPix(this.mContext, 100);
        this.mEX = a.jn(this.mContext);
        this.mEY = a.jo(this.mContext);
        this.rZ = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        AppMethodBeat.o(82287);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(82288);
        if (!this.JAt) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(82288);
            return onTouchEvent;
        }
        if (this.JAn == 0 || this.JAo == 0) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            this.JAn = rect.right - rect.left;
            this.JAo = rect.bottom - rect.top;
            Log.d("MicroMsg.MovingImageButton", "right = %d, top = %d, left = %d, bottom = %d, screenX = %d, screenY = %d", Integer.valueOf(rect.right), Integer.valueOf(rect.top), Integer.valueOf(rect.left), Integer.valueOf(rect.bottom), Integer.valueOf(this.JAn), Integer.valueOf(this.JAo));
        }
        this.x = (int) motionEvent.getRawX();
        this.y = (int) motionEvent.getRawY();
        switch (motionEvent.getAction()) {
            case 0:
                this.JAl = this.x;
                this.JAm = this.y;
                break;
            case 1:
                if (Math.abs(this.JAl - this.x) + Math.abs(this.JAm - this.y) <= this.rZ) {
                    performClick();
                    break;
                } else {
                    if (this.y < this.JAr) {
                        this.JAp.topMargin = 0;
                    } else if (this.y > this.JAo - this.JAr) {
                        this.JAp.topMargin = this.JAo - getHeight();
                    } else if (this.x > this.JAn / 2) {
                        this.JAp.rightMargin = 0;
                    } else {
                        this.JAp.rightMargin = this.JAn - getWidth();
                    }
                    requestLayout();
                    break;
                }
            case 2:
                int i2 = this.x - this.nrK;
                int i3 = this.y - this.nrL;
                if (!(i2 == 0 && i3 == 0)) {
                    this.JAp = (ViewGroup.MarginLayoutParams) getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = this.JAp;
                    marginLayoutParams.rightMargin = (-i2) + marginLayoutParams.rightMargin;
                    this.JAp.topMargin += i3;
                    if (this.JAp.rightMargin < 0) {
                        this.JAp.rightMargin = 0;
                    } else if (this.JAp.rightMargin > this.JAn - getWidth()) {
                        this.JAp.rightMargin = this.JAn - getWidth();
                    }
                    if (this.JAp.topMargin < 0) {
                        this.JAp.topMargin = 0;
                    } else if (this.JAp.topMargin > this.JAo - getHeight()) {
                        this.JAp.topMargin = this.JAo - getHeight();
                    }
                    requestLayout();
                    break;
                }
        }
        this.nrK = this.x;
        this.nrL = this.y;
        AppMethodBeat.o(82288);
        return true;
    }

    public void setCanMove(boolean z) {
        this.JAt = z;
    }
}
