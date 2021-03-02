package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@Keep
public class MediaEditReportInfo implements Parcelable {
    public static final Parcelable.Creator<MediaEditReportInfo> CREATOR = new Parcelable.Creator<MediaEditReportInfo>() {
        /* class com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MediaEditReportInfo[] newArray(int i2) {
            return new MediaEditReportInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MediaEditReportInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(207039);
            MediaEditReportInfo mediaEditReportInfo = new MediaEditReportInfo(parcel);
            AppMethodBeat.o(207039);
            return mediaEditReportInfo;
        }
    };
    public int cropSizeCnt;
    public ArrayList<EditItem> editList = new ArrayList<>();
    public int seekBarDragCnt;

    public MediaEditReportInfo() {
        AppMethodBeat.i(207044);
        AppMethodBeat.o(207044);
    }

    protected MediaEditReportInfo(Parcel parcel) {
        AppMethodBeat.i(207045);
        this.seekBarDragCnt = parcel.readInt();
        this.cropSizeCnt = parcel.readInt();
        parcel.readList(this.editList, EditItem.class.getClassLoader());
        AppMethodBeat.o(207045);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(207046);
        parcel.writeInt(this.seekBarDragCnt);
        parcel.writeInt(this.cropSizeCnt);
        parcel.writeList(this.editList);
        AppMethodBeat.o(207046);
    }

    static {
        AppMethodBeat.i(207047);
        AppMethodBeat.o(207047);
    }

    @Keep
    public static class EditItem implements Parcelable {
        public static final Parcelable.Creator<EditItem> CREATOR = new Parcelable.Creator<EditItem>() {
            /* class com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ EditItem[] newArray(int i2) {
                return new EditItem[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ EditItem createFromParcel(Parcel parcel) {
                AppMethodBeat.i(207040);
                EditItem editItem = new EditItem(parcel);
                AppMethodBeat.o(207040);
                return editItem;
            }
        };
        public int clickEditCount;
        public int dragCount;
        public int durationCutCount;
        public int durationScrollCount;
        public boolean isBeauty;
        public long originDuration;
        public int scaleCount;
        public long targetDuration;
        public int type;

        public EditItem() {
        }

        protected EditItem(Parcel parcel) {
            AppMethodBeat.i(207041);
            this.type = parcel.readInt();
            this.isBeauty = parcel.readInt() != 0;
            this.originDuration = parcel.readLong();
            this.targetDuration = parcel.readLong();
            this.clickEditCount = parcel.readInt();
            this.durationCutCount = parcel.readInt();
            this.durationScrollCount = parcel.readInt();
            this.dragCount = parcel.readInt();
            this.scaleCount = parcel.readInt();
            AppMethodBeat.o(207041);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(207042);
            parcel.writeInt(this.type);
            parcel.writeInt(this.isBeauty ? 1 : 0);
            parcel.writeLong(this.originDuration);
            parcel.writeLong(this.targetDuration);
            parcel.writeInt(this.clickEditCount);
            parcel.writeInt(this.durationCutCount);
            parcel.writeInt(this.durationScrollCount);
            parcel.writeInt(this.dragCount);
            parcel.writeInt(this.scaleCount);
            AppMethodBeat.o(207042);
        }

        static {
            AppMethodBeat.i(207043);
            AppMethodBeat.o(207043);
        }
    }
}
