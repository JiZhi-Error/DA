package com.tencent.mm.ipcinvoker.wx_extension;

import android.app.Application;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.ipcinvoker.a.d;
import com.tencent.mm.ipcinvoker.a.e;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand1IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand2IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand3IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand4IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.LiteAppIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class PluginIPC extends f implements o, b {
    private static final long hnK = TimeUnit.DAYS.toMillis(1);

    static {
        AppMethodBeat.i(146424);
        AppMethodBeat.o(146424);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(146422);
        Log.i("MicroMsg.PluginIPC", "execute(%s)", gVar.mProcessName);
        if (MMApplicationContext.isMainProcess()) {
            String[] strArr = {"MicroMsg.XIPC.MMProtoBufTransfer"};
            for (int i2 = 0; i2 <= 0; i2++) {
                String str = strArr[i2];
                try {
                    com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(MMApplicationContext.getContext().getFilesDir().getAbsolutePath() + "/mmkv/" + str);
                    if (oVar.exists()) {
                        oVar.delete();
                        s.deleteFile(aa.z(oVar.her()) + ".crc");
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.PluginIPC", "delete MMProtoBufTransfer dirty file[%s] e = %s", str, e2);
                }
            }
        }
        Application application = com.tencent.mm.kernel.g.aAe().azG().ca;
        AnonymousClass1 r1 = new com.tencent.mm.ipcinvoker.a.a() {
            /* class com.tencent.mm.ipcinvoker.wx_extension.PluginIPC.AnonymousClass1 */

            @Override // com.tencent.mm.ipcinvoker.a.a, com.tencent.mm.ipcinvoker.a.c
            public final void a(d dVar) {
                AppMethodBeat.i(146416);
                super.a(dVar);
                dVar.a(a.hnD);
                AppMethodBeat.o(146416);
            }

            @Override // com.tencent.mm.ipcinvoker.a.a, com.tencent.mm.ipcinvoker.a.c
            public final void a(e eVar) {
                AppMethodBeat.i(146417);
                super.a(eVar);
                MultiProcessMMKV.init();
                eVar.a(new c());
                eVar.a(new a());
                eVar.a(new d());
                AppMethodBeat.o(146417);
            }

            @Override // com.tencent.mm.ipcinvoker.a.c
            public final void b(d dVar) {
                AppMethodBeat.i(146418);
                dVar.a(MainProcessIPCService.dkO, MainProcessIPCService.class);
                dVar.a(ToolsProcessIPCService.dkO, ToolsProcessIPCService.class);
                dVar.a(ToolsMpProcessIPCService.dkO, ToolsMpProcessIPCService.class);
                dVar.a(SupportProcessIPCService.dkO, SupportProcessIPCService.class);
                dVar.a(Appbrand0IPCService.dkO, Appbrand0IPCService.class);
                dVar.a(Appbrand1IPCService.dkO, Appbrand1IPCService.class);
                dVar.a(Appbrand2IPCService.dkO, Appbrand2IPCService.class);
                dVar.a(Appbrand3IPCService.dkO, Appbrand3IPCService.class);
                dVar.a(Appbrand4IPCService.dkO, Appbrand4IPCService.class);
                LiteAppIPCService.a aVar = LiteAppIPCService.hnQ;
                dVar.a(LiteAppIPCService.dkO, LiteAppIPCService.class);
                AppMethodBeat.o(146418);
            }
        };
        Assert.assertNotNull(application);
        com.tencent.mm.ipcinvoker.g.sContext = application;
        i.AnonymousClass1 r3 = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a8: CONSTRUCTOR  (r3v1 'r3' com.tencent.mm.ipcinvoker.i$1) = (r0v5 'application' android.app.Application) call: com.tencent.mm.ipcinvoker.i.1.<init>(android.app.Application):void type: CONSTRUCTOR in method: com.tencent.mm.ipcinvoker.wx_extension.PluginIPC.execute(com.tencent.mm.kernel.b.g):void, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ipcinvoker.i, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            */
        /*
        // Method dump skipped, instructions count: 233
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ipcinvoker.wx_extension.PluginIPC.execute(com.tencent.mm.kernel.b.g):void");
    }

    @Override // com.tencent.mm.app.o
    public void onAppForeground(String str) {
    }

    @Override // com.tencent.mm.app.o
    public void onAppBackground(String str) {
        AppMethodBeat.i(146423);
        if (MMApplicationContext.isMainProcess()) {
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.ipcinvoker.wx_extension.PluginIPC.AnonymousClass2 */

                public final void run() {
                    boolean z = true;
                    AppMethodBeat.i(146419);
                    try {
                        if (com.tencent.mm.kernel.g.aAh().azQ().a(ar.a.USERINFO_IPC_EXT_MM_PROTOBUF_TRANSFER_MMKV_LARGE_FILE_CLEAR_CHECK_TIMESTAMP_LONG, 0) + PluginIPC.hnK <= Util.nowMilliSecond()) {
                            try {
                                if (c.VQ().totalSize() < 20971520) {
                                    z = false;
                                }
                                Log.i("MicroMsg.PluginIPC", "do check MMProtoBuf mmkv file too large, needClear[%b]", Boolean.valueOf(z));
                                if (z) {
                                    c.VQ().clearAll();
                                }
                            } catch (Throwable th) {
                                Log.e("MicroMsg.PluginIPC", "do check MMProtoBuf mmkv file too large, exception = %s", th);
                            } finally {
                                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_IPC_EXT_MM_PROTOBUF_TRANSFER_MMKV_LARGE_FILE_CLEAR_CHECK_TIMESTAMP_LONG, Long.valueOf(Util.nowMilliSecond()));
                                AppMethodBeat.o(146419);
                            }
                        } else {
                            AppMethodBeat.o(146419);
                        }
                    } catch (Throwable th2) {
                        AppMethodBeat.o(146419);
                    }
                }
            });
        }
        AppMethodBeat.o(146423);
    }

    static final class a implements com.tencent.mm.ipcinvoker.h.a.a {
        static final com.tencent.mm.ipcinvoker.h.a.a hnD = new a();

        private a() {
        }

        static {
            AppMethodBeat.i(146421);
            AppMethodBeat.o(146421);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ipcinvoker.h.a.a
        public final void printLog(int i2, String str, String str2, Object... objArr) {
            AppMethodBeat.i(146420);
            switch (i2) {
                case 2:
                    Log.v(str, str2, objArr);
                    AppMethodBeat.o(146420);
                    return;
                case 3:
                    Log.d(str, str2, objArr);
                    AppMethodBeat.o(146420);
                    return;
                case 4:
                    Log.i(str, str2, objArr);
                    AppMethodBeat.o(146420);
                    return;
                case 5:
                    Log.w(str, str2, objArr);
                    AppMethodBeat.o(146420);
                    return;
                case 6:
                    Log.e(str, str2, objArr);
                    AppMethodBeat.o(146420);
                    return;
                case 7:
                    Log.e(str, str2, objArr);
                    break;
            }
            AppMethodBeat.o(146420);
        }
    }
}
