package com.tencent.mm.plugin.ipcall.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public boolean isStart = false;
    public c qrz = null;
    public final Object yql = new Object();
    public int yqm = 0;
    public boolean yqn = false;
    public com.tencent.mm.plugin.ipcall.model.a.a yqo;

    public a(com.tencent.mm.plugin.ipcall.model.a.a aVar) {
        AppMethodBeat.i(231722);
        this.yqo = aVar;
        AppMethodBeat.o(231722);
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.model.c.a$a  reason: collision with other inner class name */
    public class RunnableC1442a implements Runnable {
        private c yqq = null;

        public RunnableC1442a(c cVar) {
            this.yqq = cVar;
        }

        public final void run() {
            AppMethodBeat.i(25414);
            if (this.yqq != null) {
                this.yqq.fFr();
                this.yqq.fFo();
                this.yqq = null;
                a.this.yqn = false;
            }
            a.this.yqo.cdV();
            AppMethodBeat.o(25414);
        }
    }

    public final void qw(boolean z) {
        int appCmd;
        AppMethodBeat.i(25417);
        Log.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", Boolean.valueOf(this.yqn), Boolean.valueOf(z));
        this.yqo.jp(z);
        com.tencent.mm.plugin.ipcall.model.d.a eat = i.eat();
        if (z) {
            appCmd = eat.yqF.setAppCmd(401);
        } else {
            appCmd = eat.yqF.setAppCmd(402);
        }
        if (appCmd < 0) {
            Log.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", Integer.valueOf(appCmd));
        }
        if (z != this.yqn) {
            this.yqn = z;
            if (this.qrz != null && this.qrz.GSW) {
                this.qrz.wS(z);
            }
        }
        AppMethodBeat.o(25417);
    }
}
