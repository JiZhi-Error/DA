package com.tencent.qqmusic.mediaplayer.utils;

import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.audioplaylist.AudioPlayListItemInfo;
import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.seektable.NativeSeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.TrackDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class AudioUtil {
    private static final int DEFAULT_DECODE_BUFFER_SIZE = 8192;
    private static final String TAG = "AudioUtil";

    public static int getDecodeBufferSize(NativeDecoder nativeDecoder) {
        AppMethodBeat.i(76599);
        AudioInformation audioInformation = nativeDecoder.getAudioInformation();
        int i2 = 0;
        if (audioInformation != null && audioInformation.getAudioType() == AudioFormat.AudioType.FLAC) {
            i2 = (int) nativeDecoder.getMinBufferSize();
        }
        if (i2 <= 0) {
            i2 = 8192;
        }
        AppMethodBeat.o(76599);
        return i2;
    }

    public static int getDecodeBufferSizeForPlay(NativeDecoder nativeDecoder) {
        int i2;
        int i3 = 12;
        int i4 = 2;
        AppMethodBeat.i(76600);
        int decodeBufferSize = getDecodeBufferSize(nativeDecoder);
        AudioInformation audioInformation = nativeDecoder.getAudioInformation();
        if (audioInformation == null || audioInformation.getAudioType() == AudioFormat.AudioType.FLAC) {
            i2 = decodeBufferSize;
        } else {
            int channels = audioInformation.getChannels();
            if (channels == 1) {
                i3 = 4;
            } else if (channels != 2) {
                if (channels == 6) {
                    i3 = 252;
                } else if (channels == 8) {
                    i3 = 1020;
                }
            }
            if (audioInformation.getBitDepth() == 1) {
                i4 = 3;
            }
            i2 = Math.max(AudioTrack.getMinBufferSize((int) audioInformation.getSampleRate(), i3, i4), decodeBufferSize);
        }
        AppMethodBeat.o(76600);
        return i2;
    }

    public static NativeDecoder getDecoderFromTrack(String str, long j2, long j3) {
        AppMethodBeat.i(76601);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(76601);
            return null;
        } else if (j2 >= j3) {
            AppMethodBeat.o(76601);
            return null;
        } else {
            NativeDecoder nativeDecoder = new NativeDecoder();
            TrackInfo trackInfo = new TrackInfo(AudioPlayListItemInfo.TYPE_CUE);
            trackInfo.setFilePath(str);
            trackInfo.setStartPosition(j2);
            trackInfo.setEndPostion(j3);
            try {
                TrackDataSource trackDataSource = new TrackDataSource(trackInfo);
                if (nativeDecoder.init(trackDataSource) != 0) {
                    Logger.e(TAG, "init decoder from track failed!");
                    AppMethodBeat.o(76601);
                    return null;
                }
                long seek = new NativeSeekTable(nativeDecoder).seek(j3);
                if (seek <= 0) {
                    Logger.e(TAG, "endPos from track <= 0");
                    AppMethodBeat.o(76601);
                    return null;
                }
                trackDataSource.setEndBytePosition(seek);
                nativeDecoder.seekTo((int) j2);
                AppMethodBeat.o(76601);
                return nativeDecoder;
            } catch (Exception e2) {
                Logger.e(TAG, e2);
                AppMethodBeat.o(76601);
                return null;
            }
        }
    }

    public static NativeDecoder getDecoder(String str, boolean z, long j2, long j3) {
        AppMethodBeat.i(76602);
        if (z) {
            NativeDecoder decoderFromTrack = getDecoderFromTrack(str, j2, j3);
            AppMethodBeat.o(76602);
            return decoderFromTrack;
        }
        NativeDecoder decoderFormFile = AudioRecognition.getDecoderFormFile(str);
        AppMethodBeat.o(76602);
        return decoderFormFile;
    }

    public static int getPlaybackHeadPositionSafely(AudioTrack audioTrack) {
        AppMethodBeat.i(76603);
        int i2 = 0;
        if (audioTrack != null) {
            try {
                i2 = audioTrack.getPlaybackHeadPosition();
            } catch (Exception e2) {
                Logger.e(TAG, "getPlaybackHeadPositionSafely", e2);
            }
        }
        AppMethodBeat.o(76603);
        return i2;
    }
}
