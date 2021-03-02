package com.tencent.qqmusic.mediaplayer.upstream;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.IOException;

public class TrackDataSource implements PlayerListenerCallback, IDataSource {
    private static final String TAG = "TrackDataSource";
    private IDataSource mDataSource;
    private long mEndBytePosition;
    private long mStartBytePosition;
    private long mStartTimePosition;
    private TrackInfo mTrackInfo;
    private TrackStateCallback mTrackStateCallback;

    public interface TrackStateCallback {
        void onTrackPrepared(TrackInfo trackInfo);
    }

    public TrackDataSource(TrackInfo trackInfo) {
        AppMethodBeat.i(76505);
        String uri = trackInfo.getUri();
        if (TextUtils.isEmpty(trackInfo.getUri())) {
            DataSourceException dataSourceException = new DataSourceException(-1, "track info has no media file path!", null);
            AppMethodBeat.o(76505);
            throw dataSourceException;
        } else if (!new File(uri).exists()) {
            DataSourceException dataSourceException2 = new DataSourceException(-1, "track info's media file not exists!", null);
            AppMethodBeat.o(76505);
            throw dataSourceException2;
        } else {
            this.mDataSource = new FileDataSource(trackInfo.getUri());
            this.mTrackInfo = trackInfo;
            AppMethodBeat.o(76505);
        }
    }

    public void setTrackStateCallback(TrackStateCallback trackStateCallback) {
        this.mTrackStateCallback = trackStateCallback;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public void open() {
        AppMethodBeat.i(76506);
        this.mDataSource.open();
        AppMethodBeat.o(76506);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public int readAt(long j2, byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(76507);
        if (this.mEndBytePosition <= 0 || j2 <= this.mEndBytePosition) {
            int readAt = this.mDataSource.readAt(j2, bArr, i2, i3);
            AppMethodBeat.o(76507);
            return readAt;
        }
        AppMethodBeat.o(76507);
        return -1;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public long getSize() {
        AppMethodBeat.i(76508);
        long size = this.mDataSource.getSize();
        AppMethodBeat.o(76508);
        return size;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AppMethodBeat.i(76509);
        this.mDataSource.close();
        AppMethodBeat.o(76509);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public AudioFormat.AudioType getAudioType() {
        AppMethodBeat.i(76510);
        AudioFormat.AudioType audioType = this.mDataSource.getAudioType();
        AppMethodBeat.o(76510);
        return audioType;
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i2) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onCompletion(BaseMediaPlayer baseMediaPlayer) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onSeekComplete(BaseMediaPlayer baseMediaPlayer, int i2) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onError(BaseMediaPlayer baseMediaPlayer, int i2, int i3, int i4) {
    }

    public void setEndBytePosition(long j2) {
        this.mEndBytePosition = j2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onPrepared(BaseMediaPlayer baseMediaPlayer) {
        AppMethodBeat.i(76511);
        try {
            this.mDataSource.open();
            long size = this.mDataSource.getSize();
            SeekTable createSeekTable = baseMediaPlayer.createSeekTable();
            Pair<Long, Long> range = this.mTrackInfo.getRange();
            Logger.i(TAG, "start time: " + range.first + ", end time: " + range.second);
            if (((Long) range.first).longValue() > ((Long) range.second).longValue()) {
                Logger.e(TAG, "start range larger, return");
                AppMethodBeat.o(76511);
                return;
            }
            this.mStartTimePosition = ((Long) range.first).longValue();
            long seek = createSeekTable.seek(((Long) range.first).longValue());
            long seek2 = createSeekTable.seek(((Long) range.second).longValue());
            if (size <= 0 || seek <= size) {
                if (size > 0 && seek2 > size) {
                    seek2 = size;
                }
                this.mStartBytePosition = seek;
                this.mEndBytePosition = seek2;
                Logger.i(TAG, "start byte: " + this.mStartBytePosition + ", end byte: " + this.mEndBytePosition);
                if (this.mTrackStateCallback != null) {
                    this.mTrackStateCallback.onTrackPrepared(this.mTrackInfo);
                }
                AppMethodBeat.o(76511);
                return;
            }
            Logger.e(TAG, "startBytePosition larger than size!");
            AppMethodBeat.o(76511);
        } catch (IOException e2) {
            Logger.e(TAG, "dataSource open failed!", e2);
            AppMethodBeat.o(76511);
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onStarted(BaseMediaPlayer baseMediaPlayer) {
        AppMethodBeat.i(76512);
        baseMediaPlayer.seekTo(0);
        AppMethodBeat.o(76512);
    }

    @Override // com.tencent.qqmusic.mediaplayer.PlayerListenerCallback
    public void onStateChanged(BaseMediaPlayer baseMediaPlayer, int i2) {
    }
}
