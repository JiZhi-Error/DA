package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Mdhd extends FullBox {
    long creationTime;
    long duration;
    long modificationTime;
    byte[] remaining;
    int timeScale;

    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.FullBox, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Box
    public void parse(Parsable parsable, Box box) {
        AppMethodBeat.i(114264);
        super.parse(parsable, box);
        if (this.version == 1) {
            this.creationTime = parsable.readLong();
            this.modificationTime = parsable.readLong();
            this.timeScale = parsable.readInt();
            this.duration = parsable.readLong();
        } else {
            this.creationTime = (long) parsable.readInt();
            this.modificationTime = (long) parsable.readInt();
            this.timeScale = parsable.readInt();
            this.duration = (long) parsable.readInt();
        }
        this.remaining = new byte[4];
        parsable.readBytes(this.remaining, 0, this.remaining.length);
        AppMethodBeat.o(114264);
    }

    public long getCreationTime() {
        return this.creationTime;
    }

    public long getModificationTime() {
        return this.modificationTime;
    }

    public int getTimeScale() {
        return this.timeScale;
    }

    public long getDuration() {
        return this.duration;
    }
}
