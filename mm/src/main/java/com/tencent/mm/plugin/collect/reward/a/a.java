package com.tencent.mm.plugin.collect.reward.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public abstract class a extends q implements m {
    protected int errCode = 0;
    protected String errMsg;
    protected int errType = 0;
    protected WeakReference<Activity> lAM;
    protected boolean qxx = false;
    protected boolean qxy = false;

    /* renamed from: com.tencent.mm.plugin.collect.reward.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0930a {
        void g(q qVar);
    }

    /* access modifiers changed from: protected */
    public abstract void b(int i2, int i3, String str, s sVar);

    /* access modifiers changed from: protected */
    public boolean czP() {
        return true;
    }

    public final void M(Activity activity) {
        this.lAM = new WeakReference<>(activity);
    }

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        Activity activity;
        if (!(i3 == 0 && i4 == 0)) {
            this.qxx = true;
            if (!(!czP() || this.lAM == null || (activity = this.lAM.get()) == null)) {
                h.a((Context) activity, activity.getString(R.string.itf), (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.collect.reward.a.a.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
            }
        }
        this.errCode = i4;
        this.errType = i3;
        this.errMsg = str;
        b(i3, i4, str, sVar);
    }

    public final a a(AbstractC0930a aVar) {
        if (!this.qxx && !this.qxy) {
            aVar.g(this);
        }
        return this;
    }

    public final a b(AbstractC0930a aVar) {
        if (this.qxy) {
            aVar.g(this);
        }
        return this;
    }

    public final a c(AbstractC0930a aVar) {
        if (this.qxx) {
            aVar.g(this);
        }
        return this;
    }
}
