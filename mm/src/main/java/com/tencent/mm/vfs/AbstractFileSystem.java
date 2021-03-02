package com.tencent.mm.vfs;

import com.tencent.mm.vfs.n;
import java.util.HashMap;

public abstract class AbstractFileSystem implements FileSystem {
    private volatile n RaS = n.Rdw;

    /* access modifiers changed from: protected */
    public final void l(int i2, Object... objArr) {
        HashMap hashMap;
        if (objArr.length == 0) {
            hashMap = null;
        } else {
            HashMap hashMap2 = new HashMap(objArr.length / 2);
            int i3 = 0;
            while (i3 < objArr.length - 1) {
                int i4 = i3 + 1;
                Object obj = objArr[i3];
                if (i4 >= objArr.length) {
                    break;
                }
                i3 = i4 + 1;
                hashMap2.put(obj.toString(), objArr[i4]);
            }
            hashMap = hashMap2;
        }
        n nVar = this.RaS;
        if (nVar.Rdv != null) {
            nVar.Rdv.a(nVar.gIx, nVar.Rdu, i2, hashMap);
        }
    }

    public final void a(String str, n.a aVar) {
        if (aVar == null) {
            this.RaS = n.Rdw;
        } else {
            this.RaS = new n(this, str, aVar);
        }
    }

    public int describeContents() {
        return 0;
    }
}
