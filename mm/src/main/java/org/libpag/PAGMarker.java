package org.libpag;

public class PAGMarker {
    public String mComment;
    public long mDuration;
    public long mStartTime;

    public PAGMarker(long j2, long j3, String str) {
        this.mStartTime = j2;
        this.mDuration = j3;
        this.mComment = str;
    }
}
