package com.tencent.tbs.one.impl.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class c {
    public static InputStream a(Context context, String str, String str2) {
        AppMethodBeat.i(173916);
        if (a(str2)) {
            InputStream open = context.getResources().getAssets().open(b(str2));
            AppMethodBeat.o(173916);
            return open;
        } else if (new File(str2).isAbsolute()) {
            FileInputStream fileInputStream = new FileInputStream(str2);
            AppMethodBeat.o(173916);
            return fileInputStream;
        } else {
            String absolutePath = new File(str, str2).getAbsolutePath();
            if (a(absolutePath)) {
                InputStream open2 = context.getResources().getAssets().open(b(absolutePath));
                AppMethodBeat.o(173916);
                return open2;
            }
            FileInputStream fileInputStream2 = new FileInputStream(absolutePath);
            AppMethodBeat.o(173916);
            return fileInputStream2;
        }
    }

    public static String a(InputStream inputStream, String str) {
        AppMethodBeat.i(173907);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        String str2 = new String(byteArrayOutputStream.toByteArray(), str);
        AppMethodBeat.o(173907);
        return str2;
    }

    public static String a(InputStream inputStream, String str, File file) {
        h hVar;
        Throwable th;
        AppMethodBeat.i(173908);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        File file2 = new File(file.getPath() + ".tmp");
        try {
            hVar = new h(new OutputStream[]{byteArrayOutputStream, new FileOutputStream(file2)});
            try {
                a(inputStream, hVar);
                a(hVar);
                if (!file2.renameTo(file)) {
                    IOException iOException = new IOException();
                    AppMethodBeat.o(173908);
                    throw iOException;
                }
                String str2 = new String(byteArrayOutputStream.toByteArray(), str);
                AppMethodBeat.o(173908);
                return str2;
            } catch (Throwable th2) {
                th = th2;
                a(hVar);
                AppMethodBeat.o(173908);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            hVar = null;
            a(hVar);
            AppMethodBeat.o(173908);
            throw th;
        }
    }

    public static void a(Closeable closeable) {
        AppMethodBeat.i(173904);
        if (closeable == null) {
            AppMethodBeat.o(173904);
            return;
        }
        try {
            closeable.close();
            AppMethodBeat.o(173904);
        } catch (IOException e2) {
            f.c("Failed to close %s", closeable, e2);
            AppMethodBeat.o(173904);
        }
    }

    public static void a(File file, File file2) {
        FileChannel fileChannel;
        Throwable th;
        FileChannel fileChannel2;
        AppMethodBeat.i(173909);
        try {
            fileChannel2 = new FileInputStream(file).getChannel();
            try {
                FileChannel channel = new FileOutputStream(file2).getChannel();
                try {
                    channel.transferFrom(fileChannel2, 0, fileChannel2.size());
                    a(fileChannel2);
                    a(channel);
                    AppMethodBeat.o(173909);
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = channel;
                    a(fileChannel2);
                    a(fileChannel);
                    AppMethodBeat.o(173909);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
                a(fileChannel2);
                a(fileChannel);
                AppMethodBeat.o(173909);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileChannel = null;
            fileChannel2 = null;
            a(fileChannel2);
            a(fileChannel);
            AppMethodBeat.o(173909);
            throw th;
        }
    }

    public static void a(InputStream inputStream, File file, File file2) {
        ZipOutputStream zipOutputStream;
        ZipInputStream zipInputStream;
        h hVar;
        AppMethodBeat.i(188000);
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
            if (file2 != null) {
                try {
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                } catch (Throwable th) {
                    th = th;
                    zipOutputStream = null;
                }
            } else {
                zipOutputStream = null;
            }
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        File file3 = new File(file, nextEntry.getName());
                        if (!nextEntry.isDirectory()) {
                            File parentFile = file3.getParentFile();
                            if (parentFile.exists() || parentFile.mkdirs()) {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                                if (zipOutputStream != null) {
                                    hVar = new h(new OutputStream[]{bufferedOutputStream, zipOutputStream});
                                    zipOutputStream.putNextEntry(nextEntry);
                                } else {
                                    hVar = new h(new OutputStream[]{bufferedOutputStream});
                                }
                                a(zipInputStream, hVar);
                                bufferedOutputStream.close();
                                if (zipOutputStream != null) {
                                    zipOutputStream.closeEntry();
                                }
                            } else {
                                IOException iOException = new IOException("Failed to create directory " + parentFile.getAbsolutePath());
                                AppMethodBeat.o(188000);
                                throw iOException;
                            }
                        } else if (!file3.exists() && !file3.mkdirs()) {
                            IOException iOException2 = new IOException("Failed to create directory " + file3.getAbsolutePath());
                            AppMethodBeat.o(188000);
                            throw iOException2;
                        }
                        zipInputStream.closeEntry();
                    } else {
                        do {
                        } while (inputStream.read(new byte[8192]) != -1);
                        a(zipInputStream);
                        a(zipOutputStream);
                        AppMethodBeat.o(188000);
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    a(zipInputStream);
                    a(zipOutputStream);
                    AppMethodBeat.o(188000);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
            zipInputStream = null;
            a(zipInputStream);
            a(zipOutputStream);
            AppMethodBeat.o(188000);
            throw th;
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(173906);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                AppMethodBeat.o(173906);
                return;
            }
        }
    }

    public static void a(String str, String str2, File file) {
        FileOutputStream fileOutputStream;
        Throwable th;
        AppMethodBeat.i(173913);
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(str.getBytes(str2));
                a(fileOutputStream);
                AppMethodBeat.o(173913);
            } catch (Throwable th2) {
                th = th2;
                a(fileOutputStream);
                AppMethodBeat.o(173913);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            a(fileOutputStream);
            AppMethodBeat.o(173913);
            throw th;
        }
    }

    public static boolean a(File file) {
        File[] listFiles;
        AppMethodBeat.i(173905);
        try {
            if (!file.exists()) {
                AppMethodBeat.o(173905);
                return true;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    a(file2);
                }
            }
            boolean delete = file.delete();
            AppMethodBeat.o(173905);
            return delete;
        } catch (Exception e2) {
            f.c("recursivelyDeleteFile failed,current file is %s,exception is %s", file.getAbsolutePath(), Log.getStackTraceString(e2));
            AppMethodBeat.o(173905);
            return false;
        }
    }

    private static boolean a(String str) {
        AppMethodBeat.i(173914);
        if (TextUtils.isEmpty(str) || (!str.startsWith("/android_asset/") && !str.startsWith("file:///android_asset/"))) {
            AppMethodBeat.o(173914);
            return false;
        }
        AppMethodBeat.o(173914);
        return true;
    }

    private static String b(String str) {
        AppMethodBeat.i(173915);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(173915);
            return null;
        } else if (str.startsWith("/android_asset/")) {
            String substring = str.substring(15);
            AppMethodBeat.o(173915);
            return substring;
        } else if (str.startsWith("file:///android_asset/")) {
            String substring2 = str.substring(22);
            AppMethodBeat.o(173915);
            return substring2;
        } else {
            AppMethodBeat.o(173915);
            return null;
        }
    }

    public static void b(File file) {
        AppMethodBeat.i(173917);
        try {
            if (!file.createNewFile()) {
                f.c("Failed to create file %s, file already exists", file.getAbsolutePath());
            }
            AppMethodBeat.o(173917);
        } catch (IOException e2) {
            f.c("Failed to create file %s", file.getAbsolutePath(), e2);
            AppMethodBeat.o(173917);
        }
    }

    public static void b(File file, File file2) {
        AppMethodBeat.i(173910);
        if (!file.isDirectory()) {
            if (file.canRead()) {
                a(file, file2);
            }
            AppMethodBeat.o(173910);
        } else if (file2.exists() || file2.mkdirs()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file3 : listFiles) {
                    b(file3, new File(file2, file3.getName()));
                }
            }
            AppMethodBeat.o(173910);
        } else {
            IOException iOException = new IOException("Failed to create directory " + file2.getAbsolutePath());
            AppMethodBeat.o(173910);
            throw iOException;
        }
    }

    public static void c(File file) {
        AppMethodBeat.i(173918);
        if (!a(file)) {
            f.c("Failed to delete file %s", file.getAbsolutePath());
        }
        AppMethodBeat.o(173918);
    }

    public static void c(File file, File file2) {
        AppMethodBeat.i(173911);
        if (!file.renameTo(file2)) {
            b(file, file2);
            a(file);
        }
        AppMethodBeat.o(173911);
    }

    public static void d(File file) {
        AppMethodBeat.i(173919);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                f.c("Failed to create non-exist directory %s", file.getAbsolutePath());
                AppMethodBeat.o(173919);
                return;
            }
        } else if (!file.isDirectory() && (!file.delete() || !file.mkdirs())) {
            f.c("Failed to create namesake directory %s", file.getAbsolutePath());
        }
        AppMethodBeat.o(173919);
    }
}
