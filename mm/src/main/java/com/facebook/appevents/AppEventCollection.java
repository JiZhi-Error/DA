package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Set;

/* access modifiers changed from: package-private */
public class AppEventCollection {
    private final HashMap<AccessTokenAppIdPair, SessionEventsState> stateMap = new HashMap<>();

    public AppEventCollection() {
        AppMethodBeat.i(17313);
        AppMethodBeat.o(17313);
    }

    public synchronized void addPersistedEvents(PersistedEvents persistedEvents) {
        AppMethodBeat.i(17314);
        if (persistedEvents == null) {
            AppMethodBeat.o(17314);
        } else {
            for (AccessTokenAppIdPair accessTokenAppIdPair : persistedEvents.keySet()) {
                SessionEventsState sessionEventsState = getSessionEventsState(accessTokenAppIdPair);
                for (AppEvent appEvent : persistedEvents.get(accessTokenAppIdPair)) {
                    sessionEventsState.addEvent(appEvent);
                }
            }
            AppMethodBeat.o(17314);
        }
    }

    public synchronized void addEvent(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        AppMethodBeat.i(17315);
        getSessionEventsState(accessTokenAppIdPair).addEvent(appEvent);
        AppMethodBeat.o(17315);
    }

    public synchronized Set<AccessTokenAppIdPair> keySet() {
        Set<AccessTokenAppIdPair> keySet;
        AppMethodBeat.i(17316);
        keySet = this.stateMap.keySet();
        AppMethodBeat.o(17316);
        return keySet;
    }

    public synchronized SessionEventsState get(AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        AppMethodBeat.i(17317);
        sessionEventsState = this.stateMap.get(accessTokenAppIdPair);
        AppMethodBeat.o(17317);
        return sessionEventsState;
    }

    public synchronized int getEventCount() {
        int i2;
        AppMethodBeat.i(17318);
        i2 = 0;
        for (SessionEventsState sessionEventsState : this.stateMap.values()) {
            i2 = sessionEventsState.getAccumulatedEventCount() + i2;
        }
        AppMethodBeat.o(17318);
        return i2;
    }

    private synchronized SessionEventsState getSessionEventsState(AccessTokenAppIdPair accessTokenAppIdPair) {
        SessionEventsState sessionEventsState;
        AppMethodBeat.i(17319);
        sessionEventsState = this.stateMap.get(accessTokenAppIdPair);
        if (sessionEventsState == null) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            sessionEventsState = new SessionEventsState(AttributionIdentifiers.getAttributionIdentifiers(applicationContext), AppEventsLogger.getAnonymousAppDeviceGUID(applicationContext));
        }
        this.stateMap.put(accessTokenAppIdPair, sessionEventsState);
        AppMethodBeat.o(17319);
        return sessionEventsState;
    }
}
