package com.facebook.appevents;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AppEventUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* access modifiers changed from: package-private */
public class AnalyticsUserIDStore {
    private static final String ANALYTICS_USER_ID_KEY = "com.facebook.appevents.AnalyticsUserIDStore.userID";
    private static final String TAG = AnalyticsUserIDStore.class.getSimpleName();
    private static volatile boolean initialized = false;
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static String userID;

    AnalyticsUserIDStore() {
    }

    static /* synthetic */ void access$000() {
        AppMethodBeat.i(17299);
        initAndWait();
        AppMethodBeat.o(17299);
    }

    static {
        AppMethodBeat.i(17300);
        AppMethodBeat.o(17300);
    }

    public static void initStore() {
        AppMethodBeat.i(17295);
        if (initialized) {
            AppMethodBeat.o(17295);
            return;
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.AnalyticsUserIDStore.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(17293);
                AnalyticsUserIDStore.access$000();
                AppMethodBeat.o(17293);
            }
        });
        AppMethodBeat.o(17295);
    }

    public static void setUserID(final String str) {
        AppMethodBeat.i(17296);
        AppEventUtility.assertIsNotMainThread();
        if (!initialized) {
            initAndWait();
        }
        AppEventsLogger.getAnalyticsExecutor().execute(new Runnable() {
            /* class com.facebook.appevents.AnalyticsUserIDStore.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(17294);
                AnalyticsUserIDStore.lock.writeLock().lock();
                try {
                    String unused = AnalyticsUserIDStore.userID = str;
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
                    edit.putString(AnalyticsUserIDStore.ANALYTICS_USER_ID_KEY, AnalyticsUserIDStore.userID);
                    edit.apply();
                } finally {
                    AnalyticsUserIDStore.lock.writeLock().unlock();
                    AppMethodBeat.o(17294);
                }
            }
        });
        AppMethodBeat.o(17296);
    }

    public static String getUserID() {
        AppMethodBeat.i(17297);
        if (!initialized) {
            initAndWait();
        }
        lock.readLock().lock();
        try {
            return userID;
        } finally {
            lock.readLock().unlock();
            AppMethodBeat.o(17297);
        }
    }

    private static void initAndWait() {
        AppMethodBeat.i(17298);
        if (initialized) {
            AppMethodBeat.o(17298);
            return;
        }
        lock.writeLock().lock();
        try {
            if (!initialized) {
                userID = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString(ANALYTICS_USER_ID_KEY, null);
                initialized = true;
                lock.writeLock().unlock();
                AppMethodBeat.o(17298);
            }
        } finally {
            lock.writeLock().unlock();
            AppMethodBeat.o(17298);
        }
    }
}
