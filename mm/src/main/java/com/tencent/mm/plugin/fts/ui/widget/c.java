package com.tencent.mm.plugin.fts.ui.widget;

import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.s;

public final class c extends s {
    public boolean xfJ;

    @Override // com.tencent.mm.ui.tools.s
    public final boolean biK() {
        return this.xfJ;
    }

    @Override // com.tencent.mm.ui.tools.s
    public final void a(FragmentActivity fragmentActivity, Menu menu) {
        AppMethodBeat.i(112329);
        if (fragmentActivity == null) {
            Log.w("MicroMsg.FTSVoiceSearchViewHelper", "on add search menu, activity is null");
            AppMethodBeat.o(112329);
            return;
        }
        if (this.Qwh == null) {
            this.Qwh = new FTSActionBarSearchView(fragmentActivity);
        }
        super.a(fragmentActivity, menu);
        AppMethodBeat.o(112329);
    }

    public final void setCursorVisible(boolean z) {
        AppMethodBeat.i(112330);
        ((FTSActionBarSearchView) this.Qwh).setCursorVisible(z);
        AppMethodBeat.o(112330);
    }

    @Override // com.tencent.mm.ui.tools.s
    public final void setSearchContent(String str) {
        AppMethodBeat.i(112331);
        try {
            super.setSearchContent(str);
            AppMethodBeat.o(112331);
        } catch (Exception e2) {
            Log.e("MicroMsg.FTSVoiceSearchViewHelper", "setSearchContent exception: " + e2.getMessage());
            AppMethodBeat.o(112331);
        }
    }
}
