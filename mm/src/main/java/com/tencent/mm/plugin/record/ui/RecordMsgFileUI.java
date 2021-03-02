package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.n.c;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pluginsdk.ui.tools.v;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;

public class RecordMsgFileUI extends MMActivity implements d {
    private static final long thH = ((long) c.aqr());
    private HandOffFile BIm;
    private n BIn;
    private boolean BIo;
    private aml dKT;
    private ca dTX;
    private MMHandler hAk;
    private TextView kgE;
    private String mediaId;
    private long msgId;
    private TextView nnM;
    private ProgressBar progressBar;
    private TextView progressTips;
    private j qbJ = null;
    private Button reX;
    private Button thI;
    private Button thJ;
    private MMImageView thK;
    private View thM;
    private View thN;
    private boolean thR = false;
    private boolean thV = false;
    private boolean thW = false;
    private boolean wir = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(RecordMsgFileUI recordMsgFileUI, int i2, int i3) {
        AppMethodBeat.i(27934);
        recordMsgFileUI.fP(i2, i3);
        AppMethodBeat.o(27934);
    }

    static /* synthetic */ int c(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.i(27930);
        int type = recordMsgFileUI.getType();
        AppMethodBeat.o(27930);
        return type;
    }

    static /* synthetic */ void e(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.i(27931);
        recordMsgFileUI.bLd();
        AppMethodBeat.o(27931);
    }

    static /* synthetic */ void g(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.i(27933);
        recordMsgFileUI.cWx();
        AppMethodBeat.o(27933);
    }

    static /* synthetic */ void h(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.i(27935);
        recordMsgFileUI.cWy();
        AppMethodBeat.o(27935);
    }

    static /* synthetic */ String o(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.i(232040);
        String eIB = recordMsgFileUI.eIB();
        AppMethodBeat.o(232040);
        return eIB;
    }

    static /* synthetic */ void r(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.i(232041);
        recordMsgFileUI.cWA();
        AppMethodBeat.o(232041);
    }

    static /* synthetic */ void s(RecordMsgFileUI recordMsgFileUI) {
        AppMethodBeat.i(232042);
        recordMsgFileUI.cWw();
        AppMethodBeat.o(232042);
    }

    static {
        AppMethodBeat.i(232043);
        AppMethodBeat.o(232043);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a8r;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(27915);
        super.onCreate(bundle);
        this.hAk = new MMHandler();
        this.BIn = new n();
        this.msgId = getIntent().getLongExtra("message_id", -1);
        this.dTX = ((l) g.af(l.class)).eiy().Hb(this.msgId);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        com.tencent.mm.protocal.b.a.c aKY = p.aKY(getIntent().getStringExtra("record_xml"));
        if (aKY == null) {
            Log.w("MicroMsg.RecordMsgFileUI", "get record msg data error, empty");
            finish();
            AppMethodBeat.o(27915);
            return;
        }
        Iterator<aml> it = aKY.iAd.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            if (next.dLl.equals(stringExtra)) {
                this.dKT = next;
            }
        }
        if (this.dKT == null) {
            Log.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
            finish();
            AppMethodBeat.o(27915);
            return;
        }
        this.mediaId = p.g(this.dKT.dLl, this.msgId, true);
        this.reX = (Button) findViewById(R.id.ggf);
        this.thI = (Button) findViewById(R.id.g48);
        this.thJ = (Button) findViewById(R.id.bto);
        this.thK = (MMImageView) findViewById(R.id.dtx);
        this.kgE = (TextView) findViewById(R.id.fti);
        this.nnM = (TextView) findViewById(R.id.ipe);
        this.thN = findViewById(R.id.buk);
        this.thM = findViewById(R.id.bue);
        this.progressBar = (ProgressBar) findViewById(R.id.buc);
        this.progressTips = (TextView) findViewById(R.id.bug);
        if (4 == getType()) {
            setMMTitle(R.string.cd1);
        } else if (15 == getType()) {
            setMMTitle(R.string.cc9);
            findViewById(R.id.j44).setBackgroundResource(R.color.fm);
        } else {
            setMMTitle(R.string.c_k);
        }
        if (getType() == 4) {
            this.thK.setImageResource(R.raw.app_attach_file_icon_video);
        } else {
            this.thK.setImageResource(f.bcX(this.dKT.LvC));
        }
        this.kgE.setText(this.dKT.title);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(27895);
                RecordMsgFileUI.this.finish();
                AppMethodBeat.o(27895);
                return true;
            }
        });
        this.thI.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(27902);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String c2 = p.c(RecordMsgFileUI.this.dKT, RecordMsgFileUI.this.msgId);
                new Intent().setAction("android.intent.action.VIEW");
                if (4 == RecordMsgFileUI.c(RecordMsgFileUI.this)) {
                    RecordMsgFileUI.this.thV = false;
                    RecordMsgFileUI.e(RecordMsgFileUI.this);
                } else {
                    RecordMsgFileUI.a(RecordMsgFileUI.this, c2);
                }
                a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27902);
            }
        });
        final String str = this.dKT.Lvu;
        if (!Util.isNullOrNil(str)) {
            this.reX.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(27903);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    com.tencent.mm.br.c.b(RecordMsgFileUI.this.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27903);
                }
            });
        }
        this.thJ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(27904);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!e.apn()) {
                    h.n(RecordMsgFileUI.this.getContext(), R.string.cad, R.string.zb);
                    a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(27904);
                    return;
                }
                p.b(RecordMsgFileUI.this.dKT, RecordMsgFileUI.this.msgId, true);
                RecordMsgFileUI.this.wir = true;
                RecordMsgFileUI.g(RecordMsgFileUI.this);
                RecordMsgFileUI.a(RecordMsgFileUI.this, 7, 1);
                a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27904);
            }
        });
        this.thN.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(27905);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                RecordMsgFileUI.h(RecordMsgFileUI.this);
                a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(27905);
            }
        });
        bg.aVF();
        this.BIm = HandOffFile.fromFavItem(this.dKT, null, com.tencent.mm.model.c.aSQ().Hb(this.msgId), com.tencent.mm.plugin.fav.a.b.d((aml) null));
        this.BIm.setSource(1);
        this.BIm.setFileStatus(p.d(this.dKT, this.msgId) ? 1 : 2);
        ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).g(this.BIm);
        ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).c(this.BIm);
        if (getType() != 15 || Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("SightForwardEnable")) == 1) {
            addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
                /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass11 */

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(27908);
                    com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) RecordMsgFileUI.this.getContext(), 1, false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass11.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(27906);
                            mVar.d(0, RecordMsgFileUI.this.getString(R.string.cc8));
                            String akC = s.akC(p.c(RecordMsgFileUI.this.dKT, RecordMsgFileUI.this.msgId));
                            if (((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYl() && RecordMsgFileUI.this.BIm != null && HandOffFile.isSupportOpenFile(akC)) {
                                mVar.d(1, RecordMsgFileUI.this.getString(R.string.cek));
                            }
                            AppMethodBeat.o(27906);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass11.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(27907);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    if (RecordMsgFileUI.c(RecordMsgFileUI.this) == 8) {
                                        String c2 = p.c(RecordMsgFileUI.this.dKT, RecordMsgFileUI.this.msgId);
                                        if (!s.YS(c2)) {
                                            Log.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
                                            Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(R.string.cc6), 1).show();
                                            AppMethodBeat.o(27907);
                                            return;
                                        } else if (new com.tencent.mm.vfs.o(c2).length() > RecordMsgFileUI.thH) {
                                            Log.e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
                                            Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(R.string.cc7), 1).show();
                                            AppMethodBeat.o(27907);
                                            return;
                                        }
                                    }
                                    RecordMsgFileUI.j(RecordMsgFileUI.this);
                                    AppMethodBeat.o(27907);
                                    return;
                                case 1:
                                    if (RecordMsgFileUI.this.BIm != null) {
                                        ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).f(RecordMsgFileUI.this.BIm);
                                        break;
                                    }
                                    break;
                            }
                            AppMethodBeat.o(27907);
                        }
                    };
                    eVar.dGm();
                    AppMethodBeat.o(27908);
                    return true;
                }
            });
        } else {
            Log.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
        }
        boolean z2 = Util.isNullOrNil(this.dKT.KuR) || Util.isNullOrNil(this.dKT.Lvp);
        if (Util.isNullOrNil(this.dKT.LwF) || Util.isNullOrNil(this.dKT.LwC)) {
            z = true;
        } else {
            z = false;
        }
        if (!z2 && !z) {
            cWw();
        } else if (p.d(this.dKT, this.msgId)) {
            enableOptionMenu(true);
            cWA();
        } else {
            com.tencent.mm.plugin.record.a.j aKX = ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(this.mediaId);
            if (aKX == null || 2 == aKX.field_status) {
                cWy();
            } else if (4 == aKX.field_status) {
                cWw();
            } else if (aKX.field_status == 0 || 1 == aKX.field_status) {
                cWx();
            } else {
                Log.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                cWy();
            }
            enableOptionMenu(false);
        }
        ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
        if (8 == getType()) {
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).Z(stringExtra, this.dTX.field_msgSvrId);
        }
        fP(4, 0);
        AppMethodBeat.o(27915);
    }

    private int getType() {
        int i2 = this.dKT.dataType;
        if (i2 == 15) {
            return 4;
        }
        return i2;
    }

    private void cWw() {
        AppMethodBeat.i(27916);
        this.thJ.setVisibility(8);
        this.reX.setVisibility(8);
        this.thI.setVisibility(8);
        this.thM.setVisibility(8);
        this.nnM.setVisibility(0);
        if (this.dKT.dataType == 4) {
            this.nnM.setGravity(17);
            this.nnM.setText(R.string.cak);
            AppMethodBeat.o(27916);
            return;
        }
        this.nnM.setGravity(17);
        this.nnM.setText(R.string.caj);
        if (!this.BIo) {
            this.BIo = true;
            fP(8, 6);
        }
        AppMethodBeat.o(27916);
    }

    private void cWx() {
        AppMethodBeat.i(27917);
        this.thJ.setVisibility(8);
        this.reX.setVisibility(8);
        this.thI.setVisibility(8);
        this.nnM.setVisibility(8);
        this.thM.setVisibility(0);
        c(((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(this.mediaId));
        AppMethodBeat.o(27917);
    }

    private void cWy() {
        AppMethodBeat.i(27918);
        this.thM.setVisibility(8);
        this.thI.setVisibility(8);
        if (Util.isNullOrNil(this.dKT.Lvu)) {
            this.reX.setVisibility(8);
        } else {
            this.reX.setVisibility(0);
        }
        this.thJ.setVisibility(0);
        this.thJ.setText(R.string.c_y);
        this.nnM.setVisibility(8);
        AppMethodBeat.o(27918);
    }

    private void cWA() {
        AppMethodBeat.i(27919);
        if (this.BIm.getFileStatus() != 1) {
            this.BIm.setFileStatus(1);
            this.BIm.setFullPath(Util.nullAsNil(p.c(this.dKT, this.msgId)));
            ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).g(this.BIm);
            ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.BIm);
        }
        if (getType() == 15 && this.dKT.Lwn != null && !Util.isNullOrNil(this.dKT.Lwn.iyZ) && !Util.isNullOrNil(this.dKT.Lwn.izd)) {
            this.thW = true;
            this.thK.setVisibility(8);
            this.thM.setVisibility(8);
            this.thJ.setVisibility(8);
            this.reX.setVisibility(8);
            this.thI.setVisibility(8);
            this.nnM.setVisibility(8);
            String c2 = p.c(this.dKT, this.msgId);
            Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.app() + " initView: fullpath:" + c2);
            this.qbJ = v.iE(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            ((ViewGroup) findViewById(R.id.j44)).addView((View) this.qbJ, 0, layoutParams);
            this.qbJ.setVideoCallback(new j.a() {
                /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass12 */

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void tf() {
                    AppMethodBeat.i(27910);
                    Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.app() + " onPrepared");
                    RecordMsgFileUI.this.qbJ.setLoop(true);
                    RecordMsgFileUI.this.qbJ.start();
                    AppMethodBeat.o(27910);
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void onError(int i2, int i3) {
                    AppMethodBeat.i(27911);
                    RecordMsgFileUI.this.qbJ.stop();
                    if (RecordMsgFileUI.this.thR) {
                        AppMethodBeat.o(27911);
                        return;
                    }
                    RecordMsgFileUI.this.thR = true;
                    final Bitmap b2 = RecordMsgFileUI.this.BIn.b(RecordMsgFileUI.this.dKT, RecordMsgFileUI.this.msgId);
                    final String videoPath = RecordMsgFileUI.this.qbJ.getVideoPath();
                    CrashReportFactory.reportRawMessage(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.eVv() + "[RecordMsgFileUI] on play sight error, what=" + i2 + ", extra=" + i3 + ", path=" + Util.nullAs(videoPath, "")).getBytes(), 2), "FullScreenPlaySight");
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass12.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(27909);
                            ImageView imageView = (ImageView) RecordMsgFileUI.this.findViewById(R.id.j73);
                            imageView.setImageBitmap(b2);
                            imageView.setVisibility(0);
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            FileProviderHelper.setIntentDataAndType((Context) RecordMsgFileUI.this.getContext(), intent, new com.tencent.mm.vfs.o(videoPath), "video/*", false);
                            try {
                                RecordMsgFileUI recordMsgFileUI = RecordMsgFileUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(Intent.createChooser(intent, RecordMsgFileUI.this.getString(R.string.cd1)));
                                a.a(recordMsgFileUI, bl.axQ(), "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$7$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                recordMsgFileUI.startActivity((Intent) bl.pG(0));
                                a.a(recordMsgFileUI, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$7$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(27909);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
                                h.n(RecordMsgFileUI.this.getContext(), R.string.caa, R.string.cab);
                                AppMethodBeat.o(27909);
                            }
                        }
                    });
                    AppMethodBeat.o(27911);
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void onCompletion() {
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final int fh(int i2, int i3) {
                    return 0;
                }

                @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
                public final void eo(int i2, int i3) {
                }
            });
            Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.app() + " initView :" + c2);
            if (c2 != null) {
                this.qbJ.stop();
                this.qbJ.setVideoPath(c2);
            }
            Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.app() + " initView");
            if (bg.Xi() != null) {
                bg.Xi().akr();
            }
        }
        if (getType() != 15 && getType() != 4) {
            this.thM.setVisibility(8);
            this.thJ.setVisibility(4);
            if (Util.isNullOrNil(this.dKT.Lvu)) {
                this.reX.setVisibility(8);
            } else {
                this.reX.setVisibility(0);
            }
            this.thI.setVisibility(0);
            this.nnM.setVisibility(0);
        } else if (!this.thW) {
            this.thM.setVisibility(8);
            this.thJ.setVisibility(8);
            this.reX.setVisibility(8);
            this.thI.setVisibility(0);
            this.thI.setText(R.string.ca0);
            this.nnM.setVisibility(8);
            bLd();
            AppMethodBeat.o(27919);
            return;
        }
        AppMethodBeat.o(27919);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(27920);
        if (this.qbJ != null) {
            this.qbJ.setVideoCallback(null);
            this.qbJ.stop();
            this.qbJ.onDetach();
            if (bg.Xi() != null) {
                bg.Xi().akq();
            }
        }
        super.onDestroy();
        ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
        if (this.BIm != null) {
            ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).d(this.BIm);
        }
        this.BIn.destory();
        AppMethodBeat.o(27920);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(27921);
        super.onResume();
        if (this.qbJ != null) {
            this.qbJ.start();
        }
        AppMethodBeat.o(27921);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(27922);
        super.onPause();
        if (this.qbJ != null) {
            this.qbJ.stop();
        }
        AppMethodBeat.o(27922);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        final String stringExtra;
        AppMethodBeat.i(27923);
        super.onActivityResult(i2, i3, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a((Activity) this, i2, i3, intent, true, (int) R.string.bny, (int) R.string.bnz, 5);
        if (i3 != -1) {
            AppMethodBeat.o(27923);
            return;
        }
        if (i2 == 1001) {
            String stringExtra2 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                stringExtra = null;
            } else {
                stringExtra = intent.getStringExtra("custom_send_text");
            }
            final q a2 = h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
            Log.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", Integer.valueOf(getType()));
            final AnonymousClass13 r3 = new Runnable() {
                /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass13 */

                public final void run() {
                    AppMethodBeat.i(27912);
                    a2.dismiss();
                    AppMethodBeat.o(27912);
                }
            };
            if (Util.isNullOrNil(stringExtra2)) {
                AppMethodBeat.o(27923);
                return;
            }
            final ArrayList<String> stringsToList = Util.stringsToList(stringExtra2.split(","));
            if (getType() == 4 || getType() == 15) {
                bg.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass14 */

                    public final void run() {
                        AppMethodBeat.i(27913);
                        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(p.c(RecordMsgFileUI.this.dKT, RecordMsgFileUI.this.msgId));
                        for (String str : stringsToList) {
                            if (oVar.exists()) {
                                String o = RecordMsgFileUI.o(RecordMsgFileUI.this);
                                Log.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", aa.z(oVar.her()), o);
                                if (RecordMsgFileUI.c(RecordMsgFileUI.this) == 15) {
                                    com.tencent.mm.plugin.messenger.a.g.eir().a(RecordMsgFileUI.this.getContext(), str, aa.z(oVar.her()), o, 62, RecordMsgFileUI.this.dKT.duration, "", RecordMsgFileUI.this.dKT.jsz);
                                } else {
                                    com.tencent.mm.plugin.messenger.a.g.eir().a(RecordMsgFileUI.this.getContext(), str, aa.z(oVar.her()), o, 1, RecordMsgFileUI.this.dKT.duration, "", RecordMsgFileUI.this.dKT.jsz);
                                }
                            } else {
                                String str2 = RecordMsgFileUI.this.dKT.Lvu;
                                if (!Util.isNullOrNil(str2)) {
                                    WXVideoObject wXVideoObject = new WXVideoObject();
                                    wXVideoObject.videoUrl = str2;
                                    WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
                                    String nullAs = Util.nullAs(RecordMsgFileUI.this.dKT.title, RecordMsgFileUI.this.getContext().getResources().getString(R.string.cd1));
                                    wXMediaMessage.mediaObject = wXVideoObject;
                                    wXMediaMessage.title = nullAs;
                                    wXMediaMessage.description = RecordMsgFileUI.this.dKT.desc;
                                    wXMediaMessage.thumbData = Util.readFromFile(p.f(RecordMsgFileUI.this.dKT, RecordMsgFileUI.this.msgId));
                                    if (wXMediaMessage.thumbData == null) {
                                        StringBuilder sb = new StringBuilder();
                                        bg.aVF();
                                        wXMediaMessage.thumbData = Util.readFromFile(sb.append(com.tencent.mm.model.c.aTi()).append("web/").append(com.tencent.mm.b.g.getMessageDigest(Util.nullAs(RecordMsgFileUI.this.dKT.dFN, "").getBytes())).toString());
                                    }
                                    com.tencent.mm.pluginsdk.model.app.m.a(wXMediaMessage, "", "", str, 3, (String) null);
                                }
                            }
                            com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra, str);
                        }
                        RecordMsgFileUI.a(RecordMsgFileUI.this, 2, 7);
                        MMHandlerThread.postToMainThread(r3);
                        AppMethodBeat.o(27913);
                    }

                    public final String toString() {
                        AppMethodBeat.i(27914);
                        String str = super.toString() + "|onActivityResult1";
                        AppMethodBeat.o(27914);
                        return str;
                    }
                });
                AppMethodBeat.o(27923);
                return;
            }
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(27896);
                    String c2 = p.c(RecordMsgFileUI.this.dKT, RecordMsgFileUI.this.msgId);
                    WXFileObject wXFileObject = new WXFileObject();
                    wXFileObject.setFilePath(c2);
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.mediaObject = wXFileObject;
                    wXMediaMessage.title = RecordMsgFileUI.this.dKT.title;
                    wXMediaMessage.description = RecordMsgFileUI.this.dKT.desc;
                    wXMediaMessage.thumbData = Util.readFromFile(p.f(RecordMsgFileUI.this.dKT, RecordMsgFileUI.this.msgId));
                    for (String str : stringsToList) {
                        com.tencent.mm.pluginsdk.model.app.m.a(wXMediaMessage, "", "", str, 3, (String) null);
                        com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra, str);
                    }
                    MMHandlerThread.postToMainThread(r3);
                    AppMethodBeat.o(27896);
                }

                public final String toString() {
                    AppMethodBeat.i(27897);
                    String str = super.toString() + "|onActivityResult2";
                    AppMethodBeat.o(27897);
                    return str;
                }
            });
        }
        AppMethodBeat.o(27923);
    }

    private String eIB() {
        String sb;
        AppMethodBeat.i(27924);
        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(p.f(this.dKT, this.msgId));
        if (oVar.exists()) {
            sb = aa.z(oVar.her());
        } else {
            StringBuilder sb2 = new StringBuilder();
            bg.aVF();
            sb = sb2.append(com.tencent.mm.model.c.aTi()).append("web/").append(com.tencent.mm.b.g.getMessageDigest(Util.nullAs(this.dKT.dFN, "").getBytes())).toString();
        }
        AppMethodBeat.o(27924);
        return sb;
    }

    private void c(com.tencent.mm.plugin.record.a.j jVar) {
        final int i2;
        final int i3;
        final int i4;
        AppMethodBeat.i(27925);
        if (jVar != null) {
            int max = (int) ((((float) jVar.field_offset) / ((float) Math.max(1, jVar.field_totalLen))) * 100.0f);
            i3 = jVar.field_offset;
            i2 = jVar.field_totalLen;
            i4 = max;
        } else {
            i2 = (int) this.dKT.LvI;
            i3 = 0;
            i4 = 0;
        }
        this.hAk.post(new Runnable() {
            /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(27898);
                RecordMsgFileUI.this.progressBar.setProgress(i4);
                RecordMsgFileUI.this.progressTips.setText(RecordMsgFileUI.this.getString(R.string.c9p, new Object[]{Util.getLengthStr((float) i3), Util.getLengthStr((float) i2)}));
                AppMethodBeat.o(27898);
            }
        });
        AppMethodBeat.o(27925);
    }

    @Override // com.tencent.mm.plugin.record.a.d
    public final void a(int i2, com.tencent.mm.plugin.record.a.j jVar) {
        AppMethodBeat.i(27926);
        if (jVar == null) {
            Log.w("MicroMsg.RecordMsgFileUI", "on cdn info changed, but cdn info is null");
            AppMethodBeat.o(27926);
            return;
        }
        Log.v("MicroMsg.RecordMsgFileUI", "cur mediaid[%s], notify mediaid[%s]", this.mediaId, jVar.field_mediaId);
        if (!this.mediaId.equals(jVar.field_mediaId)) {
            AppMethodBeat.o(27926);
            return;
        }
        switch (jVar.field_status) {
            case 2:
                this.hAk.post(new Runnable() {
                    /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(27899);
                        RecordMsgFileUI.this.enableOptionMenu(true);
                        RecordMsgFileUI.r(RecordMsgFileUI.this);
                        AppMethodBeat.o(27899);
                    }
                });
                a(jVar, true);
                fP(0, 2);
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1203, 5, this.dKT.LvI, false);
                AppMethodBeat.o(27926);
                return;
            case 3:
                this.hAk.post(new Runnable() {
                    /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(27901);
                        RecordMsgFileUI.h(RecordMsgFileUI.this);
                        h.cD(RecordMsgFileUI.this.getContext(), RecordMsgFileUI.this.getString(R.string.bnp));
                        AppMethodBeat.o(27901);
                    }
                });
                a(jVar, false);
                fP(1, 4);
                AppMethodBeat.o(27926);
                return;
            case 4:
                a(jVar, false);
                this.hAk.post(new Runnable() {
                    /* class com.tencent.mm.plugin.record.ui.RecordMsgFileUI.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(27900);
                        RecordMsgFileUI.s(RecordMsgFileUI.this);
                        AppMethodBeat.o(27900);
                    }
                });
                fP(1, 3);
                AppMethodBeat.o(27926);
                return;
            default:
                c(jVar);
                AppMethodBeat.o(27926);
                return;
        }
    }

    private void bLd() {
        AppMethodBeat.i(27927);
        if (this.thV) {
            AppMethodBeat.o(27927);
            return;
        }
        this.thV = true;
        Intent intent = new Intent();
        intent.putExtra("key_detail_fav_path", p.c(this.dKT, this.msgId));
        intent.putExtra("key_detail_fav_thumb_path", p.f(this.dKT, this.msgId));
        intent.putExtra("key_detail_fav_video_duration", this.dKT.duration);
        intent.putExtra("key_detail_statExtStr", this.dKT.ean);
        intent.putExtra("key_detail_fav_video_scene_from", 1);
        intent.putExtra("key_detail_msg_uuid", this.dKT.jsz);
        com.tencent.mm.plugin.fav.a.b.b(this, ".ui.detail.FavoriteVideoPlayUI", intent);
        finish();
        AppMethodBeat.o(27927);
    }

    private void fP(int i2, int i3) {
        AppMethodBeat.i(27928);
        if (8 == getType()) {
            int i4 = this.dKT.LvI > 26214400 ? 7 : 5;
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1203, (long) i3, 1, false);
            String format = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", this.dKT.KuR, Integer.valueOf(i4), Long.valueOf(this.dKT.LvI), Integer.valueOf(i2), Long.valueOf((cl.aWz() - this.dTX.field_createTime) / 1000), this.dKT.LvC, this.dTX.field_talker, 2, this.dKT.dLl, Long.valueOf(this.dTX.field_msgSvrId), Long.valueOf(this.dTX.field_createTime));
            Log.i("MicroMsg.RecordMsgFileUI", "reportKVStat 14665 %s", format);
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(14665, format);
        }
        AppMethodBeat.o(27928);
    }

    private void a(com.tencent.mm.plugin.record.a.j jVar, boolean z) {
        AppMethodBeat.i(27929);
        if (1 == jVar.field_type && ((jVar.field_fileType == com.tencent.mm.i.a.gpO || jVar.field_fileType == com.tencent.mm.i.a.MediaType_FILE) && this.wir)) {
            try {
                ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).a(false, jVar.field_dataId, ((l) g.af(l.class)).eiy().Hb(Long.valueOf(jVar.field_mediaId.split("@")[2]).longValue()).field_msgSvrId, z);
                AppMethodBeat.o(27929);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(27929);
    }

    static /* synthetic */ void a(RecordMsgFileUI recordMsgFileUI, String str) {
        AppMethodBeat.i(27932);
        com.tencent.mm.pluginsdk.ui.tools.a.b(recordMsgFileUI, str, recordMsgFileUI.dKT.LvC, 5);
        AppMethodBeat.o(27932);
    }

    static /* synthetic */ void j(RecordMsgFileUI recordMsgFileUI) {
        int i2 = 1;
        AppMethodBeat.i(232039);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        if (recordMsgFileUI.getType() == 15) {
            i2 = 11;
            intent.putExtra("image_path", recordMsgFileUI.eIB());
        } else if (recordMsgFileUI.getType() == 4) {
            intent.putExtra("image_path", recordMsgFileUI.eIB());
        } else {
            intent.putExtra("desc_title", recordMsgFileUI.dKT.title);
            i2 = 3;
        }
        intent.putExtra("Retr_Msg_Type", i2);
        com.tencent.mm.br.c.c(recordMsgFileUI, ".ui.transmit.SelectConversationUI", intent, 1001);
        AppMethodBeat.o(232039);
    }
}
