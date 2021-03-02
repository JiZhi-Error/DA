package com.tencent.mm.plugin.talkroom.component;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.talkroom.component.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.egm;
import com.tencent.mm.protocal.protobuf.euc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.smtt.sdk.TbsOnlineSDKExtensionEntry;
import java.io.IOException;

/* access modifiers changed from: package-private */
public class g extends a.AbstractBinderC1793a {
    private final v2engine FOY = new v2engine();
    private final MMHandler handler = new MMHandler(Looper.getMainLooper());

    static {
        AppMethodBeat.i(29417);
        g.class.getClassLoader();
        j.Ed("voipMain");
        AppMethodBeat.o(29417);
    }

    public g() {
        AppMethodBeat.i(29408);
        AppMethodBeat.o(29408);
    }

    @Override // com.tencent.mm.plugin.talkroom.component.a
    public final int uninitLive() {
        AppMethodBeat.i(29409);
        int intValue = ((Integer) new SyncTask<Integer>(Integer.valueOf((int) TbsOnlineSDKExtensionEntry.EXTENSION_INIT_FAILURE)) {
            /* class com.tencent.mm.plugin.talkroom.component.g.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Integer run() {
                AppMethodBeat.i(29399);
                Integer valueOf = Integer.valueOf(g.this.FOY.uninitLive());
                AppMethodBeat.o(29399);
                return valueOf;
            }
        }.exec(this.handler)).intValue();
        AppMethodBeat.o(29409);
        return intValue;
    }

    @Override // com.tencent.mm.plugin.talkroom.component.a
    public final int SetCurrentMicId(final int i2) {
        AppMethodBeat.i(29410);
        int intValue = ((Integer) new SyncTask<Integer>(Integer.valueOf((int) TbsOnlineSDKExtensionEntry.EXTENSION_INIT_FAILURE)) {
            /* class com.tencent.mm.plugin.talkroom.component.g.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Integer run() {
                AppMethodBeat.i(29400);
                Integer valueOf = Integer.valueOf(g.this.FOY.SetCurrentMicId(i2));
                AppMethodBeat.o(29400);
                return valueOf;
            }
        }.exec(this.handler)).intValue();
        AppMethodBeat.o(29410);
        return intValue;
    }

    @Override // com.tencent.mm.plugin.talkroom.component.a
    public final int Close() {
        AppMethodBeat.i(29411);
        int intValue = ((Integer) new SyncTask<Integer>(Integer.valueOf((int) TbsOnlineSDKExtensionEntry.EXTENSION_INIT_FAILURE)) {
            /* class com.tencent.mm.plugin.talkroom.component.g.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Integer run() {
                AppMethodBeat.i(29401);
                Integer valueOf = Integer.valueOf(g.this.FOY.Close());
                AppMethodBeat.o(29401);
                return valueOf;
            }
        }.exec(this.handler)).intValue();
        AppMethodBeat.o(29411);
        return intValue;
    }

    @Override // com.tencent.mm.plugin.talkroom.component.a
    public final int ftD() {
        AppMethodBeat.i(29412);
        int intValue = ((Integer) new SyncTask<Integer>(Integer.valueOf((int) TbsOnlineSDKExtensionEntry.EXTENSION_INIT_FAILURE)) {
            /* class com.tencent.mm.plugin.talkroom.component.g.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Integer run() {
                AppMethodBeat.i(29402);
                int aon = m.aon();
                Log.i("MicroMsg.TalkRoomEngineProxy", "initLive cpuFlag: %d", Integer.valueOf(aon));
                int initLive = g.this.FOY.initLive(aon, b.aKA() + "lib/");
                Log.i("MicroMsg.TalkRoomEngineProxy", "initLive %d ", Integer.valueOf(initLive));
                Integer valueOf = Integer.valueOf(initLive);
                AppMethodBeat.o(29402);
                return valueOf;
            }
        }.exec(this.handler)).intValue();
        AppMethodBeat.o(29412);
        return intValue;
    }

    @Override // com.tencent.mm.plugin.talkroom.component.a
    public final int a(final b bVar, final int i2, final int i3, final int i4, final long j2, int[] iArr, final int[] iArr2, final int i5, final String[] strArr) {
        AppMethodBeat.i(29413);
        short[] sArr = new short[iArr2.length];
        for (int i6 = 0; i6 < iArr2.length; i6++) {
            sArr[i6] = (short) iArr2[i6];
        }
        int intValue = ((Integer) new SyncTask<Integer>(Integer.valueOf((int) TbsOnlineSDKExtensionEntry.EXTENSION_INIT_FAILURE)) {
            /* class com.tencent.mm.plugin.talkroom.component.g.AnonymousClass5 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ Integer run() {
                AppMethodBeat.i(29404);
                Integer bjO = bjO();
                AppMethodBeat.o(29404);
                return bjO;
            }

            private Integer bjO() {
                AppMethodBeat.i(29403);
                try {
                    euc euc = new euc();
                    Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine svr cnt %d", Integer.valueOf(strArr.length));
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        egm egm = new egm();
                        egm.Ngz = strArr[i2];
                        if (egm.Ngz == null) {
                            Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine ip_str null skip");
                        } else {
                            egm.port = iArr2[i2];
                            euc.Nrw.add(egm);
                            Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine svr:[%s][%d] ", egm.Ngz, Integer.valueOf(egm.port));
                        }
                    }
                    Log.i("MicroMsg.TalkRoomEngineProxy", "Open Engine valid svr cnt %d", Integer.valueOf(euc.Nrw.size()));
                    Integer valueOf = Integer.valueOf(g.this.FOY.Open(bVar, i2, i3, i4, j2, i5, euc.toByteArray(), euc.toByteArray().length));
                    AppMethodBeat.o(29403);
                    return valueOf;
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.TalkRoomEngineProxy", e2, "engine.Open exception", new Object[0]);
                    AppMethodBeat.o(29403);
                    return -1;
                }
            }
        }.exec(this.handler)).intValue();
        AppMethodBeat.o(29413);
        return intValue;
    }

    @Override // com.tencent.mm.plugin.talkroom.component.a
    public final byte[] e(final int[] iArr, final String str) {
        AppMethodBeat.i(29414);
        byte[] bArr = (byte[]) new SyncTask<byte[]>() {
            /* class com.tencent.mm.plugin.talkroom.component.g.AnonymousClass6 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ byte[] run() {
                AppMethodBeat.i(29405);
                PByteArray pByteArray = new PByteArray();
                iArr[0] = g.this.FOY.GetStatis(pByteArray, str);
                byte[] bArr = pByteArray.value;
                AppMethodBeat.o(29405);
                return bArr;
            }
        }.exec(this.handler);
        AppMethodBeat.o(29414);
        return bArr;
    }

    @Override // com.tencent.mm.plugin.talkroom.component.a
    public final e a(final c cVar) {
        AppMethodBeat.i(29415);
        e eVar = (e) new SyncTask<e>() {
            /* class com.tencent.mm.plugin.talkroom.component.g.AnonymousClass7 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ e run() {
                AppMethodBeat.i(29406);
                h hVar = new h(g.this.FOY, cVar);
                AppMethodBeat.o(29406);
                return hVar;
            }
        }.exec(this.handler);
        AppMethodBeat.o(29415);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.talkroom.component.a
    public final d ftE() {
        AppMethodBeat.i(29416);
        d dVar = (d) new SyncTask<d>() {
            /* class com.tencent.mm.plugin.talkroom.component.g.AnonymousClass8 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ d run() {
                AppMethodBeat.i(29407);
                f fVar = new f(g.this.FOY);
                AppMethodBeat.o(29407);
                return fVar;
            }
        }.exec(this.handler);
        AppMethodBeat.o(29416);
        return dVar;
    }
}
