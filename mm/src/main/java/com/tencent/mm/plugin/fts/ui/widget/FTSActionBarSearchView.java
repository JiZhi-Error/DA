package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.ActionBarSearchView;

public class FTSActionBarSearchView extends ActionBarSearchView {
    public FTSActionBarSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FTSActionBarSearchView(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.ui.tools.ActionBarSearchView
    public int getLayoutId() {
        AppMethodBeat.i(112231);
        Log.i("FTSActionBarSearchView", "getLayoutId");
        AppMethodBeat.o(112231);
        return R.layout.ank;
    }

    public void setCursorVisible(boolean z) {
        AppMethodBeat.i(112232);
        this.QoH.setCursorVisible(z);
        AppMethodBeat.o(112232);
    }
}
