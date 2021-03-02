package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.qbar.QbarNative;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class b {
    AtomicBoolean lQs = new AtomicBoolean(false);
    a lQt;
    MMHandler lQu = new MMHandler("MicroMsg.appbrand.ScanDecoder");

    public interface a {
        void a(int i2, String str, int i3, byte[] bArr, QbarNative.QBarPoint qBarPoint);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean a(byte[] bArr, int i2, int i3, int i4, int i5, Point point, Rect rect, int i6, int i7);

    /* access modifiers changed from: package-private */
    public abstract void init();

    /* access modifiers changed from: package-private */
    public abstract void release();

    public b(a aVar) {
        this.lQt = aVar;
    }

    /* access modifiers changed from: protected */
    public final void a(final String str, final int i2, final int i3, final byte[] bArr, final QbarNative.QBarPoint qBarPoint) {
        Log.d("MicroMsg.appbrand.ScanDecoder", "result:%b, resultText:%s, resultType:%d, codeType:%d, codeVersion:%d", Boolean.TRUE, str, Integer.valueOf(i2), 0, Integer.valueOf(i3));
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.camera.a.b.AnonymousClass2 */
            final /* synthetic */ int lQH = 0;

            public final void run() {
                AppMethodBeat.i(46235);
                if (b.this.lQt != null) {
                    b.this.lQt.a(i2, str, i3, bArr, qBarPoint);
                }
                AppMethodBeat.o(46235);
            }
        });
    }
}
