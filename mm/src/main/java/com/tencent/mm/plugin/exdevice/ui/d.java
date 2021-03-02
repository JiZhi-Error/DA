package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class d {
    int azh;
    com.tencent.mm.plugin.exdevice.g.b.a.d rMD;
    int rME;

    /* synthetic */ d(int i2, int i3, String str, String str2, com.tencent.mm.plugin.exdevice.g.b.a.d dVar, byte b2) {
        this(i2, i3, str, str2, dVar);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        int azh;
        String rJH;
        com.tencent.mm.plugin.exdevice.g.b.a.d rMD = null;
        int rME;
        String username;

        public final d cMh() {
            AppMethodBeat.i(24308);
            d dVar = new d(this.azh, this.rME, this.rJH, this.username, this.rMD, (byte) 0);
            AppMethodBeat.o(24308);
            return dVar;
        }
    }

    private d(int i2, int i3, String str, String str2, com.tencent.mm.plugin.exdevice.g.b.a.d dVar) {
        AppMethodBeat.i(24309);
        this.azh = i2;
        this.rME = i3;
        if (i2 != 0) {
            if (dVar != null) {
                this.rMD = dVar;
                AppMethodBeat.o(24309);
                return;
            }
            com.tencent.mm.plugin.exdevice.g.b.a.d dVar2 = new com.tencent.mm.plugin.exdevice.g.b.a.d();
            dVar2.field_username = str2;
            dVar2.field_appusername = str;
            dVar2.field_ranknum = 0;
            dVar2.field_selfLikeState = 0;
            dVar2.field_rankID = "";
            dVar2.field_likecount = 0;
            dVar2.field_score = 0;
            this.rMD = dVar2;
        }
        AppMethodBeat.o(24309);
    }

    public final String toString() {
        String str;
        AppMethodBeat.i(24310);
        String str2 = "{ view type: " + this.azh + " display flag: " + this.rME;
        if (this.rMD != null) {
            str = str2 + this.rMD.toString();
        } else {
            str = str2 + " mExdeviceRankInfo is null";
        }
        String str3 = str + "}";
        AppMethodBeat.o(24310);
        return str3;
    }
}
