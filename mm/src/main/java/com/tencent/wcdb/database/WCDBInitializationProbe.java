package com.tencent.wcdb.database;

/* access modifiers changed from: package-private */
public class WCDBInitializationProbe {
    static volatile long apiEnv = 0;
    static boolean libLoaded = false;

    private WCDBInitializationProbe() {
    }
}
