package com.tencent.mm.plugin.newtips;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public class PluginNewTips extends f implements c {
    private static HashMap<String, a> ACU = new HashMap<>();
    private IListener<ny> ACV = new IListener<ny>() {
        /* class com.tencent.mm.plugin.newtips.PluginNewTips.AnonymousClass1 */

        {
            AppMethodBeat.i(184020);
            this.__eventId = ny.class.getName().hashCode();
            AppMethodBeat.o(184020);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ny nyVar) {
            AppMethodBeat.i(184021);
            ny nyVar2 = nyVar;
            if (nyVar2 != null && !Util.isNullOrNil(nyVar2.dUa.dUb)) {
                Log.i("MicroMsg.NewTips.PluginNewTips", "NotifyPushNewTipsEvent %s", nyVar2.dUa.dUb);
                a aVar = (a) PluginNewTips.ACU.get(nyVar2.dUa.dUb);
                if (aVar != null) {
                    aVar.exp();
                }
            }
            AppMethodBeat.o(184021);
            return true;
        }
    };

    public interface a {
        void exp();
    }

    public PluginNewTips() {
        AppMethodBeat.i(184022);
        AppMethodBeat.o(184022);
    }

    static {
        AppMethodBeat.i(184027);
        AppMethodBeat.o(184027);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(127208);
        if (gVar.aBb()) {
            pin(a.exj());
        }
        AppMethodBeat.o(127208);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(184023);
        this.ACV.alive();
        AppMethodBeat.o(184023);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(184024);
        this.ACV.dead();
        AppMethodBeat.o(184024);
    }

    public static void addLocalNewTipsCallback(String str, a aVar) {
        AppMethodBeat.i(184025);
        ACU.put(str, aVar);
        AppMethodBeat.o(184025);
    }

    public static void removeLocalNewTipsCallback(String str) {
        AppMethodBeat.i(184026);
        ACU.remove(str);
        AppMethodBeat.o(184026);
    }
}
