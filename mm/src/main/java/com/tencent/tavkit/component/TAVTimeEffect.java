package com.tencent.tavkit.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public class TAVTimeEffect {
    private boolean freeze = false;
    private int loopCount = 1;
    private boolean reverse = false;
    private CMTime scaledDuration = CMTime.CMTimeInvalid;
    private CMTimeRange timeRange;

    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
    }

    public CMTime getScaledDuration() {
        return this.scaledDuration;
    }

    public void setScaledDuration(CMTime cMTime) {
        this.scaledDuration = cMTime;
    }

    public int getLoopCount() {
        AppMethodBeat.i(197425);
        int abs = Math.abs(this.loopCount);
        AppMethodBeat.o(197425);
        return abs;
    }

    public void setLoopCount(int i2) {
        this.loopCount = i2;
    }

    public boolean isFreeze() {
        return this.freeze;
    }

    public void setFreeze(boolean z) {
        this.freeze = z;
    }

    public boolean isReverse() {
        return this.reverse;
    }

    public void setReverse(boolean z) {
        this.reverse = z;
    }
}
