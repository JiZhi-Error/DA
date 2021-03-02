package com.tencent.youtu.ytcommon.tools;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class YTFileUtils {
    private YTFileUtils() {
        AppMethodBeat.i(73377);
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(73377);
        throw assertionError;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0055 A[SYNTHETIC, Splitter:B:16:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.StringBuilder readAssetFile(android.content.Context r6, java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 131
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.youtu.ytcommon.tools.YTFileUtils.readAssetFile(android.content.Context, java.lang.String):java.lang.StringBuilder");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f A[SYNTHETIC, Splitter:B:20:0x005f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.StringBuilder readFile(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 142
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.youtu.ytcommon.tools.YTFileUtils.readFile(java.lang.String):java.lang.StringBuilder");
    }

    public static boolean copyAsset(AssetManager assetManager, String str, String str2) {
        AppMethodBeat.i(73380);
        try {
            InputStream open = assetManager.open(str);
            new File(str2).createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            copyFile(open, fileOutputStream);
            open.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            AppMethodBeat.o(73380);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(73380);
            return false;
        }
    }

    public static void copyFileOrDir(AssetManager assetManager, String str, String str2) {
        AppMethodBeat.i(73381);
        try {
            String[] list = assetManager.list(str);
            if (list.length == 0) {
                copyAsset(assetManager, str, str2 + FilePathGenerator.ANDROID_DIR_SEP + str);
                AppMethodBeat.o(73381);
                return;
            }
            File file = new File(str2.endsWith(File.separator) ? str2 + str : str2 + File.separator + str);
            if (!file.exists()) {
                file.mkdir();
            }
            for (int i2 = 0; i2 < list.length; i2++) {
                copyFileOrDir(assetManager, str + FilePathGenerator.ANDROID_DIR_SEP + list[i2], str2);
            }
            AppMethodBeat.o(73381);
        } catch (IOException e2) {
            AppMethodBeat.o(73381);
        }
    }

    public static void copyFile(InputStream inputStream, OutputStream outputStream) {
        AppMethodBeat.i(73382);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                AppMethodBeat.o(73382);
                return;
            }
        }
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap;
        AppMethodBeat.i(73383);
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                Bitmap bitmap2 = bitmapDrawable.getBitmap();
                AppMethodBeat.o(73383);
                return bitmap2;
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        AppMethodBeat.o(73383);
        return bitmap;
    }

    public static boolean zipFileAtPath(String str, String str2) {
        AppMethodBeat.i(73384);
        File file = new File(str);
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str2)));
            if (!file.isDirectory()) {
                byte[] bArr = new byte[2048];
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(str), 2048);
                zipOutputStream.putNextEntry(new ZipEntry(getLastPathComponent(str)));
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 2048);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
            } else {
                zipSubFolder(zipOutputStream, file, file.getParent().length());
            }
            zipOutputStream.close();
            AppMethodBeat.o(73384);
            return true;
        } catch (Exception e2) {
            AppMethodBeat.o(73384);
            return false;
        }
    }

    private static void zipSubFolder(ZipOutputStream zipOutputStream, File file, int i2) {
        AppMethodBeat.i(73385);
        File[] listFiles = file.listFiles();
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                zipSubFolder(zipOutputStream, file2, i2);
            } else {
                byte[] bArr = new byte[2048];
                String path = file2.getPath();
                String substring = path.substring(i2);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path), 2048);
                zipOutputStream.putNextEntry(new ZipEntry(substring));
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 2048);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                bufferedInputStream.close();
            }
        }
        AppMethodBeat.o(73385);
    }

    public static String getLastPathComponent(String str) {
        AppMethodBeat.i(73386);
        String[] split = str.split(FilePathGenerator.ANDROID_DIR_SEP);
        if (split.length == 0) {
            AppMethodBeat.o(73386);
            return "";
        }
        String str2 = split[split.length - 1];
        AppMethodBeat.o(73386);
        return str2;
    }
}
