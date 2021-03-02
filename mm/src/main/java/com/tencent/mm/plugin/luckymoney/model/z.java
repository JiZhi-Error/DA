package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class z implements i, e {
    HashSet<q> ksO = new HashSet<>();
    HashSet<q> ksP = new HashSet<>();
    private Set<Integer> ktd = new HashSet();
    private Context mContext;
    private String mProcessName;
    com.tencent.mm.ui.base.q tipDialog = null;
    private f yWw = null;

    public z(Context context, f fVar) {
        AppMethodBeat.i(65230);
        this.mContext = context;
        this.yWw = fVar;
        AppMethodBeat.o(65230);
    }

    @Override // com.tencent.mm.wallet_core.d.e
    public final void b(q qVar, boolean z) {
        AppMethodBeat.i(65231);
        k(qVar);
        this.ksO.add(qVar);
        if (z && (this.tipDialog == null || (this.tipDialog != null && !this.tipDialog.isShowing()))) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            this.tipDialog = h.a(this.mContext, this.mContext.getString(R.string.ekc), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.luckymoney.model.z.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(65228);
                    z.this.forceCancel();
                    AppMethodBeat.o(65228);
                }
            });
        }
        g.aAi();
        g.aAg().hqi.a(qVar, 0);
        AppMethodBeat.o(65231);
    }

    public final void doSceneProgress(q qVar, boolean z) {
        AppMethodBeat.i(65232);
        Log.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(z)));
        k(qVar);
        this.ksP.add(qVar);
        if (z && (this.tipDialog == null || (this.tipDialog != null && !this.tipDialog.isShowing()))) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            this.tipDialog = h.a(this.mContext, 3, this.mContext.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.luckymoney.model.z.AnonymousClass2 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(65229);
                    if (z.this.tipDialog != null && z.this.ksO.isEmpty()) {
                        z.this.tipDialog.dismiss();
                        Iterator<q> it = z.this.ksP.iterator();
                        while (it.hasNext()) {
                            g.aAi();
                            g.aAg().hqi.a(it.next());
                        }
                        z.this.ksP.clear();
                    }
                    AppMethodBeat.o(65229);
                }
            });
        }
        g.aAi();
        g.aAg().hqi.a(qVar, 0);
        AppMethodBeat.o(65232);
    }

    public final void forceCancel() {
        AppMethodBeat.i(65233);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        Iterator<q> it = this.ksO.iterator();
        while (it.hasNext()) {
            g.aAi();
            g.aAg().hqi.a(it.next());
        }
        Iterator<q> it2 = this.ksP.iterator();
        while (it2.hasNext()) {
            g.aAi();
            g.aAg().hqi.a(it2.next());
        }
        this.ksO.clear();
        this.ksP.clear();
        AppMethodBeat.o(65233);
    }

    public final void addSceneEndListener(int i2) {
        AppMethodBeat.i(65234);
        this.ktd.add(Integer.valueOf(i2));
        g.aAi();
        g.aAg().hqi.a(i2, this);
        AppMethodBeat.o(65234);
    }

    public final void removeSceneEndListener(int i2) {
        AppMethodBeat.i(65235);
        g.aAi();
        g.aAg().hqi.b(i2, this);
        this.ktd.remove(Integer.valueOf(i2));
        if (this.ktd.isEmpty()) {
            forceCancel();
            this.yWw = null;
            this.mContext = null;
        }
        AppMethodBeat.o(65235);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(65236);
        if (this.ksP.contains(qVar)) {
            this.ksP.remove(qVar);
            Log.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
            z = true;
        } else if (this.ksO.contains(qVar)) {
            this.ksO.remove(qVar);
            Log.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
            z = true;
        } else {
            z = false;
        }
        if (!this.ksP.isEmpty() || !this.ksO.isEmpty()) {
            z2 = false;
        } else {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            z2 = true;
        }
        if (z && this.yWw != null) {
            this.yWw.onSceneEnd(i2, i3, str, qVar, z2);
        }
        AppMethodBeat.o(65236);
    }

    public final boolean isProcessing() {
        AppMethodBeat.i(65237);
        if (!this.ksP.isEmpty() || !this.ksO.isEmpty()) {
            AppMethodBeat.o(65237);
            return true;
        }
        AppMethodBeat.o(65237);
        return false;
    }

    private void k(q qVar) {
        AppMethodBeat.i(65238);
        if (qVar != null && (qVar instanceof w)) {
            ((w) qVar).setProcessName(this.mProcessName);
        }
        AppMethodBeat.o(65238);
    }

    @Override // com.tencent.mm.wallet_core.d.e
    public final void efi() {
        AppMethodBeat.i(65239);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(65239);
    }
}
