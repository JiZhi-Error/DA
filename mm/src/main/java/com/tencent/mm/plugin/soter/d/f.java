package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.df;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends IListener<df> {
    private static String TAG = "MicroMsg.SoterDynamicConfigUpdatedEventListener";

    public f() {
        AppMethodBeat.i(161756);
        this.__eventId = df.class.getName().hashCode();
        AppMethodBeat.o(161756);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(df dfVar) {
        AppMethodBeat.i(130843);
        Log.i(TAG, "alvinluo dynamic config updated.");
        m.flO();
        AppMethodBeat.o(130843);
        return true;
    }
}
