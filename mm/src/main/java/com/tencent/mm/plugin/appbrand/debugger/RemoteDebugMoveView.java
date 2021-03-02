package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class RemoteDebugMoveView extends FrameLayout {
    float deo;
    float dep;
    int hbc;
    float liD;
    float liE;
    int oh;

    public RemoteDebugMoveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RemoteDebugMoveView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(147042);
        super.onConfigurationChanged(configuration);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.AnonymousClass2 */
            private int cBY = 0;

            public final void onGlobalLayout() {
                AppMethodBeat.i(147040);
                int i2 = this.cBY + 1;
                this.cBY = i2;
                if (i2 < 2) {
                    AppMethodBeat.o(147040);
                    return;
                }
                RemoteDebugMoveView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                RemoteDebugMoveView.this.post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.debugger.RemoteDebugMoveView.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(147039);
                        if (RemoteDebugMoveView.this.getParent() instanceof View) {
                            View view = (View) RemoteDebugMoveView.this.getParent();
                            RemoteDebugMoveView.this.hbc = view.getMeasuredWidth();
                            RemoteDebugMoveView.this.oh = view.getMeasuredHeight();
                            float max = Math.max(0.0f, Math.min((float) (RemoteDebugMoveView.this.hbc - RemoteDebugMoveView.this.getWidth()), RemoteDebugMoveView.this.getX()));
                            float max2 = Math.max(0.0f, Math.min((float) (RemoteDebugMoveView.this.oh - RemoteDebugMoveView.this.getHeight()), RemoteDebugMoveView.this.getY()));
                            RemoteDebugMoveView.this.setX(max);
                            RemoteDebugMoveView.this.setY(max2);
                            RemoteDebugMoveView.this.requestLayout();
                        }
                        AppMethodBeat.o(147039);
                    }
                });
                AppMethodBeat.o(147040);
            }
        });
        AppMethodBeat.o(147042);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(147043);
        switch (motionEvent.getAction()) {
            case 0:
                this.deo = motionEvent.getRawX();
                this.dep = motionEvent.getRawY();
                break;
            case 2:
                this.liD = motionEvent.getRawX();
                this.liE = motionEvent.getRawY();
                float x = getX() + (this.liD - this.deo);
                if (0.0f < x && x < ((float) (this.hbc - getWidth()))) {
                    setX(x);
                }
                float f2 = this.liE - this.dep;
                float height = (float) (this.oh - getHeight());
                float y = getY() + f2;
                if ((0.0f < y && y < height) || ((y <= 0.0f && f2 > 0.0f) || (y >= height && f2 < 0.0f))) {
                    setY(y);
                }
                this.deo = this.liD;
                this.dep = this.liE;
                break;
        }
        AppMethodBeat.o(147043);
        return true;
    }

    static /* synthetic */ int b(RemoteDebugMoveView remoteDebugMoveView) {
        AppMethodBeat.i(147044);
        int width = remoteDebugMoveView.getWidth();
        if (width > 0) {
            AppMethodBeat.o(147044);
            return width;
        }
        int fromDPToPix = a.fromDPToPix(remoteDebugMoveView.getContext(), 200);
        AppMethodBeat.o(147044);
        return fromDPToPix;
    }
}
