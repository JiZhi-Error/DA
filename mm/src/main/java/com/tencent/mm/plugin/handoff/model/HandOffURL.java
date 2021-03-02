package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.fah;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.m;
import kotlin.n.n;
import kotlin.o;

@Keep
@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 32\u00020\u0001:\u00013BG\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bB\u0007\b\u0016¢\u0006\u0002\u0010\fB\u000f\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\"\u001a\u00020\u0003H\u0015J\b\u0010#\u001a\u00020\u0001H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\n\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0016\u0010'\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*\u0018\u00010(H\u0014J\b\u0010+\u001a\u00020\u0007H\u0016J\b\u0010,\u001a\u00020\u0003H\u0016J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0001H\u0016J\u0018\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u0007H\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R+\u0010\u0014\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0000\u0012\u0002\b\u00030\u00160\u00158BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "title", "", "url", "icon", "handOffType", "", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "memberProperties", "", "Lkotlin/reflect/KProperty1;", "getMemberProperties", "()Ljava/util/Collection;", "memberProperties$delegate", "Lkotlin/Lazy;", "nickname", "getNickname", "setNickname", "getTitle", "setTitle", "getUrl", "setUrl", "body", "copy", "describeContents", "doCreateBallInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "doCreateMultiTaskInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "", "getDataType", "toString", "update", "", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public final class HandOffURL extends HandOff {
    public static final Parcelable.Creator<HandOffURL> CREATOR = new b();
    public static final a Companion = new a((byte) 0);
    public static final String KShareUrl = "handoff#shareUrl";
    private String icon;
    private final f memberProperties$delegate;
    private String nickname;
    private String title;
    private String url;

    public HandOffURL(String str, String str2, String str3) {
        this(str, str2, str3, 0, null, null, null, 120, null);
    }

    public HandOffURL(String str, String str2, String str3, int i2) {
        this(str, str2, str3, i2, null, null, null, 112, null);
    }

    public HandOffURL(String str, String str2, String str3, int i2, String str4) {
        this(str, str2, str3, i2, str4, null, null, 96, null);
    }

    public HandOffURL(String str, String str2, String str3, int i2, String str4, String str5) {
        this(str, str2, str3, i2, str4, str5, null, 64, null);
    }

    private final Collection<m<HandOffURL, ?>> getMemberProperties() {
        AppMethodBeat.i(238063);
        Collection<m<HandOffURL, ?>> collection = (Collection) this.memberProperties$delegate.getValue();
        AppMethodBeat.o(238063);
        return collection;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        AppMethodBeat.i(121732);
        p.h(str, "<set-?>");
        this.title = str;
        AppMethodBeat.o(121732);
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        AppMethodBeat.i(121733);
        p.h(str, "<set-?>");
        this.url = str;
        AppMethodBeat.o(121733);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        AppMethodBeat.i(121734);
        p.h(str, "<set-?>");
        this.icon = str;
        AppMethodBeat.o(121734);
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final void setNickname(String str) {
        AppMethodBeat.i(238062);
        p.h(str, "<set-?>");
        this.nickname = str;
        AppMethodBeat.o(238062);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HandOffURL(java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, int r16, kotlin.g.b.j r17) {
        /*
            r8 = this;
            r0 = r16 & 8
            if (r0 == 0) goto L_0x0036
            r4 = 1
        L_0x0005:
            r0 = r16 & 16
            if (r0 == 0) goto L_0x0034
            java.lang.String r5 = ""
        L_0x000c:
            r0 = r16 & 32
            if (r0 == 0) goto L_0x0032
            java.lang.String r6 = ""
        L_0x0013:
            r0 = r16 & 64
            if (r0 == 0) goto L_0x0030
            r0 = 2
            java.lang.String r7 = com.tencent.mm.plugin.handoff.model.HandOff.a.generateKey(r0, r4)
        L_0x001c:
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = 238066(0x3a1f2, float:3.33602E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r0)
            r0 = 238066(0x3a1f2, float:3.33602E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r0)
            return
        L_0x0030:
            r7 = r15
            goto L_0x001c
        L_0x0032:
            r6 = r14
            goto L_0x0013
        L_0x0034:
            r5 = r13
            goto L_0x000c
        L_0x0036:
            r4 = r12
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.handoff.model.HandOffURL.<init>(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.j):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandOffURL(String str, String str2, String str3, int i2, String str4, String str5, String str6) {
        super(i2, str4, str5, str6, null, 0, 48, null);
        p.h(str, "title");
        p.h(str2, "url");
        p.h(str3, "icon");
        p.h(str4, "from");
        p.h(str5, "to");
        p.h(str6, "key");
        AppMethodBeat.i(121740);
        this.nickname = "";
        this.memberProperties$delegate = g.ah(c.yhJ);
        this.title = str;
        this.url = str2;
        this.icon = str3;
        AppMethodBeat.o(121740);
    }

    public HandOffURL() {
        this("", "", "", 0, null, null, null, 120, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandOffURL(Parcel parcel) {
        super(parcel);
        p.h(parcel, "source");
        AppMethodBeat.i(121742);
        this.nickname = "";
        this.memberProperties$delegate = g.ah(c.yhJ);
        String readString = parcel.readString();
        if (readString == null) {
            p.hyc();
        }
        this.title = readString;
        String readString2 = parcel.readString();
        if (readString2 == null) {
            p.hyc();
        }
        this.url = readString2;
        String readString3 = parcel.readString();
        if (readString3 == null) {
            p.hyc();
        }
        this.icon = readString3;
        String readString4 = parcel.readString();
        if (readString4 == null) {
            p.hyc();
        }
        this.nickname = readString4;
        AppMethodBeat.o(121742);
    }

    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public final int getDataType() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public final void update(HandOff handOff) {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(121735);
        p.h(handOff, "newHandOff");
        super.update(handOff);
        if (handOff instanceof HandOffURL) {
            if (((HandOffURL) handOff).title.length() > 0) {
                this.title = ((HandOffURL) handOff).title;
            }
            if (((HandOffURL) handOff).url.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.url = ((HandOffURL) handOff).url;
            }
            if (((HandOffURL) handOff).icon.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.icon = ((HandOffURL) handOff).icon;
            }
            if (((HandOffURL) handOff).nickname.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                this.nickname = ((HandOffURL) handOff).nickname;
            }
        }
        AppMethodBeat.o(121735);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public final String body() {
        AppMethodBeat.i(121736);
        String buv = n.buv("\n        <title>" + a.du(this.title) + "</title>\n        <url>" + a.du(this.url) + "</url>\n        <icon>" + a.du(this.icon) + "</icon>\n    ");
        AppMethodBeat.o(121736);
        return buv;
    }

    public final int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(121737);
        p.h(parcel, "dest");
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
        parcel.writeString(this.icon);
        parcel.writeString(this.nickname);
        AppMethodBeat.o(121737);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/handoff/model/HandOffURL$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "KShareUrl", "", "api-handoff_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/handoff/model/HandOffURL$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "api-handoff_release"})
    public static final class b implements Parcelable.Creator<HandOffURL> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ HandOffURL createFromParcel(Parcel parcel) {
            AppMethodBeat.i(121731);
            p.h(parcel, "source");
            HandOffURL handOffURL = new HandOffURL(parcel);
            AppMethodBeat.o(121731);
            return handOffURL;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ HandOffURL[] newArray(int i2) {
            return new HandOffURL[i2];
        }
    }

    static {
        AppMethodBeat.i(121743);
        AppMethodBeat.o(121743);
    }

    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public final HandOff copy() {
        AppMethodBeat.i(121738);
        HandOffURL handOffURL = new HandOffURL(this.title, this.url, this.icon, getHandOffType(), getFrom(), getTo(), getKey());
        handOffURL.setId(getId());
        HandOffURL handOffURL2 = handOffURL;
        AppMethodBeat.o(121738);
        return handOffURL2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public final BallInfo doCreateBallInfo() {
        AppMethodBeat.i(238064);
        if (getHandOffType() == 1) {
            AppMethodBeat.o(238064);
            return null;
        }
        BallInfo ballInfo = new BallInfo(2, getKey());
        ballInfo.name = this.title;
        ballInfo.icon = this.icon;
        ballInfo.eS("rawUrl", this.url);
        AppMethodBeat.o(238064);
        return ballInfo;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.handoff.model.HandOff
    public final o<cru, byte[]> doCreateMultiTaskInfo() {
        AppMethodBeat.i(238065);
        if (getHandOffType() == 1) {
            AppMethodBeat.o(238065);
            return null;
        }
        cru cru = new cru();
        fah fah = new fah();
        cru.title = this.title;
        cru.MwR = this.icon;
        cru.nickname = "";
        fah.Nwh = this.url;
        fah.edo = this.url;
        o<cru, byte[]> oVar = new o<>(cru, fah.toByteArray());
        AppMethodBeat.o(238065);
        return oVar;
    }

    public final String toString() {
        AppMethodBeat.i(121739);
        String str = "HandOffURL(key='" + getKey() + "', id='" + getId() + "', createTime='" + getCreateTime() + ", title='" + this.title + "', url='" + this.url + "', icon='" + this.icon + "')";
        AppMethodBeat.o(121739);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "Lkotlin/reflect/KProperty1;", "Lcom/tencent/mm/plugin/handoff/model/HandOffURL;", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Collection<? extends m<HandOffURL, ?>>> {
        public static final c yhJ = new c();

        static {
            AppMethodBeat.i(238061);
            AppMethodBeat.o(238061);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Collection<? extends m<HandOffURL, ?>> invoke() {
            AppMethodBeat.i(238060);
            kotlin.l.b bp = aa.bp(HandOffURL.class);
            p.h(bp, "$this$declaredMemberProperties");
            ArrayList arrayList = new ArrayList();
            for (T t : ((kotlin.l.b.a.g) bp).SZV.invoke().hyB()) {
                T t2 = t;
                if ((!(t2.hys().hAr() != null)) && (t2 instanceof m)) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(238060);
            return arrayList2;
        }
    }
}
