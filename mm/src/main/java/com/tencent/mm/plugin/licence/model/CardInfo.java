package com.tencent.mm.plugin.licence.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CardInfo {
    public byte[] bitmapData;
    public int bitmapLen = 0;
    public int height = 0;
    public int width = 0;

    public CardInfo(int i2, int i3) {
        AppMethodBeat.i(40585);
        this.bitmapData = new byte[((((int) (0.8d * ((double) i2))) * ((int) (0.52d * ((double) i2))) * 3) + 54)];
        AppMethodBeat.o(40585);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getSize() {
        return this.bitmapLen;
    }

    public byte[] getData() {
        return this.bitmapData;
    }
}
