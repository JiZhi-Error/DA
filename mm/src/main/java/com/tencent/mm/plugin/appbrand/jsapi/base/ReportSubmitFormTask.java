package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.few;
import com.tencent.mm.protocal.protobuf.ky;
import com.tencent.mm.protocal.protobuf.kz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportSubmitFormTask extends MainProcessTask {
    public static final Parcelable.Creator<ReportSubmitFormTask> CREATOR = new Parcelable.Creator<ReportSubmitFormTask>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ReportSubmitFormTask[] newArray(int i2) {
            return new ReportSubmitFormTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ReportSubmitFormTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46139);
            ReportSubmitFormTask reportSubmitFormTask = new ReportSubmitFormTask();
            reportSubmitFormTask.f(parcel);
            AppMethodBeat.o(46139);
            return reportSubmitFormTask;
        }
    };
    public String appId;
    public int appVersion;
    public int dCv;
    public String lKc;
    public String pageId;
    public int type;

    public ReportSubmitFormTask() {
    }

    public ReportSubmitFormTask(l lVar) {
        this.appId = lVar.appId;
        this.dCv = lVar.leE.kNW;
        this.appVersion = lVar.leE.pkgVersion;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(46140);
        d.a aVar = new d.a();
        aVar.iLN = new ky();
        aVar.iLO = new kz();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
        aVar.funcId = 1129;
        d aXF = aVar.aXF();
        final ky kyVar = (ky) aXF.iLK.iLR;
        kyVar.KOQ = new LinkedList<>();
        few few = new few();
        few.type = this.type;
        few.dNI = this.appId;
        few.NAk = this.lKc;
        few.NAl = this.pageId;
        few.nJE = this.dCv;
        few.nLk = this.appVersion;
        kyVar.KOQ.add(few);
        synchronized (getClass()) {
            try {
                kyVar.KOQ.addAll(bEZ());
            } catch (Throwable th) {
                AppMethodBeat.o(46140);
                throw th;
            }
        }
        aa.a(aXF, new aa.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask.AnonymousClass1 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                AppMethodBeat.i(46138);
                if (i2 == 0 && i3 == 0) {
                    AppMethodBeat.o(46138);
                } else {
                    synchronized (ReportSubmitFormTask.this.getClass()) {
                        try {
                            ReportSubmitFormTask.z(kyVar.KOQ);
                        } catch (Throwable th) {
                            AppMethodBeat.o(46138);
                            throw th;
                        }
                    }
                    Log.e("MicroMsg.ReportSubmitFormTask", "Error: %d, %d", Integer.valueOf(i2), Integer.valueOf(i3));
                    AppMethodBeat.o(46138);
                }
                return 0;
            }
        });
        AppMethodBeat.o(46140);
    }

    private static LinkedList<few> bEZ() {
        AppMethodBeat.i(46141);
        LinkedList<few> linkedList = new LinkedList<>();
        try {
            JSONArray jSONArray = new JSONArray((String) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_FAILED_FORMID_STRING, (Object) null));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                few few = new few();
                few.type = jSONObject.getInt("type");
                few.dNI = jSONObject.getString("appid");
                few.NAk = jSONObject.getString("formid");
                few.NAl = jSONObject.getString("pageid");
                few.nJE = jSONObject.getInt("appstate");
                few.nLk = jSONObject.getInt("appversion");
                linkedList.add(few);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.ReportSubmitFormTask", e2.getMessage());
        }
        g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_FAILED_FORMID_STRING, "");
        AppMethodBeat.o(46141);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(46142);
        parcel.writeInt(this.type);
        parcel.writeString(this.appId);
        parcel.writeString(this.lKc);
        parcel.writeString(this.pageId);
        parcel.writeInt(this.dCv);
        parcel.writeInt(this.appVersion);
        AppMethodBeat.o(46142);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(46143);
        this.type = parcel.readInt();
        this.appId = parcel.readString();
        this.lKc = parcel.readString();
        this.pageId = parcel.readString();
        this.dCv = parcel.readInt();
        this.appVersion = parcel.readInt();
        AppMethodBeat.o(46143);
    }

    static {
        AppMethodBeat.i(46145);
        AppMethodBeat.o(46145);
    }

    static /* synthetic */ void z(LinkedList linkedList) {
        AppMethodBeat.i(46144);
        linkedList.addAll(bEZ());
        JSONArray jSONArray = new JSONArray();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            few few = (few) it.next();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", few.type);
                jSONObject.put("appid", few.dNI);
                jSONObject.put("formid", few.NAk);
                jSONObject.put("pageid", few.NAl);
                jSONObject.put("appstate", few.nJE);
                jSONObject.put("appversion", few.nLk);
                jSONArray.put(jSONObject);
            } catch (Exception e2) {
                Log.e("MicroMsg.ReportSubmitFormTask", e2.getMessage());
            }
        }
        g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_FAILED_FORMID_STRING, jSONArray.toString());
        AppMethodBeat.o(46144);
    }
}
