package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

public final class k extends d<f> {
    public static final int CTRL_INDEX = 801;
    public static final String NAME = "shareImageMessage";
    final int mrM = a.aK(this);

    public k() {
        AppMethodBeat.i(180271);
        AppMethodBeat.o(180271);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        boolean z;
        final int i3;
        AppMethodBeat.i(180272);
        if (fVar == null) {
            Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, env is null");
            AppMethodBeat.o(180272);
        } else if (jSONObject == null) {
            Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, data is null");
            fVar.i(i2, h("fail:data is null", null));
            AppMethodBeat.o(180272);
        } else if (!jSONObject.has("imagePath")) {
            Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, data is null or can not find imagePath");
            fVar.i(i2, h("fail:imagePath is null", null));
            AppMethodBeat.o(180272);
        } else {
            String optString = jSONObject.optString("imagePath");
            if (Util.isNullOrNil(optString)) {
                Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, imagePath is null");
                fVar.i(i2, h("fail:imagePath is null", null));
                AppMethodBeat.o(180272);
                return;
            }
            String optString2 = jSONObject.optString("quality", "compressed");
            while (true) {
                switch (optString2.hashCode()) {
                    case -369449087:
                        if (optString2.equals("compressed")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 112680:
                        if (optString2.equals(ShareConstants.DEXMODE_RAW)) {
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        z = true;
                        break;
                }
                switch (z) {
                    case false:
                        i3 = 1;
                        break;
                    case true:
                        i3 = 0;
                        break;
                    default:
                        optString2 = "compressed";
                }
            }
            Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, imagePath: %s, compressType: %d", optString, Integer.valueOf(i3));
            c.a(fVar, optString, null, new c.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.share.k.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.utils.c.a
                public final void Wz(final String str) {
                    AppMethodBeat.i(180270);
                    Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, localPath: ".concat(String.valueOf(str)));
                    if (Util.isNullOrNil(str)) {
                        fVar.i(i2, k.this.h("fail:imagePath is illegal", null));
                        AppMethodBeat.o(180270);
                        return;
                    }
                    Context context = fVar.getContext();
                    if (context instanceof Activity) {
                        final Activity activity = (Activity) context;
                        final AnonymousClass1 r1 = new MMActivity.a() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.share.k.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.MMActivity.a
                            public final void d(int i2, int i3, Intent intent) {
                                AppMethodBeat.i(180267);
                                if (i2 != k.this.mrM) {
                                    Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, requestCode: %d is not match", Integer.valueOf(i2));
                                    AppMethodBeat.o(180267);
                                } else if (i3 != -1) {
                                    Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, resultCode is not RESULT_OK: ".concat(String.valueOf(i3)));
                                    fVar.i(i2, k.this.h("cancel", null));
                                    AppMethodBeat.o(180267);
                                } else {
                                    ArrayList<String> stringArrayListExtra = intent == null ? null : intent.getStringArrayListExtra("SendMsgUsernames");
                                    if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                                        Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, toUsers is empty");
                                        fVar.i(i2, k.this.h("fail:selected user is empty", null));
                                        AppMethodBeat.o(180267);
                                        return;
                                    }
                                    Log.i("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, toUser: " + Arrays.toString(stringArrayListExtra.toArray()));
                                    fVar.i(i2, k.this.h("ok", null));
                                    AppMethodBeat.o(180267);
                                }
                            }
                        };
                        fVar.P(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.share.k.AnonymousClass1.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(180269);
                                com.tencent.luggage.h.f.aK(activity).b(new f.c() {
                                    /* class com.tencent.mm.plugin.appbrand.jsapi.share.k.AnonymousClass1.AnonymousClass2.AnonymousClass1 */

                                    @Override // com.tencent.luggage.h.f.c
                                    public final boolean c(int i2, int i3, Intent intent) {
                                        AppMethodBeat.i(180268);
                                        if (k.this.mrM != i2) {
                                            AppMethodBeat.o(180268);
                                            return false;
                                        }
                                        r1.d(i2, i3, intent);
                                        AppMethodBeat.o(180268);
                                        return true;
                                    }
                                });
                                Intent intent = new Intent();
                                intent.putExtra("Retr_File_Name", str);
                                intent.putExtra("Retr_Compress_Type", i3);
                                intent.putExtra("Retr_Msg_Type", 0);
                                com.tencent.mm.br.c.c(activity, ".ui.transmit.MsgRetransmitUI", intent, k.this.mrM);
                                AppMethodBeat.o(180269);
                            }
                        });
                        AppMethodBeat.o(180270);
                        return;
                    }
                    Log.w("MicroMsg.AppBrand.JsApiShareImageMessage", "invoke, activity is null");
                    fVar.i(i2, k.this.h("fail:activity is null", null));
                    AppMethodBeat.o(180270);
                }
            });
            AppMethodBeat.o(180272);
        }
    }
}
