package com.tencent.mm.ui.chatting.d;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.o;
import com.tencent.mm.g.a.qv;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.n.h;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.aa;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.d.b.ao;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.util.LinkedList;
import java.util.List;

@a(gRF = ao.class)
public class az extends a implements i, i.a, ao {
    private static boolean PtV = false;
    private int PtU;
    private long PtW;
    private int gTn = -1;
    @SuppressLint({"HandlerLeak"})
    private MMHandler handler = new MMHandler() {
        /* class com.tencent.mm.ui.chatting.d.az.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(35597);
            if (az.this.dom == null || !az.this.dom.cQp) {
                AppMethodBeat.o(35597);
            } else if (!az.this.dom.Pwi) {
                Log.e("MicroMsg.SignallingComponent", "current ChattingUI lose focus!");
                az.this.dom.Pwj = true;
                AppMethodBeat.o(35597);
            } else {
                az.this.dom.Pwj = false;
                if (az.PtV) {
                    boolean unused = az.PtV = false;
                    ((aa) az.this.dom.bh(aa.class)).gPx();
                    az.this.dom.cmy();
                }
                AppMethodBeat.o(35597);
            }
        }
    };

    public az() {
        AppMethodBeat.i(35601);
        AppMethodBeat.o(35601);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ao
    public final void keepSignalling() {
        AppMethodBeat.i(35602);
        if (this.PtU == -2) {
            bg.azz().a(new bu(new bu.a() {
                /* class com.tencent.mm.ui.chatting.d.az.AnonymousClass3 */

                @Override // com.tencent.mm.model.bu.a
                public final void a(g gVar) {
                    AppMethodBeat.i(35599);
                    if (gVar == null) {
                        AppMethodBeat.o(35599);
                        return;
                    }
                    gVar.keepSignalling();
                    AppMethodBeat.o(35599);
                }
            }), 0);
        }
        AppMethodBeat.o(35602);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ao
    public final void stopSignalling() {
        AppMethodBeat.i(35603);
        bg.azz().a(new bu(new bu.a() {
            /* class com.tencent.mm.ui.chatting.d.az.AnonymousClass4 */

            @Override // com.tencent.mm.model.bu.a
            public final void a(g gVar) {
                AppMethodBeat.i(35600);
                if (gVar == null) {
                    AppMethodBeat.o(35600);
                    return;
                }
                gVar.stopSignalling();
                AppMethodBeat.o(35600);
            }
        }), 0);
        AppMethodBeat.o(35603);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.ao
    public final void amF(int i2) {
        List<ca> gQL;
        AppMethodBeat.i(35604);
        if (this.dom == null) {
            Log.e("MicroMsg.SignallingComponent", "[doDirectSend] mChattingContext is null!", Util.getStack().toString());
            AppMethodBeat.o(35604);
            return;
        }
        com.tencent.mm.ui.chatting.e.a aVar = this.dom;
        boolean z = aVar.gRL() || ((d) aVar.bh(d.class)).gOQ();
        int intValue = ((Integer) bg.aVD().get(35, 10)).intValue();
        LinkedList linkedList = new LinkedList();
        linkedList.add(aVar.getTalkerUserName());
        if (intValue == -2) {
            if (!z || !(i2 == 1 || i2 == 2)) {
                Log.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend done chatStatus:%d", Integer.valueOf(i2));
                bg.azz().a(new j(linkedList, o.iC(i2)), 0);
                AppMethodBeat.o(35604);
                return;
            }
            Log.d("MicroMsg.SignallingComponent", "oreh old logic doDirectSend not support chatStatus:%d", Integer.valueOf(i2));
            AppMethodBeat.o(35604);
        } else if (z || as.bjo(aVar.getTalkerUserName()) || as.bjm(aVar.getTalkerUserName()) || aVar.GUe.gBM()) {
            Log.d("MicroMsg.SignallingComponent", "oreh doDirectSend not support");
            AppMethodBeat.o(35604);
        } else {
            if (this.PtW == 0 && (gQL = ((ae) this.dom.bh(ae.class)).gQL()) != null && gQL.size() > 0) {
                this.PtW = gQL.get(0).field_createTime;
            }
            long milliSecondsToNow = Util.milliSecondsToNow(this.PtW);
            if (intValue == -1 || milliSecondsToNow > ((long) intValue) * 1000) {
                Log.d("MicroMsg.SignallingComponent", "oreh doDirectSend interval too long: %d;  interval: %d", Long.valueOf(milliSecondsToNow / 1000), Integer.valueOf(intValue));
                AppMethodBeat.o(35604);
                return;
            }
            Log.d("MicroMsg.SignallingComponent", "oreh doDirectSend done chatStatus:%d, delt:%d", Integer.valueOf(i2), Long.valueOf(milliSecondsToNow / 1000));
            bg.azz().a(new j(linkedList, o.iC(i2)), 0);
            AppMethodBeat.o(35604);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(35605);
        if (this.dom == null) {
            AppMethodBeat.o(35605);
            return;
        }
        this.dom.dismissDialog();
        if (10 != qVar.getType()) {
            AppMethodBeat.o(35605);
            return;
        }
        boolean gQZ = ((am) this.dom.bh(am.class)).gQZ();
        boolean gRa = ((am) this.dom.bh(am.class)).gRa();
        boolean gRd = ((am) this.dom.bh(am.class)).gRd();
        if (gRd || gRa || gQZ) {
            Log.i("MicroMsg.SignallingComponent", "[onSceneEnd] [%s|%s|%s]", Boolean.valueOf(gQZ), Boolean.valueOf(gRa), Boolean.valueOf(gRd));
            AppMethodBeat.o(35605);
            return;
        }
        if (i2 == 0 && i3 == 0) {
            j jVar = (j) qVar;
            if (jVar.jje != null && jVar.jje.equals(this.dom.getTalkerUserName())) {
                if (jVar.content == null || jVar.content.length != 4) {
                    Log.e("MicroMsg.SignallingComponent", "unknown directsend op");
                    AppMethodBeat.o(35605);
                    return;
                }
                int v = o.v(jVar.content, 0);
                Log.d("MicroMsg.SignallingComponent", "directsend: status=".concat(String.valueOf(v)));
                switch (v) {
                    case 1:
                        PtV = true;
                        ((aa) this.dom.bh(aa.class)).setMMTitle(R.string.b2t);
                        this.handler.sendMessageDelayed(new Message(), 15000);
                        EventCenter.instance.publish(new qv());
                        AppMethodBeat.o(35605);
                        return;
                    case 2:
                    default:
                        PtV = false;
                        ((aa) this.dom.bh(aa.class)).gPx();
                        if (this.dom.Pwi) {
                            this.dom.Pwj = false;
                            this.dom.cmy();
                            break;
                        } else {
                            Log.e("MicroMsg.SignallingComponent", "onSceneEnd, current ChattingUI lose focus!");
                            this.dom.Pwj = true;
                            AppMethodBeat.o(35605);
                            return;
                        }
                    case 3:
                        PtV = true;
                        ((aa) this.dom.bh(aa.class)).setMMTitle(R.string.b2u);
                        this.handler.sendMessageDelayed(new Message(), 15000);
                        AppMethodBeat.o(35605);
                        return;
                }
            }
        }
        AppMethodBeat.o(35605);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
    public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.i iVar, i.c cVar) {
        AppMethodBeat.i(35606);
        Log.d("MicroMsg.SignallingComponent", "on msg notify change");
        if (this.dom == null) {
            Log.w("MicroMsg.SignallingComponent", "[onNotifyChange] mChattingContext is null!");
            AppMethodBeat.o(35606);
            return;
        }
        if (this.dom.getTalkerUserName().equals(cVar.talker) && "insert".equals(cVar.zqn) && cVar.hIs.size() > 0 && cVar.hIs.get(0).field_isSend == 0) {
            Log.i("MicroMsg.SignallingComponent", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", Integer.valueOf(cVar.hIs.get(0).field_flag), Long.valueOf(cVar.hIs.get(0).field_msgSeq));
            this.PtW = Util.nowMilliSecond();
        }
        AppMethodBeat.o(35606);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void a(com.tencent.mm.ui.chatting.e.a aVar) {
        AppMethodBeat.i(35607);
        super.a(aVar);
        Log.i("MicroMsg.SignallingComponent", "[onComponentInstall] hash:%s", this);
        bg.azz().a(new bu(new bu.a() {
            /* class com.tencent.mm.ui.chatting.d.az.AnonymousClass2 */

            @Override // com.tencent.mm.model.bu.a
            public final void a(g gVar) {
                AppMethodBeat.i(35598);
                if (gVar == null) {
                    AppMethodBeat.o(35598);
                    return;
                }
                az.a(az.this, gVar);
                AppMethodBeat.o(35598);
            }
        }), 0);
        AppMethodBeat.o(35607);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35608);
        super.gOK();
        Log.i("MicroMsg.SignallingComponent", "[onComponentUnInstall] hash:%s", this);
        this.handler.removeCallbacksAndMessages(null);
        bg.aVF();
        c.aSQ().a(this);
        bg.azz().b(10, this);
        AppMethodBeat.o(35608);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35609);
        bg.aVF();
        c.aSQ().a(this, Looper.getMainLooper());
        bg.azz().a(10, this);
        AppMethodBeat.o(35609);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35610);
        bg.aVF();
        c.aSQ().a(this);
        bg.azz().b(10, this);
        AppMethodBeat.o(35610);
    }

    static /* synthetic */ void a(az azVar, g gVar) {
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        AppMethodBeat.i(35611);
        String ispId = gVar.getIspId();
        if (!Util.isNullOrNil(ispId)) {
            j2 = Util.getLong(ispId, 0);
        } else {
            j2 = 0;
        }
        if (j2 != 0) {
            str2 = "TypingTrigger" + "_ISP" + j2;
            str = "TypingInterval" + "_ISP" + j2;
        } else {
            str = "TypingInterval";
            str2 = "TypingTrigger";
        }
        if (com.tencent.mm.kernel.g.aAf().azp()) {
            str4 = Util.nullAs(h.aqJ().getValue(str2), PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT);
            str3 = Util.nullAs(h.aqJ().getValue(str), "15");
        } else {
            str3 = "15";
            str4 = PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT;
        }
        azVar.PtU = Util.getInt(str4, 0);
        azVar.gTn = Util.getInt(str3, 0);
        Log.i("MicroMsg.SignallingComponent", "ispId: %d, trigger:%d, interval:%d", Long.valueOf(j2), Integer.valueOf(azVar.PtU), Integer.valueOf(azVar.gTn));
        if (!(azVar.PtU == -1 || azVar.PtU == -2 || azVar.PtU > 0)) {
            azVar.PtU = 10;
        }
        if (azVar.gTn <= 0) {
            azVar.gTn = 15;
        }
        gVar.setSignallingStrategy((long) (azVar.gTn * 1000), 20000);
        AppMethodBeat.o(35611);
    }
}
