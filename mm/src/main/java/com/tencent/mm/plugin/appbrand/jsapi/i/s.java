package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.statemachine.IState;
import com.tencent.mm.sdk.statemachine.State;
import com.tencent.mm.sdk.statemachine.StateMachine;

public class s extends StateMachine implements n {
    Bundle jkf;
    volatile boolean jvO = false;
    public volatile boolean kYn = false;
    private final b lXt;
    public volatile boolean lXu = false;
    a lXv;
    private final State lXw = new State() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.i.s.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final String getName() {
            AppMethodBeat.i(143635);
            String str = s.this.getName() + "$StateListening";
            AppMethodBeat.o(143635);
            return str;
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final boolean processMessage(Message message) {
            AppMethodBeat.i(143636);
            if (1 == message.what) {
                s.a(s.this, s.this.lXx);
                AppMethodBeat.o(143636);
                return true;
            } else if (4 == message.what) {
                s.b(s.this, s.this.lXx);
                AppMethodBeat.o(143636);
                return true;
            } else {
                boolean processMessage = super.processMessage(message);
                AppMethodBeat.o(143636);
                return processMessage;
            }
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final void enter() {
            AppMethodBeat.i(143637);
            super.enter();
            Log.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateNotListening");
            ((com.tencent.mm.plugin.appbrand.utils.b.a) e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", s.this.lXt, s.this.jkf);
            s.this.kYn = false;
            s.this.ZP("StateNotListening");
            AppMethodBeat.o(143637);
        }
    };
    private final State lXx = new State() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.i.s.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final String getName() {
            AppMethodBeat.i(143638);
            String str = s.this.getName() + "$StateNotListening";
            AppMethodBeat.o(143638);
            return str;
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final void enter() {
            AppMethodBeat.i(143639);
            super.enter();
            Log.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateListening");
            ((com.tencent.mm.plugin.appbrand.utils.b.a) e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("gcj02", s.this.lXt, s.this.jkf);
            s.this.kYn = true;
            s.this.ZP("StateListening");
            AppMethodBeat.o(143639);
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final void exit() {
            AppMethodBeat.i(143640);
            super.exit();
            ((com.tencent.mm.plugin.appbrand.utils.b.a) e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("gcj02", s.this.lXt, s.this.jkf);
            s.this.kYn = false;
            s.this.ZP("StateNotListening");
            AppMethodBeat.o(143640);
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final boolean processMessage(Message message) {
            AppMethodBeat.i(143641);
            if (2 == message.what) {
                s.c(s.this, s.this.lXw);
                AppMethodBeat.o(143641);
                return true;
            } else if (3 == message.what) {
                s.d(s.this, s.this.lXy);
                AppMethodBeat.o(143641);
                return true;
            } else {
                boolean processMessage = super.processMessage(message);
                AppMethodBeat.o(143641);
                return processMessage;
            }
        }
    };
    private final State lXy = new State() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.i.s.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final String getName() {
            AppMethodBeat.i(143642);
            String str = s.this.getName() + "$StateSuspend";
            AppMethodBeat.o(143642);
            return str;
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final boolean processMessage(Message message) {
            AppMethodBeat.i(143643);
            if (2 == message.what) {
                s.e(s.this, s.this.lXw);
                AppMethodBeat.o(143643);
                return true;
            } else if (4 == message.what) {
                s.f(s.this, s.this.lXx);
                AppMethodBeat.o(143643);
                return true;
            } else {
                boolean processMessage = super.processMessage(message);
                AppMethodBeat.o(143643);
                return processMessage;
            }
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final void enter() {
            AppMethodBeat.i(143644);
            super.enter();
            Log.i("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateSuspend");
            s.this.ZP("StateSuspend");
            AppMethodBeat.o(143644);
        }
    };

    public interface a {
        void ZO(String str);
    }

    static /* synthetic */ void a(s sVar, IState iState) {
        AppMethodBeat.i(143651);
        sVar.transitionTo(iState);
        AppMethodBeat.o(143651);
    }

    static /* synthetic */ void b(s sVar, IState iState) {
        AppMethodBeat.i(143652);
        sVar.transitionTo(iState);
        AppMethodBeat.o(143652);
    }

    static /* synthetic */ void c(s sVar, IState iState) {
        AppMethodBeat.i(143653);
        sVar.transitionTo(iState);
        AppMethodBeat.o(143653);
    }

    static /* synthetic */ void d(s sVar, IState iState) {
        AppMethodBeat.i(143654);
        sVar.transitionTo(iState);
        AppMethodBeat.o(143654);
    }

    static /* synthetic */ void e(s sVar, IState iState) {
        AppMethodBeat.i(143655);
        sVar.transitionTo(iState);
        AppMethodBeat.o(143655);
    }

    static /* synthetic */ void f(s sVar, IState iState) {
        AppMethodBeat.i(143656);
        sVar.transitionTo(iState);
        AppMethodBeat.o(143656);
    }

    s(f fVar) {
        super("RuntimeLocationUpdateStateManager[" + fVar.getAppId() + "]", Looper.getMainLooper());
        AppMethodBeat.i(143645);
        this.lXt = new b(fVar);
        addState(this.lXw);
        addState(this.lXx);
        addState(this.lXy);
        setInitialState(this.lXw);
        AppMethodBeat.o(143645);
    }

    public final void ZP(String str) {
        AppMethodBeat.i(143646);
        if (this.lXv != null) {
            this.lXv.ZO(str);
        }
        AppMethodBeat.o(143646);
    }

    public final void bGI() {
        AppMethodBeat.i(143647);
        this.jvO = false;
        sendMessage(3);
        AppMethodBeat.o(143647);
    }

    public final void bGJ() {
        AppMethodBeat.i(143648);
        if (!this.jvO) {
            sendMessage(4);
            AppMethodBeat.o(143648);
            return;
        }
        this.jvO = false;
        AppMethodBeat.o(143648);
    }

    public final void stopListening() {
        AppMethodBeat.i(143649);
        this.jvO = false;
        sendMessage(2);
        AppMethodBeat.o(143649);
    }

    public final void bGK() {
        AppMethodBeat.i(143650);
        this.jvO = true;
        sendMessage(2);
        AppMethodBeat.o(143650);
    }
}
