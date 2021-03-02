package com.tencent.tav.report;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AudioBufferPrintHelper {
    public static final boolean CLEAR_MODE = false;
    public static final boolean ENABLE = false;
    public static final String SDCARD_TAVKIT_DEMO_INFO = "/sdcard/tavkit_demo/info/";
    private static final String TAG = "DebugUtils";
    private boolean enable = false;
    private List<String> list = new ArrayList();
    private int maxPrintCount = 0;
    private long startIndex = 0;
    private String startName = "";
    private long startTimeMs = 0;
    private long waitMs;

    public AudioBufferPrintHelper() {
        AppMethodBeat.i(218704);
        AppMethodBeat.o(218704);
    }

    public static AudioBufferPrintHelper getInstance() {
        AppMethodBeat.i(218705);
        AudioBufferPrintHelper audioBufferPrintHelper = Instance.INSTANCE;
        AppMethodBeat.o(218705);
        return audioBufferPrintHelper;
    }

    public static void reset() {
        AppMethodBeat.i(218706);
        AudioBufferPrintHelper unused = Instance.INSTANCE = new AudioBufferPrintHelper();
        AppMethodBeat.o(218706);
    }

    public static ByteBuffer clone(ByteBuffer byteBuffer) {
        AppMethodBeat.i(218707);
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
        byteBuffer.rewind();
        allocate.put(byteBuffer);
        byteBuffer.rewind();
        allocate.flip();
        AppMethodBeat.o(218707);
        return allocate;
    }

    public static ShortBuffer clone(ShortBuffer shortBuffer) {
        AppMethodBeat.i(218708);
        ShortBuffer allocate = ShortBuffer.allocate(shortBuffer.capacity());
        shortBuffer.rewind();
        allocate.put(shortBuffer);
        shortBuffer.rewind();
        allocate.flip();
        AppMethodBeat.o(218708);
        return allocate;
    }

    public static void clearFiles() {
    }

    private static void deleteAllFiles(File file) {
        AppMethodBeat.i(218709);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            AppMethodBeat.o(218709);
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                deleteAllFiles(file2);
                file2.delete();
            } else if (file2.exists()) {
                deleteAllFiles(file2);
                file2.delete();
            }
        }
        AppMethodBeat.o(218709);
    }

    static class Instance {
        private static AudioBufferPrintHelper INSTANCE = new AudioBufferPrintHelper();

        private Instance() {
        }

        static {
            AppMethodBeat.i(218703);
            AppMethodBeat.o(218703);
        }
    }

    public void startIgnoreBegin(int i2) {
        AppMethodBeat.i(218710);
        startIgnoreBegin(i2, 100);
        AppMethodBeat.o(218710);
    }

    public void startIgnoreBegin(int i2, int i3) {
        AppMethodBeat.i(218711);
        initFlag(i3);
        long j2 = this.startIndex;
        this.startIndex = 1 + j2;
        if (j2 > ((long) i2)) {
            this.enable = true;
        }
        if (this.enable) {
            int i4 = this.maxPrintCount;
            this.maxPrintCount = i4 - 1;
            if (i4 < 0) {
                this.enable = false;
            }
        }
        AppMethodBeat.o(218711);
    }

    public void startDelay(long j2) {
        AppMethodBeat.i(218712);
        startDelay(j2, 100);
        AppMethodBeat.o(218712);
    }

    public void startDelay(long j2, int i2) {
        AppMethodBeat.i(218713);
        initFlag(i2);
        this.enable = System.currentTimeMillis() >= this.startTimeMs + j2;
        if (this.enable) {
            int i3 = this.maxPrintCount;
            this.maxPrintCount = i3 - 1;
            if (i3 < 0) {
                this.enable = false;
            }
        }
        AppMethodBeat.o(218713);
    }

    @SuppressLint({"SimpleDateFormat"})
    private void initFlag(int i2) {
        AppMethodBeat.i(218714);
        if (this.startTimeMs == 0) {
            this.startTimeMs = System.currentTimeMillis();
            this.startName = new SimpleDateFormat("HHmmss").format(new Date(this.startTimeMs));
        }
        if (this.maxPrintCount == 0) {
            this.maxPrintCount = i2;
        }
        AppMethodBeat.o(218714);
    }

    public void printByteBuffer(String str, ByteBuffer byteBuffer) {
    }

    public void printByteBuffer(String str, ShortBuffer shortBuffer) {
    }

    public void printByteBuffer(String str, short[] sArr) {
    }

    public static File createNewFile(String str, String str2) {
        AppMethodBeat.i(218715);
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            File file2 = new File(file, str2);
            try {
                file2.delete();
                if (!file2.createNewFile()) {
                    new StringBuilder("export: 创建输出文件失败:").append(file2.getAbsolutePath());
                    AppMethodBeat.o(218715);
                    return null;
                }
                AppMethodBeat.o(218715);
                return file2;
            } catch (IOException e2) {
                AppMethodBeat.o(218715);
                return null;
            }
        } else {
            AppMethodBeat.o(218715);
            return null;
        }
    }
}
