package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsCommentCollapseLayout extends RelativeLayout {
    private SnsComment2LinePreloadTextView Ffi = null;
    private SnsCommentPreloadTextView Ffj = null;
    private TextView Ffk = null;
    private CharSequence Ffl = null;
    private CharSequence Ffm = null;
    private int Ffn = 0;

    static /* synthetic */ void b(SnsCommentCollapseLayout snsCommentCollapseLayout) {
        AppMethodBeat.i(100521);
        snsCommentCollapseLayout.hTI();
        AppMethodBeat.o(100521);
    }

    static /* synthetic */ void c(SnsCommentCollapseLayout snsCommentCollapseLayout) {
        AppMethodBeat.i(204000);
        snsCommentCollapseLayout.hWN();
        AppMethodBeat.o(204000);
    }

    public SnsCommentCollapseLayout(Context context) {
        super(context);
        AppMethodBeat.i(100508);
        init();
        AppMethodBeat.o(100508);
    }

    public SnsCommentCollapseLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(100509);
        init();
        AppMethodBeat.o(100509);
    }

    public SnsCommentCollapseLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(100510);
        init();
        AppMethodBeat.o(100510);
    }

    private void init() {
        AppMethodBeat.i(100511);
        LayoutInflater.from(getContext()).inflate(R.layout.bvh, (ViewGroup) this, true);
        this.Ffi = (SnsComment2LinePreloadTextView) findViewById(R.id.hx9);
        this.Ffj = (SnsCommentPreloadTextView) findViewById(R.id.hxa);
        this.Ffi.setGravity(16);
        this.Ffj.setGravity(16);
        this.Ffk = (TextView) findViewById(R.id.hx_);
        this.Ffn = a.fromDPToPix(getContext(), 22);
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(100506);
                if (motionEvent.getAction() == 0) {
                    view.setTag(R.id.iu_, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
                }
                AppMethodBeat.o(100506);
                return false;
            }
        });
        AppMethodBeat.o(100511);
    }

    private void hWN() {
        AppMethodBeat.i(259470);
        this.Ffk.setVisibility(0);
        this.Ffi.setLines(2);
        this.Ffi.getConfig().huY = (getMeasuredWidth() - this.Ffk.getMeasuredWidth()) - this.Ffn;
        this.Ffi.setText(this.Ffm);
        this.Ffi.setVisibility(0);
        this.Ffj.setVisibility(8);
        invalidate();
        AppMethodBeat.o(259470);
    }

    private void hTI() {
        AppMethodBeat.i(259471);
        this.Ffk.setVisibility(4);
        this.Ffj.setText(this.Ffl);
        this.Ffj.setVisibility(0);
        this.Ffi.setVisibility(8);
        invalidate();
        AppMethodBeat.o(259471);
    }

    public SnsCommentPreloadTextView getNormalCommentTv() {
        return this.Ffj;
    }

    public SnsComment2LinePreloadTextView get2LineCommentTv() {
        return this.Ffi;
    }

    public void setOpClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(100512);
        this.Ffk.setOnClickListener(onClickListener);
        AppMethodBeat.o(100512);
    }

    public void setPressTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(100513);
        this.Ffi.setOnTouchListener(onTouchListener);
        this.Ffj.setOnTouchListener(onTouchListener);
        AppMethodBeat.o(100513);
    }

    public void setTextSize(float f2) {
        AppMethodBeat.i(100514);
        this.Ffi.setTextSize(f2);
        this.Ffj.setTextSize(f2);
        AppMethodBeat.o(100514);
    }

    public final void setTextSize$255e752(float f2) {
        AppMethodBeat.i(100515);
        this.Ffi.setTextSize$255e752(f2);
        this.Ffj.setTextSize$255e752(f2);
        this.Ffk.setTextSize(1, f2);
        AppMethodBeat.o(100515);
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(100516);
        this.Ffi.setTextColor(i2);
        this.Ffj.setTextColor(i2);
        AppMethodBeat.o(100516);
    }

    public void setGravity(int i2) {
        AppMethodBeat.i(100517);
        this.Ffi.setGravity(i2);
        this.Ffj.setGravity(i2);
        AppMethodBeat.o(100517);
    }

    public final void a(final CharSequence charSequence, final CharSequence charSequence2, final int i2, final int i3) {
        CharSequence charSequence3;
        AppMethodBeat.i(203999);
        if (ah.VaL) {
            Log.d("MicroMsg.SnsCommentCollapseLayout", "setText text:%s, commentFlag:%s", charSequence, Integer.valueOf(i2));
            this.Ffl = charSequence == null ? "" : charSequence;
            if (charSequence2 == null) {
                charSequence3 = "";
            } else {
                charSequence3 = charSequence2;
            }
            this.Ffm = charSequence3;
            if (i3 > 0 || !e.iY(i2, 16)) {
                hTI();
            } else {
                hWN();
            }
            post(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(100507);
                    Log.d("MicroMsg.SnsCommentCollapseLayout", "setText text:%s, commentFlag:%s", charSequence, Integer.valueOf(i2));
                    SnsCommentCollapseLayout.this.Ffl = charSequence == null ? "" : charSequence;
                    SnsCommentCollapseLayout.this.Ffm = charSequence2 == null ? "" : charSequence2;
                    if (i3 > 0 || !e.iY(i2, 16)) {
                        SnsCommentCollapseLayout.b(SnsCommentCollapseLayout.this);
                        AppMethodBeat.o(100507);
                        return;
                    }
                    SnsCommentCollapseLayout.c(SnsCommentCollapseLayout.this);
                    AppMethodBeat.o(100507);
                }
            });
            AppMethodBeat.o(203999);
            return;
        }
        post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(259469);
                Log.d("MicroMsg.SnsCommentCollapseLayout", "setText text:%s, commentFlag:%s", charSequence, Integer.valueOf(i2));
                SnsCommentCollapseLayout.this.Ffl = charSequence == null ? "" : charSequence;
                SnsCommentCollapseLayout.this.Ffm = charSequence2 == null ? "" : charSequence2;
                if (i3 > 0 || !e.iY(i2, 16)) {
                    SnsCommentCollapseLayout.b(SnsCommentCollapseLayout.this);
                    AppMethodBeat.o(259469);
                    return;
                }
                SnsCommentCollapseLayout.c(SnsCommentCollapseLayout.this);
                AppMethodBeat.o(259469);
            }
        });
        AppMethodBeat.o(203999);
    }

    public void setTag(Object obj) {
        AppMethodBeat.i(100519);
        super.setTag(obj);
        if (this.Ffi != null) {
            this.Ffi.setTag(obj);
        }
        if (this.Ffj != null) {
            this.Ffj.setTag(obj);
        }
        AppMethodBeat.o(100519);
    }
}
