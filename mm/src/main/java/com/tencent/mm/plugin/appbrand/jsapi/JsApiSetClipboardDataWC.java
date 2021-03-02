package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.z.o;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.secinforeport.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.nio.charset.Charset;

public final class JsApiSetClipboardDataWC extends o<s> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.z.o
    public final /* synthetic */ void c(s sVar, String str) {
        AppMethodBeat.i(45652);
        s sVar2 = sVar;
        if (!Util.isNullOrNil(str)) {
            String appId = sVar2.getAppId();
            w brh = sVar2.getRuntime().brh();
            if (brh == null || brh.getCurrentPage() == null) {
                AppMethodBeat.o(45652);
                return;
            }
            AppBrandMainProcessService.a(new ReportClipBoardTask(appId, brh.getCurrentPage().getCurrentUrl(), str.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)).length));
        }
        AppMethodBeat.o(45652);
    }

    static class ReportClipBoardTask extends MainProcessTask {
        public static final Parcelable.Creator<ReportClipBoardTask> CREATOR = new Parcelable.Creator<ReportClipBoardTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardDataWC.ReportClipBoardTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ReportClipBoardTask[] newArray(int i2) {
                return new ReportClipBoardTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ReportClipBoardTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45646);
                ReportClipBoardTask reportClipBoardTask = new ReportClipBoardTask(parcel);
                AppMethodBeat.o(45646);
                return reportClipBoardTask;
            }
        };
        private String lBI;
        private String mAppId;
        private int mLength;

        public ReportClipBoardTask(String str, String str2, int i2) {
            this.mAppId = str;
            this.lBI = str2;
            this.mLength = i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45647);
            a aVar = a.INSTANCE;
            a.N(this.mLength, this.mAppId, this.lBI);
            AppMethodBeat.o(45647);
        }

        public ReportClipBoardTask(Parcel parcel) {
            AppMethodBeat.i(45648);
            f(parcel);
            AppMethodBeat.o(45648);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(45649);
            this.mAppId = parcel.readString();
            this.lBI = parcel.readString();
            this.mLength = parcel.readInt();
            AppMethodBeat.o(45649);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45650);
            parcel.writeString(this.mAppId);
            parcel.writeString(this.lBI);
            parcel.writeInt(this.mLength);
            AppMethodBeat.o(45650);
        }

        static {
            AppMethodBeat.i(45651);
            AppMethodBeat.o(45651);
        }
    }
}
