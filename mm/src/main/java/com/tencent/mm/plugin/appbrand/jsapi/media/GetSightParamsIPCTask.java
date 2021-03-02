package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00072\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0007\bB\u0005¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams;", "Lcom/tencent/mm/plugin/mmsight/SightParams;", "()V", "invoke", "data", "Companion", "TaskParams", "plugin-appbrand-integration_release"})
public final class GetSightParamsIPCTask implements k<TaskParams, SightParams> {
    public static final a mbY = new a((byte) 0);

    static {
        AppMethodBeat.i(50551);
        AppMethodBeat.o(50551);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.ipcinvoker.k
    public final /* synthetic */ SightParams invoke(TaskParams taskParams) {
        int i2 = 1;
        AppMethodBeat.i(50550);
        TaskParams taskParams2 = taskParams;
        p.h(taskParams2, "data");
        String str = "microMsg_" + Util.nowMilliSecond();
        String str2 = b.aKV() + "microMsg." + str + ".mp4";
        String str3 = b.aKV() + "microMsg." + str + ".jpeg";
        int i3 = taskParams2.maxDuration;
        if (taskParams2.mbZ == 2) {
            SightParams sightParams = new SightParams(3, 2);
            sightParams.zsL = b.aKV();
            sightParams.zsK = "microMsg." + System.currentTimeMillis() + ".jpg";
            AppMethodBeat.o(50550);
            return sightParams;
        }
        SightParams sightParams2 = new SightParams(3, 1);
        if (!taskParams2.isFront) {
            i2 = 2;
        }
        sightParams2.zsH = i2;
        sightParams2.mode = taskParams2.mbZ;
        if (sightParams2.irT == null) {
            sightParams2.irT = new VideoTransPara();
        }
        sightParams2.irT.duration = i3;
        sightParams2.zsO = false;
        sightParams2.v(str, str2, str3, AndroidMediaUtil.getSysCameraDirPath() + "capture" + Util.nowMilliSecond() + ".jpg");
        AppMethodBeat.o(50550);
        return sightParams2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$Companion;", "", "()V", "getSightParams", "Lcom/tencent/mm/plugin/mmsight/SightParams;", "sightMode", "", "maxDuration", "isFront", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static SightParams p(int i2, int i3, boolean z) {
            AppMethodBeat.i(180477);
            Object a2 = XIPCInvoker.a(MainProcessIPCService.dkO, new TaskParams(i2, i3, z), GetSightParamsIPCTask.class);
            p.g(a2, "XIPCInvoker.invokeSync(\n…aramsIPCTask::class.java)");
            SightParams sightParams = (SightParams) a2;
            AppMethodBeat.o(180477);
            return sightParams;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\tHÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0013\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0006H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams;", "Landroid/os/Parcelable;", LocaleUtil.INDONESIAN_NEWNAME, "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "sightMode", "", "maxDuration", "isFront", "", "(IIZ)V", "()Z", "getMaxDuration", "()I", "getSightMode", "component1", "component2", "component3", "copy", "describeContents", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
    public static final class TaskParams implements Parcelable {
        public static final a CREATOR = new a((byte) 0);
        final boolean isFront;
        final int maxDuration;
        final int mbZ;

        static {
            AppMethodBeat.i(50548);
            AppMethodBeat.o(50548);
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof TaskParams) {
                    TaskParams taskParams = (TaskParams) obj;
                    if (!(this.mbZ == taskParams.mbZ && this.maxDuration == taskParams.maxDuration && this.isFront == taskParams.isFront)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i2 = ((this.mbZ * 31) + this.maxDuration) * 31;
            boolean z = this.isFront;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return i3 + i2;
        }

        public final String toString() {
            AppMethodBeat.i(50549);
            String str = "TaskParams(sightMode=" + this.mbZ + ", maxDuration=" + this.maxDuration + ", isFront=" + this.isFront + ")";
            AppMethodBeat.o(50549);
            return str;
        }

        public TaskParams(int i2, int i3, boolean z) {
            this.mbZ = i2;
            this.maxDuration = i3;
            this.isFront = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public TaskParams(Parcel parcel) {
            this(parcel.readInt(), parcel.readInt(), parcel.readByte() != 0);
            p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
            AppMethodBeat.i(50547);
            AppMethodBeat.o(50547);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(50546);
            p.h(parcel, "dest");
            parcel.writeInt(this.mbZ);
            parcel.writeInt(this.maxDuration);
            parcel.writeByte(this.isFront ? (byte) 1 : 0);
            AppMethodBeat.o(50546);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/media/GetSightParamsIPCTask$TaskParams;", "plugin-appbrand-integration_release"})
        public static final class a implements Parcelable.Creator<TaskParams> {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TaskParams createFromParcel(Parcel parcel) {
                AppMethodBeat.i(50545);
                p.h(parcel, "source");
                TaskParams taskParams = new TaskParams(parcel);
                AppMethodBeat.o(50545);
                return taskParams;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ TaskParams[] newArray(int i2) {
                return new TaskParams[i2];
            }
        }
    }
}
