package com.github.henryye.nativeiv.bitmap;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a<ConfType> {
    public boolean bbd;
    public ConfType bbe;
    public long bbf;
    public int height;
    public int width;

    public final String toString() {
        AppMethodBeat.i(127362);
        String str = "DumpInfo{width=" + this.width + ", height=" + this.height + ", isNative=" + this.bbd + ", config=" + ((Object) this.bbe) + ", decodeUsingInMs=" + this.bbf + '}';
        AppMethodBeat.o(127362);
        return str;
    }
}
