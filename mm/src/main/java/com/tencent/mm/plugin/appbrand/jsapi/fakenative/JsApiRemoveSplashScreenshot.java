package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.ui.c.a.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "RemoveParams", "plugin-appbrand-integration_release"})
public final class JsApiRemoveSplashScreenshot extends d<c> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "removeSplashScreenshot";
    @Deprecated
    public static final a lUp = new a((byte) 0);

    static {
        AppMethodBeat.i(228409);
        AppMethodBeat.o(228409);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$RemoveParams;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
    static final class b<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<RemoveParams, IPCVoid> {
        public static final b lUq = new b();

        static {
            AppMethodBeat.i(228407);
            AppMethodBeat.o(228407);
        }

        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(RemoveParams removeParams, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(228406);
            RemoveParams removeParams2 = removeParams;
            if (removeParams2 != null) {
                String str = removeParams2.appId;
                int i2 = removeParams2.iOo;
                com.tencent.mm.plugin.appbrand.ui.c.a.b bVar = (com.tencent.mm.plugin.appbrand.ui.c.a.b) n.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class);
                if (bVar != null) {
                    com.tencent.mm.plugin.appbrand.ui.c.a.b.a(bVar, str, i2, (b.AbstractC0806b) null, 4);
                }
            }
            if (dVar != null) {
                com.tencent.mm.ipcinvoker.wx_extension.b.a.a(dVar);
                AppMethodBeat.o(228406);
                return;
            }
            AppMethodBeat.o(228406);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(228408);
        c cVar2 = cVar;
        if (cVar2 == null) {
            AppMethodBeat.o(228408);
            return;
        }
        e.a aVar = e.lUr;
        if (!e.a.a(cVar2)) {
            cVar2.i(i2, Zf("fail:not supported"));
            AppMethodBeat.o(228408);
            return;
        }
        String appId = cVar2.getAppId();
        p.g(appId, "env.appId");
        q runtime = cVar2.getRuntime();
        p.g(runtime, "env.runtime");
        com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new RemoveParams(appId, runtime.brf()), b.lUq, null);
        cVar2.i(i2, Zf("ok"));
        AppMethodBeat.o(228408);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiRemoveSplashScreenshot$RemoveParams;", "Landroid/os/Parcelable;", "appId", "", "versionType", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getVersionType", "()I", "component1", "component2", "copy", "describeContents", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-appbrand-integration_release"})
    static final class RemoveParams implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        final String appId;
        final int iOo;

        @l(hxD = {1, 1, 16})
        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(228399);
                p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
                RemoveParams removeParams = new RemoveParams(parcel.readString(), parcel.readInt());
                AppMethodBeat.o(228399);
                return removeParams;
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new RemoveParams[i2];
            }
        }

        static {
            AppMethodBeat.i(228405);
            AppMethodBeat.o(228405);
        }

        public final int describeContents() {
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            if (r3.iOo == r4.iOo) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 228403(0x37c33, float:3.20061E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x001e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.jsapi.fakenative.JsApiRemoveSplashScreenshot.RemoveParams
                if (r0 == 0) goto L_0x0023
                com.tencent.mm.plugin.appbrand.jsapi.fakenative.JsApiRemoveSplashScreenshot$RemoveParams r4 = (com.tencent.mm.plugin.appbrand.jsapi.fakenative.JsApiRemoveSplashScreenshot.RemoveParams) r4
                java.lang.String r0 = r3.appId
                java.lang.String r1 = r4.appId
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0023
                int r0 = r3.iOo
                int r1 = r4.iOo
                if (r0 != r1) goto L_0x0023
            L_0x001e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0022:
                return r0
            L_0x0023:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.fakenative.JsApiRemoveSplashScreenshot.RemoveParams.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(228402);
            String str = this.appId;
            int hashCode = ((str != null ? str.hashCode() : 0) * 31) + this.iOo;
            AppMethodBeat.o(228402);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(228401);
            String str = "RemoveParams(appId=" + this.appId + ", versionType=" + this.iOo + ")";
            AppMethodBeat.o(228401);
            return str;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(228404);
            p.h(parcel, "parcel");
            parcel.writeString(this.appId);
            parcel.writeInt(this.iOo);
            AppMethodBeat.o(228404);
        }

        public RemoveParams(String str, int i2) {
            p.h(str, "appId");
            AppMethodBeat.i(228400);
            this.appId = str;
            this.iOo = i2;
            AppMethodBeat.o(228400);
        }
    }
}
