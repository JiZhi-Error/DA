package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;

@a(3)
public class FavoriteVideoPlayUI extends MMActivity {
    private String dLl;
    private boolean dUo = true;
    private String fullPath;
    private boolean isAnimated = false;
    private ImageView jUG;
    private String jsz;
    private long msgId;
    private Bundle qaD;
    private e qaE;
    private int qaF = 0;
    private int qaG = 0;
    private int qaH = 0;
    private int qaI = 0;
    private String taf = "";
    private String thumbPath;
    private boolean tiS = true;
    private View.OnLongClickListener tib = new View.OnLongClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.AnonymousClass3 */

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(107260);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            if (!FavoriteVideoPlayUI.this.tjl.ZA) {
                Log.i("MicroMsg.FavoriteVideoPlayUI", "longClickListener onClick isPrepared:false");
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(107260);
            } else {
                view.getTag();
                com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) FavoriteVideoPlayUI.this.getContext(), 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(107258);
                        if (FavoriteVideoPlayUI.this.tjn) {
                            if (s.YS(FavoriteVideoPlayUI.this.thumbPath)) {
                                mVar.add(0, 1, 0, FavoriteVideoPlayUI.this.getString(R.string.cc8));
                            }
                            mVar.add(0, 2, 0, FavoriteVideoPlayUI.this.getString(R.string.gav));
                        }
                        AppMethodBeat.o(107258);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.AnonymousClass3.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(107259);
                        switch (menuItem.getItemId()) {
                            case 1:
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                intent.putExtra("mutil_select_is_ret", true);
                                if (s.YS(FavoriteVideoPlayUI.this.thumbPath)) {
                                    intent.putExtra("image_path", FavoriteVideoPlayUI.this.thumbPath);
                                } else {
                                    intent.putExtra("image_path", FavoriteVideoPlayUI.this.fullPath);
                                }
                                intent.putExtra("Retr_Msg_Type", 1);
                                c.c(FavoriteVideoPlayUI.this.getContext(), ".ui.transmit.SelectConversationUI", intent, 1);
                                if (FavoriteVideoPlayUI.this.tjo == 0) {
                                    h.w(FavoriteVideoPlayUI.this.getIntent().getLongExtra("key_detail_info_id", 0), 1);
                                    AppMethodBeat.o(107259);
                                    return;
                                }
                                break;
                            case 2:
                                FavoriteVideoPlayUI favoriteVideoPlayUI = FavoriteVideoPlayUI.this;
                                String str = FavoriteVideoPlayUI.this.fullPath;
                                p.b(favoriteVideoPlayUI.getContext(), str, new p.a(str, FavoriteVideoPlayUI.this) {
                                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.AnonymousClass4 */
                                    final /* synthetic */ String cJK;
                                    final /* synthetic */ Context val$context;

                                    {
                                        this.cJK = r2;
                                        this.val$context = r3;
                                    }

                                    @Override // com.tencent.mm.platformtools.p.a
                                    public final void bP(String str, final String str2) {
                                        AppMethodBeat.i(235338);
                                        Log.i("MicroMsg.FavoriteVideoPlayUI", "save video now video path %s out path %s", this.cJK, str2);
                                        Toast.makeText(FavoriteVideoPlayUI.this.getContext(), this.val$context.getString(R.string.hwu, AndroidMediaUtil.getFriendlySdcardPath(str2)), 1).show();
                                        com.tencent.mm.pluginsdk.ui.tools.s.refreshMediaScanner(str2, FavoriteVideoPlayUI.this.getContext());
                                        com.tencent.f.h.RTc.aX(new Runnable() {
                                            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.AnonymousClass4.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(235337);
                                                String bhK = s.bhK(str2);
                                                v vVar = v.jNy;
                                                v.bR(bhK, FavoriteVideoPlayUI.this.jsz);
                                                AppMethodBeat.o(235337);
                                            }
                                        });
                                        AppMethodBeat.o(235338);
                                    }

                                    @Override // com.tencent.mm.platformtools.p.a
                                    public final void bQ(String str, String str2) {
                                        AppMethodBeat.i(235339);
                                        Log.i("MicroMsg.FavoriteVideoPlayUI", "save video now video path %s out path %s", this.cJK, str2);
                                        Toast.makeText(this.val$context, this.val$context.getString(R.string.hwt), 1).show();
                                        AppMethodBeat.o(235339);
                                    }
                                });
                                break;
                        }
                        AppMethodBeat.o(107259);
                    }
                };
                eVar.dGm();
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(107260);
            }
            return true;
        }
    };
    private String tjj;
    private RelativeLayout tjk;
    private FavVideoView tjl;
    private LinearLayout tjm;
    private boolean tjn = true;
    private int tjo;
    private boolean tjp = false;
    private boolean tjq = true;
    private boolean tjr = false;
    private int videoDuration;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavoriteVideoPlayUI() {
        AppMethodBeat.i(107266);
        AppMethodBeat.o(107266);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        String str;
        Bitmap asm;
        AppMethodBeat.i(107267);
        super.onCreate(bundle);
        hideTitleView();
        if (d.oD(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        this.qaD = bundle;
        getWindow().addFlags(128);
        this.tjn = getIntent().getBooleanExtra("key_detail_data_valid", true);
        this.fullPath = getIntent().getStringExtra("key_detail_fav_path");
        this.thumbPath = getIntent().getStringExtra("key_detail_fav_thumb_path");
        this.videoDuration = getIntent().getIntExtra("key_detail_fav_video_duration", 0);
        this.tjj = getIntent().getStringExtra("key_detail_statExtStr");
        this.tjo = getIntent().getIntExtra("key_detail_fav_video_scene_from", 0);
        this.dUo = getIntent().getBooleanExtra("show_share", true);
        this.tjp = getIntent().getBooleanExtra("key_detail_fav_video_show_download_status", false);
        this.taf = getIntent().getStringExtra("key_detail_data_id");
        this.tjq = getIntent().getBooleanExtra("key_detail_is_data_exist", true);
        this.dLl = getIntent().getStringExtra("record_data_id");
        this.msgId = getIntent().getLongExtra("message_id", -1);
        this.jsz = getIntent().getStringExtra("key_detail_msg_uuid");
        if (!s.YS(this.thumbPath) && (asm = com.tencent.mm.plugin.fav.ui.e.asm(this.fullPath)) != null) {
            try {
                Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: create thumbpath bitmap, saveBitmapToImage ");
                BitmapUtil.saveBitmapToImage(asm, 60, Bitmap.CompressFormat.JPEG, this.thumbPath, true);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FavoriteVideoPlayUI", e2, "", new Object[0]);
            }
        }
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.tjn);
        objArr[1] = Util.isNullOrNil(this.thumbPath) ? "" : this.thumbPath;
        if (Util.isNullOrNil(this.fullPath)) {
            str = "";
        } else {
            str = this.fullPath;
        }
        objArr[2] = str;
        Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: init data, isVideoValid: %B. thumbPath: %s, fullPath: %s", objArr);
        this.tjk = (RelativeLayout) findViewById(R.id.j6x);
        this.tjl = (FavVideoView) findViewById(R.id.j6y);
        ImageView imageView = (ImageView) findViewById(R.id.j6m);
        this.jUG = (ImageView) findViewById(R.id.dcj);
        this.tjm = (LinearLayout) findViewById(R.id.cbv);
        if (!this.tjn && this.tjm != null) {
            this.tjm.setVisibility(0);
        }
        if (Util.isNullOrNil(this.fullPath)) {
            h(imageView);
        } else if (s.YS(this.fullPath)) {
            this.tjl.setVideoData(this.fullPath);
            Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  videoView.setVideoData(fullPath)");
        } else {
            h(imageView);
        }
        if (this.dUo) {
            this.tjl.setOnLongClickListener(this.tib);
        }
        this.qaE = new e(null);
        this.tjl.setCallback(new FavVideoView.b() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.fav.ui.widget.FavVideoView.b
            public final void finish() {
                AppMethodBeat.i(107256);
                FavoriteVideoPlayUI.this.cvQ();
                AppMethodBeat.o(107256);
            }
        });
        this.tjl.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(107257);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (FavoriteVideoPlayUI.this.tjl != null) {
                    FavoriteVideoPlayUI.this.tjl.cWU();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(107257);
            }
        });
        AppMethodBeat.o(107267);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a86;
    }

    private void h(ImageView imageView) {
        AppMethodBeat.i(107268);
        if (this.tjq) {
            this.tjl.c(this.fullPath, this.tjp, this.taf);
            if (imageView != null) {
                if (s.YS(this.thumbPath)) {
                    imageView.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(this.thumbPath, 1.0f));
                } else {
                    imageView.setImageResource(R.drawable.c3w);
                }
            }
        } else {
            ((g) com.tencent.mm.kernel.g.af(g.class)).h(getIntent().getStringExtra("record_xml"), this.msgId, this.dLl);
            this.tjl.c(this.fullPath, true, this.dLl);
            this.tjl.setThumbView(this.thumbPath);
        }
        Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: fullPath is not null,but not exist videoView.setVideoData(null)");
        AppMethodBeat.o(107268);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(107270);
        Bundle bundle = this.qaD;
        if (!this.isAnimated) {
            this.isAnimated = true;
            if (Build.VERSION.SDK_INT >= 12) {
                this.qaF = getIntent().getIntExtra("img_gallery_top", 0);
                this.qaG = getIntent().getIntExtra("img_gallery_left", 0);
                this.qaH = getIntent().getIntExtra("img_gallery_width", 0);
                this.qaI = getIntent().getIntExtra("img_gallery_height", 0);
                this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
                if (bundle == null) {
                    this.tjl.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.AnonymousClass6 */

                        public final boolean onPreDraw() {
                            AppMethodBeat.i(164103);
                            FavoriteVideoPlayUI.this.tjl.getViewTreeObserver().removeOnPreDrawListener(this);
                            FavoriteVideoPlayUI.this.qaE.a(FavoriteVideoPlayUI.this.tjl, FavoriteVideoPlayUI.this.jUG, new e.c() {
                                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.AnonymousClass6.AnonymousClass1 */

                                @Override // com.tencent.mm.ui.tools.e.c
                                public final void onAnimationStart() {
                                    AppMethodBeat.i(164102);
                                    if (FavoriteVideoPlayUI.this.tjl != null) {
                                        FavoriteVideoPlayUI.this.tjl.onResume();
                                    }
                                    AppMethodBeat.o(164102);
                                }

                                @Override // com.tencent.mm.ui.tools.e.c
                                public final void onAnimationEnd() {
                                }
                            });
                            AppMethodBeat.o(164103);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
        AppMethodBeat.o(107270);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(107271);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  onResume,hadOnStart is %B", Boolean.valueOf(this.tiS));
        this.tiS = false;
        super.onResume();
        if (this.tjr) {
            this.tjl.cWY();
        }
        f.e(true, true, true);
        AppMethodBeat.o(107271);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(107272);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        if (this.tjl.isPlaying()) {
            this.tjr = true;
        }
        FavVideoView favVideoView = this.tjl;
        Log.i("MicroMsg.FavVideoView", "VideoPlay:   onPause()");
        favVideoView.cWW();
        favVideoView.cWX();
        super.onPause();
        f.e(false, true, true);
        AppMethodBeat.o(107272);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(107273);
        setResult(0, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
        this.tjl.onDestroy();
        getWindow().clearFlags(128);
        super.onDestroy();
        AppMethodBeat.o(107273);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(107274);
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(107274);
        return dispatchKeyEvent;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(107275);
        if (i2 == 1 && -1 == i3) {
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            final q a2 = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
            AnonymousClass5 r8 = new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(164101);
                    a2.dismiss();
                    AppMethodBeat.o(164101);
                }
            };
            if (Util.isNullOrNil(stringExtra)) {
                AppMethodBeat.o(107275);
                return;
            }
            for (String str : Util.stringsToList(stringExtra.split(","))) {
                AppCompatActivity context = getContext();
                String str2 = this.fullPath;
                String str3 = this.thumbPath;
                int i4 = this.videoDuration;
                String str4 = this.tjj;
                String str5 = this.jsz;
                if (context == null) {
                    Log.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
                } else if (Util.isNullOrNil(str)) {
                    Log.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
                } else {
                    com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str2);
                    if (!Util.isNullOrNil(str2) || oVar.exists()) {
                        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable(context, str, str2, str3, i4, str4, str5, r8) {
                            /* class com.tencent.mm.plugin.fav.ui.l.AnonymousClass6 */
                            final /* synthetic */ String dnJ;
                            final /* synthetic */ String iYw;
                            final /* synthetic */ int moi;
                            final /* synthetic */ String teL;
                            final /* synthetic */ String tfM;
                            final /* synthetic */ String tfN;
                            final /* synthetic */ Runnable val$callback;
                            final /* synthetic */ Context val$context;

                            {
                                this.val$context = r1;
                                this.dnJ = r2;
                                this.tfM = r3;
                                this.iYw = r4;
                                this.moi = r5;
                                this.tfN = r6;
                                this.teL = r7;
                                this.val$callback = r8;
                            }

                            public final void run() {
                                AppMethodBeat.i(106893);
                                Context context = this.val$context;
                                String str = this.dnJ;
                                String str2 = this.tfM;
                                String str3 = this.iYw;
                                int i2 = this.moi;
                                String str4 = this.tfN;
                                String str5 = this.teL;
                                com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str2);
                                if (oVar.exists()) {
                                    Log.i("MicroMsg.FavSendLogic", "sendVideo::data path[%s] thumb path[%s]", aa.z(oVar.her()), aa.z(new com.tencent.mm.vfs.o(str3).her()));
                                    com.tencent.mm.plugin.messenger.a.g.eir().a(context, str, aa.z(oVar.her()), str3, 1, i2, str4, str5);
                                }
                                MMHandlerThread.postToMainThread(this.val$callback);
                                AppMethodBeat.o(106893);
                            }

                            public final String toString() {
                                AppMethodBeat.i(106894);
                                String str = super.toString() + "|sendFavVideo";
                                AppMethodBeat.o(106894);
                                return str;
                            }
                        });
                    } else {
                        Log.w("MicroMsg.FavSendLogic", "want to send fav video, but datapath is null or is not exist ");
                    }
                }
                if (!Util.isNullOrNil(stringExtra2)) {
                    com.tencent.mm.plugin.messenger.a.g.eir().ad(str, stringExtra2, ab.JG(str));
                }
            }
            com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.c8o));
            AppMethodBeat.o(107275);
            return;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(107275);
    }

    public final void cvQ() {
        AppMethodBeat.i(107276);
        this.tjm.setVisibility(8);
        int width = this.tjk.getWidth();
        int height = this.tjk.getHeight();
        if (!(this.qaH == 0 || this.qaI == 0)) {
            height = (int) ((((float) width) / ((float) this.qaH)) * ((float) this.qaI));
        }
        this.qaE.ls(width, height);
        this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
        this.qaE.a(this.tjl, this.jUG, new e.c() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.AnonymousClass7 */

            @Override // com.tencent.mm.ui.tools.e.c
            public final void onAnimationStart() {
            }

            @Override // com.tencent.mm.ui.tools.e.c
            public final void onAnimationEnd() {
                AppMethodBeat.i(164105);
                new MMHandler().post(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI.AnonymousClass7.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(164104);
                        FavoriteVideoPlayUI.this.finish();
                        FavoriteVideoPlayUI.this.overridePendingTransition(0, 0);
                        AppMethodBeat.o(164104);
                    }
                });
                AppMethodBeat.o(164105);
            }
        }, null);
        AppMethodBeat.o(107276);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(107277);
        cvQ();
        AppMethodBeat.o(107277);
    }
}
