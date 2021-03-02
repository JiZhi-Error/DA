package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.zo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet_core.c.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class l extends IListener<zo> {
    public l() {
        AppMethodBeat.i(160862);
        this.__eventId = zo.class.getName().hashCode();
        AppMethodBeat.o(160862);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(zo zoVar) {
        final String str;
        AppMethodBeat.i(69187);
        final zo zoVar2 = zoVar;
        g.aAi();
        final int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue();
        int aUf = z.aUf();
        zoVar2.efG.retCode = 0;
        if (aUf == 4) {
            if (intValue != zoVar2.efF.efI) {
                Log.i("MicroMsg.HandleWCPayWalletBufferListener", "wrong region, client: %s, req: %s", Integer.valueOf(intValue), Integer.valueOf(zoVar2.efF.efI));
                zoVar2.efG.retCode = -1;
            } else if ("fetch".equals(zoVar2.efF.action)) {
                Log.i("MicroMsg.HandleWCPayWalletBufferListener", "do fetch");
                switch (intValue) {
                    case 1:
                        g.aAi();
                        str = (String) g.aAh().azQ().get(ar.a.USERINFO_WCPAY_WALLET_BUFFER_CN_STRING_SYNC, "");
                        break;
                    case 2:
                        g.aAi();
                        str = (String) g.aAh().azQ().get(ar.a.USERINFO_WCPAY_WALLET_BUFFER_MY_STRING_SYNC, "");
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    default:
                        str = "";
                        break;
                    case 4:
                        g.aAi();
                        str = (String) g.aAh().azQ().get(ar.a.USERINFO_WCPAY_WALLET_BUFFER_ZA_STRING_SYNC, "");
                        break;
                    case 8:
                        g.aAi();
                        str = (String) g.aAh().azQ().get(ar.a.USERINFO_WCPAY_WALLET_BUFFER_HK_STRING_SYNC, "");
                        break;
                }
                if (!Util.isNullOrNil(str)) {
                    a(zoVar2, new i() {
                        /* class com.tencent.mm.plugin.wallet.a.l.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                            AppMethodBeat.i(69184);
                            g.aAi();
                            g.aAg().hqi.b(1767, this);
                            if (i2 == 0 && i3 == 0) {
                                zoVar2.efG.buffer = str;
                                zoVar2.efG.efJ.run();
                                AppMethodBeat.o(69184);
                                return;
                            }
                            Log.i("MicroMsg.HandleWCPayWalletBufferListener", "check jsapi error: %s, %s", Integer.valueOf(i3), str);
                            zoVar2.efG.retCode = -1;
                            zoVar2.efG.efJ.run();
                            AppMethodBeat.o(69184);
                        }
                    });
                    AppMethodBeat.o(69187);
                } else {
                    Log.i("MicroMsg.HandleWCPayWalletBufferListener", "fetch empty buffer");
                    zoVar2.efG.retCode = -2;
                }
            } else if ("save".equals(zoVar2.efF.action)) {
                Log.i("MicroMsg.HandleWCPayWalletBufferListener", "do save");
                a(zoVar2, new i() {
                    /* class com.tencent.mm.plugin.wallet.a.l.AnonymousClass2 */

                    @Override // com.tencent.mm.ak.i
                    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                        AppMethodBeat.i(69185);
                        g.aAi();
                        g.aAg().hqi.b(1767, this);
                        if (i2 == 0 && i3 == 0) {
                            l.cH(intValue, zoVar2.efF.buffer);
                            zoVar2.efG.efJ.run();
                            AppMethodBeat.o(69185);
                            return;
                        }
                        Log.i("MicroMsg.HandleWCPayWalletBufferListener", "check jsapi error: %s, %s", Integer.valueOf(i3), str);
                        zoVar2.efG.retCode = -1;
                        zoVar2.efG.efJ.run();
                        AppMethodBeat.o(69185);
                    }
                });
                AppMethodBeat.o(69187);
            } else {
                Log.i("MicroMsg.HandleWCPayWalletBufferListener", "wrong action: %s", zoVar2.efF.action);
                zoVar2.efG.retCode = -1;
            }
            zoVar2.efG.efJ.run();
            AppMethodBeat.o(69187);
        } else {
            Log.i("MicroMsg.HandleWCPayWalletBufferListener", "wrong type: %s", Integer.valueOf(aUf));
            zoVar2.efG.retCode = -1;
            zoVar2.efG.efJ.run();
            AppMethodBeat.o(69187);
        }
        return false;
    }

    private static void a(zo zoVar, i iVar) {
        AppMethodBeat.i(69186);
        Log.i("MicroMsg.HandleWCPayWalletBufferListener", "do check pay jsapi");
        g.aAi();
        g.aAg().hqi.a(1767, iVar);
        zo.a aVar = zoVar.efF;
        Log.i("MicroMsg.HandleWCPayWalletBufferListener", "appId: %s, \nnonce: %s, \ntimestamp: %s, \npackage: %s, \nsign: %s, \nsignType: %s, \nurl: %s", aVar.appId, aVar.nonceStr, aVar.dmc, aVar.efH, aVar.dQk, aVar.signType, aVar.url);
        a aVar2 = new a(aVar.appId, aVar.nonceStr, aVar.dmc, aVar.efH, aVar.dQk, aVar.signType, aVar.url);
        g.aAi();
        g.aAg().hqi.a(aVar2, 0);
        AppMethodBeat.o(69186);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void cH(int i2, String str) {
        AppMethodBeat.i(214050);
        switch (i2) {
            case 1:
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WCPAY_WALLET_BUFFER_CN_STRING_SYNC, str);
                AppMethodBeat.o(214050);
                return;
            case 2:
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WCPAY_WALLET_BUFFER_MY_STRING_SYNC, str);
                AppMethodBeat.o(214050);
                return;
            case 4:
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WCPAY_WALLET_BUFFER_ZA_STRING_SYNC, str);
                AppMethodBeat.o(214050);
                return;
            case 8:
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WCPAY_WALLET_BUFFER_HK_STRING_SYNC, str);
                break;
        }
        AppMethodBeat.o(214050);
    }
}
