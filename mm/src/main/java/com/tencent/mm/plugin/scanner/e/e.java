package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.scanner.api.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0003\u000f\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001c\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRReporter;", "Lcom/tencent/mm/plugin/scanner/api/ocr/IImageOCRReporter;", "()V", "opReported", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "key", "opType", "", "scene", "reportOCRMenuOp", "", "reset", "Companion", "ResultOpType", "ZoomOpType", "plugin-scan_release"})
public final class e implements b {
    public static final a CIJ = new a((byte) 0);
    private final HashMap<String, Boolean> CII = new HashMap<>();

    static {
        AppMethodBeat.i(240553);
        AppMethodBeat.o(240553);
    }

    public e() {
        AppMethodBeat.i(240552);
        AppMethodBeat.o(240552);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRReporter$Companion;", "", "()V", "TAG", "", "reportImageOCRResultOp", "", "sessionId", "", "opType", "", "reportImageZoomOp", "zoomOpType", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void S(long j2, int i2) {
            AppMethodBeat.i(240548);
            h.INSTANCE.a(21699, String.valueOf(j2), Integer.valueOf(i2));
            AppMethodBeat.o(240548);
        }

        public static void T(long j2, int i2) {
            AppMethodBeat.i(240549);
            h.INSTANCE.a(21700, String.valueOf(j2), Integer.valueOf(i2));
            AppMethodBeat.o(240549);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.api.a.b
    public final void reset() {
        AppMethodBeat.i(240550);
        Log.v("MicroMsg.ImageOCRReporter", "alvinluo ImageOCRReporter reset");
        this.CII.clear();
        AppMethodBeat.o(240550);
    }

    @Override // com.tencent.mm.plugin.scanner.api.a.b
    public final void hY(int i2, int i3) {
        AppMethodBeat.i(240551);
        String sb = new StringBuilder().append(i2).append(',').append(i3).toString();
        Log.v("MicroMsg.ImageOCRReporter", "alvinluo reportOCRMenuOp key: %s, reported: %s", sb, this.CII.get(sb));
        if (!p.j(this.CII.get(sb), Boolean.TRUE)) {
            this.CII.put(sb, Boolean.TRUE);
            h.INSTANCE.a(22143, Integer.valueOf(i3), Integer.valueOf(i2));
        }
        AppMethodBeat.o(240551);
    }
}
