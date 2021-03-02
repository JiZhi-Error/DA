package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Context f1496a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f1497b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f1498c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f1499d;

    /* renamed from: e  reason: collision with root package name */
    public static ThreadPoolExecutor f1500e = new ThreadPoolExecutor(f1498c, f1499d, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    static {
        AppMethodBeat.i(190351);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f1497b = availableProcessors;
        f1498c = availableProcessors + 1;
        f1499d = (availableProcessors * 2) + 1;
        AppMethodBeat.o(190351);
    }

    public static int a(ContentResolver contentResolver, Uri uri) {
        int i2 = 0;
        AppMethodBeat.i(190350);
        Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
            AppMethodBeat.o(190350);
        } else {
            InputStream inputStream = null;
            try {
                InputStream openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    AppMethodBeat.o(190350);
                } else {
                    i2 = openInputStream.available();
                    try {
                        openInputStream.close();
                    } catch (IOException e3) {
                    }
                    AppMethodBeat.o(190350);
                }
            } catch (Exception e4) {
                Log.w("MicroMsg.SDK.Util", "getFileSize fail, " + e4.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
                AppMethodBeat.o(190350);
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                    }
                }
                AppMethodBeat.o(190350);
                throw th;
            }
        }
        return i2;
    }

    public static int a(String str) {
        AppMethodBeat.i(190349);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(190349);
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            int length = (int) file.length();
            AppMethodBeat.o(190349);
            return length;
        } else if (f1496a == null || !str.startsWith("content")) {
            AppMethodBeat.o(190349);
            return 0;
        } else {
            try {
                int a2 = a(f1496a.getContentResolver(), Uri.parse(str));
                AppMethodBeat.o(190349);
                return a2;
            } catch (Exception e2) {
                AppMethodBeat.o(190349);
                return 0;
            }
        }
    }

    public static int a(String str, int i2) {
        AppMethodBeat.i(190348);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i2 = Integer.parseInt(str);
                }
            } catch (Exception e2) {
                AppMethodBeat.o(190348);
            }
        }
        AppMethodBeat.o(190348);
        return i2;
    }

    public static boolean a(int i2) {
        return i2 == 36 || i2 == 46;
    }

    public static boolean b(String str) {
        AppMethodBeat.i(190347);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(190347);
            return true;
        }
        AppMethodBeat.o(190347);
        return false;
    }
}
