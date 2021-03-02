package com.tencent.mm.plugin.scanner.box;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J \u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\u001a\u0010\u001a\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010 \u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0018\u00010\rR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl;", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;", "session", "", "boxDialogOnShowListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/scanner/box/BoxDialogOnShowListener;)V", "createBoxWebViewEnd", "", "createBoxWebViewStart", "initWebViewEnd", "initWebViewStart", "reportInfo", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl$BoxWebViewPreloadReportInfo;", "showEnd", "showStart", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onCreateBoxWebViewEnd", "enablePreloadWebView", "", "enablePreloadFromFindTab", "useCache", "onCreateBoxWebViewStart", "onDismiss", "exitType", "", "onInitWebViewEnd", "onInitWebViewStart", "onShow", "onShowStart", "BoxWebViewPreloadReportInfo", "Companion", "plugin-scan_release"})
public final class k implements j {
    public static final b CCX = new b((byte) 0);
    long CCP;
    private long CCQ;
    private long CCR;
    private long CCS;
    private long CCT;
    private long CCU;
    a CCV;
    private final g CCW;
    final String dRM;

    static {
        AppMethodBeat.i(240284);
        AppMethodBeat.o(240284);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public k(String str, g gVar) {
        p.h(str, "session");
        AppMethodBeat.i(240283);
        this.dRM = str;
        this.CCW = gVar;
        AppMethodBeat.o(240283);
    }

    @Override // com.tencent.mm.plugin.scanner.box.j
    public final void ePs() {
        AppMethodBeat.i(240276);
        this.CCR = System.currentTimeMillis();
        Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onCreateBoxWebViewBefore session: %s", this.dRM);
        AppMethodBeat.o(240276);
    }

    @Override // com.tencent.mm.plugin.scanner.box.j
    public final void n(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(240277);
        this.CCS = System.currentTimeMillis();
        a aVar = this.CCV;
        if (aVar != null) {
            aVar.CCq = z;
            aVar.CCY = z2;
            aVar.efT = z3;
            aVar.CCZ = this.CCS - this.CCR;
        }
        Object[] objArr = new Object[4];
        objArr[0] = this.dRM;
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(z3);
        a aVar2 = this.CCV;
        objArr[3] = aVar2 != null ? Long.valueOf(aVar2.CCZ) : null;
        Log.i("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onCreateBoxWebViewAfter session: %s, enablePreload: %b, useCache: %b, cost: %s", objArr);
        a aVar3 = this.CCV;
        if (aVar3 != null) {
            h.INSTANCE.dN(1259, aVar3.CCq ? 130 : 150);
            if (!aVar3.CCq) {
                h.INSTANCE.n(1259, 151, aVar3.CCZ);
                AppMethodBeat.o(240277);
            } else if (!aVar3.efT) {
                h.INSTANCE.dN(1259, TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE);
                h.INSTANCE.n(1259, 133, aVar3.CCZ);
                AppMethodBeat.o(240277);
            } else {
                h.INSTANCE.dN(1259, 132);
                AppMethodBeat.o(240277);
            }
        } else {
            AppMethodBeat.o(240277);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.box.j
    public final void ePt() {
        AppMethodBeat.i(240278);
        Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onInitWebViewStart");
        this.CCT = System.currentTimeMillis();
        AppMethodBeat.o(240278);
    }

    @Override // com.tencent.mm.plugin.scanner.box.j
    public final void ePu() {
        AppMethodBeat.i(240279);
        this.CCU = System.currentTimeMillis();
        a aVar = this.CCV;
        if (aVar != null) {
            aVar.CDa = this.CCU - this.CCT;
        }
        Object[] objArr = new Object[2];
        objArr[0] = this.dRM;
        a aVar2 = this.CCV;
        objArr[1] = aVar2 != null ? Long.valueOf(aVar2.CDa) : null;
        Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onInitWebViewEnd session: %s, cost: %s", objArr);
        a aVar3 = this.CCV;
        if (aVar3 != null) {
            aVar3.report();
            AppMethodBeat.o(240279);
            return;
        }
        AppMethodBeat.o(240279);
    }

    @Override // com.tencent.mm.plugin.scanner.box.g
    public final void onShow(DialogInterface dialogInterface) {
        AppMethodBeat.i(240280);
        g gVar = this.CCW;
        if (gVar != null) {
            gVar.onShow(dialogInterface);
        }
        this.CCQ = System.currentTimeMillis();
        a aVar = this.CCV;
        if (aVar != null) {
            aVar.CDb = this.CCQ - this.CCP;
        }
        Object[] objArr = new Object[2];
        objArr[0] = this.dRM;
        a aVar2 = this.CCV;
        objArr[1] = aVar2 != null ? Long.valueOf(aVar2.CDb) : null;
        Log.i("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onShow session: %s, cost: %s", objArr);
        a aVar3 = this.CCV;
        if (aVar3 != null) {
            aVar3.report();
            AppMethodBeat.o(240280);
            return;
        }
        AppMethodBeat.o(240280);
    }

    @Override // com.tencent.mm.plugin.scanner.box.g
    public final void a(DialogInterface dialogInterface, int i2) {
        AppMethodBeat.i(240281);
        Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onDismiss session: %s", this.dRM);
        g gVar = this.CCW;
        if (gVar != null) {
            gVar.a(dialogInterface, i2);
            AppMethodBeat.o(240281);
            return;
        }
        AppMethodBeat.o(240281);
    }

    @Override // com.tencent.mm.plugin.scanner.box.g
    public final void onCancel(DialogInterface dialogInterface) {
        AppMethodBeat.i(240282);
        Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo onCancel session: %s", this.dRM);
        g gVar = this.CCW;
        if (gVar != null) {
            gVar.onCancel(dialogInterface);
            AppMethodBeat.o(240282);
            return;
        }
        AppMethodBeat.o(240282);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001a\u0010\u0017\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl$BoxWebViewPreloadReportInfo;", "", "(Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListenerImpl;)V", "enablePreloadFromFindTab", "", "getEnablePreloadFromFindTab", "()Z", "setEnablePreloadFromFindTab", "(Z)V", "enablePreloadWebView", "getEnablePreloadWebView", "setEnablePreloadWebView", "getWebViewCost", "", "getGetWebViewCost", "()J", "setGetWebViewCost", "(J)V", "initWebViewCost", "getInitWebViewCost", "setInitWebViewCost", "isReported", "setReported", "showCost", "getShowCost", "setShowCost", "useCache", "getUseCache", "setUseCache", "report", "", "reportWebViewCreate", "plugin-scan_release"})
    final class a {
        boolean CCY;
        long CCZ = -1;
        boolean CCq;
        long CDa = -1;
        long CDb = -1;
        boolean efT;
        private boolean gqx;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        public final void report() {
            int i2;
            int i3;
            int i4 = 1;
            AppMethodBeat.i(240275);
            if (this.gqx) {
                AppMethodBeat.o(240275);
                return;
            }
            if (this.CCZ >= 0 && this.CDb > 0 && this.CDa > 0) {
                this.gqx = true;
                Log.v("MicroMsg.ScanBoxDialogViewListenerImpl", "alvinluo reportScanGoodsWebViewCreate enablePreloadWebView: %b, enablePreloadFromFindTab: %b, useCache: %b, getWebViewCost: %d, initWebViewCost: %d, showCost: %d", Boolean.valueOf(this.CCq), Boolean.valueOf(this.CCY), Boolean.valueOf(this.efT), Long.valueOf(this.CCZ), Long.valueOf(this.CDa), Long.valueOf(this.CDb));
                h hVar = h.INSTANCE;
                Object[] objArr = new Object[6];
                if (this.CCq) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                objArr[0] = Integer.valueOf(i2);
                if (this.efT) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                objArr[1] = Integer.valueOf(i3);
                objArr[2] = Long.valueOf(this.CCZ);
                objArr[3] = Long.valueOf(this.CDa);
                objArr[4] = Long.valueOf(this.CDb);
                if (!this.CCY) {
                    i4 = 0;
                }
                objArr[5] = Integer.valueOf(i4);
                hVar.a(20835, objArr);
            }
            AppMethodBeat.o(240275);
        }
    }
}
