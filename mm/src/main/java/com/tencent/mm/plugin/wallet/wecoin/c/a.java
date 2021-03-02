package com.tencent.mm.plugin.wallet.wecoin.c;

import android.arch.lifecycle.MutableLiveData;
import android.os.Looper;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.wecoin.c.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\u0002¢\u0006\u0002\u0010\u0006\u001a+\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0006¨\u0006\b"}, hxF = {"postSetValue", "", "T", "mld", "Landroid/arch/lifecycle/MutableLiveData;", "d", "(Landroid/arch/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "setValue", "plugin-wxpay_release"})
public final class a {
    public static final <T> void a(MutableLiveData<T> mutableLiveData, T t) {
        AppMethodBeat.i(212914);
        if (mutableLiveData == null) {
            AppMethodBeat.o(212914);
            return;
        }
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        p.g(mainLooper, "Looper.getMainLooper()");
        if (currentThread == mainLooper.getThread()) {
            mutableLiveData.setValue(t);
            AppMethodBeat.o(212914);
            return;
        }
        b(mutableLiveData, t);
        AppMethodBeat.o(212914);
    }

    private static final <T> void b(MutableLiveData<T> mutableLiveData, T t) {
        AppMethodBeat.i(212915);
        i iVar = h.RTc;
        b.a aVar = b.HPp;
        iVar.aV(b.a.c(mutableLiveData, t));
        AppMethodBeat.o(212915);
    }
}
