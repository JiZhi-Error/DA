package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.b;

public final class i {
    public int SwJ;
    public int SwK;
    public int SwL;
    public int SwM;
    public int SwN;
    public int SwO;
    public int SwP;
    public int SwQ;
    public int SwR;
    public int mHeight;
    public int mNetType;
    public int mWidth;

    public i(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        AppMethodBeat.i(62551);
        this.SwJ = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        this.SwK = i5;
        this.SwL = i6;
        this.SwM = i7;
        this.SwN = i8;
        this.mNetType = i9;
        this.SwO = i10;
        this.SwP = i11;
        this.SwQ = i12;
        this.SwR = i13;
        b.d("VoiceEngineConf", "mDisableVideo: ", Integer.valueOf(i2), " mWidth: ", Integer.valueOf(i3), " mHeight: ", Integer.valueOf(i4), " mInFPS: ", Integer.valueOf(i5), " mOutFmt: ", Integer.valueOf(i6), " mOSType: ", Integer.valueOf(i7), " mNetKbps: ", Integer.valueOf(i8), " mNetType: ", Integer.valueOf(i9), " mMTUSize: ", Integer.valueOf(i10), " mCPUFlag: ", Integer.valueOf(i11), " mDispRate: ", Integer.valueOf(i12), " mVCodecType: ", Integer.valueOf(i13));
        AppMethodBeat.o(62551);
    }
}
