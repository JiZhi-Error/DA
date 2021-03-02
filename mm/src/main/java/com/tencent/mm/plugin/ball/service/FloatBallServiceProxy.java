package com.tencent.mm.plugin.ball.service;

import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class FloatBallServiceProxy implements com.tencent.mm.plugin.ball.c.b {
    @Override // com.tencent.mm.plugin.ball.c.b
    public final void dn(View view) {
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void chU() {
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jQ(boolean z2) {
        AppMethodBeat.i(176964);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(z2), u.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(176964);
    }

    static final class u implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid> {
        private u() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCBoolean iPCBoolean, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(176963);
            d.ciB().jQ(iPCBoolean.value);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(176963);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jL(boolean z2) {
        AppMethodBeat.i(106191);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(z2), n.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass10 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106191);
    }

    static final class n implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid> {
        private n() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCBoolean iPCBoolean, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106165);
            d.ciB().a(iPCBoolean.value, (AnimatorListenerAdapter) null);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106165);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jM(boolean z2) {
        AppMethodBeat.i(106192);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(z2), ac.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass20 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106192);
    }

    static final class ac implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid> {
        private ac() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCBoolean iPCBoolean, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106176);
            d.ciB().a(iPCBoolean.value, true, (AnimatorListenerAdapter) null);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106176);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jN(boolean z2) {
        AppMethodBeat.i(106193);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(z2), o.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass26 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106193);
    }

    static final class o implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid> {
        private o() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCBoolean iPCBoolean, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106166);
            d.ciB().jN(iPCBoolean.value);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106166);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jO(boolean z2) {
        AppMethodBeat.i(106194);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(z2), ad.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass27 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106194);
    }

    static final class ad implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid> {
        private ad() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCBoolean iPCBoolean, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106177);
            d.ciB().jO(iPCBoolean.value);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106177);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jP(boolean z2) {
        AppMethodBeat.i(217022);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(z2), p.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass28 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(217022);
    }

    static final class p implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid> {
        private p() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCBoolean iPCBoolean, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(217016);
            d.ciB().jP(iPCBoolean.value);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(217016);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void chL() {
        AppMethodBeat.i(106195);
        XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, w.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass29 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106195);
    }

    static final class w implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid> {
        private w() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106170);
            d.ciB().chL();
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106170);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void onAccountRelease() {
        AppMethodBeat.i(106196);
        XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, x.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass30 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106196);
    }

    static final class x implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid> {
        private x() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106171);
            d.ciB().onAccountRelease();
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106171);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void Dw(boolean z2) {
        AppMethodBeat.i(106197);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(z2), ag.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass31 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106197);
    }

    static final class ag implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid> {
        private ag() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCBoolean iPCBoolean, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106169);
            d.ciB().Dw(iPCBoolean.value);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106169);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final boolean chM() {
        AppMethodBeat.i(106198);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, r.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.o(106198);
            return false;
        }
        AppMethodBeat.o(106198);
        return true;
    }

    static final class r implements com.tencent.mm.ipcinvoker.k<IPCVoid, IPCBoolean> {
        private r() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(106167);
            IPCBoolean iPCBoolean = new IPCBoolean(d.ciB().oXc);
            AppMethodBeat.o(106167);
            return iPCBoolean;
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final boolean chV() {
        AppMethodBeat.i(217023);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, q.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.o(217023);
            return false;
        }
        AppMethodBeat.o(217023);
        return true;
    }

    static final class q implements com.tencent.mm.ipcinvoker.k<IPCVoid, IPCBoolean> {
        private q() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(217017);
            IPCBoolean iPCBoolean = new IPCBoolean(d.ciB().oXd);
            AppMethodBeat.o(217017);
            return iPCBoolean;
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final boolean chN() {
        AppMethodBeat.i(217024);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, v.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.o(217024);
            return false;
        }
        AppMethodBeat.o(217024);
        return true;
    }

    static final class v implements com.tencent.mm.ipcinvoker.k<IPCVoid, IPCBoolean> {
        private v() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(217019);
            IPCBoolean iPCBoolean = new IPCBoolean(d.ciB().chN());
            AppMethodBeat.o(217019);
            return iPCBoolean;
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final boolean chO() {
        AppMethodBeat.i(106199);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, s.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.o(106199);
            return false;
        }
        AppMethodBeat.o(106199);
        return true;
    }

    static final class s implements com.tencent.mm.ipcinvoker.k<IPCVoid, IPCBoolean> {
        private s() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(106168);
            IPCBoolean iPCBoolean = new IPCBoolean(d.ciB().oXe);
            AppMethodBeat.o(106168);
            return iPCBoolean;
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void By(long j2) {
        AppMethodBeat.i(217025);
        Log.w("MicroMsg.FloatBallServiceProxy", "markEnterChattingUI not implemented in non-MM process");
        AppMethodBeat.o(217025);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final long dgY() {
        AppMethodBeat.i(258546);
        Log.w("MicroMsg.FloatBallServiceProxy", "getEnterChattingUITimestamp not implemented in non-MM process");
        AppMethodBeat.o(258546);
        return 0;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void chP() {
        AppMethodBeat.i(106200);
        XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, j.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106200);
    }

    static final class j implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid> {
        private j() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106156);
            d.ciB().chP();
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106156);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(int i2, int i3, boolean z2, long j2) {
        AppMethodBeat.i(184594);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCKeyBoardChangedInfo(i2, i3, z2, j2), ak.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
                AppMethodBeat.i(106144);
                AppMethodBeat.o(106144);
            }
        });
        AppMethodBeat.o(184594);
    }

    static final class ak implements com.tencent.mm.ipcinvoker.b<IPCKeyBoardChangedInfo, IPCVoid> {
        private ak() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCKeyBoardChangedInfo iPCKeyBoardChangedInfo, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106190);
            IPCKeyBoardChangedInfo iPCKeyBoardChangedInfo2 = iPCKeyBoardChangedInfo;
            d.ciB().a(iPCKeyBoardChangedInfo2.height, iPCKeyBoardChangedInfo2.oXj, iPCKeyBoardChangedInfo2.hwq, iPCKeyBoardChangedInfo2.gY);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106190);
        }
    }

    static class IPCKeyBoardChangedInfo implements Parcelable {
        public static final Parcelable.Creator<IPCKeyBoardChangedInfo> CREATOR = new Parcelable.Creator<IPCKeyBoardChangedInfo>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.IPCKeyBoardChangedInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ IPCKeyBoardChangedInfo[] newArray(int i2) {
                return new IPCKeyBoardChangedInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ IPCKeyBoardChangedInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(184584);
                IPCKeyBoardChangedInfo iPCKeyBoardChangedInfo = new IPCKeyBoardChangedInfo(parcel);
                AppMethodBeat.o(184584);
                return iPCKeyBoardChangedInfo;
            }
        };
        long gY;
        int height;
        boolean hwq;
        int oXj;

        IPCKeyBoardChangedInfo(int i2, int i3, boolean z, long j2) {
            this.height = i2;
            this.oXj = i3;
            this.hwq = z;
            this.gY = j2;
        }

        IPCKeyBoardChangedInfo(Parcel parcel) {
            AppMethodBeat.i(184585);
            this.height = parcel.readInt();
            this.oXj = parcel.readInt();
            this.hwq = parcel.readByte() != 0;
            this.gY = parcel.readLong();
            AppMethodBeat.o(184585);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(184586);
            parcel.writeInt(this.height);
            parcel.writeInt(this.oXj);
            parcel.writeByte((byte) (this.hwq ? 1 : 0));
            parcel.writeLong(this.gY);
            AppMethodBeat.o(184586);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(184587);
            AppMethodBeat.o(184587);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void dhp() {
        AppMethodBeat.i(106202);
        XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, al.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass22 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106202);
    }

    static final class al implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid> {
        private al() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106172);
            d.ciB().dhp();
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106172);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(final com.tencent.mm.plugin.ball.c.i iVar) {
        AppMethodBeat.i(106203);
        XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, k.class, new com.tencent.mm.ipcinvoker.d<BallInfoListParcel>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(BallInfoListParcel ballInfoListParcel) {
                AppMethodBeat.i(217011);
                BallInfoListParcel ballInfoListParcel2 = ballInfoListParcel;
                if (ballInfoListParcel2 == null || ballInfoListParcel2.oVq == null || ballInfoListParcel2.oVq.isEmpty()) {
                    if (iVar != null) {
                        iVar.bH(new ArrayList());
                    }
                } else if (iVar != null) {
                    iVar.bH(ballInfoListParcel2.oVq);
                    AppMethodBeat.o(217011);
                    return;
                }
                AppMethodBeat.o(217011);
            }
        });
        AppMethodBeat.o(106203);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final List<BallInfo> chQ() {
        return null;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final List<BallInfo> chR() {
        return null;
    }

    static final class k implements com.tencent.mm.ipcinvoker.b<IPCVoid, BallInfoListParcel> {
        private k() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, final com.tencent.mm.ipcinvoker.d<BallInfoListParcel> dVar) {
            AppMethodBeat.i(106162);
            d.ciB().a(new com.tencent.mm.plugin.ball.c.i() {
                /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.k.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.ball.c.i
                public final void bH(List<BallInfo> list) {
                    AppMethodBeat.i(106161);
                    if (dVar != null) {
                        dVar.bn(new BallInfoListParcel(list));
                    }
                    AppMethodBeat.o(106161);
                }
            });
            AppMethodBeat.o(106162);
        }
    }

    static class BallInfoListParcel implements Parcelable {
        public static final Parcelable.Creator<BallInfoListParcel> CREATOR = new Parcelable.Creator<BallInfoListParcel>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.BallInfoListParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ BallInfoListParcel[] newArray(int i2) {
                return new BallInfoListParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ BallInfoListParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(106146);
                BallInfoListParcel ballInfoListParcel = new BallInfoListParcel(parcel);
                AppMethodBeat.o(106146);
                return ballInfoListParcel;
            }
        };
        List<BallInfo> oVq;

        public BallInfoListParcel(List<BallInfo> list) {
            this.oVq = list;
        }

        protected BallInfoListParcel(Parcel parcel) {
            AppMethodBeat.i(106147);
            this.oVq = parcel.createTypedArrayList(BallInfo.CREATOR);
            AppMethodBeat.o(106147);
        }

        static {
            AppMethodBeat.i(106149);
            AppMethodBeat.o(106149);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(106148);
            parcel.writeTypedList(this.oVq);
            AppMethodBeat.o(106148);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final BallInfo h(BallInfo ballInfo) {
        AppMethodBeat.i(106204);
        BallInfo ballInfo2 = (BallInfo) XIPCInvoker.a(MainProcessIPCService.dkO, ballInfo, l.class);
        AppMethodBeat.o(106204);
        return ballInfo2;
    }

    static final class l implements com.tencent.mm.ipcinvoker.k<BallInfo, BallInfo> {
        private l() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ BallInfo invoke(BallInfo ballInfo) {
            AppMethodBeat.i(106163);
            BallInfo h2 = d.ciB().h(ballInfo);
            AppMethodBeat.o(106163);
            return h2;
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final boolean i(BallInfo ballInfo) {
        AppMethodBeat.i(106205);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a(MainProcessIPCService.dkO, ballInfo, d.class);
        if (iPCBoolean == null || !iPCBoolean.value) {
            AppMethodBeat.o(106205);
            return false;
        }
        AppMethodBeat.o(106205);
        return true;
    }

    static final class d implements com.tencent.mm.ipcinvoker.k<BallInfo, IPCBoolean> {
        private d() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCBoolean invoke(BallInfo ballInfo) {
            AppMethodBeat.i(106150);
            IPCBoolean iPCBoolean = new IPCBoolean(d.ciB().i(ballInfo));
            AppMethodBeat.o(106150);
            return iPCBoolean;
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void j(BallInfo ballInfo) {
        AppMethodBeat.i(106206);
        XIPCInvoker.a(MainProcessIPCService.dkO, ballInfo, a.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass5 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106206);
    }

    static final class a implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(BallInfo ballInfo, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106145);
            d.ciB().j(ballInfo);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106145);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void k(BallInfo ballInfo) {
        AppMethodBeat.i(106207);
        XIPCInvoker.a(MainProcessIPCService.dkO, ballInfo, ai.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass6 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106207);
    }

    static final class ai implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid> {
        private ai() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(BallInfo ballInfo, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106184);
            d.ciB().k(ballInfo);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106184);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void l(BallInfo ballInfo) {
        AppMethodBeat.i(106208);
        XIPCInvoker.a(MainProcessIPCService.dkO, ballInfo, z.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass7 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106208);
    }

    static final class z implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid> {
        private z() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(BallInfo ballInfo, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106174);
            d.ciB().l(ballInfo);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106174);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void t(BallInfo ballInfo) {
        AppMethodBeat.i(217026);
        XIPCInvoker.a(MainProcessIPCService.dkO, ballInfo, t.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass8 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(217026);
    }

    static final class t implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid> {
        private t() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(BallInfo ballInfo, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(217018);
            d.ciB().t(ballInfo);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(217018);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(long j2, final b.a aVar) {
        AppMethodBeat.i(217027);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCLong(j2), c.class, new com.tencent.mm.ipcinvoker.d<IPCInteger>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass9 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCInteger iPCInteger) {
                AppMethodBeat.i(217012);
                IPCInteger iPCInteger2 = iPCInteger;
                if (aVar != null) {
                    aVar.BE(iPCInteger2.value);
                }
                AppMethodBeat.o(217012);
            }
        });
        AppMethodBeat.o(217027);
    }

    static final class c implements com.tencent.mm.ipcinvoker.b<IPCLong, IPCInteger> {
        private c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCLong iPCLong, final com.tencent.mm.ipcinvoker.d<IPCInteger> dVar) {
            AppMethodBeat.i(217015);
            d.ciB().a(iPCLong.value, new b.a() {
                /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.c.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.ball.c.b.a
                public final void BE(int i2) {
                    AppMethodBeat.i(217014);
                    dVar.bn(new IPCInteger(i2));
                    AppMethodBeat.o(217014);
                }
            });
            AppMethodBeat.o(217015);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void BD(int i2) {
        AppMethodBeat.i(217028);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCInteger(i2), ab.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass11 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(217028);
    }

    static final class ab implements com.tencent.mm.ipcinvoker.b<IPCInteger, IPCVoid> {
        private ab() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCInteger iPCInteger, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(217020);
            d.ciB().BD(iPCInteger.value);
            AppMethodBeat.o(217020);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void m(BallInfo ballInfo) {
        AppMethodBeat.i(106209);
        XIPCInvoker.a(MainProcessIPCService.dkO, ballInfo, e.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass12 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
                AppMethodBeat.i(176962);
                AppMethodBeat.o(176962);
            }
        });
        AppMethodBeat.o(106209);
    }

    static final class e implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid> {
        private e() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(BallInfo ballInfo, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106151);
            d.ciB().m(ballInfo);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106151);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void n(BallInfo ballInfo) {
        AppMethodBeat.i(106210);
        XIPCInvoker.a(MainProcessIPCService.dkO, ballInfo, i.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass13 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106210);
    }

    static final class i implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid> {
        private i() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(BallInfo ballInfo, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106155);
            d.ciB().n(ballInfo);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106155);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void o(BallInfo ballInfo) {
        AppMethodBeat.i(106211);
        XIPCInvoker.a(MainProcessIPCService.dkO, ballInfo, f.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass14 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106211);
    }

    static final class f implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid> {
        private f() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(BallInfo ballInfo, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106152);
            d.ciB().c(ballInfo, true);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106152);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void p(BallInfo ballInfo) {
        AppMethodBeat.i(106212);
        XIPCInvoker.a(MainProcessIPCService.dkO, ballInfo, g.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass15 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106212);
    }

    static final class g implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid> {
        private g() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(BallInfo ballInfo, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106153);
            d.ciB().c(ballInfo, false);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106153);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void q(BallInfo ballInfo) {
        AppMethodBeat.i(106213);
        XIPCInvoker.a(MainProcessIPCService.dkO, ballInfo, h.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass16 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106213);
    }

    static final class h implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid> {
        private h() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(BallInfo ballInfo, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106154);
            d.ciB().q(ballInfo);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106154);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(BallInfo ballInfo, ResultReceiver resultReceiver) {
        AppMethodBeat.i(106214);
        XIPCInvoker.a(MainProcessIPCService.dkO, new FloatBallInfoEventReceiverParcel(ballInfo, com.tencent.mm.plugin.ball.f.d.b(resultReceiver)), y.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass17 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106214);
    }

    static final class y implements com.tencent.mm.ipcinvoker.b<FloatBallInfoEventReceiverParcel, IPCVoid> {
        private y() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(FloatBallInfoEventReceiverParcel floatBallInfoEventReceiverParcel, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106173);
            FloatBallInfoEventReceiverParcel floatBallInfoEventReceiverParcel2 = floatBallInfoEventReceiverParcel;
            d.ciB().a(floatBallInfoEventReceiverParcel2.oWE, floatBallInfoEventReceiverParcel2.cBu);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106173);
        }
    }

    static final class FloatBallInfoEventReceiverParcel implements Parcelable {
        public static final Parcelable.Creator<FloatBallInfoEventReceiverParcel> CREATOR = new Parcelable.Creator<FloatBallInfoEventReceiverParcel>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.FloatBallInfoEventReceiverParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ FloatBallInfoEventReceiverParcel[] newArray(int i2) {
                return new FloatBallInfoEventReceiverParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FloatBallInfoEventReceiverParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(106157);
                FloatBallInfoEventReceiverParcel floatBallInfoEventReceiverParcel = new FloatBallInfoEventReceiverParcel(parcel);
                AppMethodBeat.o(106157);
                return floatBallInfoEventReceiverParcel;
            }
        };
        ResultReceiver cBu;
        BallInfo oWE;

        public FloatBallInfoEventReceiverParcel(BallInfo ballInfo, ResultReceiver resultReceiver) {
            this.oWE = ballInfo;
            this.cBu = resultReceiver;
        }

        protected FloatBallInfoEventReceiverParcel(Parcel parcel) {
            AppMethodBeat.i(106158);
            this.oWE = (BallInfo) parcel.readParcelable(BallInfo.class.getClassLoader());
            this.cBu = (ResultReceiver) parcel.readParcelable(ResultReceiver.class.getClassLoader());
            AppMethodBeat.o(106158);
        }

        static {
            AppMethodBeat.i(106160);
            AppMethodBeat.o(106160);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(106159);
            parcel.writeParcelable(this.oWE, i2);
            parcel.writeParcelable(this.cBu, i2);
            AppMethodBeat.o(106159);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void s(BallInfo ballInfo) {
        AppMethodBeat.i(106215);
        XIPCInvoker.a(MainProcessIPCService.dkO, ballInfo, aa.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass18 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106215);
    }

    static final class aa implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid> {
        private aa() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(BallInfo ballInfo, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106175);
            d.ciB().s(ballInfo);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106175);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final Point getBallPosition() {
        AppMethodBeat.i(106216);
        Point point = (Point) XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, m.class);
        AppMethodBeat.o(106216);
        return point;
    }

    static final class m implements com.tencent.mm.ipcinvoker.k<IPCVoid, Point> {
        private m() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Point invoke(IPCVoid iPCVoid) {
            AppMethodBeat.i(106164);
            Point ballPosition = d.ciB().getBallPosition();
            AppMethodBeat.o(106164);
            return ballPosition;
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(ResultReceiver resultReceiver) {
        AppMethodBeat.i(217029);
        XIPCInvoker.a(MainProcessIPCService.dkO, resultReceiver, ah.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass19 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(217029);
    }

    static final class ah implements com.tencent.mm.ipcinvoker.b<ResultReceiver, IPCVoid> {
        private ah() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(ResultReceiver resultReceiver, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106183);
            d.ciB().a(resultReceiver);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106183);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void r(BallInfo ballInfo) {
        AppMethodBeat.i(217030);
        if (ballInfo == null) {
            AppMethodBeat.o(217030);
            return;
        }
        XIPCInvoker.a(MainProcessIPCService.dkO, ballInfo, b.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass21 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(217030);
    }

    static final class b implements com.tencent.mm.ipcinvoker.b<BallInfo, IPCVoid> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(BallInfo ballInfo, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(217013);
            BallInfo ballInfo2 = ballInfo;
            if (ballInfo2 != null) {
                b.a(ballInfo2, d.ciB().oVq);
            }
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(217013);
        }
    }

    static class SetFloatBallAlphaParcel implements Parcelable {
        public static final Parcelable.Creator<SetFloatBallAlphaParcel> CREATOR = new Parcelable.Creator<SetFloatBallAlphaParcel>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.SetFloatBallAlphaParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SetFloatBallAlphaParcel[] newArray(int i2) {
                return new SetFloatBallAlphaParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SetFloatBallAlphaParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(106178);
                SetFloatBallAlphaParcel setFloatBallAlphaParcel = new SetFloatBallAlphaParcel(parcel);
                AppMethodBeat.o(106178);
                return setFloatBallAlphaParcel;
            }
        };
        float alpha;
        BallInfo oWE;

        protected SetFloatBallAlphaParcel(Parcel parcel) {
            AppMethodBeat.i(106179);
            this.alpha = parcel.readFloat();
            this.oWE = (BallInfo) parcel.readParcelable(BallInfo.class.getClassLoader());
            AppMethodBeat.o(106179);
        }

        static {
            AppMethodBeat.i(106181);
            AppMethodBeat.o(106181);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(106180);
            parcel.writeFloat(this.alpha);
            parcel.writeParcelable(this.oWE, i2);
            AppMethodBeat.o(106180);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(BallInfo ballInfo, boolean z2) {
        AppMethodBeat.i(106219);
        XIPCInvoker.a(MainProcessIPCService.dkO, new UpdateBallVisibilityParcel(z2, ballInfo), aj.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass23 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(106219);
    }

    static final class aj implements com.tencent.mm.ipcinvoker.b<UpdateBallVisibilityParcel, IPCVoid> {
        private aj() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(UpdateBallVisibilityParcel updateBallVisibilityParcel, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(106189);
            UpdateBallVisibilityParcel updateBallVisibilityParcel2 = updateBallVisibilityParcel;
            d.ciB().a(updateBallVisibilityParcel2.oWE, updateBallVisibilityParcel2.visible);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(106189);
        }
    }

    static class UpdateBallVisibilityParcel implements Parcelable {
        public static final Parcelable.Creator<UpdateBallVisibilityParcel> CREATOR = new Parcelable.Creator<UpdateBallVisibilityParcel>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.UpdateBallVisibilityParcel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ UpdateBallVisibilityParcel[] newArray(int i2) {
                return new UpdateBallVisibilityParcel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ UpdateBallVisibilityParcel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(106185);
                UpdateBallVisibilityParcel updateBallVisibilityParcel = new UpdateBallVisibilityParcel(parcel);
                AppMethodBeat.o(106185);
                return updateBallVisibilityParcel;
            }
        };
        BallInfo oWE;
        boolean visible;

        public UpdateBallVisibilityParcel(boolean z, BallInfo ballInfo) {
            this.visible = z;
            this.oWE = ballInfo;
        }

        protected UpdateBallVisibilityParcel(Parcel parcel) {
            AppMethodBeat.i(106186);
            this.visible = parcel.readByte() != 0;
            this.oWE = (BallInfo) parcel.readParcelable(BallInfo.class.getClassLoader());
            AppMethodBeat.o(106186);
        }

        static {
            AppMethodBeat.i(106188);
            AppMethodBeat.o(106188);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(106187);
            parcel.writeByte((byte) (this.visible ? 1 : 0));
            parcel.writeParcelable(this.oWE, i2);
            AppMethodBeat.o(106187);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(int i2, com.tencent.mm.plugin.ball.c.e eVar) {
        AppMethodBeat.i(106220);
        Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallInfoEventListener not implemented in non-MM process");
        AppMethodBeat.o(106220);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void b(int i2, com.tencent.mm.plugin.ball.c.e eVar) {
        AppMethodBeat.i(106221);
        Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallInfoEventListener not implemented in non-MM process");
        AppMethodBeat.o(106221);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(com.tencent.mm.plugin.ball.c.d dVar) {
        AppMethodBeat.i(258074);
        Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallInfoChangedListener not implemented in non-MM process");
        AppMethodBeat.o(258074);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void b(com.tencent.mm.plugin.ball.c.d dVar) {
        AppMethodBeat.i(258075);
        Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallInfoChangedListener not implemented in non-MM process");
        AppMethodBeat.o(258075);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(com.tencent.mm.plugin.ball.c.g gVar) {
        AppMethodBeat.i(217031);
        Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallViewListener not implemented in non-MM process");
        AppMethodBeat.o(217031);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void b(com.tencent.mm.plugin.ball.c.g gVar) {
        AppMethodBeat.i(217032);
        Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallViewListener not implemented in non-MM process");
        AppMethodBeat.o(217032);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final Set<com.tencent.mm.plugin.ball.c.g> chS() {
        AppMethodBeat.i(217033);
        Log.w("MicroMsg.FloatBallServiceProxy", "getFloatBallViewListeners not implemented in non-MM process");
        AppMethodBeat.o(217033);
        return null;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final boolean chT() {
        AppMethodBeat.i(217034);
        Log.w("MicroMsg.FloatBallServiceProxy", "isFloatBallViewDockLeft not implemented in non-MM process");
        AppMethodBeat.o(217034);
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jR(boolean z2) {
        AppMethodBeat.i(184595);
        Log.w("MicroMsg.FloatBallServiceProxy", "markNeedProcessFloatViewLayoutParamsFlag not implemented in non-MM process");
        AppMethodBeat.o(184595);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jS(boolean z2) {
        AppMethodBeat.i(217035);
        Log.w("MicroMsg.FloatBallServiceProxy", "markForceHideAllFloatBall not implemented in non-MM process");
        AppMethodBeat.o(217035);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void chW() {
        AppMethodBeat.i(184596);
        Log.w("MicroMsg.FloatBallServiceProxy", "addFloatBallViewLayoutParamsFlag not implemented in non-MM process");
        AppMethodBeat.o(184596);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void chX() {
        AppMethodBeat.i(184597);
        Log.w("MicroMsg.FloatBallServiceProxy", "removeFloatBallViewLayoutParamsFlag not implemented in non-MM process");
        AppMethodBeat.o(184597);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void setEnableClick(boolean z2) {
        AppMethodBeat.i(217036);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCBoolean(z2), af.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass24 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(217036);
    }

    static final class af implements com.tencent.mm.ipcinvoker.b<IPCBoolean, IPCVoid> {
        private af() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCBoolean iPCBoolean, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(217021);
            d.ciB().setEnableClick(iPCBoolean.value);
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(217021);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final boolean c(AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(184598);
        Log.w("MicroMsg.FloatBallServiceProxy", "updateBallVisibilityByPosition not implemented in non-MM process");
        AppMethodBeat.o(184598);
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void BC(int i2) {
        AppMethodBeat.i(184599);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCInteger(i2), ae.class, new com.tencent.mm.ipcinvoker.d<IPCVoid>() {
            /* class com.tencent.mm.plugin.ball.service.FloatBallServiceProxy.AnonymousClass25 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* bridge */ /* synthetic */ void bn(IPCVoid iPCVoid) {
            }
        });
        AppMethodBeat.o(184599);
    }

    static final class ae implements com.tencent.mm.ipcinvoker.b<IPCInteger, IPCVoid> {
        private ae() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCInteger iPCInteger, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(184590);
            d.ciB().displayHeight = iPCInteger.value;
            dVar.bn(IPCVoid.hnE);
            AppMethodBeat.o(184590);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void u(BallInfo ballInfo) {
        AppMethodBeat.i(217037);
        Log.w("MicroMsg.FloatBallServiceProxy", "switchVoipVoice not implemented in non-MM process");
        AppMethodBeat.o(217037);
    }
}
