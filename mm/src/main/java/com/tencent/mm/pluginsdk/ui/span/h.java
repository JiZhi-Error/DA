package com.tencent.mm.pluginsdk.ui.span;

import android.text.style.CharacterStyle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.as;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.neattextview.textview.view.b;

public class h extends b {
    private View.OnTouchListener KqG;

    public h(NeatTextView neatTextView, View.OnTouchListener onTouchListener) {
        super(neatTextView.getContext(), neatTextView);
        AppMethodBeat.i(223849);
        this.KqG = onTouchListener;
        AppMethodBeat.o(223849);
    }

    @Override // com.tencent.neattextview.textview.view.b
    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(152269);
        as.d("MMNeatTouchListener", "onTouch", new Object[0]);
        view.setTag(R.id.iu_, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
        if (view instanceof NeatTextView) {
            NeatTextView neatTextView = (NeatTextView) view;
            if (!neatTextView.gYM() || neatTextView.pMM) {
                if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                    neatTextView.getWrappedTextView().setPressed(false);
                } else if (motionEvent.getAction() == 0) {
                    neatTextView.getWrappedTextView().setPressed(true);
                }
                neatTextView.getWrappedTextView().setTag(view.getTag());
                boolean onTouch = this.KqG.onTouch(neatTextView.getWrappedTextView(), motionEvent);
                AppMethodBeat.o(152269);
                return onTouch;
            }
        } else {
            this.KqG.onTouch(view, motionEvent);
        }
        boolean onTouch2 = super.onTouch(view, motionEvent);
        AppMethodBeat.o(152269);
        return onTouch2;
    }

    @Override // com.tencent.neattextview.textview.view.b
    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(152270);
        boolean onDown = super.onDown(motionEvent);
        if (this.RCi != null) {
            CharacterStyle characterStyle = this.RCi.RAM;
            if (characterStyle instanceof p) {
                ((p) characterStyle).setIsPressed(true);
            }
            AppMethodBeat.o(152270);
            return true;
        }
        AppMethodBeat.o(152270);
        return onDown;
    }

    @Override // com.tencent.neattextview.textview.view.b
    public final void cancel(int i2) {
        AppMethodBeat.i(152271);
        if (this.RCi != null) {
            CharacterStyle characterStyle = this.RCi.RAM;
            if (characterStyle instanceof p) {
                ((p) characterStyle).setIsPressed(false);
            }
        }
        super.cancel(i2);
        AppMethodBeat.o(152271);
    }

    @Override // com.tencent.neattextview.textview.view.b
    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(152272);
        if (!(this.RCi == null || this.mView == null)) {
            this.mView.performLongClick();
        }
        super.onLongPress(motionEvent);
        AppMethodBeat.o(152272);
    }
}
