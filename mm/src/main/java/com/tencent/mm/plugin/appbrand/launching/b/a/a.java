package com.tencent.mm.plugin.appbrand.launching.b.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.vending.g.e;
import java.io.IOException;
import java.util.List;

public interface a extends com.tencent.mm.kernel.c.a {
    e<List<C0735a>> a(String str, String str2, z zVar);

    void a(String str, android.arch.a.c.a<WxaAttributes, Void> aVar);

    void bO(List<Pair<C0735a, String>> list);

    void ek(String str, String str2);

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.b.a.a$a  reason: collision with other inner class name */
    public static class C0735a extends def {
        public String mYc;
        public String mYd;
        public long mYe;

        public final byte[] bNX() {
            AppMethodBeat.i(153225);
            byte[] byteArray = super.toByteArray();
            AppMethodBeat.o(153225);
            return byteArray;
        }

        public final void aO(byte[] bArr) {
            AppMethodBeat.i(153226);
            if (bArr == null || bArr.length == 0) {
                IOException iOException = new IOException("Invalid bytes");
                AppMethodBeat.o(153226);
                throw iOException;
            }
            super.parseFrom(bArr);
            AppMethodBeat.o(153226);
        }

        public final String toString() {
            AppMethodBeat.i(153227);
            String str = "PrefetchPkgDownloadInfo{packageMD5='" + this.mYc + '\'' + ", packageURL='" + this.mYd + '\'' + ", urlLifespan=" + this.mYe + ", appId='" + this.appId + '\'' + ", packageKey='" + this.MJn + '\'' + ", packageType=" + this.packageType + ", packageVersion=" + this.MJo + '}';
            AppMethodBeat.o(153227);
            return str;
        }
    }
}
