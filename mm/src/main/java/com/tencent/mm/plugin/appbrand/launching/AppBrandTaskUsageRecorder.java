package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.launching.a.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.fcc;
import com.tencent.mm.protocal.protobuf.fds;
import com.tencent.mm.protocal.protobuf.fez;

public final class AppBrandTaskUsageRecorder {

    public static final class UpdateTask extends MainProcessTask {
        public static final Parcelable.Creator<UpdateTask> CREATOR = new Parcelable.Creator<UpdateTask>() {
            /* class com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ UpdateTask[] newArray(int i2) {
                return new UpdateTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ UpdateTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(47112);
                UpdateTask updateTask = new UpdateTask(parcel);
                AppMethodBeat.o(47112);
                return updateTask;
            }
        };
        LaunchCheckParams mRN;

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(47113);
            if (!g.aAf().hpY || a.azj()) {
                AppMethodBeat.o(47113);
                return;
            }
            this.mRN.getClass();
            AppBrandLaunchReferrer appBrandLaunchReferrer = this.mRN.kEG.cys;
            fez b2 = d.b(appBrandLaunchReferrer);
            fds c2 = d.c(appBrandLaunchReferrer);
            fcc fcc = new fcc();
            fcc.MjZ = this.mRN.kEG.eix;
            fcc.KSa = this.mRN.pkgVersion;
            fcc.Scene = this.mRN.mRM.scene;
            fcc.MqE = this.mRN.kEG.kHw;
            fcc.MqD = 1;
            fcc.MqC = this.mRN.mRM.ecU;
            String str = null;
            if (1173 == this.mRN.mRM.scene) {
                str = com.tencent.mm.plugin.appbrand.openmaterial.model.a.ado(this.mRN.kEG.ldR);
            }
            acc acc = new acc();
            acc.dUS = this.mRN.mRM.scene;
            acc.LmF = this.mRN.kEG.cyz == b.PRE_RENDER;
            acc.LmG = 1;
            new com.tencent.mm.plugin.appbrand.launching.a.b(this.mRN.kEG.appId, false, fcc, b2, c2, this.mRN.cym, this.mRN.lKh, this.mRN.ldW, "", this.mRN.kEG.kHI, str, acc).bNW();
            AppMethodBeat.o(47113);
        }

        public UpdateTask(LaunchCheckParams launchCheckParams) {
            this.mRN = launchCheckParams;
        }

        UpdateTask(Parcel parcel) {
            AppMethodBeat.i(47114);
            f(parcel);
            AppMethodBeat.o(47114);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(47115);
            this.mRN = (LaunchCheckParams) parcel.readParcelable(LaunchCheckParams.class.getClassLoader());
            AppMethodBeat.o(47115);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(47116);
            parcel.writeParcelable(this.mRN, i2);
            AppMethodBeat.o(47116);
        }

        static {
            AppMethodBeat.i(47117);
            AppMethodBeat.o(47117);
        }
    }

    public static final class LaunchCheckParams implements Parcelable {
        public static final Parcelable.Creator<LaunchCheckParams> CREATOR = new Parcelable.Creator<LaunchCheckParams>() {
            /* class com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.LaunchCheckParams.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ LaunchCheckParams[] newArray(int i2) {
                return new LaunchCheckParams[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ LaunchCheckParams createFromParcel(Parcel parcel) {
                AppMethodBeat.i(47108);
                LaunchCheckParams launchCheckParams = new LaunchCheckParams(parcel);
                AppMethodBeat.o(47108);
                return launchCheckParams;
            }
        };
        final String cym;
        final AppBrandInitConfigWC kEG;
        final int lKh;
        final QualitySession ldW;
        final boolean loP = true;
        final AppBrandStatObject mRM;
        final int pkgVersion;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(47109);
            parcel.writeParcelable(this.kEG, i2);
            parcel.writeParcelable(this.mRM, i2);
            parcel.writeInt(this.pkgVersion);
            parcel.writeInt(this.lKh);
            parcel.writeString(this.cym);
            parcel.writeParcelable(this.ldW, i2);
            AppMethodBeat.o(47109);
        }

        public LaunchCheckParams(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject, int i2, int i3, String str, QualitySession qualitySession) {
            this.kEG = appBrandInitConfigWC;
            this.mRM = appBrandStatObject;
            this.pkgVersion = i2;
            this.lKh = i3;
            this.cym = str;
            this.ldW = qualitySession;
        }

        LaunchCheckParams(Parcel parcel) {
            AppMethodBeat.i(47110);
            this.kEG = (AppBrandInitConfigWC) parcel.readParcelable(AppBrandInitConfigWC.class.getClassLoader());
            this.mRM = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
            this.pkgVersion = parcel.readInt();
            this.lKh = parcel.readInt();
            this.cym = parcel.readString();
            this.ldW = (QualitySession) parcel.readParcelable(QualitySession.class.getClassLoader());
            AppMethodBeat.o(47110);
        }

        static {
            AppMethodBeat.i(47111);
            AppMethodBeat.o(47111);
        }
    }
}
