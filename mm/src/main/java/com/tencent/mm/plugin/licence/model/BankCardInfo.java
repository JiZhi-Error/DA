package com.tencent.mm.plugin.licence.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class BankCardInfo {
    private static final String TAG = "BankCardInfo";
    public byte[] bitmapData;
    public int bitmapLen = 0;
    private String cardNum = "";
    private int cardNumLen = 0;
    public int height = 0;
    private int[] rectX = new int[20];
    private int[] rectY = new int[20];
    public int width = 0;

    public BankCardInfo(int i2, int i3) {
        AppMethodBeat.i(40584);
        this.bitmapData = new byte[((((int) (0.8d * ((double) i2))) * ((int) (0.52d * ((double) i2))) * 3) + 54)];
        AppMethodBeat.o(40584);
    }

    public int getCardNumLen() {
        return this.cardNumLen;
    }

    public void setCardNumLen(int i2) {
        this.cardNumLen = i2;
    }

    public String getCardNum() {
        return this.cardNum;
    }

    public void setCardNum(String str) {
        this.cardNum = str;
    }

    public int[] getRectY() {
        return this.rectY;
    }

    public void setRectY(int[] iArr) {
        this.rectY = iArr;
    }

    public int[] getRectX() {
        return this.rectX;
    }

    public void setRectX(int[] iArr) {
        this.rectX = iArr;
    }
}
