package com.tencent.thumbplayer.api.capability;

public class TPVCodecCapabilityForSet {
    private int level;
    private int lowerboundHeight;
    private int lowerboundWidth;
    private int profile;
    private int upperboundHeight;
    private int upperboundWidth;

    public TPVCodecCapabilityForSet(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.upperboundWidth = i2;
        this.upperboundHeight = i3;
        this.lowerboundWidth = i4;
        this.lowerboundHeight = i5;
        this.profile = i6;
        this.level = i7;
    }

    public TPVCodecCapabilityForSet(int i2, int i3) {
        this.upperboundWidth = i2;
        this.upperboundHeight = i3;
        this.lowerboundWidth = 0;
        this.lowerboundHeight = 0;
        this.profile = -1;
        this.level = -1;
    }

    public TPVCodecCapabilityForSet(int i2, int i3, int i4) {
        this.upperboundWidth = i2;
        this.upperboundHeight = i3;
        this.profile = i4;
        this.lowerboundWidth = 0;
        this.lowerboundHeight = 0;
        this.level = -1;
    }

    public int getUpperboundWidth() {
        return this.upperboundWidth;
    }

    public int getUpperboundHeight() {
        return this.upperboundHeight;
    }

    public int getLowerboundWidth() {
        return this.lowerboundWidth;
    }

    public int getLowerboundHeight() {
        return this.lowerboundHeight;
    }

    public int getProfile() {
        return this.profile;
    }

    public int getLevel() {
        return this.level;
    }
}
