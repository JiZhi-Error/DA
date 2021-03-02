package com.tencent.luggage.sdk.launching;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class OnWXAppResultXPCWrapper<R extends Parcelable> implements Parcelable {
    public static final Parcelable.Creator<OnWXAppResultXPCWrapper> CREATOR = new Parcelable.Creator<OnWXAppResultXPCWrapper>() {
        /* class com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper.AnonymousClass3 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ OnWXAppResultXPCWrapper[] newArray(int i2) {
            return new OnWXAppResultXPCWrapper[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OnWXAppResultXPCWrapper createFromParcel(Parcel parcel) {
            AppMethodBeat.i(146873);
            OnWXAppResultXPCWrapper onWXAppResultXPCWrapper = new OnWXAppResultXPCWrapper(parcel, (byte) 0);
            AppMethodBeat.o(146873);
            return onWXAppResultXPCWrapper;
        }
    };
    private final ResultReceiver MU;
    private final a<R> cBx;

    /* synthetic */ OnWXAppResultXPCWrapper(Parcel parcel, byte b2) {
        this(parcel);
    }

    public static <R extends Parcelable> void a(a<R> aVar, Parcel parcel) {
        AppMethodBeat.i(146878);
        if (aVar == null) {
            parcel.writeString(null);
            AppMethodBeat.o(146878);
            return;
        }
        parcel.writeParcelable(new OnWXAppResultXPCWrapper(aVar), 0);
        AppMethodBeat.o(146878);
    }

    public static <R extends Parcelable> a<R> a(Parcel parcel) {
        a<R> aVar;
        AppMethodBeat.i(146879);
        OnWXAppResultXPCWrapper onWXAppResultXPCWrapper = (OnWXAppResultXPCWrapper) parcel.readParcelable(OnWXAppResultXPCWrapper.class.getClassLoader());
        if (onWXAppResultXPCWrapper != null) {
            aVar = onWXAppResultXPCWrapper.cBx;
        } else {
            aVar = null;
        }
        AppMethodBeat.o(146879);
        return aVar;
    }

    private OnWXAppResultXPCWrapper(final a<R> aVar) {
        AppMethodBeat.i(146880);
        this.cBx = aVar;
        this.MU = new ResultReceiver(new Handler(Looper.getMainLooper())) {
            /* class com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.tencent.luggage.sdk.launching.a */
            /* JADX WARN: Multi-variable type inference failed */
            /* access modifiers changed from: protected */
            public void onReceiveResult(int i2, Bundle bundle) {
                AppMethodBeat.i(146871);
                if (bundle == null) {
                    aVar.b(null);
                    AppMethodBeat.o(146871);
                    return;
                }
                bundle.setClassLoader(SafeParcelableWrapper.class.getClassLoader());
                try {
                    aVar.b(((SafeParcelableWrapper) bundle.getParcelable("parcel")).cBA);
                    AppMethodBeat.o(146871);
                } catch (ClassCastException | NullPointerException e2) {
                    Log.e("Luggage.WxaSDK.OnWXAppResultXPCWrapper", "onReceiveResult, e = %s", e2);
                    aVar.b(null);
                    AppMethodBeat.o(146871);
                }
            }
        };
        AppMethodBeat.o(146880);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(146881);
        this.MU.writeToParcel(parcel, i2);
        AppMethodBeat.o(146881);
    }

    private OnWXAppResultXPCWrapper(Parcel parcel) {
        AppMethodBeat.i(146882);
        this.MU = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        this.cBx = new a<R>() {
            /* class com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper.AnonymousClass2 */

            @Override // com.tencent.luggage.sdk.launching.a
            public final void b(R r) {
                AppMethodBeat.i(146872);
                Bundle bundle = new Bundle(1);
                bundle.putParcelable("parcel", new SafeParcelableWrapper(r));
                OnWXAppResultXPCWrapper.this.MU.send(-1, bundle);
                AppMethodBeat.o(146872);
            }
        };
        AppMethodBeat.o(146882);
    }

    static {
        AppMethodBeat.i(146883);
        AppMethodBeat.o(146883);
    }

    static final class SafeParcelableWrapper implements Parcelable {
        public static final Parcelable.Creator<SafeParcelableWrapper> CREATOR = new Parcelable.Creator<SafeParcelableWrapper>() {
            /* class com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper.SafeParcelableWrapper.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SafeParcelableWrapper[] newArray(int i2) {
                return new SafeParcelableWrapper[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SafeParcelableWrapper createFromParcel(Parcel parcel) {
                AppMethodBeat.i(146874);
                SafeParcelableWrapper safeParcelableWrapper = new SafeParcelableWrapper(parcel);
                AppMethodBeat.o(146874);
                return safeParcelableWrapper;
            }
        };
        private Parcelable cBA;

        SafeParcelableWrapper(Parcelable parcelable) {
            this.cBA = parcelable;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(146875);
            if (this.cBA == null) {
                parcel.writeString(null);
                AppMethodBeat.o(146875);
                return;
            }
            parcel.writeString(this.cBA.getClass().getName());
            parcel.writeParcelable(this.cBA, i2);
            AppMethodBeat.o(146875);
        }

        SafeParcelableWrapper(Parcel parcel) {
            AppMethodBeat.i(146876);
            String readString = parcel.readString();
            if (TextUtils.isEmpty(readString)) {
                this.cBA = null;
                AppMethodBeat.o(146876);
                return;
            }
            try {
                this.cBA = parcel.readParcelable(Class.forName(readString).getClassLoader());
                AppMethodBeat.o(146876);
            } catch (ClassNotFoundException e2) {
                Log.e("Luggage.WxaSDK.OnWXAppResultXPCWrapper", "ClassNotFoundException with %s", readString);
                AppMethodBeat.o(146876);
            }
        }

        static {
            AppMethodBeat.i(146877);
            AppMethodBeat.o(146877);
        }
    }
}
