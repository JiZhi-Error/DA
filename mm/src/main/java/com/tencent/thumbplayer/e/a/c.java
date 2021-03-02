package com.tencent.thumbplayer.e.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest;
import com.tencent.thumbplayer.utils.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class c implements ITPAssetResourceLoadingDataRequest {
    private static String TAG = "TPAssetResourceLoadingDataRequest";
    int RZY;
    private long Sae;
    private long Saf;
    private boolean Sag;
    private volatile long Sah;
    private long Sai;
    b Saj;
    String Sak;
    private volatile long mCurrentOffset;
    private RandomAccessFile mRandomAccessFile;

    static /* synthetic */ boolean a(c cVar, long j2, byte[] bArr, String str) {
        AppMethodBeat.i(189265);
        boolean a2 = cVar.a(j2, bArr, str);
        AppMethodBeat.o(189265);
        return a2;
    }

    public c(long j2, long j3, boolean z) {
        this.Sae = j2;
        this.mCurrentOffset = j2;
        this.Sah = j2;
        this.Saf = j3;
        this.Sag = z;
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest
    public final long getRequestedOffset() {
        return this.Sae;
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest
    public final long getRequestedLength() {
        return this.Saf;
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest
    public final long getCurrentOffset() {
        return this.mCurrentOffset;
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest
    public final int getRequestNum() {
        return this.RZY;
    }

    public final synchronized int OF(long j2) {
        int i2 = -1;
        synchronized (this) {
            AppMethodBeat.i(189261);
            long j3 = this.Sah;
            if (j2 >= j3) {
                AppMethodBeat.o(189261);
            } else if (j2 < this.Sae) {
                g.e(TAG, "Offset less than mRequestedOffset");
                AppMethodBeat.o(189261);
            } else {
                i2 = (int) Math.min(1048576L, j3 - j2);
                g.i(TAG, "getDataReadyLength, readyLength:" + i2 + ", realOffset:" + j3 + ", requestOffset:" + j2 + ", requestNum:" + this.RZY);
                AppMethodBeat.o(189261);
            }
        }
        return i2;
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest
    public final synchronized void notifyDataReady(long j2, long j3) {
        AppMethodBeat.i(189262);
        if (j2 + j3 > this.Sae + this.Saf) {
            g.e(TAG, "data exceed the max request offset");
            AppMethodBeat.o(189262);
        } else {
            if (j2 < this.Sae) {
                g.w(TAG, "the notify data offset is less than request offset");
            }
            if (j2 + j3 < this.mCurrentOffset) {
                g.e(TAG, "data not reach current offset");
                AppMethodBeat.o(189262);
            } else {
                this.mCurrentOffset = j2 + j3;
                this.Sah = this.mCurrentOffset;
                g.i(TAG, "notifyDataReady, mRealOffset: " + this.Sah + ", readyOffset:" + j2 + ", readyLength:" + j3 + ", requestNum:" + this.RZY);
                AppMethodBeat.o(189262);
            }
        }
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingDataRequest
    public final void respondWithData(byte[] bArr) {
        AppMethodBeat.i(189263);
        if (this.Sai > this.Saf) {
            g.i(TAG, "respond full data");
            AppMethodBeat.o(189263);
            return;
        }
        int length = bArr.length;
        a aVar = new a((byte) 0);
        aVar.Sal = this.mCurrentOffset;
        aVar.data = bArr;
        if (this.Saj != null) {
            Message obtainMessage = this.Saj.obtainMessage();
            obtainMessage.what = 256;
            obtainMessage.arg1 = length;
            obtainMessage.arg2 = 0;
            obtainMessage.obj = aVar;
            this.Saj.sendMessage(obtainMessage);
        }
        g.i(TAG, "respond data from:" + this.mCurrentOffset + ", dataLength:" + length);
        this.mCurrentOffset += (long) length;
        this.Sai = ((long) length) + this.Sai;
        AppMethodBeat.o(189263);
    }

    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(189260);
            switch (message.what) {
                case 256:
                    a aVar = (a) message.obj;
                    long j2 = aVar.Sal;
                    byte[] bArr = aVar.data;
                    int i2 = message.arg1;
                    if (c.a(c.this, j2, bArr, c.this.Sak)) {
                        c.this.Sah = ((long) i2) + j2;
                        g.i(c.TAG, "write data from " + j2 + " , with dataLength" + i2);
                        break;
                    } else {
                        g.e(c.TAG, "write data failed");
                        AppMethodBeat.o(189260);
                        return;
                    }
            }
            AppMethodBeat.o(189260);
        }
    }

    private boolean a(long j2, byte[] bArr, String str) {
        AppMethodBeat.i(189264);
        boolean z = false;
        try {
            this.mRandomAccessFile = new RandomAccessFile(str, "rw");
            this.mRandomAccessFile.seek(j2);
            this.mRandomAccessFile.write(bArr);
            z = true;
            if (this.mRandomAccessFile != null) {
                try {
                    this.mRandomAccessFile.close();
                } catch (IOException e2) {
                    g.e(TAG, "fail to close mRandomAccessFile");
                }
            }
        } catch (FileNotFoundException e3) {
            g.e(TAG, "file not found");
            if (this.mRandomAccessFile != null) {
                try {
                    this.mRandomAccessFile.close();
                } catch (IOException e4) {
                    g.e(TAG, "fail to close mRandomAccessFile");
                }
            }
        } catch (IOException e5) {
            g.e(TAG, "fail to write data");
            if (this.mRandomAccessFile != null) {
                try {
                    this.mRandomAccessFile.close();
                } catch (IOException e6) {
                    g.e(TAG, "fail to close mRandomAccessFile");
                }
            }
        } catch (Throwable th) {
            if (this.mRandomAccessFile != null) {
                try {
                    this.mRandomAccessFile.close();
                } catch (IOException e7) {
                    g.e(TAG, "fail to close mRandomAccessFile");
                }
            }
            AppMethodBeat.o(189264);
            throw th;
        }
        AppMethodBeat.o(189264);
        return z;
    }

    static class a {
        long Sal;
        byte[] data;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
