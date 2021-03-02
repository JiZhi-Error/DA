package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class NoSpaceProfile extends d {
    public static final String dkO = (MMApplicationContext.getPackageName() + ":nospace");

    static {
        AppMethodBeat.i(19462);
        AppMethodBeat.o(19462);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onCreate() {
        AppMethodBeat.i(19461);
        LocaleUtil.initLanguage(MMApplicationContext.getContext());
        ab.WH();
        AppMethodBeat.o(19461);
    }

    @Override // com.tencent.mm.compatible.loader.d
    public final void onConfigurationChanged(Configuration configuration) {
    }
}
