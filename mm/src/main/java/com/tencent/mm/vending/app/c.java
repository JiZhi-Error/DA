package com.tencent.mm.vending.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.d.a;
import com.tencent.mm.vending.e.b;
import junit.framework.Assert;

public final class c implements b {
    private b QZe = b.hdp();
    private a QZf;
    private com.tencent.mm.vending.c.b<? extends a> QZg;
    private int QZh = 0;
    private com.tencent.mm.vending.e.c rfv = new com.tencent.mm.vending.e.c();

    public c() {
        AppMethodBeat.i(74876);
        AppMethodBeat.o(74876);
    }

    private synchronized <T extends com.tencent.mm.vending.c.b<? extends a>> T bm(Class<? extends com.tencent.mm.vending.c.b<? extends a>> cls) {
        T t;
        AppMethodBeat.i(74877);
        if (this.QZg == null) {
            try {
                this.QZg = (com.tencent.mm.vending.c.b) cls.newInstance();
                if (this.QZf == null) {
                    this.QZf = (a) this.QZg.bmc();
                }
                hdq();
                t = (T) this.QZg;
                AppMethodBeat.o(74877);
            } catch (IllegalAccessException | InstantiationException e2) {
                InternalError internalError = new InternalError("Could not create interactor api instance : " + cls.toString());
                AppMethodBeat.o(74877);
                throw internalError;
            }
        } else if (!cls.isInstance(this.QZg)) {
            IllegalAccessError illegalAccessError = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
            AppMethodBeat.o(74877);
            throw illegalAccessError;
        } else {
            t = (T) this.QZg;
            AppMethodBeat.o(74877);
        }
        return t;
    }

    private synchronized <T extends a> T bn(Class<? extends a> cls) {
        T t;
        AppMethodBeat.i(74878);
        if (this.QZg != null) {
            t = (T) ((a) this.QZg.bmc());
            AppMethodBeat.o(74878);
        } else if (this.QZf == null) {
            try {
                this.QZf = (a) cls.newInstance();
                hdq();
                t = (T) this.QZf;
                AppMethodBeat.o(74878);
            } catch (IllegalAccessException | InstantiationException e2) {
                InternalError internalError = new InternalError("Could not create interactor instance : " + cls.toString());
                AppMethodBeat.o(74878);
                throw internalError;
            }
        } else if (!cls.isInstance(this.QZf)) {
            IllegalAccessError illegalAccessError = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
            AppMethodBeat.o(74878);
            throw illegalAccessError;
        } else {
            t = (T) this.QZf;
            AppMethodBeat.o(74878);
        }
        return t;
    }

    private void hdq() {
        AppMethodBeat.i(177468);
        if (this.QZe != null) {
            this.QZe.a(this, this.QZf);
        }
        AppMethodBeat.o(177468);
    }

    private synchronized void z(Intent intent, Context context) {
        AppMethodBeat.i(177469);
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.QZf);
        this.QZf.mContext = context;
        this.QZf.QYU = new a(intent);
        AppMethodBeat.o(177469);
    }

    public final synchronized a aBf() {
        a aVar;
        AppMethodBeat.i(74881);
        if (this.QZf == null && this.QZe != null) {
            this.QZf = this.QZe.QZa.get(this);
        }
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.QZf);
        aVar = this.QZf;
        AppMethodBeat.o(74881);
        return aVar;
    }

    public final <T extends com.tencent.mm.vending.c.b<? extends a>> T a(Activity activity, Class<? extends com.tencent.mm.vending.c.b<? extends a>> cls) {
        AppMethodBeat.i(74882);
        if (activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed())) {
            com.tencent.mm.vending.f.a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", activity);
            AppMethodBeat.o(74882);
            return null;
        }
        T t = (T) bm(cls);
        AppMethodBeat.o(74882);
        return t;
    }

    public final <T extends a> T b(Activity activity, Class<? extends a> cls) {
        AppMethodBeat.i(74883);
        if (activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed())) {
            com.tencent.mm.vending.f.a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", activity);
            AppMethodBeat.o(74883);
            return null;
        }
        T t = (T) bn(cls);
        AppMethodBeat.o(74883);
        return t;
    }

    public final void apB(int i2) {
        AppMethodBeat.i(177470);
        this.QZh = i2;
        b bVar = this.QZe;
        a aVar = bVar.QZa.get(this);
        if (aVar != null) {
            switch (i2) {
                case 1:
                    com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "onCreate interactor %s presenter %s %s %s", aVar, this, Integer.valueOf(hashCode()), Looper.myLooper());
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                    com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "onDestroy interactor %s activity %s %s %s", aVar, this, Integer.valueOf(hashCode()), Looper.myLooper());
                    bVar.QZa.remove(this);
                    break;
                default:
                    com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "Unknow phase %s, interactor %s activity %s %s %s", Integer.valueOf(i2), aVar, this, Integer.valueOf(hashCode()), Looper.myLooper());
                    AppMethodBeat.o(177470);
                    return;
            }
            bVar.QZc.sendMessage(bVar.QZc.obtainMessage(i2, aVar));
        }
        bVar.QZb.put(hashCode(), i2);
        AppMethodBeat.o(177470);
    }

    public final void A(Intent intent, Context context) {
        AppMethodBeat.i(74885);
        z(intent, context);
        apB(1);
        AppMethodBeat.o(74885);
    }

    @Override // com.tencent.mm.vending.e.b
    public final void keep(com.tencent.mm.vending.e.a aVar) {
        AppMethodBeat.i(74886);
        Assert.assertTrue("target must be a ILifeCycle", aVar instanceof com.tencent.mm.vending.e.a);
        this.rfv.keep(aVar);
        AppMethodBeat.o(74886);
    }

    public final void onDestroy() {
        AppMethodBeat.i(74887);
        this.rfv.dead();
        apB(4);
        AppMethodBeat.o(74887);
    }
}
