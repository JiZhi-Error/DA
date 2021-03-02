package com.tencent.mm.plugin.topstory.ui.home;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public final class c extends b {
    public c(MMActivity mMActivity) {
        super(mMActivity, true);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.home.b
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(126036);
        super.onCreate(bundle);
        AppMethodBeat.o(126036);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.topstory.ui.home.b
    public final boolean fyp() {
        return false;
    }
}
