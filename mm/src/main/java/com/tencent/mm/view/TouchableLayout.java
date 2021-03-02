package com.tencent.mm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public class TouchableLayout extends FrameLayout {
    public static final a Rni = new a((byte) 0);
    private static int kuv;
    private static int kuw;

    static {
        AppMethodBeat.i(164649);
        AppMethodBeat.o(164649);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchableLayout(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(205016);
        AppMethodBeat.o(205016);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(164647);
        AppMethodBeat.o(164647);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchableLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(164648);
        AppMethodBeat.o(164648);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(164646);
        p.h(motionEvent, "ev");
        if (motionEvent.getAction() == 0) {
            kuv = (int) motionEvent.getRawX();
            kuw = (int) motionEvent.getRawY();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(164646);
        return dispatchTouchEvent;
    }
}
