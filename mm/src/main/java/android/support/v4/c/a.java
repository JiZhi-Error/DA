package android.support.v4.c;

import android.support.v4.e.m;
import android.util.Base64;
import java.util.List;

public final class a {
    final String Nt;
    final String Nu;
    final String Nv;
    final List<List<byte[]>> Nw;
    final int Nx = 0;
    final String Ny = (this.Nt + "-" + this.Nu + "-" + this.Nv);

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.Nt = (String) m.checkNotNull(str);
        this.Nu = (String) m.checkNotNull(str2);
        this.Nv = (String) m.checkNotNull(str3);
        this.Nw = (List) m.checkNotNull(list);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.Nt + ", mProviderPackage: " + this.Nu + ", mQuery: " + this.Nv + ", mCertificates:");
        for (int i2 = 0; i2 < this.Nw.size(); i2++) {
            sb.append(" [");
            List<byte[]> list = this.Nw.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.Nx);
        return sb.toString();
    }
}
