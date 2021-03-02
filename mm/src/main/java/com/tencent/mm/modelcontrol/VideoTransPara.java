package com.tencent.mm.modelcontrol;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VideoTransPara implements Parcelable, Cloneable {
    public static final Parcelable.Creator<VideoTransPara> CREATOR = new Parcelable.Creator<VideoTransPara>() {
        /* class com.tencent.mm.modelcontrol.VideoTransPara.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ VideoTransPara[] newArray(int i2) {
            return new VideoTransPara[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ VideoTransPara createFromParcel(Parcel parcel) {
            AppMethodBeat.i(133560);
            VideoTransPara videoTransPara = new VideoTransPara(parcel);
            AppMethodBeat.o(133560);
            return videoTransPara;
        }
    };
    public int audioBitrate;
    public int audioChannelCount = 1;
    public int audioSampleRate;
    public int duration;
    public int fps;
    public int height;
    public int iSU;
    public int iSV;
    public int iTf = 0;
    public int iTg;
    public int iTh;
    public int iTi;
    public int iTj;
    public int iTk;
    public int iTl;
    public int iTm;
    public int iTn;
    public int iTo;
    public int iTp;
    public int iTq;
    public int iTr = 0;
    public int iTs = 0;
    public int idF;
    public int idG;
    public int iiH;
    public boolean isDefault;
    public int minDuration;
    public int videoBitrate;
    public int width;

    public VideoTransPara() {
    }

    public VideoTransPara(VideoTransPara videoTransPara) {
        this.width = videoTransPara.width;
        this.height = videoTransPara.height;
        this.fps = videoTransPara.fps;
        this.videoBitrate = videoTransPara.videoBitrate;
        this.duration = videoTransPara.duration;
        this.iiH = videoTransPara.iiH;
        this.audioBitrate = videoTransPara.audioBitrate;
        this.audioSampleRate = videoTransPara.audioSampleRate;
        this.iSU = videoTransPara.iSU;
        this.iSV = videoTransPara.iSV;
        this.isDefault = videoTransPara.isDefault;
        this.iTf = videoTransPara.iTf;
        this.iTg = videoTransPara.iTg;
        this.iTh = videoTransPara.iTh;
        this.iTi = videoTransPara.iTi;
        this.iTj = videoTransPara.iTj;
        this.iTk = videoTransPara.iTk;
        this.iTl = videoTransPara.iTl;
        this.iTm = videoTransPara.iTm;
        this.iTn = videoTransPara.iTn;
        this.iTo = videoTransPara.iTo;
        this.idF = videoTransPara.idF;
        this.idG = videoTransPara.idG;
        this.iTp = videoTransPara.iTp;
        this.iTq = videoTransPara.iTq;
        this.audioChannelCount = videoTransPara.audioChannelCount;
        this.iTr = videoTransPara.iTr;
        this.iTs = videoTransPara.iTs;
        this.minDuration = videoTransPara.minDuration;
    }

    protected VideoTransPara(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(133561);
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.fps = parcel.readInt();
        this.videoBitrate = parcel.readInt();
        this.duration = parcel.readInt();
        this.iiH = parcel.readInt();
        this.audioBitrate = parcel.readInt();
        this.audioSampleRate = parcel.readInt();
        this.iSU = parcel.readInt();
        this.iSV = parcel.readInt();
        this.isDefault = parcel.readInt() <= 0 ? false : z;
        this.iTf = parcel.readInt();
        this.iTg = parcel.readInt();
        this.iTh = parcel.readInt();
        this.iTi = parcel.readInt();
        this.iTj = parcel.readInt();
        this.iTk = parcel.readInt();
        this.iTl = parcel.readInt();
        this.iTm = parcel.readInt();
        this.iTn = parcel.readInt();
        this.iTo = parcel.readInt();
        this.idF = parcel.readInt();
        this.idG = parcel.readInt();
        this.iTp = parcel.readInt();
        this.iTq = parcel.readInt();
        this.audioChannelCount = parcel.readInt();
        this.iTr = parcel.readInt();
        this.iTs = parcel.readInt();
        this.minDuration = parcel.readInt();
        AppMethodBeat.o(133561);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(133562);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.fps);
        parcel.writeInt(this.videoBitrate);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.iiH);
        parcel.writeInt(this.audioBitrate);
        parcel.writeInt(this.audioSampleRate);
        parcel.writeInt(this.iSU);
        parcel.writeInt(this.iSV);
        parcel.writeInt(this.isDefault ? 1 : 0);
        parcel.writeInt(this.iTf);
        parcel.writeInt(this.iTg);
        parcel.writeInt(this.iTh);
        parcel.writeInt(this.iTi);
        parcel.writeInt(this.iTj);
        parcel.writeInt(this.iTk);
        parcel.writeInt(this.iTl);
        parcel.writeInt(this.iTm);
        parcel.writeInt(this.iTn);
        parcel.writeInt(this.iTo);
        parcel.writeInt(this.idF);
        parcel.writeInt(this.idG);
        parcel.writeInt(this.iTp);
        parcel.writeInt(this.iTq);
        parcel.writeInt(this.audioChannelCount);
        parcel.writeInt(this.iTr);
        parcel.writeInt(this.iTs);
        parcel.writeInt(this.minDuration);
        AppMethodBeat.o(133562);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(133565);
        AppMethodBeat.o(133565);
    }

    public String toString() {
        AppMethodBeat.i(133563);
        String str = "[isDefault " + this.isDefault + " width " + this.width + " height " + this.height + " fps " + this.fps + " video bitrate " + this.videoBitrate + " iFrame " + this.iiH + " audio bitrate " + this.audioBitrate + " audioSampleRate " + this.audioSampleRate + "audioChannelCount " + this.audioChannelCount + " duration " + this.duration + " profile index " + this.iSU + " preset index " + this.iSV + " thumbSize " + this.iTf + " abaSwitch " + this.iTg + " qpSwitch " + this.iTh + " abaUpgear " + this.iTi + " abaDowngear " + this.iTj + " ceilingVideoBR " + this.iTk + " flooringVideoBR " + this.iTl + " isEnableHEVCEncode " + this.iTm + " isEnable720p " + this.iTn + " maxVideoSize " + this.iTo + " minQP " + this.idF + " maxQP " + this.idG + " takePhotosVideoBR " + this.iTp + " remuxScene " + this.iTq + " hwEnableHevc " + this.iTr + " swEnableHevc " + this.iTs + "]";
        AppMethodBeat.o(133563);
        return str;
    }

    @Override // java.lang.Object
    public Object clone() {
        AppMethodBeat.i(133564);
        Object clone = super.clone();
        AppMethodBeat.o(133564);
        return clone;
    }
}
