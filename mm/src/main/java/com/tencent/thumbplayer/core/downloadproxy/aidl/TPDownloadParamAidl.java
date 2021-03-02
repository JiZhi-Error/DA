package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TPDownloadParamAidl implements Parcelable {
    public static final Parcelable.Creator<TPDownloadParamAidl> CREATOR = new Parcelable.Creator<TPDownloadParamAidl>() {
        /* class com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadParamAidl.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final TPDownloadParamAidl createFromParcel(Parcel parcel) {
            AppMethodBeat.i(209871);
            TPDownloadParamAidl tPDownloadParamAidl = new TPDownloadParamAidl(parcel);
            AppMethodBeat.o(209871);
            return tPDownloadParamAidl;
        }

        @Override // android.os.Parcelable.Creator
        public final TPDownloadParamAidl[] newArray(int i2) {
            return new TPDownloadParamAidl[i2];
        }
    };
    private int dlType;
    private Map<String, Object> extInfoMap;
    private ArrayList<String> urlList;

    public TPDownloadParamAidl(ArrayList<String> arrayList, int i2, Map<String, Object> map) {
        this.urlList = arrayList;
        this.dlType = i2;
        this.extInfoMap = map;
    }

    protected TPDownloadParamAidl(Parcel parcel) {
        AppMethodBeat.i(209874);
        try {
            this.urlList = parcel.createStringArrayList();
            this.dlType = parcel.readInt();
            this.extInfoMap = parcel.readHashMap(TPDownloadParamAidl.class.getClassLoader());
            AppMethodBeat.o(209874);
        } catch (Throwable th) {
            TPDLProxyLog.e("TPDownloadParamAidl", 0, ITPDLProxyLogListener.COMMON_TAG, th.toString());
            this.urlList = new ArrayList<>();
            this.dlType = 0;
            this.extInfoMap = new HashMap();
            AppMethodBeat.o(209874);
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(209875);
        parcel.writeStringList(this.urlList);
        parcel.writeInt(this.dlType);
        parcel.writeMap(this.extInfoMap);
        AppMethodBeat.o(209875);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(209876);
        AppMethodBeat.o(209876);
    }

    public ArrayList<String> getUrlList() {
        return this.urlList;
    }

    public void setUrlList(ArrayList<String> arrayList) {
        this.urlList = arrayList;
    }

    public int getDlType() {
        return this.dlType;
    }

    public void setDlType(int i2) {
        this.dlType = i2;
    }

    public Map<String, Object> getExtInfoMap() {
        return this.extInfoMap;
    }

    public void setExtInfoMap(Map<String, Object> map) {
        this.extInfoMap = map;
    }
}
