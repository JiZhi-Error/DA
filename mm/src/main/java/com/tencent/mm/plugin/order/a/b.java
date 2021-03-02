package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.order.b.a;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storagebase.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    com.tencent.mm.plugin.order.model.b ANB = null;
    private com.tencent.mm.plugin.order.b.b ANC;
    private c AND = null;
    private cj.a ANE = new cj.a() {
        /* class com.tencent.mm.plugin.order.a.b.AnonymousClass2 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(66636);
            final String a2 = z.a(aVar.heO.KHn);
            Log.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:".concat(String.valueOf(a2)));
            b.this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.order.a.b.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(66635);
                    b bVar = b.this;
                    g.aAf().azk();
                    if (bVar.ANB == null) {
                        bVar.ANB = new com.tencent.mm.plugin.order.model.b();
                    }
                    com.tencent.mm.plugin.order.model.b bVar2 = bVar.ANB;
                    String str = a2;
                    if (!Util.isNullOrNil(str)) {
                        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
                        if (parseXml == null) {
                            AppMethodBeat.o(66635);
                            return;
                        }
                        try {
                            String str2 = parseXml.get(".sysmsg.wxpay.transid");
                            if (!Util.isNullOrNil(str2)) {
                                Log.d("MicroMsg.WalletOrdersManager", "transid ".concat(String.valueOf(str2)));
                                if (!bVar2.ANV.contains(str2)) {
                                    bVar2.ANV.add(str2);
                                    g.aAi();
                                    g.aAh().azQ().set(204817, Integer.valueOf(bVar2.ANV.size()));
                                    Log.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + bVar2.ANV.size());
                                    bVar2.Yy();
                                    b.eBa().onChange();
                                }
                            }
                            AppMethodBeat.o(66635);
                            return;
                        } catch (Exception e2) {
                            Log.e("MicroMsg.WalletOrdersManager", "cmdid error");
                        }
                    }
                    AppMethodBeat.o(66635);
                }
            });
            AppMethodBeat.o(66636);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    private List<WeakReference<Object>> pQG = new ArrayList();
    private cj.a qvw = new cj.a() {
        /* class com.tencent.mm.plugin.order.a.b.AnonymousClass3 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(final h.a aVar) {
            AppMethodBeat.i(66638);
            final String a2 = z.a(aVar.heO.KHn);
            Log.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:".concat(String.valueOf(a2)));
            b.this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.order.a.b.AnonymousClass3.AnonymousClass1 */

                public final void run() {
                    int i2;
                    AppMethodBeat.i(66637);
                    c eBd = b.eBd();
                    String str = a2;
                    String sb = new StringBuilder().append(aVar.heO.Brl).toString();
                    if (!TextUtils.isEmpty(str)) {
                        j aJA = c.aJA(str);
                        if (aJA == null) {
                            Log.i("MicroMsg.MallPayMsgManager", "payMsg == null");
                            AppMethodBeat.o(66637);
                            return;
                        } else if ((!TextUtils.isEmpty(aJA.APc) || !TextUtils.isEmpty(aJA.APt) || !TextUtils.isEmpty(aJA.APs) || !TextUtils.isEmpty(aJA.dWG) || !TextUtils.isEmpty(aJA.APo) || !TextUtils.isEmpty(aJA.APp) || !TextUtils.isEmpty(aJA.APn) || !TextUtils.isEmpty(aJA.APr) || !TextUtils.isEmpty(aJA.APq) || !TextUtils.isEmpty(aJA.APm)) && (aJA.APm == null || !com.tencent.mm.plugin.order.c.c.isNumeric(aJA.APm) || (i2 = Util.getInt(aJA.APm, 0)) == 2 || i2 == 1)) {
                            if (TextUtils.isEmpty(aJA.APo)) {
                                aJA.msgId = sb;
                            } else {
                                aJA.msgId = sb + aJA.APo;
                            }
                            Log.i("MicroMsg.MallPayMsgManager", "msgid: " + aJA.msgId);
                            Log.i("MicroMsg.MallPayMsgManager", "msgType: " + aJA.APm);
                            if (!eBd.aJC(aJA.msgId)) {
                                eBd.pRP.add(aJA);
                                eBd.a(aJA, str, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            } else {
                                Log.e("MicroMsg.MallPayMsgManager", "msg for id " + aJA.msgId + " is exist!!");
                                a aJE = eBd.aJE(aJA.msgId);
                                eBd.aJB(aJA.msgId);
                                eBd.pRP.add(aJA);
                                eBd.a(aJA, str, aJE.field_isRead);
                            }
                            eBd.eBg();
                            b eBa = b.eBa();
                            if (aJA != null) {
                                daq daq = new daq();
                                if (TextUtils.isEmpty(aJA.APo) || !com.tencent.mm.plugin.order.c.c.isNumeric(aJA.APo)) {
                                    daq.CreateTime = (int) (System.currentTimeMillis() / 1000);
                                    daq.AOX = (int) (System.currentTimeMillis() / 1000);
                                } else {
                                    daq.CreateTime = Util.getInt(aJA.APo, 0);
                                    daq.AOX = Util.getInt(aJA.APo, 0);
                                }
                                daq.APa = 100000;
                                daq.APc = aJA.APc;
                                daq.AOT = aJA.msgId;
                                daq.AOW = aJA.APq;
                                daq.MFR = -1;
                                daq.APd = aJA.APn;
                                daq.APe = aJA.APq;
                                daq.APf = aJA.dWG;
                            }
                            eBa.eBb();
                        }
                    }
                    AppMethodBeat.o(66637);
                }
            });
            AppMethodBeat.o(66638);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };

    public b() {
        AppMethodBeat.i(66639);
        AppMethodBeat.o(66639);
    }

    static {
        AppMethodBeat.i(66646);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("ORDERCOMMONMSGXML_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.order.a.b.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.order.b.b.SQL_CREATE;
            }
        });
        com.tencent.mm.wallet_core.a.j("ShowOrdersInfoProcess", a.class);
        AppMethodBeat.o(66646);
    }

    public static b eBa() {
        AppMethodBeat.i(66640);
        b bVar = (b) y.at(b.class);
        AppMethodBeat.o(66640);
        return bVar;
    }

    public final void eBb() {
        AppMethodBeat.i(66641);
        if (this.pQG == null) {
            AppMethodBeat.o(66641);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<Object> weakReference = this.pQG.get(i2);
            if (weakReference != null) {
                weakReference.get();
            }
        }
        AppMethodBeat.o(66641);
    }

    public final void onChange() {
        AppMethodBeat.i(66642);
        if (this.pQG == null) {
            AppMethodBeat.o(66642);
            return;
        }
        for (int i2 = 0; i2 < this.pQG.size(); i2++) {
            WeakReference<Object> weakReference = this.pQG.get(i2);
            if (weakReference != null) {
                weakReference.get();
            }
        }
        AppMethodBeat.o(66642);
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
        this.ANB = null;
        this.AND = null;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
    }

    public static com.tencent.mm.plugin.order.b.b eBc() {
        AppMethodBeat.i(66643);
        g.aAf().azk();
        if (eBa().ANC == null) {
            b eBa = eBa();
            g.aAi();
            eBa.ANC = new com.tencent.mm.plugin.order.b.b(g.aAh().hqK);
        }
        com.tencent.mm.plugin.order.b.b bVar = eBa().ANC;
        AppMethodBeat.o(66643);
        return bVar;
    }

    public static c eBd() {
        AppMethodBeat.i(66644);
        g.aAf().azk();
        if (eBa().AND == null) {
            eBa().AND = new c();
        }
        c cVar = eBa().AND;
        AppMethodBeat.o(66644);
        return cVar;
    }

    public static String eeA() {
        AppMethodBeat.i(66645);
        if (g.aAc()) {
            String str = d.aSY() + "order";
            AppMethodBeat.o(66645);
            return str;
        }
        AppMethodBeat.o(66645);
        return "";
    }
}
