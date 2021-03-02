package com.tencent.mm.plugin.finder.widget.record;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b;

@SuppressLint({"AppCompatCustomView"})
public class MarqueeTextView extends TextView {
    private boolean CA;
    private Scroller mScroller;
    private int wDP;
    private int wDQ;
    private boolean wDR;
    private int wDS;
    private int wDT;

    public MarqueeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MarqueeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(241823);
        this.wDQ = 0;
        this.CA = true;
        this.wDR = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.a.MarqueeTextView);
        this.wDP = obtainStyledAttributes.getInt(1, 10000);
        this.wDS = obtainStyledAttributes.getInt(2, 100);
        this.wDT = obtainStyledAttributes.getInt(0, 1000);
        obtainStyledAttributes.recycle();
        setSingleLine();
        setEllipsize(null);
        AppMethodBeat.o(241823);
    }

    public void computeScroll() {
        AppMethodBeat.i(241824);
        super.computeScroll();
        if (this.mScroller == null) {
            AppMethodBeat.o(241824);
            return;
        }
        if (this.mScroller.isFinished() && !this.CA) {
            if (this.wDS != 101) {
                this.CA = true;
                this.wDQ = getWidth() * -1;
                this.wDR = false;
                if (this.CA) {
                    setHorizontallyScrolling(true);
                    if (this.mScroller == null) {
                        this.mScroller = new Scroller(getContext(), new LinearInterpolator());
                        setScroller(this.mScroller);
                    }
                    TextPaint paint = getPaint();
                    Rect rect = new Rect();
                    String charSequence = getText().toString();
                    paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
                    int width = rect.width();
                    final int i2 = width - this.wDQ;
                    final int intValue = Double.valueOf((((double) (this.wDP * i2)) * 1.0d) / ((double) width)).intValue();
                    if (this.wDR) {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.finder.widget.record.MarqueeTextView.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(241822);
                                MarqueeTextView.this.mScroller.startScroll(MarqueeTextView.this.wDQ, 0, i2, 0, intValue);
                                MarqueeTextView.this.invalidate();
                                MarqueeTextView.this.CA = false;
                                AppMethodBeat.o(241822);
                            }
                        }, (long) this.wDT);
                        AppMethodBeat.o(241824);
                        return;
                    }
                    this.mScroller.startScroll(this.wDQ, 0, i2, 0, intValue);
                    invalidate();
                    this.CA = false;
                }
            } else if (this.mScroller == null) {
                AppMethodBeat.o(241824);
                return;
            } else {
                this.wDQ = 0;
                this.CA = true;
                this.wDR = true;
                this.mScroller.startScroll(0, 0, 0, 0, 0);
                invalidate();
                AppMethodBeat.o(241824);
                return;
            }
        }
        AppMethodBeat.o(241824);
    }

    public int getRndDuration() {
        return this.wDP;
    }

    public void setRndDuration(int i2) {
        this.wDP = i2;
    }

    public void setScrollMode(int i2) {
        this.wDS = i2;
    }

    public int getScrollMode() {
        return this.wDS;
    }

    public void setScrollFirstDelay(int i2) {
        this.wDT = i2;
    }

    public int getScrollFirstDelay() {
        return this.wDT;
    }
}
