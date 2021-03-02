package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.m;
import java.util.HashSet;
import java.util.Iterator;

public final class k implements j, m {
    private HashSet<m> PnY = new HashSet<>();

    public k() {
        AppMethodBeat.i(35179);
        AppMethodBeat.o(35179);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.j
    public final void a(m mVar) {
        AppMethodBeat.i(35180);
        if (!this.PnY.contains(mVar)) {
            this.PnY.add(mVar);
        }
        AppMethodBeat.o(35180);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.j
    public final void b(m mVar) {
        AppMethodBeat.i(35181);
        this.PnY.remove(mVar);
        AppMethodBeat.o(35181);
    }

    @Override // com.tencent.mm.ui.m
    public final void gIk() {
        AppMethodBeat.i(35182);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.PnY).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            mVar.gIk();
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
            if (Log.getLogLevel() == 0) {
                Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingInit] listener:%s cost:%sms", mVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis3));
            }
        }
        Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingInit]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(35182);
    }

    @Override // com.tencent.mm.ui.m
    public final void gIl() {
        AppMethodBeat.i(35183);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.PnY).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            mVar.gIl();
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
            if (Log.getLogLevel() == 0) {
                Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart] listener:%s cost:%sms", mVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis3));
            }
        }
        Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimStart]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(35183);
    }

    @Override // com.tencent.mm.ui.m
    public final void gIm() {
        AppMethodBeat.i(35184);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.PnY).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            mVar.gIm();
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
            if (Log.getLogLevel() == 0) {
                Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd] listener:%s cost:%sms", mVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis3));
            }
        }
        Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingEnterAnimEnd]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(35184);
    }

    @Override // com.tencent.mm.ui.m
    public final void cFx() {
        AppMethodBeat.i(35185);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.PnY).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            mVar.cFx();
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
            if (Log.getLogLevel() == 0) {
                Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingResume] listener:%s cost:%sms", mVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis3));
            }
        }
        Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingResume]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(35185);
    }

    @Override // com.tencent.mm.ui.m
    public final void cFy() {
        AppMethodBeat.i(35186);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.PnY).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            mVar.cFy();
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
            if (Log.getLogLevel() == 0) {
                Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingPause] listener:%s cost:%sms", mVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis3));
            }
        }
        Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingPause]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(35186);
    }

    @Override // com.tencent.mm.ui.m
    public final void gIn() {
        AppMethodBeat.i(35187);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.PnY).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            mVar.gIn();
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
            if (Log.getLogLevel() == 0) {
                Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart] listener:%s cost:%sms", mVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis3));
            }
        }
        Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimStart]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(35187);
    }

    @Override // com.tencent.mm.ui.m
    public final void gIo() {
        AppMethodBeat.i(35188);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = new HashSet(this.PnY).iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            long currentTimeMillis2 = System.currentTimeMillis();
            mVar.gIo();
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
            if (Log.getLogLevel() == 0) {
                Log.v("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd] listener:%s cost:%sms", mVar.getClass().getSimpleName(), Long.valueOf(currentTimeMillis3));
            }
        }
        Log.i("MicroMsg.ChattingLifecycleObserver", "[onChattingExitAnimEnd]cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(35188);
    }
}
