package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.aa;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FitWindowsFrameLayout extends FrameLayout implements aa {
    private aa.a anG;

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.v7.widget.aa
    public void setOnFitSystemWindowsListener(aa.a aVar) {
        this.anG = aVar;
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (this.anG != null) {
            this.anG.f(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
