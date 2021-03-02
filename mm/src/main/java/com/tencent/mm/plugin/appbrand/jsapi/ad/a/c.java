package com.tencent.mm.plugin.appbrand.jsapi.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c extends com.tencent.luggage.a.b {

    public enum a {
        AUTO(0, "auto"),
        MIC(1, "mic"),
        CAMCORDER(5, "camcorder"),
        VOICE_RECOGNITION(6, "voice_recognition"),
        VOICE_COMMUNICATION(7, "voice_communication"),
        UNPROCESSED(9, "unprocessed");
        
        public int mFN;
        public String mFO;

        public static a valueOf(String str) {
            AppMethodBeat.i(137900);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(137900);
            return aVar;
        }

        static {
            AppMethodBeat.i(137901);
            AppMethodBeat.o(137901);
        }

        private a(int i2, String str) {
            this.mFN = i2;
            this.mFO = str;
        }
    }

    public static class b {
        int duration;
        String filePath;
        String format;
        int mFQ;
        int mFR;
        double mFS;
        a mFT;
        int sampleRate;

        public final String toString() {
            AppMethodBeat.i(137902);
            String str = "RecordParams{filePath='" + this.filePath + '\'' + ", duration=" + this.duration + ", sampleRate=" + this.sampleRate + ", numberOfChannels=" + this.mFQ + ", format='" + this.format + '\'' + ", encodeBitRate=" + this.mFR + ", frameSize=" + this.mFS + ", audioSource=" + this.mFT + '}';
            AppMethodBeat.o(137902);
            return str;
        }
    }
}
