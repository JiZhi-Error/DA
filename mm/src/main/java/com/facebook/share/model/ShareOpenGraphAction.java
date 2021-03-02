package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphAction extends ShareOpenGraphValueContainer<ShareOpenGraphAction, Builder> {
    public static final Parcelable.Creator<ShareOpenGraphAction> CREATOR = new Parcelable.Creator<ShareOpenGraphAction>() {
        /* class com.facebook.share.model.ShareOpenGraphAction.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareOpenGraphAction createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8542);
            ShareOpenGraphAction shareOpenGraphAction = new ShareOpenGraphAction(parcel);
            AppMethodBeat.o(8542);
            return shareOpenGraphAction;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareOpenGraphAction[] newArray(int i2) {
            return new ShareOpenGraphAction[i2];
        }
    };

    private ShareOpenGraphAction(Builder builder) {
        super(builder);
    }

    ShareOpenGraphAction(Parcel parcel) {
        super(parcel);
    }

    public final String getActionType() {
        AppMethodBeat.i(8552);
        String string = getString("og:type");
        AppMethodBeat.o(8552);
        return string;
    }

    static {
        AppMethodBeat.i(8553);
        AppMethodBeat.o(8553);
    }

    public static final class Builder extends ShareOpenGraphValueContainer.Builder<ShareOpenGraphAction, Builder> {
        private static final String ACTION_TYPE_KEY = "og:type";

        @Override // com.facebook.share.model.ShareModelBuilder, com.facebook.share.model.ShareOpenGraphValueContainer.Builder
        public final /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8550);
            Builder readFrom = readFrom((ShareOpenGraphAction) shareModel);
            AppMethodBeat.o(8550);
            return readFrom;
        }

        /* Return type fixed from 'com.facebook.share.model.ShareOpenGraphValueContainer$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareOpenGraphValueContainer] */
        @Override // com.facebook.share.model.ShareOpenGraphValueContainer.Builder
        public final /* bridge */ /* synthetic */ Builder readFrom(ShareOpenGraphAction shareOpenGraphAction) {
            AppMethodBeat.i(8549);
            Builder readFrom = readFrom(shareOpenGraphAction);
            AppMethodBeat.o(8549);
            return readFrom;
        }

        public final Builder setActionType(String str) {
            AppMethodBeat.i(8545);
            putString(ACTION_TYPE_KEY, str);
            AppMethodBeat.o(8545);
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public final ShareOpenGraphAction build() {
            AppMethodBeat.i(8546);
            ShareOpenGraphAction shareOpenGraphAction = new ShareOpenGraphAction(this);
            AppMethodBeat.o(8546);
            return shareOpenGraphAction;
        }

        public final Builder readFrom(ShareOpenGraphAction shareOpenGraphAction) {
            AppMethodBeat.i(8547);
            if (shareOpenGraphAction == null) {
                AppMethodBeat.o(8547);
                return this;
            }
            Builder actionType = ((Builder) super.readFrom((ShareOpenGraphValueContainer) shareOpenGraphAction)).setActionType(shareOpenGraphAction.getActionType());
            AppMethodBeat.o(8547);
            return actionType;
        }

        /* access modifiers changed from: package-private */
        public final Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(8548);
            Builder readFrom = readFrom((ShareOpenGraphAction) parcel.readParcelable(ShareOpenGraphAction.class.getClassLoader()));
            AppMethodBeat.o(8548);
            return readFrom;
        }
    }
}
