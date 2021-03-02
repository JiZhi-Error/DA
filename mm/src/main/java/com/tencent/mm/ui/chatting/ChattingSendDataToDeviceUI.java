package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.ev;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXLocationObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class ChattingSendDataToDeviceUI extends MMActivity {
    boolean PdX = false;
    private boolean Pdm;
    private String PiA = "";
    private RelativeLayout PiB;
    private RelativeLayout PiC;
    private TextView PiD;
    private Boolean PiE = Boolean.FALSE;
    private b PiF;
    private List<c> PiG = new ArrayList();
    private List<g> PiH = new ArrayList();
    private long PiI = 0;
    private boolean PiJ = true;
    boolean PiK = false;
    boolean PiL = true;
    int PiM = 2;
    int PiN = -1;
    private HashMap<String, View> PiO = new HashMap<>();
    private HashMap<String, c> PiP = new HashMap<>();
    private Map<Integer, View> PiQ = new HashMap();
    private Map<String, Integer> PiR = new HashMap();
    private IListener PiS = new IListener<ev>() {
        /* class com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.AnonymousClass2 */

        {
            AppMethodBeat.i(161521);
            this.__eventId = ev.class.getName().hashCode();
            AppMethodBeat.o(161521);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ev evVar) {
            AppMethodBeat.i(34635);
            boolean l = ChattingSendDataToDeviceUI.this.gNW().l(evVar);
            AppMethodBeat.o(34635);
            return l;
        }
    };
    private IListener PiT = new IListener<ez>() {
        /* class com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.AnonymousClass3 */

        {
            AppMethodBeat.i(161522);
            this.__eventId = ez.class.getName().hashCode();
            AppMethodBeat.o(161522);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ez ezVar) {
            AppMethodBeat.i(34636);
            boolean l = ChattingSendDataToDeviceUI.this.gNW().l(ezVar);
            AppMethodBeat.o(34636);
            return l;
        }
    };
    private HorizontalListView Piv;
    private HorizontalListView Piw;
    private b Pix;
    private a Piy;
    private int Piz;
    boolean dIo = false;
    private k.b dXm;
    String filePath = null;
    String gCr = null;
    private long gof;
    WXMediaMessage pez = null;
    private ca qnv;
    private String rzs;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ChattingSendDataToDeviceUI() {
        AppMethodBeat.i(34660);
        AppMethodBeat.o(34660);
    }

    static /* synthetic */ void a(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, int i2) {
        AppMethodBeat.i(34678);
        chattingSendDataToDeviceUI.GD(i2);
        AppMethodBeat.o(34678);
    }

    static /* synthetic */ boolean b(c cVar, long j2) {
        AppMethodBeat.i(34683);
        boolean a2 = a(cVar, j2);
        AppMethodBeat.o(34683);
        return a2;
    }

    static /* synthetic */ boolean b(c cVar, String str) {
        AppMethodBeat.i(34682);
        boolean a2 = a(cVar, str);
        AppMethodBeat.o(34682);
        return a2;
    }

    static /* synthetic */ void j(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI) {
        AppMethodBeat.i(34680);
        chattingSendDataToDeviceUI.gNU();
        AppMethodBeat.o(34680);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0359, code lost:
        if (r6 == 62) goto L_0x02fb;
     */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
        // Method dump skipped, instructions count: 869
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.onCreate(android.os.Bundle):void");
    }

    private void GD(int i2) {
        AppMethodBeat.i(34662);
        if (this.dIo) {
            h.INSTANCE.a(13197, Integer.valueOf(i2), Integer.valueOf(this.PiN), "", 2, Integer.valueOf(this.PiM));
            AppMethodBeat.o(34662);
            return;
        }
        h.INSTANCE.a(13197, Integer.valueOf(i2), Integer.valueOf(this.PiN), Nr(this.gof), 1, Integer.valueOf(this.PiM));
        AppMethodBeat.o(34662);
    }

    private static String Nr(long j2) {
        k.b HD;
        AppMethodBeat.i(34663);
        String str = "";
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(j2);
        if (Hb.field_msgId == 0) {
            AppMethodBeat.o(34663);
            return "";
        }
        String str2 = Hb.field_content;
        if (Hb.getType() == 49 && (HD = k.b.HD(str2)) != null && HD.type == 6) {
            str = HD.iwJ;
        }
        AppMethodBeat.o(34663);
        return str;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.u1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(34664);
        super.onConfigurationChanged(configuration);
        ed edVar = new ed();
        if (this.dIo) {
            String string = getIntent().getExtras().getString("sns_send_data_ui_image_path");
            String string2 = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
            edVar.dHn.dHp = this.rzs;
            edVar.dHn.dHq = string;
            edVar.dHn.dHr = string2;
        } else {
            edVar.dHn.msgId = this.gof;
        }
        EventCenter.instance.publish(edVar);
        if (edVar.dHo.dGX && this.PiG.size() > 0) {
            Log.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", Integer.valueOf(this.PiG.size()));
            this.Piy.ad(this.PiG);
            if (this.Piy.getCount() > 0) {
                this.PiD.setText(R.string.axk);
                this.PiJ = false;
            }
            this.Piy.notifyDataSetChanged();
        }
        AppMethodBeat.o(34664);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void gNU() {
        AppMethodBeat.i(34665);
        if (this.Pix == null || this.PiI == 0) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.Pix == null);
            objArr[1] = Long.valueOf(this.PiI);
            Log.e("MicroMsg.ChattingSendDataToDeviceUI", "mAppInfoAdapter is null %s, contentFlag %s", objArr);
            if (this.PiC != null) {
                this.PiC.setVisibility(8);
            }
            AppMethodBeat.o(34665);
            return;
        }
        this.PiH = com.tencent.mm.pluginsdk.model.app.h.b((Context) this, this.PiI, false);
        if (!com.tencent.mm.pluginsdk.model.app.h.s(this, this.PiI) && this.PiC != null) {
            this.PiC.setVisibility(8);
        }
        ArrayList arrayList = new ArrayList();
        if (this.PiH != null && this.PiH.size() > 0) {
            final List<String> Mq = ao.gng().Mq(this.PiI);
            if (Mq != null && Mq.size() > 0) {
                Collections.sort(this.PiH, new Comparator<g>() {
                    /* class com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.AnonymousClass6 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(g gVar, g gVar2) {
                        AppMethodBeat.i(34640);
                        int indexOf = Mq.indexOf(gVar2.field_appId) - Mq.indexOf(gVar.field_appId);
                        AppMethodBeat.o(34640);
                        return indexOf;
                    }
                });
            }
            for (g gVar : this.PiH) {
                z zVar = new z();
                zVar.appId = gVar.field_appId;
                zVar.gCv = gVar.field_appName;
                zVar.iconUrl = gVar.field_appIconUrl;
                arrayList.add(zVar);
            }
        }
        if (this.pez == null) {
            WXMusicObject wXMusicObject = null;
            WXFileObject wXFileObject = null;
            wXMusicObject = null;
            wXMusicObject = null;
            switch (this.qnv.getType()) {
                case 1:
                    wXMusicObject = new WXTextObject(this.qnv.field_content);
                    this.pez = new WXMediaMessage(wXMusicObject);
                    this.pez.sdkVer = Build.SDK_INT;
                    if (!(this.gCr == null || this.filePath == null || wXMusicObject == null || !(wXMusicObject instanceof WXFileObject))) {
                        this.PdX = true;
                        break;
                    }
                case 3:
                    WXImageObject wXImageObject = new WXImageObject();
                    com.tencent.mm.av.g U = q.bcR().U(this.qnv);
                    if (U != null) {
                        wXImageObject.imagePath = q.bcR().Oz(U.iXm);
                        if (Util.isNullOrNil(wXImageObject.imagePath)) {
                            wXImageObject.imagePath = q.bcR().Oz(U.iXo);
                        }
                        if (!Util.isNullOrNil(wXImageObject.imagePath)) {
                            this.filePath = wXImageObject.imagePath;
                            int lastIndexOf = wXImageObject.imagePath.lastIndexOf(".");
                            if (lastIndexOf >= 0 && lastIndexOf < wXImageObject.imagePath.length() - 1) {
                                this.gCr = wXImageObject.imagePath.substring(lastIndexOf + 1);
                            }
                        }
                    }
                    Log.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", wXImageObject.imagePath);
                    wXMusicObject = wXImageObject;
                    this.pez = new WXMediaMessage(wXMusicObject);
                    this.pez.sdkVer = Build.SDK_INT;
                    this.PdX = true;
                    break;
                case 43:
                    WXVideoObject wXVideoObject = new WXVideoObject();
                    o.bhj();
                    String Qw = t.Qw(this.qnv.field_imgPath);
                    wXMusicObject = wXVideoObject;
                    if (Qw != null) {
                        wXVideoObject.videoUrl = Qw;
                        this.filePath = Qw;
                        int lastIndexOf2 = Qw.lastIndexOf(".");
                        wXMusicObject = wXVideoObject;
                        if (lastIndexOf2 >= 0) {
                            wXMusicObject = wXVideoObject;
                            if (lastIndexOf2 < Qw.length() - 1) {
                                this.gCr = Qw.substring(lastIndexOf2 + 1);
                                wXMusicObject = wXVideoObject;
                            }
                        }
                    }
                    this.pez = new WXMediaMessage(wXMusicObject);
                    this.pez.sdkVer = Build.SDK_INT;
                    this.PdX = true;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    bg.aVF();
                    ca.b aEL = com.tencent.mm.model.c.aSQ().aEL(this.qnv.field_content);
                    wXMusicObject = new WXLocationObject(aEL.yFu, aEL.yFv);
                    this.pez = new WXMediaMessage(wXMusicObject);
                    this.pez.sdkVer = Build.SDK_INT;
                    this.PdX = true;
                    break;
                case 49:
                    if (this.dXm != null) {
                        if (this.dXm.type == 3) {
                            WXMusicObject wXMusicObject2 = new WXMusicObject();
                            wXMusicObject2.musicUrl = this.dXm.url;
                            wXMusicObject2.musicDataUrl = this.dXm.ixd;
                            wXMusicObject2.musicLowBandUrl = this.dXm.iwH;
                            wXMusicObject2.musicLowBandDataUrl = this.dXm.ixe;
                            com.tencent.mm.pluginsdk.ui.tools.b bVar = (com.tencent.mm.pluginsdk.ui.tools.b) this.dXm.as(com.tencent.mm.pluginsdk.ui.tools.b.class);
                            if (bVar != null) {
                                wXMusicObject2.songAlbumUrl = bVar.songAlbumUrl;
                                wXMusicObject2.songLyric = bVar.songLyric;
                            }
                            wXMusicObject = wXMusicObject2;
                        } else if (this.dXm.type == 4) {
                            WXVideoObject wXVideoObject2 = new WXVideoObject();
                            wXVideoObject2.videoUrl = this.dXm.url;
                            wXVideoObject2.videoLowBandUrl = this.dXm.ixe;
                            wXMusicObject = wXVideoObject2;
                        } else if (this.dXm.type == 5) {
                            wXMusicObject = new WXWebpageObject(this.dXm.url);
                        } else if (this.dXm.type == 6) {
                            com.tencent.mm.pluginsdk.model.app.c bdx = ao.cgO().bdx(this.dXm.dCK);
                            if (bdx != null) {
                                Log.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage fileFullPath %s", bdx.field_fileFullPath);
                                WXFileObject wXFileObject2 = new WXFileObject(bdx.field_fileFullPath);
                                this.filePath = bdx.field_fileFullPath;
                                this.gCr = this.dXm.iwJ;
                                wXFileObject = wXFileObject2;
                            } else {
                                Log.e("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage attInfo is null");
                            }
                            wXMusicObject = wXFileObject;
                            if (r.bdN(this.filePath) != null) {
                                com.tencent.mm.ui.base.h.cD(this, getString(R.string.b2e));
                                finish();
                                break;
                            }
                        } else if (this.dXm.type == 2) {
                            WXImageObject wXImageObject2 = new WXImageObject();
                            com.tencent.mm.av.g U2 = q.bcR().U(this.qnv);
                            if (U2 != null) {
                                wXImageObject2.imagePath = q.bcR().Oz(U2.iXm);
                                if (Util.isNullOrNil(wXImageObject2.imagePath)) {
                                    wXImageObject2.imagePath = q.bcR().Oz(U2.iXo);
                                }
                            }
                            this.filePath = wXImageObject2.imagePath;
                            this.gCr = this.dXm.iwJ;
                            Log.i("MicroMsg.ChattingSendDataToDeviceUI", "getWXMediaMessage imagePath %s", wXImageObject2.imagePath);
                            wXMusicObject = wXImageObject2;
                        }
                    }
                    this.pez = new WXMediaMessage(wXMusicObject);
                    this.pez.sdkVer = Build.SDK_INT;
                    this.PdX = true;
                    break;
                default:
                    this.pez = new WXMediaMessage(wXMusicObject);
                    this.pez.sdkVer = Build.SDK_INT;
                    this.PdX = true;
                    break;
            }
        }
        this.Pix.PdX = this.PdX;
        this.Pix.ad(arrayList);
        this.Pix.notifyDataSetChanged();
        AppMethodBeat.o(34665);
    }

    private void gNV() {
        AppMethodBeat.i(34666);
        ed edVar = new ed();
        if (this.dIo) {
            String string = getIntent().getExtras().getString("sns_send_data_ui_image_path");
            String string2 = getIntent().getExtras().getString("sns_send_data_ui_image_media_id");
            edVar.dHn.dHp = this.rzs;
            edVar.dHn.dHq = string;
            edVar.dHn.dHr = string2;
        } else {
            edVar.dHn.msgId = this.gof;
        }
        EventCenter.instance.publish(edVar);
        if (edVar.dHo.dGX) {
            List list = edVar.dHo.dHs;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = new c();
                cVar.dGP = (String) ((Map) list.get(i2)).get("deviceType");
                cVar.deviceID = (String) ((Map) list.get(i2)).get("deviceID");
                cVar.gCv = (String) ((Map) list.get(i2)).get("displayName");
                cVar.iconUrl = (String) ((Map) list.get(i2)).get("iconUrl");
                cVar.dIn = (String) ((Map) list.get(i2)).get("ability");
                cVar.Pjg = (String) ((Map) list.get(i2)).get("abilityInf");
                if (this.dIo && a(cVar, this.rzs)) {
                    this.PiG.add(cVar);
                } else if (!this.dIo && a(cVar, this.gof)) {
                    this.PiG.add(cVar);
                }
            }
            if (this.PiG.size() > 0) {
                Log.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
                this.Piy.ad(this.PiG);
                if (this.Piy.getCount() > 0) {
                    this.PiD.setText(R.string.axk);
                    this.PiJ = false;
                }
                this.Piy.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(34666);
    }

    private static boolean a(String str, c cVar) {
        boolean z = false;
        AppMethodBeat.i(34667);
        String str2 = cVar.dIn;
        String str3 = cVar.Pjg;
        String host = Uri.parse(str).getHost();
        if (str3 != null && str3.length() > 0 && str2 != null && str2.contains("wxmsg_url")) {
            try {
                JSONArray jSONArray = new JSONObject(str3).getJSONArray("wxmsg_url");
                int length = jSONArray.length();
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (jSONArray.getString(i2).equals(host)) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.ChattingSendDataToDeviceUI", e2, str3, new Object[0]);
            }
        }
        AppMethodBeat.o(34667);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0064, code lost:
        if (r4.contains("wxmsg_music") == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        if (r4.contains("wxmsg_video") != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004f, code lost:
        if (r4.contains("wxmsg_image") != false) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 130
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a(com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$c, java.lang.String):boolean");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(34669);
        if (this.PiO.size() > 0) {
            d.a aVar = new d.a(this);
            aVar.aoS(R.string.b2h);
            aVar.aoV(R.string.b2j).c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(34641);
                    for (String str : ChattingSendDataToDeviceUI.this.PiO.keySet()) {
                        ds dsVar = new ds();
                        dsVar.dGK.dGL = str;
                        EventCenter.instance.publish(dsVar);
                    }
                    ChattingSendDataToDeviceUI.this.finish();
                    AppMethodBeat.o(34641);
                }
            });
            aVar.aoW(R.string.b2i).d(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(34642);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(34642);
                }
            });
            aVar.hbn().show();
            AppMethodBeat.o(34669);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(34669);
    }

    public final void bmx(final String str) {
        final int i2;
        AppMethodBeat.i(34670);
        try {
            final as asVar = (as) this.PiQ.get(Integer.valueOf(this.PiR.get(str).intValue())).getTag();
            Log.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", Integer.valueOf(asVar.Plh.getProgress()), str);
            final c cVar = this.PiP.get(str);
            runOnUiThread(new Runnable() {
                /* class com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(34643);
                    asVar.Plh.setVisibility(0);
                    asVar.Pjb.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.a6y));
                    asVar.Pjb.setText(ChattingSendDataToDeviceUI.this.getText(R.string.b2p));
                    cVar.dIr = "send_data_sending";
                    AppMethodBeat.o(34643);
                }
            });
            final int abs = Math.abs(asVar.Plh.getProgress());
            cVar.progress = abs;
            if (abs >= 100) {
                i2 = 0;
            } else {
                i2 = 500 / (100 - abs);
            }
            Log.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", Integer.valueOf(i2));
            com.tencent.f.h.RTc.ba(new com.tencent.f.i.h() {
                /* class com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.AnonymousClass10 */

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    return "ThreadPool";
                }

                public final void run() {
                    AppMethodBeat.i(34645);
                    int i2 = abs + 1;
                    while (true) {
                        if (i2 >= 100) {
                            try {
                                ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.AnonymousClass10.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(34644);
                                        asVar.Plh.amr(0);
                                        ChattingSendDataToDeviceUI.this.PiO.remove(str);
                                        asVar.Plh.setVisibility(4);
                                        asVar.Pjb.setText(ChattingSendDataToDeviceUI.this.getText(R.string.b2n));
                                        asVar.Pjb.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.a6y));
                                        cVar.dIr = "send_data_sucess";
                                        cVar.progress = 0;
                                        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 4);
                                        AppMethodBeat.o(34644);
                                    }
                                });
                                break;
                            } catch (Exception e2) {
                                Log.d("MicroMsg.ChattingSendDataToDeviceUI", "setProgress on progress view exception %s", e2);
                            }
                        } else {
                            asVar.Plh.amr(i2);
                            i2++;
                            Thread.sleep((long) i2);
                        }
                    }
                    AppMethodBeat.o(34645);
                }
            });
            this.PiP.put(cVar.deviceID, cVar);
            AppMethodBeat.o(34670);
        } catch (Exception e2) {
            Log.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress to success exception %s", e2);
            AppMethodBeat.o(34670);
        }
    }

    private static boolean a(c cVar, long j2) {
        boolean z = false;
        AppMethodBeat.i(34671);
        if (j2 == -1) {
            AppMethodBeat.o(34671);
        } else {
            String str = cVar.dIn;
            bg.aVF();
            ca Hb = com.tencent.mm.model.c.aSQ().Hb(j2);
            if (Hb.field_msgId == 0 || str == null) {
                AppMethodBeat.o(34671);
            } else {
                int type = Hb.getType();
                String str2 = Hb.field_content;
                if (Hb.dOQ()) {
                    k.b HD = k.b.HD(str2);
                    if (HD == null) {
                        Log.e("MicroMsg.ChattingSendDataToDeviceUI", "get content is null");
                        AppMethodBeat.o(34671);
                    } else if (HD.type == 3 || HD.type == 76) {
                        if (str.contains("wxmsg_music")) {
                            z = true;
                        }
                    } else if (HD.type != 4) {
                        if (HD.type == 6) {
                            if (str.contains("wxmsg_file")) {
                                z = true;
                            }
                        } else if (HD.type == 5) {
                            z = a(HD.url, cVar);
                        } else if (HD.type == 2 && str.contains("wxmsg_image")) {
                            z = true;
                        }
                    }
                } else if (type == 3) {
                    if (str.contains("wxmsg_image")) {
                        z = true;
                    }
                } else if (type == 48) {
                    if (str.contains("wxmsg_poi")) {
                        z = true;
                    }
                } else if (type == 62 && str.contains("wxmsg_video")) {
                    z = true;
                }
                AppMethodBeat.o(34671);
            }
        }
        return z;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(34672);
        super.onResume();
        gNU();
        if (this.PiE.booleanValue()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Piv.getLayoutParams();
            int i2 = layoutParams.height;
            float ez = com.tencent.mm.cb.a.ez(this);
            if (ez == com.tencent.mm.cb.a.iY(this)) {
                layoutParams.height = i2 + getResources().getDimensionPixelSize(R.dimen.i2);
            } else if (ez == com.tencent.mm.cb.a.ja(this) || ez == com.tencent.mm.cb.a.iZ(this) || ez == com.tencent.mm.cb.a.jb(this)) {
                layoutParams.height = i2 + getResources().getDimensionPixelSize(R.dimen.ir);
            }
            this.Piv.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(34672);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(34673);
        super.onPause();
        AppMethodBeat.o(34673);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(34674);
        super.onActivityResult(i2, i3, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a((Activity) this, i2, i3, intent, true, (int) R.string.bny, (int) R.string.bnz, 1);
        AppMethodBeat.o(34674);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(34675);
        super.onDestroy();
        Log.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
        this.PiL = false;
        if (this.PiE.booleanValue()) {
            if (!this.PiK) {
                GD(2);
            }
            EventCenter.instance.removeListener(this.PiS);
            EventCenter.instance.removeListener(this.PiT);
            fl flVar = new fl();
            EventCenter.instance.publish(flVar);
            if (flVar.dIL.isSuccess) {
                Log.i("MicroMsg.ChattingSendDataToDeviceUI", "Stop scan Network success!");
            }
        }
        AppMethodBeat.o(34675);
    }

    public class b {
        public b() {
        }

        public final boolean l(IEvent iEvent) {
            AppMethodBeat.i(34657);
            if (iEvent instanceof ev) {
                boolean n = n(iEvent);
                AppMethodBeat.o(34657);
                return n;
            } else if (iEvent instanceof ez) {
                boolean m = m(iEvent);
                AppMethodBeat.o(34657);
                return m;
            } else {
                AppMethodBeat.o(34657);
                return true;
            }
        }

        private boolean m(IEvent iEvent) {
            AppMethodBeat.i(34658);
            ez ezVar = (ez) iEvent;
            String str = ezVar.dIp.dIr;
            String str2 = ezVar.dIp.dGL;
            if (str.equals("send_data_sending")) {
                ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_sending", str2, ezVar.dIp.progress);
            } else if (str.equals("send_data_failed")) {
                ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, "send_data_failed", str2, 0);
            } else if (str.equals("send_data_sucess")) {
                ChattingSendDataToDeviceUI.this.bmx(str2);
            }
            AppMethodBeat.o(34658);
            return true;
        }

        private boolean n(IEvent iEvent) {
            AppMethodBeat.i(34659);
            List list = ((ev) iEvent).dIf.dHs;
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                c cVar = new c();
                cVar.dGP = (String) ((Map) list.get(i2)).get("deviceType");
                cVar.deviceID = (String) ((Map) list.get(i2)).get("deviceID");
                cVar.gCv = (String) ((Map) list.get(i2)).get("displayName");
                cVar.iconUrl = (String) ((Map) list.get(i2)).get("iconUrl");
                cVar.dIn = (String) ((Map) list.get(i2)).get("ability");
                cVar.Pjg = (String) ((Map) list.get(i2)).get("abilityInf");
                if ((ChattingSendDataToDeviceUI.this.dIo && ChattingSendDataToDeviceUI.b(cVar, ChattingSendDataToDeviceUI.this.rzs)) || (!ChattingSendDataToDeviceUI.this.dIo && ChattingSendDataToDeviceUI.b(cVar, ChattingSendDataToDeviceUI.this.gof))) {
                    if (ChattingSendDataToDeviceUI.this.PiP.containsKey(cVar.deviceID) && ((c) ChattingSendDataToDeviceUI.this.PiP.get(cVar.deviceID)).dIr != null) {
                        cVar.dIr = ((c) ChattingSendDataToDeviceUI.this.PiP.get(cVar.deviceID)).dIr;
                        cVar.progress = ((c) ChattingSendDataToDeviceUI.this.PiP.get(cVar.deviceID)).progress;
                    }
                    arrayList.add(cVar);
                }
            }
            if (ChattingSendDataToDeviceUI.this.PiG.size() != arrayList.size()) {
                ChattingSendDataToDeviceUI.this.PiG = arrayList;
                ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(34656);
                        ChattingSendDataToDeviceUI.this.Piy.ad(ChattingSendDataToDeviceUI.this.PiG);
                        if (ChattingSendDataToDeviceUI.this.Piy.getCount() > 0) {
                            ChattingSendDataToDeviceUI.this.PiD.setText(R.string.axk);
                            ChattingSendDataToDeviceUI.this.PiJ = false;
                        }
                        ChattingSendDataToDeviceUI.this.Piy.notifyDataSetChanged();
                        AppMethodBeat.o(34656);
                    }
                });
            }
            AppMethodBeat.o(34659);
            return true;
        }
    }

    public final b gNW() {
        AppMethodBeat.i(34676);
        if (this.PiF == null) {
            this.PiF = new b();
        }
        b bVar = this.PiF;
        AppMethodBeat.o(34676);
        return bVar;
    }

    public class c {
        String Pjg;
        String dGP;
        String dIn;
        String dIr;
        String deviceID;
        String gCv;
        String iconUrl;
        int progress;

        public c() {
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private List<Map<String, c>> PdW = new ArrayList();
        private Map<String, c> Pjc;
        private Context context;
        private com.tencent.mm.av.a.a.c rFu;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(34655);
            c aml = aml(i2);
            AppMethodBeat.o(34655);
            return aml;
        }

        public a(Context context2) {
            AppMethodBeat.i(34650);
            this.context = context2;
            c.a aVar = new c.a();
            aVar.jbq = R.drawable.biz;
            this.rFu = aVar.bdv();
            AppMethodBeat.o(34650);
        }

        public final void ad(List<c> list) {
            AppMethodBeat.i(34651);
            this.PdW.clear();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.Pjc = new HashMap();
                this.Pjc.put("hard_device_info", list.get(i2));
                this.PdW.add(this.Pjc);
            }
            AppMethodBeat.o(34651);
        }

        public final int getCount() {
            AppMethodBeat.i(34652);
            int size = this.PdW.size();
            AppMethodBeat.o(34652);
            return size;
        }

        public final c aml(int i2) {
            AppMethodBeat.i(34653);
            c cVar = this.PdW.get(i2).get("hard_device_info");
            AppMethodBeat.o(34653);
            return cVar;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            final as asVar;
            View view2;
            final int i3;
            AppMethodBeat.i(34654);
            c aml = aml(i2);
            Log.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", Integer.valueOf(i2), Integer.valueOf(getCount()));
            if (ChattingSendDataToDeviceUI.this.PiQ.get(Integer.valueOf(i2)) == null) {
                asVar = new as();
                View inflate = View.inflate(viewGroup.getContext(), R.layout.bq8, null);
                asVar.rII = inflate.findViewById(R.id.be3);
                asVar.kgE = (TextView) inflate.findViewById(R.id.ft9);
                asVar.nnL = (ImageView) inflate.findViewById(R.id.dtb);
                asVar.Pjb = (TextView) inflate.findViewById(R.id.hjx);
                asVar.Plh = (SendDataToDeviceProgressBar) inflate.findViewById(R.id.hjw);
                asVar.Plh.setVisibility(4);
                ChattingSendDataToDeviceUI.this.PiQ.put(Integer.valueOf(i2), inflate);
                inflate.setTag(asVar);
                view2 = inflate;
            } else {
                View view3 = (View) ChattingSendDataToDeviceUI.this.PiQ.get(Integer.valueOf(i2));
                asVar = (as) view3.getTag();
                view2 = view3;
            }
            ChattingSendDataToDeviceUI.this.PiR.put(aml.deviceID, Integer.valueOf(i2));
            String str = aml.gCv;
            int i4 = 8;
            int i5 = 0;
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            float ez = com.tencent.mm.cb.a.ez(this.context);
            if (ez == com.tencent.mm.cb.a.iY(this.context) || ez == com.tencent.mm.cb.a.iZ(this.context)) {
                i4 = 6;
            } else if (ez == com.tencent.mm.cb.a.ja(this.context) || ez == com.tencent.mm.cb.a.jb(this.context)) {
                i4 = 5;
            }
            for (int i6 = 0; i6 < str.length(); i6++) {
                int codePointAt = Character.codePointAt(str, i6);
                String substring = str.substring(i6, i6 + 1);
                if (codePointAt < 0 || codePointAt > 255) {
                    i5 += 2;
                } else {
                    i5++;
                }
                if (i5 <= i4) {
                    stringBuffer = stringBuffer.append(substring);
                } else {
                    stringBuffer2 = stringBuffer2.append(substring);
                }
            }
            asVar.kgE.setText(stringBuffer.toString());
            if (i5 >= i4) {
                asVar.Pjb.setText(stringBuffer2);
            }
            c cVar = null;
            if (ChattingSendDataToDeviceUI.this.PiP.containsKey(aml(i2).deviceID)) {
                cVar = (c) ChattingSendDataToDeviceUI.this.PiP.get(aml(i2).deviceID);
            }
            if (!(cVar == null || cVar.dIr == null)) {
                Log.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", Integer.valueOf(i2), cVar.dIr);
                if (cVar.dIr.equals("send_data_sending")) {
                    asVar.Pjb.setText(this.context.getString(R.string.b2p));
                    asVar.Pjb.setTextColor(this.context.getResources().getColor(R.color.a6y));
                    asVar.Plh.amr(aml.progress);
                    asVar.Plh.setVisibility(0);
                    final c cVar2 = (c) ChattingSendDataToDeviceUI.this.PiP.get(aml.deviceID);
                    final int i7 = cVar2.progress;
                    if (i7 >= 100) {
                        i3 = 0;
                    } else {
                        i3 = 500 / (100 - i7);
                    }
                    com.tencent.f.h.RTc.ba(new com.tencent.f.i.h() {
                        /* class com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a.AnonymousClass1 */

                        @Override // com.tencent.f.i.h, com.tencent.f.i.g
                        public final String getKey() {
                            return "SendDataState_handler";
                        }

                        public final void run() {
                            AppMethodBeat.i(34649);
                            int i2 = i7 + 1;
                            while (ChattingSendDataToDeviceUI.this.PiL) {
                                if (i2 >= 100) {
                                    try {
                                        if (cVar2.dIr.equals("send_data_sucess")) {
                                            ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable() {
                                                /* class com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a.AnonymousClass1.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(34647);
                                                    asVar.Plh.amr(0);
                                                    asVar.Plh.setVisibility(4);
                                                    asVar.Pjb.setText(ChattingSendDataToDeviceUI.this.getText(R.string.b2n));
                                                    asVar.Pjb.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.a6y));
                                                    cVar2.dIr = "send_data_sucess";
                                                    cVar2.progress = 0;
                                                    ChattingSendDataToDeviceUI.this.PiP.put(cVar2.deviceID, cVar2);
                                                    Log.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_SUCCESS!", cVar2.deviceID);
                                                    AppMethodBeat.o(34647);
                                                }
                                            });
                                            AppMethodBeat.o(34649);
                                            return;
                                        } else if (cVar2.dIr.equals("send_data_failed")) {
                                            ChattingSendDataToDeviceUI.this.runOnUiThread(new Runnable() {
                                                /* class com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a.AnonymousClass1.AnonymousClass2 */

                                                public final void run() {
                                                    AppMethodBeat.i(34648);
                                                    asVar.Plh.amr(0);
                                                    asVar.Plh.setVisibility(4);
                                                    asVar.Pjb.setText(ChattingSendDataToDeviceUI.this.getText(R.string.b2k));
                                                    asVar.Pjb.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.a71));
                                                    cVar2.dIr = "send_data_failed";
                                                    cVar2.progress = 0;
                                                    ChattingSendDataToDeviceUI.this.PiP.put(cVar2.deviceID, cVar2);
                                                    Log.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_FAILED!", cVar2.deviceID);
                                                    AppMethodBeat.o(34648);
                                                }
                                            });
                                            AppMethodBeat.o(34649);
                                            return;
                                        }
                                    } catch (Exception e2) {
                                        Log.d("MicroMsg.ChattingSendDataToDeviceUI", "setSendingProgress exception %s", e2);
                                    }
                                } else {
                                    asVar.Plh.amr(i2);
                                    cVar2.progress = i2;
                                    i2++;
                                    Thread.sleep((long) i3);
                                }
                            }
                            AppMethodBeat.o(34649);
                        }
                    });
                } else if (cVar.dIr.equals("send_data_sucess")) {
                    asVar.Pjb.setText(this.context.getString(R.string.b2n));
                    asVar.Pjb.setTextColor(this.context.getResources().getColor(R.color.a6y));
                    asVar.Plh.setVisibility(4);
                } else if (cVar.dIr.equals("send_data_cancel")) {
                    asVar.Pjb.setText(this.context.getString(R.string.b2g));
                    asVar.Pjb.setTextColor(this.context.getResources().getColor(R.color.a6w));
                    asVar.Plh.setVisibility(4);
                } else if (cVar.dIr.equals("send_data_failed")) {
                    asVar.Pjb.setText(this.context.getString(R.string.b2k));
                    asVar.Pjb.setTextColor(this.context.getResources().getColor(R.color.a71));
                    asVar.Plh.setVisibility(4);
                }
            }
            Log.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", Integer.valueOf(i2), aml.gCv);
            q.bcV().a(aml.iconUrl, asVar.nnL, this.rFu);
            asVar.rII.setTag(Integer.valueOf(i2));
            AppMethodBeat.o(34654);
            return view2;
        }
    }

    static /* synthetic */ void a(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, final String str, final String str2, final int i2) {
        AppMethodBeat.i(34677);
        Log.d("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data State:%s progress: %d", str, Integer.valueOf(i2));
        chattingSendDataToDeviceUI.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.AnonymousClass11 */
            TextView Pjb;

            public final void run() {
                AppMethodBeat.i(34646);
                try {
                    c cVar = (c) ChattingSendDataToDeviceUI.this.PiP.get(str2);
                    cVar.dIr = str;
                    if (i2 > cVar.progress) {
                        cVar.progress = i2;
                    }
                    View view = (View) ChattingSendDataToDeviceUI.this.PiQ.get(Integer.valueOf(((Integer) ChattingSendDataToDeviceUI.this.PiR.get(str2)).intValue()));
                    as asVar = (as) view.getTag();
                    if (asVar == null) {
                        Log.w("MicroMsg.ChattingSendDataToDeviceUI", "get view holder is null");
                        AppMethodBeat.o(34646);
                        return;
                    }
                    this.Pjb = asVar.Pjb;
                    this.Pjb.setVisibility(0);
                    if (str.equals("send_data_failed")) {
                        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 5);
                        this.Pjb.setText(ChattingSendDataToDeviceUI.this.getString(R.string.b2k));
                        ChattingSendDataToDeviceUI.this.PiO.remove(str2);
                        this.Pjb.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.a71));
                        ChattingSendDataToDeviceUI.a(false, 0, view);
                    } else if (str.equals("send_data_sending")) {
                        this.Pjb.setText(ChattingSendDataToDeviceUI.this.getString(R.string.b2p));
                        this.Pjb.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.a6y));
                        ChattingSendDataToDeviceUI.a(true, i2, view);
                    } else if (str.equals("send_data_cancel")) {
                        ChattingSendDataToDeviceUI.a(ChattingSendDataToDeviceUI.this, 6);
                        this.Pjb.setText(ChattingSendDataToDeviceUI.this.getString(R.string.b2g));
                        this.Pjb.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.color.a6w));
                        ChattingSendDataToDeviceUI.a(true, 0, view);
                    }
                    ChattingSendDataToDeviceUI.this.PiP.put(cVar.deviceID, cVar);
                    AppMethodBeat.o(34646);
                } catch (Exception e2) {
                    Log.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data: %s", e2.getMessage());
                    AppMethodBeat.o(34646);
                }
            }
        });
        AppMethodBeat.o(34677);
    }

    static /* synthetic */ void bmy(String str) {
        AppMethodBeat.i(34679);
        ez ezVar = new ez();
        ezVar.dIp.dIr = str;
        EventCenter.instance.publish(ezVar);
        AppMethodBeat.o(34679);
    }

    static /* synthetic */ void a(boolean z, int i2, View view) {
        AppMethodBeat.i(34681);
        try {
            as asVar = (as) view.getTag();
            if (asVar == null) {
                AppMethodBeat.o(34681);
                return;
            }
            if (z) {
                asVar.Plh.setVisibility(0);
                if (i2 > asVar.Plh.getProgress()) {
                    asVar.Plh.amr(i2);
                    AppMethodBeat.o(34681);
                    return;
                }
            } else {
                asVar.Plh.setVisibility(4);
                asVar.Plh.amr(0);
            }
            AppMethodBeat.o(34681);
        } catch (Exception e2) {
            Log.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress exception %s", e2);
            AppMethodBeat.o(34681);
        }
    }
}
