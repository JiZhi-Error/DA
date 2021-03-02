package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.test.suitebuilder.annotation.Suppress;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;

public class MMTextView extends TextView {
    private boolean PPd = false;
    private GestureDetector PPe = null;
    private b QDL = null;
    private boolean QDM = false;
    private boolean QDN = false;
    private boolean QDO = false;
    private a QDP = null;
    private long gof = -1;

    public interface a {
        void a(CharSequence charSequence, long j2);
    }

    public interface b {
        boolean gB(View view);
    }

    public void setMsgId(long j2) {
        this.gof = j2;
    }

    public MMTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(143405);
        init();
        AppMethodBeat.o(143405);
    }

    public MMTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(143406);
        init();
        AppMethodBeat.o(143406);
    }

    public void setMMTextViewCallBack(a aVar) {
        if (!this.QDO && aVar != null) {
            this.QDP = aVar;
            this.QDO = true;
        }
    }

    public void setIsFromChatting(boolean z) {
        if (!this.QDM) {
            this.QDM = z;
        }
    }

    private void init() {
        AppMethodBeat.i(143407);
        this.PPe = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            /* class com.tencent.mm.ui.widget.MMTextView.AnonymousClass1 */

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(205409);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(205409);
                return onContextClick;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(205408);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(205408);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(205407);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(205407);
                return onSingleTapUp;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(143404);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                if (MMTextView.this.QDL == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                    AppMethodBeat.o(143404);
                    return false;
                }
                boolean gB = MMTextView.this.QDL.gB(MMTextView.this);
                com.tencent.mm.hellhoundlib.a.a.a(gB, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(143404);
                return gB;
            }
        }, new Handler(Looper.getMainLooper()));
        AppMethodBeat.o(143407);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.i(143408);
        int action = motionEvent.getAction();
        if (action == 1 && this.PPd) {
            Log.d("MicroMsg.MMTextView", "ignore Action Up Event this time");
            AppMethodBeat.o(143408);
        } else {
            if (action == 0) {
                this.PPd = false;
            }
            if (this.QDL == null || this.PPe == null) {
                z = false;
            } else {
                GestureDetector gestureDetector = this.PPe;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/ui/widget/MMTextView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                z = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/widget/MMTextView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            }
            if (!z) {
                z = super.onTouchEvent(motionEvent);
            }
            AppMethodBeat.o(143408);
        }
        return z;
    }

    public void setOnDoubleClickLitsener(b bVar) {
        this.QDL = bVar;
    }

    public void setTextInternal(CharSequence charSequence) {
        AppMethodBeat.i(143409);
        this.QDN = true;
        setText(charSequence);
        AppMethodBeat.o(143409);
    }

    @Override // android.widget.TextView
    @Suppress
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        AppMethodBeat.i(143410);
        super.setText(charSequence, bufferType);
        if (this.QDP != null && this.QDM && (charSequence instanceof Spannable) && ((Spannable) charSequence).getSpans(0, charSequence.length(), Object.class) != null) {
            this.QDP.a(charSequence, this.gof);
        }
        this.QDN = false;
        AppMethodBeat.o(143410);
    }

    public void cancelLongPress() {
        AppMethodBeat.i(143411);
        Log.d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
        this.PPd = true;
        super.cancelLongPress();
        AppMethodBeat.o(143411);
    }

    public boolean performLongClick() {
        AppMethodBeat.i(143412);
        Log.d("MicroMsg.MMTextView", "performLongClick , should ignore Action Up Event next time");
        this.PPd = true;
        boolean performLongClick = super.performLongClick();
        AppMethodBeat.o(143412);
        return performLongClick;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(143413);
        try {
            super.onMeasure(i2, i3);
            AppMethodBeat.o(143413);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
            AppMethodBeat.o(143413);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(143414);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(143414);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
            AppMethodBeat.o(143414);
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(143415);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.o(143415);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.o(143415);
            return true;
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(143416);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(143416);
            return baseline;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
            AppMethodBeat.o(143416);
            return -1;
        }
    }
}
