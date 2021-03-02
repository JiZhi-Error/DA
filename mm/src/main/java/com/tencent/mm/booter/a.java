package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.model.an;
import com.tencent.mm.model.ao;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import java.util.ArrayList;
import java.util.List;

public class a implements an {
    private static volatile a gkY;
    private List<ao> callbacks = new ArrayList();
    private PhoneStatusWatcher gkW = new PhoneStatusWatcher();
    private PhoneStatusWatcher.PhoneCallListener gkX = new PhoneStatusWatcher.PhoneCallListener() {
        /* class com.tencent.mm.booter.a.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener
        public final void onPhoneCall(int i2) {
            AppMethodBeat.i(149953);
            switch (i2) {
                case 0:
                    Log.v("MicroMsg.BackgroundPlayer", "call end");
                    a.this.akq();
                    AppMethodBeat.o(149953);
                    return;
                case 1:
                case 2:
                    Log.v("MicroMsg.BackgroundPlayer", "call start");
                    a.this.akr();
                    break;
            }
            AppMethodBeat.o(149953);
        }
    };
    private IListener gkZ;

    private a() {
        AppMethodBeat.i(149955);
        this.gkW.addPhoneCallListener(this.gkX);
        this.gkW.begin(MMApplicationContext.getContext());
        if (this.gkZ == null) {
            this.gkZ = new IListener<rd>() {
                /* class com.tencent.mm.booter.a.AnonymousClass2 */

                {
                    AppMethodBeat.i(161769);
                    this.__eventId = rd.class.getName().hashCode();
                    AppMethodBeat.o(161769);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(rd rdVar) {
                    AppMethodBeat.i(149954);
                    switch (rdVar.dXT.state) {
                        case 0:
                            Log.d("MicroMsg.BackgroundPlayer", "jacks record resume event");
                            a.this.akr();
                            break;
                        case 1:
                            Log.d("MicroMsg.BackgroundPlayer", "jacks record pause event");
                            a.this.akq();
                            break;
                    }
                    AppMethodBeat.o(149954);
                    return false;
                }
            };
        }
        EventCenter.instance.addListener(this.gkZ);
        AppMethodBeat.o(149955);
    }

    public static a akp() {
        AppMethodBeat.i(149956);
        if (gkY == null) {
            synchronized (a.class) {
                try {
                    if (gkY == null) {
                        gkY = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(149956);
                    throw th;
                }
            }
        }
        a aVar = gkY;
        AppMethodBeat.o(149956);
        return aVar;
    }

    @Override // com.tencent.mm.model.an
    public final void a(ao aoVar) {
        AppMethodBeat.i(149957);
        Log.d("MicroMsg.BackgroundPlayer", "add callback : %s", aoVar.toString());
        this.callbacks.add(aoVar);
        AppMethodBeat.o(149957);
    }

    @Override // com.tencent.mm.model.an
    public final void b(ao aoVar) {
        AppMethodBeat.i(149958);
        this.callbacks.remove(aoVar);
        AppMethodBeat.o(149958);
    }

    @Override // com.tencent.mm.model.an
    public final void akq() {
        AppMethodBeat.i(149959);
        if (this.callbacks == null) {
            AppMethodBeat.o(149959);
            return;
        }
        for (ao aoVar : this.callbacks) {
            aoVar.aVl();
        }
        AppMethodBeat.o(149959);
    }

    @Override // com.tencent.mm.model.an
    public final void akr() {
        AppMethodBeat.i(149960);
        if (this.callbacks == null) {
            AppMethodBeat.o(149960);
            return;
        }
        for (ao aoVar : this.callbacks) {
            aoVar.aVm();
        }
        AppMethodBeat.o(149960);
    }
}
