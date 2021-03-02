package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class q {
    public static int Rc(String str) {
        AppMethodBeat.i(148446);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(148446);
            return -1;
        }
        Log.d("MicroMsg.VoiceFile", "fileName ".concat(String.valueOf(str)));
        if (h(str, 0, false)) {
            AppMethodBeat.o(148446);
            return 0;
        } else if (i(str, 0, false)) {
            AppMethodBeat.o(148446);
            return 2;
        } else {
            AppMethodBeat.o(148446);
            return 1;
        }
    }

    public static int g(String str, int i2, boolean z) {
        AppMethodBeat.i(148447);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(148447);
            return -1;
        }
        Log.d("MicroMsg.VoiceFile", "fileName ".concat(String.valueOf(str)));
        if (h(str, i2, z)) {
            AppMethodBeat.o(148447);
            return 0;
        } else if (i(str, i2, z)) {
            AppMethodBeat.o(148447);
            return 2;
        } else {
            AppMethodBeat.o(148447);
            return 1;
        }
    }

    private static boolean h(String str, int i2, boolean z) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        Exception e2;
        AppMethodBeat.i(148448);
        if (!z) {
            if (i2 == 0) {
                str = s.getFullPath(str);
            } else {
                str = null;
            }
        }
        Log.d("MicroMsg.VoiceFile", "path ".concat(String.valueOf(str)));
        try {
            randomAccessFile = s.dB(str, false);
            try {
                byte[] bArr = new byte[6];
                if (randomAccessFile.read(bArr, 0, 6) == -1) {
                    Log.e("MicroMsg.VoiceFile", "read amr file header failed!");
                    aa.closeQuietly(randomAccessFile);
                    AppMethodBeat.o(148448);
                    return false;
                }
                String str2 = new String(bArr);
                Log.i("MicroMsg.VoiceFile", "isAmrHeader voice file headHex:|%s| headStr:|%s| AmrFileOperator.AMR_NB_HEAD:|%s|", Util.dumpHex(bArr), str2, "#!AMR\n");
                if (str2.endsWith("#!AMR\n")) {
                    aa.closeQuietly(randomAccessFile);
                    AppMethodBeat.o(148448);
                    return true;
                }
                aa.closeQuietly(randomAccessFile);
                AppMethodBeat.o(148448);
                return false;
            } catch (Exception e3) {
                e2 = e3;
                try {
                    Log.printErrStackTrace("MicroMsg.VoiceFile", e2, "", new Object[0]);
                    aa.closeQuietly(randomAccessFile);
                    AppMethodBeat.o(148448);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    aa.closeQuietly(randomAccessFile);
                    AppMethodBeat.o(148448);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            randomAccessFile = null;
            Log.printErrStackTrace("MicroMsg.VoiceFile", e2, "", new Object[0]);
            aa.closeQuietly(randomAccessFile);
            AppMethodBeat.o(148448);
            return false;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            aa.closeQuietly(randomAccessFile);
            AppMethodBeat.o(148448);
            throw th;
        }
    }

    public static boolean i(String str, int i2, boolean z) {
        RandomAccessFile randomAccessFile = null;
        AppMethodBeat.i(148449);
        if (!z) {
            if (i2 == 0) {
                str = s.getFullPath(str);
            } else if (i2 == 1) {
                Log.e("MicroMsg.VoiceFile", "isSilkHeader usertype error, TYPE_RECOGNIZER_BIZ fileName:%s", str);
                AppMethodBeat.o(148449);
                return false;
            } else {
                str = null;
            }
        }
        Log.d("MicroMsg.VoiceFile", "isSilkHeader path ".concat(String.valueOf(str)));
        try {
            randomAccessFile = s.dB(str, false);
            byte[] bArr = new byte[9];
            randomAccessFile.seek(1);
            if (randomAccessFile.read(bArr, 0, 9) == -1) {
                aa.closeQuietly(randomAccessFile);
                AppMethodBeat.o(148449);
                return false;
            }
            String str2 = new String(bArr);
            Log.i("MicroMsg.VoiceFile", "isSilkHeader voice file headHex:|%s| headStr:|%s| AmrFileOperator.AMR_NB_HEAD:|%s|", Util.dumpHex(bArr), str2, "#!SILK_V3");
            if (str2.endsWith("#!SILK_V3")) {
                aa.closeQuietly(randomAccessFile);
                AppMethodBeat.o(148449);
                return true;
            }
            aa.closeQuietly(randomAccessFile);
            AppMethodBeat.o(148449);
            return false;
        } catch (Exception e2) {
            Log.d("MicroMsg.VoiceFile", "isSilkHeader file not found");
            aa.closeQuietly(randomAccessFile);
        } catch (Throwable th) {
            aa.closeQuietly(randomAccessFile);
            AppMethodBeat.o(148449);
            throw th;
        }
    }

    public static int Qy(String str) {
        boolean z = true;
        AppMethodBeat.i(148450);
        switch (Rc(str)) {
            case 0:
                int Rd = Rd(s.getFullPath(str));
                AppMethodBeat.o(148450);
                return Rd;
            case 1:
                String fullPath = s.getFullPath(str);
                if (fullPath.length() < 0) {
                    z = false;
                }
                Assert.assertTrue(z);
                o oVar = new o(fullPath);
                if (!oVar.exists()) {
                    AppMethodBeat.o(148450);
                    return 0;
                }
                int length = (int) oVar.length();
                if (length <= 0) {
                    AppMethodBeat.o(148450);
                    return 0;
                }
                AppMethodBeat.o(148450);
                return length;
            case 2:
                String fullPath2 = s.getFullPath(str);
                if (fullPath2.length() < 0) {
                    z = false;
                }
                Assert.assertTrue(z);
                o oVar2 = new o(fullPath2);
                if (!oVar2.exists()) {
                    AppMethodBeat.o(148450);
                    return 0;
                }
                int length2 = (int) oVar2.length();
                if (length2 <= 0) {
                    AppMethodBeat.o(148450);
                    return 0;
                }
                AppMethodBeat.o(148450);
                return length2;
            default:
                int Rd2 = Rd(s.getFullPath(str));
                AppMethodBeat.o(148450);
                return Rd2;
        }
    }

    private static int Rd(String str) {
        AppMethodBeat.i(148451);
        Assert.assertTrue(str.length() >= 0);
        o oVar = new o(str);
        if (!oVar.exists()) {
            AppMethodBeat.o(148451);
            return 0;
        }
        int length = ((int) oVar.length()) - 6;
        if (length <= 0) {
            AppMethodBeat.o(148451);
            return 0;
        }
        AppMethodBeat.o(148451);
        return length;
    }
}
