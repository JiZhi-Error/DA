package com.facebook.appevents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class PersistedEvents implements Serializable {
    private static final long serialVersionUID = 20160629001L;
    private HashMap<AccessTokenAppIdPair, List<AppEvent>> events = new HashMap<>();

    public PersistedEvents() {
        AppMethodBeat.i(17447);
        AppMethodBeat.o(17447);
    }

    public PersistedEvents(HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap) {
        AppMethodBeat.i(17448);
        this.events.putAll(hashMap);
        AppMethodBeat.o(17448);
    }

    public Set<AccessTokenAppIdPair> keySet() {
        AppMethodBeat.i(17449);
        Set<AccessTokenAppIdPair> keySet = this.events.keySet();
        AppMethodBeat.o(17449);
        return keySet;
    }

    public List<AppEvent> get(AccessTokenAppIdPair accessTokenAppIdPair) {
        AppMethodBeat.i(17450);
        List<AppEvent> list = this.events.get(accessTokenAppIdPair);
        AppMethodBeat.o(17450);
        return list;
    }

    public boolean containsKey(AccessTokenAppIdPair accessTokenAppIdPair) {
        AppMethodBeat.i(17451);
        boolean containsKey = this.events.containsKey(accessTokenAppIdPair);
        AppMethodBeat.o(17451);
        return containsKey;
    }

    public void addEvents(AccessTokenAppIdPair accessTokenAppIdPair, List<AppEvent> list) {
        AppMethodBeat.i(17452);
        if (!this.events.containsKey(accessTokenAppIdPair)) {
            this.events.put(accessTokenAppIdPair, list);
            AppMethodBeat.o(17452);
            return;
        }
        this.events.get(accessTokenAppIdPair).addAll(list);
        AppMethodBeat.o(17452);
    }

    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = 20160629001L;
        private final HashMap<AccessTokenAppIdPair, List<AppEvent>> proxyEvents;

        private SerializationProxyV1(HashMap<AccessTokenAppIdPair, List<AppEvent>> hashMap) {
            this.proxyEvents = hashMap;
        }

        private Object readResolve() {
            AppMethodBeat.i(17446);
            PersistedEvents persistedEvents = new PersistedEvents(this.proxyEvents);
            AppMethodBeat.o(17446);
            return persistedEvents;
        }
    }

    private Object writeReplace() {
        AppMethodBeat.i(17453);
        SerializationProxyV1 serializationProxyV1 = new SerializationProxyV1(this.events);
        AppMethodBeat.o(17453);
        return serializationProxyV1;
    }
}
