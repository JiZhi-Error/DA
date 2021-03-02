package com.tencent.mm.plugin.appbrand.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    public String dGP;
    public String host;
    public String ljO;
    public String ljP;
    public String ljQ;
    public String ljR;
    public String ljS;
    public ArrayList<f> ljT = new ArrayList<>();
    public ArrayList<Object> ljU = new ArrayList<>();
    public int major;
    public int minor;
    public int port;
    public String uuid;

    public b() {
        AppMethodBeat.i(158911);
        AppMethodBeat.o(158911);
    }

    public final String toString() {
        AppMethodBeat.i(158912);
        StringBuilder sb = new StringBuilder();
        Iterator<f> it = this.ljT.iterator();
        while (it.hasNext()) {
            sb.append("[");
            sb.append(it.next().toString());
            sb.append("]\n");
        }
        String str = "host=" + this.host + "\nport=" + this.port + "\nmajor=" + this.major + "\nminor=" + this.minor + "\ndeviceType=" + this.dGP + "\nfriendlyName=" + this.ljP + "\nmanufacturer=" + this.ljQ + "\nmodeName=" + this.ljR + "\nserviceCount=" + this.ljT.size() + "\nserviceList=\n" + sb.toString();
        AppMethodBeat.o(158912);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(158913);
        if (obj == this) {
            AppMethodBeat.o(158913);
            return true;
        } else if (obj instanceof b) {
            b bVar = (b) obj;
            if (!this.host.equals(bVar.host) || this.port != bVar.port || !this.ljS.equals(bVar.ljS)) {
                AppMethodBeat.o(158913);
                return false;
            }
            AppMethodBeat.o(158913);
            return true;
        } else {
            AppMethodBeat.o(158913);
            return false;
        }
    }
}
