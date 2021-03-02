package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.plugin.notification.e;
import com.tencent.mm.plugin.setting.model.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ck;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.ac;
import com.tencent.mm.ui.chatting.d.b.aq;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.d.b.r;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.y;

@a(gRF = aq.class)
public class ay extends a implements i, aq {
    private boolean Pnm = false;
    private y PtR;
    private int PtS;

    private void gpe() {
        AppMethodBeat.i(35583);
        e.b(this.PtR);
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.PtS);
        this.PtS = 0;
        AppMethodBeat.o(35583);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aq
    public final boolean bmO(String str) {
        AppMethodBeat.i(35584);
        boolean hc = hc(str, 0);
        AppMethodBeat.o(35584);
        return hc;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.aq
    public final void aBt(String str) {
        AppMethodBeat.i(35585);
        ((r) this.dom.bh(r.class)).bmJ(str);
        AppMethodBeat.o(35585);
    }

    private boolean hc(String str, final int i2) {
        int i3 = 0;
        AppMethodBeat.i(35586);
        final String filterString = Util.getFilterString(str);
        if (filterString == null || filterString.length() == 0) {
            Log.e("MicroMsg.ChattingUI.SendTextComponent", "doSendMessage null");
            AppMethodBeat.o(35586);
            return false;
        }
        cj cjVar = new cj();
        cjVar.dFB.dFD = filterString;
        cjVar.dFB.context = this.dom.Pwc.getContext();
        cjVar.dFB.username = this.dom.getTalkerUserName();
        EventCenter.instance.publish(cjVar);
        if (cjVar.dFC.dFE) {
            AppMethodBeat.o(35586);
            return true;
        }
        boolean z = WXHardCoderJNI.hcSendMsgEnable;
        int i4 = WXHardCoderJNI.hcSendMsgDelay;
        int i5 = WXHardCoderJNI.hcSendMsgCPU;
        int i6 = WXHardCoderJNI.hcSendMsgIO;
        if (WXHardCoderJNI.hcSendMsgThr) {
            i3 = g.aAk().getProcessTid();
        }
        this.PtS = WXHardCoderJNI.startPerformance(z, i4, i5, i6, i3, WXHardCoderJNI.hcSendMsgTimeout, 202, WXHardCoderJNI.hcSendMsgAction, "MicroMsg.ChattingUI.SendTextComponent");
        com.tencent.mm.ui.chatting.e.a.gRP().post(new Runnable() {
            /* class com.tencent.mm.ui.chatting.d.ay.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(35582);
                if (ay.this.dom == null) {
                    Log.w("MicroMsg.ChattingUI.SendTextComponent", "NULL == mChattingContext");
                    AppMethodBeat.o(35582);
                    return;
                }
                com.tencent.mm.plugin.report.service.g.Wl(20);
                if (ay.a(ay.this)) {
                    ay.this.dom.gRI();
                    bg.azz().a(new com.tencent.mm.ar.a(ay.this.dom.GUe.field_username, filterString), 0);
                    AppMethodBeat.o(35582);
                    return;
                }
                if (((k) ay.this.dom.bh(k.class)).getCount() == 0 && as.bjo(ay.this.dom.getTalkerUserName())) {
                    cf.aWl().f(10076, 1);
                }
                String talkerUserName = ay.this.dom.getTalkerUserName();
                if (Util.isNullOrNil(talkerUserName)) {
                    Log.e("MicroMsg.ChattingUI.SendTextComponent", "toUser is null or nil!");
                    AppMethodBeat.o(35582);
                    return;
                }
                int JG = ab.JG(talkerUserName);
                String str = filterString;
                String str2 = null;
                try {
                    str2 = ((ac) ay.this.dom.bh(ac.class)).bmM(talkerUserName);
                } catch (NullPointerException e2) {
                    Log.printErrStackTrace("MicroMsg.ChattingUI.SendTextComponent", e2, "", new Object[0]);
                }
                if (Util.isNullOrNil(str2)) {
                    Log.w("MicroMsg.ChattingUI.SendTextComponent", "tempUser is null");
                    AppMethodBeat.o(35582);
                    return;
                }
                u uVar = (u) ay.this.dom.bh(u.class);
                o.e tD = o.Pl(str2).tD(JG);
                tD.cSx = uVar.gPO().gK(talkerUserName, i2);
                tD.content = str;
                tD.toUser = str2;
                tD.jdQ = uVar.gPO().mD(talkerUserName, str);
                tD.jdR = 5;
                o.b bdQ = tD.bdQ();
                T t = bdQ.jdJ;
                if (t instanceof com.tencent.mm.modelmulti.i) {
                    ((ac) ay.this.dom.bh(ac.class)).g((com.tencent.mm.modelmulti.i) t);
                }
                bdQ.execute();
                if (ab.JA(talkerUserName)) {
                    bg.azz().a(new m(q.aoL(), filterString + " key " + ck.getFingerprint() + " local key " + ck.gEv() + "NetType:" + NetStatusUtil.getNetTypeString(ay.this.dom.Pwc.getContext().getApplicationContext()) + " hasNeon: " + n.aos() + " isArmv6: " + n.aou() + " isArmv7: " + n.aot()), 0);
                }
                AppMethodBeat.o(35582);
            }
        });
        this.dom.BN(true);
        AppMethodBeat.o(35586);
        return true;
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void a(com.tencent.mm.ui.chatting.e.a aVar) {
        AppMethodBeat.i(35587);
        super.a(aVar);
        this.PtR = new y(this.dom);
        AppMethodBeat.o(35587);
    }

    @Override // com.tencent.mm.ui.l
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(35588);
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case 207:
                hc(intent.getStringExtra("art_smiley_slelct_data"), 4);
                break;
        }
        AppMethodBeat.o(35588);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        AppMethodBeat.i(35590);
        bg.azz().a(522, this);
        AppMethodBeat.o(35590);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        AppMethodBeat.i(35591);
        if (!this.Pnm) {
            e.a(this.PtR);
        }
        this.Pnm = false;
        AppMethodBeat.o(35591);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(35593);
        bg.azz().b(522, this);
        gpe();
        AppMethodBeat.o(35593);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(35594);
        super.gOK();
        bg.azz().b(522, this);
        gpe();
        AppMethodBeat.o(35594);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIl() {
        AppMethodBeat.i(35589);
        e.a(this.PtR);
        this.Pnm = true;
        AppMethodBeat.o(35589);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(35592);
        e.b(this.PtR);
        AppMethodBeat.o(35592);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(35595);
        if (this.dom != null) {
            this.dom.dismissDialog();
        }
        if (522 == qVar.getType()) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSendMsgEnable, this.PtS);
            this.PtS = 0;
        }
        AppMethodBeat.o(35595);
    }

    static /* synthetic */ boolean a(ay ayVar) {
        AppMethodBeat.i(35596);
        if (!ayVar.dom.GUe.field_username.equals("medianote") || (z.aUc() & 16384) != 0) {
            AppMethodBeat.o(35596);
            return false;
        }
        AppMethodBeat.o(35596);
        return true;
    }
}
