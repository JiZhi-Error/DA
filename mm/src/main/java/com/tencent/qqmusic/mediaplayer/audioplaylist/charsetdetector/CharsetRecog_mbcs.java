package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

abstract class CharsetRecog_mbcs extends CharsetRecognizer {
    /* access modifiers changed from: package-private */
    @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
    public abstract String getName();

    /* access modifiers changed from: package-private */
    public abstract boolean nextChar(iteratedChar iteratedchar, CharsetDetector charsetDetector);

    CharsetRecog_mbcs() {
    }

    /* access modifiers changed from: package-private */
    public int match(CharsetDetector charsetDetector, int[] iArr) {
        iteratedChar iteratedchar = new iteratedChar();
        iteratedchar.reset();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (nextChar(iteratedchar, charsetDetector)) {
            i2++;
            if (iteratedchar.error) {
                i3++;
            } else {
                long j2 = ((long) iteratedchar.charValue) & Util.MAX_32BIT_VALUE;
                if (j2 > 255) {
                    i5++;
                    if (iArr != null && Arrays.binarySearch(iArr, (int) j2) >= 0) {
                        i4++;
                    }
                }
            }
            if (i3 >= 2 && i3 * 5 >= i5) {
                return 0;
            }
        }
        if (i5 <= 10 && i3 == 0) {
            return (i5 != 0 || i2 >= 10) ? 10 : 0;
        }
        if (i5 < i3 * 20) {
            return 0;
        }
        if (iArr != null) {
            return Math.min((int) (((90.0d / Math.log((double) (((float) i5) / 4.0f))) * Math.log((double) (i4 + 1))) + 10.0d), 100);
        }
        int i6 = (i5 + 30) - (i3 * 20);
        if (i6 > 100) {
            return 100;
        }
        return i6;
    }

    static class iteratedChar {
        int charValue = 0;
        boolean done = false;
        boolean error = false;
        int nextIndex = 0;

        iteratedChar() {
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.charValue = 0;
            this.nextIndex = 0;
            this.error = false;
            this.done = false;
        }

        /* access modifiers changed from: package-private */
        public int nextByte(CharsetDetector charsetDetector) {
            if (this.nextIndex >= charsetDetector.fRawLength) {
                this.done = true;
                return -1;
            }
            byte[] bArr = charsetDetector.fRawInput;
            int i2 = this.nextIndex;
            this.nextIndex = i2 + 1;
            return bArr[i2] & 255;
        }
    }

    static class CharsetRecog_sjis extends CharsetRecog_mbcs {
        static int[] commonChars = {33088, 33089, 33090, 33093, 33115, 33129, 33130, 33141, 33142, 33440, 33442, 33444, 33449, 33450, 33451, 33453, 33455, 33457, 33459, 33461, 33463, 33469, 33470, 33473, 33476, 33477, 33478, 33480, 33481, 33484, 33485, 33500, 33504, 33511, 33512, 33513, 33514, 33520, 33521, 33601, 33603, 33614, 33615, 33624, 33630, 33634, 33639, 33653, 33654, 33673, 33674, 33675, 33677, 33683, 36502, 37882, 38314};

        CharsetRecog_sjis() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs
        public boolean nextChar(iteratedChar iteratedchar, CharsetDetector charsetDetector) {
            AppMethodBeat.i(76663);
            iteratedchar.error = false;
            int nextByte = iteratedchar.nextByte(charsetDetector);
            iteratedchar.charValue = nextByte;
            if (nextByte < 0) {
                AppMethodBeat.o(76663);
                return false;
            } else if (nextByte <= 127 || (nextByte > 160 && nextByte <= 223)) {
                AppMethodBeat.o(76663);
                return true;
            } else {
                int nextByte2 = iteratedchar.nextByte(charsetDetector);
                if (nextByte2 < 0) {
                    AppMethodBeat.o(76663);
                    return false;
                }
                iteratedchar.charValue = (nextByte << 8) | nextByte2;
                if ((nextByte2 < 64 || nextByte2 > 127) && (nextByte2 < 128 || nextByte2 > 255)) {
                    iteratedchar.error = true;
                }
                AppMethodBeat.o(76663);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            AppMethodBeat.i(76664);
            int match = match(charsetDetector, commonChars);
            if (match == 0) {
                AppMethodBeat.o(76664);
                return null;
            }
            CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, match);
            AppMethodBeat.o(76664);
            return charsetMatch;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs
        public String getName() {
            return "Shift_JIS";
        }

        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public String getLanguage() {
            return LocaleUtil.JAPANESE;
        }
    }

    static class CharsetRecog_big5 extends CharsetRecog_mbcs {
        static int[] commonChars = {41280, 41281, 41282, 41283, 41287, 41289, 41333, 41334, 42048, 42054, 42055, 42056, 42065, 42068, 42071, 42084, 42090, 42092, 42103, 42147, 42148, 42151, 42177, 42190, 42193, 42207, 42216, 42237, 42304, 42312, 42328, 42345, 42445, 42471, 42583, 42593, 42594, 42600, 42608, 42664, 42675, 42681, 42707, 42715, 42726, 42738, 42816, 42833, 42841, 42970, 43171, 43173, 43181, 43217, 43219, 43236, 43260, 43456, 43474, 43507, 43627, 43706, 43710, 43724, 43772, 44103, 44111, 44208, 44242, 44377, 44745, 45024, 45290, 45423, 45747, 45764, 45935, 46156, 46158, 46412, 46501, 46525, 46544, 46552, 46705, 47085, 47207, 47428, 47832, 47940, 48033, 48593, 49860, 50105, 50240, 50271};

        CharsetRecog_big5() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs
        public boolean nextChar(iteratedChar iteratedchar, CharsetDetector charsetDetector) {
            AppMethodBeat.i(76649);
            iteratedchar.error = false;
            int nextByte = iteratedchar.nextByte(charsetDetector);
            iteratedchar.charValue = nextByte;
            if (nextByte < 0) {
                AppMethodBeat.o(76649);
                return false;
            } else if (nextByte <= 127 || nextByte == 255) {
                AppMethodBeat.o(76649);
                return true;
            } else {
                int nextByte2 = iteratedchar.nextByte(charsetDetector);
                if (nextByte2 < 0) {
                    AppMethodBeat.o(76649);
                    return false;
                }
                iteratedchar.charValue = (iteratedchar.charValue << 8) | nextByte2;
                if (nextByte2 < 64 || nextByte2 == 127 || nextByte2 == 255) {
                    iteratedchar.error = true;
                }
                AppMethodBeat.o(76649);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            AppMethodBeat.i(76650);
            int match = match(charsetDetector, commonChars);
            if (match == 0) {
                AppMethodBeat.o(76650);
                return null;
            }
            CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, match);
            AppMethodBeat.o(76650);
            return charsetMatch;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs
        public String getName() {
            return "Big5";
        }

        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public String getLanguage() {
            return "zh";
        }
    }

    static abstract class CharsetRecog_euc extends CharsetRecog_mbcs {
        CharsetRecog_euc() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs
        public boolean nextChar(iteratedChar iteratedchar, CharsetDetector charsetDetector) {
            iteratedchar.error = false;
            int nextByte = iteratedchar.nextByte(charsetDetector);
            iteratedchar.charValue = nextByte;
            if (nextByte < 0) {
                iteratedchar.done = true;
            } else if (nextByte > 141) {
                int nextByte2 = iteratedchar.nextByte(charsetDetector);
                iteratedchar.charValue = (iteratedchar.charValue << 8) | nextByte2;
                if (nextByte < 161 || nextByte > 254) {
                    if (nextByte == 142) {
                        if (nextByte2 < 161) {
                            iteratedchar.error = true;
                        }
                    } else if (nextByte == 143) {
                        int nextByte3 = iteratedchar.nextByte(charsetDetector);
                        iteratedchar.charValue = (iteratedchar.charValue << 8) | nextByte3;
                        if (nextByte3 < 161) {
                            iteratedchar.error = true;
                        }
                    }
                } else if (nextByte2 < 161) {
                    iteratedchar.error = true;
                }
            }
            return !iteratedchar.done;
        }

        static class CharsetRecog_euc_jp extends CharsetRecog_euc {
            static int[] commonChars = {41377, 41378, 41379, 41382, 41404, 41418, 41419, 41430, 41431, 42146, 42148, 42150, 42152, 42154, 42155, 42156, 42157, 42159, 42161, 42163, 42165, 42167, 42169, 42171, 42173, 42175, 42176, 42177, 42179, 42180, 42182, 42183, 42184, 42185, 42186, 42187, 42190, 42191, 42192, 42206, 42207, 42209, 42210, 42212, 42216, 42217, 42218, 42219, 42220, 42223, 42226, 42227, 42402, 42403, 42404, 42406, 42407, 42410, 42413, 42415, 42416, 42419, 42421, 42423, 42424, 42425, 42431, 42435, 42438, 42439, 42440, 42441, 42443, 42448, 42453, 42454, 42455, 42462, 42464, 42465, 42469, 42473, 42474, 42475, 42476, 42477, 42483, 47273, 47572, 47854, 48072, 48880, 49079, 50410, 50940, 51133, 51896, 51955, 52188, 52689};

            CharsetRecog_euc_jp() {
            }

            /* access modifiers changed from: package-private */
            @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs
            public String getName() {
                return "EUC-JP";
            }

            /* access modifiers changed from: package-private */
            @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
            public CharsetMatch match(CharsetDetector charsetDetector) {
                AppMethodBeat.i(76639);
                int match = match(charsetDetector, commonChars);
                if (match == 0) {
                    AppMethodBeat.o(76639);
                    return null;
                }
                CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, match);
                AppMethodBeat.o(76639);
                return charsetMatch;
            }

            @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
            public String getLanguage() {
                return LocaleUtil.JAPANESE;
            }
        }

        static class CharsetRecog_euc_kr extends CharsetRecog_euc {
            static int[] commonChars = {45217, 45235, 45253, 45261, 45268, 45286, 45293, 45304, 45306, 45308, 45496, 45497, 45511, 45527, 45538, 45994, 46011, 46274, 46287, 46297, 46315, 46501, 46517, 46527, 46535, 46569, 46835, 47023, 47042, 47054, 47270, 47278, 47286, 47288, 47291, 47337, 47531, 47534, 47564, 47566, 47613, 47800, 47822, 47824, 47857, 48103, 48115, 48125, 48301, 48314, 48338, 48374, 48570, 48576, 48579, 48581, 48838, 48840, 48863, 48878, 48888, 48890, 49057, 49065, 49088, 49124, 49131, 49132, 49144, 49319, 49327, 49336, 49338, 49339, 49341, 49351, 49356, 49358, 49359, 49366, 49370, 49381, 49403, 49404, 49572, 49574, 49590, 49622, 49631, 49654, 49656, 50337, 50637, 50862, 51151, 51153, 51154, 51160, 51173, 51373};

            CharsetRecog_euc_kr() {
            }

            /* access modifiers changed from: package-private */
            @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs
            public String getName() {
                return "EUC-KR";
            }

            /* access modifiers changed from: package-private */
            @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
            public CharsetMatch match(CharsetDetector charsetDetector) {
                AppMethodBeat.i(76614);
                int match = match(charsetDetector, commonChars);
                if (match == 0) {
                    AppMethodBeat.o(76614);
                    return null;
                }
                CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, match);
                AppMethodBeat.o(76614);
                return charsetMatch;
            }

            @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
            public String getLanguage() {
                return LocaleUtil.KOREAN;
            }
        }
    }

    static class CharsetRecog_gb_18030 extends CharsetRecog_mbcs {
        static int[] commonChars = {41377, 41378, 41379, 41380, 41392, 41393, 41457, 41459, 41889, 41900, 41914, 45480, 45496, 45502, 45755, 46025, 46070, 46323, 46525, 46532, 46563, 46767, 46804, 46816, 47010, 47016, 47037, 47062, 47069, 47284, 47327, 47350, 47531, 47561, 47576, 47610, 47613, 47821, 48039, 48086, 48097, 48122, 48316, 48347, 48382, 48588, 48845, 48861, 49076, 49094, 49097, 49332, 49389, 49611, 49883, 50119, 50396, 50410, 50636, 50935, 51192, 51371, 51403, 51413, 51431, 51663, 51706, 51889, 51893, 51911, 51920, 51926, 51957, 51965, 52460, 52728, 52906, 52932, 52946, 52965, 53173, 53186, 53206, 53442, 53445, 53456, 53460, 53671, 53930, 53938, 53941, 53947, 53972, 54211, 54224, 54269, 54466, 54490, 54754, 54992};

        CharsetRecog_gb_18030() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs
        public boolean nextChar(iteratedChar iteratedchar, CharsetDetector charsetDetector) {
            int nextByte;
            int nextByte2;
            AppMethodBeat.i(76665);
            iteratedchar.error = false;
            int nextByte3 = iteratedchar.nextByte(charsetDetector);
            iteratedchar.charValue = nextByte3;
            if (nextByte3 < 0) {
                iteratedchar.done = true;
            } else if (nextByte3 > 128) {
                int nextByte4 = iteratedchar.nextByte(charsetDetector);
                iteratedchar.charValue = (iteratedchar.charValue << 8) | nextByte4;
                if (nextByte3 >= 129 && nextByte3 <= 254 && ((nextByte4 < 64 || nextByte4 > 126) && (nextByte4 < 80 || nextByte4 > 254))) {
                    if (nextByte4 < 48 || nextByte4 > 57 || (nextByte = iteratedchar.nextByte(charsetDetector)) < 129 || nextByte > 254 || (nextByte2 = iteratedchar.nextByte(charsetDetector)) < 48 || nextByte2 > 57) {
                        iteratedchar.error = true;
                    } else {
                        iteratedchar.charValue = (nextByte << 8) | (iteratedchar.charValue << 16) | nextByte2;
                    }
                }
            }
            if (!iteratedchar.done) {
                AppMethodBeat.o(76665);
                return true;
            }
            AppMethodBeat.o(76665);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer, com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs
        public String getName() {
            return "GB18030";
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            AppMethodBeat.i(76666);
            int match = match(charsetDetector, commonChars);
            if (match == 0) {
                AppMethodBeat.o(76666);
                return null;
            }
            CharsetMatch charsetMatch = new CharsetMatch(charsetDetector, this, match);
            AppMethodBeat.o(76666);
            return charsetMatch;
        }

        @Override // com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecognizer
        public String getLanguage() {
            return "zh";
        }
    }
}
