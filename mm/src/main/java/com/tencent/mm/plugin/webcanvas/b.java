package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\f\u0010\u0010\u001a\u00020\u000f*\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/webcanvas/WebCanvasHttpImageStreamFetcher;", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher;", "()V", "connectionTimeoutMs", "", "readTimeoutMs", "accept", "", "obj", "", "fetch", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher$StreamFetchResult;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "getSourceTypeName", "", "toFileName", "Companion", "webview-sdk_release"})
public final class b implements com.github.henryye.nativeiv.b.b {
    public static final a IzB = new a((byte) 0);
    private int bbs = CommonUtils.MAX_TIMEOUT_MS;
    private int bbt = CommonUtils.MAX_TIMEOUT_MS;

    static {
        AppMethodBeat.i(224619);
        AppMethodBeat.o(224619);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"needRedirect", "", "respCode", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.webcanvas.b$b  reason: collision with other inner class name */
    static final class C1934b extends q implements kotlin.g.a.b<Integer, Boolean> {
        final /* synthetic */ z.d IzC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1934b(z.d dVar) {
            super(1);
            this.IzC = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(Integer num) {
            AppMethodBeat.i(224616);
            Boolean valueOf = Boolean.valueOf(Dz(num.intValue()));
            AppMethodBeat.o(224616);
            return valueOf;
        }

        public final boolean Dz(int i2) {
            return this.IzC.SYE < 15 && (i2 == 301 || i2 == 302);
        }
    }

    @Override // com.github.henryye.nativeiv.b.b
    public final boolean accept(Object obj) {
        AppMethodBeat.i(224617);
        p.h(obj, "obj");
        if (!(obj instanceof String) || (!n.J((String) obj, HttpWrapperBase.PROTOCAL_HTTP, false) && !n.J((String) obj, HttpWrapperBase.PROTOCAL_HTTPS, false))) {
            AppMethodBeat.o(224617);
            return false;
        }
        AppMethodBeat.o(224617);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0210 A[SYNTHETIC, Splitter:B:59:0x0210] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0215 A[Catch:{ Exception -> 0x0275 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x021a A[Catch:{ Exception -> 0x0275 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x027d A[SYNTHETIC, Splitter:B:82:0x027d] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0282 A[Catch:{ Exception -> 0x029a }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0287 A[Catch:{ Exception -> 0x029a }] */
    @Override // com.github.henryye.nativeiv.b.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.github.henryye.nativeiv.b.b.a a(java.lang.Object r17, com.github.henryye.nativeiv.ImageDecodeConfig r18) {
        /*
        // Method dump skipped, instructions count: 689
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webcanvas.b.a(java.lang.Object, com.github.henryye.nativeiv.ImageDecodeConfig):com.github.henryye.nativeiv.b.b$a");
    }

    @Override // com.github.henryye.nativeiv.b.b
    public final String sS() {
        return "http";
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webcanvas/WebCanvasHttpImageStreamFetcher$Companion;", "", "()V", "MAX_REDIRECTS_COUNT", "", "TAG", "", "webview-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
