package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.DrawnCallBackLinearLayout;

public class TestTimeForChatting extends DrawnCallBackLinearLayout {
    a Qxe;
    public int Qxf = 0;
    public int Qxg = 0;
    public final String TAG = "MicroMsg.TestTimeForChatting";
    private long cwj;
    private int gRJ = 0;

    public interface a {
        void gJx();
    }

    public TestTimeForChatting(Context context) {
        super(context);
    }

    public TestTimeForChatting(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(39200);
        long currentTimeMillis = System.currentTimeMillis();
        super.onDraw(canvas);
        Log.i("MicroMsg.TestTimeForChatting", new StringBuilder().append(System.currentTimeMillis() - currentTimeMillis).toString());
        AppMethodBeat.o(39200);
    }

    public final void gXV() {
        AppMethodBeat.i(39201);
        Log.i("MicroMsg.TestTimeForChatting", "start chatting response time: %dms", Long.valueOf(System.currentTimeMillis() - this.cwj));
        this.gRJ = 0;
        AppMethodBeat.o(39201);
    }

    public final void gXW() {
        AppMethodBeat.i(39202);
        Log.i("MicroMsg.TestTimeForChatting", "klem frameCount:%d", Integer.valueOf(this.gRJ));
        h.INSTANCE.a(11198, Integer.valueOf(this.gRJ));
        AppMethodBeat.o(39202);
    }

    @Override // com.tencent.mm.ui.widget.DrawnCallBackLinearLayout
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(39203);
        this.gRJ++;
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.TestTimeForChatting", th, "dispatchDraw", new Object[0]);
        }
        g.Wm(9);
        g.Wm(18);
        g.Wm(25);
        g.Wm(24);
        g.Wm(20);
        g.Wm(18);
        if (this.Qxe != null) {
            post(new Runnable() {
                /* class com.tencent.mm.ui.tools.TestTimeForChatting.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(39199);
                    if (TestTimeForChatting.this.Qxe != null) {
                        TestTimeForChatting.this.Qxe.gJx();
                    }
                    AppMethodBeat.o(39199);
                }
            });
        }
        AppMethodBeat.o(39203);
    }

    public void setOndispatchDraw(a aVar) {
        this.Qxe = aVar;
    }

    public boolean fitSystemWindows(Rect rect) {
        AppMethodBeat.i(39204);
        Log.d("MicroMsg.TestTimeForChatting", "ashu::fitSystemWindows: %s, fixBottomPadding:%d fixRightPadding:%d", rect.toString(), Integer.valueOf(this.Qxf), Integer.valueOf(this.Qxg));
        rect.bottom += this.Qxf;
        rect.right += this.Qxg;
        boolean fitSystemWindows = super.fitSystemWindows(rect);
        AppMethodBeat.o(39204);
        return fitSystemWindows;
    }
}
