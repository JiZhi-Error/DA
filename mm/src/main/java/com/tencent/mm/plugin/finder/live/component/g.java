package com.tencent.mm.plugin.finder.live.component;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\b\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/component/LotteryUpdateStatus;", "", "statusChange", "", "newLottery", "localStatus", "", "lotteryStatus", "resumeState", "(ZZIIZ)V", "getLocalStatus", "()I", "setLocalStatus", "(I)V", "getLotteryStatus", "setLotteryStatus", "getNewLottery", "()Z", "setNewLottery", "(Z)V", "getResumeState", "setResumeState", "getStatusChange", "setStatusChange", "component1", "component2", "component3", "component4", "component5", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
public final class g {
    boolean uhB;
    boolean uhC;
    int uhD;
    int uhE;
    boolean uhF;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                if (!(this.uhB == gVar.uhB && this.uhC == gVar.uhC && this.uhD == gVar.uhD && this.uhE == gVar.uhE && this.uhF == gVar.uhF)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = 1;
        boolean z = this.uhB;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = i3 * 31;
        boolean z2 = this.uhC;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (((((i7 + i6) * 31) + this.uhD) * 31) + this.uhE) * 31;
        boolean z3 = this.uhF;
        if (!z3) {
            i2 = z3 ? 1 : 0;
        }
        return i10 + i2;
    }

    private g() {
        this.uhB = false;
        this.uhC = false;
        this.uhD = 0;
        this.uhE = 0;
        this.uhF = false;
    }

    public /* synthetic */ g(byte b2) {
        this();
    }

    public final String toString() {
        AppMethodBeat.i(245973);
        String str = "LotteryUpdateStatus localStatus:" + this.uhD + ",lotteryStatus:" + this.uhE + ",statusChange:" + this.uhB + ",newLottery:" + this.uhC + ",resumeState:" + this.uhF;
        AppMethodBeat.o(245973);
        return str;
    }
}
