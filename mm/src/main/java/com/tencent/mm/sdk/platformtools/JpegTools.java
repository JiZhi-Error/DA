package com.tencent.mm.sdk.platformtools;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;

public class JpegTools {
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final String TAG = "MicroMsg.JpegTools";
    private boolean bigOrder;
    private MBuf buf;
    private int ordivalue;

    private boolean checkIsJpeg() {
        AppMethodBeat.i(230313);
        byte b2 = this.buf.getBuffer().get();
        byte b3 = this.buf.getBuffer().get();
        if (!byte2HexString(b2).equals("FF") || !byte2HexString(b3).equals("D8")) {
            AppMethodBeat.o(230313);
            return false;
        }
        AppMethodBeat.o(230313);
        return true;
    }

    private boolean checkExifTag() {
        AppMethodBeat.i(230314);
        if (new StringBuilder().append((char) this.buf.getBuffer().get()).append((char) this.buf.getBuffer().get()).append((char) this.buf.getBuffer().get()).append((char) this.buf.getBuffer().get()).toString().equals("Exif")) {
            AppMethodBeat.o(230314);
            return true;
        }
        AppMethodBeat.o(230314);
        return false;
    }

    private int findAppTag() {
        int i2;
        AppMethodBeat.i(230315);
        int i3 = 0;
        while (true) {
            byte b2 = this.buf.getBuffer().get();
            byte b3 = this.buf.getBuffer().get();
            this.buf.getBuffer().get();
            byte b4 = this.buf.getBuffer().get();
            if (byte2HexString(b2).equals("FF")) {
                if (!byte2HexString(b2).equals("FF") || !byte2HexString(b3).equals("E1")) {
                    if (byte2HexString(b2).equals("FF") && byte2HexString(b3).equals("D9")) {
                        i2 = -1;
                        break;
                    }
                    this.buf.getBuffer().position((this.buf.getOffset() + b4) - 2);
                    i3++;
                    if (i3 > 100) {
                        Log.e(TAG, "error while!");
                        i2 = -1;
                        break;
                    }
                } else {
                    i2 = (b4 & 255) - 2;
                    break;
                }
            } else {
                i2 = -1;
                break;
            }
        }
        AppMethodBeat.o(230315);
        return i2;
    }

    private void dropByte(int i2) {
        AppMethodBeat.i(230316);
        this.buf.getBuffer().position(this.buf.getBuffer().position() + i2);
        AppMethodBeat.o(230316);
    }

    private String byteOrder() {
        AppMethodBeat.i(230317);
        byte b2 = this.buf.getBuffer().get();
        byte b3 = this.buf.getBuffer().get();
        if (((char) b2) == 'M' && ((char) b3) == 'M') {
            AppMethodBeat.o(230317);
            return "MM";
        } else if (((char) b2) == 'I' && ((char) b3) == 'I') {
            AppMethodBeat.o(230317);
            return "II";
        } else {
            AppMethodBeat.o(230317);
            return "";
        }
    }

    private boolean checkTiffTag(boolean z) {
        AppMethodBeat.i(230318);
        byte b2 = this.buf.getBuffer().get();
        byte b3 = this.buf.getBuffer().get();
        if (z && byte2HexString(b2).equals("00") && byte2HexString(b3).equals("2A")) {
            AppMethodBeat.o(230318);
            return true;
        } else if (!byte2HexString(b2).equals("2A") || !byte2HexString(b3).equals("00")) {
            Log.w(TAG, "checkTiffTag: " + byte2HexString(b2) + " " + byte2HexString(b3));
            AppMethodBeat.o(230318);
            return false;
        } else {
            AppMethodBeat.o(230318);
            return true;
        }
    }

    private int getOffset() {
        AppMethodBeat.i(230319);
        dropByte(4);
        AppMethodBeat.o(230319);
        return 0;
    }

    private int getOrei(boolean z) {
        AppMethodBeat.i(230320);
        byte b2 = this.buf.getBuffer().get();
        byte b3 = this.buf.getBuffer().get();
        dropByte(2);
        if (z) {
            int i2 = b3 & 255;
            AppMethodBeat.o(230320);
            return i2;
        }
        int i3 = b2 & 255;
        AppMethodBeat.o(230320);
        return i3;
    }

    public JpegTools(byte[] bArr) {
        AppMethodBeat.i(230321);
        this.buf = null;
        this.ordivalue = -1;
        this.bigOrder = true;
        this.buf = new MBuf();
        this.buf.setBuffer(bArr);
        AppMethodBeat.o(230321);
    }

    public int parserJpeg() {
        AppMethodBeat.i(230322);
        try {
            if (!checkIsJpeg()) {
                Log.w(TAG, "this is not jpeg or no exif data!!!");
                AppMethodBeat.o(230322);
                return -1;
            } else if (findAppTag() < 0) {
                Log.w(TAG, "datalen is error ");
                AppMethodBeat.o(230322);
                return -1;
            } else if (!checkExifTag()) {
                Log.w(TAG, "checkExifTag is error");
                AppMethodBeat.o(230322);
                return -1;
            } else {
                dropByte(2);
                String byteOrder = byteOrder();
                if (byteOrder.equals("MM") || byteOrder.equals("II")) {
                    this.bigOrder = byteOrder.equals("MM");
                    if (!checkTiffTag(this.bigOrder)) {
                        Log.w(TAG, "checkTiffTag  is error ");
                        AppMethodBeat.o(230322);
                        return -1;
                    }
                    getOffset();
                    byte b2 = this.buf.getBuffer().get();
                    byte b3 = this.buf.getBuffer().get();
                    int i2 = b2 & 255;
                    if (this.bigOrder) {
                        i2 = b3 & 255;
                    }
                    int i3 = 0;
                    boolean z = false;
                    while (true) {
                        if (i3 >= i2 || i3 >= 255) {
                            break;
                        }
                        byte b4 = this.buf.getBuffer().get();
                        byte b5 = this.buf.getBuffer().get();
                        if (this.bigOrder && byte2HexString(b4).equals("01") && byte2HexString(b5).equals("12")) {
                            z = true;
                        } else if (!this.bigOrder && byte2HexString(b4).equals("12") && byte2HexString(b5).equals("01")) {
                            z = true;
                        }
                        dropByte(2);
                        dropByte(4);
                        if (z) {
                            this.ordivalue = getOrei(this.bigOrder);
                            break;
                        }
                        dropByte(4);
                        i3++;
                    }
                    Log.d(TAG, "orei " + this.ordivalue);
                    int oreiValue = getOreiValue();
                    AppMethodBeat.o(230322);
                    return oreiValue;
                }
                Log.w(TAG, "byteOrder  is error ".concat(String.valueOf(byteOrder)));
                AppMethodBeat.o(230322);
                return -1;
            }
        } catch (Exception e2) {
            Log.e(TAG, "parser jpeg error");
            AppMethodBeat.o(230322);
            return -1;
        }
    }

    public int getOreiValue() {
        if (this.ordivalue == -1) {
            return -1;
        }
        switch (this.ordivalue) {
            case 1:
                return 0;
            case 2:
            case 4:
            case 5:
            case 7:
            default:
                return -1;
            case 3:
                return TXLiveConstants.RENDER_ROTATION_180;
            case 6:
                return 90;
            case 8:
                return 270;
        }
    }

    public static String byte2HexString(byte b2) {
        AppMethodBeat.i(230323);
        String hexString = Integer.toHexString(b2 & 255);
        if (hexString.length() == 1) {
            hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(hexString));
        }
        String str = "" + hexString.toUpperCase();
        AppMethodBeat.o(230323);
        return str;
    }
}
