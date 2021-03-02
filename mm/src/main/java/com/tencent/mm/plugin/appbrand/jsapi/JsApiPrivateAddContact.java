package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiPrivateAddContact extends d<k> {
    public static final int CTRL_INDEX = 407;
    public static final String NAME = "private_addContact";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45616);
        final k kVar2 = kVar;
        int bEp = bEp();
        try {
            int i3 = jSONObject.getInt("scene");
            String string = jSONObject.getString(ch.COL_USERNAME);
            if (Util.isNullOrNil(string)) {
                Log.i("MicroMsg.JsApiPrivateAddContact", "username nil");
                kVar2.i(i2, h("fail:username is nil", null));
                AppMethodBeat.o(45616);
                return;
            }
            AddContactRequest addContactRequest = new AddContactRequest();
            addContactRequest.userName = string;
            addContactRequest.scene = i3;
            addContactRequest.lBy = bEp;
            com.tencent.mm.plugin.appbrand.ipc.a.a(kVar2.getContext(), addContactRequest, new AppBrandProxyUIProcessTask.b<AddContactResult>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
                public final /* synthetic */ void a(AddContactResult addContactResult) {
                    AppMethodBeat.i(45602);
                    AddContactResult addContactResult2 = addContactResult;
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(addContactResult2 == null ? -1000 : addContactResult2.resultCode);
                    Log.i("MicroMsg.JsApiPrivateAddContact", "onReceiveResult resultCode:%d", objArr);
                    if (addContactResult2 != null) {
                        switch (addContactResult2.resultCode) {
                            case -2:
                            case 1:
                                kVar2.i(i2, JsApiPrivateAddContact.this.h("ok", null));
                                AppMethodBeat.o(45602);
                                return;
                            case 0:
                                kVar2.i(i2, JsApiPrivateAddContact.this.h("cancel", null));
                                AppMethodBeat.o(45602);
                                return;
                        }
                        AppMethodBeat.o(45602);
                    }
                    kVar2.i(i2, JsApiPrivateAddContact.this.h("fail", null));
                    AppMethodBeat.o(45602);
                }
            });
            AppMethodBeat.o(45616);
        } catch (JSONException e2) {
            Log.w("MicroMsg.JsApiPrivateAddContact", "parse exp:%s", e2);
            kVar2.i(i2, h("fail:parse exp", null));
            AppMethodBeat.o(45616);
        }
    }

    /* access modifiers changed from: protected */
    public int bEp() {
        return 1;
    }

    static final class AddContactRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
        public static final Parcelable.Creator<AddContactRequest> CREATOR = new Parcelable.Creator<AddContactRequest>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.AddContactRequest.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AddContactRequest[] newArray(int i2) {
                return new AddContactRequest[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AddContactRequest createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45603);
                AddContactRequest addContactRequest = new AddContactRequest(parcel);
                AppMethodBeat.o(45603);
                return addContactRequest;
            }
        };
        int lBy;
        int scene;
        String userName;

        AddContactRequest() {
        }

        AddContactRequest(Parcel parcel) {
            AppMethodBeat.i(45604);
            k(parcel);
            AppMethodBeat.o(45604);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final Class<? extends AppBrandProxyUIProcessTask> bCJ() {
            return a.class;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final void k(Parcel parcel) {
            AppMethodBeat.i(45605);
            this.userName = parcel.readString();
            this.scene = parcel.readInt();
            this.lBy = parcel.readInt();
            AppMethodBeat.o(45605);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45606);
            parcel.writeString(this.userName);
            parcel.writeInt(this.scene);
            parcel.writeInt(this.lBy);
            AppMethodBeat.o(45606);
        }

        static {
            AppMethodBeat.i(45607);
            AppMethodBeat.o(45607);
        }
    }

    static final class AddContactResult extends AppBrandProxyUIProcessTask.ProcessResult {
        public static final Parcelable.Creator<AddContactResult> CREATOR = new Parcelable.Creator<AddContactResult>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.AddContactResult.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AddContactResult[] newArray(int i2) {
                return new AddContactResult[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AddContactResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45608);
                AddContactResult addContactResult = new AddContactResult(parcel);
                AppMethodBeat.o(45608);
                return addContactResult;
            }
        };
        private int resultCode;

        AddContactResult() {
        }

        AddContactResult(Parcel parcel) {
            AppMethodBeat.i(45609);
            k(parcel);
            AppMethodBeat.o(45609);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult
        public final void k(Parcel parcel) {
            AppMethodBeat.i(45610);
            this.resultCode = parcel.readInt();
            AppMethodBeat.o(45610);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45611);
            parcel.writeInt(this.resultCode);
            AppMethodBeat.o(45611);
        }

        static {
            AppMethodBeat.i(45612);
            AppMethodBeat.o(45612);
        }
    }

    static final class a extends AppBrandProxyUIProcessTask {
        private a() {
        }

        static /* synthetic */ void a(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(45615);
            aVar.b(processResult);
            AppMethodBeat.o(45615);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
            boolean z = true;
            AppMethodBeat.i(45614);
            final AddContactResult addContactResult = new AddContactResult();
            if (!(processRequest instanceof AddContactRequest)) {
                Log.w("MicroMsg.JsApiPrivateAddContact", "handleRequest !(request instanceof AddContactRequest)");
                addContactResult.resultCode = -1;
                b(addContactResult);
                AppMethodBeat.o(45614);
                return;
            }
            AddContactRequest addContactRequest = (AddContactRequest) processRequest;
            com.tencent.mm.pluginsdk.a aVar = new com.tencent.mm.pluginsdk.a();
            if (addContactRequest.lBy != 1) {
                z = false;
            }
            aVar.JSl = z;
            ((i) g.af(i.class)).a(bDF(), addContactRequest.userName, addContactRequest.scene, new v() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.a.AnonymousClass1 */

                @Override // com.tencent.mm.pluginsdk.ui.applet.v
                public final void wK(int i2) {
                    AppMethodBeat.i(45613);
                    Log.i("MicroMsg.JsApiPrivateAddContact", "onAddContact resultCode:%d", Integer.valueOf(i2));
                    addContactResult.resultCode = i2;
                    a.a(a.this, addContactResult);
                    AppMethodBeat.o(45613);
                }
            }, aVar).show();
            AppMethodBeat.o(45614);
        }
    }
}
