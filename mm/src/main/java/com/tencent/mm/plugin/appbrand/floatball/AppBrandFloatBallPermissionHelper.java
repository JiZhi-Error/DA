package com.tencent.mm.plugin.appbrand.floatball;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.ball.f.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class AppBrandFloatBallPermissionHelper {
    public static void a(Context context, int i2, final c.a aVar) {
        AppMethodBeat.i(44992);
        CheckFloatBallPermissionRequest checkFloatBallPermissionRequest = new CheckFloatBallPermissionRequest();
        checkFloatBallPermissionRequest.lqH = i2;
        com.tencent.mm.plugin.appbrand.ipc.a.a(context, checkFloatBallPermissionRequest, new AppBrandProxyUIProcessTask.b<CheckFloatBallPermissionResult>() {
            /* class com.tencent.mm.plugin.appbrand.floatball.AppBrandFloatBallPermissionHelper.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
            public final /* synthetic */ void a(CheckFloatBallPermissionResult checkFloatBallPermissionResult) {
                boolean z = true;
                AppMethodBeat.i(44980);
                CheckFloatBallPermissionResult checkFloatBallPermissionResult2 = checkFloatBallPermissionResult;
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(checkFloatBallPermissionResult2 != null && checkFloatBallPermissionResult2.dHF);
                Log.i("MicroMsg.AppBrandLocationFloatBallHelper", "onClose, checkFloatBallPermission isOK:%b", objArr);
                if (aVar != null) {
                    c.a aVar = aVar;
                    if (checkFloatBallPermissionResult2 == null || !checkFloatBallPermissionResult2.dHF) {
                        z = false;
                    }
                    aVar.ha(z);
                }
                AppMethodBeat.o(44980);
            }
        });
        AppMethodBeat.o(44992);
    }

    /* access modifiers changed from: package-private */
    public static final class CheckFloatBallPermissionRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
        public static final Parcelable.Creator<CheckFloatBallPermissionRequest> CREATOR = new Parcelable.Creator<CheckFloatBallPermissionRequest>() {
            /* class com.tencent.mm.plugin.appbrand.floatball.AppBrandFloatBallPermissionHelper.CheckFloatBallPermissionRequest.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ CheckFloatBallPermissionRequest[] newArray(int i2) {
                return new CheckFloatBallPermissionRequest[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CheckFloatBallPermissionRequest createFromParcel(Parcel parcel) {
                AppMethodBeat.i(44981);
                CheckFloatBallPermissionRequest checkFloatBallPermissionRequest = new CheckFloatBallPermissionRequest(parcel);
                AppMethodBeat.o(44981);
                return checkFloatBallPermissionRequest;
            }
        };
        int lqH;

        CheckFloatBallPermissionRequest() {
        }

        CheckFloatBallPermissionRequest(Parcel parcel) {
            super(parcel);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final Class<? extends AppBrandProxyUIProcessTask> bCJ() {
            return a.class;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final void k(Parcel parcel) {
            AppMethodBeat.i(44982);
            this.lqH = parcel.readInt();
            AppMethodBeat.o(44982);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(44983);
            parcel.writeInt(this.lqH);
            AppMethodBeat.o(44983);
        }

        static {
            AppMethodBeat.i(44984);
            AppMethodBeat.o(44984);
        }
    }

    static final class CheckFloatBallPermissionResult extends AppBrandProxyUIProcessTask.ProcessResult {
        public static final Parcelable.Creator<CheckFloatBallPermissionResult> CREATOR = new Parcelable.Creator<CheckFloatBallPermissionResult>() {
            /* class com.tencent.mm.plugin.appbrand.floatball.AppBrandFloatBallPermissionHelper.CheckFloatBallPermissionResult.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ CheckFloatBallPermissionResult[] newArray(int i2) {
                return new CheckFloatBallPermissionResult[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CheckFloatBallPermissionResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(44985);
                CheckFloatBallPermissionResult checkFloatBallPermissionResult = new CheckFloatBallPermissionResult(parcel);
                AppMethodBeat.o(44985);
                return checkFloatBallPermissionResult;
            }
        };
        boolean dHF;

        CheckFloatBallPermissionResult() {
        }

        CheckFloatBallPermissionResult(Parcel parcel) {
            super(parcel);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult
        public final void k(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(44986);
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.dHF = z;
            AppMethodBeat.o(44986);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(44987);
            parcel.writeByte(this.dHF ? (byte) 1 : 0);
            AppMethodBeat.o(44987);
        }

        static {
            AppMethodBeat.i(44988);
            AppMethodBeat.o(44988);
        }
    }

    static final class a extends AppBrandProxyUIProcessTask {
        private a() {
        }

        static /* synthetic */ void a(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(44991);
            aVar.b(processResult);
            AppMethodBeat.o(44991);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
            AppMethodBeat.i(44990);
            if (!(processRequest instanceof CheckFloatBallPermissionRequest)) {
                AppMethodBeat.o(44990);
                return;
            }
            c.a((Context) bDF(), ((CheckFloatBallPermissionRequest) processRequest).lqH, false, (c.a) new c.a() {
                /* class com.tencent.mm.plugin.appbrand.floatball.AppBrandFloatBallPermissionHelper.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.ball.f.c.a
                public final void ha(boolean z) {
                    AppMethodBeat.i(44989);
                    CheckFloatBallPermissionResult checkFloatBallPermissionResult = new CheckFloatBallPermissionResult();
                    checkFloatBallPermissionResult.dHF = z;
                    a.a(a.this, checkFloatBallPermissionResult);
                    AppMethodBeat.o(44989);
                }
            });
            AppMethodBeat.o(44990);
        }
    }
}
