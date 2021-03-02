package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b implements i {
    HashSet<q> ksO = new HashSet<>();
    HashSet<q> ksP = new HashSet<>();
    private a ktc = null;
    private Set<Integer> ktd = new HashSet();
    private Context mContext;
    Dialog tipDialog = null;

    public b(Context context, a aVar) {
        AppMethodBeat.i(20820);
        this.mContext = context;
        this.ktc = aVar;
        AppMethodBeat.o(20820);
    }

    public final void doSceneProgress(q qVar, boolean z) {
        AppMethodBeat.i(231573);
        Log.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(z)));
        this.ksP.add(qVar);
        if (z && (this.tipDialog == null || (this.tipDialog != null && !this.tipDialog.isShowing()))) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            this.tipDialog = h.a(this.mContext, "", true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.address.c.b.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(20819);
                    if (b.this.tipDialog != null && b.this.ksO.isEmpty()) {
                        b.this.tipDialog.dismiss();
                        Iterator<q> it = b.this.ksP.iterator();
                        while (it.hasNext()) {
                            bg.azz().a(it.next());
                        }
                        b.this.ksP.clear();
                    }
                    AppMethodBeat.o(20819);
                }
            });
        }
        bg.azz().a(qVar, 0);
        AppMethodBeat.o(231573);
    }

    public final void addSceneEndListener(int i2) {
        AppMethodBeat.i(20822);
        this.ktd.add(Integer.valueOf(i2));
        bg.azz().a(i2, this);
        AppMethodBeat.o(20822);
    }

    public final void removeSceneEndListener(int i2) {
        AppMethodBeat.i(20823);
        bg.azz().b(i2, this);
        this.ktd.remove(Integer.valueOf(i2));
        if (this.ktd.isEmpty()) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            Iterator<q> it = this.ksO.iterator();
            while (it.hasNext()) {
                bg.azz().a(it.next());
            }
            Iterator<q> it2 = this.ksP.iterator();
            while (it2.hasNext()) {
                bg.azz().a(it2.next());
            }
            this.ksO.clear();
            this.ksP.clear();
            this.ktc = null;
            this.mContext = null;
        }
        AppMethodBeat.o(20823);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z = true;
        AppMethodBeat.i(20824);
        if (this.ksP.contains(qVar)) {
            this.ksP.remove(qVar);
            Log.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
        } else if (this.ksO.contains(qVar)) {
            this.ksO.remove(qVar);
            Log.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
        } else {
            z = false;
        }
        if (this.ksP.isEmpty() && this.ksO.isEmpty() && this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (z && this.ktc != null) {
            this.ktc.c(i2, i3, str, qVar);
        }
        AppMethodBeat.o(20824);
    }
}
