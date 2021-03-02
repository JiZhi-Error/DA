package com.tencent.mm.plugin.qqmail.d;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.SparseArray;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.qqmail.c;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class v {
    public static final String BrS = WeChatHosts.domainString(R.string.e2s);
    public static final String BrT = (WeChatHosts.domainString(R.string.e2s) + ":443");
    private static SparseArray<String> BrZ = null;
    public m BrU;
    public h BrV;
    private j BrW;
    private Map<Long, c.C1612c> BrX = new HashMap();
    private Map<Long, a> BrY = new HashMap();
    Map<String, String> cookie = new HashMap();

    static /* synthetic */ String Vg(int i2) {
        AppMethodBeat.i(198621);
        String Vf = Vf(i2);
        AppMethodBeat.o(198621);
        return Vf;
    }

    static {
        AppMethodBeat.i(198622);
        AppMethodBeat.o(198622);
    }

    public final long a(String str, Map<String, String> map, c.a aVar) {
        AppMethodBeat.i(198613);
        long a2 = a(str, map, new c.b(), aVar);
        AppMethodBeat.o(198613);
        return a2;
    }

    public final long a(String str, Map<String, String> map, c.b bVar, c.a aVar) {
        AppMethodBeat.i(198614);
        long a2 = a(str, 1, map, bVar, aVar);
        AppMethodBeat.o(198614);
        return a2;
    }

    public v() {
        AppMethodBeat.i(198615);
        reset();
        AppMethodBeat.o(198615);
    }

    public static String eGq() {
        AppMethodBeat.i(198616);
        String str = HttpWrapperBase.PROTOCAL_HTTPS + BrS;
        AppMethodBeat.o(198616);
        return str;
    }

    public final long a(String str, int i2, Map<String, String> map, c.b bVar, c.a aVar) {
        AppMethodBeat.i(198617);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("appname", "qqmail_weixin");
        map.put("f", "xml");
        map.put("charset", ProtocolPackage.ServerEncoding);
        map.put("clientip", getLocalIp());
        final c.C1612c cVar = new c.C1612c(eGq() + str, new c.e(i2, map, this.cookie), aVar);
        cVar.BqN = bVar;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.qqmail.d.v.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(122726);
                a aVar = new a(v.this, (byte) 0);
                v.this.BrX.put(Long.valueOf(cVar.id), cVar);
                v.this.BrY.put(Long.valueOf(cVar.id), aVar);
                aVar.b(cVar);
                AppMethodBeat.o(122726);
            }
        });
        long j2 = cVar.id;
        AppMethodBeat.o(198617);
        return j2;
    }

    private void cancel() {
        AppMethodBeat.i(122745);
        for (a aVar : this.BrY.values()) {
            aVar.cancel(true);
        }
        this.BrY.clear();
        this.BrX.clear();
        AppMethodBeat.o(122745);
    }

    public final void cancel(long j2) {
        AppMethodBeat.i(122746);
        a aVar = this.BrY.get(Long.valueOf(j2));
        if (aVar != null) {
            aVar.onCancelled();
            aVar.cancel(true);
        }
        this.BrY.remove(Long.valueOf(j2));
        this.BrX.remove(Long.valueOf(j2));
        AppMethodBeat.o(122746);
    }

    public final void reset() {
        AppMethodBeat.i(122747);
        cancel();
        this.cookie.clear();
        String eGr = eGr();
        if (Util.isNullOrNil(eGr)) {
            this.BrU = new m("wcf://mailapp/" + "addr/mail_address/addrpage");
            this.BrU.BrA.blr();
        } else {
            this.BrU = new m("wcf://mailapp/" + "addr/mail_address/" + eGr + "/addrpage");
        }
        this.BrV = new h("wcf://mailapp/" + "draft/");
        this.BrW = new j("wcf://mailapp/" + "http/", 0);
        AppMethodBeat.o(122747);
    }

    public static String getDownloadPath() {
        AppMethodBeat.i(122749);
        String str = b.aLG() + "attach/";
        s.boN(str);
        AppMethodBeat.o(122749);
        return str;
    }

    public static an at(Bundle bundle) {
        AppMethodBeat.i(198618);
        an anVar = new an();
        anVar.BsV = bundle.getInt("mail_send_type");
        anVar.BsZ = bundle.getString("mail_id");
        anVar.Bru = bundle.getString("mail_subject");
        anVar.content = bundle.getString("mail_content");
        Log.i("MicroMsg.Mail.NormalMailAppService", "parseSendMailContent before content:%s", anVar.content);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("mail_image_attach");
        if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                Bundle bundle2 = (Bundle) it.next();
                String string = bundle2.getString("attach_fileId", "");
                String string2 = bundle2.getString("attach_name", "");
                String string3 = bundle2.getString("attach_path", "");
                anVar.content = anVar.content.replaceAll(String.format("src=\"%s\"", "file://".concat(String.valueOf(string3))), String.format("src=\"/attach/preview?bizid=50&fileid=%s&name=%s\"", string, string2));
            }
        }
        Log.i("MicroMsg.Mail.NormalMailAppService", "parseSendMailContent after content:%s", anVar.content);
        anVar.Bta = true;
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("mail_from_list");
        if (parcelableArrayList2 != null && !parcelableArrayList2.isEmpty()) {
            anVar.BsW = new al();
            al alVar = anVar.BsW;
            g.aAf();
            alVar.uin = (long) com.tencent.mm.kernel.a.getUin();
            anVar.BsW.BsK = ((Bundle) parcelableArrayList2.get(0)).getString("item_addr");
            anVar.BsW.nickname = ((Bundle) parcelableArrayList2.get(0)).getString(FirebaseAnalytics.b.ITEM_NAME);
            Log.i("MicroMsg.Mail.NormalMailAppService", "from addr %s", anVar.BsW.BsK);
        }
        ArrayList parcelableArrayList3 = bundle.getParcelableArrayList("mail_to_list");
        if (parcelableArrayList3 != null && !parcelableArrayList3.isEmpty()) {
            Iterator it2 = parcelableArrayList3.iterator();
            while (it2.hasNext()) {
                Bundle bundle3 = (Bundle) it2.next();
                al alVar2 = new al();
                alVar2.BsK = bundle3.getString("item_addr");
                alVar2.nickname = bundle3.getString(FirebaseAnalytics.b.ITEM_NAME);
                anVar.BsN.add(alVar2);
                Log.i("MicroMsg.Mail.NormalMailAppService", "to addr %s", alVar2.BsK);
            }
        }
        ArrayList parcelableArrayList4 = bundle.getParcelableArrayList("mail_cc_list");
        if (parcelableArrayList4 != null && !parcelableArrayList4.isEmpty()) {
            Iterator it3 = parcelableArrayList4.iterator();
            while (it3.hasNext()) {
                Bundle bundle4 = (Bundle) it3.next();
                al alVar3 = new al();
                alVar3.BsK = bundle4.getString("item_addr");
                alVar3.nickname = bundle4.getString(FirebaseAnalytics.b.ITEM_NAME);
                anVar.BsO.add(alVar3);
                Log.i("MicroMsg.Mail.NormalMailAppService", "cc addr %s", alVar3.BsK);
            }
        }
        ArrayList parcelableArrayList5 = bundle.getParcelableArrayList("mail_bcc_list");
        if (parcelableArrayList5 != null && !parcelableArrayList5.isEmpty()) {
            Iterator it4 = parcelableArrayList5.iterator();
            while (it4.hasNext()) {
                Bundle bundle5 = (Bundle) it4.next();
                al alVar4 = new al();
                alVar4.BsK = bundle5.getString("item_addr");
                alVar4.nickname = bundle5.getString(FirebaseAnalytics.b.ITEM_NAME);
                anVar.BsP.add(alVar4);
                Log.i("MicroMsg.Mail.NormalMailAppService", "bcc addr %s", alVar4.BsK);
            }
        }
        ArrayList parcelableArrayList6 = bundle.getParcelableArrayList("mail_normal_attach");
        if (parcelableArrayList6 != null && !parcelableArrayList6.isEmpty()) {
            Iterator it5 = parcelableArrayList6.iterator();
            while (it5.hasNext()) {
                Bundle bundle6 = (Bundle) it5.next();
                ak akVar = new ak();
                akVar.fileid = bundle6.getString("attach_fileId");
                akVar.key = bundle6.getString("attach_key");
                akVar.name = bundle6.getString("attach_name");
                akVar.size = bundle6.getInt("attach_size");
                akVar.BsJ = bundle6.getString("attach_download_url");
                akVar.type = bundle6.getString("attach_type");
                anVar.BsX.add(akVar);
                Log.i("MicroMsg.Mail.NormalMailAppService", "attach %s,%s,%s", akVar.fileid, akVar.name, akVar.BsJ);
            }
        }
        ArrayList parcelableArrayList7 = bundle.getParcelableArrayList("mail_big_attach");
        if (parcelableArrayList7 != null && !parcelableArrayList7.isEmpty()) {
            Iterator it6 = parcelableArrayList7.iterator();
            while (it6.hasNext()) {
                Bundle bundle7 = (Bundle) it6.next();
                ak akVar2 = new ak();
                akVar2.fileid = bundle7.getString("attach_fileId");
                akVar2.key = bundle7.getString("attach_key");
                akVar2.name = bundle7.getString("attach_name");
                akVar2.size = bundle7.getInt("attach_size");
                akVar2.BsJ = bundle7.getString("attach_download_url");
                akVar2.type = bundle7.getString("attach_type");
                anVar.BsY.add(akVar2);
                Log.i("MicroMsg.Mail.NormalMailAppService", "big attach %s,%s,%s", akVar2.fileid, akVar2.name, akVar2.BsJ);
            }
        }
        AppMethodBeat.o(198618);
        return anVar;
    }

    private static String getLocalIp() {
        AppMethodBeat.i(122750);
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            String hostAddress = nextElement.getHostAddress();
                            AppMethodBeat.o(122750);
                            return hostAddress;
                        }
                    }
                }
            }
        } catch (Exception | SocketException e2) {
        }
        AppMethodBeat.o(122750);
        return null;
    }

    /* access modifiers changed from: package-private */
    public class a extends AsyncTask<c.C1612c, Integer, c.C1612c> implements c.d {
        private c Bsc;
        c.C1612c Bsd;

        private a() {
        }

        /* synthetic */ a(v vVar, byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ c.C1612c doInBackground(c.C1612c[] cVarArr) {
            byte[] bArr;
            String str;
            AppMethodBeat.i(122734);
            c.C1612c cVar = cVarArr[0];
            if (!Util.isNullOrNil(cVar.BqO.cookie.get("xm_skey"))) {
                if (!cVar.BqN.BqK && cVar.BqN.BqL) {
                    j jVar = v.this.BrW;
                    String str2 = cVar.uri;
                    Map<String, String> map = cVar.BqO.params;
                    if (str2 == null || str2.length() == 0) {
                        Log.e("Msg.Plugin.HttpRequestCache", "getCache, invalid argument");
                        bArr = null;
                    } else {
                        String J = j.J(str2, map);
                        byte[] readFromFile = j.readFromFile(jVar.Brx + J);
                        if (readFromFile == null) {
                            Log.i("Msg.Plugin.HttpRequestCache", "readFromFile fail, cipherText is null, read error or cache not exist");
                            bArr = null;
                        } else {
                            byte[] decrypt = j.decrypt(readFromFile, j.aKC(J));
                            if (decrypt == null) {
                                Log.e("Msg.Plugin.HttpRequestCache", "decrypt fail, plaintText is null");
                                bArr = null;
                            } else {
                                bArr = decrypt;
                            }
                        }
                    }
                    if (bArr == null) {
                        str = null;
                    } else {
                        str = new String(bArr);
                    }
                    if (str != null) {
                        cVar.BqP = new c.f(304, null, str);
                        if (cVar.BqN.BqM || !(cVar.BqP.status == 304 || cVar.BqP.status == 200)) {
                            Log.e("MicroMsg.Mail.NormalMailAppService", "http error, %d", Integer.valueOf(cVar.BqP.status));
                        } else {
                            Log.d("MicroMsg.Mail.NormalMailAppService", cVar.BqP.content);
                            cVar.BqQ = XmlParser.parseXml(cVar.BqP.content, "Response", null);
                        }
                    }
                }
                if (cVar.BqO.BqS != null) {
                    this.Bsc = new com.tencent.mm.plugin.qqmail.a();
                } else {
                    this.Bsc = new com.tencent.mm.plugin.qqmail.b();
                }
                cVar.BqP = this.Bsc.a(HttpWrapperBase.PROTOCAL_HTTPS, cVar.uri, cVar.BqO, this);
                if (cVar.BqP == null) {
                    AppMethodBeat.o(122734);
                    return null;
                }
                if (cVar.BqN.BqM) {
                }
                Log.e("MicroMsg.Mail.NormalMailAppService", "http error, %d", Integer.valueOf(cVar.BqP.status));
            }
            AppMethodBeat.o(122734);
            return cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(c.C1612c cVar) {
            AppMethodBeat.i(122733);
            c.C1612c cVar2 = cVar;
            if (cVar2 != null) {
                if (Util.isNullOrNil(cVar2.BqO.cookie.get("xm_skey"))) {
                    cVar2.BqR.onError(-5, "");
                } else if (cVar2.BqP.status == 304) {
                    v.a(cVar2);
                } else if (cVar2.BqP.status == 200) {
                    v vVar = v.this;
                    Map<String, String> map = cVar2.BqP.cookie;
                    if (!(vVar.cookie == null || map == null)) {
                        for (String str : map.keySet()) {
                            vVar.cookie.put(str, map.get(str));
                        }
                    }
                    if (v.a(cVar2) == 0 && cVar2.BqN.BqL) {
                        j jVar = v.this.BrW;
                        String str2 = cVar2.uri;
                        Map<String, String> map2 = cVar2.BqO.params;
                        byte[] bytes = cVar2.BqP.content.getBytes();
                        if (str2 == null || str2.length() == 0 || bytes == null || bytes.length == 0) {
                            Log.e("Msg.Plugin.HttpRequestCache", "setCache, invalid argument");
                        } else {
                            jVar.eGm();
                            String J = j.J(str2, map2);
                            byte[] encrypt = j.encrypt(bytes, j.aKC(J));
                            if (encrypt == null) {
                                Log.e("Msg.Plugin.HttpRequestCache", "encrypt fail, cipherText is null");
                            } else {
                                j.writeToFile(jVar.Brx + J, encrypt);
                            }
                        }
                    }
                } else {
                    cVar2.BqR.onError(cVar2.BqP.status, v.Vg(cVar2.BqP.status));
                }
                cVar2.BqR.onComplete();
                v.this.BrX.remove(Long.valueOf(cVar2.id));
                v.this.BrY.remove(Long.valueOf(cVar2.id));
            }
            AppMethodBeat.o(122733);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onProgressUpdate(Integer[] numArr) {
            AppMethodBeat.i(122732);
            numArr[0].intValue();
            AppMethodBeat.o(122732);
        }

        public final boolean b(c.C1612c cVar) {
            AppMethodBeat.i(198612);
            if (!cVar.BqR.onReady()) {
                AppMethodBeat.o(198612);
                return false;
            }
            this.Bsd = cVar;
            super.execute(cVar);
            AppMethodBeat.o(198612);
            return true;
        }

        @Override // com.tencent.mm.plugin.qqmail.c.d
        public final void eGj() {
            AppMethodBeat.i(122730);
            publishProgress(0);
            AppMethodBeat.o(122730);
        }

        /* access modifiers changed from: protected */
        public final void onCancelled() {
            AppMethodBeat.i(122731);
            g.aAi();
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.qqmail.d.v.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(122727);
                    if (a.this.Bsc != null) {
                        a.this.Bsc.cancel();
                    }
                    AppMethodBeat.o(122727);
                }

                public final String toString() {
                    AppMethodBeat.i(122728);
                    String str = super.toString() + "|onCancelled";
                    AppMethodBeat.o(122728);
                    return str;
                }
            });
            super.onCancelled();
            AppMethodBeat.o(122731);
        }
    }

    private static String bR(int i2, String str) {
        AppMethodBeat.i(122753);
        int i3 = 0;
        switch (i2) {
            case -105:
            case -6:
                i3 = R.string.foi;
                break;
            case -104:
                i3 = R.string.fog;
                break;
            case -103:
                i3 = R.string.fof;
                break;
            case -102:
                i3 = R.string.foe;
                break;
            case -7:
                i3 = R.string.foj;
                break;
            case -4:
            case -3:
                i3 = R.string.foh;
                break;
            case -1:
                i3 = R.string.foc;
                break;
        }
        if (i3 == 0) {
            AppMethodBeat.o(122753);
            return str;
        }
        String aI = com.tencent.mm.cb.a.aI(MMApplicationContext.getContext(), i3);
        AppMethodBeat.o(122753);
        return aI;
    }

    public static String eGr() {
        AppMethodBeat.i(198619);
        String str = ((IPCString) h.a(MMApplicationContext.getPackageName(), new IPCVoid(), com.tencent.mm.plugin.qqmail.c.c.class)).value;
        AppMethodBeat.o(198619);
        return str;
    }

    public final void clearData() {
        AppMethodBeat.i(122748);
        s.dy("wcf://mailapp/", true);
        reset();
        AppMethodBeat.o(122748);
    }

    private static String Vf(int i2) {
        AppMethodBeat.i(122752);
        if (BrZ == null) {
            BrZ = new SparseArray<>();
            Field[] declaredFields = HttpURLConnection.class.getDeclaredFields();
            for (Field field : declaredFields) {
                int modifiers = field.getModifiers();
                String name = field.getName();
                if (name != null && name.startsWith("HTTP_") && Modifier.isPublic(modifiers) && Modifier.isFinal(modifiers) && Modifier.isStatic(modifiers)) {
                    try {
                        int i3 = field.getInt(0);
                        StringBuilder sb = new StringBuilder();
                        String[] split = name.split("_");
                        if (split != null) {
                            for (int i4 = 1; i4 < split.length; i4++) {
                                sb.append(split[i4]).append(' ');
                            }
                            sb.append("error");
                        }
                        BrZ.put(i3, sb.toString().toLowerCase());
                    } catch (Exception e2) {
                    }
                }
            }
        }
        String str = BrZ.get(i2);
        if (str == null) {
            String bR = bR(i2, "request error");
            AppMethodBeat.o(122752);
            return bR;
        }
        AppMethodBeat.o(122752);
        return str;
    }

    static /* synthetic */ int a(c.C1612c cVar) {
        AppMethodBeat.i(198620);
        if (!cVar.BqN.BqM) {
            cVar.BqR.onSuccess(cVar.BqP.content, null);
            AppMethodBeat.o(198620);
            return 0;
        }
        c.f fVar = cVar.BqP;
        if (cVar.BqQ == null) {
            cVar.BqR.onError(-1002, "format error");
            AppMethodBeat.o(198620);
            return -1002;
        }
        int i2 = Util.getInt(cVar.BqQ.get(".Response.error.code"), 0);
        if (i2 == 0) {
            cVar.BqR.onSuccess(fVar.content, cVar.BqQ);
            AppMethodBeat.o(198620);
            return 0;
        }
        cVar.BqR.onError(i2, bR(i2, cVar.BqQ.get(".Response.error.message")));
        AppMethodBeat.o(198620);
        return i2;
    }
}
