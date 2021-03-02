package com.facebook.login.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.login.DeviceLoginManager;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DeviceLoginButton extends LoginButton {
    private Uri deviceRedirectUri;

    public DeviceLoginButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public DeviceLoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DeviceLoginButton(Context context) {
        super(context);
    }

    public void setDeviceRedirectUri(Uri uri) {
        this.deviceRedirectUri = uri;
    }

    public Uri getDeviceRedirectUri() {
        return this.deviceRedirectUri;
    }

    /* access modifiers changed from: protected */
    @Override // com.facebook.login.widget.LoginButton
    public LoginButton.LoginClickListener getNewLoginClickListener() {
        AppMethodBeat.i(40397);
        DeviceLoginClickListener deviceLoginClickListener = new DeviceLoginClickListener();
        AppMethodBeat.o(40397);
        return deviceLoginClickListener;
    }

    class DeviceLoginClickListener extends LoginButton.LoginClickListener {
        private DeviceLoginClickListener() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // com.facebook.login.widget.LoginButton.LoginClickListener
        public LoginManager getLoginManager() {
            AppMethodBeat.i(40396);
            DeviceLoginManager instance = DeviceLoginManager.getInstance();
            instance.setDefaultAudience(DeviceLoginButton.this.getDefaultAudience());
            instance.setLoginBehavior(LoginBehavior.DEVICE_AUTH);
            instance.setDeviceRedirectUri(DeviceLoginButton.this.getDeviceRedirectUri());
            AppMethodBeat.o(40396);
            return instance;
        }
    }
}
