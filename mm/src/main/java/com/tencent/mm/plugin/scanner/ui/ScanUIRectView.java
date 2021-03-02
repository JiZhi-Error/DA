package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.d.a;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.plugin.scanner.model.af;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.model.an;
import com.tencent.mm.plugin.scanner.model.f;
import com.tencent.mm.plugin.scanner.model.x;
import com.tencent.mm.plugin.scanner.model.y;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanAnimationDotsView;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanDebugView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.plugin.scanner.util.l;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.ScanRectDecorView;
import com.tencent.mm.plugin.scanner.view.ScanTranslationMaskView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qbar.QbarNative;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarPoint;
import com.tencent.qbar.WxQBarResult;
import com.tencent.qbar.WxQbarNative;
import com.tencent.qbar.a;
import com.tencent.qbar.c;
import com.tencent.qbar.h;
import com.tencent.scanlib.a.b;
import com.tencent.scanlib.ui.ScanView;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.e;
import kotlin.g.b.p;

public class ScanUIRectView extends ScanView {
    public static final int CNv = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scan_code_continuous_max_frame, 50);
    private float CBd;
    private long CDU;
    BaseScanMaskView CGD;
    ScanSharedMaskView CGE;
    private BaseScanRequest CJD;
    private boolean CJO = false;
    private ScannerFlashSwitcher CJh;
    private com.tencent.mm.plugin.scanner.ui.widget.b CJn;
    private boolean CJu = true;
    boolean CJv = false;
    private int CNA = 0;
    private long CNB = 0;
    private boolean CNC = false;
    private boolean CND = true;
    private boolean CNE = false;
    private Runnable CNF = new Runnable() {
        /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(51916);
            if (ScanUIRectView.a(ScanUIRectView.this) && !ScanUIRectView.this.CNC) {
                ScanUIRectView.this.CND = false;
                ScanUIRectView.this.CNC = true;
                af.eQj();
                ScanUIRectView.e(ScanUIRectView.this);
            }
            AppMethodBeat.o(51916);
        }
    };
    private int CNG = 0;
    private int CNH = 0;
    private h.c CNI = new h.c() {
        /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass3 */

        @Override // com.tencent.qbar.h.c
        public final void aj(final long j2, final long j3) {
            AppMethodBeat.i(240780);
            ScanUIRectView.this.post(new Runnable() {
                /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass3.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(161013);
                    if (j2 == ScanUIRectView.this.CDU && j2 != 0) {
                        ScanUIRectView.this.IC(j3);
                    }
                    AppMethodBeat.o(161013);
                }
            });
            AppMethodBeat.o(240780);
        }

        @Override // com.tencent.qbar.h.c
        public final void a(final long j2, final List<a.C2180a> list, final List<QbarNative.QBarPoint> list2, final List<WxQbarNative.QBarReportMsg> list3, final Bundle bundle) {
            AppMethodBeat.i(240781);
            Log.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", Long.valueOf(j2)));
            if (list != null && !list.isEmpty()) {
                ScanUIRectView.this.post(new Runnable() {
                    /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass3.AnonymousClass2 */

                    public final void run() {
                        QbarNative.QBarPoint qBarPoint;
                        WxQbarNative.QBarReportMsg qBarReportMsg;
                        AppMethodBeat.i(161014);
                        if (ScanUIRectView.this.CDU == j2 && j2 != 0) {
                            ScanUIRectView.this.eRa();
                            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                            if (list != null && !list.isEmpty()) {
                                Log.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", Integer.valueOf(list.size()));
                                int i2 = 0;
                                int i3 = 0;
                                while (i2 < list.size()) {
                                    a.C2180a aVar = (a.C2180a) list.get(i2);
                                    WxQBarResult wxQBarResult = new WxQBarResult(aVar.typeID, aVar.typeName, aVar.data, aVar.rawData, aVar.charset, aVar.priorityLevel);
                                    Log.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", Integer.valueOf(i2), Integer.valueOf(wxQBarResult.typeID), wxQBarResult.data);
                                    if (!(list3 == null || list3.size() < i2 + 1 || (qBarReportMsg = (WxQbarNative.QBarReportMsg) list3.get(i2)) == null)) {
                                        wxQBarResult.RJN = qBarReportMsg.qrcodeVersion;
                                    }
                                    if (!(list2 == null || list2.size() < i2 + 1 || (qBarPoint = (QbarNative.QBarPoint) list2.get(i2)) == null)) {
                                        wxQBarResult.RKp = new WxQBarPoint(qBarPoint);
                                        i3++;
                                    }
                                    arrayList.add(wxQBarResult);
                                    i2++;
                                    i3 = i3;
                                }
                                Bundle bundle = new Bundle();
                                bundle.putParcelableArrayList("result_qbar_result_list", arrayList);
                                bundle.putInt("result_code_point_count", i3);
                                if (bundle != null) {
                                    bundle.putAll(bundle);
                                }
                                ScanUIRectView.this.cWj();
                                if (ScanUIRectView.this.CNl != null) {
                                    ScanUIRectView.this.CNl.e(ScanUIRectView.this.CDU, bundle);
                                }
                            }
                        }
                        AppMethodBeat.o(161014);
                    }
                });
            }
            AppMethodBeat.o(240781);
        }

        @Override // com.tencent.qbar.h.c
        public final void b(final long j2, final Bundle bundle) {
            AppMethodBeat.i(240782);
            ScanUIRectView.this.post(new Runnable() {
                /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass3.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(161015);
                    if (j2 == ScanUIRectView.this.CDU && j2 != 0 && bundle.containsKey("param_zoom_ratio")) {
                        float f2 = bundle.getFloat("param_zoom_ratio", 0.0f);
                        Log.i("MicroMsg.ScanUIRectView", "zoom to scale %f", Float.valueOf(f2));
                        if (f2 > 0.0f && ScanUIRectView.this.CNt && ScanUIRectView.this.ROY.dEO()) {
                            ((com.tencent.scanlib.a.a) ScanUIRectView.this.ROY).aqE((int) (((float) ((com.tencent.scanlib.a.a) ScanUIRectView.this.ROY).hkX()) * f2));
                            c cVar = c.RJE;
                            cVar.RJS++;
                            cVar.RJT *= f2;
                            cVar.RJU = System.currentTimeMillis() - cVar.CHf;
                            Log.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", Integer.valueOf(cVar.RJS), Float.valueOf(f2), Float.valueOf(cVar.RJT), Long.valueOf(cVar.RJU));
                        }
                    }
                    AppMethodBeat.o(161015);
                }
            });
            AppMethodBeat.o(240782);
        }
    };
    private a.AbstractC1668a CNJ = new a.AbstractC1668a() {
        /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass4 */

        @Override // com.tencent.mm.plugin.scanner.d.b.a
        public final void a(final long j2, final Bundle bundle) {
            AppMethodBeat.i(240786);
            Log.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", Long.valueOf(j2));
            if (bundle.getBoolean("result_is_best_img", false)) {
                ScanUIRectView.this.post(new Runnable() {
                    /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(240783);
                        if (!(j2 != ScanUIRectView.this.CDU || ScanUIRectView.this.CDU == 0 || ScanUIRectView.this.CNl == null)) {
                            ScanUIRectView.this.CNl.e(ScanUIRectView.this.CDU, bundle);
                        }
                        AppMethodBeat.o(240783);
                    }
                });
            }
            AppMethodBeat.o(240786);
        }

        @Override // com.tencent.mm.plugin.scanner.d.b.a
        public final void Iw(final long j2) {
            AppMethodBeat.i(240787);
            Log.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", Long.valueOf(j2), 0L);
            ScanUIRectView.this.post(new Runnable() {
                /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass4.AnonymousClass2 */
                final /* synthetic */ long ynh = 0;

                public final void run() {
                    AppMethodBeat.i(240784);
                    if (ScanUIRectView.this.CDU == j2 && ScanUIRectView.this.CDU != 0) {
                        ScanUIRectView.this.IC(this.ynh);
                    }
                    AppMethodBeat.o(240784);
                }
            });
            AppMethodBeat.o(240787);
        }

        @Override // com.tencent.mm.plugin.scanner.d.a.AbstractC1668a
        public final void a(final ae aeVar) {
            AppMethodBeat.i(240788);
            ScanUIRectView.this.post(new Runnable() {
                /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass4.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(240785);
                    if (aeVar != null && (ScanUIRectView.this.CGD instanceof ScanGoodsMaskView)) {
                        ScanGoodsMaskView scanGoodsMaskView = (ScanGoodsMaskView) ScanUIRectView.this.CGD;
                        ae aeVar = aeVar;
                        p.h(aeVar, "pointsResult");
                        if (scanGoodsMaskView.CUN) {
                            Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
                            AppMethodBeat.o(240785);
                            return;
                        }
                        ScanPoint[] scanPointArr = aeVar.points;
                        if (scanPointArr != null) {
                            Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", Integer.valueOf(aeVar.pointCount));
                            int i2 = aeVar.pointCount;
                            for (int i3 = 0; i3 < i2; i3++) {
                                ScanPoint scanPoint = (ScanPoint) e.f(scanPointArr, i3);
                                Object[] objArr = new Object[3];
                                objArr[0] = scanPoint != null ? Integer.valueOf(scanPoint.getId()) : null;
                                objArr[1] = scanPoint != null ? Float.valueOf(scanPoint.getX()) : null;
                                objArr[2] = scanPoint != null ? Float.valueOf(scanPoint.getY()) : null;
                                Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", objArr);
                            }
                            ScanAnimationDotsView scanAnimationDotsView = scanGoodsMaskView.CPO;
                            if (scanAnimationDotsView == null) {
                                p.btv("animationDotsView");
                            }
                            scanAnimationDotsView.b(aeVar);
                        }
                    }
                    AppMethodBeat.o(240785);
                }
            });
            AppMethodBeat.o(240788);
        }
    };
    private IListener<tj> CNK = new IListener<tj>() {
        /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass6 */

        {
            AppMethodBeat.i(161023);
            this.__eventId = tj.class.getName().hashCode();
            AppMethodBeat.o(161023);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tj tjVar) {
            AppMethodBeat.i(161024);
            if (tjVar.dZP.dDe == 1) {
                if (!((com.tencent.mm.plugin.scanner.a.a) ScanUIRectView.this.ROY).ePD()) {
                    ((com.tencent.mm.plugin.scanner.a.a) ScanUIRectView.this.ROY).ejE();
                }
            } else if (((com.tencent.mm.plugin.scanner.a.a) ScanUIRectView.this.ROY).ePD()) {
                ((com.tencent.mm.plugin.scanner.a.a) ScanUIRectView.this.ROY).ejF();
            }
            AppMethodBeat.o(161024);
            return true;
        }
    };
    private b CNL = new b(Looper.getMainLooper());
    private ScanRectDecorView CNj;
    ScanDebugView CNk;
    private a CNl;
    private String CNm;
    f CNn;
    private boolean CNo = true;
    private boolean CNp = false;
    private int CNq = 0;
    private int CNr = 120;
    private boolean CNs;
    private boolean CNt = true;
    private boolean CNu = false;
    private boolean CNw = false;
    private boolean CNx = false;
    private boolean CNy = false;
    private com.tencent.mm.plugin.scanner.util.h CNz = new com.tencent.mm.plugin.scanner.util.h();
    private Activity activity;
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass5 */

        {
            AppMethodBeat.i(161021);
            AppMethodBeat.o(161021);
        }

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(240790);
            Log.i("MicroMsg.ScanUIRectView", "onGetLocation %s", Boolean.valueOf(z));
            if (!z) {
                Log.i("MicroMsg.ScanUIRectView", "check permission not passed!");
                if (!ScanUIRectView.this.uSu && !d.bcc()) {
                    ScanUIRectView.this.uSu = true;
                    com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(R.string.dvi), ScanUIRectView.this.getContext().getString(R.string.zb), ScanUIRectView.this.getContext().getString(R.string.e_k), ScanUIRectView.this.getContext().getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass5.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(240789);
                            d.cZ(ScanUIRectView.this.getContext());
                            AppMethodBeat.o(240789);
                        }
                    }, (DialogInterface.OnClickListener) null);
                }
                AppMethodBeat.o(240790);
                return true;
            } else if (ScanUIRectView.this.CNs) {
                Log.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
                AppMethodBeat.o(240790);
                return false;
            } else {
                ScanUIRectView.this.cWj();
                ScanUIRectView.this.CNs = true;
                o.a(2012, f2, f3, (int) d3);
                if (ScanUIRectView.this.CNl != null) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("result_lbs_latitude", f3);
                    bundle.putFloat("result_lbs_longitude", f2);
                    bundle.putInt("result_lbs_accuracy", (int) d3);
                    bundle.putInt("result_lbs_source", i2);
                    ScanUIRectView.this.CNl.e(ScanUIRectView.this.CDU, bundle);
                }
                AppMethodBeat.o(240790);
                return false;
            }
        }
    };
    private d iOv;
    private boolean isFirst = true;
    private boolean isRetry = false;
    private GestureDetector jKk = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
        /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass7 */

        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(240793);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(240793);
            return onContextClick;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(240792);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            super.onLongPress(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(240792);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(240791);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(240791);
            return onSingleTapUp;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(161025);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            Log.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", Integer.valueOf(motionEvent.getActionIndex()), Float.valueOf(motionEvent.getX(motionEvent.getActionIndex())), Float.valueOf(motionEvent.getY(motionEvent.getActionIndex())));
            ((com.tencent.scanlib.a.a) ScanUIRectView.this.ROY).aqF(5);
            af.ia(ScanUIRectView.this.mode, 3);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(161025);
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            AppMethodBeat.i(161026);
            Log.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(ScanUIRectView.this.CNp), Boolean.valueOf(ScanUIRectView.this.CNo), Boolean.valueOf(ScanUIRectView.this.xsN));
            if (!ScanUIRectView.this.xsN && ScanUIRectView.this.CNo && Math.abs(f2) > Math.abs(f3)) {
                if (f2 < -1200.0f && ScanUIRectView.this.CNp) {
                    if (ScanUIRectView.this.CJn != null) {
                        ScanUIRectView.this.CJn.eRD();
                    }
                    ScanUIRectView.this.CNp = false;
                } else if (f2 > 1200.0f && ScanUIRectView.this.CNp) {
                    if (ScanUIRectView.this.CJn != null) {
                        ScanUIRectView.this.CJn.eRE();
                    }
                    ScanUIRectView.this.CNp = false;
                }
            }
            boolean onFling = super.onFling(motionEvent, motionEvent2, f2, f3);
            AppMethodBeat.o(161026);
            return onFling;
        }
    });
    private long lastShotTime;
    private long mTimeout = this.CNz.mTimeout;
    int mode = 1;
    private Point sRG = null;
    private boolean uSu;
    private boolean xsN = false;

    public interface a {
        void e(long j2, Bundle bundle);
    }

    static /* synthetic */ void a(ScanUIRectView scanUIRectView, Object obj, com.tencent.mm.plugin.scanner.view.d dVar) {
        AppMethodBeat.i(240802);
        scanUIRectView.a(obj, dVar);
        AppMethodBeat.o(240802);
    }

    static /* synthetic */ void a(ScanUIRectView scanUIRectView, boolean z) {
        AppMethodBeat.i(240803);
        scanUIRectView.tY(z);
        AppMethodBeat.o(240803);
    }

    static /* synthetic */ void a(ScanUIRectView scanUIRectView, byte[] bArr) {
        AppMethodBeat.i(240801);
        scanUIRectView.bX(bArr);
        AppMethodBeat.o(240801);
    }

    static /* synthetic */ byte[] k(ScanUIRectView scanUIRectView) {
        AppMethodBeat.i(240800);
        byte[] eRb = scanUIRectView.eRb();
        AppMethodBeat.o(240800);
        return eRb;
    }

    static {
        AppMethodBeat.i(51980);
        AppMethodBeat.o(51980);
    }

    public ScanUIRectView(Context context) {
        super(context);
        AppMethodBeat.i(51945);
        AppMethodBeat.o(51945);
    }

    public ScanUIRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(51946);
        AppMethodBeat.o(51946);
    }

    public ScanUIRectView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(51947);
        AppMethodBeat.o(51947);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void eQY() {
        AppMethodBeat.i(51948);
        this.ROY = new com.tencent.mm.plugin.scanner.a.a();
        AppMethodBeat.o(51948);
    }

    public com.tencent.scanlib.a.f getScanCamera() {
        return this.ROY;
    }

    public void setActivity(Activity activity2) {
        this.activity = activity2;
    }

    public void setBlackInterval(int i2) {
        AppMethodBeat.i(170024);
        h hkp = h.hkp();
        synchronized (hkp.lQo) {
            try {
                if (hkp.lQo.hasInited()) {
                    hkp.lQo.setBlackInterval(i2);
                }
            } finally {
                AppMethodBeat.o(170024);
            }
        }
    }

    public void setMyQrCodeVisible(boolean z) {
        AppMethodBeat.i(240794);
        if (this.CGD instanceof ScanCodeMaskView) {
            ((ScanCodeMaskView) this.CGD).setMyQrCodeButtonVisible(z);
        }
        AppMethodBeat.o(240794);
    }

    public void setScanRequest(BaseScanRequest baseScanRequest) {
        this.CJD = baseScanRequest;
    }

    public void setEnableScanGoodsDynamicWording(boolean z) {
        this.CJO = z;
    }

    public TextureView getTextrueView() {
        return this.bec;
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void onCreate() {
        AppMethodBeat.i(51949);
        super.onCreate();
        this.CNr = (int) (((float) com.tencent.mm.cb.a.jn(getContext())) / 4.5f);
        if (r.Xd(this.mode)) {
            h.hkp().init(getContext());
        }
        h.hkp().RKr = new an();
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass8 */
            private float CNT;
            private float CNU = 400.0f;
            private boolean CNV = false;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(161027);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                Log.d("MicroMsg.ScanUIRectView", "pointIndex:%d, action: %d", Integer.valueOf(actionIndex), Integer.valueOf(actionMasked));
                switch (actionMasked) {
                    case 0:
                        Log.d("MicroMsg.ScanUIRectView", "first down,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
                        ScanUIRectView.this.CBd = motionEvent.getRawX();
                        ScanUIRectView.this.CNp = true;
                        this.CNV = false;
                        break;
                    case 1:
                        Log.d("MicroMsg.ScanUIRectView", "last up,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
                        if (motionEvent.getPointerCount() == 2) {
                            this.CNT = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                            break;
                        }
                        break;
                    case 2:
                        if (motionEvent.getPointerCount() != 2) {
                            if (motionEvent.getPointerCount() == 1 && ScanUIRectView.this.CNo && !ScanUIRectView.this.xsN) {
                                float rawX = motionEvent.getRawX() - ScanUIRectView.this.CBd;
                                Log.v("MicroMsg.ScanUIRectView", "alvinluo onTouchEvent offsetX: %f, canScrollSwitchTab: %b", Float.valueOf(rawX), Boolean.valueOf(ScanUIRectView.this.CNp));
                                if (rawX < ((float) ScanUIRectView.this.CNr) || !ScanUIRectView.this.CNp) {
                                    if (rawX <= ((float) (-ScanUIRectView.this.CNr)) && ScanUIRectView.this.CNp) {
                                        if (ScanUIRectView.this.CJn != null) {
                                            ScanUIRectView.this.CJn.eRD();
                                        }
                                        ScanUIRectView.this.CNp = false;
                                        break;
                                    }
                                } else {
                                    if (ScanUIRectView.this.CJn != null) {
                                        ScanUIRectView.this.CJn.eRE();
                                    }
                                    ScanUIRectView.this.CNp = false;
                                    break;
                                }
                            }
                        } else {
                            Log.d("MicroMsg.ScanUIRectView", "move,pointer:0,x:%f,y:%f", Float.valueOf(motionEvent.getX(0)), Float.valueOf(motionEvent.getY(0)));
                            Log.d("MicroMsg.ScanUIRectView", "move,pointer:1,x:%f,y:%f", Float.valueOf(motionEvent.getX(1)), Float.valueOf(motionEvent.getY(1)));
                            float pow = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                            Log.d("MicroMsg.ScanUIRectView", "distance:%f,lastDistance:%f,min move:%f", Float.valueOf(pow), Float.valueOf(this.CNT), Float.valueOf(this.CNU));
                            if (Math.abs(pow - this.CNT) > this.CNU) {
                                if (ScanUIRectView.this.CNt) {
                                    ScanUIRectView.this.CNt = false;
                                }
                                if (pow - this.CNT > 0.0f) {
                                    ((com.tencent.scanlib.a.a) ScanUIRectView.this.ROY).aqF(2);
                                    this.CNV = true;
                                } else {
                                    ((com.tencent.scanlib.a.a) ScanUIRectView.this.ROY).aqF(3);
                                    this.CNV = true;
                                }
                                this.CNT = pow;
                                break;
                            }
                        }
                        break;
                    case 5:
                        Log.d("MicroMsg.ScanUIRectView", "down,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX(actionIndex)), Float.valueOf(motionEvent.getY(actionIndex)));
                        if (motionEvent.getPointerCount() == 2) {
                            this.CNT = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                            ScanUIRectView.this.xsN = true;
                        }
                        this.CNV = false;
                        break;
                    case 6:
                        Log.d("MicroMsg.ScanUIRectView", "up,pointer:%d,x:%f,y:%f", Integer.valueOf(actionIndex), Float.valueOf(motionEvent.getX(actionIndex)), Float.valueOf(motionEvent.getY(actionIndex)));
                        if (motionEvent.getPointerCount() == 2) {
                            this.CNT = (float) (Math.pow((double) (motionEvent.getX(0) - motionEvent.getX(1)), 2.0d) + Math.pow((double) (motionEvent.getY(0) - motionEvent.getY(1)), 2.0d));
                            if (this.CNV) {
                                this.CNV = false;
                                af.ia(ScanUIRectView.this.mode, 4);
                                break;
                            }
                        }
                        break;
                }
                GestureDetector gestureDetector = ScanUIRectView.this.jKk;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$16", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$16", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                if (motionEvent.getAction() == 1) {
                    ScanUIRectView.this.xsN = false;
                }
                AppMethodBeat.o(161027);
                return true;
            }
        });
        EventCenter.instance.addListener(this.CNK);
        if (this.CNz != null) {
            this.CNz.viC = System.currentTimeMillis();
        }
        AppMethodBeat.o(51949);
    }

    public final boolean eQZ() {
        AppMethodBeat.i(51950);
        if (this.ROY != null) {
            boolean eQZ = ((com.tencent.scanlib.a.a) this.ROY).eQZ();
            AppMethodBeat.o(51950);
            return eQZ;
        }
        AppMethodBeat.o(51950);
        return false;
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void onResume() {
        AppMethodBeat.i(51951);
        super.onResume();
        if (!this.ROY.isOpen()) {
            Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume openCamera");
            a((b.AbstractCallableC2185b.a) null);
        } else if (!this.ROY.dEO()) {
            Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume startPreview");
            ((com.tencent.mm.plugin.scanner.a.a) this.ROY).ePC();
            a(new b.d.a() {
                /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass9 */

                @Override // com.tencent.scanlib.a.b.d.a
                public final void eRk() {
                    AppMethodBeat.i(170017);
                    ScanUIRectView.this.IC(0);
                    AppMethodBeat.o(170017);
                }
            });
            Log.i("MicroMsg.ScanUIRectView", "focus mode %s", this.ROY.getFocusMode());
        } else {
            Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume camera is previewing");
            Log.i("MicroMsg.ScanUIRectView", "focus mode %s", this.ROY.getFocusMode());
            IC(0);
        }
        Log.i("MicroMsg.ScanUIRectView", "onResume %s", Util.getStack());
        this.CDU = System.currentTimeMillis();
        if (r.Xd(this.mode)) {
            h.hkp().a(this.CDU, this.CNI);
        } else if (this.mode == 12) {
            Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume currentNetworkAvailable: %b", Boolean.valueOf(this.CJv));
            if (this.CJv) {
                com.tencent.mm.plugin.scanner.d.a ePJ = com.tencent.mm.plugin.scanner.d.a.ePJ();
                long j2 = this.CDU;
                a.AbstractC1668a aVar = this.CNJ;
                synchronized (ePJ.CCt) {
                    try {
                        ePJ.CDU = j2;
                        ePJ.CEl = aVar;
                    } finally {
                        AppMethodBeat.o(51951);
                    }
                }
                synchronized (ePJ.CEk) {
                    try {
                        if (ePJ.gKM) {
                            x.reset();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } else {
                com.tencent.mm.plugin.scanner.d.a.ePJ().Iv(this.CDU);
            }
        }
        this.CNs = false;
        if (this.CGD != null) {
            this.CGD.onResume();
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(51923);
                if (ScanUIRectView.this.CJD == null || !ScanUIRectView.this.CJD.CAG) {
                    ScanCameraLightDetector.CTx.start(((com.tencent.mm.plugin.scanner.a.a) ScanUIRectView.this.ROY).getFocusMode());
                    AppMethodBeat.o(51923);
                    return;
                }
                AppMethodBeat.o(51923);
            }
        }, 300);
        this.CNx = true;
        AppMethodBeat.o(51951);
    }

    public final void eRa() {
        AppMethodBeat.i(51952);
        Log.i("MicroMsg.ScanUIRectView", "alvinluo stopCurrentSession %d", Long.valueOf(this.CDU));
        h.hkp().Iv(this.CDU);
        com.tencent.mm.plugin.scanner.d.a.ePJ().Iv(this.CDU);
        this.CDU = 0;
        AppMethodBeat.o(51952);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void onPause() {
        AppMethodBeat.i(51953);
        super.onPause();
        Log.i("MicroMsg.ScanUIRectView", "alvinluo onPause");
        eRj();
        if (this.CGD != null) {
            this.CGD.onPause();
        }
        eRa();
        if (this.iOv != null) {
            this.iOv.c(this.gmA);
        }
        AppMethodBeat.o(51953);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void onStop() {
        AppMethodBeat.i(51954);
        super.onStop();
        aPK();
        ScanCameraLightDetector.CTx.stop();
        AppMethodBeat.o(51954);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void onDestroy() {
        AppMethodBeat.i(51955);
        super.onDestroy();
        Log.d("MicroMsg.ScanUIRectView", "alvinluo releaseView");
        if (this.CGD != null) {
            this.CGD.release();
        }
        if (this.CGE != null) {
            ScanSharedMaskView scanSharedMaskView = this.CGE;
            Log.d("MicroMsg.ScanSharedMaskView", "alvinluo release hashCode: %d", Integer.valueOf(scanSharedMaskView.hashCode()));
            scanSharedMaskView.eRF();
            scanSharedMaskView.eRG();
        }
        h.hkp().release();
        com.tencent.mm.plugin.scanner.d.a ePJ = com.tencent.mm.plugin.scanner.d.a.ePJ();
        Log.i("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo release");
        x.a(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0057: INVOKE  
              (wrap: com.tencent.mm.plugin.scanner.d.a$3 : 0x0054: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.scanner.d.a$3) = (r0v4 'ePJ' com.tencent.mm.plugin.scanner.d.a) call: com.tencent.mm.plugin.scanner.d.a.3.<init>(com.tencent.mm.plugin.scanner.d.a):void type: CONSTRUCTOR)
             type: STATIC call: com.tencent.mm.plugin.scanner.model.x.a(com.tencent.mm.plugin.scanner.model.y):void in method: com.tencent.mm.plugin.scanner.ui.ScanUIRectView.onDestroy():void, file: classes7.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0054: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.scanner.d.a$3) = (r0v4 'ePJ' com.tencent.mm.plugin.scanner.d.a) call: com.tencent.mm.plugin.scanner.d.a.3.<init>(com.tencent.mm.plugin.scanner.d.a):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.scanner.ui.ScanUIRectView.onDestroy():void, file: classes7.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.scanner.d.a, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 251
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ui.ScanUIRectView.onDestroy():void");
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void stopPreview() {
        AppMethodBeat.i(51956);
        super.stopPreview();
        this.CNw = true;
        this.CNx = false;
        AppMethodBeat.o(51956);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void IC(long j2) {
        AppMethodBeat.i(51957);
        this.CNu = true;
        Log.d("MicroMsg.ScanUIRectView", "alvinluo takeOneShot timeout: %d, isRetry: %b, onPreviewFrameCalled: %b, canReportOnPreviewFrame: %b, hasReport: %b", Long.valueOf(this.mTimeout), Boolean.valueOf(this.isRetry), Boolean.valueOf(this.CNE), Boolean.valueOf(this.CND), Boolean.valueOf(this.CNC));
        if (!this.isRetry) {
            super.IC(j2);
            this.CNB = System.currentTimeMillis();
            if (!this.CNE && this.CND && r.Xd(this.mode)) {
                removeCallbacks(this.CNF);
                postDelayed(this.CNF, this.mTimeout);
                AppMethodBeat.o(51957);
                return;
            }
        } else if (this.CNz != null && this.CNz.Xc(this.CNA)) {
            if (this.CNA == 1) {
                super.IC(j2);
                this.CNB = System.currentTimeMillis();
                AppMethodBeat.o(51957);
                return;
            } else if (this.CNA == 2) {
                ID(j2);
            }
        }
        AppMethodBeat.o(51957);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void a(final b.AbstractCallableC2185b.a aVar) {
        AppMethodBeat.i(161041);
        super.a(new b.AbstractCallableC2185b.a() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass12 */

            @Override // com.tencent.scanlib.a.b.AbstractCallableC2185b.a
            public final void eRl() {
                AppMethodBeat.i(161029);
                ScanUIRectView.h(ScanUIRectView.this);
                if (aVar != null) {
                    aVar.eRl();
                }
                AppMethodBeat.o(161029);
            }
        });
        AppMethodBeat.o(161041);
    }

    private byte[] eRb() {
        AppMethodBeat.i(161042);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int width = this.bec.getWidth();
            int height = this.bec.getHeight();
            if (!(this.CNz == null || this.CNz.CTP == 0.0f)) {
                width = (int) (((float) this.bec.getWidth()) * this.CNz.CTP);
                height = (int) (((float) this.bec.getHeight()) * this.CNz.CTP);
            }
            if (width % 2 != 0) {
                width--;
            }
            if (height % 2 != 0) {
                height--;
            }
            Bitmap bitmap = this.bec.getBitmap(width, height);
            Log.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView getBitmap cost: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (bitmap != null && !bitmap.isRecycled()) {
                this.CNG = bitmap.getWidth();
                this.CNH = bitmap.getHeight();
                Log.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView bitmap width: %d, height: %d", Integer.valueOf(this.CNG), Integer.valueOf(this.CNH));
                long currentTimeMillis2 = System.currentTimeMillis();
                byte[] nv21 = com.tencent.mm.plugin.scanner.util.o.getNV21(this.CNG, this.CNH, bitmap);
                long currentTimeMillis3 = System.currentTimeMillis();
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(nv21 != null ? nv21.length : -1);
                objArr[1] = Long.valueOf(currentTimeMillis3 - currentTimeMillis2);
                Log.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView yuvData: %d, getNV21 cost: %d", objArr);
                AppMethodBeat.o(161042);
                return nv21;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanUIRectView", e2, "alvinluo generateFrameByTextureView exception", new Object[0]);
        }
        AppMethodBeat.o(161042);
        return null;
    }

    public void setNetworkAvailable(boolean z) {
        this.CJv = z;
    }

    public void setScrollTabController(com.tencent.mm.plugin.scanner.ui.widget.b bVar) {
        this.CJn = bVar;
    }

    public void setBottomExtraHeight(int i2) {
        this.CNq = i2;
    }

    public void setEnableScrollSwitchTab(boolean z) {
        AppMethodBeat.i(51958);
        Log.i("MicroMsg.ScanUIRectView", "alvinluo setEnableScrollSwitchTab: %b", Boolean.valueOf(z));
        this.CNo = z;
        AppMethodBeat.o(51958);
    }

    public void setIgnorePreviewFrame(boolean z) {
        AppMethodBeat.i(240795);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo setIgnorePreviewFrame %b", Boolean.valueOf(z));
        this.CNy = z;
        AppMethodBeat.o(240795);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void init() {
        AppMethodBeat.i(51959);
        super.init();
        this.CNj = new ScanRectDecorView(getContext());
        if (this.CJO) {
            this.CNm = x.eQa();
        }
        Log.i("MicroMsg.ScanUIRectView", "initScanGoodsTips enable: %b, %s", Boolean.valueOf(this.CJO), this.CNm);
        addView(this.CNj, new FrameLayout.LayoutParams(-1, -1));
        this.CGE = new ScanSharedMaskView(getContext());
        this.CJh = this.CGE.getFlashSwitcherView();
        addView(this.CGE, new FrameLayout.LayoutParams(-1, -1));
        eRd();
        AppMethodBeat.o(51959);
    }

    private void eRc() {
        TextView textView;
        TextView textView2;
        View view;
        ScannerFlashSwitcher scannerFlashSwitcher;
        boolean z = true;
        AppMethodBeat.i(51960);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo createScanMaskView mode: %d, bottomHeight: %d", Integer.valueOf(this.mode), Integer.valueOf(this.CNq));
        switch (this.mode) {
            case 1:
            case 4:
            case 8:
                eRi();
                this.CGD = new ScanCodeMaskView(getContext());
                addView(this.CGD);
                break;
            case 3:
                this.CGD = new ScanTranslationMaskView(getContext());
                addView(this.CGD);
                break;
            case 12:
                this.CGD = new ScanGoodsMaskView(getContext());
                addView(this.CGD);
                if ((this.CGD instanceof ScanGoodsMaskView) && (this.CJD instanceof ScanGoodsRequest)) {
                    ((ScanGoodsMaskView) this.CGD).setScanRequest((ScanGoodsRequest) this.CJD);
                    break;
                }
            default:
                Log.i("MicroMsg.ScanUIRectView", "unknown scan mode %d", Integer.valueOf(this.mode));
                break;
        }
        if (!(this.CGD == null || this.CGE == null)) {
            this.CGD.setBottomExtraHeight(this.CNq);
            this.CGD.CMx = (com.tencent.mm.plugin.scanner.a.a) this.ROY;
            BaseScanMaskView baseScanMaskView = this.CGD;
            TextView scanTipsView = this.CGE.getScanTipsView();
            p.h(scanTipsView, "tipsView");
            baseScanMaskView.CSB = scanTipsView;
            this.CGD.eRq();
            this.CGE.setBottomExtraHeight(this.CNq);
            this.CGE.setFlashStatus(this.CJh.ddZ);
            this.CGE.setShowTitle(!this.isFirst);
            ScanSharedMaskView scanSharedMaskView = this.CGE;
            int i2 = this.mode;
            Log.i("MicroMsg.ScanSharedMaskView", "alvinluo onViewReady currentTab: %d, hashCode: %d", Integer.valueOf(i2), Integer.valueOf(scanSharedMaskView.hashCode()));
            scanSharedMaskView.CSG = i2;
            TextView textView3 = scanSharedMaskView.CSB;
            if (textView3 == null) {
                p.btv("scanTips");
            }
            TextView textView4 = scanSharedMaskView.CSB;
            if (textView4 == null) {
                p.btv("scanTips");
            }
            ViewGroup.LayoutParams layoutParams = textView4.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(scanSharedMaskView.getContext(), 120) + scanSharedMaskView.CSP;
                }
                textView = textView3;
            } else {
                layoutParams = null;
                textView = textView3;
            }
            textView.setLayoutParams(layoutParams);
            TextView textView5 = scanSharedMaskView.CSC;
            if (textView5 == null) {
                p.btv("scanToast");
            }
            TextView textView6 = scanSharedMaskView.CSC;
            if (textView6 == null) {
                p.btv("scanToast");
            }
            ViewGroup.LayoutParams layoutParams2 = textView6.getLayoutParams();
            if (layoutParams2 != null) {
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(scanSharedMaskView.getContext(), 110) + scanSharedMaskView.CSP;
                }
                textView2 = textView5;
            } else {
                layoutParams2 = null;
                textView2 = textView5;
            }
            textView2.setLayoutParams(layoutParams2);
            View view2 = scanSharedMaskView.CSE;
            if (view2 == null) {
                p.btv("galleryButton");
            }
            View view3 = scanSharedMaskView.CSE;
            if (view3 == null) {
                p.btv("galleryButton");
            }
            ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
            if (layoutParams3 != null) {
                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(scanSharedMaskView.getContext(), 32) + scanSharedMaskView.CSP;
                }
                view = view2;
            } else {
                layoutParams3 = null;
                view = view2;
            }
            view.setLayoutParams(layoutParams3);
            if (r.Xf(scanSharedMaskView.CSG)) {
                ScannerFlashSwitcher scannerFlashSwitcher2 = scanSharedMaskView.CJh;
                if (scannerFlashSwitcher2 == null) {
                    p.btv("flashSwitcher");
                }
                scannerFlashSwitcher2.setVisibility(8);
            } else {
                ScannerFlashSwitcher scannerFlashSwitcher3 = scanSharedMaskView.CJh;
                if (scannerFlashSwitcher3 == null) {
                    p.btv("flashSwitcher");
                }
                ScannerFlashSwitcher scannerFlashSwitcher4 = scanSharedMaskView.CJh;
                if (scannerFlashSwitcher4 == null) {
                    p.btv("flashSwitcher");
                }
                ViewGroup.LayoutParams layoutParams4 = scannerFlashSwitcher4.getLayoutParams();
                if (layoutParams4 != null) {
                    if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(scanSharedMaskView.getContext(), 32) + scanSharedMaskView.CSP;
                    }
                    scannerFlashSwitcher = scannerFlashSwitcher3;
                } else {
                    layoutParams4 = null;
                    scannerFlashSwitcher = scannerFlashSwitcher3;
                }
                scannerFlashSwitcher.setLayoutParams(layoutParams4);
            }
            if (!scanSharedMaskView.CSQ) {
                if (scanSharedMaskView.CSO) {
                    z = false;
                }
                scanSharedMaskView.uf(z);
                TextView textView7 = scanSharedMaskView.CSA;
                if (textView7 == null) {
                    p.btv("scanTitle");
                }
                textView7.setVisibility(8);
                scanSharedMaskView.CSN = false;
            } else {
                scanSharedMaskView.uf(false);
                scanSharedMaskView.eRF();
                scanSharedMaskView.eRG();
                TextView textView8 = scanSharedMaskView.CSA;
                if (textView8 == null) {
                    p.btv("scanTitle");
                }
                textView8.setAlpha(1.0f);
                TextView textView9 = scanSharedMaskView.CSA;
                if (textView9 == null) {
                    p.btv("scanTitle");
                }
                if (textView9.getVisibility() == 0) {
                    z = false;
                }
                if (scanSharedMaskView.CSL == null) {
                    l lVar = new l();
                    TextView textView10 = scanSharedMaskView.CSA;
                    if (textView10 == null) {
                        p.btv("scanTitle");
                    }
                    l eRZ = lVar.eV(textView10).eRY().eRZ();
                    eRZ.CUp = new ScanSharedMaskView.f(scanSharedMaskView);
                    scanSharedMaskView.CSL = eRZ;
                }
                l lVar2 = scanSharedMaskView.CSL;
                if (lVar2 != null) {
                    lVar2.ul(z);
                }
            }
            TextView textView11 = scanSharedMaskView.CSC;
            if (textView11 == null) {
                p.btv("scanToast");
            }
            textView11.setVisibility(8);
            scanSharedMaskView.eQC();
            scanSharedMaskView.WY(i2);
            this.isFirst = false;
        }
        AppMethodBeat.o(51960);
    }

    public final void refreshView() {
        AppMethodBeat.i(51961);
        this.CNj.setVisibility(8);
        eRd();
        eRg();
        eRc();
        AppMethodBeat.o(51961);
    }

    private void eRd() {
        AppMethodBeat.i(51962);
        this.CGE.setScanTips(getScanTips());
        this.CGE.setScanRequest(this.CJD);
        switch (this.mode) {
            case 1:
            case 4:
            case 8:
                this.CGE.setScanTitle(getResources().getString(R.string.gbt));
                AppMethodBeat.o(51962);
                return;
            case 3:
                this.CGE.setScanTitle(getResources().getString(R.string.gbs));
                AppMethodBeat.o(51962);
                return;
            case 12:
                this.CGE.setScanTitle(getResources().getString(R.string.gbo));
                AppMethodBeat.o(51962);
                return;
            default:
                Log.e("MicroMsg.ScanUIRectView", "alvinluo refreshSharedMaskView unknown scan mode %d", Integer.valueOf(this.mode));
                AppMethodBeat.o(51962);
                return;
        }
    }

    private String getScanTips() {
        AppMethodBeat.i(51963);
        if (!this.CJu) {
            AppMethodBeat.o(51963);
            return "";
        }
        switch (this.mode) {
            case 1:
                String string = getResources().getString(R.string.gdx);
                AppMethodBeat.o(51963);
                return string;
            case 3:
                String string2 = getResources().getString(R.string.ge6);
                AppMethodBeat.o(51963);
                return string2;
            case 4:
                String string3 = getResources().getString(R.string.fqy);
                AppMethodBeat.o(51963);
                return string3;
            case 8:
                String string4 = getResources().getString(R.string.fqx);
                AppMethodBeat.o(51963);
                return string4;
            case 12:
                if (!Util.isNullOrNil(this.CNm)) {
                    String str = this.CNm;
                    AppMethodBeat.o(51963);
                    return str;
                }
                String string5 = getResources().getString(R.string.gc7);
                AppMethodBeat.o(51963);
                return string5;
            default:
                AppMethodBeat.o(51963);
                return "";
        }
    }

    public ScanSharedMaskView getSharedMaskView() {
        return this.CGE;
    }

    public BaseScanMaskView getScanMaskView() {
        return this.CGD;
    }

    public void setScanSource(int i2) {
        AppMethodBeat.i(51964);
        if (this.CGD != null) {
            this.CGD.setScanSource(i2);
        }
        AppMethodBeat.o(51964);
    }

    public final void b(boolean z, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(51965);
        if (this.CGD != null) {
            this.CGD.b(z, onCancelListener);
        }
        AppMethodBeat.o(51965);
    }

    public void setFlashStatus(boolean z) {
        AppMethodBeat.i(51966);
        if (this.CGE != null) {
            this.CGE.setFlashStatus(z);
        }
        AppMethodBeat.o(51966);
    }

    public final void eRe() {
        AppMethodBeat.i(51967);
        if (this.CGE != null && !this.CJh.ddZ) {
            this.CGE.uh(true);
        }
        AppMethodBeat.o(51967);
    }

    public final void eRf() {
        AppMethodBeat.i(51968);
        if (this.CGE != null && this.CJh.ddZ) {
            this.CGE.uh(false);
        }
        AppMethodBeat.o(51968);
    }

    public final void tW(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(51969);
        Log.v("MicroMsg.ScanUIRectView", "alvinluo onShowNoDataView show: %b", Boolean.valueOf(z));
        if (this.CGE != null) {
            this.CGE.ui(!z);
        }
        if (this.CGD != null) {
            BaseScanMaskView baseScanMaskView = this.CGD;
            if (z) {
                z2 = false;
            }
            baseScanMaskView.ui(z2);
        }
        AppMethodBeat.o(51969);
    }

    private void eRg() {
        AppMethodBeat.i(51970);
        if (this.CGD != null) {
            final BaseScanMaskView baseScanMaskView = this.CGD;
            baseScanMaskView.a(new Animator.AnimatorListener() {
                /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass15 */

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(170021);
                    ScanUIRectView.this.removeView((View) baseScanMaskView);
                    baseScanMaskView.release();
                    AppMethodBeat.o(170021);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(170022);
                    ScanUIRectView.this.removeView((View) baseScanMaskView);
                    baseScanMaskView.release();
                    AppMethodBeat.o(170022);
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        }
        AppMethodBeat.o(51970);
    }

    public void setSuccessMarkClickListener(ag agVar) {
        AppMethodBeat.i(170025);
        if (this.CGD instanceof ScanCodeMaskView) {
            ((ScanCodeMaskView) this.CGD).setSuccessMarkClickListener(agVar);
        }
        AppMethodBeat.o(170025);
    }

    public void setDecodeSuccessFrameData(ScanDecodeFrameData scanDecodeFrameData) {
        AppMethodBeat.i(170026);
        if (this.CGD != null) {
            this.CGD.setDecodeSuccessFrameData(scanDecodeFrameData);
        }
        AppMethodBeat.o(170026);
    }

    public final void a(final Object obj, final com.tencent.mm.plugin.scanner.view.d dVar, boolean z) {
        AppMethodBeat.i(240796);
        if (z) {
            com.tencent.f.h.RTc.n(new Runnable() {
                /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass16 */

                public final void run() {
                    AppMethodBeat.i(170023);
                    ScanUIRectView.a(ScanUIRectView.this, obj, dVar);
                    AppMethodBeat.o(170023);
                }
            }, 200);
            AppMethodBeat.o(240796);
            return;
        }
        a(obj, dVar);
        AppMethodBeat.o(240796);
    }

    private void a(Object obj, com.tencent.mm.plugin.scanner.view.d dVar) {
        AppMethodBeat.i(240797);
        Log.i("MicroMsg.ScanUIRectView", "alvinluo onScanSuccess");
        eRj();
        eRh();
        if (this.CGD != null) {
            this.CGD.b(obj, dVar);
            this.CGD.eU(this.bec);
        }
        if (this.CGE != null) {
            this.CGE.eRH();
        }
        if (r.Xd(this.mode) && this.CNz != null) {
            this.CNz.CTR = true;
        }
        AppMethodBeat.o(240797);
    }

    public void setScanMode(int i2) {
        this.mode = i2;
    }

    public void setScanCallback(a aVar) {
        this.CNl = aVar;
    }

    public void setShowScanTips(boolean z) {
        this.CJu = z;
    }

    public final void eRh() {
        AppMethodBeat.i(240798);
        onPause();
        stopPreview();
        AppMethodBeat.o(240798);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public void onAutoFocus(boolean z, Camera camera) {
        AppMethodBeat.i(51972);
        Log.i("MicroMsg.ScanUIRectView", "onAutoFocus %s", Boolean.valueOf(z));
        if (z) {
            this.CND = false;
            IC(0);
        }
        Oy((long) RPb);
        AppMethodBeat.o(51972);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        AppMethodBeat.i(51973);
        super.onPreviewFrame(bArr, camera);
        this.CNE = true;
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(bArr == null);
        objArr[1] = Boolean.valueOf(this.CNw);
        objArr[2] = Boolean.valueOf(this.CNx);
        Log.d("MicroMsg.ScanUIRectView", "onPreviewFrame null data: %b, isPreviewPaused: %b, canResumePreview: %b", objArr);
        if (this.CNA == 2) {
            if (this.CNz != null) {
                com.tencent.mm.plugin.scanner.util.h hVar = this.CNz;
                int i2 = this.CNA;
                Log.i("MicroMsg.ScanRetryManager", "alvinluo cancelRetryType: %d", Integer.valueOf(i2));
                if (i2 == 1) {
                    hVar.CTN = false;
                } else if (i2 == 2) {
                    hVar.CTO = false;
                }
            }
            this.isRetry = false;
        }
        removeCallbacks(this.CNF);
        if (this.CNz != null) {
            com.tencent.mm.plugin.scanner.util.h hVar2 = this.CNz;
            long currentTimeMillis = System.currentTimeMillis() - this.CNB;
            if (!hVar2.CTL) {
                hVar2.CTL = true;
                hVar2.mTimeout = Math.max(hVar2.CTJ, Math.min(hVar2.CTI, (long) (((float) currentTimeMillis) * hVar2.CTK)));
            }
            this.CNz.CNE = true;
        }
        if (this.CNw && this.CNx) {
            this.CNw = false;
            this.CNx = false;
            tX(false);
            IC(100);
            AppMethodBeat.o(51973);
        } else if (this.CNy) {
            Log.w("MicroMsg.ScanUIRectView", "alvinluo onPreviewFrame ignorePreviewFrame");
            AppMethodBeat.o(51973);
        } else if (bArr == null) {
            Log.w("MicroMsg.ScanUIRectView", "alvinluo onPreviewFrame data is null");
            IC(0);
            af.eQk();
            AppMethodBeat.o(51973);
        } else {
            bX(bArr);
            AppMethodBeat.o(51973);
        }
    }

    private void bX(byte[] bArr) {
        AppMethodBeat.i(161043);
        if (this.ROY.dEO() && ((com.tencent.mm.plugin.scanner.a.a) this.ROY).ePE()) {
            ScanCameraLightDetector.CTx.N(bArr, ((com.tencent.mm.plugin.scanner.a.a) this.ROY).hkU().x, ((com.tencent.mm.plugin.scanner.a.a) this.ROY).hkU().y);
        }
        switch (this.mode) {
            case 1:
            case 4:
            case 8:
                bY(bArr);
                AppMethodBeat.o(161043);
                return;
            case 12:
                bZ(bArr);
                AppMethodBeat.o(161043);
                return;
            default:
                Log.i("MicroMsg.ScanUIRectView", "unknown scan mode %d", Integer.valueOf(this.mode));
                AppMethodBeat.o(161043);
                return;
        }
    }

    public final void tX(final boolean z) {
        AppMethodBeat.i(170027);
        af.WA(this.mode);
        if (this.mode == 12) {
            af.aE(1, System.currentTimeMillis());
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            tY(z);
            AppMethodBeat.o(170027);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(240779);
                ScanUIRectView.a(ScanUIRectView.this, z);
                AppMethodBeat.o(240779);
            }
        });
        AppMethodBeat.o(170027);
    }

    private void tY(boolean z) {
        AppMethodBeat.i(51974);
        if (this.CGD != null) {
            this.CGD.tY(z);
        }
        if (this.CGE != null) {
            this.CGE.tY(z);
        }
        if (this.CNk != null) {
            this.CNk.setVisibility(8);
        }
        if (this.CNn != null) {
            this.CNn.ePO();
        }
        AppMethodBeat.o(51974);
    }

    private void eRi() {
        AppMethodBeat.i(162394);
        if (com.tencent.qbar.f.hkm()) {
            Log.i("MicroMsg.ScanUIRectView", "alvinluo updateScanCodeRect visibleResolution: %s", this.sRG);
            if (this.sRG != null && this.sRG.x > 0 && this.sRG.y > 0) {
                this.CNj.setDecorRect(new Rect(0, (int) ((((float) this.sRG.y) * 1.0f) / 19.0f), this.sRG.x, (int) ((((float) this.sRG.y) * 17.0f) / 19.0f)));
                AppMethodBeat.o(162394);
                return;
            }
        } else {
            this.CNj.ij(getResources().getDimensionPixelSize(R.dimen.ahx), getResources().getDimensionPixelSize(R.dimen.ahw));
        }
        AppMethodBeat.o(162394);
    }

    private Rect getScanCodeRect() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(51975);
        if (com.tencent.qbar.f.hkm()) {
            Rect decorRect = getDecorRect();
            AppMethodBeat.o(51975);
            return decorRect;
        }
        Rect decorRect2 = getDecorRect();
        Point point = new Point();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getSize(point);
        Rect rect = new Rect();
        int width = (int) (((float) decorRect2.width()) * 0.5f);
        int height = (int) (((float) decorRect2.height()) * 0.5f);
        rect.left = decorRect2.left - (width / 2);
        rect.right = (width / 2) + decorRect2.right;
        rect.top = decorRect2.top - (height / 2);
        rect.bottom = decorRect2.bottom + (height / 2);
        rect.left = rect.left < 0 ? 0 : rect.left;
        rect.right = rect.right > point.x ? point.x : rect.right;
        if (rect.top >= 0) {
            i3 = rect.top;
        }
        rect.top = i3;
        if (rect.bottom > point.y) {
            i2 = point.y;
        } else {
            i2 = rect.bottom;
        }
        rect.bottom = i2;
        AppMethodBeat.o(51975);
        return rect;
    }

    private void bY(byte[] bArr) {
        AppMethodBeat.i(161044);
        if (this.CDU != 0 && this.ROY.dEO()) {
            Point hkU = this.ROY.hkU();
            if (hkU != null) {
                Rect scanCodeRect = getScanCodeRect();
                if (!this.isRetry || this.CNA == 1) {
                    Rect w = ((com.tencent.mm.plugin.scanner.a.a) this.ROY).w(scanCodeRect);
                    if (this.CGD != null) {
                        this.CGD.setPreviewRect(w);
                        this.CGD.setScanRect(scanCodeRect);
                        if (this.CGD instanceof ScanCodeMaskView) {
                            ((ScanCodeMaskView) this.CGD).setNeedRotate(true);
                        }
                    }
                    h.hkp().a(bArr, hkU, this.ROY.getCameraRotation(), w);
                } else if (this.isRetry && this.CNA == 2) {
                    Rect rect = new Rect(0, 0, this.CNG, this.CNH);
                    if (this.CGD != null) {
                        this.CGD.setPreviewRect(rect);
                        this.CGD.setScanRect(scanCodeRect);
                        if (this.CGD instanceof ScanCodeMaskView) {
                            ((ScanCodeMaskView) this.CGD).setNeedRotate(false);
                        }
                    }
                    h.hkp().a(bArr, new Point(this.CNG, this.CNH), 0, rect);
                }
            }
            if (!((com.tencent.scanlib.a.a) this.ROY).eQZ() && h.hkp().CDX > CNv) {
                Log.i("MicroMsg.ScanUIRectView", "change to FOCUS_MODE_AUTO");
                this.ROY.setFocusMode("auto");
                Oy(100);
            }
        }
        AppMethodBeat.o(161044);
    }

    private void bZ(byte[] bArr) {
        AppMethodBeat.i(161045);
        if (this.CDU != 0) {
            synchronized (this.ROY) {
                try {
                    if (this.ROY.dEO()) {
                        Point hkU = this.ROY.hkU();
                        boolean z = true;
                        if (this.CJD instanceof ScanGoodsRequest) {
                            z = ((ScanGoodsRequest) this.CJD).CAR;
                        }
                        com.tencent.mm.plugin.scanner.d.a.ePJ().a(bArr, hkU, this.ROY.getCameraRotation(), ((com.tencent.mm.plugin.scanner.a.a) this.ROY).getPreviewFormat(), z);
                    }
                } finally {
                    AppMethodBeat.o(161045);
                }
            }
            return;
        }
        AppMethodBeat.o(161045);
    }

    public Rect getDecorRect() {
        AppMethodBeat.i(51976);
        Rect decorRect = this.CNj.getDecorRect();
        AppMethodBeat.o(51976);
        return decorRect;
    }

    public void setDecorRect(Rect rect) {
        AppMethodBeat.i(51977);
        this.CNj.setDecorRect(rect);
        AppMethodBeat.o(51977);
    }

    public final void cWj() {
        AppMethodBeat.i(51978);
        if (this.CGD != null && (this.CGD instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView) this.CGD).cWj();
        }
        AppMethodBeat.o(51978);
    }

    public void setScanCodeReaders(int[] iArr) {
        AppMethodBeat.i(51979);
        h.hkp().S(iArr);
        AppMethodBeat.o(51979);
    }

    private void eRj() {
        AppMethodBeat.i(160188);
        if (this.CNF != null) {
            removeCallbacks(this.CNF);
        }
        AppMethodBeat.o(160188);
    }

    /* access modifiers changed from: package-private */
    public class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(161040);
            ScanUIRectView.this.lastShotTime = System.currentTimeMillis();
            ScanUIRectView.M(ScanUIRectView.this);
            AppMethodBeat.o(161040);
        }
    }

    private void ID(long j2) {
        AppMethodBeat.i(161046);
        long currentTimeMillis = System.currentTimeMillis() - this.lastShotTime;
        if (currentTimeMillis > ((long) ROZ)) {
            this.CNL.removeMessages(0);
            this.CNL.sendEmptyMessageDelayed(0, j2);
            AppMethodBeat.o(161046);
            return;
        }
        this.CNL.removeMessages(0);
        this.CNL.sendEmptyMessageDelayed(0, (((long) ROZ) - currentTimeMillis) + j2);
        AppMethodBeat.o(161046);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(162395);
        super.onSurfaceTextureAvailable(surfaceTexture, i2, i3);
        if (!(this.sRG != null && i2 == this.sRG.x && i3 == this.sRG.y)) {
            if (this.sRG == null) {
                this.sRG = new Point(i2, i3);
            }
            if (r.Xd(this.mode)) {
                eRi();
            }
        }
        AppMethodBeat.o(162395);
    }

    static /* synthetic */ boolean a(ScanUIRectView scanUIRectView) {
        AppMethodBeat.i(160189);
        boolean Xd = r.Xd(scanUIRectView.mode);
        AppMethodBeat.o(160189);
        return Xd;
    }

    static /* synthetic */ void e(ScanUIRectView scanUIRectView) {
        AppMethodBeat.i(170028);
        if (scanUIRectView.CNz != null) {
            int i2 = scanUIRectView.CNz.CTM;
            Log.i("MicroMsg.ScanUIRectView", "alvinluo checkAndRetry retryType: %d, canRetry: %b", Integer.valueOf(i2), Boolean.valueOf(scanUIRectView.CNz.Xc(i2)));
            if (scanUIRectView.CNz.Xc(i2)) {
                if (i2 == 1) {
                    scanUIRectView.CNz.isRetry = true;
                    af.WD(1);
                    try {
                        Log.i("MicroMsg.ScanUIRectView", "alvinluo checkAndReopenCamera");
                        scanUIRectView.a(new b.c.a() {
                            /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass13 */

                            @Override // com.tencent.scanlib.a.b.c.a
                            public final void eRl() {
                                AppMethodBeat.i(170019);
                                ScanUIRectView.this.CNA = 1;
                                ScanUIRectView.this.isRetry = true;
                                ScanUIRectView.h(ScanUIRectView.this);
                                AppMethodBeat.o(170019);
                            }
                        });
                        AppMethodBeat.o(170028);
                        return;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.ScanUIRectView", e2, "alvinluo checkAnReopenCamera exception", new Object[0]);
                        AppMethodBeat.o(170028);
                        return;
                    }
                } else if (i2 == 2) {
                    scanUIRectView.CNz.isRetry = true;
                    scanUIRectView.isRetry = true;
                    scanUIRectView.CNA = i2;
                    af.WD(2);
                    scanUIRectView.ID(0);
                }
            }
        }
        AppMethodBeat.o(170028);
    }

    static /* synthetic */ void h(ScanUIRectView scanUIRectView) {
        AppMethodBeat.i(240799);
        Log.i("MicroMsg.ScanUIRectView", "alvinluo onCameraOpened");
        ((com.tencent.mm.plugin.scanner.a.a) scanUIRectView.ROY).ePC();
        scanUIRectView.a(new b.d.a() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass11 */

            @Override // com.tencent.scanlib.a.b.d.a
            public final void eRk() {
                AppMethodBeat.i(170018);
                ScanUIRectView.this.IC(0);
                AppMethodBeat.o(170018);
            }
        });
        AppMethodBeat.o(240799);
    }

    static /* synthetic */ void M(ScanUIRectView scanUIRectView) {
        AppMethodBeat.i(240804);
        x.a(new y() {
            /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(170020);
                final byte[] k = ScanUIRectView.k(ScanUIRectView.this);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.scanner.ui.ScanUIRectView.AnonymousClass14.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(51937);
                        ScanUIRectView.a(ScanUIRectView.this, k);
                        AppMethodBeat.o(51937);
                    }
                });
                AppMethodBeat.o(170020);
            }
        }, "takeOneShotByTextureLoopTag");
        AppMethodBeat.o(240804);
    }
}
