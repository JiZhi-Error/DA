package com.tencent.mm.plugin.address.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.address.d.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.n.d;

public final class l {
    private static final Pattern PATTERN = Pattern.compile("(-|\\s)+");
    public a ksX = new a();
    public boolean ksY = false;
    public final List<RcptItem> ksZ = new ArrayList();
    public final HashMap<String, List<RcptItem>> kta = new HashMap<>();
    public final HashMap<String, List<RcptItem>> ktb = new HashMap<>();
    public String path;

    public l() {
        AppMethodBeat.i(20801);
        AppMethodBeat.o(20801);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02f6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02f7, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01fb, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01fc, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02c2 A[Catch:{ Exception -> 0x02db }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1 A[SYNTHETIC, Splitter:B:24:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a6 A[Catch:{ Exception -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ac A[SYNTHETIC, Splitter:B:30:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00dc A[SYNTHETIC, Splitter:B:43:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b5 A[SYNTHETIC, Splitter:B:71:0x01b5] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01ba A[Catch:{ Exception -> 0x01c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01fb A[ExcHandler: all (th java.lang.Throwable), Splitter:B:30:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01ff A[SYNTHETIC, Splitter:B:90:0x01ff] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bqe() {
        /*
        // Method dump skipped, instructions count: 782
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.address.model.l.bqe():void");
    }

    public final b vp(int i2) {
        AppMethodBeat.i(20803);
        for (int i3 = 0; i3 < this.ksX.ktf.size(); i3++) {
            b bVar = this.ksX.ktf.get(i3);
            if (bVar.id == i2) {
                AppMethodBeat.o(20803);
                return bVar;
            }
        }
        AppMethodBeat.o(20803);
        return null;
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(20804);
        if (this.ksX == null) {
            this.ksX = new a();
        }
        for (int i2 = 0; i2 < this.ksX.ktf.size(); i2++) {
            if (this.ksX.ktf.get(i2).id == bVar.id) {
                this.ksX.ktf.remove(i2);
                AppMethodBeat.o(20804);
                return true;
            }
        }
        AppMethodBeat.o(20804);
        return false;
    }

    public final boolean t(LinkedList<djk> linkedList) {
        AppMethodBeat.i(20805);
        this.ksX.ktf.clear();
        Iterator<djk> it = linkedList.iterator();
        while (it.hasNext()) {
            djk next = it.next();
            b bVar = new b();
            bVar.id = next.id;
            bVar.kto = next.MNE.MTo;
            bVar.kti = next.MNy.MTo;
            bVar.ktl = next.MNB.MTo;
            bVar.ktj = next.MNz.MTo;
            bVar.ktm = next.MNC.MTo;
            bVar.ktn = next.MND.MTo;
            bVar.kth = next.MNx.MTo;
            bVar.ktk = next.MNA.MTo;
            this.ksX.ktf.add(bVar);
        }
        AppMethodBeat.o(20805);
        return true;
    }

    public final void bqf() {
        AppMethodBeat.i(20806);
        try {
            byte[] byteArray = this.ksX.toByteArray();
            long currentTimeMillis = System.currentTimeMillis();
            ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_WALLET_ADDRESS_INFO_STRING_SYNC, new String(byteArray, d.ISO_8859_1));
            Log.d("MicroMsg.WalletAddrMgr", "hakon saveAddr time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(20806);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WalletAddrMgr", e2, "", new Object[0]);
            AppMethodBeat.o(20806);
        }
    }

    public final List<RcptItem> TB(String str) {
        AppMethodBeat.i(20810);
        if (this.kta.containsKey(str)) {
            List<RcptItem> list = this.kta.get(str);
            AppMethodBeat.o(20810);
            return list;
        }
        ArrayList arrayList = new ArrayList();
        AppMethodBeat.o(20810);
        return arrayList;
    }

    public final List<RcptItem> TC(String str) {
        AppMethodBeat.i(20811);
        if (this.ktb.containsKey(str)) {
            List<RcptItem> list = this.ktb.get(str);
            AppMethodBeat.o(20811);
            return list;
        }
        ArrayList arrayList = new ArrayList();
        AppMethodBeat.o(20811);
        return arrayList;
    }

    public final RcptItem TD(String str) {
        AppMethodBeat.i(20812);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(20812);
            return null;
        }
        for (RcptItem rcptItem : this.ksZ) {
            if (rcptItem.name.startsWith(str)) {
                AppMethodBeat.o(20812);
                return rcptItem;
            }
        }
        AppMethodBeat.o(20812);
        return null;
    }

    public final RcptItem cd(String str, String str2) {
        AppMethodBeat.i(20813);
        List<RcptItem> TB = TB(str);
        if (TB == null || TB.size() == 0) {
            AppMethodBeat.o(20813);
            return null;
        }
        for (RcptItem rcptItem : TB) {
            if (rcptItem.name.startsWith(str2)) {
                AppMethodBeat.o(20813);
                return rcptItem;
            }
        }
        AppMethodBeat.o(20813);
        return null;
    }

    static {
        AppMethodBeat.i(20818);
        AppMethodBeat.o(20818);
    }

    private static boolean ce(String str, String str2) {
        AppMethodBeat.i(20814);
        if (str.substring(6).startsWith(str2)) {
            AppMethodBeat.o(20814);
            return true;
        }
        AppMethodBeat.o(20814);
        return false;
    }

    public final RcptItem x(String str, String str2, String str3) {
        AppMethodBeat.i(20815);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(20815);
            return null;
        }
        RcptItem e2 = e(this.ksZ, str);
        if (e2 == null || TextUtils.isEmpty(e2.code)) {
            AppMethodBeat.o(20815);
            return null;
        }
        RcptItem e3 = e(TB(e2.code), str2);
        if (e3 == null || TextUtils.isEmpty(e3.code)) {
            AppMethodBeat.o(20815);
            return null;
        } else if (TextUtils.isEmpty(str3)) {
            AppMethodBeat.o(20815);
            return e3;
        } else {
            RcptItem e4 = e(TC(e3.code), str3);
            if (e4 == null) {
                AppMethodBeat.o(20815);
                return e3;
            }
            AppMethodBeat.o(20815);
            return e4;
        }
    }

    private static RcptItem e(List<RcptItem> list, String str) {
        RcptItem rcptItem;
        AppMethodBeat.i(20816);
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(20816);
            return null;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= list.size()) {
                rcptItem = null;
                break;
            }
            rcptItem = list.get(i2);
            if (rcptItem != null && str.equals(rcptItem.name)) {
                break;
            }
            i2++;
        }
        AppMethodBeat.o(20816);
        return rcptItem;
    }

    public final boolean y(String str, String str2, String str3) {
        AppMethodBeat.i(20817);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(20817);
            return false;
        }
        RcptItem e2 = e(this.ksZ, str);
        if (e2 == null || TextUtils.isEmpty(e2.code)) {
            AppMethodBeat.o(20817);
            return false;
        }
        RcptItem e3 = e(TB(e2.code), str2);
        if (e3 == null || TextUtils.isEmpty(e3.code)) {
            AppMethodBeat.o(20817);
            return false;
        } else if (TextUtils.isEmpty(str3)) {
            AppMethodBeat.o(20817);
            return true;
        } else if (e(TC(e3.code), str3) == null) {
            AppMethodBeat.o(20817);
            return false;
        } else {
            AppMethodBeat.o(20817);
            return true;
        }
    }
}
