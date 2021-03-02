package com.tencent.mm.plugin.transvoice.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;

public class TransVoicePanelLayout extends InputPanelFrameLayout {
    a Gwn;

    /* access modifiers changed from: package-private */
    public interface a {
        void f(boolean z, int i2);
    }

    public TransVoicePanelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TransVoicePanelLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.ui.widget.InputPanelFrameLayout, com.tencent.mm.ui.widget.b.a
    public final void f(boolean z, int i2) {
        AppMethodBeat.i(102632);
        super.f(z, i2);
        Log.d("TransVoicePanelLayout", "isKeyboardShow: %s, keyboardHeight: %d.", Boolean.valueOf(z), Integer.valueOf(i2));
        if (this.Gwn != null) {
            this.Gwn.f(z, i2);
        }
        AppMethodBeat.o(102632);
    }

    /* access modifiers changed from: package-private */
    public void setOnInputPanelChange(a aVar) {
        this.Gwn = aVar;
    }
}
