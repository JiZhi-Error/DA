package com.tencent.mm.wallet_core.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.a;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class i implements com.tencent.mm.ak.i, e {
    private a RuB;
    private b RuC;
    public HashMap<Integer, c> RuD;
    public HashSet<q> ksO = new HashSet<>();
    public HashSet<q> ksP = new HashSet<>();
    private Set<Integer> ktd = new HashSet();
    public Bundle mBundle;
    public Context mContext;
    public String mProcessName;
    public Dialog tipDialog = null;
    private f yWw = null;

    public i(Context context, f fVar) {
        AppMethodBeat.i(72863);
        this.mContext = context;
        this.yWw = fVar;
        this.RuB = new a(this);
        this.RuC = new b(this);
        this.RuD = new HashMap<>();
        AppMethodBeat.o(72863);
    }

    @Override // com.tencent.mm.wallet_core.d.e
    public final void b(q qVar, boolean z) {
        AppMethodBeat.i(72864);
        s(qVar);
        this.ksO.add(qVar);
        if (z && (this.tipDialog == null || (this.tipDialog != null && !this.tipDialog.isShowing()))) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            if (this.mContext == null) {
                Log.w("MicroMsg.WalletNetSceneMgr", "%s activity has destroyed!!!", this);
                AppMethodBeat.o(72864);
                return;
            }
            this.tipDialog = h.a(this.mContext, false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.wallet_core.d.i.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(72855);
                    i.this.forceCancel();
                    AppMethodBeat.o(72855);
                }
            });
        }
        if (ac.jPC && (qVar instanceof m) && (((m) qVar).getUri().contains("authen") || ((m) qVar).getUri().contains("verify"))) {
            ((m) qVar).setFake();
        }
        g.aAi();
        g.aAg().hqi.a(qVar, 0);
        AppMethodBeat.o(72864);
    }

    public final void a(q qVar, boolean z, int i2) {
        AppMethodBeat.i(72865);
        a(qVar, z, i2, 0);
        AppMethodBeat.o(72865);
    }

    public final void a(q qVar, boolean z, int i2, int i3) {
        AppMethodBeat.i(72866);
        Object[] objArr = new Object[7];
        objArr[0] = this;
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = qVar;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(qVar.getType());
        objArr[5] = Boolean.valueOf(qVar instanceof j);
        objArr[6] = Boolean.valueOf(this.tipDialog == null || (this.tipDialog != null && !this.tipDialog.isShowing()));
        Log.i("MicroMsg.WalletNetSceneMgr", "this %s isShowProgress %s scene: %s dialogType %s type %s IWxSafePay %s tipDialog showing? %s", objArr);
        s(qVar);
        this.ksP.add(qVar);
        if (z && (this.tipDialog == null || (this.tipDialog != null && !this.tipDialog.isShowing()))) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            if (this.mContext == null) {
                Log.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                AppMethodBeat.o(72866);
                return;
            } else if (i2 == 1) {
                if (qVar instanceof j) {
                    this.tipDialog = h.a(this.mContext, false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.wallet_core.d.i.AnonymousClass2 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(72856);
                            if (i.this.tipDialog != null && i.this.ksO.isEmpty()) {
                                i.this.tipDialog.dismiss();
                                Iterator<q> it = i.this.ksP.iterator();
                                while (it.hasNext()) {
                                    g.aAi();
                                    g.aAg().hqi.a(it.next());
                                }
                                i.this.ksP.clear();
                            }
                            AppMethodBeat.o(72856);
                        }
                    });
                } else {
                    Context context = this.mContext;
                    this.mContext.getString(R.string.ty);
                    this.tipDialog = com.tencent.mm.ui.base.h.a(context, this.mContext.getString(R.string.inu), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.wallet_core.d.i.AnonymousClass3 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(72857);
                            if (i.this.tipDialog != null && i.this.ksO.isEmpty()) {
                                i.this.tipDialog.dismiss();
                                Iterator<q> it = i.this.ksP.iterator();
                                while (it.hasNext()) {
                                    g.aAi();
                                    g.aAg().hqi.a(it.next());
                                }
                                i.this.ksP.clear();
                            }
                            AppMethodBeat.o(72857);
                        }
                    });
                }
            } else if (i2 == 2) {
                Context context2 = this.mContext;
                this.mContext.getString(R.string.ty);
                this.tipDialog = com.tencent.mm.ui.base.h.a(context2, this.mContext.getString(R.string.inu), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.wallet_core.d.i.AnonymousClass4 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(72858);
                        if (i.this.tipDialog != null && i.this.ksO.isEmpty()) {
                            i.this.tipDialog.dismiss();
                            Iterator<q> it = i.this.ksP.iterator();
                            while (it.hasNext()) {
                                g.aAi();
                                g.aAg().hqi.a(it.next());
                            }
                            i.this.ksP.clear();
                        }
                        AppMethodBeat.o(72858);
                    }
                });
            } else if (i2 == 3) {
                this.tipDialog = h.a(this.mContext, "验证中", new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.wallet_core.d.i.AnonymousClass5 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(72859);
                        if (i.this.tipDialog != null && i.this.ksO.isEmpty()) {
                            i.this.tipDialog.dismiss();
                            Iterator<q> it = i.this.ksP.iterator();
                            while (it.hasNext()) {
                                g.aAi();
                                g.aAg().hqi.a(it.next());
                            }
                            i.this.ksP.clear();
                        }
                        AppMethodBeat.o(72859);
                    }
                });
            } else if (i2 == 4) {
                this.tipDialog = h.a(this.mContext, false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.wallet_core.d.i.AnonymousClass6 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(72860);
                        if (i.this.tipDialog != null && i.this.ksO.isEmpty()) {
                            i.this.tipDialog.dismiss();
                            Iterator<q> it = i.this.ksP.iterator();
                            while (it.hasNext()) {
                                g.aAi();
                                g.aAg().hqi.a(it.next());
                            }
                            i.this.ksP.clear();
                        }
                        AppMethodBeat.o(72860);
                    }
                });
            } else {
                Log.i("MicroMsg.WalletNetSceneMgr", "unknown dialog type: %d", Integer.valueOf(i2));
                Context context3 = this.mContext;
                this.mContext.getString(R.string.ty);
                this.tipDialog = com.tencent.mm.ui.base.h.a(context3, this.mContext.getString(R.string.inu), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.wallet_core.d.i.AnonymousClass7 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(72861);
                        if (i.this.tipDialog != null && i.this.ksO.isEmpty()) {
                            i.this.tipDialog.dismiss();
                            Iterator<q> it = i.this.ksP.iterator();
                            while (it.hasNext()) {
                                g.aAi();
                                g.aAg().hqi.a(it.next());
                            }
                            i.this.ksP.clear();
                        }
                        AppMethodBeat.o(72861);
                    }
                });
            }
        }
        if (ac.jPC && (qVar instanceof m) && (((m) qVar).getUri().contains("authen") || ((m) qVar).getUri().contains("verify"))) {
            ((m) qVar).setFake();
        }
        g.aAi();
        g.aAg().hqi.a(qVar, i3);
        Object[] objArr2 = new Object[3];
        objArr2[0] = this;
        objArr2[1] = qVar;
        objArr2[2] = qVar.getReqResp() == null ? "" : qVar.getReqResp().getUri();
        Log.i("MicroMsg.WalletNetSceneMgr", "this %s scene url %s %s", objArr2);
        AppMethodBeat.o(72866);
    }

    public final void forceCancel() {
        AppMethodBeat.i(72867);
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
        AppMethodBeat.o(72867);
    }

    public final void addSceneEndListener(int i2) {
        AppMethodBeat.i(72868);
        this.ktd.add(Integer.valueOf(i2));
        g.aAi();
        g.aAg().hqi.a(i2, this);
        AppMethodBeat.o(72868);
    }

    public final void removeSceneEndListener(int i2) {
        AppMethodBeat.i(72869);
        g.aAi();
        g.aAg().hqi.b(i2, this);
        this.ktd.remove(Integer.valueOf(i2));
        if (this.ktd.isEmpty()) {
            onDestroy();
        }
        AppMethodBeat.o(72869);
    }

    @Override // com.tencent.mm.wallet_core.d.e
    public final void efi() {
        AppMethodBeat.i(258762);
        closeTipDialog();
        AppMethodBeat.o(258762);
    }

    private boolean j(int i2, int i3, String str, q qVar) {
        boolean z;
        boolean z2;
        ITenpaySave.RetryPayInfo retryPayInfo;
        ITenpaySave.RetryPayInfo retryPayInfo2;
        AppMethodBeat.i(72871);
        Log.i("MicroMsg.WalletNetSceneMgr", "onSceneEnd scene is %s %s", this, qVar.toString());
        Log.d("MicroMsg.WalletNetSceneMgr", "tofutest: %s errType: %d, errCode: %d, errMsg: %s, %s", this, Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(ac.jPC));
        if (!ac.jPC || !(qVar instanceof n) || ((n) qVar).getHasRetried() || ((n) qVar).fOn()) {
            if (qVar instanceof ITenpaySave) {
                ITenpaySave iTenpaySave = (ITenpaySave) qVar;
                if ((iTenpaySave instanceof ITenpaySave) && (retryPayInfo2 = iTenpaySave.getRetryPayInfo()) != null && retryPayInfo2.exv()) {
                    b.retryPayInfo = retryPayInfo2;
                }
            }
            if (qVar instanceof n) {
                if (((n) qVar).getHasRetried()) {
                    Log.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass %s", qVar);
                    AppMethodBeat.o(72871);
                    return false;
                } else if (((n) qVar).fOn() && (qVar instanceof a)) {
                    boolean canPayRetry = ((n) qVar).canPayRetry();
                    boolean z3 = !((n) qVar).checkRecSrvResp();
                    Log.i("MicroMsg.WalletNetSceneMgr", "%s save or fetch shouldRetry, network: %B, server: %B", this, Boolean.valueOf(z3), Boolean.valueOf(canPayRetry));
                    if (canPayRetry || z3) {
                        a aVar = (a) qVar;
                        if ((aVar instanceof a) && (retryPayInfo = aVar.getRetryPayInfo()) != null && retryPayInfo.exv()) {
                            b.retryPayInfo = retryPayInfo;
                        }
                        if (this.RuC.c((n) qVar)) {
                            AppMethodBeat.o(72871);
                            return true;
                        }
                        AppMethodBeat.o(72871);
                        return false;
                    }
                    AppMethodBeat.o(72871);
                    return false;
                }
            }
            int type = qVar.getType();
            if (this.RuD != null) {
                c cVar = this.RuD.get(Integer.valueOf(type));
                if (qVar instanceof d) {
                    if (((d) qVar).getHasRetried()) {
                        AppMethodBeat.o(72871);
                        return false;
                    }
                    T t = (T) ((d) qVar);
                    Log.i("MicroMsg.IDelayQueryOrder", "startQueryOrder %s ", t);
                    cVar.Ruy = t;
                    if (cVar.a(i2, i3, t)) {
                        AppMethodBeat.o(72871);
                        return true;
                    }
                }
            }
            if (!(qVar instanceof n)) {
                AppMethodBeat.o(72871);
                return false;
            } else if (((n) qVar).fOn()) {
                AppMethodBeat.o(72871);
                return false;
            } else if (((n) qVar).getHasRetried()) {
                Log.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass");
                AppMethodBeat.o(72871);
                return false;
            } else {
                n nVar = (n) qVar;
                a aVar2 = this.RuB;
                int i4 = t.fQI().mRetryCount;
                Log.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", Boolean.valueOf(nVar.hhN()), Integer.valueOf(aVar2.Ruw));
                if (!nVar.hhN() || aVar2.Ruw >= i4) {
                    z = false;
                } else {
                    z = true;
                }
                if (!nVar.checkRecSrvResp()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Log.d("MicroMsg.WalletNetSceneMgr", "%s shouldRetry, network: %B, server: %B", this, Boolean.valueOf(z2), Boolean.valueOf(z));
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(965, 13, 1);
                if (z2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(965, 14, 1);
                }
                if (z || z2) {
                    Log.i("MicroMsg.WalletNetSceneMgr", "%s doing delay order query retry", this);
                    this.RuB.a(nVar);
                    AppMethodBeat.o(72871);
                    return true;
                }
                AppMethodBeat.o(72871);
                return false;
            }
        } else {
            Log.i("MicroMsg.WalletNetSceneMgr", "test do delay query order");
            this.RuB.a((n) qVar);
            AppMethodBeat.o(72871);
            return true;
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(72872);
        if (this.ksP.contains(qVar)) {
            Log.d("MicroMsg.WalletNetSceneMgr", "%s has find scene ", this);
            if (!j(i2, i3, str, qVar)) {
                Log.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", this);
                this.ksP.remove(qVar);
                z = true;
            } else {
                Log.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", this);
                AppMethodBeat.o(72872);
                return;
            }
        } else if (this.ksO.contains(qVar)) {
            Log.d("MicroMsg.WalletNetSceneMgr", "%s has find forcescenes ", this);
            if (!j(i2, i3, str, qVar)) {
                this.ksO.remove(qVar);
                Log.i("MicroMsg.WalletNetSceneMgr", "%s Not need delay query order,remove scene", this);
                z = true;
            } else {
                Log.i("MicroMsg.WalletNetSceneMgr", "%s do delay order query.break off!", this);
                AppMethodBeat.o(72872);
                return;
            }
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletNetSceneMgr", "%s onSceneEnd scenes %s forcescenes %s", this, Integer.valueOf(this.ksP.size()), Integer.valueOf(this.ksO.size()));
        if (!this.ksP.isEmpty() || !this.ksO.isEmpty()) {
            z2 = false;
        } else {
            closeTipDialog();
            z2 = true;
        }
        if (z && this.yWw != null) {
            this.yWw.onSceneEnd(i2, i3, str, qVar, z2);
        }
        AppMethodBeat.o(72872);
    }

    public final void closeTipDialog() {
        AppMethodBeat.i(72873);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        AppMethodBeat.o(72873);
    }

    public final boolean isProcessing() {
        AppMethodBeat.i(72874);
        if (!this.ksP.isEmpty() || !this.ksO.isEmpty()) {
            AppMethodBeat.o(72874);
            return true;
        }
        AppMethodBeat.o(72874);
        return false;
    }

    private void onDestroy() {
        AppMethodBeat.i(72875);
        forceCancel();
        this.yWw = null;
        this.mContext = null;
        this.RuB.destory();
        this.RuC.destory();
        for (c cVar : this.RuD.values()) {
            cVar.fib();
        }
        this.RuD.clear();
        AppMethodBeat.o(72875);
    }

    private void s(q qVar) {
        AppMethodBeat.i(72876);
        if (qVar != null && (qVar instanceof w)) {
            ((w) qVar).setProcessName(this.mProcessName);
            if (this.mBundle != null) {
                ((w) qVar).setProcessBundle(this.mBundle);
                AppMethodBeat.o(72876);
                return;
            } else if (this.mContext instanceof WalletBaseUI) {
                ((w) qVar).setProcessBundle(((WalletBaseUI) this.mContext).getInput());
            }
        }
        AppMethodBeat.o(72876);
    }
}
