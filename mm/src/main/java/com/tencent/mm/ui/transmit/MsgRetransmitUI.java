package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ag.w;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.e;
import com.tencent.mm.av.g;
import com.tencent.mm.av.i;
import com.tencent.mm.av.n;
import com.tencent.mm.g.a.p;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.g.a.up;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.g.a.vo;
import com.tencent.mm.g.b.a.gf;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.i.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.co;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.network.ag;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.pluginsdk.g.c;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.DoNotCheckLeakForActivities;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.ui.chatting.m;
import com.tencent.mm.ui.transmit.e;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.snackbar.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class MsgRetransmitUI extends MMBaseActivity implements i {
    private String PCe;
    private int PMs = -1;
    private boolean PbY = false;
    private int QyA;
    private int QyB;
    private boolean QyC = true;
    private boolean QyD = false;
    private boolean QyE = false;
    private int QyF = 0;
    boolean QyG = false;
    public List<String> Qyf;
    private String Qyg = null;
    private boolean Qyh = true;
    private boolean Qyi = false;
    private d Qyj;
    private int Qyk = 0;
    private int Qyl = 0;
    private n Qym = null;
    private boolean Qyn = false;
    private List<String> Qyo = null;
    private int Qyp = 0;
    private int Qyq = 0;
    private boolean Qyr = false;
    private boolean Qys = false;
    private int Qyt;
    private boolean Qyu;
    private boolean Qyv = true;
    private boolean Qyw = true;
    private int Qyx = 0;
    private int Qyy;
    private String Qyz;
    public String dWG;
    public String fileName;
    private ProgressDialog gtM = null;
    private int iXp = 0;
    private j iYO = null;
    private String iZr;
    private String jsz;
    private float latitude;
    private int length;
    private float longtitude;
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    private String mSessionId;
    public long msgId;
    public int msgType;
    long ppv;
    private long startTime = 0;
    boolean tca;
    private String thumbPath;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MsgRetransmitUI() {
        AppMethodBeat.i(39288);
        AppMethodBeat.o(39288);
    }

    static /* synthetic */ void a(MsgRetransmitUI msgRetransmitUI, Intent intent, String str) {
        AppMethodBeat.i(39313);
        msgRetransmitUI.t(intent, str);
        AppMethodBeat.o(39313);
    }

    static /* synthetic */ void a(MsgRetransmitUI msgRetransmitUI, g gVar, ca caVar, String str, int i2, String str2, String str3) {
        AppMethodBeat.i(39315);
        msgRetransmitUI.b(gVar, caVar, str, i2, str2, str3);
        AppMethodBeat.o(39315);
    }

    static /* synthetic */ void a(MsgRetransmitUI msgRetransmitUI, b bVar, String str) {
        AppMethodBeat.i(39317);
        msgRetransmitUI.a(bVar, str);
        AppMethodBeat.o(39317);
    }

    static /* synthetic */ void a(MsgRetransmitUI msgRetransmitUI, String str, int i2, String str2, String str3, j jVar, long j2) {
        AppMethodBeat.i(39316);
        msgRetransmitUI.a(str, i2, str2, str3, jVar, j2);
        AppMethodBeat.o(39316);
    }

    static /* synthetic */ void a(MsgRetransmitUI msgRetransmitUI, String str, k.b bVar, byte[] bArr, ca caVar) {
        AppMethodBeat.i(39312);
        msgRetransmitUI.a(str, bVar, bArr, caVar);
        AppMethodBeat.o(39312);
    }

    static /* synthetic */ void i(MsgRetransmitUI msgRetransmitUI) {
        AppMethodBeat.i(39318);
        msgRetransmitUI.gYg();
        AppMethodBeat.o(39318);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(39289);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        ao.e(getWindow());
        Log.i("MicroMsg.MsgRetransmitUI", "on activity create");
        this.startTime = Util.nowSecond();
        this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
        this.dWG = getIntent().getStringExtra("Retr_Msg_content");
        this.msgId = getIntent().getLongExtra("Retr_Msg_Id", -1);
        this.fileName = getIntent().getStringExtra("Retr_File_Name");
        this.Qyo = getIntent().getStringArrayListExtra("Retr_File_Path_List");
        this.Qyr = this.Qyo != null && this.Qyo.size() > 0;
        this.iXp = getIntent().getIntExtra("Retr_Compress_Type", 0);
        this.Qyl = getIntent().getIntExtra("Retr_Scene", 0);
        this.length = getIntent().getIntExtra("Retr_length", 0);
        this.Qyk = getIntent().getIntExtra("Retr_video_isexport", 0);
        this.Qyg = getIntent().getStringExtra("Retr_Msg_thumb_path");
        this.Qyh = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
        this.Qyv = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
        Intent intent = getIntent();
        if (this.Qyl == 0) {
            z = true;
        } else {
            z = false;
        }
        this.Qyw = intent.getBooleanExtra("Multi_Retr", z);
        if (this.Qyw) {
            this.Qyv = true;
        }
        this.Qyi = getIntent().getBooleanExtra("Retr_show_success_tips", this.Qyv);
        this.Qys = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
        this.PbY = getIntent().getBooleanExtra("is_group_chat", false);
        this.jsz = getIntent().getStringExtra("msg_uuid");
        this.PMs = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
        this.thumbPath = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
        this.Qyt = getIntent().getIntExtra("Retr_MsgImgScene", 0);
        this.longtitude = getIntent().getFloatExtra("Retr_Longtitude", -1000.0f);
        this.latitude = getIntent().getFloatExtra("Retr_Latitude", -1000.0f);
        this.iZr = getIntent().getStringExtra("Retr_AttachedContent");
        this.Qyu = "gallery".equals(getIntent().getStringExtra("Retr_From"));
        this.mSessionId = getIntent().getStringExtra("reportSessionId");
        this.Qyy = getIntent().getIntExtra("Retr_MsgFromScene", 0);
        this.PCe = getIntent().getStringExtra("Retr_MsgFromUserName");
        this.Qyz = getIntent().getStringExtra("Retr_MsgTalker");
        this.QyA = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 1);
        this.QyB = getIntent().getIntExtra("Retr_MsgAppBrandServiceType", 0);
        this.QyD = getIntent().getBooleanExtra("Retr_MsgFromMoreSelectRetransmit", false);
        bg.azz().a(110, this);
        if (!com.tencent.mm.compatible.util.d.oD(19)) {
            setContentView(R.layout.lb);
        }
        Intent intent2 = new Intent(this, SelectConversationUI.class);
        intent2.putExtra("scene", 8);
        intent2.putExtra("select_is_ret", true);
        if (this.Qyw) {
            intent2.putExtra("mutil_select_is_ret", true);
        }
        switch (this.msgType) {
            case 2:
            case 6:
            case 7:
            case 14:
            case 15:
            case 16:
                intent2.putExtra("appbrand_params", getIntent().getSerializableExtra("appbrand_params"));
                if (this.Qyy == 3) {
                    intent2.putExtra("scene_from", 3);
                }
                intent2.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.PMs);
                intent2.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
                intent2.putExtra("Select_Conv_Type", 3);
                break;
            case 3:
            case 4:
            case 5:
            case 9:
            case 10:
            case 11:
            default:
                intent2.putExtra("Select_Conv_Type", 3);
                break;
            case 8:
                bg.aVF();
                ca.a aEK = c.aSQ().aEK(this.dWG);
                if (aEK.dkU == null || aEK.dkU.length() <= 0) {
                    Log.e("MicroMsg.MsgRetransmitUI", "getView : parse possible friend msg failed");
                }
                if (ab.rR(aEK.IOs)) {
                    intent2.putExtra("Select_Conv_Type", 3);
                    break;
                } else {
                    intent2.putExtra("Select_Conv_Type", 7);
                    intent2.putExtra("search_range", new int[]{131072});
                    intent2.putExtra("mutil_select_is_ret", false);
                    intent2.putExtra("forward_card", true);
                    break;
                }
            case 12:
                if (!l.gNx()) {
                    intent2.putExtra("Select_Conv_Type", 3);
                    break;
                } else {
                    Log.d("MicroMsg.MsgRetransmitUI", "has can forward card");
                    intent2.putExtra("Select_Conv_Type", 7);
                    intent2.putExtra("mutil_select_is_ret", false);
                    intent2.putExtra("search_range", new int[]{131072});
                    intent2.putExtra("forward_card", true);
                    break;
                }
            case 13:
                intent2.putExtra("Select_Conv_Type", 11);
                break;
        }
        intent2.putExtra("Retr_Msg_Type", this.msgType);
        intent2.putExtra("Retr_Msg_Id", this.msgId);
        intent2.putExtra("Retr_Msg_content", this.dWG);
        intent2.putExtra("Retr_Msg_thumb_path", this.Qyg);
        intent2.putExtra("image_path", this.fileName);
        startActivityForResult(intent2, 0);
        AppMethodBeat.o(39289);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void finish() {
        AppMethodBeat.i(39290);
        super.finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(39290);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(39291);
        if (!this.Qyn) {
            bg.azz().b(110, this);
        }
        super.onDestroy();
        AppMethodBeat.o(39291);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void gYe() {
        View inflate;
        boolean z;
        String str;
        Object obj;
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        int i3;
        boolean z11;
        AppMethodBeat.i(39292);
        switch (this.Qyl) {
            case 0:
                switch (this.msgType) {
                    case 0:
                    case 1:
                    case 5:
                    case 8:
                    case 11:
                        if (!gYf()) {
                            finish();
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 2:
                    case 6:
                    case 10:
                    case 12:
                    case 13:
                    case 14:
                    case 16:
                        z = true;
                        break;
                    case 3:
                    default:
                        Log.e("MicroMsg.MsgRetransmitUI", "unknown type %s", Integer.valueOf(this.msgType));
                        z = true;
                        break;
                    case 4:
                        if (this.dWG == null || this.dWG.equals("")) {
                            Log.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
                            finish();
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 7:
                        if (!gYf()) {
                            finish();
                            z = false;
                            break;
                        } else {
                            if (this.fileName == null) {
                                Log.e("MicroMsg.MsgRetransmitUI", "Transfer fileName erro: fileName null");
                                finish();
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        }
                    case 9:
                        if (this.dWG == null || this.dWG.equals("")) {
                            Log.e("MicroMsg.MsgRetransmitUI", "Transfer text erro: content null");
                            finish();
                            z = false;
                            break;
                        }
                        z = true;
                        break;
                    case 15:
                        finish();
                        z = false;
                        break;
                }
                if (z) {
                    boolean z12 = true;
                    if (this.msgType != 11 && this.msgType != 1) {
                        if (this.msgType == 0) {
                            this.Qyx = this.Qyf.size();
                        }
                        int size = this.Qyf.size();
                        c.hn(this.mSessionId, size);
                        for (final String str2 : this.Qyf) {
                            int i4 = size - 1;
                            boolean z13 = i4 == 0;
                            switch (this.msgType) {
                                case 0:
                                    bg.aAk().setHighPriority();
                                    h.RTc.b(new Runnable() {
                                        /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(39258);
                                            Log.i("MicroMsg.MsgRetransmitUI", "test before sendMutiImage");
                                            MsgRetransmitUI.a(MsgRetransmitUI.this, str2);
                                            AppMethodBeat.o(39258);
                                        }
                                    }, "MicroMsg.MsgRetransmitUI");
                                    break;
                                case 2:
                                case 16:
                                case 19:
                                    z3 = bnY(str2);
                                    z12 = z3;
                                    break;
                                case 4:
                                    z.aTY();
                                    o.e Pl = o.Pl(str2);
                                    Pl.toUser = str2;
                                    Pl.content = this.dWG;
                                    o.e tD = Pl.tD(ab.JG(str2));
                                    tD.cSx = 0;
                                    tD.jdR = 4;
                                    tD.bdQ().execute();
                                    z3 = true;
                                    z12 = z3;
                                    break;
                                case 5:
                                    z3 = du(str2, false);
                                    z12 = z3;
                                    break;
                                case 6:
                                    k.b HD = k.b.HD(Util.processXml(this.dWG));
                                    if (HD == null) {
                                        Log.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
                                        z11 = false;
                                    } else {
                                        a(str2, HD, null, null);
                                        z11 = true;
                                    }
                                    z12 = z11;
                                    break;
                                case 7:
                                    bg.azz().a(new f(s.n(str2, this.fileName, this.length), 1), 0);
                                    z3 = true;
                                    z12 = z3;
                                    break;
                                case 8:
                                    ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(this.msgId);
                                    if (Hb.getType() == 42) {
                                        Log.d("MicroMsg.MsgRetransmitUI", "set forward flag");
                                        Hb.gDE();
                                        ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.msgId, Hb);
                                    }
                                    ca.a bkA = ca.a.bkA(this.dWG);
                                    o.e Pl2 = o.Pl(str2);
                                    Pl2.toUser = str2;
                                    Pl2.content = this.dWG;
                                    if (as.bjp(bkA.dkU)) {
                                        i3 = 66;
                                    } else {
                                        i3 = 42;
                                    }
                                    o.e tD2 = Pl2.tD(i3);
                                    tD2.cSx = 1;
                                    tD2.jdR = 4;
                                    tD2.bdQ().execute();
                                    break;
                                case 9:
                                    o.e Pl3 = o.Pl(str2);
                                    Pl3.toUser = str2;
                                    Pl3.content = this.dWG;
                                    o.e tD3 = Pl3.tD(48);
                                    tD3.cSx = 0;
                                    tD3.jdR = 4;
                                    tD3.bdQ().execute();
                                    z3 = true;
                                    z12 = z3;
                                    break;
                                case 10:
                                    rc rcVar = new rc();
                                    rcVar.dXF.type = 4;
                                    rc.a aVar = rcVar.dXF;
                                    bg.aVF();
                                    aVar.dTX = c.aSQ().Hb(this.msgId);
                                    rcVar.dXF.toUser = str2;
                                    EventCenter.instance.publish(rcVar);
                                    break;
                                case 12:
                                    l.n(this, str2, z13);
                                    break;
                                case 13:
                                    l.m(this, str2, z13);
                                    break;
                                case 14:
                                    up upVar = new up();
                                    upVar.eaS.dFm = this.msgId;
                                    upVar.eaS.dPu = this.dWG;
                                    upVar.eaS.dPv = str2;
                                    EventCenter.instance.publish(upVar);
                                    break;
                                case 18:
                                    if (!Util.isNullOrNil(this.dWG)) {
                                        Log.i("MicroMsg.MsgRetransmitUI", "transfer finder feed to %s", str2);
                                        k.b HD2 = k.b.HD(this.dWG);
                                        if (HD2 != null) {
                                            w.a.aSz().a(HD2, "", "", str2, "", null);
                                            com.tencent.mm.plugin.i.a.f fVar = (com.tencent.mm.plugin.i.a.f) HD2.as(com.tencent.mm.plugin.i.a.f.class);
                                            if (fVar != null) {
                                                LinkedList linkedList = new LinkedList();
                                                linkedList.add(new Pair(fVar.jlg.objectId, fVar.jlg.objectNonceId));
                                                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).shareStatsReport(linkedList, false);
                                            }
                                            z10 = true;
                                            z12 = z10;
                                            break;
                                        }
                                    }
                                    z10 = false;
                                    z12 = z10;
                                case 20:
                                    if (!Util.isNullOrNil(this.dWG)) {
                                        Log.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", str2);
                                        k.b HD3 = k.b.HD(this.dWG);
                                        if (HD3 != null) {
                                            w.a.aSz().a(HD3, "", "", str2, "", null);
                                            z8 = true;
                                            z12 = z8;
                                            break;
                                        }
                                    }
                                    z8 = false;
                                    z12 = z8;
                                case 21:
                                case 25:
                                case 27:
                                    if (!Util.isNullOrNil(this.dWG)) {
                                        Log.i("MicroMsg.MsgRetransmitUI", "transfer finder topic to %s", str2);
                                        k.b HD4 = k.b.HD(this.dWG);
                                        if (HD4 != null) {
                                            w.a.aSz().a(HD4, "", "", str2, "", null);
                                            z7 = true;
                                            z12 = z7;
                                            break;
                                        }
                                    }
                                    z7 = false;
                                    z12 = z7;
                                case 22:
                                    if (!Util.isNullOrNil(this.dWG)) {
                                        Log.i("MicroMsg.MsgRetransmitUI", "transfer finder topic to %s", str2);
                                        k.b HD5 = k.b.HD(this.dWG);
                                        if (HD5 != null) {
                                            w.a.aSz().a(HD5, "", "", str2, "", null);
                                            z6 = true;
                                            z12 = z6;
                                            break;
                                        }
                                    }
                                    z6 = false;
                                    z12 = z6;
                                case 23:
                                case 29:
                                    if (!Util.isNullOrNil(this.dWG)) {
                                        Log.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", str2);
                                        k.b HD6 = k.b.HD(this.dWG);
                                        if (HD6 != null) {
                                            w.a.aSz().a(HD6, "", "", str2, "", null);
                                            z9 = true;
                                            z12 = z9;
                                            break;
                                        }
                                    }
                                    z9 = false;
                                    z12 = z9;
                                case 24:
                                    if (!Util.isNullOrNil(this.dWG)) {
                                        Log.i("MicroMsg.MsgRetransmitUI", "transfer finder name card to %s", str2);
                                        k.b HD7 = k.b.HD(this.dWG);
                                        if (HD7 != null) {
                                            w.a.aSz().a(HD7, "", "", str2, "", null);
                                            z4 = true;
                                            z12 = z4;
                                            break;
                                        }
                                    }
                                    z4 = false;
                                    z12 = z4;
                                case 26:
                                    if (!Util.isNullOrNil(this.dWG)) {
                                        Log.i("MicroMsg.MsgRetransmitUI", "transfer finder feed to %s", str2);
                                        k.b HD8 = k.b.HD(this.dWG);
                                        if (HD8 != null) {
                                            w.a.aSz().a(HD8, "", "", str2, "", null);
                                            com.tencent.mm.plugin.i.a.i iVar = (com.tencent.mm.plugin.i.a.i) HD8.as(com.tencent.mm.plugin.i.a.i.class);
                                            if (iVar != null) {
                                                LinkedList linkedList2 = new LinkedList();
                                                linkedList2.add(new Pair(iVar.jlh.objectId, iVar.jlh.objectNonceId));
                                                ((aj) com.tencent.mm.kernel.g.ah(aj.class)).shareStatsReport(linkedList2, true);
                                            }
                                            z5 = true;
                                            z12 = z5;
                                            break;
                                        }
                                    }
                                    z5 = false;
                                    z12 = z5;
                                case 28:
                                    if (!Util.isNullOrNil(this.dWG)) {
                                        Log.i("MicroMsg.MsgRetransmitUI", "transfer finder poi to %s", str2);
                                        k.b HD9 = k.b.HD(this.dWG);
                                        if (HD9 != null) {
                                            w.a.aSz().a(HD9, "", "", str2, "", null);
                                            z3 = true;
                                            z12 = z3;
                                            break;
                                        }
                                    }
                                    z3 = false;
                                    z12 = z3;
                            }
                            if (this.Qys) {
                                l.BM(z13);
                            }
                            size = i4;
                        }
                        String str3 = this.Qyf.get(0);
                        switch (this.msgType) {
                            case 0:
                            case 2:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 13:
                            case 14:
                            case 16:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                                if (this.msgType == 2 || this.msgType == 16) {
                                    k.b HD10 = k.b.HD(Util.processXml(this.dWG));
                                    if (HD10 != null && HD10.type == 5 && !Util.isNullOrNil(HD10.url)) {
                                        String str4 = "";
                                        try {
                                            str4 = URLEncoder.encode(HD10.url, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                                        } catch (UnsupportedEncodingException e2) {
                                            Log.printErrStackTrace("MicroMsg.MsgRetransmitUI", e2, "", new Object[0]);
                                        }
                                        if (z12) {
                                            i2 = 1;
                                        } else {
                                            i2 = 2;
                                        }
                                        Log.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", 13378, HD10.url, Long.valueOf(this.startTime), Integer.valueOf(this.Qyy), 1, Integer.valueOf(i2));
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13378, str4, Long.valueOf(this.startTime), Integer.valueOf(this.Qyy), 1, Integer.valueOf(i2));
                                    } else if (!z12 && HD10 != null && HD10.type == 33) {
                                        p pVar = new p();
                                        pVar.dCt.scene = this.QyA;
                                        pVar.dCt.cyo = this.QyB;
                                        if (2 == this.QyA) {
                                            pVar.dCt.dCw = this.Qyz + ":" + this.PCe;
                                        } else {
                                            pVar.dCt.dCw = this.Qyz;
                                        }
                                        if (str3.endsWith("@chatroom")) {
                                            pVar.dCt.action = 2;
                                        } else {
                                            pVar.dCt.action = 1;
                                        }
                                        pVar.dCt.dCv = HD10.izz + 1;
                                        pVar.dCt.dCx = HD10.izh;
                                        pVar.dCt.dCu = HD10.izi;
                                        pVar.dCt.appId = HD10.izj;
                                        pVar.dCt.appVersion = HD10.izA;
                                        pVar.dCt.dCy = "";
                                        pVar.dCt.dCz = Util.nowSecond();
                                        pVar.dCt.dCA = 2;
                                        pVar.dCt.dCC = HD10.izn;
                                        EventCenter.instance.publish(pVar);
                                    }
                                }
                                if (z12) {
                                    if (this.Qyi) {
                                        com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.dzo));
                                    }
                                    Intent intent = new Intent();
                                    ArrayList<String> arrayList = new ArrayList<>();
                                    arrayList.addAll(this.Qyf);
                                    intent.putStringArrayListExtra("SendMsgUsernames", arrayList);
                                    intent.putExtra("sendResult", 0);
                                    setResult(-1, intent);
                                    if (this.QyC) {
                                        this.mHandler.postDelayed(new Runnable() {
                                            /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass5 */

                                            public final void run() {
                                                AppMethodBeat.i(39264);
                                                MsgRetransmitUI.this.finish();
                                                AppMethodBeat.o(39264);
                                            }
                                        }, this.Qyi ? 1800 : 0);
                                    }
                                    if (this.Qyh && !this.Qyv) {
                                        Intent intent2 = new Intent(this, ChattingUI.class);
                                        intent2.addFlags(67108864);
                                        intent2.putExtra("Chat_User", str3);
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/transmit/MsgRetransmitUI", "done", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/MsgRetransmitUI", "done", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    }
                                    AppMethodBeat.o(39292);
                                    return;
                                }
                                finish();
                                AppMethodBeat.o(39292);
                                return;
                            case 1:
                            case 11:
                                AppMethodBeat.o(39292);
                                return;
                            case 3:
                            case 15:
                            case 17:
                            default:
                                finish();
                                break;
                        }
                    } else {
                        List<String> list = this.Qyf;
                        Log.i("MicroMsg.MsgRetransmitUI", "processVideoTransfer");
                        if (11 != this.msgType || !u.QO(this.fileName)) {
                            b bVar = new b((byte) 0);
                            bVar.Qza = new LinkedList();
                            bVar.Qza.addAll(list);
                            final com.tencent.mm.modelvideo.s QN = u.QN(this.fileName);
                            if (QN == null) {
                                bg.aVF();
                                if (c.aSQ().Hb(this.msgId).cWK()) {
                                    jY(list);
                                }
                            }
                            for (final String str5 : list) {
                                Object[] objArr = new Object[2];
                                if (QN != null) {
                                    str = QN.getFileName();
                                } else {
                                    str = "";
                                }
                                objArr[0] = str;
                                if (QN != null) {
                                    obj = Integer.valueOf(QN.status);
                                } else {
                                    obj = "";
                                }
                                objArr[1] = obj;
                                Log.i("MicroMsg.MsgRetransmitUI", "info[%s, %s]", objArr);
                                if (QN == null || QN.status != 199) {
                                    if (QN == null) {
                                        Log.w("MicroMsg.MsgRetransmitUI", "checkVideoCdnInfo info is null !!!");
                                        z2 = false;
                                    } else {
                                        Map<String, String> parseXml = XmlParser.parseXml(QN.bhv(), "msg", null);
                                        if (parseXml == null) {
                                            Log.w("MicroMsg.MsgRetransmitUI", "%s cdntra parse video recv xml failed");
                                            z2 = false;
                                        } else {
                                            final String str6 = parseXml.get(".msg.videomsg.$cdnvideourl");
                                            if (Util.isNullOrNil(str6)) {
                                                z2 = false;
                                            } else {
                                                final String str7 = parseXml.get(".msg.videomsg.$aeskey");
                                                final String str8 = parseXml.get(".msg.videomsg.$md5");
                                                final String str9 = parseXml.get(".msg.videomsg.$newmd5");
                                                final int i5 = Util.getInt(parseXml.get(".msg.videomsg.$length"), 0);
                                                final int i6 = Util.getInt(parseXml.get(".msg.videomsg.$playlength"), 0);
                                                final int i7 = Util.getInt(parseXml.get(".msg.videomsg.$cdnthumblength"), 0);
                                                if (Util.isNullOrNil(str8)) {
                                                    com.tencent.mm.modelvideo.o.bhj();
                                                    if (!com.tencent.mm.vfs.s.YS(t.Qw(QN.getFileName()))) {
                                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1328, 1, 1, true);
                                                        z2 = false;
                                                    }
                                                }
                                                com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                                                gVar.taskName = "task_MsgRetransmitUI_3";
                                                gVar.gqy = new g.a() {
                                                    /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass15 */

                                                    @Override // com.tencent.mm.i.g.a
                                                    public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                                                        AppMethodBeat.i(39276);
                                                        if (dVar != null) {
                                                            if (dVar.field_exist_whencheck) {
                                                                dVar.field_fileId = str6;
                                                                dVar.field_aesKey = str7;
                                                                dVar.field_thumbimgLength = i7;
                                                                dVar.field_fileLength = (long) i5;
                                                                dVar.field_toUser = str5;
                                                                dVar.field_filemd5 = str8;
                                                                dVar.field_mp4identifymd5 = str9;
                                                                Log.i("MicroMsg.MsgRetransmitUI", "support second!! sceneResult: %s", dVar);
                                                                final String Qv = t.Qv(str5);
                                                                com.tencent.mm.modelvideo.o.bhj();
                                                                String Qx = t.Qx(Qv);
                                                                com.tencent.mm.modelvideo.o.bhj();
                                                                com.tencent.mm.vfs.s.nw(t.Qx(MsgRetransmitUI.this.fileName), Qx);
                                                                String str2 = ((("<msg><videomsg aeskey=\"" + str7 + "\" cdnthumbaeskey=\"" + str7 + "\" cdnvideourl=\"" + str6 + "\" ") + "cdnthumburl=\"" + str6 + "\" ") + "length=\"" + i5 + "\" ") + "cdnthumblength=\"" + i7 + "\"/></msg>";
                                                                Log.i("MicroMsg.MsgRetransmitUI", "cdn callback new build cdnInfo:%s", str2);
                                                                u.b(Qv, i6, str5, str2, QN.jso);
                                                                com.tencent.mm.av.s bcY = com.tencent.mm.av.s.bcY();
                                                                bcY.fileName = Qv;
                                                                bcY.jaB = 0;
                                                                bcY.jaC = dVar;
                                                                bcY.jaD = new com.tencent.mm.av.f() {
                                                                    /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass15.AnonymousClass1 */

                                                                    @Override // com.tencent.mm.av.f
                                                                    public final void dq(int i2, int i3) {
                                                                        AppMethodBeat.i(39275);
                                                                        com.tencent.mm.modelvideo.s QN = u.QN(Qv);
                                                                        QN.status = 111;
                                                                        QN.cSx = 256;
                                                                        com.tencent.mm.modelvideo.o.bhj().c(QN);
                                                                        Log.d("MicroMsg.MsgRetransmitUI", "NetSceneUploadVideoForCdn callback, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
                                                                        AppMethodBeat.o(39275);
                                                                    }
                                                                };
                                                                bcY.jdR = 4;
                                                                bcY.bdQ().execute();
                                                                MsgRetransmitUI.this.finish();
                                                            } else {
                                                                Log.i("MicroMsg.MsgRetransmitUI", "not support second!! dealDownloadVideo");
                                                                MsgRetransmitUI.i(MsgRetransmitUI.this);
                                                            }
                                                        }
                                                        AppMethodBeat.o(39276);
                                                        return 0;
                                                    }

                                                    @Override // com.tencent.mm.i.g.a
                                                    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                                                    }

                                                    @Override // com.tencent.mm.i.g.a
                                                    public final byte[] f(String str, byte[] bArr) {
                                                        return new byte[0];
                                                    }
                                                };
                                                gVar.field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), str5, new StringBuilder().append(this.msgId).toString());
                                                gVar.field_fileId = str6;
                                                gVar.field_aesKey = str7;
                                                gVar.field_filemd5 = str8;
                                                gVar.field_fileType = 4;
                                                gVar.field_talker = str5;
                                                gVar.field_priority = com.tencent.mm.i.a.gpM;
                                                gVar.field_svr_signature = "";
                                                gVar.field_onlycheckexist = true;
                                                gVar.field_trysafecdn = true;
                                                Log.d("MicroMsg.MsgRetransmitUI", "field_fileId:%s, md5:%s, field_aesKey:%s, xml:%s", str6, str8, str7, QN.bhv());
                                                if (!com.tencent.mm.an.f.baQ().f(gVar)) {
                                                    Log.e("MicroMsg.MsgRetransmitUI", "check exist fail! download video before retransmit");
                                                    finish();
                                                    z2 = false;
                                                } else {
                                                    this.Qyi = false;
                                                    finish();
                                                    z2 = true;
                                                }
                                            }
                                        }
                                    }
                                    if (!z2) {
                                        gYg();
                                    }
                                } else {
                                    a(bVar, str5);
                                }
                            }
                        } else {
                            com.tencent.mm.ui.widget.snackbar.b.a(this, getResources().getString(R.string.gkm), "", (a.b) null);
                            this.mHandler.postDelayed(new Runnable() {
                                /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass19 */

                                public final void run() {
                                    AppMethodBeat.i(39280);
                                    MsgRetransmitUI.this.finish();
                                    AppMethodBeat.o(39280);
                                }
                            }, 1800);
                        }
                        if (this.Qys) {
                            l.BM(true);
                        }
                        AppMethodBeat.o(39292);
                        return;
                    }
                }
                AppMethodBeat.o(39292);
                return;
            case 1:
                final String str10 = this.Qyf.get(0);
                if (!gYf()) {
                    finish();
                    AppMethodBeat.o(39292);
                    return;
                }
                switch (this.msgType) {
                    case 0:
                        if (this.Qyo != null && this.Qyo.size() > 0) {
                            this.Qyq = this.Qyo.size();
                        }
                        this.iYO = new j() {
                            /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass2 */

                            @Override // com.tencent.mm.ak.j
                            public final void a(int i2, int i3, q qVar) {
                                AppMethodBeat.i(39259);
                                if (MsgRetransmitUI.this.Qyj == null || i3 == 0) {
                                    AppMethodBeat.o(39259);
                                    return;
                                }
                                int i4 = (int) ((((long) i2) * 100) / ((long) i3));
                                MsgRetransmitUI.this.Qyj.setMessage(MsgRetransmitUI.this.getString(R.string.f4p, new Object[]{Integer.valueOf(MsgRetransmitUI.this.Qyp), Integer.valueOf(MsgRetransmitUI.this.Qyq), Integer.valueOf(i4)}));
                                Log.i("MicroMsg.MsgRetransmitUI", "onSceneProgress: %d", Integer.valueOf(i4));
                                AppMethodBeat.o(39259);
                            }
                        };
                        this.Qyj = com.tencent.mm.ui.base.h.d(this, getString(R.string.f4p, new Object[]{1, Integer.valueOf(this.Qyq), 0}), getString(R.string.zb), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(39260);
                                if (MsgRetransmitUI.this.Qyj != null) {
                                    MsgRetransmitUI.this.Qyj.cancel();
                                }
                                AppMethodBeat.o(39260);
                            }
                        });
                        Log.i("MicroMsg.MsgRetransmitUI", "show uploadImgDialog : %s", this.Qyj);
                        if (this.Qyj != null) {
                            this.Qyj.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass4 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(39263);
                                    com.tencent.mm.ui.base.h.a(MsgRetransmitUI.this, (int) R.string.f4j, (int) R.string.zb, (int) R.string.a0_, (int) R.string.x6, new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass4.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            com.tencent.mm.av.g tl;
                                            AppMethodBeat.i(39261);
                                            if (MsgRetransmitUI.this.Qym != null) {
                                                bg.azz().a(MsgRetransmitUI.this.Qym);
                                                int i3 = (int) MsgRetransmitUI.this.Qym.iYP;
                                                com.tencent.mm.av.g tl2 = com.tencent.mm.av.q.bcR().tl(i3);
                                                if (tl2 != null) {
                                                    com.tencent.mm.av.i bcR = com.tencent.mm.av.q.bcR();
                                                    com.tencent.mm.av.g tl3 = bcR.tl(i3);
                                                    if (tl3 != null && tl3.localId == ((long) i3)) {
                                                        com.tencent.mm.vfs.s.deleteFile(bcR.o(tl3.iXm, "", ""));
                                                        com.tencent.mm.vfs.s.deleteFile(bcR.o(tl3.iXr, "", ""));
                                                        com.tencent.mm.vfs.s.deleteFile(bcR.o(tl3.iXo, "", ""));
                                                        com.tencent.mm.vfs.s.deleteFile(bcR.o(tl3.iXo, "", "") + "hd");
                                                        bcR.iFy.delete(i.d.Ay((long) i3), "id=?", new String[]{String.valueOf(i3)});
                                                        if (tl3.bcv() && (tl = bcR.tl(tl3.iXx)) != null) {
                                                            com.tencent.mm.vfs.s.deleteFile(bcR.o(tl.iXm, "", ""));
                                                            com.tencent.mm.vfs.s.deleteFile(bcR.o(tl.iXr, "", ""));
                                                            com.tencent.mm.vfs.s.deleteFile(bcR.o(tl.iXo, "", ""));
                                                            com.tencent.mm.vfs.s.deleteFile(bcR.o(tl.iXo, "", "") + "hd");
                                                            bcR.iFy.delete(i.d.Ay((long) i3), "id=?", new String[]{new StringBuilder().append(tl.localId).toString()});
                                                        }
                                                    }
                                                    bg.aVF();
                                                    c.aSQ().Hc(tl2.iXv);
                                                }
                                            }
                                            Toast.makeText(MsgRetransmitUI.this, (int) R.string.f4k, 1).show();
                                            MsgRetransmitUI.this.finish();
                                            AppMethodBeat.o(39261);
                                        }
                                    }, new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass4.AnonymousClass2 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(39262);
                                            if (MsgRetransmitUI.this.Qyj != null) {
                                                MsgRetransmitUI.this.Qyj.show();
                                            }
                                            AppMethodBeat.o(39262);
                                        }
                                    });
                                    AppMethodBeat.o(39263);
                                }
                            });
                            this.Qyj.setCanceledOnTouchOutside(false);
                            this.Qyj.getButton(-1).setText(R.string.sz);
                        }
                        a(str10, 6, this.iYO);
                        AppMethodBeat.o(39292);
                        return;
                    case 1:
                    case 11:
                        if (!ag.dm(this)) {
                            com.tencent.mm.ui.base.h.a(this, (int) R.string.hwn, (int) R.string.zb, (int) R.string.x_, (int) R.string.sz, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass17 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(39278);
                                    MsgRetransmitUI.a(MsgRetransmitUI.this, MsgRetransmitUI.this.getIntent(), str10);
                                    AppMethodBeat.o(39278);
                                }
                            }, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass18 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(39279);
                                    MsgRetransmitUI.this.finish();
                                    AppMethodBeat.o(39279);
                                }
                            });
                            AppMethodBeat.o(39292);
                            return;
                        }
                        t(getIntent(), str10);
                        AppMethodBeat.o(39292);
                        return;
                    case 5:
                        du(str10, true);
                        AppMethodBeat.o(39292);
                        return;
                    default:
                        Log.i("MicroMsg.MsgRetransmitUI", "doRetransmitOnSceneShareFromSystemGallery unknown msg type:%d", Integer.valueOf(this.msgType));
                        AppMethodBeat.o(39292);
                        return;
                }
            case 2:
                switch (this.msgType) {
                    case 2:
                    case 16:
                        this.Qyf.get(0);
                        String string = getIntent().getExtras().getString(ConstantsAPI.APP_PACKAGE);
                        com.tencent.mm.pluginsdk.model.app.g gVar2 = new com.tencent.mm.pluginsdk.model.app.g();
                        gVar2.field_packageName = string;
                        com.tencent.mm.pluginsdk.model.app.ao.eAS().get(gVar2, AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
                        WXMediaMessage wXMediaMessage = new SendMessageToWX.Req(getIntent().getExtras()).message;
                        e eVar = new e(new e.a() {
                            /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass12 */

                            @Override // com.tencent.mm.ui.transmit.e.a
                            public final void gYh() {
                                AppMethodBeat.i(39271);
                                MsgRetransmitUI.this.finish();
                                AppMethodBeat.o(39271);
                            }
                        });
                        Bitmap decodeByteArray = wXMediaMessage.thumbData == null ? null : BitmapUtil.decodeByteArray(wXMediaMessage.thumbData);
                        switch (wXMediaMessage.mediaObject.type()) {
                            case 1:
                                inflate = View.inflate(this, R.layout.h6, null);
                                ((TextView) inflate.findViewById(R.id.ir3)).setText(wXMediaMessage.title);
                                break;
                            case 2:
                                inflate = View.inflate(this, R.layout.h5, null);
                                ((ImageView) inflate.findViewById(R.id.imb)).setImageBitmap(decodeByteArray);
                                ((TextView) inflate.findViewById(R.id.ir3)).setText(wXMediaMessage.title);
                                break;
                            case 3:
                                inflate = View.inflate(this, R.layout.h4, null);
                                ((ImageView) inflate.findViewById(R.id.imb)).setImageBitmap(decodeByteArray);
                                ((TextView) inflate.findViewById(R.id.ir3)).setText(wXMediaMessage.title);
                                ((TextView) inflate.findViewById(R.id.bn6)).setText(wXMediaMessage.description);
                                break;
                            case 4:
                                inflate = View.inflate(this, R.layout.h4, null);
                                ((ImageView) inflate.findViewById(R.id.imb)).setImageBitmap(decodeByteArray);
                                ((TextView) inflate.findViewById(R.id.ir3)).setText(wXMediaMessage.title);
                                ((TextView) inflate.findViewById(R.id.bn6)).setText(wXMediaMessage.description);
                                break;
                            case 5:
                                inflate = View.inflate(this, R.layout.h4, null);
                                ((ImageView) inflate.findViewById(R.id.imb)).setImageBitmap(decodeByteArray);
                                ((TextView) inflate.findViewById(R.id.ir3)).setText(wXMediaMessage.title);
                                ((TextView) inflate.findViewById(R.id.bn6)).setText(wXMediaMessage.description);
                                break;
                            case 6:
                                inflate = View.inflate(this, R.layout.h4, null);
                                ((ImageView) inflate.findViewById(R.id.imb)).setImageBitmap(decodeByteArray);
                                ((TextView) inflate.findViewById(R.id.ir3)).setText(wXMediaMessage.title);
                                ((TextView) inflate.findViewById(R.id.bn6)).setText(wXMediaMessage.description);
                                break;
                            case 7:
                                inflate = View.inflate(this, R.layout.h4, null);
                                ((ImageView) inflate.findViewById(R.id.imb)).setImageBitmap(decodeByteArray);
                                ((TextView) inflate.findViewById(R.id.ir3)).setText(wXMediaMessage.title);
                                ((TextView) inflate.findViewById(R.id.bn6)).setText(wXMediaMessage.description);
                                break;
                            default:
                                Log.e("MicroMsg.SendAppMessage", "unkown app message type, skipped, type=" + wXMediaMessage.mediaObject.type());
                                AppMethodBeat.o(39292);
                                return;
                        }
                        ((TextView) inflate.findViewById(R.id.i34)).setText(com.tencent.mm.pluginsdk.model.app.h.a(this, gVar2, (String) null));
                        eVar.kdo = com.tencent.mm.ui.base.h.a(this, (String) null, inflate, getString(R.string.yq), getString(R.string.sz), new DialogInterface.OnClickListener(eVar) {
                            /* class com.tencent.mm.ui.transmit.e.AnonymousClass1 */
                            final /* synthetic */ e QzX;

                            {
                                this.QzX = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(39413);
                                this.QzX.QzW.gYh();
                                AppMethodBeat.o(39413);
                            }
                        }, new DialogInterface.OnClickListener(eVar) {
                            /* class com.tencent.mm.ui.transmit.e.AnonymousClass2 */
                            final /* synthetic */ e QzX;

                            {
                                this.QzX = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(39414);
                                e eVar = this.QzX;
                                if (eVar.kdo != null) {
                                    eVar.kdo.dismiss();
                                    eVar.kdo = null;
                                }
                                eVar.QzW.gYh();
                                AppMethodBeat.o(39414);
                            }
                        });
                        break;
                }
                AppMethodBeat.o(39292);
                return;
            default:
                Log.e("MicroMsg.MsgRetransmitUI", "unknown scene %s", Integer.valueOf(this.Qyl));
                finish();
                AppMethodBeat.o(39292);
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        long j2;
        AppMethodBeat.i(39293);
        super.onActivityResult(i2, i3, intent);
        String str = "";
        if (intent != null) {
            str = intent.getStringExtra("custom_send_text");
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!Util.isNullOrNil(stringExtra)) {
                this.Qyf = Util.stringsToList(stringExtra.split(","));
            }
        }
        if (this.QyD) {
            com.tencent.mm.plugin.selectrecord.b.b eSz = com.tencent.mm.plugin.selectrecord.b.b.eSz();
            List<String> list = this.Qyf;
            gf gfVar = eSz.CXf;
            gfVar.eJm = gfVar.x("ToUsername", Util.listToString(list, ";"), true);
            com.tencent.mm.plugin.selectrecord.b.b eSz2 = com.tencent.mm.plugin.selectrecord.b.b.eSz();
            if (Util.isNullOrNil(str)) {
                j2 = 2;
            } else {
                j2 = 1;
            }
            eSz2.CXf.eJi = j2;
        }
        if (i3 != -1) {
            k.b HD = k.b.HD(Util.processXml(this.dWG));
            if (HD != null && HD.type == 5 && HD.url != null) {
                Log.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", 13378, HD.url, Long.valueOf(this.startTime), Integer.valueOf(this.Qyy), 1, 3);
                String str2 = "";
                try {
                    str2 = URLEncoder.encode(HD.url, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace("MicroMsg.MsgRetransmitUI", e2, "", new Object[0]);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13378, str2, Long.valueOf(this.startTime), Integer.valueOf(this.Qyy), 1, 3);
            } else if (HD != null && HD.type == 33) {
                p pVar = new p();
                pVar.dCt.cyo = this.QyB;
                pVar.dCt.scene = this.QyA;
                if (2 == this.QyA) {
                    pVar.dCt.dCw = this.Qyz + ":" + this.PCe;
                } else {
                    pVar.dCt.dCw = this.Qyz;
                }
                pVar.dCt.dCv = HD.izz + 1;
                pVar.dCt.dCx = HD.izh;
                pVar.dCt.dCu = HD.izi;
                pVar.dCt.appId = HD.izj;
                pVar.dCt.appVersion = HD.izA;
                pVar.dCt.action = 1;
                pVar.dCt.dCy = "";
                pVar.dCt.dCz = Util.nowSecond();
                pVar.dCt.dCA = 3;
                pVar.dCt.dCC = HD.izn;
                EventCenter.instance.publish(pVar);
            }
            if (this.QyD) {
                com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
            }
            finish();
            AppMethodBeat.o(39293);
        } else if (i2 != 0) {
            Log.e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(i2)));
            AppMethodBeat.o(39293);
        } else {
            this.tca = intent.getBooleanExtra("key_is_biz_chat", false);
            if (this.tca) {
                this.ppv = intent.getLongExtra("key_biz_chat_id", -1);
            }
            int intExtra = intent.getIntExtra("Retr_Msg_Type", -1);
            if (intExtra != -1) {
                Log.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", Integer.valueOf(this.msgType), Integer.valueOf(intExtra));
                this.msgType = intExtra;
            }
            this.QyE = intent.getBooleanExtra("KSendGroupToDo", false);
            this.QyF = intent.getIntExtra("KShowTodoIntroduceView", 0);
            Log.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", Integer.valueOf(this.msgType), Integer.valueOf(this.Qyl), Integer.valueOf(this.Qyf.size()));
            gYe();
            if (!TextUtils.isEmpty(str)) {
                for (String str3 : this.Qyf) {
                    tw twVar = new tw();
                    twVar.eaq.dkV = str3;
                    twVar.eaq.content = str;
                    twVar.eaq.type = ab.JG(str3);
                    twVar.eaq.flags = 0;
                    EventCenter.instance.publish(twVar);
                }
            }
            if (this.QyD) {
                com.tencent.mm.plugin.selectrecord.b.b eSz3 = com.tencent.mm.plugin.selectrecord.b.b.eSz();
                eSz3.Xk(1);
                eSz3.bfK();
            }
            AppMethodBeat.o(39293);
        }
    }

    private boolean bnY(final String str) {
        AppMethodBeat.i(39294);
        final k.b HD = k.b.HD(Util.processXml(this.dWG));
        Log.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", this.dWG, HD);
        if (HD == null) {
            Log.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
            AppMethodBeat.o(39294);
            return false;
        } else if (HD.type == 53 || HD.type == 57) {
            String str2 = HD.title;
            z.aTY();
            o.e Pl = o.Pl(str);
            Pl.toUser = str;
            Pl.content = str2;
            o.e tD = Pl.tD(ab.JG(str));
            tD.cSx = 0;
            tD.jdR = 4;
            tD.bdQ().execute();
            AppMethodBeat.o(39294);
            return true;
        } else {
            bg.aVF();
            final ca Hb = c.aSQ().Hb(this.msgId);
            if (!Hb.gAt()) {
                final byte[] bArr = null;
                if (this.Qyg != null) {
                    try {
                        bArr = com.tencent.mm.vfs.s.aW(this.Qyg, 0, -1);
                        if (!cM(bArr)) {
                            AppMethodBeat.o(39294);
                            return false;
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.MsgRetransmitUI", e2, "", new Object[0]);
                        Log.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", str, e2.getLocalizedMessage());
                    }
                } else if (this.PMs < 0 && Hb.field_imgPath != null && !Hb.field_imgPath.equals("")) {
                    try {
                        bArr = com.tencent.mm.vfs.s.aW(com.tencent.mm.av.q.bcR().R(Hb.field_imgPath, true), 0, -1);
                        if (!cM(bArr)) {
                            AppMethodBeat.o(39294);
                            return false;
                        }
                    } catch (Exception e3) {
                        Log.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", str, e3.getLocalizedMessage());
                    }
                }
                com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) HD.as(com.tencent.mm.ag.a.class);
                if (aVar == null) {
                    aVar = new com.tencent.mm.ag.a();
                }
                aVar.ivq = this.QyE;
                HD.a(aVar);
                h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass16 */

                    public final void run() {
                        AppMethodBeat.i(39277);
                        MsgRetransmitUI.a(MsgRetransmitUI.this, str, HD, bArr, Hb);
                        AppMethodBeat.o(39277);
                    }
                }, "MicroMsg.MsgRetransmitUI");
            } else if (HD.type == 33) {
                m.b(str, HD, co.c(((HashMap) getIntent().getSerializableExtra("appbrand_params")).get("img_url"), null));
            } else {
                com.tencent.mm.ui.chatting.k.a(this, str, this.dWG, Hb.field_isSend, this.PbY);
            }
            AppMethodBeat.o(39294);
            return true;
        }
    }

    private void a(final String str, final k.b bVar, final byte[] bArr, ca caVar) {
        AppMethodBeat.i(39295);
        Log.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", str, bVar.dCK);
        com.tencent.mm.pluginsdk.model.app.c bdJ = com.tencent.mm.pluginsdk.model.app.m.bdJ(bVar.dCK);
        if (!Util.isNullOrNil(bVar.iwN)) {
            bdJ = com.tencent.mm.pluginsdk.model.app.m.c(caVar, bVar.dCK);
        }
        String str2 = "";
        if (!(bdJ == null || bdJ.field_fileFullPath == null || bdJ.field_fileFullPath.equals(""))) {
            bg.aVF();
            str2 = com.tencent.mm.pluginsdk.model.app.m.aB(c.aTg(), bVar.title, bVar.iwJ);
            com.tencent.mm.vfs.s.nw(bdJ.field_fileFullPath, str2);
            Log.i("MicroMsg.MsgRetransmitUI", "summerbig send old path[%s], title[%s] attachPath[%s]， finish[%b]", bdJ.field_fileFullPath, bVar.title, str2, Boolean.valueOf(bdJ.deQ()));
        }
        final k.b a2 = k.b.a(bVar);
        a2.iwL = 3;
        if (caVar != null && bVar.type == 6 && !Util.isNullOrNil(bVar.iwN) && bdJ != null && (!com.tencent.mm.vfs.s.YS(bdJ.field_fileFullPath) || com.tencent.mm.vfs.s.boW(bdJ.field_fileFullPath) != bdJ.field_totalLen)) {
            a(a2, bdJ, caVar, str, str2, bArr);
            AppMethodBeat.o(39295);
        } else if (!Util.isNullOrNil(str2) || (bVar.iwM == 0 && bVar.iwI <= 26214400)) {
            com.tencent.mm.pluginsdk.model.app.m.a(a2, bVar.appId, bVar.appName, str, str2, bArr, this.mSessionId);
            if (a2.type == 36) {
                int i2 = str.endsWith("chatroom") ? 1 : 0;
                String encode = URLEncoder.encode(Util.nullAsNil(a2.url));
                String encode2 = URLEncoder.encode(Util.nullAsNil(a2.title));
                String encode3 = URLEncoder.encode(Util.nullAsNil(a2.description));
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14127, a2.appId, a2.izi, URLEncoder.encode(Util.nullAsNil(a2.izh)), encode2, encode3, "", encode, 0, 1, 1, Integer.valueOf(i2), str, 1, bVar.izn, "");
            }
            AppMethodBeat.o(39295);
        } else {
            Log.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", Integer.valueOf(bVar.iwM), Integer.valueOf(bVar.iwI));
            bg.azz().a(new com.tencent.mm.pluginsdk.g.c(bVar, null, str, new c.a() {
                /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass20 */

                @Override // com.tencent.mm.pluginsdk.g.c.a
                public final void a(String str, String str2, String str3, String str4, String str5, String str6, long j2) {
                    AppMethodBeat.i(234474);
                    Log.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new, errMsg:[%s], md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", str, str2, Util.secPrint(str3), Util.secPrint(str4), Util.secPrint(bVar.aesKey), Util.secPrint(str5), Util.secPrint(str6));
                    if (!Util.isNullOrNil(str4)) {
                        com.tencent.mm.pluginsdk.model.app.m.a(a2, bVar.appId, bVar.appName, str, "", bArr, MsgRetransmitUI.this.mSessionId, str4);
                        AppMethodBeat.o(234474);
                        return;
                    }
                    com.tencent.mm.ui.base.h.c(MsgRetransmitUI.this, MsgRetransmitUI.this.getString(R.string.bip), "", true);
                    MsgRetransmitUI.this.finish();
                    AppMethodBeat.o(234474);
                }
            }), 0);
            AppMethodBeat.o(39295);
        }
    }

    private void a(final k.b bVar, final com.tencent.mm.pluginsdk.model.app.c cVar, final ca caVar, final String str, final String str2, final byte[] bArr) {
        AppMethodBeat.i(39296);
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.taskName = "task_MsgRetransmitUI_1";
        gVar.gqy = new g.a() {
            /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass21 */

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                AppMethodBeat.i(39282);
                cVar.field_fileFullPath = str2;
                if (i2 == 0 && cVar != null) {
                    cVar.field_offset = cVar.field_finishedLength;
                    com.tencent.mm.pluginsdk.model.app.ao.cgO().a(cVar, new String[0]);
                }
                if (i2 == 0 && dVar != null && dVar.field_retCode == 0) {
                    cVar.field_status = 199;
                    cVar.field_offset = cVar.field_totalLen;
                    com.tencent.mm.pluginsdk.model.app.ao.cgO().a(cVar, new String[0]);
                    caVar.setStatus(3);
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
                    com.tencent.mm.pluginsdk.model.app.m.a(bVar, bVar.appId, bVar.appName, str, str2, bArr, MsgRetransmitUI.this.mSessionId);
                }
                AppMethodBeat.o(39282);
                return 0;
            }

            @Override // com.tencent.mm.i.g.a
            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            @Override // com.tencent.mm.i.g.a
            public final byte[] f(String str, byte[] bArr) {
                return new byte[0];
            }
        };
        gVar.field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), caVar.field_talker, new StringBuilder().append(caVar.field_msgId).toString());
        gVar.field_aesKey = bVar.aesKey;
        gVar.field_fileType = 19;
        gVar.field_authKey = bVar.iwT;
        gVar.gqB = bVar.iwN;
        gVar.field_fullpath = str2;
        if (!com.tencent.mm.an.f.baQ().b(gVar, -1)) {
            Log.e("MicroMsg.MsgRetransmitUI", "openim attach download failed before rescend");
        }
        AppMethodBeat.o(39296);
    }

    private boolean du(String str, boolean z) {
        boolean z2;
        EmojiInfo emojiInfo;
        AppMethodBeat.i(39297);
        if (this.fileName == null) {
            AppMethodBeat.o(39297);
            return false;
        }
        EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(this.fileName);
        long boW = aml == null ? com.tencent.mm.vfs.s.boW(this.fileName) : com.tencent.mm.vfs.s.boW(aml.hYx());
        String hYx = aml == null ? this.fileName : aml.hYx();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapUtil.decodeFile(hYx, options);
        if (options.outHeight > com.tencent.mm.n.c.aqo() || options.outWidth > com.tencent.mm.n.c.aqo()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (boW > ((long) com.tencent.mm.n.c.aqp()) || z2) {
            Object[] objArr = new Object[2];
            objArr[0] = aml == null ? DownloadInfo.FILENAME : aml.getMd5();
            objArr[1] = Integer.valueOf(this.length);
            Log.i("MicroMsg.MsgRetransmitUI", "emoji is over size. md5:%s size:%d", objArr);
            this.QyC = false;
            this.Qyi = false;
            com.tencent.mm.ui.base.h.a(this, getString(R.string.bs3), "", getString(R.string.e2u), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass22 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(39283);
                    MsgRetransmitUI.this.finish();
                    AppMethodBeat.o(39283);
                }
            });
            if (this.Qyt == 1) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13459, Long.valueOf(boW), 1, aml.getMd5(), 1);
            }
            AppMethodBeat.o(39297);
            return true;
        }
        if (this.Qyt == 1) {
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr2 = new Object[4];
            objArr2[0] = Long.valueOf(boW);
            objArr2[1] = 0;
            objArr2[2] = aml == null ? "" : aml.getMd5();
            objArr2[3] = 1;
            hVar.a(13459, objArr2);
        }
        if (z) {
            if (aml == null) {
                emojiInfo = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(getApplicationContext(), new WXMediaMessage(new WXEmojiObject(this.fileName)), ""));
            } else {
                emojiInfo = aml;
            }
            if (emojiInfo != null) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13459, Long.valueOf(boW), 0, emojiInfo.getMd5(), 2);
                com.tencent.mm.ui.chatting.k.d(emojiInfo, str);
            }
            finish();
            AppMethodBeat.o(39297);
            return true;
        } else if (aml != null && boW > ((long) com.tencent.mm.n.c.aqm())) {
            com.tencent.mm.ui.chatting.k.d(aml, str);
            AppMethodBeat.o(39297);
            return true;
        } else if (((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().u(this, str, this.fileName)) {
            AppMethodBeat.o(39297);
            return true;
        } else {
            Log.e("MicroMsg.MsgRetransmitUI", "Retransmit emoji failed.");
            AppMethodBeat.o(39297);
            return false;
        }
    }

    private boolean gYf() {
        AppMethodBeat.i(39298);
        bg.aVF();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            Log.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
            com.tencent.mm.ui.base.u.g(this, null);
            AppMethodBeat.o(39298);
            return false;
        }
        AppMethodBeat.o(39298);
        return true;
    }

    private void t(Intent intent, String str) {
        AppMethodBeat.i(39299);
        if (this.Qyr) {
            this.Qyq = this.Qyo.size();
            ArrayList parcelableArrayList = intent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
            if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                finish();
                AppMethodBeat.o(39299);
                return;
            }
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                it.next();
                if (this.QyG) {
                    break;
                }
                bnZ(str);
            }
            AppMethodBeat.o(39299);
            return;
        }
        this.Qyq = 1;
        bnZ(str);
        AppMethodBeat.o(39299);
    }

    private void bnZ(String str) {
        AppMethodBeat.i(39300);
        Log.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
        final com.tencent.mm.pluginsdk.model.m mVar = new com.tencent.mm.pluginsdk.model.m(this, null, getIntent(), str, 1, new m.a() {
            /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass6 */

            @Override // com.tencent.mm.pluginsdk.model.m.a
            public final void gmA() {
                AppMethodBeat.i(39265);
                if (MsgRetransmitUI.this.gtM != null) {
                    MsgRetransmitUI.this.gtM.dismiss();
                    MsgRetransmitUI.this.gtM = null;
                }
                MsgRetransmitUI.this.finish();
                AppMethodBeat.o(39265);
            }
        });
        h.RTc.aX(mVar);
        getString(R.string.zb);
        this.gtM = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass7 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(39266);
                mVar.gmu();
                MsgRetransmitUI.this.QyG = true;
                MsgRetransmitUI.this.finish();
                AppMethodBeat.o(39266);
            }
        });
        AppMethodBeat.o(39300);
    }

    private void a(String str, int i2, j jVar) {
        long j2;
        AppMethodBeat.i(39301);
        String aTY = z.aTY();
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
        if (Hb.field_msgId == this.msgId) {
            String str2 = Hb.field_content;
            com.tencent.mm.av.g gVar = null;
            if (Hb.field_msgId > 0) {
                gVar = com.tencent.mm.av.q.bcR().H(Hb.field_talker, Hb.field_msgId);
            }
            if ((gVar == null || gVar.localId <= 0) && Hb.field_msgSvrId > 0) {
                gVar = com.tencent.mm.av.q.bcR().G(Hb.field_talker, Hb.field_msgSvrId);
            }
            if (Util.isNullOrNil(str2) && Hb.field_msgSvrId > 0) {
                str2 = gVar.iXy;
            }
            if (gVar == null || ((gVar.offset >= gVar.iKP && gVar.iKP != 0) || this.Qyr)) {
                if (gVar != null) {
                    j2 = gVar.localId;
                } else {
                    j2 = -1;
                }
                a(str, i2, aTY, str2, jVar, j2);
                AppMethodBeat.o(39301);
                return;
            }
            com.tencent.mm.av.g G = com.tencent.mm.av.q.bcR().G(Hb.field_talker, Hb.field_msgSvrId);
            if (!a(G, Hb, str2, i2, str, aTY)) {
                b(G, Hb, str2, i2, str, aTY);
            }
            AppMethodBeat.o(39301);
            return;
        }
        a(str, i2, aTY, "", jVar, -1);
        AppMethodBeat.o(39301);
    }

    private void b(com.tencent.mm.av.g gVar, ca caVar, final String str, final int i2, final String str2, final String str3) {
        AppMethodBeat.i(39303);
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        pString.value = this.fileName;
        int i3 = gVar.iXp;
        long a2 = com.tencent.mm.av.q.bcR().a(caVar.field_talker, this.fileName, i3, i2, pString, pInt, pInt2);
        com.tencent.mm.av.g c2 = com.tencent.mm.av.q.bcR().c(Long.valueOf(a2));
        c2.tj(1);
        ca caVar2 = new ca();
        caVar2.setType(ab.JH(str2));
        caVar2.Cy(str2);
        caVar2.nv(1);
        caVar2.setStatus(1);
        caVar2.Cz(pString.value);
        caVar2.nG(pInt.value);
        caVar2.nH(pInt2.value);
        caVar2.setCreateTime(bp.Kw(caVar2.field_talker));
        if (com.tencent.mm.al.g.DQ(caVar2.field_talker)) {
            caVar.BB(com.tencent.mm.al.a.e.ajw());
        }
        bg.aVF();
        long aC = com.tencent.mm.model.c.aSQ().aC(caVar2);
        Assert.assertTrue(aC >= 0);
        Log.i("MicroMsg.MsgRetransmitUI", "NetSceneUploadMsgImg: local msgId = ".concat(String.valueOf(aC)));
        c2.Aw((long) ((int) aC));
        com.tencent.mm.av.q.bcR().a(Long.valueOf(a2), c2);
        HashMap hashMap = new HashMap();
        hashMap.put(Long.valueOf(aC), gVar);
        com.tencent.mm.av.q.bcS().a(gVar.localId, caVar.field_msgId, i3, hashMap, R.drawable.c3h, new e.a() {
            /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass10 */

            @Override // com.tencent.mm.av.e.a
            public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, q qVar) {
            }

            @Override // com.tencent.mm.av.e.a
            public final void a(long j2, long j3, int i2, int i3, Object obj, int i4, int i5, String str, q qVar) {
                HashMap hashMap;
                AppMethodBeat.i(39269);
                boolean z = i4 == 0 && i5 == 0;
                if ((obj instanceof HashMap) && (hashMap = (HashMap) obj) != null) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        Long l = (Long) entry.getKey();
                        MsgRetransmitUI.this.fileName = com.tencent.mm.av.q.bcR().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g) entry.getValue()), "", "");
                        if (z) {
                            bg.aVF();
                            com.tencent.mm.model.c.aSQ().Hc(l.longValue());
                            MsgRetransmitUI.a(MsgRetransmitUI.this, str2, i2, str3, str, MsgRetransmitUI.this.iYO, j2);
                        }
                    }
                }
                AppMethodBeat.o(39269);
            }

            @Override // com.tencent.mm.av.e.a
            public final void a(long j2, long j3, int i2, int i3, Object obj) {
            }
        });
        AppMethodBeat.o(39303);
    }

    private void a(String str, int i2, String str2, String str3, j jVar, long j2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(39304);
        if (!Util.isNullOrNil(this.fileName)) {
            this.Qyp = 1;
            this.Qyq = 1;
            if (!bnU(this.fileName)) {
                AppMethodBeat.o(39304);
                return;
            }
            if (this.iXp == 1 && !z.f(this.fileName, str, false)) {
                this.iXp = 0;
            }
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(106, 96, 1, false);
            o.e tc = o.a(o.d.jdL).tc(i2);
            tc.dRL = str2;
            tc.toUser = str;
            tc.iZt = this.fileName;
            tc.iXp = this.iXp;
            tc.jdS = jVar;
            tc.dQd = 0;
            tc.iXy = str3;
            tc.thumbPath = "";
            tc.jdV = true;
            tc.jdU = R.drawable.c3h;
            tc.jea = true;
            tc.jeb = this.Qyt;
            tc.dTj = this.longtitude;
            tc.latitude = this.latitude;
            tc.iZr = this.iZr;
            tc.jdX = j2;
            tc.jdW = this.msgId;
            tc.jdY = this.jsz;
            if (this.Qyl == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            tc.hmr = z2;
            tc.jdR = 19;
            o.b bdQ = tc.bdQ();
            this.Qym = (n) bdQ.jdJ;
            bdQ.execute();
            this.Qyn = true;
            Log.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.iXp));
            cf.aWl().f(cf.iFI, null);
            AppMethodBeat.o(39304);
            return;
        }
        if (this.Qyr) {
            this.Qyp++;
            if (!bnU(this.Qyo.get(0))) {
                AppMethodBeat.o(39304);
                return;
            }
            if (this.iXp == 1 && !z.f(this.Qyo.get(0), str, false)) {
                this.iXp = 0;
            }
            Log.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", Integer.valueOf(this.iXp));
            o.e tc2 = o.a(o.d.jdL).tc(i2);
            tc2.dRL = str2;
            tc2.toUser = str;
            tc2.iZt = this.Qyo.get(0);
            tc2.iXp = this.iXp;
            tc2.jdS = jVar;
            tc2.dQd = 0;
            tc2.iXy = str3;
            tc2.thumbPath = "";
            tc2.jdV = true;
            tc2.jdU = R.drawable.c3h;
            if (this.Qyl == 1) {
                z = true;
            } else {
                z = false;
            }
            tc2.hmr = z;
            tc2.jdR = 11;
            o.b bdQ2 = tc2.bdQ();
            this.Qym = (n) bdQ2.jdJ;
            this.Qyn = true;
            bdQ2.execute();
            cf.aWl().f(cf.iFI, null);
        }
        AppMethodBeat.o(39304);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0016] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean bnU(java.lang.String r7) {
        /*
            r2 = 0
            r6 = 39305(0x9989, float:5.5078E-41)
            r0 = 1
            r1 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            java.lang.String r3 = "MicroMsg.MsgRetransmitUI"
            java.lang.String r4 = "isImage called, fn:%s"
            java.lang.Object[] r5 = new java.lang.Object[r0]
            r5[r1] = r7
            com.tencent.mm.sdk.platformtools.Log.i(r3, r4, r5)
            java.io.InputStream r2 = com.tencent.mm.vfs.s.openRead(r7)     // Catch:{ FileNotFoundException -> 0x0037, all -> 0x0050 }
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch:{ FileNotFoundException -> 0x005c, all -> 0x0050 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x005c, all -> 0x0050 }
            r4 = 1
            r3.inJustDecodeBounds = r4     // Catch:{ FileNotFoundException -> 0x005c, all -> 0x0050 }
            r4 = 0
            com.tencent.mm.graphics.MMBitmapFactory.decodeStream(r2, r4, r3)     // Catch:{ FileNotFoundException -> 0x005c, all -> 0x0050 }
            int r4 = r3.outWidth     // Catch:{ FileNotFoundException -> 0x005c, all -> 0x0050 }
            if (r4 < 0) goto L_0x0035
            int r3 = r3.outHeight     // Catch:{ FileNotFoundException -> 0x005c, all -> 0x0050 }
            if (r3 < 0) goto L_0x0035
        L_0x002e:
            com.tencent.mm.sdk.platformtools.Util.qualityClose(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x0034:
            return r0
        L_0x0035:
            r0 = r1
            goto L_0x002e
        L_0x0037:
            r0 = move-exception
            r0 = r2
        L_0x0039:
            java.lang.String r2 = "MicroMsg.MsgRetransmitUI"
            java.lang.String r3 = "fn:%s not found."
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0059 }
            r5 = 0
            r4[r5] = r7     // Catch:{ all -> 0x0059 }
            com.tencent.mm.sdk.platformtools.Log.w(r2, r3, r4)     // Catch:{ all -> 0x0059 }
            com.tencent.mm.sdk.platformtools.Util.qualityClose(r0)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            r0 = r1
            goto L_0x0034
        L_0x0050:
            r0 = move-exception
            r1 = r0
        L_0x0052:
            com.tencent.mm.sdk.platformtools.Util.qualityClose(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            throw r1
        L_0x0059:
            r1 = move-exception
            r2 = r0
            goto L_0x0052
        L_0x005c:
            r0 = move-exception
            r0 = r2
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.MsgRetransmitUI.bnU(java.lang.String):boolean");
    }

    private static boolean cM(byte[] bArr) {
        AppMethodBeat.i(39306);
        Log.i("MicroMsg.MsgRetransmitUI", "isImage called, data[0-4]:[%d,%d,%d,%d,%d]", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]));
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (options.outWidth < 0 || options.outHeight < 0) {
            AppMethodBeat.o(39306);
            return false;
        }
        AppMethodBeat.o(39306);
        return true;
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        public List<String> Qza;
        boolean dFE;

        private b() {
            this.Qza = null;
            this.dFE = true;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static final class a extends AsyncTask<Object, Object, String> {
        public boolean QyQ;
        public String QyR;
        public boolean QyS = true;
        public boolean QyT = false;
        public boolean QyU = true;
        public eeq QyV = null;
        public b QyW = null;
        public int QyX;
        public d.a QyY = null;
        public boolean Qyi = false;
        public int Qyk;
        public Context context;
        public String ean;
        public String fileName;
        public String fqK;
        public int iFw;
        public int jqs;
        public String jsz;
        private MMHandler mHandler = new MMHandler(Looper.getMainLooper());
        public Dialog tipDialog;
        public String userName;

        public a() {
            AppMethodBeat.i(39285);
            AppMethodBeat.o(39285);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(String str) {
            boolean z;
            int i2;
            boolean z2;
            boolean z3;
            AppMethodBeat.i(39286);
            String str2 = str;
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            com.tencent.mm.modelvideo.o.bhj();
            boolean YS = com.tencent.mm.vfs.s.YS(t.Qw(str2));
            com.tencent.mm.modelvideo.o.bhj();
            String Qx = t.Qx(str2);
            boolean YS2 = com.tencent.mm.vfs.s.YS(Qx);
            if (this.QyQ) {
                if (YS) {
                    com.tencent.mm.vfs.s.deleteFile(str2);
                }
                if (YS2) {
                    com.tencent.mm.vfs.s.deleteFile(Qx);
                }
                if (this.context instanceof Activity) {
                    ((Activity) this.context).finish();
                }
                if (this.QyY != null) {
                    this.QyY.bIM();
                }
                AppMethodBeat.o(39286);
                return;
            }
            Log.d("MicroMsg.MsgRetransmitUI", "dkvideo videoIsExport :" + this.Qyk + ", videoMsgType :43 videoType : " + this.jqs);
            u.a(str2, this.iFw, this.userName, null, this.Qyk, "", 43, this.QyV, this.ean, this.QyX, this.jsz);
            if (u.QG(str2) != 0) {
                z = true;
            } else {
                z = false;
            }
            com.tencent.mm.modelvideo.s QN = u.QN(this.fileName);
            if (QN != null && QN.videoFormat == 2) {
                u.QS(str2);
            }
            com.tencent.mm.modelvideo.o.bhj();
            String Qw = t.Qw(str2);
            int i3 = 3;
            if (!Util.isNullOrNil(this.fileName) && this.fileName.contains("favorite")) {
                i3 = 7;
            }
            if (Util.isNullOrNil(this.fileName) || !this.fileName.contains("sns")) {
                i2 = i3;
            } else {
                i2 = 6;
            }
            com.tencent.mm.modelvideo.n.bhh().a("", Qw, this.userName, this.fqK, "", i2, 2);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10424, 43, 8, this.userName);
            if (this.QyW != null) {
                b bVar = this.QyW;
                String str3 = this.userName;
                if (!z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (bVar.Qza == null || !bVar.Qza.contains(str3)) {
                    z3 = false;
                } else {
                    bVar.Qza.remove(str3);
                    if (!z2) {
                        bVar.dFE = false;
                    }
                    if (bVar.Qza.size() == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
                if (!z3) {
                    if (this.context instanceof Activity) {
                        ((Activity) this.context).finish();
                    }
                    if (this.QyY != null) {
                        this.QyY.bIM();
                    }
                    AppMethodBeat.o(39286);
                    return;
                }
                z = !this.QyW.dFE;
            }
            if (this.QyS) {
                Intent intent = new Intent(this.context, ChattingUI.class);
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", this.userName);
                Context context2 = this.context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/ui/transmit/MsgRetransmitUI$CopyVideoTask", "onPostExecute", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context2.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/ui/transmit/MsgRetransmitUI$CopyVideoTask", "onPostExecute", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            if (this.Qyi && (this.context instanceof Activity)) {
                com.tencent.mm.ui.widget.snackbar.b.r((Activity) this.context, this.context.getString(!z ? R.string.dzo : R.string.gkm));
            }
            this.mHandler.postDelayed(new Runnable() {
                /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(39284);
                    if (a.this.QyT && (a.this.context instanceof Activity)) {
                        ((Activity) a.this.context).finish();
                    }
                    AppMethodBeat.o(39284);
                }
            }, 1800);
            if (this.QyY != null) {
                this.QyY.bIM();
            }
            AppMethodBeat.o(39286);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ String doInBackground(Object[] objArr) {
            int i2;
            AppMethodBeat.i(39287);
            String Qv = t.Qv(this.userName);
            com.tencent.mm.modelvideo.o.bhj();
            String Qx = t.Qx(Qv);
            if (this.QyU) {
                com.tencent.mm.vfs.s.nw(t.Qw(this.fileName), t.Qw(Qv));
                com.tencent.mm.vfs.s.nw(t.Qx(this.fileName), Qx);
            } else {
                com.tencent.mm.vfs.s.nw(this.fileName, t.Qw(Qv));
                com.tencent.mm.vfs.s.nw(this.QyR, Qx);
            }
            com.tencent.mm.modelvideo.s QN = u.QN(this.fileName);
            if (QN != null) {
                i2 = QN.status;
            } else {
                i2 = 0;
            }
            Log.i("MicroMsg.MsgRetransmitUI", "CopyVideoTask ori[%s] status[%d] new[%s]", this.fileName, Integer.valueOf(i2), Qv);
            Log.d("MicroMsg.MsgRetransmitUI", "newfileSize:%s, oldFileSzie: %s", Long.valueOf(com.tencent.mm.vfs.s.boW(t.Qw(Qv))), Long.valueOf(com.tencent.mm.vfs.s.boW(t.Qw(this.fileName))));
            AppMethodBeat.o(39287);
            return Qv;
        }
    }

    private void jY(List<String> list) {
        AppMethodBeat.i(39307);
        for (String str : list) {
            bnY(str);
        }
        if (this.Qyi) {
            com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.dzo));
        }
        this.mHandler.postDelayed(new Runnable() {
            /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(39270);
                MsgRetransmitUI.this.finish();
                AppMethodBeat.o(39270);
            }
        }, 1800);
        AppMethodBeat.o(39307);
    }

    private void gYg() {
        AppMethodBeat.i(39308);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(39273);
                com.tencent.mm.modelvideo.o.bho().a(MsgRetransmitUI.this.fileName, new t.a() {
                    /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass13.AnonymousClass1 */

                    @Override // com.tencent.mm.modelvideo.t.a
                    public final void a(t.a.C0460a aVar) {
                        AppMethodBeat.i(39272);
                        com.tencent.mm.modelvideo.s QN = u.QN(aVar.fileName);
                        if (QN != null && QN.status == 199) {
                            b bVar = new b((byte) 0);
                            bVar.Qza = new LinkedList();
                            bVar.Qza.addAll(MsgRetransmitUI.this.Qyf);
                            for (String str : MsgRetransmitUI.this.Qyf) {
                                Log.i("MicroMsg.MsgRetransmitUI", "copy video after download %s", str);
                                MsgRetransmitUI.a(MsgRetransmitUI.this, bVar, str);
                            }
                        }
                        AppMethodBeat.o(39272);
                    }
                });
                AppMethodBeat.o(39273);
            }
        }, "MicroMsg.MsgRetransmitUI");
        this.Qyi = false;
        AppMethodBeat.o(39308);
    }

    private void a(b bVar, String str) {
        int i2 = 0;
        AppMethodBeat.i(39309);
        Log.printInfoStack("MicroMsg.MsgRetransmitUI", "start copy video", new Object[0]);
        final a aVar = new a();
        getString(R.string.zb);
        this.gtM = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.ys), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass14 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(39274);
                aVar.QyQ = true;
                MsgRetransmitUI.this.finish();
                AppMethodBeat.o(39274);
            }
        });
        aVar.context = this;
        aVar.fileName = this.fileName;
        aVar.tipDialog = this.gtM;
        aVar.Qyk = this.Qyk;
        aVar.iFw = this.length;
        aVar.jqs = this.msgType;
        aVar.QyS = false;
        aVar.userName = str;
        aVar.QyT = true;
        aVar.Qyi = this.Qyi;
        aVar.QyW = bVar;
        com.tencent.mm.modelvideo.s QN = u.QN(this.fileName);
        if (!(QN == null || QN.jsw == null)) {
            Log.d("MicroMsg.MsgRetransmitUI", "msgRetrans streamvideo");
            aVar.QyV = QN.jsw;
            aVar.fqK = QN.getUser();
            aVar.QyX = QN.jso;
        }
        aVar.execute(new Object[0]);
        cf.aWl().f(cf.iFJ, null);
        if (this.msgId == -1) {
            AppMethodBeat.o(39309);
            return;
        }
        bg.aVF();
        ca Hb = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
        boolean Eq = ab.Eq(str);
        a.c cVar = Eq ? a.c.Chatroom : a.c.Chat;
        a.d dVar = this.Qyu ? a.d.Full : a.d.Samll;
        if (Eq) {
            i2 = v.Ie(str);
        }
        com.tencent.mm.ui.chatting.a.a(cVar, dVar, Hb, i2);
        AppMethodBeat.o(39309);
    }

    @Override // com.tencent.mm.ak.i
    @DoNotCheckLeakForActivities
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(39310);
        Log.i("MicroMsg.MsgRetransmitUI", "errType : %s, errCode : %s, errMsg : %s.", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar.getType() != 110 || !(qVar instanceof n)) {
            AppMethodBeat.o(39310);
            return;
        }
        n nVar = (n) qVar;
        if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false)) {
            String stringExtra = getIntent().getStringExtra("Retr_KSnsId");
            if (ab.Eq(nVar.dkV)) {
                vn vnVar = new vn();
                vnVar.ebK.dRS = stringExtra;
                EventCenter.instance.publish(vnVar);
            } else {
                vo voVar = new vo();
                voVar.ebL.dRS = stringExtra;
                EventCenter.instance.publish(voVar);
            }
        }
        if (this.Qyo == null || this.Qyo.size() <= 1) {
            if (this.Qyj != null) {
                this.Qyj.dismiss();
                Log.i("MicroMsg.MsgRetransmitUI", "uploadImgDialog dismissed : %s", this.Qyj.toString());
                this.Qyj = null;
            }
            this.Qyx--;
            if (this.Qyx <= 0 || !this.Qyw) {
                this.Qyn = false;
                bg.azz().b(110, this);
                if (this.Qyl != 0) {
                    finish();
                    if (this.Qyh && !this.Qyv) {
                        Intent intent = new Intent(this, ChattingUI.class);
                        intent.addFlags(67108864);
                        intent.putExtra("Chat_User", nVar.dkV);
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/transmit/MsgRetransmitUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/MsgRetransmitUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                }
            }
            AppMethodBeat.o(39310);
            return;
        }
        this.Qyo.remove(0);
        String str2 = nVar.dkV;
        if (Util.isNullOrNil(str2) && this.Qyf != null) {
            str2 = this.Qyf.get(0);
        }
        a(str2, 3, this.iYO);
        AppMethodBeat.o(39310);
    }

    private boolean a(final com.tencent.mm.av.g gVar, final ca caVar, final String str, final int i2, final String str2, final String str3) {
        final int i3;
        String str4;
        AppMethodBeat.i(39302);
        Map<String, String> parseXml = XmlParser.parseXml(gVar.iXy, "msg", null);
        if (parseXml == null) {
            Log.e("MicroMsg.MsgRetransmitUI", "parse cdnInfo failed. [%s]", gVar.iXy);
            AppMethodBeat.o(39302);
            return false;
        }
        final int i4 = gVar.iXp;
        if (i4 != 1) {
            i3 = 2;
            str4 = parseXml.get(".msg.img.$cdnmidimgurl");
        } else {
            i3 = 1;
            str4 = parseXml.get(".msg.img.$cdnbigimgurl");
        }
        Log.d("MicroMsg.MsgRetransmitUI", "cdntra read xml  comptype:%d url:[%s]", Integer.valueOf(i4), str4);
        if (Util.isNullOrNil(str4)) {
            Log.e("MicroMsg.MsgRetransmitUI", "cdntra get cdnUrlfailed.");
            AppMethodBeat.o(39302);
            return false;
        }
        String str5 = parseXml.get(".msg.img.$aeskey");
        if (Util.isNullOrNil(str5)) {
            Log.e("MicroMsg.MsgRetransmitUI", "cdntra get aes key failed.");
            AppMethodBeat.o(39302);
            return false;
        } else if (Util.isNullOrNil(com.tencent.mm.an.c.a("downimg", (long) gVar.iXu, caVar.field_talker, new StringBuilder().append(caVar.field_msgId).toString()))) {
            Log.w("MicroMsg.MsgRetransmitUI", "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(caVar.field_msgSvrId));
            AppMethodBeat.o(39302);
            return false;
        } else {
            final String str6 = parseXml.get(".msg.img.$md5");
            com.tencent.mm.i.g gVar2 = new com.tencent.mm.i.g();
            gVar2.taskName = "task_MsgRetransmitUI_2";
            gVar2.gqy = new g.a() {
                /* class com.tencent.mm.ui.transmit.MsgRetransmitUI.AnonymousClass8 */

                @Override // com.tencent.mm.i.g.a
                public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                    AppMethodBeat.i(39267);
                    if (dVar != null) {
                        if (dVar.field_exist_whencheck) {
                            Log.i("MicroMsg.MsgRetransmitUI", "support second !! sceneResult:[%s]", dVar);
                            MsgRetransmitUI.a(MsgRetransmitUI.this, dVar, caVar, i2, str2, str3, str, str6, i4);
                        } else {
                            Log.i("MicroMsg.MsgRetransmitUI", "not support second !! dealDownLoadImg");
                            MsgRetransmitUI.a(MsgRetransmitUI.this, gVar, caVar, str, i2, str2, str3);
                        }
                    }
                    AppMethodBeat.o(39267);
                    return 0;
                }

                @Override // com.tencent.mm.i.g.a
                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                @Override // com.tencent.mm.i.g.a
                public final byte[] f(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            gVar2.field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), str2, new StringBuilder().append(caVar.field_msgId).toString());
            gVar2.field_fileId = str4;
            gVar2.field_aesKey = str5;
            gVar2.field_filemd5 = str6;
            gVar2.field_fileType = i3;
            gVar2.field_talker = str2;
            gVar2.field_priority = com.tencent.mm.i.a.gpM;
            gVar2.field_svr_signature = "";
            gVar2.field_onlycheckexist = true;
            gVar2.field_trysafecdn = true;
            if (!com.tencent.mm.an.f.baQ().f(gVar2)) {
                Log.e("MicroMsg.MsgRetransmitUI", "check exist fail! download img before retransmit");
                AppMethodBeat.o(39302);
                return false;
            }
            AppMethodBeat.o(39302);
            return true;
        }
    }

    static /* synthetic */ void a(MsgRetransmitUI msgRetransmitUI, String str) {
        AppMethodBeat.i(39311);
        msgRetransmitUI.a(str, 4, (j) null);
        AppMethodBeat.o(39311);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0252  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.ui.transmit.MsgRetransmitUI r20, com.tencent.mm.i.d r21, com.tencent.mm.storage.ca r22, int r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, int r28) {
        /*
        // Method dump skipped, instructions count: 603
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.MsgRetransmitUI.a(com.tencent.mm.ui.transmit.MsgRetransmitUI, com.tencent.mm.i.d, com.tencent.mm.storage.ca, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int):void");
    }
}
