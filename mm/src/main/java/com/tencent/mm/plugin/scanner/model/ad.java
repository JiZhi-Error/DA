package com.tencent.mm.plugin.scanner.model;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\fJ$\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u0013J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\"\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010\nJ*\u0010%\u001a\u00020\u00132\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J \u0010&\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u001eJ\u0016\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\b2\u0006\u0010!\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper;", "", "()V", "currentInfoViewType", "", "infoMaskView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView;", "isLoadingShow", "", "loadingCancelListener", "Lcom/tencent/mm/plugin/scanner/view/ScanLoadingViewModel$OnCancelListener;", "mScanUIMode", "Lcom/tencent/mm/plugin/scanner/model/IScanUIModel;", "scanMaskView", "Lcom/tencent/mm/plugin/scanner/view/BaseScanMaskView;", "Lcom/tencent/mm/plugin/scanner/api/BaseScanRequest;", "sharedMaskView", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanSharedMaskView;", "animateSwitch", "", "animationListener", "Landroid/animation/AnimatorListenerAdapter;", "attachScanUIModel", "scanUIModel", "buildViewParams", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "context", "Landroid/content/Context;", "showType", "data", "Landroid/os/Bundle;", "cancelLoading", "dismissInfoView", "withAnimation", "getInfoViewType", "setOnCancelListener", "cancelListener", "setScanMaskView", "showInfoView", "extra", "showLoadingView", "show", "Companion", "plugin-scan_release"})
public final class ad {
    public static final a CGJ = new a((byte) 0);
    private f CGC;
    public BaseScanMaskView<BaseScanRequest> CGD;
    public ScanSharedMaskView CGE;
    public ScanInfoMaskView CGF;
    public boolean CGG;
    public c.a CGH;
    public int CGI;

    static {
        AppMethodBeat.i(240458);
        AppMethodBeat.o(240458);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(BaseScanMaskView<BaseScanRequest> baseScanMaskView, ScanSharedMaskView scanSharedMaskView, ScanInfoMaskView scanInfoMaskView) {
        this.CGD = baseScanMaskView;
        this.CGE = scanSharedMaskView;
        this.CGF = scanInfoMaskView;
    }

    public final void a(f fVar) {
        AppMethodBeat.i(240455);
        p.h(fVar, "scanUIModel");
        this.CGC = fVar;
        AppMethodBeat.o(240455);
    }

    public final void ag(boolean z, boolean z2) {
        boolean z3;
        AppMethodBeat.i(240456);
        if (this.CGG != z) {
            if (z) {
                BaseScanMaskView<BaseScanRequest> baseScanMaskView = this.CGD;
                View targetSuccessMarkView = baseScanMaskView != null ? baseScanMaskView.getTargetSuccessMarkView() : null;
                ScanInfoMaskView scanInfoMaskView = this.CGF;
                if (scanInfoMaskView != null) {
                    scanInfoMaskView.setAnchorView(targetSuccessMarkView);
                }
            }
            this.CGG = z;
            ScanSharedMaskView scanSharedMaskView = this.CGE;
            if (scanSharedMaskView != null) {
                if (!z) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                scanSharedMaskView.ui(z3);
            }
            ScanInfoMaskView scanInfoMaskView2 = this.CGF;
            if (scanInfoMaskView2 != null) {
                Log.v("MicroMsg.ScanInfoMaskView", "alvinluo showLoadingView show: %b, withAnimation: %b", Boolean.valueOf(z), Boolean.valueOf(z2));
                View view = scanInfoMaskView2.BCP;
                if (view == null) {
                    p.btv("infoLayout");
                }
                view.setVisibility(8);
                TextView textView = scanInfoMaskView2.CRU;
                if (textView == null) {
                    p.btv("opButton");
                }
                textView.setVisibility(8);
                if (!z) {
                    scanInfoMaskView2.setVisibility(8);
                    scanInfoMaskView2.CGG = false;
                    View view2 = scanInfoMaskView2.xcd;
                    if (view2 == null) {
                        p.btv("loadingLayout");
                    }
                    view2.setVisibility(8);
                    scanInfoMaskView2.eRC();
                } else if (!z2) {
                    scanInfoMaskView2.ue(false);
                } else {
                    scanInfoMaskView2.CRX = false;
                    scanInfoMaskView2.CSd = true;
                    scanInfoMaskView2.CSe = z2;
                    View view3 = scanInfoMaskView2.xcd;
                    if (view3 == null) {
                        p.btv("loadingLayout");
                    }
                    view3.setVisibility(0);
                    scanInfoMaskView2.setVisibility(4);
                    scanInfoMaskView2.post(new ScanInfoMaskView.f(scanInfoMaskView2));
                }
            }
            BaseScanMaskView<BaseScanRequest> baseScanMaskView2 = this.CGD;
            if (baseScanMaskView2 != null) {
                baseScanMaskView2.uc(z);
                AppMethodBeat.o(240456);
                return;
            }
        }
        AppMethodBeat.o(240456);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00a2, code lost:
        if (r1 == null) goto L_0x00a4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.scanner.view.a.C1682a b(android.content.Context r12, int r13, android.os.Bundle r14) {
        /*
        // Method dump skipped, instructions count: 398
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.model.ad.b(android.content.Context, int, android.os.Bundle):com.tencent.mm.plugin.scanner.view.a$a");
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ ad CGK;

        b(ad adVar) {
            this.CGK = adVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(240453);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper$buildViewParams$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            f fVar = this.CGK.CGC;
            if (fVar != null) {
                fVar.ePP();
            }
            af.eQo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper$buildViewParams$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240453);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ ad CGK;

        c(ad adVar) {
            this.CGK = adVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(240454);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper$buildViewParams$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            f fVar = this.CGK.CGC;
            if (fVar != null) {
                fVar.ePP();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/model/ScanInfoPageViewHelper$buildViewParams$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(240454);
        }
    }
}
