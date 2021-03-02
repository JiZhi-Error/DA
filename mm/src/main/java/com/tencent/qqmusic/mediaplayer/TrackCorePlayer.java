package com.tencent.qqmusic.mediaplayer;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

class TrackCorePlayer extends CorePlayer implements TrackDataSource.TrackStateCallback {
    private static final String TAG = "TrackCorePlayer";
    private long mStartPosition = 0;

    TrackCorePlayer(IDataSource iDataSource, PlayerCallback playerCallback, Looper looper, QMThreadExecutor qMThreadExecutor) {
        super(iDataSource, null, playerCallback, looper, new NativeDecoder(), qMThreadExecutor);
        AppMethodBeat.i(76571);
        AppMethodBeat.o(76571);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.CorePlayer
    public long getCurPosition() {
        AppMethodBeat.i(76572);
        long curPosition = super.getCurPosition() - this.mStartPosition;
        AppMethodBeat.o(76572);
        return curPosition;
    }

    @Override // com.tencent.qqmusic.mediaplayer.CorePlayer
    public void seek(int i2) {
        AppMethodBeat.i(76573);
        int i3 = (int) (((long) i2) + this.mStartPosition);
        Logger.i(TAG, "seek, position: " + i2 + " ,realseek: " + i3);
        super.seek(i3);
        AppMethodBeat.o(76573);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource.TrackStateCallback
    public void onTrackPrepared(TrackInfo trackInfo) {
        AppMethodBeat.i(76574);
        this.mStartPosition = ((Long) trackInfo.getRange().first).longValue();
        long longValue = ((Long) trackInfo.getRange().second).longValue();
        long longValue2 = ((Long) trackInfo.getRange().first).longValue();
        Logger.i(TAG, "onTrackPrepared, start byte: " + longValue2 + ", end byte: " + longValue);
        this.mInformation.setDuration(longValue - longValue2);
        AppMethodBeat.o(76574);
    }
}
