package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class InstantAutoCompleteTextView extends AutoCompleteTextView {
    private boolean BFo;

    public InstantAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InstantAutoCompleteTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void dismissDropDown() {
        AppMethodBeat.i(67272);
        super.dismissDropDown();
        Log.d("TestAutoCompleteTextView", "dismiss");
        AppMethodBeat.o(67272);
    }

    public void setShowAlways(boolean z) {
        this.BFo = z;
    }

    public boolean enoughToFilter() {
        AppMethodBeat.i(67273);
        if (this.BFo || super.enoughToFilter()) {
            AppMethodBeat.o(67273);
            return true;
        }
        AppMethodBeat.o(67273);
        return false;
    }
}
