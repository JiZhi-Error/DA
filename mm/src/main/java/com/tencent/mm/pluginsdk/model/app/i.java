package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public final class i implements com.tencent.mm.ak.i, am.b, u {
    private List<String> JVN;
    private MTimerHandler JVP;
    private List<String> JWb;
    private List<String> JWc;
    private volatile boolean JWd;
    private List<String> hiK;
    Map<String, Integer> lpp;

    public i() {
        AppMethodBeat.i(151727);
        this.JVN = null;
        this.hiK = null;
        this.lpp = null;
        this.JWd = false;
        this.JVP = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.pluginsdk.model.app.i.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(151726);
                i.this.lpp.clear();
                AppMethodBeat.o(151726);
                return false;
            }
        }, false);
        this.JVN = new ArrayList();
        this.hiK = new ArrayList();
        this.lpp = new HashMap();
        this.JWb = new Vector();
        this.JWc = new ArrayList();
        this.JVP.startTimer(600000);
        a.eAV().a(7, this);
        AppMethodBeat.o(151727);
    }

    @Override // com.tencent.mm.model.am.b
    public final String r(Context context, String str) {
        AppMethodBeat.i(151728);
        String r = h.r(context, str);
        AppMethodBeat.o(151728);
        return r;
    }

    public final void bF(LinkedList<String> linkedList) {
        AppMethodBeat.i(151729);
        if (linkedList == null || linkedList.size() == 0) {
            Log.e("MicroMsg.AppInfoService", "batch push appinfo err: null or nil applist");
            AppMethodBeat.o(151729);
            return;
        }
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            alB(it.next());
        }
        gmV();
        AppMethodBeat.o(151729);
    }

    private synchronized void alB(String str) {
        boolean z;
        AppMethodBeat.i(151730);
        if (Util.isNullOrNil(str) || this.JWb.contains(str)) {
            Log.i("MicroMsg.AppInfoService", "should not add this appid:[%s], it is already runing", str);
            AppMethodBeat.o(151730);
        } else {
            if (str == null) {
                Log.e("MicroMsg.AppInfoService", "increaseCounter fail, appId is null");
                z = false;
            } else {
                Integer valueOf = Integer.valueOf(Util.nullAs(this.lpp.get(str), 0));
                if (valueOf.intValue() >= 5) {
                    Log.e("MicroMsg.AppInfoService", "increaseCounter fail, has reached the max try count");
                    z = false;
                } else {
                    this.lpp.put(str, Integer.valueOf(valueOf.intValue() + 1));
                    z = true;
                }
            }
            if (!z) {
                Log.e("MicroMsg.AppInfoService", "this app has reach the max retry count, appid is %s", str);
                AppMethodBeat.o(151730);
            } else {
                Log.i("MicroMsg.AppInfoService", "add appid:[%s]", str);
                this.JWb.add(str);
                AppMethodBeat.o(151730);
            }
        }
    }

    public final void bdF(String str) {
        AppMethodBeat.i(151731);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AppInfoService", "push fail, appId is null");
            AppMethodBeat.o(151731);
            return;
        }
        Log.i("MicroMsg.AppInfoService", "push appid : ".concat(String.valueOf(str)));
        alB(str);
        gmV();
        AppMethodBeat.o(151731);
    }

    private void gmV() {
        int i2 = 20;
        AppMethodBeat.i(151732);
        if (this.JWd) {
            Log.d("MicroMsg.AppInfoService", " batch get appinfo doing now");
            AppMethodBeat.o(151732);
        } else if (this.JWb == null || this.JWb.isEmpty()) {
            Log.d("MicroMsg.AppInfoService", "batchwaitinglist is empty, no need to doscene");
            AppMethodBeat.o(151732);
        } else {
            int size = this.JWb.size();
            if (size <= 20) {
                i2 = size;
            }
            synchronized (this) {
                try {
                    this.JWc.addAll(this.JWb.subList(0, i2));
                } finally {
                    AppMethodBeat.o(151732);
                }
            }
            if (this.JWc != null && !this.JWc.isEmpty()) {
                this.JWd = true;
                g.aAg().hqi.a(new ab(7, new ac(this.JWc)), 0);
            }
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(151733);
        int type = qVar.getType();
        switch (type) {
            case 451:
                synchronized (this) {
                    try {
                        if (this.JWc != null && !this.JWc.isEmpty()) {
                            this.JWb.removeAll(this.JWc);
                            this.JWc.clear();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(151733);
                        throw th;
                    }
                }
                this.JWd = false;
                gmV();
                AppMethodBeat.o(151733);
                return;
            default:
                Log.e("MicroMsg.AppInfoService", "error type: ".concat(String.valueOf(type)));
                AppMethodBeat.o(151733);
                return;
        }
    }

    @Override // com.tencent.mm.pluginsdk.model.app.u
    public final void a(int i2, int i3, String str, aa aaVar) {
        AppMethodBeat.i(151734);
        if (aaVar.getType() != 7) {
            Log.d("MicroMsg.AppInfoService", "not the getappinfolist scene, ignore");
            AppMethodBeat.o(151734);
            return;
        }
        synchronized (this) {
            try {
                if (this.JWc != null && !this.JWc.isEmpty()) {
                    this.JWb.removeAll(this.JWc);
                    this.JWc.clear();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(151734);
                throw th;
            }
        }
        this.JWd = false;
        gmV();
        AppMethodBeat.o(151734);
    }
}
