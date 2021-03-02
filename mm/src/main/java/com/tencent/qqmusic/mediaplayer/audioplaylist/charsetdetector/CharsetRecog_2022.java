package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class CharsetRecog_2022 extends CharsetRecognizer {
    CharsetRecog_2022() {
    }

    /* access modifiers changed from: package-private */
    public int match(byte[] bArr, int i2, byte[][] bArr2) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i8 < i2) {
            if (bArr[i8] == 27) {
                for (byte[] bArr3 : bArr2) {
                    if (i2 - i8 >= bArr3.length) {
                        for (int i9 = 1; i9 < bArr3.length; i9++) {
                            if (bArr3[i9] == bArr[i8 + i9]) {
                            }
                        }
                        i7++;
                        i8 += bArr3.length - 1;
                        i4 = i5;
                        i3 = i6;
                        break;
                    }
                }
                i3 = i6 + 1;
                if (bArr[i8] != 14 || bArr[i8] == 15) {
                    i4 = i5 + 1;
                } else {
                    i4 = i5;
                }
            } else {
                i3 = i6;
                if (bArr[i8] != 14) {
                }
                i4 = i5 + 1;
            }
            i8++;
            i5 = i4;
            i6 = i3;
        }
        if (i7 == 0) {
            return 0;
        }
        int i10 = ((i7 * 100) - (i6 * 100)) / (i7 + i6);
        if (i7 + i5 < 5) {
            i10 -= (5 - (i7 + i5)) * 10;
        }
        if (i10 >= 0) {
            return i10;
        }
        return 0;
    }

    static class CharsetRecog_2022JP extends CharsetRecog_2022 {
        private byte[][] escapeSequences = {new byte[]{27, 36, 40, 67}, new byte[]{27, 36, 40, 68}, new byte[]{27, 36, 64}, new byte[]{27, 36, 65}, new byte[]{27, 36, 66}, new byte[]{27, 38, 64}, new byte[]{27, 40, 66}, new byte[]{27, 40, 72}, new byte[]{27, 40, 73}, new byte[]{27, 40, 74}, new byte[]{27, 46, 65}, new byte[]{27, 46, 70}};

        CharsetRecog_2022JP() {
            AppMethodBeat.i(76646);
            AppMethodBeat.o(76646);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public String getName() {
            return "ISO-2022-JP";
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            AppMethodBeat.i(76647);
            int match = match(charsetDetector.fInputBytes, charsetDetector.fInputLen, this.escapeSequences);
            if (match == 0) {
                AppMethodBeat.o(76647);
                return null;
            }
            CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, match);
            AppMethodBeat.o(76647);
            return charsetMatch;
        }
    }

    static class CharsetRecog_2022KR extends CharsetRecog_2022 {
        private byte[][] escapeSequences = {new byte[]{27, 36, 41, 67}};

        CharsetRecog_2022KR() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public String getName() {
            return "ISO-2022-KR";
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            int match = match(charsetDetector.fInputBytes, charsetDetector.fInputLen, this.escapeSequences);
            if (match == 0) {
                return null;
            }
            return new CharsetMatch(charsetDetector, this, match);
        }
    }

    static class CharsetRecog_2022CN extends CharsetRecog_2022 {
        private byte[][] escapeSequences = {new byte[]{27, 36, 41, 65}, new byte[]{27, 36, 41, 71}, new byte[]{27, 36, 42, 72}, new byte[]{27, 36, 41, 69}, new byte[]{27, 36, 43, 73}, new byte[]{27, 36, 43, 74}, new byte[]{27, 36, 43, 75}, new byte[]{27, 36, 43, 76}, new byte[]{27, 36, 43, 77}, new byte[]{27, 78}, new byte[]{27, 79}};

        CharsetRecog_2022CN() {
            AppMethodBeat.i(76617);
            AppMethodBeat.o(76617);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public String getName() {
            return "ISO-2022-CN";
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            AppMethodBeat.i(76618);
            int match = match(charsetDetector.fInputBytes, charsetDetector.fInputLen, this.escapeSequences);
            if (match == 0) {
                AppMethodBeat.o(76618);
                return null;
            }
            CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, match);
            AppMethodBeat.o(76618);
            return charsetMatch;
        }
    }
}
