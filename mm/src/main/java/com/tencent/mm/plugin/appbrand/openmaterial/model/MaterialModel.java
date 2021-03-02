package com.tencent.mm.plugin.appbrand.openmaterial.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaterialModel implements Parcelable {
    public static final Parcelable.Creator<MaterialModel> CREATOR = new Parcelable.Creator<MaterialModel>() {
        /* class com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MaterialModel[] newArray(int i2) {
            return new MaterialModel[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MaterialModel createFromParcel(Parcel parcel) {
            AppMethodBeat.i(194374);
            MaterialModel materialModel = new MaterialModel(parcel);
            AppMethodBeat.o(194374);
            return materialModel;
        }
    };
    private static final Map<String, String> nlS;
    public final String mimeType;
    public String nlI;

    static {
        AppMethodBeat.i(194384);
        HashMap hashMap = new HashMap(32);
        hashMap.put("docm", "application/vnd.ms-word.document.macroEnabled.12");
        hashMap.put("xlsm", "application/vnd.ms-excel.sheet.macroEnabled.12");
        hashMap.put("wps", "application/wps-office.wps");
        hashMap.put("et", "application/wps-office.et");
        hashMap.put("rar", "application/vnd.rar");
        hashMap.put("7z", "application/x-7z-compressed");
        hashMap.put("psd", "application/x-photoshop");
        hashMap.put("dwg", "application/acad");
        hashMap.put("cdr", "application/x-cdr");
        hashMap.put("dxf", "application/dxf");
        hashMap.put("stp", "application/step");
        hashMap.put("rtf", "application/rtf");
        hashMap.put("ai", "application/postscript");
        nlS = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.o(194384);
    }

    public static MaterialModel eB(String str, String str2) {
        AppMethodBeat.i(194375);
        Log.d("MicroMsg.AppBrand.MaterialModel", "from, mimeType: %s, materialPath: %s", str, str2);
        MaterialModel materialModel = new MaterialModel(str, str2);
        AppMethodBeat.o(194375);
        return materialModel;
    }

    public static MaterialModel adp(String str) {
        AppMethodBeat.i(194376);
        Log.d("MicroMsg.AppBrand.MaterialModel", "fromWebView, materialUrl: ".concat(String.valueOf(str)));
        MaterialModel materialModel = new MaterialModel("text/html", str);
        AppMethodBeat.o(194376);
        return materialModel;
    }

    public static MaterialModel adq(String str) {
        AppMethodBeat.i(194377);
        Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, materialLocalPath: ".concat(String.valueOf(str)));
        String akC = s.akC(str);
        Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, materialExt: ".concat(String.valueOf(akC)));
        String adr = adr(akC);
        if (adr == null) {
            adr = MimeTypeUtil.getMimeTypeByFileExt(akC);
        }
        Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, mimeType: ".concat(String.valueOf(adr)));
        if (adr == null) {
            AppMethodBeat.o(194377);
            return null;
        }
        MaterialModel materialModel = new MaterialModel(adr, str);
        AppMethodBeat.o(194377);
        return materialModel;
    }

    public static MaterialModel eC(String str, String str2) {
        AppMethodBeat.i(194378);
        Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, materialLocalPath: %s, materialExt: %s", str, str2);
        if (Util.isNullOrNil(str2)) {
            MaterialModel adq = adq(str);
            AppMethodBeat.o(194378);
            return adq;
        }
        String adr = adr(str2);
        if (adr == null) {
            adr = MimeTypeUtil.getMimeTypeByFileExt(str2);
        }
        Log.d("MicroMsg.AppBrand.MaterialModel", "fromLocalPath, mimeType: ".concat(String.valueOf(adr)));
        if (adr == null) {
            AppMethodBeat.o(194378);
            return null;
        }
        MaterialModel materialModel = new MaterialModel(adr, str);
        AppMethodBeat.o(194378);
        return materialModel;
    }

    public static MaterialModel bQg() {
        AppMethodBeat.i(194379);
        MaterialModel materialModel = new MaterialModel("", "");
        AppMethodBeat.o(194379);
        return materialModel;
    }

    private static String adr(String str) {
        AppMethodBeat.i(194380);
        Log.d("MicroMsg.AppBrand.MaterialModel", "getMimeTypeByFileExtHardCode, fileExt: ".concat(String.valueOf(str)));
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(194380);
            return null;
        }
        String str2 = nlS.get(str.toLowerCase());
        AppMethodBeat.o(194380);
        return str2;
    }

    private MaterialModel(String str, String str2) {
        this.mimeType = str;
        this.nlI = str2;
    }

    public String toString() {
        AppMethodBeat.i(194381);
        String str = "MaterialModel{mimeType='" + this.mimeType + '\'' + ", materialPath='" + this.nlI + '\'' + '}';
        AppMethodBeat.o(194381);
        return str;
    }

    protected MaterialModel(Parcel parcel) {
        AppMethodBeat.i(194382);
        this.mimeType = Util.nullAs(parcel.readString(), "");
        this.nlI = Util.nullAs(parcel.readString(), "");
        AppMethodBeat.o(194382);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(194383);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.nlI);
        AppMethodBeat.o(194383);
    }
}
