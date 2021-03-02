package com.tencent.mm.plugin.flutter.e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flutter.e.a.a.o;
import com.tencent.mm.plugin.recordvideo.res.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorTextFetcher;", "", "()V", "FLUTTER_TAG", "", "getFLUTTER_TAG", "()Ljava/lang/String;", "checkFontFamilyRes", "", "getFontFamilyData", "", "Companion", "plugin-flutter_release"})
public final class l {
    private static l wKv;
    public static final a wKw = new a((byte) 0);
    final String vRb;

    static {
        AppMethodBeat.i(241099);
        AppMethodBeat.o(241099);
    }

    private l() {
        this.vRb = "MMVideoEditorTextFetcher.FlutterVideoEditor_DataReport";
    }

    public /* synthetic */ l(byte b2) {
        this();
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorTextFetcher$Companion;", "", "()V", "mInstance", "Lcom/tencent/mm/plugin/flutter/plugins/video/api/MMVideoEditorTextFetcher;", "getInstance", "plugin-flutter_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static l dMc() {
            AppMethodBeat.i(241096);
            if (l.wKv == null) {
                l.wKv = new l((byte) 0);
            }
            l lVar = l.wKv;
            if (lVar == null) {
                p.hyc();
            }
            AppMethodBeat.o(241096);
            return lVar;
        }
    }

    public final boolean dMa() {
        AppMethodBeat.i(241098);
        if (!e.BYn.BXZ) {
            h.INSTANCE.dN(1565, 10);
            Log.i(this.vRb, "start to download font");
            e.BYn.BYa = new b(this);
        }
        e.BYn.bbA();
        boolean z = e.BYn.BXZ;
        AppMethodBeat.o(241098);
        return z;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ l wKx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(l lVar) {
            super(0);
            this.wKx = lVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(241097);
            h.INSTANCE.dN(1565, 11);
            Log.i(this.wKx.vRb, "download font success");
            o.a aVar = o.wKI;
            o.a.dMh().t("downloadFontFileSuccess", 0);
            x xVar = x.SXb;
            AppMethodBeat.o(241097);
            return xVar;
        }
    }
}
