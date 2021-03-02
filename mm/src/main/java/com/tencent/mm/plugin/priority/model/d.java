package com.tencent.mm.plugin.priority.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class d {
    public List<Object> AYo = new LinkedList();
    public a AYp = new a("Priority.PriorityTaskRunner");

    public d() {
        AppMethodBeat.i(87812);
        AppMethodBeat.o(87812);
    }

    public class a extends MMHandler {
        a(String str) {
            super(str);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(87811);
            try {
                switch (message.what) {
                    case 0:
                        Log.v("MicroMsg.Priority.PriorityTaskRunner", "priority runner tick");
                        d dVar = d.this;
                        if (dVar.AYp != null) {
                            dVar.AYp.removeMessages(0);
                        }
                        d.this.HJ(120000);
                        com.tencent.mm.plugin.priority.model.a.c.a c2CImgAutoDownloader = ((PluginPriority) g.ah(PluginPriority.class)).getC2CImgAutoDownloader();
                        if (c2CImgAutoDownloader.AYM != 0) {
                            com.tencent.mm.av.g H = q.bcR().H(c2CImgAutoDownloader.talker, c2CImgAutoDownloader.AYM);
                            z = q.bcS().a(H.localId, c2CImgAutoDownloader.AYM, H.iXp);
                        } else {
                            z = false;
                        }
                        if (!z) {
                            ((PluginPriority) g.ah(PluginPriority.class)).getC2CImgAutoDownloader();
                            if (com.tencent.mm.plugin.priority.model.a.c.a.eCY()) {
                                ((PluginPriority) g.ah(PluginPriority.class)).getC2CImgAutoDownloader().start();
                            }
                        }
                        if (!Util.isNullOrNil(((PluginPriority) g.ah(PluginPriority.class)).getC2CFileAutoDownloader().AYB)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            ((PluginPriority) g.ah(PluginPriority.class)).getC2CFileAutoDownloader();
                            if (com.tencent.mm.plugin.priority.model.a.b.a.eCR()) {
                                ((PluginPriority) g.ah(PluginPriority.class)).getC2CFileAutoDownloader().start();
                            }
                        }
                        if (c.eDa()) {
                            d.this.a(new c());
                            AppMethodBeat.o(87811);
                            return;
                        }
                        break;
                    case 1:
                        long currentTimeMillis = System.currentTimeMillis();
                        com.tencent.mm.plugin.priority.model.b.a aVar = (com.tencent.mm.plugin.priority.model.b.a) message.obj;
                        try {
                            aVar.run();
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", e2, "MESSAGE_ONCE_RUN_TASK %s", aVar.getName());
                        }
                        Log.i("MicroMsg.Priority.PriorityTaskRunner", "Once Run Task %s Use Time %d", aVar.getName(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        break;
                }
                AppMethodBeat.o(87811);
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", e3, "handle priority msg", new Object[0]);
                AppMethodBeat.o(87811);
            }
        }
    }

    public final void HJ(long j2) {
        AppMethodBeat.i(87813);
        if (this.AYp != null) {
            if (j2 == 0) {
                this.AYp.sendEmptyMessage(0);
                AppMethodBeat.o(87813);
                return;
            }
            this.AYp.sendEmptyMessageDelayed(0, j2);
        }
        AppMethodBeat.o(87813);
    }

    public final void a(com.tencent.mm.plugin.priority.model.b.a aVar) {
        AppMethodBeat.i(87814);
        if (this.AYp != null) {
            this.AYp.sendMessage(this.AYp.obtainMessage(1, aVar));
        }
        AppMethodBeat.o(87814);
    }

    public final void b(com.tencent.mm.plugin.priority.model.b.a aVar) {
        AppMethodBeat.i(87815);
        if (this.AYp != null) {
            this.AYp.sendMessageDelayed(this.AYp.obtainMessage(1, aVar), 1000);
        }
        AppMethodBeat.o(87815);
    }
}
