package com.tencent.midas.comm.log.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.processor.APLogCompressor;
import com.tencent.midas.comm.log.processor.APLogEncryptor;
import com.tencent.midas.comm.log.processor.APLogWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Locale;

public class APLogAppender {
    private static final int AUTO_FLUSH_INTERVAL = 15000;
    private static final int BUFFER_BLOCK_SIZE = 153600;
    private static final int POSITION_INIT = 12;
    private static boolean stopAutoFlush = false;
    private byte[] EMPTY_BUFFER = new byte[BUFFER_BLOCK_SIZE];
    private String FLAG_BEGIN = "============mmap cache begin===========\r\n";
    private String FLAG_END = "============mmap cache end=============\r\n";
    private final String SPACE = " ";
    private final byte[] _bytes = new byte[0];
    private Thread autoFlushThread = null;
    private FileChannel fileChannel = null;
    private APLogCompressor mCompressor = null;
    private APLogEncryptor mEncryptor = null;
    private APLogWriter mWriter = null;
    private MappedByteBuffer mappedByteBuffer = null;
    private RandomAccessFile randomAccessFile = null;
    private volatile long seq = 12;

    private APLogAppender() {
        AppMethodBeat.i(193410);
        AppMethodBeat.o(193410);
    }

    public static APLogAppender open() {
        AppMethodBeat.i(193411);
        APLogAppender aPLogAppender = new APLogAppender();
        aPLogAppender.createBufferProcessor();
        aPLogAppender.openMmapFile();
        aPLogAppender.initMmap();
        aPLogAppender.startAutoFlush();
        AppMethodBeat.o(193411);
        return aPLogAppender;
    }

    private void openMmapFile() {
        AppMethodBeat.i(193412);
        try {
            this.randomAccessFile = new RandomAccessFile(APLogFileInfo.mmapName, "rw");
            this.fileChannel = this.randomAccessFile.getChannel();
            this.mappedByteBuffer = this.fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 153600);
            AppMethodBeat.o(193412);
        } catch (Throwable th) {
            String.format(Locale.CHINA, "open log mmap file error: <%s>%s", th.getClass().getName(), th.getMessage());
            AppMethodBeat.o(193412);
        }
    }

    private void initMmap() {
        AppMethodBeat.i(193413);
        if (this.mappedByteBuffer == null) {
            AppMethodBeat.o(193413);
            return;
        }
        checkAndFlushBuffer();
        this.mappedByteBuffer.putLong(0, 12);
        this.mappedByteBuffer.putInt(8, 39);
        resetPosAndSeq();
        AppMethodBeat.o(193413);
    }

    private void createBufferProcessor() {
        AppMethodBeat.i(193414);
        if (APLog.getLogInfo() != null && APLog.getLogInfo().isCompressLog()) {
            this.mCompressor = APLogCompressor.create();
        }
        if (APLog.getLogInfo() != null && APLog.getLogInfo().isEncryptLog()) {
            this.mEncryptor = APLogEncryptor.create();
        }
        this.mWriter = APLogWriter.create();
        AppMethodBeat.o(193414);
    }

    private void startAutoFlush() {
        AppMethodBeat.i(193415);
        if (APLog.getLogInfo() != null && APLog.getLogInfo().isAutoFlush() && this.autoFlushThread == null) {
            this.autoFlushThread = new Thread(new Runnable() {
                /* class com.tencent.midas.comm.log.internal.APLogAppender.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(193409);
                    while (true) {
                        try {
                            Thread.sleep(15000);
                        } catch (InterruptedException e2) {
                        }
                        if (!APLogAppender.stopAutoFlush) {
                            APLogAppender.this.flushAndWrite();
                        } else {
                            AppMethodBeat.o(193409);
                            return;
                        }
                    }
                }
            });
            this.autoFlushThread.start();
        }
        AppMethodBeat.o(193415);
    }

    private void stopAutoFlush() {
        stopAutoFlush = true;
    }

    public void append(String str) {
        AppMethodBeat.i(193416);
        try {
            updateMmap(process(str));
            AppMethodBeat.o(193416);
        } catch (Throwable th) {
            String.format(Locale.CHINA, "append log error: <%s> %s", th.getClass().getName(), th.getMessage());
            AppMethodBeat.o(193416);
        }
    }

    public synchronized void updateMmap(byte[] bArr) {
        AppMethodBeat.i(193417);
        if (((long) bArr.length) + this.seq > 102400) {
            checkAndFlushBuffer();
        }
        if (this.mappedByteBuffer == null) {
            AppMethodBeat.o(193417);
        } else {
            this.mappedByteBuffer.put(bArr);
            this.seq += (long) bArr.length;
            this.mappedByteBuffer.putLong(0, this.seq);
            AppMethodBeat.o(193417);
        }
    }

    private synchronized byte[] process(String str) {
        byte[] bArr;
        AppMethodBeat.i(193418);
        try {
            bArr = (System.currentTimeMillis() + " " + str).getBytes();
            if (this.mCompressor != null) {
                bArr = this.mCompressor.compress(bArr);
            }
            if (this.mEncryptor != null) {
                bArr = this.mEncryptor.encrypt(bArr);
            }
            AppMethodBeat.o(193418);
        } catch (Throwable th) {
            String.format(Locale.CHINA, "process log error: <%s>%s", th.getClass().getName(), th.getMessage());
            bArr = this._bytes;
            AppMethodBeat.o(193418);
        }
        return bArr;
    }

    private synchronized void checkAndFlushBuffer() {
        AppMethodBeat.i(193419);
        try {
            if (this.mappedByteBuffer == null) {
                AppMethodBeat.o(193419);
            } else {
                int i2 = (int) this.mappedByteBuffer.getLong(0);
                if (i2 <= 12) {
                    this.seq = 12;
                    AppMethodBeat.o(193419);
                } else {
                    flushBuffer(i2 - 12);
                    AppMethodBeat.o(193419);
                }
            }
        } catch (Throwable th) {
            String.format(Locale.CHINA, "check and flush buffer error: <%s>%s", th.getClass().getName(), th.getMessage());
            AppMethodBeat.o(193419);
        }
    }

    private void flushBuffer(int i2) {
        AppMethodBeat.i(193420);
        if (this.mappedByteBuffer == null) {
            AppMethodBeat.o(193420);
            return;
        }
        if (i2 > BUFFER_BLOCK_SIZE) {
            i2 = BUFFER_BLOCK_SIZE;
        }
        byte[] bArr = new byte[i2];
        this.mappedByteBuffer.position(12);
        this.mappedByteBuffer.get(bArr);
        this.mWriter.write(bArr, process(this.FLAG_BEGIN), process(this.FLAG_END));
        this.mappedByteBuffer.position(12);
        this.mappedByteBuffer.put(this.EMPTY_BUFFER, 12, i2);
        this.mappedByteBuffer.putLong(0, 0);
        resetPosAndSeq();
        AppMethodBeat.o(193420);
    }

    private void resetPosAndSeq() {
        AppMethodBeat.i(193421);
        if (this.mappedByteBuffer == null) {
            AppMethodBeat.o(193421);
            return;
        }
        this.seq = 12;
        this.mappedByteBuffer.position(12);
        AppMethodBeat.o(193421);
    }

    public void flushAndWrite() {
        AppMethodBeat.i(193422);
        try {
            checkAndFlushBuffer();
            if (this.mWriter != null) {
                this.mWriter.flush();
            }
            AppMethodBeat.o(193422);
        } catch (Throwable th) {
            String.format(Locale.CHINA, "flush buffer and write error: <%s>%s", th.getClass().getName(), th.getMessage());
            AppMethodBeat.o(193422);
        }
    }
}
