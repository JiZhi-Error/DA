package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

/* access modifiers changed from: package-private */
public final class s implements HelperHeaderPreference.a {
    private Context context;

    public s(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a
    public final CharSequence getHint() {
        AppMethodBeat.i(27260);
        String string = this.context.getString(R.string.bcg);
        AppMethodBeat.o(27260);
        return string;
    }

    @Override // com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a
    public final void a(HelperHeaderPreference helperHeaderPreference) {
        boolean z;
        AppMethodBeat.i(27261);
        if ((z.aUl() & TPMediaCodecProfileLevel.HEVCMainTierLevel62) == 0) {
            z = true;
        } else {
            z = false;
        }
        helperHeaderPreference.sK(z);
        AppMethodBeat.o(27261);
    }
}
