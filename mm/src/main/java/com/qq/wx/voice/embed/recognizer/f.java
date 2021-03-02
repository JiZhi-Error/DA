package com.qq.wx.voice.embed.recognizer;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

final class f {

    /* renamed from: a  reason: collision with root package name */
    private boolean f120a = false;

    /* renamed from: b  reason: collision with root package name */
    String f121b = null;

    f() {
    }

    private static boolean a(String str, String str2) {
        AppMethodBeat.i(76753);
        boolean exists = new File(String.valueOf(str2) + FilePathGenerator.ANDROID_DIR_SEP + str).exists();
        AppMethodBeat.o(76753);
        return exists;
    }

    private static boolean a(String str, String[] strArr) {
        AppMethodBeat.i(76751);
        for (String str2 : strArr) {
            if (str.compareTo(str2) == 0) {
                AppMethodBeat.o(76751);
                return true;
            }
        }
        AppMethodBeat.o(76751);
        return false;
    }

    private static String b(String str, String str2) {
        String str3;
        AppMethodBeat.i(76754);
        File file = new File(String.valueOf(str2) + FilePathGenerator.ANDROID_DIR_SEP + str);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            MappedByteBuffer map = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(map);
            str3 = new BigInteger(1, instance.digest()).toString(16);
            try {
                fileInputStream.close();
            } catch (IOException e2) {
            }
        } catch (Exception e3) {
            try {
                fileInputStream.close();
                str3 = null;
            } catch (IOException e4) {
                str3 = null;
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (IOException e5) {
            }
            AppMethodBeat.o(76754);
            throw th;
        }
        AppMethodBeat.o(76754);
        return str3;
    }

    private static void e(String str, String str2, String str3) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        Throwable th;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream2;
        FileChannel fileChannel3;
        AppMethodBeat.i(76752);
        File file = new File(String.valueOf(str2) + FilePathGenerator.ANDROID_DIR_SEP + str);
        File file2 = new File(String.valueOf(str3) + FilePathGenerator.ANDROID_DIR_SEP + str);
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileChannel3 = fileInputStream.getChannel();
                    try {
                        fileChannel = fileOutputStream.getChannel();
                    } catch (IOException e2) {
                        fileChannel = null;
                        fileOutputStream2 = fileOutputStream;
                        fileInputStream2 = fileInputStream;
                        try {
                            fileInputStream2.close();
                            fileChannel3.close();
                            fileOutputStream2.close();
                            fileChannel.close();
                            AppMethodBeat.o(76752);
                        } catch (IOException e3) {
                            AppMethodBeat.o(76752);
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileChannel = null;
                        fileChannel2 = fileChannel3;
                        try {
                            fileInputStream.close();
                            fileChannel2.close();
                            fileOutputStream.close();
                            fileChannel.close();
                        } catch (IOException e4) {
                        }
                        AppMethodBeat.o(76752);
                        throw th;
                    }
                } catch (IOException e5) {
                    fileChannel = null;
                    fileChannel3 = null;
                    fileOutputStream2 = fileOutputStream;
                    fileInputStream2 = fileInputStream;
                    fileInputStream2.close();
                    fileChannel3.close();
                    fileOutputStream2.close();
                    fileChannel.close();
                    AppMethodBeat.o(76752);
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = null;
                    fileChannel2 = null;
                    fileInputStream.close();
                    fileChannel2.close();
                    fileOutputStream.close();
                    fileChannel.close();
                    AppMethodBeat.o(76752);
                    throw th;
                }
            } catch (IOException e6) {
                fileChannel = null;
                fileChannel3 = null;
                fileOutputStream2 = null;
                fileInputStream2 = fileInputStream;
                fileInputStream2.close();
                fileChannel3.close();
                fileOutputStream2.close();
                fileChannel.close();
                AppMethodBeat.o(76752);
            } catch (Throwable th4) {
                th = th4;
                fileChannel = null;
                fileChannel2 = null;
                fileOutputStream = null;
                fileInputStream.close();
                fileChannel2.close();
                fileOutputStream.close();
                fileChannel.close();
                AppMethodBeat.o(76752);
                throw th;
            }
            try {
                fileChannel3.transferTo(0, fileChannel3.size(), fileChannel);
                try {
                    fileInputStream.close();
                    fileChannel3.close();
                    fileOutputStream.close();
                    fileChannel.close();
                    AppMethodBeat.o(76752);
                } catch (IOException e7) {
                    AppMethodBeat.o(76752);
                }
            } catch (IOException e8) {
                fileOutputStream2 = fileOutputStream;
                fileInputStream2 = fileInputStream;
                fileInputStream2.close();
                fileChannel3.close();
                fileOutputStream2.close();
                fileChannel.close();
                AppMethodBeat.o(76752);
            } catch (Throwable th5) {
                th = th5;
                fileChannel2 = fileChannel3;
                fileInputStream.close();
                fileChannel2.close();
                fileOutputStream.close();
                fileChannel.close();
                AppMethodBeat.o(76752);
                throw th;
            }
        } catch (IOException e9) {
            fileChannel = null;
            fileChannel3 = null;
            fileOutputStream2 = null;
            fileInputStream2 = null;
            fileInputStream2.close();
            fileChannel3.close();
            fileOutputStream2.close();
            fileChannel.close();
            AppMethodBeat.o(76752);
        } catch (Throwable th6) {
            th = th6;
            fileChannel = null;
            fileChannel2 = null;
            fileOutputStream = null;
            fileInputStream = null;
            fileInputStream.close();
            fileChannel2.close();
            fileOutputStream.close();
            fileChannel.close();
            AppMethodBeat.o(76752);
            throw th;
        }
    }

    public final int a(Context context, String str, String str2, String str3) {
        AppMethodBeat.i(76749);
        if (this.f120a) {
            AppMethodBeat.o(76749);
            return 0;
        } else if (!a("libwxvoiceembed.so", str)) {
            AppMethodBeat.o(76749);
            return -201;
        } else if (!a("libwxvoiceembed.bin", str)) {
            AppMethodBeat.o(76749);
            return -202;
        } else {
            String str4 = String.valueOf(context.getFilesDir().getAbsolutePath()) + "/NamesSearch/";
            File file = new File(str4);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!a("libwxvoiceembed.so", str4)) {
                e("libwxvoiceembed.so", str, str4);
            }
            if (!a("libwxvoiceembed.bin", str4)) {
                e("libwxvoiceembed.bin", str, str4);
            }
            try {
                String b2 = b("libwxvoiceembed.so", str4);
                if (b2.compareTo(b("libwxvoiceembed.so", str)) != 0) {
                    e("libwxvoiceembed.so", str, str4);
                }
                if (!a(b2, str2.split(";"))) {
                    AppMethodBeat.o(76749);
                    return -203;
                }
                try {
                    String b3 = b("libwxvoiceembed.bin", str4);
                    if (b3.compareTo(b("libwxvoiceembed.bin", str)) != 0) {
                        e("libwxvoiceembed.bin", str, str4);
                    }
                    if (!a(b3, str3.split(";"))) {
                        AppMethodBeat.o(76749);
                        return -204;
                    }
                    this.f121b = str4;
                    this.f120a = true;
                    AppMethodBeat.o(76749);
                    return 0;
                } catch (FileNotFoundException e2) {
                    AppMethodBeat.o(76749);
                    return -204;
                }
            } catch (FileNotFoundException e3) {
                AppMethodBeat.o(76749);
                return -203;
            }
        }
    }

    public final int d(String str, String str2, String str3) {
        AppMethodBeat.i(76750);
        if (this.f120a) {
            AppMethodBeat.o(76750);
            return 0;
        } else if (!a("libwxvoiceembed.so", str)) {
            AppMethodBeat.o(76750);
            return -201;
        } else if (!a("libwxvoiceembed.bin", str)) {
            AppMethodBeat.o(76750);
            return -202;
        } else {
            try {
                if (!a(b("libwxvoiceembed.so", str), str2.split(";"))) {
                    AppMethodBeat.o(76750);
                    return -203;
                }
                try {
                    if (!a(b("libwxvoiceembed.bin", str), str3.split(";"))) {
                        AppMethodBeat.o(76750);
                        return -204;
                    }
                    this.f121b = str;
                    this.f120a = true;
                    AppMethodBeat.o(76750);
                    return 0;
                } catch (FileNotFoundException e2) {
                    AppMethodBeat.o(76750);
                    return -204;
                }
            } catch (FileNotFoundException e3) {
                AppMethodBeat.o(76750);
                return -203;
            }
        }
    }
}
