package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Stts extends FullBox {
    int entryCount;
    int[] sampleCount;
    int[] sampleDelta;

    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.FullBox, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Box
    public void parse(Parsable parsable, Box box) {
        AppMethodBeat.i(114267);
        super.parse(parsable, box);
        this.entryCount = parsable.readInt();
        this.sampleCount = new int[this.entryCount];
        this.sampleDelta = new int[this.entryCount];
        parsable.readIntArrayInterleaved(this.entryCount, this.sampleCount, this.sampleDelta);
        AppMethodBeat.o(114267);
    }

    public int getEntryCount() {
        return this.entryCount;
    }

    public int[] getSampleCount() {
        return this.sampleCount;
    }

    public int[] getSampleDelta() {
        return this.sampleDelta;
    }
}
