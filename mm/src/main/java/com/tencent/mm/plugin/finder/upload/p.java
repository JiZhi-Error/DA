package com.tencent.mm.plugin.finder.upload;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.m;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cjk;
import java.util.ArrayList;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b0\b\b\u0018\u00002\u00020\u0001B·\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ\t\u00107\u001a\u00020\u0003HÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013HÆ\u0003J\t\u00109\u001a\u00020\u0010HÆ\u0003J\t\u0010:\u001a\u00020\u0010HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010F\u001a\u00020\u0010HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003JÇ\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00052\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÆ\u0001J\u0013\u0010I\u001a\u00020\u00102\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\u0003HÖ\u0001J\t\u0010L\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010)R\u0011\u0010\u0015\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010)R\u0011\u0010\u0016\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010)R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010/R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010$¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/HoldingPostData;", "", "mediaType", "", "description", "", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "extendedReading", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "originalFlag", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "isFromCamera", "", "videoPathBeforeCut", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "isLongVideo", "isNewsFeed", "fromAppInfo", "Lcom/tencent/mm/protocal/protobuf/FinderFromAppInfo;", "remoteUrl", "paramsJson", "sdkShareType", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;ILcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;ZLjava/lang/String;Ljava/util/ArrayList;ZZLcom/tencent/mm/protocal/protobuf/FinderFromAppInfo;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;)V", "getActivityEvent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "getAtContactList", "()Ljava/util/ArrayList;", "getDescription", "()Ljava/lang/String;", "getExtendedReading", "()Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "getFromAppInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderFromAppInfo;", "()Z", "getLocalContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", m.NAME, "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getMediaType", "()I", "getOriginalFlag", "getParamsJson", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRemoteUrl", "getSdkShareType", "getVideoPathBeforeCut", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-finder_release"})
public final class p {
    final String description;
    public final boolean isLongVideo;
    final axt location;
    public final int mediaType;
    final int originalFlag;
    public final int sdkShareType;
    final String tsW;
    final String tsX;
    final boolean vTA;
    final String vTB;
    final ArrayList<cjj> vTC;
    final boolean vTD;
    final arm vTE;
    final azs vTF;
    final cjk vTx;
    final aqp vTy;
    final azy vTz;

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009e, code lost:
        if (kotlin.g.b.p.j(r3.vTF, r4.vTF) != false) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
        // Method dump skipped, instructions count: 170
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.p.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 1;
        int i3 = 0;
        AppMethodBeat.i(253137);
        int i4 = this.mediaType * 31;
        String str = this.description;
        int hashCode = ((str != null ? str.hashCode() : 0) + i4) * 31;
        cjk cjk = this.vTx;
        int hashCode2 = ((cjk != null ? cjk.hashCode() : 0) + hashCode) * 31;
        axt axt = this.location;
        int hashCode3 = ((axt != null ? axt.hashCode() : 0) + hashCode2) * 31;
        aqp aqp = this.vTy;
        int hashCode4 = ((((aqp != null ? aqp.hashCode() : 0) + hashCode3) * 31) + this.originalFlag) * 31;
        azy azy = this.vTz;
        int hashCode5 = ((azy != null ? azy.hashCode() : 0) + hashCode4) * 31;
        boolean z = this.vTA;
        if (z) {
            z = true;
        }
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = z ? 1 : 0;
        int i8 = (i5 + hashCode5) * 31;
        String str2 = this.vTB;
        int hashCode6 = ((str2 != null ? str2.hashCode() : 0) + i8) * 31;
        ArrayList<cjj> arrayList = this.vTC;
        int hashCode7 = ((arrayList != null ? arrayList.hashCode() : 0) + hashCode6) * 31;
        boolean z2 = this.isLongVideo;
        if (z2) {
            z2 = true;
        }
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = z2 ? 1 : 0;
        int i12 = (i9 + hashCode7) * 31;
        boolean z3 = this.vTD;
        if (!z3) {
            i2 = z3 ? 1 : 0;
        }
        int i13 = (i12 + i2) * 31;
        arm arm = this.vTE;
        int hashCode8 = ((arm != null ? arm.hashCode() : 0) + i13) * 31;
        String str3 = this.tsW;
        int hashCode9 = ((str3 != null ? str3.hashCode() : 0) + hashCode8) * 31;
        String str4 = this.tsX;
        int hashCode10 = ((((str4 != null ? str4.hashCode() : 0) + hashCode9) * 31) + this.sdkShareType) * 31;
        azs azs = this.vTF;
        if (azs != null) {
            i3 = azs.hashCode();
        }
        int i14 = hashCode10 + i3;
        AppMethodBeat.o(253137);
        return i14;
    }

    public final String toString() {
        AppMethodBeat.i(253136);
        String str = "HoldingPostData(mediaType=" + this.mediaType + ", description=" + this.description + ", localContent=" + this.vTx + ", location=" + this.location + ", extendedReading=" + this.vTy + ", originalFlag=" + this.originalFlag + ", refFeed=" + this.vTz + ", isFromCamera=" + this.vTA + ", videoPathBeforeCut=" + this.vTB + ", atContactList=" + this.vTC + ", isLongVideo=" + this.isLongVideo + ", isNewsFeed=" + this.vTD + ", fromAppInfo=" + this.vTE + ", remoteUrl=" + this.tsW + ", paramsJson=" + this.tsX + ", sdkShareType=" + this.sdkShareType + ", activityEvent=" + this.vTF + ")";
        AppMethodBeat.o(253136);
        return str;
    }

    public p(int i2, String str, cjk cjk, axt axt, aqp aqp, int i3, azy azy, boolean z, String str2, ArrayList<cjj> arrayList, boolean z2, boolean z3, arm arm, String str3, String str4, int i4, azs azs) {
        kotlin.g.b.p.h(str, "description");
        kotlin.g.b.p.h(str2, "videoPathBeforeCut");
        kotlin.g.b.p.h(str3, "remoteUrl");
        kotlin.g.b.p.h(str4, "paramsJson");
        AppMethodBeat.i(253135);
        this.mediaType = i2;
        this.description = str;
        this.vTx = cjk;
        this.location = axt;
        this.vTy = aqp;
        this.originalFlag = i3;
        this.vTz = azy;
        this.vTA = z;
        this.vTB = str2;
        this.vTC = arrayList;
        this.isLongVideo = z2;
        this.vTD = z3;
        this.vTE = arm;
        this.tsW = str3;
        this.tsX = str4;
        this.sdkShareType = i4;
        this.vTF = azs;
        AppMethodBeat.o(253135);
    }
}
