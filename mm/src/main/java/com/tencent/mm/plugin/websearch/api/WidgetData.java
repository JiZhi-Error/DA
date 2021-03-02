package com.tencent.mm.plugin.websearch.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class WidgetData implements Parcelable {
    public static final Parcelable.Creator<WidgetData> CREATOR = new Parcelable.Creator<WidgetData>() {
        /* class com.tencent.mm.plugin.websearch.api.WidgetData.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WidgetData[] newArray(int i2) {
            return new WidgetData[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WidgetData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(117806);
            WidgetData widgetData = new WidgetData(parcel);
            AppMethodBeat.o(117806);
            return widgetData;
        }
    };
    public MoreFooter IFF;
    public Info IFG;
    public Style IFH;
    public int IFI;
    public String dWw;
    public String query;

    public static class Info implements Parcelable {
        public static final Parcelable.Creator<Info> CREATOR = new Parcelable.Creator<Info>() {
            /* class com.tencent.mm.plugin.websearch.api.WidgetData.Info.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Info[] newArray(int i2) {
                return new Info[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Info createFromParcel(Parcel parcel) {
                AppMethodBeat.i(117807);
                Info info = new Info(parcel);
                AppMethodBeat.o(117807);
                return info;
            }
        };
        public String IFJ;
        public String IFK;
        public String IFL;
        public String IFM;
        public long IFN;
        public String IFO;
        public String dCx;
        public String dNI;
        public String downloadUrl;
        public String footerWording;
        public String hes;
        public String iIA;
        public String iconUrl;
        public String label;
        public int nbf;
        public String nickName;
        public int serviceType;
        public String userName;
        public int version;
        public String wWb;
        public boolean wkz;

        public String toString() {
            AppMethodBeat.i(117808);
            String format = String.format("appid:%s, srcAppid %s, permission %d, pathPath: %s", this.dNI, this.iIA, Long.valueOf(this.IFN), this.dCx);
            AppMethodBeat.o(117808);
            return format;
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(117809);
            if (this == obj) {
                AppMethodBeat.o(117809);
                return true;
            } else if (!(obj instanceof Info)) {
                AppMethodBeat.o(117809);
                return false;
            } else {
                Info info = (Info) obj;
                if (this.serviceType != info.serviceType || this.nbf != info.nbf || this.version != info.version || this.IFN != info.IFN || this.wkz != info.wkz || !Objects.equals(this.IFJ, info.IFJ) || !Objects.equals(this.nickName, info.nickName) || !Objects.equals(this.IFK, info.IFK) || !Objects.equals(this.IFL, info.IFL) || !Objects.equals(this.dCx, info.dCx) || !Objects.equals(this.dNI, info.dNI) || !Objects.equals(this.userName, info.userName) || !Objects.equals(this.wWb, info.wWb) || !Objects.equals(this.iconUrl, info.iconUrl) || !Objects.equals(this.downloadUrl, info.downloadUrl) || !Objects.equals(this.IFM, info.IFM) || !Objects.equals(this.hes, info.hes) || !Objects.equals(this.label, info.label) || !Objects.equals(this.iIA, info.iIA) || !Objects.equals(this.IFO, info.IFO) || !Objects.equals(this.footerWording, info.footerWording)) {
                    AppMethodBeat.o(117809);
                    return false;
                }
                AppMethodBeat.o(117809);
                return true;
            }
        }

        public int hashCode() {
            AppMethodBeat.i(117810);
            int hash = Objects.hash(Integer.valueOf(this.serviceType), this.IFJ, this.nickName, this.IFK, this.IFL, this.dCx, this.dNI, this.userName, Integer.valueOf(this.nbf), Integer.valueOf(this.version), this.wWb, this.iconUrl, this.downloadUrl, this.IFM, this.hes, this.label, Long.valueOf(this.IFN), this.iIA, this.IFO, this.footerWording, Boolean.valueOf(this.wkz));
            AppMethodBeat.o(117810);
            return hash;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(117811);
            parcel.writeInt(this.serviceType);
            parcel.writeString(this.IFJ);
            parcel.writeString(this.nickName);
            parcel.writeString(this.IFK);
            parcel.writeString(this.IFL);
            parcel.writeString(this.dCx);
            parcel.writeString(this.dNI);
            parcel.writeString(this.userName);
            parcel.writeInt(this.nbf);
            parcel.writeInt(this.version);
            parcel.writeString(this.wWb);
            parcel.writeString(this.iconUrl);
            parcel.writeString(this.downloadUrl);
            parcel.writeString(this.IFM);
            parcel.writeString(this.hes);
            parcel.writeString(this.label);
            parcel.writeLong(this.IFN);
            parcel.writeString(this.iIA);
            parcel.writeString(this.IFO);
            parcel.writeString(this.footerWording);
            parcel.writeByte(this.wkz ? (byte) 1 : 0);
            AppMethodBeat.o(117811);
        }

        public Info() {
        }

        protected Info(Parcel parcel) {
            AppMethodBeat.i(117812);
            this.serviceType = parcel.readInt();
            this.IFJ = parcel.readString();
            this.nickName = parcel.readString();
            this.IFK = parcel.readString();
            this.IFL = parcel.readString();
            this.dCx = parcel.readString();
            this.dNI = parcel.readString();
            this.userName = parcel.readString();
            this.nbf = parcel.readInt();
            this.version = parcel.readInt();
            this.wWb = parcel.readString();
            this.iconUrl = parcel.readString();
            this.downloadUrl = parcel.readString();
            this.IFM = parcel.readString();
            this.hes = parcel.readString();
            this.label = parcel.readString();
            this.IFN = parcel.readLong();
            this.iIA = parcel.readString();
            this.IFO = parcel.readString();
            this.footerWording = parcel.readString();
            this.wkz = parcel.readByte() != 0;
            AppMethodBeat.o(117812);
        }

        static {
            AppMethodBeat.i(117813);
            AppMethodBeat.o(117813);
        }
    }

    public static class Style implements Parcelable {
        public static final Parcelable.Creator<Style> CREATOR = new Parcelable.Creator<Style>() {
            /* class com.tencent.mm.plugin.websearch.api.WidgetData.Style.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Style[] newArray(int i2) {
                return new Style[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Style createFromParcel(Parcel parcel) {
                AppMethodBeat.i(117820);
                Style style = new Style(parcel);
                AppMethodBeat.o(117820);
                return style;
            }
        };
        public double IFR = 65.0d;
        public int IFS;
        public boolean eco = true;
        public int height;
        public String lco;
        public int maZ;
        public int mba;
        public int width;

        public String toString() {
            AppMethodBeat.i(117821);
            String obj = super.toString();
            AppMethodBeat.o(117821);
            return obj;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(117822);
            parcel.writeDouble(this.IFR);
            parcel.writeInt(this.IFS);
            parcel.writeInt(this.maZ);
            parcel.writeInt(this.mba);
            parcel.writeInt(this.height);
            parcel.writeString(this.lco);
            parcel.writeInt(this.width);
            parcel.writeByte(this.eco ? (byte) 1 : 0);
            AppMethodBeat.o(117822);
        }

        public Style() {
        }

        protected Style(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(117823);
            this.IFR = parcel.readDouble();
            this.IFS = parcel.readInt();
            this.maZ = parcel.readInt();
            this.mba = parcel.readInt();
            this.height = parcel.readInt();
            this.lco = parcel.readString();
            this.width = parcel.readInt();
            this.eco = parcel.readByte() == 0 ? false : z;
            AppMethodBeat.o(117823);
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(117824);
            if (this == obj) {
                AppMethodBeat.o(117824);
                return true;
            } else if (!(obj instanceof Style)) {
                AppMethodBeat.o(117824);
                return false;
            } else {
                Style style = (Style) obj;
                if (Double.compare(style.IFR, this.IFR) == 0 && this.IFS == style.IFS && this.maZ == style.maZ && this.mba == style.mba && this.height == style.height && this.width == style.width && this.eco == style.eco && Objects.equals(this.lco, style.lco)) {
                    AppMethodBeat.o(117824);
                    return true;
                }
                AppMethodBeat.o(117824);
                return false;
            }
        }

        public int hashCode() {
            AppMethodBeat.i(117825);
            int hash = Objects.hash(Double.valueOf(this.IFR), Integer.valueOf(this.IFS), Integer.valueOf(this.maZ), Integer.valueOf(this.mba), Integer.valueOf(this.height), this.lco, Integer.valueOf(this.width), Boolean.valueOf(this.eco));
            AppMethodBeat.o(117825);
            return hash;
        }

        static {
            AppMethodBeat.i(117826);
            AppMethodBeat.o(117826);
        }
    }

    public static class MoreFooter implements Parcelable {
        public static final Parcelable.Creator<MoreFooter> CREATOR = new Parcelable.Creator<MoreFooter>() {
            /* class com.tencent.mm.plugin.websearch.api.WidgetData.MoreFooter.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ MoreFooter[] newArray(int i2) {
                return new MoreFooter[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MoreFooter createFromParcel(Parcel parcel) {
                AppMethodBeat.i(117814);
                MoreFooter moreFooter = new MoreFooter(parcel);
                AppMethodBeat.o(117814);
                return moreFooter;
            }
        };
        public String IFP;
        public String IFQ;
        public String title;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(117815);
            parcel.writeString(this.title);
            parcel.writeString(this.IFP);
            parcel.writeString(this.IFQ);
            AppMethodBeat.o(117815);
        }

        public MoreFooter() {
        }

        protected MoreFooter(Parcel parcel) {
            AppMethodBeat.i(117816);
            this.title = parcel.readString();
            this.IFP = parcel.readString();
            this.IFQ = parcel.readString();
            AppMethodBeat.o(117816);
        }

        static {
            AppMethodBeat.i(117819);
            AppMethodBeat.o(117819);
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(117817);
            if (this == obj) {
                AppMethodBeat.o(117817);
                return true;
            } else if (!(obj instanceof MoreFooter)) {
                AppMethodBeat.o(117817);
                return false;
            } else {
                MoreFooter moreFooter = (MoreFooter) obj;
                if (!Objects.equals(this.title, moreFooter.title) || !Objects.equals(this.IFP, moreFooter.IFP) || !Objects.equals(this.IFQ, moreFooter.IFQ)) {
                    AppMethodBeat.o(117817);
                    return false;
                }
                AppMethodBeat.o(117817);
                return true;
            }
        }

        public int hashCode() {
            AppMethodBeat.i(117818);
            int hash = Objects.hash(this.title, this.IFP, this.IFQ);
            AppMethodBeat.o(117818);
            return hash;
        }
    }

    public String toString() {
        AppMethodBeat.i(117827);
        Object[] objArr = new Object[2];
        objArr[0] = this.IFG == null ? "" : this.IFG.toString();
        objArr[1] = this.IFH == null ? "" : this.IFH.toString();
        String format = String.format("info: [%s], style:[%s]", objArr);
        AppMethodBeat.o(117827);
        return format;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(117828);
        if (this == obj) {
            AppMethodBeat.o(117828);
            return true;
        } else if (!(obj instanceof WidgetData)) {
            AppMethodBeat.o(117828);
            return false;
        } else {
            WidgetData widgetData = (WidgetData) obj;
            if (this.IFI != widgetData.IFI || !Objects.equals(this.IFF, widgetData.IFF) || !Objects.equals(this.IFG, widgetData.IFG) || !Objects.equals(this.IFH, widgetData.IFH) || !Objects.equals(this.query, widgetData.query) || !Objects.equals(this.dWw, widgetData.dWw)) {
                AppMethodBeat.o(117828);
                return false;
            }
            AppMethodBeat.o(117828);
            return true;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(117829);
        int hash = Objects.hash(this.IFF, this.IFG, this.IFH, Integer.valueOf(this.IFI), this.query, this.dWw);
        AppMethodBeat.o(117829);
        return hash;
    }

    public static WidgetData aXl(String str) {
        int optInt;
        AppMethodBeat.i(117830);
        if (str == null || str.length() == 0) {
            Log.i("WidgetData", "insert args invalid");
            AppMethodBeat.o(117830);
            return null;
        }
        WidgetData widgetData = new WidgetData();
        widgetData.IFG = new Info();
        widgetData.IFH = new Style();
        try {
            JSONObject jSONObject = new JSONObject(str);
            widgetData.IFG.dNI = jSONObject.optString("appid");
            widgetData.IFG.version = jSONObject.optInt("version");
            widgetData.IFG.nickName = jSONObject.optString("nickName");
            widgetData.IFG.userName = jSONObject.optString(ch.COL_USERNAME);
            widgetData.IFG.iIA = jSONObject.optString("srcAppid");
            widgetData.IFG.IFJ = jSONObject.optString("inputData");
            widgetData.IFG.dCx = jSONObject.optString("pagePath");
            widgetData.IFG.IFK = jSONObject.optString("wxaData");
            widgetData.IFG.IFL = jSONObject.optString("launchwxawidget");
            widgetData.IFG.serviceType = Util.safeParseInt(jSONObject.optString("serviceType"));
            Info info = widgetData.IFG;
            if (!jSONObject.has("debugMode")) {
                optInt = 0;
            } else {
                optInt = jSONObject.optInt("debugMode");
            }
            info.nbf = optInt;
            widgetData.IFG.hes = jSONObject.optString("searchId");
            String optString = jSONObject.optString("relayInfoStr");
            try {
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    if (jSONObject2.has("openapp_permission")) {
                        widgetData.IFG.IFN = jSONObject2.optLong("openapp_permission");
                    }
                }
            } catch (JSONException e2) {
                Log.printErrStackTrace("WidgetData", e2, "", new Object[0]);
            }
            widgetData.IFH.IFS = jSONObject.has("maxHeight") ? jSONObject.optInt("maxHeight") : Integer.MAX_VALUE;
            widgetData.IFH.height = jSONObject.optInt("height");
            widgetData.IFH.width = jSONObject.optInt("width");
            widgetData.IFH.lco = jSONObject.optString("backgroundColor");
            widgetData.IFH.IFR = jSONObject.has("minHeight") ? jSONObject.optDouble("minHeight") : 0.0d;
            widgetData.IFH.maZ = jSONObject.optInt("offsetX");
            widgetData.IFH.mba = jSONObject.optInt("offsetY");
            widgetData.IFH.eco = jSONObject.has("show") ? jSONObject.optBoolean("show") : true;
            AppMethodBeat.o(117830);
            return widgetData;
        } catch (JSONException e3) {
            Log.printErrStackTrace("WidgetData", e3, "", new Object[0]);
            AppMethodBeat.o(117830);
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(117831);
        parcel.writeParcelable(this.IFF, i2);
        parcel.writeParcelable(this.IFG, i2);
        parcel.writeParcelable(this.IFH, i2);
        parcel.writeInt(this.IFI);
        parcel.writeString(this.query);
        parcel.writeString(this.dWw);
        AppMethodBeat.o(117831);
    }

    public WidgetData() {
    }

    protected WidgetData(Parcel parcel) {
        AppMethodBeat.i(117832);
        this.IFF = (MoreFooter) parcel.readParcelable(MoreFooter.class.getClassLoader());
        this.IFG = (Info) parcel.readParcelable(Info.class.getClassLoader());
        this.IFH = (Style) parcel.readParcelable(Style.class.getClassLoader());
        this.IFI = parcel.readInt();
        this.query = parcel.readString();
        this.dWw = parcel.readString();
        AppMethodBeat.o(117832);
    }

    static {
        AppMethodBeat.i(117833);
        AppMethodBeat.o(117833);
    }
}
