package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStream;

public final class MMImageChecker {
    private static final IImageChecker[] sCheckers = {new BmpBadAllocChecker(104857600)};

    interface IImageChecker {
        boolean isLegalImage(FileDescriptor fileDescriptor);

        boolean isLegalImage(InputStream inputStream);

        boolean isLegalImage(byte[] bArr);
    }

    static {
        AppMethodBeat.i(215383);
        AppMethodBeat.o(215383);
    }

    public static boolean isLegalImage(InputStream inputStream) {
        AppMethodBeat.i(215379);
        if (inputStream == null) {
            AppMethodBeat.o(215379);
            return false;
        }
        for (IImageChecker iImageChecker : sCheckers) {
            if (!iImageChecker.isLegalImage(inputStream)) {
                AppMethodBeat.o(215379);
                return false;
            }
        }
        AppMethodBeat.o(215379);
        return true;
    }

    public static boolean isLegalImage(byte[] bArr) {
        AppMethodBeat.i(215380);
        if (bArr == null) {
            AppMethodBeat.o(215380);
            return false;
        }
        for (IImageChecker iImageChecker : sCheckers) {
            if (!iImageChecker.isLegalImage(bArr)) {
                AppMethodBeat.o(215380);
                return false;
            }
        }
        AppMethodBeat.o(215380);
        return true;
    }

    public static boolean isLegalImage(FileDescriptor fileDescriptor) {
        AppMethodBeat.i(215381);
        if (fileDescriptor == null || !fileDescriptor.valid()) {
            AppMethodBeat.o(215381);
            return false;
        }
        for (IImageChecker iImageChecker : sCheckers) {
            if (!iImageChecker.isLegalImage(fileDescriptor)) {
                AppMethodBeat.o(215381);
                return false;
            }
        }
        AppMethodBeat.o(215381);
        return true;
    }

    static class BmpBadAllocChecker implements IImageChecker {
        private static final long BMP_SECOND_HEADER_SIZE_OFFSET = 14;
        private static final String TAG = "MicroMsg.BmpBadAllocChecker";
        private final long mImageSizeLimit;

        BmpBadAllocChecker(int i2) {
            AppMethodBeat.i(215374);
            this.mImageSizeLimit = (long) i2;
            AppMethodBeat.o(215374);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMImageChecker.IImageChecker
        public boolean isLegalImage(InputStream inputStream) {
            AppMethodBeat.i(215375);
            if (!inputStream.markSupported()) {
                if (inputStream instanceof FileInputStream) {
                    inputStream = new FileSeekingInputStream((FileInputStream) inputStream);
                } else {
                    inputStream = new BufferedInputStream(inputStream);
                }
            }
            boolean isLegalImageInMarkableStream = isLegalImageInMarkableStream(inputStream);
            AppMethodBeat.o(215375);
            return isLegalImageInMarkableStream;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMImageChecker.IImageChecker
        public boolean isLegalImage(byte[] bArr) {
            AppMethodBeat.i(215376);
            if (((long) bArr.length) < BMP_SECOND_HEADER_SIZE_OFFSET) {
                AppMethodBeat.o(215376);
                return true;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            boolean isLegalImageInMarkableStream = isLegalImageInMarkableStream(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
            } catch (Throwable th) {
            }
            AppMethodBeat.o(215376);
            return isLegalImageInMarkableStream;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x002d A[SYNTHETIC, Splitter:B:15:0x002d] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0038 A[SYNTHETIC, Splitter:B:21:0x0038] */
        @Override // com.tencent.mm.sdk.platformtools.MMImageChecker.IImageChecker
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isLegalImage(java.io.FileDescriptor r8) {
            /*
                r7 = this;
                r0 = 0
                r6 = 215377(0x34951, float:3.01807E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                r3 = 0
                java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Throwable -> 0x001d, all -> 0x0034 }
                java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x001d, all -> 0x0034 }
                r1.<init>(r8)     // Catch:{ Throwable -> 0x001d, all -> 0x0034 }
                r2.<init>(r1)     // Catch:{ Throwable -> 0x001d, all -> 0x0034 }
                boolean r0 = r7.isLegalImageInMarkableStream(r2)     // Catch:{ Throwable -> 0x0047 }
                r2.close()     // Catch:{ Throwable -> 0x003f }
            L_0x0019:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            L_0x001c:
                return r0
            L_0x001d:
                r1 = move-exception
                r2 = r3
            L_0x001f:
                java.lang.String r3 = "MicroMsg.BmpBadAllocChecker"
                java.lang.String r4 = ""
                r5 = 0
                java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0045 }
                com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(r3, r1, r4, r5)     // Catch:{ all -> 0x0045 }
                if (r2 == 0) goto L_0x0030
                r2.close()     // Catch:{ Throwable -> 0x0041 }
            L_0x0030:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                goto L_0x001c
            L_0x0034:
                r0 = move-exception
                r2 = r3
            L_0x0036:
                if (r2 == 0) goto L_0x003b
                r2.close()     // Catch:{ Throwable -> 0x0043 }
            L_0x003b:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                throw r0
            L_0x003f:
                r1 = move-exception
                goto L_0x0019
            L_0x0041:
                r1 = move-exception
                goto L_0x0030
            L_0x0043:
                r1 = move-exception
                goto L_0x003b
            L_0x0045:
                r0 = move-exception
                goto L_0x0036
            L_0x0047:
                r1 = move-exception
                goto L_0x001f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.MMImageChecker.BmpBadAllocChecker.isLegalImage(java.io.FileDescriptor):boolean");
        }

        private boolean isLegalImageInMarkableStream(InputStream inputStream) {
            boolean z = true;
            AppMethodBeat.i(215378);
            if (!inputStream.markSupported()) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("not a markable input stream.");
                AppMethodBeat.o(215378);
                throw illegalArgumentException;
            }
            inputStream.mark(32);
            try {
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                byte readByte = dataInputStream.readByte();
                byte readByte2 = dataInputStream.readByte();
                if (readByte == 66 && readByte2 == 77) {
                    dataInputStream.skip(12);
                    byte[] bArr = new byte[4];
                    dataInputStream.read(bArr);
                    if ((((long) (((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[0] & 255))) & Util.MAX_32BIT_VALUE) > this.mImageSizeLimit) {
                        z = false;
                    }
                    try {
                        inputStream.reset();
                    } catch (Throwable th) {
                    }
                    AppMethodBeat.o(215378);
                    return z;
                }
                try {
                    inputStream.reset();
                } catch (Throwable th2) {
                }
                AppMethodBeat.o(215378);
                return true;
            } catch (Throwable th3) {
            }
            AppMethodBeat.o(215378);
            return false;
        }
    }

    private MMImageChecker() {
        AppMethodBeat.i(215382);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(215382);
        throw unsupportedOperationException;
    }
}
