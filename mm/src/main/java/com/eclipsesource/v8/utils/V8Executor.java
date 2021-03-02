package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class V8Executor extends Thread {
    private Exception exception;
    private volatile boolean forceTerminating;
    private boolean longRunning;
    private String messageHandler;
    private LinkedList<String[]> messageQueue;
    private String result;
    private V8 runtime;
    private final String script;
    private volatile boolean shuttingDown;
    private volatile boolean terminated;

    public V8Executor(String str, boolean z, String str2) {
        AppMethodBeat.i(61709);
        this.terminated = false;
        this.shuttingDown = false;
        this.forceTerminating = false;
        this.exception = null;
        this.messageQueue = new LinkedList<>();
        this.script = str;
        this.longRunning = z;
        this.messageHandler = str2;
        AppMethodBeat.o(61709);
    }

    public V8Executor(String str) {
        this(str, false, null);
    }

    /* access modifiers changed from: protected */
    public void setup(V8 v8) {
    }

    public String getResult() {
        return this.result;
    }

    public void postMessage(String... strArr) {
        AppMethodBeat.i(61710);
        synchronized (this) {
            try {
                this.messageQueue.add(strArr);
                notify();
            } finally {
                AppMethodBeat.o(61710);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0092, code lost:
        if (r9.runtime.getLocker().hasLock() == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0094, code lost:
        r9.runtime.release();
        r9.runtime = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009c, code lost:
        r9.terminated = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009f, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00aa, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ac, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(61711);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00af, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b7, code lost:
        if (r9.messageQueue.isEmpty() != false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b9, code lost:
        r1 = r9.messageQueue.remove(0);
        r4 = new com.eclipsesource.v8.V8Array(r9.runtime);
        r5 = new com.eclipsesource.v8.V8Array(r9.runtime);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r6 = r1.length;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d2, code lost:
        if (r2 >= r6) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d4, code lost:
        r5.push(r1[r2]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d9, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0105, code lost:
        r4.push((com.eclipsesource.v8.V8Value) r5);
        r9.runtime.executeVoidFunction(r9.messageHandler, r4);
        r5.release();
        r4.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0135, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0136, code lost:
        r5.release();
        r4.release();
        com.tencent.matrix.trace.core.AppMethodBeat.o(61711);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0142, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        // Method dump skipped, instructions count: 371
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8Executor.run():void");
    }

    public boolean hasException() {
        return this.exception != null;
    }

    public Exception getException() {
        return this.exception;
    }

    public boolean hasTerminated() {
        return this.terminated;
    }

    public void forceTermination() {
        AppMethodBeat.i(61712);
        synchronized (this) {
            try {
                this.forceTerminating = true;
                this.shuttingDown = true;
                if (this.runtime != null) {
                    this.runtime.terminateExecution();
                }
                notify();
            } finally {
                AppMethodBeat.o(61712);
            }
        }
    }

    public void shutdown() {
        AppMethodBeat.i(61713);
        synchronized (this) {
            try {
                this.shuttingDown = true;
                notify();
            } finally {
                AppMethodBeat.o(61713);
            }
        }
    }

    public boolean isShuttingDown() {
        return this.shuttingDown;
    }

    public boolean isTerminating() {
        return this.forceTerminating;
    }

    class ExecutorTermination implements JavaVoidCallback {
        ExecutorTermination() {
        }

        @Override // com.eclipsesource.v8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            AppMethodBeat.i(61708);
            if (V8Executor.this.forceTerminating) {
                RuntimeException runtimeException = new RuntimeException("V8Thread Termination");
                AppMethodBeat.o(61708);
                throw runtimeException;
            }
            AppMethodBeat.o(61708);
        }
    }
}
