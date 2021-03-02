package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\n\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ocr/BizImageOCRManager;", "", "()V", "TAG", "", "ocrResultMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/scanner/ocr/BizImageOCRManager$ImageOCRResult;", "getOCRResult", "sessionId", "saveOCRResult", "", "result", "ImageOCRResult", "plugin-scan_release"})
public final class a {
    private static final ConcurrentHashMap<String, C1669a> CHT = new ConcurrentHashMap<>();
    public static final a CHU = new a();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ocr/BizImageOCRManager$ImageOCRResult;", "", "()V", "result", "", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "sourceUsername", "getSourceUsername", "setSourceUsername", "plugin-scan_release"})
    /* renamed from: com.tencent.mm.plugin.scanner.e.a$a  reason: collision with other inner class name */
    public static final class C1669a {
        public String CAZ = "";
        public String result = "";
    }

    static {
        AppMethodBeat.i(240482);
        AppMethodBeat.o(240482);
    }

    private a() {
    }

    public static void a(String str, C1669a aVar) {
        AppMethodBeat.i(240480);
        p.h(aVar, "result");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(240480);
            return;
        }
        Log.d("MicroMsg.BizImageOCRManager", "alvinluo saveOCRResult sessionId: " + str + ", sourceUsername: " + aVar.CAZ);
        CHT.put(str, aVar);
        AppMethodBeat.o(240480);
    }

    public static C1669a aMF(String str) {
        AppMethodBeat.i(240481);
        C1669a aVar = CHT.get(str);
        AppMethodBeat.o(240481);
        return aVar;
    }
}
