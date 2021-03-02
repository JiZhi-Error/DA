package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class CharsetRecog_Unicode extends CharsetRecognizer {
    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
    public abstract String getName();

    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
    public abstract CharsetMatch match(CharsetDetector charsetDetector);

    CharsetRecog_Unicode() {
    }

    static int codeUnit16FromBytes(byte b2, byte b3) {
        return ((b2 & 255) << 8) | (b3 & 255);
    }

    static int adjustConfidence(int i2, int i3) {
        int i4;
        if (i2 == 0) {
            i4 = i3 - 10;
        } else if ((i2 < 32 || i2 > 255) && i2 != 10) {
            i4 = i3;
        } else {
            i4 = i3 + 10;
        }
        if (i4 < 0) {
            return 0;
        }
        if (i4 <= 100) {
            return i4;
        }
        return 100;
    }

    static class CharsetRecog_UTF_16_BE extends CharsetRecog_Unicode {
        CharsetRecog_UTF_16_BE() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode
        public String getName() {
            return "UTF-16BE";
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode
        public CharsetMatch match(CharsetDetector charsetDetector) {
            AppMethodBeat.i(76615);
            byte[] bArr = charsetDetector.fRawInput;
            int i2 = 10;
            int min = Math.min(bArr.length, 30);
            int i3 = 0;
            while (true) {
                if (i3 >= min - 1) {
                    break;
                }
                int codeUnit16FromBytes = codeUnit16FromBytes(bArr[i3], bArr[i3 + 1]);
                if (i3 != 0 || codeUnit16FromBytes != 65279) {
                    i2 = adjustConfidence(codeUnit16FromBytes, i2);
                    if (i2 == 0 || i2 == 100) {
                        break;
                    }
                    i3 += 2;
                } else {
                    i2 = 100;
                    break;
                }
            }
            if (min < 4 && i2 < 100) {
                i2 = 0;
            }
            if (i2 > 0) {
                CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, i2);
                AppMethodBeat.o(76615);
                return charsetMatch;
            }
            AppMethodBeat.o(76615);
            return null;
        }
    }

    static class CharsetRecog_UTF_16_LE extends CharsetRecog_Unicode {
        CharsetRecog_UTF_16_LE() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode
        public String getName() {
            return "UTF-16LE";
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode
        public CharsetMatch match(CharsetDetector charsetDetector) {
            AppMethodBeat.i(76619);
            byte[] bArr = charsetDetector.fRawInput;
            int i2 = 10;
            int min = Math.min(bArr.length, 30);
            int i3 = 0;
            while (true) {
                if (i3 >= min - 1) {
                    break;
                }
                int codeUnit16FromBytes = codeUnit16FromBytes(bArr[i3 + 1], bArr[i3]);
                if (i3 != 0 || codeUnit16FromBytes != 65279) {
                    i2 = adjustConfidence(codeUnit16FromBytes, i2);
                    if (i2 == 0 || i2 == 100) {
                        break;
                    }
                    i3 += 2;
                } else {
                    i2 = 100;
                    break;
                }
            }
            if (min < 4 && i2 < 100) {
                i2 = 0;
            }
            if (i2 > 0) {
                CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, i2);
                AppMethodBeat.o(76619);
                return charsetMatch;
            }
            AppMethodBeat.o(76619);
            return null;
        }
    }

    static abstract class CharsetRecog_UTF_32 extends CharsetRecog_Unicode {
        /* access modifiers changed from: package-private */
        public abstract int getChar(byte[] bArr, int i2);

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode
        public abstract String getName();

        CharsetRecog_UTF_32() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode
        public CharsetMatch match(CharsetDetector charsetDetector) {
            int i2 = 0;
            byte[] bArr = charsetDetector.fRawInput;
            int i3 = (charsetDetector.fRawLength / 4) * 4;
            if (i3 == 0) {
                return null;
            }
            boolean z = getChar(bArr, 0) == 65279;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6 += 4) {
                int i7 = getChar(bArr, i6);
                if (i7 < 0 || i7 >= 1114111 || (i7 >= 55296 && i7 <= 57343)) {
                    i4++;
                } else {
                    i5++;
                }
            }
            if (z && i4 == 0) {
                i2 = 100;
            } else if (z && i5 > i4 * 10) {
                i2 = 80;
            } else if (i5 > 3 && i4 == 0) {
                i2 = 100;
            } else if (i5 > 0 && i4 == 0) {
                i2 = 80;
            } else if (i5 > i4 * 10) {
                i2 = 25;
            }
            if (i2 == 0) {
                return null;
            }
            return new CharsetMatch(charsetDetector, this, i2);
        }
    }

    static class CharsetRecog_UTF_32_BE extends CharsetRecog_UTF_32 {
        CharsetRecog_UTF_32_BE() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode.CharsetRecog_UTF_32
        public int getChar(byte[] bArr, int i2) {
            return ((bArr[i2 + 0] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8) | (bArr[i2 + 3] & 255);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode.CharsetRecog_UTF_32, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode
        public String getName() {
            return "UTF-32BE";
        }
    }

    static class CharsetRecog_UTF_32_LE extends CharsetRecog_UTF_32 {
        CharsetRecog_UTF_32_LE() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode.CharsetRecog_UTF_32
        public int getChar(byte[] bArr, int i2) {
            return ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) | (bArr[i2 + 0] & 255);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode.CharsetRecog_UTF_32, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode
        public String getName() {
            return "UTF-32LE";
        }
    }
}
