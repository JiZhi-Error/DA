package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mm.ui.base.q;

public abstract class a {
    protected boolean NDL = true;
    protected com.tencent.mm.roomsdk.a.b.a NDM;
    protected com.tencent.mm.roomsdk.a.b.a NDN;
    protected com.tencent.mm.roomsdk.a.b.a NDO;
    protected q tipDialog;

    public abstract void a(Context context, String str, String str2, boolean z, boolean z2, DialogInterface.OnCancelListener onCancelListener);

    public abstract void aJu();

    public abstract void cancel();

    public final boolean gvP() {
        return this.NDL;
    }

    public static b Aw(boolean z) {
        return new b(z);
    }

    public static c Ax(boolean z) {
        return new c(z);
    }

    public final a b(com.tencent.mm.roomsdk.a.b.a aVar) {
        this.NDM = aVar;
        return this;
    }

    public final a c(com.tencent.mm.roomsdk.a.b.a aVar) {
        this.NDN = aVar;
        return this;
    }

    public final a d(com.tencent.mm.roomsdk.a.b.a aVar) {
        this.NDO = aVar;
        return this;
    }
}
