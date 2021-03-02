package com.tencent.qqmusic.mediaplayer.seektable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

public class NativeSeekTable implements SeekTable {
    private final BaseDecoder nativeDecoder;

    public NativeSeekTable(BaseDecoder baseDecoder) {
        this.nativeDecoder = baseDecoder;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public void parse(IDataSource iDataSource) {
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public long seek(long j2) {
        AppMethodBeat.i(114271);
        long bytePositionOfTime = this.nativeDecoder.getBytePositionOfTime(j2);
        AppMethodBeat.o(114271);
        return bytePositionOfTime;
    }
}
