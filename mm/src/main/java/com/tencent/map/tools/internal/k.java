package com.tencent.map.tools.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.map.tools.sheet.listener.ModuleEncryptListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class k {

    /* renamed from: a  reason: collision with root package name */
    SimpleDateFormat f1354a = new SimpleDateFormat("HHmmss");

    /* renamed from: b  reason: collision with root package name */
    a f1355b;

    /* renamed from: c  reason: collision with root package name */
    public File f1356c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f1357d = k.class.getSimpleName();

    /* renamed from: e  reason: collision with root package name */
    private ModuleEncryptListener f1358e;

    /* renamed from: f  reason: collision with root package name */
    private Context f1359f;

    /* renamed from: g  reason: collision with root package name */
    private u f1360g;

    /* renamed from: h  reason: collision with root package name */
    private SimpleDateFormat f1361h = new SimpleDateFormat("yyyyMMdd-HHmmss");

    /* renamed from: i  reason: collision with root package name */
    private StringBuilder f1362i;

    /* renamed from: j  reason: collision with root package name */
    private String f1363j = "/d_l";
    private String k;

    public k(Context context, Looper looper, File file, ModuleEncryptListener moduleEncryptListener) {
        AppMethodBeat.i(180814);
        this.f1359f = context;
        this.f1355b = new a(looper);
        this.f1358e = moduleEncryptListener;
        if (file == null) {
            try {
                file = new File(context.getExternalFilesDir("data").getAbsolutePath() + File.separator + a.f1309a + "_" + this.f1363j);
            } catch (Throwable th) {
                file = null;
            }
        }
        this.f1356c = file;
        this.k = "d_";
        this.f1360g = new u(this.f1359f, file, "d");
        a();
        q.a(this.f1355b, (int) ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, 15000);
        q.a(this.f1355b, (int) ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL, (long) Util.MILLSECONDS_OF_MINUTE);
        AppMethodBeat.o(180814);
    }

    public final void a() {
        AppMethodBeat.i(180815);
        q.a(this.f1355b, 10001, b());
        AppMethodBeat.o(180815);
    }

    private String b() {
        AppMethodBeat.i(180816);
        StringBuilder sb = new StringBuilder();
        sb.append("LOC_CORE,").append(this.f1361h.format(new Date())).append(',').append(x.c(this.f1359f)).append(',').append(',').append(',').append("MapSDK_COMP,").append(a.f1310b).append(".").append(a.f1311c).append(',').append(a.f1313e).append(',').append(a.f1314f).append("$");
        String sb2 = sb.toString();
        AppMethodBeat.o(180816);
        return sb2;
    }

    /* access modifiers changed from: package-private */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
            AppMethodBeat.i(180809);
            k.this.f1362i = new StringBuilder(1024);
            AppMethodBeat.o(180809);
        }

        public final void handleMessage(Message message) {
            File[] listFiles;
            AppMethodBeat.i(180810);
            super.handleMessage(message);
            switch (message.what) {
                case 10001:
                    k.this.f1362i.append((String) message.obj).append("$");
                    if (((long) k.this.f1362i.length()) > 20480) {
                        q.a(k.this.f1355b, (int) ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, 0);
                        AppMethodBeat.o(180810);
                        return;
                    }
                    k.this.f1360g.a(k.this.f1362i.toString().getBytes());
                    AppMethodBeat.o(180810);
                    return;
                case ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL /*{ENCODED_INT: 10003}*/:
                    if (k.this.f1362i != null) {
                        a(k.this.f1362i.toString().getBytes());
                        k.this.f1362i.setLength(0);
                        k.this.a();
                        AppMethodBeat.o(180810);
                        return;
                    }
                    break;
                case ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL /*{ENCODED_INT: 10004}*/:
                    File file = k.this.f1356c;
                    if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            if (file2.exists() && file2.getName().startsWith(k.this.k)) {
                                byte[] a2 = a(file2);
                                if (a2 == null || a2.length <= 0) {
                                    if (a2 != null && a2.length == 0) {
                                        file2.delete();
                                    }
                                } else if (r.a(a.k, a2) != null) {
                                    file2.delete();
                                }
                            }
                        }
                    }
                    q.a(k.this.f1355b, (int) ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL, (long) Util.MILLSECONDS_OF_MINUTE);
                    break;
            }
            AppMethodBeat.o(180810);
        }

        public final boolean a(byte[] bArr) {
            AppMethodBeat.i(180811);
            if (bArr != null) {
                try {
                    if (bArr.length != 0) {
                        if (k.this.f1358e != null) {
                            bArr = k.this.f1358e.enCryptModleData(bArr);
                        }
                        if (bArr == null || bArr.length == 0) {
                            AppMethodBeat.o(180811);
                            return true;
                        }
                        if (r.a(a.k, bArr) == null) {
                            k.this.f1360g.a(bArr);
                        }
                        AppMethodBeat.o(180811);
                        return false;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(180811);
                    return false;
                }
            }
            AppMethodBeat.o(180811);
            return true;
        }

        private static byte[] a(File file) {
            BufferedInputStream bufferedInputStream;
            BufferedInputStream bufferedInputStream2;
            Throwable th;
            AppMethodBeat.i(180812);
            if (!file.exists() || file.length() == 0) {
                byte[] bArr = new byte[0];
                AppMethodBeat.o(180812);
                return bArr;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[4096];
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr2);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            a(bufferedInputStream);
                            a(byteArrayOutputStream);
                            AppMethodBeat.o(180812);
                            return byteArray;
                        }
                    } catch (Throwable th2) {
                        try {
                            byte[] bArr3 = new byte[0];
                            a(bufferedInputStream);
                            a(byteArrayOutputStream);
                            AppMethodBeat.o(180812);
                            return bArr3;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedInputStream2 = bufferedInputStream;
                            a(bufferedInputStream2);
                            a(byteArrayOutputStream);
                            AppMethodBeat.o(180812);
                            throw th;
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream2 = null;
                a(bufferedInputStream2);
                a(byteArrayOutputStream);
                AppMethodBeat.o(180812);
                throw th;
            }
        }

        private static void a(Closeable closeable) {
            AppMethodBeat.i(180813);
            if (closeable != null) {
                try {
                    closeable.close();
                    AppMethodBeat.o(180813);
                    return;
                } catch (Throwable th) {
                }
            }
            AppMethodBeat.o(180813);
        }
    }
}
