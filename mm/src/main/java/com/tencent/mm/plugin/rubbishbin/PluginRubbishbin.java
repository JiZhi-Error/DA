package com.tencent.mm.plugin.rubbishbin;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class PluginRubbishbin extends f implements c {
    private static boolean Czn = false;
    private IListener<fp> qZd = new IListener<fp>() {
        /* class com.tencent.mm.plugin.rubbishbin.PluginRubbishbin.AnonymousClass1 */

        {
            AppMethodBeat.i(161663);
            this.__eventId = fp.class.getName().hashCode();
            AppMethodBeat.o(161663);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fp fpVar) {
            AppMethodBeat.i(146669);
            Log.i("Rubbish", "[sunny]: evt chg!!!");
            if (((b) g.af(b.class)).a(b.a.clicfg_rubbishbin_enable, false)) {
                int a2 = ((b) g.af(b.class)).a(b.a.clicfg_rubbishbin_exec_time, 0);
                String a3 = ((b) g.af(b.class)).a(b.a.clicfg_rubbishbin_exec_tag, "Default");
                int a4 = ((b) g.af(b.class)).a(b.a.clicfg_rubbishbin_exec_time_interval, 1);
                Log.i("Rubbish", "[sunny]ec:%d,t:%s,itv:%d", Integer.valueOf(a2), a3, Integer.valueOf(a4));
                PluginRubbishbin.enableRubbishBin(MMApplicationContext.getContext(), a2, a4 * 1000, a3);
            }
            AppMethodBeat.o(146669);
            return false;
        }
    };

    public PluginRubbishbin() {
        AppMethodBeat.i(146670);
        AppMethodBeat.o(146670);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(146671);
        AppMethodBeat.o(146671);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
    }

    public static void enableRubbishBin(Context context, int i2, int i3, String str) {
        AppMethodBeat.i(146672);
        try {
            Intent intent = new Intent(context, RubbishBinServiceImpl.class);
            intent.putExtra("exec_time", i2);
            intent.putExtra("interval", i3);
            intent.putExtra("exec_tag", str);
            context.startService(intent);
            AppMethodBeat.o(146672);
        } catch (IllegalStateException e2) {
            AppMethodBeat.o(146672);
        } catch (Exception e3) {
            AppMethodBeat.o(146672);
        }
    }
}
