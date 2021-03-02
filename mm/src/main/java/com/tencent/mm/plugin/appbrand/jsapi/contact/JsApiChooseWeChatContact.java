package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.br.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiChooseWeChatContact extends d<s> {
    public static final int CTRL_INDEX = 195;
    public static final String NAME = "chooseWeChatContact";
    final int lSc = a.aK(this);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46254);
        final s sVar2 = sVar;
        Activity ay = sVar2.ay(Activity.class);
        if (ay == null) {
            Log.e("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact context is null, appId is %s", sVar2.getAppId());
            sVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(46254);
            return;
        }
        Log.i("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact appId:%s", sVar2.getAppId());
        Intent intent = new Intent();
        String string = ay.getString(R.string.a3_);
        int i3 = 259;
        int[] iArr = {131072, 131075};
        Log.i("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact data %s:", jSONObject);
        if (!(jSONObject == null || jSONObject.optJSONArray("contactMode") == null || jSONObject.optJSONArray("contactMode").length() <= 0)) {
            String jSONArray = jSONObject.optJSONArray("contactMode").toString();
            if (jSONArray.contains("singleContact") && !jSONArray.contains("chatroom")) {
                i3 = 263;
                string = ay.getString(R.string.a39);
                iArr = new int[]{131072};
            } else if (jSONArray.contains("chatroom") && !jSONArray.contains("singleContact")) {
                i3 = 275;
                iArr = new int[]{131075};
            }
        }
        intent.putExtra("Select_Conv_Type", i3);
        intent.putExtra("jsapi_select_mode", 1);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("scene_from", 9);
        intent.putExtra("Select_Conv_ui_title", string);
        intent.putExtra("search_range", iArr);
        GetUserDataTask getUserDataTask = new GetUserDataTask("");
        AppBrandMainProcessService.b(getUserDataTask);
        intent.putExtra("Select_block_List", getUserDataTask.lSe);
        f.aK(ay).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                String stringExtra;
                AppMethodBeat.i(174780);
                if (JsApiChooseWeChatContact.this.lSc != i2) {
                    Log.e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact requestCode not equal, requestCode = %d", Integer.valueOf(i2));
                    sVar2.i(i2, JsApiChooseWeChatContact.this.h("fail", null));
                    AppMethodBeat.o(174780);
                    return false;
                } else if (i3 == 0 || i3 == 1) {
                    Log.e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact user cancel, resultCode = %d", Integer.valueOf(i2));
                    sVar2.i(i2, JsApiChooseWeChatContact.this.h("cancel", null));
                    AppMethodBeat.o(174780);
                    return true;
                } else {
                    if (i3 == -1) {
                        if (intent == null) {
                            stringExtra = null;
                        } else {
                            stringExtra = intent.getStringExtra("Select_Conv_User");
                        }
                        if (stringExtra == null || stringExtra.length() == 0) {
                            Log.e("MicroMsg.JsApiChooseWeChatContact", "mmOnActivityResult, selectSingleContact fail, user is null");
                            sVar2.i(i2, JsApiChooseWeChatContact.this.h("fail", null));
                            AppMethodBeat.o(174780);
                            return true;
                        }
                        GetUserDataTask getUserDataTask = new GetUserDataTask(stringExtra);
                        AppBrandMainProcessService.b(getUserDataTask);
                        String str = getUserDataTask.nickName;
                        String str2 = getUserDataTask.cgo;
                        String str3 = getUserDataTask.kog;
                        HashMap hashMap = new HashMap();
                        hashMap.put("avatarUrl", str3);
                        hashMap.put("userName", stringExtra);
                        hashMap.put("nickName", str);
                        hashMap.put("remarkName", str2);
                        Log.i("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact: nickName:%s, remarkName:%s", str, str2);
                        sVar2.i(i2, JsApiChooseWeChatContact.this.n("ok", hashMap));
                    }
                    AppMethodBeat.o(174780);
                    return true;
                }
            }
        });
        c.c(ay, ".ui.transmit.SelectConversationUI", intent, this.lSc);
        AppMethodBeat.o(46254);
    }

    public JsApiChooseWeChatContact() {
        AppMethodBeat.i(174781);
        AppMethodBeat.o(174781);
    }

    static class GetUserDataTask extends MainProcessTask {
        public static final Parcelable.Creator<GetUserDataTask> CREATOR = new Parcelable.Creator<GetUserDataTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact.GetUserDataTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetUserDataTask[] newArray(int i2) {
                return new GetUserDataTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetUserDataTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46248);
                GetUserDataTask getUserDataTask = new GetUserDataTask(parcel);
                AppMethodBeat.o(46248);
                return getUserDataTask;
            }
        };
        String cgo;
        String kog = "";
        public String lSe;
        String nickName;
        public String userName;

        public GetUserDataTask(String str) {
            this.userName = str;
        }

        public GetUserDataTask(Parcel parcel) {
            AppMethodBeat.i(46249);
            f(parcel);
            AppMethodBeat.o(46249);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(46250);
            this.lSe = z.aTY();
            if (!TextUtils.isEmpty(this.userName)) {
                this.nickName = aa.Ir(this.userName);
                this.cgo = aa.Is(this.userName);
                i Mx = p.aYB().Mx(this.userName);
                if (Mx != null) {
                    this.kog = Mx.aYt();
                    if (Util.isNullOrNil(this.kog)) {
                        this.kog = Mx.aYu();
                    }
                }
            }
            AppMethodBeat.o(46250);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(46251);
            this.lSe = parcel.readString();
            this.userName = parcel.readString();
            this.nickName = parcel.readString();
            this.cgo = parcel.readString();
            this.kog = parcel.readString();
            AppMethodBeat.o(46251);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46252);
            parcel.writeString(this.lSe);
            parcel.writeString(this.userName);
            parcel.writeString(this.nickName);
            parcel.writeString(this.cgo);
            parcel.writeString(this.kog);
            AppMethodBeat.o(46252);
        }

        static {
            AppMethodBeat.i(46253);
            AppMethodBeat.o(46253);
        }
    }
}
