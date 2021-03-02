package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public class FLock {
    private static final int ERRNO_EBADF = 9;
    private static final int ERRNO_EINTR = 4;
    private static final int ERRNO_EINVAL = 22;
    private static final int ERRNO_ENOLCK = 46;
    private static final int ERRNO_EWOULDBLOCK = 11;
    private static final int ERRNO_NOERR = 0;
    private static final String TAG = "MicroMsg.FLock";
    private volatile int mFD;
    private o mFile;

    private static native void nativeFree(int i2);

    private static native int nativeInit(String str);

    private static native int nativeLockRead(int i2, boolean z);

    private static native int nativeLockWrite(int i2, boolean z);

    private static native int nativeUnlock(int i2);

    public FLock(String str, boolean z) {
        this(new o(str), z);
        AppMethodBeat.i(200840);
        AppMethodBeat.o(200840);
    }

    public FLock(o oVar, boolean z) {
        AppMethodBeat.i(200841);
        this.mFile = null;
        this.mFD = -1;
        if (!oVar.exists()) {
            if (z) {
                try {
                    oVar.createNewFile();
                } catch (IOException e2) {
                    IllegalStateException illegalStateException = new IllegalStateException(e2);
                    AppMethodBeat.o(200841);
                    throw illegalStateException;
                }
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("target is not exists or create failed.");
                AppMethodBeat.o(200841);
                throw illegalArgumentException;
            }
        } else if (!oVar.isFile()) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("target is not a file.");
            AppMethodBeat.o(200841);
            throw illegalArgumentException2;
        }
        this.mFile = oVar;
        AppMethodBeat.o(200841);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(125215);
        super.finalize();
        unlock();
        AppMethodBeat.o(125215);
    }

    private synchronized int init() {
        int i2;
        AppMethodBeat.i(125216);
        if (!this.mFile.exists()) {
            try {
                this.mFile.createNewFile();
            } catch (IOException e2) {
            }
            this.mFD = -1;
        }
        if (this.mFD == -1) {
            this.mFD = nativeInit(aa.z(this.mFile.her()));
        }
        i2 = this.mFD;
        AppMethodBeat.o(125216);
        return i2;
    }

    private synchronized void free() {
        AppMethodBeat.i(125217);
        if (this.mFD != -1) {
            nativeFree(this.mFD);
            this.mFD = -1;
        }
        AppMethodBeat.o(125217);
    }

    public synchronized boolean tryLockRead() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(200842);
            int init = init();
            while (true) {
                switch (nativeLockRead(init, false)) {
                    case 4:
                        try {
                            Thread.sleep(0);
                        } catch (InterruptedException e2) {
                        }
                    case 9:
                        IllegalStateException illegalStateException = new IllegalStateException("bad file descriptor.");
                        AppMethodBeat.o(200842);
                        throw illegalStateException;
                    case 11:
                        AppMethodBeat.o(200842);
                        break;
                    case 22:
                        IllegalStateException illegalStateException2 = new IllegalStateException("bad operation.");
                        AppMethodBeat.o(200842);
                        throw illegalStateException2;
                    case 46:
                        IllegalStateException illegalStateException3 = new IllegalStateException("kernel lock spaces ran out.");
                        AppMethodBeat.o(200842);
                        throw illegalStateException3;
                    default:
                        z = true;
                        AppMethodBeat.o(200842);
                        break;
                }
            }
        }
        return z;
    }

    public synchronized void lockRead() {
        AppMethodBeat.i(125218);
        int init = init();
        while (true) {
            switch (nativeLockRead(init, true)) {
                case 4:
                case 11:
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e2) {
                    }
                case 9:
                    IllegalStateException illegalStateException = new IllegalStateException("bad file descriptor.");
                    AppMethodBeat.o(125218);
                    throw illegalStateException;
                case 22:
                    IllegalStateException illegalStateException2 = new IllegalStateException("bad operation.");
                    AppMethodBeat.o(125218);
                    throw illegalStateException2;
                case 46:
                    IllegalStateException illegalStateException3 = new IllegalStateException("kernel lock spaces ran out.");
                    AppMethodBeat.o(125218);
                    throw illegalStateException3;
                default:
                    AppMethodBeat.o(125218);
                    break;
            }
        }
    }

    public synchronized boolean tryLockWrite() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(125219);
            int init = init();
            while (true) {
                switch (nativeLockWrite(init, false)) {
                    case 4:
                        try {
                            Thread.sleep(0);
                        } catch (InterruptedException e2) {
                        }
                    case 9:
                        IllegalStateException illegalStateException = new IllegalStateException("bad file descriptor.");
                        AppMethodBeat.o(125219);
                        throw illegalStateException;
                    case 11:
                        AppMethodBeat.o(125219);
                        break;
                    case 22:
                        IllegalStateException illegalStateException2 = new IllegalStateException("bad operation.");
                        AppMethodBeat.o(125219);
                        throw illegalStateException2;
                    case 46:
                        IllegalStateException illegalStateException3 = new IllegalStateException("kernel lock spaces ran out.");
                        AppMethodBeat.o(125219);
                        throw illegalStateException3;
                    default:
                        z = true;
                        AppMethodBeat.o(125219);
                        break;
                }
            }
        }
        return z;
    }

    public synchronized void lockWrite() {
        AppMethodBeat.i(125220);
        int init = init();
        while (true) {
            switch (nativeLockWrite(init, true)) {
                case 4:
                case 11:
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e2) {
                    }
                case 9:
                    IllegalStateException illegalStateException = new IllegalStateException("bad file descriptor.");
                    AppMethodBeat.o(125220);
                    throw illegalStateException;
                case 22:
                    IllegalStateException illegalStateException2 = new IllegalStateException("bad operation.");
                    AppMethodBeat.o(125220);
                    throw illegalStateException2;
                case 46:
                    IllegalStateException illegalStateException3 = new IllegalStateException("kernel lock spaces ran out.");
                    AppMethodBeat.o(125220);
                    throw illegalStateException3;
                default:
                    AppMethodBeat.o(125220);
                    break;
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public synchronized void unlock() {
        AppMethodBeat.i(125221);
        if (this.mFD == -1) {
            AppMethodBeat.o(125221);
        } else {
            try {
                int nativeUnlock = nativeUnlock(this.mFD);
                switch (nativeUnlock) {
                    case 0:
                        break;
                    case 9:
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(this.mFD + " is not a valid fd.");
                        AppMethodBeat.o(125221);
                        throw illegalArgumentException;
                    case 22:
                        IllegalStateException illegalStateException = new IllegalStateException("bad operation.");
                        AppMethodBeat.o(125221);
                        throw illegalStateException;
                    default:
                        IllegalStateException illegalStateException2 = new IllegalStateException("other err: ".concat(String.valueOf(nativeUnlock)));
                        AppMethodBeat.o(125221);
                        throw illegalStateException2;
                }
            } finally {
                free();
                AppMethodBeat.o(125221);
            }
        }
    }

    static {
        AppMethodBeat.i(125222);
        try {
            System.loadLibrary("wechatcommon");
            AppMethodBeat.o(125222);
        } catch (Throwable th) {
            Log.printErrStackTrace(TAG, th, "fail to load so.", new Object[0]);
            AppMethodBeat.o(125222);
        }
    }
}
