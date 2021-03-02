package com.tencent.mm.plugin.soter.e;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.c.b;
import com.tencent.soter.a.g.e;
import com.tencent.soter.a.g.j;

public final class f extends j {
    public f(Context context, e eVar) {
        super(context, eVar);
    }

    @Override // com.tencent.soter.a.g.j
    @SuppressLint({"DefaultLocale"})
    public final void f(String str, int[] iArr) {
        AppMethodBeat.i(130887);
        Log.v("MicroMsg.SoterTaskInitForWX", "alvinluo generateAuthKeyNames");
        for (int i2 : iArr) {
            String aay = m.aay(i2);
            Log.i("MicroMsg.SoterTaskInitForWX", "alvinluo scene: %d, authKeyName: %s", Integer.valueOf(i2), aay);
            b.hlG().hlI().put(i2, aay);
        }
        AppMethodBeat.o(130887);
    }
}
