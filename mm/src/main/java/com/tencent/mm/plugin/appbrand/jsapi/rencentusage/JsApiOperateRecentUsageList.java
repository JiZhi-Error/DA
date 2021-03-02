package com.tencent.mm.plugin.appbrand.jsapi.rencentusage;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.appusage.an;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.HashMap;
import java.util.NoSuchElementException;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.s;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "printW", "", "append", "Companion", "plugin-appbrand-integration_release"})
public final class JsApiOperateRecentUsageList extends d<c> {
    public static final int CTRL_INDEX = 854;
    public static final String NAME = "operateRecentUsageList";
    public static final Companion moE = new Companion((byte) 0);

    static {
        AppMethodBeat.i(228502);
        AppMethodBeat.o(228502);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class a<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ c lUh;
        final /* synthetic */ int lyo;
        final /* synthetic */ JsApiOperateRecentUsageList moU;

        a(JsApiOperateRecentUsageList jsApiOperateRecentUsageList, c cVar, int i2) {
            this.moU = jsApiOperateRecentUsageList;
            this.lUh = cVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            AppMethodBeat.i(228498);
            Companion.Result result = (Companion.Result) obj;
            if (result.success) {
                this.lUh.i(this.lyo, this.moU.n("ok", ae.g(s.U(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, Integer.valueOf(result.moQ.value)))));
                AppMethodBeat.o(228498);
                return;
            }
            this.lUh.i(this.lyo, this.moU.n(JsApiOperateRecentUsageList.aaH("fail:" + result.errorMsg), ae.g(s.U(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, Integer.valueOf(result.moQ.value)))));
            AppMethodBeat.o(228498);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        AppMethodBeat.i(228499);
        c cVar2 = cVar;
        if (cVar2 == null) {
            AppMethodBeat.o(228499);
        } else if (jSONObject == null) {
            AppMethodBeat.o(228499);
        } else {
            Log.i("MicroMsg.operateRecentUsageList", "data = ".concat(String.valueOf(jSONObject)));
            HashMap g2 = ae.g(s.U(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, Integer.valueOf(Companion.b.FAIL_OTHER.value)));
            int optInt = jSONObject.optInt("actionType", -1);
            Companion.a[] values = Companion.a.values();
            int length = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z = true;
                    break;
                }
                if (values[i3].type == optInt) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    z = false;
                    break;
                }
                i3++;
            }
            if (z) {
                cVar2.i(i2, n(dF("fail:illegal actionType", ":".concat(String.valueOf(optInt))), g2));
                AppMethodBeat.o(228499);
                return;
            }
            String optString = jSONObject.optString(ch.COL_USERNAME, "");
            String str = optString;
            if (str == null || n.aL(str)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                cVar2.i(i2, n(aaH("fail:username is empty"), g2));
                AppMethodBeat.o(228499);
                return;
            }
            String optString2 = jSONObject.optString("appId", "");
            String str2 = optString2;
            if (str2 == null || n.aL(str2)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                cVar2.i(i2, n(aaH("fail:appId is empty"), g2));
                AppMethodBeat.o(228499);
                return;
            }
            int optInt2 = jSONObject.optInt("versionType", -1);
            if (optInt2 == -1) {
                cVar2.i(i2, n(aaH("fail:versionType is empty"), g2));
                AppMethodBeat.o(228499);
                return;
            }
            String str3 = MainProcessIPCService.dkO;
            Companion.a.C0701a aVar = Companion.a.moJ;
            Companion.a xn = Companion.a.C0701a.xn(optInt);
            p.g(optString, ch.COL_USERNAME);
            p.g(optString2, "appId");
            h.a(str3, new Companion.Parameter(xn, optString, optString2, optInt2), Companion.c.class, new a(this, cVar2, i2));
            AppMethodBeat.o(228499);
        }
    }

    static /* synthetic */ String aaH(String str) {
        AppMethodBeat.i(228501);
        String dF = dF(str, "");
        AppMethodBeat.o(228501);
        return dF;
    }

    private static String dF(String str, String str2) {
        AppMethodBeat.i(228500);
        Log.w("MicroMsg.operateRecentUsageList", str + str2);
        AppMethodBeat.o(228500);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "ActionType", "ErrorCode", "Parameter", "Result", "Task", "plugin-appbrand-integration_release"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "REMOVE_FROM_RECENT_USAGE_LIST", "ADD_TO_MY_COLLECTION", "REMOVE_FROM_MY_COLLECTION", "Companion", "plugin-appbrand-integration_release"})
        public enum a {
            REMOVE_FROM_RECENT_USAGE_LIST(0),
            ADD_TO_MY_COLLECTION(1),
            REMOVE_FROM_MY_COLLECTION(2);
            
            public static final C0701a moJ = new C0701a((byte) 0);
            final int type;

            public static a valueOf(String str) {
                AppMethodBeat.i(228475);
                a aVar = (a) Enum.valueOf(a.class, str);
                AppMethodBeat.o(228475);
                return aVar;
            }

            private a(int i2) {
                this.type = i2;
            }

            static {
                AppMethodBeat.i(228473);
                AppMethodBeat.o(228473);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType$Companion;", "", "()V", "obtain", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "type", "", "plugin-appbrand-integration_release"})
            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList$Companion$a$a  reason: collision with other inner class name */
            public static final class C0701a {
                private C0701a() {
                }

                public /* synthetic */ C0701a(byte b2) {
                    this();
                }

                public static a xn(int i2) {
                    AppMethodBeat.i(228472);
                    a[] values = a.values();
                    for (a aVar : values) {
                        if (aVar.type == i2) {
                            AppMethodBeat.o(228472);
                            return aVar;
                        }
                    }
                    NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
                    AppMethodBeat.o(228472);
                    throw noSuchElementException;
                }
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OK", "FAIL_OTHER", "FAIL_ADD_STAR_REACHED_MAXIMUM_LIMIT", "FAIL_ADD_STAR_BLOCKED", "plugin-appbrand-integration_release"})
        public enum b {
            OK(0),
            FAIL_OTHER(1),
            FAIL_ADD_STAR_REACHED_MAXIMUM_LIMIT(2),
            FAIL_ADD_STAR_BLOCKED(3);
            
            final int value;

            public static b valueOf(String str) {
                AppMethodBeat.i(228478);
                b bVar = (b) Enum.valueOf(b.class, str);
                AppMethodBeat.o(228478);
                return bVar;
            }

            private b(int i2) {
                this.value = i2;
            }

            static {
                AppMethodBeat.i(228476);
                AppMethodBeat.o(228476);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J\t\u0010\u0014\u001a\u00020\nHÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\nHÖ\u0001J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "success", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "", "(ZLcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;Ljava/lang/String;)V", "getErrorCode", "()Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ErrorCode;", "getErrorMsg", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "plugin-appbrand-integration_release"})
        public static final class Result implements Parcelable {
            public static final Parcelable.Creator<Result> CREATOR = new b();
            private static final Result moR = new Result(true, b.OK);
            private static final Result moS = new Result(false, b.FAIL_OTHER);
            public static final a moT = new a((byte) 0);
            final String errorMsg;
            final b moQ;
            final boolean success;

            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
                if (kotlin.g.b.p.j(r3.errorMsg, r4.errorMsg) != false) goto L_0x0028;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean equals(java.lang.Object r4) {
                /*
                    r3 = this;
                    r2 = 228495(0x37c8f, float:3.2019E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    if (r3 == r4) goto L_0x0028
                    boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList.Companion.Result
                    if (r0 == 0) goto L_0x002d
                    com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList$Companion$Result r4 = (com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList.Companion.Result) r4
                    boolean r0 = r3.success
                    boolean r1 = r4.success
                    if (r0 != r1) goto L_0x002d
                    com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList$Companion$b r0 = r3.moQ
                    com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList$Companion$b r1 = r4.moQ
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x002d
                    java.lang.String r0 = r3.errorMsg
                    java.lang.String r1 = r4.errorMsg
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x002d
                L_0x0028:
                    r0 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                L_0x002c:
                    return r0
                L_0x002d:
                    r0 = 0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    goto L_0x002c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList.Companion.Result.equals(java.lang.Object):boolean");
            }

            public final int hashCode() {
                int i2 = 0;
                AppMethodBeat.i(228494);
                boolean z = this.success;
                if (z) {
                    z = true;
                }
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = z ? 1 : 0;
                int i6 = i3 * 31;
                b bVar = this.moQ;
                int hashCode = ((bVar != null ? bVar.hashCode() : 0) + i6) * 31;
                String str = this.errorMsg;
                if (str != null) {
                    i2 = str.hashCode();
                }
                int i7 = hashCode + i2;
                AppMethodBeat.o(228494);
                return i7;
            }

            public final String toString() {
                AppMethodBeat.i(228493);
                String str = "Result(success=" + this.success + ", errorCode=" + this.moQ + ", errorMsg=" + this.errorMsg + ")";
                AppMethodBeat.o(228493);
                return str;
            }

            private /* synthetic */ Result(boolean z, b bVar) {
                this(z, bVar, "");
                AppMethodBeat.i(228490);
                AppMethodBeat.o(228490);
            }

            public Result(boolean z, b bVar, String str) {
                p.h(bVar, OpenSDKTool4Assistant.EXTRA_ERROR_CODE);
                p.h(str, OpenSDKTool4Assistant.EXTRA_ERROR_MSG);
                AppMethodBeat.i(228489);
                this.success = z;
                this.moQ = bVar;
                this.errorMsg = str;
                AppMethodBeat.o(228489);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public Result(Parcel parcel) {
                this(parcel.readByte() != 0, b.valueOf(String.valueOf(parcel.readString())), String.valueOf(parcel.readString()));
                p.h(parcel, "parcel");
                AppMethodBeat.i(228491);
                AppMethodBeat.o(228491);
            }

            public final void writeToParcel(Parcel parcel, int i2) {
                AppMethodBeat.i(228488);
                p.h(parcel, "parcel");
                parcel.writeByte(this.success ? (byte) 1 : 0);
                parcel.writeString(this.moQ.name());
                parcel.writeString(this.errorMsg);
                AppMethodBeat.o(228488);
            }

            public final int describeContents() {
                return 0;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "FAIL", "getFAIL", "()Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "OK", "getOK", "plugin-appbrand-integration_release"})
            public static final class a {
                private a() {
                }

                public /* synthetic */ a(byte b2) {
                    this();
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "plugin-appbrand-integration_release"})
            public static final class b implements Parcelable.Creator<Result> {
                b() {
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ Result createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(228487);
                    p.h(parcel, "parcel");
                    Result result = new Result(parcel);
                    AppMethodBeat.o(228487);
                    return result;
                }

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ Result[] newArray(int i2) {
                    return new Result[i2];
                }
            }

            static {
                AppMethodBeat.i(228492);
                AppMethodBeat.o(228492);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u000bHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u000bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "actionType", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", ch.COL_USERNAME, "", "appId", "versionType", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;Ljava/lang/String;Ljava/lang/String;I)V", "getActionType", "()Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$ActionType;", "getAppId", "()Ljava/lang/String;", "getUsername", "getVersionType", "()I", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
        public static final class Parameter implements Parcelable {
            public static final a CREATOR = new a((byte) 0);
            final String appId;
            final int iOo;
            final a moP;
            final String username;

            static {
                AppMethodBeat.i(228483);
                AppMethodBeat.o(228483);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
                if (r3.iOo == r4.iOo) goto L_0x0032;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean equals(java.lang.Object r4) {
                /*
                    r3 = this;
                    r2 = 228486(0x37c86, float:3.20177E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    if (r3 == r4) goto L_0x0032
                    boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList.Companion.Parameter
                    if (r0 == 0) goto L_0x0037
                    com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList$Companion$Parameter r4 = (com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList.Companion.Parameter) r4
                    com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList$Companion$a r0 = r3.moP
                    com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList$Companion$a r1 = r4.moP
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x0037
                    java.lang.String r0 = r3.username
                    java.lang.String r1 = r4.username
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x0037
                    java.lang.String r0 = r3.appId
                    java.lang.String r1 = r4.appId
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x0037
                    int r0 = r3.iOo
                    int r1 = r4.iOo
                    if (r0 != r1) goto L_0x0037
                L_0x0032:
                    r0 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                L_0x0036:
                    return r0
                L_0x0037:
                    r0 = 0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    goto L_0x0036
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiOperateRecentUsageList.Companion.Parameter.equals(java.lang.Object):boolean");
            }

            public final int hashCode() {
                int i2 = 0;
                AppMethodBeat.i(228485);
                a aVar = this.moP;
                int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
                String str = this.username;
                int hashCode2 = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
                String str2 = this.appId;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                int i3 = ((hashCode2 + i2) * 31) + this.iOo;
                AppMethodBeat.o(228485);
                return i3;
            }

            public final String toString() {
                AppMethodBeat.i(228484);
                String str = "Parameter(actionType=" + this.moP + ", username=" + this.username + ", appId=" + this.appId + ", versionType=" + this.iOo + ")";
                AppMethodBeat.o(228484);
                return str;
            }

            public Parameter(a aVar, String str, String str2, int i2) {
                p.h(aVar, "actionType");
                p.h(str, ch.COL_USERNAME);
                p.h(str2, "appId");
                AppMethodBeat.i(228481);
                this.moP = aVar;
                this.username = str;
                this.appId = str2;
                this.iOo = i2;
                AppMethodBeat.o(228481);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public Parameter(Parcel parcel) {
                this(a.valueOf(String.valueOf(parcel.readString())), String.valueOf(parcel.readString()), String.valueOf(parcel.readString()), parcel.readInt());
                p.h(parcel, "parcel");
                AppMethodBeat.i(228482);
                AppMethodBeat.o(228482);
            }

            public final void writeToParcel(Parcel parcel, int i2) {
                AppMethodBeat.i(228480);
                p.h(parcel, "parcel");
                parcel.writeString(this.moP.name());
                parcel.writeString(this.username);
                parcel.writeString(this.appId);
                parcel.writeInt(this.iOo);
                AppMethodBeat.o(228480);
            }

            public final int describeContents() {
                return 0;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "plugin-appbrand-integration_release"})
            public static final class a implements Parcelable.Creator<Parameter> {
                private a() {
                }

                public /* synthetic */ a(byte b2) {
                    this();
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ Parameter createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(228479);
                    p.h(parcel, "parcel");
                    Parameter parameter = new Parameter(parcel);
                    AppMethodBeat.o(228479);
                    return parameter;
                }

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ Parameter[] newArray(int i2) {
                    return new Parameter[i2];
                }
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Task;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Parameter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiOperateRecentUsageList$Companion$Result;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
        public static final class c implements com.tencent.mm.ipcinvoker.b<Parameter, Result> {
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ipcinvoker.b
            public final /* synthetic */ void invoke(Parameter parameter, com.tencent.mm.ipcinvoker.d<Result> dVar) {
                AppMethodBeat.i(228497);
                Parameter parameter2 = parameter;
                if (parameter2 == null) {
                    AppMethodBeat.o(228497);
                } else if (dVar == null) {
                    AppMethodBeat.o(228497);
                } else {
                    switch (b.$EnumSwitchMapping$0[parameter2.moP.ordinal()]) {
                        case 1:
                            Log.i("MicroMsg.operateRecentUsageList", "REMOVE_FROM_RECENT_USAGE_LIST  appId=" + parameter2.appId + "  versionType=" + parameter2.iOo);
                            an.t(parameter2.username, parameter2.appId, parameter2.iOo);
                            Result.a aVar = Result.moT;
                            dVar.bn(Result.moR);
                            AppMethodBeat.o(228497);
                            return;
                        case 2:
                            Log.i("MicroMsg.operateRecentUsageList", "ADD_TO_MY_COLLECTION   username=" + parameter2.username + "  versionType=" + parameter2.iOo);
                            switch (((u) com.tencent.mm.plugin.appbrand.app.n.W(u.class)).bk(parameter2.username, parameter2.iOo)) {
                                case -3:
                                    dVar.bn(new Result(false, b.FAIL_ADD_STAR_BLOCKED, "action be blocked"));
                                    AppMethodBeat.o(228497);
                                    return;
                                case -2:
                                    dVar.bn(new Result(false, b.FAIL_ADD_STAR_REACHED_MAXIMUM_LIMIT, "star app's count reached maximum limit"));
                                    AppMethodBeat.o(228497);
                                    return;
                                case -1:
                                    Result.a aVar2 = Result.moT;
                                    dVar.bn(Result.moS);
                                    AppMethodBeat.o(228497);
                                    return;
                                case 0:
                                    Result.a aVar3 = Result.moT;
                                    dVar.bn(Result.moR);
                                    AppMethodBeat.o(228497);
                                    return;
                                default:
                                    Result.a aVar4 = Result.moT;
                                    dVar.bn(Result.moS);
                                    AppMethodBeat.o(228497);
                                    return;
                            }
                        case 3:
                            Log.i("MicroMsg.operateRecentUsageList", "REMOVE_FROM_MY_COLLECTION username=" + parameter2.username + "  versionType=" + parameter2.iOo);
                            if (!((u) com.tencent.mm.plugin.appbrand.app.n.W(u.class)).bl(parameter2.username, parameter2.iOo)) {
                                Result.a aVar5 = Result.moT;
                                dVar.bn(Result.moS);
                                break;
                            } else {
                                Result.a aVar6 = Result.moT;
                                dVar.bn(Result.moR);
                                AppMethodBeat.o(228497);
                                return;
                            }
                    }
                    AppMethodBeat.o(228497);
                }
            }
        }
    }
}
