package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.scanner.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListenerImpl;", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListener;", "()V", "sessionId", "", "onCancel", "", "session", "onDialogCancel", "dialog", "Landroid/content/DialogInterface;", "onDialogDismiss", "exitType", "", "onDialogShow", "onGetOCRResult", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onStart", "onZoomIn", "onZoomOut", "Companion", "plugin-scan_release"})
public final class d implements c {
    public static final a CIH = new a((byte) 0);
    private long sessionId;

    static {
        AppMethodBeat.i(240547);
        AppMethodBeat.o(240547);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListenerImpl$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.scanner.e.c
    public final void IA(long j2) {
        AppMethodBeat.i(240540);
        this.sessionId = j2;
        Log.d("MicroMsg.ImageOCRListenerImpl", "alvinluo onStart session: %s", Long.valueOf(j2));
        AppMethodBeat.o(240540);
    }

    @Override // com.tencent.mm.plugin.scanner.e.c
    public final void IB(long j2) {
        AppMethodBeat.i(240541);
        Log.d("MicroMsg.ImageOCRListenerImpl", "alvinluo onCancel session: %s", Long.valueOf(j2));
        if (this.sessionId == j2) {
            e.a aVar = e.CIJ;
            e.a.S(j2, 1);
        }
        AppMethodBeat.o(240541);
    }

    @Override // com.tencent.mm.plugin.scanner.e.c
    public final void a(f fVar) {
        AppMethodBeat.i(240542);
        p.h(fVar, "result");
        Log.d("MicroMsg.ImageOCRListenerImpl", "alvinluo onGetOCRResult session: %s, success: %s", Long.valueOf(fVar.dDZ), Boolean.valueOf(fVar.success));
        AppMethodBeat.o(240542);
    }

    @Override // com.tencent.mm.plugin.scanner.e.c
    public final void eOX() {
        AppMethodBeat.i(240543);
        e.a aVar = e.CIJ;
        e.a.S(this.sessionId, 2);
        AppMethodBeat.o(240543);
    }

    @Override // com.tencent.mm.plugin.scanner.e.c
    public final void WM(int i2) {
        AppMethodBeat.i(240544);
        if (i2 == 4) {
            e.a aVar = e.CIJ;
            e.a.S(this.sessionId, 3);
            AppMethodBeat.o(240544);
            return;
        }
        if (i2 == 5) {
            e.a aVar2 = e.CIJ;
            e.a.S(this.sessionId, 4);
        }
        AppMethodBeat.o(240544);
    }

    @Override // com.tencent.mm.plugin.scanner.e.c
    public final void bqR() {
        AppMethodBeat.i(240545);
        e.a aVar = e.CIJ;
        e.a.T(this.sessionId, 1);
        AppMethodBeat.o(240545);
    }

    @Override // com.tencent.mm.plugin.scanner.e.c
    public final void bqQ() {
        AppMethodBeat.i(240546);
        e.a aVar = e.CIJ;
        e.a.T(this.sessionId, 2);
        AppMethodBeat.o(240546);
    }
}
