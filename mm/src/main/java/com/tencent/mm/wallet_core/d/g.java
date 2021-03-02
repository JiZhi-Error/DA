package com.tencent.mm.wallet_core.d;

import android.content.Intent;
import com.tencent.mm.ak.q;
import com.tencent.mm.ui.MMActivity;

public abstract class g {
    public i Ruz;
    public MMActivity activity;

    public abstract boolean onSceneEnd(int i2, int i3, String str, q qVar);

    public abstract boolean r(Object... objArr);

    public g(MMActivity mMActivity, i iVar) {
        this.activity = mMActivity;
        this.Ruz = iVar;
    }

    public CharSequence getTips(int i2) {
        return null;
    }

    public boolean A(Object... objArr) {
        return false;
    }

    public boolean B(Object... objArr) {
        return false;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }
}
