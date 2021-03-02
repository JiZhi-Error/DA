package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScanFrameProcessResult {
    public byte[] bestImageData = new byte[0];
    public int height = 0;
    public float maxX;
    public float maxY;
    public float minX;
    public float minY;
    public int result = 0;
    public boolean shouldJump;
    public int width = 0;

    public ScanFrameProcessResult() {
        AppMethodBeat.i(51650);
        AppMethodBeat.o(51650);
    }
}
