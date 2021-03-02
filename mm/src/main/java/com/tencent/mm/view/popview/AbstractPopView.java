package com.tencent.mm.view.popview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

public abstract class AbstractPopView extends FrameLayout {
    protected a RpZ;
    protected int Rqa = 0;

    public interface a {
        void onDismiss();
    }

    public abstract WindowManager.LayoutParams getWindowLayoutParams();

    public abstract void hI(View view);

    public AbstractPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbstractPopView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0 && (x < 0 || x >= getWidth() || y < 0 || y >= getHeight())) {
            dismiss();
            return true;
        } else if (motionEvent.getAction() != 4) {
            return super.onTouchEvent(motionEvent);
        } else {
            dismiss();
            return true;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        KeyEvent.DispatcherState keyDispatcherState;
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (getKeyDispatcherState() == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
            if (keyDispatcherState2 == null) {
                return true;
            }
            keyDispatcherState2.startTracking(keyEvent, this);
            return true;
        } else if (keyEvent.getAction() != 1 || (keyDispatcherState = getKeyDispatcherState()) == null || !keyDispatcherState.isTracking(keyEvent) || keyEvent.isCanceled()) {
            return super.dispatchKeyEvent(keyEvent);
        } else {
            dismiss();
            return true;
        }
    }

    public void dismiss() {
        if (this.RpZ != null) {
            this.RpZ.onDismiss();
        }
    }

    public void setOnDismissCallback(a aVar) {
        this.RpZ = aVar;
    }

    /* access modifiers changed from: protected */
    public final void kO(Context context) {
        Activity activity;
        Context context2 = context;
        while (true) {
            if (!(context2 instanceof Activity)) {
                if (!(context2 instanceof ContextThemeWrapper)) {
                    activity = null;
                    break;
                }
                context2 = ((ContextThemeWrapper) context2).getBaseContext();
            } else {
                activity = (Activity) context2;
                break;
            }
        }
        this.Rqa = 0;
        if (activity != null) {
            View findViewById = activity.findViewById(16908290);
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            findViewById.getLocationOnScreen(iArr);
            findViewById.getLocationInWindow(iArr2);
            this.Rqa = iArr[1] - iArr2[1];
        }
    }
}
