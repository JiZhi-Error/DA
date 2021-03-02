package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppGroupCreationContent implements ShareModel {
    public static final Parcelable.Creator<AppGroupCreationContent> CREATOR = new Parcelable.Creator<AppGroupCreationContent>() {
        /* class com.facebook.share.model.AppGroupCreationContent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final AppGroupCreationContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8345);
            AppGroupCreationContent appGroupCreationContent = new AppGroupCreationContent(parcel);
            AppMethodBeat.o(8345);
            return appGroupCreationContent;
        }

        @Override // android.os.Parcelable.Creator
        public final AppGroupCreationContent[] newArray(int i2) {
            return new AppGroupCreationContent[i2];
        }
    };
    private final String description;
    private final String name;
    private AppGroupPrivacy privacy;

    private AppGroupCreationContent(Builder builder) {
        AppMethodBeat.i(8355);
        this.name = builder.name;
        this.description = builder.description;
        this.privacy = builder.privacy;
        AppMethodBeat.o(8355);
    }

    AppGroupCreationContent(Parcel parcel) {
        AppMethodBeat.i(8356);
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.privacy = (AppGroupPrivacy) parcel.readSerializable();
        AppMethodBeat.o(8356);
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final AppGroupPrivacy getAppGroupPrivacy() {
        return this.privacy;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8357);
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeSerializable(this.privacy);
        AppMethodBeat.o(8357);
    }

    static {
        AppMethodBeat.i(8358);
        AppMethodBeat.o(8358);
    }

    public enum AppGroupPrivacy {
        Open,
        Closed;

        public static AppGroupPrivacy valueOf(String str) {
            AppMethodBeat.i(8349);
            AppGroupPrivacy appGroupPrivacy = (AppGroupPrivacy) Enum.valueOf(AppGroupPrivacy.class, str);
            AppMethodBeat.o(8349);
            return appGroupPrivacy;
        }

        static {
            AppMethodBeat.i(8350);
            AppMethodBeat.o(8350);
        }
    }

    public static class Builder implements ShareModelBuilder<AppGroupCreationContent, Builder> {
        private String description;
        private String name;
        private AppGroupPrivacy privacy;

        /* Return type fixed from 'com.facebook.share.model.ShareModelBuilder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareModel] */
        @Override // com.facebook.share.model.ShareModelBuilder
        public /* bridge */ /* synthetic */ Builder readFrom(AppGroupCreationContent appGroupCreationContent) {
            AppMethodBeat.i(8353);
            Builder readFrom = readFrom(appGroupCreationContent);
            AppMethodBeat.o(8353);
            return readFrom;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        public Builder setAppGroupPrivacy(AppGroupPrivacy appGroupPrivacy) {
            this.privacy = appGroupPrivacy;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public AppGroupCreationContent build() {
            AppMethodBeat.i(8351);
            AppGroupCreationContent appGroupCreationContent = new AppGroupCreationContent(this);
            AppMethodBeat.o(8351);
            return appGroupCreationContent;
        }

        public Builder readFrom(AppGroupCreationContent appGroupCreationContent) {
            AppMethodBeat.i(8352);
            if (appGroupCreationContent == null) {
                AppMethodBeat.o(8352);
                return this;
            }
            Builder appGroupPrivacy = setName(appGroupCreationContent.getName()).setDescription(appGroupCreationContent.getDescription()).setAppGroupPrivacy(appGroupCreationContent.getAppGroupPrivacy());
            AppMethodBeat.o(8352);
            return appGroupPrivacy;
        }
    }
}
