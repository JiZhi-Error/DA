package com.tencent.thumbplayer.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import java.io.Serializable;

public final class a implements ITPMediaTrackClip, Serializable {
    private int RYH;
    private int RYI;
    private long mEndTime = 0;
    private long mStartPosition;
    private long mStartTime = 0;

    public a(int i2) {
        AppMethodBeat.i(189103);
        this.RYH = i2;
        this.RYI = c.arm(this.RYH);
        AppMethodBeat.o(189103);
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final void setCutTimeRange(long j2, long j3) {
        AppMethodBeat.i(189104);
        if (j2 < 0) {
            j2 = 0;
        }
        if (j2 >= j3) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("setCutTimeRange: Start time is greater than end time");
            AppMethodBeat.o(189104);
            throw illegalArgumentException;
        }
        this.mStartTime = j2;
        this.mEndTime = j3;
        AppMethodBeat.o(189104);
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final int getClipId() {
        return this.RYI;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public final int getMediaType() {
        return this.RYH;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final long getStartTimeMs() {
        return this.mStartTime;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final long getEndTimeMs() {
        return this.mEndTime;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final String getFilePath() {
        return null;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public final String getUrl() {
        return null;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final long getOriginalDurationMs() {
        return this.mEndTime - this.mStartTime;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final void setOriginalDurationMs(long j2) {
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(189105);
        if (obj == null) {
            AppMethodBeat.o(189105);
            return false;
        } else if (!(obj instanceof a)) {
            AppMethodBeat.o(189105);
            return false;
        } else if (this.RYI == ((a) obj).getClipId() && this.RYH == ((a) obj).getMediaType()) {
            AppMethodBeat.o(189105);
            return true;
        } else {
            AppMethodBeat.o(189105);
            return false;
        }
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final ITPMediaTrackClip clone(int i2) {
        AppMethodBeat.i(189106);
        if (i2 == 3 || i2 == 2 || i2 == 1) {
            a aVar = new a(i2);
            aVar.RYI = c.arm(i2);
            aVar.mStartTime = this.mStartTime;
            aVar.mEndTime = this.mEndTime;
            AppMethodBeat.o(189106);
            return aVar;
        }
        AppMethodBeat.o(189106);
        return null;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final void setStartPositionMs(long j2) {
        this.mStartPosition = j2;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final long getStartPositionMs() {
        return this.mStartPosition;
    }
}
