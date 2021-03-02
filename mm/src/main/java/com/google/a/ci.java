package com.google.a;

import com.tencent.liteav.TXLiteAVCode;

/* access modifiers changed from: package-private */
public final class ci {
    private static final b cax;

    public static boolean F(byte[] bArr) {
        return cax.s(bArr, 0, bArr.length);
    }

    public static boolean s(byte[] bArr, int i2, int i3) {
        return cax.s(bArr, i2, i3);
    }

    /* access modifiers changed from: private */
    public static int gV(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static int by(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return (i3 << 8) ^ i2;
    }

    /* access modifiers changed from: private */
    public static int z(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return ((i3 << 8) ^ i2) ^ (i4 << 16);
    }

    /* access modifiers changed from: package-private */
    public static class d extends IllegalArgumentException {
        d(int i2, int i3) {
            super("Unpaired surrogate at index " + i2 + " of " + i3);
        }
    }

    static int v(CharSequence charSequence) {
        int i2;
        int i3 = 0;
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length && charSequence.charAt(i4) < 128) {
            i4++;
        }
        int i5 = length;
        while (true) {
            if (i4 >= length) {
                i2 = i5;
                break;
            }
            char charAt = charSequence.charAt(i4);
            if (charAt < 2048) {
                i5 += (127 - charAt) >>> 31;
                i4++;
            } else {
                int length2 = charSequence.length();
                while (i4 < length2) {
                    char charAt2 = charSequence.charAt(i4);
                    if (charAt2 < 2048) {
                        i3 += (127 - charAt2) >>> 31;
                    } else {
                        i3 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i4) < 65536) {
                                throw new d(i4, length2);
                            }
                            i4++;
                        }
                    }
                    i4++;
                }
                i2 = i3 + i5;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + 4294967296L));
    }

    static int a(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        return cax.b(charSequence, bArr, i2, i3);
    }

    static String t(byte[] bArr, int i2, int i3) {
        return cax.t(bArr, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public static abstract class b {
        /* access modifiers changed from: package-private */
        public abstract int b(CharSequence charSequence, byte[] bArr, int i2, int i3);

        /* access modifiers changed from: package-private */
        public abstract String t(byte[] bArr, int i2, int i3);

        /* access modifiers changed from: package-private */
        public abstract int v(byte[] bArr, int i2, int i3);

        b() {
        }

        /* access modifiers changed from: package-private */
        public final boolean s(byte[] bArr, int i2, int i3) {
            return v(bArr, i2, i3) == 0;
        }
    }

    static final class c extends b {
        c() {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 151
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
            */
        @Override // com.google.a.ci.b
        final int v(byte[] r10, int r11, int r12) {
            /*
            // Method dump skipped, instructions count: 124
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.ci.c.v(byte[], int, int):int");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 154
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
            */
        @Override // com.google.a.ci.b
        final java.lang.String t(byte[] r12, int r13, int r14) {
            /*
            // Method dump skipped, instructions count: 204
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.ci.c.t(byte[], int, int):java.lang.String");
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.a.ci.b
        public final int b(CharSequence charSequence, byte[] bArr, int i2, int i3) {
            int i4;
            int length = charSequence.length();
            int i5 = 0;
            int i6 = i2 + i3;
            while (i5 < length && i5 + i2 < i6) {
                char charAt = charSequence.charAt(i5);
                if (charAt >= 128) {
                    break;
                }
                bArr[i2 + i5] = (byte) charAt;
                i5++;
            }
            if (i5 == length) {
                return i2 + length;
            }
            int i7 = i2 + i5;
            while (i5 < length) {
                char charAt2 = charSequence.charAt(i5);
                if (charAt2 < 128 && i7 < i6) {
                    i4 = i7 + 1;
                    bArr[i7] = (byte) charAt2;
                } else if (charAt2 < 2048 && i7 <= i6 - 2) {
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) ((charAt2 >>> 6) | 960);
                    i4 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 & '?') | 128);
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i7 <= i6 - 3) {
                    int i9 = i7 + 1;
                    bArr[i7] = (byte) ((charAt2 >>> '\f') | 480);
                    int i10 = i9 + 1;
                    bArr[i9] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i4 = i10 + 1;
                    bArr[i10] = (byte) ((charAt2 & '?') | 128);
                } else if (i7 <= i6 - 4) {
                    if (i5 + 1 != charSequence.length()) {
                        i5++;
                        char charAt3 = charSequence.charAt(i5);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i11 = i7 + 1;
                            bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                            int i12 = i11 + 1;
                            bArr[i11] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i13 = i12 + 1;
                            bArr[i12] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i4 = i13 + 1;
                            bArr[i13] = (byte) ((codePoint & 63) | 128);
                        }
                    }
                    throw new d(i5 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || (i5 + 1 != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i5 + 1)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i7);
                } else {
                    throw new d(i5, length);
                }
                i5++;
                i7 = i4;
            }
            return i7;
        }
    }

    static final class e extends b {
        e() {
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.a.ci.b
        public final int v(byte[] bArr, int i2, int i3) {
            if ((i2 | i3 | (bArr.length - i3)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            long j2 = (long) i2;
            return a(bArr, j2, (int) (((long) i3) - j2));
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 154
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
            */
        @Override // com.google.a.ci.b
        final java.lang.String t(byte[] r13, int r14, int r15) {
            /*
            // Method dump skipped, instructions count: 233
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.ci.e.t(byte[], int, int):java.lang.String");
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.a.ci.b
        public final int b(CharSequence charSequence, byte[] bArr, int i2, int i3) {
            long j2;
            long j3 = (long) i2;
            long j4 = j3 + ((long) i3);
            int length = charSequence.length();
            if (length > i3 || bArr.length - i3 < i2) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i2 + i3));
            }
            int i4 = 0;
            while (i4 < length) {
                char charAt = charSequence.charAt(i4);
                if (charAt >= 128) {
                    break;
                }
                ch.a(bArr, j3, (byte) charAt);
                i4++;
                j3 = 1 + j3;
            }
            if (i4 == length) {
                return (int) j3;
            }
            long j5 = j3;
            while (i4 < length) {
                char charAt2 = charSequence.charAt(i4);
                if (charAt2 < 128 && j5 < j4) {
                    j2 = 1 + j5;
                    ch.a(bArr, j5, (byte) charAt2);
                } else if (charAt2 < 2048 && j5 <= j4 - 2) {
                    long j6 = j5 + 1;
                    ch.a(bArr, j5, (byte) ((charAt2 >>> 6) | 960));
                    j2 = 1 + j6;
                    ch.a(bArr, j6, (byte) ((charAt2 & '?') | 128));
                } else if ((charAt2 < 55296 || 57343 < charAt2) && j5 <= j4 - 3) {
                    long j7 = 1 + j5;
                    ch.a(bArr, j5, (byte) ((charAt2 >>> '\f') | 480));
                    long j8 = 1 + j7;
                    ch.a(bArr, j7, (byte) (((charAt2 >>> 6) & 63) | 128));
                    j2 = 1 + j8;
                    ch.a(bArr, j8, (byte) ((charAt2 & '?') | 128));
                } else if (j5 <= j4 - 4) {
                    if (i4 + 1 != length) {
                        i4++;
                        char charAt3 = charSequence.charAt(i4);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            long j9 = 1 + j5;
                            ch.a(bArr, j5, (byte) ((codePoint >>> 18) | 240));
                            long j10 = 1 + j9;
                            ch.a(bArr, j9, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j11 = j10 + 1;
                            ch.a(bArr, j10, (byte) (((codePoint >>> 6) & 63) | 128));
                            j2 = 1 + j11;
                            ch.a(bArr, j11, (byte) ((codePoint & 63) | 128));
                        }
                    }
                    throw new d(i4 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || (i4 + 1 != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i4 + 1)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j5);
                } else {
                    throw new d(i4, length);
                }
                i4++;
                j5 = j2;
            }
            return (int) j5;
        }

        private static int a(byte[] bArr, int i2, long j2, int i3) {
            switch (i3) {
                case 0:
                    return ci.gV(i2);
                case 1:
                    return ci.by(i2, ch.c(bArr, j2));
                case 2:
                    return ci.z(i2, ch.c(bArr, j2), ch.c(bArr, 1 + j2));
                default:
                    throw new AssertionError();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004e, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0085, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int a(byte[] r9, long r10, int r12) {
            /*
            // Method dump skipped, instructions count: 190
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.a.ci.e.a(byte[], long, int):int");
        }
    }

    static class a {
        static /* synthetic */ void a(byte b2, byte b3, byte b4, char[] cArr, int i2) {
            if (h(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || h(b4)))) {
                throw af.GN();
            }
            cArr[i2] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
        }

        private static boolean h(byte b2) {
            return b2 > -65;
        }

        static /* synthetic */ void a(byte b2, char[] cArr, int i2) {
            cArr[i2] = (char) b2;
        }

        static /* synthetic */ boolean i(byte b2) {
            return b2 < -32;
        }

        static /* synthetic */ void a(byte b2, byte b3, char[] cArr, int i2) {
            if (b2 < -62 || h(b3)) {
                throw af.GN();
            }
            cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
        }

        static /* synthetic */ boolean j(byte b2) {
            return b2 < -16;
        }

        static /* synthetic */ void a(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) {
            if (h(b3) || (((b2 << 28) + (b3 + 112)) >> 30) != 0 || h(b4) || h(b5)) {
                throw af.GN();
            }
            int i3 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
            cArr[i2] = (char) (55232 + (i3 >>> 10));
            cArr[i2 + 1] = (char) ((i3 & TXLiteAVCode.EVT_CAMERA_REMOVED) + 56320);
        }
    }

    static /* synthetic */ int u(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2 - 1];
        switch (i3 - i2) {
            case 0:
                return gV(b2);
            case 1:
                return by(b2, bArr[i2]);
            case 2:
                return z(b2, bArr[i2], bArr[i2 + 1]);
            default:
                throw new AssertionError();
        }
    }

    static {
        boolean z;
        if (!ch.HS() || !ch.HT()) {
            z = false;
        } else {
            z = true;
        }
        cax = (!z || e.yM()) ? new c() : new e();
    }
}
