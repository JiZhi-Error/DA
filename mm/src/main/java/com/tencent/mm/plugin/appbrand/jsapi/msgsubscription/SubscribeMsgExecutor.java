package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.util.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 92\u00020\u0001:\u00029:B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u000200H\u0016J*\u00101\u001a\u00020*2\u0006\u00102\u001a\u0002002\u0006\u00103\u001a\u0002002\u0006\u00104\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00105\u001a\u00020*H\u0016J\u001a\u00106\u001a\u00020*2\b\u00107\u001a\u0004\u0018\u00010\b2\u0006\u00108\u001a\u000200H\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR0\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/ISubscribeMsgCGIExecutor;", ch.COL_USERNAME, "", "eventListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "(Ljava/lang/String;)V", "buffers", "", "getBuffers", "()[B", "setBuffers", "([B)V", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getDispatcher", "()Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "setDispatcher", "(Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;)V", "getEventListener", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "setEventListener", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;)V", "value", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "subscribeMsgTmpItems", "getSubscribeMsgTmpItems", "()Ljava/util/List;", "setSubscribeMsgTmpItems", "(Ljava/util/List;)V", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "getUIData", "()Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "setUIData", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;)V", "dealWithCgiResult", "", "context", "Landroid/content/Context;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "describeContents", "", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "requestCgi", "writeToParcel", "dest", "flags", "Companion", "EventListener", "luggage-wechat-full-sdk_release"})
public final class SubscribeMsgExecutor implements ISubscribeMsgCGIExecutor {
    public static final Parcelable.Creator<SubscribeMsgExecutor> CREATOR = new b();
    public static final a mfU = new a((byte) 0);
    SubscribeMsgRequestDialogUiData jzq;
    c mfR;
    byte[] mfS;
    List<SubscribeMsgTmpItem> mfT;
    a.AbstractC0480a mfx;
    final String username;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onSubscribeMsgDone", "luggage-wechat-full-sdk_release"})
    public interface c {
        void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult);

        void c(SubscribeMsgRequestResult subscribeMsgRequestResult);
    }

    private SubscribeMsgExecutor(String str) {
        AppMethodBeat.i(50624);
        this.username = str;
        this.mfT = new ArrayList();
        this.mfx = a.mfw;
        AppMethodBeat.o(50624);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SubscribeMsgExecutor(String str, c cVar) {
        this(str);
        p.h(str, ch.COL_USERNAME);
        p.h(cVar, "eventListener");
        AppMethodBeat.i(50625);
        this.mfR = cVar;
        AppMethodBeat.o(50625);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SubscribeMsgExecutor(Parcel parcel) {
        this(String.valueOf(parcel.readString()));
        v vVar;
        p.h(parcel, "parcel");
        AppMethodBeat.i(50626);
        List<SubscribeMsgTmpItem> list = this.mfT;
        ArrayList createTypedArrayList = parcel.createTypedArrayList(SubscribeMsgTmpItem.CREATOR);
        if (createTypedArrayList != null) {
            vVar = createTypedArrayList;
        } else {
            vVar = v.SXr;
        }
        list.addAll(vVar);
        this.mfS = new byte[parcel.readInt()];
        parcel.readByteArray(this.mfS);
        this.jzq = (SubscribeMsgRequestDialogUiData) parcel.readParcelable(SubscribeMsgRequestDialogUiData.class.getClassLoader());
        AppMethodBeat.o(50626);
    }

    @Override // com.tencent.mm.msgsubscription.a.b.c
    public final void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
        AppMethodBeat.i(50622);
        p.h(str, "errMsg");
        c cVar = this.mfR;
        if (cVar != null) {
            cVar.a(i2, i3, str, subscribeMsgRequestResult);
            AppMethodBeat.o(50622);
            return;
        }
        AppMethodBeat.o(50622);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int i3;
        AppMethodBeat.i(50623);
        if (parcel != null) {
            parcel.writeString(this.username);
        }
        if (parcel != null) {
            parcel.writeTypedList(this.mfT);
        }
        if (parcel != null) {
            byte[] bArr = this.mfS;
            if (bArr != null) {
                i3 = bArr.length;
            } else {
                i3 = 0;
            }
            parcel.writeInt(i3);
        }
        if (parcel != null) {
            byte[] bArr2 = this.mfS;
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            parcel.writeByteArray(bArr2);
        }
        if (parcel != null) {
            parcel.writeParcelable(this.jzq, i2);
            AppMethodBeat.o(50623);
            return;
        }
        AppMethodBeat.o(50623);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "luggage-wechat-full-sdk_release"})
    public static final class b implements Parcelable.Creator<SubscribeMsgExecutor> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SubscribeMsgExecutor createFromParcel(Parcel parcel) {
            AppMethodBeat.i(50621);
            p.h(parcel, "parcel");
            SubscribeMsgExecutor subscribeMsgExecutor = new SubscribeMsgExecutor(parcel);
            AppMethodBeat.o(50621);
            return subscribeMsgExecutor;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SubscribeMsgExecutor[] newArray(int i2) {
            return new SubscribeMsgExecutor[i2];
        }
    }

    static {
        AppMethodBeat.i(50627);
        AppMethodBeat.o(50627);
    }
}
