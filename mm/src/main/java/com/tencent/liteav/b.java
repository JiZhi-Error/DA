package com.tencent.liteav;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f184a = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private int f185b = 300;

    /* renamed from: c  reason: collision with root package name */
    private long f186c = 0;

    /* renamed from: d  reason: collision with root package name */
    private a f187d;

    /* renamed from: e  reason: collision with root package name */
    private HandlerThread f188e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f189f = false;

    /* renamed from: g  reason: collision with root package name */
    private ByteBuffer f190g = null;

    /* renamed from: h  reason: collision with root package name */
    private Bitmap f191h = null;

    /* renamed from: i  reason: collision with root package name */
    private int f192i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f193j = 0;
    private WeakReference<AbstractC0155b> k = null;

    /* renamed from: com.tencent.liteav.b$b  reason: collision with other inner class name */
    public interface AbstractC0155b {
        void a();

        void a(Bitmap bitmap, ByteBuffer byteBuffer, int i2, int i3);
    }

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(222358);
        bVar.f();
        AppMethodBeat.o(222358);
    }

    static {
        AppMethodBeat.i(222359);
        AppMethodBeat.o(222359);
    }

    public b(AbstractC0155b bVar) {
        AppMethodBeat.i(222353);
        this.k = new WeakReference<>(bVar);
        AppMethodBeat.o(222353);
    }

    public void a(int i2, int i3) {
        AppMethodBeat.i(16698);
        if (this.f189f) {
            TXCLog.w(f184a, "bkgpush: start background publish return when started");
            AppMethodBeat.o(16698);
            return;
        }
        this.f189f = true;
        b(i2, i3);
        d();
        if (this.f187d != null) {
            this.f187d.sendEmptyMessageDelayed(1001, (long) this.f185b);
        }
        TXCLog.w(f184a, "bkgpush: start background publish with time:" + ((this.f186c - System.currentTimeMillis()) / 1000) + ", interval:" + this.f185b);
        AppMethodBeat.o(16698);
    }

    public void a(int i2, int i3, Bitmap bitmap, int i4, int i5) {
        AppMethodBeat.i(222354);
        if (this.f189f) {
            TXCLog.w(f184a, "bkgpush: start background publish return when started");
            AppMethodBeat.o(222354);
            return;
        }
        if (bitmap == null) {
            try {
                TXCLog.w(f184a, "bkgpush: background publish img is empty, add default img " + i4 + "*" + i5);
                ColorDrawable colorDrawable = new ColorDrawable(WebView.NIGHT_MODE_COLOR);
                bitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
                colorDrawable.draw(new Canvas(bitmap));
            } catch (Exception e2) {
                TXCLog.e(f184a, "save bitmap failed.", e2);
            } catch (Error e3) {
                TXCLog.e(f184a, "save bitmap failed.", e3);
            }
        }
        TXCLog.w(f184a, "bkgpush: generate bitmap " + i4 + "*" + i5);
        this.f191h = bitmap;
        this.f192i = i4;
        this.f193j = i5;
        a(i2, i3);
        AppMethodBeat.o(222354);
    }

    public boolean a() {
        return this.f189f;
    }

    public void b() {
        AppMethodBeat.i(16693);
        this.f189f = false;
        this.f190g = null;
        this.f191h = null;
        TXCLog.w(f184a, "bkgpush: stop background publish");
        e();
        AppMethodBeat.o(16693);
    }

    private void b(int i2, int i3) {
        AppMethodBeat.i(16710);
        if (i2 > 0) {
            if (i2 >= 20) {
                i2 = 20;
            } else if (i2 <= 5) {
                i2 = 5;
            }
            this.f185b = 1000 / i2;
        } else {
            this.f185b = 200;
        }
        long j2 = (long) i3;
        if (i3 > 0) {
            this.f186c = (j2 * 1000) + System.currentTimeMillis();
            AppMethodBeat.o(16710);
        } else if (i3 == 0) {
            this.f186c = System.currentTimeMillis() + 300000;
            AppMethodBeat.o(16710);
        } else {
            this.f186c = -1;
            AppMethodBeat.o(16710);
        }
    }

    private void d() {
        AppMethodBeat.i(222355);
        e();
        this.f188e = new HandlerThread("TXImageCapturer");
        this.f188e.start();
        this.f187d = new a(this.f188e.getLooper(), this.f185b, this.f186c);
        AppMethodBeat.o(222355);
    }

    private void e() {
        AppMethodBeat.i(222356);
        if (this.f187d != null) {
            this.f187d.removeCallbacksAndMessages(null);
            this.f187d = null;
        }
        if (this.f188e != null) {
            this.f188e.quit();
            this.f188e = null;
        }
        AppMethodBeat.o(222356);
    }

    private void f() {
        int i2;
        int i3;
        int i4;
        AbstractC0155b bVar;
        int i5 = 0;
        AppMethodBeat.i(222357);
        try {
            if (!(this.k == null || !this.f189f || (bVar = this.k.get()) == null)) {
                Bitmap bitmap = this.f191h;
                ByteBuffer byteBuffer = this.f190g;
                if (byteBuffer != null || bitmap == null) {
                    i3 = 0;
                    i2 = 0;
                } else {
                    i2 = bitmap.getWidth();
                    try {
                        i5 = bitmap.getHeight();
                        byteBuffer = ByteBuffer.allocateDirect(i2 * i5 * 4);
                        bitmap.copyPixelsToBuffer(byteBuffer);
                        byteBuffer.rewind();
                        this.f190g = byteBuffer;
                        i3 = i5;
                    } catch (Exception e2) {
                        i4 = i5;
                        TXCLog.w(f184a, "bkgpush: generate bitmap pixel exception " + i2 + "*" + i4);
                        AppMethodBeat.o(222357);
                    } catch (Error e3) {
                        i3 = i5;
                        TXCLog.w(f184a, "bkgpush: generate bitmap pixel error " + i2 + "*" + i3);
                        AppMethodBeat.o(222357);
                    }
                }
                if (!(bitmap == null || byteBuffer == null)) {
                    try {
                        bVar.a(bitmap, byteBuffer, this.f192i, this.f193j);
                    } catch (Exception e4) {
                        i4 = i3;
                        TXCLog.w(f184a, "bkgpush: generate bitmap pixel exception " + i2 + "*" + i4);
                        AppMethodBeat.o(222357);
                    } catch (Error e5) {
                        TXCLog.w(f184a, "bkgpush: generate bitmap pixel error " + i2 + "*" + i3);
                        AppMethodBeat.o(222357);
                    }
                }
            }
            AppMethodBeat.o(222357);
        } catch (Exception e6) {
            i4 = 0;
            i2 = 0;
            TXCLog.w(f184a, "bkgpush: generate bitmap pixel exception " + i2 + "*" + i4);
            AppMethodBeat.o(222357);
        } catch (Error e7) {
            i3 = 0;
            i2 = 0;
            TXCLog.w(f184a, "bkgpush: generate bitmap pixel error " + i2 + "*" + i3);
            AppMethodBeat.o(222357);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private int f195b = 300;

        /* renamed from: c  reason: collision with root package name */
        private long f196c = 0;

        public a(Looper looper, int i2, long j2) {
            super(looper);
            AppMethodBeat.i(222589);
            this.f195b = i2;
            this.f196c = j2;
            TXCLog.w(b.f184a, "bkgpush:init publish time delay:" + this.f195b + ", end:" + this.f196c);
            AppMethodBeat.o(222589);
        }

        public void handleMessage(Message message) {
            AppMethodBeat.i(222590);
            if (message.what == 1001) {
                try {
                    b.a(b.this);
                    if (this.f196c < 0 || System.currentTimeMillis() < this.f196c) {
                        sendEmptyMessageDelayed(1001, (long) this.f195b);
                        AppMethodBeat.o(222590);
                        return;
                    }
                    TXCLog.w(b.f184a, "bkgpush:stop background publish when timeout");
                    if (b.this.k != null && b.this.f189f) {
                        AbstractC0155b bVar = (AbstractC0155b) b.this.k.get();
                        if (bVar != null) {
                            bVar.a();
                        }
                        b.this.f189f = false;
                    }
                    AppMethodBeat.o(222590);
                    return;
                } catch (Exception e2) {
                    TXCLog.e(b.f184a, "publish image failed." + e2.getMessage());
                }
            }
            AppMethodBeat.o(222590);
        }
    }
}
