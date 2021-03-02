package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.faw;
import com.tencent.mm.protocal.protobuf.fax;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 ?2\u00020\u0001:\u0001?B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0017H\u0002J\u001a\u0010#\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u001bH\u0002J\u0012\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010\f2\b\u0010,\u001a\u0004\u0018\u00010\fJ\u0012\u0010-\u001a\u0004\u0018\u00010\f2\b\u0010,\u001a\u0004\u0018\u00010\fJ\u0012\u0010.\u001a\u0004\u0018\u00010\f2\b\u0010/\u001a\u0004\u0018\u00010\fJ\u001c\u0010.\u001a\u0004\u0018\u00010\f2\b\u00100\u001a\u0004\u0018\u00010\f2\b\u0010/\u001a\u0004\u0018\u00010\fJ\u0014\u00101\u001a\u0004\u0018\u00010\f2\b\u0010,\u001a\u0004\u0018\u00010\fH\u0002J\u001e\u00102\u001a\u0004\u0018\u00010\u00142\b\u00100\u001a\u0004\u0018\u00010\f2\b\u0010/\u001a\u0004\u0018\u00010\fH\u0002J\u0014\u00103\u001a\u0004\u0018\u00010'2\b\u0010,\u001a\u0004\u0018\u00010\fH\u0002J8\u00104\u001a\u0002052\b\u00100\u001a\u0004\u0018\u00010\f2\b\u0010*\u001a\u0004\u0018\u00010\f2\b\u00106\u001a\u0004\u0018\u00010\f2\b\u0010/\u001a\u0004\u0018\u00010\f2\b\u00107\u001a\u0004\u0018\u00010\fJ\u0006\u00108\u001a\u00020$J$\u00109\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u00010\f2\b\u0010/\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020\u0014H\u0002J\u001a\u0010:\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010\f2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010;\u001a\u00020$H\u0002J\b\u0010<\u001a\u00020$H\u0002J\u0014\u0010=\u001a\u00020\f*\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\fJ\n\u0010>\u001a\u00020\f*\u00020\fJ\u001c\u0010,\u001a\u00020\f*\u00020\f2\u0006\u00100\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "", UserDataStore.CITY, "Landroid/content/Context;", "(Landroid/content/Context;)V", "checkTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "kvSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getKvSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "lastMusicId", "", "getLastMusicId", "()Ljava/lang/String;", "setLastMusicId", "(Ljava/lang/String;)V", "mContext", "mCurrentAlbumId", "mWebViewAlbumInfo", "Lcom/tencent/mm/protocal/protobuf/WebViewAlbumInfo;", "musicPlayerListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "getMusicPlayerListener", "()Lcom/tencent/mm/sdk/event/IListener;", "playActionSource", "", "getPlayActionSource", "()I", "setPlayActionSource", "(I)V", "playId", "getPlayId", "setPlayId", "doReport", "", "event", "info", "Lcom/tencent/mm/protocal/protobuf/WebViewAudioInfo;", "eventType", "formatReportData", "data", "getAlbumIdFromMusicId", "musicId", "getAudioIdFromMusicId", "getAudioListState", "domain", "albumId", "getDomainFromMusicId", "getWebViewAlbumInfoInfo", "getWebViewAudioInfo", "playAudioList", "", "playAudioId", "appId", "saveCurrentAudioPlayTime", "saveWebViewAlbumInfoInfo", "saveWebViewAudioInfo", "startTimer", "stopTimer", "albumInfoKey", "audioInfoKey", "Companion", "plugin-webview_release"})
public final class i {
    private static i JwQ;
    public static final a JwR = new a((byte) 0);
    private faw JwL;
    private String JwM;
    private int JwN;
    private String JwO;
    private String JwP;
    final IListener<mx> lEl;
    private Context mContext;
    private MTimerHandler mEP;
    private final MMKVSlotManager pvV;

    static {
        AppMethodBeat.i(182673);
        AppMethodBeat.o(182673);
    }

    private i(Context context) {
        AppMethodBeat.i(182672);
        this.JwM = "";
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__web_music_slot_mmkv_key__");
        p.g(mmkv, "MultiProcessMMKV.getMMKV…b_music_slot_mmkv_key__\")");
        this.pvV = new MMKVSlotManager(mmkv, 15552000);
        this.lEl = new c(this);
        this.mEP = new MTimerHandler("MicroMsg.MusicAlbumHelper", (MTimerHandler.CallBack) new b(this), true);
        this.JwN = 1;
        this.JwO = "";
        this.JwP = "";
        this.mContext = context;
        AppMethodBeat.o(182672);
    }

    public /* synthetic */ i(Context context, byte b2) {
        this(context);
    }

    public static final /* synthetic */ fax a(i iVar, String str) {
        AppMethodBeat.i(210576);
        fax bbb = iVar.bbb(str);
        AppMethodBeat.o(210576);
        return bbb;
    }

    public static final /* synthetic */ void a(i iVar, mx mxVar) {
        AppMethodBeat.i(210575);
        iVar.c(mxVar);
        AppMethodBeat.o(210575);
    }

    public static final /* synthetic */ void a(i iVar, String str, fax fax) {
        AppMethodBeat.i(210577);
        iVar.a(str, fax);
        AppMethodBeat.o(210577);
    }

    public static final /* synthetic */ void c(i iVar) {
        AppMethodBeat.i(182675);
        iVar.stopTimer();
        AppMethodBeat.o(182675);
    }

    private static String bh(String str, String str2, String str3) {
        AppMethodBeat.i(182661);
        p.h(str, "$this$musicId");
        p.h(str2, "albumId");
        String str4 = str3 + '_' + str2 + '_' + str;
        AppMethodBeat.o(182661);
        return str4;
    }

    private static String baZ(String str) {
        AppMethodBeat.i(210564);
        p.h(str, "$this$audioInfoKey");
        String str2 = "audioInfo_" + str + '}';
        AppMethodBeat.o(210564);
        return str2;
    }

    private static String mi(String str, String str2) {
        AppMethodBeat.i(210565);
        p.h(str, "$this$albumInfoKey");
        String str3 = "album_" + str2 + '_' + str + '}';
        AppMethodBeat.o(210565);
        return str3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "plugin-webview_release"})
    public static final class c extends IListener<mx> {
        final /* synthetic */ i JwS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(i iVar) {
            this.JwS = iVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(182660);
            mx mxVar2 = mxVar;
            p.h(mxVar2, "event");
            i.a(this.JwS, mxVar2);
            switch (mxVar2.dSE.action) {
                case 0:
                case 1:
                case 8:
                case 13:
                case 14:
                    f bef = com.tencent.mm.ay.a.bef();
                    if (bef != null && !Util.isNullOrNil(bef.jeV)) {
                        fax a2 = i.a(this.JwS, bef.jeV);
                        if ((a2 != null ? a2.Dzt : -1) >= 0) {
                            this.JwS.ghV();
                            if (this.JwS.mEP.stopped()) {
                                i.b(this.JwS);
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                case 3:
                case 4:
                    if (!this.JwS.mEP.stopped()) {
                        i.c(this.JwS);
                        break;
                    }
                    break;
                case 7:
                    fax a3 = i.a(this.JwS, mxVar2.dSE.dSF);
                    if (a3 != null && a3.Dzt >= 0 && a3.duration > 0) {
                        a3.Dzt = a3.duration;
                        i.a(this.JwS, mxVar2.dSE.dSF, a3);
                        break;
                    }
            }
            AppMethodBeat.o(182660);
            return false;
        }
    }

    public final synchronized String bba(String str) {
        String mj;
        AppMethodBeat.i(182667);
        mj = mj(((MultiProcessMMKV) this.pvV.getSlot()).decodeString("currentAlbumId"), str);
        AppMethodBeat.o(182667);
        return mj;
    }

    public final synchronized String mj(String str, String str2) {
        LinkedList<String> linkedList;
        String str3;
        int i2;
        AppMethodBeat.i(182668);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(182668);
            str3 = null;
        } else {
            ghV();
            if (!Util.isEqual(str, this.JwM) || this.JwL == null) {
                faw mk = mk(str, str2);
                if (mk != null) {
                    this.JwL = mk;
                    this.JwM = str;
                    linkedList = mk.Nxi;
                } else {
                    linkedList = null;
                }
            } else {
                faw faw = this.JwL;
                if (faw == null) {
                    p.hyc();
                }
                linkedList = faw.Nxi;
            }
            if (Util.isNullOrNil(linkedList)) {
                AppMethodBeat.o(182668);
                str3 = null;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("albumId", str);
                    faw faw2 = this.JwL;
                    if (faw2 == null || (i2 = faw2.Nxh) == null) {
                        i2 = 0;
                    }
                    jSONObject.put("audioId", i2);
                    if (linkedList != null) {
                        for (T t : linkedList) {
                            T t2 = t;
                            if (!(t2 == null || n.aL(t2))) {
                                if (str == null) {
                                    p.hyc();
                                }
                                fax bbb = bbb(bh(t, str, str2));
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("currentTime", (bbb != null ? bbb.Dzt : 0) / 1000);
                                jSONObject2.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, (bbb != null ? bbb.duration : 0) / 1000);
                                jSONObject2.put("playbackRate", bbb != null ? Float.valueOf(bbb.Nxp) : Float.valueOf(1.0f));
                                jSONObject.put(t, jSONObject2);
                            }
                        }
                    }
                    str3 = jSONObject.toString();
                    AppMethodBeat.o(182668);
                } catch (Exception e2) {
                    Log.w("MicroMsg.MusicAlbumHelper", "getAudioListState ex:%s", e2.getMessage());
                    AppMethodBeat.o(182668);
                    str3 = null;
                }
            }
        }
        return str3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0337  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38) {
        /*
        // Method dump skipped, instructions count: 855
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.media.i.k(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public final synchronized void ghV() {
        String str;
        AppMethodBeat.i(182670);
        f bef = com.tencent.mm.ay.a.bef();
        if (bef == null) {
            AppMethodBeat.o(182670);
        } else if (bef.jeV == null) {
            AppMethodBeat.o(182670);
        } else {
            com.tencent.mm.ay.c beg = com.tencent.mm.ay.a.beg();
            if (beg != null) {
                MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) this.pvV.getSlot();
                fax bbb = bbb(bef.jeV);
                if (bbb != null) {
                    if (bbb.Dzt >= 0) {
                        if (beg.getPosition() > 0) {
                            bbb.Dzt = beg.getPosition();
                        }
                        bbb.duration = Math.max(0, beg.getDuration());
                        a(bef.jeV, bbb);
                        String bbd = bbd(bef.jeV);
                        String bbe = bbe(bef.jeV);
                        fax bbb2 = bbb(bef.jeV);
                        if (bbb2 != null) {
                            str = bbb2.domain;
                        } else {
                            str = null;
                        }
                        if (!Util.isNullOrNil(bbd) && !Util.isNullOrNil(bbe)) {
                            multiProcessMMKV.encode("currentAlbumId", bbd);
                            faw mk = mk(bbd, str);
                            if (mk != null) {
                                faw faw = this.JwL;
                                if (faw != null) {
                                    faw.Nxh = bbe;
                                }
                                mk.Nxh = bbe;
                                a(bbd, str, mk);
                                AppMethodBeat.o(182670);
                            }
                        }
                    }
                    AppMethodBeat.o(182670);
                } else {
                    AppMethodBeat.o(182670);
                }
            } else {
                AppMethodBeat.o(182670);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class b implements MTimerHandler.CallBack {
        final /* synthetic */ i JwS;

        b(i iVar) {
            this.JwS = iVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(182659);
            this.JwS.ghV();
            AppMethodBeat.o(182659);
            return true;
        }
    }

    private final void stopTimer() {
        AppMethodBeat.i(182671);
        Log.d("MicroMsg.MusicAlbumHelper", "stop timer");
        this.mEP.stopTimer();
        AppMethodBeat.o(182671);
    }

    private final fax bbb(String str) {
        Object obj;
        byte[] decodeBytes;
        AppMethodBeat.i(210566);
        String str2 = str;
        if (str2 == null || n.aL(str2)) {
            AppMethodBeat.o(210566);
            return null;
        }
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) this.pvV.getSlot();
        String baZ = baZ(str);
        if (multiProcessMMKV.containsKey(baZ) && (decodeBytes = multiProcessMMKV.decodeBytes(baZ)) != null) {
            if (!(decodeBytes.length == 0)) {
                try {
                    Object newInstance = fax.class.newInstance();
                    ((com.tencent.mm.bw.a) newInstance).parseFrom(decodeBytes);
                    obj = (com.tencent.mm.bw.a) newInstance;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                }
                fax fax = (fax) obj;
                AppMethodBeat.o(210566);
                return fax;
            }
        }
        obj = null;
        fax fax2 = (fax) obj;
        AppMethodBeat.o(210566);
        return fax2;
    }

    private final void a(String str, fax fax) {
        AppMethodBeat.i(210567);
        String str2 = str;
        if (str2 == null || n.aL(str2)) {
            AppMethodBeat.o(210567);
            return;
        }
        try {
            ((MultiProcessMMKV) this.pvV.getSlot()).encode(baZ(str), fax.toByteArray());
            AppMethodBeat.o(210567);
        } catch (Exception e2) {
            Log.e("MicroMsg.MusicAlbumHelper", "saveWebViewAudioInfo ex " + e2.getMessage());
            AppMethodBeat.o(210567);
        }
    }

    private final faw mk(String str, String str2) {
        Object obj;
        byte[] decodeBytes;
        AppMethodBeat.i(210568);
        String str3 = str;
        if (!(str3 == null || n.aL(str3))) {
            String str4 = str2;
            if (!(str4 == null || n.aL(str4))) {
                MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) this.pvV.getSlot();
                String mi = mi(str, str2);
                if (multiProcessMMKV.containsKey(mi) && (decodeBytes = multiProcessMMKV.decodeBytes(mi)) != null) {
                    if (!(decodeBytes.length == 0)) {
                        try {
                            Object newInstance = faw.class.newInstance();
                            ((com.tencent.mm.bw.a) newInstance).parseFrom(decodeBytes);
                            obj = (com.tencent.mm.bw.a) newInstance;
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", e2, "decode ProtoBuffer", new Object[0]);
                        }
                        faw faw = (faw) obj;
                        AppMethodBeat.o(210568);
                        return faw;
                    }
                }
                obj = null;
                faw faw2 = (faw) obj;
                AppMethodBeat.o(210568);
                return faw2;
            }
        }
        AppMethodBeat.o(210568);
        return null;
    }

    private final void a(String str, String str2, faw faw) {
        AppMethodBeat.i(210569);
        String str3 = str;
        if (!(str3 == null || n.aL(str3))) {
            String str4 = str2;
            if (!(str4 == null || n.aL(str4))) {
                try {
                    ((MultiProcessMMKV) this.pvV.getSlot()).encode(mi(str, str2), faw.toByteArray());
                    AppMethodBeat.o(210569);
                    return;
                } catch (Exception e2) {
                    Log.e("MicroMsg.MusicAlbumHelper", "saveWebViewAlbumInfoInfo ex " + e2.getMessage());
                    AppMethodBeat.o(210569);
                    return;
                }
            }
        }
        AppMethodBeat.o(210569);
    }

    private final synchronized void c(mx mxVar) {
        AppMethodBeat.i(210570);
        f fVar = mxVar.dSE.dSy;
        if (fVar == null) {
            fVar = com.tencent.mm.ay.a.bef();
        }
        if (fVar != null) {
            if (Util.isNullOrNil(this.JwP)) {
                String str = fVar.jeV;
                p.g(str, "musicWrapper.MusicId");
                this.JwP = str;
                this.JwO = String.valueOf(System.currentTimeMillis());
            }
            Log.i("MicroMsg.MusicAlbumHelper", "doWebViewReport musicId = " + this.JwP + ", playId=" + this.JwO + ", playActionSource=" + this.JwN + "，action=" + mxVar.dSE.action);
            switch (mxVar.dSE.action) {
                case 2:
                case 18:
                    a(bbb(this.JwP), 8);
                    AppMethodBeat.o(210570);
                    break;
                case 3:
                    a(bbb(this.JwP), 4);
                    AppMethodBeat.o(210570);
                    break;
                case 4:
                    a(bbb(this.JwP), 9);
                    AppMethodBeat.o(210570);
                    break;
                case 5:
                case 6:
                case 8:
                case 9:
                case 11:
                case 12:
                case 13:
                case 14:
                default:
                    if (!Util.isEqual(this.JwP, fVar.jeV)) {
                        String str2 = fVar.jeV;
                        p.g(str2, "musicWrapper.MusicId");
                        this.JwP = str2;
                        this.JwO = String.valueOf(System.currentTimeMillis());
                        Log.i("MicroMsg.MusicAlbumHelper", "doWebViewReport new music musicId = " + this.JwP + ", playId=" + this.JwO);
                    }
                    switch (mxVar.dSE.action) {
                        case 0:
                        case 1:
                            a(bbb(this.JwP), 3);
                            AppMethodBeat.o(210570);
                            break;
                        case 8:
                            a(bbb(this.JwP), 6);
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 10:
                        default:
                            AppMethodBeat.o(210570);
                            break;
                        case 9:
                            a(bbb(this.JwP), 1);
                            AppMethodBeat.o(210570);
                            break;
                        case 11:
                            a(bbb(this.JwP), 2);
                            AppMethodBeat.o(210570);
                            break;
                        case 12:
                            a(bbb(this.JwP), 5);
                            AppMethodBeat.o(210570);
                            break;
                    }
                case 7:
                    a(bbb(this.JwP), 7);
                    AppMethodBeat.o(210570);
                    break;
                case 10:
                    a(bbb(this.JwP), 100);
                    AppMethodBeat.o(210570);
                    break;
                case 15:
                    this.JwN = 2;
                    AppMethodBeat.o(210570);
                    break;
                case 16:
                case 17:
                    this.JwN = 3;
                    AppMethodBeat.o(210570);
                    break;
            }
        } else {
            AppMethodBeat.o(210570);
        }
    }

    private final void a(fax fax, int i2) {
        AppMethodBeat.i(210571);
        if (fax == null) {
            AppMethodBeat.o(210571);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        h.INSTANCE.a(19839, fax.NhM, Long.valueOf(fax.msgId), Integer.valueOf(fax.idx), fax.Nxj, fax.dtX, Integer.valueOf(fax.dLt), Long.valueOf(fax.prZ), fax.Nxk, Integer.valueOf(fax.scene), Integer.valueOf(fax.pHw), this.JwO, Integer.valueOf(fax.duration), Integer.valueOf(fax.Dzt), Long.valueOf(currentTimeMillis), Integer.valueOf(i2), Integer.valueOf(this.JwN), z.bfG(fax.Nxl), Integer.valueOf(fax.Nxo), bbc(fax.Nxm), bbc(fax.Nxn));
        AppMethodBeat.o(210571);
    }

    private static String bbc(String str) {
        boolean z;
        AppMethodBeat.i(210572);
        String str2 = str;
        if (str2 == null || n.aL(str2)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(210572);
            return "";
        }
        String j2 = n.j(str, ",", "", false);
        AppMethodBeat.o(210572);
        return j2;
    }

    public final String bbd(String str) {
        AppMethodBeat.i(210573);
        fax bbb = bbb(str);
        if (bbb != null) {
            String str2 = bbb.Nxj;
            AppMethodBeat.o(210573);
            return str2;
        }
        AppMethodBeat.o(210573);
        return null;
    }

    public final String bbe(String str) {
        AppMethodBeat.i(210574);
        fax bbb = bbb(str);
        if (bbb != null) {
            String str2 = bbb.dtX;
            AppMethodBeat.o(210574);
            return str2;
        }
        AppMethodBeat.o(210574);
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper$Companion;", "", "()V", "TAG", "", "albumDelimiter", "currentAlbumIdKey", "<set-?>", "Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "instance", "getInstance", "()Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;", "setInstance", "(Lcom/tencent/mm/plugin/webview/ui/tools/media/WebViewMusicAlbumHelper;)V", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static i ghX() {
            IListener<mx> iListener;
            AppMethodBeat.i(182656);
            if (i.JwQ == null) {
                synchronized (i.class) {
                    try {
                        if (i.JwQ == null) {
                            Context context = MMApplicationContext.getContext();
                            p.g(context, "MMApplicationContext.getContext()");
                            i.JwQ = new i(context, (byte) 0);
                            i iVar = i.JwQ;
                            if (!(iVar == null || (iListener = iVar.lEl) == null)) {
                                iListener.alive();
                            }
                        }
                        x xVar = x.SXb;
                    } catch (Throwable th) {
                        AppMethodBeat.o(182656);
                        throw th;
                    }
                }
            }
            i iVar2 = i.JwQ;
            AppMethodBeat.o(182656);
            return iVar2;
        }
    }

    public static final /* synthetic */ void b(i iVar) {
        AppMethodBeat.i(182674);
        Log.d("MicroMsg.MusicAlbumHelper", "start timer");
        if (!iVar.mEP.stopped()) {
            iVar.stopTimer();
        }
        iVar.mEP.startTimer(3000);
        AppMethodBeat.o(182674);
    }
}
