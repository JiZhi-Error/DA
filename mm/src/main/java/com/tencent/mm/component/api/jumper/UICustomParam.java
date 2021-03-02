package com.tencent.mm.component.api.jumper;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class UICustomParam implements Parcelable {
    public static final Parcelable.Creator<UICustomParam> CREATOR = new Parcelable.Creator<UICustomParam>() {
        /* class com.tencent.mm.component.api.jumper.UICustomParam.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UICustomParam[] newArray(int i2) {
            return new UICustomParam[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UICustomParam createFromParcel(Parcel parcel) {
            AppMethodBeat.i(101474);
            UICustomParam uICustomParam = new UICustomParam(parcel);
            AppMethodBeat.o(101474);
            return uICustomParam;
        }
    };
    public float gLH;
    public float gLI;
    public float gLJ;
    public float gLK;
    public Map<String, Boolean> gLL;
    public int gLM;
    public int gLN;
    public int gLO;
    public String gLP;
    public int gLQ;
    public float gLR;
    public int gLS;
    public float gLT;
    public int previewHeight;
    public int previewWidth;
    public String text;

    /* synthetic */ UICustomParam(byte b2) {
        this();
    }

    public static class a {
        public UICustomParam gLU = new UICustomParam((byte) 0);

        public a() {
            AppMethodBeat.i(101475);
            this.gLU.gLL.put("plugin_filter", Boolean.TRUE);
            AppMethodBeat.o(101475);
        }

        public static a apz() {
            AppMethodBeat.i(101476);
            a aVar = new a();
            aVar.apE();
            aVar.apD();
            aVar.dz(true);
            AppMethodBeat.o(101476);
            return aVar;
        }

        public final a apA() {
            this.gLU.gLH = 0.6f;
            this.gLU.gLI = 0.6f;
            return this;
        }

        public final a apB() {
            this.gLU.gLJ = 0.5f;
            this.gLU.gLK = 0.5f;
            return this;
        }

        public final a dv(boolean z) {
            AppMethodBeat.i(207033);
            this.gLU.gLL.put("plugin_emoji", Boolean.valueOf(z));
            AppMethodBeat.o(207033);
            return this;
        }

        public final a dw(boolean z) {
            AppMethodBeat.i(207034);
            this.gLU.gLL.put("plugin_text", Boolean.valueOf(z));
            AppMethodBeat.o(207034);
            return this;
        }

        public final a dx(boolean z) {
            AppMethodBeat.i(207035);
            this.gLU.gLL.put("plugin_music", Boolean.valueOf(z));
            AppMethodBeat.o(207035);
            return this;
        }

        public final a dy(boolean z) {
            AppMethodBeat.i(168708);
            this.gLU.gLL.put("plugin_video_crop", Boolean.valueOf(z));
            AppMethodBeat.o(168708);
            return this;
        }

        public final a apC() {
            AppMethodBeat.i(168709);
            this.gLU.gLL.put("plugin_photo_crop", Boolean.TRUE);
            AppMethodBeat.o(168709);
            return this;
        }

        public final a apD() {
            AppMethodBeat.i(101478);
            this.gLU.gLL.put("plugin_tip", Boolean.TRUE);
            AppMethodBeat.o(101478);
            return this;
        }

        public final a apE() {
            AppMethodBeat.i(101479);
            this.gLU.gLL.put("plugin_poi", Boolean.TRUE);
            AppMethodBeat.o(101479);
            return this;
        }

        public final a dz(boolean z) {
            AppMethodBeat.i(168710);
            this.gLU.gLL.put("plugin_menu", Boolean.valueOf(z));
            AppMethodBeat.o(168710);
            return this;
        }

        public final a apF() {
            AppMethodBeat.i(168711);
            this.gLU.gLL.put("plugin_filter", Boolean.TRUE);
            AppMethodBeat.o(168711);
            return this;
        }

        public final a a(int i2, int i3, String str, int i4) {
            this.gLU.gLM = i2;
            this.gLU.gLN = i3;
            this.gLU.text = str;
            this.gLU.gLO = i4;
            return this;
        }

        public final a L(String str, int i2) {
            this.gLU.gLP = str;
            this.gLU.gLQ = i2;
            this.gLU.gLR = 17.0f;
            return this;
        }

        public final a oG(int i2) {
            this.gLU.gLS = i2;
            return this;
        }

        public final a ai(float f2) {
            this.gLU.gLT = f2;
            return this;
        }

        public final UICustomParam apG() {
            return this.gLU;
        }
    }

    private UICustomParam() {
        AppMethodBeat.i(101481);
        this.gLH = 0.0f;
        this.gLI = 0.0f;
        this.gLJ = 0.0f;
        this.gLK = 0.0f;
        this.gLM = 0;
        this.gLN = 0;
        this.gLO = 0;
        this.text = "";
        this.gLP = "";
        this.gLQ = 0;
        this.gLR = 0.0f;
        this.gLS = 0;
        this.previewWidth = -1;
        this.previewHeight = -1;
        this.gLT = -1.0f;
        this.gLL = new HashMap();
        AppMethodBeat.o(101481);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(101483);
        parcel.writeFloat(this.gLH);
        parcel.writeFloat(this.gLI);
        parcel.writeFloat(this.gLJ);
        parcel.writeFloat(this.gLK);
        parcel.writeInt(this.gLL.size());
        for (Map.Entry<String, Boolean> entry : this.gLL.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeValue(entry.getValue());
        }
        parcel.writeInt(this.gLM);
        parcel.writeInt(this.gLN);
        parcel.writeInt(this.gLO);
        parcel.writeString(this.text);
        parcel.writeString(this.gLP);
        parcel.writeInt(this.gLQ);
        parcel.writeFloat(this.gLR);
        parcel.writeInt(this.gLS);
        parcel.writeInt(this.previewWidth);
        parcel.writeInt(this.previewHeight);
        parcel.writeFloat(this.gLT);
        AppMethodBeat.o(101483);
    }

    protected UICustomParam(Parcel parcel) {
        AppMethodBeat.i(101482);
        this.gLH = 0.0f;
        this.gLI = 0.0f;
        this.gLJ = 0.0f;
        this.gLK = 0.0f;
        this.gLM = 0;
        this.gLN = 0;
        this.gLO = 0;
        this.text = "";
        this.gLP = "";
        this.gLQ = 0;
        this.gLR = 0.0f;
        this.gLS = 0;
        this.previewWidth = -1;
        this.previewHeight = -1;
        this.gLT = -1.0f;
        this.gLH = parcel.readFloat();
        this.gLI = parcel.readFloat();
        this.gLJ = parcel.readFloat();
        this.gLK = parcel.readFloat();
        int readInt = parcel.readInt();
        this.gLL = new HashMap(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.gLL.put(parcel.readString(), (Boolean) parcel.readValue(Boolean.class.getClassLoader()));
        }
        this.gLM = parcel.readInt();
        this.gLN = parcel.readInt();
        this.gLO = parcel.readInt();
        this.text = parcel.readString();
        this.gLP = parcel.readString();
        this.gLQ = parcel.readInt();
        this.gLR = parcel.readFloat();
        this.gLS = parcel.readInt();
        this.previewWidth = parcel.readInt();
        this.previewHeight = parcel.readInt();
        this.gLT = parcel.readFloat();
        AppMethodBeat.o(101482);
    }

    static {
        AppMethodBeat.i(101484);
        AppMethodBeat.o(101484);
    }
}
