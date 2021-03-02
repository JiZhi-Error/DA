package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.V8ScriptException;

/* access modifiers changed from: package-private */
public interface c {

    public interface a {
        void b(V8ScriptException v8ScriptException);
    }

    String LP();

    boolean Xw();

    void a(a aVar);

    void b(Runnable runnable, long j2, boolean z);

    void cS(boolean z);

    boolean doInnerLoopTask();

    void loop();

    void pause();

    void quit();

    void resume();

    void resumeLoopTasks();

    void u(Runnable runnable);
}
