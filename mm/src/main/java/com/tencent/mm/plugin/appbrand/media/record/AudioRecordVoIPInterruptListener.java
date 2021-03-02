package com.tencent.mm.plugin.appbrand.media.record;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fn;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class AudioRecordVoIPInterruptListener implements f {
    private boolean isStart = false;
    private e ndG;
    private CheckInterruptTask ndR;
    private StartInterruptEventListenTask ndS;
    private StopInterruptEventListenTask ndT;

    @Override // com.tencent.mm.plugin.appbrand.media.record.f
    public final void a(e eVar) {
        this.ndG = eVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.f
    public final boolean bOX() {
        AppMethodBeat.i(47610);
        if (this.ndG == null) {
            Log.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
            AppMethodBeat.o(47610);
            return false;
        }
        if (this.ndR == null) {
            this.ndR = new CheckInterruptTask(this.ndG);
        }
        AppBrandMainProcessService.b(this.ndR);
        Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isInterrupted:%b", Boolean.valueOf(this.ndR.ndC));
        boolean z = this.ndR.ndC;
        AppMethodBeat.o(47610);
        return z;
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.f
    public final void bOY() {
        AppMethodBeat.i(47611);
        if (this.ndG == null) {
            Log.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "callback is invalid");
            AppMethodBeat.o(47611);
            return;
        }
        if (this.ndS == null) {
            this.ndS = new StartInterruptEventListenTask(this.ndG);
        }
        this.isStart = true;
        AppBrandMainProcessService.a(this.ndS);
        AppMethodBeat.o(47611);
    }

    @Override // com.tencent.mm.plugin.appbrand.media.record.f
    public final void bOZ() {
        AppMethodBeat.i(47612);
        if (!this.isStart) {
            Log.e("MicroMsg.Record.AudioRecordVoIPInterruptListener", "not start listen");
            AppMethodBeat.o(47612);
            return;
        }
        this.isStart = false;
        if (this.ndT == null) {
            this.ndT = new StopInterruptEventListenTask();
        }
        AppBrandMainProcessService.b(this.ndT);
        AppMethodBeat.o(47612);
    }

    static class CheckInterruptTask extends MainProcessTask {
        public static final Parcelable.Creator<CheckInterruptTask> CREATOR = new Parcelable.Creator<CheckInterruptTask>() {
            /* class com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener.CheckInterruptTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ CheckInterruptTask[] newArray(int i2) {
                return new CheckInterruptTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CheckInterruptTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(47584);
                CheckInterruptTask checkInterruptTask = new CheckInterruptTask(parcel);
                AppMethodBeat.o(47584);
                return checkInterruptTask;
            }
        };
        private boolean ndC = false;
        private e ndG;

        public CheckInterruptTask(e eVar) {
            this.ndG = eVar;
        }

        public CheckInterruptTask(Parcel parcel) {
            AppMethodBeat.i(47585);
            f(parcel);
            AppMethodBeat.o(47585);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            boolean z = false;
            AppMethodBeat.i(47586);
            this.ndC = false;
            zi ziVar = new zi();
            EventCenter.instance.publish(ziVar);
            boolean z2 = ziVar.efv.dCI;
            boolean att = com.tencent.mm.q.a.att();
            Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "isVoipUsing:%b, isMultiTalkUsing:%b, isAppBrandVoiceUsing:%b", Boolean.valueOf(z2), Boolean.valueOf(att), Boolean.valueOf(com.tencent.mm.q.a.atw()));
            if (z2 || att) {
                z = true;
            }
            this.ndC = z;
            bDU();
            AppMethodBeat.o(47586);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(47587);
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.ndC = z;
            AppMethodBeat.o(47587);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(47588);
            parcel.writeInt(this.ndC ? 1 : 0);
            AppMethodBeat.o(47588);
        }

        static {
            AppMethodBeat.i(47589);
            AppMethodBeat.o(47589);
        }
    }

    static class StartInterruptEventListenTask extends MainProcessTask {
        public static final Parcelable.Creator<StartInterruptEventListenTask> CREATOR = new Parcelable.Creator<StartInterruptEventListenTask>() {
            /* class com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener.StartInterruptEventListenTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StartInterruptEventListenTask[] newArray(int i2) {
                return new StartInterruptEventListenTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StartInterruptEventListenTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(47593);
                StartInterruptEventListenTask startInterruptEventListenTask = new StartInterruptEventListenTask(parcel);
                AppMethodBeat.o(47593);
                return startInterruptEventListenTask;
            }
        };
        private e ndG;
        private int ndW = -1;
        private final IListener ndX = new IListener<fn>() {
            /* class com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener.StartInterruptEventListenTask.AnonymousClass2 */

            {
                AppMethodBeat.i(160608);
                this.__eventId = fn.class.getName().hashCode();
                AppMethodBeat.o(160608);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(fn fnVar) {
                AppMethodBeat.i(47594);
                StartInterruptEventListenTask.a(StartInterruptEventListenTask.this);
                Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "exit multi talk room event");
                AppMethodBeat.o(47594);
                return false;
            }
        };
        private final IListener ndY = new IListener<zj>() {
            /* class com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener.StartInterruptEventListenTask.AnonymousClass3 */

            {
                AppMethodBeat.i(160609);
                this.__eventId = zj.class.getName().hashCode();
                AppMethodBeat.o(160609);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(zj zjVar) {
                AppMethodBeat.i(47595);
                zj zjVar2 = zjVar;
                if (zjVar2.efx.dKy == 11) {
                    Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "stop voIP event");
                    StartInterruptEventListenTask.this.ndW = 11;
                    StartInterruptEventListenTask.b(StartInterruptEventListenTask.this);
                    AppMethodBeat.o(47595);
                    return true;
                } else if (zjVar2.efx.dKy == 3) {
                    Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "start invite voIP event");
                    StartInterruptEventListenTask.this.ndW = 3;
                    StartInterruptEventListenTask.c(StartInterruptEventListenTask.this);
                    AppMethodBeat.o(47595);
                    return true;
                } else {
                    AppMethodBeat.o(47595);
                    return false;
                }
            }
        };

        static /* synthetic */ boolean a(StartInterruptEventListenTask startInterruptEventListenTask) {
            AppMethodBeat.i(47602);
            boolean bDU = startInterruptEventListenTask.bDU();
            AppMethodBeat.o(47602);
            return bDU;
        }

        static /* synthetic */ boolean b(StartInterruptEventListenTask startInterruptEventListenTask) {
            AppMethodBeat.i(47603);
            boolean bDU = startInterruptEventListenTask.bDU();
            AppMethodBeat.o(47603);
            return bDU;
        }

        static /* synthetic */ boolean c(StartInterruptEventListenTask startInterruptEventListenTask) {
            AppMethodBeat.i(47604);
            boolean bDU = startInterruptEventListenTask.bDU();
            AppMethodBeat.o(47604);
            return bDU;
        }

        public StartInterruptEventListenTask(e eVar) {
            AppMethodBeat.i(47596);
            this.ndG = eVar;
            AppMethodBeat.o(47596);
        }

        public StartInterruptEventListenTask(Parcel parcel) {
            AppMethodBeat.i(47597);
            f(parcel);
            AppMethodBeat.o(47597);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(47598);
            Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "addListener");
            if (!EventCenter.instance.hadListened(this.ndX)) {
                EventCenter.instance.addListener(this.ndX);
                a.bPh();
                a.a(this.ndX);
            }
            if (!EventCenter.instance.hadListened(this.ndY)) {
                EventCenter.instance.addListener(this.ndY);
                a.bPh();
                a.a(this.ndY);
            }
            AppMethodBeat.o(47598);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(47599);
            if (this.ndG != null) {
                if (this.ndW == 11) {
                    Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptEnd");
                    this.ndG.bOW();
                } else if (this.ndW == 3) {
                    Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "onInterruptBegin");
                    this.ndG.bOV();
                }
                this.ndW = -1;
            }
            AppMethodBeat.o(47599);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(47600);
            this.ndW = parcel.readInt();
            AppMethodBeat.o(47600);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(47601);
            parcel.writeInt(this.ndW);
            AppMethodBeat.o(47601);
        }

        static {
            AppMethodBeat.i(47605);
            AppMethodBeat.o(47605);
        }
    }

    static class StopInterruptEventListenTask extends MainProcessTask {
        public static final Parcelable.Creator<StopInterruptEventListenTask> CREATOR = new Parcelable.Creator<StopInterruptEventListenTask>() {
            /* class com.tencent.mm.plugin.appbrand.media.record.AudioRecordVoIPInterruptListener.StopInterruptEventListenTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StopInterruptEventListenTask[] newArray(int i2) {
                return new StopInterruptEventListenTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StopInterruptEventListenTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(47606);
                StopInterruptEventListenTask stopInterruptEventListenTask = new StopInterruptEventListenTask(parcel);
                AppMethodBeat.o(47606);
                return stopInterruptEventListenTask;
            }
        };

        public StopInterruptEventListenTask() {
        }

        public StopInterruptEventListenTask(Parcel parcel) {
            AppMethodBeat.i(47607);
            f(parcel);
            AppMethodBeat.o(47607);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(47608);
            Log.i("MicroMsg.Record.AudioRecordVoIPInterruptListener", "removeListener");
            a bPh = a.bPh();
            synchronized (a.class) {
                try {
                    Iterator<IListener<IEvent>> it = bPh.ndV.iterator();
                    while (it.hasNext()) {
                        EventCenter.instance.removeListener(it.next());
                    }
                    bPh.ndV.clear();
                } finally {
                    AppMethodBeat.o(47608);
                }
            }
        }

        static {
            AppMethodBeat.i(47609);
            AppMethodBeat.o(47609);
        }
    }

    static class a {
        private static a ndU;
        LinkedList<IListener<IEvent>> ndV = new LinkedList<>();

        private a() {
            AppMethodBeat.i(47590);
            AppMethodBeat.o(47590);
        }

        public static a bPh() {
            AppMethodBeat.i(47591);
            if (ndU == null) {
                synchronized (a.class) {
                    try {
                        if (ndU == null) {
                            ndU = new a();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(47591);
                        throw th;
                    }
                }
            }
            a aVar = ndU;
            AppMethodBeat.o(47591);
            return aVar;
        }

        public static void a(IListener<IEvent> iListener) {
            AppMethodBeat.i(47592);
            synchronized (a.class) {
                try {
                    bPh().ndV.add(iListener);
                } finally {
                    AppMethodBeat.o(47592);
                }
            }
        }
    }
}
