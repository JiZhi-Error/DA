package com.tencent.mm.ipcinvoker.wx_extension.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/ipcinvoker/wx_extension/service/LiteAppIPCService;", "Lcom/tencent/mm/ipcinvoker/BaseIPCService;", "()V", "getProcessName", "", "Companion", "lib-ipcinvoker-wx-extension_release"})
public final class LiteAppIPCService extends BaseIPCService {
    private static String TAG = "MicroMsg.LiteAppIPCService";
    private static final String dkO = (MMApplicationContext.getPackageName() + ":lite");
    public static final a hnQ = new a((byte) 0);

    @Override // com.tencent.mm.ipcinvoker.BaseIPCService
    public final String getProcessName() {
        return dkO;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J_\u0010\u000b\u001a\u00020\f\"\u0014\b\u0000\u0010\r*\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00100\u000e\"\b\b\u0001\u0010\u000f*\u00020\u0011\"\b\b\u0002\u0010\u0010*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u0001H\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\r0\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010\u0017JQ\u0010\u0018\u001a\u0004\u0018\u0001H\u0010\"\u0014\b\u0000\u0010\r*\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00100\u0019\"\b\b\u0001\u0010\u000f*\u00020\u0011\"\b\b\u0002\u0010\u0010*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u0001H\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\r0\u0014H\u0007¢\u0006\u0002\u0010\u001aR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/ipcinvoker/wx_extension/service/LiteAppIPCService$Companion;", "", "()V", "PROCESS_NAME", "", "getPROCESS_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "setTAG", "(Ljava/lang/String;)V", "invokeAsyncToLiteApp", "", "T", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "InputType", "ResultType", "Landroid/os/Parcelable;", "data", "taskClass", "Ljava/lang/Class;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "(Landroid/os/Parcelable;Ljava/lang/Class;Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;)Z", "invokeSyncToLiteApp", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "(Landroid/os/Parcelable;Ljava/lang/Class;)Landroid/os/Parcelable;", "lib-ipcinvoker-wx-extension_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(225244);
        AppMethodBeat.o(225244);
    }
}
