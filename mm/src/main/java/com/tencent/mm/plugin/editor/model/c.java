package com.tencent.mm.plugin.editor.model;

import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.editor.model.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class c {
    private static c qPs = null;
    public long duration;
    public b jvG = new b(MMApplicationContext.getContext());
    public String path = "";
    public final MMHandler qPb = new MMHandler() {
        /* class com.tencent.mm.plugin.editor.model.c.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(181677);
            if (c.this.qPw.qPY.booleanValue()) {
                c.this.qPv.cDi();
                c.this.qPw.qPY = Boolean.FALSE;
            }
            c.this.qPw.qPQ = (int) com.tencent.mm.plugin.editor.b.AO(c.e(c.this));
            sendEmptyMessageDelayed(4096, 250);
            AppMethodBeat.o(181677);
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
    public a qPv;
    public com.tencent.mm.plugin.editor.model.a.m qPw = null;
    private final MMHandler qPx = new MMHandler() {
        /* class com.tencent.mm.plugin.editor.model.c.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(181676);
            super.handleMessage(message);
            c.this.qPk = false;
            AppMethodBeat.o(181676);
        }
    };
    public final MTimerHandler qPy = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.editor.model.c.AnonymousClass5 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(181678);
            if (c.this.qPn == -1) {
                c.this.qPn = Util.currentTicks();
            }
            long ticksToNow = Util.ticksToNow(c.this.qPn);
            if (ticksToNow >= 3590000 && ticksToNow <= Util.MILLSECONDS_OF_HOUR) {
                if (c.this.qPo == null) {
                    c.this.qPo = Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.c8w, Integer.valueOf((int) ((Util.MILLSECONDS_OF_HOUR - ticksToNow) / 1000))), 0);
                } else {
                    c.this.qPo.setText(MMApplicationContext.getContext().getString(R.string.c8w, Integer.valueOf((int) ((Util.MILLSECONDS_OF_HOUR - ticksToNow) / 1000))));
                }
                c.this.qPo.show();
            }
            if (ticksToNow >= Util.MILLSECONDS_OF_HOUR) {
                Log.v("MicroMsg.EditorVoiceLogic", "record stop on countdown");
                c.this.qPm = true;
                c.i(c.this);
                if (c.this.qPv != null) {
                    c.this.qPv.cDh();
                }
                AppMethodBeat.o(181678);
                return false;
            }
            AppMethodBeat.o(181678);
            return true;
        }
    }, true);

    static /* synthetic */ long e(c cVar) {
        AppMethodBeat.i(181688);
        long duration2 = cVar.getDuration();
        AppMethodBeat.o(181688);
        return duration2;
    }

    static /* synthetic */ void i(c cVar) {
        AppMethodBeat.i(181689);
        cVar.cDc();
        AppMethodBeat.o(181689);
    }

    private c() {
        AppMethodBeat.i(181679);
        AppMethodBeat.o(181679);
    }

    public static c cCZ() {
        AppMethodBeat.i(181680);
        if (qPs == null) {
            qPs = new c();
        }
        c cVar = qPs;
        AppMethodBeat.o(181680);
        return cVar;
    }

    public final void cDa() {
        AppMethodBeat.i(181681);
        if (!this.qPk) {
            AppMethodBeat.o(181681);
            return;
        }
        if (!this.qPm) {
            cDc();
        }
        AppMethodBeat.o(181681);
    }

    public final String cDb() {
        AppMethodBeat.i(181682);
        if (s.YS(this.path)) {
            String str = this.path;
            AppMethodBeat.o(181682);
            return str;
        }
        AppMethodBeat.o(181682);
        return "";
    }

    private void stopRecord() {
        AppMethodBeat.i(181683);
        if (this.qPr.equals("speex")) {
            this.qPq.ZZ();
        } else {
            this.qPp.ZZ();
        }
        if (this.jvG != null) {
            this.jvG.apm();
        }
        AppMethodBeat.o(181683);
    }

    private void cDc() {
        AppMethodBeat.i(181684);
        if (!this.qPk) {
            AppMethodBeat.o(181684);
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
        AppMethodBeat.o(181684);
    }

    private void cDd() {
        AppMethodBeat.i(181685);
        this.qPx.sendEmptyMessageDelayed(0, 500);
        AppMethodBeat.o(181685);
    }

    private long getDuration() {
        AppMethodBeat.i(181686);
        if (this.qPl == 0) {
            AppMethodBeat.o(181686);
            return 0;
        }
        long ticksToNow = Util.ticksToNow(this.qPl);
        AppMethodBeat.o(181686);
        return ticksToNow;
    }

    private void cDe() {
        AppMethodBeat.i(181687);
        o oVar = new o(this.path);
        if (oVar.exists()) {
            oVar.delete();
        }
        AppMethodBeat.o(181687);
    }

    public static void destroy() {
        qPs = null;
    }

    public static c cDf() {
        return qPs;
    }
}
