package com.tencent.mm.plugin.appbrand.jsapi.scanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiScanCode extends d<c> {
    public static final int CTRL_INDEX = 148;
    public static final String NAME = "scanCode";
    private static volatile boolean mpG = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i2) {
        int[] iArr;
        AppMethodBeat.i(174883);
        final c cVar2 = cVar;
        if (mpG) {
            cVar2.i(i2, h("cancel", null));
            AppMethodBeat.o(174883);
            return;
        }
        mpG = true;
        Activity ay = cVar2.ay(Activity.class);
        if (ay == null) {
            cVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(174883);
            return;
        }
        f.aK(ay).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                int i4;
                int i5;
                String str = null;
                AppMethodBeat.i(174873);
                boolean unused = JsApiScanCode.mpG = false;
                if (i2 != (JsApiScanCode.this.hashCode() & 65535)) {
                    AppMethodBeat.o(174873);
                    return false;
                }
                switch (i3) {
                    case -1:
                        String str2 = "";
                        String encodeToString = Base64.encodeToString(new byte[0], 2);
                        if (intent != null) {
                            str2 = intent.getStringExtra("key_scan_result");
                            byte[] byteArrayExtra = intent.getByteArrayExtra("key_scan_result_raw");
                            if (byteArrayExtra != null) {
                                encodeToString = Base64.encodeToString(byteArrayExtra, 2);
                            }
                            str = intent.getStringExtra("key_scan_result_code_name");
                            i5 = e.d.bcV(str);
                            i4 = intent.getIntExtra("key_scan_result_code_version", 0);
                        } else {
                            i4 = 0;
                            i5 = 0;
                        }
                        final HashMap hashMap = new HashMap();
                        hashMap.put("charSet", ProtocolPackage.ServerEncoding);
                        hashMap.put("rawData", encodeToString);
                        hashMap.put("codeVersion", Integer.valueOf(i4));
                        if (i5 == 19 || i5 == 22) {
                            hashMap.put("result", i5 == 22 ? "" : str2);
                            hashMap.put("scanType", i5 == 22 ? "WX_CODE" : "QR_CODE");
                            if (!NetStatusUtil.isConnected(cVar2.getContext())) {
                                Log.i("MicroMsg.JsApiScanCode", "offline mode");
                                cVar2.i(i2, JsApiScanCode.this.n("ok", hashMap));
                                break;
                            } else {
                                Log.i("MicroMsg.JsApiScanCode", "online mode");
                                final GetA8KeyTask getA8KeyTask = new GetA8KeyTask();
                                getA8KeyTask.mpM = str2;
                                getA8KeyTask.dFL = i5;
                                getA8KeyTask.dFM = i4;
                                getA8KeyTask.mpO = new Runnable() {
                                    /* class com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(174872);
                                        getA8KeyTask.bDK();
                                        if (getA8KeyTask.actionCode == 26) {
                                            Uri parse = Uri.parse(getA8KeyTask.mpN);
                                            if (cVar2.getRuntime().bsC().username.equals(parse.getQueryParameter(ch.COL_USERNAME))) {
                                                hashMap.put("path", URLDecoder.decode(Util.nullAsNil(parse.getQueryParameter("path"))));
                                            }
                                        }
                                        cVar2.i(i2, JsApiScanCode.this.n("ok", hashMap));
                                        AppMethodBeat.o(174872);
                                    }
                                };
                                getA8KeyTask.bDJ();
                                AppBrandMainProcessService.a(getA8KeyTask);
                                break;
                            }
                        } else {
                            hashMap.put("result", str2);
                            hashMap.put("scanType", Util.nullAsNil(str));
                            cVar2.i(i2, JsApiScanCode.this.n("ok", hashMap));
                            AppMethodBeat.o(174873);
                            return true;
                        }
                    case 0:
                        cVar2.i(i2, JsApiScanCode.this.h("cancel", null));
                        break;
                    default:
                        cVar2.i(i2, JsApiScanCode.this.h("fail", null));
                        break;
                }
                AppMethodBeat.o(174873);
                return true;
            }
        });
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 1);
        intent.putExtra("key_show_scan_tips", false);
        intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
        intent.putExtra("key_set_result_after_scan", true);
        intent.putExtra("key_is_hide_right_btn", jSONObject.optBoolean("onlyFromCamera", false));
        intent.putExtra("key_for_jsapi_use", true);
        JSONArray optJSONArray = jSONObject.optJSONArray("scanType");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            iArr = new int[]{2, 4, 5, 1, 3};
        } else {
            int[] iArr2 = new int[optJSONArray.length()];
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString = optJSONArray.optString(i3);
                char c2 = 65535;
                switch (optString.hashCode()) {
                    case -993060056:
                        if (optString.equals("pdf417")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -952485970:
                        if (optString.equals("qrCode")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -334537568:
                        if (optString.equals("barCode")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 2003869675:
                        if (optString.equals("datamatrix")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        iArr2[i3] = 1;
                        break;
                    case 1:
                        iArr2[i3] = 2;
                        break;
                    case 2:
                        iArr2[i3] = 5;
                        break;
                    case 3:
                        iArr2[i3] = 4;
                        break;
                }
            }
            iArr = iArr2;
        }
        intent.putExtra("key_support_scan_code_type", iArr);
        intent.putExtra("key_enable_multi_code", false);
        intent.putExtra("key_scan_entry_scene", 4);
        com.tencent.mm.br.c.a((Context) ay, "scanner", ".ui.BaseScanUI", intent, hashCode() & 65535, false);
        AppMethodBeat.o(174883);
    }

    public static class GetA8KeyTask extends MainProcessTask {
        public static final Parcelable.Creator<GetA8KeyTask> CREATOR = new Parcelable.Creator<GetA8KeyTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode.GetA8KeyTask.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetA8KeyTask[] newArray(int i2) {
                return new GetA8KeyTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetA8KeyTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(174875);
                GetA8KeyTask getA8KeyTask = new GetA8KeyTask();
                getA8KeyTask.f(parcel);
                AppMethodBeat.o(174875);
                return getA8KeyTask;
            }
        };
        public int actionCode;
        public int dFL;
        public int dFM;
        public String mpM;
        public String mpN;
        public Runnable mpO;

        static /* synthetic */ boolean a(GetA8KeyTask getA8KeyTask) {
            AppMethodBeat.i(174880);
            boolean bDU = getA8KeyTask.bDU();
            AppMethodBeat.o(174880);
            return bDU;
        }

        static /* synthetic */ boolean b(GetA8KeyTask getA8KeyTask) {
            AppMethodBeat.i(174881);
            boolean bDU = getA8KeyTask.bDU();
            AppMethodBeat.o(174881);
            return bDU;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(174876);
            final l lVar = new l(this.mpM, 36, this.dFL, this.dFM, (int) System.currentTimeMillis(), new byte[0]);
            aa.a(lVar.rr, new aa.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode.GetA8KeyTask.AnonymousClass1 */

                @Override // com.tencent.mm.ak.aa.a
                public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                    AppMethodBeat.i(174874);
                    if (i2 == 0 && i3 == 0) {
                        GetA8KeyTask.this.actionCode = lVar.beS();
                        switch (GetA8KeyTask.this.actionCode) {
                            case 26:
                                GetA8KeyTask.this.mpN = lVar.beQ();
                                break;
                            default:
                                GetA8KeyTask.this.mpN = "";
                                break;
                        }
                        GetA8KeyTask.b(GetA8KeyTask.this);
                        AppMethodBeat.o(174874);
                    } else {
                        GetA8KeyTask.this.actionCode = -1;
                        GetA8KeyTask.a(GetA8KeyTask.this);
                        AppMethodBeat.o(174874);
                    }
                    return 0;
                }
            }, true);
            AppMethodBeat.o(174876);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(174877);
            if (this.mpO != null) {
                this.mpO.run();
            }
            AppMethodBeat.o(174877);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(174878);
            parcel.writeString(this.mpM);
            parcel.writeInt(this.actionCode);
            parcel.writeString(this.mpN);
            parcel.writeInt(this.dFL);
            parcel.writeInt(this.dFM);
            AppMethodBeat.o(174878);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(174879);
            this.mpM = parcel.readString();
            this.actionCode = parcel.readInt();
            this.mpN = parcel.readString();
            this.dFL = parcel.readInt();
            this.dFM = parcel.readInt();
            AppMethodBeat.o(174879);
        }

        static {
            AppMethodBeat.i(174882);
            AppMethodBeat.o(174882);
        }
    }
}
