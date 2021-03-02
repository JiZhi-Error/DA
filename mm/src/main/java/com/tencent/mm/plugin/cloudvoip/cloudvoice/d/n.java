package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public enum n {
    INSTANCE;

    public static n valueOf(String str) {
        AppMethodBeat.i(90846);
        n nVar = (n) Enum.valueOf(n.class, str);
        AppMethodBeat.o(90846);
        return nVar;
    }

    static {
        AppMethodBeat.i(90849);
        AppMethodBeat.o(90849);
    }

    /* access modifiers changed from: package-private */
    public final void EX(int i2) {
        AppMethodBeat.i(90847);
        final String processName = MMApplicationContext.getProcessName();
        Log.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: %s operate network change: %d", processName, Integer.valueOf(i2));
        Bundle bundle = new Bundle();
        bundle.putString("from_process", processName);
        bundle.putInt("opcode", i2);
        h.a(MainProcessIPCService.dkO, bundle, a.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.n.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                AppMethodBeat.i(90839);
                Log.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: %s invokeAsync result: %s", processName, bundle.toString());
                AppMethodBeat.o(90839);
            }
        });
        AppMethodBeat.o(90847);
    }

    /* access modifiers changed from: package-private */
    public static class a implements b<Bundle, Bundle> {
        private static String qsG;
        private static final p qsH = new p.a() {
            /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.n.a.AnonymousClass1 */

            @Override // com.tencent.mm.network.p
            public final void onNetworkChange(int i2) {
                AppMethodBeat.i(90841);
                String formatedNetType = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
                final String processName = MMApplicationContext.getProcessName();
                Log.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: %s on network changed: %d, changed to %s, %s", processName, Integer.valueOf(i2), formatedNetType, a.qsG);
                Bundle bundle = new Bundle();
                bundle.putString("from_process", processName);
                bundle.putInt("newState", i2);
                h.a(a.qsG, bundle, C0928a.class, new d<Bundle>() {
                    /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.n.a.AnonymousClass1.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.ipcinvoker.d
                    public final /* synthetic */ void bn(Bundle bundle) {
                        AppMethodBeat.i(90840);
                        Log.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: %s invokeAsync result: %s", processName, bundle.toString());
                        AppMethodBeat.o(90840);
                    }
                });
                AppMethodBeat.o(90841);
            }
        };

        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(90843);
            Bundle bundle2 = bundle;
            int i2 = 0;
            String str = "success";
            String string = bundle2.getString("from_process", "");
            qsG = string;
            if (Util.isNullOrNil(string) || !qsG.startsWith("com.tencent.mm")) {
                str = "invalid package name " + qsG;
                i2 = -1;
            } else {
                int i3 = bundle2.getInt("opcode", -1);
                if (i3 == 0) {
                    g.aAg().a(qsH);
                } else if (i3 == 1) {
                    g.aAg().b(qsH);
                } else {
                    i2 = -2;
                    str = "not valid op code";
                }
            }
            if (dVar != null) {
                Bundle bundle3 = new Bundle();
                bundle3.putInt("err_code", i2);
                bundle3.putString("err_desc", str);
                dVar.bn(bundle3);
            }
            AppMethodBeat.o(90843);
        }

        static {
            AppMethodBeat.i(90844);
            AppMethodBeat.o(90844);
        }

        /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.n$a$a  reason: collision with other inner class name */
        static class C0928a implements b<Bundle, Bundle> {
            private C0928a() {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
            @Override // com.tencent.mm.ipcinvoker.b
            public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
                AppMethodBeat.i(90842);
                int i2 = bundle.getInt("newState", 0);
                n nVar = n.INSTANCE;
                n.EY(i2);
                if (dVar != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("err_code", 0);
                    bundle2.putString("err_desc", "success");
                    dVar.bn(bundle2);
                }
                AppMethodBeat.o(90842);
            }
        }
    }

    static /* synthetic */ void EY(int i2) {
        AppMethodBeat.i(90848);
        String formatedNetType = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
        Log.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: %s on network changed: %d (%s)", MMApplicationContext.getProcessName(), Integer.valueOf(i2), formatedNetType);
        if ("NON_NETWORK".equals(formatedNetType)) {
            q qVar = q.INSTANCE;
            q.EZ(0);
            AppMethodBeat.o(90848);
        } else if ("2G".equals(formatedNetType)) {
            q qVar2 = q.INSTANCE;
            q.EZ(1);
            AppMethodBeat.o(90848);
        } else if ("3G".equals(formatedNetType)) {
            q qVar3 = q.INSTANCE;
            q.EZ(3);
            AppMethodBeat.o(90848);
        } else if ("WIFI".equals(formatedNetType)) {
            q qVar4 = q.INSTANCE;
            q.EZ(4);
            AppMethodBeat.o(90848);
        } else {
            if ("4G".equals(formatedNetType)) {
                q qVar5 = q.INSTANCE;
                q.EZ(5);
            }
            AppMethodBeat.o(90848);
        }
    }
}
