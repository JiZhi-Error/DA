package com.tencent.thumbplayer.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import java.io.Serializable;

public final class e implements ITPMediaTrackClip, Serializable {
    private int RYH;
    private int RYI;
    public String RYW;
    private long RYX;
    private long mEndTime;
    private long mStartPosition;
    private long mStartTime;

    private e() {
    }

    public e(String str, int i2) {
        this(str, i2, 0, -1);
    }

    public e(String str, int i2, long j2, long j3) {
        AppMethodBeat.i(189130);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("TPMediaCompositionTrackClip : clipPath empty");
            AppMethodBeat.o(189130);
            throw illegalArgumentException;
        }
        this.RYH = i2;
        this.RYW = str;
        this.mStartTime = j2;
        this.mEndTime = j3;
        if (this.mStartTime < 0) {
            this.mStartTime = 0;
        }
        if (this.mEndTime <= 0) {
            this.mEndTime = getOriginalDurationMs();
        }
        this.RYI = c.arm(this.RYH);
        AppMethodBeat.o(189130);
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final int getClipId() {
        return this.RYI;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final void setCutTimeRange(long j2, long j3) {
        AppMethodBeat.i(189131);
        if (j2 >= getOriginalDurationMs()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("setCutTimeRange: Start time is greater than duration");
            AppMethodBeat.o(189131);
            throw illegalArgumentException;
        } else if (j3 > getOriginalDurationMs()) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("setCutTimeRange: Start time is greater than duration");
            AppMethodBeat.o(189131);
            throw illegalArgumentException2;
        } else {
            if (j2 < 0) {
                j2 = 0;
            }
            if (j3 <= 0) {
                j3 = getOriginalDurationMs();
            }
            if (j2 >= j3) {
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("setCutTimeRange: Start time is greater than end time");
                AppMethodBeat.o(189131);
                throw illegalArgumentException3;
            }
            this.mStartTime = j2;
            this.mEndTime = j3;
            AppMethodBeat.o(189131);
        }
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final String getFilePath() {
        return this.RYW;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public final String getUrl() {
        return this.RYW;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final long getStartTimeMs() {
        return this.mStartTime;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final long getEndTimeMs() {
        return this.mEndTime;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public final int getMediaType() {
        return this.RYH;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final long getOriginalDurationMs() {
        return this.RYX;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final void setOriginalDurationMs(long j2) {
        this.RYX = j2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(189132);
        if (obj == null) {
            AppMethodBeat.o(189132);
            return false;
        } else if (!(obj instanceof e)) {
            AppMethodBeat.o(189132);
            return false;
        } else if (this.RYI == ((e) obj).getClipId() && this.RYH == ((e) obj).getMediaType()) {
            AppMethodBeat.o(189132);
            return true;
        } else {
            AppMethodBeat.o(189132);
            return false;
        }
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public final ITPMediaTrackClip clone(int i2) {
        AppMethodBeat.i(189133);
        if (i2 == 3 || i2 == 2 || i2 == 1) {
            e eVar = new e();
            eVar.RYH = i2;
            eVar.RYI = c.arm(this.RYH);
            eVar.mStartTime = this.mStartTime;
            eVar.mEndTime = this.mEndTime;
            eVar.RYW = this.RYW;
            AppMethodBeat.o(189133);
            return eVar;
        }
        AppMethodBeat.o(189133);
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
