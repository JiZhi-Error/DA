package com.tencent.mm.plugin.emoji.ui.fts;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.q;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.ui.EmojiSendDialogUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;

public class FTSEmojiDetailPageUI extends MMActivity implements i {
    private String dKJ;
    private String dUs;
    private String designerName;
    private EmojiInfo gWm;
    private l mHj;
    private ProgressBar oMO;
    private String productId;
    private d.a rbA = new d.a() {
        /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass10 */

        @Override // com.tencent.mm.plugin.emoji.model.d.a
        public final void a(boolean z, EmojiInfo emojiInfo) {
            AppMethodBeat.i(109110);
            if (emojiInfo == null || !z || FTSEmojiDetailPageUI.this.gWm == null || !FTSEmojiDetailPageUI.this.gWm.getMd5().equals(emojiInfo.getMd5())) {
                Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "somethings error.");
                AppMethodBeat.o(109110);
                return;
            }
            Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", FTSEmojiDetailPageUI.this.gWm.getMd5());
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass10.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(109109);
                    FTSEmojiDetailPageUI.e(FTSEmojiDetailPageUI.this);
                    AppMethodBeat.o(109109);
                }
            });
            AppMethodBeat.o(109110);
        }
    };
    private String rbI;
    private MMAnimateView rji;
    private Button rjj;
    private Button rjk;
    private TextView rjl;
    private ImageView rjm;
    private View rjn;
    private boolean rjo;
    private boolean rjp;
    private String rjq;
    private int rjr;
    private String rjs;
    private String rjt;
    private String rju;
    private String rjv;
    private String rjw;
    private IListener rjx = new IListener<dm>() {
        /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass9 */

        {
            AppMethodBeat.i(161093);
            this.__eventId = dm.class.getName().hashCode();
            AppMethodBeat.o(161093);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dm dmVar) {
            AppMethodBeat.i(109108);
            dm dmVar2 = dmVar;
            if (FTSEmojiDetailPageUI.this.gWm != null && dmVar2.dGw.md5.equals(FTSEmojiDetailPageUI.this.gWm.getMd5())) {
                Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiDownloadListener callback %s", FTSEmojiDetailPageUI.this.gWm.getMd5());
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass9.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(109107);
                        FTSEmojiDetailPageUI.e(FTSEmojiDetailPageUI.this);
                        AppMethodBeat.o(109107);
                    }
                });
            }
            AppMethodBeat.o(109108);
            return false;
        }
    };
    private k rjy = new k() {
        /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass11 */

        @Override // com.tencent.mm.av.a.c.k
        public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.i(109112);
            Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", str);
            if (bitmap != null && objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String) && str.equals(FTSEmojiDetailPageUI.this.gWm.field_encrypturl)) {
                o oVar = new o(objArr[0].toString());
                if (oVar.exists()) {
                    FTSEmojiDetailPageUI.this.gWm.field_md5 = s.bhK(aa.z(oVar.mUri));
                    FTSEmojiDetailPageUI fTSEmojiDetailPageUI = FTSEmojiDetailPageUI.this;
                    a aVar = a.hdT;
                    fTSEmojiDetailPageUI.dUs = EmojiLogic.W(a.awt(), "", FTSEmojiDetailPageUI.this.gWm.field_md5);
                    s.nw(aa.z(oVar.her()), FTSEmojiDetailPageUI.this.dUs);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass11.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(109111);
                            FTSEmojiDetailPageUI.e(FTSEmojiDetailPageUI.this);
                            AppMethodBeat.o(109111);
                        }
                    });
                }
            }
            AppMethodBeat.o(109112);
        }
    };
    private o.g rjz = new o.g() {
        /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass3 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(109101);
            FTSEmojiDetailPageUI.this.mHj = null;
            switch (menuItem.getItemId()) {
                case 2:
                    FTSEmojiDetailPageUI.h(FTSEmojiDetailPageUI.this);
                    AppMethodBeat.o(109101);
                    return;
                case 1:
                    FTSEmojiDetailPageUI.i(FTSEmojiDetailPageUI.this);
                    break;
            }
            AppMethodBeat.o(109101);
        }
    };
    private int scene;
    private int sourceType;
    private int type;
    private String weappUserName;
    private int weappVersion;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FTSEmojiDetailPageUI() {
        AppMethodBeat.i(109114);
        AppMethodBeat.o(109114);
    }

    static /* synthetic */ void e(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.i(109127);
        fTSEmojiDetailPageUI.is(false);
        AppMethodBeat.o(109127);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109115);
        super.onCreate(bundle);
        this.rjj = (Button) findViewById(R.id.byv);
        this.rjk = (Button) findViewById(R.id.c1n);
        this.rji = (MMAnimateView) findViewById(R.id.c07);
        this.oMO = (ProgressBar) findViewById(R.id.epo);
        this.rjl = (TextView) findViewById(R.id.c1q);
        this.rjm = (ImageView) findViewById(R.id.c1p);
        this.rjn = findViewById(R.id.aa7);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109099);
                FTSEmojiDetailPageUI.this.finish();
                AppMethodBeat.o(109099);
                return false;
            }
        });
        this.rjj.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(109103);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this, FTSEmojiDetailPageUI.this.gWm.getMd5(), FTSEmojiDetailPageUI.this.gWm.field_designerID, FTSEmojiDetailPageUI.this.gWm.field_thumbUrl, FTSEmojiDetailPageUI.this.gWm.field_activityid);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109103);
            }
        });
        this.rjk.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass6 */

            public final void onClick(View view) {
                AppMethodBeat.i(109104);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FTSEmojiDetailPageUI.b(FTSEmojiDetailPageUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109104);
            }
        });
        this.rjn.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(109105);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FTSEmojiDetailPageUI.c(FTSEmojiDetailPageUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109105);
            }
        });
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass8 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109106);
                FTSEmojiDetailPageUI.d(FTSEmojiDetailPageUI.this);
                AppMethodBeat.o(109106);
                return true;
            }
        });
        this.type = getIntent().getIntExtra("extra_type", 0);
        this.scene = getIntent().getIntExtra("extra_scence", 0);
        this.gWm = new EmojiInfo();
        this.gWm.field_designerID = getIntent().getStringExtra("id");
        this.gWm.field_name = getIntent().getStringExtra("extra_emoji_name");
        this.gWm.field_aeskey = getIntent().getStringExtra("extra_aeskey");
        this.gWm.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
        this.gWm.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
        this.gWm.field_md5 = getIntent().getStringExtra("extra_md5");
        this.gWm.field_groupId = getIntent().getStringExtra("extra_product_id");
        this.productId = this.gWm.field_groupId;
        this.rjt = getIntent().getStringExtra("extra_product_name");
        this.rjs = getIntent().getStringExtra("productUrl");
        this.rju = getIntent().getStringExtra("extra_article_url");
        this.rjv = getIntent().getStringExtra("extra_article_name");
        this.dKJ = this.gWm.field_designerID;
        this.designerName = getIntent().getStringExtra("name");
        this.rjw = getIntent().getStringExtra("headurl");
        this.weappUserName = getIntent().getStringExtra("weapp_user_name");
        this.weappVersion = getIntent().getIntExtra("weapp_version", 0);
        this.sourceType = getIntent().getIntExtra("source_type", 0);
        this.rjq = getIntent().getStringExtra("searchID");
        this.rbI = getIntent().getStringExtra("docID");
        this.rjr = getIntent().getIntExtra("search_type", 0);
        this.rjo = getIntent().getBooleanExtra("disableAddSticker", false);
        this.rjp = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
        String stringExtra = getIntent().getStringExtra("activityId");
        if (!Util.isNullOrNil(stringExtra)) {
            this.gWm.field_activityid = stringExtra;
        }
        EventCenter.instance.addListener(this.rjx);
        com.tencent.mm.plugin.emoji.model.k.cGd().rbg = this.rbA;
        ar.h(this.scene, this.rjq, this.rbI, this.rjr);
        is(true);
        Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", this.dUs);
        ar.h(this.scene, this.rjq, this.rbI, this.rjr);
        AppMethodBeat.o(109115);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(109116);
        super.onResume();
        is(false);
        AppMethodBeat.o(109116);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(109117);
        if (i2 == 1001 && i3 == -1) {
            com.tencent.mm.ui.widget.snackbar.b.r(this, getContext().getString(R.string.yt));
        }
        AppMethodBeat.o(109117);
    }

    private void is(boolean z) {
        AppMethodBeat.i(109118);
        if (z) {
            setMMTitle(this.gWm.getName());
        }
        switch (this.type) {
            case 2:
                q.bcV().loadImage(this.rjs, this.rjm);
                this.rjl.setText(this.rjt);
                this.dUs = this.gWm.hYx();
                break;
            case 3:
                q.bcV().loadImage(this.rjw, this.rjm);
                this.rjl.setText(this.designerName);
                this.dUs = this.gWm.hYx();
                break;
            case 4:
                this.rjm.setVisibility(8);
                if (Util.isNullOrNil(this.rjv)) {
                    this.rjl.setText(R.string.ggh);
                    break;
                } else {
                    this.rjl.setText(this.rjv);
                    break;
                }
        }
        if (s.YS(this.dUs)) {
            this.oMO.setVisibility(8);
            this.rji.setVisibility(0);
            EmojiInfo blk = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(this.gWm.getMd5());
            if (blk == null || (blk.field_reserved4 & EmojiInfo.Vll) != EmojiInfo.Vll) {
                Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
                this.rji.setImageFilePath(this.dUs);
            } else {
                Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
                this.rji.g(((com.tencent.mm.plugin.emoji.b.d) g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(blk), "");
            }
            cHR();
            cHQ();
        } else if (z) {
            if (this.type == 4) {
                com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(getCacheDir(), com.tencent.mm.b.g.getMessageDigest(this.gWm.field_encrypturl.getBytes()));
                if (oVar.exists()) {
                    this.gWm.field_md5 = s.bhK(aa.z(oVar.mUri));
                    a aVar = a.hdT;
                    String W = EmojiLogic.W(a.awt(), "", this.gWm.field_md5);
                    if (!s.YS(W)) {
                        s.nw(aa.z(oVar.her()), W);
                    }
                    this.dUs = W;
                    is(false);
                } else {
                    c.a aVar2 = new c.a();
                    aVar2.jbf = true;
                    aVar2.fullPath = aa.z(oVar.her());
                    aVar2.jbE = new Object[]{aa.z(oVar.her())};
                    com.tencent.mm.plugin.emoji.model.k.cGc().a(this.gWm.field_encrypturl, (ImageView) null, aVar2.bdv(), this.rjy);
                }
            } else {
                this.rji.setVisibility(8);
                this.oMO.setVisibility(0);
                this.rjj.setText(R.string.btw);
                this.rjk.setText(R.string.g5j);
                this.rjj.setEnabled(false);
                this.rjk.setEnabled(false);
                com.tencent.mm.plugin.emoji.model.k.cGd().u(this.gWm);
            }
        }
        if (this.rjo) {
            this.rjj.setVisibility(8);
        }
        AppMethodBeat.o(109118);
    }

    private void cHQ() {
        AppMethodBeat.i(109119);
        this.rjk.setEnabled(true);
        AppMethodBeat.o(109119);
    }

    private void cHR() {
        AppMethodBeat.i(109120);
        EmojiInfo blk = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(this.gWm.getMd5());
        if (blk == null) {
            blk = this.gWm;
        }
        if (blk.field_catalog == EmojiGroupInfo.VkP) {
            this.rjj.setEnabled(false);
            this.rjj.setText(R.string.h9);
            AppMethodBeat.o(109120);
            return;
        }
        this.rjj.setText(R.string.btw);
        if (s.YS(this.dUs)) {
            this.rjj.setEnabled(true);
            AppMethodBeat.o(109120);
            return;
        }
        this.rjj.setEnabled(false);
        AppMethodBeat.o(109120);
    }

    private boolean cHS() {
        AppMethodBeat.i(109121);
        if (Util.isNullOrNil(this.weappUserName) || this.sourceType != 1) {
            AppMethodBeat.o(109121);
            return false;
        }
        AppMethodBeat.o(109121);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.an_;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109122);
        EventCenter.instance.removeListener(this.rjx);
        com.tencent.mm.plugin.emoji.model.k.cGd().rbg = null;
        super.onDestroy();
        AppMethodBeat.o(109122);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
    }

    static /* synthetic */ void a(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(109123);
        ar.a(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.rjq, fTSEmojiDetailPageUI.rbI, 1, 0, fTSEmojiDetailPageUI.rjr);
        EmojiInfo blk = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(str);
        a aVar = a.hdT;
        String W = EmojiLogic.W(a.awt(), "", str);
        if (blk == null) {
            int i2 = ImgUtil.isGif(W) ? EmojiInfo.VkY : EmojiInfo.VkX;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str;
            emojiInfo.field_catalog = EmojiInfo.VkQ;
            emojiInfo.field_type = i2;
            emojiInfo.field_size = (int) s.boW(W);
            emojiInfo.field_temp = 1;
            emojiInfo.field_designerID = str2;
            emojiInfo.field_thumbUrl = str3;
            emojiInfo.field_activityid = str4;
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.J(emojiInfo);
            blk = emojiInfo;
        }
        if (blk != null) {
            Log.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "doAddAction %b", Boolean.valueOf(com.tencent.mm.plugin.emoji.model.k.cGf().a(fTSEmojiDetailPageUI, blk, 18, z.aTY())));
        }
        AppMethodBeat.o(109123);
    }

    static /* synthetic */ void b(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.i(109124);
        ar.a(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.rjq, fTSEmojiDetailPageUI.rbI, 2, 0, fTSEmojiDetailPageUI.rjr);
        Intent intent = new Intent(fTSEmojiDetailPageUI, EmojiSendDialogUI.class);
        intent.putExtra("emoji_info", fTSEmojiDetailPageUI.gWm);
        fTSEmojiDetailPageUI.startActivityForResult(intent, 1001);
        AppMethodBeat.o(109124);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void c(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        int i2;
        AppMethodBeat.i(109125);
        int i3 = fTSEmojiDetailPageUI.scene;
        String str = fTSEmojiDetailPageUI.rjq;
        String str2 = fTSEmojiDetailPageUI.rbI;
        switch (fTSEmojiDetailPageUI.type) {
            case 2:
                if (!Util.isNullOrNil(fTSEmojiDetailPageUI.productId)) {
                    i2 = 1;
                    break;
                }
                i2 = 0;
                break;
            case 3:
                if (!Util.isNullOrNil(fTSEmojiDetailPageUI.dKJ)) {
                    i2 = 2;
                    break;
                }
                i2 = 0;
                break;
            case 4:
                if (!Util.isNullOrNil(fTSEmojiDetailPageUI.rju)) {
                    i2 = 3;
                    break;
                }
                i2 = 0;
                break;
            default:
                i2 = 0;
                break;
        }
        if (fTSEmojiDetailPageUI.cHS()) {
            i2 = 4;
        }
        ar.a(i3, str, str2, 3, i2, fTSEmojiDetailPageUI.rjr);
        if (fTSEmojiDetailPageUI.cHS()) {
            Bundle bundle = new Bundle();
            bundle.putInt("stat_scene", 8);
            bundle.putString("stat_search_id", fTSEmojiDetailPageUI.rjq);
            Intent intent = new Intent();
            intent.putExtra("key_username", fTSEmojiDetailPageUI.weappUserName);
            intent.putExtra("key_can_swipe_back", true);
            intent.putExtra("key_from_scene", 6);
            intent.putExtra("key_scene_note", fTSEmojiDetailPageUI.rjq + ":" + fTSEmojiDetailPageUI.rbI + ":" + String.valueOf(fTSEmojiDetailPageUI.scene) + ":" + String.valueOf(fTSEmojiDetailPageUI.type));
            intent.putExtra("_stat_obj", bundle);
            com.tencent.mm.br.c.b(fTSEmojiDetailPageUI.getContext(), "appbrand", ".ui.AppBrandProfileUI", intent);
            AppMethodBeat.o(109125);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("preceding_scence", fTSEmojiDetailPageUI.getIntent().getIntExtra("preceding_scence", 0));
        intent2.putExtra("download_entrance_scene", 27);
        intent2.putExtra("searchID", Util.getLong(fTSEmojiDetailPageUI.rjq, 0));
        intent2.putExtra("docID", fTSEmojiDetailPageUI.rbI);
        switch (fTSEmojiDetailPageUI.type) {
            case 2:
                intent2.setClass(fTSEmojiDetailPageUI, EmojiStoreDetailUI.class);
                intent2.setFlags(268435456);
                intent2.putExtra("extra_scence", fTSEmojiDetailPageUI.scene);
                intent2.putExtra("extra_type", fTSEmojiDetailPageUI.type);
                intent2.putExtra("extra_id", fTSEmojiDetailPageUI.productId);
                break;
            case 3:
                intent2.setClass(fTSEmojiDetailPageUI, EmojiStoreV2DesignerUI.class);
                intent2.putExtra("extra_scence", 27);
                intent2.putExtra("id", fTSEmojiDetailPageUI.dKJ);
                intent2.putExtra("name", fTSEmojiDetailPageUI.designerName);
                intent2.putExtra("headurl", fTSEmojiDetailPageUI.rjw);
                break;
            case 4:
                if (!Util.isNullOrNil(fTSEmojiDetailPageUI.rju)) {
                    intent2.putExtra("rawUrl", fTSEmojiDetailPageUI.rju);
                    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                }
                AppMethodBeat.o(109125);
                return;
            default:
                AppMethodBeat.o(109125);
                return;
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(fTSEmojiDetailPageUI, bl.axQ(), "com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI", "onClickBottomBar", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        fTSEmojiDetailPageUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(fTSEmojiDetailPageUI, "com/tencent/mm/plugin/emoji/ui/fts/FTSEmojiDetailPageUI", "onClickBottomBar", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(109125);
    }

    static /* synthetic */ void d(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.i(109126);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        if (fTSEmojiDetailPageUI.rjp) {
            arrayList.add(1);
            arrayList2.add(fTSEmojiDetailPageUI.getString(R.string.gau));
        }
        arrayList.add(2);
        arrayList2.add(fTSEmojiDetailPageUI.getString(R.string.bu1));
        if (fTSEmojiDetailPageUI.mHj == null) {
            fTSEmojiDetailPageUI.mHj = new l(fTSEmojiDetailPageUI.getContext());
        }
        fTSEmojiDetailPageUI.mHj.HLX = new o.f() {
            /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass12 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(109113);
                mVar.setHeaderTitle("");
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    mVar.d(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                }
                AppMethodBeat.o(109113);
            }
        };
        fTSEmojiDetailPageUI.mHj.HLY = fTSEmojiDetailPageUI.rjz;
        fTSEmojiDetailPageUI.mHj.a(new e.b() {
            /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                AppMethodBeat.i(109100);
                FTSEmojiDetailPageUI.this.mHj = null;
                AppMethodBeat.o(109100);
            }
        });
        h.a(fTSEmojiDetailPageUI.getContext(), fTSEmojiDetailPageUI.mHj.gXI());
        AppMethodBeat.o(109126);
    }

    static /* synthetic */ void h(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.i(109128);
        Log.d("MicroMsg.FTS.FTSEmojiDetailPageUI", "ApplicationLanguage" + LocaleUtil.getApplicationLanguage());
        Intent intent = new Intent();
        intent.putExtra("title", fTSEmojiDetailPageUI.getString(R.string.bu1));
        intent.putExtra("rawUrl", fTSEmojiDetailPageUI.getString(R.string.dja) + LocaleUtil.getApplicationLanguage());
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        com.tencent.mm.br.c.b(fTSEmojiDetailPageUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(109128);
    }

    static /* synthetic */ void i(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.i(109129);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(109102);
                EmojiInfo blk = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(FTSEmojiDetailPageUI.this.gWm.getMd5());
                if (blk != null) {
                    FTSEmojiDetailPageUI.this.gWm = blk;
                }
                if (com.tencent.mm.emoji.decode.a.aum().b(FTSEmojiDetailPageUI.this.gWm)) {
                    String str = FTSEmojiDetailPageUI.this.gWm.hYx() + "_decode";
                    if (s.YS(str)) {
                        s.deleteFile(str);
                    }
                    s.bpa(str);
                    byte[] a2 = com.tencent.mm.emoji.decode.a.aum().a(FTSEmojiDetailPageUI.this.gWm);
                    s.f(str, a2, a2.length);
                    com.tencent.mm.pluginsdk.ui.tools.s.l(str, FTSEmojiDetailPageUI.this);
                    s.deleteFile(str);
                    AppMethodBeat.o(109102);
                    return;
                }
                if (s.YS(FTSEmojiDetailPageUI.this.dUs)) {
                    com.tencent.mm.pluginsdk.ui.tools.s.l(FTSEmojiDetailPageUI.this.dUs, FTSEmojiDetailPageUI.this);
                }
                AppMethodBeat.o(109102);
            }
        });
        AppMethodBeat.o(109129);
    }
}
