package com.tencent.scanlib.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.a;
import com.tencent.scanlib.a.b;
import com.tencent.scanlib.b.c;
import com.tencent.stubs.logger.Log;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.List;

public class ScanCodeView extends ScanView {
    public long CDU;
    private c.AbstractC2187c ROO = new c.AbstractC2187c() {
        /* class com.tencent.scanlib.ui.ScanCodeView.AnonymousClass1 */

        @Override // com.tencent.scanlib.b.c.AbstractC2187c
        public final void aj(final long j2, final long j3) {
            AppMethodBeat.i(3588);
            ScanCodeView.this.post(new Runnable() {
                /* class com.tencent.scanlib.ui.ScanCodeView.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(3585);
                    if (j2 == ScanCodeView.this.CDU && j2 != 0) {
                        ScanCodeView.this.IC(j3);
                    }
                    AppMethodBeat.o(3585);
                }
            });
            AppMethodBeat.o(3588);
        }

        @Override // com.tencent.scanlib.b.c.AbstractC2187c
        public final void b(final long j2, final List<a.C2180a> list) {
            AppMethodBeat.i(3589);
            Log.d("ScanCodeView", String.format("after decode %d", Long.valueOf(j2)));
            if (list != null && !list.isEmpty()) {
                ScanCodeView.this.post(new Runnable() {
                    /* class com.tencent.scanlib.ui.ScanCodeView.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(3586);
                        if (ScanCodeView.this.CDU == j2 && j2 != 0) {
                            ScanCodeView.a(ScanCodeView.this);
                            if (list != null && !list.isEmpty()) {
                                Bundle bundle = new Bundle();
                                String str = ((a.C2180a) list.get(0)).data;
                                bundle.putString("result_content", str);
                                int i2 = ((a.C2180a) list.get(0)).typeID;
                                bundle.putInt("result_code_format", i2);
                                bundle.putString("result_code_name", ((a.C2180a) list.get(0)).typeName);
                                byte[] bArr = ((a.C2180a) list.get(0)).rawData;
                                if (bArr != null) {
                                    bundle.putByteArray("result_raw_data", bArr);
                                }
                                Log.i("ScanCodeView", String.format("scan result format: %d, content:%s", Integer.valueOf(i2), str));
                                if (ScanCodeView.this.ROT != null) {
                                    ScanCodeView.this.ROT.ay(bundle);
                                }
                            }
                        }
                        AppMethodBeat.o(3586);
                    }
                });
            }
            AppMethodBeat.o(3589);
        }

        @Override // com.tencent.scanlib.b.c.AbstractC2187c
        public final void b(final long j2, final Bundle bundle) {
            AppMethodBeat.i(3590);
            ScanCodeView.this.post(new Runnable() {
                /* class com.tencent.scanlib.ui.ScanCodeView.AnonymousClass1.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(3587);
                    if (j2 == ScanCodeView.this.CDU && j2 != 0 && bundle.containsKey("param_zoom_ratio")) {
                        float f2 = bundle.getFloat("param_zoom_ratio", 0.0f);
                        if (f2 > 0.0f && ScanCodeView.this.ROY.dEO()) {
                            ((com.tencent.scanlib.a.a) ScanCodeView.this.ROY).aqE((int) (((float) ((com.tencent.scanlib.a.a) ScanCodeView.this.ROY).hkX()) * f2));
                        }
                    }
                    AppMethodBeat.o(3587);
                }
            });
            AppMethodBeat.o(3590);
        }
    };
    public a ROT;

    public interface a {
        void ay(Bundle bundle);
    }

    static /* synthetic */ void a(ScanCodeView scanCodeView) {
        AppMethodBeat.i(3603);
        scanCodeView.eRa();
        AppMethodBeat.o(3603);
    }

    public ScanCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(3592);
        AppMethodBeat.o(3592);
    }

    public ScanCodeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(3593);
        AppMethodBeat.o(3593);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public void onCreate() {
        AppMethodBeat.i(3594);
        super.onCreate();
        c hld = c.hld();
        Context context = getContext();
        synchronized (hld.ROF) {
            try {
                if (!hld.ROF.hasInited()) {
                    hld.ROF.a(0, com.tencent.scanlib.a.lb(context));
                    if (hld.ROF.hasInited()) {
                        hld.ROF.T(hld.RKg);
                    }
                }
            } finally {
                AppMethodBeat.o(3594);
            }
        }
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public void onResume() {
        AppMethodBeat.i(3595);
        super.onResume();
        if (!this.ROY.isOpen()) {
            a(new b.AbstractCallableC2185b.a() {
                /* class com.tencent.scanlib.ui.ScanCodeView.AnonymousClass2 */

                @Override // com.tencent.scanlib.a.b.AbstractCallableC2185b.a
                public final void eRl() {
                    AppMethodBeat.i(3591);
                    ScanCodeView.this.a(new b.d.a() {
                        /* class com.tencent.scanlib.ui.ScanCodeView.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.scanlib.a.b.d.a
                        public final void eRk() {
                            AppMethodBeat.i(174604);
                            ScanCodeView.this.IC(0);
                            AppMethodBeat.o(174604);
                        }
                    });
                    AppMethodBeat.o(3591);
                }
            });
        } else if (!this.ROY.dEO()) {
            a(new b.d.a() {
                /* class com.tencent.scanlib.ui.ScanCodeView.AnonymousClass3 */

                @Override // com.tencent.scanlib.a.b.d.a
                public final void eRk() {
                    AppMethodBeat.i(174605);
                    ScanCodeView.this.IC(0);
                    AppMethodBeat.o(174605);
                }
            });
        } else {
            IC(0);
        }
        this.CDU = System.currentTimeMillis();
        c.hld().a(this.CDU, this.ROO);
        AppMethodBeat.o(3595);
    }

    private void eRa() {
        AppMethodBeat.i(3596);
        c.hld().Iv(this.CDU);
        this.CDU = 0;
        AppMethodBeat.o(3596);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public void onPause() {
        AppMethodBeat.i(3597);
        super.onPause();
        eRa();
        AppMethodBeat.o(3597);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public void onStop() {
        AppMethodBeat.i(3598);
        super.onStop();
        stopPreview();
        aPK();
        AppMethodBeat.o(3598);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public void onDestroy() {
        AppMethodBeat.i(3599);
        super.onDestroy();
        c hld = c.hld();
        Log.i("ScanDecodeQueue", "release QBar");
        synchronized (hld.ROF) {
            try {
                hld.ROF.release();
            } finally {
                AppMethodBeat.o(3599);
            }
        }
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        AppMethodBeat.i(LocalCache.TIME_HOUR);
        super.onPreviewFrame(bArr, camera);
        Log.d("ScanCodeView", "onPreviewFrame null data:" + (bArr == null));
        if (this.CDU != 0 && this.ROY.dEO()) {
            Point hkU = this.ROY.hkU();
            Rect w = ((com.tencent.scanlib.a.a) this.ROY).w(new Rect(0, 0, getWidth(), getHeight()));
            c hld = c.hld();
            int cameraRotation = this.ROY.getCameraRotation();
            synchronized (hld.CCt) {
                try {
                    Log.d("ScanDecodeQueue", String.format("%d submit crop gray", Long.valueOf(hld.CDU)));
                    if (hld.CDU != 0) {
                        hld.ROH.execute(new c.a(hld.CDU, bArr, hkU, cameraRotation, w));
                    }
                } finally {
                    AppMethodBeat.o(LocalCache.TIME_HOUR);
                }
            }
            if (!((com.tencent.scanlib.a.a) this.ROY).eQZ() && c.hld().CDX > 50) {
                Log.i("ScanCodeView", "change to FOCUS_MODE_AUTO");
                this.ROY.setFocusMode("auto");
                Oy(100);
            }
        }
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public void onAutoFocus(boolean z, Camera camera) {
        AppMethodBeat.i(3601);
        Log.i("ScanCodeView", "onAutoFocus %s", Boolean.valueOf(z));
        if (z) {
            IC(0);
        }
        Oy(1000);
        AppMethodBeat.o(3601);
    }

    public void setScanCallBack(a aVar) {
        this.ROT = aVar;
    }

    public void setScanCodeReaders(int[] iArr) {
        AppMethodBeat.i(3602);
        c hld = c.hld();
        if (iArr == null || iArr.length <= 0) {
            AppMethodBeat.o(3602);
            return;
        }
        synchronized (hld.ROF) {
            try {
                hld.RKg = iArr;
                if (hld.ROF.hasInited()) {
                    hld.ROF.T(hld.RKg);
                }
            } finally {
                AppMethodBeat.o(3602);
            }
        }
    }
}
