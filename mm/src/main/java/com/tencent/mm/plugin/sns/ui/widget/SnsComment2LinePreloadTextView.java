package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsComment2LinePreloadTextView extends PLTextView {
    private static a Ffe = null;
    private static int Fff = 0;
    private boolean Ffg = false;

    public SnsComment2LinePreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsComment2LinePreloadTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.kiss.widget.textview.StaticTextView
    public final a aBn() {
        AppMethodBeat.i(100497);
        if (Ffe == null) {
            Ffe = c.flh().getTextViewConfig();
        }
        a aVar = Ffe;
        AppMethodBeat.o(100497);
        return aVar;
    }

    public static a getTextViewConfig() {
        AppMethodBeat.i(100498);
        if (Ffe == null) {
            Ffe = c.flh().getTextViewConfig();
        }
        a aVar = Ffe;
        AppMethodBeat.o(100498);
        return aVar;
    }

    @Override // com.tencent.mm.kiss.widget.textview.PLTextView
    public final void B(CharSequence charSequence) {
        AppMethodBeat.i(100499);
        super.B(charSequence);
        AppMethodBeat.o(100499);
    }

    @Override // com.tencent.mm.kiss.widget.textview.PLTextView
    public final void A(CharSequence charSequence) {
        AppMethodBeat.i(100500);
        super.A(charSequence);
        AppMethodBeat.o(100500);
    }

    public static int getViewWidth() {
        AppMethodBeat.i(100501);
        if (Fff == 0) {
            Fff = c.flh().getViewWidth();
        }
        int i2 = Fff;
        AppMethodBeat.o(100501);
        return i2;
    }

    @Override // com.tencent.mm.kiss.widget.textview.StaticTextView, com.tencent.mm.kiss.widget.textview.PLTextView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(100502);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(100502);
    }
}
