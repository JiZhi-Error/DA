package com.tencent.thumbplayer.api.capability;

public class TPVCodecCapabilityForGet {
    public int maxFramerateFormaxLumaSamples;
    private int maxLevel;
    private int maxLumaSamples;
    private int maxProfile;

    public TPVCodecCapabilityForGet(int i2, int i3, int i4, int i5) {
        this.maxLumaSamples = i2;
        this.maxProfile = i3;
        this.maxLevel = i4;
        this.maxFramerateFormaxLumaSamples = i5;
    }

    public int getMaxLumaSamples() {
        return this.maxLumaSamples;
    }

    public int getMaxProfile() {
        return this.maxProfile;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public int getMaxFramerateFormaxLumaSamples() {
        return this.maxFramerateFormaxLumaSamples;
    }
}
