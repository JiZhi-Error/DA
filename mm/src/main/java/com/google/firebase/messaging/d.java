package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d {
    static void a(String str, Intent intent) {
        AppMethodBeat.i(116802);
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra2 != null) {
            bundle.putString("_nmn", stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("google.c.a.m_l");
        if (!TextUtils.isEmpty(stringExtra3)) {
            bundle.putString("label", stringExtra3);
        }
        String stringExtra4 = intent.getStringExtra("from");
        if (stringExtra4 == null || !stringExtra4.startsWith("/topics/")) {
            stringExtra4 = null;
        }
        if (stringExtra4 != null) {
            bundle.putString("_nt", stringExtra4);
        }
        try {
            bundle.putInt("_nmt", Integer.parseInt(intent.getStringExtra("google.c.a.ts")));
        } catch (NumberFormatException e2) {
        }
        if (intent.hasExtra("google.c.a.udt")) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(intent.getStringExtra("google.c.a.udt")));
            } catch (NumberFormatException e3) {
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(bundle);
            new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(valueOf).length()).append("Sending event=").append(str).append(" params=").append(valueOf);
        }
        a aVar = (a) com.google.firebase.a.xS().y(a.class);
        if (aVar != null) {
            aVar.logEvent(AppMeasurement.FCM_ORIGIN, str, bundle);
            AppMethodBeat.o(116802);
            return;
        }
        AppMethodBeat.o(116802);
    }
}
