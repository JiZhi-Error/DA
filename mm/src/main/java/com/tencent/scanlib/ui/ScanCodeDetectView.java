package com.tencent.scanlib.ui;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.a;
import com.tencent.scanlib.a.a;
import com.tencent.scanlib.a.b;
import com.tencent.scanlib.b.c;
import com.tencent.scanlib.model.DetectCode;
import com.tencent.stubs.logger.Log;
import java.util.ArrayList;
import java.util.List;

public class ScanCodeDetectView extends ScanCodeView {
    private DetectCodeView RON;
    private c.AbstractC2187c ROO = new c.AbstractC2187c() {
        /* class com.tencent.scanlib.ui.ScanCodeDetectView.AnonymousClass1 */

        @Override // com.tencent.scanlib.b.c.AbstractC2187c
        public final void aj(final long j2, final long j3) {
            AppMethodBeat.i(3576);
            ScanCodeDetectView.this.post(new Runnable() {
                /* class com.tencent.scanlib.ui.ScanCodeDetectView.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(3572);
                    if (j2 == ScanCodeDetectView.this.CDU && j2 != 0) {
                        ScanCodeDetectView.this.IC(j3);
                    }
                    AppMethodBeat.o(3572);
                }
            });
            AppMethodBeat.o(3576);
        }

        @Override // com.tencent.scanlib.b.c.AbstractC2187c
        public final void b(final long j2, final Bundle bundle) {
            AppMethodBeat.i(3577);
            ScanCodeDetectView.this.post(new Runnable() {
                /* class com.tencent.scanlib.ui.ScanCodeDetectView.AnonymousClass1.AnonymousClass2 */

                public final void run() {
                    ArrayList<DetectCode> parcelableArrayList;
                    AppMethodBeat.i(3573);
                    if (j2 == ScanCodeDetectView.this.CDU && j2 != 0) {
                        if (bundle.containsKey("param_zoom_ratio")) {
                            float f2 = bundle.getFloat("param_zoom_ratio", 0.0f);
                            if (f2 > 0.0f && ScanCodeDetectView.this.ROY.dEO()) {
                                ((a) ScanCodeDetectView.this.ROY).aqE((int) (((float) ((a) ScanCodeDetectView.this.ROY).hkX()) * f2));
                            }
                        }
                        if (bundle.containsKey("param_detect_codes") && (parcelableArrayList = bundle.getParcelableArrayList("param_detect_codes")) != null && !parcelableArrayList.isEmpty()) {
                            for (DetectCode detectCode : parcelableArrayList) {
                                ArrayList arrayList = new ArrayList(detectCode.points.size());
                                for (Point point : detectCode.points) {
                                    arrayList.add(ScanCodeDetectView.a(ScanCodeDetectView.this, point));
                                }
                                detectCode.points = arrayList;
                            }
                            ScanCodeDetectView.this.RON.setDetectedCodes(parcelableArrayList);
                        }
                    }
                    AppMethodBeat.o(3573);
                }
            });
            AppMethodBeat.o(3577);
        }

        @Override // com.tencent.scanlib.b.c.AbstractC2187c
        public final void b(final long j2, final List<a.C2180a> list) {
            AppMethodBeat.i(3578);
            if (list != null && !list.isEmpty()) {
                ScanCodeDetectView.this.post(new Runnable() {
                    /* class com.tencent.scanlib.ui.ScanCodeDetectView.AnonymousClass1.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(3575);
                        if (ScanCodeDetectView.this.CDU == j2 && j2 != 0) {
                            c.hld().Iv(ScanCodeDetectView.this.CDU);
                            ScanCodeDetectView.this.CDU = 0;
                            ScanCodeDetectView.this.postDelayed(new Runnable() {
                                /* class com.tencent.scanlib.ui.ScanCodeDetectView.AnonymousClass1.AnonymousClass3.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(3574);
                                    ScanCodeDetectView.this.RON.setDetectedCodes(null);
                                    AppMethodBeat.o(3574);
                                }
                            }, 500);
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
                                Log.i("ScanCodeDetectView", String.format("scan result format: %d, content:%s", Integer.valueOf(i2), str));
                                if (ScanCodeDetectView.this.ROT != null) {
                                    ScanCodeDetectView.this.ROT.ay(bundle);
                                }
                            }
                        }
                        AppMethodBeat.o(3575);
                    }
                });
            }
            AppMethodBeat.o(3578);
        }
    };

    public ScanCodeDetectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(3580);
        AppMethodBeat.o(3580);
    }

    public ScanCodeDetectView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(3581);
        AppMethodBeat.o(3581);
    }

    @Override // com.tencent.scanlib.ui.ScanCodeView, com.tencent.scanlib.ui.ScanView
    public final void onResume() {
        AppMethodBeat.i(3582);
        if (!this.ROY.isOpen()) {
            a(new b.AbstractCallableC2185b.a() {
                /* class com.tencent.scanlib.ui.ScanCodeDetectView.AnonymousClass2 */

                @Override // com.tencent.scanlib.a.b.AbstractCallableC2185b.a
                public final void eRl() {
                    AppMethodBeat.i(3579);
                    ScanCodeDetectView.this.a(new b.d.a() {
                        /* class com.tencent.scanlib.ui.ScanCodeDetectView.AnonymousClass2.AnonymousClass1 */

                        @Override // com.tencent.scanlib.a.b.d.a
                        public final void eRk() {
                            AppMethodBeat.i(174602);
                            ScanCodeDetectView.this.IC(0);
                            AppMethodBeat.o(174602);
                        }
                    });
                    AppMethodBeat.o(3579);
                }
            });
        } else if (!this.ROY.dEO()) {
            a(new b.d.a() {
                /* class com.tencent.scanlib.ui.ScanCodeDetectView.AnonymousClass3 */

                @Override // com.tencent.scanlib.a.b.d.a
                public final void eRk() {
                    AppMethodBeat.i(174603);
                    ScanCodeDetectView.this.IC(0);
                    AppMethodBeat.o(174603);
                }
            });
        } else {
            IC(0);
        }
        this.CDU = System.currentTimeMillis();
        c.hld().a(this.CDU, this.ROO);
        AppMethodBeat.o(3582);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.scanlib.ui.ScanView
    public final void init() {
        AppMethodBeat.i(3583);
        super.init();
        this.RON = new DetectCodeView(getContext());
        addView(this.RON, new FrameLayout.LayoutParams(-1, -1));
        AppMethodBeat.o(3583);
    }

    static /* synthetic */ Point a(ScanCodeDetectView scanCodeDetectView, Point point) {
        AppMethodBeat.i(3584);
        float hkW = scanCodeDetectView.ROY.hkW();
        Point point2 = new Point((int) (((float) point.x) * hkW), (int) (hkW * ((float) point.y)));
        AppMethodBeat.o(3584);
        return point2;
    }
}
