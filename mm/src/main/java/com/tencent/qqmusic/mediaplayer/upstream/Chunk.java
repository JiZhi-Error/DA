package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Chunk {
    public final int bufferSize;
    public final long size;
    public final long start;

    public Chunk(int i2, long j2, long j3) {
        this.bufferSize = i2;
        this.start = j2;
        this.size = j3;
    }

    public boolean contains(long j2) {
        AppMethodBeat.i(76524);
        if (isEndless()) {
            if (j2 >= this.start) {
                AppMethodBeat.o(76524);
                return true;
            }
            AppMethodBeat.o(76524);
            return false;
        } else if (j2 < this.start || j2 > this.start + this.size) {
            AppMethodBeat.o(76524);
            return false;
        } else {
            AppMethodBeat.o(76524);
            return true;
        }
    }

    public boolean isEndless() {
        return this.size == -1;
    }

    public String toString() {
        AppMethodBeat.i(76525);
        String str = "Chunk{bufferSize=" + this.bufferSize + ", start=" + this.start + ", size=" + this.size + '}';
        AppMethodBeat.o(76525);
        return str;
    }
}
