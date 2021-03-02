package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphObject extends ShareOpenGraphValueContainer<ShareOpenGraphObject, Builder> {
    public static final Parcelable.Creator<ShareOpenGraphObject> CREATOR = new Parcelable.Creator<ShareOpenGraphObject>() {
        /* class com.facebook.share.model.ShareOpenGraphObject.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareOpenGraphObject createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8567);
            ShareOpenGraphObject shareOpenGraphObject = new ShareOpenGraphObject(parcel);
            AppMethodBeat.o(8567);
            return shareOpenGraphObject;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareOpenGraphObject[] newArray(int i2) {
            return new ShareOpenGraphObject[i2];
        }
    };

    private ShareOpenGraphObject(Builder builder) {
        super(builder);
    }

    ShareOpenGraphObject(Parcel parcel) {
        super(parcel);
    }

    static {
        AppMethodBeat.i(8574);
        AppMethodBeat.o(8574);
    }

    public static final class Builder extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphObject, Builder> {
        public Builder() {
            AppMethodBeat.i(8570);
            putBoolean(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY, true);
            AppMethodBeat.o(8570);
        }

        @Override // com.facebook.share.ShareBuilder
        public final ShareOpenGraphObject build() {
            AppMethodBeat.i(8571);
            ShareOpenGraphObject shareOpenGraphObject = new ShareOpenGraphObject(this);
            AppMethodBeat.o(8571);
            return shareOpenGraphObject;
        }

        /* access modifiers changed from: package-private */
        public final Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(8572);
            Builder builder = (Builder) readFrom((ShareOpenGraphValueContainer) ((ShareOpenGraphObject) parcel.readParcelable(ShareOpenGraphObject.class.getClassLoader())));
            AppMethodBeat.o(8572);
            return builder;
        }
    }
}
