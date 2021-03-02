package com.tencent.mm.plugin.ball.model;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Iterator;
import org.json.JSONObject;

public class BallInfo implements Parcelable {
    public static final Parcelable.Creator<BallInfo> CREATOR = new Parcelable.Creator<BallInfo>() {
        /* class com.tencent.mm.plugin.ball.model.BallInfo.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BallInfo[] newArray(int i2) {
            return new BallInfo[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BallInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(127525);
            BallInfo ballInfo = new BallInfo(parcel);
            AppMethodBeat.o(127525);
            return ballInfo;
        }
    };
    public int beK;
    public long createTime;
    public long crj;
    public String desc;
    public boolean gqx;
    public String icon;
    public Bundle jkf;
    public String key;
    public String name;
    public boolean nno;
    public int noe;
    public int oWl;
    public Point oWm;
    public Point oWn;
    public View oWo;
    public long oWp;
    public boolean oWq;
    public boolean oWr;
    public BallReportInfo oWs;
    public a oWt;
    public boolean oWu;
    public long progress;
    public int state;
    public String tag;
    public int type;
    public View vk;

    public static class a {
        public Point oWv;
        public Point oWw;
    }

    public BallInfo(int i2, String str) {
        this(i2, str, null);
    }

    private BallInfo(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(127528);
        this.oWl = 0;
        this.oWm = null;
        this.oWn = null;
        this.noe = -1;
        this.progress = -2147483648L;
        this.oWp = 0;
        this.createTime = 0;
        this.crj = 0;
        this.oWq = false;
        this.jkf = new Bundle();
        this.state = 0;
        this.oWr = false;
        this.nno = false;
        this.gqx = false;
        this.oWt = null;
        this.oWu = false;
        this.type = i2;
        this.key = str;
        this.oWs = jSONObject == null ? new BallReportInfo() : new BallReportInfo(jSONObject);
        this.beK = i2;
        AppMethodBeat.o(127528);
    }

    public final String cif() {
        AppMethodBeat.i(127529);
        String format = String.format("%s#%s", Integer.valueOf(this.type), this.key);
        AppMethodBeat.o(127529);
        return format;
    }

    public final int cig() {
        if (this.state == 8 || this.state == 4) {
            return 4;
        }
        return this.state;
    }

    private synchronized void cih() {
        AppMethodBeat.i(127530);
        if (this.jkf == null) {
            this.jkf = new Bundle();
        }
        AppMethodBeat.o(127530);
    }

    public final synchronized boolean hasExtra(String str) {
        boolean z;
        AppMethodBeat.i(127531);
        if (this.jkf == null || Util.isNullOrNil(str)) {
            z = false;
            AppMethodBeat.o(127531);
        } else {
            z = this.jkf.containsKey(str);
            AppMethodBeat.o(127531);
        }
        return z;
    }

    public final synchronized void eS(String str, String str2) {
        AppMethodBeat.i(127532);
        if (!Util.isNullOrNil(str)) {
            cih();
            this.jkf.putString(str, str2);
        }
        AppMethodBeat.o(127532);
    }

    public final synchronized String eT(String str, String str2) {
        AppMethodBeat.i(127533);
        if (hasExtra(str)) {
            str2 = this.jkf.getString(str, str2);
            AppMethodBeat.o(127533);
        } else {
            AppMethodBeat.o(127533);
        }
        return str2;
    }

    public final synchronized byte[] getByteArrayExtra(String str) {
        byte[] bArr;
        AppMethodBeat.i(127534);
        if (hasExtra(str)) {
            bArr = this.jkf.getByteArray(str);
            AppMethodBeat.o(127534);
        } else {
            bArr = null;
            AppMethodBeat.o(127534);
        }
        return bArr;
    }

    public final synchronized void cy(String str, int i2) {
        AppMethodBeat.i(127535);
        if (!Util.isNullOrNil(str)) {
            cih();
            this.jkf.putInt(str, i2);
        }
        AppMethodBeat.o(127535);
    }

    public final synchronized int getIntExtra(String str, int i2) {
        AppMethodBeat.i(127536);
        if (hasExtra(str)) {
            i2 = this.jkf.getInt(str, i2);
            AppMethodBeat.o(127536);
        } else {
            AppMethodBeat.o(127536);
        }
        return i2;
    }

    public final synchronized void X(String str, long j2) {
        AppMethodBeat.i(127537);
        if (!Util.isNullOrNil(str)) {
            cih();
            this.jkf.putLong(str, j2);
        }
        AppMethodBeat.o(127537);
    }

    public final synchronized long agQ(String str) {
        long j2 = 0;
        synchronized (this) {
            AppMethodBeat.i(127538);
            if (hasExtra(str)) {
                j2 = this.jkf.getLong(str, 0);
                AppMethodBeat.o(127538);
            } else {
                AppMethodBeat.o(127538);
            }
        }
        return j2;
    }

    public final synchronized void G(String str, byte[] bArr) {
        AppMethodBeat.i(127539);
        if (!Util.isNullOrNil(str)) {
            cih();
            this.jkf.putByteArray(str, bArr);
        }
        AppMethodBeat.o(127539);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(127540);
        if (obj instanceof BallInfo) {
            BallInfo ballInfo = (BallInfo) obj;
            if (this.type == ballInfo.type && !Util.isNullOrNil(this.key) && !Util.isNullOrNil(ballInfo.key) && this.key.equals(ballInfo.key)) {
                AppMethodBeat.o(127540);
                return true;
            }
        }
        AppMethodBeat.o(127540);
        return false;
    }

    public String toString() {
        AppMethodBeat.i(127541);
        String str = "BallInfo{type=" + this.type + ", key='" + this.key + '\'' + ", contentType='" + this.beK + '\'' + ", passive=" + this.oWr + ", hidden=" + this.nno + ", icon='" + this.icon + '\'' + ", iconResId=" + this.noe + ", name='" + this.name + '\'' + ", desc='" + this.desc + '\'' + ", tag='" + this.tag + '\'' + ", progress='" + this.progress + '\'' + ", state=" + this.state + ", activeTime=" + this.oWp + ", createTime=" + this.createTime + ", reportInfo=" + this.oWs.toString() + '}';
        AppMethodBeat.o(127541);
        return str;
    }

    public final synchronized void w(BallInfo ballInfo) {
        AppMethodBeat.i(188575);
        if (ballInfo != null) {
            this.icon = ballInfo.icon;
            this.noe = ballInfo.noe;
            this.name = ballInfo.name;
            this.desc = ballInfo.desc;
            this.tag = ballInfo.tag;
            this.progress = ballInfo.progress;
            this.jkf = ballInfo.jkf;
            this.state = ballInfo.state;
            this.oWr = ballInfo.oWr;
            this.vk = ballInfo.vk;
            this.beK = ballInfo.beK;
            a(ballInfo.oWs);
        }
        AppMethodBeat.o(188575);
    }

    private void a(BallReportInfo ballReportInfo) {
        this.oWs.dPJ = ballReportInfo.dPJ;
        this.oWs.iNV = ballReportInfo.iNV;
        this.oWs.oWy = ballReportInfo.oWy;
        this.oWs.hDa = ballReportInfo.hDa;
        this.oWs.oWx = ballReportInfo.oWx;
        this.oWs.hCZ = ballReportInfo.hCZ;
        this.oWs.opType = ballReportInfo.opType;
    }

    public final synchronized void b(BallReportInfo ballReportInfo) {
        AppMethodBeat.i(188576);
        a(ballReportInfo);
        AppMethodBeat.o(188576);
    }

    protected BallInfo(Parcel parcel) {
        boolean z;
        AppMethodBeat.i(127542);
        this.oWl = 0;
        this.oWm = null;
        this.oWn = null;
        this.noe = -1;
        this.progress = -2147483648L;
        this.oWp = 0;
        this.createTime = 0;
        this.crj = 0;
        this.oWq = false;
        this.jkf = new Bundle();
        this.state = 0;
        this.oWr = false;
        this.nno = false;
        this.gqx = false;
        this.oWt = null;
        this.oWu = false;
        try {
            this.type = parcel.readInt();
            this.key = parcel.readString();
            this.icon = parcel.readString();
            this.noe = parcel.readInt();
            this.name = parcel.readString();
            this.desc = parcel.readString();
            this.tag = parcel.readString();
            this.progress = parcel.readLong();
            this.jkf = parcel.readBundle(getClass().getClassLoader());
            this.state = parcel.readInt();
            this.oWr = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.nno = z;
            BallReportInfo ballReportInfo = (BallReportInfo) parcel.readParcelable(getClass().getClassLoader());
            this.oWs = ballReportInfo == null ? new BallReportInfo() : ballReportInfo;
            this.beK = parcel.readInt();
            AppMethodBeat.o(127542);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BallInfo", e2, "readFromParcel fail, exception:%s", e2);
            AppMethodBeat.o(127542);
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        AppMethodBeat.i(127543);
        try {
            parcel.writeInt(this.type);
            parcel.writeString(this.key);
            parcel.writeString(this.icon);
            parcel.writeInt(this.noe);
            parcel.writeString(this.name);
            parcel.writeString(this.desc);
            parcel.writeString(this.tag);
            parcel.writeLong(this.progress);
            parcel.writeBundle(this.jkf != null ? this.jkf : new Bundle());
            parcel.writeInt(this.state);
            parcel.writeInt(this.oWr ? 1 : 0);
            if (this.nno) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeParcelable(this.oWs, i2);
            parcel.writeInt(this.beK);
            AppMethodBeat.o(127543);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BallInfo", e2, "writeToParcel fail, exception:%s", e2);
            AppMethodBeat.o(127543);
        }
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(127548);
        AppMethodBeat.o(127548);
    }

    public static BallInfo av(JSONObject jSONObject) {
        AppMethodBeat.i(127544);
        try {
            BallInfo ballInfo = new BallInfo(jSONObject.getInt("type"), jSONObject.getString("key"), jSONObject.optJSONObject("reportInfo"));
            ballInfo.beK = jSONObject.optInt(DownloadInfo.CONTENTTYPE, 0);
            ballInfo.nno = jSONObject.optBoolean("hidden", false);
            ballInfo.oWr = jSONObject.optBoolean("passive", false);
            ballInfo.state = jSONObject.optInt("state", 0);
            ballInfo.icon = jSONObject.optString("icon");
            ballInfo.noe = jSONObject.optInt("iconResId", -1);
            ballInfo.name = jSONObject.optString("name");
            ballInfo.desc = jSONObject.optString("desc");
            ballInfo.tag = jSONObject.optString("tag");
            ballInfo.progress = jSONObject.optLong("progress");
            ballInfo.oWp = jSONObject.optLong("activeTime", 0);
            ballInfo.createTime = jSONObject.optLong("createTime", 0);
            ballInfo.jkf = aw(jSONObject.optJSONObject("extra"));
            AppMethodBeat.o(127544);
            return ballInfo;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BallInfo", e2, "convertJSONObjectToBallInfo fail, exception:%s", e2);
            AppMethodBeat.o(127544);
            return null;
        }
    }

    public static JSONObject x(BallInfo ballInfo) {
        AppMethodBeat.i(127545);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", ballInfo.type);
            jSONObject.put(DownloadInfo.CONTENTTYPE, ballInfo.beK);
            jSONObject.put("key", ballInfo.key);
            jSONObject.put("name", ballInfo.name);
            jSONObject.put("desc", ballInfo.desc);
            jSONObject.put("tag", ballInfo.tag);
            jSONObject.put("progress", ballInfo.progress);
            jSONObject.put("icon", ballInfo.icon);
            jSONObject.put("iconResId", ballInfo.noe);
            jSONObject.put("state", ballInfo.state);
            jSONObject.put("activeTime", ballInfo.oWp);
            jSONObject.put("createTime", ballInfo.createTime);
            jSONObject.put("passive", ballInfo.oWr);
            jSONObject.put("hidden", ballInfo.nno);
            jSONObject.put("extra", U(ballInfo.jkf));
            jSONObject.put("reportInfo", ballInfo.oWs.cii());
            AppMethodBeat.o(127545);
            return jSONObject;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BallInfo", e2, "convertBallInfoToJSONObject fail, exception:%s", e2);
            AppMethodBeat.o(127545);
            return null;
        }
    }

    private static JSONObject U(Bundle bundle) {
        AppMethodBeat.i(127546);
        JSONObject jSONObject = new JSONObject();
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    for (String str : bundle.keySet()) {
                        jSONObject.put(str, new b(bundle.get(str)));
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.BallInfo", e2, "convertBallInfoToJSONObject fail, exception:%s", e2);
            }
        }
        AppMethodBeat.o(127546);
        return jSONObject;
    }

    private static Bundle aw(JSONObject jSONObject) {
        AppMethodBeat.i(127547);
        Bundle bundle = new Bundle();
        if (jSONObject != null) {
            try {
                if (jSONObject.length() > 0) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        b.a(bundle, next, jSONObject.getJSONObject(next));
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.BallInfo", e2, "convertJSONObjectToBundle fail, exception:%s", e2);
            }
        }
        AppMethodBeat.o(127547);
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public static final class b extends JSONObject {
        public b(Object obj) {
            AppMethodBeat.i(127526);
            if (obj instanceof String) {
                put("type", 1);
                put("val", obj);
                AppMethodBeat.o(127526);
            } else if (obj instanceof Integer) {
                put("type", 2);
                put("val", obj);
                AppMethodBeat.o(127526);
            } else if (obj instanceof Long) {
                put("type", 3);
                put("val", obj);
                AppMethodBeat.o(127526);
            } else if (obj instanceof Double) {
                put("type", 4);
                put("val", obj);
                AppMethodBeat.o(127526);
            } else if (obj instanceof Boolean) {
                put("type", 5);
                put("val", obj);
                AppMethodBeat.o(127526);
            } else if (obj instanceof byte[]) {
                put("type", 6);
                put("val", Base64.encodeToString((byte[]) obj, 2));
                AppMethodBeat.o(127526);
            } else {
                Log.w("MicroMsg.BallInfo", "not support type, class:%s", obj.getClass());
                put("type", 0);
                AppMethodBeat.o(127526);
            }
        }

        static /* synthetic */ void a(Bundle bundle, String str, JSONObject jSONObject) {
            AppMethodBeat.i(127527);
            try {
                switch (jSONObject.getInt("type")) {
                    case 1:
                        bundle.putString(str, jSONObject.getString("val"));
                        AppMethodBeat.o(127527);
                        return;
                    case 2:
                        bundle.putInt(str, jSONObject.getInt("val"));
                        AppMethodBeat.o(127527);
                        return;
                    case 3:
                        bundle.putLong(str, jSONObject.getLong("val"));
                        AppMethodBeat.o(127527);
                        return;
                    case 4:
                        bundle.putDouble(str, jSONObject.getDouble("val"));
                        AppMethodBeat.o(127527);
                        return;
                    case 5:
                        bundle.putBoolean(str, jSONObject.getBoolean("val"));
                        AppMethodBeat.o(127527);
                        return;
                    case 6:
                        bundle.putByteArray(str, Base64.decode(jSONObject.getString("val"), 2));
                        AppMethodBeat.o(127527);
                        return;
                    default:
                        Log.w("MicroMsg.BallInfo", "restoreToBundle, not support type");
                        AppMethodBeat.o(127527);
                        return;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.BallInfo", e2, "restoreToBundle fail, exception:%s", e2);
                AppMethodBeat.o(127527);
            }
        }
    }
}
