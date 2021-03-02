package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "openFinderDetailView", IssueStorage.COLUMN_EXT_INFO, "OpenFinderViewTask", "OpenFinderViewTaskData", "plugin-webview_release"})
public final class JsApiOpenFinderView extends com.tencent.mm.plugin.webview.d.c.a {
    private static final int CDJ = CDJ;
    public static final JsApiOpenFinderView JxB = new JsApiOpenFinderView();
    private static final String edq = edq;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class b<T> implements d<IPCBoolean> {
        final /* synthetic */ f CDE;
        final /* synthetic */ n pGr;

        b(f fVar, n nVar) {
            this.CDE = fVar;
            this.pGr = nVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(IPCBoolean iPCBoolean) {
            AppMethodBeat.i(210638);
            if (iPCBoolean.value) {
                this.CDE.IQZ.h(this.pGr.ISe, this.pGr.mhO + ":ok", null);
                AppMethodBeat.o(210638);
                return;
            }
            this.CDE.IQZ.h(this.pGr.ISe, this.pGr.mhO + ":fail open fail", null);
            AppMethodBeat.o(210638);
        }
    }

    static {
        AppMethodBeat.i(210640);
        AppMethodBeat.o(210640);
    }

    private JsApiOpenFinderView() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return CDJ;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        AppMethodBeat.i(210639);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        Log.i("MicroMsg.JsApiOpenFinderView", "alvinfluo openFinderView");
        String str = (String) nVar.params.get(IssueStorage.COLUMN_EXT_INFO);
        if (str == null) {
            str = "";
        }
        Log.d("MicroMsg.JsApiOpenFinderView", "alvinluo openFinderView extInfo: %s", str);
        XIPCInvoker.a(MainProcessIPCService.dkO, new OpenFinderViewTaskData(str), a.class, new b(fVar, nVar));
        AppMethodBeat.o(210639);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
    static final class a implements com.tencent.mm.ipcinvoker.b<OpenFinderViewTaskData, IPCBoolean> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(OpenFinderViewTaskData openFinderViewTaskData, d<IPCBoolean> dVar) {
            boolean z;
            String str;
            AppMethodBeat.i(210632);
            OpenFinderViewTaskData openFinderViewTaskData2 = openFinderViewTaskData;
            Log.v("MicroMsg.JsApiOpenFinderView", "alvinluo openFinderView in mm process");
            try {
                JSONObject jSONObject = new JSONObject();
                if (openFinderViewTaskData2 != null) {
                    str = openFinderViewTaskData2.extInfo;
                } else {
                    str = null;
                }
                jSONObject.put(IssueStorage.COLUMN_EXT_INFO, new JSONObject(str));
                ((aj) g.ah(aj.class)).enterFinderUI(MMApplicationContext.getContext(), jSONObject.toString());
                z = true;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.JsApiOpenFinderView", e2, "alvinluo openFinderView exception", new Object[0]);
                z = false;
            }
            if (dVar != null) {
                dVar.bn(new IPCBoolean(z));
                AppMethodBeat.o(210632);
                return;
            }
            AppMethodBeat.o(210632);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData;", "Landroid/os/Parcelable;", IssueStorage.COLUMN_EXT_INFO, "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getExtInfo", "()Ljava/lang/String;", "setExtInfo", "describeContents", "", "writeToParcel", "", "parcel", "flags", "CREATOR", "plugin-webview_release"})
    static final class OpenFinderViewTaskData implements Parcelable {
        public static final a CREATOR = new a((byte) 0);
        String extInfo = "";

        static {
            AppMethodBeat.i(210637);
            AppMethodBeat.o(210637);
        }

        public OpenFinderViewTaskData(String str) {
            p.h(str, IssueStorage.COLUMN_EXT_INFO);
            AppMethodBeat.i(210635);
            this.extInfo = str;
            AppMethodBeat.o(210635);
        }

        public OpenFinderViewTaskData(Parcel parcel) {
            p.h(parcel, "src");
            AppMethodBeat.i(210636);
            String readString = parcel.readString();
            this.extInfo = readString == null ? "" : readString;
            AppMethodBeat.o(210636);
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(210634);
            p.h(parcel, "parcel");
            parcel.writeString(this.extInfo);
            AppMethodBeat.o(210634);
        }

        public final int describeContents() {
            return 0;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenFinderView$OpenFinderViewTaskData;", "plugin-webview_release"})
        public static final class a implements Parcelable.Creator<OpenFinderViewTaskData> {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ OpenFinderViewTaskData createFromParcel(Parcel parcel) {
                AppMethodBeat.i(210633);
                p.h(parcel, "parcel");
                OpenFinderViewTaskData openFinderViewTaskData = new OpenFinderViewTaskData(parcel);
                AppMethodBeat.o(210633);
                return openFinderViewTaskData;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ OpenFinderViewTaskData[] newArray(int i2) {
                return new OpenFinderViewTaskData[i2];
            }
        }
    }
}
