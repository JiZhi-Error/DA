package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.pg;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.appbrand.openmaterial.g;
import com.tencent.mm.plugin.appbrand.openmaterial.h;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.plugin.record.b.d;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class AppAttachDownloadUI extends MMSecDataActivity implements i, f.a, MStorage.IOnStorageChange {
    private f BGq;
    private MMImageView BtF;
    private AppBrandOpenMaterialCollection Jgy = null;
    private h Jgz = null;
    private com.tencent.mm.ui.chatting.multitask.b KvS;
    private String KvW = null;
    private g KvX = null;
    private long LzM;
    private RoundProgressBtn Pdf;
    private a Pdg;
    private View Pdh;
    private TextView Pdi;
    private TextView Pdj;
    private TextView Pdk;
    private j Pdl;
    private boolean Pdm;
    private k.b Pdn;
    private String Pdo;
    private boolean Pdp = false;
    private boolean Pdq = false;
    private boolean Pdr = true;
    private int Pds = 5000;
    private boolean Pdt = false;
    private int Pdu;
    private LinearLayout Pdv;
    private LinearLayout Pdw;
    private boolean Pdx = false;
    private LinearLayout Pdy;
    private ImageView Pdz;
    private String aesKey;
    private int appType;
    private String authKey;
    private String cdnURL;
    private String dRL;
    private ca dTX;
    private boolean dUo;
    private String dWG;
    private String fileName;
    private String filePath;
    private String gCr;
    private TextView kbe;
    private String mediaId;
    private long msgId;
    private e oXS = null;
    private String pkL;
    private int ppd;
    private int ppe;
    private com.tencent.mm.ui.widget.b.a pqr = null;
    private int qoX = 0;
    private o.g rJj = new o.g() {
        /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass4 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            String str;
            AppMethodBeat.i(232797);
            if (AppAttachDownloadUI.this.fileName.equals("")) {
                str = AppAttachDownloadUI.this.getString(R.string.fiv);
            } else {
                str = AppAttachDownloadUI.this.fileName;
            }
            ClipboardHelper.setText(MMApplicationContext.getContext(), null, str);
            com.tencent.mm.ui.base.h.cD(AppAttachDownloadUI.this, AppAttachDownloadUI.this.getString(R.string.ta));
            AppMethodBeat.o(232797);
        }
    };
    private int scene;
    private Button thI;
    private HandOffFile thY;
    private View.OnTouchListener tia = new View.OnTouchListener() {
        /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass5 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(232798);
            switch (motionEvent.getAction()) {
                case 0:
                    AppAttachDownloadUI.this.ppd = (int) motionEvent.getRawX();
                    AppAttachDownloadUI.this.ppe = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.o(232798);
            return false;
        }
    };
    private View.OnLongClickListener tib = new View.OnLongClickListener() {
        /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass6 */

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(232799);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$14", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            Log.d("MicroMsg.AppAttachDownloadUI", "onLongClick");
            if (AppAttachDownloadUI.this.pqr == null) {
                AppAttachDownloadUI.this.pqr = new com.tencent.mm.ui.widget.b.a(AppAttachDownloadUI.this.cWv());
            }
            AppAttachDownloadUI.this.pqr.a(view, AppAttachDownloadUI.this, AppAttachDownloadUI.this.rJj, AppAttachDownloadUI.this.ppd, AppAttachDownloadUI.this.ppe);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$14", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(232799);
            return true;
        }
    };

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AppAttachDownloadUI() {
        AppMethodBeat.i(34129);
        AppMethodBeat.o(34129);
    }

    static /* synthetic */ c F(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(258927);
        c gMB = appAttachDownloadUI.gMB();
        AppMethodBeat.o(258927);
        return gMB;
    }

    static /* synthetic */ boolean G(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(258928);
        boolean gMA = appAttachDownloadUI.gMA();
        AppMethodBeat.o(258928);
        return gMA;
    }

    static /* synthetic */ void R(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(258931);
        appAttachDownloadUI.gMC();
        AppMethodBeat.o(258931);
    }

    static /* synthetic */ void U(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(258932);
        appAttachDownloadUI.fP(8, 6);
        AppMethodBeat.o(258932);
    }

    static /* synthetic */ void a(AppAttachDownloadUI appAttachDownloadUI, int i2) {
        AppMethodBeat.i(258926);
        appAttachDownloadUI.alY(i2);
        AppMethodBeat.o(258926);
    }

    static /* synthetic */ boolean c(c cVar) {
        AppMethodBeat.i(258930);
        boolean b2 = b(cVar);
        AppMethodBeat.o(258930);
        return b2;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34130);
        super.onCreate(bundle);
        init();
        AppMethodBeat.o(34130);
    }

    private void init() {
        AppMethodBeat.i(34131);
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        if (!cPt()) {
            finish();
            AppMethodBeat.o(34131);
            return;
        }
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(com.tencent.mm.loader.j.b.aKM());
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        ao.cgO().add(this);
        initView();
        gMv();
        AppMethodBeat.o(34131);
    }

    private void gMv() {
        AppMethodBeat.i(232813);
        this.KvS = new com.tencent.mm.ui.chatting.multitask.b(new com.tencent.mm.plugin.multitask.a.b((MMActivity) super.getContext()));
        this.KvS.g(this.filePath, this.gCr, this.qoX, true);
        this.KvS.ni(this.gCr, this.fileName);
        this.thY.saveToMultiTaskInfo(this.KvS.Abp);
        AppMethodBeat.o(232813);
    }

    private boolean cPt() {
        String str;
        AppMethodBeat.i(34134);
        this.scene = getIntent().getIntExtra("scene", 0);
        this.msgId = getIntent().getLongExtra("app_msg_id", -1);
        this.Pdt = getIntent().getBooleanExtra("choose_way", false);
        this.Pdu = getIntent().getIntExtra("msg_type", 0);
        if (this.msgId == -1) {
            AppMethodBeat.o(34134);
            return false;
        }
        bg.aVF();
        this.dTX = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
        if (this.dTX == null || this.dTX.field_msgId == 0 || this.dTX.field_content == null) {
            if (gMw()) {
                MsgQuoteItem msgQuoteItem = (MsgQuoteItem) getIntent().getParcelableExtra("key_quoted_msg");
                if (msgQuoteItem == null) {
                    AppMethodBeat.o(34134);
                    return false;
                }
                this.dTX = new ca();
                this.dTX.setType(msgQuoteItem.type);
                this.dTX.yF(msgQuoteItem.zFI);
                this.dTX.Cy(msgQuoteItem.zFJ);
                this.dTX.BB(msgQuoteItem.zFM);
                this.dTX.setContent(msgQuoteItem.content);
                if (Util.isEqual(msgQuoteItem.zFK, z.aTY())) {
                    this.dTX.nv(1);
                }
            } else {
                AppMethodBeat.o(34134);
                return false;
            }
        }
        this.Pdm = ab.Eq(this.dTX.field_talker);
        this.dWG = this.dTX.field_content;
        if (this.Pdm && this.dTX.field_isSend == 0) {
            String str2 = this.dTX.field_content;
            if (this.Pdm && str2 != null) {
                str2 = bp.Kt(str2);
            }
            this.dWG = str2;
        }
        this.Pdn = k.b.HD(this.dWG);
        if (this.Pdn == null) {
            Log.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", this.dWG);
            AppMethodBeat.o(34134);
            return false;
        }
        if (af.isNullOrNil(this.Pdn.dCK) && !af.isNullOrNil(this.Pdn.iwW)) {
            Log.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", this.dWG);
            this.Pdn.dCK = new StringBuilder().append(this.Pdn.iwW.hashCode()).toString();
        }
        this.appType = this.Pdn.type;
        this.mediaId = this.Pdn.dCK;
        this.fileName = af.nullAsNil(this.Pdn.title);
        this.gCr = af.nullAsNil(this.Pdn.iwJ).toLowerCase();
        this.LzM = (long) this.Pdn.iwI;
        this.pkL = af.nullAsNil(this.Pdn.filemd5);
        this.dRL = af.nullAsNil(this.Pdn.dRL);
        this.cdnURL = af.nullAsNil(this.Pdn.iwW);
        this.Pdo = af.nullAsNil(this.Pdn.iwN);
        this.aesKey = af.nullAsNil(this.Pdn.aesKey);
        this.authKey = af.nullAsNil(this.Pdn.iwT);
        if (af.isNullOrNil(this.gCr)) {
            this.gCr = s.akC(this.fileName);
        }
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", Long.valueOf(this.msgId), Integer.valueOf(this.dTX.field_isSend), this.dWG, Integer.valueOf(this.appType), this.mediaId, this.fileName);
        c gMB = gMB();
        if (gMB == null) {
            Log.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
            this.Pdq = false;
        } else {
            this.filePath = gMB.field_fileFullPath;
            new com.tencent.mm.vfs.o(gMB.field_fileFullPath);
            if (gMB.field_offset > 0) {
                this.Pdq = true;
            } else {
                this.Pdq = false;
            }
            Log.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", gMB.field_fileFullPath, Long.valueOf(gMB.field_offset), Boolean.valueOf(this.Pdq));
        }
        if (this.Pdn.type == 6) {
            ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).Z(String.valueOf(this.dTX.field_msgId), this.dTX.field_msgSvrId);
        }
        fP(4, 0);
        String nullAsNil = af.nullAsNil(z.aTY());
        String nullAsNil2 = af.nullAsNil(this.dTX.field_talker);
        if (ab.Eq(nullAsNil2)) {
            nullAsNil2 = af.nullAsNil(this.Pdn.dRL);
        }
        String str3 = this.dTX.field_isSend == 1 ? nullAsNil : nullAsNil2;
        if (this.dTX.field_isSend == 1) {
            str = nullAsNil2;
        } else {
            str = nullAsNil;
        }
        this.thY = new HandOffFile(af.nullAsNil(this.filePath), this.gCr, this.fileName, this.pkL, this.LzM, 1, Long.toString(this.dTX.field_msgSvrId), "", !af.isNullOrNil(this.cdnURL) ? this.cdnURL : this.Pdo, this.aesKey, this.authKey, 1, "", 0, "", 0, 1, str3, str);
        this.thY.setFileStatus(b(gMB()) ? 1 : 2);
        ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).g(this.thY);
        ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).c(this.thY);
        ach ach = new ach();
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_multi_task_common_info");
        if (byteArrayExtra != null) {
            try {
                ach.parseFrom(byteArrayExtra);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppAttachDownloadUI", e2, "", new Object[0]);
            }
        }
        if (b(gMB)) {
            if (this.scene == 3) {
                Intent intent = new Intent();
                intent.putExtra("filePath", this.filePath);
                intent.putExtra(DownloadInfo.FILENAME, this.fileName);
                intent.putExtra("fileExt", this.gCr);
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(34134);
                return true;
            } else if (this.scene == 1) {
                this.qoX = 7;
                if (this.Pdt) {
                    boolean c2 = com.tencent.mm.pluginsdk.ui.tools.a.c(this, gMB.field_fileFullPath, this.gCr, this.qoX);
                    AppMethodBeat.o(34134);
                    return c2;
                }
                boolean a2 = com.tencent.mm.pluginsdk.ui.tools.a.a(gMB.field_fileFullPath, this.gCr, this.qoX, ach);
                AppMethodBeat.o(34134);
                return a2;
            } else {
                if (this.qoX != 9) {
                    this.qoX = 1;
                }
                if (this.Pdt) {
                    boolean c3 = com.tencent.mm.pluginsdk.ui.tools.a.c(this, gMB.field_fileFullPath, this.gCr, this.qoX);
                    AppMethodBeat.o(34134);
                    return c3;
                } else if (!com.tencent.mm.pluginsdk.ui.tools.a.mE(gMB.field_fileFullPath, this.gCr)) {
                    boolean a3 = com.tencent.mm.pluginsdk.ui.tools.a.a(gMB.field_fileFullPath, this.gCr, this.qoX, ach);
                    AppMethodBeat.o(34134);
                    return a3;
                }
            }
        }
        AppMethodBeat.o(34134);
        return true;
    }

    public final MMActivity cWv() {
        AppMethodBeat.i(258924);
        MMActivity mMActivity = (MMActivity) super.getContext();
        AppMethodBeat.o(258924);
        return mMActivity;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(34136);
        ao.cgO().remove(this);
        super.onDestroy();
        if (this.thY != null) {
            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).d(this.thY);
        }
        AppMethodBeat.o(34136);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(34137);
        super.onResume();
        bg.azz().a(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, this);
        bg.azz().a(728, this);
        pg pgVar = new pg();
        pgVar.dVo.pause = true;
        pgVar.dVo.talker = this.dTX.field_talker;
        EventCenter.instance.asyncPublish(pgVar, getMainLooper());
        Log.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
        this.thI.setEnabled(true);
        if (this.KvS != null) {
            this.KvS.bCA();
        }
        AppMethodBeat.o(34137);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        String str;
        AppMethodBeat.i(34138);
        bg.azz().b(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, this);
        bg.azz().b(728, this);
        super.onPause();
        if (this.KvS != null) {
            this.KvS.aGj();
        }
        pg pgVar = new pg();
        pgVar.dVo.pause = false;
        pg.a aVar = pgVar.dVo;
        if (this.dTX == null) {
            str = "";
        } else {
            str = this.dTX.field_talker;
        }
        aVar.talker = str;
        EventCenter.instance.asyncPublish(pgVar, getMainLooper());
        Log.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
        AppMethodBeat.o(34138);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        TextPaint paint;
        AppMethodBeat.i(34139);
        this.BtF = (MMImageView) findViewById(R.id.buq);
        this.Pdf = (RoundProgressBtn) findViewById(R.id.h9i);
        this.Pdg = new a((Button) findViewById(R.id.bts), (TextView) findViewById(R.id.btt));
        this.thI = (Button) findViewById(R.id.bu_);
        this.Pdh = findViewById(R.id.btu);
        this.kbe = (TextView) findViewById(R.id.bu2);
        this.Pdi = (TextView) findViewById(R.id.btv);
        this.Pdj = (TextView) findViewById(R.id.bu0);
        this.Pdk = (TextView) findViewById(R.id.bu1);
        this.Pdv = (LinearLayout) findViewById(R.id.bu4);
        this.Pdw = (LinearLayout) findViewById(R.id.eox);
        this.Pdy = (LinearLayout) findViewById(R.id.bu6);
        this.Pdz = (ImageView) findViewById(R.id.bu5);
        this.Pdz.setImageDrawable(ar.m(this, R.raw.icons_filled_mini_program, getResources().getColor(R.color.gt)));
        this.Pdy.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(232795);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.d("MicroMsg.AppAttachDownloadUI", "MoreOpenWaysArea#onClick");
                if (AppAttachDownloadUI.this.KvX != null) {
                    AppAttachDownloadUI.this.KvX.bPY();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232795);
            }
        });
        this.Pdj.setOnTouchListener(this.tia);
        this.Pdj.setOnLongClickListener(this.tib);
        if (!(this.Pdj == null || (paint = this.Pdj.getPaint()) == null)) {
            paint.setFakeBoldText(true);
        }
        this.Pdf.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(34115);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AppAttachDownloadUI.a(AppAttachDownloadUI.this, 8);
                AppAttachDownloadUI.this.Pdg.setVisibility(0);
                AppAttachDownloadUI.this.Pdh.setVisibility(8);
                Log.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar downloadAppAttachScene[%s]", AppAttachDownloadUI.this.BGq);
                if (AppAttachDownloadUI.this.BGq != null) {
                    AppAttachDownloadUI.this.BGq.a(AppAttachDownloadUI.this);
                    com.tencent.mm.kernel.g.azz().a(AppAttachDownloadUI.this.BGq);
                } else {
                    c F = AppAttachDownloadUI.F(AppAttachDownloadUI.this);
                    if (!(F == null || F.field_status == 199)) {
                        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp roundProgressBar onClick but scene is null and set status[%d] paused", Long.valueOf(F.field_status));
                        F.field_status = 102;
                        ao.cgO().a(F, new String[0]);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(34115);
            }
        });
        this.Pdg.ubX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(232796);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
                AppAttachDownloadUI.this.Pdg.setVisibility(8);
                if (AppAttachDownloadUI.G(AppAttachDownloadUI.this)) {
                    c F = AppAttachDownloadUI.F(AppAttachDownloadUI.this);
                    if (F != null) {
                        F.field_status = 101;
                        F.field_lastModifyTime = Util.nowSecond();
                        ao.cgO().a(F, new String[0]);
                    }
                    AppAttachDownloadUI.this.BGq = new f(AppAttachDownloadUI.this.msgId, AppAttachDownloadUI.this.mediaId, AppAttachDownloadUI.this.Pdl);
                    bg.azz().a(AppAttachDownloadUI.this.BGq, 0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232796);
            }
        });
        this.thI.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(232800);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppAttachDownloadUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                AppAttachDownloadUI.this.Pdr = true;
                AppAttachDownloadUI.Q(AppAttachDownloadUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232800);
            }
        });
        switch (this.appType) {
            case 0:
            case 7:
                if (!Util.isImageExt(this.gCr)) {
                    this.BtF.setImageResource(R.raw.app_attach_file_icon_unknow);
                    break;
                } else {
                    this.BtF.setImageResource(R.drawable.bxc);
                    break;
                }
            case 1:
            case 3:
            case 5:
            default:
                this.BtF.setImageResource(R.raw.app_attach_file_icon_unknow);
                break;
            case 2:
                this.BtF.setImageResource(R.drawable.bxc);
                break;
            case 4:
                this.BtF.setImageResource(R.raw.app_attach_file_icon_video);
                break;
            case 6:
                this.BtF.setImageResource(r.bdt(this.gCr));
                break;
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass10 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34118);
                if (AppAttachDownloadUI.this.BGq != null) {
                    bg.azz().a(AppAttachDownloadUI.this.BGq);
                }
                if (AppAttachDownloadUI.this.KvS == null || !AppAttachDownloadUI.this.KvS.O(1, false)) {
                    AppAttachDownloadUI.this.finish();
                    AppMethodBeat.o(34118);
                } else {
                    AppMethodBeat.o(34118);
                }
                return true;
            }
        });
        this.dUo = getIntent().getBooleanExtra("app_show_share", true);
        if (this.dUo) {
            addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass11 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(232803);
                    AppAttachDownloadUI.a(AppAttachDownloadUI.this, AppAttachDownloadUI.this.Pdp);
                    AppMethodBeat.o(232803);
                    return false;
                }
            });
        }
        this.Pdp = false;
        if (!gMw() || this.dTX.field_msgId != 0) {
            c gMB = gMB();
            if (gMB == null || !new com.tencent.mm.vfs.o(gMB.field_fileFullPath).exists()) {
                z = false;
            } else {
                z = gMB.deQ() || (this.dTX.field_isSend == 1 && gMB.field_isUpload);
            }
            if (z) {
                Log.i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
                if (this.LzM > 0) {
                    this.Pdk.setVisibility(0);
                    this.Pdk.setText(getResources().getString(R.string.ceh, af.getSizeKB(this.LzM)));
                } else {
                    this.Pdk.setVisibility(8);
                }
                this.Pdp = true;
                gMC();
                AppMethodBeat.o(34139);
                return;
            }
            if (this.LzM > 0) {
                this.Pdk.setVisibility(0);
                this.Pdk.setText(getResources().getString(R.string.ceh, af.getSizeKB(this.LzM)));
            } else {
                this.Pdk.setVisibility(8);
            }
            if (this.Pdp) {
                AppMethodBeat.o(34139);
                return;
            }
            this.Pdl = new j() {
                /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass17 */

                @Override // com.tencent.mm.ak.j
                public final void a(int i2, int i3, q qVar) {
                    float f2;
                    AppMethodBeat.i(232810);
                    if (i3 == 0) {
                        f2 = 0.0f;
                    } else {
                        f2 = (((float) i2) * 100.0f) / ((float) i3);
                    }
                    if (i2 < i3 && AppAttachDownloadUI.this.Pdf.getVisibility() != 0) {
                        AppAttachDownloadUI.a(AppAttachDownloadUI.this, 0);
                        AppAttachDownloadUI.this.Pdg.setVisibility(8);
                    }
                    AppAttachDownloadUI.this.Pdf.setProgress((int) f2);
                    AppMethodBeat.o(232810);
                }
            };
            switch (this.appType) {
                case 0:
                case 6:
                    if (this.Pdq) {
                        this.Pdg.setVisibility(0);
                    } else {
                        this.Pdg.setVisibility(8);
                    }
                    alY(8);
                    this.Pdh.setVisibility(8);
                    this.thI.setVisibility(8);
                    Log.d("MicroMsg.AppAttachDownloadUI", "hide moreOpenWaysArea");
                    this.Pdy.setVisibility(4);
                    gMG();
                    this.Pdj.setVisibility(0);
                    if (this.fileName.equals("")) {
                        this.Pdj.setText(getString(R.string.fiv));
                    } else {
                        this.Pdj.setText(this.fileName);
                    }
                    String mimeType = getMimeType();
                    if (mimeType == null || mimeType.equals("")) {
                        this.kbe.setText(getString(R.string.bnj));
                    } else {
                        this.kbe.setText(getString(R.string.bnk));
                    }
                    if (Util.isImageExt(this.gCr)) {
                        gMG();
                        break;
                    }
                    break;
                case 2:
                    alY(8);
                    this.Pdh.setVisibility(8);
                    if (this.Pdq) {
                        this.Pdg.setVisibility(0);
                    } else {
                        this.Pdg.setVisibility(8);
                    }
                    this.thI.setVisibility(8);
                    Log.d("MicroMsg.AppAttachDownloadUI", "hide moreOpenWaysArea");
                    this.Pdy.setVisibility(4);
                    this.Pdj.setVisibility(8);
                    gMG();
                    break;
                case 7:
                    if (this.Pdq) {
                        this.Pdg.setVisibility(0);
                    } else {
                        this.Pdg.setVisibility(8);
                    }
                    alY(8);
                    this.Pdh.setVisibility(8);
                    this.thI.setVisibility(8);
                    Log.d("MicroMsg.AppAttachDownloadUI", "hide moreOpenWaysArea");
                    this.Pdy.setVisibility(4);
                    this.Pdj.setVisibility(8);
                    gMG();
                    this.kbe.setText(getString(R.string.bnk));
                    break;
            }
            Log.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", this.Pdl, Boolean.valueOf(this.Pdp), Boolean.valueOf(this.Pdq));
            if (this.appType == 2 || (!this.Pdp && !this.Pdq)) {
                gMz();
            }
            AppMethodBeat.o(34139);
            return;
        }
        this.Pdk.setVisibility(8);
        this.Pdj.setVisibility(0);
        if (this.fileName.equals("")) {
            this.Pdj.setText(getString(R.string.fiv));
        } else {
            this.Pdj.setText(this.fileName);
        }
        gMF();
        if (this.scene == 3) {
            Intent intent = new Intent();
            intent.putExtra("resLoadFailed", true);
            setResult(-1, intent);
            finish();
        }
        AppMethodBeat.o(34139);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(34140);
        Log.i("MicroMsg.AppAttachDownloadUI", "onKeyDown keyCode %d", Integer.valueOf(i2));
        if (i2 != 4 || this.KvS == null || !this.KvS.O(2, false)) {
            boolean onKeyDown = super.onKeyDown(i2, keyEvent);
            AppMethodBeat.o(34140);
            return onKeyDown;
        }
        AppMethodBeat.o(34140);
        return true;
    }

    private boolean gMw() {
        if (this.Pdu == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class b implements com.tencent.mm.plugin.appbrand.openmaterial.i {
        private final WeakReference<AppAttachDownloadUI> Kwe;
        private final com.tencent.mm.plugin.appbrand.service.i Kwf;
        private final MaterialModel nlD;

        public b(AppAttachDownloadUI appAttachDownloadUI, MaterialModel materialModel, com.tencent.mm.plugin.appbrand.service.i iVar) {
            AppMethodBeat.i(232811);
            this.Kwe = new WeakReference<>(appAttachDownloadUI);
            this.nlD = materialModel;
            this.Kwf = iVar;
            AppMethodBeat.o(232811);
        }

        @Override // com.tencent.mm.plugin.appbrand.openmaterial.i
        public final void a(boolean z, AppBrandOpenMaterialCollection appBrandOpenMaterialCollection) {
            boolean z2;
            AppMethodBeat.i(232812);
            Log.d("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot");
            AppAttachDownloadUI appAttachDownloadUI = this.Kwe.get();
            if (appAttachDownloadUI == null) {
                Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, ui is null");
                AppMethodBeat.o(232812);
            } else if (!z) {
                Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, fail");
                AppMethodBeat.o(232812);
            } else {
                appAttachDownloadUI.KvW = this.nlD.nlI;
                appAttachDownloadUI.Jgy = appBrandOpenMaterialCollection;
                if (!appAttachDownloadUI.Pdp || appBrandOpenMaterialCollection.nlF.isEmpty()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials#onMyOpenMaterialsGot, not need enhance");
                    AppMethodBeat.o(232812);
                    return;
                }
                if (appAttachDownloadUI.KvX != null) {
                    appAttachDownloadUI.KvX.dead();
                }
                appAttachDownloadUI.KvX = this.Kwf.bQa().b(com.tencent.mm.plugin.appbrand.openmaterial.model.b.ATTACH).a(appAttachDownloadUI, appAttachDownloadUI.oXS, appAttachDownloadUI.Jgy);
                if (appAttachDownloadUI.oXS != null) {
                    if (appAttachDownloadUI.Jgz != null) {
                        appAttachDownloadUI.Jgz.dead();
                    }
                    appAttachDownloadUI.Jgz = this.Kwf.a(com.tencent.mm.plugin.appbrand.openmaterial.model.b.ATTACH, appAttachDownloadUI, appAttachDownloadUI.oXS, appAttachDownloadUI.Jgy, appAttachDownloadUI.KvX, null);
                }
                Log.d("MicroMsg.AppAttachDownloadUI", "show moreOpenWaysArea");
                appAttachDownloadUI.Pdy.setVisibility(0);
                AppMethodBeat.o(232812);
            }
        }
    }

    private void gMx() {
        AppMethodBeat.i(232815);
        Log.d("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials");
        if (af.isNullOrNil(this.filePath)) {
            Log.w("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, filePath is empty");
            AppMethodBeat.o(232815);
        } else if (!this.filePath.equals(this.KvW) || this.Jgy == null) {
            MaterialModel eC = MaterialModel.eC(this.filePath, this.gCr);
            if (eC == null) {
                Log.w("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, materialModel is null");
                AppMethodBeat.o(232815);
                return;
            }
            com.tencent.mm.plugin.appbrand.service.i iVar = (com.tencent.mm.plugin.appbrand.service.i) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.i.class);
            if (iVar == null) {
                Log.w("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, openMaterialService is null");
                AppMethodBeat.o(232815);
            } else if (!iVar.c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.ATTACH)) {
                Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, openMaterialService is not enabled");
                AppMethodBeat.o(232815);
            } else if (!iVar.adl(eC.mimeType)) {
                Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, openMaterialService is not support " + eC.mimeType);
                AppMethodBeat.o(232815);
            } else {
                iVar.a(eC, new b(this, eC, iVar));
                AppMethodBeat.o(232815);
            }
        } else {
            Log.i("MicroMsg.AppAttachDownloadUI", "loadOpenMaterials, already load");
            AppMethodBeat.o(232815);
        }
    }

    private void gMy() {
        AppMethodBeat.i(34141);
        cz czVar = new cz();
        com.tencent.mm.pluginsdk.model.h.d(czVar, this.dTX);
        czVar.dFZ.activity = this;
        czVar.dFZ.dGf = 39;
        EventCenter.instance.publish(czVar);
        AppMethodBeat.o(34141);
    }

    private void gMz() {
        AppMethodBeat.i(34143);
        alY(0);
        this.Pdg.setVisibility(8);
        if (gMA()) {
            Log.i("MicroMsg.AppAttachDownloadUI", "startToDownloadFile");
            this.BGq = new f(this.msgId, this.mediaId, this.Pdl);
            bg.azz().a(this.BGq, 0);
            com.tencent.mm.modelsimple.ab.ab(this.dTX);
            fP(7, 1);
        }
        AppMethodBeat.o(34143);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(34144);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 0, 0, getString(R.string.t_));
        AppMethodBeat.o(34144);
    }

    private boolean gMA() {
        boolean z;
        boolean z2;
        int i2 = -1;
        boolean z3 = true;
        AppMethodBeat.i(34145);
        c gMB = gMB();
        if (gMB == null) {
            m.E(this.msgId, this.dWG);
            gMB = gMB();
            if (gMB != null) {
                Object[] objArr = new Object[8];
                objArr[0] = Long.valueOf(gMB.systemRowid);
                objArr[1] = Long.valueOf(gMB.field_totalLen);
                objArr[2] = gMB.field_fileFullPath;
                objArr[3] = Long.valueOf(gMB.field_type);
                objArr[4] = gMB.field_mediaId;
                objArr[5] = Long.valueOf(gMB.field_msgInfoId);
                objArr[6] = Boolean.valueOf(gMB.field_isUpload);
                if (gMB.field_signature != null) {
                    i2 = gMB.field_signature.length();
                }
                objArr[7] = Integer.valueOf(i2);
                Log.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]", objArr);
                if (this.Pdn.iwM != 0 || this.Pdn.iwI > 26214400) {
                    if (!af.isNullOrNil(gMB.field_signature)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z2;
                }
            }
        } else {
            com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(gMB.field_fileFullPath);
            if (gMB.field_status == 199 && !oVar.exists()) {
                Log.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
                m.E(this.msgId, this.dWG);
            }
            Object[] objArr2 = new Object[10];
            objArr2[0] = Long.valueOf(gMB.systemRowid);
            objArr2[1] = Long.valueOf(gMB.field_totalLen);
            objArr2[2] = gMB.field_fileFullPath;
            objArr2[3] = Long.valueOf(gMB.field_type);
            objArr2[4] = gMB.field_mediaId;
            objArr2[5] = Long.valueOf(gMB.field_msgInfoId);
            objArr2[6] = Boolean.valueOf(gMB.field_isUpload);
            objArr2[7] = Boolean.valueOf(oVar.exists());
            objArr2[8] = Long.valueOf(gMB.field_status);
            if (gMB.field_signature != null) {
                i2 = gMB.field_signature.length();
            }
            objArr2[9] = Integer.valueOf(i2);
            Log.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]", objArr2);
        }
        if (this.Pdn == null || (this.Pdn.iwM == 0 && this.Pdn.iwI <= 26214400)) {
            z = z3;
        } else {
            z = false;
        }
        if (!z) {
            bg.azz().a(new d(gMB, this.aesKey, this.pkL, this.fileName, this.gCr, this.dRL), 0);
        }
        if (gMB != null) {
            this.filePath = gMB.field_fileFullPath;
            gMv();
        }
        AppMethodBeat.o(34145);
        return z;
    }

    private String getMimeType() {
        AppMethodBeat.i(34146);
        k.b HD = k.b.HD(this.dWG);
        String str = null;
        if (HD.iwJ != null && HD.iwJ.length() > 0) {
            str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(HD.iwJ);
        }
        if (str == null || str.length() == 0) {
            Log.w("MicroMsg.AppAttachDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
            str = "*/" + HD.iwJ;
        }
        AppMethodBeat.o(34146);
        return str;
    }

    private c gMB() {
        AppMethodBeat.i(34147);
        final c Mp = ao.cgO().Mp(this.msgId);
        if (Mp != null) {
            Log.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", Long.valueOf(this.msgId), af.blN());
            AppMethodBeat.o(34147);
        } else {
            Mp = m.bdJ(this.mediaId);
            if (Mp == null) {
                Log.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", af.blN());
                AppMethodBeat.o(34147);
            } else if (Mp.field_msgInfoId == this.msgId || s.YS(Mp.field_fileFullPath)) {
                AppMethodBeat.o(34147);
            } else {
                m.E(this.msgId, this.dWG);
                final c Mp2 = ao.cgO().Mp(this.msgId);
                if (Mp2 == null) {
                    Log.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", af.blN());
                    AppMethodBeat.o(34147);
                } else {
                    ThreadPool.post(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass8 */

                        public final void run() {
                            boolean z;
                            AppMethodBeat.i(232801);
                            long currentTimeMillis = System.currentTimeMillis();
                            long nw = s.nw(Mp.field_fileFullPath, Mp2.field_fileFullPath);
                            if (nw > 0) {
                                Mp2.field_offset = nw;
                                if (AppAttachDownloadUI.c(Mp2)) {
                                    Mp2.field_status = 199;
                                }
                                z = ao.cgO().a(Mp2, new String[0]);
                            } else {
                                z = false;
                            }
                            Log.i("MicroMsg.AppAttachDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", Long.valueOf(nw), Long.valueOf(Mp.field_msgInfoId), Long.valueOf(Mp2.field_msgInfoId), Boolean.valueOf(z), Long.valueOf(Mp2.field_status), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            AppMethodBeat.o(232801);
                        }
                    }, "copyAttachFromLocal");
                    AppMethodBeat.o(34147);
                }
            }
        }
        return Mp;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(34148);
        super.onActivityResult(i2, i3, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i2, i3, intent, this.Pdr, (int) R.string.bny, (int) R.string.bnz, 1);
        AppMethodBeat.o(34148);
    }

    private void gMC() {
        AppMethodBeat.i(34150);
        switch (this.appType) {
            case 0:
            case 6:
                if (gMD()) {
                    if (!Util.isImageExt(this.gCr)) {
                        String mimeType = getMimeType();
                        Log.i("MicroMsg.AppAttachDownloadUI", "onDownLoadImpl");
                        gMG();
                        alY(8);
                        this.Pdh.setVisibility(8);
                        this.Pdg.setVisibility(8);
                        this.Pdj.setVisibility(0);
                        if (this.fileName.equals("")) {
                            this.Pdj.setText(getString(R.string.fiv));
                        } else {
                            this.Pdj.setText(this.fileName);
                        }
                        if (mimeType != null && !mimeType.equals("")) {
                            this.thI.setVisibility(0);
                            this.kbe.setText(getString(R.string.bnk));
                            break;
                        } else {
                            this.thI.setVisibility(8);
                            this.kbe.setText(getString(R.string.bnj));
                            break;
                        }
                    } else {
                        gME();
                        break;
                    }
                }
                break;
            case 1:
            case 3:
            case 4:
            case 5:
            default:
                this.thI.setVisibility(0);
                alY(8);
                this.Pdh.setVisibility(8);
                break;
            case 2:
                if (gMD()) {
                    dGU();
                    break;
                }
                break;
            case 7:
                Intent intent = new Intent();
                intent.putExtra("App_MsgId", this.msgId);
                setResult(-1, intent);
                finish();
                break;
        }
        if (this.thY.getFileStatus() != 1) {
            this.thY.setFileStatus(1);
            c gMB = gMB();
            if (gMB != null) {
                this.thY.setFullPath(af.nullAsNil(gMB.field_fileFullPath));
            }
            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).g(this.thY);
            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.thY);
        }
        gMx();
        AppMethodBeat.o(34150);
    }

    private boolean gMD() {
        AppMethodBeat.i(34151);
        c gMB = gMB();
        if (gMB == null) {
            AppMethodBeat.o(34151);
            return true;
        } else if (s.YS(gMB.field_fileFullPath)) {
            alY(8);
            this.Pdh.setVisibility(8);
            this.Pdg.setVisibility(8);
            AppMethodBeat.o(34151);
            return true;
        } else {
            alY(8);
            gMF();
            if (this.scene == 3) {
                Intent intent = new Intent();
                intent.putExtra("resLoadFailed", true);
                setResult(-1, intent);
                finish();
            }
            AppMethodBeat.o(34151);
            return false;
        }
    }

    private void gME() {
        AppMethodBeat.i(34152);
        c gMB = gMB();
        if (gMB == null) {
            Log.e("MicroMsg.AppAttachDownloadUI", "info == null");
            AppMethodBeat.o(34152);
            return;
        }
        Intent intent = new Intent(this, ShowImageUI.class);
        intent.putExtra("key_message_id", this.dTX.field_msgId);
        intent.putExtra("key_image_path", gMB.field_fileFullPath);
        intent.putExtra("key_favorite", true);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        AppMethodBeat.o(34152);
    }

    private void dGU() {
        AppMethodBeat.i(34153);
        Log.i("MicroMsg.AppAttachDownloadUI", "[ImageGalleryUI] showImage");
        Intent intent = new Intent(this, ImageGalleryUI.class);
        intent.putExtra("img_gallery_msg_id", this.dTX.field_msgId);
        intent.putExtra("img_gallery_talker", this.dTX.field_talker);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showImage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        overridePendingTransition(0, 0);
        AppMethodBeat.o(34153);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a07;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(34154);
        Log.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar.getType() != 221 && qVar.getType() != 728) {
            AppMethodBeat.o(34154);
        } else if (qVar.getType() == 728 && i2 == 0 && i3 == 0) {
            c gMB = gMB();
            if (gMB == null) {
                Log.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
            } else {
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(gMB.field_signature == null ? -1 : gMB.field_signature.length());
                Log.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach", objArr);
            }
            if (gMB != null) {
                gMB.field_status = 101;
                gMB.field_lastModifyTime = Util.nowSecond();
                ao.cgO().a(gMB, new String[0]);
            }
            this.BGq = new f(this.msgId, this.mediaId, this.Pdl);
            bg.azz().a(this.BGq, 0);
            AppMethodBeat.o(34154);
        } else {
            if (this.BGq == null && (qVar instanceof f)) {
                f fVar = (f) qVar;
                c gMB2 = gMB();
                if (gMB2 != null && !af.isNullOrNil(gMB2.field_mediaSvrId) && gMB2.field_mediaSvrId.equals(fVar.getMediaId())) {
                    this.BGq = fVar;
                    Log.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", this.BGq, gMB2.field_mediaSvrId);
                }
            }
            if (i2 == 0 && i3 == 0) {
                if (this.Pdn.type == 6) {
                    fP(0, 2);
                    c gMB3 = gMB();
                    if (gMB3 != null) {
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1203, 5, gMB3.field_totalLen, false);
                    }
                }
                AppMethodBeat.o(34154);
                return;
            }
            if (i3 != 0 && CrashReportFactory.hasDebuger()) {
                Toast.makeText(this, "errCode[" + i3 + "]", 0).show();
            }
            if (i3 == -5103059) {
                gMF();
                alY(8);
                fP(1, 3);
                if (this.scene == 3) {
                    Intent intent = new Intent();
                    intent.putExtra("resLoadFailed", true);
                    setResult(-1, intent);
                    finish();
                }
                AppMethodBeat.o(34154);
                return;
            }
            alY(8);
            this.Pdg.setVisibility(0);
            this.Pdh.setVisibility(8);
            Log.e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + qVar.getType() + " errType = " + i2 + ", errCode = " + i3);
            AppMethodBeat.o(34154);
        }
    }

    @Override // com.tencent.mm.plugin.record.b.f.a
    public final void eIn() {
        AppMethodBeat.i(34155);
        Toast.makeText(this, (int) R.string.bo2, 0).show();
        AppMethodBeat.o(34155);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(34156);
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.KvS != null) {
            this.KvS.aGj();
        }
        init();
        AppMethodBeat.o(34156);
    }

    private static boolean b(c cVar) {
        AppMethodBeat.i(34157);
        if (cVar == null) {
            AppMethodBeat.o(34157);
            return false;
        }
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(cVar.field_fileFullPath);
        if (!oVar.exists() || oVar.length() != cVar.field_totalLen) {
            AppMethodBeat.o(34157);
            return false;
        }
        AppMethodBeat.o(34157);
        return true;
    }

    private void alY(int i2) {
        AppMethodBeat.i(34158);
        if (i2 != this.Pdf.getVisibility()) {
            Log.i("MicroMsg.AppAttachDownloadUI", "setRoundProgressBar %s %s", Integer.valueOf(i2), af.blN());
            this.Pdf.setVisibility(i2);
        }
        AppMethodBeat.o(34158);
    }

    private void gMF() {
        AppMethodBeat.i(34159);
        this.Pdv.setVisibility(0);
        this.Pdw.setVisibility(8);
        gMG();
        this.Pdg.gMH();
        AppMethodBeat.o(34159);
    }

    private void gMG() {
        AppMethodBeat.i(34160);
        this.kbe.setVisibility(8);
        AppMethodBeat.o(34160);
    }

    /* access modifiers changed from: package-private */
    public class a {
        private boolean BIo;
        Button ubX;
        private TextView vr;

        public a(Button button, TextView textView) {
            AppMethodBeat.i(34126);
            this.ubX = button;
            this.vr = textView;
            if (textView != null) {
                Math.floor((((double) (((long) com.tencent.mm.n.h.aqJ().getInt("MsgFileExpiredInterval", 432000)) - cl.secondsToNow(AppAttachDownloadUI.this.dTX.field_createTime / 1000))) * 1.0d) / 86400.0d);
                textView.setText("");
            }
            AppMethodBeat.o(34126);
        }

        public final void setVisibility(int i2) {
            AppMethodBeat.i(34127);
            if (this.ubX != null) {
                this.ubX.setVisibility(i2);
            }
            if (this.vr != null) {
                this.vr.setVisibility(i2);
            }
            AppMethodBeat.o(34127);
        }

        public final void gMH() {
            AppMethodBeat.i(34128);
            Log.i("MicroMsg.AppAttachDownloadUI", "showErrorTip overtime %s", Long.valueOf(AppAttachDownloadUI.this.dTX.field_msgId));
            if (this.ubX != null) {
                this.ubX.setVisibility(4);
            }
            if (this.vr != null) {
                this.vr.setVisibility(0);
                this.vr.setText(R.string.ce2);
                this.vr.setTextColor(AppAttachDownloadUI.this.getResources().getColor(R.color.Red_120));
                AppAttachDownloadUI.this.kbe.setVisibility(8);
                AppAttachDownloadUI.this.Pdh.setVisibility(8);
                if (!this.BIo) {
                    this.BIo = true;
                    AppAttachDownloadUI.U(AppAttachDownloadUI.this);
                }
            }
            AppMethodBeat.o(34128);
        }
    }

    private void fP(int i2, int i3) {
        AppMethodBeat.i(34161);
        if (6 == this.appType) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1203, (long) i3, 1, false);
            Object[] objArr = new Object[11];
            objArr[0] = this.Pdn.iwW;
            objArr[1] = Integer.valueOf(this.Pdn.iwM == 1 ? 7 : 5);
            objArr[2] = Integer.valueOf(this.Pdn.iwI);
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Long.valueOf((cl.aWz() - this.dTX.field_createTime) / 1000);
            objArr[5] = this.gCr;
            objArr[6] = this.dTX.field_talker;
            objArr[7] = 1;
            objArr[8] = "";
            objArr[9] = Long.valueOf(this.dTX.field_msgSvrId);
            objArr[10] = Long.valueOf(this.dTX.field_createTime);
            String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", objArr);
            Log.i("MicroMsg.AppAttachDownloadUI", "reportKVStat 14665 %s", format);
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(14665, format);
        }
        AppMethodBeat.o(34161);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        int i2;
        String aKE;
        int indexOf;
        AppMethodBeat.i(34149);
        c gMB = gMB();
        if (gMB != null) {
            long j2 = gMB.field_totalLen;
            long j3 = gMB.field_offset;
            this.LzM = j2;
            this.Pdi.setText(getString(R.string.bnm, new Object[]{af.getSizeKB(j3), af.getSizeKB(j2)}));
            if (gMB.field_totalLen == 0) {
                i2 = 0;
            } else {
                i2 = (int) ((gMB.field_offset * 100) / gMB.field_totalLen);
            }
            Log.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i2 + " offset:" + j3 + " totallen:" + j2 + " status " + gMB.field_status);
            this.Pdf.setProgress(i2);
            if (gMB.field_status == 199 && i2 >= 100 && !this.Pdp) {
                if (this.KvS != null) {
                    com.tencent.mm.ui.chatting.multitask.b bVar = this.KvS;
                    long j4 = this.LzM;
                    if (bVar.nhp != null) {
                        bVar.nhp.LzM = j4;
                        try {
                            bVar.Abp.field_data = bVar.nhp.toByteArray();
                        } catch (IOException e2) {
                            Log.e("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "updateFileLen", e2);
                        }
                    }
                }
                this.Pdp = true;
                if (this.Pdx) {
                    this.Pdx = false;
                    gMy();
                }
                if (this.scene == 3) {
                    Intent intent = new Intent();
                    intent.putExtra("filePath", this.filePath);
                    intent.putExtra(DownloadInfo.FILENAME, this.fileName);
                    intent.putExtra("fileExt", this.gCr);
                    setResult(-1, intent);
                    finish();
                    AppMethodBeat.o(34149);
                    return;
                }
                if (gMB != null) {
                    StringBuilder append = new StringBuilder().append(getString(R.string.boa)).append(" : ");
                    String str2 = gMB.field_fileFullPath;
                    if (str2 != null && (indexOf = (str2 = s.k(str2, true)).indexOf((aKE = com.tencent.mm.loader.j.b.aKE()))) >= 0) {
                        String substring = str2.substring(aKE.length() + indexOf);
                        if (substring.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                            str2 = "/sdcard".concat(String.valueOf(substring));
                        } else {
                            str2 = "/sdcard/".concat(String.valueOf(substring));
                        }
                    }
                    Toast.makeText(this, append.append(str2).toString(), this.Pds).show();
                    com.tencent.mm.pluginsdk.ui.tools.a.a(this, gMB.field_fileFullPath, this.gCr, this.fileName, 1);
                }
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass9 */

                    public final void run() {
                        AppMethodBeat.i(232802);
                        AppAttachDownloadUI.R(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232802);
                    }
                }, 200);
            }
            if (this.Pdf.getVisibility() != 0 && i2 < 100 && !gMB.field_isUpload && gMB.field_status == 101) {
                Log.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", Integer.valueOf(i2));
                alY(0);
                this.Pdg.setVisibility(8);
            }
        }
        AppMethodBeat.o(34149);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public /* bridge */ /* synthetic */ AppCompatActivity getContext() {
        AppMethodBeat.i(34162);
        MMActivity mMActivity = (MMActivity) super.getContext();
        AppMethodBeat.o(34162);
        return mMActivity;
    }

    static /* synthetic */ void a(AppAttachDownloadUI appAttachDownloadUI, boolean z) {
        boolean z2;
        AppMethodBeat.i(232816);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        if (z) {
            ef efVar = new ef();
            efVar.dHy.msgId = appAttachDownloadUI.msgId;
            EventCenter.instance.publish(efVar);
            switch (appAttachDownloadUI.appType) {
                case 0:
                    arrayList.add(appAttachDownloadUI.getString(R.string.g5c));
                    arrayList.add(appAttachDownloadUI.getString(R.string.bnr));
                    arrayList2.add(0);
                    arrayList2.add(3);
                    if (efVar.dHz.dGX) {
                        arrayList.add(appAttachDownloadUI.getString(R.string.bo1));
                        arrayList2.add(4);
                        break;
                    }
                    break;
                case 6:
                    arrayList.add(appAttachDownloadUI.getString(R.string.g5c));
                    arrayList2.add(0);
                    if (appAttachDownloadUI.KvS != null && appAttachDownloadUI.KvS.bPq()) {
                        arrayList.add(appAttachDownloadUI.getString(R.string.bx0));
                        arrayList2.add(9);
                    }
                    arrayList.add(appAttachDownloadUI.getString(R.string.bnr));
                    arrayList2.add(3);
                    Long bcU = e.a.bcU(appAttachDownloadUI.gCr);
                    if (efVar.dHz.dGX || (bcU != null && com.tencent.mm.pluginsdk.model.app.h.s((MMActivity) super.getContext(), bcU.longValue()))) {
                        arrayList.add(appAttachDownloadUI.getString(R.string.bo1));
                        arrayList2.add(4);
                    }
                    if (com.tencent.mm.br.c.aZU("favorite")) {
                        arrayList.add(appAttachDownloadUI.getString(R.string.fn9));
                        arrayList2.add(2);
                    }
                    if (((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYl() && appAttachDownloadUI.thY != null && HandOffFile.isSupportOpenFile(appAttachDownloadUI.gCr)) {
                        arrayList.add(appAttachDownloadUI.getString(R.string.cek));
                        arrayList2.add(17);
                    }
                    arrayList.add(appAttachDownloadUI.getString(R.string.c2x));
                    arrayList2.add(14);
                    break;
                default:
                    arrayList.add(appAttachDownloadUI.getString(R.string.g5c));
                    arrayList2.add(0);
                    break;
            }
        } else if (com.tencent.mm.br.c.aZU("favorite")) {
            arrayList.add(appAttachDownloadUI.getString(R.string.fn9));
            arrayList2.add(2);
        }
        com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
        if (Util.getInt(com.tencent.mm.util.c.axY(com.tencent.mm.util.c.np("search", "applyLocalTemplate")), 0) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (appAttachDownloadUI.fileName.startsWith("fts_template") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.string.bnb));
                arrayList2.add(5);
            } else if (appAttachDownloadUI.fileName.startsWith("was_template") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.string.bni));
                arrayList2.add(6);
            }
            if (appAttachDownloadUI.fileName.startsWith("fts_feature") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.string.bna));
                arrayList2.add(7);
            }
            if (appAttachDownloadUI.fileName.startsWith("wrd_template") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.string.bn_));
                arrayList2.add(8);
            }
            if (appAttachDownloadUI.fileName.startsWith("pardus") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.string.bnf));
                arrayList2.add(12);
            }
            if (appAttachDownloadUI.fileName.startsWith("box_template") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.string.bn8));
                arrayList2.add(10);
            }
            if (appAttachDownloadUI.fileName.startsWith("box_flight_number") && appAttachDownloadUI.fileName.endsWith(".txt")) {
                arrayList.add(appAttachDownloadUI.getString(R.string.bn9));
                arrayList2.add(11);
            }
            if (appAttachDownloadUI.fileName.startsWith("popup_scan") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.string.bng));
                arrayList2.add(13);
            }
            if ((appAttachDownloadUI.fileName.startsWith("fs_kw_main") && appAttachDownloadUI.fileName.endsWith(".zip")) || appAttachDownloadUI.fileName.startsWith("73.1.data")) {
                arrayList.add(appAttachDownloadUI.getString(R.string.bnc));
                arrayList2.add(15);
            }
            if (appAttachDownloadUI.fileName.startsWith("tsc") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.string.bnh));
                arrayList2.add(16);
            }
            if (appAttachDownloadUI.fileName.startsWith("ocr") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.string.bnd));
                arrayList2.add(18);
            }
            if (appAttachDownloadUI.fileName.startsWith("mv_default_video") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.string.bne));
                arrayList2.add(19);
            }
            if (appAttachDownloadUI.fileName.startsWith("TextState") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.string.j88));
                arrayList2.add(20);
            }
        }
        final AnonymousClass12 r0 = new h.e() {
            /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass12 */

            @Override // com.tencent.mm.ui.base.h.e
            public final void cy(int i2, int i3) {
                AppMethodBeat.i(232804);
                switch (i3) {
                    case 0:
                        AppAttachDownloadUI.e(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 2:
                        AppAttachDownloadUI.f(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 3:
                        AppAttachDownloadUI.g(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 4:
                        AppAttachDownloadUI.h(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 5:
                        AppAttachDownloadUI.i(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 6:
                        AppAttachDownloadUI.m(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 7:
                        AppAttachDownloadUI.l(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 8:
                        AppAttachDownloadUI.n(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 9:
                        if (AppAttachDownloadUI.this.KvS != null) {
                            AppAttachDownloadUI.this.KvS.ic(true);
                            AppMethodBeat.o(232804);
                            return;
                        }
                        break;
                    case 10:
                        AppAttachDownloadUI.q(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 11:
                        AppAttachDownloadUI.r(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 12:
                        AppAttachDownloadUI.o(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 13:
                        AppAttachDownloadUI.s(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 14:
                        AppAttachDownloadUI.v(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 15:
                        AppAttachDownloadUI.t(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 16:
                        AppAttachDownloadUI.u(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 17:
                        if (AppAttachDownloadUI.this.thY != null) {
                            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).f(AppAttachDownloadUI.this.thY);
                            AppMethodBeat.o(232804);
                            return;
                        }
                        break;
                    case 18:
                        AppAttachDownloadUI.w(AppAttachDownloadUI.this);
                        break;
                    case 19:
                        AppAttachDownloadUI.j(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                    case 20:
                        AppAttachDownloadUI.k(AppAttachDownloadUI.this);
                        AppMethodBeat.o(232804);
                        return;
                }
                AppMethodBeat.o(232804);
            }
        };
        if (arrayList.size() != 0 || !Util.isNullOrNil((String) null)) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) appAttachDownloadUI, 1, false);
            eVar.HLX = new o.f() {
                /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass13 */
                final /* synthetic */ String OPn;
                final /* synthetic */ String dqb = null;

                {
                    this.OPn = null;
                }

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    AppMethodBeat.i(232805);
                    if (!Util.isNullOrNil(this.dqb)) {
                        mVar.setHeaderTitle(this.dqb);
                    }
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        mVar.d(((Integer) arrayList2.get(i2)).intValue(), (CharSequence) arrayList.get(i2));
                    }
                    if (!Util.isNullOrNil(this.OPn)) {
                        mVar.d(-1, this.OPn);
                    }
                    AppMethodBeat.o(232805);
                }
            };
            eVar.HLY = new o.g() {
                /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass14 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(232806);
                    if (r0 != null) {
                        r0.cy(i2, menuItem.getItemId());
                    }
                    AppMethodBeat.o(232806);
                }
            };
            eVar.PGl = new e.b() {
                /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass15 */

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                    AppMethodBeat.i(232807);
                    Log.d("MicroMsg.AppAttachDownloadUI", "showAlert, onDismiss");
                    AppAttachDownloadUI.this.oXS = null;
                    AppMethodBeat.o(232807);
                }
            };
            Log.d("MicroMsg.AppAttachDownloadUI", "enhanceBottomSheet");
            if (appAttachDownloadUI.Jgy == null) {
                Log.d("MicroMsg.AppAttachDownloadUI", "enhanceBottomSheet, openMaterialCollection is null");
            } else {
                com.tencent.mm.plugin.appbrand.service.i iVar = (com.tencent.mm.plugin.appbrand.service.i) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.i.class);
                if (iVar == null) {
                    Log.w("MicroMsg.AppAttachDownloadUI", "enhanceBottomSheet, openMaterialService is null");
                } else if (!iVar.c(com.tencent.mm.plugin.appbrand.openmaterial.model.b.ATTACH)) {
                    Log.i("MicroMsg.AppAttachDownloadUI", "tryEnhanceBottomSheet, openMaterialService is not enabled");
                } else {
                    if (appAttachDownloadUI.Jgz != null) {
                        appAttachDownloadUI.Jgz.dead();
                    }
                    appAttachDownloadUI.Jgz = iVar.a(com.tencent.mm.plugin.appbrand.openmaterial.model.b.ATTACH, appAttachDownloadUI, eVar, appAttachDownloadUI.Jgy, null, null);
                }
            }
            Log.d("MicroMsg.AppAttachDownloadUI", "showAlert, set BottomSheet");
            appAttachDownloadUI.oXS = eVar;
            eVar.dGm();
        }
        AppMethodBeat.o(232816);
    }

    static /* synthetic */ void e(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(34165);
        appAttachDownloadUI.fP(2, 7);
        boolean z = appAttachDownloadUI.Pdn != null ? appAttachDownloadUI.Pdn.iwM != 0 || appAttachDownloadUI.Pdn.iwI > 26214400 : false;
        Intent intent = new Intent(appAttachDownloadUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", appAttachDownloadUI.dWG);
        intent.putExtra("Retr_Msg_Type", 2);
        intent.putExtra("Retr_Msg_Id", appAttachDownloadUI.dTX.field_msgId);
        intent.putExtra("Retr_Big_File", z);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(appAttachDownloadUI, bl.axQ(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "doRestransmitMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        appAttachDownloadUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(appAttachDownloadUI, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "doRestransmitMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34165);
    }

    static /* synthetic */ void f(AppAttachDownloadUI appAttachDownloadUI) {
        c c2;
        AppMethodBeat.i(34166);
        if (!appAttachDownloadUI.Pdp && appAttachDownloadUI.dTX.dOQ()) {
            k.b HD = k.b.HD(appAttachDownloadUI.dTX.field_content);
            if (HD.type == 6 && !Util.isNullOrNil(HD.iwN) && (c2 = m.c(appAttachDownloadUI.dTX, HD.dCK)) != null && (!s.YS(c2.field_fileFullPath) || s.boW(c2.field_fileFullPath) != c2.field_totalLen)) {
                appAttachDownloadUI.Pdx = true;
                c2.field_status = 101;
                c2.field_lastModifyTime = Util.nowSecond();
                ao.cgO().a(c2, new String[0]);
                appAttachDownloadUI.gMz();
                AppMethodBeat.o(34166);
                return;
            }
        }
        appAttachDownloadUI.gMy();
        AppMethodBeat.o(34166);
    }

    static /* synthetic */ void g(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(34167);
        Intent intent = new Intent(appAttachDownloadUI, AppAttachFileListUI.class);
        intent.setFlags(67108864);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(appAttachDownloadUI, bl.axQ(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileList", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        appAttachDownloadUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(appAttachDownloadUI, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "showFileList", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11168, 6, 1);
        AppMethodBeat.o(34167);
    }

    static /* synthetic */ void h(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(34168);
        Intent intent = new Intent(appAttachDownloadUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", appAttachDownloadUI.dTX.field_msgId);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(appAttachDownloadUI, bl.axQ(), "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "doOtherOpenMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        appAttachDownloadUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(appAttachDownloadUI, "com/tencent/mm/ui/chatting/AppAttachDownloadUI", "doOtherOpenMsg", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(34168);
    }

    static /* synthetic */ void i(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(34169);
        if (appAttachDownloadUI.gMB() != null) {
            lx lxVar = new lx();
            lxVar.dRu.dEO = 27;
            lxVar.dRu.subType = 1;
            if (appAttachDownloadUI.gMB() != null) {
                lxVar.dRu.filePath = appAttachDownloadUI.gMB().field_fileFullPath;
            }
            EventCenter.instance.publish(lxVar);
            u.makeText(MMApplicationContext.getContext(), String.format("current template is %d", Integer.valueOf(ai.aft(0))), 1).show();
        }
        AppMethodBeat.o(34169);
    }

    static /* synthetic */ void j(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(34170);
        if (appAttachDownloadUI.gMB() != null) {
            lx lxVar = new lx();
            lxVar.dRu.dEO = 87;
            lxVar.dRu.subType = 1;
            if (appAttachDownloadUI.gMB() != null) {
                lxVar.dRu.filePath = appAttachDownloadUI.gMB().field_fileFullPath;
            }
            EventCenter.instance.publish(lxVar);
            u.makeText(MMApplicationContext.getContext(), String.format("apply to mv", new Object[0]), 1).show();
        }
        AppMethodBeat.o(34170);
    }

    static /* synthetic */ void k(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(34171);
        if (appAttachDownloadUI.gMB() != null) {
            lx lxVar = new lx();
            lxVar.dRu.dEO = 86;
            lxVar.dRu.subType = 1;
            if (appAttachDownloadUI.gMB() != null) {
                lxVar.dRu.filePath = appAttachDownloadUI.gMB().field_fileFullPath;
            }
            EventCenter.instance.publish(lxVar);
            u.makeText(MMApplicationContext.getContext(), String.format("apply to TextStatus", new Object[0]), 1).show();
        }
        AppMethodBeat.o(34171);
    }

    static /* synthetic */ void l(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(34172);
        com.tencent.mm.g.a.bp bpVar = new com.tencent.mm.g.a.bp();
        bpVar.dEN.dEO = 35;
        bpVar.dEN.subType = 1;
        if (appAttachDownloadUI.gMB() != null) {
            bpVar.dEN.filePath = appAttachDownloadUI.gMB().field_fileFullPath;
        }
        EventCenter.instance.publish(bpVar);
        u.makeText(MMApplicationContext.getContext(), String.format("apply success", new Object[0]), 1).show();
        AppMethodBeat.o(34172);
    }

    static /* synthetic */ void m(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(34173);
        lx lxVar = new lx();
        lxVar.dRu.dEO = 40;
        lxVar.dRu.subType = 1;
        if (appAttachDownloadUI.gMB() != null) {
            lxVar.dRu.filePath = appAttachDownloadUI.gMB().field_fileFullPath;
            lxVar.dRu.filePath = appAttachDownloadUI.gMB().field_fileFullPath;
        }
        EventCenter.instance.publish(lxVar);
        u.makeText(MMApplicationContext.getContext(), String.format("current wxa template is %d", Integer.valueOf(ai.aft(3))), 1).show();
        AppMethodBeat.o(34173);
    }

    static /* synthetic */ void n(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(169845);
        lx lxVar = new lx();
        lxVar.dRu.dEO = 27;
        lxVar.dRu.subType = 2;
        if (appAttachDownloadUI.gMB() != null) {
            lxVar.dRu.filePath = appAttachDownloadUI.gMB().field_fileFullPath;
        }
        EventCenter.instance.publish(lxVar);
        u.makeText(MMApplicationContext.getContext(), String.format("current browse template is %d", Integer.valueOf(ai.aft(1))), 1).show();
        AppMethodBeat.o(169845);
    }

    static /* synthetic */ void o(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(169846);
        lx lxVar = new lx();
        lxVar.dRu.dEO = 66;
        lxVar.dRu.subType = 1;
        if (appAttachDownloadUI.gMB() != null) {
            lxVar.dRu.filePath = appAttachDownloadUI.gMB().field_fileFullPath;
        }
        EventCenter.instance.publish(lxVar);
        u.makeText(MMApplicationContext.getContext(), String.format("current pardus template is %d", Integer.valueOf(ai.aft(5))), 1).show();
        AppMethodBeat.o(169846);
    }

    static /* synthetic */ void q(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(232818);
        com.tencent.mm.g.a.bp bpVar = new com.tencent.mm.g.a.bp();
        bpVar.dEN.dEO = 62;
        bpVar.dEN.subType = 1;
        if (appAttachDownloadUI.gMB() != null) {
            bpVar.dEN.filePath = appAttachDownloadUI.gMB().field_fileFullPath;
        }
        EventCenter.instance.publish(bpVar);
        u.makeText(MMApplicationContext.getContext(), String.format("apply success", new Object[0]), 1).show();
        AppMethodBeat.o(232818);
    }

    static /* synthetic */ void r(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(232819);
        com.tencent.mm.g.a.bp bpVar = new com.tencent.mm.g.a.bp();
        bpVar.dEN.dEO = 62;
        bpVar.dEN.subType = 2;
        if (appAttachDownloadUI.gMB() != null) {
            bpVar.dEN.filePath = appAttachDownloadUI.gMB().field_fileFullPath;
        }
        EventCenter.instance.publish(bpVar);
        u.makeText(MMApplicationContext.getContext(), String.format("apply success", new Object[0]), 1).show();
        AppMethodBeat.o(232819);
    }

    static /* synthetic */ void s(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(232820);
        Log.i("MicroMsg.AppAttachDownloadUI", "alvinluo applyToScanGoods");
        com.tencent.mm.g.a.bp bpVar = new com.tencent.mm.g.a.bp();
        bpVar.dEN.dEO = 64;
        bpVar.dEN.subType = 1;
        if (appAttachDownloadUI.gMB() != null) {
            bpVar.dEN.filePath = appAttachDownloadUI.gMB().field_fileFullPath;
        }
        EventCenter.instance.publish(bpVar);
        u.makeText(MMApplicationContext.getContext(), String.format("apply success", new Object[0]), 1).show();
        AppMethodBeat.o(232820);
    }

    static /* synthetic */ void t(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(232821);
        lx lxVar = new lx();
        lxVar.dRu.dEO = 73;
        lxVar.dRu.subType = 1;
        if (appAttachDownloadUI.gMB() != null) {
            lxVar.dRu.filePath = appAttachDownloadUI.gMB().field_fileFullPath;
        }
        EventCenter.instance.publish(lxVar);
        u.makeText(MMApplicationContext.getContext(), String.format("apply success", new Object[0]), 1).show();
        AppMethodBeat.o(232821);
    }

    static /* synthetic */ void u(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(232822);
        lx lxVar = new lx();
        lxVar.dRu.dEO = 79;
        lxVar.dRu.subType = 1;
        if (appAttachDownloadUI.gMB() != null) {
            lxVar.dRu.filePath = appAttachDownloadUI.gMB().field_fileFullPath;
        }
        EventCenter.instance.publish(lxVar);
        u.makeText(MMApplicationContext.getContext(), String.format("apply success", new Object[0]), 1).show();
        AppMethodBeat.o(232822);
    }

    static /* synthetic */ void v(AppAttachDownloadUI appAttachDownloadUI) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(232823);
        if (!appAttachDownloadUI.Pdp) {
            Toast.makeText(appAttachDownloadUI, appAttachDownloadUI.getString(R.string.hp4), 1).show();
            AppMethodBeat.o(232823);
            return;
        }
        c gMB = appAttachDownloadUI.gMB();
        if (gMB == null) {
            Log.e("MicroMsg.AppAttachDownloadUI", "[-] Fail to get app attach info.");
            z = false;
        } else {
            z = true;
        }
        if (z && gMB.field_fileFullPath == null) {
            Log.e("MicroMsg.AppAttachDownloadUI", "[-] field_fileFullPath == null");
            z = false;
        }
        if (!z || s.YS(gMB.field_fileFullPath)) {
            z2 = z;
        } else {
            Log.e("MicroMsg.AppAttachDownloadUI", "[-] [%s] does not exist.", gMB.field_fileFullPath);
        }
        if (z2) {
            p.c(appAttachDownloadUI, gMB.field_fileFullPath, new p.a() {
                /* class com.tencent.mm.ui.chatting.AppAttachDownloadUI.AnonymousClass16 */

                @Override // com.tencent.mm.platformtools.p.a
                public final void bP(String str, String str2) {
                    AppMethodBeat.i(232808);
                    Toast.makeText(AppAttachDownloadUI.this, AppAttachDownloadUI.this.getString(R.string.hp6, new Object[]{AndroidMediaUtil.getFriendlySdcardPath(str2)}), 1).show();
                    AppMethodBeat.o(232808);
                }

                @Override // com.tencent.mm.platformtools.p.a
                public final void bQ(String str, String str2) {
                    AppMethodBeat.i(232809);
                    Toast.makeText(AppAttachDownloadUI.this, AppAttachDownloadUI.this.getString(R.string.hp5), 1).show();
                    AppMethodBeat.o(232809);
                }
            });
            AppMethodBeat.o(232823);
            return;
        }
        Toast.makeText(appAttachDownloadUI, appAttachDownloadUI.getString(R.string.hp5), 1).show();
        AppMethodBeat.o(232823);
    }

    static /* synthetic */ void w(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(258925);
        Log.i("MicroMsg.AppAttachDownloadUI", "alvinluo applyToImageOcr");
        com.tencent.mm.g.a.bp bpVar = new com.tencent.mm.g.a.bp();
        bpVar.dEN.dEO = 84;
        bpVar.dEN.subType = 1;
        if (appAttachDownloadUI.gMB() != null) {
            bpVar.dEN.filePath = appAttachDownloadUI.gMB().field_fileFullPath;
        }
        EventCenter.instance.publish(bpVar);
        u.makeText(MMApplicationContext.getContext(), String.format("apply success", new Object[0]), 1).show();
        AppMethodBeat.o(258925);
    }

    static /* synthetic */ void Q(AppAttachDownloadUI appAttachDownloadUI) {
        AppMethodBeat.i(258929);
        c gMB = appAttachDownloadUI.gMB();
        if (gMB == null) {
            Log.e("MicroMsg.AppAttachDownloadUI", "open fail, info is null");
            AppMethodBeat.o(258929);
        } else if (gMB.field_fileFullPath == null || gMB.field_fileFullPath.length() == 0) {
            Log.e("MicroMsg.AppAttachDownloadUI", "open fail, field fileFullPath is null");
            AppMethodBeat.o(258929);
        } else {
            String str = gMB.field_fileFullPath;
            if (appAttachDownloadUI.scene == 1) {
                com.tencent.mm.pluginsdk.ui.tools.a.a(appAttachDownloadUI, str, appAttachDownloadUI.gCr, appAttachDownloadUI.fileName, 7);
            } else {
                com.tencent.mm.pluginsdk.ui.tools.a.a(appAttachDownloadUI, str, appAttachDownloadUI.gCr, appAttachDownloadUI.fileName, 1);
            }
            appAttachDownloadUI.thI.setEnabled(false);
            AppMethodBeat.o(258929);
        }
    }
}
