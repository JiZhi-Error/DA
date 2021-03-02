package com.tencent.mm.plugin.hp.net;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.hp.b.e;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.mm.plugin.hp.tinker.h;
import com.tencent.mm.protocal.protobuf.cxu;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.Huawei;
import com.tencent.mm.sdk.vendor.OnePlus;
import java.util.List;

public final class d extends a {
    protected boolean ymZ;
    b yna;

    public d() {
        this("", "", null, false);
    }

    public d(String str, String str2, List<cxu> list) {
        this(str, str2, list, true);
    }

    private d(String str, String str2, List<cxu> list, boolean z) {
        AppMethodBeat.i(117450);
        this.ymZ = true;
        if (!z) {
            str = a.aKw();
            str2 = a.aKx();
            list = e.dZe();
            this.mScene = 1;
        } else {
            this.mScene = 0;
        }
        this.ymP = str;
        this.ymQ = str2;
        this.ymR.addAll(list);
        this.ymZ = z;
        if (this.ymZ) {
            AnonymousClass1 r9 = new c.a() {
                /* class com.tencent.mm.plugin.hp.net.d.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.hp.d.c.a
                public final void a(boolean z, b bVar) {
                    AppMethodBeat.i(117449);
                    if (!z || bVar == null) {
                        Context context = MMApplicationContext.getContext();
                        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_base_id", d.this.ymP).apply();
                        h.aY(MMApplicationContext.getContext(), "");
                        AppMethodBeat.o(117449);
                        return;
                    }
                    d.this.yna = bVar;
                    d.this.ymQ = d.this.yna.cri;
                    Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "Use last response patchId %s instead of current patchId %s", d.this.yna.cri, d.this.ymQ);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(614, 71, 1, false);
                    AppMethodBeat.o(117449);
                }
            };
            String string = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_node", "");
            if (!Util.isNullOrNil(string)) {
                try {
                    cxw cxw = new cxw();
                    cxw.parseFrom(Base64.decode(string.getBytes(), 0));
                    if (cxw.APx != null) {
                        String aKx = a.aKx();
                        String aKw = a.aKw();
                        String string2 = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_base_id", "");
                        b bVar = new b(cxw.MCM);
                        Log.i("Tinker.TinkerUtils", "LastResponse PID:%s current PID:%s last baseId:%s current baseId:%s", bVar.cri, aKx, string2, aKw);
                        if (!Util.isNullOrNil(bVar.cri) && !bVar.cri.equalsIgnoreCase(aKx) && !Util.isNullOrNil(aKw) && aKw.equalsIgnoreCase(string2)) {
                            r9.a(true, bVar);
                            AppMethodBeat.o(117450);
                            return;
                        }
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("Tinker.TinkerUtils", e2, "parse tinker update Response failed.", new Object[0]);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(614, 73, 1, false);
                }
            }
            r9.a(false, null);
        }
        AppMethodBeat.o(117450);
    }

    @Override // com.tencent.mm.plugin.hp.net.a, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(177772);
        if (!BuildInfo.TINKER_VERSION.equals("1.9.14.5-INTERNALv1") || ((!Huawei.ifHUAWEI() || Build.VERSION.SDK_INT != 24) && (!OnePlus.isOnePlus() || Build.VERSION.SDK_INT <= 28))) {
            int doScene = super.doScene(gVar, iVar);
            AppMethodBeat.o(177772);
            return doScene;
        }
        Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check ignore.");
        this.callback = iVar;
        AppMethodBeat.o(177772);
        return -1;
    }

    @Override // com.tencent.mm.plugin.hp.net.a, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(117451);
        Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "errType:%d errCode:%d errMsg:%s ", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        if (i3 == 0 && i4 == 0) {
            cxw cxw = (cxw) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
            cxz cxz = cxw.MCM;
            if (cxz == null) {
                if (cxw.MCO == 1) {
                    com.tencent.mm.plugin.hp.b.a.gN(1, 0);
                } else if (cxw.MCO == 2) {
                    com.tencent.mm.plugin.hp.b.a.gN(2, 0);
                } else if (cxw.MCO == 3) {
                    com.tencent.mm.plugin.hp.b.a.gN(3, 0);
                } else if (cxw.MCO == 4) {
                    com.tencent.mm.plugin.hp.b.a.gN(6, 0);
                } else if (cxw.MCO == 6) {
                    Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "revoke this patch.");
                } else {
                    com.tencent.mm.plugin.hp.b.a.gN(5, 0);
                }
                if (this.yna != null) {
                    String aKx = a.aKx();
                    if (!Util.isNullOrNil(this.yna.cri) && !this.yna.cri.equalsIgnoreCase(aKx)) {
                        int i5 = MMApplicationContext.getContext().getSharedPreferences("tinker_patch_share_config", 4).getInt("tinker_node_retry_time", 0);
                        if (i5 >= 4) {
                            h.aY(MMApplicationContext.getContext(), "");
                            h.aj(MMApplicationContext.getContext(), 0);
                            Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "retry time over %d time, then clear node and count", Integer.valueOf(i5));
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(614, 74, 1, false);
                            AppMethodBeat.o(117451);
                            return;
                        }
                        new e(this.yna).qk(this.ymZ);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(614, 70, 1, false);
                        int i6 = i5 + 1;
                        h.aj(MMApplicationContext.getContext(), i6);
                        Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "add retry time %d", Integer.valueOf(i6));
                    }
                }
                AppMethodBeat.o(117451);
            } else if (this.ymZ) {
                try {
                    h.aY(MMApplicationContext.getContext(), new String(Base64.encode(cxw.toByteArray(), 0)));
                    h.aj(MMApplicationContext.getContext(), 0);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", e2, "save node failed.", new Object[0]);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(614, 72, 1, false);
                }
                Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. try to process");
                b bVar = new b(cxz);
                Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. new TinkerSyncResponse finish");
                new e(bVar).qk(this.ymZ);
                Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "node is no empty. end process");
                com.tencent.mm.plugin.hp.b.a.gN(4, 0);
                AppMethodBeat.o(117451);
            } else {
                Log.i("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check from setting about ui. ");
                AppMethodBeat.o(117451);
            }
        } else {
            Log.d("MicroMsg.Tinker.NetSceneCheckTinkerUpdate", "check tinker update failed.");
            com.tencent.mm.plugin.hp.b.a.gN(5, i3);
            AppMethodBeat.o(117451);
        }
    }
}
