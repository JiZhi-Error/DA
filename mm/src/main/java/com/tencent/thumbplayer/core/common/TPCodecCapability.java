package com.tencent.thumbplayer.core.common;

import java.io.Serializable;

public interface TPCodecCapability {
    public static final int DEFAULT_FRAMERATE = 30;

    public static class TPACodecCapability implements Serializable {
        int channels;
        boolean isSupported;
        int level;
        int profile;
    }

    public static class TPVCodecPropertyRange implements Serializable {
        public int level;
        public int lowerboundHeight;
        public int lowerboundWidth;
        public int profile;
        public int upperboundHeight;
        public int upperboundWidth;

        public void set(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.upperboundWidth = i2;
            this.upperboundHeight = i3;
            this.lowerboundWidth = i4;
            this.lowerboundHeight = i5;
            this.profile = i6;
            this.level = i7;
        }
    }

    public static class TPVCodecMaxCapability implements Serializable {
        public int maxFramerateFormaxLumaSamples;
        public int maxLevel;
        public int maxLumaSamples;
        public int maxProfile;

        @Deprecated
        TPVCodecMaxCapability(int i2, int i3, int i4) {
            this.maxLumaSamples = i2;
            this.maxProfile = i3;
            this.maxLevel = i4;
            this.maxFramerateFormaxLumaSamples = 30;
        }

        TPVCodecMaxCapability(int i2, int i3, int i4, int i5) {
            this.maxLumaSamples = i2;
            this.maxProfile = i3;
            this.maxLevel = i4;
            this.maxFramerateFormaxLumaSamples = i5;
        }
    }
}
