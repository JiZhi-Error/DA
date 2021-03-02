package com.tencent.mm.plugin.ab;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "dispatch", "", "eventType", "", "event", "cb", "Landroid/webkit/ValueCallback;", "webview-sdk_release"})
public interface c extends b {
    void b(String str, String str2, ValueCallback<String> valueCallback);

    @l(hxD = {1, 1, 16})
    public static final class a {
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.ab.c */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(c cVar, String str, String str2, ValueCallback valueCallback, int i2) {
            AppMethodBeat.i(224771);
            if ((i2 & 2) != 0) {
                str2 = "{}";
            }
            if ((i2 & 4) != 0) {
                valueCallback = null;
            }
            cVar.b(str, str2, valueCallback);
            AppMethodBeat.o(224771);
        }
    }
}
