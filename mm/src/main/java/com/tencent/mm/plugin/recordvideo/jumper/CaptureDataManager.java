package com.tencent.mm.plugin.recordvideo.jumper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class CaptureDataManager {
    public static CaptureDataManager BOb = new CaptureDataManager();
    public b BOa = null;
    private Bundle lpM = new Bundle();

    public interface a {
        void eJL();
    }

    public interface b {
        void a(Context context, CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle);

        void a(RecordMediaReportInfo recordMediaReportInfo, Bundle bundle);

        boolean a(Context context, Bundle bundle, a aVar);
    }

    private CaptureDataManager() {
        AppMethodBeat.i(101490);
        AppMethodBeat.o(101490);
    }

    static {
        AppMethodBeat.i(101494);
        AppMethodBeat.o(101494);
    }

    public final void a(b bVar) {
        this.BOa = bVar;
    }

    public final b hWJ() {
        return this.BOa;
    }

    public final void a(Context context, CaptureVideoNormalModel captureVideoNormalModel) {
        AppMethodBeat.i(101491);
        if (this.BOa == null || context == null) {
            Intent intent = new Intent();
            intent.putExtra("key_extra_data", this.lpM);
            intent.putExtra("KSEGMENTMEDIAINFO", captureVideoNormalModel);
            ((Activity) context).setResult(-1, intent);
            ((Activity) context).finish();
            AppMethodBeat.o(101491);
            return;
        }
        this.BOa.a(context, captureVideoNormalModel, this.lpM);
        this.lpM.clear();
        AppMethodBeat.o(101491);
    }

    public final boolean a(Context context, a aVar) {
        AppMethodBeat.i(101492);
        if (this.BOa != null) {
            boolean a2 = this.BOa.a(context, this.lpM, aVar);
            AppMethodBeat.o(101492);
            return a2;
        }
        AppMethodBeat.o(101492);
        return false;
    }

    public final void d(RecordMediaReportInfo recordMediaReportInfo) {
        AppMethodBeat.i(207038);
        if (this.BOa == null) {
            AppMethodBeat.o(207038);
            return;
        }
        this.BOa.a(recordMediaReportInfo, this.lpM);
        AppMethodBeat.o(207038);
    }

    public final void eJF() {
        AppMethodBeat.i(101493);
        this.lpM.clear();
        AppMethodBeat.o(101493);
    }

    public final Bundle getExtData() {
        return this.lpM;
    }

    public static class c implements b {
        @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
        public void a(Context context, CaptureVideoNormalModel captureVideoNormalModel, Bundle bundle) {
        }

        @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
        public boolean a(Context context, Bundle bundle, a aVar) {
            return false;
        }

        @Override // com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.b
        public final void a(RecordMediaReportInfo recordMediaReportInfo, Bundle bundle) {
        }
    }

    public static class CaptureVideoNormalModel implements Parcelable {
        public static final Parcelable.Creator<CaptureVideoNormalModel> CREATOR = new Parcelable.Creator<CaptureVideoNormalModel>() {
            /* class com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ CaptureVideoNormalModel[] newArray(int i2) {
                return new CaptureVideoNormalModel[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CaptureVideoNormalModel createFromParcel(Parcel parcel) {
                AppMethodBeat.i(101485);
                CaptureVideoNormalModel captureVideoNormalModel = new CaptureVideoNormalModel(parcel);
                AppMethodBeat.o(101485);
                return captureVideoNormalModel;
            }
        };
        public Boolean BOc;
        public Long BOd;
        public Boolean BOe;
        private RecordMediaReportInfo BOf;
        private List<String> BOg = new ArrayList();
        public String thumbPath;
        public String videoPath;

        public CaptureVideoNormalModel(Boolean bool, String str, String str2, Long l, Boolean bool2, RecordMediaReportInfo recordMediaReportInfo) {
            AppMethodBeat.i(207036);
            this.BOc = bool;
            this.videoPath = str;
            this.thumbPath = str2;
            this.BOd = l;
            this.BOe = bool2;
            this.BOf = recordMediaReportInfo;
            AppMethodBeat.o(207036);
        }

        public final Boolean eJG() {
            return this.BOc;
        }

        public final String getVideoPath() {
            return this.videoPath;
        }

        public final String aQn() {
            return this.thumbPath;
        }

        public final Long eJH() {
            return this.BOd;
        }

        public final Boolean eJI() {
            return this.BOe;
        }

        public final RecordMediaReportInfo eJJ() {
            AppMethodBeat.i(101486);
            if (this.BOf == null) {
                RecordMediaReportInfo recordMediaReportInfo = new RecordMediaReportInfo();
                AppMethodBeat.o(101486);
                return recordMediaReportInfo;
            }
            RecordMediaReportInfo recordMediaReportInfo2 = this.BOf;
            AppMethodBeat.o(101486);
            return recordMediaReportInfo2;
        }

        public final void gf(List<String> list) {
            AppMethodBeat.i(207037);
            if (list != null) {
                this.BOg.addAll(list);
            }
            AppMethodBeat.o(207037);
        }

        public final List<String> eJK() {
            return this.BOg;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(101487);
            parcel.writeValue(this.BOc);
            parcel.writeString(this.videoPath);
            parcel.writeString(this.thumbPath);
            parcel.writeValue(this.BOd);
            parcel.writeValue(this.BOe);
            parcel.writeParcelable(this.BOf, i2);
            parcel.writeList(this.BOg);
            AppMethodBeat.o(101487);
        }

        protected CaptureVideoNormalModel(Parcel parcel) {
            AppMethodBeat.i(101488);
            this.BOc = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
            this.videoPath = parcel.readString();
            this.thumbPath = parcel.readString();
            this.BOd = (Long) parcel.readValue(Long.class.getClassLoader());
            this.BOe = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
            this.BOf = (RecordMediaReportInfo) parcel.readParcelable(RecordMediaReportInfo.class.getClassLoader());
            this.BOg = parcel.readArrayList(ArrayList.class.getClassLoader());
            AppMethodBeat.o(101488);
        }

        static {
            AppMethodBeat.i(101489);
            AppMethodBeat.o(101489);
        }
    }
}
