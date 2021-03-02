package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.g;

public final class i {
    public int NBC = this.NBz.getInt("crash_count", 0);
    public boolean NBU = this.NBz.getBoolean("launch_recovery", false);
    public boolean NBV = this.NBz.getBoolean("launch_recovery_real", false);
    public boolean NBW = this.NBz.getBoolean("recover_from_crash", false);
    public int NBX = this.NBz.getInt("recovery_status", -1);
    public boolean NBY = this.NBz.getBoolean("recover_is_discard", false);
    public int NBZ = this.NBz.getInt("recover_internal_status", 0);
    private g NBz;
    public long NCa = this.NBz.getLong("recover_running_time", 0);
    public int mFrom = this.NBz.getInt("recovery_from", 0);

    public static i iQ(Context context) {
        AppMethodBeat.i(193833);
        i iVar = new i(context);
        AppMethodBeat.o(193833);
        return iVar;
    }

    private i(Context context) {
        AppMethodBeat.i(193834);
        this.NBz = new g.b(context, "recovery_statistic").guJ();
        AppMethodBeat.o(193834);
    }

    public final String toString() {
        AppMethodBeat.i(193835);
        String str = "RecoveryStatistic{mCrashCount=" + this.NBC + ", mNeedLaunchRecovery=" + this.NBU + ", mHasReallyLaunchRecovery=" + this.NBV + ", mHasRecoverFromCrash=" + this.NBW + ", mRecoveryStatus=" + this.NBX + ", mIsDiscarded=" + this.NBY + ", mFrom=" + this.mFrom + ", mInternalStatus=" + this.NBZ + ", mRunningTime=" + this.NCa + '}';
        AppMethodBeat.o(193835);
        return str;
    }

    public final void save() {
        AppMethodBeat.i(193836);
        this.NBz.gL("crash_count", this.NBC).de("launch_recovery", this.NBU).de("launch_recovery_real", this.NBV).de("recover_from_crash", this.NBW).gL("recovery_status", this.NBX).gL("recovery_from", this.mFrom).gL("recover_internal_status", this.NBZ).bT("recover_running_time", this.NCa).de("recover_is_discard", this.NBY).guF();
        AppMethodBeat.o(193836);
    }

    public final void guO() {
        AppMethodBeat.i(193837);
        this.NBz.gL("crash_count", this.NBC).de("launch_recovery", this.NBU).de("launch_recovery_real", this.NBV).de("recover_from_crash", this.NBW).gL("recovery_status", this.NBX).gL("recovery_from", this.mFrom).gL("recover_internal_status", this.NBZ).bT("recover_running_time", this.NCa).de("recover_is_discard", this.NBY).guG();
        AppMethodBeat.o(193837);
    }
}
