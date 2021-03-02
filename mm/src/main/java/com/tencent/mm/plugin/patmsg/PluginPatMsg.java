package com.tencent.mm.plugin.patmsg;

import android.util.Pair;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.patmsg.a.b;
import com.tencent.mm.plugin.patmsg.a.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PluginPatMsg extends f implements c, e {
    private a ARg = new a();
    private Map<String, com.tencent.mm.plugin.patmsg.a.f> ARh = new HashMap();
    private b ARi = null;
    LinkedList<czi> ARj = null;

    public PluginPatMsg() {
        AppMethodBeat.i(206947);
        AppMethodBeat.o(206947);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(206948);
        com.tencent.mm.kernel.g.b(b.class, this.ARg);
        com.tencent.mm.kernel.g.azz().a(849, this.ARg);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("pat", this.ARg.ARa);
        if (cVar.hrc) {
            com.tencent.mm.vfs.s.dy(com.tencent.mm.kernel.g.aAh().hqG + "patmsg/", true);
        }
        this.ARi = new b(((PluginPatMsg) com.tencent.mm.kernel.g.ah(PluginPatMsg.class)).getAccPatMsgPath() + "pat_recv_record");
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.patmsg.PluginPatMsg.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(206945);
                PluginPatMsg.this.ARj = PluginPatMsg.this.ARi.blq();
                if (PluginPatMsg.this.ARj == null) {
                    PluginPatMsg.this.ARj = new LinkedList<>();
                }
                AppMethodBeat.o(206945);
            }
        });
        AppMethodBeat.o(206948);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(206949);
        com.tencent.mm.kernel.g.ag(b.class);
        com.tencent.mm.kernel.g.azz().b(849, this.ARg);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("pat", this.ARg.ARa);
        AppMethodBeat.o(206949);
    }

    public void playPatAnimation(View view) {
        AppMethodBeat.i(206950);
        view.startAnimation(AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.a0));
        AppMethodBeat.o(206950);
    }

    public void playRevokePatAnimation(View view, boolean z) {
        AppMethodBeat.i(206951);
        if (z) {
            view.startAnimation(AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.x));
            AppMethodBeat.o(206951);
            return;
        }
        view.startAnimation(AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.anim.w));
        AppMethodBeat.o(206951);
    }

    public boolean isPatEnable() {
        AppMethodBeat.i(206952);
        int i2 = ((a) com.tencent.mm.kernel.g.af(a.class)).aqJ().getInt("DisableSendPat", 1);
        Log.i("MicroMsg.PluginPatMsg", "disable sendPat %d", Integer.valueOf(i2));
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG) {
            AppMethodBeat.o(206952);
            return true;
        } else if (i2 == 0) {
            AppMethodBeat.o(206952);
            return true;
        } else {
            AppMethodBeat.o(206952);
            return false;
        }
    }

    public boolean isNickClickable() {
        AppMethodBeat.i(206953);
        if (((a) com.tencent.mm.kernel.g.af(a.class)).aqJ().getInt("SendPatUserShowBitVal", 0) != 0) {
            AppMethodBeat.o(206953);
            return true;
        }
        AppMethodBeat.o(206953);
        return false;
    }

    public boolean isRevokePatMsgEnable() {
        AppMethodBeat.i(206954);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_revoke_pat_msg_enable, 1) == 1) {
            AppMethodBeat.o(206954);
            return true;
        }
        AppMethodBeat.o(206954);
        return false;
    }

    public com.tencent.mm.plugin.patmsg.a.f parseDisplayTemplate(String str, String str2) {
        AppMethodBeat.i(206955);
        List<h.a> aDX = com.tencent.mm.plugin.messenger.a.h.aDX(str);
        if (this.ARh.containsKey(str)) {
            Log.i("MicroMsg.PluginPatMsg", "find %s (%s) in cache", str, this.ARh.get(str));
            com.tencent.mm.plugin.patmsg.a.f fVar = this.ARh.get(str);
            AppMethodBeat.o(206955);
            return fVar;
        }
        com.tencent.mm.plugin.patmsg.a.f fVar2 = new com.tencent.mm.plugin.patmsg.a.f();
        String str3 = str;
        for (h.a aVar : aDX) {
            String displayName = aa.getDisplayName(aVar.value, str2);
            int indexOf = str3.indexOf(aVar.group);
            fVar2.ARm.add(Pair.create(Integer.valueOf(indexOf), Integer.valueOf(indexOf + displayName.length())));
            fVar2.iPH.add(aVar.value);
            str3 = str3.replace(aVar.group, displayName);
        }
        fVar2.result = str3;
        this.ARh.put(str, fVar2);
        AppMethodBeat.o(206955);
        return fVar2;
    }

    public void clearTemplate() {
        AppMethodBeat.i(206956);
        this.ARh.clear();
        AppMethodBeat.o(206956);
    }

    public String getAccPatMsgPath() {
        AppMethodBeat.i(206957);
        String str = com.tencent.mm.kernel.g.aAh().cachePath + "patmsg/";
        AppMethodBeat.o(206957);
        return str;
    }

    public void addRecvRecord(long j2, czh czh) {
        AppMethodBeat.i(206958);
        synchronized (this.ARj) {
            try {
                czi czi = new czi();
                czi.MED = j2;
                czi.MEE = czh;
                this.ARj.addFirst(czi);
            } catch (Throwable th) {
                AppMethodBeat.o(206958);
                throw th;
            }
        }
        syncRecvRecord();
        AppMethodBeat.o(206958);
    }

    public void deleteRecvRecord(long j2) {
        AppMethodBeat.i(206959);
        syncRecvRecord();
        AppMethodBeat.o(206959);
    }

    public czi getRecvRecord(long j2) {
        czi czi;
        AppMethodBeat.i(206960);
        synchronized (this.ARj) {
            try {
                Iterator<czi> it = this.ARj.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        czi = null;
                        AppMethodBeat.o(206960);
                        break;
                    }
                    czi = it.next();
                    if (czi.MEE != null && czi.MEE.oNJ == j2) {
                        break;
                    }
                }
            } finally {
                AppMethodBeat.o(206960);
            }
        }
        return czi;
    }

    private void syncRecvRecord() {
        AppMethodBeat.i(206961);
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.patmsg.PluginPatMsg.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(206946);
                if (PluginPatMsg.this.ARi != null) {
                    LinkedList linkedList = new LinkedList();
                    int i2 = 0;
                    while (i2 < 100 && i2 < PluginPatMsg.this.ARj.size()) {
                        linkedList.add(PluginPatMsg.this.ARj.get(i2));
                        i2++;
                    }
                    PluginPatMsg.this.ARi.r(linkedList);
                }
                AppMethodBeat.o(206946);
            }
        }, "sync_pat_recv_record_thread");
        AppMethodBeat.o(206961);
    }
}
