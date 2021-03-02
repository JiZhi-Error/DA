package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.tencent.mm.R;

public class AppCompatSeekBar extends SeekBar {
    private final k akO;

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.yl);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.akO = new k(this);
        this.akO.a(attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        int max;
        int i2 = 1;
        synchronized (this) {
            super.onDraw(canvas);
            k kVar = this.akO;
            if (kVar.akQ != null && (max = kVar.akP.getMax()) > 1) {
                int intrinsicWidth = kVar.akQ.getIntrinsicWidth();
                int intrinsicHeight = kVar.akQ.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                kVar.akQ.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((kVar.akP.getWidth() - kVar.akP.getPaddingLeft()) - kVar.akP.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) kVar.akP.getPaddingLeft(), (float) (kVar.akP.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    kVar.akQ.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        k kVar = this.akO;
        Drawable drawable = kVar.akQ;
        if (drawable != null && drawable.isStateful() && drawable.setState(kVar.akP.getDrawableState())) {
            kVar.akP.invalidateDrawable(drawable);
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        k kVar = this.akO;
        if (kVar.akQ != null) {
            kVar.akQ.jumpToCurrentState();
        }
    }
}
