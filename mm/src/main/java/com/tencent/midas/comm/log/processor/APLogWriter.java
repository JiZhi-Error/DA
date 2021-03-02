package com.tencent.midas.comm.log.processor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Locale;

public class APLogWriter {
    private FileChannel fileChannel = null;
    private MappedByteBuffer mappedByteBuffer = null;
    private RandomAccessFile randomAccessFile = null;

    public static APLogWriter create() {
        AppMethodBeat.i(193435);
        APLogWriter aPLogWriter = new APLogWriter();
        aPLogWriter.openLogFile();
        AppMethodBeat.o(193435);
        return aPLogWriter;
    }

    private void openLogFile() {
        AppMethodBeat.i(193436);
        try {
            new StringBuilder("open log file: ").append(APLogFileInfo.fileName);
            this.randomAccessFile = new RandomAccessFile(APLogFileInfo.fileName, "rw");
            this.fileChannel = this.randomAccessFile.getChannel();
            AppMethodBeat.o(193436);
        } catch (FileNotFoundException e2) {
            AppMethodBeat.o(193436);
        }
    }

    public void write(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        AppMethodBeat.i(193437);
        try {
            long refreshFileChannel = refreshFileChannel((long) bArr.length);
            long currentTimeMillis = System.currentTimeMillis();
            this.mappedByteBuffer = this.fileChannel.map(FileChannel.MapMode.READ_WRITE, refreshFileChannel, (long) (bArr.length + bArr2.length + bArr3.length));
            long currentTimeMillis2 = System.currentTimeMillis();
            this.mappedByteBuffer.put(bArr2);
            this.mappedByteBuffer.put(bArr);
            this.mappedByteBuffer.put(bArr3);
            this.mappedByteBuffer.force();
            new StringBuilder("write map time: ").append(System.currentTimeMillis() - currentTimeMillis).append(", sync time: ").append(System.currentTimeMillis() - currentTimeMillis2);
            APLogFileUtil.deleteOldFileToday(APLogFileInfo.dirName);
            AppMethodBeat.o(193437);
        } catch (Throwable th) {
            String.format(Locale.CHINA, "cache log to file error: <%s>%s", th.getClass().getName(), th.getMessage());
            AppMethodBeat.o(193437);
        }
    }

    private long refreshFileChannel(long j2) {
        long j3;
        AppMethodBeat.i(193438);
        try {
            j3 = this.fileChannel.size();
        } catch (IOException e2) {
            APLogFileInfo.updateFileName();
            openLogFile();
            j3 = 0;
        }
        long j4 = (long) (APLogFileUtil.maxLogFileSizeMB * 1024 * 1024);
        long j5 = (j2 + j3) - j4;
        String.format(Locale.CHINA, "size to write: %d, channel size: %d, limit: %d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        if (j5 > 0) {
            APLogFileInfo.updateFileName();
            openLogFile();
            j3 = 0;
        }
        AppMethodBeat.o(193438);
        return j3;
    }

    public void flush() {
        AppMethodBeat.i(193439);
        if (this.mappedByteBuffer != null) {
            this.mappedByteBuffer.force();
        }
        AppMethodBeat.o(193439);
    }

    public void close() {
        AppMethodBeat.i(193440);
        try {
            if (this.fileChannel != null) {
                this.fileChannel.close();
            }
            if (this.randomAccessFile != null) {
                this.randomAccessFile.close();
            }
            if (this.mappedByteBuffer != null) {
                this.mappedByteBuffer.force();
                this.mappedByteBuffer.clear();
            }
            AppMethodBeat.o(193440);
        } catch (Throwable th) {
            AppMethodBeat.o(193440);
        }
    }
}
