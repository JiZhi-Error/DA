package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.appbrand.jsapi.pay.g;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.protocal.protobuf.cuy;
import com.tencent.mm.protocal.protobuf.cuz;
import com.tencent.mm.protocal.protobuf.eci;
import com.tencent.mm.protocal.protobuf.eih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

final class b {
    final ReentrantLock dgE;
    final Condition szi;
    final Condition szj;

    b() {
        AppMethodBeat.i(121862);
        cbk cNI = cNI();
        if (cNI == null) {
            cbk cbk = new cbk();
            cbk.bwA = 10;
            a(cbk);
        } else if (cNI.bwA <= 0) {
            cNI.bwA = 10;
            a(cNI);
        }
        this.dgE = new ReentrantLock(true);
        this.szi = this.dgE.newCondition();
        this.szj = this.dgE.newCondition();
        AppMethodBeat.o(121862);
    }

    /* access modifiers changed from: package-private */
    public final a cNG() {
        cbk cbk;
        a aVar;
        AppMethodBeat.i(121863);
        ReentrantLock reentrantLock = this.dgE;
        reentrantLock.lockInterruptibly();
        while (cNH() == 0) {
            try {
                this.szi.await();
            } finally {
                reentrantLock.unlock();
                AppMethodBeat.o(121863);
            }
        }
        cbk cNI = cNI();
        if (cNI == null) {
            cbk cbk2 = new cbk();
            a(cbk2);
            cbk = cbk2;
        } else {
            cbk = cNI;
        }
        cbj pollFirst = cbk.Mhm.pollFirst();
        a(cbk);
        this.szj.signal();
        if (pollFirst == null) {
            aVar = null;
        } else {
            a aVar2 = new a();
            switch (pollFirst.msgType) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 300:
                case 301:
                    aVar2.szh = Long.valueOf(pollFirst.timestamp);
                    aVar2.msgType = pollFirst.msgType;
                    break;
                case 5:
                    bfk bfk = new bfk();
                    bfk.LOX = new eih();
                    if (pollFirst.Mhe != null) {
                        bfk.LOX.activityName = pollFirst.Mhe.activityName;
                        bfk.LOX.aHK = pollFirst.Mhe.aHK;
                        bfk.LOX.timestamp = pollFirst.Mhe.timestamp;
                    }
                    bfk.LPa = pollFirst.LPa;
                    bfk.LPb = pollFirst.LPb;
                    bfk.LOY = pollFirst.LOY;
                    bfk.LOZ = pollFirst.LOZ;
                    bfk.LPc = pollFirst.LPc;
                    bfk.timestamp = pollFirst.timestamp;
                    aVar2.msgType = 5;
                    aVar2.szh = bfk;
                    break;
                case 6:
                    bfj bfj = new bfj();
                    bfj.LOX = new eih();
                    if (pollFirst.Mhe != null) {
                        bfj.LOX.activityName = pollFirst.Mhe.activityName;
                        bfj.LOX.aHK = pollFirst.Mhe.aHK;
                        bfj.LOX.timestamp = pollFirst.Mhe.timestamp;
                    }
                    bfj.LOY = pollFirst.LOY;
                    bfj.LOZ = pollFirst.LOZ;
                    bfj.timestamp = pollFirst.timestamp;
                    aVar2.msgType = 6;
                    aVar2.szh = bfj;
                    break;
                case 100:
                    eci eci = new eci();
                    eci.Mhd = new eih();
                    if (pollFirst.Mhd != null) {
                        eci.Mhd.activityName = pollFirst.Mhd.activityName;
                        eci.Mhd.aHK = pollFirst.Mhd.aHK;
                        eci.Mhd.timestamp = pollFirst.Mhd.timestamp;
                    }
                    eci.Mhe = new eih();
                    if (pollFirst.Mhe != null) {
                        eci.Mhe.activityName = pollFirst.Mhe.activityName;
                        eci.Mhe.aHK = pollFirst.Mhe.aHK;
                        eci.Mhe.timestamp = pollFirst.Mhe.timestamp;
                    }
                    eci.LPb = pollFirst.LPb;
                    eci.LOY = pollFirst.LOY;
                    eci.flags = pollFirst.flags;
                    eci.LPa = pollFirst.LPa;
                    eci.Mhf = pollFirst.Mhf;
                    eci.Mhg = pollFirst.Mhg;
                    eci.timestamp = pollFirst.timestamp;
                    aVar2.msgType = 100;
                    aVar2.szh = eci;
                    break;
                case 101:
                    eih eih = new eih();
                    if (pollFirst.Mhe != null) {
                        eih.activityName = pollFirst.Mhe.activityName;
                        eih.aHK = pollFirst.Mhe.aHK;
                        eih.timestamp = pollFirst.Mhe.timestamp;
                    }
                    aVar2.msgType = 101;
                    aVar2.szh = eih;
                    break;
                case 102:
                    cri cri = new cri();
                    cri.LOX = new eih();
                    if (pollFirst.Mhe != null) {
                        cri.LOX.activityName = pollFirst.Mhe.activityName;
                        cri.LOX.aHK = pollFirst.Mhe.aHK;
                        cri.LOX.timestamp = pollFirst.Mhe.timestamp;
                    }
                    cri.Mhi = pollFirst.Mhi;
                    aVar2.msgType = 102;
                    aVar2.szh = cri;
                    break;
                case 200:
                    cuy cuy = new cuy();
                    cuy.LOX = new eih();
                    if (pollFirst.Mhe != null) {
                        cuy.LOX.activityName = pollFirst.Mhe.activityName;
                        cuy.LOX.aHK = pollFirst.Mhe.aHK;
                        cuy.LOX.timestamp = pollFirst.Mhe.timestamp;
                    }
                    cuy.flags = pollFirst.flags;
                    aVar2.msgType = 200;
                    aVar2.szh = cuy;
                    break;
                case 201:
                    cuy cuy2 = new cuy();
                    cuy2.LOX = new eih();
                    if (pollFirst.Mhe != null) {
                        cuy2.LOX.activityName = pollFirst.Mhe.activityName;
                        cuy2.LOX.aHK = pollFirst.Mhe.aHK;
                        cuy2.LOX.timestamp = pollFirst.Mhe.timestamp;
                    }
                    cuy2.flags = pollFirst.flags;
                    aVar2.msgType = 201;
                    aVar2.szh = cuy2;
                    break;
                case 202:
                    eih eih2 = new eih();
                    if (pollFirst.Mhe != null) {
                        eih2.activityName = pollFirst.Mhe.activityName;
                        eih2.aHK = pollFirst.Mhe.aHK;
                        eih2.timestamp = pollFirst.Mhe.timestamp;
                    }
                    aVar2.msgType = 202;
                    aVar2.szh = eih2;
                    break;
                case 203:
                    cuz cuz = new cuz();
                    cuz.LOX = new eih();
                    if (pollFirst.Mhe != null) {
                        cuz.LOX.activityName = pollFirst.Mhe.activityName;
                        cuz.LOX.aHK = pollFirst.Mhe.aHK;
                        cuz.LOX.timestamp = pollFirst.Mhe.timestamp;
                    }
                    cuz.LPb = pollFirst.LPb;
                    cuz.Mhh = pollFirst.Mhh;
                    cuz.LOY = pollFirst.LOY;
                    aVar2.msgType = 203;
                    aVar2.szh = cuz;
                    break;
                case 204:
                    eih eih3 = new eih();
                    if (pollFirst.Mhe != null) {
                        eih3.activityName = pollFirst.Mhe.activityName;
                        eih3.aHK = pollFirst.Mhe.aHK;
                        eih3.timestamp = pollFirst.Mhe.timestamp;
                    }
                    aVar2.msgType = 204;
                    aVar2.szh = eih3;
                    break;
                case 205:
                    cuz cuz2 = new cuz();
                    cuz2.LOX = new eih();
                    if (pollFirst.Mhe != null) {
                        cuz2.LOX.activityName = pollFirst.Mhe.activityName;
                        cuz2.LOX.aHK = pollFirst.Mhe.aHK;
                        cuz2.LOX.timestamp = pollFirst.Mhe.timestamp;
                    }
                    cuz2.LPb = pollFirst.LPb;
                    cuz2.Mhh = pollFirst.Mhh;
                    cuz2.LOY = pollFirst.LOY;
                    aVar2.msgType = 205;
                    aVar2.szh = cuz2;
                    break;
                case 206:
                    eih eih4 = new eih();
                    if (pollFirst.Mhe != null) {
                        eih4.activityName = pollFirst.Mhe.activityName;
                        eih4.aHK = pollFirst.Mhe.aHK;
                        eih4.timestamp = pollFirst.Mhe.timestamp;
                    }
                    aVar2.msgType = 206;
                    aVar2.szh = eih4;
                    break;
                case 207:
                    eih eih5 = new eih();
                    if (pollFirst.Mhe != null) {
                        eih5.activityName = pollFirst.Mhe.activityName;
                        eih5.aHK = pollFirst.Mhe.aHK;
                        eih5.timestamp = pollFirst.Mhe.timestamp;
                    }
                    aVar2.msgType = 207;
                    aVar2.szh = eih5;
                    break;
                case 208:
                    aVar2.szh = Long.valueOf(pollFirst.timestamp);
                    aVar2.msgType = 208;
                    break;
                case 209:
                    aVar2.msgType = 209;
                    break;
                case 210:
                    aVar2.szh = Integer.valueOf(pollFirst.flags);
                    aVar2.msgType = 210;
                    break;
                case 211:
                    aVar2.szh = Long.valueOf(pollFirst.timestamp);
                    aVar2.msgType = 211;
                    break;
                case 212:
                    aVar2.szh = Long.valueOf(pollFirst.timestamp);
                    aVar2.msgType = 212;
                    break;
                case 213:
                    aVar2.msgType = 213;
                    break;
                case 214:
                    aVar2.msgType = 214;
                    break;
                case 215:
                    aVar2.msgType = 215;
                    break;
                case 216:
                    aVar2.msgType = 216;
                    break;
                case 217:
                    aVar2.szh = Long.valueOf(pollFirst.timestamp);
                    aVar2.msgType = 217;
                    break;
                case 218:
                    aVar2.szh = Long.valueOf(pollFirst.timestamp);
                    aVar2.msgType = 218;
                    break;
                case TbsListener.ErrorCode.RENAME_EXCEPTION /*{ENCODED_INT: 219}*/:
                    aVar2.szh = Long.valueOf(pollFirst.timestamp);
                    aVar2.msgType = TbsListener.ErrorCode.RENAME_EXCEPTION;
                    break;
                case TbsListener.ErrorCode.COPY_INSTALL_SUCCESS /*{ENCODED_INT: 220}*/:
                    aVar2.szh = Long.valueOf(pollFirst.timestamp);
                    aVar2.msgType = TbsListener.ErrorCode.COPY_INSTALL_SUCCESS;
                    break;
                case TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS /*{ENCODED_INT: 221}*/:
                    aVar2.msgType = TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS;
                    break;
                case TbsListener.ErrorCode.UNLZMA_FAIURE /*{ENCODED_INT: 222}*/:
                    aVar2.msgType = TbsListener.ErrorCode.UNLZMA_FAIURE;
                    aVar2.szh = pollFirst.LPa;
                    break;
                case 400:
                case 401:
                case 402:
                case 403:
                    aVar2.szh = Integer.valueOf(pollFirst.flags);
                    aVar2.msgType = pollFirst.msgType;
                    break;
                case 500:
                    aVar2.szh = pollFirst.Mhj;
                    aVar2.msgType = 500;
                    break;
                case 501:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 501;
                    break;
                case 502:
                    aVar2.szh = pollFirst.Mhj;
                    aVar2.msgType = 502;
                    break;
                case 503:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 503;
                    break;
                case 504:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 504;
                    break;
                case 600:
                    aVar2.msgType = pollFirst.msgType;
                    break;
                case 700:
                    aVar2.msgType = 700;
                    break;
                case 701:
                    aVar2.msgType = 701;
                    break;
                case 702:
                    aVar2.msgType = 702;
                    break;
                case 703:
                    aVar2.msgType = 703;
                    break;
                case 704:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 704;
                    break;
                case 705:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 705;
                    break;
                case 706:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 706;
                    break;
                case 707:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 707;
                    break;
                case 708:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 708;
                    break;
                case 709:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 709;
                    break;
                case 710:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 710;
                    break;
                case 711:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 711;
                    break;
                case 712:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 712;
                    break;
                case 713:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 713;
                    break;
                case g.CTRL_INDEX:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = g.CTRL_INDEX;
                    break;
                case 715:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 715;
                    break;
                case 716:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 716;
                    break;
                case 717:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 717;
                    break;
                case 718:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 718;
                    break;
                case 719:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 719;
                    break;
                case TAVExporter.VIDEO_EXPORT_WIDTH /*{ENCODED_INT: 720}*/:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = TAVExporter.VIDEO_EXPORT_WIDTH;
                    break;
                case 721:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 721;
                    break;
                case 722:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 722;
                    break;
                case 723:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 723;
                    break;
                case 724:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 724;
                    break;
                case 725:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 725;
                    break;
                case 726:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 726;
                    break;
                case 727:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 727;
                    break;
                case 728:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 728;
                    break;
                case 729:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 729;
                    break;
                case TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH /*{ENCODED_INT: 730}*/:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH;
                    break;
                case 731:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 731;
                    break;
                case TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION /*{ENCODED_INT: 732}*/:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
                    break;
                case 733:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 733;
                    break;
                case a.CTRL_INDEX:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = a.CTRL_INDEX;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.b.CTRL_INDEX:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.b.CTRL_INDEX;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.b.CTRL_INDEX:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a.b.CTRL_INDEX;
                    break;
                case c.CTRL_INDEX:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = c.CTRL_INDEX;
                    break;
                case 738:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 738;
                    break;
                case 739:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 739;
                    break;
                case 740:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 740;
                    break;
                case 741:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 741;
                    break;
                case 742:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 742;
                    break;
                case 743:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 743;
                    break;
                case 744:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 744;
                    break;
                case 745:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 745;
                    break;
                case 746:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = 746;
                    break;
                case av.CTRL_INDEX:
                    aVar2.szh = pollFirst.Mhf;
                    aVar2.msgType = av.CTRL_INDEX;
                    break;
                case 800:
                    aVar2.szh = pollFirst.Mhk;
                    aVar2.msgType = 800;
                    break;
                case 801:
                    aVar2.szh = pollFirst.Mhl;
                    aVar2.msgType = 801;
                    break;
            }
            aVar = aVar2;
        }
        return aVar;
    }

    static int cNH() {
        AppMethodBeat.i(121864);
        cbk cNI = cNI();
        if (cNI == null) {
            AppMethodBeat.o(121864);
            return 0;
        }
        int size = cNI.Mhm.size();
        AppMethodBeat.o(121864);
        return size;
    }

    static void a(cbk cbk) {
        AppMethodBeat.i(121865);
        if (cbk == null) {
            AppMethodBeat.o(121865);
            return;
        }
        try {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("key_hellhound_msgQ", cbk.toByteArray());
            AppMethodBeat.o(121865);
        } catch (IOException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellMsgQDao", e2, "HellMsgQDao, _write, crash: %s", e2.getMessage());
            AppMethodBeat.o(121865);
        }
    }

    static cbk cNI() {
        AppMethodBeat.i(121866);
        byte[] bytes = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("key_hellhound_msgQ");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(121866);
            return null;
        }
        cbk cbk = new cbk();
        try {
            cbk.parseFrom(bytes);
            AppMethodBeat.o(121866);
            return cbk;
        } catch (IOException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellMsgQDao", e2, "HellMsgQDao, _read, crash: %s", e2.getMessage());
            AppMethodBeat.o(121866);
            return null;
        }
    }
}
