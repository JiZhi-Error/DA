package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.smtt.utils.TbsLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j {
    private static boolean zjy = false;
    private static List<a> zjz = new ArrayList();

    public interface a {
        void b(dil dil);

        void c(dil dil);
    }

    static {
        AppMethodBeat.i(66011);
        AppMethodBeat.o(66011);
    }

    public static void a(a aVar, boolean z, boolean z2) {
        boolean z3;
        AppMethodBeat.i(66007);
        Log.i("MicroMsg.QueryWeChatWalletManager", "do query wechat wallet: %s", Boolean.valueOf(z));
        if (!g.aAc()) {
            Log.w("MicroMsg.QueryWeChatWalletManager", "account not ready");
            AppMethodBeat.o(66007);
            return;
        }
        final dil dil = new dil();
        String str = (String) ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().get(ar.a.USERINFO_WALLET_RESP_CACHE_STRING_SYNC, (Object) null);
        if (!Util.isNullOrNil(str)) {
            try {
                dil.parseFrom(str.getBytes(org.apache.commons.a.a.ISO_8859_1));
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.QueryWeChatWalletManager", e2, "", new Object[0]);
            }
        }
        if (z2) {
            if (aVar != null) {
                aVar.b(dil);
            }
            z3 = true;
        } else {
            z3 = false;
        }
        if ((z2 && !z3) || z) {
            if (aVar != null && !zjz.contains(aVar)) {
                zjz.add(aVar);
            }
            if (zjy) {
                Log.i("MicroMsg.QueryWeChatWalletManager", "is quering");
            } else {
                zjy = true;
                f.a("wallet_balance_version", new f.b() {
                    /* class com.tencent.mm.plugin.mall.a.j.AnonymousClass1 */
                    final /* synthetic */ int zjA = 0;

                    @Override // com.tencent.mm.wallet_core.ui.f.b
                    public final void dy(Object obj) {
                        AppMethodBeat.i(66003);
                        Log.i("MicroMsg.QueryWeChatWalletManager", "get from push done: %s", obj);
                        long j2 = 0;
                        if (obj instanceof Long) {
                            j2 = ((Long) obj).longValue();
                        }
                        j.a(j2, this.zjA, dil);
                        AppMethodBeat.o(66003);
                    }
                });
            }
            if (!z3 && !z) {
                h.INSTANCE.dN(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, 1);
            }
        }
        AppMethodBeat.o(66007);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(66008);
        Log.d("MicroMsg.QueryWeChatWalletManager", "remove ret: %s", Boolean.valueOf(zjz.remove(aVar)));
        AppMethodBeat.o(66008);
    }

    static /* synthetic */ void a(final long j2, final int i2, dil dil) {
        AppMethodBeat.i(66009);
        new c(j2, dil).aYI().h(new com.tencent.mm.vending.c.a<dil, c.a<dil>>() {
            /* class com.tencent.mm.plugin.mall.a.j.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ dil call(c.a<dil> aVar) {
                AppMethodBeat.i(66006);
                dil g2 = g(aVar);
                AppMethodBeat.o(66006);
                return g2;
            }

            private static dil g(c.a<dil> aVar) {
                AppMethodBeat.i(182484);
                Log.i("MicroMsg.QueryWeChatWalletManager", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.errMsg);
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    dil dil = (dil) aVar.iLC;
                    if (dil.MMX != null) {
                        Iterator<cdv> it = dil.MMX.MaA.iterator();
                        while (it.hasNext()) {
                            Iterator<egf> it2 = it.next().Mjq.iterator();
                            while (it2.hasNext()) {
                                egf next = it2.next();
                                if (next.KNW.equals("balance_cell")) {
                                    if (next.Ngg != null && next.Ngg.size() > 0) {
                                        String charSequence = com.tencent.mm.plugin.wallet_core.utils.g.a(MMApplicationContext.getContext(), next.Ngg.get(0), (g.a) null).toString();
                                        Log.d("MicroMsg.QueryWeChatWalletManager", "balance: %s", charSequence);
                                        if (!Util.isNullOrNil(charSequence) && charSequence.length() > 1) {
                                            ((com.tencent.mm.plugin.wxpay.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_NEW_BALANCE_LONG_SYNC, Long.valueOf(f.nF(charSequence.substring(1), "100")));
                                        }
                                    }
                                } else if (next.KNW.equals("lqt_cell") && next.Ngg != null && next.Ngg.size() > 0) {
                                    String charSequence2 = com.tencent.mm.plugin.wallet_core.utils.g.a(MMApplicationContext.getContext(), next.Ngg.get(0), (g.a) null).toString();
                                    Log.d("MicroMsg.QueryWeChatWalletManager", "lqt: %s", charSequence2);
                                    if (!Util.isNullOrNil(charSequence2) && charSequence2.length() > 1) {
                                        ((com.tencent.mm.plugin.wxpay.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_NEW_LQT_LONG_SYNC, Long.valueOf(f.nF(charSequence2.substring(1), "100")));
                                    }
                                }
                            }
                        }
                    }
                    try {
                        ((com.tencent.mm.plugin.wxpay.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_WALLET_RESP_CACHE_STRING_SYNC, new String(dil.toByteArray(), org.apache.commons.a.a.ISO_8859_1));
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.QueryWeChatWalletManager", e2, "", new Object[0]);
                    }
                    if (dil.MMY != null) {
                        Log.i("MicroMsg.QueryWeChatWalletManager", "wallet balance: %s", Long.valueOf(dil.MMY.Nvg));
                        an fQI = t.fQI();
                        if (fQI.IbK == null) {
                            fQI.IbK = t.fQD().fRN();
                        }
                        am amVar = fQI.IbK;
                        amVar.field_wallet_balance = dil.MMY.Nvg;
                        ((com.tencent.mm.plugin.wxpay.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_NEW_BALANCE_LONG_SYNC, Long.valueOf(amVar.field_wallet_balance));
                        t.fQI().a(amVar);
                    }
                }
                dil dil2 = (dil) aVar.iLC;
                AppMethodBeat.o(182484);
                return dil2;
            }
        }).b(new com.tencent.mm.vending.c.a<Object, dil>() {
            /* class com.tencent.mm.plugin.mall.a.j.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(dil dil) {
                AppMethodBeat.i(66004);
                dil dil2 = dil;
                Log.i("MicroMsg.QueryWeChatWalletManager", "callback ui");
                int i2 = i2 - 1;
                if (dil2 != null || i2 < 0) {
                    boolean unused = j.zjy = false;
                    j.a(dil2);
                } else if (i2 >= 0) {
                    j.a(j2, i2, (dil) null);
                }
                AppMethodBeat.o(66004);
                return null;
            }
        });
        AppMethodBeat.o(66009);
    }

    static /* synthetic */ void a(dil dil) {
        AppMethodBeat.i(66010);
        for (int size = zjz.size() - 1; size >= 0; size--) {
            a aVar = zjz.get(size);
            aVar.c(dil);
            zjz.remove(aVar);
        }
        AppMethodBeat.o(66010);
    }
}
