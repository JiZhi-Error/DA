package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import android.os.Message;
import com.tencent.f.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.appbrand.jsapi.pay.g;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.cbn;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.protocal.protobuf.cuy;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.protocal.protobuf.eci;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public final class e {
    private MMHandler szm;
    public d szn;
    b szo = new b();
    private final h szp = new h() {
        /* class com.tencent.mm.plugin.expt.hellhound.core.a.a.e.AnonymousClass1 */

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "hellhound-receive";
        }

        public final void run() {
            AppMethodBeat.i(121871);
            while (true) {
                try {
                    a cNG = e.this.szo.cNG();
                    if (cNG == null) {
                        Log.e("HABBYGE-MALI.MsgQ", "MsgQ, mReceiver, localMsg == null");
                    } else if (e.this.szn != null) {
                        e.this.szn.a(cNG);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("HABBYGE-MALI.MsgQ", e2, "MsgQ, mReceiver: %s", e2.getMessage());
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(932, 113, 1, false);
                }
            }
        }
    };

    e() {
        AppMethodBeat.i(121873);
        if (b.isMMProcess()) {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("key_hellhound_msgQ", new byte[0]);
        }
        this.szm = new a("hellhound_msgq");
        this.szm.setLogging(false);
        com.tencent.f.h.RTc.ba(this.szp);
        AppMethodBeat.o(121873);
    }

    /* access modifiers changed from: package-private */
    public final void b(a aVar) {
        AppMethodBeat.i(121874);
        Message obtainMessage = this.szm.obtainMessage();
        obtainMessage.what = 0;
        obtainMessage.obj = aVar;
        this.szm.sendMessage(obtainMessage);
        AppMethodBeat.o(121874);
    }

    final class a extends MMHandler {
        a(String str) {
            super(str);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            cbk cbk;
            cbj cbj;
            AppMethodBeat.i(121872);
            if (message == null || message.what != 0) {
                AppMethodBeat.o(121872);
                return;
            }
            try {
                a aVar = (a) message.obj;
                b bVar = e.this.szo;
                if (aVar != null) {
                    ReentrantLock reentrantLock = bVar.dgE;
                    reentrantLock.lockInterruptibly();
                    while (b.cNH() == 10) {
                        try {
                            bVar.szj.await();
                        } finally {
                            reentrantLock.unlock();
                            AppMethodBeat.o(121872);
                        }
                    }
                    cbk cNI = b.cNI();
                    if (cNI == null) {
                        cbk = new cbk();
                    } else {
                        cbk = cNI;
                    }
                    LinkedList<cbj> linkedList = cbk.Mhm;
                    if (aVar == null) {
                        cbj = null;
                    } else {
                        cbj cbj2 = new cbj();
                        switch (aVar.msgType) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 300:
                            case 301:
                                cbj2.timestamp = ((Long) aVar.szh).longValue();
                                cbj2.msgType = aVar.msgType;
                                break;
                            case 5:
                                bfk bfk = (bfk) aVar.szh;
                                cbj2.Mhe = new eih();
                                if (bfk.LOX != null) {
                                    cbj2.Mhe.activityName = bfk.LOX.activityName;
                                    cbj2.Mhe.aHK = bfk.LOX.aHK;
                                    cbj2.Mhe.timestamp = bfk.LOX.timestamp;
                                }
                                cbj2.LPa = bfk.LPa;
                                cbj2.LPb = bfk.LPb;
                                cbj2.LOY = bfk.LOY;
                                cbj2.LOZ = bfk.LOZ;
                                cbj2.LPc = bfk.LPc;
                                cbj2.timestamp = bfk.timestamp;
                                cbj2.msgType = 5;
                                break;
                            case 6:
                                bfj bfj = (bfj) aVar.szh;
                                cbj2.Mhe = new eih();
                                if (bfj.LOX != null) {
                                    cbj2.Mhe.activityName = bfj.LOX.activityName;
                                    cbj2.Mhe.aHK = bfj.LOX.aHK;
                                    cbj2.Mhe.timestamp = bfj.LOX.timestamp;
                                }
                                cbj2.LOY = bfj.LOY;
                                cbj2.LOZ = bfj.LOZ;
                                cbj2.timestamp = bfj.timestamp;
                                cbj2.msgType = 6;
                                break;
                            case 100:
                                eci eci = (eci) aVar.szh;
                                cbj2.Mhd = new eih();
                                if (eci.Mhd != null) {
                                    cbj2.Mhd.activityName = eci.Mhd.activityName;
                                    cbj2.Mhd.aHK = eci.Mhd.aHK;
                                    cbj2.Mhd.timestamp = eci.Mhd.timestamp;
                                }
                                cbj2.Mhe = new eih();
                                if (eci.Mhe != null) {
                                    cbj2.Mhe.activityName = eci.Mhe.activityName;
                                    cbj2.Mhe.aHK = eci.Mhe.aHK;
                                    cbj2.Mhe.timestamp = eci.Mhe.timestamp;
                                }
                                cbj2.LPb = eci.LPb;
                                cbj2.LOY = eci.LOY;
                                cbj2.flags = eci.flags;
                                cbj2.LPa = eci.LPa;
                                cbj2.Mhf = eci.Mhf;
                                cbj2.Mhg = eci.Mhg;
                                cbj2.timestamp = eci.timestamp;
                                cbj2.msgType = 100;
                                break;
                            case 101:
                                eih eih = (eih) aVar.szh;
                                cbj2.Mhe = new eih();
                                cbj2.Mhe.activityName = eih.activityName;
                                cbj2.Mhe.aHK = eih.aHK;
                                cbj2.Mhe.timestamp = eih.timestamp;
                                cbj2.msgType = 101;
                                break;
                            case 102:
                                cri cri = (cri) aVar.szh;
                                cbj2.Mhe = new eih();
                                cbj2.Mhe.activityName = cri.LOX.activityName;
                                cbj2.Mhe.aHK = cri.LOX.aHK;
                                cbj2.Mhe.timestamp = cri.LOX.timestamp;
                                cbj2.Mhi = cri.Mhi;
                                cbj2.msgType = 102;
                                break;
                            case 200:
                                cuy cuy = (cuy) aVar.szh;
                                cbj2.Mhe = new eih();
                                cbj2.Mhe.activityName = cuy.LOX.activityName;
                                cbj2.Mhe.aHK = cuy.LOX.aHK;
                                cbj2.Mhe.timestamp = cuy.LOX.timestamp;
                                cbj2.flags = cuy.flags;
                                cbj2.msgType = 200;
                                break;
                            case 201:
                                cuy cuy2 = (cuy) aVar.szh;
                                cbj2.Mhe = new eih();
                                cbj2.Mhe.activityName = cuy2.LOX.activityName;
                                cbj2.Mhe.aHK = cuy2.LOX.aHK;
                                cbj2.Mhe.timestamp = cuy2.LOX.timestamp;
                                cbj2.flags = cuy2.flags;
                                cbj2.msgType = 201;
                                break;
                            case 202:
                                eih eih2 = (eih) aVar.szh;
                                cbj2.Mhe = new eih();
                                cbj2.Mhe.activityName = eih2.activityName;
                                cbj2.Mhe.aHK = eih2.aHK;
                                cbj2.Mhe.timestamp = eih2.timestamp;
                                cbj2.msgType = 202;
                                break;
                            case 203:
                                cuz cuz = (cuz) aVar.szh;
                                cbj2.Mhe = new eih();
                                cbj2.Mhe.activityName = cuz.LOX.activityName;
                                cbj2.Mhe.aHK = cuz.LOX.aHK;
                                cbj2.Mhe.timestamp = cuz.LOX.timestamp;
                                cbj2.LPb = cuz.LPb;
                                cbj2.Mhh = cuz.Mhh;
                                cbj2.LOY = cuz.LOY;
                                cbj2.msgType = 203;
                                break;
                            case 204:
                                eih eih3 = (eih) aVar.szh;
                                cbj2.Mhe = new eih();
                                cbj2.Mhe.activityName = eih3.activityName;
                                cbj2.Mhe.aHK = eih3.aHK;
                                cbj2.Mhe.timestamp = eih3.timestamp;
                                cbj2.msgType = 204;
                                break;
                            case 205:
                                cuz cuz2 = (cuz) aVar.szh;
                                cbj2.Mhe = new eih();
                                cbj2.Mhe.activityName = cuz2.LOX.activityName;
                                cbj2.Mhe.aHK = cuz2.LOX.aHK;
                                cbj2.Mhe.timestamp = cuz2.LOX.timestamp;
                                cbj2.LPb = cuz2.LPb;
                                cbj2.Mhh = cuz2.Mhh;
                                cbj2.LOY = cuz2.LOY;
                                cbj2.msgType = 205;
                                break;
                            case 206:
                                eih eih4 = (eih) aVar.szh;
                                cbj2.Mhe = new eih();
                                cbj2.Mhe.activityName = eih4.activityName;
                                cbj2.Mhe.aHK = eih4.aHK;
                                cbj2.Mhe.timestamp = eih4.timestamp;
                                cbj2.msgType = 206;
                                break;
                            case 207:
                                eih eih5 = (eih) aVar.szh;
                                cbj2.Mhe = new eih();
                                cbj2.Mhe.activityName = eih5.activityName;
                                cbj2.Mhe.aHK = eih5.aHK;
                                cbj2.Mhe.timestamp = eih5.timestamp;
                                cbj2.msgType = 207;
                                break;
                            case 208:
                                cbj2.timestamp = ((Long) aVar.szh).longValue();
                                cbj2.msgType = 208;
                                break;
                            case 209:
                                cbj2.msgType = 209;
                                break;
                            case 210:
                                cbj2.flags = ((ben) aVar.szh).type;
                                cbj2.msgType = 210;
                                break;
                            case 211:
                                cbj2.timestamp = ((Long) aVar.szh).longValue();
                                cbj2.msgType = 211;
                                break;
                            case 212:
                                cbj2.timestamp = ((Long) aVar.szh).longValue();
                                cbj2.msgType = 212;
                                break;
                            case 213:
                                cbj2.msgType = 213;
                                break;
                            case 214:
                                cbj2.msgType = 214;
                                break;
                            case 215:
                                cbj2.msgType = 215;
                                break;
                            case 216:
                                cbj2.msgType = 216;
                                break;
                            case 217:
                                cbj2.timestamp = ((Long) aVar.szh).longValue();
                                cbj2.msgType = 217;
                                break;
                            case 218:
                                cbj2.timestamp = ((Long) aVar.szh).longValue();
                                cbj2.msgType = 218;
                                break;
                            case TbsListener.ErrorCode.RENAME_EXCEPTION /*{ENCODED_INT: 219}*/:
                                cbj2.timestamp = ((Long) aVar.szh).longValue();
                                cbj2.msgType = TbsListener.ErrorCode.RENAME_EXCEPTION;
                                break;
                            case TbsListener.ErrorCode.COPY_INSTALL_SUCCESS /*{ENCODED_INT: 220}*/:
                                cbj2.timestamp = ((Long) aVar.szh).longValue();
                                cbj2.msgType = TbsListener.ErrorCode.COPY_INSTALL_SUCCESS;
                                break;
                            case TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS /*{ENCODED_INT: 221}*/:
                                cbj2.msgType = TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS;
                                break;
                            case TbsListener.ErrorCode.UNLZMA_FAIURE /*{ENCODED_INT: 222}*/:
                                cbj2.LPa = (String) aVar.szh;
                                cbj2.msgType = TbsListener.ErrorCode.UNLZMA_FAIURE;
                                break;
                            case 400:
                            case 401:
                            case 402:
                            case 403:
                                cbj2.flags = ((Integer) aVar.szh).intValue();
                                cbj2.msgType = aVar.msgType;
                                break;
                            case 500:
                                cbj2.Mhj = (cbn) aVar.szh;
                                cbj2.msgType = 500;
                                break;
                            case 501:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 501;
                                break;
                            case 502:
                                cbj2.Mhj = (cbn) aVar.szh;
                                cbj2.msgType = 502;
                                break;
                            case 503:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 503;
                                break;
                            case 504:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 504;
                                break;
                            case 600:
                                cbj2.msgType = aVar.msgType;
                                break;
                            case 700:
                                cbj2.msgType = 700;
                                break;
                            case 701:
                                cbj2.msgType = 701;
                                break;
                            case 702:
                                cbj2.msgType = 702;
                                break;
                            case 703:
                                cbj2.msgType = 703;
                                break;
                            case 704:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 704;
                                break;
                            case 705:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 705;
                                break;
                            case 706:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 706;
                                break;
                            case 707:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 707;
                                break;
                            case 708:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 708;
                                break;
                            case 709:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 709;
                                break;
                            case 710:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 710;
                                break;
                            case 711:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 711;
                                break;
                            case 712:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 712;
                                break;
                            case 713:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 713;
                                break;
                            case g.CTRL_INDEX:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = g.CTRL_INDEX;
                                break;
                            case 715:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 715;
                                break;
                            case 716:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 716;
                                break;
                            case 717:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 717;
                                break;
                            case 718:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 718;
                                break;
                            case 719:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 719;
                                break;
                            case TAVExporter.VIDEO_EXPORT_WIDTH /*{ENCODED_INT: 720}*/:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = TAVExporter.VIDEO_EXPORT_WIDTH;
                                break;
                            case 721:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 721;
                                break;
                            case 722:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 722;
                                break;
                            case 723:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 723;
                                break;
                            case 724:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 724;
                                break;
                            case 725:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 725;
                                break;
                            case 726:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 726;
                                break;
                            case 727:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 727;
                                break;
                            case 728:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 728;
                                break;
                            case 729:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 729;
                                break;
                            case TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH /*{ENCODED_INT: 730}*/:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH;
                                break;
                            case 731:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 731;
                                break;
                            case TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION /*{ENCODED_INT: 732}*/:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
                                break;
                            case 733:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 733;
                                break;
                            case com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.a.CTRL_INDEX:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.a.CTRL_INDEX;
                                break;
                            case com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.b.CTRL_INDEX:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.b.CTRL_INDEX;
                                break;
                            case com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.b.CTRL_INDEX:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.b.CTRL_INDEX;
                                break;
                            case c.CTRL_INDEX:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = c.CTRL_INDEX;
                                break;
                            case 738:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 738;
                                break;
                            case 739:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 739;
                                break;
                            case 740:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 740;
                                break;
                            case 741:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 741;
                                break;
                            case 742:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 742;
                                break;
                            case 743:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 743;
                                break;
                            case 744:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 744;
                                break;
                            case 745:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 745;
                                break;
                            case 746:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = 746;
                                break;
                            case av.CTRL_INDEX:
                                cbj2.Mhf = (String) aVar.szh;
                                cbj2.msgType = av.CTRL_INDEX;
                                break;
                            case 800:
                                cbj2.Mhk = (erd) aVar.szh;
                                cbj2.msgType = 800;
                                break;
                            case 801:
                                cbj2.Mhl = (boj) aVar.szh;
                                cbj2.msgType = 801;
                                break;
                        }
                        cbj = cbj2;
                    }
                    linkedList.offerLast(cbj);
                    b.a(cbk);
                    bVar.szi.signal();
                    return;
                }
                AppMethodBeat.o(121872);
            } catch (Exception e2) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(932, 114, 1, false);
                AppMethodBeat.o(121872);
            }
        }
    }
}
