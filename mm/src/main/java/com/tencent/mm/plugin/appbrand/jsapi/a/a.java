package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public final class a extends d<c> {
    public static final int CTRL_INDEX = 912;
    public static final String NAME = "addPhoneCalendar";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(226711);
        c cVar2 = cVar;
        Context context = cVar2.getContext();
        String optString = jSONObject.optString("title", "");
        long optLong = jSONObject.optLong("startTime", 0);
        Boolean valueOf = Boolean.valueOf(jSONObject.optBoolean("allDay", false));
        Boolean valueOf2 = Boolean.valueOf(jSONObject.optBoolean("repeat", false));
        if ("".equals(optString) || optLong == 0) {
            Log.e("MicroMsg.JsApiAddPhoneCalendar", "wrong format, title is blank, or startTime is 0");
            cVar2.i(i2, h("fail:wrong format:title or startTime", null));
            AppMethodBeat.o(226711);
            return;
        }
        long optLong2 = jSONObject.optLong("endTime", optLong);
        String optString2 = jSONObject.optString("description", "");
        String optString3 = jSONObject.optString(FirebaseAnalytics.b.LOCATION, "");
        StringBuilder sb = new StringBuilder(64);
        sb.append("FREQ=");
        if (valueOf2.booleanValue()) {
            String optString4 = jSONObject.optString("repeatInterval", "");
            char c2 = 65535;
            switch (optString4.hashCode()) {
                case 0:
                    if (optString4.equals("")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 99228:
                    if (optString4.equals("day")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3645428:
                    if (optString4.equals("week")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3704893:
                    if (optString4.equals("year")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 104080000:
                    if (optString4.equals("month")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    Log.e("MicroMsg.JsApiAddPhoneCalendar", "wrong format, repeat is true,but the repeatInterval is null");
                    cVar2.i(i2, h("fail:wrong format:repeat", null));
                    AppMethodBeat.o(226711);
                    return;
                case 1:
                    sb.append("DAILY");
                    break;
                case 2:
                    sb.append("WEEKLY");
                    break;
                case 3:
                    sb.append("MONTHLY;BYMONTHDAY=");
                    sb.append(new SimpleDateFormat("d").format(new Date(1000 * optLong)));
                    break;
                case 4:
                    sb.append("YEARLY");
                    break;
                default:
                    Log.e("MicroMsg.JsApiAddPhoneCalendar", "wrong format, repeat is true,but the repeatInterval is not day,week,month,year");
                    cVar2.i(i2, h("fail:wrong format:repeat", null));
                    AppMethodBeat.o(226711);
                    return;
            }
            long optLong3 = jSONObject.optLong("repeatEndTime", 0);
            if (optLong3 != 0) {
                String format = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'").format(new Date(optLong3 * 1000));
                sb.append(";UNTIL=");
                sb.append(format);
            }
        }
        Log.i("MicroMsg.JsApiAddPhoneCalendar", "title:%s, description:%s, startTime:%d, endTime:%d, repeatValue:%s", optString, optString2, Long.valueOf(optLong), Long.valueOf(optLong2), sb);
        Intent putExtra = new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("beginTime", optLong * 1000).putExtra("endTime", optLong2 * 1000).putExtra("title", optString).putExtra("description", optString2).putExtra("eventLocation", optString3).putExtra("availability", 0).putExtra("allDay", valueOf);
        if (valueOf2.booleanValue()) {
            putExtra.putExtra("rrule", sb.toString());
        }
        if (context == null) {
            cVar2.i(i2, h("fail:context nil", null));
            AppMethodBeat.o(226711);
        } else if (putExtra.resolveActivity(context.getPackageManager()) != null) {
            try {
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(putExtra);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/calendar/JsApiAddPhoneCalendar", "invoke", "(Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/appbrand/jsapi/calendar/JsApiAddPhoneCalendar", "invoke", "(Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;Lorg/json/JSONObject;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                cVar2.i(i2, h("ok", null));
                AppMethodBeat.o(226711);
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiAddPhoneCalendar", "startActivity exp:%s", e2);
                cVar2.i(i2, h("fail:startActivity exception", null));
                AppMethodBeat.o(226711);
            }
        } else {
            cVar2.i(i2, h("fail:no supporting apps", null));
            AppMethodBeat.o(226711);
        }
    }
}
