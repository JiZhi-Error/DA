package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MaskLinearLayout extends LinearLayout {
    private MMHandler Eok = new MMHandler();
    private Runnable Eol = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.MaskLinearLayout.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(97966);
            MaskLinearLayout.this.setPressed(false);
            MaskLinearLayout.a(MaskLinearLayout.this);
            MaskLinearLayout.this.invalidate();
            AppMethodBeat.o(97966);
        }
    };
    private boolean enable = false;
    private List<MaskImageView> list = new LinkedList();

    public MaskLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(97968);
        super.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.MaskLinearLayout.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(97967);
                Log.e(APMidasPayAPI.ENV_TEST, "touch: " + motionEvent.getAction());
                if (!MaskLinearLayout.this.enable) {
                    AppMethodBeat.o(97967);
                } else {
                    switch (motionEvent.getAction()) {
                        case 0:
                            view.setPressed(true);
                            MaskLinearLayout.a(MaskLinearLayout.this);
                            view.invalidate();
                            MaskLinearLayout.this.Eok.removeCallbacks(MaskLinearLayout.this.Eol);
                            break;
                        case 1:
                        case 3:
                            MaskLinearLayout.this.Eok.post(MaskLinearLayout.this.Eol);
                            break;
                    }
                    if (MaskLinearLayout.this.list != null) {
                        for (MaskImageView maskImageView : MaskLinearLayout.this.list) {
                            maskImageView.f(maskImageView, motionEvent);
                        }
                    }
                    AppMethodBeat.o(97967);
                }
                return false;
            }
        });
        AppMethodBeat.o(97968);
    }

    public void settouchEnable(boolean z) {
        this.enable = z;
    }

    public final void b(MaskImageView maskImageView) {
        AppMethodBeat.i(97969);
        this.list.add(maskImageView);
        AppMethodBeat.o(97969);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(97970);
        super.onDraw(canvas);
        AppMethodBeat.o(97970);
    }

    @Deprecated
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(97971);
        Assert.assertTrue(false);
        AppMethodBeat.o(97971);
    }

    static /* synthetic */ void a(MaskLinearLayout maskLinearLayout) {
        AppMethodBeat.i(97972);
        if (maskLinearLayout.isPressed()) {
            maskLinearLayout.setBackgroundColor(maskLinearLayout.getResources().getColor(R.color.FG_3));
            AppMethodBeat.o(97972);
            return;
        }
        maskLinearLayout.setBackgroundResource(0);
        AppMethodBeat.o(97972);
    }
}
