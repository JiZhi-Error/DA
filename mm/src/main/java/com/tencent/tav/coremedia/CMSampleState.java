package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CMSampleState {
    private boolean isNewFrame;
    private String msg;
    private long stateCode;
    private Throwable throwable;
    private final CMTime time;

    public static CMSampleState fromError(long j2) {
        AppMethodBeat.i(199403);
        CMSampleState fromError = fromError(j2, "state:".concat(String.valueOf(j2)));
        AppMethodBeat.o(199403);
        return fromError;
    }

    public static CMSampleState fromError(long j2, String str) {
        AppMethodBeat.i(199404);
        CMSampleState fromError = fromError(j2, str, new RuntimeException(str));
        AppMethodBeat.o(199404);
        return fromError;
    }

    public static CMSampleState fromError(long j2, String str, Throwable th) {
        AppMethodBeat.i(199405);
        CMSampleState cMSampleState = new CMSampleState(j2, str, th);
        AppMethodBeat.o(199405);
        return cMSampleState;
    }

    public CMSampleState() {
        this(CMTime.CMTimeInvalid);
    }

    public CMSampleState(CMTime cMTime) {
        AppMethodBeat.i(199406);
        this.isNewFrame = true;
        this.stateCode = 0;
        this.time = cMTime;
        if (cMTime.value < 0) {
            this.stateCode = cMTime.value;
        }
        AppMethodBeat.o(199406);
    }

    public CMSampleState(long j2, String str, Throwable th) {
        AppMethodBeat.i(199407);
        this.isNewFrame = true;
        this.stateCode = 0;
        this.time = new CMTime(j2);
        this.stateCode = j2;
        this.msg = str;
        this.throwable = th;
        AppMethodBeat.o(199407);
    }

    public boolean stateMatchingTo(long... jArr) {
        for (long j2 : jArr) {
            if (this.stateCode == j2) {
                return true;
            }
        }
        return false;
    }

    public boolean isNewFrame() {
        return this.isNewFrame;
    }

    public void setNewFrame(boolean z) {
        this.isNewFrame = z;
    }

    public CMTime getTime() {
        return this.time;
    }

    public long getStateCode() {
        return this.stateCode;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isInvalid() {
        return this.time == CMTime.CMTimeInvalid;
    }

    public String toString() {
        AppMethodBeat.i(199408);
        String str = "CMSampleState{time=" + this.time + ", isNewFrame=" + this.isNewFrame + ", stateCode=" + this.stateCode + ", throwable=" + this.throwable + ", msg='" + this.msg + '\'' + '}';
        AppMethodBeat.o(199408);
        return str;
    }
}
