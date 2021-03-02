package com.tencent.youtu.sdkkitframework.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import java.util.HashMap;

public class TimeoutCounter {
    private static final String TAG = TimeoutCounter.class.getSimpleName();
    private long elaspeTimeMs = 0;
    private String name = "timeout counter";
    private boolean needShowTimer = true;
    private boolean needTimer = false;
    private long targetTimeoutMs = 0;

    static {
        AppMethodBeat.i(192564);
        AppMethodBeat.o(192564);
    }

    public TimeoutCounter(String str) {
        this.name = str;
    }

    public void init(long j2, boolean z) {
        AppMethodBeat.i(192559);
        this.targetTimeoutMs = j2;
        this.needShowTimer = z;
        YtLogger.i(TAG, this.name + " init with " + this.targetTimeoutMs);
        AppMethodBeat.o(192559);
    }

    public void start() {
        AppMethodBeat.i(192560);
        reset();
        AppMethodBeat.o(192560);
    }

    public void reset() {
        AppMethodBeat.i(192561);
        YtLogger.i(TAG, this.name + " reset");
        this.needTimer = true;
        if (this.targetTimeoutMs > 0 && this.needShowTimer) {
            YtFSM.getInstance().sendFSMEvent(new HashMap<String, Object>() {
                /* class com.tencent.youtu.sdkkitframework.common.TimeoutCounter.AnonymousClass1 */

                {
                    AppMethodBeat.i(192558);
                    put(StateEvent.Name.UI_ACTION, StateEvent.ActionValue.TIMEOUT_COUNTDOWN_BEGIN);
                    put(StateEvent.Name.COUNTDOWN_TIME, Long.valueOf(TimeoutCounter.this.targetTimeoutMs));
                    AppMethodBeat.o(192558);
                }
            });
        }
        this.elaspeTimeMs = System.currentTimeMillis();
        AppMethodBeat.o(192561);
    }

    public boolean checkTimeout() {
        AppMethodBeat.i(192562);
        if (!this.needTimer) {
            AppMethodBeat.o(192562);
            return false;
        } else if (this.targetTimeoutMs <= 0 || System.currentTimeMillis() - this.elaspeTimeMs <= this.targetTimeoutMs) {
            AppMethodBeat.o(192562);
            return false;
        } else {
            AppMethodBeat.o(192562);
            return true;
        }
    }

    public void cancel() {
        AppMethodBeat.i(192563);
        YtLogger.i(TAG, this.name + " cancel");
        this.needTimer = false;
        AppMethodBeat.o(192563);
    }

    public boolean isRunning() {
        return this.needTimer && this.targetTimeoutMs > 0;
    }
}
