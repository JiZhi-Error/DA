package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ImgUtil {
    private static final int MAX_CHECK_IMG_SIZE = 64;
    private static final String TAG = "MicroMsg.ImgUtil";

    public static boolean isImgFile(String str) {
        boolean z = true;
        AppMethodBeat.i(156181);
        if (str == null || str.length() == 0) {
            Log.e(TAG, "isImgFile, invalid argument");
            AppMethodBeat.o(156181);
            return false;
        } else if (str.length() < 3) {
            AppMethodBeat.o(156181);
            return false;
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                if (!s.YS(str)) {
                    return false;
                }
                InputStream openRead = s.openRead(str);
                MMBitmapFactory.decodeStream(openRead, null, options);
                if (options.outWidth <= 0 || options.outHeight <= 0) {
                    z = false;
                }
                Util.qualityClose(openRead);
                AppMethodBeat.o(156181);
                return z;
            } catch (Throwable th) {
                Log.printErrStackTrace(TAG, th, "unexpected exception.", new Object[0]);
                return false;
            } finally {
                Util.qualityClose(null);
                AppMethodBeat.o(156181);
            }
        }
    }

    private static int getMaxSampleRateFromFile(String str) {
        AppMethodBeat.i(215366);
        InputStream inputStream = null;
        try {
            InputStream openRead = s.openRead(str);
            int[] imgWdithAndHeightFromStream = getImgWdithAndHeightFromStream(openRead);
            if (imgWdithAndHeightFromStream == null || imgWdithAndHeightFromStream.length < 2) {
                Log.w(TAG, "hy: can not get size from file");
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.o(215366);
                return 1;
            }
            int i2 = imgWdithAndHeightFromStream[0];
            int i3 = imgWdithAndHeightFromStream[1];
            Log.d(TAG, "hy: decoded file: %s size: width: %d, height: %d", str, Integer.valueOf(i2), Integer.valueOf(i3));
            int sampleRate = getSampleRate(i2, i3);
            Log.d(TAG, "hy: sample rate: %d", Integer.valueOf(sampleRate));
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.o(215366);
            return sampleRate;
        } catch (FileNotFoundException e4) {
            Log.printErrStackTrace(TAG, e4, "hy: exception in getMaxSampleRateFromFile", new Object[0]);
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(215366);
            return 1;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(215366);
            throw th;
        }
    }

    public static boolean isGif(byte[] bArr) {
        AppMethodBeat.i(156182);
        if (bArr == null) {
            AppMethodBeat.o(156182);
            return false;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        String str = "";
        for (int i2 = 0; i2 < 6; i2++) {
            try {
                str = str + ((char) byteArrayInputStream.read());
            } catch (IOException e2) {
                AppMethodBeat.o(156182);
                return false;
            }
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e3) {
        }
        if (!str.startsWith("GIF")) {
            AppMethodBeat.o(156182);
            return false;
        }
        AppMethodBeat.o(156182);
        return true;
    }

    public static boolean isGif(String str) {
        AppMethodBeat.i(156183);
        InputStream inputStream = null;
        try {
            InputStream openRead = s.openRead(str);
            byte[] bArr = new byte[6];
            String str2 = "";
            openRead.read(bArr);
            for (int i2 = 0; i2 < 6; i2++) {
                str2 = str2 + ((char) bArr[i2]);
            }
            if (!str2.startsWith("GIF")) {
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.o(156183);
                return false;
            }
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.o(156183);
            return true;
        } catch (Exception e4) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(156183);
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(156183);
            throw th;
        }
    }

    public static boolean isGif(Context context, int i2) {
        AppMethodBeat.i(156184);
        try {
            InputStream openRawResource = context.getResources().openRawResource(i2);
            String str = "";
            for (int i3 = 0; i3 < 6; i3++) {
                try {
                    str = str + ((char) openRawResource.read());
                } catch (IOException e2) {
                    AppMethodBeat.o(156184);
                    return false;
                }
            }
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e3) {
                }
            }
            if (!str.startsWith("GIF")) {
                AppMethodBeat.o(156184);
                return false;
            }
            AppMethodBeat.o(156184);
            return true;
        } catch (Exception e4) {
            AppMethodBeat.o(156184);
            return false;
        }
    }

    public static boolean isImageFile(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return false;
        }
        if (bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71) {
            return true;
        }
        if (bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
            return true;
        }
        if (bArr[6] == 74 && bArr[7] == 70 && bArr[8] == 73 && bArr[9] == 70) {
            return true;
        }
        return bArr[0] == 119 && bArr[1] == 120 && bArr[2] == 103 && bArr[3] == 102;
    }

    public static boolean isWXGF(String str) {
        AppMethodBeat.i(156185);
        InputStream inputStream = null;
        try {
            InputStream openRead = s.openRead(str);
            byte[] bArr = new byte[8];
            String str2 = "";
            openRead.read(bArr);
            for (int i2 = 0; i2 < 8; i2++) {
                str2 = str2 + ((char) bArr[i2]);
            }
            if (!str2.startsWith("wxgf")) {
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (IOException e2) {
                    }
                }
                AppMethodBeat.o(156185);
                return false;
            }
            if (openRead != null) {
                try {
                    openRead.close();
                } catch (IOException e3) {
                }
            }
            AppMethodBeat.o(156185);
            return true;
        } catch (Exception e4) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(156185);
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(156185);
            throw th;
        }
    }

    public static boolean isWXGF(byte[] bArr) {
        AppMethodBeat.i(156186);
        if (bArr == null) {
            AppMethodBeat.o(156186);
            return false;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        String str = "";
        for (int i2 = 0; i2 < 8; i2++) {
            try {
                str = str + ((char) byteArrayInputStream.read());
            } catch (IOException e2) {
                AppMethodBeat.o(156186);
                return false;
            }
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException e3) {
        }
        if (!str.startsWith("wxgf")) {
            AppMethodBeat.o(156186);
            return false;
        }
        AppMethodBeat.o(156186);
        return true;
    }

    public static int[] getImgWdithAndHeightFromStream(InputStream inputStream) {
        AppMethodBeat.i(215367);
        if (inputStream == null) {
            Log.w(TAG, "hy: the input stream is null");
            AppMethodBeat.o(215367);
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeStream(inputStream, null, options);
        int[] iArr = {options.outWidth, options.outHeight};
        AppMethodBeat.o(215367);
        return iArr;
    }

    private static int getSampleRate(int i2, int i3) {
        AppMethodBeat.i(215368);
        int max = Math.max(i2, i3);
        int i4 = 1;
        while (max > 64) {
            i4 *= 2;
            max /= i4;
        }
        AppMethodBeat.o(215368);
        return i4;
    }

    public static String identifyImgType(String str) {
        AppMethodBeat.i(156188);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(156188);
            return "";
        }
        String identifyImgType = identifyImgType(s.aW(str, 0, 2));
        AppMethodBeat.o(156188);
        return identifyImgType;
    }

    public static String identifyImgType(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            return "";
        }
        byte b2 = bArr[0];
        int i2 = b2;
        if (b2 < 0) {
            i2 = b2 + 256;
        }
        byte b3 = bArr[1];
        int i3 = b3;
        if (b3 < 0) {
            i3 = b3 + 256;
        }
        if (i2 == 66 && i3 == 77) {
            return ".bmp";
        }
        if (i2 == 255 && i3 == 216) {
            return ".jpg";
        }
        if (i2 == 137 && i3 == 80) {
            return ".png";
        }
        if (i2 == 71 && i3 == 73) {
            return ".gif";
        }
        return ".jpg";
    }
}
