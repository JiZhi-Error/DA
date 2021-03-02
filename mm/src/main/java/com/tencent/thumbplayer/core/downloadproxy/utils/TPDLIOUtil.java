package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TPDLIOUtil {
    private static final String FILE_NAME = "TPDLIOUtil";
    private static Pattern PATH_PATTERN = Pattern.compile("^(\\w+):/{2,3}(.*)");
    private static final String PROTOCOL_ASSET = "asset";
    private static final String PROTOCOL_FILE = "file";
    private static final String PROTOCOL_HTTP = "http";
    private static final String PROTOCOL_HTTPS = "https";
    private static Pattern PROTOCOL_PATTERN = Pattern.compile("^(\\w+):/{2,3}");

    static {
        AppMethodBeat.i(210152);
        AppMethodBeat.o(210152);
    }

    public static boolean isRemoteFile(String str) {
        AppMethodBeat.i(210134);
        String protocol = getProtocol(str);
        if (protocol.equals(PROTOCOL_HTTPS) || protocol.equals(PROTOCOL_HTTP)) {
            AppMethodBeat.o(210134);
            return true;
        }
        AppMethodBeat.o(210134);
        return false;
    }

    public static String getProtocol(String str) {
        AppMethodBeat.i(210135);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(210135);
            return PROTOCOL_FILE;
        }
        Matcher matcher = PROTOCOL_PATTERN.matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            AppMethodBeat.o(210135);
            return group;
        }
        AppMethodBeat.o(210135);
        return PROTOCOL_FILE;
    }

    public static InputStream open(Context context, String str) {
        AppMethodBeat.i(210136);
        String protocol = getProtocol(str);
        if (protocol.equals(PROTOCOL_ASSET)) {
            try {
                InputStream open = context.getAssets().open(getPath(str));
                AppMethodBeat.o(210136);
                return open;
            } catch (IOException e2) {
                AppMethodBeat.o(210136);
                return null;
            }
        } else if (protocol.equals(PROTOCOL_FILE)) {
            try {
                FileInputStream fileInputStream = new FileInputStream(getPath(str));
                AppMethodBeat.o(210136);
                return fileInputStream;
            } catch (Exception e3) {
                AppMethodBeat.o(210136);
                return null;
            }
        } else if (protocol.equals(PROTOCOL_HTTP) || protocol.equals(PROTOCOL_HTTPS)) {
            try {
                InputStream openStream = new URL(str).openStream();
                AppMethodBeat.o(210136);
                return openStream;
            } catch (Exception e4) {
                AppMethodBeat.o(210136);
                return null;
            }
        } else {
            AppMethodBeat.o(210136);
            return null;
        }
    }

    public static String getPath(String str) {
        AppMethodBeat.i(210137);
        if (str == null) {
            AppMethodBeat.o(210137);
            return null;
        }
        Matcher matcher = PATH_PATTERN.matcher(str);
        if (!matcher.find() || !matcher.group(1).equals(PROTOCOL_ASSET)) {
            AppMethodBeat.o(210137);
            return str;
        }
        String group = matcher.group(2);
        AppMethodBeat.o(210137);
        return group;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b A[SYNTHETIC, Splitter:B:32:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0096 A[SYNTHETIC, Splitter:B:40:0x0096] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean write(java.io.File r8, byte[] r9, int r10, int r11) {
        /*
        // Method dump skipped, instructions count: 194
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.downloadproxy.utils.TPDLIOUtil.write(java.io.File, byte[], int, int):boolean");
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) {
        int i2 = 0;
        AppMethodBeat.i(210139);
        if (inputStream == null || outputStream == null) {
            AppMethodBeat.o(210139);
        } else {
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    i2 += read;
                } catch (IOException e2) {
                }
            }
            AppMethodBeat.o(210139);
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0057 A[SYNTHETIC, Splitter:B:32:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005c A[SYNTHETIC, Splitter:B:35:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0068 A[SYNTHETIC, Splitter:B:41:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006d A[SYNTHETIC, Splitter:B:44:0x006d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int copy(java.io.File r5, java.io.File r6) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.downloadproxy.utils.TPDLIOUtil.copy(java.io.File, java.io.File):int");
    }

    public static OutputStream openOutputStream(String str) {
        AppMethodBeat.i(210141);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(210141);
            return null;
        }
        OutputStream openOutputStream = openOutputStream(new File(str));
        AppMethodBeat.o(210141);
        return openOutputStream;
    }

    public static OutputStream openOutputStream(File file) {
        AppMethodBeat.i(210142);
        if (file == null || !createFile(file)) {
            AppMethodBeat.o(210142);
            return null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            AppMethodBeat.o(210142);
            return fileOutputStream;
        } catch (FileNotFoundException e2) {
            AppMethodBeat.o(210142);
            return null;
        }
    }

    public static InputStream openInputStream(String str) {
        AppMethodBeat.i(210143);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(210143);
            return null;
        }
        InputStream openInputStream = openInputStream(new File(str));
        AppMethodBeat.o(210143);
        return openInputStream;
    }

    public static InputStream openInputStream(File file) {
        AppMethodBeat.i(210144);
        if (file == null) {
            AppMethodBeat.o(210144);
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            AppMethodBeat.o(210144);
            return fileInputStream;
        } catch (FileNotFoundException e2) {
            AppMethodBeat.o(210144);
            return null;
        }
    }

    public static boolean createParentDirectories(File file) {
        AppMethodBeat.i(210145);
        if (file == null) {
            AppMethodBeat.o(210145);
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists()) {
            AppMethodBeat.o(210145);
            return true;
        }
        boolean mkdirs = parentFile.mkdirs();
        AppMethodBeat.o(210145);
        return mkdirs;
    }

    public static boolean createParentDirectories(String str) {
        AppMethodBeat.i(210146);
        boolean createParentDirectories = createParentDirectories(new File(str));
        AppMethodBeat.o(210146);
        return createParentDirectories;
    }

    public static boolean createFile(File file) {
        AppMethodBeat.i(210147);
        if (file == null) {
            AppMethodBeat.o(210147);
            return false;
        } else if (file.exists()) {
            AppMethodBeat.o(210147);
            return true;
        } else if (!createParentDirectories(file)) {
            AppMethodBeat.o(210147);
            return false;
        } else {
            try {
                boolean createNewFile = file.createNewFile();
                AppMethodBeat.o(210147);
                return createNewFile;
            } catch (IOException e2) {
                AppMethodBeat.o(210147);
                return false;
            }
        }
    }

    public static boolean createFile(String str) {
        AppMethodBeat.i(210148);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(210148);
            return false;
        }
        boolean createFile = createFile(new File(str));
        AppMethodBeat.o(210148);
        return createFile;
    }

    public static File compare(File file, File file2) {
        AppMethodBeat.i(210149);
        if (file == null) {
            AppMethodBeat.o(210149);
            return file2;
        } else if (file2 == null || !file2.exists()) {
            AppMethodBeat.o(210149);
            return file;
        } else if (!file.exists()) {
            AppMethodBeat.o(210149);
            return file2;
        } else if (file.lastModified() > file2.lastModified()) {
            AppMethodBeat.o(210149);
            return file;
        } else {
            AppMethodBeat.o(210149);
            return file2;
        }
    }

    public static void recursiveDelete(File file) {
        AppMethodBeat.i(210150);
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null) {
                            AppMethodBeat.o(210150);
                            return;
                        }
                        for (File file2 : listFiles) {
                            recursiveDelete(file2);
                        }
                    }
                    TPDLProxyLog.d(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "recursiveDelete: delete=".concat(String.valueOf(file.delete())));
                }
            } catch (Exception e2) {
                TPDLProxyLog.d(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "recursiveDelete failed, error:" + e2.toString());
                AppMethodBeat.o(210150);
                return;
            }
        }
        AppMethodBeat.o(210150);
    }

    public static boolean isExternalStorageMounted() {
        AppMethodBeat.i(210151);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        AppMethodBeat.o(210151);
        return equals;
    }
}
