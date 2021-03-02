package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.FileUtils;
import kotlin.g.b.p;
import kotlin.l;

@Keep
@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015BW\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rB\u0007\b\u0016¢\u0006\u0002\u0010\u000eB\u000f\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/handoff/model/HandOffMG;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "icon", "", "title", "appID", "appEntryPage", "appUserName", "handOffType", "", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "copy", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "getDataType", "Companion", "api-handoff_release"})
public final class HandOffMG extends HandOffMP {
    public static final Parcelable.Creator<HandOffMG> CREATOR = new b();
    public static final a Companion = new a((byte) 0);

    public HandOffMG(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, 0, null, null, null, 480, null);
        AppMethodBeat.i(121716);
        AppMethodBeat.o(121716);
    }

    public HandOffMG(String str, String str2, String str3, String str4, String str5, int i2) {
        this(str, str2, str3, str4, str5, i2, null, null, null, FileUtils.S_IRWXU, null);
    }

    public HandOffMG(String str, String str2, String str3, String str4, String str5, int i2, String str6) {
        this(str, str2, str3, str4, str5, i2, str6, null, null, 384, null);
    }

    public HandOffMG(String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7) {
        this(str, str2, str3, str4, str5, i2, str6, str7, null, 256, null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HandOffMG(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, kotlin.g.b.j r22) {
        /*
            r11 = this;
            r1 = r21 & 32
            if (r1 == 0) goto L_0x0040
            r7 = 1
        L_0x0005:
            r1 = r21 & 64
            if (r1 == 0) goto L_0x003d
            java.lang.String r8 = ""
        L_0x000c:
            r0 = r21
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x003a
            java.lang.String r9 = ""
        L_0x0015:
            r0 = r21
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0037
            r1 = 4
            java.lang.String r10 = com.tencent.mm.plugin.handoff.model.HandOff.a.generateKey(r1, r7)
        L_0x0020:
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = 238053(0x3a1e5, float:3.33583E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            r1 = 238053(0x3a1e5, float:3.33583E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        L_0x0037:
            r10 = r20
            goto L_0x0020
        L_0x003a:
            r9 = r19
            goto L_0x0015
        L_0x003d:
            r8 = r18
            goto L_0x000c
        L_0x0040:
            r7 = r17
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.handoff.model.HandOffMG.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.j):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandOffMG(String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8) {
        super(str, str2, str3, str4, str5, i2, str6, str7, str8);
        p.h(str, "icon");
        p.h(str2, "title");
        p.h(str3, "appID");
        p.h(str4, "appEntryPage");
        p.h(str5, "appUserName");
        p.h(str6, "from");
        p.h(str7, "to");
        p.h(str8, "key");
        AppMethodBeat.i(121715);
        AppMethodBeat.o(121715);
    }

    public HandOffMG() {
        this("", "", "", "", "", 0, null, null, null, 480, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HandOffMG(Parcel parcel) {
        super(parcel);
        p.h(parcel, "source");
        AppMethodBeat.i(121717);
        AppMethodBeat.o(121717);
    }

    @Override // com.tencent.mm.plugin.handoff.model.HandOffMP, com.tencent.mm.plugin.handoff.model.HandOff
    public final int getDataType() {
        return 4;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/handoff/model/HandOffMG$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMG;", "api-handoff_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/handoff/model/HandOffMG$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMG;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffMG;", "api-handoff_release"})
    public static final class b implements Parcelable.Creator<HandOffMG> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ HandOffMG createFromParcel(Parcel parcel) {
            AppMethodBeat.i(121713);
            p.h(parcel, "source");
            HandOffMG handOffMG = new HandOffMG(parcel);
            AppMethodBeat.o(121713);
            return handOffMG;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ HandOffMG[] newArray(int i2) {
            return new HandOffMG[i2];
        }
    }

    static {
        AppMethodBeat.i(121718);
        AppMethodBeat.o(121718);
    }

    @Override // com.tencent.mm.plugin.handoff.model.HandOffMP, com.tencent.mm.plugin.handoff.model.HandOff
    public final HandOff copy() {
        AppMethodBeat.i(121714);
        HandOffMG handOffMG = new HandOffMG(getIcon(), getTitle(), getAppID(), getAppEntryPage(), getAppUserName(), getHandOffType(), getFrom(), getTo(), getKey());
        handOffMG.setId(getId());
        HandOffMG handOffMG2 = handOffMG;
        AppMethodBeat.o(121714);
        return handOffMG2;
    }
}
