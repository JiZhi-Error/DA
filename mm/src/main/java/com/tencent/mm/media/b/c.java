package com.tencent.mm.media.b;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\r\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006J\r\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0004J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0012H\u0014J\r\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0016R\u001c\u0010\u0004\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/media/config/SimpleElementConfig;", "T", "", "()V", "elementConfig", "getElementConfig", "()Ljava/lang/Object;", "setElementConfig", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getConfig", "getConfigByStatus", "getFloatDynamicConfig", "", "key", "", "defValue", "getIntDynamicConfig", "", "initDefaultConfig", "loadConfig", "", "loadConfigByStatus", "resetConfig", "update", "parse", "plugin-mediaeditor_release"})
public abstract class c<T> {
    protected T idA;

    public abstract T aLR();

    public abstract void aLS();

    /* access modifiers changed from: protected */
    public final T aLQ() {
        T t = this.idA;
        if (t == null) {
            p.btv("elementConfig");
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public final void bS(T t) {
        p.h(t, "<set-?>");
        this.idA = t;
    }

    public void cav() {
    }

    /* access modifiers changed from: protected */
    public int ab(String str, int i2) {
        p.h(str, "key");
        if (!MMApplicationContext.isMMProcess()) {
            return Util.getInt(CaptureMMProxy.getInstance().getDynamicConfig(str), i2);
        }
        a af = g.af(com.tencent.mm.plugin.zero.b.a.class);
        p.g(af, "MMKernel.service<IConfig…onfigService::class.java)");
        return Util.getInt(((com.tencent.mm.plugin.zero.b.a) af).aqJ().getValue(str), i2);
    }

    public final T aLT() {
        this.idA = aLR();
        aLS();
        T t = this.idA;
        if (t == null) {
            p.btv("elementConfig");
        }
        return t;
    }

    public final T caF() {
        this.idA = aLR();
        cav();
        T t = this.idA;
        if (t == null) {
            p.btv("elementConfig");
        }
        return t;
    }
}
