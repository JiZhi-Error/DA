package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u000b\f\r\u000eB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "IPC_AppBrandSearchUIParamsPrepareRequest", "IPC_AppBrandSearchUIParamsPrepareResult", "IPC_AppBrandSearchUIParamsPrepareTask", "plugin-appbrand-integration_release"})
public final class API_openWeAppSearch extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 647;
    public static final String NAME = "openWeAppSearch";
    @Deprecated
    public static final a mvd = new a((byte) 0);

    static {
        AppMethodBeat.i(50719);
        AppMethodBeat.o(50719);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class c<T> implements com.tencent.mm.ipcinvoker.d<IPC_AppBrandSearchUIParamsPrepareResult> {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lBv;
        final /* synthetic */ int lyo;
        final /* synthetic */ API_openWeAppSearch mvk;

        c(API_openWeAppSearch aPI_openWeAppSearch, com.tencent.mm.plugin.appbrand.d dVar, int i2) {
            this.mvk = aPI_openWeAppSearch;
            this.lBv = dVar;
            this.lyo = i2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(IPC_AppBrandSearchUIParamsPrepareResult iPC_AppBrandSearchUIParamsPrepareResult) {
            AppMethodBeat.i(50717);
            IPC_AppBrandSearchUIParamsPrepareResult iPC_AppBrandSearchUIParamsPrepareResult2 = iPC_AppBrandSearchUIParamsPrepareResult;
            switch (iPC_AppBrandSearchUIParamsPrepareResult2.resultCode) {
                case -1:
                    Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.lBv.getContext());
                    if (castActivityOrNull != null) {
                        Intent intent = iPC_AppBrandSearchUIParamsPrepareResult2.intent;
                        if (intent != null) {
                            intent.setExtrasClassLoader(JsapiPermissionWrapper.class.getClassLoader());
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(castActivityOrNull, bl.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$invoke$1", "onCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            castActivityOrNull.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(castActivityOrNull, "com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$invoke$1", "onCallback", "(Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            this.lBv.i(this.lyo, this.mvk.Zf("ok"));
                            AppMethodBeat.o(50717);
                            return;
                        }
                        new a(this, iPC_AppBrandSearchUIParamsPrepareResult2).invoke();
                        AppMethodBeat.o(50717);
                        return;
                    }
                    new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.API_openWeAppSearch.c.AnonymousClass1 */
                        final /* synthetic */ c mvl;

                        {
                            this.mvl = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(50716);
                            this.mvl.lBv.i(this.mvl.lyo, this.mvl.mvk.Zf("fail:internal error invalid android context"));
                            x xVar = x.SXb;
                            AppMethodBeat.o(50716);
                            return xVar;
                        }
                    }.invoke();
                    AppMethodBeat.o(50717);
                    return;
                case 0:
                    this.lBv.i(this.lyo, this.mvk.Zf("fail:internal error"));
                    AppMethodBeat.o(50717);
                    return;
                case 1:
                    this.lBv.i(this.lyo, this.mvk.Zf("fail:auth denied"));
                    break;
            }
            AppMethodBeat.o(50717);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$invoke$1$1$2"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ c mvl;
            final /* synthetic */ IPC_AppBrandSearchUIParamsPrepareResult mvm;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, IPC_AppBrandSearchUIParamsPrepareResult iPC_AppBrandSearchUIParamsPrepareResult) {
                super(0);
                this.mvl = cVar;
                this.mvm = iPC_AppBrandSearchUIParamsPrepareResult;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(50715);
                this.mvl.lBv.i(this.mvl.lyo, this.mvl.mvk.Zf("fail:internal error"));
                x xVar = x.SXb;
                AppMethodBeat.o(50715);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(50718);
        com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        if (dVar2 == null) {
            AppMethodBeat.o(50718);
        } else if (jSONObject == null) {
            AppMethodBeat.o(50718);
        } else {
            int optInt = jSONObject.optInt("scene", 201);
            IPC_AppBrandSearchUIParamsPrepareRequest iPC_AppBrandSearchUIParamsPrepareRequest = new IPC_AppBrandSearchUIParamsPrepareRequest();
            iPC_AppBrandSearchUIParamsPrepareRequest.mve = optInt;
            XIPCInvoker.a(MainProcessIPCService.dkO, iPC_AppBrandSearchUIParamsPrepareRequest, b.class, new c(this, dVar2, i2));
            AppMethodBeat.o(50718);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "searchScene", "", "getSearchScene", "()I", "setSearchScene", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
    static final class IPC_AppBrandSearchUIParamsPrepareRequest implements Parcelable {
        public static final Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareRequest> CREATOR = new b();
        public static final a mvf = new a((byte) 0);
        int mve;

        public IPC_AppBrandSearchUIParamsPrepareRequest() {
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public IPC_AppBrandSearchUIParamsPrepareRequest(Parcel parcel) {
            this();
            p.h(parcel, "source");
            AppMethodBeat.i(50704);
            this.mve = parcel.readInt();
            AppMethodBeat.o(50704);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(50703);
            p.h(parcel, "dest");
            parcel.writeInt(this.mve);
            AppMethodBeat.o(50703);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "plugin-appbrand-integration_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "plugin-appbrand-integration_release"})
        public static final class b implements Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareRequest> {
            b() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ IPC_AppBrandSearchUIParamsPrepareRequest createFromParcel(Parcel parcel) {
                AppMethodBeat.i(50702);
                p.h(parcel, "source");
                IPC_AppBrandSearchUIParamsPrepareRequest iPC_AppBrandSearchUIParamsPrepareRequest = new IPC_AppBrandSearchUIParamsPrepareRequest(parcel);
                AppMethodBeat.o(50702);
                return iPC_AppBrandSearchUIParamsPrepareRequest;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ IPC_AppBrandSearchUIParamsPrepareRequest[] newArray(int i2) {
                return new IPC_AppBrandSearchUIParamsPrepareRequest[i2];
            }
        }

        static {
            AppMethodBeat.i(50705);
            AppMethodBeat.o(50705);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "resultCode", "", "getResultCode", "()I", "setResultCode", "(I)V", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
    static final class IPC_AppBrandSearchUIParamsPrepareResult implements Parcelable {
        public static final Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareResult> CREATOR = new b();
        public static final a mvg = new a((byte) 0);
        Intent intent;
        int resultCode;

        public IPC_AppBrandSearchUIParamsPrepareResult() {
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public IPC_AppBrandSearchUIParamsPrepareResult(Parcel parcel) {
            this();
            p.h(parcel, "source");
            AppMethodBeat.i(50708);
            this.resultCode = parcel.readInt();
            this.intent = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
            AppMethodBeat.o(50708);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(50707);
            p.h(parcel, "dest");
            parcel.writeInt(this.resultCode);
            parcel.writeParcelable(this.intent, i2);
            AppMethodBeat.o(50707);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "RESULT_FATAL", "", "RESULT_OK", "RESULT_PRIVACY_DENIED", "plugin-appbrand-integration_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "plugin-appbrand-integration_release"})
        public static final class b implements Parcelable.Creator<IPC_AppBrandSearchUIParamsPrepareResult> {
            b() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ IPC_AppBrandSearchUIParamsPrepareResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(50706);
                p.h(parcel, "source");
                IPC_AppBrandSearchUIParamsPrepareResult iPC_AppBrandSearchUIParamsPrepareResult = new IPC_AppBrandSearchUIParamsPrepareResult(parcel);
                AppMethodBeat.o(50706);
                return iPC_AppBrandSearchUIParamsPrepareResult;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ IPC_AppBrandSearchUIParamsPrepareResult[] newArray(int i2) {
                return new IPC_AppBrandSearchUIParamsPrepareResult[i2];
            }
        }

        static {
            AppMethodBeat.i(50709);
            AppMethodBeat.o(50709);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    static final class b implements com.tencent.mm.ipcinvoker.b<IPC_AppBrandSearchUIParamsPrepareRequest, IPC_AppBrandSearchUIParamsPrepareResult> {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"performCallback", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "invoke"})
        static final class a extends q implements kotlin.g.a.b<IPC_AppBrandSearchUIParamsPrepareResult, x> {
            final /* synthetic */ com.tencent.mm.ipcinvoker.d kFf;
            final /* synthetic */ PBool mvh;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(PBool pBool, com.tencent.mm.ipcinvoker.d dVar) {
                super(1);
                this.mvh = pBool;
                this.kFf = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(IPC_AppBrandSearchUIParamsPrepareResult iPC_AppBrandSearchUIParamsPrepareResult) {
                AppMethodBeat.i(50710);
                a(iPC_AppBrandSearchUIParamsPrepareResult);
                x xVar = x.SXb;
                AppMethodBeat.o(50710);
                return xVar;
            }

            public final void a(IPC_AppBrandSearchUIParamsPrepareResult iPC_AppBrandSearchUIParamsPrepareResult) {
                AppMethodBeat.i(50711);
                p.h(iPC_AppBrandSearchUIParamsPrepareResult, "result");
                if (this.mvh.value) {
                    AppMethodBeat.o(50711);
                    return;
                }
                this.kFf.bn(iPC_AppBrandSearchUIParamsPrepareResult);
                this.mvh.value = true;
                AppMethodBeat.o(50711);
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPC_AppBrandSearchUIParamsPrepareRequest iPC_AppBrandSearchUIParamsPrepareRequest, com.tencent.mm.ipcinvoker.d<IPC_AppBrandSearchUIParamsPrepareResult> dVar) {
            AppMethodBeat.i(50714);
            IPC_AppBrandSearchUIParamsPrepareRequest iPC_AppBrandSearchUIParamsPrepareRequest2 = iPC_AppBrandSearchUIParamsPrepareRequest;
            if (iPC_AppBrandSearchUIParamsPrepareRequest2 == null) {
                AppMethodBeat.o(50714);
            } else if (dVar == null) {
                AppMethodBeat.o(50714);
            } else {
                PBool pBool = new PBool();
                a aVar = new a(pBool, dVar);
                ((i) g.af(i.class)).a(MMApplicationContext.getContext(), new RunnableC0704b(pBool, iPC_AppBrandSearchUIParamsPrepareRequest2, aVar));
                com.tencent.mm.kernel.b aAg = g.aAg();
                p.g(aAg, "MMKernel.network()");
                aAg.azz().a(2957, new c(pBool, aVar));
                AppMethodBeat.o(50714);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.API_openWeAppSearch$b$b  reason: collision with other inner class name */
        static final class RunnableC0704b implements Runnable {
            final /* synthetic */ PBool mvh;
            final /* synthetic */ IPC_AppBrandSearchUIParamsPrepareRequest mvi;
            final /* synthetic */ a mvj;

            RunnableC0704b(PBool pBool, IPC_AppBrandSearchUIParamsPrepareRequest iPC_AppBrandSearchUIParamsPrepareRequest, a aVar) {
                this.mvh = pBool;
                this.mvi = iPC_AppBrandSearchUIParamsPrepareRequest;
                this.mvj = aVar;
            }

            public final void run() {
                AppMethodBeat.i(50712);
                if (this.mvh.value) {
                    AppMethodBeat.o(50712);
                    return;
                }
                com.tencent.mm.plugin.appbrand.c.a aVar = com.tencent.mm.plugin.appbrand.c.a.INSTANCE;
                Intent M = com.tencent.mm.plugin.appbrand.c.a.M(MMApplicationContext.getContext(), this.mvi.mve);
                a aVar2 = this.mvj;
                IPC_AppBrandSearchUIParamsPrepareResult iPC_AppBrandSearchUIParamsPrepareResult = new IPC_AppBrandSearchUIParamsPrepareResult();
                M.setExtrasClassLoader(JsapiPermissionWrapper.class.getClassLoader());
                iPC_AppBrandSearchUIParamsPrepareResult.resultCode = -1;
                iPC_AppBrandSearchUIParamsPrepareResult.intent = M;
                aVar2.a(iPC_AppBrandSearchUIParamsPrepareResult);
                AppMethodBeat.o(50712);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 3>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
        static final class c implements com.tencent.mm.ak.i {
            final /* synthetic */ PBool mvh;
            final /* synthetic */ a mvj;

            c(PBool pBool, a aVar) {
                this.mvh = pBool;
                this.mvj = aVar;
            }

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                AppMethodBeat.i(50713);
                if (this.mvh.value) {
                    AppMethodBeat.o(50713);
                    return;
                }
                com.tencent.mm.kernel.c.a af = g.af(i.class);
                p.g(af, "MMKernel.service(IWebSearchPrivacyMgr::class.java)");
                if (!((i) af).fXw()) {
                    a aVar = this.mvj;
                    IPC_AppBrandSearchUIParamsPrepareResult iPC_AppBrandSearchUIParamsPrepareResult = new IPC_AppBrandSearchUIParamsPrepareResult();
                    iPC_AppBrandSearchUIParamsPrepareResult.resultCode = 1;
                    aVar.a(iPC_AppBrandSearchUIParamsPrepareResult);
                }
                AppMethodBeat.o(50713);
            }
        }
    }
}
