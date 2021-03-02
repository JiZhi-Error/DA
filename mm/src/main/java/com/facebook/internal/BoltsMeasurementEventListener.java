package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.d;
import com.facebook.appevents.AppEventsLogger;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BoltsMeasurementEventListener extends BroadcastReceiver {
    private static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
    private static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
    private static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
    private static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
    private static BoltsMeasurementEventListener _instance;
    private Context applicationContext;

    private BoltsMeasurementEventListener(Context context) {
        AppMethodBeat.i(17680);
        this.applicationContext = context.getApplicationContext();
        AppMethodBeat.o(17680);
    }

    private void open() {
        AppMethodBeat.i(17681);
        d.W(this.applicationContext).a(this, new IntentFilter(MEASUREMENT_EVENT_NOTIFICATION_NAME));
        AppMethodBeat.o(17681);
    }

    private void close() {
        AppMethodBeat.i(17682);
        d.W(this.applicationContext).unregisterReceiver(this);
        AppMethodBeat.o(17682);
    }

    public static BoltsMeasurementEventListener getInstance(Context context) {
        AppMethodBeat.i(17683);
        if (_instance != null) {
            BoltsMeasurementEventListener boltsMeasurementEventListener = _instance;
            AppMethodBeat.o(17683);
            return boltsMeasurementEventListener;
        }
        BoltsMeasurementEventListener boltsMeasurementEventListener2 = new BoltsMeasurementEventListener(context);
        _instance = boltsMeasurementEventListener2;
        boltsMeasurementEventListener2.open();
        BoltsMeasurementEventListener boltsMeasurementEventListener3 = _instance;
        AppMethodBeat.o(17683);
        return boltsMeasurementEventListener3;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(17684);
        try {
            close();
        } finally {
            super.finalize();
            AppMethodBeat.o(17684);
        }
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(17685);
        AppEventsLogger newLogger = AppEventsLogger.newLogger(context);
        String str = BOLTS_MEASUREMENT_EVENT_PREFIX + intent.getStringExtra(MEASUREMENT_EVENT_NAME_KEY);
        Bundle bundleExtra = intent.getBundleExtra(MEASUREMENT_EVENT_ARGS_KEY);
        Bundle bundle = new Bundle();
        for (String str2 : bundleExtra.keySet()) {
            bundle.putString(str2.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) bundleExtra.get(str2));
        }
        newLogger.logEvent(str, bundle);
        AppMethodBeat.o(17685);
    }
}
