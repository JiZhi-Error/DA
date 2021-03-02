package com.tencent.mm.msgsubscription.util;

import android.os.Parcelable;
import android.os.Process;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nJ\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\nJ\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH&R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/msgsubscription/util/CompatProcessTask;", "Landroid/os/Parcelable;", "()V", "taskId", "", "getTaskId", "()Ljava/lang/String;", "taskId$delegate", "Lkotlin/Lazy;", "callback", "", "describeContents", "", "execAsync", "keepMe", "parseFromParcel", "p", "Landroid/os/Parcel;", "releaseMe", "runInClientProcess", "runInMainProcess", "wxbiz-msgsubscription-sdk_release"})
public abstract class CompatProcessTask implements Parcelable {
    private final f jDe = g.ah(new c(this));

    public abstract void bjj();

    public final String bjl() {
        return (String) this.jDe.getValue();
    }

    public void bjk() {
    }

    public int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ CompatProcessTask jDf;

        b(CompatProcessTask compatProcessTask) {
            this.jDf = compatProcessTask;
        }

        public final void run() {
            AppMethodBeat.i(174576);
            this.jDf.bjj();
            AppMethodBeat.o(174576);
        }
    }

    public final void bjm() {
        h.RTc.b(new b(this), "CompatProcessTask_" + bjl());
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ CompatProcessTask jDf;

        public a(CompatProcessTask compatProcessTask) {
            this.jDf = compatProcessTask;
        }

        public final void run() {
            AppMethodBeat.i(174575);
            this.jDf.bjk();
            AppMethodBeat.o(174575);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ CompatProcessTask jDf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(CompatProcessTask compatProcessTask) {
            super(0);
            this.jDf = compatProcessTask;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(174577);
            String sb = new StringBuilder().append(Process.myPid()).append('_').append(this.jDf.hashCode()).toString();
            AppMethodBeat.o(174577);
            return sb;
        }
    }
}
