package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.Wearable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public abstract class CapabilityClient extends GoogleApi<Wearable.WearableOptions> {
    public static final String ACTION_CAPABILITY_CHANGED = "com.google.android.gms.wearable.CAPABILITY_CHANGED";
    public static final int FILTER_ALL = 0;
    public static final int FILTER_LITERAL = 0;
    public static final int FILTER_PREFIX = 1;
    public static final int FILTER_REACHABLE = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CapabilityFilterType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NodeFilterType {
    }

    public interface OnCapabilityChangedListener extends CapabilityApi.CapabilityListener {
        @Override // com.google.android.gms.wearable.CapabilityApi.CapabilityListener
        void onCapabilityChanged(CapabilityInfo capabilityInfo);
    }

    public CapabilityClient(Activity activity, GoogleApi.Settings settings) {
        super(activity, (Api) Wearable.API, (Api.ApiOptions) null, settings);
    }

    public CapabilityClient(Context context, GoogleApi.Settings settings) {
        super(context, Wearable.API, (Api.ApiOptions) null, settings);
    }

    public abstract Task<Void> addListener(OnCapabilityChangedListener onCapabilityChangedListener, Uri uri, int i2);

    public abstract Task<Void> addListener(OnCapabilityChangedListener onCapabilityChangedListener, String str);

    public abstract Task<Void> addLocalCapability(String str);

    public abstract Task<Map<String, CapabilityInfo>> getAllCapabilities(int i2);

    public abstract Task<CapabilityInfo> getCapability(String str, int i2);

    public abstract Task<Boolean> removeListener(OnCapabilityChangedListener onCapabilityChangedListener);

    public abstract Task<Boolean> removeListener(OnCapabilityChangedListener onCapabilityChangedListener, String str);

    public abstract Task<Void> removeLocalCapability(String str);
}
