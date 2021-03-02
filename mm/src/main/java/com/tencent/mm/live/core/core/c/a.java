package com.tencent.mm.live.core.core.c;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, hxF = {"Lcom/tencent/mm/live/core/core/secdevice/LiveSecondaryDeviceTRTCCore;", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "()V", "updatePrivateMapKey", "", "privateMapKey", "", "Companion", "plugin-core_release"})
public final class a extends b {
    private static a hAi;
    public static final C0381a hAj = new C0381a((byte) 0);

    static {
        AppMethodBeat.i(196489);
        AppMethodBeat.o(196489);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/live/core/core/secdevice/LiveSecondaryDeviceTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/secdevice/LiveSecondaryDeviceTRTCCore;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
    /* renamed from: com.tencent.mm.live.core.core.c.a$a  reason: collision with other inner class name */
    public static final class C0381a {
        private C0381a() {
        }

        public /* synthetic */ C0381a(byte b2) {
            this();
        }

        public static a aDw() {
            AppMethodBeat.i(196486);
            if (a.hAi == null) {
                a.hAi = new a();
            }
            a aVar = a.hAi;
            if (aVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(196486);
            return aVar;
        }

        public static boolean aDp() {
            AppMethodBeat.i(196487);
            if (a.hAi != null) {
                AppMethodBeat.o(196487);
                return true;
            }
            AppMethodBeat.o(196487);
            return false;
        }
    }

    @Override // com.tencent.mm.live.core.core.trtc.a
    public final void Go(String str) {
        AppMethodBeat.i(196488);
        p.h(str, "privateMapKey");
        if (!Util.isNullOrNil(str)) {
            i iVar = new i();
            iVar.h("privateMapKey", str);
            i iVar2 = new i();
            iVar2.h(ProviderConstants.API_PATH, "updatePrivateMapKey");
            iVar2.h(NativeProtocol.WEB_DIALOG_PARAMS, iVar);
            Log.i("MicroMsg.LiveCoreVisitor", "updatePrivateMapKey:" + iVar2 + ' ');
            this.hAl.callExperimentalAPI(iVar2.toString());
        }
        AppMethodBeat.o(196488);
    }
}
