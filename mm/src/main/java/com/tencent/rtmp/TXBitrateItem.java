package com.tencent.rtmp;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXBitrateItem implements Comparable<TXBitrateItem> {
    public int bitrate;
    public int height;
    public int index;
    public int width;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(TXBitrateItem tXBitrateItem) {
        AppMethodBeat.i(14061);
        int compareTo = compareTo(tXBitrateItem);
        AppMethodBeat.o(14061);
        return compareTo;
    }

    public int compareTo(TXBitrateItem tXBitrateItem) {
        return this.bitrate - tXBitrateItem.bitrate;
    }
}
