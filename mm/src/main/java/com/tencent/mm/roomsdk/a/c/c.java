package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.h;

public final class c extends a {
    public k.b NDQ;
    boolean NDR = false;
    j.a NDS = new j.a() {
        /* class com.tencent.mm.roomsdk.a.c.c.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.a.j.a
        public final void F(int i2, String str, String str2) {
            AppMethodBeat.i(152781);
            ((l) g.af(l.class)).aSM().b(c.this.NDQ.getCmdId(), c.this.NDS);
            if (c.this.NDR) {
                AppMethodBeat.o(152781);
                return;
            }
            c.this.NDR = true;
            if (c.this.NDO != null) {
                if (c.this.NDO instanceof e) {
                    e eVar = (e) c.this.NDO;
                    eVar.ret = i2;
                    eVar.title = str;
                    eVar.content = str2;
                }
                c.this.NDO.a(0, i2, "", c.this.NDO);
            }
            if (c.this.tipDialog != null) {
                c.this.tipDialog.dismiss();
            }
            AppMethodBeat.o(152781);
        }
    };
    IListener gyj = new IListener<pd>() {
        /* class com.tencent.mm.roomsdk.a.c.c.AnonymousClass1 */

        {
            AppMethodBeat.i(161795);
            this.__eventId = pd.class.getName().hashCode();
            AppMethodBeat.o(161795);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pd pdVar) {
            AppMethodBeat.i(152780);
            final pd pdVar2 = pdVar;
            c.this.gyj.dead();
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.roomsdk.a.c.c.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(152779);
                    if (c.this.NDR) {
                        AppMethodBeat.o(152779);
                        return;
                    }
                    c.this.NDR = true;
                    String str = pdVar2.dVh.dVi;
                    String str2 = pdVar2.dVh.dVj;
                    int i2 = pdVar2.dVh.ret;
                    if (c.this.NDO != null) {
                        if (c.this.NDO instanceof e) {
                            e eVar = (e) c.this.NDO;
                            eVar.title = str;
                            eVar.ret = i2;
                            eVar.content = str2;
                        }
                        c.this.NDO.a(0, i2, "", c.this.NDO);
                    }
                    if (c.this.tipDialog != null) {
                        c.this.tipDialog.dismiss();
                    }
                    AppMethodBeat.o(152779);
                }
            });
            AppMethodBeat.o(152780);
            return false;
        }
    };

    public c(boolean z) {
        AppMethodBeat.i(152782);
        this.NDL = z;
        AppMethodBeat.o(152782);
    }

    @Override // com.tencent.mm.roomsdk.a.c.a
    public final void cancel() {
        AppMethodBeat.i(152783);
        ((l) g.af(l.class)).aSM().e(this.NDQ);
        ((l) g.af(l.class)).aSM().b(this.NDQ.getCmdId(), this.NDS);
        this.gyj.dead();
        AppMethodBeat.o(152783);
    }

    @Override // com.tencent.mm.roomsdk.a.c.a
    public final void aJu() {
        AppMethodBeat.i(152784);
        Log.i("MicroMsg.RoomCallbackFactory", "request oplog %s", this.NDQ);
        if (!(this.NDM == null && this.NDN == null && this.NDO == null)) {
            this.gyj.alive();
            ((l) g.af(l.class)).aSM().a(this.NDQ.getCmdId(), this.NDS);
        }
        ((l) g.af(l.class)).aSM().d(this.NDQ);
        AppMethodBeat.o(152784);
    }

    @Override // com.tencent.mm.roomsdk.a.c.a
    public final void a(Context context, String str, String str2, boolean z, boolean z2, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(223897);
        this.tipDialog = h.a(context, str2, z2, onCancelListener);
        aJu();
        AppMethodBeat.o(223897);
    }
}
