package com.google.android.gms.gcm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.iid.InstanceID;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

@Deprecated
public class GcmPubSub {
    private static GcmPubSub zzn;
    private static final Pattern zzp = Pattern.compile("/topics/[a-zA-Z0-9-_.~%]{1,900}");
    private InstanceID zzo;

    static {
        AppMethodBeat.i(3627);
        AppMethodBeat.o(3627);
    }

    private GcmPubSub(Context context) {
        AppMethodBeat.i(3623);
        this.zzo = InstanceID.getInstance(context);
        AppMethodBeat.o(3623);
    }

    @Deprecated
    public static synchronized GcmPubSub getInstance(Context context) {
        GcmPubSub gcmPubSub;
        synchronized (GcmPubSub.class) {
            AppMethodBeat.i(3624);
            if (zzn == null) {
                GoogleCloudMessaging.zze(context);
                zzn = new GcmPubSub(context);
            }
            gcmPubSub = zzn;
            AppMethodBeat.o(3624);
        }
        return gcmPubSub;
    }

    @Deprecated
    public void subscribe(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(3625);
        if (str == null || str.isEmpty()) {
            String valueOf = String.valueOf(str);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(valueOf.length() != 0 ? "Invalid appInstanceToken: ".concat(valueOf) : new String("Invalid appInstanceToken: "));
            AppMethodBeat.o(3625);
            throw illegalArgumentException;
        } else if (str2 == null || !zzp.matcher(str2).matches()) {
            String valueOf2 = String.valueOf(str2);
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(valueOf2.length() != 0 ? "Invalid topic name: ".concat(valueOf2) : new String("Invalid topic name: "));
            AppMethodBeat.o(3625);
            throw illegalArgumentException2;
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("gcm.topic", str2);
            this.zzo.getToken(str, str2, bundle);
            AppMethodBeat.o(3625);
        }
    }

    @Deprecated
    public void unsubscribe(String str, String str2) {
        AppMethodBeat.i(3626);
        Bundle bundle = new Bundle();
        bundle.putString("gcm.topic", str2);
        this.zzo.zzd(str, str2, bundle);
        AppMethodBeat.o(3626);
    }
}
