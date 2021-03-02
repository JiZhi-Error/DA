package com.tencent.mm.plugin.festival.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/HeartbeatTimer;", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "block", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "isStarted", "()Z", "isStopped", "", "looperInterval", "getLooperInterval", "()J", "startTimer", "delay", "interval", "stopTimer", "plugin-festival_release"})
public final class ae extends MTimerHandler {
    long UzL = MAlarmHandler.NEXT_FIRE_INTERVAL;
    boolean ifP = true;
    boolean isStarted;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ae(final a<x> aVar) {
        super(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.festival.model.ae.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(263146);
                aVar.invoke();
                AppMethodBeat.o(263146);
                return true;
            }
        }, true);
        p.h(aVar, "block");
        AppMethodBeat.i(263149);
        AppMethodBeat.o(263149);
    }

    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler
    public final void startTimer(long j2, long j3) {
        AppMethodBeat.i(263147);
        this.UzL = j3;
        this.isStarted = true;
        this.ifP = false;
        super.startTimer(j2, j3);
        this.UzL = j3;
        this.isStarted = true;
        this.ifP = false;
        AppMethodBeat.o(263147);
    }

    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler
    public final void stopTimer() {
        AppMethodBeat.i(263148);
        this.UzL = MAlarmHandler.NEXT_FIRE_INTERVAL;
        this.isStarted = false;
        this.ifP = true;
        super.stopTimer();
        AppMethodBeat.o(263148);
    }
}
