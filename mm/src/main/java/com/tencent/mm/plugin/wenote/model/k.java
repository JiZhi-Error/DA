package com.tencent.mm.plugin.wenote.model;

import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class k {
    private static k JHF = null;
    public a JHG;
    public l JHH = null;
    public long duration;
    public b jvG = new b(MMApplicationContext.getContext());
    public String path = "";
    public final MMHandler qPb = new MMHandler() {
        /* class com.tencent.mm.plugin.wenote.model.k.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(30360);
            if (k.this.JHH.qPY.booleanValue()) {
                k.this.JHG.cDi();
                k.this.JHH.qPY = Boolean.FALSE;
            }
            k.this.JHH.qPQ = (int) com.tencent.mm.bl.a.AO(k.e(k.this));
            sendEmptyMessageDelayed(4096, 250);
            AppMethodBeat.o(30360);
        }
    };
    public boolean qPk;
    public long qPl;
    public boolean qPm;
    public long qPn = -1;
    private Toast qPo;
    public j qPp;
    public m qPq;
    public String qPr = "";
    public TextView qPt;
    public int qPu = 0;
    private final MMHandler qPx = new MMHandler() {
        /* class com.tencent.mm.plugin.wenote.model.k.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(30359);
            super.handleMessage(message);
            k.this.qPk = false;
            AppMethodBeat.o(30359);
        }
    };
    public final MTimerHandler qPy = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.wenote.model.k.AnonymousClass5 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(30361);
            if (k.this.qPn == -1) {
                k.this.qPn = Util.currentTicks();
            }
            long ticksToNow = Util.ticksToNow(k.this.qPn);
            if (ticksToNow >= 3590000 && ticksToNow <= Util.MILLSECONDS_OF_HOUR) {
                if (k.this.qPo == null) {
                    k.this.qPo = Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.c8w, Integer.valueOf((int) ((Util.MILLSECONDS_OF_HOUR - ticksToNow) / 1000))), 0);
                } else {
                    k.this.qPo.setText(MMApplicationContext.getContext().getString(R.string.c8w, Integer.valueOf((int) ((Util.MILLSECONDS_OF_HOUR - ticksToNow) / 1000))));
                }
                k.this.qPo.show();
            }
            if (ticksToNow >= Util.MILLSECONDS_OF_HOUR) {
                Log.v("MicroMsg.WNNoteVoiceLogic", "record stop on countdown");
                k.this.qPm = true;
                k.i(k.this);
                if (k.this.JHG != null) {
                    k.this.JHG.cDh();
                }
                AppMethodBeat.o(30361);
                return false;
            }
            AppMethodBeat.o(30361);
            return true;
        }
    }, true);

    static /* synthetic */ long e(k kVar) {
        AppMethodBeat.i(30371);
        long duration2 = kVar.getDuration();
        AppMethodBeat.o(30371);
        return duration2;
    }

    static /* synthetic */ void i(k kVar) {
        AppMethodBeat.i(30372);
        kVar.cDc();
        AppMethodBeat.o(30372);
    }

    private k() {
        AppMethodBeat.i(30362);
        AppMethodBeat.o(30362);
    }

    public static k gjD() {
        AppMethodBeat.i(30363);
        if (JHF == null) {
            JHF = new k();
        }
        k kVar = JHF;
        AppMethodBeat.o(30363);
        return kVar;
    }

    public final void cDa() {
        AppMethodBeat.i(30364);
        if (!this.qPk) {
            AppMethodBeat.o(30364);
            return;
        }
        if (!this.qPm) {
            cDc();
        }
        AppMethodBeat.o(30364);
    }

    public final String cDb() {
        AppMethodBeat.i(30365);
        if (s.YS(this.path)) {
            String str = this.path;
            AppMethodBeat.o(30365);
            return str;
        }
        AppMethodBeat.o(30365);
        return "";
    }

    private void stopRecord() {
        AppMethodBeat.i(30366);
        if (this.qPr.equals("speex")) {
            this.qPq.ZZ();
        } else {
            this.qPp.ZZ();
        }
        if (this.jvG != null) {
            this.jvG.apm();
        }
        AppMethodBeat.o(30366);
    }

    private void cDc() {
        AppMethodBeat.i(30367);
        if (!this.qPk) {
            AppMethodBeat.o(30367);
            return;
        }
        this.qPb.removeMessages(4096);
        stopRecord();
        this.duration = getDuration();
        boolean z = this.duration < 800;
        this.qPy.stopTimer();
        if (z) {
            cDe();
            cDd();
        }
        this.qPk = false;
        AppMethodBeat.o(30367);
    }

    private void cDd() {
        AppMethodBeat.i(30368);
        this.qPx.sendEmptyMessageDelayed(0, 500);
        AppMethodBeat.o(30368);
    }

    private long getDuration() {
        AppMethodBeat.i(30369);
        if (this.qPl == 0) {
            AppMethodBeat.o(30369);
            return 0;
        }
        long ticksToNow = Util.ticksToNow(this.qPl);
        AppMethodBeat.o(30369);
        return ticksToNow;
    }

    private void cDe() {
        AppMethodBeat.i(30370);
        o oVar = new o(this.path);
        if (oVar.exists()) {
            oVar.delete();
        }
        AppMethodBeat.o(30370);
    }

    public static void destroy() {
        JHF = null;
    }

    public static k gjE() {
        return JHF;
    }
}
