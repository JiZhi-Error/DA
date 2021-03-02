package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import java.io.InputStream;
import java.util.List;

public interface q {
    WxaPkg UT(String str);

    InputStream UU(String str);

    a UV(String str);

    boolean UW(String str);

    List<String> bvA();

    void bvy();

    List<ModulePkgInfo> bvz();

    void close();

    public static class a {
        public int appVersion;
        public String fileName;
        public String kKF;
        public String kKG;
        public WxaPkg kKH;
        public String kKI;
        public int kKJ;
        public int kKK;

        public final WxaPkg.Info bvB() {
            AppMethodBeat.i(178519);
            WxaPkg.Info info = new WxaPkg.Info(this.kKI, this.fileName, this.kKJ, this.kKK);
            AppMethodBeat.o(178519);
            return info;
        }

        public final void a(a aVar) {
            this.kKF = aVar.kKF;
            this.appVersion = aVar.appVersion;
            this.kKG = aVar.kKG;
            this.kKH = aVar.kKH;
            this.kKI = aVar.kKI;
            this.fileName = aVar.fileName;
            this.kKJ = aVar.kKJ;
            this.kKK = aVar.kKK;
        }
    }
}
