package com.tencent.mm.plugin.fav.ui.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;

public class FavoriteSightDetailUI extends BaseFavDetailReportUI implements p, MStorage.IOnStorageChange {
    private aml dKT;
    private k tfE = new k();
    private g tfP;
    private boolean thR = false;
    private boolean thX = false;
    private View tiM;
    private ImageView tiN;
    private MMPinProgressBtn tiO;
    private VideoPlayerTextureView tiP;
    private ImageView tiQ;
    private long tiR;
    private boolean tiS = true;
    private boolean tiT = false;
    private Runnable tiU = new Runnable() {
        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.AnonymousClass5 */

        public final void run() {
            AppMethodBeat.i(107219);
            if (!FavoriteSightDetailUI.this.tfP.isDone() || !b.g(FavoriteSightDetailUI.this.dKT) || FavoriteSightDetailUI.this.tiP == null || !FavoriteSightDetailUI.this.tiP.isPlaying()) {
                FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, true);
                AppMethodBeat.o(107219);
                return;
            }
            AppMethodBeat.o(107219);
        }
    };
    private boolean tiV = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavoriteSightDetailUI() {
        AppMethodBeat.i(107222);
        AppMethodBeat.o(107222);
    }

    static /* synthetic */ void a(FavoriteSightDetailUI favoriteSightDetailUI, boolean z) {
        AppMethodBeat.i(107234);
        favoriteSightDetailUI.mG(z);
        AppMethodBeat.o(107234);
    }

    static /* synthetic */ void f(FavoriteSightDetailUI favoriteSightDetailUI) {
        AppMethodBeat.i(107235);
        favoriteSightDetailUI.cWD();
        AppMethodBeat.o(107235);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a8c;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI
    public final MMLoadScrollView cWr() {
        AppMethodBeat.i(107223);
        MMLoadScrollView mMLoadScrollView = (MMLoadScrollView) findViewById(R.id.hcs);
        AppMethodBeat.o(107223);
        return mMLoadScrollView;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(107224);
        h.q(this);
        super.onCreate(bundle);
        this.tiR = getIntent().getLongExtra("key_detail_info_id", -1);
        this.tfP = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.tiR);
        if (this.tfP == null) {
            Log.w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", Long.valueOf(this.tiR));
            finish();
            AppMethodBeat.o(107224);
            return;
        }
        H(this.tfP);
        m.x(this.tfP);
        a.a(this, this.tfP);
        this.dKT = b.c(this.tfP);
        this.tiN = (ImageView) findViewById(R.id.i59);
        this.tiO = (MMPinProgressBtn) findViewById(R.id.j62);
        this.tiM = findViewById(R.id.b3o);
        this.tiP = (VideoPlayerTextureView) findViewById(R.id.j6y);
        this.tiQ = (ImageView) findViewById(R.id.j6m);
        this.tiM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(107207);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (com.tencent.mm.q.a.cC(view.getContext()) || com.tencent.mm.q.a.cA(view.getContext()) || com.tencent.mm.q.a.cE(view.getContext())) {
                    a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107207);
                    return;
                }
                Log.i("MicroMsg.FavoriteSightDetailUI", "click item favid %d, localid %d, itemstatus %d", Integer.valueOf(FavoriteSightDetailUI.this.tfP.field_id), Long.valueOf(FavoriteSightDetailUI.this.tfP.field_localId), Integer.valueOf(FavoriteSightDetailUI.this.tfP.field_itemStatus));
                if (FavoriteSightDetailUI.this.tfP.isDone()) {
                    if (b.g(FavoriteSightDetailUI.this.dKT)) {
                        m.a(m.a.EnterFullScreen, FavoriteSightDetailUI.this.tfP);
                        FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, true, view.getContext());
                        a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(107207);
                        return;
                    } else if (Util.isNullOrNil(FavoriteSightDetailUI.this.dKT.KuR)) {
                        FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, view.getContext());
                        a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(107207);
                        return;
                    } else {
                        Log.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
                    }
                } else if (FavoriteSightDetailUI.this.tfP.cUz()) {
                    if (Util.isNullOrNil(FavoriteSightDetailUI.this.dKT.KuR)) {
                        FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, view.getContext());
                        a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(107207);
                        return;
                    }
                } else if (FavoriteSightDetailUI.this.tfP.isDownloading() || FavoriteSightDetailUI.this.tfP.cUx()) {
                    if (FavoriteSightDetailUI.this.tiO.getVisibility() == 8) {
                        FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false);
                    }
                    a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(107207);
                    return;
                }
                if (FavoriteSightDetailUI.this.tfP.cUy()) {
                    b.l(FavoriteSightDetailUI.this.tfP);
                } else {
                    b.m(FavoriteSightDetailUI.this.tfP);
                }
                FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false);
                a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(107207);
            }
        });
        this.tiP.setVideoCallback(new j.a() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.AnonymousClass2 */

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void tf() {
                AppMethodBeat.i(107210);
                Log.i("MicroMsg.FavoriteSightDetailUI", " onPrepared");
                FavoriteSightDetailUI.this.tiP.setLoop(true);
                FavoriteSightDetailUI.this.tiT = FavoriteSightDetailUI.this.tiP.start();
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(107208);
                        FavoriteSightDetailUI.this.tiQ.setVisibility(8);
                        AppMethodBeat.o(107208);
                    }
                });
                AppMethodBeat.o(107210);
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void onError(int i2, int i3) {
                AppMethodBeat.i(107211);
                Log.e("MicroMsg.FavoriteSightDetailUI", "VideoPlay: on play video error what %d extra %d.", Integer.valueOf(i2), Integer.valueOf(i3));
                if (i2 == -1) {
                    FavoriteSightDetailUI.this.tiP.stop();
                    if (s.YS(b.d(FavoriteSightDetailUI.this.dKT))) {
                        FavoriteSightDetailUI.f(FavoriteSightDetailUI.this);
                        AppMethodBeat.o(107211);
                        return;
                    }
                    if (s.YS(b.a(FavoriteSightDetailUI.this.dKT))) {
                        FavoriteSightDetailUI.this.tiQ.setVisibility(0);
                    }
                    AppMethodBeat.o(107211);
                } else if (FavoriteSightDetailUI.this.tiT) {
                    onCompletion();
                    AppMethodBeat.o(107211);
                } else {
                    FavoriteSightDetailUI.this.tiP.stop();
                    if (FavoriteSightDetailUI.this.thR) {
                        AppMethodBeat.o(107211);
                        return;
                    }
                    FavoriteSightDetailUI.this.thR = true;
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.AnonymousClass2.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(107209);
                            com.tencent.mm.ui.base.h.n(FavoriteSightDetailUI.this.getContext(), R.string.hwr, R.string.hxe);
                            AppMethodBeat.o(107209);
                        }
                    });
                    AppMethodBeat.o(107211);
                }
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void onCompletion() {
                AppMethodBeat.i(107212);
                FavoriteSightDetailUI.this.tiP.q(0.0d);
                AppMethodBeat.o(107212);
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final int fh(int i2, int i3) {
                return 0;
            }

            @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
            public final void eo(int i2, int i3) {
            }
        });
        setMMTitle(getString(R.string.c9_));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(107213);
                FavoriteSightDetailUI.this.finish();
                AppMethodBeat.o(107213);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.hp_, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(107218);
                e eVar = new e((Context) FavoriteSightDetailUI.this.getContext(), 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.AnonymousClass4.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                        AppMethodBeat.i(107214);
                        if ((FavoriteSightDetailUI.this.tfP.cUu() && !FavoriteSightDetailUI.this.tfE.u(FavoriteSightDetailUI.this.tfP)) && FavoriteSightDetailUI.this.dKT.Lwv == 0) {
                            mVar.d(0, FavoriteSightDetailUI.this.getString(R.string.cc8));
                        }
                        mVar.d(4, FavoriteSightDetailUI.this.getString(R.string.cbv));
                        mVar.d(3, FavoriteSightDetailUI.this.getString(R.string.c9s));
                        mVar.d(2, FavoriteSightDetailUI.this.getContext().getString(R.string.tf));
                        AppMethodBeat.o(107214);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.AnonymousClass4.AnonymousClass2 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(107217);
                        switch (menuItem.getItemId()) {
                            case 0:
                                com.tencent.mm.plugin.fav.a.h.w(FavoriteSightDetailUI.this.tfP.field_localId, 1);
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("scene_from", 1);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("select_fav_local_id", FavoriteSightDetailUI.this.tfP.field_localId);
                                c.c(FavoriteSightDetailUI.this.getContext(), ".ui.transmit.SelectConversationUI", intent, 1);
                                FavoriteSightDetailUI.this.thD.tar++;
                                AppMethodBeat.o(107217);
                                return;
                            case 2:
                                com.tencent.mm.ui.base.h.a(FavoriteSightDetailUI.this.getContext(), FavoriteSightDetailUI.this.getString(R.string.th), "", new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.AnonymousClass4.AnonymousClass2.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(107216);
                                        final q a2 = com.tencent.mm.ui.base.h.a((Context) FavoriteSightDetailUI.this.getContext(), FavoriteSightDetailUI.this.getString(R.string.th), false, (DialogInterface.OnCancelListener) null);
                                        b.b(FavoriteSightDetailUI.this.tfP.field_localId, new Runnable() {
                                            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.AnonymousClass4.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(107215);
                                                FavoriteSightDetailUI.this.thD.tav = true;
                                                a2.dismiss();
                                                Log.i("MicroMsg.FavoriteSightDetailUI", "do del fav file, local id %d, fav id %d", Long.valueOf(FavoriteSightDetailUI.this.tfP.field_localId), Integer.valueOf(FavoriteSightDetailUI.this.tfP.field_id));
                                                FavoriteSightDetailUI.this.finish();
                                                AppMethodBeat.o(107215);
                                            }
                                        });
                                        AppMethodBeat.o(107216);
                                    }
                                }, (DialogInterface.OnClickListener) null);
                                AppMethodBeat.o(107217);
                                return;
                            case 3:
                                FavoriteSightDetailUI.this.thD.tau++;
                                Intent intent2 = new Intent();
                                intent2.putExtra("key_fav_scene", 2);
                                intent2.putExtra("key_fav_item_id", FavoriteSightDetailUI.this.tfP.field_localId);
                                b.b(FavoriteSightDetailUI.this.getContext(), ".ui.FavTagEditUI", intent2);
                                AppMethodBeat.o(107217);
                                return;
                            case 4:
                                com.tencent.mm.plugin.fav.ui.j.a(FavoriteSightDetailUI.this, FavoriteSightDetailUI.this.tiR, FavoriteSightDetailUI.this.thD);
                                break;
                        }
                        AppMethodBeat.o(107217);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(107218);
                return true;
            }
        });
        if (s.YS(b.a(this.dKT))) {
            Bitmap a2 = com.tencent.mm.plugin.fav.ui.o.a(this.dKT, this.tfP);
            if (a2 != null) {
                int width = a2.getWidth();
                int height = a2.getHeight();
                if (!this.tiV) {
                    this.tiV = true;
                    DisplayMetrics displayMetrics = this.tiM.getResources().getDisplayMetrics();
                    float f2 = (displayMetrics.density * 36.0f) + 0.5f;
                    ViewGroup.LayoutParams layoutParams = this.tiM.getLayoutParams();
                    if (layoutParams == null) {
                        Log.e("MicroMsg.FavoriteSightDetailUI", "setViewResize, but params is null");
                    } else {
                        layoutParams.width = displayMetrics.widthPixels - ((int) f2);
                        layoutParams.height = (height * layoutParams.width) / width;
                        this.tiM.setLayoutParams(layoutParams);
                    }
                }
                this.tiQ.setImageBitmap(a2);
                this.tiQ.setVisibility(0);
            }
        } else if (!Util.isNullOrNil(this.dKT.iwX)) {
            b.a(this.tfP, this.dKT);
        }
        mG(false);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().add(this);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(this);
        h.r(this);
        AppMethodBeat.o(107224);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(107225);
        if (this.tiP != null) {
            this.tiP.setVideoCallback(null);
            this.tiP.stop();
        }
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().remove(this);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(this);
        super.onDestroy();
        AppMethodBeat.o(107225);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(107226);
        super.onResume();
        if (this.tiP != null) {
            if (!this.tiS) {
                cWD();
            } else if (!this.tiP.isPlaying()) {
                this.tiP.start();
            }
            this.tiS = false;
        }
        AppMethodBeat.o(107226);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(107227);
        if (this.tiP != null) {
            this.tiP.stop();
        }
        super.onPause();
        AppMethodBeat.o(107227);
    }

    @SuppressLint({"ResourceType"})
    private void mG(boolean z) {
        AppMethodBeat.i(107228);
        if (this.tfP.isDone()) {
            if (b.g(this.dKT)) {
                this.tiN.setVisibility(8);
                this.tiO.setVisibility(8);
                cWD();
                AppMethodBeat.o(107228);
                return;
            } else if (Util.isNullOrNil(this.dKT.KuR)) {
                this.tiN.setImageResource(R.raw.shortvideo_play_btn);
            } else {
                Log.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
                this.tiN.setImageResource(R.raw.shortvideo_play_btn);
            }
        } else if (this.tfP.cUz()) {
            if (Util.isNullOrNil(this.dKT.KuR)) {
                this.tiN.setImageResource(R.raw.shortvideo_play_btn);
                if (z) {
                }
            } else {
                this.tiN.setImageResource(R.raw.shortvideo_play_btn);
                if (z) {
                    com.tencent.mm.ui.base.h.cD(getContext(), getString(R.string.bnp));
                }
            }
        } else if (this.tfP.cUy()) {
            this.tiN.setImageResource(R.raw.shortvideo_play_btn);
            if (z) {
                com.tencent.mm.ui.base.h.cD(getContext(), getString(R.string.c8y));
            }
        } else if (this.tfP.isDownloading() || this.tfP.cUx()) {
            this.tiN.setVisibility(8);
            this.tiO.setVisibility(0);
            com.tencent.mm.plugin.fav.a.c asa = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(this.dKT.dLl);
            if (asa != null) {
                this.tiO.setProgress((int) asa.getProgress());
            } else {
                this.tiO.setProgress(0);
            }
            this.tiQ.setVisibility(0);
            AppMethodBeat.o(107228);
            return;
        } else {
            Log.w("MicroMsg.FavoriteSightDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
            this.tiN.setImageResource(R.raw.shortvideo_play_btn);
        }
        this.tiN.setVisibility(0);
        this.tiO.setVisibility(8);
        this.tiQ.setVisibility(0);
        AppMethodBeat.o(107228);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        boolean z;
        AppMethodBeat.i(107229);
        Log.i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", str, Long.valueOf(this.tfP.field_localId));
        g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.tfP.field_localId);
        if (DY == null) {
            Log.w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
            finish();
            AppMethodBeat.o(107229);
            return;
        }
        this.tfP = DY;
        this.dKT = b.c(DY);
        com.tencent.mm.plugin.fav.a.c asa = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(this.dKT.dLl);
        if (asa == null) {
            z = false;
        } else if (this.thX) {
            z = false;
        } else {
            if (asa.field_status == 4 && ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(this.dKT.dLl).field_extFlag != 0) {
                b.a(this.tfP, this.dKT, true);
                this.thX = true;
            }
            Log.i("MicroMsg.FavoriteSightDetailUI", "FavoriteFileDetail download, check retry, return %B", Boolean.valueOf(this.thX));
            z = this.thX;
        }
        if (z) {
            AppMethodBeat.o(107229);
            return;
        }
        MMHandlerThread.removeRunnable(this.tiU);
        MMHandlerThread.postToMainThreadDelayed(this.tiU, 500);
        AppMethodBeat.o(107229);
    }

    @Override // com.tencent.mm.plugin.fav.a.p
    public final void e(com.tencent.mm.plugin.fav.a.c cVar) {
        AppMethodBeat.i(107230);
        if (cVar == null || cVar.field_dataId == null) {
            Log.w("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, item is null");
            AppMethodBeat.o(107230);
            return;
        }
        Log.i("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s,offset is %d, total is %d,cdn status is %d, cdn type is %d (send or recieve)", this.dKT.dLl, cVar.field_dataId, Integer.valueOf(cVar.field_offset), Integer.valueOf(cVar.field_totalLen), Integer.valueOf(cVar.field_status), Integer.valueOf(cVar.field_type));
        if (cVar.field_offset > cVar.field_totalLen) {
            Log.e("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, cdn offset length > cdn total length, do cdnLengthError()");
            if (1 == cVar.field_type) {
                cVar.field_status = 2;
            } else {
                cVar.field_status = 4;
            }
            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(cVar, new String[0]);
            if (cVar.field_type == 0) {
                b.b(cVar);
            }
            if (cVar.field_type == 1) {
                b.c(cVar);
            }
        }
        if (cVar.field_dataId.equals(this.dKT.dLl)) {
            final int progress = (int) cVar.getProgress();
            this.tiO.post(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(107220);
                    FavoriteSightDetailUI.this.tiO.setProgress(progress);
                    AppMethodBeat.o(107220);
                }
            });
        }
        AppMethodBeat.o(107230);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String stringExtra;
        AppMethodBeat.i(107231);
        if (i2 == 1 && -1 == i3) {
            String stringExtra2 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                stringExtra = null;
            } else {
                stringExtra = intent.getStringExtra("custom_send_text");
            }
            final q a2 = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
            l.a(getContext(), stringExtra2, stringExtra, this.tfP, new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(107221);
                    a2.dismiss();
                    AppMethodBeat.o(107221);
                }
            });
            boolean Eq = ab.Eq(stringExtra2);
            m.a(Eq ? m.c.Chatroom : m.c.Chat, this.tfP, m.d.Samll, Eq ? v.Ie(stringExtra2) : 0);
            com.tencent.mm.ui.widget.snackbar.b.r(this, getString(R.string.c8o));
            AppMethodBeat.o(107231);
            return;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(107231);
    }

    private void cWD() {
        AppMethodBeat.i(107232);
        String d2 = b.d(this.dKT);
        if (!s.YS(d2)) {
            AppMethodBeat.o(107232);
            return;
        }
        this.tiP.stop();
        this.tiP.setMute(true);
        this.tiP.setVideoPath(d2);
        AppMethodBeat.o(107232);
    }

    static /* synthetic */ void a(FavoriteSightDetailUI favoriteSightDetailUI, boolean z, Context context) {
        AppMethodBeat.i(107233);
        aml c2 = b.c(favoriteSightDetailUI.tfP);
        if (c2 == null) {
            Log.e("MicroMsg.FavoriteSightDetailUI", "goPlayView, but dataitem is null , exit");
            AppMethodBeat.o(107233);
        } else if (c2.Lwn == null || (Util.isNullOrNil(c2.Lwn.iyZ) && Util.isNullOrNil(c2.Lwn.izd))) {
            Intent intent = new Intent();
            intent.putExtra("key_detail_info_id", favoriteSightDetailUI.tfP.field_localId);
            intent.putExtra("key_detail_fav_scene", favoriteSightDetailUI.thD.scene);
            intent.putExtra("key_detail_fav_sub_scene", favoriteSightDetailUI.thD.pHw);
            intent.putExtra("key_detail_fav_path", b.d(c2));
            intent.putExtra("key_detail_fav_thumb_path", b.a(c2));
            intent.putExtra("key_detail_fav_video_duration", c2.duration);
            intent.putExtra("key_detail_statExtStr", c2.ean);
            intent.putExtra("key_detail_data_valid", z);
            intent.putExtra("key_detail_msg_uuid", c2.jsz);
            b.b(context, ".ui.detail.FavoriteVideoPlayUI", intent);
            AppMethodBeat.o(107233);
        } else {
            Log.i("MicroMsg.FavoriteSightDetailUI", "it is ad sight.use sight play");
            Intent intent2 = new Intent();
            intent2.putExtra("key_detail_fav_scene", favoriteSightDetailUI.thD.scene);
            intent2.putExtra("key_detail_fav_sub_scene", favoriteSightDetailUI.thD.pHw);
            intent2.putExtra("key_detail_info_id", favoriteSightDetailUI.tfP.field_localId);
            intent2.putExtra("key_detail_data_id", c2.dLl);
            intent2.putExtra("key_detail_can_delete", false);
            b.b(context, ".ui.detail.FavoriteFileDetailUI", intent2);
            AppMethodBeat.o(107233);
        }
    }
}
