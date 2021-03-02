package com.tencent.mm.plugin.wallet.wecoin.c;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \n*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\nB\u001f\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0016R\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable;", "T", "Ljava/lang/Runnable;", "liveData", "Landroid/arch/lifecycle/MutableLiveData;", "data", "(Landroid/arch/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "Ljava/lang/Object;", "run", "", "Companion", "plugin-wxpay_release"})
final class b<T> implements Runnable {
    public static final a HPp = new a((byte) 0);
    private final MutableLiveData<T> CAn;
    private final T data;

    static {
        AppMethodBeat.i(212918);
        AppMethodBeat.o(212918);
    }

    private b(MutableLiveData<T> mutableLiveData, T t) {
        this.CAn = mutableLiveData;
        this.data = t;
    }

    public /* synthetic */ b(MutableLiveData mutableLiveData, Object obj, byte b2) {
        this(mutableLiveData, obj);
    }

    public final void run() {
        AppMethodBeat.i(212917);
        this.CAn.setValue(this.data);
        AppMethodBeat.o(212917);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\b\u0010\b\u001a\u0004\u0018\u0001H\u0005¢\u0006\u0002\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable;", "T", "liveData", "Landroid/arch/lifecycle/MutableLiveData;", "data", "(Landroid/arch/lifecycle/MutableLiveData;Ljava/lang/Object;)Lcom/tencent/mm/plugin/wallet/wecoin/utils/SetValueRunnable;", "plugin-wxpay_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static <T> b<T> c(MutableLiveData<T> mutableLiveData, T t) {
            AppMethodBeat.i(212916);
            p.h(mutableLiveData, "liveData");
            b<T> bVar = new b<>(mutableLiveData, t, (byte) 0);
            AppMethodBeat.o(212916);
            return bVar;
        }
    }
}
