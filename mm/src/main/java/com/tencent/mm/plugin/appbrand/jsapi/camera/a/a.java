package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.g;

public final class a extends b {
    private Object duI = new Object();
    private g lQo = new g("MicroMsg.appbrand.ScanQBarDecoder");
    private volatile boolean lQp = false;
    private byte[] lQq;
    byte[] lQr;
    private String type;

    public a(b.a aVar, String str) {
        super(aVar);
        AppMethodBeat.i(46229);
        this.type = str;
        AppMethodBeat.o(46229);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008c  */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.a.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void init() {
        /*
        // Method dump skipped, instructions count: 237
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.init():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x034c  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x035a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02e1  */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.a.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(byte[] r18, int r19, int r20, int r21, int r22, android.graphics.Point r23, android.graphics.Rect r24, int r25, int r26) {
        /*
        // Method dump skipped, instructions count: 1356
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.a(byte[], int, int, int, int, android.graphics.Point, android.graphics.Rect, int, int):boolean");
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.a.b
    public final void release() {
        AppMethodBeat.i(46232);
        Log.i("MicroMsg.appbrand.ScanQBarDecoder", "release");
        releaseDecoder();
        AppMethodBeat.o(46232);
    }

    private void releaseDecoder() {
        AppMethodBeat.i(46233);
        synchronized (this.duI) {
            try {
                if (this.lQp) {
                    if (this.lQo != null) {
                        this.lQo.release();
                    }
                    this.lQo = null;
                    this.lQp = false;
                    Log.d("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative.Release()");
                }
            } finally {
                AppMethodBeat.o(46233);
            }
        }
    }
}
