package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;

public final class r {
    private static String bytesToHexString(byte[] bArr) {
        AppMethodBeat.i(133566);
        StringBuilder sb = new StringBuilder();
        if (bArr.length <= 0) {
            AppMethodBeat.o(133566);
            return null;
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(133566);
        return sb2;
    }

    public static boolean Ql(String str) {
        AppMethodBeat.i(133567);
        Log.d("MicroMsg.VideoFile", " filepath ".concat(String.valueOf(str)));
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(133567);
            return false;
        }
        InputStream inputStream = null;
        try {
            InputStream openRead = s.openRead(str);
            byte[] bArr = new byte[10];
            openRead.read(bArr, 0, 10);
            String bytesToHexString = bytesToHexString(bArr);
            if (!Util.isNullOrNil(bytesToHexString)) {
                String upperCase = bytesToHexString.toUpperCase();
                Log.d("MicroMsg.VideoFile", "file type ".concat(String.valueOf(upperCase)));
                if (upperCase.contains("00000014667479707174")) {
                    Log.d("MicroMsg.VideoFile", "file type qt ");
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (IOException e2) {
                        }
                    }
                    AppMethodBeat.o(133567);
                    return true;
                }
            }
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e3) {
                }
            }
        } catch (Exception e4) {
            Log.e("MicroMsg.VideoFile", "exception:%s", Util.stackTraceToString(e4));
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(133567);
            throw th;
        }
        AppMethodBeat.o(133567);
        return false;
    }

    public static boolean Qm(String str) {
        AppMethodBeat.i(133568);
        if (!s.YS(str)) {
            AppMethodBeat.o(133568);
            return false;
        }
        InputStream inputStream = null;
        try {
            InputStream openRead = s.openRead(str);
            byte[] bArr = new byte[32];
            openRead.read(bArr, 0, 32);
            String bytesToHexString = bytesToHexString(bArr);
            if (Util.isNullOrNil(bytesToHexString) || !bytesToHexString.toUpperCase().contains("68766331")) {
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.o(133568);
                return false;
            }
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.o(133568);
            return true;
        } catch (Exception e4) {
            Log.e("MicroMsg.VideoFile", "exception:%s", Util.stackTraceToString(e4));
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(133568);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0061, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a4, code lost:
        r4.gLF.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ae, code lost:
        r5.gLF.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c5, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c6, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0084 A[LOOP:0: B:10:0x0040->B:24:0x0084, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c0 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x007a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isH265Video(java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.r.isH265Video(java.lang.String):boolean");
    }
}
