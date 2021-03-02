package com.tencent.mm.plugin.recordvideo.jumper;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;

public class RecordConfigProvider implements Parcelable {
    public static final Parcelable.Creator<RecordConfigProvider> CREATOR = new Parcelable.Creator<RecordConfigProvider>() {
        /* class com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RecordConfigProvider[] newArray(int i2) {
            return new RecordConfigProvider[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RecordConfigProvider createFromParcel(Parcel parcel) {
            AppMethodBeat.i(101495);
            RecordConfigProvider recordConfigProvider = new RecordConfigProvider(parcel);
            AppMethodBeat.o(101495);
            return recordConfigProvider;
        }
    };
    public String BOA;
    public String BOB;
    public String BOC;
    public ArrayList<String> BOD;
    public VideoCaptureReportInfo BOE;
    public long BOF;
    public boolean BOG;
    public boolean BOH;
    public boolean BOI;
    public XEffectConfig BOJ;
    public String BOK;
    public Boolean BOh = Boolean.FALSE;
    public int BOi = 2;
    public int BOj = 1;
    public Boolean BOk = Boolean.FALSE;
    public Boolean BOl = Boolean.FALSE;
    public VideoTransPara BOm;
    public UICustomParam BOn;
    public i.e BOo;
    public int BOp;
    public Boolean BOq;
    public Boolean BOr;
    public Boolean BOs;
    public Boolean BOt;
    public Boolean BOu;
    public int BOv;
    public int BOw;
    public boolean BOx;
    public boolean BOy;
    public String BOz;
    public HashMap hwc;
    public int ilT = 1080;
    public ArrayList<String> images;
    public Bundle jkf;
    public int remuxType = 1;
    public int scene;
    public String thumbPath;

    public String toString() {
        AppMethodBeat.i(101496);
        String str = "RecordConfigProvider{remuxType=" + this.remuxType + ", useCPUCrop=" + this.BOh + ", resolutionLimit=" + this.ilT + ", recordType=" + this.BOi + ", recordLevel=" + this.BOj + ", useCameraApi2=" + this.BOk + ", useImageStream=" + this.BOl + ", videoParam=" + this.BOm + ", uiParam=" + this.BOn + ", outputType=" + this.BOp + ", previewForceFullScreen=" + this.BOq + ", enablePicture=" + this.BOr + ", enableVideo=" + this.BOs + ", forceForegroundMix=" + this.BOt + ", enableAlbum=" + this.BOu + ", maxRecordTimeMs=" + this.BOv + ", saveSourceMedia=" + this.BOx + ", savaToSysAlbumIfMediaEdited=" + this.BOy + ", inputVideoPath='" + this.BOz + '\'' + ", outputVideoPath='" + this.BOA + '\'' + ", thumbPath='" + this.thumbPath + '\'' + ", inputPhotoPath='" + this.BOB + '\'' + ", outputPhotoPath='" + this.BOC + '\'' + ", scene=" + this.scene + ", images=" + this.images + ", videos=" + this.BOD + ", reportInfo=" + this.BOE + ", expiredTimeMsIfMixInBackground=" + this.BOF + ", supportCaptureLandscape=" + this.BOG + ", forcePortrait=" + this.BOH + ", autoAdjustFoldingScreen=" + this.BOI + ", router=" + this.hwc + '}';
        AppMethodBeat.o(101496);
        return str;
    }

    public static RecordConfigProvider jA(String str, String str2) {
        AppMethodBeat.i(101497);
        RecordConfigProvider recordConfigProvider = new RecordConfigProvider();
        recordConfigProvider.BOB = s.k(str, false);
        recordConfigProvider.BOC = s.k(str2, true);
        recordConfigProvider.BOx = true;
        recordConfigProvider.BOp = 3;
        AppMethodBeat.o(101497);
        return recordConfigProvider;
    }

    public static RecordConfigProvider aD(String str, String str2, String str3) {
        AppMethodBeat.i(101498);
        RecordConfigProvider recordConfigProvider = new RecordConfigProvider();
        recordConfigProvider.BOz = s.k(str, false);
        recordConfigProvider.BOA = s.k(str2, true);
        recordConfigProvider.thumbPath = str3;
        if (!TextUtils.isEmpty(str3)) {
            recordConfigProvider.thumbPath = s.k(str3, true);
        }
        recordConfigProvider.BOx = true;
        recordConfigProvider.BOp = 4;
        AppMethodBeat.o(101498);
        return recordConfigProvider;
    }

    public static RecordConfigProvider jB(String str, String str2) {
        AppMethodBeat.i(101499);
        RecordConfigProvider recordConfigProvider = new RecordConfigProvider();
        recordConfigProvider.BOA = s.k(str, true);
        recordConfigProvider.thumbPath = str2;
        if (!TextUtils.isEmpty(str2)) {
            recordConfigProvider.thumbPath = s.k(str2, true);
        }
        recordConfigProvider.BOx = true;
        recordConfigProvider.BOp = 4;
        AppMethodBeat.o(101499);
        return recordConfigProvider;
    }

    public static RecordConfigProvider eJM() {
        AppMethodBeat.i(101500);
        RecordConfigProvider recordConfigProvider = new RecordConfigProvider();
        recordConfigProvider.BOr = Boolean.TRUE;
        recordConfigProvider.BOt = Boolean.TRUE;
        recordConfigProvider.BOu = Boolean.FALSE;
        recordConfigProvider.scene = 4;
        AppMethodBeat.o(101500);
        return recordConfigProvider;
    }

    public static RecordConfigProvider a(String str, String str2, VideoTransPara videoTransPara, int i2, int i3) {
        AppMethodBeat.i(101501);
        RecordConfigProvider recordConfigProvider = new RecordConfigProvider();
        recordConfigProvider.BOm = videoTransPara;
        recordConfigProvider.BOr = Boolean.TRUE;
        recordConfigProvider.BOt = Boolean.TRUE;
        recordConfigProvider.BOu = Boolean.FALSE;
        recordConfigProvider.BOv = i2;
        recordConfigProvider.BOA = s.k(str, true);
        recordConfigProvider.thumbPath = str2;
        if (!TextUtils.isEmpty(str2)) {
            recordConfigProvider.thumbPath = s.k(str2, true);
        }
        recordConfigProvider.scene = i3;
        AppMethodBeat.o(101501);
        return recordConfigProvider;
    }

    private RecordConfigProvider() {
        AppMethodBeat.i(101502);
        new UICustomParam.a();
        this.BOn = UICustomParam.a.apz().gLU;
        this.BOo = i.e.DEFAULT;
        this.BOp = 1;
        this.BOq = Boolean.FALSE;
        this.BOr = Boolean.TRUE;
        this.BOs = Boolean.TRUE;
        this.BOt = Boolean.TRUE;
        this.BOu = Boolean.TRUE;
        this.BOv = 10000;
        this.BOw = -1;
        this.BOx = false;
        this.BOy = true;
        this.BOF = 259200000;
        this.BOG = true;
        this.BOH = false;
        this.BOI = false;
        this.hwc = new HashMap();
        this.BOJ = new XEffectConfig();
        this.BOK = "";
        AppMethodBeat.o(101502);
    }

    public final void F(int i2, String str) {
        AppMethodBeat.i(101503);
        this.hwc.put(Integer.valueOf(i2), str);
        AppMethodBeat.o(101503);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        byte b2;
        byte b3;
        byte b4;
        byte b5 = 1;
        AppMethodBeat.i(101504);
        parcel.writeInt(this.remuxType);
        parcel.writeValue(this.BOh);
        parcel.writeInt(this.ilT);
        parcel.writeInt(this.BOi);
        parcel.writeInt(this.BOj);
        parcel.writeValue(this.BOk);
        parcel.writeValue(this.BOl);
        parcel.writeParcelable(this.BOm, i2);
        parcel.writeParcelable(this.BOn, i2);
        parcel.writeInt(this.BOo == null ? -1 : this.BOo.ordinal());
        parcel.writeInt(this.BOp);
        parcel.writeValue(this.BOq);
        parcel.writeValue(this.BOr);
        parcel.writeValue(this.BOs);
        parcel.writeValue(this.BOt);
        parcel.writeValue(this.BOu);
        parcel.writeInt(this.BOv);
        if (this.BOx) {
            b2 = 1;
        } else {
            b2 = 0;
        }
        parcel.writeByte(b2);
        if (this.BOy) {
            b3 = 1;
        } else {
            b3 = 0;
        }
        parcel.writeByte(b3);
        parcel.writeString(this.BOz);
        parcel.writeString(this.BOA);
        parcel.writeString(this.thumbPath);
        parcel.writeString(this.BOB);
        parcel.writeString(this.BOC);
        parcel.writeInt(this.scene);
        parcel.writeStringList(this.images);
        parcel.writeStringList(this.BOD);
        parcel.writeParcelable(this.BOE, i2);
        parcel.writeLong(this.BOF);
        parcel.writeByte(this.BOG ? (byte) 1 : 0);
        if (this.BOH) {
            b4 = 1;
        } else {
            b4 = 0;
        }
        parcel.writeByte(b4);
        parcel.writeBundle(this.jkf);
        if (!this.BOI) {
            b5 = 0;
        }
        parcel.writeByte(b5);
        parcel.writeSerializable(this.hwc);
        parcel.writeParcelable(this.BOJ, i2);
        parcel.writeInt(this.BOw);
        parcel.writeString(this.BOK);
        AppMethodBeat.o(101504);
    }

    protected RecordConfigProvider(Parcel parcel) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        AppMethodBeat.i(101505);
        new UICustomParam.a();
        this.BOn = UICustomParam.a.apz().gLU;
        this.BOo = i.e.DEFAULT;
        this.BOp = 1;
        this.BOq = Boolean.FALSE;
        this.BOr = Boolean.TRUE;
        this.BOs = Boolean.TRUE;
        this.BOt = Boolean.TRUE;
        this.BOu = Boolean.TRUE;
        this.BOv = 10000;
        this.BOw = -1;
        this.BOx = false;
        this.BOy = true;
        this.BOF = 259200000;
        this.BOG = true;
        this.BOH = false;
        this.BOI = false;
        this.hwc = new HashMap();
        this.BOJ = new XEffectConfig();
        this.BOK = "";
        this.remuxType = parcel.readInt();
        this.BOh = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.ilT = parcel.readInt();
        this.BOi = parcel.readInt();
        this.BOj = parcel.readInt();
        this.BOk = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.BOl = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.BOm = (VideoTransPara) parcel.readParcelable(VideoTransPara.class.getClassLoader());
        this.BOn = (UICustomParam) parcel.readParcelable(UICustomParam.class.getClassLoader());
        int readInt = parcel.readInt();
        this.BOo = readInt == -1 ? null : i.e.values()[readInt];
        this.BOp = parcel.readInt();
        this.BOq = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.BOr = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.BOs = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.BOt = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.BOu = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.BOv = parcel.readInt();
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.BOx = z;
        if (parcel.readByte() != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.BOy = z2;
        this.BOz = parcel.readString();
        this.BOA = parcel.readString();
        this.thumbPath = parcel.readString();
        this.BOB = parcel.readString();
        this.BOC = parcel.readString();
        this.scene = parcel.readInt();
        this.images = parcel.createStringArrayList();
        this.BOD = parcel.createStringArrayList();
        this.BOE = (VideoCaptureReportInfo) parcel.readParcelable(VideoCaptureReportInfo.class.getClassLoader());
        this.BOF = parcel.readLong();
        this.BOG = parcel.readByte() != 0;
        if (parcel.readByte() != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.BOH = z3;
        this.jkf = parcel.readBundle();
        this.BOI = parcel.readByte() == 0 ? false : z4;
        this.hwc = (HashMap) parcel.readSerializable();
        this.BOJ = (XEffectConfig) parcel.readParcelable(XEffectConfig.class.getClassLoader());
        this.BOw = parcel.readInt();
        this.BOK = parcel.readString();
        AppMethodBeat.o(101505);
    }

    static {
        AppMethodBeat.i(101506);
        AppMethodBeat.o(101506);
    }
}
