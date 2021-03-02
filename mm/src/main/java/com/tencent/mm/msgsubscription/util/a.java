package com.tencent.mm.msgsubscription.util;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001:\u0005\u0005\u0006\u0007\b\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "", "()V", "getType", "", "ConstantsNetwork", "ConstantsProtocal", "IDispatcher", "IOnSceneEnd", "IReqResp", "wxbiz-msgsubscription-sdk_release"})
public abstract class a {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "wxbiz-msgsubscription-sdk_release"})
    /* renamed from: com.tencent.mm.msgsubscription.util.a$a  reason: collision with other inner class name */
    public interface AbstractC0480a {
        int a(c cVar, b bVar, a aVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "wxbiz-msgsubscription-sdk_release"})
    public interface b {
        void k(int i2, int i3, String str);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "", "requestProtoBuf", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "getRequestProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "responseProtoBuf", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getResponseProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "getType", "()I", ShareConstants.MEDIA_URI, "", "getUri", "()Ljava/lang/String;", "Companion", "wxbiz-msgsubscription-sdk_release"})
    public interface c {
        public static final C0481a jCZ = C0481a.jDa;

        dop bjh();

        dpc bji();

        int getType();

        String getUri();

        @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp$Companion;", "", "()V", "build", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", ShareConstants.MEDIA_URI, "", "wxbiz-msgsubscription-sdk_release"})
        /* renamed from: com.tencent.mm.msgsubscription.util.a$c$a  reason: collision with other inner class name */
        public static final class C0481a {
            static final /* synthetic */ C0481a jDa = new C0481a();

            static {
                AppMethodBeat.i(174574);
                AppMethodBeat.o(174574);
            }

            private C0481a() {
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, hxF = {"com/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp$Companion$build$1", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "requestProtoBuf", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "getRequestProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "responseProtoBuf", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getResponseProtoBuf", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "type", "", "getType", "()I", ShareConstants.MEDIA_URI, "", "getUri", "()Ljava/lang/String;", "wxbiz-msgsubscription-sdk_release"})
            /* renamed from: com.tencent.mm.msgsubscription.util.a$c$a$a  reason: collision with other inner class name */
            public static final class C0482a implements c {
                final /* synthetic */ int $type = 2920;
                final /* synthetic */ dop jDb;
                final /* synthetic */ dpc jDc;
                final /* synthetic */ String jDd;

                C0482a(dop dop, dpc dpc, int i2, String str) {
                    this.jDb = dop;
                    this.jDc = dpc;
                    this.jDd = str;
                }

                @Override // com.tencent.mm.msgsubscription.util.a.c
                public final dop bjh() {
                    return this.jDb;
                }

                @Override // com.tencent.mm.msgsubscription.util.a.c
                public final dpc bji() {
                    return this.jDc;
                }

                @Override // com.tencent.mm.msgsubscription.util.a.c
                public final int getType() {
                    return this.$type;
                }

                @Override // com.tencent.mm.msgsubscription.util.a.c
                public final String getUri() {
                    return this.jDd;
                }
            }

            public static c a(dop dop, dpc dpc, String str) {
                AppMethodBeat.i(174573);
                p.h(dop, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
                p.h(dpc, "response");
                p.h(str, ShareConstants.MEDIA_URI);
                C0482a aVar = new C0482a(dop, dpc, 2920, str);
                AppMethodBeat.o(174573);
                return aVar;
            }
        }
    }
}
