package com.tencent.mm.live.core.core.trtc.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class d implements Serializable {
    public boolean cIw = false;
    private boolean hBA = false;
    public boolean hBB = false;
    public boolean hBC = false;
    public boolean hBD = false;
    public boolean hBE = true;
    public int hBF = 0;
    public boolean hBG = true;
    private transient boolean hBm = true;
    public int hBu = 108;
    public int hBv = 15;
    public boolean hBw = true;
    public boolean hBx = false;
    public int hBy = 0;
    private boolean hBz = true;
    public int mMinVideoBitrate = 600;
    public int mQosMode = 1;
    public int mQosPreference = 2;
    public int mVideoBitrate = 600;
    public int uEA = 110;
    public int uHL = 600;
    public int uHx = 15;
    public int uHy = 1500;
    public boolean uKs = false;

    public final void qt(int i2) {
        this.mQosMode = i2;
    }

    public final void setVideoResolution(int i2) {
        this.hBu = i2;
    }

    public final int aDR() {
        return this.hBv;
    }

    public final void qu(int i2) {
        this.hBv = i2;
    }

    public final void setVideoBitrate(int i2) {
        this.mVideoBitrate = i2;
    }

    public final void setMinVideoBitrate(int i2) {
        this.mMinVideoBitrate = i2;
    }

    public final void aws(int i2) {
        this.uEA = i2;
    }

    public final void awt(int i2) {
        this.uHx = i2;
    }

    public final void awu(int i2) {
        this.uHy = i2;
    }

    public final void awv(int i2) {
        this.uHL = i2;
    }

    public final boolean aDS() {
        return this.hBw;
    }

    public final void eA(boolean z) {
        this.hBw = z;
    }

    public final void eB(boolean z) {
        this.hBG = z;
    }

    public final void qv(int i2) {
        this.mQosPreference = i2;
    }

    public final void eC(boolean z) {
        this.hBz = z;
    }

    public final boolean bqa() {
        return this.uKs;
    }

    public final void jb(boolean z) {
        this.uKs = z;
    }

    public final String Lb() {
        AppMethodBeat.i(196278);
        StringBuilder sb = new StringBuilder();
        sb.append(this.hBu).append("-").append(this.hBv).append("-").append(this.mVideoBitrate).append("-").append(this.mQosPreference).append("-").append(this.mQosMode);
        String sb2 = sb.toString();
        AppMethodBeat.o(196278);
        return sb2;
    }
}
