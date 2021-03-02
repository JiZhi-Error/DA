package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Wearable;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class ChannelClient extends GoogleApi<Wearable.WearableOptions> {
    public static final String ACTION_CHANNEL_EVENT = "com.google.android.gms.wearable.CHANNEL_EVENT";

    public interface Channel extends Parcelable {
        String getNodeId();

        String getPath();
    }

    public static abstract class ChannelCallback {
        public static final int CLOSE_REASON_DISCONNECTED = 1;
        public static final int CLOSE_REASON_LOCAL_CLOSE = 3;
        public static final int CLOSE_REASON_NORMAL = 0;
        public static final int CLOSE_REASON_REMOTE_CLOSE = 2;

        public void onChannelClosed(Channel channel, int i2, int i3) {
        }

        public void onChannelOpened(Channel channel) {
        }

        public void onInputClosed(Channel channel, int i2, int i3) {
        }

        public void onOutputClosed(Channel channel, int i2, int i3) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CloseReason {
    }

    public ChannelClient(Activity activity, GoogleApi.Settings settings) {
        super(activity, (Api) Wearable.API, (Api.ApiOptions) null, settings);
    }

    public ChannelClient(Context context, GoogleApi.Settings settings) {
        super(context, Wearable.API, (Api.ApiOptions) null, settings);
    }

    public abstract Task<Void> close(Channel channel);

    public abstract Task<Void> close(Channel channel, int i2);

    public abstract Task<InputStream> getInputStream(Channel channel);

    public abstract Task<OutputStream> getOutputStream(Channel channel);

    public abstract Task<Channel> openChannel(String str, String str2);

    public abstract Task<Void> receiveFile(Channel channel, Uri uri, boolean z);

    public abstract Task<Void> registerChannelCallback(Channel channel, ChannelCallback channelCallback);

    public abstract Task<Void> registerChannelCallback(ChannelCallback channelCallback);

    public abstract Task<Void> sendFile(Channel channel, Uri uri);

    public abstract Task<Void> sendFile(Channel channel, Uri uri, long j2, long j3);

    public abstract Task<Boolean> unregisterChannelCallback(Channel channel, ChannelCallback channelCallback);

    public abstract Task<Boolean> unregisterChannelCallback(ChannelCallback channelCallback);
}
