package com.facebook.appevents;

import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

class AppEventStore {
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG = AppEventStore.class.getName();

    AppEventStore() {
    }

    static {
        AppMethodBeat.i(17341);
        AppMethodBeat.o(17341);
    }

    public static synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        synchronized (AppEventStore.class) {
            AppMethodBeat.i(17337);
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents readAndClearStore = readAndClearStore();
            if (readAndClearStore.containsKey(accessTokenAppIdPair)) {
                readAndClearStore.get(accessTokenAppIdPair).addAll(sessionEventsState.getEventsToPersist());
            } else {
                readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
            }
            saveEventsToDisk(readAndClearStore);
            AppMethodBeat.o(17337);
        }
    }

    public static synchronized void persistEvents(AppEventCollection appEventCollection) {
        synchronized (AppEventStore.class) {
            AppMethodBeat.i(17338);
            AppEventUtility.assertIsNotMainThread();
            PersistedEvents readAndClearStore = readAndClearStore();
            for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection.keySet()) {
                readAndClearStore.addEvents(accessTokenAppIdPair, appEventCollection.get(accessTokenAppIdPair).getEventsToPersist());
            }
            saveEventsToDisk(readAndClearStore);
            AppMethodBeat.o(17338);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
        // Method dump skipped, instructions count: 141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        r2 = r1;
        r3 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043 A[ExcHandler: all (r1v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r0 
      PHI: (r0v0 java.io.ObjectOutputStream) = (r0v2 java.io.ObjectOutputStream), (r0v2 java.io.ObjectOutputStream), (r0v5 java.io.ObjectOutputStream), (r0v5 java.io.ObjectOutputStream) binds: [B:9:0x002b, B:10:?, B:3:0x001c, B:4:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:3:0x001c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void saveEventsToDisk(com.facebook.appevents.PersistedEvents r7) {
        /*
            r6 = 17340(0x43bc, float:2.4299E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            r1 = 0
            android.content.Context r2 = com.facebook.FacebookSdk.getApplicationContext()
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0026, all -> 0x0039 }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0026, all -> 0x0039 }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            r5 = 0
            java.io.FileOutputStream r4 = r2.openFileOutput(r4, r5)     // Catch:{ Exception -> 0x0026, all -> 0x0039 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0026, all -> 0x0039 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0026, all -> 0x0039 }
            r0.writeObject(r7)     // Catch:{ Exception -> 0x0049, all -> 0x0043 }
            com.facebook.internal.Utility.closeQuietly(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x0025:
            return
        L_0x0026:
            r0 = move-exception
            r0 = r1
        L_0x0028:
            java.lang.String r1 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r2.getFileStreamPath(r1)     // Catch:{ Exception -> 0x0047, all -> 0x0043 }
            r1.delete()     // Catch:{ Exception -> 0x0047, all -> 0x0043 }
        L_0x0032:
            com.facebook.internal.Utility.closeQuietly(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            goto L_0x0025
        L_0x0039:
            r0 = move-exception
            r2 = r0
            r3 = r1
        L_0x003c:
            com.facebook.internal.Utility.closeQuietly(r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            throw r2
        L_0x0043:
            r1 = move-exception
            r2 = r1
            r3 = r0
            goto L_0x003c
        L_0x0047:
            r1 = move-exception
            goto L_0x0032
        L_0x0049:
            r1 = move-exception
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.saveEventsToDisk(com.facebook.appevents.PersistedEvents):void");
    }

    /* access modifiers changed from: package-private */
    public static class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1";

        public MovedClassObjectInputStream(InputStream inputStream) {
            super(inputStream);
        }

        /* access modifiers changed from: protected */
        @Override // java.io.ObjectInputStream
        public ObjectStreamClass readClassDescriptor() {
            AppMethodBeat.i(17336);
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (readClassDescriptor.getName().equals(ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            } else if (readClassDescriptor.getName().equals(APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV1.class);
            }
            AppMethodBeat.o(17336);
            return readClassDescriptor;
        }
    }
}
