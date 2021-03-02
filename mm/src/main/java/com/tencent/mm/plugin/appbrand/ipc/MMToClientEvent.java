package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public class MMToClientEvent extends MainProcessTask {
    public static final Parcelable.Creator<MMToClientEvent> CREATOR = new Parcelable.Creator<MMToClientEvent>() {
        /* class com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MMToClientEvent[] newArray(int i2) {
            return new MMToClientEvent[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MMToClientEvent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134841);
            MMToClientEvent mMToClientEvent = new MMToClientEvent(parcel, (byte) 0);
            AppMethodBeat.o(134841);
            return mMToClientEvent;
        }
    };
    private static final HashMap<String, MMToClientEvent> lwS = new HashMap<>();
    private static final h<String, c> lwT = new h<>();
    public String appId;
    String config;
    int dCm;
    private f lqg;
    public int lwP;
    String lwQ;
    Object lwR;
    public int type;

    public static class a extends s {
        private static final int CTRL_INDEX = 109;
        private static final String NAME = "onAppConfig";
    }

    public static class b extends s {
        private static final int CTRL_INDEX = 152;
        private static final String NAME = "onContactMessageCountChange";
    }

    public interface c {
        void cq(Object obj);
    }

    /* synthetic */ MMToClientEvent(Parcel parcel, byte b2) {
        this(parcel);
    }

    private MMToClientEvent() {
    }

    private MMToClientEvent(Parcel parcel) {
        AppMethodBeat.i(134842);
        f(parcel);
        AppMethodBeat.o(134842);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(134843);
        switch (this.lwP) {
            case 1:
                e.a(this);
                AppMethodBeat.o(134843);
                return;
            case 2:
                e.b(this);
                break;
        }
        AppMethodBeat.o(134843);
    }

    static {
        AppMethodBeat.i(134851);
        AppMethodBeat.o(134851);
    }

    public static boolean isRegistered(String str) {
        AppMethodBeat.i(174745);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(174745);
            return false;
        } else if (lwS.get(str) != null) {
            AppMethodBeat.o(174745);
            return true;
        } else {
            AppMethodBeat.o(174745);
            return false;
        }
    }

    public static void e(f fVar) {
        AppMethodBeat.i(134844);
        if (fVar == null) {
            AppMethodBeat.o(134844);
            return;
        }
        MMToClientEvent mMToClientEvent = new MMToClientEvent();
        lwS.put(fVar.getAppId(), mMToClientEvent);
        mMToClientEvent.lwP = 1;
        mMToClientEvent.appId = fVar.getAppId();
        mMToClientEvent.lqg = fVar;
        AppBrandMainProcessService.a(mMToClientEvent);
        AppMethodBeat.o(134844);
    }

    public static void YY(String str) {
        AppMethodBeat.i(174746);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(174746);
            return;
        }
        MMToClientEvent mMToClientEvent = new MMToClientEvent();
        lwS.put(str, mMToClientEvent);
        mMToClientEvent.lwP = 1;
        mMToClientEvent.appId = str;
        AppBrandMainProcessService.a(mMToClientEvent);
        AppMethodBeat.o(174746);
    }

    public static void f(f fVar) {
        AppMethodBeat.i(134845);
        if (fVar == null) {
            AppMethodBeat.o(134845);
            return;
        }
        MMToClientEvent remove = lwS.remove(fVar.getAppId());
        if (remove == null) {
            AppMethodBeat.o(134845);
            return;
        }
        lwT.cN(fVar.getAppId());
        remove.lwP = 2;
        remove.appId = fVar.getAppId();
        remove.lqg = null;
        AppBrandMainProcessService.b(remove);
        AppMethodBeat.o(134845);
    }

    public static void YZ(String str) {
        AppMethodBeat.i(226649);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(226649);
            return;
        }
        MMToClientEvent remove = lwS.remove(str);
        if (remove == null) {
            AppMethodBeat.o(226649);
            return;
        }
        lwT.cN(str);
        remove.lwP = 2;
        remove.appId = str;
        AppBrandMainProcessService.b(remove);
        AppMethodBeat.o(226649);
    }

    public static void a(String str, c cVar) {
        AppMethodBeat.i(134846);
        if (cVar != null) {
            lwT.r(str, cVar);
        }
        AppMethodBeat.o(134846);
    }

    public static void b(String str, c cVar) {
        AppMethodBeat.i(134847);
        if (cVar != null) {
            lwT.J(str, cVar);
        }
        AppMethodBeat.o(134847);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(134848);
        switch (this.lwP) {
            case 3:
                if (this.lqg != null) {
                    a aVar = new a();
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", Integer.valueOf(this.type));
                    hashMap.put("data", this.config);
                    aVar.g(this.lqg).L(hashMap).bEo();
                    AppMethodBeat.o(134848);
                    return;
                }
                break;
            case 4:
                b bVar = new b();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("count", Integer.valueOf(this.dCm));
                hashMap2.put("data", this.config);
                bVar.g(this.lqg).L(hashMap2).bEo();
                AppMethodBeat.o(134848);
                return;
            case 5:
                if (this.appId != null && this.lwR != null) {
                    final String str = this.appId;
                    final Object obj = this.lwR;
                    com.tencent.f.h.RTc.b(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(134840);
                            h hVar = MMToClientEvent.lwT;
                            String str = str;
                            AnonymousClass1 r2 = new android.support.v4.e.c<c>() {
                                /* class com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.AnonymousClass1.AnonymousClass1 */

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // android.support.v4.e.c
                                public final /* synthetic */ void accept(c cVar) {
                                    AppMethodBeat.i(174744);
                                    c cVar2 = cVar;
                                    if (cVar2 != null) {
                                        cVar2.cq(obj);
                                    }
                                    AppMethodBeat.o(174744);
                                }
                            };
                            if (str == null) {
                                AppMethodBeat.o(134840);
                                return;
                            }
                            for (Object obj : hVar.cM(str)) {
                                r2.accept(obj);
                            }
                            AppMethodBeat.o(134840);
                        }
                    }, "MicroMsg.MMToClientEvent");
                    break;
                } else {
                    AppMethodBeat.o(134848);
                    return;
                }
                break;
        }
        AppMethodBeat.o(134848);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        Class<?> cls;
        AppMethodBeat.i(134849);
        this.lwP = parcel.readInt();
        this.appId = parcel.readString();
        this.type = parcel.readInt();
        this.config = parcel.readString();
        this.dCm = parcel.readInt();
        try {
            this.lwQ = parcel.readString();
            if (!Util.isNullOrNil(this.lwQ) && (cls = Class.forName(this.lwQ)) != null) {
                this.lwR = parcel.readParcelable(cls.getClassLoader());
            }
            AppMethodBeat.o(134849);
        } catch (Exception e2) {
            Log.v("MicroMsg.MMToClientEvent", "unparcel custom data e %s", e2);
            AppMethodBeat.o(134849);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(134850);
        parcel.writeInt(this.lwP);
        parcel.writeString(this.appId);
        parcel.writeInt(this.type);
        parcel.writeString(this.config);
        parcel.writeInt(this.dCm);
        if (!Util.isNullOrNil(this.lwQ) && this.lwR != null) {
            parcel.writeString(this.lwQ);
            parcel.writeParcelable((Parcelable) this.lwR, i2);
        }
        AppMethodBeat.o(134850);
    }
}
