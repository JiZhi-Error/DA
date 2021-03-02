package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsCommentPreloadTextView extends PLTextView {
    private static a Ffe = null;
    private static int Fff = 0;
    private boolean Ffg = false;

    public SnsCommentPreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsCommentPreloadTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.kiss.widget.textview.StaticTextView
    public final a aBn() {
        AppMethodBeat.i(100523);
        if (Ffe == null) {
            Ffe = d.fli().getTextViewConfig();
        }
        a aVar = Ffe;
        AppMethodBeat.o(100523);
        return aVar;
    }

    public static a getTextViewConfig() {
        AppMethodBeat.i(100524);
        if (Ffe == null) {
            Ffe = d.fli().getTextViewConfig();
        }
        a aVar = Ffe;
        AppMethodBeat.o(100524);
        return aVar;
    }

    @Override // com.tencent.mm.kiss.widget.textview.PLTextView
    public final void B(CharSequence charSequence) {
        AppMethodBeat.i(100525);
        super.B(charSequence);
        AppMethodBeat.o(100525);
    }

    @Override // com.tencent.mm.kiss.widget.textview.PLTextView
    public final void A(CharSequence charSequence) {
        AppMethodBeat.i(100526);
        super.A(charSequence);
        AppMethodBeat.o(100526);
    }

    public static int getViewWidth() {
        AppMethodBeat.i(100527);
        if (Fff == 0) {
            Fff = d.fli().getViewWidth();
        }
        int i2 = Fff;
        AppMethodBeat.o(100527);
        return i2;
    }

    @Override // com.tencent.mm.kiss.widget.textview.StaticTextView, com.tencent.mm.kiss.widget.textview.PLTextView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(100528);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(100528);
    }
}
