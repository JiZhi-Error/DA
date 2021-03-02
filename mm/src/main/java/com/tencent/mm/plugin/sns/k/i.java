package com.tencent.mm.plugin.sns.k;

import com.tencent.mm.modelsns.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Vector;

public abstract class i {
    private Vector<k> DVS = new Vector<>();

    public final k b(k kVar) {
        this.DVS.add(kVar);
        return kVar;
    }

    public final boolean c(k kVar) {
        boolean z;
        Iterator<k> it = this.DVS.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            k next = it.next();
            if (next.jlm == kVar.jlm) {
                this.DVS.remove(next);
                z = true;
                break;
            }
        }
        this.DVS.add(kVar);
        return z;
    }

    public final k dR(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Iterator<k> it = this.DVS.iterator();
            while (it.hasNext()) {
                k next = it.next();
                if (obj.equals(next.jlk)) {
                    this.DVS.remove(next);
                    return next;
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.Ss_log_base_helper", "report by key " + e2.getMessage() + " " + obj);
        }
        return null;
    }
}
