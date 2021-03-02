package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.f;

public final class d {
    private String ENE;
    a.bb Sup;
    private a.bc Suq;

    public d(a.bb bbVar) {
        AppMethodBeat.i(199670);
        a(bbVar);
        AppMethodBeat.o(199670);
    }

    public d(a.bb bbVar, a.bc bcVar) {
        AppMethodBeat.i(199671);
        a(bbVar);
        if (bcVar == null) {
            b.w("tagorewang:TalkRoomMember", "set null profile");
            AppMethodBeat.o(199671);
            return;
        }
        this.Suq = bcVar;
        AppMethodBeat.o(199671);
    }

    public final void a(a.bb bbVar) {
        AppMethodBeat.i(199672);
        if (bbVar == null) {
            b.w("tagorewang:TalkRoomMember", "set null info");
            AppMethodBeat.o(199672);
            return;
        }
        this.Sup = bbVar;
        AppMethodBeat.o(199672);
    }

    public final String hra() {
        if (this.Sup != null) {
            return this.Sup.dLN;
        }
        return "";
    }

    public final String getDisplayName() {
        AppMethodBeat.i(62595);
        try {
            String str = this.ENE;
            if (str == null || str.trim().length() == 0) {
                AppMethodBeat.o(62595);
                return str;
            }
            char[] charArray = str.trim().toCharArray();
            int i2 = 0;
            for (char c2 : charArray) {
                if (c2 >= 161) {
                    i2 += 2;
                } else {
                    i2++;
                }
            }
            if (i2 <= 10) {
                AppMethodBeat.o(62595);
                return str;
            }
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            for (int i4 = 0; i4 < charArray.length; i4++) {
                if (charArray[i4] >= 161) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 + 1 > 10) {
                    break;
                }
                sb.append(charArray[i4]);
            }
            sb.append((char) 8230);
            String sb2 = sb.toString();
            AppMethodBeat.o(62595);
            return sb2;
        } catch (Exception e2) {
            b.w("tagorewang:TalkRoomMember", "getDisplayName err: ", e2);
            String str2 = this.ENE;
            AppMethodBeat.o(62595);
            return str2;
        }
    }

    public final int getState() {
        if (this.Sup == null) {
            return 0;
        }
        return this.Sup.status;
    }

    public final int getMemberId() {
        if (this.Sup == null) {
            return -1;
        }
        return this.Sup.qrD;
    }

    public final String toString() {
        String sb;
        String sb2;
        AppMethodBeat.i(62596);
        int i2 = 0;
        if (this.Sup != null) {
            i2 = this.Sup.KBb;
        } else if (this.Suq != null) {
            i2 = this.Suq.KBb;
        }
        if (this.Sup == null || this.Suq == null) {
            String concat = "invlaid TalkRoomMember which uuid is ".concat(String.valueOf(i2));
            AppMethodBeat.o(62596);
            return concat;
        }
        StringBuilder sb3 = new StringBuilder();
        a.bb bbVar = this.Sup;
        if (bbVar == null) {
            sb = BuildConfig.COMMAND;
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("VoiceGroupMem");
            sb4.append(" uuid:").append(bbVar.KBb);
            sb4.append(" openClientId:").append(bbVar.RGi);
            sb4.append(" invite uuid: ").append(bbVar.RGe);
            sb4.append(" member id:").append(bbVar.qrD);
            sb4.append(" status: ").append(bbVar.status);
            sb4.append(" reason: ").append(bbVar.bDZ);
            sb = sb4.toString();
        }
        StringBuilder append = sb3.append(sb).append(" ");
        a.bc bcVar = this.Suq;
        if (bcVar == null) {
            sb2 = BuildConfig.COMMAND;
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("VoiceGroupUsrProfile");
            sb5.append(" uuid: ").append(bcVar.KBb);
            sb5.append(" user name: ").append(bcVar.username);
            sb5.append(" head url: ").append(bcVar.headUrl);
            sb2 = sb5.toString();
        }
        append.append(sb2);
        String sb6 = sb3.toString();
        AppMethodBeat.o(62596);
        return sb6;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(62597);
        if (obj == null || !(obj instanceof d)) {
            AppMethodBeat.o(62597);
            return false;
        }
        boolean equals = f.equals(hra(), ((d) obj).hra());
        AppMethodBeat.o(62597);
        return equals;
    }

    public final int hashCode() {
        AppMethodBeat.i(62598);
        String hra = hra();
        if (hra == null) {
            AppMethodBeat.o(62598);
            return 0;
        }
        int hashCode = hra.hashCode();
        AppMethodBeat.o(62598);
        return hashCode;
    }

    public final boolean isSelf() {
        AppMethodBeat.i(62599);
        boolean equals = f.equals(com.tencent.pb.a.a.a.hjq(), hra());
        AppMethodBeat.o(62599);
        return equals;
    }
}
