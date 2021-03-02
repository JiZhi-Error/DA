package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public class DrawnCallBackLinearLayout extends LinearLayout {
    public final boolean DEBUG = true;
    private a QBJ;
    private b QBK;
    public final String TAG = "MicroMsg.TestTimeForChatting";

    public interface a {
        void gRe();
    }

    public interface b {
    }

    public DrawnCallBackLinearLayout(Context context) {
        super(context);
    }

    public DrawnCallBackLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(11)
    public DrawnCallBackLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(143314);
        if (this.QBK != null) {
            this.QBK = null;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(143314);
        return dispatchTouchEvent;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(143315);
        long currentTimeMillis = System.currentTimeMillis();
        super.onLayout(z, i2, i3, i4, i5);
        Log.i("MicroMsg.TestTimeForChatting", "[onLayout] " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(143315);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(143316);
        super.dispatchDraw(canvas);
        if (this.QBJ != null) {
            this.QBJ.gRe();
            this.QBJ = null;
        }
        AppMethodBeat.o(143316);
    }

    public void setListener(a aVar) {
        this.QBJ = aVar;
    }

    public void setTouchedCallback(b bVar) {
        this.QBK = bVar;
    }
}
