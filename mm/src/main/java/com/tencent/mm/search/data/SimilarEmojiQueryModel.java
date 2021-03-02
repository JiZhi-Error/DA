package com.tencent.mm.search.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 L2\u00020\u0001:\u0001LB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bg\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\t\u00106\u001a\u00020\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\nHÆ\u0003J\t\u0010;\u001a\u00020\fHÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010?\u001a\u00020\u0012HÆ\u0003Js\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\b\u0010A\u001a\u00020\fH\u0016J\u0013\u0010B\u001a\u00020\u00122\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020\fHÖ\u0001J\u0006\u0010F\u001a\u00020\u0012J\t\u0010G\u001a\u00020\u0006HÖ\u0001J\u0018\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\fH\u0016R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001d¨\u0006M"}, hxF = {"Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", SearchIntents.EXTRA_QUERY, "", "emojiMD5", "chatID", AppMeasurement.Param.TIMESTAMP, "", "scene", "", "toUser", "panelEmojiCtx", "Lcom/tencent/mm/protobuf/ByteString;", "PageBuff", "enableSos", "", "panelCallbackImpl", "Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;ZLcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "getPageBuff", "()Lcom/tencent/mm/protobuf/ByteString;", "setPageBuff", "(Lcom/tencent/mm/protobuf/ByteString;)V", "getChatID", "()Ljava/lang/String;", "setChatID", "(Ljava/lang/String;)V", "getEmojiMD5", "setEmojiMD5", "getEnableSos", "()Z", "setEnableSos", "(Z)V", "getPanelCallbackImpl", "()Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;", "setPanelCallbackImpl", "(Lcom/tencent/mm/pluginsdk/ui/chat/SmileyPanelCallback;)V", "getPanelEmojiCtx", "setPanelEmojiCtx", "getQuery", "setQuery", "getScene", "()I", "setScene", "(I)V", "getTimestamp", "()J", "setTimestamp", "(J)V", "getToUser", "setToUser", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "isSimilarSearch", "toString", "writeToParcel", "", "dest", "flags", "Companion", "plugin-emojisdk_release"})
public final class SimilarEmojiQueryModel implements Parcelable {
    public static final Parcelable.Creator<SimilarEmojiQueryModel> CREATOR = new b();
    public static final a NJo = new a((byte) 0);
    private com.tencent.mm.bw.b LXB;
    public String NJk;
    public com.tencent.mm.bw.b NJl;
    public boolean NJm;
    public j NJn;
    public String emojiMD5;
    public String query;
    public int scene;
    public long timestamp;
    public String toUser;

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        if (kotlin.g.b.p.j(r5.NJn, r6.NJn) != false) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
        // Method dump skipped, instructions count: 114
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.search.data.SimilarEmojiQueryModel.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(105832);
        String str = this.query;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.emojiMD5;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.NJk;
        int hashCode3 = str3 != null ? str3.hashCode() : 0;
        long j2 = this.timestamp;
        int i3 = (((((hashCode3 + hashCode2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.scene) * 31;
        String str4 = this.toUser;
        int hashCode4 = ((str4 != null ? str4.hashCode() : 0) + i3) * 31;
        com.tencent.mm.bw.b bVar = this.NJl;
        int hashCode5 = ((bVar != null ? bVar.hashCode() : 0) + hashCode4) * 31;
        com.tencent.mm.bw.b bVar2 = this.LXB;
        int hashCode6 = ((bVar2 != null ? bVar2.hashCode() : 0) + hashCode5) * 31;
        boolean z = this.NJm;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (i4 + hashCode6) * 31;
        j jVar = this.NJn;
        if (jVar != null) {
            i2 = jVar.hashCode();
        }
        int i8 = i7 + i2;
        AppMethodBeat.o(105832);
        return i8;
    }

    public final String toString() {
        AppMethodBeat.i(105831);
        String str = "SimilarEmojiQueryModel(query=" + this.query + ", emojiMD5=" + this.emojiMD5 + ", chatID=" + this.NJk + ", timestamp=" + this.timestamp + ", scene=" + this.scene + ", toUser=" + this.toUser + ", panelEmojiCtx=" + this.NJl + ", PageBuff=" + this.LXB + ", enableSos=" + this.NJm + ", panelCallbackImpl=" + this.NJn + ")";
        AppMethodBeat.o(105831);
        return str;
    }

    public SimilarEmojiQueryModel(String str, String str2, String str3, long j2, int i2, String str4, com.tencent.mm.bw.b bVar, boolean z, j jVar) {
        p.h(str, SearchIntents.EXTRA_QUERY);
        p.h(str2, "emojiMD5");
        p.h(str3, "chatID");
        p.h(str4, "toUser");
        AppMethodBeat.i(200081);
        this.query = str;
        this.emojiMD5 = str2;
        this.NJk = str3;
        this.timestamp = j2;
        this.scene = i2;
        this.toUser = str4;
        this.NJl = bVar;
        this.LXB = null;
        this.NJm = z;
        this.NJn = jVar;
        AppMethodBeat.o(200081);
    }

    private /* synthetic */ SimilarEmojiQueryModel(String str, String str2, String str3, long j2, int i2, String str4) {
        this(str, str2, str3, j2, i2, str4, null, true, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimilarEmojiQueryModel(Parcel parcel) {
        this(String.valueOf(parcel.readString()), String.valueOf(parcel.readString()), String.valueOf(parcel.readString()), parcel.readLong(), parcel.readInt(), String.valueOf(parcel.readString()));
        p.h(parcel, "source");
        AppMethodBeat.i(105829);
        AppMethodBeat.o(105829);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(105827);
        p.h(parcel, "dest");
        parcel.writeString(this.query);
        parcel.writeString(this.emojiMD5);
        parcel.writeString(this.NJk);
        parcel.writeLong(this.timestamp);
        parcel.writeInt(this.scene);
        parcel.writeString(this.toUser);
        AppMethodBeat.o(105827);
    }

    public final boolean gau() {
        AppMethodBeat.i(200080);
        String str = this.query;
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(200080);
            return true;
        }
        AppMethodBeat.o(200080);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/search/data/SimilarEmojiQueryModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "plugin-emojisdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/search/data/SimilarEmojiQueryModel$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "plugin-emojisdk_release"})
    public static final class b implements Parcelable.Creator<SimilarEmojiQueryModel> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SimilarEmojiQueryModel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(105826);
            p.h(parcel, "source");
            SimilarEmojiQueryModel similarEmojiQueryModel = new SimilarEmojiQueryModel(parcel);
            AppMethodBeat.o(105826);
            return similarEmojiQueryModel;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SimilarEmojiQueryModel[] newArray(int i2) {
            return new SimilarEmojiQueryModel[i2];
        }
    }

    static {
        AppMethodBeat.i(105830);
        AppMethodBeat.o(105830);
    }
}
