package com.tencent.tav.core.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

class EncoderUtils {
    private static final int FREQ_IDX = 4;
    public static final int INDEX_START = 1;
    private static final int PROFILE = 2;

    EncoderUtils() {
    }

    public static void addADTStoPacket(byte[] bArr, int i2) {
        AppMethodBeat.i(218006);
        byte[] generateADTSHeader = generateADTSHeader(bArr.length, i2);
        System.arraycopy(generateADTSHeader, 0, bArr, 0, generateADTSHeader.length);
        AppMethodBeat.o(218006);
    }

    public static byte[] generateADTSHeader(int i2, int i3) {
        return new byte[]{-1, -7, (byte) ((i3 >> 2) + 80), (byte) (((i3 & 3) << 6) + (i2 >> 11)), (byte) ((i2 & 2047) >> 3), (byte) (((i2 & 7) << 5) + 31), -4};
    }

    static String getAudioOutSaveFilePath(String str, int i2, String str2) {
        AppMethodBeat.i(218007);
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf > 0) {
            String str3 = str.substring(0, lastIndexOf) + "_" + str2 + "_" + i2 + str.substring(lastIndexOf);
            AppMethodBeat.o(218007);
            return str3;
        }
        String str4 = str + "_" + str2 + "_" + i2;
        AppMethodBeat.o(218007);
        return str4;
    }

    static boolean mergeAllFiles(String str, int i2, String str2) {
        AppMethodBeat.i(218008);
        Logger.d("EncoderUtils", "mergeAllFiles " + i2 + " sessionId = " + str2);
        try {
            File file = new File(str);
            file.delete();
            if (isValidFile(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                for (int i3 = 1; i3 <= i2; i3++) {
                    randomAccessFile.write(readFromFile(getAudioOutSaveFilePath(str, i3, str2)));
                }
                close(randomAccessFile);
                AppMethodBeat.o(218008);
                return true;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(218008);
        return false;
    }

    static void deleteAllTmpFiles(String str, int i2, String str2) {
        AppMethodBeat.i(218009);
        Logger.d("EncoderUtils", "deleteAllTmpFiles " + i2 + " sessionId = " + str2);
        for (int i3 = 1; i3 <= i2; i3++) {
            File file = new File(getAudioOutSaveFilePath(str, i3, str2));
            Logger.d("EncoderUtils", "delete file " + file.getAbsolutePath() + " deleteResult = " + file.delete());
        }
        AppMethodBeat.o(218009);
    }

    private static boolean isValidFile(File file) {
        AppMethodBeat.i(218010);
        if (file.createNewFile() || (file.exists() && file.isFile())) {
            AppMethodBeat.o(218010);
            return true;
        }
        AppMethodBeat.o(218010);
        return false;
    }

    private static byte[] readFromFile(String str) {
        AppMethodBeat.i(218011);
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            return bArr;
        } finally {
            close(fileInputStream);
            AppMethodBeat.o(218011);
        }
    }

    public static void close(Closeable closeable) {
        AppMethodBeat.i(218012);
        if (closeable == null) {
            AppMethodBeat.o(218012);
            return;
        }
        try {
            closeable.close();
            AppMethodBeat.o(218012);
        } catch (Throwable th) {
            AppMethodBeat.o(218012);
        }
    }
}
