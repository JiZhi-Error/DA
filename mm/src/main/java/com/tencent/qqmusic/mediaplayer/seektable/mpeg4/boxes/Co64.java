package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Co64 extends FullBox {
    private long[] chunkOffset;
    private int entryCount;

    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.FullBox, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Box
    public void parse(Parsable parsable, Box box) {
        AppMethodBeat.i(114262);
        super.parse(parsable, box);
        this.entryCount = parsable.readInt();
        this.chunkOffset = parsable.readLongArray(this.entryCount);
        AppMethodBeat.o(114262);
    }

    public int getEntryCount() {
        return this.entryCount;
    }

    public long[] getChunkOffset() {
        return this.chunkOffset;
    }
}
