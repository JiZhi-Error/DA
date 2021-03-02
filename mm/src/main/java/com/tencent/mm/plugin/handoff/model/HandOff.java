package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.protocal.protobuf.cru;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@Keep
@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b'\u0018\u0000 32\u00020\u0001:\u00013B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B9\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010!\u001a\u00020\bH$J\b\u0010\"\u001a\u00020\bH\u0007J\b\u0010#\u001a\u00020\u0000H&J\b\u0010$\u001a\u0004\u0018\u00010%J\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'J\n\u0010*\u001a\u0004\u0018\u00010%H$J\u0016\u0010+\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0018\u00010'H$J\b\u0010,\u001a\u00020\u0006H&J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0000H\u0016J\u0018\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0006H\u0016R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\n\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "handOffType", "", "from", "", "to", "key", "id", "createTime", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "getFrom", "()Ljava/lang/String;", "setFrom", "(Ljava/lang/String;)V", "getHandOffType", "()I", "setHandOffType", "(I)V", "getId", "setId", "getKey", "setKey", "getTo", "setTo", "body", "build", "copy", "createBallInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "createMultiTaskInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "", "doCreateBallInfo", "doCreateMultiTaskInfo", "getDataType", "update", "", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public abstract class HandOff implements Parcelable {
    public static final a Companion = new a((byte) 0);
    public static final String KId = "handoff#id";
    private long createTime;
    private String from;
    private int handOffType;
    private String id;
    private String key;
    private String to;

    public static final String generateKey(int i2, int i3) {
        return a.generateKey(i2, i3);
    }

    /* access modifiers changed from: protected */
    public abstract String body();

    public abstract HandOff copy();

    /* access modifiers changed from: protected */
    public abstract BallInfo doCreateBallInfo();

    /* access modifiers changed from: protected */
    public abstract o<cru, byte[]> doCreateMultiTaskInfo();

    public abstract int getDataType();

    public HandOff(int i2, String str, String str2, String str3, String str4, long j2) {
        p.h(str, "from");
        p.h(str2, "to");
        p.h(str3, "key");
        p.h(str4, "id");
        this.handOffType = i2;
        this.from = str;
        this.to = str2;
        this.key = str3;
        this.id = str4;
        this.createTime = j2;
    }

    public final int getHandOffType() {
        return this.handOffType;
    }

    public final void setHandOffType(int i2) {
        this.handOffType = i2;
    }

    public final String getFrom() {
        return this.from;
    }

    public final void setFrom(String str) {
        p.h(str, "<set-?>");
        this.from = str;
    }

    public final String getTo() {
        return this.to;
    }

    public final void setTo(String str) {
        p.h(str, "<set-?>");
        this.to = str;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        p.h(str, "<set-?>");
        this.key = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ HandOff(int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, long r14, int r16, kotlin.g.b.j r17) {
        /*
            r8 = this;
            r0 = r16 & 16
            if (r0 == 0) goto L_0x0025
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "UUID.randomUUID().toString()"
            kotlin.g.b.p.g(r5, r0)
        L_0x0012:
            r0 = r16 & 32
            if (r0 == 0) goto L_0x0023
            long r6 = java.lang.System.currentTimeMillis()
        L_0x001a:
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        L_0x0023:
            r6 = r14
            goto L_0x001a
        L_0x0025:
            r5 = r13
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.handoff.model.HandOff.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, int, kotlin.g.b.j):void");
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        p.h(str, "<set-?>");
        this.id = str;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(long j2) {
        this.createTime = j2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/handoff/model/HandOff$Companion;", "", "()V", "KId", "", "generateKey", "dataType", "", "handOffType", "api-handoff_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String generateKey(int i2, int i3) {
            AppMethodBeat.i(121692);
            String sb = new StringBuilder().append(i2).append('_').append(i3).append('_').append(System.currentTimeMillis()).toString();
            AppMethodBeat.o(121692);
            return sb;
        }
    }

    public void update(HandOff handOff) {
        p.h(handOff, "newHandOff");
    }

    public final BallInfo createBallInfo() {
        BallInfo doCreateBallInfo = doCreateBallInfo();
        if (doCreateBallInfo == null) {
            return null;
        }
        doCreateBallInfo.jkf.putString(KId, this.id);
        return doCreateBallInfo;
    }

    public final o<cru, byte[]> createMultiTaskInfo() {
        return doCreateMultiTaskInfo();
    }

    public final String build() {
        return n.buv("\n    <handoff type=\"" + getDataType() + "\" id=\"" + this.id + "\" createtime=\"" + this.createTime + "\" from=\"" + this.from + "\" to=\"" + this.to + "\">\n        <handofftype>" + a.du(Integer.valueOf(this.handOffType)) + "</handofftype>\n        " + body() + "\n    </handoff>\n    ");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HandOff(android.os.Parcel r9) {
        /*
            r8 = this;
            java.lang.String r0 = "source"
            kotlin.g.b.p.h(r9, r0)
            int r1 = r9.readInt()
            java.lang.String r2 = r9.readString()
            if (r2 != 0) goto L_0x0013
            kotlin.g.b.p.hyc()
        L_0x0013:
            java.lang.String r0 = "source.readString()!!"
            kotlin.g.b.p.g(r2, r0)
            java.lang.String r3 = r9.readString()
            if (r3 != 0) goto L_0x0022
            kotlin.g.b.p.hyc()
        L_0x0022:
            java.lang.String r0 = "source.readString()!!"
            kotlin.g.b.p.g(r3, r0)
            java.lang.String r4 = r9.readString()
            if (r4 != 0) goto L_0x0031
            kotlin.g.b.p.hyc()
        L_0x0031:
            java.lang.String r0 = "source.readString()!!"
            kotlin.g.b.p.g(r4, r0)
            java.lang.String r5 = r9.readString()
            if (r5 != 0) goto L_0x0040
            kotlin.g.b.p.hyc()
        L_0x0040:
            java.lang.String r0 = "source.readString()!!"
            kotlin.g.b.p.g(r5, r0)
            long r6 = r9.readLong()
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.handoff.model.HandOff.<init>(android.os.Parcel):void");
    }

    public void writeToParcel(Parcel parcel, int i2) {
        p.h(parcel, "dest");
        parcel.writeInt(this.handOffType);
        parcel.writeString(this.from);
        parcel.writeString(this.to);
        parcel.writeString(this.key);
        parcel.writeString(this.id);
        parcel.writeLong(this.createTime);
    }
}
