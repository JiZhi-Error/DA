package com.tencent.mm.plugin.wear.model.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a {
    public static void aK(Bundle bundle) {
        AppMethodBeat.i(30050);
        Intent intent = new Intent();
        intent.setPackage(MMApplicationContext.getContext().getPackageName());
        intent.setAction("com.tencent.mm.wear.message");
        intent.putExtras(bundle);
        MMApplicationContext.getContext().sendBroadcast(intent);
        AppMethodBeat.o(30050);
    }
}
