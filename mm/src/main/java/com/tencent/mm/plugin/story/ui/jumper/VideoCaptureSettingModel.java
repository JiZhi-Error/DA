package com.tencent.mm.plugin.story.ui.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B)\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001eHÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u001eH\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "videoFilePath", "", "videoThumbPath", "enablePicture", "", "forceForegroundMix", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getEnablePicture", "()Z", "setEnablePicture", "(Z)V", "getForceForegroundMix", "setForceForegroundMix", "getVideoFilePath", "()Ljava/lang/String;", "setVideoFilePath", "(Ljava/lang/String;)V", "getVideoThumbPath", "setVideoThumbPath", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "flags", "Companion", "plugin-story_release"})
public final class VideoCaptureSettingModel implements Parcelable {
    public static final Parcelable.Creator<VideoCaptureSettingModel> CREATOR = new b();
    public static final a FzL = new a((byte) 0);
    private boolean BRu;
    private boolean FzK;
    private String lPw;
    private String mss;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r3.FzK == r4.FzK) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 119914(0x1d46a, float:1.68035E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x002e
            boolean r0 = r4 instanceof com.tencent.mm.plugin.story.ui.jumper.VideoCaptureSettingModel
            if (r0 == 0) goto L_0x0033
            com.tencent.mm.plugin.story.ui.jumper.VideoCaptureSettingModel r4 = (com.tencent.mm.plugin.story.ui.jumper.VideoCaptureSettingModel) r4
            java.lang.String r0 = r3.lPw
            java.lang.String r1 = r4.lPw
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = r3.mss
            java.lang.String r1 = r4.mss
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0033
            boolean r0 = r3.BRu
            boolean r1 = r4.BRu
            if (r0 != r1) goto L_0x0033
            boolean r0 = r3.FzK
            boolean r1 = r4.FzK
            if (r0 != r1) goto L_0x0033
        L_0x002e:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0032:
            return r0
        L_0x0033:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.jumper.VideoCaptureSettingModel.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 1;
        int i3 = 0;
        AppMethodBeat.i(119913);
        String str = this.lPw;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mss;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        int i4 = (hashCode + i3) * 31;
        boolean z = this.BRu;
        if (z) {
            z = true;
        }
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = z ? 1 : 0;
        int i8 = (i5 + i4) * 31;
        boolean z2 = this.FzK;
        if (!z2) {
            i2 = z2 ? 1 : 0;
        }
        int i9 = i8 + i2;
        AppMethodBeat.o(119913);
        return i9;
    }

    public final String toString() {
        AppMethodBeat.i(119912);
        String str = "VideoCaptureSettingModel(videoFilePath=" + this.lPw + ", videoThumbPath=" + this.mss + ", enablePicture=" + this.BRu + ", forceForegroundMix=" + this.FzK + ")";
        AppMethodBeat.o(119912);
        return str;
    }

    private VideoCaptureSettingModel(String str, String str2, boolean z, boolean z2) {
        p.h(str, "videoFilePath");
        p.h(str2, "videoThumbPath");
        AppMethodBeat.i(119909);
        this.lPw = str;
        this.mss = str2;
        this.BRu = z;
        this.FzK = z2;
        AppMethodBeat.o(119909);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public VideoCaptureSettingModel(android.os.Parcel r8) {
        /*
            r7 = this;
            r6 = 119910(0x1d466, float:1.6803E-40)
            r2 = 0
            r1 = 1
            java.lang.String r0 = "source"
            kotlin.g.b.p.h(r8, r0)
            java.lang.String r0 = r8.readString()
            java.lang.String r3 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r8.readString()
            java.lang.String r4 = java.lang.String.valueOf(r0)
            int r0 = r8.readInt()
            if (r1 != r0) goto L_0x0032
            r0 = r1
        L_0x0022:
            int r5 = r8.readInt()
            if (r1 != r5) goto L_0x0034
        L_0x0028:
            r7.<init>(r3, r4, r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x0032:
            r0 = r2
            goto L_0x0022
        L_0x0034:
            r1 = r2
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.jumper.VideoCaptureSettingModel.<init>(android.os.Parcel):void");
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int i3;
        int i4 = 1;
        AppMethodBeat.i(119908);
        p.h(parcel, "dest");
        parcel.writeString(this.lPw);
        parcel.writeString(this.mss);
        if (this.BRu) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        if (!this.FzK) {
            i4 = 0;
        }
        parcel.writeInt(i4);
        AppMethodBeat.o(119908);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel;", "generateNormalModel", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/story/ui/jumper/VideoCaptureSettingModel;", "plugin-story_release"})
    public static final class b implements Parcelable.Creator<VideoCaptureSettingModel> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ VideoCaptureSettingModel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(119907);
            p.h(parcel, "source");
            VideoCaptureSettingModel videoCaptureSettingModel = new VideoCaptureSettingModel(parcel);
            AppMethodBeat.o(119907);
            return videoCaptureSettingModel;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ VideoCaptureSettingModel[] newArray(int i2) {
            return new VideoCaptureSettingModel[i2];
        }
    }

    static {
        AppMethodBeat.i(119911);
        AppMethodBeat.o(119911);
    }
}
