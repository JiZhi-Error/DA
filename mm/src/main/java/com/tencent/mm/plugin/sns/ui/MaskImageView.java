package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class MaskImageView extends TagImageView {
    private MMHandler Eok = new MMHandler(Looper.getMainLooper());
    private Runnable Eol = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ui.MaskImageView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(97959);
            MaskImageView.this.setPressed(false);
            MaskImageView.this.invalidate();
            AppMethodBeat.o(97959);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f1513a = 90;

    /* renamed from: b  reason: collision with root package name */
    private int f1514b = 0;
    private boolean enable = true;

    /* renamed from: g  reason: collision with root package name */
    private int f1515g = 0;
    private int r = 0;

    public MaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(97961);
        super.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.MaskImageView.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(97960);
                if (!MaskImageView.this.enable) {
                    AppMethodBeat.o(97960);
                    return false;
                }
                boolean f2 = MaskImageView.this.f(view, motionEvent);
                AppMethodBeat.o(97960);
                return f2;
            }
        });
        super.setContentDescription(getContext().getResources().getString(R.string.h71));
        AppMethodBeat.o(97961);
    }

    public void settouchEnable(boolean z) {
        this.enable = z;
    }

    public final boolean f(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(97962);
        switch (motionEvent.getAction()) {
            case 0:
                view.setPressed(true);
                view.invalidate();
                this.Eok.removeCallbacks(this.Eol);
                break;
            case 1:
            case 3:
                this.Eok.post(this.Eol);
                break;
        }
        if (isClickable() || isLongClickable()) {
            AppMethodBeat.o(97962);
            return false;
        }
        AppMethodBeat.o(97962);
        return true;
    }

    @Override // com.tencent.mm.ui.widget.QImageView
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(97963);
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.f1513a, this.r, this.f1515g, this.f1514b);
        }
        AppMethodBeat.o(97963);
    }

    @Override // com.tencent.mm.memory.ui.QPictureView
    public void onAttachedToWindow() {
        AppMethodBeat.i(97964);
        super.onAttachedToWindow();
        AppMethodBeat.o(97964);
    }

    @Override // com.tencent.mm.ui.widget.QImageView, com.tencent.mm.memory.ui.QPictureView
    public void onDetachedFromWindow() {
        AppMethodBeat.i(97965);
        super.onDetachedFromWindow();
        AppMethodBeat.o(97965);
    }
}
