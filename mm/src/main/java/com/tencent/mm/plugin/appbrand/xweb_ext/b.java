package com.tencent.mm.plugin.appbrand.xweb_ext;

import android.content.Context;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/UseXWebCanvas;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", ch.COL_USERNAME, "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-appbrand-integration_release"})
public final class b implements com.tencent.mm.pluginsdk.cmd.a {
    public static final a oGm = new a((byte) 0);

    static {
        AppMethodBeat.i(51458);
        AppMethodBeat.o(51458);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(51457);
        p.h(context, "context");
        p.h(strArr, "args");
        p.h(str, ch.COL_USERNAME);
        if (!p.j("//skia", strArr[0])) {
            AppMethodBeat.o(51457);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(51457);
            return false;
        } else {
            String str2 = strArr[1];
            switch (str2.hashCode()) {
                case 3569038:
                    if (str2.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        a.cdi().putBoolean("use_skia_canvas", true);
                        a.cdi().commit();
                        break;
                    }
                    a.cdi().clear();
                    a.cdi().commit();
                    break;
                case 97196323:
                    if (str2.equals("false")) {
                        a.cdi().putBoolean("use_skia_canvas", false);
                        a.cdi().commit();
                        break;
                    }
                    a.cdi().clear();
                    a.cdi().commit();
                    break;
                default:
                    a.cdi().clear();
                    a.cdi().commit();
                    break;
            }
            AppMethodBeat.o(51457);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\r\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/UseXWebCanvas$Companion;", "", "()V", "COMMAND_USE_XWEB_CANVAS", "", "TAG", "USE_SKIA_CANVAS", "kvCommand", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getKvCommand", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "register", "", "useSkiaCanvas", "", "()Ljava/lang/Boolean;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static MultiProcessMMKV cdi() {
            AppMethodBeat.i(51455);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("MicroMsg.UseXWebCanvas");
            p.g(mmkv, "MultiProcessMMKV.getMMKV(TAG)");
            AppMethodBeat.o(51455);
            return mmkv;
        }
    }

    public static final void LW() {
        AppMethodBeat.i(51459);
        com.tencent.mm.pluginsdk.cmd.b.a(new b(), "//skia");
        AppMethodBeat.o(51459);
    }
}
