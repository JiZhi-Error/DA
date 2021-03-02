package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference;

/* access modifiers changed from: package-private */
public final class r implements HelperHeaderPreference.a {
    private Context context;

    public r(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a
    public final CharSequence getHint() {
        AppMethodBeat.i(27230);
        String string = this.context.getString(R.string.bb_);
        AppMethodBeat.o(27230);
        return string;
    }

    @Override // com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a
    public final void a(HelperHeaderPreference helperHeaderPreference) {
        AppMethodBeat.i(27231);
        helperHeaderPreference.sK((z.aUl() & 32768) == 0);
        AppMethodBeat.o(27231);
    }
}
