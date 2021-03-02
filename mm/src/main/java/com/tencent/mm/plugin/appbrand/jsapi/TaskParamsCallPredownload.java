package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\tHÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\tH\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/TaskParamsCallPredownload;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", ch.COL_USERNAME, "", "path", "scene", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getPath", "()Ljava/lang/String;", "getScene", "()I", "getUsername", "component1", "component2", "component3", "copy", "describeContents", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
final class TaskParamsCallPredownload implements Parcelable {
    public static final Parcelable.Creator<TaskParamsCallPredownload> CREATOR = new b();
    public static final a lCN = new a((byte) 0);
    final String path;
    final int scene;
    final String username;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r3.scene == r4.scene) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 50429(0xc4fd, float:7.0666E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0028
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.jsapi.TaskParamsCallPredownload
            if (r0 == 0) goto L_0x002d
            com.tencent.mm.plugin.appbrand.jsapi.TaskParamsCallPredownload r4 = (com.tencent.mm.plugin.appbrand.jsapi.TaskParamsCallPredownload) r4
            java.lang.String r0 = r3.username
            java.lang.String r1 = r4.username
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r3.path
            java.lang.String r1 = r4.path
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x002d
            int r0 = r3.scene
            int r1 = r4.scene
            if (r0 != r1) goto L_0x002d
        L_0x0028:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x002c:
            return r0
        L_0x002d:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.TaskParamsCallPredownload.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(50428);
        String str = this.username;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.path;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = ((hashCode + i2) * 31) + this.scene;
        AppMethodBeat.o(50428);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(50427);
        String str = "TaskParamsCallPredownload(username=" + this.username + ", path=" + this.path + ", scene=" + this.scene + ")";
        AppMethodBeat.o(50427);
        return str;
    }

    public TaskParamsCallPredownload(String str, String str2, int i2) {
        this.username = str;
        this.path = str2;
        this.scene = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TaskParamsCallPredownload(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readInt());
        p.h(parcel, "source");
        AppMethodBeat.i(50425);
        AppMethodBeat.o(50425);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(50424);
        p.h(parcel, "dest");
        parcel.writeString(this.username);
        parcel.writeString(this.path);
        parcel.writeInt(this.scene);
        AppMethodBeat.o(50424);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/TaskParamsCallPredownload$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/TaskParamsCallPredownload;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/TaskParamsCallPredownload$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/TaskParamsCallPredownload;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/TaskParamsCallPredownload;", "plugin-appbrand-integration_release"})
    public static final class b implements Parcelable.Creator<TaskParamsCallPredownload> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaskParamsCallPredownload createFromParcel(Parcel parcel) {
            AppMethodBeat.i(50423);
            p.h(parcel, "source");
            TaskParamsCallPredownload taskParamsCallPredownload = new TaskParamsCallPredownload(parcel);
            AppMethodBeat.o(50423);
            return taskParamsCallPredownload;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TaskParamsCallPredownload[] newArray(int i2) {
            return new TaskParamsCallPredownload[i2];
        }
    }

    static {
        AppMethodBeat.i(50426);
        AppMethodBeat.o(50426);
    }
}
