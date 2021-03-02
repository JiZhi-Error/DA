package com.tencent.mm.plugin.multitask;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\b\u0016\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005B\u000f\b\u0014\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "Landroid/os/Parcelable;", "taskInfoList", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "(Ljava/util/List;)V", LocaleUtil.INDONESIAN_NEWNAME, "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "multiTaskInfoList", "getMultiTaskInfoList", "()Ljava/util/List;", "setMultiTaskInfoList", "describeContents", "", "writeToParcel", "", "dest", "flags", "Companion", "plugin-multitask_release"})
final class MultiTaskListParcel implements Parcelable {
    public static final Parcelable.Creator<MultiTaskListParcel> CREATOR = new b();
    public static final a zZl = new a((byte) 0);
    List<? extends MultiTaskInfo> zZk;

    public MultiTaskListParcel(List<? extends MultiTaskInfo> list) {
        this.zZk = list;
    }

    protected MultiTaskListParcel(Parcel parcel) {
        p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
        AppMethodBeat.i(200299);
        this.zZk = parcel.createTypedArrayList(MultiTaskInfo.CREATOR);
        AppMethodBeat.o(200299);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(200298);
        p.h(parcel, "dest");
        parcel.writeTypedList(this.zZk);
        AppMethodBeat.o(200298);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "plugin-multitask_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/multitask/MultiTaskListParcel$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "createFromParcel", LocaleUtil.INDONESIAN_NEWNAME, "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/multitask/MultiTaskListParcel;", "plugin-multitask_release"})
    public static final class b implements Parcelable.Creator<MultiTaskListParcel> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MultiTaskListParcel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(200297);
            p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
            MultiTaskListParcel multiTaskListParcel = new MultiTaskListParcel(parcel);
            AppMethodBeat.o(200297);
            return multiTaskListParcel;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MultiTaskListParcel[] newArray(int i2) {
            return new MultiTaskListParcel[i2];
        }
    }

    static {
        AppMethodBeat.i(200300);
        AppMethodBeat.o(200300);
    }
}
