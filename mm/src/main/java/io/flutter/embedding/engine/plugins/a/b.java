package io.flutter.embedding.engine.plugins.a;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.content.Intent;

public interface b {
    void a(Activity activity, Lifecycle lifecycle);

    boolean a(int i2, String[] strArr, int[] iArr);

    void hwJ();

    void hwK();

    void hwL();

    void hwM();

    boolean onActivityResult(int i2, int i3, Intent intent);

    void onNewIntent(Intent intent);

    void onUserLeaveHint();
}
