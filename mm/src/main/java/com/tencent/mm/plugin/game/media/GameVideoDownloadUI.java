package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.q;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class GameVideoDownloadUI extends MMActivity {
    private static final String xCf = (b.c(b.a.ONE_WEEK) + "haowan/");
    private String Mc;
    private String mAppId;
    private Context mContext;
    private String mFilePath;
    private int mFrom;
    private long njp = 0;
    private int xAD = 0;
    private String xCg;
    private CycleProgressView xCh;
    private a xCi;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ Map a(GameVideoDownloadUI gameVideoDownloadUI, int i2) {
        AppMethodBeat.i(204135);
        Map Oi = gameVideoDownloadUI.Oi(i2);
        AppMethodBeat.o(204135);
        return Oi;
    }

    static /* synthetic */ void a(GameVideoDownloadUI gameVideoDownloadUI) {
        AppMethodBeat.i(41139);
        gameVideoDownloadUI.dUB();
        AppMethodBeat.o(41139);
    }

    static /* synthetic */ void a(GameVideoDownloadUI gameVideoDownloadUI, String str) {
        AppMethodBeat.i(41140);
        gameVideoDownloadUI.azZ(str);
        AppMethodBeat.o(41140);
    }

    static {
        AppMethodBeat.i(41142);
        AppMethodBeat.o(41142);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41131);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        setSelfNavigationBarVisible(8);
        getWindow().addFlags(2097280);
        getWindow().setFlags(201327616, 201327616);
        this.mContext = this;
        this.mFrom = getIntent().getIntExtra("from", -1);
        this.xCg = getIntent().getStringExtra("business_type");
        this.mAppId = getIntent().getStringExtra("appid");
        final String stringExtra = getIntent().getStringExtra("video_url");
        String stringExtra2 = getIntent().getStringExtra("thumb_url");
        this.xAD = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
        this.xCh = (CycleProgressView) findViewById(R.id.bk8);
        findViewById(R.id.btr).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.game.media.GameVideoDownloadUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(41120);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/media/GameVideoDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                GameVideoDownloadUI.a(GameVideoDownloadUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/media/GameVideoDownloadUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(41120);
            }
        });
        final ImageView imageView = (ImageView) findViewById(R.id.j55);
        final ImageView imageView2 = (ImageView) findViewById(R.id.j4c);
        int screenWidth = c.getScreenWidth(this.mContext);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView2.getLayoutParams();
        layoutParams.width = screenWidth;
        layoutParams.height = (screenWidth * 1080) / 1920;
        imageView2.setLayoutParams(layoutParams);
        imageView.setVisibility(8);
        imageView2.setVisibility(0);
        com.tencent.mm.av.a.a bcV = q.bcV();
        c.a aVar = new c.a();
        aVar.jbf = true;
        bcV.a(stringExtra2, imageView, aVar.bdv(), new h() {
            /* class com.tencent.mm.plugin.game.media.GameVideoDownloadUI.AnonymousClass2 */

            @Override // com.tencent.mm.av.a.c.h
            public final void b(String str, View view) {
            }

            @Override // com.tencent.mm.av.a.c.h
            public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                return null;
            }

            @Override // com.tencent.mm.av.a.c.h
            public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                AppMethodBeat.i(41122);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.game.media.GameVideoDownloadUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(41121);
                        imageView.setVisibility(0);
                        imageView2.setVisibility(8);
                        AppMethodBeat.o(41121);
                    }
                });
                AppMethodBeat.o(41122);
            }
        });
        Bundle bundleExtra = getIntent().getBundleExtra("ext_data");
        if (bundleExtra != null) {
            this.mFilePath = bundleExtra.getString("key_video_cache_path");
            this.Mc = bundleExtra.getString("key_video_media_id");
        }
        Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "video cache path:%s", this.mFilePath);
        if (!s.YS(this.mFilePath)) {
            this.mFilePath = xCf + "MMVideo_" + MD5Util.getMD5String(stringExtra) + ".mp4";
        }
        if (Util.isNullOrNil(this.Mc)) {
            this.Mc = "MMVideo_" + MD5Util.getMD5String(stringExtra);
        }
        if (NetStatusUtil.isWifi(this) || this.mFrom != 3) {
            azZ(stringExtra);
        } else {
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dt3), "", getString(R.string.dt1), getString(R.string.dt0), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.game.media.GameVideoDownloadUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(41123);
                    GameVideoDownloadUI.a(GameVideoDownloadUI.this, stringExtra);
                    AppMethodBeat.o(41123);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.game.media.GameVideoDownloadUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(41124);
                    if (GameVideoDownloadUI.this.mFrom == 3) {
                        n.d(GameVideoDownloadUI.this.xCg, "video download cancel", GameVideoDownloadUI.this.mAppId, -2, "video download cancel");
                    } else if (GameVideoDownloadUI.this.mFrom == 5) {
                        GameVideoDownloadUI.this.setResult(-1, new Intent().putExtra("webview_callback_err", 1));
                    }
                    GameVideoDownloadUI.this.finish();
                    AppMethodBeat.o(41124);
                }
            });
        }
        Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "onCreate");
        com.tencent.mm.game.report.b.a.a(this, 8760, 0, 1, this.mAppId, this.xAD, com.tencent.mm.game.report.b.a.c(this.mFrom, null));
        AppMethodBeat.o(41131);
    }

    private void azZ(String str) {
        AppMethodBeat.i(41132);
        final View findViewById = findViewById(R.id.epy);
        a(str, new g.a() {
            /* class com.tencent.mm.plugin.game.media.GameVideoDownloadUI.AnonymousClass5 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.plugin.game.api.g.a
            public final void an(String str, int i2, int i3) {
                AppMethodBeat.i(41126);
                if (str != null && str.endsWith(".temp")) {
                    String replace = str.replace(".temp", "");
                    s.nx(str, replace);
                    Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "download videoPath:%s", replace);
                    str = replace;
                }
                switch (i2) {
                    case 0:
                        com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.this.mContext, 8760, 0, 48, GameVideoDownloadUI.this.mAppId, GameVideoDownloadUI.this.xAD, com.tencent.mm.game.report.b.a.c(GameVideoDownloadUI.this.mFrom, GameVideoDownloadUI.a(GameVideoDownloadUI.this, 0)));
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.game.media.GameVideoDownloadUI.AnonymousClass5.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(41125);
                                findViewById.setVisibility(8);
                                AppMethodBeat.o(41125);
                            }
                        });
                        Intent intent = new Intent();
                        intent.putExtras(GameVideoDownloadUI.this.getIntent().getExtras());
                        intent.putExtra("video_path", str);
                        com.tencent.mm.br.c.b(GameVideoDownloadUI.this.mContext, "game", ".media.GameVideoEditorProxyUI", intent, (int) TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM);
                        AppMethodBeat.o(41126);
                        return;
                    case 2:
                        com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.this.mContext, 8760, 0, 56, GameVideoDownloadUI.this.mAppId, GameVideoDownloadUI.this.xAD, com.tencent.mm.game.report.b.a.c(GameVideoDownloadUI.this.mFrom, GameVideoDownloadUI.a(GameVideoDownloadUI.this, i3)));
                        if (GameVideoDownloadUI.this.mFrom == 3) {
                            n.d(GameVideoDownloadUI.this.xCg, "video download err:".concat(String.valueOf(i3)), GameVideoDownloadUI.this.mAppId, -3, "video download err:".concat(String.valueOf(i3)));
                        } else if (GameVideoDownloadUI.this.mFrom == 5) {
                            GameVideoDownloadUI.this.setResult(-1, new Intent().putExtra("webview_callback_err", 2));
                        }
                        GameVideoDownloadUI.this.finish();
                        break;
                }
                AppMethodBeat.o(41126);
            }
        });
        AppMethodBeat.o(41132);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(41133);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 223) {
            setResult(i3, intent);
            finish();
        }
        AppMethodBeat.o(41133);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(41134);
        super.onDestroy();
        if (this.xCi != null) {
            MMHandlerThread.removeRunnable(this.xCi);
        }
        o.bhk().m(this.Mc, null);
        AppMethodBeat.o(41134);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(41135);
        super.onBackPressed();
        dUB();
        AppMethodBeat.o(41135);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.at0;
    }

    private void dUB() {
        AppMethodBeat.i(41136);
        Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "cancel video download!");
        com.tencent.mm.game.report.b.a.a(this.mContext, 8760, 1, 2, this.mAppId, this.xAD, com.tencent.mm.game.report.b.a.c(this.mFrom, Oi(0)));
        if (this.mFrom == 3) {
            n.d(this.xCg, "video download cancel", this.mAppId, -2, "video download cancel");
        } else if (this.mFrom == 5) {
            setResult(-1, new Intent().putExtra("webview_callback_err", 1));
        }
        finish();
        AppMethodBeat.o(41136);
    }

    private void a(final String str, final g.a aVar) {
        AppMethodBeat.i(41137);
        final long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.i.h hVar = new com.tencent.mm.i.h();
        hVar.taskName = "task_GameVideoDownloadUI";
        hVar.field_mediaId = this.Mc;
        hVar.url = str;
        hVar.gqU = 0;
        hVar.gqP = 3;
        hVar.concurrentCount = 4;
        s.boN(s.boZ(this.mFilePath));
        hVar.field_fullpath = this.mFilePath;
        hVar.gre = new h.a() {
            /* class com.tencent.mm.plugin.game.media.GameVideoDownloadUI.AnonymousClass6 */

            @Override // com.tencent.mm.i.h.a
            public final void Ds(String str) {
            }

            @Override // com.tencent.mm.i.h.a
            public final void a(String str, long j2, long j3, String str2) {
            }

            @Override // com.tencent.mm.i.h.a
            public final void onDataAvailable(String str, long j2, long j3) {
            }

            @Override // com.tencent.mm.i.h.a
            public final void i(String str, final long j2, final long j3) {
                AppMethodBeat.i(41128);
                Log.d("MicroMsg.Haowan.GameVideoDownloadUI", "download video offset:%d, total:%d", Long.valueOf(j2), Long.valueOf(j3));
                if (GameVideoDownloadUI.this.Mc.equals(str) && j3 != 0) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.game.media.GameVideoDownloadUI.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(41127);
                            GameVideoDownloadUI.this.xCh.setProgress((int) ((j2 * 100) / j3));
                            AppMethodBeat.o(41127);
                        }
                    });
                }
                AppMethodBeat.o(41128);
            }

            @Override // com.tencent.mm.i.h.a
            public final void a(String str, int i2, d dVar) {
                AppMethodBeat.i(41129);
                Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "download video mediaId:%s, rawMediaId:%s", str, GameVideoDownloadUI.this.Mc);
                if (GameVideoDownloadUI.this.Mc.equals(str)) {
                    Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "download video cost time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (i2 == 0) {
                        Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "download video[%s] success", str);
                    } else {
                        Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "download video[%s] fail, ret:%d", str, Integer.valueOf(i2));
                    }
                    if (i2 == 0 && !TextUtils.isEmpty(GameVideoDownloadUI.this.mFilePath)) {
                        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(GameVideoDownloadUI.this.mFilePath);
                        if (oVar.exists()) {
                            Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "download file size:%d", Long.valueOf(oVar.length()));
                            aVar.an(GameVideoDownloadUI.this.mFilePath, 0, 0);
                            AppMethodBeat.o(41129);
                            return;
                        }
                    }
                    u.makeText(GameVideoDownloadUI.this.mContext, (int) R.string.dt2, 1).show();
                    if (aVar != null) {
                        aVar.an(GameVideoDownloadUI.this.mFilePath, 2, i2);
                    }
                }
                AppMethodBeat.o(41129);
            }
        };
        this.njp = System.currentTimeMillis();
        this.xCi = new a(hVar);
        MMHandlerThread.postToMainThreadDelayed(this.xCi, 500);
        AppMethodBeat.o(41137);
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        private com.tencent.mm.i.h xCt;

        public a(com.tencent.mm.i.h hVar) {
            this.xCt = hVar;
        }

        public final void run() {
            AppMethodBeat.i(41130);
            if (this.xCt != null) {
                o.bhk().a(this.xCt, false);
            }
            AppMethodBeat.o(41130);
        }
    }

    private Map Oi(int i2) {
        long j2 = 0;
        AppMethodBeat.i(41138);
        if (this.njp != 0) {
            j2 = System.currentTimeMillis() - this.njp;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("costtime", Long.valueOf(j2));
        hashMap.put("failid", Integer.valueOf(i2));
        AppMethodBeat.o(41138);
        return hashMap;
    }
}
