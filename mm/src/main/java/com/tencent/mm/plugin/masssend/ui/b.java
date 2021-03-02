package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.m;
import com.tencent.mm.cj.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.plugin.transvoice.a.c;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import java.util.List;

public final class b implements com.tencent.mm.pluginsdk.ui.chat.b {
    private List<String> gxh;
    final MTimerHandler jxC = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.masssend.ui.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(26387);
            b.this.znD.aiy(b.this.znE.getMaxAmplitude());
            AppMethodBeat.o(26387);
            return true;
        }
    }, true);
    private Vibrator paT;
    long qPn = -1;
    Toast qPo;
    final MTimerHandler qPy = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.masssend.ui.b.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(26390);
            if (b.this.qPn == -1) {
                b.this.qPn = Util.currentTicks();
            }
            long ticksToNow = Util.ticksToNow(b.this.qPn);
            if (ticksToNow >= 50000 && ticksToNow <= Util.MILLSECONDS_OF_MINUTE) {
                if (b.this.qPo == null) {
                    int i2 = (int) ((Util.MILLSECONDS_OF_MINUTE - ticksToNow) / 1000);
                    b.this.qPo = Toast.makeText(b.this.znC, b.this.znC.getResources().getQuantityString(R.plurals.f3136c, i2, Integer.valueOf(i2)), 0);
                } else {
                    int i3 = (int) ((Util.MILLSECONDS_OF_MINUTE - ticksToNow) / 1000);
                    b.this.qPo.setText(b.this.znC.getResources().getQuantityString(R.plurals.f3136c, i3, Integer.valueOf(i3)));
                }
                b.this.qPo.show();
            }
            if (ticksToNow >= Util.MILLSECONDS_OF_MINUTE) {
                Log.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
                if (b.this.znD.grl()) {
                    b.this.znD.gqR();
                } else {
                    if (b.this.znE.Qt()) {
                        b.this.ehK();
                    }
                    b.this.znD.a(ChatFooter.h.SendVoice);
                }
                PlaySound.play(b.this.znC, R.string.hom);
                AppMethodBeat.o(26390);
                return false;
            }
            AppMethodBeat.o(26390);
            return true;
        }
    }, true);
    q tipDialog = null;
    MassSendMsgUI znC;
    ChatFooter znD;
    a znE;
    private String znF;
    private boolean znG;
    private final m.a znH = new m.a() {
        /* class com.tencent.mm.plugin.masssend.ui.b.AnonymousClass2 */

        @Override // com.tencent.mm.ak.m.a
        public final void onError() {
            AppMethodBeat.i(26388);
            b.this.znE.reset();
            b.this.jxC.stopTimer();
            b.this.qPy.stopTimer();
            MMEntryLock.unlock("keep_app_silent");
            b.this.znD.a(ChatFooter.h.Error);
            Log.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
            Toast.makeText(b.this.znC, b.this.znC.getString(R.string.b1p), 0).show();
            AppMethodBeat.o(26388);
        }
    };
    private final m.b znI = new m.b() {
        /* class com.tencent.mm.plugin.masssend.ui.b.AnonymousClass3 */

        @Override // com.tencent.mm.ak.m.b
        public final void aYN() {
            AppMethodBeat.i(26389);
            b.this.znD.gqr();
            AppMethodBeat.o(26389);
        }
    };

    public b(MassSendMsgUI massSendMsgUI, ChatFooter chatFooter, String str, List<String> list, boolean z) {
        AppMethodBeat.i(26394);
        this.znC = massSendMsgUI;
        this.znD = chatFooter;
        this.znF = str;
        this.gxh = list;
        this.znG = z;
        this.znE = new a(massSendMsgUI);
        this.znE.a(this.znH);
        this.znE.a(this.znI);
        this.paT = (Vibrator) massSendMsgUI.getSystemService("vibrator");
        AppMethodBeat.o(26394);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final boolean ehI() {
        AppMethodBeat.i(26395);
        this.jxC.stopTimer();
        this.qPy.stopTimer();
        this.qPn = -1;
        if (this.znE.Qt()) {
            c.a aVar = c.Guc;
            c.fAu().setExitType(0);
            ehK();
            this.znD.a(ChatFooter.h.SendVoice);
        } else {
            this.znD.cDd();
        }
        bg.Xi().akq();
        AppMethodBeat.o(26395);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final boolean ehJ() {
        AppMethodBeat.i(26396);
        this.jxC.stopTimer();
        this.qPy.stopTimer();
        this.qPn = -1;
        this.znE.Qt();
        this.znD.a(ChatFooter.h.StopRecord);
        bg.Xi().akq();
        AppMethodBeat.o(26396);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void ehK() {
        AppMethodBeat.i(26397);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.znm = this.znF;
        aVar.znn = this.gxh.size();
        aVar.filename = this.znE.fileName;
        aVar.msgType = 34;
        aVar.zno = this.znE.dAn;
        final f fVar = new f(aVar, this.znG);
        bg.azz().a(fVar, 0);
        MassSendMsgUI massSendMsgUI = this.znC;
        this.znC.getString(R.string.zb);
        this.tipDialog = h.a((Context) massSendMsgUI, this.znC.getString(R.string.gko), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.masssend.ui.b.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(26391);
                bg.azz().a(fVar);
                if (b.this.tipDialog != null) {
                    b.this.tipDialog.dismiss();
                    b.this.tipDialog = null;
                }
                AppMethodBeat.o(26391);
            }
        });
        AppMethodBeat.o(26397);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final boolean ehL() {
        AppMethodBeat.i(26398);
        this.jxC.stopTimer();
        this.qPy.stopTimer();
        this.qPn = -1;
        this.znD.a(ChatFooter.h.Cancel);
        this.znE.cTH();
        bg.Xi().akq();
        AppMethodBeat.o(26398);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void ehM() {
        AppMethodBeat.i(185750);
        this.znD.a(ChatFooter.h.Cancel);
        this.znE.cTH();
        AppMethodBeat.o(185750);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final boolean ehN() {
        AppMethodBeat.i(26399);
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            u.g(this.znC, null);
            AppMethodBeat.o(26399);
        } else if (com.tencent.mm.q.a.cB(this.znC)) {
            AppMethodBeat.o(26399);
        } else {
            this.paT.vibrate(50);
            c.a aVar = c.Guc;
            c.fAu().GtJ = true;
            this.jxC.startTimer(100);
            this.qPy.startTimer(200);
            this.znD.aix(this.znC.getResources().getDisplayMetrics().heightPixels - this.znD.getHeight());
            this.znE.hx("_USER_FOR_THROWBOTTLE_");
            this.znE.a(this.znI);
            this.znE.a(this.znH);
            bg.Xi().akr();
            AppMethodBeat.o(26399);
        }
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final boolean aDN(String str) {
        AppMethodBeat.i(26400);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(26400);
            return false;
        }
        MassSendMsgUI.aDR(str);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.znm = this.znF;
        aVar.znn = this.gxh.size();
        aVar.filename = str;
        aVar.msgType = 1;
        final f fVar = new f(aVar, this.znG);
        bg.azz().a(fVar, 0);
        MassSendMsgUI massSendMsgUI = this.znC;
        this.znC.getString(R.string.zb);
        this.tipDialog = h.a((Context) massSendMsgUI, this.znC.getString(R.string.gko), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.masssend.ui.b.AnonymousClass6 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(26392);
                bg.azz().a(fVar);
                if (b.this.tipDialog != null) {
                    b.this.tipDialog.dismiss();
                    b.this.tipDialog = null;
                }
                AppMethodBeat.o(26392);
            }
        });
        AppMethodBeat.o(26400);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void aBt(String str) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final boolean eu(String str, int i2) {
        AppMethodBeat.i(26401);
        ehK();
        AppMethodBeat.o(26401);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final boolean aDO(String str) {
        AppMethodBeat.i(26402);
        boolean Rl = s.Rl(str);
        AppMethodBeat.o(26402);
        return Rl;
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void ehO() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void ehP() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void ehQ() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void X(MotionEvent motionEvent) {
    }

    /* access modifiers changed from: package-private */
    public class a extends com.tencent.mm.audio.b.h {
        String fileName;

        public a(Context context) {
            super(context, false);
        }

        @Override // com.tencent.mm.ak.m, com.tencent.mm.audio.b.h
        public final String getFileName() {
            return this.fileName;
        }

        @Override // com.tencent.mm.ak.m, com.tencent.mm.audio.b.h
        public final boolean Qt() {
            AppMethodBeat.i(26393);
            this.fileName = super.getFileName();
            boolean Qt = super.Qt();
            super.reset();
            AppMethodBeat.o(26393);
            return Qt;
        }

        public final void cTH() {
            AppMethodBeat.i(185749);
            Qt();
            s.Rl(this.fileName);
            AppMethodBeat.o(185749);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void release() {
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void onPause() {
        AppMethodBeat.i(26403);
        this.jxC.stopTimer();
        this.qPy.stopTimer();
        this.qPn = -1;
        a.C0295a aVar = com.tencent.mm.cj.a.Owq;
        if (!a.C0295a.blI(this.znE.fileName)) {
            a.C0295a aVar2 = com.tencent.mm.cj.a.Owq;
            if (!a.C0295a.blK(this.znE.fileName)) {
                this.znE.Qt();
            }
        }
        bg.Xi().akq();
        AppMethodBeat.o(26403);
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final void qY(boolean z) {
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final String getFileName() {
        if (this.znE != null) {
            return this.znE.fileName;
        }
        return "";
    }

    @Override // com.tencent.mm.pluginsdk.ui.chat.b
    public final long aas() {
        AppMethodBeat.i(26404);
        if (this.znE != null) {
            long aas = this.znE.aas();
            AppMethodBeat.o(26404);
            return aas;
        }
        AppMethodBeat.o(26404);
        return 0;
    }
}
