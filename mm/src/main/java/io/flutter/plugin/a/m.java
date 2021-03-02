package io.flutter.plugin.a;

import android.content.Intent;
import io.flutter.view.FlutterNativeView;

public interface m {

    public interface a {
        boolean onActivityResult(int i2, int i3, Intent intent);
    }

    public interface b {
        boolean onNewIntent(Intent intent);
    }

    public interface c {
    }

    public interface d {
        boolean a(int i2, String[] strArr, int[] iArr);
    }

    public interface e {
        void onUserLeaveHint();
    }

    public interface f {
        boolean a(FlutterNativeView flutterNativeView);
    }

    boolean bsW(String str);

    c bsX(String str);
}
