package com.tencent.xweb.extension.video;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class c {
    float CBd = 0.0f;
    a SBa;
    boolean SBb = false;
    float SBc;
    ImageView mCM;
    ImageView mCN;
    private ImageView mCO = null;
    ImageView mDf = null;
    float mProgress;

    public interface a {
        void aJq();

        void cP(float f2);
    }

    public c(FrameLayout frameLayout, a aVar) {
        AppMethodBeat.i(153561);
        this.SBa = aVar;
        this.mCM = (ImageView) frameLayout.findViewById(R.id.gcx);
        this.mDf = (ImageView) frameLayout.findViewById(R.id.gcy);
        this.mCN = (ImageView) frameLayout.findViewById(R.id.gcw);
        this.mCO = (ImageView) frameLayout.findViewById(R.id.gd0);
        this.mCO.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.xweb.extension.video.c.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                float f2 = 0.0f;
                AppMethodBeat.i(153560);
                if (motionEvent.getAction() == 0) {
                    c.this.SBb = false;
                    c.this.CBd = motionEvent.getX();
                    if (c.this.SBa != null) {
                        c.this.SBa.aJq();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = (float) ((int) ((motionEvent.getX() - c.this.CBd) + ((float) c.this.mCM.getWidth())));
                    if (x >= 0.0f) {
                        if (x > ((float) c.this.mCN.getWidth())) {
                            f2 = (float) c.this.mCN.getWidth();
                        } else {
                            f2 = x;
                        }
                    }
                    c.this.SBc = (f2 * 100.0f) / ((float) c.this.mCN.getWidth());
                    c.this.e(c.this.SBc, true);
                    if (c.this.SBa != null) {
                        c.this.SBa.aJq();
                    }
                    c.this.SBb = true;
                } else {
                    if (c.this.SBb && c.this.SBa != null) {
                        c.this.SBa.cP(c.this.SBc);
                    }
                    c.this.SBb = false;
                }
                AppMethodBeat.o(153560);
                return true;
            }
        });
        AppMethodBeat.o(153561);
    }

    public final void e(float f2, boolean z) {
        AppMethodBeat.i(153562);
        if (!this.SBb || z) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            } else if (f2 > 100.0f) {
                f2 = 100.0f;
            }
            this.mProgress = f2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCO.getLayoutParams();
            layoutParams.leftMargin = (int) (((f2 / 100.0f) * ((float) this.mCN.getWidth())) - ((float) (this.mCO.getWidth() / 2)));
            this.mCO.setLayoutParams(layoutParams);
            this.mCO.requestLayout();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mCM.getLayoutParams();
            layoutParams2.width = (int) ((f2 / 100.0f) * ((float) this.mCN.getWidth()));
            this.mCM.setLayoutParams(layoutParams2);
            this.mCM.requestLayout();
            AppMethodBeat.o(153562);
            return;
        }
        AppMethodBeat.o(153562);
    }
}
