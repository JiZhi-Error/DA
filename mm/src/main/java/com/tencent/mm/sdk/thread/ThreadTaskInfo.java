package com.tencent.mm.sdk.thread;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ThreadTaskInfo {
    public long addedTime;
    public long costTime;
    public String name;
    public long startTime;
    public State state;

    public enum State {
        WAITING,
        RUNNING,
        FINISH;

        public static State valueOf(String str) {
            AppMethodBeat.i(158157);
            State state = (State) Enum.valueOf(State.class, str);
            AppMethodBeat.o(158157);
            return state;
        }

        static {
            AppMethodBeat.i(158158);
            AppMethodBeat.o(158158);
        }
    }

    public ThreadTaskInfo(String str) {
        this.name = str;
    }

    public String toString() {
        AppMethodBeat.i(158159);
        String str = this.name + " " + this.state + " " + this.addedTime + " " + this.startTime + " " + this.costTime;
        AppMethodBeat.o(158159);
        return str;
    }
}
