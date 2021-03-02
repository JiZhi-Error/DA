package com.tencent.tmassistantsdk.storage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidParameterException;

public class TMAssistantFile {
    protected static final int DataBufferMaxLen = 16384;
    protected static final String TAG = "TMAssistantFile";
    protected int mDataBufferDataLen = 0;
    protected long mFileDataLen = 0;
    protected OutputStream mFileOutputStream = null;
    protected String mFinalFileName = null;
    protected String mTempFileName = null;
    protected byte[] mWriteDataBuffer = null;

    public TMAssistantFile(String str, String str2) {
        AppMethodBeat.i(102414);
        this.mTempFileName = str;
        this.mFinalFileName = str2;
        this.mFileDataLen = length();
        TMLog.i(TAG, "mFileDataLen = " + this.mFileDataLen);
        AppMethodBeat.o(102414);
    }

    public void deleteTempFile() {
        AppMethodBeat.i(102415);
        String tmpFilePath = getTmpFilePath(this.mTempFileName);
        TMLog.i(TAG, "deleteFile 1 tmpFilePathString: ".concat(String.valueOf(tmpFilePath)));
        if (!TextUtils.isEmpty(tmpFilePath)) {
            o oVar = new o(tmpFilePath);
            TMLog.i(TAG, "deleteFile 2 file: ".concat(String.valueOf(oVar)));
            if (oVar.exists()) {
                TMLog.i(TAG, "deleteFile result:" + oVar.delete() + ",filename:" + tmpFilePath);
                AppMethodBeat.o(102415);
                return;
            }
            TMLog.i(TAG, "deleteFile 3");
        }
        AppMethodBeat.o(102415);
    }

    public long length() {
        AppMethodBeat.i(102416);
        String saveFilePath = getSaveFilePath(this.mFinalFileName);
        if (saveFilePath != null) {
            o oVar = new o(saveFilePath);
            if (!oVar.exists()) {
                String tmpFilePath = getTmpFilePath(this.mTempFileName);
                if (tmpFilePath != null) {
                    o oVar2 = new o(tmpFilePath);
                    if (!oVar2.exists()) {
                        this.mFileDataLen = 0;
                    } else {
                        TMLog.i(TAG, tmpFilePath + " exists");
                        this.mFileDataLen = oVar2.length();
                    }
                }
            } else {
                this.mFileDataLen = oVar.length();
            }
            long j2 = this.mFileDataLen;
            AppMethodBeat.o(102416);
            return j2;
        }
        AppMethodBeat.o(102416);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public void ensureFilePath(String str) {
        boolean z = true;
        AppMethodBeat.i(102417);
        if (TextUtils.isEmpty(str)) {
            TMLog.i(TAG, "fileFullPath is null or the filename.size is zero.");
            InvalidParameterException invalidParameterException = new InvalidParameterException("fileFullPath is null or the filename.size is zero.");
            AppMethodBeat.o(102417);
            throw invalidParameterException;
        }
        int lastIndexOf = str.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
        if (lastIndexOf == -1 || str.length() == 1) {
            TMLog.i(TAG, "fileFullPath is not a valid full path. fileName: ".concat(String.valueOf(str)));
            InvalidParameterException invalidParameterException2 = new InvalidParameterException("fileFullPath is not a valid full path. fileName: ".concat(String.valueOf(str)));
            AppMethodBeat.o(102417);
            throw invalidParameterException2;
        }
        if (lastIndexOf > 0) {
            str = str.substring(0, lastIndexOf);
        }
        o oVar = new o(str);
        if (!oVar.exists()) {
            z = oVar.mkdirs();
        }
        if (!z) {
            TMLog.i(TAG, "Failed to create directory. dir: ".concat(String.valueOf(str)));
            IOException iOException = new IOException("Failed to create directory. dir: ".concat(String.valueOf(str)));
            AppMethodBeat.o(102417);
            throw iOException;
        }
        AppMethodBeat.o(102417);
    }

    public synchronized boolean write(byte[] bArr, int i2, int i3, long j2, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.i(102418);
            if (this.mFileOutputStream == null) {
                String tmpFilePath = getTmpFilePath(this.mTempFileName);
                if (tmpFilePath != null) {
                    try {
                        ensureFilePath(tmpFilePath);
                        this.mFileOutputStream = s.dw(tmpFilePath, true);
                    } catch (Exception e2) {
                        Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                        TMLog.w(TAG, "write failed" + e2.getMessage());
                        AppMethodBeat.o(102418);
                    }
                } else {
                    TMLog.w(TAG, "write failed tmpFilePathString is null");
                    AppMethodBeat.o(102418);
                }
            }
            if (this.mWriteDataBuffer == null) {
                this.mWriteDataBuffer = new byte[16384];
                this.mDataBufferDataLen = 0;
            }
            z2 = writeData(this.mFileOutputStream, bArr, i2, i3, j2);
            if (!z2) {
                AppMethodBeat.o(102418);
            } else if (z && flush()) {
                z2 = moveFileFromTmpToSavaPath(getTmpFilePath(this.mTempFileName), getSaveFilePath(this.mFinalFileName));
                AppMethodBeat.o(102418);
            } else {
                AppMethodBeat.o(102418);
                z2 = true;
            }
        }
        return z2;
    }

    public synchronized boolean flush() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(102419);
            if (this.mFileOutputStream != null && this.mDataBufferDataLen > 0) {
                try {
                    this.mFileOutputStream.write(this.mWriteDataBuffer, 0, this.mDataBufferDataLen);
                    this.mDataBufferDataLen = 0;
                    z = true;
                    AppMethodBeat.o(102419);
                } catch (IOException e2) {
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    TMLog.w(TAG, "flush failed ".concat(String.valueOf(e2)));
                }
            }
            AppMethodBeat.o(102419);
        }
        return z;
    }

    public synchronized void close() {
        AppMethodBeat.i(102420);
        flush();
        try {
            if (this.mFileOutputStream != null) {
                this.mFileOutputStream.close();
            }
        } catch (IOException e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        this.mFileOutputStream = null;
        this.mWriteDataBuffer = null;
        this.mFileDataLen = 0;
        AppMethodBeat.o(102420);
    }

    public static String getSaveFilePath(String str) {
        AppMethodBeat.i(102421);
        if (str == null) {
            AppMethodBeat.o(102421);
            return null;
        }
        String savePathRootDir = getSavePathRootDir();
        if (savePathRootDir == null) {
            AppMethodBeat.o(102421);
            return null;
        }
        String str2 = savePathRootDir + FilePathGenerator.ANDROID_DIR_SEP + str;
        AppMethodBeat.o(102421);
        return str2;
    }

    public String getTmpFilePath(String str) {
        AppMethodBeat.i(102422);
        if (str == null) {
            AppMethodBeat.o(102422);
            return null;
        }
        String savePathRootDir = getSavePathRootDir();
        if (savePathRootDir == null) {
            AppMethodBeat.o(102422);
            return null;
        }
        String str2 = savePathRootDir + "/.tmp/" + str + ".tmp";
        AppMethodBeat.o(102422);
        return str2;
    }

    public static String getSavePathRootDir() {
        String str;
        AppMethodBeat.i(102423);
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            AppMethodBeat.o(102423);
            return null;
        }
        if (isSDCardExistAndCanWrite()) {
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/TMAssistantSDK/Download/".concat(String.valueOf(context.getPackageName()));
        } else {
            str = context.getExternalCacheDir() + "/TMAssistantSDK/Download";
        }
        AppMethodBeat.o(102423);
        return str;
    }

    public void moveFileToSavaPath() {
        AppMethodBeat.i(102424);
        moveFileFromTmpToSavaPath(getTmpFilePath(this.mTempFileName), getSaveFilePath(this.mFinalFileName));
        AppMethodBeat.o(102424);
    }

    public static boolean isSDCardExistAndCanWrite() {
        AppMethodBeat.i(102425);
        if (!"mounted".equals(Environment.getExternalStorageState()) || !Environment.getExternalStorageDirectory().canWrite()) {
            AppMethodBeat.o(102425);
            return false;
        }
        AppMethodBeat.o(102425);
        return true;
    }

    private boolean writeData(OutputStream outputStream, byte[] bArr, int i2, int i3, long j2) {
        AppMethodBeat.i(177060);
        if (outputStream == null || bArr == null) {
            AppMethodBeat.o(177060);
            return false;
        } else if (j2 != this.mFileDataLen) {
            TMLog.i(TAG, "writeData0 failed,filelen:" + this.mFileDataLen + ",offset:" + j2 + ",filename:" + this.mTempFileName);
            AppMethodBeat.o(177060);
            return false;
        } else {
            if (i3 >= 16384) {
                try {
                    if (this.mDataBufferDataLen > 0) {
                        outputStream.write(this.mWriteDataBuffer, 0, this.mDataBufferDataLen);
                        this.mDataBufferDataLen = 0;
                    }
                    outputStream.write(bArr, i2, i3);
                    this.mFileDataLen += (long) i3;
                } catch (IOException e2) {
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    TMLog.w(TAG, "writeData1 failed " + e2.getMessage());
                    AppMethodBeat.o(177060);
                    return false;
                }
            } else {
                if (this.mDataBufferDataLen + i3 > 16384 && this.mDataBufferDataLen > 0) {
                    try {
                        outputStream.write(this.mWriteDataBuffer, 0, this.mDataBufferDataLen);
                        this.mDataBufferDataLen = 0;
                    } catch (IOException e3) {
                        Log.printErrStackTrace(TAG, e3, "", new Object[0]);
                        TMLog.w(TAG, "writeData2 failed " + e3.getMessage());
                        AppMethodBeat.o(177060);
                        return false;
                    }
                }
                System.arraycopy(bArr, i2, this.mWriteDataBuffer, this.mDataBufferDataLen, i3);
                this.mDataBufferDataLen += i3;
                this.mFileDataLen += (long) i3;
            }
            AppMethodBeat.o(177060);
            return true;
        }
    }

    private boolean moveFileFromTmpToSavaPath(String str, String str2) {
        AppMethodBeat.i(102427);
        TMLog.i(TAG, "moveFileFromTmpToSavaPath, tmpFilePath = " + str + ", saveFilePath = " + str2);
        if (!(str == null || str2 == null)) {
            o oVar = new o(str);
            if (oVar.exists()) {
                boolean am = oVar.am(new o(str2));
                if (am) {
                    GlobalUtil.updateFilePathAuthorized(str2);
                }
                AppMethodBeat.o(102427);
                return am;
            }
        }
        TMLog.w(TAG, "moveFileFromTmpToSavaPath failed ");
        AppMethodBeat.o(102427);
        return false;
    }
}
