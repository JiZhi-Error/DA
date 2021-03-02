package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.aae;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.e;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.aa.model.a;
import com.tencent.mm.plugin.aa.model.a.c;
import com.tencent.mm.plugin.aa.model.a.d;
import com.tencent.mm.plugin.aa.model.i;
import com.tencent.mm.plugin.aa.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vending.g.d;
import java.util.HashMap;
import java.util.Map;

public class b implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    IListener<aae> jRA = new IListener<aae>() {
        /* class com.tencent.mm.plugin.aa.b.AnonymousClass6 */

        {
            AppMethodBeat.i(160786);
            this.__eventId = aae.class.getName().hashCode();
            AppMethodBeat.o(160786);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aae aae) {
            int i2;
            AppMethodBeat.i(63311);
            aae aae2 = aae;
            String str = aae2.egS.egU;
            aae.b bVar = aae2.egT;
            d blZ = b.blZ();
            if (d.jTI.containsKey(str)) {
                i2 = d.jTI.get(str).field_status;
            } else {
                c SD = blZ.SD(str);
                if (SD != null) {
                    d.jTI.put(str, SD);
                    i2 = SD.field_status;
                } else {
                    i2 = -1;
                }
            }
            bVar.status = i2;
            AppMethodBeat.o(63311);
            return false;
        }
    };
    private d jRB;
    private com.tencent.mm.plugin.aa.model.a.b jRC;
    private IListener<qq> jRv = new IListener<qq>() {
        /* class com.tencent.mm.plugin.aa.b.AnonymousClass1 */

        {
            AppMethodBeat.i(160782);
            this.__eventId = qq.class.getName().hashCode();
            AppMethodBeat.o(160782);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qq qqVar) {
            AppMethodBeat.i(63303);
            qq qqVar2 = qqVar;
            Object[] objArr = new Object[5];
            objArr[0] = Boolean.valueOf(qqVar2.dXe.content == null);
            objArr[1] = Integer.valueOf(qqVar2.dXe.type);
            objArr[2] = qqVar2.dXe.dRL;
            objArr[3] = qqVar2.dXe.toUser;
            objArr[4] = qqVar2.dXe.dXf;
            Log.i("MicroMsg.SubCoreAA", "receiveAANewXmlEventListener, content==null: %s, type: %s, fromUser: %s, toUser: %s, paymsgid: %s", objArr);
            if (qqVar2.dXe.type == a.jSf) {
                i.bW(qqVar2.dXe.content, qqVar2.dXe.toUser);
            } else if (qqVar2.dXe.type == a.jSg) {
                i.v(qqVar2.dXe.content, qqVar2.dXe.toUser, qqVar2.dXe.dXf);
            } else if (qqVar2.dXe.type == a.jSh) {
                String str = qqVar2.dXe.content;
                String str2 = qqVar2.dXe.toUser;
                String str3 = qqVar2.dXe.dXf;
                Log.i("MicroMsg.AAUtil", "insertUrgePaySysMsg, toUser: %s, paymsgid: %s", str2, str3);
                if (!Util.isNullOrNil(str)) {
                    com.tencent.mm.plugin.aa.model.a.a SC = b.bma().SC(str3);
                    if (SC == null || !SC.field_insertmsg) {
                        Log.i("MicroMsg.AAUtil", "insert new urge msg");
                        i.a(str, str2, SC, str3, true);
                    } else {
                        ca Hb = ((l) g.af(l.class)).eiy().Hb(SC.field_msgId);
                        Log.i("MicroMsg.AAUtil", "update old one, msgId: %s, dbMsginfo.id: %s", Long.valueOf(SC.field_msgId), Long.valueOf(Hb.field_msgId));
                        Hb.setContent(str);
                        ((l) g.af(l.class)).eiy().a(SC.field_msgId, Hb);
                    }
                }
            }
            AppMethodBeat.o(63303);
            return false;
        }
    };
    private IListener<qp> jRw = new IListener<qp>() {
        /* class com.tencent.mm.plugin.aa.b.AnonymousClass2 */

        {
            AppMethodBeat.i(160783);
            this.__eventId = qp.class.getName().hashCode();
            AppMethodBeat.o(160783);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qp qpVar) {
            AppMethodBeat.i(63304);
            qp qpVar2 = qpVar;
            long j2 = qpVar2.dXc.dXd;
            String str = qpVar2.dXc.dWG;
            Log.i("MicroMsg.SubCoreAA", "ReceiveAAMsgEvent, localMsgId: %s, msgContent: %s", Long.valueOf(j2), Util.secPrint(str));
            i.h(j2, str);
            AppMethodBeat.o(63304);
            return false;
        }
    };
    private IListener<cc> jRx = new IListener<cc>() {
        /* class com.tencent.mm.plugin.aa.b.AnonymousClass3 */

        {
            AppMethodBeat.i(160784);
            this.__eventId = cc.class.getName().hashCode();
            AppMethodBeat.o(160784);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(cc ccVar) {
            AppMethodBeat.i(63307);
            cc ccVar2 = ccVar;
            Log.i("MicroMsg.SubCoreAA", "closeAAEvent callback, billNo: %s, chatroom: %s", ccVar2.dFj.dFk, ccVar2.dFj.dFl);
            if (Util.isNullOrNil(ccVar2.dFj.dFk) || Util.isNullOrNil(ccVar2.dFj.dFl)) {
                AppMethodBeat.o(63307);
            } else {
                final k kVar = new k();
                kVar.bmm().init();
                k.a aVar = kVar.jSH;
                String str = ccVar2.dFj.dFk;
                int i2 = a.jSe;
                com.tencent.mm.vending.g.g.a(str, Integer.valueOf(i2), ccVar2.dFj.dFl, Long.valueOf(ccVar2.dFj.dFm)).c(aVar).d(new com.tencent.mm.vending.c.a<Void, Boolean>() {
                    /* class com.tencent.mm.plugin.aa.b.AnonymousClass3.AnonymousClass2 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Void call(Boolean bool) {
                        AppMethodBeat.i(63306);
                        Log.i("MicroMsg.SubCoreAA", "close aa success: %s", bool);
                        kVar.bmm().unInit();
                        Toast.makeText(MMApplicationContext.getContext(), (int) R.string.b5w, 0).show();
                        Void r0 = QZL;
                        AppMethodBeat.o(63306);
                        return r0;
                    }
                }).a(new d.a() {
                    /* class com.tencent.mm.plugin.aa.b.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.vending.g.d.a
                    public final void cn(Object obj) {
                        AppMethodBeat.i(63305);
                        if (obj instanceof String) {
                            Toast.makeText(MMApplicationContext.getContext(), obj.toString(), 0).show();
                        } else {
                            Log.e("MicroMsg.SubCoreAA", "close aa failed: %s", obj);
                            Toast.makeText(MMApplicationContext.getContext(), (int) R.string.b5y, 1).show();
                        }
                        kVar.bmm().unInit();
                        AppMethodBeat.o(63305);
                    }
                });
                AppMethodBeat.o(63307);
            }
            return false;
        }
    };
    private IListener<cd> jRy = new IListener<cd>() {
        /* class com.tencent.mm.plugin.aa.b.AnonymousClass4 */

        {
            AppMethodBeat.i(160785);
            this.__eventId = cd.class.getName().hashCode();
            AppMethodBeat.o(160785);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(cd cdVar) {
            AppMethodBeat.i(63309);
            final cd cdVar2 = cdVar;
            if (Util.isNullOrNil(cdVar2.dFn.dFk) || Util.isNullOrNil(cdVar2.dFn.dFl)) {
                AppMethodBeat.o(63309);
            } else {
                new com.tencent.mm.plugin.aa.model.cgi.d(cdVar2.dFn.dFk, cdVar2.dFn.dFl).aYI().h(new com.tencent.mm.vending.c.a<Void, c.a<com.tencent.mm.protocal.protobuf.c>>() {
                    /* class com.tencent.mm.plugin.aa.b.AnonymousClass4.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Void call(c.a<com.tencent.mm.protocal.protobuf.c> aVar) {
                        AppMethodBeat.i(63308);
                        c.a<com.tencent.mm.protocal.protobuf.c> aVar2 = aVar;
                        Log.i("MicroMsg.SubCoreAA", "close aa urge notify cgiback, errType: %s, errCode: %s", Integer.valueOf(aVar2.errType), Integer.valueOf(aVar2.errCode));
                        if (aVar2.errType == 0 && aVar2.errCode == 0) {
                            Log.i("MicroMsg.SubCoreAA", "close aa urge notify success");
                            if (((com.tencent.mm.protocal.protobuf.c) aVar2.iLC).dDN > 0 && !Util.isNullOrNil(((com.tencent.mm.protocal.protobuf.c) aVar2.iLC).qwn)) {
                                Toast.makeText(MMApplicationContext.getContext(), ((com.tencent.mm.protocal.protobuf.c) aVar2.iLC).qwn, 0).show();
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(407, 29, 1, false);
                            } else if (((com.tencent.mm.protocal.protobuf.c) aVar2.iLC).dDN == 0) {
                                Toast.makeText(MMApplicationContext.getContext(), (int) R.string.b5w, 0).show();
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(407, 27, 1, false);
                                if (!Util.isNullOrNil(((com.tencent.mm.protocal.protobuf.c) aVar2.iLC).KBu)) {
                                    i.i(cdVar2.dFn.dFm, ((com.tencent.mm.protocal.protobuf.c) aVar2.iLC).KBu);
                                }
                            } else {
                                Log.i("MicroMsg.SubCoreAA", "illegal resp");
                                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(407, 29, 1, false);
                            }
                        } else {
                            Log.i("MicroMsg.SubCoreAA", "close aa urge notify failed");
                            Toast.makeText(MMApplicationContext.getContext(), (int) R.string.b5v, 1).show();
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(407, 28, 1, false);
                        }
                        Void r0 = QZL;
                        AppMethodBeat.o(63308);
                        return r0;
                    }
                });
                AppMethodBeat.o(63309);
            }
            return false;
        }
    };
    private q jRz = new q() {
        /* class com.tencent.mm.plugin.aa.b.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(63310);
            int i2 = Util.getInt(map.get(".sysmsg.paymsg.PayMsgType"), 0);
            Log.d("MicroMsg.SubCoreAA", "paymsgtype: %d, current version: %d", Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.protocal.d.KyO));
            if (i2 == 32) {
                int i3 = Util.getInt(map.get(".sysmsg.paymsg.receiveorpayreddot"), -1);
                int i4 = Util.getInt(map.get(".sysmsg.paymsg.grouppayreddot"), -1);
                int i5 = Util.getInt(map.get(".sysmsg.paymsg.facingreceivereddot"), -1);
                int i6 = Util.getInt(map.get(".sysmsg.paymsg.f2fhongbaoreddot"), -1);
                int i7 = Util.getInt(map.get(".sysmsg.paymsg.rewardcodereddot"), -1);
                int i8 = Util.getInt(map.get(".sysmsg.paymsg.android_minclientversion"), -1);
                String nullAs = Util.nullAs(map.get(".sysmsg.paymsg.facingreceivereddotwording"), "");
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_FACING_REDDOT_WORDING_STRING_SYNC, nullAs);
                Log.i("MicroMsg.SubCoreAA", "recvOrPay: %s, aa: %s, collect： %s, f2fhb: %s, qrreward: %s, version： %s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
                if (com.tencent.mm.protocal.d.KyO >= i8) {
                    boolean z = false;
                    if (i3 == 1) {
                        Log.i("MicroMsg.SubCoreAA", "mark recv or pay red dot");
                        com.tencent.mm.y.c.axV().B(262159, true);
                    } else if (i3 == 0) {
                        com.tencent.mm.y.c.axV().B(262159, false);
                    }
                    if (i4 == 1) {
                        Log.i("MicroMsg.SubCoreAA", "mark group pay red dot");
                        com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, true);
                        z = true;
                    } else if (i4 == 0) {
                        com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_GROUP_PAY_STRING_SYNC, false);
                    }
                    if (i5 == 1) {
                        Log.i("MicroMsg.SubCoreAA", "mark f2f recv red dot");
                        com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, true);
                        z = true;
                    } else if (i5 == 0) {
                        com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_F2F_COLLECT_STRING_SYNC, false);
                    }
                    if (i6 == 1) {
                        Log.i("MicroMsg.SubCoreAA", "mark f2f hb red dot");
                        com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, true);
                        z = true;
                    } else if (i6 == 0) {
                        com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_F2F_HB_STRING_SYNC, false);
                    }
                    if (i7 == 1) {
                        Log.i("MicroMsg.SubCoreAA", "mark qr reward red dot");
                        com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, true);
                        z = true;
                    } else if (i7 == 0) {
                        com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_QR_REWARD_STRING_SYNC, false);
                    }
                    if (z) {
                        g.aAh().azQ().set(ar.a.USERINFO_PAY_OR_RECV_HAS_SHOW_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE);
                    }
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14396, 1);
            }
            AppMethodBeat.o(63310);
        }
    };

    public b() {
        AppMethodBeat.i(63312);
        AppMethodBeat.o(63312);
    }

    private static b blY() {
        AppMethodBeat.i(63313);
        b bVar = (b) y.at(b.class);
        AppMethodBeat.o(63313);
        return bVar;
    }

    static {
        AppMethodBeat.i(63318);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("AARecord".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.aa.b.AnonymousClass7 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.aa.model.a.d.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("AAPayRecord".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.aa.b.AnonymousClass8 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.aa.model.a.b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(63318);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    public static com.tencent.mm.plugin.aa.model.a.d blZ() {
        AppMethodBeat.i(63314);
        if (blY().jRB == null) {
            b blY = blY();
            g.aAi();
            blY.jRB = new com.tencent.mm.plugin.aa.model.a.d(g.aAh().hqK);
        }
        com.tencent.mm.plugin.aa.model.a.d dVar = blY().jRB;
        AppMethodBeat.o(63314);
        return dVar;
    }

    public static com.tencent.mm.plugin.aa.model.a.b bma() {
        AppMethodBeat.i(63315);
        if (blY().jRC == null) {
            b blY = blY();
            g.aAi();
            blY.jRC = new com.tencent.mm.plugin.aa.model.a.b(g.aAh().hqK);
        }
        com.tencent.mm.plugin.aa.model.a.b bVar = blY().jRC;
        AppMethodBeat.o(63315);
        return bVar;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(63316);
        EventCenter.instance.addListener(this.jRv);
        EventCenter.instance.addListener(this.jRw);
        EventCenter.instance.addListener(this.jRx);
        EventCenter.instance.addListener(this.jRy);
        EventCenter.instance.addListener(this.jRA);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().a("paymsg", this.jRz);
        e.a(new com.tencent.mm.plugin.messenger.foundation.a.a() {
            /* class com.tencent.mm.plugin.aa.b.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.messenger.foundation.a.a
            public final void a(h.a aVar, ca caVar, String str, String str2, boolean z) {
                String str3;
                AppMethodBeat.i(184836);
                if (!z && caVar != null && !Util.isNullOrNil(caVar.field_content)) {
                    if (ao.isDarkMode()) {
                        str3 = "#7D90A9";
                    } else {
                        str3 = "#576B95";
                    }
                    caVar.setContent(caVar.field_content.replace("color=\"#037AFF\"", "color=\"" + str3 + "\""));
                }
                AppMethodBeat.o(184836);
            }

            @Override // com.tencent.mm.plugin.messenger.foundation.a.a
            public final void b(h.a aVar, ca caVar, String str, String str2, boolean z) {
            }
        });
        AppMethodBeat.o(63316);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(63317);
        EventCenter.instance.removeListener(this.jRv);
        EventCenter.instance.removeListener(this.jRw);
        EventCenter.instance.removeListener(this.jRx);
        EventCenter.instance.removeListener(this.jRy);
        EventCenter.instance.removeListener(this.jRA);
        ((s) g.ah(s.class)).getSysCmdMsgExtension().b("paymsg", this.jRz);
        AppMethodBeat.o(63317);
    }
}
