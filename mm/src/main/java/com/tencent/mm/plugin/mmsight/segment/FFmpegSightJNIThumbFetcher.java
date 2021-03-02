package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;

public class FFmpegSightJNIThumbFetcher implements d {
    private static final String TAG = "MicroMsg.FFmpegSightJNIThumbFetcher";
    private int mBufId;
    private int mDurationMs;
    private Bitmap mReusedBitmap;
    private int mScaledHeight;
    private int mScaledWidth;

    @Override // com.tencent.mm.plugin.mmsight.segment.d
    public void init(String str, int i2, int i3, int i4) {
        AppMethodBeat.i(107630);
        Log.i(TAG, "init() called with: path = [" + str + "], segment_interval = [" + i2 + "], width = [" + i3 + "], height = [" + i4 + "]");
        this.mBufId = SightVideoJNI.openFileVFS(str, 1, 16, false);
        if (this.mBufId < 0) {
            o oVar = new o("open file error.");
            AppMethodBeat.o(107630);
            throw oVar;
        }
        int videoWidth = SightVideoJNI.getVideoWidth(this.mBufId);
        int videoHeight = SightVideoJNI.getVideoHeight(this.mBufId);
        this.mDurationMs = (int) (SightVideoJNI.getVideoDuration(this.mBufId) * 1000.0d);
        Point calculateScaledLength = calculateScaledLength(i3, i4, videoWidth, videoHeight, new Point());
        this.mScaledWidth = calculateScaledLength.x;
        this.mScaledHeight = calculateScaledLength.y;
        Log.i(TAG, "FFmpegSightJNIThumbFetcher.init. scaled size is (%d, %d); raw size is (%d, %d)", Integer.valueOf(this.mScaledWidth), Integer.valueOf(this.mScaledHeight), Integer.valueOf(videoWidth), Integer.valueOf(videoHeight));
        AppMethodBeat.o(107630);
    }

    private Point calculateScaledLength(int i2, int i3, int i4, int i5, Point point) {
        AppMethodBeat.i(107631);
        if (point == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("FFmpegThumbFetcherImpl : Point to calculateScaledLength can not be null.");
            AppMethodBeat.o(107631);
            throw illegalArgumentException;
        }
        if (i3 <= 0 && i2 <= 0) {
            point.x = i4;
            point.y = i5;
            AppMethodBeat.o(107631);
        } else if (i2 <= 0) {
            point.x = (int) ((((float) i3) / ((float) i5)) * ((float) i4));
            point.y = i3;
            AppMethodBeat.o(107631);
        } else if (i3 <= 0) {
            point.x = i2;
            point.y = (int) ((((float) i2) / ((float) i4)) * ((float) i5));
            AppMethodBeat.o(107631);
        } else {
            if (((float) i3) / ((float) i2) > ((float) i5) / ((float) i4)) {
                point.x = (int) ((((float) i4) * ((float) i3)) / ((float) i5));
                point.y = i3;
            } else {
                point.x = i2;
                point.y = (int) ((((float) i5) * ((float) i2)) / ((float) i4));
            }
            AppMethodBeat.o(107631);
        }
        return point;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.d
    public void reuseBitmap(Bitmap bitmap) {
        AppMethodBeat.i(107632);
        Log.i(TAG, "reuseBitmap() called with: bitmap = [" + bitmap + "]");
        if (bitmap == null) {
            AppMethodBeat.o(107632);
            return;
        }
        this.mReusedBitmap = bitmap;
        AppMethodBeat.o(107632);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.d
    public Bitmap getFrameAtTime(long j2) {
        long j3;
        long j4 = 0;
        AppMethodBeat.i(107633);
        Log.i(TAG, "getFrameAtTime() called with: timeMs = [%d], mBufId = [%d]", Long.valueOf(j2), Integer.valueOf(this.mBufId));
        if (j2 > ((long) this.mDurationMs)) {
            j3 = (long) this.mDurationMs;
        } else {
            j3 = j2;
        }
        if (j3 >= 0) {
            j4 = j3;
        }
        Log.i(TAG, "getFrameAtTime() seekStream return %d", Integer.valueOf(SightVideoJNI.seekStreamWithFlag((double) (((float) j4) / 1000.0f), 1, this.mBufId)));
        if (this.mReusedBitmap == null || this.mReusedBitmap.isRecycled() || this.mReusedBitmap.getWidth() != this.mScaledWidth || this.mReusedBitmap.getHeight() != this.mScaledHeight) {
            if (this.mReusedBitmap != null && !this.mReusedBitmap.isRecycled()) {
                o.itM.f(this.mReusedBitmap);
            }
            this.mReusedBitmap = o.itM.a(new o.b(this.mScaledWidth, this.mScaledHeight));
        }
        Log.i(TAG, "getFrameAtTime() dr return %d", Integer.valueOf(SightVideoJNI.drawScaledFrame(this.mBufId, this.mReusedBitmap, this.mScaledWidth, this.mScaledHeight)));
        Bitmap bitmap = this.mReusedBitmap;
        this.mReusedBitmap = null;
        AppMethodBeat.o(107633);
        return bitmap;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.d
    public int getDurationMs() {
        AppMethodBeat.i(107634);
        Log.i(TAG, "getDurationMs() returned: " + this.mDurationMs);
        int i2 = this.mDurationMs;
        AppMethodBeat.o(107634);
        return i2;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.d
    public int getScaledWidth() {
        AppMethodBeat.i(107635);
        Log.i(TAG, "getScaledWidth() returned: " + this.mScaledWidth);
        int i2 = this.mScaledWidth;
        AppMethodBeat.o(107635);
        return i2;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.d
    public int getScaledHeight() {
        AppMethodBeat.i(107636);
        Log.i(TAG, "getScaledHeight() returned: " + this.mScaledHeight);
        int i2 = this.mScaledHeight;
        AppMethodBeat.o(107636);
        return i2;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.d
    public void release() {
        AppMethodBeat.i(107637);
        Log.i(TAG, "release() called");
        ThreadPool.post(new ReleaseRunnable(this.mReusedBitmap, this.mBufId), "release");
        AppMethodBeat.o(107637);
    }

    static class ReleaseRunnable implements Runnable {
        int mBufId;
        Bitmap mReusedBitmap;

        private ReleaseRunnable(Bitmap bitmap, int i2) {
            this.mReusedBitmap = bitmap;
            this.mBufId = i2;
        }

        public void run() {
            AppMethodBeat.i(107629);
            if (this.mReusedBitmap != null && !this.mReusedBitmap.isRecycled()) {
                o.itM.f(this.mReusedBitmap);
            }
            SightVideoJNI.freeObj(this.mBufId);
            AppMethodBeat.o(107629);
        }
    }
}
