package com.tencent.mm.plugin.extqlauncher.ui;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static final Uri sPa = Uri.parse("content://com.tencent.qlauncher.provider.third_party_coop_provider/push_item");

    static {
        AppMethodBeat.i(24566);
        AppMethodBeat.o(24566);
    }
}
