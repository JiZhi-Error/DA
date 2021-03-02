package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;

public class AdLandingPageChattingTask extends MainProcessTask {
    public static final Parcelable.Creator<AdLandingPageChattingTask> CREATOR = new Parcelable.Creator<AdLandingPageChattingTask>() {
        /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AdLandingPageChattingTask[] newArray(int i2) {
            return new AdLandingPageChattingTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AdLandingPageChattingTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(96305);
            AdLandingPageChattingTask adLandingPageChattingTask = new AdLandingPageChattingTask(parcel);
            AppMethodBeat.o(96305);
            return adLandingPageChattingTask;
        }
    };
    public String lRW;
    public Runnable lyv;
    public String nickname;
    public String username;

    static /* synthetic */ boolean a(AdLandingPageChattingTask adLandingPageChattingTask) {
        AppMethodBeat.i(96311);
        boolean bDU = adLandingPageChattingTask.bDU();
        AppMethodBeat.o(96311);
        return bDU;
    }

    public AdLandingPageChattingTask() {
    }

    public AdLandingPageChattingTask(Parcel parcel) {
        AppMethodBeat.i(96306);
        f(parcel);
        AppMethodBeat.o(96306);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(96307);
        if (!g.aAf().hpY) {
            bDU();
            AppMethodBeat.o(96307);
            return;
        }
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.username);
        Log.d("MicroMsg.AdLandingPageChattingTask", "sessionFrom:%s,username:%s,nickname:%s", this.lRW, this.username, this.nickname);
        if (Kn == null || ((int) Kn.gMZ) == 0) {
            as asVar = new as(this.username);
            asVar.setType(0);
            asVar.setNickname(this.nickname);
            ((l) g.af(l.class)).aSN().ap(asVar);
            Log.i("MicroMsg.AdLandingPageChattingTask", "%s save to contact_table", this.username);
        }
        ((q) g.af(q.class)).c(this.username, new q.a() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageChattingTask.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.service.q.a
            public final void b(WxaAttributes wxaAttributes) {
                AppMethodBeat.i(96304);
                if (wxaAttributes == null) {
                    Log.w("MicroMsg.AdLandingPageChattingTask", "info is null, err");
                }
                AdLandingPageChattingTask.a(AdLandingPageChattingTask.this);
                AppMethodBeat.o(96304);
            }
        });
        AppMethodBeat.o(96307);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(96308);
        if (this.lyv != null) {
            this.lyv.run();
        }
        AppMethodBeat.o(96308);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(96309);
        this.lRW = parcel.readString();
        this.username = parcel.readString();
        this.nickname = parcel.readString();
        AppMethodBeat.o(96309);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(96310);
        parcel.writeString(this.lRW);
        parcel.writeString(this.username);
        parcel.writeString(this.nickname);
        AppMethodBeat.o(96310);
    }

    static {
        AppMethodBeat.i(96312);
        AppMethodBeat.o(96312);
    }
}
