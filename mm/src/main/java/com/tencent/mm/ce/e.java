package com.tencent.mm.ce;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.emoji.e.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class e {
    private static e NKR = null;
    private final String IFy = "assets:///panel/";
    private String[] NKS;
    private String[] NKT;
    private final List<SmileyPanelConfigInfo> NKU = Collections.synchronizedList(new ArrayList());
    private SparseArray<SmileyPanelConfigInfo> NKV = new SparseArray<>();
    private String country;
    private String dFG = "";
    private final String gVw;
    private final String versionName = "config.conf";

    public e(Context context) {
        AppMethodBeat.i(104920);
        StringBuilder sb = new StringBuilder();
        a aVar = a.hdT;
        this.gVw = sb.append(a.awv()).append("panel/").toString();
        this.NKS = context.getResources().getStringArray(R.array.a3);
        this.NKT = context.getResources().getStringArray(R.array.a5);
        this.NKU.clear();
        this.NKV.clear();
        gxP();
        this.country = LocaleUtil.getApplicationLanguage();
        if (!MMApplicationContext.isMainProcess()) {
            gxQ();
        }
        AppMethodBeat.o(104920);
    }

    private void gxP() {
        int i2 = 0;
        AppMethodBeat.i(104921);
        if (!(this.NKS == null || this.NKT == null)) {
            int length = this.NKS.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                SmileyPanelConfigInfo smileyPanelConfigInfo = new SmileyPanelConfigInfo(i4, this.NKS[i3]);
                this.NKU.add(smileyPanelConfigInfo);
                this.NKV.put(i4, smileyPanelConfigInfo);
                i3++;
                i4++;
            }
            int length2 = this.NKT.length;
            while (i2 < length2) {
                SmileyPanelConfigInfo smileyPanelConfigInfo2 = new SmileyPanelConfigInfo(i4, this.NKT[i2]);
                this.NKU.add(smileyPanelConfigInfo2);
                this.NKV.put(i4, smileyPanelConfigInfo2);
                i2++;
                i4++;
            }
        }
        AppMethodBeat.o(104921);
    }

    public final boolean gxQ() {
        AppMethodBeat.i(104922);
        Log.i("MicroMsg.MergerSmileyManager", "checkNewSmiley ");
        ArrayList<SmileyPanelConfigInfo> cFK = ((PluginEmoji) g.ah(PluginEmoji.class)).getProvider().cFK();
        if (cFK == null || cFK.isEmpty()) {
            cbZ();
            AppMethodBeat.o(104922);
            return true;
        }
        cbZ();
        AppMethodBeat.o(104922);
        return false;
    }

    public int cbZ() {
        ArrayList<SmileyPanelConfigInfo> arrayList;
        int i2;
        String str;
        int i3;
        AppMethodBeat.i(104923);
        Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo");
        this.NKU.clear();
        this.dFG = ((d) g.ah(d.class)).getProvider().cFN();
        new ArrayList();
        ArrayList<SmileyPanelConfigInfo> arrayList2 = new ArrayList<>();
        int EY = b.EY(this.gVw + "config.conf");
        int EY2 = b.EY("assets:///panel/config.conf");
        String str2 = this.gVw + this.dFG;
        String str3 = "assets:///panel/" + this.dFG;
        Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: local:%s, asset:%s", Integer.valueOf(EY), Integer.valueOf(EY2));
        if (EY > 0 && EY >= EY2 && s.YS(str2)) {
            arrayList2 = b.e(new o(str2));
            Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: localSize %s", Integer.valueOf(arrayList2.size()));
        }
        if (arrayList2.size() <= 0) {
            ArrayList<SmileyPanelConfigInfo> e2 = b.e(new o(str3));
            if (e2.size() < 50) {
                Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: from asset xml %s", Integer.valueOf(e2.size()));
                try {
                    Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: %s", s.boY("assets:///panel/" + this.dFG));
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.MergerSmileyManager", e3, "", new Object[0]);
                }
            }
            arrayList = e2;
        } else {
            arrayList = arrayList2;
        }
        if (!arrayList.isEmpty()) {
            ArrayList<String> gxY = f.gxT().gxY();
            int size = arrayList.size();
            int i4 = 0;
            int i5 = 0;
            while (i4 < size) {
                SmileyPanelConfigInfo smileyPanelConfigInfo = arrayList.get(i4);
                String str4 = smileyPanelConfigInfo.field_key;
                if (str4.matches("^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$")) {
                    str = new String(Base64.decode(str4, 0));
                    smileyPanelConfigInfo.field_key = str;
                } else {
                    str = str4;
                }
                if (!str.startsWith("[") || gxY.contains(str)) {
                    this.NKU.add(smileyPanelConfigInfo);
                    this.NKV.put(i5, smileyPanelConfigInfo);
                    i3 = i5 + 1;
                } else {
                    Log.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", str);
                    i3 = i5;
                }
                i4++;
                i5 = i3;
            }
            i2 = 0;
        } else {
            gxP();
            Log.i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
            i2 = -1;
        }
        AppMethodBeat.o(104923);
        return i2;
    }

    public int cca() {
        AppMethodBeat.i(104924);
        if (this.NKU == null) {
            AppMethodBeat.o(104924);
            return 0;
        }
        int size = this.NKU.size();
        AppMethodBeat.o(104924);
        return size;
    }

    public static e gxR() {
        AppMethodBeat.i(104925);
        if (NKR == null) {
            synchronized (e.class) {
                try {
                    NKR = new e(MMApplicationContext.getContext());
                } catch (Throwable th) {
                    AppMethodBeat.o(104925);
                    throw th;
                }
            }
        }
        e eVar = NKR;
        AppMethodBeat.o(104925);
        return eVar;
    }

    public final List<SmileyPanelConfigInfo> gxS() {
        ArrayList arrayList;
        AppMethodBeat.i(177035);
        synchronized (this.NKU) {
            try {
                arrayList = new ArrayList(this.NKU);
            } finally {
                AppMethodBeat.o(177035);
            }
        }
        return arrayList;
    }

    public final boolean containsKey(String str) {
        AppMethodBeat.i(177036);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(177036);
            return false;
        }
        synchronized (this.NKU) {
            try {
                for (SmileyPanelConfigInfo smileyPanelConfigInfo : this.NKU) {
                    if (Util.isEqual(smileyPanelConfigInfo.field_key, str)) {
                        return true;
                    }
                }
                AppMethodBeat.o(177036);
                return false;
            } finally {
                AppMethodBeat.o(177036);
            }
        }
    }

    public Drawable Al(int i2) {
        AppMethodBeat.i(104926);
        if (this.NKV == null) {
            Log.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
            AppMethodBeat.o(104926);
            return null;
        }
        SmileyPanelConfigInfo smileyPanelConfigInfo = this.NKV.get(i2);
        if (smileyPanelConfigInfo == null) {
            Log.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
            AppMethodBeat.o(104926);
            return null;
        }
        Drawable bid = bid(smileyPanelConfigInfo.field_key);
        AppMethodBeat.o(104926);
        return bid;
    }

    public static Drawable bid(String str) {
        AppMethodBeat.i(177037);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(177037);
            return null;
        }
        SmileyInfo bii = f.gxT().bii(str);
        if (bii != null) {
            Drawable a2 = f.gxT().a(bii);
            AppMethodBeat.o(177037);
            return a2;
        }
        Drawable a3 = b.gxI().a(b.gxI().bic(str), true);
        AppMethodBeat.o(177037);
        return a3;
    }

    public final String bie(String str) {
        AppMethodBeat.i(177038);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(177038);
            return "";
        }
        SmileyInfo bii = f.gxT().bii(str);
        if (bii == null) {
            AppMethodBeat.o(177038);
            return str;
        } else if (this.country.equals(LocaleUtil.CHINA) && !Util.isNullOrNil(bii.field_cnValue)) {
            String str2 = bii.field_cnValue;
            AppMethodBeat.o(177038);
            return str2;
        } else if ((this.country.equals(LocaleUtil.TAIWAN) || this.country.equals(LocaleUtil.HONGKONG)) && !Util.isNullOrNil(bii.field_twValue)) {
            String str3 = bii.field_twValue;
            AppMethodBeat.o(177038);
            return str3;
        } else {
            String str4 = bii.field_enValue;
            AppMethodBeat.o(177038);
            return str4;
        }
    }

    public String An(int i2) {
        String str;
        AppMethodBeat.i(104928);
        synchronized (this.NKU) {
            if (i2 >= 0) {
                try {
                    if (i2 < this.NKU.size()) {
                        SmileyPanelConfigInfo smileyPanelConfigInfo = this.NKU.get(i2);
                        if (smileyPanelConfigInfo != null) {
                            str = smileyPanelConfigInfo.field_key;
                        } else {
                            str = "";
                            AppMethodBeat.o(104928);
                        }
                    }
                } finally {
                    AppMethodBeat.o(104928);
                }
            }
            Log.w("MicroMsg.MergerSmileyManager", "get text key, error index");
            str = "";
            AppMethodBeat.o(104928);
        }
        return str;
    }

    public String Am(int i2) {
        AppMethodBeat.i(104929);
        if (i2 < 0) {
            Log.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
            AppMethodBeat.o(104929);
            return "";
        }
        String[] split = gxR().NKT[i2].split(" ");
        char[] chars = Character.toChars(Integer.decode(split[0]).intValue());
        char[] chars2 = Character.toChars(Integer.decode(split[1]).intValue());
        StringBuilder sb = new StringBuilder();
        sb.append(chars);
        sb.append(chars2);
        String sb2 = sb.toString();
        AppMethodBeat.o(104929);
        return sb2;
    }
}
