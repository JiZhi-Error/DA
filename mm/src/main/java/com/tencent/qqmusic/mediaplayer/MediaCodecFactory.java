package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.ape.ApeRecognition;
import com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegRecognition;
import com.tencent.qqmusic.mediaplayer.codec.flac.FLACRecognition;
import com.tencent.qqmusic.mediaplayer.codec.mp3.MP3Recognition;
import com.tencent.qqmusic.mediaplayer.codec.ogg.VorbisRecognition;
import com.tencent.qqmusic.mediaplayer.codec.wav.WavRecognition;
import com.tencent.qqmusic.mediaplayer.codec.wma.WmaRecognition;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;

public class MediaCodecFactory {
    private static final String TAG = "MediaCodecFactory";
    private static HashMap<AudioFormat.AudioType, Class<? extends IAudioRecognition>> mDecoderMap = new HashMap<>();
    private static ArrayList<AudioFormat.AudioType> mSupportAudioType = new ArrayList<>();

    static {
        AppMethodBeat.i(114218);
        registerDecoder(AudioFormat.AudioType.M4A, FfmpegRecognition.class);
        registerDecoder(AudioFormat.AudioType.OGG, VorbisRecognition.class);
        registerDecoder(AudioFormat.AudioType.FLAC, FLACRecognition.class);
        registerDecoder(AudioFormat.AudioType.MP3, MP3Recognition.class);
        registerDecoder(AudioFormat.AudioType.APE, ApeRecognition.class);
        registerDecoder(AudioFormat.AudioType.WAV, WavRecognition.class);
        registerDecoder(AudioFormat.AudioType.WMA, WmaRecognition.class);
        registerDecoder(AudioFormat.AudioType.MP4, FfmpegRecognition.class);
        registerDecoder(AudioFormat.AudioType.AAC, FfmpegRecognition.class);
        AppMethodBeat.o(114218);
    }

    private static void registerDecoder(AudioFormat.AudioType audioType, Class<? extends IAudioRecognition> cls) {
        AppMethodBeat.i(114214);
        mDecoderMap.put(audioType, cls);
        mSupportAudioType.add(audioType);
        AppMethodBeat.o(114214);
    }

    public static void unRegisterDecoder(AudioFormat.AudioType audioType) {
        AppMethodBeat.i(114215);
        mSupportAudioType.remove(audioType);
        mDecoderMap.remove(audioType);
        AppMethodBeat.o(114215);
    }

    static IAudioRecognition createDecoderByType(AudioFormat.AudioType audioType) {
        IAudioRecognition iAudioRecognition;
        AppMethodBeat.i(114216);
        if (!AudioFormat.isAudioType(audioType)) {
            AppMethodBeat.o(114216);
            return null;
        }
        if (mDecoderMap.containsKey(audioType)) {
            try {
                iAudioRecognition = (IAudioRecognition) mDecoderMap.get(audioType).newInstance();
            } catch (Throwable th) {
                Logger.e(TAG, "createDecoderByType error", th);
            }
            AppMethodBeat.o(114216);
            return iAudioRecognition;
        }
        iAudioRecognition = null;
        AppMethodBeat.o(114216);
        return iAudioRecognition;
    }

    public static ArrayList<AudioFormat.AudioType> getSupportAudioType() {
        AppMethodBeat.i(114217);
        ArrayList<AudioFormat.AudioType> arrayList = new ArrayList<>(mSupportAudioType);
        AppMethodBeat.o(114217);
        return arrayList;
    }
}
