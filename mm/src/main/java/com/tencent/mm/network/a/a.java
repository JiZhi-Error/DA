package com.tencent.mm.network.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;

public interface a {

    /* renamed from: com.tencent.mm.network.a.a$a  reason: collision with other inner class name */
    public static class C0484a {
        public long beginTime = 0;
        public long cCv = 0;
        public String clientIp = "";
        public long count = 0;
        public long endTime = 0;
        public int errCode = 0;
        public int errType = 0;
        public long expand1 = 0;
        public long expand2 = 0;
        public c jGm;
        public boolean jGn = false;
        public long jGo = 0;
        public long jGp = 0;
        public int jGq = 0;
        public int jGr = 0;
        public long jGs = 0;
        public long jGt = 0;
        public long jGu = 0;
        public long netSignal = 0;
        public int netType = 0;
        public int retryCount = 0;
        public long rtType = 0;

        public final String toString() {
            AppMethodBeat.i(132962);
            Object[] objArr = new Object[13];
            objArr[0] = Long.valueOf(this.rtType);
            objArr[1] = Long.valueOf(this.beginTime);
            objArr[2] = Long.valueOf(this.endTime);
            objArr[3] = Long.valueOf(this.endTime - this.beginTime);
            objArr[4] = Long.valueOf(this.cCv);
            objArr[5] = Long.valueOf(this.count);
            objArr[6] = this.jGm == null ? BuildConfig.COMMAND : this.jGm.toString();
            objArr[7] = Boolean.valueOf(this.jGn);
            objArr[8] = Integer.valueOf(this.netType);
            objArr[9] = Integer.valueOf(this.errType);
            objArr[10] = Integer.valueOf(this.errCode);
            objArr[11] = Long.valueOf(this.jGo);
            objArr[12] = Long.valueOf(this.jGp);
            String format = String.format("rtType:%d begin:%d, end:%d time:%d cost:%d count:%d ipInfo:%s socket:%b netType:%d err:(%d,%d) tx:%d rx:%d", objArr);
            AppMethodBeat.o(132962);
            return format;
        }
    }
}
