package com.tencent.mm.plugin.performance.diagnostic;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.performance.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class b {
    private static final String ASB;
    private static final IListener<fp> ASC = new IListener<fp>() {
        /* class com.tencent.mm.plugin.performance.diagnostic.b.AnonymousClass1 */

        {
            AppMethodBeat.i(201027);
            this.__eventId = fp.class.getName().hashCode();
            AppMethodBeat.o(201027);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fp fpVar) {
            AppMethodBeat.i(201028);
            Log.i("MicroMsg.DiagnosticPush", "expt changed");
            String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_diagnostic_expt_push_cmd, "");
            if (TextUtils.isEmpty(a2)) {
                Log.e("MicroMsg.DiagnosticPush", "empty push command");
                AppMethodBeat.o(201028);
            } else {
                Map<String, String> parseXml = XmlParser.parseXml(a2, "cmd", null);
                if (parseXml == null) {
                    Log.e("MicroMsg.DiagnosticPush", "invalid push command: %s", a2);
                    AppMethodBeat.o(201028);
                } else {
                    String str = parseXml.get(b.ASB);
                    String decodeString = b.cQe.decodeString(b.ASB, "");
                    if (TextUtils.isEmpty(str) || decodeString.equalsIgnoreCase(str)) {
                        Log.i("MicroMsg.DiagnosticPush", "ignore command, seq = %s, lastSeq = %s", str, decodeString);
                        AppMethodBeat.o(201028);
                    } else {
                        Log.i("MicroMsg.DiagnosticPush", "valid push cmd: %s", a2);
                        b.cQe.encode(b.ASB, str);
                        a.INSTANCE.aA(parseXml);
                        AppMethodBeat.o(201028);
                    }
                }
            }
            return false;
        }
    };
    private static final MultiProcessMMKV cQe = MultiProcessMMKV.getMMKV("diagnostic_storage");

    static {
        AppMethodBeat.i(201030);
        StringBuilder sb = new StringBuilder();
        a aVar = a.INSTANCE;
        ASB = sb.append(a.eBC()).append(".$token").toString();
        AppMethodBeat.o(201030);
    }

    public static void alive() {
        AppMethodBeat.i(201029);
        if (!MMApplicationContext.isMainProcess()) {
            AppMethodBeat.o(201029);
            return;
        }
        ASC.alive();
        AppMethodBeat.o(201029);
    }
}
