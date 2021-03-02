package com.tencent.mm.plugin.multitalk.b;

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
        AppMethodBeat.i(239093);
        n nVar = (n) Enum.valueOf(n.class, str);
        AppMethodBeat.o(239093);
        return nVar;
    }

    static {
        AppMethodBeat.i(239099);
        AppMethodBeat.o(239099);
    }

    public static int elK() {
        int i2 = 5;
        AppMethodBeat.i(239094);
        if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            i2 = 1;
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
            i2 = 3;
        } else if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            i2 = 4;
        } else if (!NetStatusUtil.is4G(MMApplicationContext.getContext()) && !NetStatusUtil.is5G(MMApplicationContext.getContext())) {
            i2 = 0;
        }
        Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: current network type is: %d", Integer.valueOf(i2));
        AppMethodBeat.o(239094);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final void cBn() {
        AppMethodBeat.i(239095);
        Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: start listen to network change");
        EX(0);
        AppMethodBeat.o(239095);
    }

    /* access modifiers changed from: package-private */
    public final void cBo() {
        AppMethodBeat.i(239096);
        Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: stop listen to network change");
        EX(1);
        AppMethodBeat.o(239096);
    }

    private void EX(int i2) {
        AppMethodBeat.i(239097);
        final String processName = MMApplicationContext.getProcessName();
        Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: %s operate network change: %d", processName, Integer.valueOf(i2));
        Bundle bundle = new Bundle();
        bundle.putString("from_process", processName);
        bundle.putInt("opcode", i2);
        h.a(MainProcessIPCService.dkO, bundle, a.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.multitalk.b.n.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                AppMethodBeat.i(239086);
                Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: %s invokeAsync result: %s", processName, bundle.toString());
                AppMethodBeat.o(239086);
            }
        });
        AppMethodBeat.o(239097);
    }

    /* access modifiers changed from: package-private */
    public static class a implements b<Bundle, Bundle> {
        private static String qsG;
        private static final p qsH = new p.a() {
            /* class com.tencent.mm.plugin.multitalk.b.n.a.AnonymousClass1 */

            @Override // com.tencent.mm.network.p
            public final void onNetworkChange(int i2) {
                AppMethodBeat.i(239088);
                String formatedNetType = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
                final String processName = MMApplicationContext.getProcessName();
                Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: %s on network changed: %d, changed to %s, %s", processName, Integer.valueOf(i2), formatedNetType, a.qsG);
                Bundle bundle = new Bundle();
                bundle.putString("from_process", processName);
                bundle.putInt("newState", i2);
                h.a(a.qsG, bundle, C1488a.class, new d<Bundle>() {
                    /* class com.tencent.mm.plugin.multitalk.b.n.a.AnonymousClass1.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.ipcinvoker.d
                    public final /* synthetic */ void bn(Bundle bundle) {
                        AppMethodBeat.i(239087);
                        Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: %s invokeAsync result: %s", processName, bundle.toString());
                        AppMethodBeat.o(239087);
                    }
                });
                AppMethodBeat.o(239088);
            }
        };

        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(239090);
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
            AppMethodBeat.o(239090);
        }

        static {
            AppMethodBeat.i(239091);
            AppMethodBeat.o(239091);
        }

        /* renamed from: com.tencent.mm.plugin.multitalk.b.n$a$a  reason: collision with other inner class name */
        static class C1488a implements b<Bundle, Bundle> {
            private C1488a() {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
            @Override // com.tencent.mm.ipcinvoker.b
            public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
                AppMethodBeat.i(239089);
                int i2 = bundle.getInt("newState", 0);
                n nVar = n.INSTANCE;
                n.Ra(i2);
                if (dVar != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("err_code", 0);
                    bundle2.putString("err_desc", "success");
                    dVar.bn(bundle2);
                }
                AppMethodBeat.o(239089);
            }
        }
    }

    static /* synthetic */ void Ra(int i2) {
        AppMethodBeat.i(239098);
        String formatedNetType = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
        Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: %s on network changed: %d (%s)", MMApplicationContext.getProcessName(), Integer.valueOf(i2), formatedNetType);
        if ("NON_NETWORK".equals(formatedNetType)) {
            p.INSTANCE.EZ(0);
            AppMethodBeat.o(239098);
        } else if ("2G".equals(formatedNetType)) {
            p.INSTANCE.EZ(1);
            AppMethodBeat.o(239098);
        } else if ("3G".equals(formatedNetType)) {
            p.INSTANCE.EZ(3);
            AppMethodBeat.o(239098);
        } else if ("WIFI".equals(formatedNetType)) {
            p.INSTANCE.EZ(4);
            AppMethodBeat.o(239098);
        } else if ("4G".equals(formatedNetType)) {
            p.INSTANCE.EZ(5);
            AppMethodBeat.o(239098);
        } else {
            if ("5G".equals(formatedNetType)) {
                p.INSTANCE.EZ(5);
            }
            AppMethodBeat.o(239098);
        }
    }
}
