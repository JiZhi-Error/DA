package com.tencent.mm.plugin.hld;

import android.content.ComponentName;
import android.inputmethodservice.InputMethodService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/hld/WxHldService;", "Landroid/inputmethodservice/InputMethodService;", "()V", "onCreate", "", "Companion", "plugin-hld_release"})
public class WxHldService extends InputMethodService {
    public static final a yjs = new a((byte) 0);

    static {
        AppMethodBeat.i(192242);
        AppMethodBeat.o(192242);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/hld/WxHldService$Companion;", "", "()V", "IME_ID_NAME", "", "TAG", "plugin-hld_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public void onCreate() {
        AppMethodBeat.i(192241);
        super.onCreate();
        Log.i("WxIme.WxHldService", "not available ime, switch to another ime.");
        getPackageManager().setComponentEnabledSetting(new ComponentName(this, "com.tencent.mm.plugin.hld.WxHldService"), 2, 1);
        AppMethodBeat.o(192241);
    }
}
