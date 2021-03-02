package com.tencent.mm.plugin.ipcall.model.d;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.euh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.LinkedList;

public final class a {
    public v2protocal yqF = new v2protocal(this.yqG);
    private MMHandler yqG = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.ipcall.model.d.a.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(25437);
            if (message == null || message.what != 59998) {
                super.handleMessage(message);
                AppMethodBeat.o(25437);
                return;
            }
            Log.d("MicroMsg.IPCallEngineManager", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
            switch (message.arg1) {
                case 3:
                    Log.d("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEV");
                    AppMethodBeat.o(25437);
                    return;
                case 4:
                    Log.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEVFAILED");
                    a aVar = a.this;
                    Log.d("MicroMsg.IPCallEngineManager", "handleStartDevFailed");
                    if (aVar.yqK != null) {
                        aVar.yqK.dZO();
                    }
                    AppMethodBeat.o(25437);
                    return;
                case 5:
                    Log.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_RESET");
                    if (message.arg2 == 4) {
                        Log.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_BROKEN");
                        a.a(a.this, 34);
                        AppMethodBeat.o(25437);
                        return;
                    } else if (message.arg2 == 1) {
                        Log.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_FAIL");
                        a.a(a.this, 20);
                        AppMethodBeat.o(25437);
                        return;
                    } else if (message.arg2 == 5) {
                        Log.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_NETWORK_ERROR");
                        a.a(a.this, 30);
                        AppMethodBeat.o(25437);
                        return;
                    }
                    break;
                case 6:
                    a aVar2 = a.this;
                    Log.d("MicroMsg.IPCallEngineManager", "channel connect!");
                    if (aVar2.yqI) {
                        Log.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
                        AppMethodBeat.o(25437);
                        return;
                    }
                    int startEngine = aVar2.yqF.startEngine();
                    Log.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", Integer.valueOf(startEngine));
                    if (startEngine == 0) {
                        aVar2.yqF.Hbh = 0;
                    } else {
                        aVar2.yqF.Hbh = 1;
                    }
                    aVar2.yqF.setInactive();
                    aVar2.yqI = true;
                    if (aVar2.yqK != null) {
                        aVar2.yqK.dZP();
                    }
                    AppMethodBeat.o(25437);
                    return;
                case 9:
                    Log.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_FIRST_PKT");
                    AppMethodBeat.o(25437);
                    return;
                case 10:
                    Log.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_ANSWER_MARK");
                    Log.i("MicroMsg.IPCallEngineManager", "handleChannelAccept");
                    g eas = i.eas();
                    Log.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
                    if (!eas.dWM) {
                        eas.yoY = true;
                        if (eas.yoW != null) {
                            eas.yoW.lPy = 2;
                            bg.azz().a(new o(eas.yoW.roomId, eas.yoW.ypH, eas.yoW.eaI(), eas.yoW.ypI, true), 0);
                        }
                        eas.Pc(2);
                        break;
                    } else {
                        Log.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
                        AppMethodBeat.o(25437);
                        return;
                    }
            }
            AppMethodBeat.o(25437);
        }
    };
    private boolean yqH = false;
    public boolean yqI = false;
    public boolean yqJ = false;
    public AbstractC1443a yqK = null;

    /* renamed from: com.tencent.mm.plugin.ipcall.model.d.a$a  reason: collision with other inner class name */
    public interface AbstractC1443a {
        void OX(int i2);

        void dZO();

        void dZP();
    }

    public a() {
        AppMethodBeat.i(25438);
        AppMethodBeat.o(25438);
    }

    public final void eaM() {
        AppMethodBeat.i(25439);
        Log.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
        if (!this.yqI) {
            Log.d("MicroMsg.IPCallEngineManager", "channel not connect now");
        }
        this.yqF.setActive();
        AppMethodBeat.o(25439);
    }

    public final void eaN() {
        int length;
        AppMethodBeat.i(25440);
        if (this.yqH) {
            Log.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
            AppMethodBeat.o(25440);
            return;
        }
        Log.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
        c cVar = i.eas().yoW;
        if (cVar != null) {
            if (cVar.oMr != null) {
                com.tencent.mm.plugin.ipcall.a.c.bc(cVar.oMr);
                com.tencent.mm.plugin.ipcall.a.c.bc(cVar.yqe);
                euh euh = new euh();
                euh.oXT = 0;
                euh.GWx = 0;
                euh.GWw = 0;
                euh.userName = "";
                euh.dQC = "";
            }
            Log.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
            this.yqF.HaA = cVar.ypZ;
            this.yqF.HbJ = cVar.yqc;
            if (cVar.yqd != null) {
                this.yqF.HbK = cVar.yqd.toByteArray();
            }
            if (cVar.yqa != null) {
                this.yqF.HaB = cVar.yqa.toByteArray();
            }
            this.yqF.roomId = cVar.roomId;
            this.yqF.ypH = cVar.ypH;
            this.yqF.ypO = cVar.ypO;
            this.yqF.HaD = cVar.ypX;
            this.yqF.HaC = cVar.ypY;
            this.yqF.HaE = cVar.yqf;
            if (this.yqF.HaB == null) {
                length = 0;
            } else {
                length = this.yqF.HaB.length;
            }
            int configInfo = this.yqF.setConfigInfo(this.yqF.Hav, (long) this.yqF.roomId, this.yqF.ypO, this.yqF.ypH, this.yqF.field_peerId, 1, this.yqF.HaC, this.yqF.HaD, this.yqF.HaA, length, this.yqF.HaB, this.yqF.HaE, 0, 0, this.yqF.HbJ, this.yqF.HbK, 255, 0, 0, null, 0, 0, 0, 0, "", "", 0);
            Log.d("MicroMsg.IPCallEngineManager", "setConfigInfo, ret: %d", Integer.valueOf(configInfo));
            if (configInfo == 0) {
                dml dml = new dml();
                dml.LqX = 0;
                dml.LqY = "";
                dml.LqZ = "";
                dml.Lra = 4;
                dml.Lrb = 4;
                dml.Lrc = 2;
                dml.MPX = com.tencent.mm.plugin.ipcall.a.c.bc(cVar.oMr);
                dml.MPY = com.tencent.mm.plugin.ipcall.a.c.bc(cVar.yqe);
                dmm dmm = new dmm();
                dmm.MPZ = 1;
                dmm.MQa = new LinkedList<>();
                dmm.MQa.add(dml);
                try {
                    this.yqF.HbZ = dmm.toByteArray();
                } catch (Exception e2) {
                    Log.e("MicroMsg.IPCallEngineManager", "relay conn info to byte array fail..");
                }
                if (this.yqF.HbZ == null) {
                    e.Loge("MicroMsg.IPCallEngineManager", "relay conns buf null");
                    if (this.yqK != null) {
                        this.yqK.OX(21);
                    }
                } else {
                    int AddNewRelayConns = this.yqF.AddNewRelayConns(this.yqF.HbZ, this.yqF.HbZ.length, 0);
                    if (AddNewRelayConns < 0) {
                        e.Loge("MicroMsg.IPCallEngineManager", "add relayconns err:".concat(String.valueOf(AddNewRelayConns)));
                        if (this.yqK != null) {
                            this.yqK.OX(21);
                        }
                    }
                }
            } else if (configInfo < 0) {
                Log.e("MicroMsg.IPCallEngineManager", "setConfigInfo failed, ret: %d", Integer.valueOf(configInfo));
                if (this.yqK != null) {
                    this.yqK.OX(21);
                }
            }
            this.yqH = true;
        }
        AppMethodBeat.o(25440);
    }

    public final void Pd(int i2) {
        AppMethodBeat.i(25441);
        if (!this.yqI) {
            AppMethodBeat.o(25441);
            return;
        }
        Log.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", Integer.valueOf(i2));
        int SetDTMFPayload = this.yqF.SetDTMFPayload(i2);
        if (SetDTMFPayload < 0) {
            Log.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", Integer.valueOf(SetDTMFPayload));
        }
        AppMethodBeat.o(25441);
    }

    public final void resetStatus() {
        this.yqI = false;
        this.yqH = false;
        this.yqJ = false;
    }

    static /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(25443);
        Log.d("MicroMsg.IPCallEngineManager", "channel connect failed!");
        if (aVar.yqK != null) {
            aVar.yqK.OX(i2);
        }
        AppMethodBeat.o(25443);
    }
}
