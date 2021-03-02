package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver;

/* access modifiers changed from: package-private */
public final class w implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
    private ViewTreeObserver IH;
    private final Runnable mRunnable;
    private final View mView;

    private w(View view, Runnable runnable) {
        this.mView = view;
        this.IH = view.getViewTreeObserver();
        this.mRunnable = runnable;
    }

    public static w a(View view, Runnable runnable) {
        w wVar = new w(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(wVar);
        view.addOnAttachStateChangeListener(wVar);
        return wVar;
    }

    public final boolean onPreDraw() {
        removeListener();
        this.mRunnable.run();
        return true;
    }

    private void removeListener() {
        if (this.IH.isAlive()) {
            this.IH.removeOnPreDrawListener(this);
        } else {
            this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.mView.removeOnAttachStateChangeListener(this);
    }

    public final void onViewAttachedToWindow(View view) {
        this.IH = view.getViewTreeObserver();
    }

    public final void onViewDetachedFromWindow(View view) {
        removeListener();
    }
}
