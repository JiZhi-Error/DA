package com.tencent.mm.plugin.qqmail;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.qqmail.d.a;
import com.tencent.mm.plugin.qqmail.d.aa;
import com.tencent.mm.plugin.qqmail.d.ab;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.y;
import java.io.IOException;

public class PluginQQMail extends f implements c, k {
    private v BqU;
    private ab BqV;
    private a BqW = new a();

    public PluginQQMail() {
        AppMethodBeat.i(122630);
        AppMethodBeat.o(122630);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(122631);
        if (gVar.aBb()) {
            y.at("mailapp", "mailapp", 3);
        }
        AppMethodBeat.o(122631);
    }

    @Override // com.tencent.mm.plugin.qqmail.d.k
    public v getNormalMailAppService() {
        AppMethodBeat.i(122632);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.BqU == null) {
            this.BqU = new v();
        }
        v vVar = this.BqU;
        AppMethodBeat.o(122632);
        return vVar;
    }

    @Override // com.tencent.mm.plugin.qqmail.d.k
    public ab getShareModeMailAppService() {
        AppMethodBeat.i(122633);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.BqV == null) {
            this.BqV = new ab();
        }
        ab abVar = this.BqV;
        AppMethodBeat.o(122633);
        return abVar;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(122634);
        EventCenter.instance.addListener(this.BqW);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.qqmail.PluginQQMail.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(122629);
                if (!com.tencent.mm.kernel.g.aAc()) {
                    AppMethodBeat.o(122629);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                aa aaVar = new aa();
                if (aaVar.Bsj.zns.size() > 0) {
                    for (int i2 = 0; i2 < aaVar.Bsj.zns.size(); i2++) {
                        String str = aaVar.Bsj.zns.get(i2).Bru;
                        ca caVar = new ca();
                        caVar.Cy("qqmail");
                        caVar.setCreateTime(bp.Kw("qqmail"));
                        caVar.nv(0);
                        caVar.setContent(String.format(MMApplicationContext.getContext().getString(R.string.gk1), str));
                        caVar.setType(1);
                        caVar.setStatus(3);
                        Log.d("MicroMsg.ShareMailInfoMgr", "send mail fail, publish fail message, id: %d", Long.valueOf(((l) com.tencent.mm.kernel.g.af(l.class)).eiy().aC(caVar)));
                    }
                    aaVar.Bsj.zns.clear();
                    try {
                        String encodeToString = Base64.encodeToString(aaVar.Bsj.toByteArray(), 0);
                        Log.d("MicroMsg.ShareMailInfoMgr", "save %s", encodeToString);
                        com.tencent.mm.kernel.g.aAh().azQ().set(282625, encodeToString);
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.ShareMailInfoMgr", e2, "", new Object[0]);
                        Log.w("MicroMsg.ShareMailInfoMgr", "save to config fail");
                    }
                }
                Log.i("SubCoreQQMail", "summeranrt onAccountPostReset notifyAllFail take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(122629);
            }
        });
        AppMethodBeat.o(122634);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(122635);
        v vVar = this.BqU;
        if (vVar != null) {
            vVar.reset();
        }
        EventCenter.instance.removeListener(this.BqW);
        AppMethodBeat.o(122635);
    }
}
