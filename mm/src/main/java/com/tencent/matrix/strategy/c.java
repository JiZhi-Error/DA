package com.tencent.matrix.strategy;

import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aj;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.protocal.protobuf.bho;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends q implements m {
    private static boolean isRunning = false;
    private static Object lock = new Object();
    private i callback;
    private bhn dah = new bhn();
    private a dai;
    private d rr;

    public interface a {
        void onStrategyResp(int i2, int i3, byte[] bArr);
    }

    public static boolean isRunning() {
        boolean z;
        synchronized (lock) {
            z = isRunning;
        }
        return z;
    }

    private static void setIsRunning(boolean z) {
        synchronized (lock) {
            isRunning = z;
        }
    }

    public c(byte[] bArr, final a aVar) {
        this.dai = aVar;
        setIsRunning(true);
        aj ajVar = new aj();
        try {
            ajVar.parseFrom(bArr);
            this.dah.LSc = ajVar;
        } catch (Exception e2) {
            Log.e("Matrix.NetSceneGetMatrixStrategy", "parse data error");
            g.aAi();
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.matrix.strategy.c.AnonymousClass1 */

                public final void run() {
                    aVar.onStrategyResp(3, -1, null);
                }
            });
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        try {
            if (g.aAg().hqi == null || g.aAg().hqi.iMw == null) {
                Log.f("Matrix.NetSceneGetMatrixStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
                this.callback.onSceneEnd(i3, i4, str, this);
            } else if (i3 != 0) {
                Log.e("Matrix.NetSceneGetMatrixStrategy", "get report strategy err, errType:" + i3 + ", errCode:" + i4);
                this.dai.onStrategyResp(i3, i4, null);
                this.callback.onSceneEnd(i3, i4, str, this);
                setIsRunning(false);
            } else {
                Log.d("Matrix.NetSceneGetMatrixStrategy", "get report strategy ok");
                try {
                    this.dai.onStrategyResp(0, 0, ((bho) this.rr.iLL.iLR).LSd.toByteArray());
                } catch (Exception e2) {
                    Log.e("Matrix.NetSceneGetMatrixStrategy", "failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), Util.stackTraceToString(e2));
                }
                this.callback.onSceneEnd(i3, i4, str, this);
                setIsRunning(false);
            }
        } finally {
            setIsRunning(false);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 914;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        int i2 = -1;
        this.callback = iVar;
        if (!((gVar == null || gVar.aZh() == null || !gVar.aZh().aZb()) ? false : true)) {
            Log.w("Matrix.NetSceneGetMatrixStrategy", "get mrs strategy must go after login");
        } else {
            d.a aVar = new d.a();
            aVar.iLQ = false;
            aVar.iLN = this.dah;
            aVar.iLO = new bho();
            aVar.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
            aVar.funcId = getType();
            this.rr = aVar.aXF();
            i2 = dispatch(gVar, this.rr, this);
            if (i2 < 0) {
                Log.i("Matrix.NetSceneGetMatrixStrategy", "mark all failed. do scene %d", Integer.valueOf(i2));
                try {
                    this.dai.onStrategyResp(3, -1, null);
                    setIsRunning(false);
                } catch (Exception e2) {
                    Log.e("Matrix.NetSceneGetMatrixStrategy", "onStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), Util.stackTraceToString(e2));
                }
            }
        }
        return i2;
    }
}
