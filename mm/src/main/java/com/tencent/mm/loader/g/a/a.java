package com.tencent.mm.loader.g.a;

import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u00060\fR\u00020\u00000\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;", "Lcom/tencent/mm/loader/loader/cfg/ILoaderRetryStrategy;", "()V", "retryCount", "", "(I)V", "retryTime", "(II)V", "MAX_URL_SIZE", "mRetryMap", "Lcom/tencent/mm/loader/model/MMLRUMap;", "", "Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "canRetry", "", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "RecentDownInfo", "libimageloader_release"})
public final class a implements c {
    private final d<String, C0404a> ial;
    private final int ibE;
    private final int ibF;
    private final int retryCount;

    public a(int i2) {
        this.retryCount = i2;
        this.ibF = Integer.MAX_VALUE;
        this.ibE = 100;
        this.ial = new d<>(this.ibE);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg$RecentDownInfo;", "", "lastTime", "", "tryCount", "", "(Lcom/tencent/mm/loader/loader/cfg/DefaultRetrySg;JI)V", "getLastTime", "()J", "setLastTime", "(J)V", "getTryCount", "()I", "setTryCount", "(I)V", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.g.a.a$a  reason: collision with other inner class name */
    public final class C0404a {
        long hwQ;
        int ibG;

        public C0404a(long j2, int i2) {
            this.hwQ = j2;
            this.ibG = i2;
        }
    }

    public a() {
        this(5);
    }

    public a(byte b2) {
        this(Integer.MAX_VALUE);
    }

    @Override // com.tencent.mm.loader.g.a.c
    public final boolean a(c cVar) {
        p.h(cVar, "task");
        if (this.ial.check(cVar.auK())) {
            long nowSecond = Util.nowSecond();
            C0404a aT = this.ial.aT(cVar.auK());
            if (aT.ibG < this.retryCount || nowSecond - aT.hwQ >= ((long) this.ibF)) {
                if (nowSecond - aT.hwQ > ((long) this.ibF)) {
                    Log.v("DefaultRetrySg", "reset: " + cVar.auK());
                    aT = new C0404a(nowSecond, 0);
                }
                aT.ibG++;
                aT.hwQ = nowSecond;
                this.ial.put(cVar.auK(), aT);
            } else {
                Log.w("DefaultRetrySg", "check block by recentdown: " + cVar.auK() + " count " + aT.ibG + "  time: " + (nowSecond - aT.hwQ));
                return false;
            }
        } else {
            this.ial.put(cVar.auK(), new C0404a(Util.nowSecond(), 1));
        }
        return true;
    }
}
