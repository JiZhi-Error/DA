package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.debug.mirror.Frame;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ExecutionState implements Releasable {
    private static final String FRAME = "frame";
    private static final String FRAME_COUNT = "frameCount";
    private static final String PREPARE_STEP = "prepareStep";
    private V8Object v8Object;

    ExecutionState(V8Object v8Object2) {
        AppMethodBeat.i(61474);
        this.v8Object = v8Object2.twin();
        AppMethodBeat.o(61474);
    }

    public int getFrameCount() {
        AppMethodBeat.i(61475);
        int executeIntegerFunction = this.v8Object.executeIntegerFunction(FRAME_COUNT, null);
        AppMethodBeat.o(61475);
        return executeIntegerFunction;
    }

    public void prepareStep(StepAction stepAction) {
        AppMethodBeat.i(61476);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(stepAction.index);
        try {
            this.v8Object.executeVoidFunction(PREPARE_STEP, v8Array);
        } finally {
            v8Array.release();
            AppMethodBeat.o(61476);
        }
    }

    public Frame getFrame(int i2) {
        AppMethodBeat.i(61477);
        V8Array v8Array = new V8Array(this.v8Object.getRuntime());
        v8Array.push(i2);
        V8Object v8Object2 = null;
        try {
            v8Object2 = this.v8Object.executeObjectFunction(FRAME, v8Array);
            return new Frame(v8Object2);
        } finally {
            v8Array.release();
            if (v8Object2 != null) {
                v8Object2.release();
            }
            AppMethodBeat.o(61477);
        }
    }

    @Override // com.eclipsesource.v8.Releasable
    public void release() {
        AppMethodBeat.i(61478);
        if (this.v8Object != null && !this.v8Object.isReleased()) {
            this.v8Object.release();
            this.v8Object = null;
        }
        AppMethodBeat.o(61478);
    }
}
