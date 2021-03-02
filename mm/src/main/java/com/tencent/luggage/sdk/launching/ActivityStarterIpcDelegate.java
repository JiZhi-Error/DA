package com.tencent.luggage.sdk.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;

public class ActivityStarterIpcDelegate implements Parcelable {
    public static final Parcelable.Creator<ActivityStarterIpcDelegate> CREATOR = new Parcelable.Creator<ActivityStarterIpcDelegate>() {
        /* class com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ActivityStarterIpcDelegate[] newArray(int i2) {
            return new ActivityStarterIpcDelegate[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ActivityStarterIpcDelegate createFromParcel(Parcel parcel) {
            AppMethodBeat.i(146865);
            ActivityStarterIpcDelegate activityStarterIpcDelegate = new ActivityStarterIpcDelegate(parcel, (byte) 0);
            AppMethodBeat.o(146865);
            return activityStarterIpcDelegate;
        }
    };
    private final ResultReceiver cBu;

    /* synthetic */ ActivityStarterIpcDelegate(Parcel parcel, byte b2) {
        this(parcel);
    }

    public static ActivityStarterIpcDelegate aJ(Context context) {
        AppMethodBeat.i(146866);
        if (context instanceof Activity) {
            ActivityStarterIpcDelegate activityStarterIpcDelegate = new ActivityStarterIpcDelegate((Activity) context);
            AppMethodBeat.o(146866);
            return activityStarterIpcDelegate;
        }
        AppMethodBeat.o(146866);
        return null;
    }

    public ActivityStarterIpcDelegate(final Activity activity) {
        AppMethodBeat.i(146867);
        this.cBu = new ResultReceiver(new Handler(Looper.getMainLooper())) {
            /* class com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i2, Bundle bundle) {
                Intent intent;
                AppMethodBeat.i(146864);
                super.onReceiveResult(i2, bundle);
                if (!(4660 != i2 || bundle == null || (intent = (Intent) bundle.getParcelable("intent")) == null)) {
                    intent.setFlags(intent.getFlags() & -268435457);
                    Activity activity = activity;
                    a bl = new a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate$1", "onReceiveResult", "(ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/luggage/sdk/launching/ActivityStarterIpcDelegate$1", "onReceiveResult", "(ILandroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                AppMethodBeat.o(146864);
            }
        };
        AppMethodBeat.o(146867);
    }

    public final void startActivity(Intent intent) {
        AppMethodBeat.i(229863);
        if (intent == null) {
            AppMethodBeat.o(229863);
            return;
        }
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("intent", intent);
        this.cBu.send(4660, bundle);
        AppMethodBeat.o(229863);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(146868);
        this.cBu.writeToParcel(parcel, i2);
        AppMethodBeat.o(146868);
    }

    private ActivityStarterIpcDelegate(Parcel parcel) {
        AppMethodBeat.i(146869);
        this.cBu = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        AppMethodBeat.o(146869);
    }

    static {
        AppMethodBeat.i(146870);
        AppMethodBeat.o(146870);
    }
}
