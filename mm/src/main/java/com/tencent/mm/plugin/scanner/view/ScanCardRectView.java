package com.tencent.mm.plugin.scanner.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.b.a.a;
import com.tencent.mm.plugin.scanner.b.a.b;
import com.tencent.mm.plugin.scanner.b.a.c;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.qbar.WxQbarNative;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.scanlib.a.b;
import com.tencent.scanlib.ui.ScanView;

public class ScanCardRectView extends ScanView {
    private long CDU;
    private IListener CJU = new IListener<ti>() {
        /* class com.tencent.mm.plugin.scanner.view.ScanCardRectView.AnonymousClass10 */

        {
            AppMethodBeat.i(161728);
            this.__eventId = ti.class.getName().hashCode();
            AppMethodBeat.o(161728);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ti tiVar) {
            AppMethodBeat.i(118388);
            if (tiVar.dZN.dZO) {
                if (ScanCardRectView.this.CJh != null && !ScanCardRectView.this.CJh.isShown()) {
                    ScanCardRectView.this.CJh.show();
                }
            } else if (ScanCardRectView.this.CJh != null && !ScanCardRectView.this.CJh.VC) {
                ScanCardRectView.this.CJh.hide();
            }
            AppMethodBeat.o(118388);
            return false;
        }
    };
    private ScannerFlashSwitcher CJh;
    private IListener<tj> CNK = new IListener<tj>() {
        /* class com.tencent.mm.plugin.scanner.view.ScanCardRectView.AnonymousClass2 */

        {
            AppMethodBeat.i(177497);
            this.__eventId = tj.class.getName().hashCode();
            AppMethodBeat.o(177497);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tj tjVar) {
            AppMethodBeat.i(177498);
            if (tjVar.dZP.dDe == 1) {
                if (!((com.tencent.mm.plugin.scanner.a.a) ScanCardRectView.this.ROY).ePD()) {
                    ((com.tencent.mm.plugin.scanner.a.a) ScanCardRectView.this.ROY).ejE();
                }
            } else if (((com.tencent.mm.plugin.scanner.a.a) ScanCardRectView.this.ROY).ePD()) {
                ((com.tencent.mm.plugin.scanner.a.a) ScanCardRectView.this.ROY).ejF();
            }
            AppMethodBeat.o(177498);
            return true;
        }
    };
    private ScanRectDecorView CNj;
    private CardHighLightEdgeView CVc;
    private a CVd;
    private View CVe;
    private a.AbstractC1663a CVf = new a.AbstractC1663a() {
        /* class com.tencent.mm.plugin.scanner.view.ScanCardRectView.AnonymousClass5 */
    };
    private b.a CVg = new b.a() {
        /* class com.tencent.mm.plugin.scanner.view.ScanCardRectView.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.scanner.b.a.b.a
        public final void aj(long j2, long j3) {
            AppMethodBeat.i(118382);
            if (j2 == ScanCardRectView.this.CDU) {
                ScanCardRectView.this.IC(j3);
            }
            AppMethodBeat.o(118382);
        }

        @Override // com.tencent.mm.plugin.scanner.b.a.b.a
        public final void a(long j2, Bundle bundle) {
            AppMethodBeat.i(118383);
            if (j2 == ScanCardRectView.this.CDU) {
                Log.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", Long.valueOf(ScanCardRectView.this.CDU));
                ScanCardRectView.b(ScanCardRectView.this);
                if (ScanCardRectView.this.CVd != null) {
                    ScanCardRectView.this.CVd.e(j2, bundle);
                }
            }
            AppMethodBeat.o(118383);
        }
    };
    private c.b CVh = new c.b() {
        /* class com.tencent.mm.plugin.scanner.view.ScanCardRectView.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.scanner.b.a.c.b
        public final void aj(long j2, long j3) {
            AppMethodBeat.i(177501);
            if (j2 == ScanCardRectView.this.CDU) {
                ScanCardRectView.this.IC(j3);
            }
            AppMethodBeat.o(177501);
        }

        @Override // com.tencent.mm.plugin.scanner.b.a.c.b
        public final void a(long j2, Bundle bundle) {
            AppMethodBeat.i(177502);
            if (j2 == ScanCardRectView.this.CDU) {
                Log.i("MicroMsg.ScanCardRectView", "license decode success %s", Long.valueOf(ScanCardRectView.this.CDU));
                ScanCardRectView.b(ScanCardRectView.this);
                if (ScanCardRectView.this.CVd != null) {
                    ScanCardRectView.this.CVd.e(j2, bundle);
                }
            }
            AppMethodBeat.o(177502);
        }

        @Override // com.tencent.mm.plugin.scanner.b.a.c.b
        public final void b(long j2, Bundle bundle) {
            AppMethodBeat.i(177503);
            if (j2 == ScanCardRectView.this.CDU && bundle.containsKey("param_card_edge")) {
                ScanCardRectView.this.CVc.setHighLightEdges(bundle.getBooleanArray("param_card_edge"));
            }
            AppMethodBeat.o(177503);
        }
    };
    private int mode;

    public interface a {
        void e(long j2, Bundle bundle);
    }

    static /* synthetic */ void b(ScanCardRectView scanCardRectView) {
        AppMethodBeat.i(177506);
        scanCardRectView.eRa();
        AppMethodBeat.o(177506);
    }

    public ScanCardRectView(Context context) {
        super(context);
        AppMethodBeat.i(118389);
        AppMethodBeat.o(118389);
    }

    public ScanCardRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(118390);
        AppMethodBeat.o(118390);
    }

    public ScanCardRectView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(118391);
        AppMethodBeat.o(118391);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void init() {
        AppMethodBeat.i(118392);
        super.init();
        this.CVc = new CardHighLightEdgeView(getContext());
        addView(this.CVc, new FrameLayout.LayoutParams(-1, -1));
        this.CNj = new ScanRectDecorView(getContext());
        addView(this.CNj, new FrameLayout.LayoutParams(-1, -1));
        AppMethodBeat.o(118392);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void eQY() {
        AppMethodBeat.i(118393);
        this.ROY = new com.tencent.mm.plugin.scanner.a.a();
        AppMethodBeat.o(118393);
    }

    public Rect getDecorRect() {
        AppMethodBeat.i(118394);
        Rect decorRect = this.CNj.getDecorRect();
        AppMethodBeat.o(118394);
        return decorRect;
    }

    public void setDecorRect(Rect rect) {
        AppMethodBeat.i(118395);
        this.CNj.setDecorRect(rect);
        this.CVc.setCardRect(rect);
        AppMethodBeat.o(118395);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(118396);
        super.onAttachedToWindow();
        Point point = new Point();
        getDisplay().getSize(point);
        Log.i("MicroMsg.ScanCardRectView", "screenSize %s", point);
        if (this.CVe != null) {
            removeView(this.CVe);
        }
        switch (this.mode) {
            case 7:
                this.CVe = View.inflate(getContext(), R.layout.bnq, null);
                String nullAs = Util.nullAs(((Activity) getContext()).getIntent().getStringExtra("bank_card_owner"), "");
                String format = String.format(getContext().getResources().getString(R.string.gb_), nullAs);
                View findViewById = this.CVe.findViewById(R.id.isq);
                if (Util.isNullOrNil(nullAs)) {
                    findViewById.setVisibility(4);
                } else {
                    ((TextView) this.CVe.findViewById(R.id.a0h)).setText(format);
                    this.CVe.findViewById(R.id.a0e).setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.plugin.scanner.view.ScanCardRectView.AnonymousClass1 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(118378);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/view/ScanCardRectView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            h.a(ScanCardRectView.this.getContext(), ScanCardRectView.this.getContext().getString(R.string.gb8), ScanCardRectView.this.getContext().getString(R.string.gb7), View.inflate(ScanCardRectView.this.getContext(), R.layout.bnp, null), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.scanner.view.ScanCardRectView.AnonymousClass1.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(118377);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(118377);
                                }
                            });
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/view/ScanCardRectView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(118378);
                        }
                    });
                    findViewById.setVisibility(0);
                }
                addView(this.CVe, new FrameLayout.LayoutParams(-1, -1));
                Rect rect = new Rect();
                rect.left = com.tencent.mm.cb.a.fromDPToPix(getContext(), 40);
                rect.right = point.x - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40);
                rect.top = (point.y - ((int) (((float) rect.width()) / 1.586f))) / 2;
                rect.bottom = rect.top + ((int) (((float) rect.width()) / 1.586f));
                Log.i("MicroMsg.ScanCardRectView", "scan bank card rect %s", rect);
                this.CNj.ij(rect.width(), rect.height());
                this.CVc.setCardRect(rect);
                eQw();
                AppMethodBeat.o(118396);
                return;
            case 8:
            default:
                Log.e("MicroMsg.ScanCardRectView", "unknown mode!");
                AppMethodBeat.o(118396);
                return;
            case 9:
            case 11:
                Rect rect2 = new Rect();
                rect2.left = com.tencent.mm.cb.a.fromDPToPix(getContext(), 40);
                rect2.right = point.x - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40);
                rect2.top = (point.y - ((int) (((float) rect2.width()) / 1.586f))) / 2;
                rect2.bottom = rect2.top + ((int) (((float) rect2.width()) / 1.586f));
                Log.i("MicroMsg.ScanCardRectView", "scan id card rect %s", rect2);
                this.CNj.ij(rect2.width(), rect2.height());
                this.CVc.setCardRect(rect2);
                this.CVe = View.inflate(getContext(), R.layout.bnz, null);
                addView(this.CVe, new FrameLayout.LayoutParams(-1, -1));
                ((TextView) this.CVe.findViewById(R.id.abi)).setText(getContext().getResources().getString(R.string.gcn, getContext().getResources().getString(R.string.gbp)));
                eQw();
                AppMethodBeat.o(118396);
                return;
            case 10:
                Rect rect3 = new Rect();
                rect3.left = com.tencent.mm.cb.a.fromDPToPix(getContext(), 40);
                rect3.right = point.x - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40);
                rect3.top = (point.y - ((int) (((float) rect3.width()) / 1.467f))) / 2;
                rect3.bottom = rect3.top + ((int) (((float) rect3.width()) / 1.467f));
                Log.i("MicroMsg.ScanCardRectView", "scan driver card rect %s", rect3);
                this.CNj.ij(rect3.width(), rect3.height());
                this.CVc.setCardRect(rect3);
                this.CVe = View.inflate(getContext(), R.layout.bnz, null);
                addView(this.CVe, new FrameLayout.LayoutParams(-1, -1));
                ((TextView) this.CVe.findViewById(R.id.abi)).setText("");
                eQw();
                AppMethodBeat.o(118396);
                return;
        }
    }

    public void setMode(int i2) {
        this.mode = i2;
        this.CDU = 0;
    }

    public void setScanCallback(a aVar) {
        this.CVd = aVar;
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void onResume() {
        AppMethodBeat.i(118397);
        super.onResume();
        if (!this.ROY.isOpen()) {
            a(new b.AbstractCallableC2185b.a() {
                /* class com.tencent.mm.plugin.scanner.view.ScanCardRectView.AnonymousClass3 */

                @Override // com.tencent.scanlib.a.b.AbstractCallableC2185b.a
                public final void eRl() {
                    AppMethodBeat.i(118379);
                    ScanCardRectView.this.a(new b.d.a() {
                        /* class com.tencent.mm.plugin.scanner.view.ScanCardRectView.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.scanlib.a.b.d.a
                        public final void eRk() {
                            AppMethodBeat.i(177499);
                            ScanCardRectView.this.IC(0);
                            AppMethodBeat.o(177499);
                        }
                    });
                    AppMethodBeat.o(118379);
                }
            });
        } else if (!this.ROY.dEO()) {
            a(new b.d.a() {
                /* class com.tencent.mm.plugin.scanner.view.ScanCardRectView.AnonymousClass4 */

                @Override // com.tencent.scanlib.a.b.d.a
                public final void eRk() {
                    AppMethodBeat.i(177500);
                    ScanCardRectView.this.IC(0);
                    AppMethodBeat.o(177500);
                }
            });
        } else {
            IC(0);
        }
        this.CDU = System.currentTimeMillis();
        if (this.mode == 7) {
            com.tencent.mm.plugin.scanner.b.a.b ePG = com.tencent.mm.plugin.scanner.b.a.b.ePG();
            long j2 = this.CDU;
            b.a aVar = this.CVg;
            synchronized (ePG.CCt) {
                try {
                    ePG.CDU = j2;
                    ePG.CDX = 0;
                    ePG.CDV = aVar;
                } catch (Throwable th) {
                    AppMethodBeat.o(118397);
                    throw th;
                }
            }
        } else if (this.mode == 9 || this.mode == 11 || this.mode == 10) {
            if (this.mode == 9 || this.mode == 11) {
                c.ePH().a(1, this.CDU, this.CVh);
            } else if (this.mode == 10) {
                c.ePH().a(2, this.CDU, this.CVh);
            }
        }
        this.CNj.cWi();
        AppMethodBeat.o(118397);
    }

    private void eRa() {
        AppMethodBeat.i(118398);
        com.tencent.mm.plugin.scanner.b.a.b.ePG().release();
        c ePH = c.ePH();
        long j2 = this.CDU;
        synchronized (ePH.CCt) {
            try {
                if (ePH.CDU == j2) {
                    ePH.CDU = 0;
                    ePH.CDX = 0;
                    ePH.CEc = null;
                    ePH.CDO.clear();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(118398);
                throw th;
            }
        }
        this.CDU = 0;
        AppMethodBeat.o(118398);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void onPause() {
        AppMethodBeat.i(118399);
        super.onPause();
        eRa();
        AppMethodBeat.o(118399);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void onStop() {
        AppMethodBeat.i(118400);
        super.onStop();
        aPK();
        if (this.CJh != null) {
            this.CJh.eRn();
        }
        ScanCameraLightDetector.CTx.stop();
        EventCenter.instance.removeListener(this.CNK);
        EventCenter.instance.removeListener(this.CJU);
        AppMethodBeat.o(118400);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public final void onDestroy() {
        AppMethodBeat.i(118401);
        super.onDestroy();
        com.tencent.mm.plugin.scanner.b.a.b.ePG().release();
        c.ePH().release();
        AppMethodBeat.o(118401);
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        AppMethodBeat.i(118402);
        super.onPreviewFrame(bArr, camera);
        Log.i("MicroMsg.ScanCardRectView", "onPreviewFrame null data:" + (bArr == null));
        if (this.ROY.dEO() && ((com.tencent.mm.plugin.scanner.a.a) this.ROY).ePE()) {
            ScanCameraLightDetector.CTx.N(bArr, ((com.tencent.mm.plugin.scanner.a.a) this.ROY).hkU().x, ((com.tencent.mm.plugin.scanner.a.a) this.ROY).hkU().y);
        }
        if (this.mode == 7) {
            Rect w = ((com.tencent.scanlib.a.a) this.ROY).w(getDecorRect());
            com.tencent.mm.plugin.scanner.b.a.b ePG = com.tencent.mm.plugin.scanner.b.a.b.ePG();
            Point hkU = this.ROY.hkU();
            int cameraRotation = this.ROY.getCameraRotation();
            synchronized (ePG.CCt) {
                try {
                    if (!(w.width() == ePG.CDR.width() && w.height() == ePG.CDR.height())) {
                        synchronized (ePG.CDP) {
                            try {
                                if (ePG.gKM) {
                                    WxQbarNative.focusedEngineRelease();
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(118402);
                                throw th;
                            }
                        }
                        ePG.gKM = false;
                    }
                } finally {
                    AppMethodBeat.o(118402);
                }
            }
            Log.i("MicroMsg.BankCardDetectQueue", "resolution %s, rotation %d, rect %s", hkU, Integer.valueOf(cameraRotation), w);
            if (!ePG.gKM) {
                synchronized (ePG.CDP) {
                    try {
                        Log.i("MicroMsg.BankCardDetectQueue", "rect %s", w);
                        ePG.CDR = w;
                        int width = (int) (((float) w.width()) * com.tencent.mm.plugin.scanner.b.a.b.CDN);
                        int height = (int) (((float) w.height()) * com.tencent.mm.plugin.scanner.b.a.b.CDN);
                        ePG.iiw.left = w.left - ((width - w.width()) / 2);
                        ePG.iiw.top = w.top - ((height - w.height()) / 2);
                        ePG.iiw.right = ePG.iiw.left + width;
                        ePG.iiw.bottom = ePG.iiw.top + height;
                        Log.i("MicroMsg.BankCardDetectQueue", "cropRect %s", ePG.iiw);
                        ePG.gKM = WxQbarNative.focusedEngineForBankcardInit(width, height, 8, false) == 0;
                    } catch (Throwable th2) {
                        AppMethodBeat.o(118402);
                        throw th2;
                    }
                }
            }
            if (ePG.gKM) {
                synchronized (ePG.CCt) {
                    try {
                        ePG.CDO.clear();
                        ePG.CDO.put("param_preview_data", bArr);
                        ePG.CDO.put("param_camera_resolution", hkU);
                        ePG.CDO.put("param_camera_rotation", Integer.valueOf(cameraRotation));
                        if (!ePG.CDW && ePG.CDU != 0) {
                            Log.i("MicroMsg.BankCardDetectQueue", "%d submit decode bankcard", Long.valueOf(ePG.CDU));
                            ePG.CDT.execute(new b.RunnableC1664b(ePG.CDU));
                        }
                    } catch (Throwable th3) {
                        AppMethodBeat.o(118402);
                        throw th3;
                    }
                }
            }
            if (!((com.tencent.scanlib.a.a) this.ROY).eQZ() && com.tencent.mm.plugin.scanner.b.a.b.ePG().CDX > 10) {
                Log.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
                this.ROY.setFocusMode("auto");
                Oy(100);
            }
            return;
        }
        if (this.mode == 11) {
            Rect w2 = ((com.tencent.scanlib.a.a) this.ROY).w(getDecorRect());
            c ePH = c.ePH();
            Point hkU2 = this.ROY.hkU();
            int cameraRotation2 = this.ROY.getCameraRotation();
            synchronized (ePH.CCt) {
                try {
                    if (!(w2.width() == ePH.CDR.width() && w2.height() == ePH.CDR.height())) {
                        ePH.release();
                        ePH.gKM = false;
                    }
                } finally {
                    AppMethodBeat.o(118402);
                }
            }
            if (!ePH.gKM) {
                synchronized (ePH.CDP) {
                    try {
                        ePH.CDR = w2;
                        int width2 = (((int) (((double) w2.width()) * 1.05d)) / 4) * 4;
                        int height2 = (((int) (((double) w2.height()) * 1.05d)) / 4) * 4;
                        ePH.iiw.left = w2.left - ((width2 - w2.width()) / 2);
                        ePH.iiw.top = w2.top - ((height2 - w2.height()) / 2);
                        ePH.iiw.right = width2 + ePH.iiw.left;
                        ePH.iiw.bottom = ePH.iiw.top + height2;
                        if (cameraRotation2 % TXLiveConstants.RENDER_ROTATION_180 != 0) {
                            int height3 = (hkU2.y - ePH.iiw.height()) / 2;
                            int width3 = (hkU2.x - ePH.iiw.width()) / 2;
                            ePH.iiw = new Rect(height3, width3, ePH.iiw.height() + height3, ePH.iiw.width() + width3);
                        }
                        Log.i("MicroMsg.LicenseCardDecodeQueue", "init cropRect %s", ePH.iiw);
                        int recognizeCardInit = LibCardRecog.recognizeCardInit(ePH.iiw.width(), ePH.iiw.height(), ePH.ixW);
                        Log.d("MicroMsg.LicenseCardDecodeQueue", "initRet %d, cropWidth %d, cropHeight %d", Integer.valueOf(recognizeCardInit), Integer.valueOf(ePH.iiw.width()), Integer.valueOf(ePH.iiw.height()));
                        ePH.gKM = recognizeCardInit == 0;
                    } catch (Throwable th4) {
                        AppMethodBeat.o(118402);
                        throw th4;
                    }
                }
            }
            if (ePH.gKM) {
                synchronized (ePH.CCt) {
                    try {
                        ePH.CDO.clear();
                        ePH.CDO.put("param_preview_data", bArr);
                        ePH.CDO.put("param_camera_resolution", hkU2);
                        ePH.CDO.put("param_camera_rotation", Integer.valueOf(cameraRotation2));
                        if (!ePH.CDW && ePH.CDU != 0) {
                            Log.i("MicroMsg.LicenseCardDecodeQueue", "%d submit decode license card", Long.valueOf(ePH.CDU));
                            ePH.CDQ.execute(new c.a(ePH.CDU));
                        }
                    } catch (Throwable th5) {
                        AppMethodBeat.o(118402);
                        throw th5;
                    }
                }
            }
            if (!((com.tencent.scanlib.a.a) this.ROY).eQZ() && c.ePH().CDX > 10) {
                Log.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
                this.ROY.setFocusMode("auto");
                Oy(100);
            }
        }
    }

    @Override // com.tencent.scanlib.ui.ScanView
    public void onAutoFocus(boolean z, Camera camera) {
        AppMethodBeat.i(118403);
        Log.i("MicroMsg.ScanCardRectView", "onAutoFocus %s", Boolean.valueOf(z));
        if (z) {
            IC(0);
        }
        Oy((long) RPb);
        AppMethodBeat.o(118403);
    }

    private void eQw() {
        AppMethodBeat.i(118404);
        this.CJh = (ScannerFlashSwitcher) this.CVe.findViewById(R.id.hb4);
        if (this.CJh != null) {
            this.CJh.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.scanner.view.ScanCardRectView.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(177504);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/view/ScanCardRectView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (!ScanCardRectView.this.CJh.VC) {
                        tj tjVar = new tj();
                        tjVar.dZP.dDe = 1;
                        EventCenter.instance.publish(tjVar);
                        ScanCardRectView.this.CJh.eRm();
                    } else {
                        tj tjVar2 = new tj();
                        tjVar2.dZP.dDe = 2;
                        EventCenter.instance.publish(tjVar2);
                        ScanCardRectView.this.CJh.eRn();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/view/ScanCardRectView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(177504);
                }
            });
        }
        EventCenter.instance.addListener(this.CJU);
        EventCenter.instance.addListener(this.CNK);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.scanner.view.ScanCardRectView.AnonymousClass9 */

            {
                AppMethodBeat.i(161727);
                AppMethodBeat.o(161727);
            }

            public final void run() {
                AppMethodBeat.i(177505);
                ScanCameraLightDetector.CTx.start(((com.tencent.mm.plugin.scanner.a.a) ScanCardRectView.this.ROY).getFocusMode());
                AppMethodBeat.o(177505);
            }
        }, 300);
        AppMethodBeat.o(118404);
    }
}
