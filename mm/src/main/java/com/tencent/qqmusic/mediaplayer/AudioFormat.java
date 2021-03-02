package com.tencent.qqmusic.mediaplayer;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AudioFormat {
    private static final String EXTENSION_AAC = "aac";
    private static final String EXTENSION_AMR = "amr";
    private static final String EXTENSION_APE = "ape";
    private static final String EXTENSION_FLAC = "flac";
    private static final String EXTENSION_M4A = "m4a";
    private static final String EXTENSION_MP3 = "mp3";
    private static final String EXTENSION_MP4 = "mp4";
    private static final String EXTENSION_OGG = "ogg";
    private static final String EXTENSION_WAV = "wav";
    private static final String EXTENSION_WMA = "wma";
    private static final int VALUE_AAC = 11;
    private static final int VALUE_AMR = 6;
    private static final int VALUE_APE = 5;
    private static final int VALUE_FLAC = 2;
    private static final int VALUE_M4A = 3;
    private static final int VALUE_MP3 = 9;
    private static final int VALUE_MP4 = 10;
    private static final int VALUE_OGG = 4;
    private static final int VALUE_UNSUPPORT = 1;
    private static final int VALUE_WAV = 8;
    private static final int VALUE_WMA = 7;

    public enum AudioType {
        UNSUPPORT(1, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN),
        MP3(9, AudioFormat.EXTENSION_MP3),
        OGG(4, AudioFormat.EXTENSION_OGG),
        M4A(3, AudioFormat.EXTENSION_M4A),
        FLAC(2, AudioFormat.EXTENSION_FLAC),
        APE(5, AudioFormat.EXTENSION_APE),
        WAV(8, AudioFormat.EXTENSION_WAV),
        WMA(7, AudioFormat.EXTENSION_WMA),
        AMR(6, AudioFormat.EXTENSION_AMR),
        MP4(10, AudioFormat.EXTENSION_MP4),
        AAC(11, AudioFormat.EXTENSION_AAC);
        
        private String extension;
        private int value = 0;

        public static AudioType valueOf(String str) {
            AppMethodBeat.i(87756);
            AudioType audioType = (AudioType) Enum.valueOf(AudioType.class, str);
            AppMethodBeat.o(87756);
            return audioType;
        }

        static {
            AppMethodBeat.i(87757);
            AppMethodBeat.o(87757);
        }

        private AudioType(int i2, String str) {
            this.value = i2;
            this.extension = str;
        }

        public final int getValue() {
            return this.value;
        }

        public final String getExtension() {
            return this.extension;
        }
    }

    public static boolean isAudioType(AudioType audioType) {
        AppMethodBeat.i(87748);
        if (audioType == null || AudioType.UNSUPPORT.equals(audioType)) {
            AppMethodBeat.o(87748);
            return false;
        }
        AppMethodBeat.o(87748);
        return true;
    }

    public static AudioType getAudioType(int i2) {
        AppMethodBeat.i(87749);
        AudioType[] values = AudioType.values();
        for (AudioType audioType : values) {
            if (audioType.value == i2) {
                AppMethodBeat.o(87749);
                return audioType;
            }
        }
        AudioType audioType2 = AudioType.UNSUPPORT;
        AppMethodBeat.o(87749);
        return audioType2;
    }
}
