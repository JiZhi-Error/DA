package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ShareMediaContent extends ShareContent<ShareMediaContent, Builder> {
    public static final Parcelable.Creator<ShareMediaContent> CREATOR = new Parcelable.Creator<ShareMediaContent>() {
        /* class com.facebook.share.model.ShareMediaContent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareMediaContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8458);
            ShareMediaContent shareMediaContent = new ShareMediaContent(parcel);
            AppMethodBeat.o(8458);
            return shareMediaContent;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareMediaContent[] newArray(int i2) {
            return new ShareMediaContent[i2];
        }
    };
    private final List<ShareMedia> media;

    private ShareMediaContent(Builder builder) {
        super(builder);
        AppMethodBeat.i(8470);
        this.media = Collections.unmodifiableList(builder.media);
        AppMethodBeat.o(8470);
    }

    ShareMediaContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(8471);
        this.media = Arrays.asList((ShareMedia[]) parcel.readParcelableArray(ShareMedia.class.getClassLoader()));
        AppMethodBeat.o(8471);
    }

    public final List<ShareMedia> getMedia() {
        return this.media;
    }

    @Override // com.facebook.share.model.ShareContent
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareContent
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8472);
        super.writeToParcel(parcel, i2);
        parcel.writeParcelableArray((ShareMedia[]) this.media.toArray(), i2);
        AppMethodBeat.o(8472);
    }

    static {
        AppMethodBeat.i(8473);
        AppMethodBeat.o(8473);
    }

    public static class Builder extends ShareContent.Builder<ShareMediaContent, Builder> {
        private final List<ShareMedia> media = new ArrayList();

        public Builder() {
            AppMethodBeat.i(8461);
            AppMethodBeat.o(8461);
        }

        /* Return type fixed from 'com.facebook.share.model.ShareContent$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareContent] */
        @Override // com.facebook.share.model.ShareContent.Builder
        public /* bridge */ /* synthetic */ Builder readFrom(ShareMediaContent shareMediaContent) {
            AppMethodBeat.i(8467);
            Builder readFrom = readFrom(shareMediaContent);
            AppMethodBeat.o(8467);
            return readFrom;
        }

        @Override // com.facebook.share.model.ShareModelBuilder, com.facebook.share.model.ShareContent.Builder
        public /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8468);
            Builder readFrom = readFrom((ShareMediaContent) shareModel);
            AppMethodBeat.o(8468);
            return readFrom;
        }

        public Builder addMedium(ShareMedia shareMedia) {
            ShareMedia build;
            AppMethodBeat.i(8462);
            if (shareMedia != null) {
                if (shareMedia instanceof SharePhoto) {
                    build = new SharePhoto.Builder().readFrom((SharePhoto) shareMedia).build();
                } else if (shareMedia instanceof ShareVideo) {
                    build = new ShareVideo.Builder().readFrom((ShareVideo) shareMedia).build();
                } else {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
                    AppMethodBeat.o(8462);
                    throw illegalArgumentException;
                }
                this.media.add(build);
            }
            AppMethodBeat.o(8462);
            return this;
        }

        public Builder addMedia(List<ShareMedia> list) {
            AppMethodBeat.i(8463);
            if (list != null) {
                for (ShareMedia shareMedia : list) {
                    addMedium(shareMedia);
                }
            }
            AppMethodBeat.o(8463);
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareMediaContent build() {
            AppMethodBeat.i(8464);
            ShareMediaContent shareMediaContent = new ShareMediaContent(this);
            AppMethodBeat.o(8464);
            return shareMediaContent;
        }

        public Builder readFrom(ShareMediaContent shareMediaContent) {
            AppMethodBeat.i(8465);
            if (shareMediaContent == null) {
                AppMethodBeat.o(8465);
                return this;
            }
            Builder addMedia = ((Builder) super.readFrom((ShareContent) shareMediaContent)).addMedia(shareMediaContent.getMedia());
            AppMethodBeat.o(8465);
            return addMedia;
        }

        public Builder setMedia(List<ShareMedia> list) {
            AppMethodBeat.i(8466);
            this.media.clear();
            addMedia(list);
            AppMethodBeat.o(8466);
            return this;
        }
    }
}
