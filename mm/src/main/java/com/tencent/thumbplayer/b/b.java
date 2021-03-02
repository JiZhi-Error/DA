package com.tencent.thumbplayer.b;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.g;
import java.io.FileDescriptor;
import java.util.HashMap;

public final class b {
    private static b RYy = null;
    private MediaMetadataRetriever RYA = null;
    private int RYB = 0;
    private c RYz = null;
    private HandlerThread mHandlerThread = null;

    public interface a {
        void arl(int i2);

        void f(int i2, Bitmap bitmap);
    }

    public static synchronized b hne() {
        b bVar;
        synchronized (b.class) {
            AppMethodBeat.i(189088);
            if (RYy == null) {
                RYy = new b();
            }
            bVar = RYy;
            AppMethodBeat.o(189088);
        }
        return bVar;
    }

    private b() {
        AppMethodBeat.i(189089);
        try {
            this.mHandlerThread = new HandlerThread("TP-SysImgCap");
            this.mHandlerThread.start();
            this.RYz = new c(this.mHandlerThread.getLooper());
            AppMethodBeat.o(189089);
        } catch (Throwable th) {
            g.e("TPSysPlayerImageCapture", th);
            this.RYz = new c(Looper.getMainLooper());
            AppMethodBeat.o(189089);
        }
    }

    public final int a(String str, FileDescriptor fileDescriptor, long j2, int i2, int i3, a aVar) {
        AppMethodBeat.i(189090);
        g.i("TPSysPlayerImageCapture", "captureImageWithPosition, position: " + j2 + ", width: " + i2 + ", height: " + i3);
        this.RYB++;
        if (TextUtils.isEmpty(Build.MODEL) || !Build.MODEL.equals("Lenovo+K900")) {
            C2204b bVar = new C2204b((byte) 0);
            bVar.id = this.RYB;
            bVar.RYC = fileDescriptor;
            bVar.url = str;
            bVar.bdG = j2;
            bVar.width = i2;
            bVar.height = i3;
            bVar.RYD = aVar;
            Message message = new Message();
            message.what = 1;
            message.obj = bVar;
            if (!this.RYz.sendMessage(message)) {
                g.i("TPSysPlayerImageCapture", "captureImageWithPosition, send msg failed ");
            }
            int i4 = this.RYB;
            AppMethodBeat.o(189090);
            return i4;
        }
        g.i("TPSysPlayerImageCapture", "captureImageWithPosition, Lenovo+K900 no incompatible");
        AppMethodBeat.o(189090);
        return -1;
    }

    /* access modifiers changed from: package-private */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(189087);
            switch (message.what) {
                case 1:
                    g.i("TPSysPlayerImageCapture", "eventHandler EV_CAP_IMAGE");
                    b.a(b.this, (C2204b) message.obj);
                    AppMethodBeat.o(189087);
                    return;
                case 2:
                    g.i("TPSysPlayerImageCapture", "eventHandler EV_STOP_CAP_IMAGE");
                    if (b.this.RYA != null) {
                        b.this.RYA.release();
                        b.this.RYA = null;
                        AppMethodBeat.o(189087);
                        return;
                    }
                    break;
                default:
                    g.i("TPSysPlayerImageCapture", "eventHandler unknow msg");
                    break;
            }
            AppMethodBeat.o(189087);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.thumbplayer.b.b$b  reason: collision with other inner class name */
    public static class C2204b {
        FileDescriptor RYC;
        protected a RYD;
        long bdG;
        int height;
        int id;
        String url;
        int width;

        private C2204b() {
        }

        /* synthetic */ C2204b(byte b2) {
            this();
        }
    }

    static /* synthetic */ void a(b bVar, C2204b bVar2) {
        AppMethodBeat.i(189091);
        try {
            if (Build.VERSION.SDK_INT < 14) {
                Exception exc = new Exception("os version not support");
                AppMethodBeat.o(189091);
                throw exc;
            }
            System.currentTimeMillis();
            if (bVar.RYA != null) {
                bVar.RYA.release();
                bVar.RYA = null;
            }
            bVar.RYA = new MediaMetadataRetriever();
            if (Build.VERSION.SDK_INT >= 14) {
                if (bVar2.RYC != null) {
                    bVar.RYA.setDataSource(bVar2.RYC);
                } else {
                    bVar.RYA.setDataSource(bVar2.url, new HashMap());
                }
            }
            Bitmap frameAtTime = bVar.RYA.getFrameAtTime(bVar2.bdG * 1000, 2);
            System.currentTimeMillis();
            if (frameAtTime != null) {
                bVar2.RYD.f(bVar2.id, frameAtTime);
            } else {
                bVar2.RYD.arl(bVar2.id);
            }
            if (bVar.RYA != null) {
                bVar.RYA.release();
                bVar.RYA = null;
                AppMethodBeat.o(189091);
                return;
            }
            AppMethodBeat.o(189091);
        } catch (Exception e2) {
            g.e("TPSysPlayerImageCapture", e2);
            g.e("TPSysPlayerImageCapture", "doRealCaptureImage, Exception: " + e2.toString());
            bVar2.RYD.arl(bVar2.id);
            if (bVar.RYA != null) {
                bVar.RYA.release();
                bVar.RYA = null;
                AppMethodBeat.o(189091);
            }
        } catch (Throwable th) {
            if (bVar.RYA != null) {
                bVar.RYA.release();
                bVar.RYA = null;
            }
            AppMethodBeat.o(189091);
            throw th;
        }
    }
}
