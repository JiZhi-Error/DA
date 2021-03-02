package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class SessionEventsState {
    private final int MAX_ACCUMULATED_LOG_EVENTS = 1000;
    private List<AppEvent> accumulatedEvents = new ArrayList();
    private String anonymousAppDeviceGUID;
    private AttributionIdentifiers attributionIdentifiers;
    private List<AppEvent> inFlightEvents = new ArrayList();
    private int numSkippedEventsDueToFullBuffer;

    public SessionEventsState(AttributionIdentifiers attributionIdentifiers2, String str) {
        AppMethodBeat.i(17454);
        this.attributionIdentifiers = attributionIdentifiers2;
        this.anonymousAppDeviceGUID = str;
        AppMethodBeat.o(17454);
    }

    public synchronized void addEvent(AppEvent appEvent) {
        AppMethodBeat.i(17455);
        if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= 1000) {
            this.numSkippedEventsDueToFullBuffer++;
            AppMethodBeat.o(17455);
        } else {
            this.accumulatedEvents.add(appEvent);
            AppMethodBeat.o(17455);
        }
    }

    public synchronized int getAccumulatedEventCount() {
        int size;
        AppMethodBeat.i(17456);
        size = this.accumulatedEvents.size();
        AppMethodBeat.o(17456);
        return size;
    }

    public synchronized void clearInFlightAndStats(boolean z) {
        AppMethodBeat.i(17457);
        if (z) {
            this.accumulatedEvents.addAll(this.inFlightEvents);
        }
        this.inFlightEvents.clear();
        this.numSkippedEventsDueToFullBuffer = 0;
        AppMethodBeat.o(17457);
    }

    public int populateRequest(GraphRequest graphRequest, Context context, boolean z, boolean z2) {
        AppMethodBeat.i(17458);
        synchronized (this) {
            try {
                int i2 = this.numSkippedEventsDueToFullBuffer;
                this.inFlightEvents.addAll(this.accumulatedEvents);
                this.accumulatedEvents.clear();
                JSONArray jSONArray = new JSONArray();
                for (AppEvent appEvent : this.inFlightEvents) {
                    if (!appEvent.isChecksumValid()) {
                        Utility.logd("Event with invalid checksum: %s", appEvent.toString());
                    } else if (z || !appEvent.getIsImplicit()) {
                        jSONArray.put(appEvent.getJSONObject());
                    }
                }
                if (jSONArray.length() == 0) {
                    return 0;
                }
                populateRequest(graphRequest, context, i2, jSONArray, z2);
                int length = jSONArray.length();
                AppMethodBeat.o(17458);
                return length;
            } finally {
                AppMethodBeat.o(17458);
            }
        }
    }

    public synchronized List<AppEvent> getEventsToPersist() {
        List<AppEvent> list;
        AppMethodBeat.i(17459);
        list = this.accumulatedEvents;
        this.accumulatedEvents = new ArrayList();
        AppMethodBeat.o(17459);
        return list;
    }

    public synchronized void accumulatePersistedEvents(List<AppEvent> list) {
        AppMethodBeat.i(17460);
        this.accumulatedEvents.addAll(list);
        AppMethodBeat.o(17460);
    }

    private void populateRequest(GraphRequest graphRequest, Context context, int i2, JSONArray jSONArray, boolean z) {
        JSONObject jSONObject;
        AppMethodBeat.i(17461);
        try {
            jSONObject = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.CUSTOM_APP_EVENTS, this.attributionIdentifiers, this.anonymousAppDeviceGUID, z, context);
            if (this.numSkippedEventsDueToFullBuffer > 0) {
                jSONObject.put("num_skipped_events", i2);
            }
        } catch (JSONException e2) {
            jSONObject = new JSONObject();
        }
        graphRequest.setGraphObject(jSONObject);
        Bundle parameters = graphRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        String jSONArray2 = jSONArray.toString();
        if (jSONArray2 != null) {
            parameters.putString("custom_events", jSONArray2);
            graphRequest.setTag(jSONArray2);
        }
        graphRequest.setParameters(parameters);
        AppMethodBeat.o(17461);
    }
}
