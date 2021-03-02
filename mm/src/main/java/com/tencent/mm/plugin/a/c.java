package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;

public final class c {
    public static boolean Sx(String str) {
        AppMethodBeat.i(133852);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(133852);
            return false;
        }
        InputStream inputStream = null;
        try {
            inputStream = s.openRead(str);
            byte[] bArr = new byte[8];
            if (inputStream.read(bArr, 0, 8) < 8) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.AtomUtil", e2, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(133852);
                return false;
            }
            int readInt = readInt(bArr, 0);
            if (readInt(bArr, 4) != a.bkJ || readInt <= 0) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        Log.printErrStackTrace("MicroMsg.AtomUtil", e3, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(133852);
                return false;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    Log.printErrStackTrace("MicroMsg.AtomUtil", e4, "", new Object[0]);
                }
            }
            AppMethodBeat.o(133852);
            return true;
        } catch (Exception e5) {
            Log.printErrStackTrace("MicroMsg.AtomUtil", e5, "", new Object[0]);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    Log.printErrStackTrace("MicroMsg.AtomUtil", e6, "", new Object[0]);
                }
            }
            AppMethodBeat.o(133852);
            return false;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                    Log.printErrStackTrace("MicroMsg.AtomUtil", e7, "", new Object[0]);
                }
            }
            AppMethodBeat.o(133852);
            throw th;
        }
    }

    public static boolean isNullOrNil(String str) {
        AppMethodBeat.i(133853);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(133853);
            return true;
        }
        AppMethodBeat.o(133853);
        return false;
    }

    public static int bJ(String str) {
        AppMethodBeat.i(133854);
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            i2++;
            i3 = (i3 << 8) | str.charAt(i2);
        }
        AppMethodBeat.o(133854);
        return i3;
    }

    public static int readInt(byte[] bArr, int i2) {
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        return ((bArr[i3] & 255) << 16) | ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 8) | (bArr[i4 + 1] & 255);
    }

    public static long D(byte[] bArr, int i2) {
        AppMethodBeat.i(133855);
        byte[] bArr2 = new byte[8];
        Arrays.fill(bArr2, (byte) 0);
        System.arraycopy(bArr, i2, bArr2, 4, 4);
        long aE = aE(bArr2);
        AppMethodBeat.o(133855);
        return aE;
    }

    public static long aE(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 56) | ((((long) bArr[1]) & 255) << 48) | ((((long) bArr[2]) & 255) << 40) | ((((long) bArr[3]) & 255) << 32) | ((((long) bArr[4]) & 255) << 24) | ((((long) bArr[5]) & 255) << 16) | ((((long) bArr[6]) & 255) << 8) | (((long) bArr[7]) & 255);
    }

    public static a a(RandomAccessFile randomAccessFile, byte[] bArr, int i2) {
        AppMethodBeat.i(133856);
        a aVar = null;
        try {
            int read = randomAccessFile.read(bArr);
            while (true) {
                if (read < 8) {
                    break;
                }
                int readInt = readInt(bArr, 0);
                int readInt2 = readInt(bArr, 4);
                if (readInt2 != i2) {
                    if (readInt2 != a.blk && readInt2 != a.blo) {
                        if (!a(randomAccessFile, (long) (readInt - 8))) {
                            break;
                        }
                        read = randomAccessFile.read(bArr);
                    } else {
                        read = randomAccessFile.read(bArr);
                    }
                } else {
                    aVar = i.f(readInt, readInt2, randomAccessFile.getFilePointer() - ((long) read));
                    break;
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AtomUtil", e2, "", new Object[0]);
            Log.e("MicroMsg.AtomUtil", "find Atom error: " + e2.toString());
        }
        AppMethodBeat.o(133856);
        return aVar;
    }

    public static a b(RandomAccessFile randomAccessFile, byte[] bArr, int i2) {
        a aVar;
        AppMethodBeat.i(208733);
        try {
            int read = randomAccessFile.read(bArr);
            int i3 = read;
            while (true) {
                if (read < 8) {
                    break;
                } else if (4194304 <= 0 || 4194304 > ((long) i3)) {
                    int readInt = readInt(bArr, 0);
                    int readInt2 = readInt(bArr, 4);
                    if (readInt2 == i2) {
                        aVar = i.f(readInt, readInt2, randomAccessFile.getFilePointer() - ((long) read));
                        break;
                    }
                    if (readInt2 != a.blk && readInt2 != a.blo) {
                        if (!a(randomAccessFile, (long) (readInt - 8))) {
                            break;
                        }
                        i3 += readInt - 8;
                        read = randomAccessFile.read(bArr);
                    } else {
                        read = randomAccessFile.read(bArr);
                    }
                    i3 += read;
                } else {
                    AppMethodBeat.o(208733);
                    return null;
                }
            }
            aVar = null;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AtomUtil", e2, "", new Object[0]);
            Log.e("MicroMsg.AtomUtil", "find Atom error: " + e2.toString());
            aVar = null;
        }
        AppMethodBeat.o(208733);
        return aVar;
    }

    public static boolean a(RandomAccessFile randomAccessFile, long j2) {
        AppMethodBeat.i(133857);
        long j3 = 0;
        while (j2 > 2147483647L) {
            j3 += (long) randomAccessFile.skipBytes(Integer.MAX_VALUE);
            j2 -= 2147483647L;
        }
        long skipBytes = j3 + ((long) randomAccessFile.skipBytes((int) j2));
        if (skipBytes != j2) {
            Log.w("MicroMsg.AtomUtil", "can not skip.skip: " + j2 + " trueSkip : " + skipBytes);
            AppMethodBeat.o(133857);
            return false;
        }
        AppMethodBeat.o(133857);
        return true;
    }
}
