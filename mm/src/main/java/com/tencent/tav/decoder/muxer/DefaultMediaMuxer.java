package com.tencent.tav.decoder.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;

public class DefaultMediaMuxer implements IMediaMuxer {
    private final String TAG = "DefaultMediaMuxer";
    private int audioTrackIndex = -1;
    private boolean isStarted = false;
    private MediaMuxer muxer;
    private int videoTrackIndex = -1;

    public DefaultMediaMuxer(String str, int i2) {
        AppMethodBeat.i(218459);
        this.muxer = new MediaMuxer(str, i2);
        AppMethodBeat.o(218459);
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void setExportConfig(ExportConfig exportConfig) {
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void start() {
        AppMethodBeat.i(218460);
        this.muxer.start();
        this.isStarted = true;
        AppMethodBeat.o(218460);
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public boolean isMuxerStarted() {
        return this.isStarted;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public boolean ignoreHeader() {
        return true;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public int addTrack(MediaFormat mediaFormat) {
        AppMethodBeat.i(218461);
        int addTrack = this.muxer.addTrack(mediaFormat);
        if (mediaFormat.containsKey("mime")) {
            String string = mediaFormat.getString("mime");
            Logger.i("DefaultMediaMuxer", "add track mime:".concat(String.valueOf(string)));
            if (string.contains("video")) {
                this.videoTrackIndex = addTrack;
            } else if (string.contains(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) {
                this.audioTrackIndex = addTrack;
            }
        }
        AppMethodBeat.o(218461);
        return addTrack;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void writeSampleData(int i2, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        AppMethodBeat.i(218462);
        this.muxer.writeSampleData(i2, byteBuffer, bufferInfo);
        AppMethodBeat.o(218462);
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void writeSampleDataTime(boolean z, CMTime cMTime) {
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public int videoTrackIndex() {
        return this.videoTrackIndex;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public int audioTrackIndex() {
        return this.audioTrackIndex;
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void stop() {
        AppMethodBeat.i(218463);
        this.muxer.stop();
        this.isStarted = false;
        Logger.i("DefaultMediaMuxer", "stop muxer");
        AppMethodBeat.o(218463);
    }

    @Override // com.tencent.tav.decoder.muxer.IMediaMuxer
    public void release() {
        AppMethodBeat.i(218464);
        this.muxer.release();
        this.isStarted = false;
        Logger.i("DefaultMediaMuxer", "release muxer");
        AppMethodBeat.o(218464);
    }
}
