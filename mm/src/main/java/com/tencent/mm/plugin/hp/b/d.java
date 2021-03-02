package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.ag;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.g.a.df;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.hp.tinker.h;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tinkerboots.sdk.a;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class d implements bd {
    private final IListener<bk> rdQ = new IListener<bk>() {
        /* class com.tencent.mm.plugin.hp.b.d.AnonymousClass1 */

        {
            AppMethodBeat.i(161181);
            this.__eventId = bk.class.getName().hashCode();
            AppMethodBeat.o(161181);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bk bkVar) {
            AppMethodBeat.i(117415);
            bk bkVar2 = bkVar;
            if (d.this.ymy) {
                String string = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_patch_msg_key", "");
                String string2 = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_patch_version_key", "");
                Log.i("Tinker.SubCoreHotpatch", "v1:%s, v2:%s, wording:%s", String.format("0x%08X", Integer.valueOf(com.tencent.mm.protocal.d.KyO)), string2, string);
                if (!Util.isNullOrNil(string)) {
                    if (String.format("0x%08X", Integer.valueOf(com.tencent.mm.protocal.d.KyO)).equalsIgnoreCase(string2)) {
                        bkVar2.dEE.dEF = true;
                        bkVar2.dEE.msg = string;
                        a.OO(2);
                        h.aX(MMApplicationContext.getContext(), "");
                        h.aW(MMApplicationContext.getContext(), "");
                    }
                }
                d.this.ymy = false;
            }
            AppMethodBeat.o(117415);
            return false;
        }
    };
    private final IListener<df> ymA = new IListener<df>() {
        /* class com.tencent.mm.plugin.hp.b.d.AnonymousClass2 */

        {
            AppMethodBeat.i(161182);
            this.__eventId = df.class.getName().hashCode();
            AppMethodBeat.o(161182);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(df dfVar) {
            AppMethodBeat.i(117416);
            h.gn(MMApplicationContext.getContext());
            a.hvX().atk(h.go(MMApplicationContext.getContext()));
            AppMethodBeat.o(117416);
            return false;
        }
    };
    private final f ymB = new f();
    private final IListener<bt> ymC = new IListener<bt>() {
        /* class com.tencent.mm.plugin.hp.b.d.AnonymousClass3 */

        {
            AppMethodBeat.i(161183);
            this.__eventId = bt.class.getName().hashCode();
            AppMethodBeat.o(161183);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bt btVar) {
            AppMethodBeat.i(117417);
            if (btVar.dEW.type == 0) {
                g.azz().a(new com.tencent.mm.plugin.hp.net.d(), 0);
            }
            AppMethodBeat.o(117417);
            return false;
        }
    };
    private boolean ymy = true;
    private final h ymz = new h();

    public d() {
        AppMethodBeat.i(117418);
        AppMethodBeat.o(117418);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(117419);
        this.ymy = z;
        b.a(new g(), "//tinker");
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("prconfignotify", (cj.a) this.ymz, true);
        EventCenter.instance.addListener(this.rdQ);
        this.ymA.alive();
        EventCenter.instance.addListener(this.ymB);
        EventCenter.instance.addListener(this.ymC);
        Log.d("Tinker.SubCoreHotpatch", "onAccountPostReset");
        com.tencent.mm.plugin.hp.tinker.h.gn(MMApplicationContext.getContext());
        try {
            long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, (Object) 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue >= Util.MILLSECONDS_OF_HOUR) {
                int i2 = Calendar.getInstance().get(11);
                Log.i("Tinker.SubCoreHotpatch", "try to fetch patch update hour %d ", Integer.valueOf(i2));
                if (i2 == 0) {
                    int nextInt = new Random().nextInt(60);
                    currentTimeMillis = (currentTimeMillis - (((long) com.tencent.mm.plugin.hp.tinker.h.go(MMApplicationContext.getContext())) * Util.MILLSECONDS_OF_HOUR)) + (((long) nextInt) * Util.MILLSECONDS_OF_MINUTE);
                    g.aAh().azQ().set(ar.a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
                    Log.i("Tinker.SubCoreHotpatch", "try to fetch patch update after %d minute currentTime %s lastUpdate %s", Integer.valueOf(nextInt), Long.valueOf(currentTimeMillis), Long.valueOf(longValue));
                } else {
                    a.hvX().Ey(true);
                    g.aAh().azQ().set(ar.a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
                    Log.i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(longValue));
                }
            } else {
                a.hvX().Ey(z);
                Log.i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
            }
            f.GQ(currentTimeMillis);
        } catch (Exception e2) {
            Log.printErrStackTrace("Tinker.SubCoreHotpatch", e2, "", new Object[0]);
        }
        if (!MMApplicationContext.isToolsIsolatedProcess()) {
            ag.a.dmC.WR();
        }
        AppMethodBeat.o(117419);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(117420);
        b.V("//tinker");
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("prconfignotify", this.ymz, true);
        EventCenter.instance.removeListener(this.rdQ);
        this.ymA.dead();
        EventCenter.instance.removeListener(this.ymB);
        EventCenter.instance.removeListener(this.ymC);
        Log.d("Tinker.SubCoreHotpatch", "onAccountRelease");
        AppMethodBeat.o(117420);
    }
}
