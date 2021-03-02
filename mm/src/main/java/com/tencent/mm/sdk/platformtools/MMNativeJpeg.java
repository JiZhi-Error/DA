package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.vfs.s;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class MMNativeJpeg {
    public static final int FAKE_PARTIAL_PROGRESSIVE_QUALITY = 25;
    public static final String TAG = "MMJPEG.JAVA";

    private static String exception2String(Throwable th) {
        AppMethodBeat.i(156193);
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        AppMethodBeat.o(156193);
        return stringWriter2;
    }

    public static void Destroy() {
    }

    private static boolean checkAndroidVersion() {
        AppMethodBeat.i(156194);
        if (Build.VERSION.SDK_INT < 11) {
            Log.i(TAG, "early version before android 3.0  unsupported.");
            AppMethodBeat.o(156194);
            return false;
        }
        AppMethodBeat.o(156194);
        return true;
    }

    private static String toRealPath(String str) {
        AppMethodBeat.i(156195);
        try {
            String k = s.k(str, false);
            if (k != null) {
                Log.i(TAG, "From %s to real path %s", str, k);
                str = k;
            }
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "to real path", new Object[0]);
        }
        AppMethodBeat.o(156195);
        return str;
    }

    public static int queryQuality(String str) {
        AppMethodBeat.i(156196);
        if (!checkAndroidVersion()) {
            AppMethodBeat.o(156196);
            return 0;
        } else if (!s.YS(str)) {
            AppMethodBeat.o(156196);
            return 0;
        } else {
            String realPath = toRealPath(str);
            try {
                int queryQuality = mmjpeg.queryQuality(realPath);
                Log.i(TAG, "after query quality:%d", Integer.valueOf(queryQuality));
                if (queryQuality < 10000 && queryQuality >= 24) {
                    AppMethodBeat.o(156196);
                    return queryQuality;
                } else if (1 == mmjpeg.isProgressiveFile(realPath)) {
                    AppMethodBeat.o(156196);
                    return 25;
                } else {
                    Log.w(TAG, "invalid jpeg file or too small quality.");
                    AppMethodBeat.o(156196);
                    return 0;
                }
            } catch (Exception e2) {
                Log.e(TAG, "queryQuality failed. exception:%s", exception2String(e2));
                AppMethodBeat.o(156196);
                return 0;
            } catch (IncompatibleClassChangeError e3) {
                Log.printErrStackTrace("MicroMsg.Crash", e3, "May cause dvmFindCatchBlock crash!", new Object[0]);
                IncompatibleClassChangeError incompatibleClassChangeError = (IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e3);
                AppMethodBeat.o(156196);
                throw incompatibleClassChangeError;
            } catch (Error e4) {
                Log.e(TAG, "queryQuality error. java.lang.UnsatisfiedLinkError: queryQuality, %s", e4.toString());
                AppMethodBeat.o(156196);
                return 0;
            }
        }
    }

    public static boolean isProgressive(String str) {
        AppMethodBeat.i(156197);
        Log.v(TAG, "isProgressive:%s", str);
        if (!checkAndroidVersion()) {
            AppMethodBeat.o(156197);
            return false;
        } else if (!s.YS(str)) {
            AppMethodBeat.o(156197);
            return false;
        } else {
            String realPath = toRealPath(str);
            Log.d(TAG, "check progressive for file:%s", realPath);
            try {
                int isProgressiveFile = mmjpeg.isProgressiveFile(realPath);
                if (1 == isProgressiveFile || isProgressiveFile == 0) {
                    Log.i(TAG, "file:%s progressive:%d", realPath, Integer.valueOf(isProgressiveFile));
                    if (isProgressiveFile == 1) {
                        AppMethodBeat.o(156197);
                        return true;
                    }
                    AppMethodBeat.o(156197);
                    return false;
                }
                Log.e(TAG, "check failed. error:%d", Integer.valueOf(isProgressiveFile));
                AppMethodBeat.o(156197);
                return false;
            } catch (Exception e2) {
                Log.e(TAG, "isProgressive exception:%s", exception2String(e2));
                AppMethodBeat.o(156197);
                return false;
            }
        }
    }

    public static boolean convertToProgressive(String str, int i2) {
        AppMethodBeat.i(156198);
        if (!checkAndroidVersion()) {
            AppMethodBeat.o(156198);
            return false;
        }
        String realPath = toRealPath(str);
        try {
            String str2 = realPath + ".prog.dat";
            Log.i(TAG, "convert %s to %s use progressive.quality:%d", realPath, str2, Integer.valueOf(i2));
            int convertToProgressive = mmjpeg.convertToProgressive(realPath, str2);
            if (convertToProgressive != 0) {
                Log.e(TAG, "convert failed. error:%d", Integer.valueOf(convertToProgressive));
                AppMethodBeat.o(156198);
                return false;
            }
            boolean nx = s.nx(str2, realPath);
            Log.i(TAG, "convert ret:%b", Boolean.valueOf(nx));
            AppMethodBeat.o(156198);
            return nx;
        } catch (Exception e2) {
            Log.e(TAG, "convertToProgressive exception:%s", exception2String(e2));
            AppMethodBeat.o(156198);
            return false;
        }
    }

    public static Bitmap decodeAsBitmap(String str) {
        AppMethodBeat.i(156199);
        Log.i(TAG, "decodeAsBitmap:%s", str);
        String realPath = toRealPath(str);
        try {
            JpegParams queryParams = mmjpeg.queryParams(realPath);
            if (queryParams == null) {
                Log.e(TAG, "can't query jpeg parames.");
                AppMethodBeat.o(156199);
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(queryParams.Width, queryParams.Height, Bitmap.Config.ARGB_8888);
            if (mmjpeg.decodeToBitmap(realPath, createBitmap)) {
                Log.i(TAG, "decode bitmap successed.");
                AppMethodBeat.o(156199);
                return createBitmap;
            }
            Log.e(TAG, "can't decode to bmp.");
            AppMethodBeat.o(156199);
            return null;
        } catch (Exception e2) {
            Log.e(TAG, "decodeAsBitmap exception:%s", exception2String(e2));
            AppMethodBeat.o(156199);
            return null;
        } catch (OutOfMemoryError e3) {
            Log.e(TAG, "decodeAsBitmap OOM:%s", realPath);
            AppMethodBeat.o(156199);
            return null;
        }
    }

    public static boolean Convert2Baseline(String str, int i2) {
        AppMethodBeat.i(156200);
        if (!isProgressive(str)) {
            Log.e(TAG, "c2b: not progressive file.%s", str);
            AppMethodBeat.o(156200);
            return true;
        }
        OutputStream outputStream = null;
        try {
            Bitmap decodeFile = MMBitmapFactory.decodeFile(str);
            if (decodeFile == null) {
                Log.i(TAG, "c2b:use mmjpeg to decode.");
                decodeFile = decodeAsBitmap(str);
            }
            if (decodeFile != null) {
                String str2 = str + ".base";
                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                outputStream = s.dw(str2, false);
                if (decodeFile.compress(compressFormat, i2, outputStream)) {
                    Log.i(TAG, "c2b: convert baseline %s ok.", str2);
                    boolean copy = FilesCopy.copy(str2, str, true);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    AppMethodBeat.o(156200);
                    return copy;
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e3) {
                }
            }
        } catch (Exception e4) {
            Log.e(TAG, "c2b:exception:%s", exception2String(e4));
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (Exception e5) {
                }
            }
        } catch (OutOfMemoryError e6) {
            Log.e(TAG, "c2b: oom");
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (Exception e7) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (Exception e8) {
                }
            }
            AppMethodBeat.o(156200);
            throw th;
        }
        AppMethodBeat.o(156200);
        return false;
    }

    public static boolean IsJpegFile(String str) {
        AppMethodBeat.i(156201);
        try {
            if (mmjpeg.queryParams(toRealPath(str)) == null) {
                Log.e(TAG, "IsJpegFile : can't query jpeg parames.");
                AppMethodBeat.o(156201);
                return false;
            }
            AppMethodBeat.o(156201);
            return true;
        } catch (Exception e2) {
            Log.e(TAG, "IsJpegFile exception:%s", exception2String(e2));
            AppMethodBeat.o(156201);
            return false;
        }
    }
}
