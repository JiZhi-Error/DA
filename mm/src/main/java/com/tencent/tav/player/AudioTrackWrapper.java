package com.tencent.tav.player;

import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;

public class AudioTrackWrapper {
    private static final String TAG = "AudioTrackWrapper";
    private AudioTrack mAudioTrack;

    /* access modifiers changed from: package-private */
    public static class AudioTrackConfig {
        int audioFormat = 2;
        int bufferSizeInBytes;
        int channelConfig = 12;
        int mode = 1;
        int sampleRateInHz;
        int streamType = 3;

        public AudioTrackConfig(int i2, int i3) {
            AppMethodBeat.i(218535);
            this.sampleRateInHz = getSampleRateInHz(i2, i3);
            this.bufferSizeInBytes = 8192;
            AppMethodBeat.o(218535);
        }

        private int getSampleRateInHz(int i2, int i3) {
            if (i3 == 1) {
                return i2 / 2;
            }
            return i2;
        }

        public String toString() {
            AppMethodBeat.i(218536);
            String str = "AudioTrackConfig{streamType=" + this.streamType + ", sampleRateInHz=" + this.sampleRateInHz + ", channelConfig=" + this.channelConfig + ", audioFormat=" + this.audioFormat + ", bufferSizeInBytes=" + this.bufferSizeInBytes + ", mode=" + this.mode + '}';
            AppMethodBeat.o(218536);
            return str;
        }
    }

    public AudioTrackWrapper(MediaFormat mediaFormat) {
        AppMethodBeat.i(218537);
        try {
            init(mediaFormat.getInteger("sample-rate"), mediaFormat.getInteger("channel-count"));
            AppMethodBeat.o(218537);
        } catch (Exception e2) {
            AppMethodBeat.o(218537);
        }
    }

    public AudioTrackWrapper(int i2, int i3) {
        AppMethodBeat.i(218538);
        try {
            init(i2, i3);
            AppMethodBeat.o(218538);
        } catch (Exception e2) {
            AppMethodBeat.o(218538);
        }
    }

    public boolean allow() {
        return this.mAudioTrack != null;
    }

    public void stop() {
        AppMethodBeat.i(218539);
        if (!allow()) {
            AppMethodBeat.o(218539);
            return;
        }
        if (this.mAudioTrack.getState() == 3 || this.mAudioTrack.getState() == 2) {
            this.mAudioTrack.stop();
        }
        AppMethodBeat.o(218539);
    }

    public void parse() {
        AppMethodBeat.i(218540);
        if (!allow()) {
            AppMethodBeat.o(218540);
            return;
        }
        if (this.mAudioTrack != null && this.mAudioTrack.getPlayState() == 3) {
            this.mAudioTrack.pause();
        }
        AppMethodBeat.o(218540);
    }

    public void writeData(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(218541);
        if (!allow()) {
            AppMethodBeat.o(218541);
            return;
        }
        if (this.mAudioTrack != null) {
            try {
                this.mAudioTrack.write(bArr, i2, i3);
                if (this.mAudioTrack.getPlayState() != 3) {
                    this.mAudioTrack.play();
                }
                AppMethodBeat.o(218541);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(218541);
    }

    public void flush() {
        AppMethodBeat.i(218542);
        if (!allow()) {
            AppMethodBeat.o(218542);
            return;
        }
        try {
            if (this.mAudioTrack != null) {
                this.mAudioTrack.flush();
            }
            AppMethodBeat.o(218542);
        } catch (Exception e2) {
            Logger.e(TAG, "flush: ", e2);
            AppMethodBeat.o(218542);
        }
    }

    public void release() {
        AppMethodBeat.i(218543);
        if (!allow()) {
            AppMethodBeat.o(218543);
            return;
        }
        stop();
        this.mAudioTrack.release();
        Logger.d(TAG, "release:--> ".concat(String.valueOf(this)));
        AppMethodBeat.o(218543);
    }

    private void init(int i2, int i3) {
        AppMethodBeat.i(218544);
        if (i2 <= 0) {
            AppMethodBeat.o(218544);
            return;
        }
        AudioTrackConfig audioTrackConfig = new AudioTrackConfig(i2, i3);
        Logger.d(TAG, "init:--> ".concat(String.valueOf(this)));
        try {
            this.mAudioTrack = new AudioTrack(audioTrackConfig.streamType, audioTrackConfig.sampleRateInHz, audioTrackConfig.channelConfig, audioTrackConfig.audioFormat, audioTrackConfig.bufferSizeInBytes, audioTrackConfig.mode);
        } catch (IllegalArgumentException e2) {
            this.mAudioTrack = null;
        }
        if (this.mAudioTrack != null) {
            this.mAudioTrack.play();
        }
        AppMethodBeat.o(218544);
    }

    public void setVolume(float f2) {
        AppMethodBeat.i(218545);
        if (!allow()) {
            AppMethodBeat.o(218545);
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.mAudioTrack.setVolume(f2);
            AppMethodBeat.o(218545);
        } else {
            this.mAudioTrack.setStereoVolume(f2, f2);
            AppMethodBeat.o(218545);
        }
    }
}
