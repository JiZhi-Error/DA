package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.box.c.b;
import com.tencent.mm.plugin.box.webview.e;
import com.tencent.mm.plugin.scanner.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J,\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/box/webview/IBoxWebData;", "uiComponent", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "(Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;)V", "netScene", "Lcom/tencent/mm/plugin/scanner/model/NetSceneBizAiScanImageRetrieval;", "finish", "", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "requestDataFromServer", "requestId", "queryJson", "Companion", "plugin-scan_release"})
public final class p implements i, e {
    public static final a CDn = new a((byte) 0);
    j CDm;
    private final b plU;

    static {
        AppMethodBeat.i(52139);
        AppMethodBeat.o(52139);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public p(b bVar) {
        kotlin.g.b.p.h(bVar, "uiComponent");
        AppMethodBeat.i(52138);
        this.plU = bVar;
        g.azz().a(1532, this);
        AppMethodBeat.o(52138);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        if (r0 != null) goto L_0x0078;
     */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r8, int r9, java.lang.String r10, com.tencent.mm.ak.q r11) {
        /*
        // Method dump skipped, instructions count: 131
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.box.p.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    @Override // com.tencent.mm.plugin.box.webview.e
    public final void fc(String str, String str2) {
        AppMethodBeat.i(52137);
        Log.i("MicroMsg.ScanBoxWebData", "alvinluo requestDataFromServer requestId: %s, queryJson: %s", str, str2);
        String str3 = str2;
        if (str3 == null || str3.length() == 0) {
            AppMethodBeat.o(52137);
            return;
        }
        try {
            if (this.CDm != null) {
                g.azz().a(this.CDm);
            }
            this.CDm = new j(str, str2);
            g.azz().b(this.CDm);
            AppMethodBeat.o(52137);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanBoxWebData", e2, "alvinluo requestDataFromServer exception", new Object[0]);
            AppMethodBeat.o(52137);
        }
    }
}
