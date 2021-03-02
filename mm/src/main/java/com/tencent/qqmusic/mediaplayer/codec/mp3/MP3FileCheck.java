package com.tencent.qqmusic.mediaplayer.codec.mp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MP3FileCheck {
    private static final String TAG = "MP3FileCheck";
    private byte[] buf = new byte[8192];
    private int endPos;
    private boolean eof;
    private int frameCount;
    private boolean hasCheck = false;
    private boolean hasID3V2 = false;
    private MP3Header header = new MP3Header();
    private int headerMask;
    private boolean isMP3 = false;
    private String mFilePath = null;
    private int mID3V2Size = -1;
    private RandomAccessFile mRandomAccessFile = null;
    private int pos;
    private int skipped;
    private boolean sync;

    public MP3FileCheck(String str) {
        AppMethodBeat.i(114321);
        this.mFilePath = str;
        AppMethodBeat.o(114321);
    }

    public static boolean isMp3File(String str) {
        AppMethodBeat.i(114322);
        boolean isMp3File = new MP3FileCheck(str).isMp3File();
        AppMethodBeat.o(114322);
        return isMp3File;
    }

    private boolean isMp3File() {
        AppMethodBeat.i(114323);
        if (!this.hasCheck) {
            fileCheck();
        }
        boolean z = this.isMP3;
        AppMethodBeat.o(114323);
        return z;
    }

    private boolean checkAndSeekID3V2Tag() {
        AppMethodBeat.i(114324);
        byte[] bArr = new byte[10];
        int fillBuffer = fillBuffer(bArr, 0, 10);
        if (fillBuffer <= 0) {
            AppMethodBeat.o(114324);
            return false;
        }
        if (bArr[0] == 73 && bArr[1] == 68 && bArr[2] == 51) {
            this.mID3V2Size = (bArr[6] << 21) + (bArr[7] << 14) + (bArr[8] << 7) + bArr[9];
            this.hasID3V2 = true;
            seekTo(this.mID3V2Size - fillBuffer);
            Logger.d(TAG, "有ID3V2，ID3V2大小 = " + this.mID3V2Size);
        } else {
            closeFileStream();
            Logger.d(TAG, "没有有ID3V2");
        }
        boolean z = this.hasID3V2;
        AppMethodBeat.o(114324);
        return z;
    }

    private void closeFileStream() {
        AppMethodBeat.i(114325);
        if (this.mRandomAccessFile != null) {
            try {
                this.mRandomAccessFile.close();
            } catch (IOException e2) {
                Logger.e(TAG, e2);
            }
            this.mRandomAccessFile = null;
        }
        AppMethodBeat.o(114325);
    }

    private void seekTo(int i2) {
        AppMethodBeat.i(114326);
        try {
            this.mRandomAccessFile.seek((long) i2);
            AppMethodBeat.o(114326);
        } catch (Exception e2) {
            Logger.e(TAG, e2);
            AppMethodBeat.o(114326);
        }
    }

    public void fileCheck() {
        AppMethodBeat.i(114327);
        try {
            this.hasCheck = true;
            checkAndSeekID3V2Tag();
            this.headerMask = -2097152;
            this.sync = false;
            this.eof = false;
            this.frameCount = 0;
            int length = this.buf.length;
            this.pos = length;
            this.endPos = length;
            this.header.initialize();
            nextFrameHeader();
            if (this.mRandomAccessFile != null) {
                try {
                    this.mRandomAccessFile.close();
                    AppMethodBeat.o(114327);
                    return;
                } catch (Exception e2) {
                    Logger.e(TAG, e2);
                    AppMethodBeat.o(114327);
                    return;
                }
            }
        } catch (Exception e3) {
            Logger.e(TAG, e3);
            if (this.mRandomAccessFile != null) {
                try {
                    this.mRandomAccessFile.close();
                    AppMethodBeat.o(114327);
                    return;
                } catch (Exception e4) {
                    Logger.e(TAG, e4);
                    AppMethodBeat.o(114327);
                    return;
                }
            }
        } catch (Throwable th) {
            if (this.mRandomAccessFile != null) {
                try {
                    this.mRandomAccessFile.close();
                } catch (Exception e5) {
                    Logger.e(TAG, e5);
                }
            }
            AppMethodBeat.o(114327);
            throw th;
        }
        AppMethodBeat.o(114327);
    }

    public int getFrameSize() {
        AppMethodBeat.i(114328);
        if (this.header != null) {
            int frameSize = this.header.getFrameSize();
            AppMethodBeat.o(114328);
            return frameSize;
        }
        AppMethodBeat.o(114328);
        return -1;
    }

    private void nextFrameHeader() {
        AppMethodBeat.i(114329);
        int i2 = 0;
        while (!this.eof && !syncFrame()) {
            int i3 = this.endPos - this.pos;
            if (i3 > 0) {
                System.arraycopy(this.buf, this.pos, this.buf, 0, i3);
            }
            this.endPos = fillBuffer(this.buf, i3, this.pos) + i3;
            if (this.endPos <= i3 || (i2 = i2 + this.pos) > 65536) {
                this.eof = true;
            }
            this.pos = 0;
        }
        AppMethodBeat.o(114329);
    }

    private boolean syncFrame() {
        AppMethodBeat.i(114330);
        int i2 = this.pos;
        if (this.endPos - this.pos <= 4) {
            AppMethodBeat.o(114330);
            return false;
        }
        int byte2int = byte2int(this.buf, this.pos);
        this.pos += 4;
        System.out.println(this.frameCount);
        while (true) {
            if (this.eof) {
                break;
            }
            while (!available(byte2int, this.headerMask)) {
                byte[] bArr = this.buf;
                int i3 = this.pos;
                this.pos = i3 + 1;
                byte2int = (byte2int << 8) | (bArr[i3] & 255);
                if (this.pos == this.endPos) {
                    int i4 = this.skipped;
                    int i5 = this.pos - 4;
                    this.pos = i5;
                    this.skipped = i4 + (i5 - i2);
                    AppMethodBeat.o(114330);
                    return false;
                }
            }
            if (this.pos > i2 + 4) {
                this.sync = false;
                this.skipped += (this.pos - 4) - i2;
            }
            this.header.decode(byte2int);
            int frameSize = this.header.getFrameSize();
            if (this.pos + frameSize > this.endPos + 4) {
                int i6 = this.skipped;
                int i7 = this.pos - 4;
                this.pos = i7;
                this.skipped = i6 + (i7 - i2);
                AppMethodBeat.o(114330);
                return false;
            } else if (this.sync) {
                break;
            } else if (this.pos + frameSize > this.endPos) {
                int i8 = this.skipped;
                int i9 = this.pos - 4;
                this.pos = i9;
                this.skipped = i8 + (i9 - i2);
                AppMethodBeat.o(114330);
                return false;
            } else {
                int i10 = (1572864 & byte2int) | -2097152 | (393216 & byte2int) | (byte2int & LVBuffer.MAX_STRING_LENGTH);
                if (available(byte2int(this.buf, frameSize + (this.pos - 4)), i10)) {
                    if (this.headerMask == -2097152) {
                        this.headerMask = i10;
                    }
                    this.sync = true;
                } else {
                    byte[] bArr2 = this.buf;
                    int i11 = this.pos;
                    this.pos = i11 + 1;
                    byte2int = (byte2int << 8) | (bArr2[i11] & 255);
                }
            }
        }
        if (this.header.isProtected()) {
            this.pos += 2;
        }
        this.frameCount++;
        if (this.skipped > 0 || (this.skipped == 0 && this.sync)) {
            this.isMP3 = true;
            this.skipped = 0;
        }
        AppMethodBeat.o(114330);
        return true;
    }

    private int fillBuffer(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(114331);
        try {
            if (this.mRandomAccessFile == null) {
                this.mRandomAccessFile = new RandomAccessFile(this.mFilePath, "r");
            }
            int read = this.mRandomAccessFile.read(bArr, i2, i3);
            AppMethodBeat.o(114331);
            return read;
        } catch (Exception e2) {
            AppMethodBeat.o(114331);
            return -1;
        }
    }

    private int byte2int(byte[] bArr, int i2) {
        return (bArr[i2] << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8) | (bArr[i2 + 3] & 255);
    }

    private boolean available(int i2, int i3) {
        return ((i2 & i3) != i3 || ((i2 >> 19) & 3) == 1 || ((i2 >> 17) & 3) == 0 || ((i2 >> 12) & 15) == 15 || ((i2 >> 12) & 15) == 0 || ((i2 >> 10) & 3) == 3) ? false : true;
    }
}
