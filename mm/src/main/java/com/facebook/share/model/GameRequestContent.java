package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

public final class GameRequestContent implements ShareModel {
    public static final Parcelable.Creator<GameRequestContent> CREATOR = new Parcelable.Creator<GameRequestContent>() {
        /* class com.facebook.share.model.GameRequestContent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final GameRequestContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8398);
            GameRequestContent gameRequestContent = new GameRequestContent(parcel);
            AppMethodBeat.o(8398);
            return gameRequestContent;
        }

        @Override // android.os.Parcelable.Creator
        public final GameRequestContent[] newArray(int i2) {
            return new GameRequestContent[i2];
        }
    };
    private final ActionType actionType;
    private final String data;
    private final Filters filters;
    private final String message;
    private final String objectId;
    private final List<String> recipients;
    private final List<String> suggestions;
    private final String title;

    public enum ActionType {
        SEND,
        ASKFOR,
        TURN;

        public static ActionType valueOf(String str) {
            AppMethodBeat.i(8402);
            ActionType actionType = (ActionType) Enum.valueOf(ActionType.class, str);
            AppMethodBeat.o(8402);
            return actionType;
        }

        static {
            AppMethodBeat.i(8403);
            AppMethodBeat.o(8403);
        }
    }

    public enum Filters {
        APP_USERS,
        APP_NON_USERS;

        public static Filters valueOf(String str) {
            AppMethodBeat.i(8411);
            Filters filters = (Filters) Enum.valueOf(Filters.class, str);
            AppMethodBeat.o(8411);
            return filters;
        }

        static {
            AppMethodBeat.i(8412);
            AppMethodBeat.o(8412);
        }
    }

    private GameRequestContent(Builder builder) {
        AppMethodBeat.i(8413);
        this.message = builder.message;
        this.recipients = builder.recipients;
        this.title = builder.title;
        this.data = builder.data;
        this.actionType = builder.actionType;
        this.objectId = builder.objectId;
        this.filters = builder.filters;
        this.suggestions = builder.suggestions;
        AppMethodBeat.o(8413);
    }

    GameRequestContent(Parcel parcel) {
        AppMethodBeat.i(8414);
        this.message = parcel.readString();
        this.recipients = parcel.createStringArrayList();
        this.title = parcel.readString();
        this.data = parcel.readString();
        this.actionType = (ActionType) parcel.readSerializable();
        this.objectId = parcel.readString();
        this.filters = (Filters) parcel.readSerializable();
        this.suggestions = parcel.createStringArrayList();
        parcel.readStringList(this.suggestions);
        AppMethodBeat.o(8414);
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTo() {
        AppMethodBeat.i(8415);
        if (getRecipients() != null) {
            String join = TextUtils.join(",", getRecipients());
            AppMethodBeat.o(8415);
            return join;
        }
        AppMethodBeat.o(8415);
        return null;
    }

    public final List<String> getRecipients() {
        return this.recipients;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getData() {
        return this.data;
    }

    public final ActionType getActionType() {
        return this.actionType;
    }

    public final String getObjectId() {
        return this.objectId;
    }

    public final Filters getFilters() {
        return this.filters;
    }

    public final List<String> getSuggestions() {
        return this.suggestions;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8416);
        parcel.writeString(this.message);
        parcel.writeStringList(this.recipients);
        parcel.writeString(this.title);
        parcel.writeString(this.data);
        parcel.writeSerializable(this.actionType);
        parcel.writeString(this.objectId);
        parcel.writeSerializable(this.filters);
        parcel.writeStringList(this.suggestions);
        AppMethodBeat.o(8416);
    }

    static {
        AppMethodBeat.i(8417);
        AppMethodBeat.o(8417);
    }

    public static class Builder implements ShareModelBuilder<GameRequestContent, Builder> {
        private ActionType actionType;
        private String data;
        private Filters filters;
        private String message;
        private String objectId;
        private List<String> recipients;
        private List<String> suggestions;
        private String title;

        /* Return type fixed from 'com.facebook.share.model.ShareModelBuilder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareModel] */
        @Override // com.facebook.share.model.ShareModelBuilder
        public /* bridge */ /* synthetic */ Builder readFrom(GameRequestContent gameRequestContent) {
            AppMethodBeat.i(8408);
            Builder readFrom = readFrom(gameRequestContent);
            AppMethodBeat.o(8408);
            return readFrom;
        }

        public Builder setMessage(String str) {
            this.message = str;
            return this;
        }

        public Builder setTo(String str) {
            AppMethodBeat.i(8404);
            if (str != null) {
                this.recipients = Arrays.asList(str.split(","));
            }
            AppMethodBeat.o(8404);
            return this;
        }

        public Builder setRecipients(List<String> list) {
            this.recipients = list;
            return this;
        }

        public Builder setData(String str) {
            this.data = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setActionType(ActionType actionType2) {
            this.actionType = actionType2;
            return this;
        }

        public Builder setObjectId(String str) {
            this.objectId = str;
            return this;
        }

        public Builder setFilters(Filters filters2) {
            this.filters = filters2;
            return this;
        }

        public Builder setSuggestions(List<String> list) {
            this.suggestions = list;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public GameRequestContent build() {
            AppMethodBeat.i(8405);
            GameRequestContent gameRequestContent = new GameRequestContent(this);
            AppMethodBeat.o(8405);
            return gameRequestContent;
        }

        public Builder readFrom(GameRequestContent gameRequestContent) {
            AppMethodBeat.i(8406);
            if (gameRequestContent == null) {
                AppMethodBeat.o(8406);
                return this;
            }
            Builder suggestions2 = setMessage(gameRequestContent.getMessage()).setRecipients(gameRequestContent.getRecipients()).setTitle(gameRequestContent.getTitle()).setData(gameRequestContent.getData()).setActionType(gameRequestContent.getActionType()).setObjectId(gameRequestContent.getObjectId()).setFilters(gameRequestContent.getFilters()).setSuggestions(gameRequestContent.getSuggestions());
            AppMethodBeat.o(8406);
            return suggestions2;
        }

        /* access modifiers changed from: package-private */
        public Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(8407);
            Builder readFrom = readFrom((GameRequestContent) parcel.readParcelable(GameRequestContent.class.getClassLoader()));
            AppMethodBeat.o(8407);
            return readFrom;
        }
    }
}
