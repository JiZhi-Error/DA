package com.tencent.mm.plugin.appbrand.utils;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.q;
import com.tencent.mm.sdk.statemachine.StateMachine;
import java.util.LinkedList;
import java.util.Queue;

public abstract class j<Task> extends StateMachine {
    private final j<Task>.b ogM = new b(this, (byte) 0);
    private final j<Task>.a ogN = new a(this, (byte) 0);
    private final String ogO;
    protected final Queue<Task> ogP = new LinkedList();

    /* access modifiers changed from: protected */
    public abstract boolean bEJ();

    /* access modifiers changed from: protected */
    public abstract void cE(Task task);

    protected j(String str, Looper looper) {
        super(str, looper);
        this.ogO = str;
        addState(this.ogM);
        addState(this.ogN);
        setInitialState(this.ogM);
        start();
    }

    public final void cQ(Task task) {
        if (!bEJ()) {
            synchronized (this.ogP) {
                this.ogP.offer(task);
            }
            sendMessage(1);
        }
    }

    @Override // com.tencent.mm.sdk.statemachine.StateMachine
    public void onQuitting() {
        super.onQuitting();
        synchronized (this.ogP) {
            this.ogP.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final class a extends q {
        private a() {
        }

        /* synthetic */ a(j jVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final boolean processMessage(Message message) {
            AppMethodBeat.i(107818);
            if (2 == message.what) {
                j.this.transitionTo(j.this.ogM);
                AppMethodBeat.o(107818);
                return true;
            }
            boolean processMessage = super.processMessage(message);
            AppMethodBeat.o(107818);
            return processMessage;
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final String getName() {
            AppMethodBeat.i(107819);
            String str = j.this.ogO + "|StateExecuting";
            AppMethodBeat.o(107819);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public final class b extends q {
        private b() {
        }

        /* synthetic */ b(j jVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.report.q, com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final void enter() {
            AppMethodBeat.i(107820);
            super.enter();
            j.c(j.this);
            AppMethodBeat.o(107820);
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final boolean processMessage(Message message) {
            AppMethodBeat.i(107821);
            if (1 == message.what || 2 == message.what) {
                j.c(j.this);
                AppMethodBeat.o(107821);
                return true;
            }
            boolean processMessage = super.processMessage(message);
            AppMethodBeat.o(107821);
            return processMessage;
        }

        @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
        public final String getName() {
            AppMethodBeat.i(107822);
            String str = j.this.ogO + "|StateIdle";
            AppMethodBeat.o(107822);
            return str;
        }
    }

    static /* synthetic */ void c(j jVar) {
        Task poll;
        synchronized (jVar.ogP) {
            poll = jVar.ogP.poll();
        }
        if (poll != null) {
            jVar.transitionTo(jVar.ogN);
            jVar.cE(poll);
        }
    }
}
