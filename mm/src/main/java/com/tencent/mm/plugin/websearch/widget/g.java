package com.tencent.mm.plugin.websearch.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.y;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.picker.CustomTimePickerNew;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.c;
import com.tencent.mm.ui.widget.picker.d;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g extends y {
    Context context;

    public g(Context context2) {
        this.context = context2;
    }

    @Override // com.tencent.mm.modelappbrand.y
    public final void a(final String str, final String str2, final t tVar) {
        AppMethodBeat.i(116650);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.websearch.widget.g.AnonymousClass1 */

            public final void run() {
                String str;
                Date date;
                Date date2;
                Date date3;
                Date date4;
                Date date5;
                Date date6 = null;
                AppMethodBeat.i(116646);
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    Bundle bundle = new Bundle();
                    String str2 = str;
                    if (str.equals(FFmpegMetadataRetriever.METADATA_KEY_DATE)) {
                        str = jSONObject.optString("mode");
                    } else {
                        str = str2;
                    }
                    char c2 = 65535;
                    switch (str.hashCode()) {
                        case 3076014:
                            if (str.equals(FFmpegMetadataRetriever.METADATA_KEY_DATE)) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 3560141:
                            if (str.equals("time")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1191572447:
                            if (str.equals("selector")) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            g.a(g.this, jSONObject, bundle, tVar);
                            AppMethodBeat.o(116646);
                            return;
                        case 1:
                            g gVar = g.this;
                            t tVar = tVar;
                            String optString = jSONObject.optString("value");
                            String optString2 = jSONObject.optString("start");
                            String optString3 = jSONObject.optString("end");
                            String optString4 = jSONObject.optString(GraphRequest.FIELDS_PARAM);
                            String str3 = "yyyy-MM-dd";
                            if ("month".equals(optString4)) {
                                str3 = "yyyy-MM";
                            } else if ("year".equals(optString4)) {
                                str3 = "yyyy";
                            }
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str3);
                            try {
                                date3 = simpleDateFormat.parse(optString);
                            } catch (ParseException e2) {
                                Log.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", e2, "", new Object[0]);
                                date3 = null;
                            }
                            try {
                                date4 = simpleDateFormat.parse(optString2);
                            } catch (ParseException e3) {
                                Log.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", e3, "", new Object[0]);
                                date4 = null;
                            }
                            try {
                                date5 = simpleDateFormat.parse(optString3);
                            } catch (ParseException e4) {
                                Log.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", e4, "", new Object[0]);
                                date5 = null;
                            }
                            b bVar = new b(gVar.context);
                            bVar.QSU = new b.a(bVar, simpleDateFormat, bundle, tVar) {
                                /* class com.tencent.mm.plugin.websearch.widget.g.AnonymousClass3 */
                                final /* synthetic */ b HSR;
                                final /* synthetic */ t IIl;
                                final /* synthetic */ Bundle IIo;
                                final /* synthetic */ SimpleDateFormat IIp;

                                {
                                    this.HSR = r2;
                                    this.IIp = r3;
                                    this.IIo = r4;
                                    this.IIl = r5;
                                }

                                @Override // com.tencent.mm.ui.widget.picker.b.a
                                public final void onResult(boolean z, int i2, int i3, int i4) {
                                    AppMethodBeat.i(116648);
                                    this.HSR.hide();
                                    String format = this.IIp.format(new Date(i2 - 1900, i3 - 1, i4));
                                    Bundle bundle = this.IIo;
                                    if (!z) {
                                        format = "";
                                    }
                                    bundle.putString("value", format);
                                    if (this.IIl != null) {
                                        this.IIl.b(z, "", this.IIo);
                                    }
                                    AppMethodBeat.o(116648);
                                }
                            };
                            if (date3 != null) {
                                bVar.aX(date3.getYear() + 1900, date3.getMonth() + 1, date3.getDate());
                            }
                            if (date4 != null) {
                                bVar.aY(date4.getYear() + 1900, date4.getMonth() + 1, date4.getDate());
                            }
                            if (date5 != null) {
                                bVar.aZ(date5.getYear() + 1900, date5.getMonth() + 1, date5.getDate());
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                if (optString4.equals("year")) {
                                    bVar.bg(false, false);
                                } else if (optString4.equals("month")) {
                                    bVar.bg(true, false);
                                }
                                if (optString4.equals("day")) {
                                    bVar.bg(true, true);
                                }
                            }
                            bVar.show();
                            AppMethodBeat.o(116646);
                            return;
                        case 2:
                            g gVar2 = g.this;
                            t tVar2 = tVar;
                            d dVar = new d(gVar2.context);
                            String optString5 = jSONObject.optString("value");
                            String optString6 = jSONObject.optString("start");
                            String optString7 = jSONObject.optString("end");
                            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm");
                            try {
                                date = simpleDateFormat2.parse(optString5);
                            } catch (ParseException e5) {
                                Log.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", e5, "", new Object[0]);
                                date = null;
                            }
                            try {
                                date2 = simpleDateFormat2.parse(optString6);
                            } catch (ParseException e6) {
                                Log.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", e6, "", new Object[0]);
                                date2 = null;
                            }
                            try {
                                date6 = simpleDateFormat2.parse(optString7);
                            } catch (ParseException e7) {
                                Log.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", e7, "", new Object[0]);
                            }
                            if (date != null) {
                                int hours = date.getHours();
                                int minutes = date.getMinutes();
                                if (dVar.QTl != null) {
                                    CustomTimePickerNew customTimePickerNew = dVar.QTl;
                                    customTimePickerNew.mnn = hours;
                                    customTimePickerNew.mno = minutes;
                                }
                            }
                            if (date2 != null) {
                                int hours2 = date2.getHours();
                                int minutes2 = date2.getMinutes();
                                if (dVar.QTl != null) {
                                    CustomTimePickerNew customTimePickerNew2 = dVar.QTl;
                                    customTimePickerNew2.mMinTimeHour = hours2;
                                    customTimePickerNew2.mMinTimeMinute = minutes2;
                                }
                            }
                            if (date6 != null) {
                                int hours3 = date6.getHours();
                                int minutes3 = date6.getMinutes();
                                if (dVar.QTl != null) {
                                    CustomTimePickerNew customTimePickerNew3 = dVar.QTl;
                                    customTimePickerNew3.mMaxTimeHour = hours3;
                                    customTimePickerNew3.mMaxTimeMinute = minutes3;
                                }
                            }
                            dVar.QTm = new d.a(dVar, bundle, tVar2) {
                                /* class com.tencent.mm.plugin.websearch.widget.g.AnonymousClass2 */
                                final /* synthetic */ t IIl;
                                final /* synthetic */ d IIn;
                                final /* synthetic */ Bundle IIo;

                                {
                                    this.IIn = r2;
                                    this.IIo = r3;
                                    this.IIl = r4;
                                }

                                @Override // com.tencent.mm.ui.widget.picker.d.a
                                public final void a(boolean z, Object obj) {
                                    AppMethodBeat.i(116647);
                                    d dVar = this.IIn;
                                    if (dVar.yfL != null) {
                                        dVar.yfL.dismiss();
                                    }
                                    this.IIo.putString("value", z ? obj.toString() : "");
                                    if (this.IIl != null) {
                                        this.IIl.b(z, "", this.IIo);
                                    }
                                    AppMethodBeat.o(116647);
                                }
                            };
                            if (dVar.yfL != null) {
                                if (dVar.QTl != null) {
                                    dVar.QTl.onShow();
                                }
                                dVar.yfL.show();
                            }
                            AppMethodBeat.o(116646);
                            return;
                        default:
                            Log.i("MicroMsg.WebSearch.WxaShowPickerListenerImpl", "unknown mode %s", str);
                            AppMethodBeat.o(116646);
                            return;
                    }
                } catch (JSONException e8) {
                    Log.printErrStackTrace("MicroMsg.WebSearch.WxaShowPickerListenerImpl", e8, "", new Object[0]);
                    AppMethodBeat.o(116646);
                }
            }
        });
        AppMethodBeat.o(116650);
    }

    static /* synthetic */ void a(g gVar, JSONObject jSONObject, final Bundle bundle, final t tVar) {
        int i2 = 0;
        AppMethodBeat.i(116651);
        ArrayList arrayList = new ArrayList();
        String optString = jSONObject.optString("rangeKey");
        if (TextUtils.isEmpty(optString)) {
            JSONArray optJSONArray = jSONObject.optJSONArray("range");
            while (i2 < optJSONArray.length()) {
                arrayList.add(optJSONArray.getString(i2));
                i2++;
            }
        } else {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("range");
            while (i2 < optJSONArray2.length()) {
                arrayList.add(optJSONArray2.getJSONObject(i2).optString(optString));
                i2++;
            }
        }
        int optInt = jSONObject.optInt("value");
        final c cVar = new c(gVar.context, arrayList);
        cVar.app(optInt);
        cVar.QTc = new c.b() {
            /* class com.tencent.mm.plugin.websearch.widget.g.AnonymousClass4 */

            @Override // com.tencent.mm.ui.widget.picker.c.b
            public final void onResult(boolean z, Object obj, Object obj2) {
                AppMethodBeat.i(116649);
                cVar.hide();
                bundle.putString("value", z ? new StringBuilder().append(cVar.hci()).toString() : "-1");
                if (tVar != null) {
                    tVar.b(z, "", bundle);
                }
                AppMethodBeat.o(116649);
            }
        };
        cVar.show();
        AppMethodBeat.o(116651);
    }
}
