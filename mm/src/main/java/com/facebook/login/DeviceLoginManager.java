package com.facebook.login;

import android.net.Uri;
import com.facebook.login.LoginClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public class DeviceLoginManager extends LoginManager {
    private static volatile DeviceLoginManager instance;
    private String deviceAuthTargetUserId;
    private Uri deviceRedirectUri;

    public static DeviceLoginManager getInstance() {
        AppMethodBeat.i(40394);
        if (instance == null) {
            synchronized (DeviceLoginManager.class) {
                try {
                    if (instance == null) {
                        instance = new DeviceLoginManager();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(40394);
                    throw th;
                }
            }
        }
        DeviceLoginManager deviceLoginManager = instance;
        AppMethodBeat.o(40394);
        return deviceLoginManager;
    }

    public void setDeviceRedirectUri(Uri uri) {
        this.deviceRedirectUri = uri;
    }

    public Uri getDeviceRedirectUri() {
        return this.deviceRedirectUri;
    }

    public void setDeviceAuthTargetUserId(String str) {
        this.deviceAuthTargetUserId = str;
    }

    public String getDeviceAuthTargetUserId() {
        return this.deviceAuthTargetUserId;
    }

    /* access modifiers changed from: protected */
    @Override // com.facebook.login.LoginManager
    public LoginClient.Request createLoginRequest(Collection<String> collection) {
        AppMethodBeat.i(40395);
        LoginClient.Request createLoginRequest = super.createLoginRequest(collection);
        Uri deviceRedirectUri2 = getDeviceRedirectUri();
        if (deviceRedirectUri2 != null) {
            createLoginRequest.setDeviceRedirectUriString(deviceRedirectUri2.toString());
        }
        String deviceAuthTargetUserId2 = getDeviceAuthTargetUserId();
        if (deviceAuthTargetUserId2 != null) {
            createLoginRequest.setDeviceAuthTargetUserId(deviceAuthTargetUserId2);
        }
        AppMethodBeat.o(40395);
        return createLoginRequest;
    }
}
