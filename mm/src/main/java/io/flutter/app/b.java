package io.flutter.app;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import io.flutter.plugin.a.m;

public interface b extends ComponentCallbacks2, m.a, m.d {
    void hwi();

    boolean onBackPressed();

    void onDestroy();

    void onNewIntent(Intent intent);

    void onPause();

    void onPostResume();

    void onResume();

    void onStart();

    void onStop();

    void onUserLeaveHint();
}
