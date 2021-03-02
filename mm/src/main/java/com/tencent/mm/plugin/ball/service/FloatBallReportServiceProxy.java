package com.tencent.mm.plugin.ball.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.ball.service.c;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0003\u0010\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "Lcom/tencent/mm/plugin/ball/api/IFloatBallReportService;", "()V", "markExitPage", "", "pageType", "", "hasFloatBall", "", "isSupportMessageBall", "markWechatForeground", "foreground", "onEnterChattingFromNotification", AppMeasurement.Param.TIMESTAMP, "", "addMessageBallResult", "Companion", "MarkExitPageTask", "MarkExitPageTaskData", "plugin-ball_release"})
public final class FloatBallReportServiceProxy implements com.tencent.mm.plugin.ball.c.a {
    private static final f iax = g.a(k.SYNCHRONIZED, b.oWR);
    public static final a oWQ = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class d<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        public static final d oWS = new d();

        static {
            AppMethodBeat.i(217167);
            AppMethodBeat.o(217167);
        }

        d() {
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* bridge */ /* synthetic */ void bn(Object obj) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "getInstance", "()Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "instance$delegate", "Lkotlin/Lazy;", "plugin-ball_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(217171);
        AppMethodBeat.o(217171);
    }

    @Override // com.tencent.mm.plugin.ball.c.a
    public final void d(int i2, boolean z, boolean z2) {
        AppMethodBeat.i(217168);
        XIPCInvoker.a(MainProcessIPCService.dkO, new MarkExitPageTaskData(i2, z, z2), c.class, d.oWS);
        AppMethodBeat.o(217168);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-ball_release"})
    static final class c implements com.tencent.mm.ipcinvoker.b<MarkExitPageTaskData, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(MarkExitPageTaskData markExitPageTaskData, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(217162);
            MarkExitPageTaskData markExitPageTaskData2 = markExitPageTaskData;
            if (markExitPageTaskData2 == null) {
                AppMethodBeat.o(217162);
                return;
            }
            c.a aVar = c.oWM;
            c.a.ciA().d(markExitPageTaskData2.lqH, markExitPageTaskData2.oWO, markExitPageTaskData2.oWP);
            AppMethodBeat.o(217162);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u0013\u0010\u0012¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "floatBallType", "", "hasFloatBall", "", "isSupportMessageBall", "(IZZ)V", "getFloatBallType", "()I", "setFloatBallType", "(I)V", "getHasFloatBall", "()Z", "setHasFloatBall", "(Z)V", "setSupportMessageBall", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-ball_release"})
    static final class MarkExitPageTaskData implements Parcelable {
        public static final a CREATOR = new a((byte) 0);
        int lqH;
        boolean oWO;
        boolean oWP;

        static {
            AppMethodBeat.i(217166);
            AppMethodBeat.o(217166);
        }

        public MarkExitPageTaskData(int i2, boolean z, boolean z2) {
            this.lqH = i2;
            this.oWO = z;
            this.oWP = z2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public MarkExitPageTaskData(Parcel parcel) {
            this(0, false, false);
            boolean z;
            boolean z2 = true;
            p.h(parcel, "parcel");
            AppMethodBeat.i(217165);
            this.lqH = parcel.readInt();
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.oWO = z;
            this.oWP = parcel.readByte() == 0 ? false : z2;
            AppMethodBeat.o(217165);
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            byte b2;
            byte b3 = 1;
            AppMethodBeat.i(217164);
            p.h(parcel, "parcel");
            parcel.writeInt(this.lqH);
            if (this.oWO) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            parcel.writeByte(b2);
            if (!this.oWP) {
                b3 = 0;
            }
            parcel.writeByte(b3);
            AppMethodBeat.o(217164);
        }

        public final int describeContents() {
            return 0;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy$MarkExitPageTaskData;", "plugin-ball_release"})
        public static final class a implements Parcelable.Creator<MarkExitPageTaskData> {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MarkExitPageTaskData createFromParcel(Parcel parcel) {
                AppMethodBeat.i(217163);
                p.h(parcel, "parcel");
                MarkExitPageTaskData markExitPageTaskData = new MarkExitPageTaskData(parcel);
                AppMethodBeat.o(217163);
                return markExitPageTaskData;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ MarkExitPageTaskData[] newArray(int i2) {
                return new MarkExitPageTaskData[i2];
            }
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.a
    public final void l(long j2, int i2) {
        AppMethodBeat.i(217169);
        c.a aVar = c.oWM;
        c.a.ciA().l(j2, i2);
        AppMethodBeat.o(217169);
    }

    @Override // com.tencent.mm.plugin.ball.c.a
    public final void jK(boolean z) {
        AppMethodBeat.i(217170);
        c.a aVar = c.oWM;
        c.a.ciA().jK(z);
        AppMethodBeat.o(217170);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/ball/service/FloatBallReportServiceProxy;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<FloatBallReportServiceProxy> {
        public static final b oWR = new b();

        static {
            AppMethodBeat.i(217161);
            AppMethodBeat.o(217161);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FloatBallReportServiceProxy invoke() {
            AppMethodBeat.i(217160);
            FloatBallReportServiceProxy floatBallReportServiceProxy = new FloatBallReportServiceProxy();
            AppMethodBeat.o(217160);
            return floatBallReportServiceProxy;
        }
    }
}
