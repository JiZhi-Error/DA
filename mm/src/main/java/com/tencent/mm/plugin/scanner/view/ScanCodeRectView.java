package com.tencent.mm.plugin.scanner.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.WxQbarNative;
import com.tencent.qbar.a;
import com.tencent.qbar.h;
import com.tencent.scanlib.a.b;
import com.tencent.scanlib.ui.ScanCodeView;
import java.util.List;

public class ScanCodeRectView extends ScanCodeView {
    ScanRectDecorView CNj;
    private h.c CVl;

    public ScanCodeRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScanCodeRectView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void init() {
        AppMethodBeat.i(91099);
        super.init();
        this.CNj = new ScanRectDecorView(getContext());
        addView(this.CNj, new FrameLayout.LayoutParams(-1, -1));
        this.CVl = new h.c() {
            /* class com.tencent.mm.plugin.scanner.view.ScanCodeRectView.AnonymousClass1 */

            @Override // com.tencent.qbar.h.c
            public final void aj(final long j2, final long j3) {
                AppMethodBeat.i(91095);
                ScanCodeRectView.this.post(new Runnable() {
                    /* class com.tencent.mm.plugin.scanner.view.ScanCodeRectView.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(91092);
                        if (j2 == ScanCodeRectView.this.CDU && j2 != 0) {
                            ScanCodeRectView.this.IC(j3);
                        }
                        AppMethodBeat.o(91092);
                    }
                });
                AppMethodBeat.o(91095);
            }

            @Override // com.tencent.qbar.h.c
            public final void a(final long j2, final List<a.C2180a> list, List<QbarNative.QBarPoint> list2, final List<WxQbarNative.QBarReportMsg> list3, Bundle bundle) {
                AppMethodBeat.i(194812);
                Log.d("MicroMsg.ScanCodeRectView", String.format("after decode %d", Long.valueOf(j2)));
                if (list != null && !list.isEmpty()) {
                    ScanCodeRectView.this.post(new Runnable() {
                        /* class com.tencent.mm.plugin.scanner.view.ScanCodeRectView.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(91093);
                            if (ScanCodeRectView.this.CDU == j2 && j2 != 0) {
                                h.hkp().Iv(ScanCodeRectView.this.CDU);
                                ScanCodeRectView.this.CDU = 0;
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
                                    if (list3 != null && !list3.isEmpty()) {
                                        bundle.putInt("result_code_version", ((WxQbarNative.QBarReportMsg) list3.get(0)).qrcodeVersion);
                                    }
                                    ScanCodeRectView.this.CNj.cWj();
                                    Log.i("MicroMsg.ScanCodeRectView", "scan result format: %d, content:", Integer.valueOf(i2), str);
                                    if (ScanCodeRectView.this.ROT != null) {
                                        ScanCodeRectView.this.ROT.ay(bundle);
                                    }
                                }
                            }
                            AppMethodBeat.o(91093);
                        }
                    });
                }
                AppMethodBeat.o(194812);
            }

            @Override // com.tencent.qbar.h.c
            public final void b(final long j2, final Bundle bundle) {
                AppMethodBeat.i(91097);
                ScanCodeRectView.this.post(new Runnable() {
                    /* class com.tencent.mm.plugin.scanner.view.ScanCodeRectView.AnonymousClass1.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(91094);
                        if (j2 == ScanCodeRectView.this.CDU && j2 != 0 && bundle.containsKey("param_zoom_ratio")) {
                            float f2 = (float) bundle.getInt("param_zoom_ratio", 0);
                            if (f2 > 0.0f && ScanCodeRectView.this.ROY.dEO()) {
                                ((com.tencent.scanlib.a.a) ScanCodeRectView.this.ROY).aqE((int) (((float) ((com.tencent.scanlib.a.a) ScanCodeRectView.this.ROY).hkX()) * f2));
                            }
                        }
                        AppMethodBeat.o(91094);
                    }
                });
                AppMethodBeat.o(91097);
            }
        };
        AppMethodBeat.o(91099);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void eQY() {
        AppMethodBeat.i(91100);
        this.ROY = new com.tencent.mm.plugin.scanner.a.a();
        AppMethodBeat.o(91100);
    }

    @Override // com.tencent.scanlib.ui.ScanCodeView, com.tencent.scanlib.ui.ScanView
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(91101);
        super.onPreviewFrame(bArr, camera);
        Log.d("MicroMsg.ScanCodeRectView", "onPreviewFrame null data:" + (bArr == null));
        if (this.CDU != 0 && this.ROY.dEO()) {
            Point hkU = this.ROY.hkU();
            com.tencent.scanlib.a.a aVar = (com.tencent.scanlib.a.a) this.ROY;
            Rect decorRect = getDecorRect();
            Rect rect = new Rect();
            ((Activity) getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            Point point = new Point(rect.width(), rect.height());
            Rect rect2 = new Rect();
            int width = (int) (((float) decorRect.width()) * 0.5f);
            int height = (int) (((float) decorRect.height()) * 0.5f);
            rect2.left = decorRect.left - (width / 2);
            rect2.right = (width / 2) + decorRect.right;
            rect2.top = decorRect.top - (height / 2);
            rect2.bottom = decorRect.bottom + (height / 2);
            rect2.left = rect2.left < 0 ? 0 : rect2.left;
            rect2.right = rect2.right > point.x ? point.x : rect2.right;
            if (rect2.top >= 0) {
                i3 = rect2.top;
            }
            rect2.top = i3;
            if (rect2.bottom > point.y) {
                i2 = point.y;
            } else {
                i2 = rect2.bottom;
            }
            rect2.bottom = i2;
            h.hkp().a(bArr, hkU, this.ROY.getCameraRotation(), aVar.w(rect2));
            if (!((com.tencent.scanlib.a.a) this.ROY).eQZ() && h.hkp().CDX > 50) {
                Log.i("MicroMsg.ScanCodeRectView", "change to FOCUS_MODE_AUTO");
                this.ROY.setFocusMode("auto");
                Oy(100);
            }
        }
        AppMethodBeat.o(91101);
    }

    @Override // com.tencent.scanlib.ui.ScanCodeView, com.tencent.scanlib.ui.ScanView
    public final void onCreate() {
        AppMethodBeat.i(91102);
        super.onCreate();
        h.hkp().init(getContext());
        AppMethodBeat.o(91102);
    }

    @Override // com.tencent.scanlib.ui.ScanCodeView, com.tencent.scanlib.ui.ScanView
    public final void onResume() {
        AppMethodBeat.i(91103);
        if (!this.ROY.isOpen()) {
            a(new b.AbstractCallableC2185b.a() {
                /* class com.tencent.mm.plugin.scanner.view.ScanCodeRectView.AnonymousClass2 */

                @Override // com.tencent.scanlib.a.b.AbstractCallableC2185b.a
                public final void eRl() {
                    AppMethodBeat.i(91098);
                    ScanCodeRectView.this.a(new b.d.a() {
                        /* class com.tencent.mm.plugin.scanner.view.ScanCodeRectView.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.scanlib.a.b.d.a
                        public final void eRk() {
                            AppMethodBeat.i(176201);
                            ScanCodeRectView.this.IC(0);
                            AppMethodBeat.o(176201);
                        }
                    });
                    AppMethodBeat.o(91098);
                }
            });
        } else if (!this.ROY.dEO()) {
            a(new b.d.a() {
                /* class com.tencent.mm.plugin.scanner.view.ScanCodeRectView.AnonymousClass3 */

                @Override // com.tencent.scanlib.a.b.d.a
                public final void eRk() {
                    AppMethodBeat.i(176202);
                    ScanCodeRectView.this.IC(0);
                    AppMethodBeat.o(176202);
                }
            });
        } else {
            IC(0);
        }
        this.CDU = System.currentTimeMillis();
        h.hkp().a(this.CDU, this.CVl);
        this.CNj.cWi();
        AppMethodBeat.o(91103);
    }

    @Override // com.tencent.scanlib.ui.ScanCodeView, com.tencent.scanlib.ui.ScanView
    public final void onPause() {
        AppMethodBeat.i(91104);
        h.hkp().Iv(this.CDU);
        this.CDU = 0;
        this.CNj.cWj();
        AppMethodBeat.o(91104);
    }

    @Override // com.tencent.scanlib.ui.ScanCodeView, com.tencent.scanlib.ui.ScanView
    public void onAutoFocus(boolean z, Camera camera) {
        AppMethodBeat.i(91105);
        Log.i("MicroMsg.ScanCodeRectView", "onAutoFocus %s", Boolean.valueOf(z));
        if (z) {
            IC(0);
        }
        Oy((long) RPb);
        AppMethodBeat.o(91105);
    }

    @Override // com.tencent.scanlib.ui.ScanCodeView, com.tencent.scanlib.ui.ScanView
    public final void onStop() {
        AppMethodBeat.i(91106);
        super.onStop();
        AppMethodBeat.o(91106);
    }

    @Override // com.tencent.scanlib.ui.ScanCodeView, com.tencent.scanlib.ui.ScanView
    public final void onDestroy() {
        AppMethodBeat.i(91107);
        super.onDestroy();
        h.hkp().release();
        AppMethodBeat.o(91107);
    }

    public Rect getDecorRect() {
        AppMethodBeat.i(91108);
        Rect decorRect = this.CNj.getDecorRect();
        AppMethodBeat.o(91108);
        return decorRect;
    }

    public void setDecorRect(Rect rect) {
        AppMethodBeat.i(91109);
        this.CNj.setDecorRect(rect);
        AppMethodBeat.o(91109);
    }

    @Override // com.tencent.scanlib.ui.ScanCodeView
    public void setScanCodeReaders(int[] iArr) {
        AppMethodBeat.i(91110);
        h.hkp().S(iArr);
        AppMethodBeat.o(91110);
    }
}
