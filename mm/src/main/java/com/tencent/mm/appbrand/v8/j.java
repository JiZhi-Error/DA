package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.SharedV8ArrayBuffer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class j implements d {
    private final AtomicInteger dpF = new AtomicInteger(0);
    private final Map<Integer, a> dpG = new HashMap();
    private final m dpH;

    public j(m mVar) {
        AppMethodBeat.i(144037);
        this.dpH = mVar;
        AppMethodBeat.o(144037);
    }

    @Override // com.tencent.mm.appbrand.v8.d
    public final int iQ(int i2) {
        AppMethodBeat.i(144038);
        int addAndGet = this.dpF.addAndGet(1);
        this.dpG.put(Integer.valueOf(addAndGet), new a(i2, this.dpH));
        Log.i("MicroMsg.SharedV8ArrayBufferMgr", "create capacity:%d, id:%d", Integer.valueOf(i2), Integer.valueOf(addAndGet));
        AppMethodBeat.o(144038);
        return addAndGet;
    }

    @Override // com.tencent.mm.appbrand.v8.d
    public final SharedV8ArrayBuffer iR(int i2) {
        AppMethodBeat.i(144039);
        if (!this.dpG.containsKey(Integer.valueOf(i2))) {
            Log.w("MicroMsg.SharedV8ArrayBufferMgr", "get: id %d not exist", Integer.valueOf(i2));
            AppMethodBeat.o(144039);
            return null;
        }
        a aVar = this.dpG.get(Integer.valueOf(i2));
        if (aVar.dpK == null) {
            aVar.dpK = aVar.dpH.XJ().newSharedV8ArrayBuffer(aVar.dpJ);
        }
        SharedV8ArrayBuffer sharedV8ArrayBuffer = aVar.dpK;
        AppMethodBeat.o(144039);
        return sharedV8ArrayBuffer;
    }

    @Override // com.tencent.mm.appbrand.v8.d
    public final ByteBuffer iS(int i2) {
        AppMethodBeat.i(144040);
        if (!this.dpG.containsKey(Integer.valueOf(i2))) {
            Log.w("MicroMsg.SharedV8ArrayBufferMgr", "getBackingStore: id %d not exist", Integer.valueOf(i2));
            AppMethodBeat.o(144040);
            return null;
        }
        ByteBuffer byteBuffer = this.dpG.get(Integer.valueOf(i2)).dpJ;
        AppMethodBeat.o(144040);
        return byteBuffer;
    }

    @Override // com.tencent.mm.appbrand.v8.d
    public final void destroy(int i2) {
        AppMethodBeat.i(144041);
        if (!this.dpG.containsKey(Integer.valueOf(i2))) {
            Log.w("MicroMsg.SharedV8ArrayBufferMgr", "destroy: id %d not exist", Integer.valueOf(i2));
            AppMethodBeat.o(144041);
            return;
        }
        Log.i("MicroMsg.SharedV8ArrayBufferMgr", "destroy id:%d", Integer.valueOf(i2));
        a aVar = this.dpG.get(Integer.valueOf(i2));
        aVar.dpH.dpQ.r(new Runnable() {
            /* class com.tencent.mm.appbrand.v8.j.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(144035);
                Log.i("MicroMsg.SharedV8ArrayBufferMgr", "SharedBuffer do release");
                if (a.this.dpK == null) {
                    Log.i("MicroMsg.SharedV8ArrayBufferMgr", "SharedBuffer do release mV8Buffer null");
                    AppMethodBeat.o(144035);
                    return;
                }
                a.this.dpK.manualRelease();
                AppMethodBeat.o(144035);
            }
        });
        this.dpG.remove(Integer.valueOf(i2));
        AppMethodBeat.o(144041);
    }

    static final class a {
        final m dpH;
        private final int dpI;
        ByteBuffer dpJ = ByteBuffer.allocateDirect(this.dpI);
        SharedV8ArrayBuffer dpK = null;

        a(int i2, m mVar) {
            AppMethodBeat.i(144036);
            this.dpH = mVar;
            this.dpI = i2;
            AppMethodBeat.o(144036);
        }
    }
}
