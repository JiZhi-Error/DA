package com.tencent.mm.plugin.sns.ui.a.b;

import android.content.Context;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;

public abstract class b extends com.tencent.mm.vending.a.b<bl, SnsInfo> {
    public abstract String JV(long j2);

    public abstract String L(long j2, String str);

    public abstract void a(Context context, bk bkVar, String str);

    public abstract void aRi(String str);

    public abstract void aRj(String str);

    public abstract void aRk(String str);

    public abstract void aRl(String str);

    public abstract void aRm(String str);

    public abstract void axJ();

    public abstract void fiE();

    public abstract String fkd();

    public abstract String fke();

    public abstract String fkf();

    public abstract String fkg();

    public abstract String fkh();

    public abstract void vD(boolean z);

    public b(SnsInfo snsInfo) {
        super(snsInfo);
    }
}
