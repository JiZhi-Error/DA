package com.tencent.tbs.one.impl.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.impl.common.a;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;
import java.util.Map;

public final class b implements TBSOneDebugger {

    /* renamed from: a  reason: collision with root package name */
    private final String f2391a;

    public b(String str) {
        this.f2391a = str;
    }

    @Override // com.tencent.tbs.one.TBSOneDebugger
    public final View createPanelView(Context context) {
        AppMethodBeat.i(174163);
        a aVar = new a(context, this.f2391a);
        AppMethodBeat.o(174163);
        return aVar;
    }

    @Override // com.tencent.tbs.one.TBSOneDebugger
    public final void executeCommand(final Context context, final String str, final Map<String, Object> map, final TBSOneCallback<Void> tBSOneCallback) {
        AppMethodBeat.i(174164);
        a.a(context, new TBSOneCallback<TBSOneDebugPlugin>() {
            /* class com.tencent.tbs.one.impl.b.b.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.tbs.one.TBSOneCallback
            public final /* synthetic */ void onCompleted(TBSOneDebugPlugin tBSOneDebugPlugin) {
                AppMethodBeat.i(174158);
                try {
                    tBSOneDebugPlugin.executeCommand(context, b.this.f2391a, str, map, tBSOneCallback);
                    AppMethodBeat.o(174158);
                } catch (UnsupportedOperationException e2) {
                    if (tBSOneCallback != null) {
                        tBSOneCallback.onError(102, "Unimplemented method");
                    }
                    AppMethodBeat.o(174158);
                }
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onError(int i2, String str) {
                AppMethodBeat.i(174157);
                if (tBSOneCallback != null) {
                    tBSOneCallback.onError(i2, str);
                }
                AppMethodBeat.o(174157);
            }
        });
        AppMethodBeat.o(174164);
    }
}
