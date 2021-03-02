package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.a;

public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() {
        /* class android.support.v4.os.ResultReceiver.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ResultReceiver[] newArray(int i2) {
            return new ResultReceiver[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }
    };
    final boolean Np = false;
    a Nq;
    final Handler mHandler = null;

    class b implements Runnable {
        final Bundle Ns;
        final int mResultCode;

        b(int i2, Bundle bundle) {
            this.mResultCode = i2;
            this.Ns = bundle;
        }

        public final void run() {
            ResultReceiver.this.onReceiveResult(this.mResultCode, this.Ns);
        }
    }

    class a extends a.AbstractBinderC0032a {
        a() {
        }

        @Override // android.support.v4.os.a
        public final void send(int i2, Bundle bundle) {
            if (ResultReceiver.this.mHandler != null) {
                ResultReceiver.this.mHandler.post(new b(i2, bundle));
            } else {
                ResultReceiver.this.onReceiveResult(i2, bundle);
            }
        }
    }

    public final void send(int i2, Bundle bundle) {
        if (this.Np) {
            if (this.mHandler != null) {
                this.mHandler.post(new b(i2, bundle));
            } else {
                onReceiveResult(i2, bundle);
            }
        } else if (this.Nq != null) {
            try {
                this.Nq.send(i2, bundle);
            } catch (RemoteException e2) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        synchronized (this) {
            if (this.Nq == null) {
                this.Nq = new a();
            }
            parcel.writeStrongBinder(this.Nq.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.Nq = a.AbstractBinderC0032a.e(parcel.readStrongBinder());
    }
}
