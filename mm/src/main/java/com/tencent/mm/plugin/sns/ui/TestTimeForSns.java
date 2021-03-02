package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;

public class TestTimeForSns extends FrameLayout {
    public final boolean DEBUG = true;
    public final String TAG = "MicroMsg.TestTimeForSns";
    public long beginTime;
    private boolean hasDrawed;
    private a listener;

    public interface a {
        void dSa();
    }

    public TestTimeForSns(Context context) {
        super(context);
    }

    public TestTimeForSns(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(99702);
        super.dispatchDraw(canvas);
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.listener != null) {
                this.listener.dSa();
            }
        }
        g.Wm(10);
        g.Wm(22);
        AppMethodBeat.o(99702);
    }

    public void setListener(a aVar) {
        this.listener = aVar;
    }

    public boolean hasDrawed() {
        return this.hasDrawed;
    }
}
