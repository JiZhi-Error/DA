package org.xwalk.core.extension;

import android.content.Intent;

/* access modifiers changed from: package-private */
public interface XWalkExternalExtensionBridge {
    void broadcastMessage(String str);

    void onBinaryMessage(int i2, byte[] bArr);

    void onDestroy();

    void onInstanceCreated(int i2);

    void onInstanceDestroyed(int i2);

    void onMessage(int i2, String str);

    void onNewIntent(Intent intent);

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    String onSyncMessage(int i2, String str);

    void postBinaryMessage(int i2, byte[] bArr);

    void postMessage(int i2, String str);
}
