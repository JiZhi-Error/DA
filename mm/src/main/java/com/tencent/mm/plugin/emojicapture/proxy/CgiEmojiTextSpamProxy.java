package com.tencent.mm.plugin.emojicapture.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J5\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062#\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bJ\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0007J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R7\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "TAG", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "shouldBlock", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "cgiEmojiTextSpam", "text", "cgiEmojiTextSpamCallback", "cgiEmojiTextSpamRemote", "plugin-emojicapture_release"})
public final class CgiEmojiTextSpamProxy extends com.tencent.mm.remoteservice.a {
    private final String TAG = "MicroMsg.CgiEmojiTextSpamProxy";
    private b<? super Boolean, x> callback;

    public CgiEmojiTextSpamProxy(d dVar) {
        super(dVar);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.Boolean, kotlin.x>, kotlin.g.a.b<java.lang.Boolean, kotlin.x> */
    public final b<Boolean, x> getCallback() {
        return this.callback;
    }

    public final void setCallback(b<? super Boolean, x> bVar) {
        this.callback = bVar;
    }

    public final void cgiEmojiTextSpam(String str, b<? super Boolean, x> bVar) {
        AppMethodBeat.i(378);
        Log.i(this.TAG, "cgiEmojiTextSpam ".concat(String.valueOf(str)));
        REMOTE_CALL("cgiEmojiTextSpamRemote", str);
        this.callback = bVar;
        AppMethodBeat.o(378);
    }

    @e
    public final void cgiEmojiTextSpamCallback(boolean z) {
        AppMethodBeat.i(379);
        Log.i(this.TAG, "cgiEmojiTextSpamCallback ".concat(String.valueOf(z)));
        b<? super Boolean, x> bVar = this.callback;
        if (bVar != null) {
            bVar.invoke(Boolean.valueOf(z));
            AppMethodBeat.o(379);
            return;
        }
        AppMethodBeat.o(379);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ CgiEmojiTextSpamProxy rrC;
        final /* synthetic */ String rry;

        a(CgiEmojiTextSpamProxy cgiEmojiTextSpamProxy, String str) {
            this.rrC = cgiEmojiTextSpamProxy;
            this.rry = str;
        }

        public final void run() {
            AppMethodBeat.i(377);
            new com.tencent.mm.plugin.emojicapture.a.a(this.rry).aYI().g(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                /* class com.tencent.mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy.a.AnonymousClass1 */
                final /* synthetic */ a rrD;

                {
                    this.rrD = r1;
                }

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    boolean z;
                    AppMethodBeat.i(376);
                    c.a aVar = (c.a) obj;
                    p.h(aVar, "cgiBack");
                    if (aVar.errType == 0 && aVar.errCode == 0) {
                        aiy aiy = (aiy) aVar.iLC;
                        Log.i(this.rrD.rrC.TAG, "CgiTextAntiSpam " + aiy.Lsv + ' ' + aiy.Lsw + ' ' + aiy.Lsx);
                        z = aiy.Lsv;
                    } else {
                        Log.w(this.rrD.rrC.TAG, "CgiTextAntiSpam error " + aVar.errType + ' ' + aVar.errCode);
                        z = false;
                    }
                    Object CLIENT_CALL = this.rrD.rrC.CLIENT_CALL("cgiEmojiTextSpamCallback", Boolean.valueOf(z));
                    AppMethodBeat.o(376);
                    return CLIENT_CALL;
                }
            });
            AppMethodBeat.o(377);
        }
    }

    @f
    public final void cgiEmojiTextSpamRemote(String str) {
        AppMethodBeat.i(380);
        MMHandlerThread.postToMainThread(new a(this, str));
        AppMethodBeat.o(380);
    }
}
