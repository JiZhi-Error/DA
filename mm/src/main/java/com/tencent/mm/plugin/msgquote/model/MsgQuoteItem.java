package com.tencent.mm.plugin.msgquote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MsgQuoteItem implements Parcelable {
    public static final Parcelable.Creator<MsgQuoteItem> CREATOR = new Parcelable.Creator<MsgQuoteItem>() {
        /* class com.tencent.mm.plugin.msgquote.model.MsgQuoteItem.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MsgQuoteItem[] newArray(int i2) {
            return new MsgQuoteItem[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MsgQuoteItem createFromParcel(Parcel parcel) {
            AppMethodBeat.i(117599);
            MsgQuoteItem msgQuoteItem = new MsgQuoteItem(parcel);
            AppMethodBeat.o(117599);
            return msgQuoteItem;
        }
    };
    public String content;
    public String fqK;
    public int type;
    public long zFI;
    public String zFJ;
    public String zFK;
    public String zFL;
    public String zFM;

    public MsgQuoteItem() {
    }

    public String toString() {
        AppMethodBeat.i(117600);
        String str = "MsgQuoteItem{type=" + this.type + ", svrid=" + this.zFI + ", fromusr='" + this.zFJ + '\'' + ", chatuser='" + this.zFK + '\'' + ", displayname='" + this.zFL + '\'' + ", msgsource='" + this.zFM + '\'' + ", content='" + this.content + '\'' + ", msgSource='" + this.fqK + '\'' + '}';
        AppMethodBeat.o(117600);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(117601);
        parcel.writeInt(this.type);
        parcel.writeLong(this.zFI);
        parcel.writeString(this.zFJ);
        parcel.writeString(this.zFK);
        parcel.writeString(this.zFL);
        parcel.writeString(this.zFM);
        parcel.writeString(this.content);
        parcel.writeString(this.fqK);
        AppMethodBeat.o(117601);
    }

    protected MsgQuoteItem(Parcel parcel) {
        AppMethodBeat.i(117602);
        this.type = parcel.readInt();
        this.zFI = parcel.readLong();
        this.zFJ = parcel.readString();
        this.zFK = parcel.readString();
        this.zFL = parcel.readString();
        this.zFM = parcel.readString();
        this.content = parcel.readString();
        this.fqK = parcel.readString();
        AppMethodBeat.o(117602);
    }

    static {
        AppMethodBeat.i(117603);
        AppMethodBeat.o(117603);
    }
}
