package com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;

public class Ftyp extends Box {
    int[] compatibleBrands;
    int majorBrand;
    int minorVersion;

    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box, com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Box
    public void parse(Parsable parsable, Box box) {
        AppMethodBeat.i(114265);
        super.parse(parsable, box);
        this.majorBrand = parsable.readInt();
        this.minorVersion = parsable.readInt();
        int available = ((int) parsable.available()) / 4;
        if (available > 0) {
            this.compatibleBrands = parsable.readIntArray(available);
        }
        AppMethodBeat.o(114265);
    }
}
