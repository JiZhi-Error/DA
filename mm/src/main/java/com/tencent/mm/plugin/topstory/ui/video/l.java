package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.topstory.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tinkerboots.sdk.b.a;

public final class l {
    public int CTg = fiw();
    public boolean Gnu = false;
    c Gnv;
    private p.a qmF = new p.a() {
        /* class com.tencent.mm.plugin.topstory.ui.video.l.AnonymousClass1 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(126107);
            final int i3 = l.this.CTg;
            l.this.CTg = l.fiw();
            if (l.this.CTg != i3) {
                Log.i("MicroMsg.TopStory.TopStoryNetworkMgr", "network change current:%d change:%d", Integer.valueOf(i3), Integer.valueOf(l.this.CTg));
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.topstory.ui.video.l.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(126106);
                        if (l.this.Gnv != null) {
                            l.this.Gnv.jm(i3, l.this.CTg);
                        }
                        AppMethodBeat.o(126106);
                    }
                });
            }
            AppMethodBeat.o(126107);
        }
    };

    public l() {
        AppMethodBeat.i(126108);
        g.aAg().a(this.qmF);
        AppMethodBeat.o(126108);
    }

    public final void onUIDestroy() {
        AppMethodBeat.i(126109);
        g.aAg().b(this.qmF);
        this.Gnv = null;
        this.CTg = 0;
        this.Gnu = false;
        AppMethodBeat.o(126109);
    }

    public final boolean cGF() {
        return this.CTg == 1;
    }

    public final boolean fzw() {
        return this.CTg == 2;
    }

    public final boolean isConnected() {
        return this.CTg != 0;
    }

    public static int fiw() {
        AppMethodBeat.i(126110);
        if (!a.isConnected(MMApplicationContext.getContext())) {
            AppMethodBeat.o(126110);
            return 0;
        } else if (a.isWifi(MMApplicationContext.getContext())) {
            AppMethodBeat.o(126110);
            return 1;
        } else {
            AppMethodBeat.o(126110);
            return 2;
        }
    }
}
