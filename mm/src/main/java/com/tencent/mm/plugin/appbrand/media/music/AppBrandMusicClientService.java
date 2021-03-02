package com.tencent.mm.plugin.appbrand.media.music;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.media.music.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class AppBrandMusicClientService {
    public static AppBrandMusicClientService ncV = new AppBrandMusicClientService();
    public HashMap<String, a> ncU = new HashMap<>();
    public volatile String ncW = "";

    public interface a {
        void bxf();

        void onStop();
    }

    static {
        AppMethodBeat.i(145815);
        AppMethodBeat.o(145815);
    }

    private AppBrandMusicClientService() {
        AppMethodBeat.i(145813);
        AppMethodBeat.o(145813);
    }

    public static boolean acC(String str) {
        AppMethodBeat.i(145814);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(145814);
            return false;
        }
        IPCQueryPlaying iPCQueryPlaying = new IPCQueryPlaying();
        iPCQueryPlaying.ncX = str;
        if (AppBrandMainProcessService.b(iPCQueryPlaying)) {
            boolean z = iPCQueryPlaying.gVd;
            AppMethodBeat.o(145814);
            return z;
        }
        AppMethodBeat.o(145814);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class IPCQueryPlaying extends MainProcessTask {
        public static final Parcelable.Creator<IPCQueryPlaying> CREATOR = new Parcelable.Creator<IPCQueryPlaying>() {
            /* class com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.IPCQueryPlaying.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ IPCQueryPlaying[] newArray(int i2) {
                return new IPCQueryPlaying[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ IPCQueryPlaying createFromParcel(Parcel parcel) {
                AppMethodBeat.i(145801);
                IPCQueryPlaying iPCQueryPlaying = new IPCQueryPlaying(parcel);
                AppMethodBeat.o(145801);
                return iPCQueryPlaying;
            }
        };
        private boolean gVd = false;
        private String ncX = null;

        IPCQueryPlaying() {
        }

        IPCQueryPlaying(Parcel parcel) {
            AppMethodBeat.i(145802);
            f(parcel);
            AppMethodBeat.o(145802);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(145804);
            this.ncX = parcel.readString();
            this.gVd = parcel.readByte() != 0;
            AppMethodBeat.o(145804);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(145805);
            parcel.writeString(this.ncX);
            parcel.writeByte((byte) (this.gVd ? 1 : 0));
            AppMethodBeat.o(145805);
        }

        static {
            AppMethodBeat.i(145806);
            AppMethodBeat.o(145806);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(145803);
            this.gVd = a.C0751a.bOR().acE(this.ncX);
            AppMethodBeat.o(145803);
        }
    }

    public static class StopBackgroundMusicTask extends MainProcessTask {
        public static final Parcelable.Creator<StopBackgroundMusicTask> CREATOR = new Parcelable.Creator<StopBackgroundMusicTask>() {
            /* class com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.StopBackgroundMusicTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StopBackgroundMusicTask[] newArray(int i2) {
                return new StopBackgroundMusicTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StopBackgroundMusicTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(145807);
                StopBackgroundMusicTask stopBackgroundMusicTask = new StopBackgroundMusicTask(parcel);
                AppMethodBeat.o(145807);
                return stopBackgroundMusicTask;
            }
        };
        public String appId;

        public StopBackgroundMusicTask() {
        }

        public StopBackgroundMusicTask(Parcel parcel) {
            AppMethodBeat.i(145808);
            f(parcel);
            AppMethodBeat.o(145808);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(145809);
            Log.i("MicroMsg.AppBrandMusicClientService", "runInMainProcess");
            String str = a.C0751a.bOR().ncY;
            if (!Util.isNullOrNil(str) && !str.equals(this.appId)) {
                Log.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, preAppId:%s, appId:%s", str, this.appId);
                bDU();
                AppMethodBeat.o(145809);
            } else if (!a.C0751a.bOR().acE(this.appId)) {
                Log.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, can't not stop, preAppId:%s, appId:%s", str, this.appId);
                bDU();
                AppMethodBeat.o(145809);
            } else {
                if (b.bej()) {
                    Log.i("MicroMsg.AppBrandMusicClientService", "stop music ok");
                } else {
                    Log.e("MicroMsg.AppBrandMusicClientService", "stop music fail");
                }
                bDU();
                AppMethodBeat.o(145809);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(145810);
            this.appId = parcel.readString();
            AppMethodBeat.o(145810);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(145811);
            parcel.writeString(this.appId);
            AppMethodBeat.o(145811);
        }

        static {
            AppMethodBeat.i(145812);
            AppMethodBeat.o(145812);
        }
    }
}
