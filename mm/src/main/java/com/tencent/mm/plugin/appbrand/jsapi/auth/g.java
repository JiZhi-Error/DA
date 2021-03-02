package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthConstants;", "()V", "Companion", "GetHeadIconPathCallback", "plugin-appbrand-integration_release"})
public final class g {
    private static final String TAG = TAG;
    public static final a lFD = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "", "onCallback", "", "path", "", "plugin-appbrand-integration_release"})
    public interface b {
        void UI(String str);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$Companion;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "TAG", "", "getHeadIconPath", "", ch.COL_USERNAME, "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "plugin-appbrand-integration_release"})
    public static final class a implements f {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(String str, b bVar) {
            AppMethodBeat.i(50445);
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                p.aYn();
                if (!e.Mm(str)) {
                    f fVar = new f();
                    fVar.a(str, new C0634a(fVar, bVar, str));
                    AppMethodBeat.o(50445);
                    return;
                }
            }
            p.aYn();
            if (str == null) {
                str = "";
            }
            String L = e.L(str, false);
            if (L == null) {
                L = "";
            }
            bVar.UI(L);
            AppMethodBeat.o(50445);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "errType", "errCode", "resultCallback"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.auth.g$a$a  reason: collision with other inner class name */
        static final class C0634a implements f.c {
            final /* synthetic */ String hLl;
            final /* synthetic */ f lFE;
            final /* synthetic */ b lFF;

            C0634a(f fVar, b bVar, String str) {
                this.lFE = fVar;
                this.lFF = bVar;
                this.hLl = str;
            }

            @Override // com.tencent.mm.aj.f.c
            public final int dp(int i2, int i3) {
                AppMethodBeat.i(50444);
                Log.i(g.TAG, "GetHDHeadImg errType=%d  errCode=%d", Integer.valueOf(i2), Integer.valueOf(i3));
                this.lFE.sQ();
                b bVar = this.lFF;
                if (bVar != null) {
                    p.aYn();
                    String L = e.L(this.hLl, false);
                    if (L == null) {
                        L = "";
                    }
                    bVar.UI(L);
                }
                AppMethodBeat.o(50444);
                return 0;
            }
        }
    }

    static {
        AppMethodBeat.i(50446);
        AppMethodBeat.o(50446);
    }
}
