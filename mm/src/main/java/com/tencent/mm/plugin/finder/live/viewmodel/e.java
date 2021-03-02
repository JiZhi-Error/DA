package com.tencent.mm.plugin.finder.live.viewmodel;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b¢\u0006\u0002\u0010\u0014J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\bHÆ\u0001J\u0013\u00108\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\bHÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020=J\u0006\u0010?\u001a\u00020=R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001d\"\u0004\b\u001f\u0010 R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001a¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "", "sdkUserId", "", "headUrl", ch.COL_USERNAME, "nickname", "micType", "", "sessionId", "pkSign", "Lcom/tencent/mm/protobuf/ByteString;", "isPkWithAnchor", "", "sdkLiveId", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "signature", "micStatus", "liveContactFlag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ZILcom/tencent/mm/protocal/protobuf/FinderAuthInfo;Ljava/lang/String;II)V", "getAuthInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "setAuthInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;)V", "getHeadUrl", "()Ljava/lang/String;", "()Z", "getLiveContactFlag", "()I", "getMicStatus", "setMicStatus", "(I)V", "getMicType", "getNickname", "getPkSign", "()Lcom/tencent/mm/protobuf/ByteString;", "getSdkLiveId", "getSdkUserId", "getSessionId", "getSignature", "getUsername", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "transToDefaultState", "", "transToLinkedState", "transToWaitingState", "plugin-finder_release"})
public final class e {
    private final b UPM;
    public final boolean UPN;
    public int UPO;
    public final int UPP;
    public FinderAuthInfo authInfo;
    public final int hFB;
    public final String headUrl;
    public final String nickname;
    public final String sessionId;
    public final String signature;
    public final String uCo;
    public final int uCx;
    public final String username;

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007a, code lost:
        if (r3.UPP == r4.UPP) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
        // Method dump skipped, instructions count: 134
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(247887);
        String str = this.uCo;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.headUrl;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.username;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        String str4 = this.nickname;
        int hashCode4 = ((((str4 != null ? str4.hashCode() : 0) + hashCode3) * 31) + this.uCx) * 31;
        String str5 = this.sessionId;
        int hashCode5 = ((str5 != null ? str5.hashCode() : 0) + hashCode4) * 31;
        b bVar = this.UPM;
        int hashCode6 = ((bVar != null ? bVar.hashCode() : 0) + hashCode5) * 31;
        boolean z = this.UPN;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (((i3 + hashCode6) * 31) + this.hFB) * 31;
        FinderAuthInfo finderAuthInfo = this.authInfo;
        int hashCode7 = ((finderAuthInfo != null ? finderAuthInfo.hashCode() : 0) + i6) * 31;
        String str6 = this.signature;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i7 = ((((hashCode7 + i2) * 31) + this.UPO) * 31) + this.UPP;
        AppMethodBeat.o(247887);
        return i7;
    }

    public final String toString() {
        AppMethodBeat.i(247886);
        String str = "FinderLiveLinkMicUser(sdkUserId=" + this.uCo + ", headUrl=" + this.headUrl + ", username=" + this.username + ", nickname=" + this.nickname + ", micType=" + this.uCx + ", sessionId=" + this.sessionId + ", pkSign=" + this.UPM + ", isPkWithAnchor=" + this.UPN + ", sdkLiveId=" + this.hFB + ", authInfo=" + this.authInfo + ", signature=" + this.signature + ", micStatus=" + this.UPO + ", liveContactFlag=" + this.UPP + ")";
        AppMethodBeat.o(247886);
        return str;
    }

    private e(String str, String str2, String str3, String str4, int i2, String str5, b bVar, boolean z, int i3, FinderAuthInfo finderAuthInfo, String str6, int i4, int i5) {
        this.uCo = str;
        this.headUrl = str2;
        this.username = str3;
        this.nickname = str4;
        this.uCx = i2;
        this.sessionId = str5;
        this.UPM = bVar;
        this.UPN = z;
        this.hFB = i3;
        this.authInfo = finderAuthInfo;
        this.signature = str6;
        this.UPO = i4;
        this.UPP = i5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ e(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, java.lang.String r21, com.tencent.mm.bw.b r22, boolean r23, int r24, com.tencent.mm.protocal.protobuf.FinderAuthInfo r25, java.lang.String r26, int r27, int r28, int r29) {
        /*
            r15 = this;
            r1 = r29 & 64
            if (r1 == 0) goto L_0x005e
            r8 = 0
        L_0x0005:
            r0 = r29
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x005b
            r9 = 0
        L_0x000c:
            r0 = r29
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0058
            r10 = 0
        L_0x0013:
            r0 = r29
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0055
            r11 = 0
        L_0x001a:
            r0 = r29
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0052
            r12 = 0
        L_0x0021:
            r0 = r29
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x004f
            r13 = 0
        L_0x0028:
            r0 = r29
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x004c
            r14 = 0
        L_0x002f:
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r1 = 261043(0x3fbb3, float:3.65799E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            r1 = 261043(0x3fbb3, float:3.65799E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            return
        L_0x004c:
            r14 = r28
            goto L_0x002f
        L_0x004f:
            r13 = r27
            goto L_0x0028
        L_0x0052:
            r12 = r26
            goto L_0x0021
        L_0x0055:
            r11 = r25
            goto L_0x001a
        L_0x0058:
            r10 = r24
            goto L_0x0013
        L_0x005b:
            r9 = r23
            goto L_0x000c
        L_0x005e:
            r8 = r22
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.viewmodel.e.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, com.tencent.mm.bw.b, boolean, int, com.tencent.mm.protocal.protobuf.FinderAuthInfo, java.lang.String, int, int, int):void");
    }

    public final void hTQ() {
        int i2 = 2;
        if (this.uCx != 2) {
            if (this.uCx == 1) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        }
        this.UPO = i2;
    }

    public final void hTR() {
        int i2;
        if (this.uCx == 2) {
            i2 = 4;
        } else if (this.uCx == 1) {
            i2 = 3;
        } else {
            i2 = 0;
        }
        this.UPO = i2;
    }
}
