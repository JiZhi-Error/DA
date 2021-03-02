package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;

public class p extends PopupWindow {
    private View.OnTouchListener ORN;
    private Context mContext = null;

    public p(Context context) {
        super(context);
        AppMethodBeat.i(159247);
        this.mContext = context;
        super.setBackgroundDrawable(null);
        setContentView(new a(this.mContext));
        AppMethodBeat.o(159247);
    }

    public p(View view) {
        super(view);
        AppMethodBeat.i(159248);
        super.setBackgroundDrawable(null);
        AppMethodBeat.o(159248);
    }

    public p(View view, int i2, int i3) {
        super(view, i2, i3);
        AppMethodBeat.i(159249);
        super.setBackgroundDrawable(null);
        AppMethodBeat.o(159249);
    }

    public p(View view, int i2, int i3, boolean z) {
        super(view, i2, i3, z);
        AppMethodBeat.i(159250);
        super.setBackgroundDrawable(null);
        AppMethodBeat.o(159250);
    }

    public void dismiss() {
        AppMethodBeat.i(159251);
        try {
            super.dismiss();
            AppMethodBeat.o(159251);
        } catch (Exception e2) {
            as.e("MicroMsg.MMPopupWindow", "dismiss exception, e = " + e2.getMessage(), new Object[0]);
            AppMethodBeat.o(159251);
        }
    }

    public Drawable getBackground() {
        AppMethodBeat.i(159252);
        View contentView = getContentView();
        if (contentView == null) {
            AppMethodBeat.o(159252);
            return null;
        } else if (contentView instanceof a) {
            Drawable background = contentView.getBackground();
            AppMethodBeat.o(159252);
            return background;
        } else {
            AppMethodBeat.o(159252);
            return null;
        }
    }

    public void setContentView(View view) {
        int i2 = -2;
        AppMethodBeat.i(159253);
        View contentView = getContentView();
        if (contentView == null) {
            super.setContentView(view);
        } else if (contentView instanceof a) {
            a aVar = (a) contentView;
            aVar.removeAllViews();
            if (view == null) {
                super.setContentView(aVar);
                AppMethodBeat.o(159253);
                return;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height != -2) {
                i2 = -1;
            }
            aVar.addView(view, new FrameLayout.LayoutParams(-1, i2));
            super.setContentView(aVar);
            AppMethodBeat.o(159253);
            return;
        }
        super.setContentView(view);
        AppMethodBeat.o(159253);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        int i2 = -2;
        AppMethodBeat.i(159254);
        View contentView = getContentView();
        if (contentView == null) {
            AppMethodBeat.o(159254);
            return;
        }
        Context context = contentView.getContext();
        if (contentView instanceof a) {
            contentView.setBackgroundDrawable(drawable);
            AppMethodBeat.o(159254);
            return;
        }
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        if (layoutParams == null || layoutParams.height != -2) {
            i2 = -1;
        }
        a aVar = new a(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, i2);
        aVar.setBackgroundDrawable(drawable);
        aVar.addView(contentView, layoutParams2);
        super.setContentView(aVar);
        AppMethodBeat.o(159254);
    }

    public void setTouchInterceptor(View.OnTouchListener onTouchListener) {
        this.ORN = onTouchListener;
    }

    /* access modifiers changed from: package-private */
    public class a extends FrameLayout {
        a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public final int[] onCreateDrawableState(int i2) {
            AppMethodBeat.i(159241);
            int[] onCreateDrawableState = super.onCreateDrawableState(i2);
            AppMethodBeat.o(159241);
            return onCreateDrawableState;
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            KeyEvent.DispatcherState keyDispatcherState;
            AppMethodBeat.i(159242);
            if (keyEvent.getKeyCode() != 4) {
                boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
                AppMethodBeat.o(159242);
                return dispatchKeyEvent;
            } else if (getKeyDispatcherState() == null) {
                boolean dispatchKeyEvent2 = super.dispatchKeyEvent(keyEvent);
                AppMethodBeat.o(159242);
                return dispatchKeyEvent2;
            } else if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                }
                AppMethodBeat.o(159242);
                return true;
            } else if (keyEvent.getAction() != 1 || (keyDispatcherState = getKeyDispatcherState()) == null || !keyDispatcherState.isTracking(keyEvent) || keyEvent.isCanceled()) {
                boolean dispatchKeyEvent3 = super.dispatchKeyEvent(keyEvent);
                AppMethodBeat.o(159242);
                return dispatchKeyEvent3;
            } else {
                p.this.dismiss();
                AppMethodBeat.o(159242);
                return true;
            }
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(159243);
            if (p.this.ORN == null || !p.this.ORN.onTouch(this, motionEvent)) {
                boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(159243);
                return dispatchTouchEvent;
            }
            AppMethodBeat.o(159243);
            return true;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(159244);
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0 && (x < 0 || x >= getWidth() || y < 0 || y >= getHeight())) {
                p.this.dismiss();
                AppMethodBeat.o(159244);
                return true;
            } else if (motionEvent.getAction() == 4) {
                p.this.dismiss();
                AppMethodBeat.o(159244);
                return true;
            } else {
                boolean onTouchEvent = super.onTouchEvent(motionEvent);
                AppMethodBeat.o(159244);
                return onTouchEvent;
            }
        }

        public final void sendAccessibilityEvent(int i2) {
            AppMethodBeat.i(159245);
            if (getChildCount() == 1) {
                getChildAt(0).sendAccessibilityEvent(i2);
            } else {
                super.sendAccessibilityEvent(i2);
            }
            super.sendAccessibilityEvent(i2);
            AppMethodBeat.o(159245);
        }
    }
}
