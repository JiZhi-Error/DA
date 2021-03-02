package com.tencent.mm.plugin.multitalk.data;

import android.view.View;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0010\u001a\u00020\tHÆ\u0003J\t\u0010\u0011\u001a\u00020\u000bHÆ\u0003J;\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0016\u001a\u00020\u000bHÖ\u0001R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/data/MultitalkAvatarViewData;", "", "member", "Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", FirebaseAnalytics.b.INDEX, "", "isRenderVideo", "", "nickName", "", "(Lcom/tencent/pb/talkroom/sdk/MultiTalkGroupMember;Landroid/view/View$OnClickListener;IZLjava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-multitalk_release"})
public final class a {
    public int index;
    public String nickName;
    public MultiTalkGroupMember zHg;
    public View.OnClickListener zHh;
    public boolean zHi;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (kotlin.g.b.p.j(r3.nickName, r4.nickName) != false) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 178953(0x2bb09, float:2.50767E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0038
            boolean r0 = r4 instanceof com.tencent.mm.plugin.multitalk.data.a
            if (r0 == 0) goto L_0x003d
            com.tencent.mm.plugin.multitalk.data.a r4 = (com.tencent.mm.plugin.multitalk.data.a) r4
            com.tencent.pb.talkroom.sdk.MultiTalkGroupMember r0 = r3.zHg
            com.tencent.pb.talkroom.sdk.MultiTalkGroupMember r1 = r4.zHg
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003d
            android.view.View$OnClickListener r0 = r3.zHh
            android.view.View$OnClickListener r1 = r4.zHh
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003d
            int r0 = r3.index
            int r1 = r4.index
            if (r0 != r1) goto L_0x003d
            boolean r0 = r3.zHi
            boolean r1 = r4.zHi
            if (r0 != r1) goto L_0x003d
            java.lang.String r0 = r3.nickName
            java.lang.String r1 = r4.nickName
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003d
        L_0x0038:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x003c:
            return r0
        L_0x003d:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.data.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(178952);
        MultiTalkGroupMember multiTalkGroupMember = this.zHg;
        int hashCode = (multiTalkGroupMember != null ? multiTalkGroupMember.hashCode() : 0) * 31;
        View.OnClickListener onClickListener = this.zHh;
        int hashCode2 = ((((onClickListener != null ? onClickListener.hashCode() : 0) + hashCode) * 31) + this.index) * 31;
        boolean z = this.zHi;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (i3 + hashCode2) * 31;
        String str = this.nickName;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i7 = i6 + i2;
        AppMethodBeat.o(178952);
        return i7;
    }

    public final String toString() {
        AppMethodBeat.i(178951);
        String str = "MultitalkAvatarViewData(member=" + this.zHg + ", listener=" + this.zHh + ", index=" + this.index + ", isRenderVideo=" + this.zHi + ", nickName=" + this.nickName + ")";
        AppMethodBeat.o(178951);
        return str;
    }

    public a(MultiTalkGroupMember multiTalkGroupMember, View.OnClickListener onClickListener, int i2, boolean z, String str) {
        p.h(multiTalkGroupMember, "member");
        p.h(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        p.h(str, "nickName");
        AppMethodBeat.i(239554);
        this.zHg = multiTalkGroupMember;
        this.zHh = onClickListener;
        this.index = i2;
        this.zHi = z;
        this.nickName = str;
        AppMethodBeat.o(239554);
    }
}
