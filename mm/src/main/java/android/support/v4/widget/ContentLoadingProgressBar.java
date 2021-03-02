package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    boolean Th = false;
    boolean Ti = false;
    private final Runnable Tj = new Runnable() {
        /* class android.support.v4.widget.ContentLoadingProgressBar.AnonymousClass1 */

        public final void run() {
            ContentLoadingProgressBar.this.Th = false;
            ContentLoadingProgressBar.this.mStartTime = -1;
            ContentLoadingProgressBar.this.setVisibility(8);
        }
    };
    private final Runnable Tk = new Runnable() {
        /* class android.support.v4.widget.ContentLoadingProgressBar.AnonymousClass2 */

        public final void run() {
            ContentLoadingProgressBar.this.Ti = false;
            if (!ContentLoadingProgressBar.this.mDismissed) {
                ContentLoadingProgressBar.this.mStartTime = System.currentTimeMillis();
                ContentLoadingProgressBar.this.setVisibility(0);
            }
        }
    };
    boolean mDismissed = false;
    long mStartTime = -1;

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fS();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fS();
    }

    private void fS() {
        removeCallbacks(this.Tj);
        removeCallbacks(this.Tk);
    }
}
