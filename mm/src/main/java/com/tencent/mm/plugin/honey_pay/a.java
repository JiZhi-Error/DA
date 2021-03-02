package com.tencent.mm.plugin.honey_pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.co.c;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.honey_pay.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class a implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private com.tencent.mm.co.h<b> yjt = new com.tencent.mm.co.h<>(new c<b>() {
        /* class com.tencent.mm.plugin.honey_pay.a.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ b get() {
            AppMethodBeat.i(64603);
            g.aAi();
            b bVar = new b(g.aAh().hqK);
            AppMethodBeat.o(64603);
            return bVar;
        }
    });
    private IListener<qr> yju = new IListener<qr>() {
        /* class com.tencent.mm.plugin.honey_pay.a.AnonymousClass3 */

        {
            AppMethodBeat.i(160799);
            this.__eventId = qr.class.getName().hashCode();
            AppMethodBeat.o(160799);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qr qrVar) {
            AppMethodBeat.i(64604);
            qr qrVar2 = qrVar;
            Log.i("MicroMsg.SubCoreHoneyPay", "receive honey pay msg: %s, %s", qrVar2.dXg.dXh, Long.valueOf(qrVar2.dXg.dXd));
            if (!Util.isNullOrNil(qrVar2.dXg.dXh) && qrVar2.dXg.dXd > -1) {
                if (!Util.isNullOrNil(qrVar2.dXg.username)) {
                    Log.d("MicroMsg.SubCoreHoneyPay", "need replace username: %s", qrVar2.dXg.username);
                    String W = com.tencent.mm.plugin.honey_pay.model.c.W(qrVar2.dXg.dWG, qrVar2.dXg.username, 6);
                    if (!W.equals(qrVar2.dXg.dWG)) {
                        qrVar2.dXg.dWG = W;
                    } else {
                        qrVar2.dXg.dWG = null;
                    }
                }
                com.tencent.mm.plugin.honey_pay.model.a aVar = new com.tencent.mm.plugin.honey_pay.model.a();
                aVar.field_msgId = qrVar2.dXg.dXd;
                aVar.field_payMsgId = qrVar2.dXg.dXh;
                a.this.dYN().insert(aVar);
            }
            AppMethodBeat.o(64604);
            return false;
        }
    };
    private q yjv = new q() {
        /* class com.tencent.mm.plugin.honey_pay.a.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(64605);
            if (Util.getInt(map.get(".sysmsg.paymsg.PayMsgType"), 0) == 35) {
                Log.i("MicroMsg.SubCoreHoneyPay", "receive honey pay newxml");
                String str2 = map.get(".sysmsg.paymsg.appmsgcontent");
                String str3 = map.get(".sysmsg.paymsg.fromusername");
                String str4 = map.get(".sysmsg.paymsg.tousername");
                String str5 = map.get(".sysmsg.paymsg.paymsgid");
                String str6 = map.get(".sysmsg.paymsg.systip");
                if (!Util.isNullOrNil(str2)) {
                    String decode = URLDecoder.decode(str2);
                    Log.d("MicroMsg.SubCoreHoneyPay", "appmsg: %s", decode);
                    com.tencent.mm.plugin.honey_pay.model.c.s(str5, decode, str4, str3);
                }
                if (!Util.isNullOrNil(str6)) {
                    String decode2 = URLDecoder.decode(str6);
                    Log.d("MicroMsg.SubCoreHoneyPay", "systip: %s", decode2);
                    Log.i("MicroMsg.HoneyPayUtil", "insert sys msg: %s, %s", str4, Boolean.valueOf(Util.isNullOrNil(decode2)));
                    if (!Util.isNullOrNil(decode2) && !Util.isNullOrNil(str4)) {
                        String W = com.tencent.mm.plugin.honey_pay.model.c.W(com.tencent.mm.plugin.honey_pay.model.c.W(decode2, str4, -1), str3, -1);
                        ca caVar = new ca();
                        caVar.nv(0);
                        caVar.Cy(str4);
                        caVar.setStatus(3);
                        caVar.setContent(W);
                        caVar.setCreateTime(bp.C(str4, System.currentTimeMillis() / 1000));
                        caVar.setType(10000);
                        caVar.setFlag(caVar.field_flag | 8);
                        long aC = ((l) g.af(l.class)).eiy().aC(caVar);
                        Log.i("MicroMsg.HoneyPayUtil", "insert msgId: %s", Long.valueOf(aC));
                        if (aC <= 0) {
                            Log.w("MicroMsg.HoneyPayUtil", "insert sys msg fail!");
                        }
                    }
                }
            }
            AppMethodBeat.o(64605);
        }
    };

    static {
        AppMethodBeat.i(64611);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("HoneyPayMsgRecord".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.honey_pay.a.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(64611);
    }

    public static a dYM() {
        AppMethodBeat.i(64606);
        a aVar = (a) y.at(a.class);
        AppMethodBeat.o(64606);
        return aVar;
    }

    public a() {
        AppMethodBeat.i(64607);
        AppMethodBeat.o(64607);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(64608);
        this.yju.alive();
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", this.yjv);
        AppMethodBeat.o(64608);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(64609);
        this.yju.dead();
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", this.yjv);
        AppMethodBeat.o(64609);
    }

    public final b dYN() {
        AppMethodBeat.i(64610);
        b bVar = this.yjt.get();
        AppMethodBeat.o(64610);
        return bVar;
    }
}
