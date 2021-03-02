package com.tencent.liteav.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface TXAudioEffectManager {

    public interface TXMusicPlayObserver {
        void onComplete(int i2, int i3);

        void onPlayProgress(int i2, long j2, long j3);

        void onStart(int i2, int i3);
    }

    void enableVoiceEarMonitor(boolean z);

    long getMusicCurrentPosInMS(int i2);

    long getMusicDurationInMS(String str);

    void pausePlayMusic(int i2);

    void resumePlayMusic(int i2);

    void seekMusicToPosInMS(int i2, int i3);

    void setAllMusicVolume(int i2);

    void setMusicObserver(int i2, TXMusicPlayObserver tXMusicPlayObserver);

    void setMusicPitch(int i2, float f2);

    void setMusicPlayoutVolume(int i2, int i3);

    void setMusicPublishVolume(int i2, int i3);

    void setMusicSpeedRate(int i2, float f2);

    void setVoiceCaptureVolume(int i2);

    void setVoiceChangerType(TXVoiceChangerType tXVoiceChangerType);

    void setVoiceEarMonitorVolume(int i2);

    void setVoiceReverbType(TXVoiceReverbType tXVoiceReverbType);

    boolean startPlayMusic(AudioMusicParam audioMusicParam);

    void stopPlayMusic(int i2);

    public static class AudioMusicParam {
        public long endTimeMS = -1;
        public int id;
        public boolean isShortFile = false;
        public int loopCount = 0;
        public String path;
        public boolean publish = false;
        public long startTimeMS = 0;

        public AudioMusicParam(int i2, String str) {
            this.path = str;
            this.id = i2;
        }
    }

    public enum TXVoiceChangerType {
        TXLiveVoiceChangerType_0(0),
        TXLiveVoiceChangerType_1(1),
        TXLiveVoiceChangerType_2(2),
        TXLiveVoiceChangerType_3(3),
        TXLiveVoiceChangerType_4(4),
        TXLiveVoiceChangerType_5(5),
        TXLiveVoiceChangerType_6(6),
        TXLiveVoiceChangerType_7(7),
        TXLiveVoiceChangerType_8(8),
        TXLiveVoiceChangerType_9(9),
        TXLiveVoiceChangerType_10(10),
        TXLiveVoiceChangerType_11(11);
        
        private int nativeValue;

        public static TXVoiceChangerType valueOf(String str) {
            AppMethodBeat.i(221851);
            TXVoiceChangerType tXVoiceChangerType = (TXVoiceChangerType) Enum.valueOf(TXVoiceChangerType.class, str);
            AppMethodBeat.o(221851);
            return tXVoiceChangerType;
        }

        static {
            AppMethodBeat.i(221852);
            AppMethodBeat.o(221852);
        }

        private TXVoiceChangerType(int i2) {
            this.nativeValue = i2;
        }

        public final int getNativeValue() {
            return this.nativeValue;
        }
    }

    public enum TXVoiceReverbType {
        TXLiveVoiceReverbType_0(0),
        TXLiveVoiceReverbType_1(1),
        TXLiveVoiceReverbType_2(2),
        TXLiveVoiceReverbType_3(3),
        TXLiveVoiceReverbType_4(4),
        TXLiveVoiceReverbType_5(5),
        TXLiveVoiceReverbType_6(6),
        TXLiveVoiceReverbType_7(7);
        
        private int nativeValue;

        public static TXVoiceReverbType valueOf(String str) {
            AppMethodBeat.i(221790);
            TXVoiceReverbType tXVoiceReverbType = (TXVoiceReverbType) Enum.valueOf(TXVoiceReverbType.class, str);
            AppMethodBeat.o(221790);
            return tXVoiceReverbType;
        }

        static {
            AppMethodBeat.i(221791);
            AppMethodBeat.o(221791);
        }

        private TXVoiceReverbType(int i2) {
            this.nativeValue = i2;
        }

        public final int getNativeValue() {
            return this.nativeValue;
        }
    }
}
