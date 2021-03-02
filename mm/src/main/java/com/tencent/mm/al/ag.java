package com.tencent.mm.al;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.g;
import com.tencent.mm.al.a.i;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.f;
import com.tencent.mm.al.o;
import com.tencent.mm.api.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.e;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.q;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.Map;

public class ag implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private static long iOV = 0;
    private e iDE = new e();
    private f iOW;
    private o.a iOX = null;
    private l iOY = null;
    private j iOZ;
    private i iPa = null;
    private d iPb = null;
    private q iPc = null;
    private b iPd = null;
    private l iPe = null;
    private g iPf = null;
    private i iPg = null;
    private com.tencent.mm.al.a.h iPh = null;
    private e iPi = null;
    private aa iPj = null;
    private ae iPk = null;
    private a iPl;
    private cj.a iPm = new cj.a() {
        /* class com.tencent.mm.al.ag.AnonymousClass11 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(212189);
            de deVar = aVar.heO;
            if (deVar == null) {
                Log.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
                AppMethodBeat.o(212189);
                return;
            }
            String a2 = z.a(deVar.KHn);
            if (Util.isNullOrNil(a2)) {
                Log.e("MicroMsg.SubCoreBiz", "msg content is null");
                AppMethodBeat.o(212189);
                return;
            }
            Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
            if (parseXml == null || parseXml.size() <= 0) {
                Log.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
                AppMethodBeat.o(212189);
            } else if (!"mmbizattrappsvr_BizAttrSync".equalsIgnoreCase(parseXml.get(".sysmsg.$type"))) {
                Log.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
                AppMethodBeat.o(212189);
            } else {
                int i2 = Util.getInt(parseXml.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0);
                Log.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", Integer.valueOf(i2));
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_BIZ_ATTR_SYNC_OPEN_FLAG_INT, Integer.valueOf(i2));
                com.tencent.mm.kernel.g.aAh().azQ().gBI();
                AppMethodBeat.o(212189);
            }
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private bw.a iPn = new bw.a() {
        /* class com.tencent.mm.al.ag.AnonymousClass2 */

        @Override // com.tencent.mm.storage.bw.a
        public final void a(az azVar, bw bwVar) {
            AppMethodBeat.i(212187);
            if (azVar != null && !Util.isNullOrNil(azVar.field_username)) {
                String str = azVar.field_username;
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str);
                if (Kn == null) {
                    AppMethodBeat.o(212187);
                    return;
                } else if (Kn.gBM() && !ab.Jf(str)) {
                    c MT = ag.bah().MT(str);
                    if (MT.systemRowid == -1) {
                        Log.i("MicroMsg.SubCoreBiz", "onMsgChangeNotify: no bizInfo");
                        AppMethodBeat.o(212187);
                        return;
                    } else if (MT.UG()) {
                        if (MT.cG(false) == null) {
                            azVar.Co(null);
                            Log.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                            AppMethodBeat.o(212187);
                            return;
                        } else if (MT.cG(false).Vh() == null) {
                            azVar.Co(null);
                            Log.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                            AppMethodBeat.o(212187);
                            return;
                        } else {
                            azVar.Co(Util.nullAsNil(MT.UN()));
                            if (Util.isNullOrNil(MT.UN())) {
                                Log.w("MicroMsg.SubCoreBiz", "Enterprise belong is null:%s", azVar.field_username);
                            }
                            AppMethodBeat.o(212187);
                            return;
                        }
                    } else if (MT.UC() || MT.UF() || ab.JA(str)) {
                        azVar.Co(null);
                        AppMethodBeat.o(212187);
                        return;
                    } else {
                        azVar.Co("officialaccounts");
                    }
                }
            }
            AppMethodBeat.o(212187);
        }
    };
    private f.a iPo = new f.a() {
        /* class com.tencent.mm.al.ag.AnonymousClass3 */

        @Override // com.tencent.mm.al.f.a
        public final void a(f.a.b bVar) {
            boolean z;
            AppMethodBeat.i(212188);
            if (bVar.iOh == f.a.EnumC0255a.INSTERT || bVar.iOh == f.a.EnumC0255a.UPDATE) {
                if (bVar.iOi == null) {
                    AppMethodBeat.o(212188);
                    return;
                }
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(bVar.iNV);
                if (Kn == null) {
                    AppMethodBeat.o(212188);
                    return;
                } else if (!Kn.gBM()) {
                    ag.m(bVar.iOi);
                    AppMethodBeat.o(212188);
                    return;
                } else if (ab.Jf(Kn.field_username)) {
                    AppMethodBeat.o(212188);
                    return;
                } else {
                    az bjY = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(bVar.iNV);
                    Log.v("MicroMsg.SubCoreBiz", "hakon onEvent bizName = %s", bVar.iNV);
                    if (bVar.iOi.UG() && bVar.iOi.cG(false) != null && bVar.iOi.cG(false).Vh() != null && !Util.isNullOrNil(bVar.iOi.UN()) && Util.isNullOrNil(bVar.iOi.field_enterpriseFather)) {
                        bVar.iOi.field_enterpriseFather = bVar.iOi.UN();
                        ag.bah().h(bVar.iOi);
                        Log.i("MicroMsg.SubCoreBiz", "hakon bizStgExt, %s set enterpriseFather %s", bVar.iNV, bVar.iOi.field_enterpriseFather);
                    }
                    if (bjY == null) {
                        AppMethodBeat.o(212188);
                        return;
                    }
                    if (bVar.iOi.UG()) {
                        if (bVar.iOi.cG(false) == null) {
                            Log.e("MicroMsg.SubCoreBiz", "getExtInfo() == null");
                            AppMethodBeat.o(212188);
                            return;
                        } else if (bVar.iOi.cG(false).Vh() == null) {
                            Log.e("MicroMsg.SubCoreBiz", "enterpriseBizInfo == null");
                            AppMethodBeat.o(212188);
                            return;
                        } else {
                            String str = bjY.field_parentRef;
                            Log.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", bVar.iOi.UN(), bVar.iNV);
                            bjY.Co(Util.nullAsNil(bVar.iOi.UN()));
                            if (str != null && bjY.field_parentRef != null && !str.equals(bjY.field_parentRef)) {
                                z = true;
                            } else if (str == null && bjY.field_parentRef != null) {
                                z = true;
                            } else if (str == null || bjY.field_parentRef != null) {
                                z = false;
                            } else {
                                z = true;
                            }
                            Log.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseChildType, %s, %s", bVar.iNV, bjY.field_parentRef);
                        }
                    } else if (bVar.iOi.UF()) {
                        Log.v("MicroMsg.SubCoreBiz", "hakon isEnterpriseFatherType, %s", bVar.iNV);
                        z = true;
                    } else if (!bVar.iOi.UC() && !ab.JA(Kn.field_username) && !"officialaccounts".equals(bjY.field_parentRef)) {
                        bjY.Co("officialaccounts");
                        z = true;
                    } else if (!bVar.iOi.UC() || bjY.field_parentRef == null) {
                        z = false;
                    } else {
                        bjY.Co(null);
                        z = true;
                    }
                    if (z) {
                        ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().a(bjY, bjY.field_username);
                        if (Util.isNullOrNil(bjY.field_parentRef)) {
                            AppMethodBeat.o(212188);
                            return;
                        } else if ("officialaccounts".equals(bjY.field_parentRef)) {
                            az bjY2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY("officialaccounts");
                            if (bjY2 == null) {
                                az azVar = new az("officialaccounts");
                                azVar.gCr();
                                ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().e(azVar);
                                bjY2 = azVar;
                            }
                            if (Util.isNullOrNil(bjY2.field_content)) {
                                Log.i("MicroMsg.SubCoreBiz", "conv content is null");
                                String gCz = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().gCz();
                                if (Util.isNullOrNil(gCz)) {
                                    Log.w("MicroMsg.SubCoreBiz", "last convBiz is null");
                                    AppMethodBeat.o(212188);
                                    return;
                                }
                                ca aEx = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx(gCz);
                                if (aEx == null || aEx.field_msgId == 0) {
                                    Log.w("MicroMsg.SubCoreBiz", "last biz msg is error");
                                    AppMethodBeat.o(212188);
                                    return;
                                }
                                ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(aEx.field_msgId, aEx);
                            }
                            AppMethodBeat.o(212188);
                            return;
                        } else {
                            Log.i("MicroMsg.SubCoreBiz", "hakon username = %s, parentRef = %s", bVar.iNV, bjY.field_parentRef);
                            az bjY3 = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(bjY.field_parentRef);
                            if (bjY3 == null) {
                                AppMethodBeat.o(212188);
                                return;
                            } else if (Util.isNullOrNil(bjY3.field_content)) {
                                Log.i("MicroMsg.SubCoreBiz", "conv content is null");
                                String bkl = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bkl(bjY.field_parentRef);
                                if (Util.isNullOrNil(bkl)) {
                                    Log.w("MicroMsg.SubCoreBiz", "last enterprise convBiz is null");
                                    AppMethodBeat.o(212188);
                                    return;
                                }
                                ca aEx2 = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEx(bkl);
                                if (aEx2 == null || aEx2.field_msgId == 0) {
                                    Log.w("MicroMsg.SubCoreBiz", "last enterprise biz msg is error");
                                    AppMethodBeat.o(212188);
                                    return;
                                }
                                ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(aEx2.field_msgId, aEx2);
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(212188);
        }
    };

    static {
        AppMethodBeat.i(124173);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("BIZINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.al.ag.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return f.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("BIZKF_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.al.ag.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return j.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("BIZCHAT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.al.ag.AnonymousClass5 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return d.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("BIZCHATUSER_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.al.ag.AnonymousClass6 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return l.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("BIZCONVERSATION_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.al.ag.AnonymousClass7 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("BIZCHAMYUSERINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.al.ag.AnonymousClass8 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return g.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("BIZENTERPRISE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.al.ag.AnonymousClass9 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return e.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("BIZADINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.al.ag.AnonymousClass10 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return q.SQL_CREATE;
            }
        });
        AppMethodBeat.o(124173);
    }

    public ag() {
        AppMethodBeat.i(124152);
        AppMethodBeat.o(124152);
    }

    private static synchronized ag baf() {
        ag agVar;
        synchronized (ag.class) {
            AppMethodBeat.i(124153);
            agVar = (ag) y.at(ag.class);
            AppMethodBeat.o(124153);
        }
        return agVar;
    }

    public static j bag() {
        AppMethodBeat.i(124154);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iOZ == null) {
            baf().iOZ = new j(com.tencent.mm.kernel.g.aAh().hqK);
        }
        j jVar = baf().iOZ;
        AppMethodBeat.o(124154);
        return jVar;
    }

    public static f bah() {
        AppMethodBeat.i(124155);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iOW == null) {
            baf().iOW = new f(com.tencent.mm.kernel.g.aAh().hqK);
        }
        f fVar = baf().iOW;
        AppMethodBeat.o(124155);
        return fVar;
    }

    public static i bai() {
        AppMethodBeat.i(124156);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iPa == null) {
            baf().iPa = new i();
            i iVar = baf().iPa;
            com.tencent.mm.kernel.g.aAg().hqi.a(675, iVar);
            com.tencent.mm.kernel.g.aAg().hqi.a(672, iVar);
            com.tencent.mm.kernel.g.aAg().hqi.a(674, iVar);
            synchronized (iVar.duI) {
                try {
                    iVar.iOm.clear();
                } catch (Throwable th) {
                    AppMethodBeat.o(124156);
                    throw th;
                }
            }
            iVar.iOj.iOn = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_biz_kf_guide_appbrand_enable, 0) == 1 || BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED;
            iVar.iOj.appId = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_biz_kf_guide_appbrand_appid, "wx3591b9dad10767f7");
            iVar.iOj.path = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_biz_kf_guide_appbrand_path, "pages/profile/profile.html");
            iVar.iOj.iOo = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_biz_kf_guide_appbrand_version_type, 0);
            Log.i("MicroMsg.BizKFService", "alvinluo initKFGuideAppBrandConfig: %s", iVar.iOj);
        }
        i iVar2 = baf().iPa;
        AppMethodBeat.o(124156);
        return iVar2;
    }

    public static d baj() {
        AppMethodBeat.i(124157);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iPb == null) {
            baf().iPb = new d(com.tencent.mm.kernel.g.aAh().hqK);
        }
        d dVar = baf().iPb;
        AppMethodBeat.o(124157);
        return dVar;
    }

    public static com.tencent.mm.al.a.b bak() {
        AppMethodBeat.i(124158);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iPd == null) {
            baf().iPd = new com.tencent.mm.al.a.b(com.tencent.mm.kernel.g.aAh().hqK);
        }
        com.tencent.mm.al.a.b bVar = baf().iPd;
        AppMethodBeat.o(124158);
        return bVar;
    }

    public static l bal() {
        AppMethodBeat.i(124159);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iPe == null) {
            baf().iPe = new l(com.tencent.mm.kernel.g.aAh().hqK);
        }
        l lVar = baf().iPe;
        AppMethodBeat.o(124159);
        return lVar;
    }

    public static g bam() {
        AppMethodBeat.i(124160);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iPf == null) {
            baf().iPf = new g(com.tencent.mm.kernel.g.aAh().hqK);
        }
        g gVar = baf().iPf;
        AppMethodBeat.o(124160);
        return gVar;
    }

    public static aa ban() {
        AppMethodBeat.i(124161);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iPj == null) {
            baf().iPj = new aa(com.tencent.mm.kernel.g.aAh().hqK);
        }
        aa aaVar = baf().iPj;
        AppMethodBeat.o(124161);
        return aaVar;
    }

    public static q bao() {
        AppMethodBeat.i(212190);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iPc == null) {
            baf().iPc = new q(com.tencent.mm.kernel.g.aAh().hqK);
        }
        q qVar = baf().iPc;
        AppMethodBeat.o(212190);
        return qVar;
    }

    public static ae bap() {
        AppMethodBeat.i(124162);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iPk == null) {
            baf().iPk = new ae(com.tencent.mm.kernel.g.aAh().hqK);
        }
        ae aeVar = baf().iPk;
        AppMethodBeat.o(124162);
        return aeVar;
    }

    public static com.tencent.mm.al.a.h baq() {
        AppMethodBeat.i(124163);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iPh == null) {
            baf().iPh = new com.tencent.mm.al.a.h();
        }
        com.tencent.mm.al.a.h hVar = baf().iPh;
        AppMethodBeat.o(124163);
        return hVar;
    }

    public static e bar() {
        AppMethodBeat.i(124164);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iPi == null) {
            baf().iPi = new e(com.tencent.mm.kernel.g.aAh().hqK);
        }
        e eVar = baf().iPi;
        AppMethodBeat.o(124164);
        return eVar;
    }

    public static o.a bas() {
        AppMethodBeat.i(124165);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iOX == null) {
            baf().iOX = new o.a();
        }
        o.a aVar = baf().iOX;
        AppMethodBeat.o(124165);
        return aVar;
    }

    public static l bat() {
        AppMethodBeat.i(124166);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iOY == null) {
            baf().iOY = new l();
        }
        l lVar = baf().iOY;
        AppMethodBeat.o(124166);
        return lVar;
    }

    public static a bau() {
        AppMethodBeat.i(124167);
        if (baf().iPl == null) {
            baf().iPl = new a();
        }
        a aVar = baf().iPl;
        AppMethodBeat.o(124167);
        return aVar;
    }

    public static i bav() {
        AppMethodBeat.i(124168);
        com.tencent.mm.kernel.g.aAf().azk();
        if (baf().iPg == null) {
            baf().iPg = new i();
        }
        i iVar = baf().iPg;
        AppMethodBeat.o(124168);
        return iVar;
    }

    public static long baw() {
        Object obj;
        AppMethodBeat.i(124169);
        if (iOV == 0 && (obj = com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG, (Object) null)) != null && (obj instanceof Long)) {
            iOV = ((Long) obj).longValue();
            Log.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime : %d.(get from ConfigStorage)", Long.valueOf(iOV));
        }
        if (iOV == 0) {
            iOV = System.currentTimeMillis();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_NEED_TO_UPDATE_CONVERSATION_TIME_DIVIDER_LONG, Long.valueOf(iOV));
            Log.i("MicroMsg.SubCoreBiz", "temp session needUpdateTime is 0, so get current time : %d.", Long.valueOf(iOV));
        }
        long j2 = iOV;
        AppMethodBeat.o(124169);
        return j2;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(124170);
        h.d.a(55, this.iDE);
        h.d.a(57, this.iDE);
        ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().c(this.iPn);
        bah().a(this.iPo, (Looper) null);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("mmbizattrappsvr_BizAttrSync", this.iPm, true);
        AppMethodBeat.o(124170);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(124171);
        h.d.b(55, this.iDE);
        h.d.b(57, this.iDE);
        if (baf().iPa != null) {
            i iVar = baf().iPa;
            com.tencent.mm.kernel.g.aAg().hqi.b(675, iVar);
            com.tencent.mm.kernel.g.aAg().hqi.b(672, iVar);
            com.tencent.mm.kernel.g.aAg().hqi.b(674, iVar);
            synchronized (iVar.duI) {
                try {
                    iVar.iOm.clear();
                } catch (Throwable th) {
                    AppMethodBeat.o(124171);
                    throw th;
                }
            }
            iVar.iOl.clear();
        }
        if (com.tencent.mm.kernel.g.aAf().azp()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().d(this.iPn);
            bah().a(this.iPo);
        }
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("mmbizattrappsvr_BizAttrSync", this.iPm, true);
        AppMethodBeat.o(124171);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    static /* synthetic */ void m(c cVar) {
        AppMethodBeat.i(124172);
        if (cVar.UG() && !cVar.UH() && cVar.cG(false) != null && cVar.cG(false).Vh() != null && !Util.isNullOrNil(cVar.UN())) {
            if (((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(cVar.UN()) == null) {
                Log.d("MicroMsg.SubCoreBiz", "father conv is null");
            }
            if (((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(cVar.field_username) == null) {
                Log.v("MicroMsg.SubCoreBiz", "add empty conv for enterprise child %s", cVar.field_username);
                az azVar = new az(cVar.field_username);
                Log.i("MicroMsg.SubCoreBiz", "Enterprise belong %s, userName: %s", cVar.UN(), cVar.field_username);
                azVar.Co(Util.nullAsNil(cVar.UN()));
                azVar.gCr();
                ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().e(azVar);
            }
        }
        AppMethodBeat.o(124172);
    }
}
