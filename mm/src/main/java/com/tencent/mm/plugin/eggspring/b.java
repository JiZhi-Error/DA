package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.k;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, hxF = {"sendCgi", "Response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cgi", "Lcom/tencent/mm/modelbase/Cgi;", "(Lcom/tencent/mm/modelbase/Cgi;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-eggspring_release"})
public final class b {
    public static final <Response extends dpc> Object a(c<Response> cVar, d<? super Response> dVar) {
        AppMethodBeat.i(194554);
        kotlinx.coroutines.l lVar = new kotlinx.coroutines.l(kotlin.d.a.b.e(dVar));
        kotlinx.coroutines.l lVar2 = lVar;
        com.tencent.mm.vending.e.c cVar2 = new com.tencent.mm.vending.e.c();
        cVar.aYI().a(cVar2).g(new a(lVar2));
        lVar2.W(new C0952b(cVar2));
        Object result = lVar.getResult();
        if (result == kotlin.d.a.a.COROUTINE_SUSPENDED) {
            p.h(dVar, "frame");
        }
        AppMethodBeat.o(194554);
        return result;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032*\u0010\u0004\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u0002 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "Response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ k qUC;

        a(k kVar) {
            this.qUC = kVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(194552);
            c.a aVar = (c.a) obj;
            if (aVar.errType == 0 && aVar.errCode == 0 && aVar.iLC != null) {
                T t = aVar.iLC;
                Result.Companion companion = Result.Companion;
                this.qUC.resumeWith(Result.m46constructorimpl(t));
            } else {
                Result.Companion companion2 = Result.Companion;
                this.qUC.resumeWith(Result.m46constructorimpl(ResultKt.createFailure(new a(aVar.errType, aVar.errCode, aVar.errMsg))));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(194552);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "Response", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", LocaleUtil.ITALIAN, "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.eggspring.b$b  reason: collision with other inner class name */
    static final class C0952b extends q implements kotlin.g.a.b<Throwable, x> {
        final /* synthetic */ com.tencent.mm.vending.e.c qUD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0952b(com.tencent.mm.vending.e.c cVar) {
            super(1);
            this.qUD = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Throwable th) {
            AppMethodBeat.i(194553);
            this.qUD.dead();
            x xVar = x.SXb;
            AppMethodBeat.o(194553);
            return xVar;
        }
    }
}
