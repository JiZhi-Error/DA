package com.tencent.mm.plugin.scanner.util;

import android.os.HandlerThread;
import android.os.Message;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;

public class ScanCameraLightDetector {
    public static final ScanCameraLightDetector CTx = new ScanCameraLightDetector();
    private long CTA = -1;
    private HandlerThread CTB;
    private final int CTy = 2;
    private int CTz;
    private MMHandler handler;
    private String imR;
    private float sQv = -1.0f;

    private static native int calcLumNative(byte[] bArr, int i2, int i3);

    static /* synthetic */ int b(ScanCameraLightDetector scanCameraLightDetector) {
        int i2 = scanCameraLightDetector.CTz;
        scanCameraLightDetector.CTz = i2 + 1;
        return i2;
    }

    static {
        AppMethodBeat.i(91077);
        AppMethodBeat.o(91077);
    }

    public final void start(String str) {
        AppMethodBeat.i(91072);
        try {
            this.imR = str;
            eRS();
            AppMethodBeat.o(91072);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanCameraLightDetector", e2, "start error: %s", e2.getMessage());
            AppMethodBeat.o(91072);
        }
    }

    public final void stop() {
        AppMethodBeat.i(91073);
        try {
            this.CTA = -1;
            if (this.CTB != null) {
                this.CTB.quit();
            }
            AppMethodBeat.o(91073);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanCameraLightDetector", e2, "stop error: %s", e2.getMessage());
            AppMethodBeat.o(91073);
        }
    }

    private void eRS() {
        AppMethodBeat.i(91074);
        Log.i("MicroMsg.ScanCameraLightDetector", "alvinluo initDetectThread");
        stop();
        this.CTB = d.hB("ScanCameraLightDetector_detectThread", 5);
        this.CTB.start();
        this.handler = new MMHandler(this.CTB.getLooper()) {
            /* class com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                a aVar;
                AppMethodBeat.i(91071);
                if (message.what == 233 && (aVar = (a) message.obj) != null) {
                    long currentTicks = Util.currentTicks();
                    boolean O = ScanCameraLightDetector.O(aVar.zvl, aVar.width, aVar.height);
                    Log.i("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", Boolean.valueOf(O), Float.valueOf(ScanCameraLightDetector.this.sQv), Long.valueOf(Util.ticksToNow(currentTicks)));
                    if (O) {
                        Log.i("MicroMsg.ScanCameraLightDetector", "is dark now");
                        ScanCameraLightDetector.b(ScanCameraLightDetector.this);
                        if (!ScanCameraLightDetector.this.imR.equals("continuous-video") || ScanCameraLightDetector.this.CTz >= 2) {
                            ScanCameraLightDetector.this.CTz = 0;
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(91069);
                                    ti tiVar = new ti();
                                    tiVar.dZN.dZO = true;
                                    EventCenter.instance.publish(tiVar);
                                    AppMethodBeat.o(91069);
                                }
                            });
                            AppMethodBeat.o(91071);
                            return;
                        }
                        AppMethodBeat.o(91071);
                        return;
                    }
                    Log.i("MicroMsg.ScanCameraLightDetector", "not dark");
                    ScanCameraLightDetector.this.CTz = 0;
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(91070);
                            ti tiVar = new ti();
                            tiVar.dZN.dZO = false;
                            EventCenter.instance.publish(tiVar);
                            AppMethodBeat.o(91070);
                        }
                    });
                }
                AppMethodBeat.o(91071);
            }
        };
        AppMethodBeat.o(91074);
    }

    public final void N(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(91075);
        if ((this.CTA < 0 || Util.ticksToNow(this.CTA) >= 1000) && this.handler != null && this.CTB != null && this.CTB.isAlive()) {
            a aVar = new a(this, (byte) 0);
            aVar.zvl = bArr;
            aVar.width = i2;
            aVar.height = i3;
            Message obtain = Message.obtain();
            obtain.what = TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS;
            obtain.obj = aVar;
            this.handler.sendMessage(obtain);
            this.CTA = Util.currentTicks();
        }
        AppMethodBeat.o(91075);
    }

    /* access modifiers changed from: package-private */
    public class a {
        int height;
        int width;
        byte[] zvl;

        private a() {
        }

        /* synthetic */ a(ScanCameraLightDetector scanCameraLightDetector, byte b2) {
            this();
        }
    }

    static /* synthetic */ boolean O(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(91076);
        if (!Util.isNullOrNil(bArr) && bArr.length > i2 * i3) {
            int calcLumNative = calcLumNative(bArr, i2, i3);
            Log.i("MicroMsg.ScanCameraLightDetector", "lum light: %s", Integer.valueOf(calcLumNative));
            if (calcLumNative < 50) {
                AppMethodBeat.o(91076);
                return true;
            }
        }
        AppMethodBeat.o(91076);
        return false;
    }
}
