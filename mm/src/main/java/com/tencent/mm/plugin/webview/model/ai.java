package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.protocal.protobuf.drk;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "Factory", "plugin-webview_release"})
public interface ai {
    String gcK();

    b gcL();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory;", "", "()V", "wrap", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "resp", "Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeConfirmResp;", "Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;", "plugin-webview_release"})
    public static final class a {
        public static final a IYW = new a();

        static {
            AppMethodBeat.i(210350);
            AppMethodBeat.o(210350);
        }

        private a() {
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory$wrap$1", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "plugin-webview_release"})
        /* renamed from: com.tencent.mm.plugin.webview.model.ai$a$a  reason: collision with other inner class name */
        public static final class C1969a implements ai {
            final /* synthetic */ dri IYX;

            C1969a(dri dri) {
                this.IYX = dri;
            }

            @Override // com.tencent.mm.plugin.webview.model.ai
            public final String gcK() {
                return this.IYX.KJw;
            }

            @Override // com.tencent.mm.plugin.webview.model.ai
            public final com.tencent.mm.bw.b gcL() {
                return this.IYX.MTX;
            }
        }

        public static final ai a(dri dri) {
            AppMethodBeat.i(210348);
            p.h(dri, "resp");
            C1969a aVar = new C1969a(dri);
            AppMethodBeat.o(210348);
            return aVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy$Factory$wrap$2", "Lcom/tencent/mm/plugin/webview/model/SDKOauthAuthorizeRespProxy;", "ilink_auth_buffer", "Lcom/tencent/mm/protobuf/ByteString;", "redirect_url", "", "plugin-webview_release"})
        public static final class b implements ai {
            final /* synthetic */ drk IYY;

            b(drk drk) {
                this.IYY = drk;
            }

            @Override // com.tencent.mm.plugin.webview.model.ai
            public final String gcK() {
                return this.IYY.KJw;
            }

            @Override // com.tencent.mm.plugin.webview.model.ai
            public final com.tencent.mm.bw.b gcL() {
                return this.IYY.MTX;
            }
        }

        public static final ai a(drk drk) {
            AppMethodBeat.i(210349);
            p.h(drk, "resp");
            b bVar = new b(drk);
            AppMethodBeat.o(210349);
            return bVar;
        }
    }
}
