package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.b.c;
import com.tencent.neattextview.textview.layout.a;
import com.tencent.neattextview.textview.view.NeatTextView;

public class b implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, NeatTextView.c {
    private a RCg;
    private a RCh;
    protected c RCi;
    private GestureDetector mDJ;
    protected View mView;

    public b(Context context, a aVar) {
        AppMethodBeat.i(39830);
        this.RCg = aVar;
        this.mDJ = new GestureDetector(context, this);
        this.mDJ.setOnDoubleTapListener(this);
        AppMethodBeat.o(39830);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(39831);
        if (this.RCg.getLayout() == null) {
            AppMethodBeat.o(39831);
            return false;
        }
        this.RCh = this.RCg.getLayout();
        this.mView = view;
        GestureDetector gestureDetector = this.mDJ;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/neattextview/textview/view/NeatViewTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/neattextview/textview/view/NeatViewTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            cancel(2);
        }
        AppMethodBeat.o(39831);
        return a2;
    }

    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(39832);
        if (this.RCg.hiS()) {
            AppMethodBeat.o(39832);
            return false;
        } else if (this.RCh.hiH() == null) {
            AppMethodBeat.o(39832);
            return false;
        } else {
            for (c cVar : this.RCh.hiH()) {
                if (cVar.aF(motionEvent.getX() - this.RCg.getHorizontalOffset(), motionEvent.getY() - this.RCg.getVerticalOffset())) {
                    this.RCi = cVar;
                    cVar.isPressed = true;
                    this.mView.postInvalidate();
                    AppMethodBeat.o(39832);
                    return true;
                }
            }
            AppMethodBeat.o(39832);
            return false;
        }
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(39833);
        if (this.RCg.hiS()) {
            AppMethodBeat.o(39833);
        } else {
            if (this.RCi != null) {
                c cVar = this.RCi;
                View view = this.mView;
                if (cVar.RAM != null) {
                    ((ClickableSpan) cVar.RAM).onClick(view);
                }
            }
            AppMethodBeat.o(39833);
        }
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(39834);
        cancel(1);
        AppMethodBeat.o(39834);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(39835);
        cancel(3);
        AppMethodBeat.o(39835);
        return false;
    }

    /* access modifiers changed from: protected */
    public void cancel(int i2) {
        AppMethodBeat.i(39836);
        if (this.RCi != null) {
            this.RCi.isPressed = false;
            this.mView.invalidate();
            this.RCi = null;
        }
        AppMethodBeat.o(39836);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(39837);
        if (this.RCg.getOnDoubleClickListener() != null) {
            this.RCg.getOnDoubleClickListener().gS(this.mView);
            AppMethodBeat.o(39837);
            return true;
        }
        AppMethodBeat.o(39837);
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
}
