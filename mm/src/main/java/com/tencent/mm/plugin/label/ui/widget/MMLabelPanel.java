package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMTagPanel;

public class MMLabelPanel extends MMTagPanel {
    public MMLabelPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMLabelPanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.ui.base.MMTagPanel
    public final void cWT() {
        AppMethodBeat.i(26338);
        Log.d("MicroMsg.Label.MMLabelPanel", "cpan[onPreDelTag]");
        if (getTagCount() > 0) {
            AppMethodBeat.o(26338);
        } else {
            AppMethodBeat.o(26338);
        }
    }
}
