package com.tencent.mm.plugin.flutter.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.e.a.a.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.q;
import kotlin.x;

public final class n {
    private static n wKE;
    public static final a wKF = new a((byte) 0);
    public final String vRb;

    static {
        AppMethodBeat.i(241110);
        AppMethodBeat.o(241110);
    }

    private n() {
        this.vRb = "MMVideoEditorTransitionResFetcher.FlutterVideoEditor_DataReport";
    }

    public /* synthetic */ n(byte b2) {
        this();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ n wKG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(n nVar) {
            super(0);
            this.wKG = nVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(241109);
            h.INSTANCE.dN(1565, 17);
            Log.d(this.wKG.vRb, "download transition success");
            o.a aVar = o.wKI;
            o.a.dMh().t("downloadTransitionResSuccess", 0);
            x xVar = x.SXb;
            AppMethodBeat.o(241109);
            return xVar;
        }
    }
}
