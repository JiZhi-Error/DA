package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.bb.n;
import com.tencent.mm.co.c;
import com.tencent.mm.g.a.aaf;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.d.d;
import com.tencent.mm.plugin.wallet_core.d.e;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.plugin.wallet_core.d.k;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class t implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private com.tencent.mm.co.h<ak> IaA = new com.tencent.mm.co.h<>(new c<ak>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass12 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ ak get() {
            AppMethodBeat.i(70374);
            ak akVar = new ak();
            AppMethodBeat.o(70374);
            return akVar;
        }
    });
    private com.tencent.mm.co.h<k> IaB = new com.tencent.mm.co.h<>(new c<k>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass20 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ k get() {
            AppMethodBeat.i(70375);
            g.aAi();
            k kVar = new k(g.aAh().hqK);
            AppMethodBeat.o(70375);
            return kVar;
        }
    });
    private com.tencent.mm.co.h<d> IaC = new com.tencent.mm.co.h<>(new c<d>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass21 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ d get() {
            AppMethodBeat.i(70376);
            g.aAi();
            d dVar = new d(g.aAh().hqK);
            AppMethodBeat.o(70376);
            return dVar;
        }
    });
    private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.c> IaD = new com.tencent.mm.co.h<>(new c<com.tencent.mm.plugin.wallet_core.d.c>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass22 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ com.tencent.mm.plugin.wallet_core.d.c get() {
            AppMethodBeat.i(70377);
            g.aAi();
            com.tencent.mm.plugin.wallet_core.d.c cVar = new com.tencent.mm.plugin.wallet_core.d.c(g.aAh().hqK);
            AppMethodBeat.o(70377);
            return cVar;
        }
    });
    private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.a> IaE = new com.tencent.mm.co.h<>(new c<com.tencent.mm.plugin.wallet_core.d.a>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass23 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ com.tencent.mm.plugin.wallet_core.d.a get() {
            AppMethodBeat.i(70378);
            g.aAi();
            com.tencent.mm.plugin.wallet_core.d.a aVar = new com.tencent.mm.plugin.wallet_core.d.a(g.aAh().hqK);
            AppMethodBeat.o(70378);
            return aVar;
        }
    });
    private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.g> IaF = new com.tencent.mm.co.h<>(new c<com.tencent.mm.plugin.wallet_core.d.g>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass24 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ com.tencent.mm.plugin.wallet_core.d.g get() {
            AppMethodBeat.i(70379);
            g.aAi();
            com.tencent.mm.plugin.wallet_core.d.g gVar = new com.tencent.mm.plugin.wallet_core.d.g(g.aAh().hqK);
            AppMethodBeat.o(70379);
            return gVar;
        }
    });
    private com.tencent.mm.co.h<e> IaG = new com.tencent.mm.co.h<>(new c<e>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass25 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ e get() {
            AppMethodBeat.i(70380);
            g.aAi();
            e eVar = new e(g.aAh().hqK);
            AppMethodBeat.o(70380);
            return eVar;
        }
    });
    private aa IaH = new aa();
    private com.tencent.mm.co.h<f> IaI = new com.tencent.mm.co.h<>(new c<f>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass26 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ f get() {
            AppMethodBeat.i(70381);
            g.aAi();
            f fVar = new f(g.aAh().hqK);
            AppMethodBeat.o(70381);
            return fVar;
        }
    });
    private com.tencent.mm.co.h<j> IaJ = new com.tencent.mm.co.h<>(new c<j>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ j get() {
            AppMethodBeat.i(70366);
            g.aAi();
            j jVar = new j(g.aAh().hqK);
            AppMethodBeat.o(70366);
            return jVar;
        }
    });
    private com.tencent.mm.co.h<i> IaK = new com.tencent.mm.co.h<>(new c<i>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass3 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ i get() {
            AppMethodBeat.i(70367);
            g.aAi();
            i iVar = new i(g.aAh().hqK);
            AppMethodBeat.o(70367);
            return iVar;
        }
    });
    private com.tencent.mm.co.h<com.tencent.mm.plugin.wallet_core.d.h> IaL = new com.tencent.mm.co.h<>(new c<com.tencent.mm.plugin.wallet_core.d.h>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass4 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ com.tencent.mm.plugin.wallet_core.d.h get() {
            AppMethodBeat.i(70368);
            g.aAi();
            com.tencent.mm.plugin.wallet_core.d.h hVar = new com.tencent.mm.plugin.wallet_core.d.h(g.aAh().hqK);
            AppMethodBeat.o(70368);
            return hVar;
        }
    });
    private com.tencent.mm.plugin.wallet_core.id_verify.util.a IaM = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
    private IListener IaN = new IListener<sd>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass5 */

        {
            AppMethodBeat.i(160873);
            this.__eventId = sd.class.getName().hashCode();
            AppMethodBeat.o(160873);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sd sdVar) {
            AppMethodBeat.i(70369);
            sd sdVar2 = sdVar;
            t.aq(sdVar2.dYH.context, sdVar2.dYH.intent);
            AppMethodBeat.o(70369);
            return true;
        }
    };
    private String IaO = "";
    private IListener<yq> IaP = new IListener<yq>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass6 */

        {
            AppMethodBeat.i(160874);
            this.__eventId = yq.class.getName().hashCode();
            AppMethodBeat.o(160874);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yq yqVar) {
            AppMethodBeat.i(70370);
            yq yqVar2 = yqVar;
            if (yqVar2.eeU.packageType == 11) {
                List<cyb> list = yqVar2.eeU.eeV;
                if (list == null || list.size() <= 0) {
                    Log.e("MicroMsg.UpdateMassSendPlaceTopListener", "empty UpdatePackageEvent");
                } else {
                    byte[] a2 = z.a(list.get(0).KIA);
                    if (a2 == null || a2.length == 0) {
                        AppMethodBeat.o(70370);
                        return false;
                    }
                    String str = new String(a2);
                    if (str.equals(t.this.IaO)) {
                        Log.i("MicroMsg.UpdateMassSendPlaceTopListener", "the same result : %s".concat(String.valueOf(str)));
                    } else {
                        Log.i("MicroMsg.UpdateMassSendPlaceTopListener", "UpdatePackageEvent: %s", str);
                        b.aVy(str);
                        t.this.IaO = str;
                    }
                }
            }
            AppMethodBeat.o(70370);
            return false;
        }
    };
    private IListener<aaf> IaQ = new IListener<aaf>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass7 */

        {
            AppMethodBeat.i(160875);
            this.__eventId = aaf.class.getName().hashCode();
            AppMethodBeat.o(160875);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0028  */
        @Override // com.tencent.mm.sdk.event.IListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.aaf r5) {
            /*
                r4 = this;
                r3 = 70371(0x112e3, float:9.8611E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                com.tencent.mm.g.a.aaf r5 = (com.tencent.mm.g.a.aaf) r5
                com.tencent.mm.plugin.wallet_core.d.h r0 = com.tencent.mm.plugin.wallet_core.model.t.fQE()
                com.tencent.mm.g.a.aaf$a r1 = r5.egV
                java.lang.String r1 = r1.egX
                boolean r2 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r1)
                if (r2 != 0) goto L_0x004b
                java.util.Map<java.lang.String, com.tencent.mm.plugin.wallet_core.model.ae> r2 = com.tencent.mm.plugin.wallet_core.d.h.jTI
                boolean r2 = r2.containsKey(r1)
                if (r2 == 0) goto L_0x003f
                java.util.Map<java.lang.String, com.tencent.mm.plugin.wallet_core.model.ae> r0 = com.tencent.mm.plugin.wallet_core.d.h.jTI
                java.lang.Object r0 = r0.get(r1)
                com.tencent.mm.plugin.wallet_core.model.ae r0 = (com.tencent.mm.plugin.wallet_core.model.ae) r0
            L_0x0026:
                if (r0 == 0) goto L_0x003a
                com.tencent.mm.g.a.aaf$b r1 = r5.egW
                int r2 = r0.field_hbType
                r1.egY = r2
                com.tencent.mm.g.a.aaf$b r1 = r5.egW
                int r2 = r0.field_hbStatus
                r1.egZ = r2
                com.tencent.mm.g.a.aaf$b r1 = r5.egW
                int r0 = r0.field_receiveStatus
                r1.eha = r0
            L_0x003a:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                return r0
            L_0x003f:
                com.tencent.mm.plugin.wallet_core.model.ae r0 = r0.aVA(r1)
                if (r0 == 0) goto L_0x004b
                java.util.Map<java.lang.String, com.tencent.mm.plugin.wallet_core.model.ae> r2 = com.tencent.mm.plugin.wallet_core.d.h.jTI
                r2.put(r1, r0)
                goto L_0x0026
            L_0x004b:
                r0 = 0
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass7.callback(com.tencent.mm.sdk.event.IEvent):boolean");
        }
    };
    private volatile x Iax = new x();
    private com.tencent.mm.co.h<an> Iay = new com.tencent.mm.co.h<>(new c<an>() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ an get() {
            AppMethodBeat.i(70365);
            an anVar = new an();
            AppMethodBeat.o(70365);
            return anVar;
        }
    });
    private volatile ah Iaz = null;
    private cj.a zjG = new cj.a() {
        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass8 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(70373);
            String a2 = z.a(aVar.heO.KHn);
            final Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            if (parseXml == null) {
                AppMethodBeat.o(70373);
                return;
            }
            int i2 = Util.getInt(parseXml.get(".sysmsg.paymsg.PayMsgType"), -1);
            Log.i("MicroMsg.SubCoreWalletCore", "got a pay msg, type = ".concat(String.valueOf(i2)));
            switch (i2) {
                case 16:
                    int i3 = Util.getInt(parseXml.get(".sysmsg.paymsg.Flag"), 0);
                    Log.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=".concat(String.valueOf(i3)));
                    if (i3 == 1) {
                        Log.i("MicroMsg.SubCoreWalletCore", "open wallet");
                        com.tencent.mm.model.z.aUk();
                        AppMethodBeat.o(70373);
                        return;
                    } else if (i3 == 2) {
                        Log.i("MicroMsg.SubCoreWalletCore", "close wallet");
                        com.tencent.mm.model.z.aUR();
                        AppMethodBeat.o(70373);
                        return;
                    }
                    break;
                case 17:
                    int i4 = Util.getInt(parseXml.get(".sysmsg.paymsg.WalletType"), -1);
                    Log.i("MicroMsg.SubCoreWalletCore", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=".concat(String.valueOf(i4)));
                    if (i4 >= 0) {
                        g.aAi();
                        g.aAh().azQ().set(339975, Integer.valueOf(i4));
                        AppMethodBeat.o(70373);
                        return;
                    }
                    break;
                case 37:
                    Log.i("MicroMsg.SubCoreWalletCore", "receive c2c content update msg: %s", a2);
                    g.aAi();
                    g.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass8.AnonymousClass1 */

                        /* JADX WARNING: Removed duplicated region for block: B:32:0x011a  */
                        /* JADX WARNING: Removed duplicated region for block: B:41:0x0136  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            /*
                            // Method dump skipped, instructions count: 449
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass8.AnonymousClass1.run():void");
                        }
                    });
                    break;
            }
            AppMethodBeat.o(70373);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };

    public t() {
        AppMethodBeat.i(70383);
        AppMethodBeat.o(70383);
    }

    static {
        AppMethodBeat.i(70405);
        t.class.getClassLoader();
        com.tencent.mm.compatible.util.j.Ed("tenpay_utils");
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("WALLET_USER_INFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass9 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return k.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("WALLET_BANKCARD_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass10 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return d.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("WALLET_BANKCARD_SCENE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass11 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.wallet_core.d.c.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass13 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.wallet_core.d.a.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass14 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.wallet_core.d.g.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass15 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return e.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass16 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return i.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass17 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return f.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass18 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return j.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.wallet_core.model.t.AnonymousClass19 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.wallet_core.d.h.SQL_CREATE;
            }
        });
        AppMethodBeat.o(70405);
    }

    public static t fQC() {
        AppMethodBeat.i(70384);
        t tVar = (t) y.at(t.class);
        AppMethodBeat.o(70384);
        return tVar;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    public static k fQD() {
        AppMethodBeat.i(70385);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(70385);
            throw bVar;
        }
        k kVar = fQC().IaB.get();
        AppMethodBeat.o(70385);
        return kVar;
    }

    public static com.tencent.mm.plugin.wallet_core.d.h fQE() {
        AppMethodBeat.i(70386);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(70386);
            throw bVar;
        }
        com.tencent.mm.plugin.wallet_core.d.h hVar = fQC().IaL.get();
        AppMethodBeat.o(70386);
        return hVar;
    }

    public static d fQF() {
        AppMethodBeat.i(70387);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(70387);
            throw bVar;
        }
        d dVar = fQC().IaC.get();
        AppMethodBeat.o(70387);
        return dVar;
    }

    public static com.tencent.mm.plugin.wallet_core.d.c fQG() {
        AppMethodBeat.i(70388);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(70388);
            throw bVar;
        }
        com.tencent.mm.plugin.wallet_core.d.c cVar = fQC().IaD.get();
        AppMethodBeat.o(70388);
        return cVar;
    }

    public static i fQH() {
        AppMethodBeat.i(70389);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(70389);
            throw bVar;
        }
        i iVar = fQC().IaK.get();
        AppMethodBeat.o(70389);
        return iVar;
    }

    public static an fQI() {
        AppMethodBeat.i(70390);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(70390);
            throw bVar;
        }
        an anVar = fQC().Iay.get();
        AppMethodBeat.o(70390);
        return anVar;
    }

    public static ak fQJ() {
        AppMethodBeat.i(70391);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(70391);
            throw bVar;
        }
        ak akVar = fQC().IaA.get();
        AppMethodBeat.o(70391);
        return akVar;
    }

    public static com.tencent.mm.plugin.wallet_core.d.a fQK() {
        AppMethodBeat.i(70392);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(70392);
            throw bVar;
        }
        com.tencent.mm.plugin.wallet_core.d.a aVar = fQC().IaE.get();
        AppMethodBeat.o(70392);
        return aVar;
    }

    public static com.tencent.mm.plugin.wallet_core.d.g fQL() {
        AppMethodBeat.i(70393);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(70393);
            throw bVar;
        }
        com.tencent.mm.plugin.wallet_core.d.g gVar = fQC().IaF.get();
        AppMethodBeat.o(70393);
        return gVar;
    }

    public static e fQM() {
        AppMethodBeat.i(70394);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(70394);
            throw bVar;
        }
        e eVar = fQC().IaG.get();
        AppMethodBeat.o(70394);
        return eVar;
    }

    public static f fQN() {
        AppMethodBeat.i(70395);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(70395);
            throw bVar;
        }
        f fVar = fQC().IaI.get();
        AppMethodBeat.o(70395);
        return fVar;
    }

    public static j fQO() {
        AppMethodBeat.i(70396);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(70396);
            throw bVar;
        }
        j jVar = fQC().IaJ.get();
        AppMethodBeat.o(70396);
        return jVar;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    public static ah fQP() {
        AppMethodBeat.i(70397);
        ah ahVar = fQC().Iaz;
        AppMethodBeat.o(70397);
        return ahVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(70398);
        Log.i("MicroMsg.SubCoreWalletCore", "onAccountPostReset subcore walletCore");
        com.tencent.mm.wallet_core.c.b.hhj().init(MMApplicationContext.getContext());
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", this.zjG, true);
        fQI().fRy();
        this.Iaz = ah.fQU();
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", this.Iaz.qvw, true);
        EventCenter.instance.add(this.IaN);
        EventCenter.instance.add(this.IaH);
        EventCenter.instance.add(this.IaQ);
        EventCenter.instance.add(this.IaP);
        com.tencent.mm.pluginsdk.cmd.b.a(new a(), "//cleanpaycn");
        AppMethodBeat.o(70398);
    }

    static class a implements com.tencent.mm.pluginsdk.cmd.a {
        a() {
        }

        @Override // com.tencent.mm.pluginsdk.cmd.a
        public final boolean a(Context context, String[] strArr, String str) {
            AppMethodBeat.i(70382);
            String str2 = strArr[0];
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1912590262:
                    if (str2.equals("//cleanpaycn")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    com.tencent.mm.wallet_core.c.b.hhj();
                    com.tencent.mm.wallet_core.c.b.clean();
                    AppMethodBeat.o(70382);
                    return true;
                default:
                    AppMethodBeat.o(70382);
                    return false;
            }
        }
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(70399);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", this.zjG, true);
        fQI().and();
        ak fQJ = fQJ();
        fQJ.IbE = null;
        fQJ.IbD.clear();
        fQJ.IbD = new ArrayList<>();
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", this.Iaz.qvw, true);
        if (ah.eN != null) {
            ah.eN.clear();
        }
        this.Iaz = null;
        EventCenter.instance.removeListener(this.IaN);
        EventCenter.instance.removeListener(this.IaH);
        EventCenter.instance.removeListener(this.IaQ);
        EventCenter.instance.removeListener(this.IaP);
        AppMethodBeat.o(70399);
    }

    public static void aq(Context context, Intent intent) {
        AppMethodBeat.i(70400);
        if (intent == null) {
            intent = new Intent();
        }
        if (com.tencent.mm.model.z.aUp()) {
            intent.setFlags(536870912);
            Log.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is h5,jump to ibg");
            com.tencent.mm.br.c.b(context, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", intent);
            AppMethodBeat.o(70400);
        } else if (com.tencent.mm.model.z.aUq()) {
            intent.setFlags(536870912);
            com.tencent.mm.br.c.b(context, "mall", ".ui.MallIndexOSUI", intent);
            AppMethodBeat.o(70400);
        } else {
            Log.i("MicroMsg.SubCoreWalletCore", "entryWalletIndexPage wallet type is native");
            intent.setFlags(536870912);
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_walletv2_open_config, true);
            Log.i("MicroMsg.SubCoreWalletCore", " walletMallV2 switch is ：%s", Boolean.valueOf(a2));
            if (a2) {
                com.tencent.mm.br.c.b(context, "mall", ".ui.MallIndexUIv2", intent);
            } else {
                com.tencent.mm.br.c.b(context, "mall", ".ui.MallIndexUI", intent);
            }
            g.aAi();
            if (g.aAh().isSDCardAvailable()) {
                n nVar = new n(11);
                g.aAi();
                g.aAg().hqi.a(nVar, 0);
            }
            AppMethodBeat.o(70400);
        }
    }

    public static x fQQ() {
        AppMethodBeat.i(70401);
        x xVar = fQC().Iax;
        AppMethodBeat.o(70401);
        return xVar;
    }

    public static boolean a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.e eVar) {
        AppMethodBeat.i(70402);
        boolean a2 = fQC().IaM.a(mMActivity, eVar, 1008);
        AppMethodBeat.o(70402);
        return a2;
    }

    public static boolean b(MMActivity mMActivity, com.tencent.mm.wallet_core.d.e eVar, int i2) {
        AppMethodBeat.i(70403);
        boolean a2 = fQC().IaM.a(mMActivity, eVar, i2);
        AppMethodBeat.o(70403);
        return a2;
    }

    public static boolean fQR() {
        AppMethodBeat.i(70404);
        boolean aUs = com.tencent.mm.model.z.aUs();
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mobile_remittance_switch, 0);
        Log.i("MicroMsg.SubCoreWalletCore", "isSupportMobileRemit() isCN:%s mobileRemitSwitch:%s", Boolean.valueOf(aUs), Integer.valueOf(a2));
        if (!aUs || a2 != 1) {
            AppMethodBeat.o(70404);
            return false;
        }
        AppMethodBeat.o(70404);
        return true;
    }
}
