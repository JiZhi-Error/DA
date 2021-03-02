package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MapRouteSectionWithName {
    public static final int kMaxRoadNameLength = 128;
    public int color;
    public int endNum;
    public String roadName;
    public int startNum;

    public static int byteLength() {
        return 140;
    }

    public byte[] toBytes() {
        AppMethodBeat.i(181080);
        byte[] bArr = new byte[byteLength()];
        System.arraycopy(intToBytes(this.startNum), 0, bArr, 0, 4);
        System.arraycopy(intToBytes(this.endNum), 0, bArr, 4, 4);
        System.arraycopy(intToBytes(this.color), 0, bArr, 8, 4);
        byte[] stringToBytes = stringToBytes(this.roadName);
        if (stringToBytes.length < 128) {
            System.arraycopy(stringToBytes, 0, bArr, 12, stringToBytes.length);
        } else {
            System.arraycopy(stringToBytes, 0, bArr, 12, 128);
        }
        AppMethodBeat.o(181080);
        return bArr;
    }

    private byte[] intToBytes(int i2) {
        return new byte[]{(byte) i2, (byte) (i2 >> 8), (byte) (i2 >> 16), (byte) (i2 >> 24)};
    }

    private byte[] stringToBytes(String str) {
        AppMethodBeat.i(181081);
        if (str != null) {
            try {
                byte[] bytes = str.getBytes("UTF-16LE");
                AppMethodBeat.o(181081);
                return bytes;
            } catch (Exception e2) {
            }
        }
        byte[] bArr = new byte[0];
        AppMethodBeat.o(181081);
        return bArr;
    }
}
