package com.tencent.mm.platformtools;

import android.app.Activity;
import com.tencent.mm.ak.i;
import java.util.HashSet;
import java.util.Set;

public abstract class c implements i {
    public Activity activity;
    Set<Integer> jMC = new HashSet();

    public abstract boolean b(ae aeVar);

    public abstract boolean c(ae aeVar);

    public abstract boolean d(ae aeVar);

    public abstract boolean e(ae aeVar);

    public abstract boolean f(ae aeVar);

    public c(Activity activity2) {
        this.activity = activity2;
    }

    public final boolean a(ae aeVar) {
        if (aeVar.action == 0) {
            return false;
        }
        switch (aeVar.action) {
            case 1:
                return b(aeVar);
            case 2:
                return c(aeVar);
            case 3:
            default:
                return false;
            case 4:
                return d(aeVar);
            case 5:
                return e(aeVar);
            case 6:
                return f(aeVar);
        }
    }
}
