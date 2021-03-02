package com.tencent.mm.media.widget.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/media/widget/camera/OpenCameraThread;", "", "()V", "TAG", "", "isTimeouted", "", "lock", "Ljava/lang/Object;", ShareConstants.RES_PATH, "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "openCamera", "context", "Landroid/content/Context;", "nowCameraId", "", "looper", "Landroid/os/Looper;", "plugin-mediaeditor_release"})
public final class e {
    final String TAG = "MicroMsg.SightCamera.OpenCameraThread";
    boolean imC;
    d.a.C0301a imD;
    final Object lock = new Object();

    public e() {
        AppMethodBeat.i(94063);
        AppMethodBeat.o(94063);
    }

    public final d.a.C0301a a(Context context, int i2, Looper looper) {
        AppMethodBeat.i(94062);
        if (context == null) {
            AppMethodBeat.o(94062);
            return null;
        }
        long nowMilliSecond = Util.nowMilliSecond();
        Thread currentThread = Thread.currentThread();
        p.g(currentThread, "Thread.currentThread()");
        long id = currentThread.getId();
        synchronized (this.lock) {
            try {
                this.imC = false;
                this.imD = null;
                ThreadPool.post(new a(this, id, nowMilliSecond, context, i2, looper), "SightCamera_openCamera");
                try {
                    this.lock.wait(30000);
                } catch (InterruptedException e2) {
                    Log.e(this.TAG, "Lock wait failed e:%s", e2.getMessage());
                }
                if (this.imD != null) {
                    d.a.C0301a aVar = this.imD;
                    if (aVar == null) {
                        p.hyc();
                    }
                    if (aVar.gGr != null) {
                        String str = this.TAG;
                        Object[] objArr = new Object[3];
                        objArr[0] = Long.valueOf(id);
                        objArr[1] = Long.valueOf(Util.nowMilliSecond() - nowMilliSecond);
                        d.a.C0301a aVar2 = this.imD;
                        if (aVar2 == null) {
                            p.hyc();
                        }
                        objArr[2] = aVar2.gGr;
                        Log.i(str, "Open Camera Succ thread:%d Time:%d camera:%s", objArr);
                        return this.imD;
                    }
                }
                this.imC = true;
                Log.e(this.TAG, "Open Camera Timeout:%d", Long.valueOf(Util.nowMilliSecond() - nowMilliSecond));
                AppMethodBeat.o(94062);
                return null;
            } finally {
                AppMethodBeat.o(94062);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/media/widget/camera/OpenCameraThread$openCamera$1$1"})
    public static final class a implements Runnable {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ e imE;
        final /* synthetic */ long imF;
        final /* synthetic */ long imG;
        final /* synthetic */ int imH;
        final /* synthetic */ Looper imI;

        a(e eVar, long j2, long j3, Context context, int i2, Looper looper) {
            this.imE = eVar;
            this.imF = j2;
            this.imG = j3;
            this.$context$inlined = context;
            this.imH = i2;
            this.imI = looper;
        }

        public final void run() {
            AppMethodBeat.i(94061);
            String str = this.imE.TAG;
            Thread currentThread = Thread.currentThread();
            p.g(currentThread, "Thread.currentThread()");
            Log.i(str, "Start Open Camera thread[parent:%d this:%d] time:%d", Long.valueOf(this.imF), Long.valueOf(currentThread.getId()), Long.valueOf(Util.nowMilliSecond() - this.imG));
            synchronized (this.imE.lock) {
                try {
                    this.imE.imD = d.a(this.$context$inlined, this.imH, this.imI);
                } catch (Exception e2) {
                    Log.e(this.imE.TAG, "openCamera failed e:%s", e2.getMessage());
                    this.imE.imD = null;
                }
                try {
                    if (this.imE.imC && this.imE.imD != null) {
                        Log.e(this.imE.TAG, "thread time out now, release camera :%d ", Long.valueOf(Util.nowMilliSecond() - this.imG));
                        try {
                            d.a.C0301a aVar = this.imE.imD;
                            if (aVar == null) {
                                p.hyc();
                            }
                            v vVar = aVar.gGr;
                            vVar.setPreviewCallback(null);
                            vVar.stopPreview();
                            vVar.release();
                            this.imE.imD = null;
                        } catch (Exception e3) {
                            Log.e(this.imE.TAG, "realease Camera failed e:%s", e3.getMessage());
                        }
                    }
                    this.imE.lock.notify();
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(94061);
                }
            }
        }
    }
}
