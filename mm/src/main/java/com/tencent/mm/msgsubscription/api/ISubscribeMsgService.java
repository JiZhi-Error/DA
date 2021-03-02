package com.tencent.mm.msgsubscription.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.appbrand.jsapi.storage.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 72\u00020\u0001:\u0003789J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH&J\u001c\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J:\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u001c\u0010\u001c\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J:\u0010\u001c\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J*\u0010\u001d\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J(\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H&J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H&J2\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\"\u0010(\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010*H&J:\u0010+\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u001e2\b\b\u0002\u0010-\u001a\u00020\u00102\b\b\u0002\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u0010H&J \u00100\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u00101\u001a\u000202H&J\u0018\u00103\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0010H&J\u0010\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u000206H&¨\u0006:"}, hxF = {"Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService;", "Lcom/tencent/mm/kernel/service/IService;", "clickSubscribeMsgSpan", "", "context", "Landroid/content/Context;", "bizUsername", "", "url", "extra", "Landroid/os/Bundle;", "getLocalSubscribeList", ch.COL_USERNAME, "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getLocalSubscribeSwitchOpened", "", "getLocalSubscribeTemplate", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "templateId", f.NAME, "Lcom/tencent/mm/msgsubscription/storage/ISubscribeStorageManager;", "getSubscribeListByAppId", "appId", "subscribeUrl", "templateIdList", "", IssueStorage.COLUMN_EXT_INFO, "getSubscribeListByUsername", "getSubscribeStatus", "", "goToSettingManagerUI", "enterScene", "", "nickname", "isTemplateMsgSubscribed", "requestSubscribeMsgForResult", "scene", "requestCode", "bizAppId", "switchSubscribeStatus", "tmpItem", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "updateLocalSubscribeStatus", "subscribeMsgList", "switchOpened", "needUpdateSwitch", "needUpdateTimestamp", "updateLocalSubscribeStatusTimestamp", AppMeasurement.Param.TIMESTAMP, "", "updateLocalSwitchOpened", "updateSubscribeList", "updateRequest", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "Companion", "SubscribeStatusOpCallback", "SubscribeStatusResult", "plugin-comm_release"})
public interface ISubscribeMsgService extends com.tencent.mm.kernel.c.a {
    public static final Companion jyT = Companion.jyU;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusOpCallback;", "", "onError", "", "onUpdated", "templateId", "", "result", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "plugin-comm_release"})
    public interface b {
        void a(String str, c cVar);

        void onError();
    }

    boolean Rt(String str);

    void a(Context context, int i2, int i3, String str, Bundle bundle);

    void a(Context context, String str, String str2, Bundle bundle);

    void a(c cVar);

    void a(String str, a aVar);

    void a(String str, List<String> list, a aVar);

    void a(String str, List<SubscribeMsgTmpItem> list, boolean z, boolean z2, boolean z3);

    void b(String str, a aVar);

    SubscribeMsgTmpItem bF(String str, String str2);

    void g(String str, String str2, long j2);

    @l(hxD = {1, 1, 16})
    public static final class a {
        public static /* synthetic */ void a(ISubscribeMsgService iSubscribeMsgService, String str, List list) {
            AppMethodBeat.i(223227);
            iSubscribeMsgService.a(str, (List<SubscribeMsgTmpItem>) list, false, false, false);
            AppMethodBeat.o(223227);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\t\u0010\b¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$SubscribeStatusResult;", "", "isSubscribed", "", "isSwitchOpened", "(ZZ)V", "()Z", "setSubscribed", "(Z)V", "setSwitchOpened", "component1", "component2", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-comm_release"})
    public static final class c {
        public boolean jyX;
        public boolean jyY;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof c) {
                    c cVar = (c) obj;
                    if (!(this.jyX == cVar.jyX && this.jyY == cVar.jyY)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i2 = 1;
            boolean z = this.jyX;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = i3 * 31;
            boolean z2 = this.jyY;
            if (!z2) {
                i2 = z2 ? 1 : 0;
            }
            return i6 + i2;
        }

        public final String toString() {
            AppMethodBeat.i(223228);
            String str = "SubscribeStatusResult(isSubscribed=" + this.jyX + ", isSwitchOpened=" + this.jyY + ")";
            AppMethodBeat.o(223228);
            return str;
        }

        public c(boolean z, boolean z2) {
            this.jyX = z;
            this.jyY = z2;
        }

        public final void fY(boolean z) {
            this.jyX = z;
        }

        public final void fZ(boolean z) {
            this.jyY = z;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion;", "", "()V", "TAG", "", "SubscribeMsgListWrapper", "plugin-comm_release"})
    public static final class Companion {
        static final /* synthetic */ Companion jyU = new Companion();

        static {
            AppMethodBeat.i(223226);
            AppMethodBeat.o(223226);
        }

        private Companion() {
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001d\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper;", "Landroid/os/Parcelable;", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "subscribeSwitchOpened", "", "(Ljava/util/List;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getSubscribeMsgList", "()Ljava/util/List;", "setSubscribeMsgList", "(Ljava/util/List;)V", "getSubscribeSwitchOpened", "()Z", "setSubscribeSwitchOpened", "(Z)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "plugin-comm_release"})
        public static final class SubscribeMsgListWrapper implements Parcelable {
            public static final a CREATOR = new a((byte) 0);
            public List<SubscribeMsgTmpItem> jyV = new ArrayList();
            public boolean jyW;

            static {
                AppMethodBeat.i(223225);
                AppMethodBeat.o(223225);
            }

            public SubscribeMsgListWrapper(List<SubscribeMsgTmpItem> list, boolean z) {
                p.h(list, "subscribeMsgList");
                AppMethodBeat.i(223223);
                this.jyV.addAll(list);
                this.jyW = z;
                AppMethodBeat.o(223223);
            }

            public SubscribeMsgListWrapper(Parcel parcel) {
                com.tencent.mm.msgsubscription.d.a aVar;
                com.tencent.mm.msgsubscription.d.a aVar2;
                p.h(parcel, "parcel");
                AppMethodBeat.i(223224);
                try {
                    parcel.readTypedList(this.jyV, SubscribeMsgTmpItem.CREATOR);
                    this.jyW = parcel.readByte() != 0;
                    AppMethodBeat.o(223224);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SubscribeMsgListWrapper", e2, "alvinluo SubscribeMsgListWrapper read parcel exception and clear storage", new Object[0]);
                    b bVar = b.jza;
                    com.tencent.mm.msgsubscription.b.a Ru = b.Ru("name_biz");
                    if (!(Ru == null || (aVar2 = Ru.jzv) == null)) {
                        aVar2.biY();
                    }
                    b bVar2 = b.jza;
                    com.tencent.mm.msgsubscription.b.a Ru2 = b.Ru("name_wxa");
                    if (Ru2 == null || (aVar = Ru2.jzv) == null) {
                        AppMethodBeat.o(223224);
                        return;
                    }
                    aVar.biY();
                    AppMethodBeat.o(223224);
                }
            }

            public final void writeToParcel(Parcel parcel, int i2) {
                AppMethodBeat.i(223222);
                p.h(parcel, "parcel");
                parcel.writeTypedList(this.jyV);
                parcel.writeByte(this.jyW ? (byte) 1 : 0);
                AppMethodBeat.o(223222);
            }

            public final int describeContents() {
                return 0;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/msgsubscription/api/ISubscribeMsgService$Companion$SubscribeMsgListWrapper;", "plugin-comm_release"})
            public static final class a implements Parcelable.Creator<SubscribeMsgListWrapper> {
                private a() {
                }

                public /* synthetic */ a(byte b2) {
                    this();
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ SubscribeMsgListWrapper createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(223221);
                    p.h(parcel, "parcel");
                    SubscribeMsgListWrapper subscribeMsgListWrapper = new SubscribeMsgListWrapper(parcel);
                    AppMethodBeat.o(223221);
                    return subscribeMsgListWrapper;
                }

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ SubscribeMsgListWrapper[] newArray(int i2) {
                    return new SubscribeMsgListWrapper[i2];
                }
            }
        }
    }
}
