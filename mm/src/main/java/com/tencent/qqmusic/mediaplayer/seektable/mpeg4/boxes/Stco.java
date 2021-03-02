package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Stco extends FullBox {
    int[] chunkOffset;
    int entryCount;

    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.FullBox, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Box
    public void parse(Parsable parsable, Box box) {
        AppMethodBeat.i(114268);
        super.parse(parsable, box);
        this.entryCount = parsable.readInt();
        this.chunkOffset = parsable.readIntArray(this.entryCount);
        AppMethodBeat.o(114268);
    }

    public int getEntryCount() {
        return this.entryCount;
    }

    public int[] getChunkOffset() {
        return this.chunkOffset;
    }
}
