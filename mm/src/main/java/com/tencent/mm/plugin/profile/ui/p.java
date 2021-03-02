package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference;

/* access modifiers changed from: package-private */
public final class p implements HelperHeaderPreference.a {
    private final Context context;

    public p(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a
    public final CharSequence getHint() {
        AppMethodBeat.i(27226);
        String string = this.context.getString(R.string.bbg);
        AppMethodBeat.o(27226);
        return string;
    }

    @Override // com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a
    public final void a(HelperHeaderPreference helperHeaderPreference) {
        AppMethodBeat.i(27227);
        helperHeaderPreference.sK(true);
        AppMethodBeat.o(27227);
    }
}
