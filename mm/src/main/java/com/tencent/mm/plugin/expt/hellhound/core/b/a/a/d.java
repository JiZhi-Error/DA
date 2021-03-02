package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public final class d extends a {
    d() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final void reset() {
        AppMethodBeat.i(121966);
        Log.i("HABBYGE-MALI.ActivityDao_MMKV", "ActivityDao_MMKV reset");
        b.o("hell_aty_action_mmkv_key", new byte[0]);
        AppMethodBeat.o(121966);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final void apd(String str) {
        AppMethodBeat.i(121967);
        bk cNZ = cNZ();
        if (cNZ == null) {
            cNZ = new bk();
        }
        cNZ.KES = true;
        if (str == null) {
            str = "";
        }
        cNZ.KEW = str;
        a(cNZ);
        AppMethodBeat.o(121967);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final boolean aph(String str) {
        AppMethodBeat.i(121968);
        bk cNZ = cNZ();
        if (cNZ == null) {
            AppMethodBeat.o(121968);
            return false;
        }
        boolean z = cNZ.KES;
        String str2 = cNZ.KEW;
        if (z) {
            if (!TextUtils.isEmpty(str2) && !str2.equals(str)) {
                z = false;
            }
            cNZ.KES = false;
            cNZ.KEW = "";
            a(cNZ);
        }
        AppMethodBeat.o(121968);
        return z;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final void ape(String str) {
        AppMethodBeat.i(121969);
        bk cNZ = cNZ();
        if (cNZ == null) {
            cNZ = new bk();
        }
        cNZ.KET = true;
        if (str == null) {
            str = "";
        }
        cNZ.KEX = str;
        a(cNZ);
        AppMethodBeat.o(121969);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final boolean cNU() {
        AppMethodBeat.i(121970);
        bk cNZ = cNZ();
        if (cNZ == null) {
            AppMethodBeat.o(121970);
            return false;
        }
        boolean z = cNZ.KET;
        if (z) {
            cNZ.KET = false;
            cNZ.KEX = "";
            a(cNZ);
        }
        AppMethodBeat.o(121970);
        return z;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final void apf(String str) {
        AppMethodBeat.i(121971);
        bk cNZ = cNZ();
        if (cNZ == null) {
            cNZ = new bk();
        }
        cNZ.KEU = true;
        if (str == null) {
            str = "";
        }
        cNZ.KEZ = str;
        a(cNZ);
        AppMethodBeat.o(121971);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final boolean cNV() {
        AppMethodBeat.i(121972);
        bk cNZ = cNZ();
        if (cNZ == null) {
            AppMethodBeat.o(121972);
            return false;
        }
        boolean z = cNZ.KEU;
        if (z) {
            cNZ.KEU = false;
            cNZ.KEZ = "";
            a(cNZ);
        }
        AppMethodBeat.o(121972);
        return z;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final void apg(String str) {
        AppMethodBeat.i(121973);
        bk cNZ = cNZ();
        if (cNZ == null) {
            cNZ = new bk();
        }
        cNZ.KEV = true;
        if (str == null) {
            str = "";
        }
        cNZ.KFa = str;
        a(cNZ);
        AppMethodBeat.o(121973);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final boolean api(String str) {
        AppMethodBeat.i(121974);
        bk cNZ = cNZ();
        if (cNZ == null) {
            AppMethodBeat.o(121974);
            return false;
        }
        boolean z = cNZ.KEV;
        String str2 = cNZ.KFa;
        if (z) {
            if (!TextUtils.isEmpty(str2) && !str2.equals(str)) {
                Log.i("HABBYGE-MALI.ActivityDao_MMKV", "isFinishAction_pause, finishActivityName: %s, pActivityName: %s", str2, str);
                z = false;
            }
            cNZ.KEV = false;
            cNZ.KFa = "";
            a(cNZ);
        }
        Log.i("HABBYGE-MALI.ActivityDao_MMKV", "isFinishAction_pause, isFinishAction: %s", Boolean.valueOf(z));
        AppMethodBeat.o(121974);
        return z;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final void GQ(int i2) {
        AppMethodBeat.i(121975);
        bk cNZ = cNZ();
        if (cNZ == null) {
            cNZ = new bk();
        }
        cNZ.KFb = i2;
        a(cNZ);
        AppMethodBeat.o(121975);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final int cNT() {
        AppMethodBeat.i(121976);
        bk cNZ = cNZ();
        if (cNZ == null) {
            AppMethodBeat.o(121976);
            return -1;
        }
        int i2 = cNZ.KFb;
        AppMethodBeat.o(121976);
        return i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final void Z(Activity activity) {
        Fragment aa;
        AppMethodBeat.i(121977);
        bk cNZ = cNZ();
        if (cNZ == null) {
            cNZ = new bk();
        }
        String str = null;
        if ((activity instanceof FragmentActivity) && (aa = h.aa(activity)) != null) {
            str = aa.getClass().getCanonicalName();
        }
        if (str == null) {
            str = activity.getClass().getCanonicalName();
        }
        cNZ.sII = str;
        a(cNZ);
        AppMethodBeat.o(121977);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final void b(String str, boolean z, String str2) {
        bk bkVar;
        AppMethodBeat.i(121978);
        bk cNZ = cNZ();
        if (cNZ == null) {
            bkVar = new bk();
        } else {
            bkVar = cNZ;
        }
        String str3 = null;
        if (z) {
            str3 = str2;
        }
        if (str3 == null) {
            str3 = str.getClass().getCanonicalName();
        }
        bkVar.sII = str3;
        a(bkVar);
        AppMethodBeat.o(121978);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final void apj(String str) {
        AppMethodBeat.i(121979);
        bk cNZ = cNZ();
        if (cNZ == null) {
            cNZ = new bk();
        }
        cNZ.sII = str;
        a(cNZ);
        AppMethodBeat.o(121979);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.expt.hellhound.core.b.a.a.a
    public final String cNW() {
        AppMethodBeat.i(121980);
        bk cNZ = cNZ();
        if (cNZ == null) {
            AppMethodBeat.o(121980);
            return null;
        } else if (cNZ.sII.equals("")) {
            AppMethodBeat.o(121980);
            return null;
        } else {
            String str = cNZ.sII;
            AppMethodBeat.o(121980);
            return str;
        }
    }

    private static void a(bk bkVar) {
        AppMethodBeat.i(121981);
        try {
            b.o("hell_aty_action_mmkv_key", bkVar.toByteArray());
            AppMethodBeat.o(121981);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.ActivityDao_MMKV", e2, "HellhoundDao writeBack", new Object[0]);
            AppMethodBeat.o(121981);
        }
    }

    private static bk cNZ() {
        AppMethodBeat.i(121982);
        byte[] bytes = b.getBytes("hell_aty_action_mmkv_key");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.o(121982);
            return null;
        }
        bk bkVar = new bk();
        try {
            bkVar.parseFrom(bytes);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.ActivityDao_MMKV", e2, "HellhoundDao _doRead parse", new Object[0]);
            bkVar = null;
        }
        AppMethodBeat.o(121982);
        return bkVar;
    }
}
