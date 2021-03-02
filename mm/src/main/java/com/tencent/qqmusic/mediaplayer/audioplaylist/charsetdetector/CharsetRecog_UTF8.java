package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;

class CharsetRecog_UTF8 extends CharsetRecognizer {
    CharsetRecog_UTF8() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
    public String getName() {
        return MimeTypeUtil.ContentType.DEFAULT_CHARSET;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
    public CharsetMatch match(CharsetDetector charsetDetector) {
        boolean z;
        int i2;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(76644);
        byte[] bArr = charsetDetector.fRawInput;
        if (charsetDetector.fRawLength >= 3 && (bArr[0] & 255) == 239 && (bArr[1] & 255) == 187 && (bArr[2] & 255) == 191) {
            z = true;
        } else {
            z = false;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < charsetDetector.fRawLength) {
            byte b2 = bArr[i5];
            if ((b2 & 128) != 0) {
                if ((b2 & 224) == 192) {
                    i3 = 1;
                    i2 = i5;
                } else if ((b2 & 240) == 224) {
                    i3 = 2;
                    i2 = i5;
                } else if ((b2 & 248) == 240) {
                    i3 = 3;
                    i2 = i5;
                } else {
                    i6++;
                    i2 = i5;
                }
                while (true) {
                    i2++;
                    if (i2 >= charsetDetector.fRawLength) {
                        break;
                    } else if ((bArr[i2] & 192) != 128) {
                        i6++;
                        break;
                    } else {
                        int i8 = i3 - 1;
                        if (i8 == 0) {
                            i7++;
                            break;
                        }
                        i3 = i8;
                    }
                }
            } else {
                i2 = i5;
            }
            i5 = i2 + 1;
        }
        if (z && i6 == 0) {
            i4 = 100;
        } else if (z && i7 > i6 * 10) {
            i4 = 80;
        } else if (i7 > 3 && i6 == 0) {
            i4 = 100;
        } else if (i7 > 0 && i6 == 0) {
            i4 = 80;
        } else if (i7 == 0 && i6 == 0) {
            i4 = 15;
        } else if (i7 > i6 * 10) {
            i4 = 25;
        }
        if (i4 == 0) {
            AppMethodBeat.o(76644);
            return null;
        }
        CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, i4);
        AppMethodBeat.o(76644);
        return charsetMatch;
    }
}
