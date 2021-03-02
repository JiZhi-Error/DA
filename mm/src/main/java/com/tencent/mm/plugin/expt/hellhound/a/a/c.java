package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dzv;

public final class c {
    public int chatFooterHeight = 0;
    public String finderLiveId = "";
    public String hJs;
    public int liveStatus;
    public String msgId;
    public int position;
    public dzv sBK;
    public int sBL = -1;
    public boolean sBM = false;
    public String sBN = "";

    /* access modifiers changed from: package-private */
    public final boolean GX(int i2) {
        AppMethodBeat.i(220454);
        int i3 = this.sBK.CHZ + this.sBK.udM;
        if (i2 != 0 && this.sBK.y == 0 && this.position == 0) {
            i3 = 0;
        }
        int i4 = this.sBK.mEY - this.sBK.virtualKeyHeight;
        int max = Math.max(this.sBK.y, i3);
        int i5 = this.sBK.y + this.sBK.height;
        int min = Math.min(i5, i4);
        if (this.sBK.y >= i4) {
            AppMethodBeat.o(220454);
            return false;
        } else if (i5 <= i3) {
            AppMethodBeat.o(220454);
            return false;
        } else if (this.sBK.y < i3 || i5 > i4) {
            int i6 = min - max;
            if (((float) i6) / ((float) this.sBK.height) >= 0.9f) {
                AppMethodBeat.o(220454);
                return true;
            } else if (((float) i6) / ((float) (i4 - i3)) >= 0.5f) {
                AppMethodBeat.o(220454);
                return true;
            } else {
                AppMethodBeat.o(220454);
                return false;
            }
        } else {
            AppMethodBeat.o(220454);
            return true;
        }
    }

    public final boolean bJw() {
        int i2 = this.sBK.CHZ + this.sBK.udM;
        int i3 = this.sBK.mEY - this.sBK.virtualKeyHeight;
        int i4 = this.sBK.y + this.sBK.height;
        if (this.sBK.y < i3 && i4 > i2) {
            return true;
        }
        return false;
    }

    public final boolean cOA() {
        int i2 = this.sBK.CHZ + this.sBK.udM;
        int i3 = (this.sBK.mEY - this.sBK.virtualKeyHeight) - this.chatFooterHeight;
        int i4 = this.sBK.y + this.sBK.height;
        if (this.sBK.y < i3 && i4 > i2) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.sBK.feedId == null ? "NULL" : this.sBK.feedId;
    }
}
