package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FavoriteImgDetailUI extends BaseFavDetailReportUI implements p {
    private View.OnClickListener dec = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass10 */

        public final void onClick(View view) {
            AppMethodBeat.i(107184);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("key_detail_info_id", FavoriteImgDetailUI.this.tcP.field_localId);
            intent.putExtra("key_detail_data_id", ((aml) view.getTag()).dLl);
            com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.this.getContext(), ".ui.FavImgGalleryUI", intent);
            FavoriteImgDetailUI.this.thD.taq++;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107184);
        }
    };
    private int displayWidth = 0;
    private ScanCodeSheetItemLogic mHu;
    private g tcP;
    private IListener teF = new IListener<qz>() {
        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass6 */

        {
            AppMethodBeat.i(164098);
            this.__eventId = qz.class.getName().hashCode();
            AppMethodBeat.o(164098);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qz qzVar) {
            AppMethodBeat.i(164099);
            qz qzVar2 = qzVar;
            String str = qzVar2.dXz.filePath;
            a aVar = null;
            for (a aVar2 : FavoriteImgDetailUI.this.tiq.values()) {
                if (!str.equals(com.tencent.mm.plugin.fav.a.b.d(aVar2.dKT))) {
                    aVar2 = aVar;
                }
                aVar = aVar2;
            }
            if (aVar != null) {
                aVar.tiH = Util.nullAs(qzVar2.dXz.result, "");
                aVar.dFL = qzVar2.dXz.dFL;
                aVar.dFM = qzVar2.dXz.dFM;
                if (!Util.isNullOrNil(aVar.tiH) && aVar.tiF.isShowing()) {
                    FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, aVar);
                }
            }
            AppMethodBeat.o(164099);
            return true;
        }
    };
    private View.OnLongClickListener tib = new View.OnLongClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass11 */

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(107185);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            a aVar = (a) FavoriteImgDetailUI.this.tiq.get(((aml) view.getTag()).dLl);
            FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, aVar);
            if (!aVar.tiG) {
                FavoriteImgDetailUI.b(aVar);
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(107185);
            return true;
        }
    };
    private LinearLayout tip;
    private HashMap<String, a> tiq = new HashMap<>();
    private Bitmap tir;
    private boolean tis = true;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavoriteImgDetailUI() {
        AppMethodBeat.i(107190);
        AppMethodBeat.o(107190);
    }

    static /* synthetic */ Bitmap a(FavoriteImgDetailUI favoriteImgDetailUI, aml aml) {
        AppMethodBeat.i(107203);
        Bitmap n = favoriteImgDetailUI.n(aml);
        AppMethodBeat.o(107203);
        return n;
    }

    static /* synthetic */ void c(a aVar) {
        aVar.tiG = false;
        aVar.tiJ = false;
        aVar.tiH = null;
        aVar.dFL = 0;
        aVar.dFM = 0;
    }

    /* access modifiers changed from: package-private */
    public class a {
        int dFL;
        int dFM;
        aml dKT;
        ImageView dKU;
        e tiF;
        boolean tiG;
        String tiH;
        boolean tiI;
        boolean tiJ;
        int tiK;
        int tiL;

        private a() {
            AppMethodBeat.i(107189);
            this.tiF = new e((Context) FavoriteImgDetailUI.this.getContext(), 1, false);
            this.tiG = false;
            this.tiH = null;
            this.dFL = 0;
            this.dFM = 0;
            this.tiI = false;
            this.tiK = 0;
            this.tiL = 0;
            AppMethodBeat.o(107189);
        }

        /* synthetic */ a(FavoriteImgDetailUI favoriteImgDetailUI, byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI
    public final MMLoadScrollView cWr() {
        AppMethodBeat.i(107191);
        MMLoadScrollView mMLoadScrollView = (MMLoadScrollView) findViewById(R.id.hcs);
        AppMethodBeat.o(107191);
        return mMLoadScrollView;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a8_;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(107192);
        h.q(this);
        super.onCreate(bundle);
        cWC();
        this.tip = (LinearLayout) findViewById(R.id.cca);
        final long longExtra = getIntent().getLongExtra("key_detail_info_id", -1);
        this.tcP = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(longExtra);
        if (this.tcP == null) {
            finish();
            AppMethodBeat.o(107192);
            return;
        }
        H(this.tcP);
        Iterator<aml> it = this.tcP.field_favProto.ppH.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            final aml next = it.next();
            Log.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", Integer.valueOf(i2), next.dLl);
            a aVar = new a(this, (byte) 0);
            aVar.dKT = next;
            int i3 = i2 + 1;
            final ImageView imageView = new ImageView(getContext());
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.k5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (i2 > 0) {
                layoutParams.topMargin = dimensionPixelSize;
            }
            this.tip.addView(imageView, layoutParams);
            imageView.setTag(next);
            final int i4 = dimensionPixelSize / 2;
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(i4, i4, i4, i4);
            imageView.setMinimumWidth(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 50));
            imageView.setMinimumHeight(com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 50));
            imageView.setImageResource(R.raw.fav_list_img_default);
            imageView.setOnClickListener(this.dec);
            imageView.setOnLongClickListener(this.tib);
            imageView.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass4 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(164096);
                    switch (motionEvent.getAction()) {
                        case 0:
                            int[] iArr = new int[2];
                            view.getLocationInWindow(iArr);
                            a aVar = (a) FavoriteImgDetailUI.this.tiq.get(next.dLl);
                            Log.i("MicroMsg.FavoriteImgDetailUI", "alvinluo scanImage locationInWindow: %s, %s, imageWidth: %s, imageHeight: %s, touch: %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(aVar.tiK), Integer.valueOf(aVar.tiL), Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()));
                            PointF a2 = m.a(imageView, (motionEvent.getRawX() - ((float) iArr[0])) - ((float) i4), (motionEvent.getRawY() - ((float) iArr[1])) - ((float) i4), aVar.tiK, aVar.tiL);
                            ad.b G = ad.aVe().G("basescanui@datacenter", true);
                            if (a2 == null) {
                                Log.e("MicroMsg.FavoriteImgDetailUI", "alvinluo get touchCoordinate is invalid");
                                G.l("key_basescanui_screen_position", Boolean.TRUE);
                                G.l("key_basescanui_screen_x", Float.valueOf(motionEvent.getRawX()));
                                G.l("key_basescanui_screen_y", Float.valueOf(motionEvent.getRawY()));
                                break;
                            } else {
                                G.l("key_basescanui_touch_normalize_x", Float.valueOf(a2.x));
                                G.l("key_basescanui_touch_normalize_y", Float.valueOf(a2.y));
                                break;
                            }
                    }
                    AppMethodBeat.o(164096);
                    return false;
                }
            });
            aVar.dKU = imageView;
            this.tiq.put(next.dLl, aVar);
            a(aVar);
            if (next.Lwv != 0) {
                this.tis = false;
            }
            i2 = i3;
        }
        setMMTitle(getString(R.string.c9_));
        a.a(this, this.tcP);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(107170);
                FavoriteImgDetailUI.this.finish();
                AppMethodBeat.o(107170);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.hp_, R.raw.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass7 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(107179);
                e eVar = new e((Context) FavoriteImgDetailUI.this.getContext(), 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass7.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                        AppMethodBeat.i(107175);
                        if (FavoriteImgDetailUI.this.tis) {
                            mVar.d(2, FavoriteImgDetailUI.this.getString(R.string.cc8));
                        }
                        mVar.d(3, FavoriteImgDetailUI.this.getString(R.string.cbv));
                        mVar.d(0, FavoriteImgDetailUI.this.getString(R.string.c9s));
                        mVar.d(1, FavoriteImgDetailUI.this.getContext().getString(R.string.tf));
                        AppMethodBeat.o(107175);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass7.AnonymousClass2 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(107178);
                        switch (menuItem.getItemId()) {
                            case 0:
                                Intent intent = new Intent();
                                intent.putExtra("key_fav_scene", 2);
                                intent.putExtra("key_fav_item_id", FavoriteImgDetailUI.this.tcP.field_localId);
                                com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.this.getContext(), ".ui.FavTagEditUI", intent);
                                FavoriteImgDetailUI.this.thD.tau++;
                                AppMethodBeat.o(107178);
                                return;
                            case 1:
                                com.tencent.mm.ui.base.h.a(FavoriteImgDetailUI.this.getContext(), FavoriteImgDetailUI.this.getString(R.string.th), "", new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass7.AnonymousClass2.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(107177);
                                        final q a2 = com.tencent.mm.ui.base.h.a((Context) FavoriteImgDetailUI.this.getContext(), FavoriteImgDetailUI.this.getString(R.string.th), false, (DialogInterface.OnCancelListener) null);
                                        com.tencent.mm.plugin.fav.a.b.b(FavoriteImgDetailUI.this.tcP.field_localId, new Runnable() {
                                            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass7.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(107176);
                                                FavoriteImgDetailUI.this.thD.tav = true;
                                                a2.dismiss();
                                                Log.d("MicroMsg.FavoriteImgDetailUI", "do del, local id %d", Long.valueOf(FavoriteImgDetailUI.this.tcP.field_localId));
                                                FavoriteImgDetailUI.this.finish();
                                                AppMethodBeat.o(107176);
                                            }
                                        });
                                        AppMethodBeat.o(107177);
                                    }
                                }, (DialogInterface.OnClickListener) null);
                                AppMethodBeat.o(107178);
                                return;
                            case 2:
                                Intent intent2 = new Intent();
                                intent2.putExtra("Select_Conv_Type", 3);
                                intent2.putExtra("scene_from", 1);
                                intent2.putExtra("mutil_select_is_ret", true);
                                intent2.putExtra("select_fav_local_id", FavoriteImgDetailUI.this.tcP.field_localId);
                                c.c(FavoriteImgDetailUI.this, ".ui.transmit.SelectConversationUI", intent2, 1);
                                com.tencent.mm.plugin.fav.a.h.w(FavoriteImgDetailUI.this.tcP.field_localId, 1);
                                FavoriteImgDetailUI.this.thD.tar++;
                                AppMethodBeat.o(107178);
                                return;
                            case 3:
                                j.a(FavoriteImgDetailUI.this, longExtra, FavoriteImgDetailUI.this.thD);
                                break;
                        }
                        AppMethodBeat.o(107178);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(107179);
                return true;
            }
        });
        h.r(this);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(this);
        EventCenter.instance.addListener(this.teF);
        this.mHu = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.b() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.b
            public final void asu(String str) {
                AppMethodBeat.i(107180);
                Log.i("MicroMsg.FavoriteImgDetailUI", "alvinluo onFetchedCodeInfo codeStr: %s", str);
                a aVar = null;
                for (a aVar2 : FavoriteImgDetailUI.this.tiq.values()) {
                    if (!str.equals(aVar2.tiH)) {
                        aVar2 = aVar;
                    }
                    aVar = aVar2;
                }
                if (aVar == null) {
                    AppMethodBeat.o(107180);
                    return;
                }
                if (aVar.tiF != null && aVar.tiF.isShowing()) {
                    FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, aVar);
                }
                AppMethodBeat.o(107180);
            }
        });
        AppMethodBeat.o(107192);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(107193);
        super.onResume();
        for (Map.Entry<String, a> entry : this.tiq.entrySet()) {
            a(entry.getValue());
        }
        AppMethodBeat.o(107193);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(107194);
        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(this);
        EventCenter.instance.removeListener(this.teF);
        super.onDestroy();
        AppMethodBeat.o(107194);
    }

    private void cWC() {
        DisplayMetrics displayMetrics;
        AppMethodBeat.i(107195);
        if (getResources() != null) {
            displayMetrics = getResources().getDisplayMetrics();
        } else {
            displayMetrics = MMApplicationContext.getResources().getDisplayMetrics();
        }
        this.displayWidth = displayMetrics.widthPixels - (getResources().getDimensionPixelOffset(R.dimen.e6) * 2);
        this.displayWidth = Math.max(this.displayWidth, 0);
        Log.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", Integer.valueOf(this.displayWidth));
        AppMethodBeat.o(107195);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(107196);
        super.onConfigurationChanged(configuration);
        cWC();
        for (Map.Entry<String, a> entry : this.tiq.entrySet()) {
            a(entry.getValue());
        }
        AppMethodBeat.o(107196);
    }

    private void a(final a aVar) {
        AppMethodBeat.i(107197);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(107183);
                final Bitmap a2 = com.tencent.mm.plugin.fav.ui.o.a(aVar.dKT, FavoriteImgDetailUI.this.tcP, false);
                if (a2 == null) {
                    Log.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
                    a2 = FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, aVar.dKT);
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass9.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(107181);
                        FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, aVar, a2);
                        AppMethodBeat.o(107181);
                    }

                    public final String toString() {
                        AppMethodBeat.i(107182);
                        String str = super.toString() + "|renderView";
                        AppMethodBeat.o(107182);
                        return str;
                    }
                });
                AppMethodBeat.o(107183);
            }
        });
        AppMethodBeat.o(107197);
    }

    public static void a(String str, final String str2, final Context context, final String str3) {
        AppMethodBeat.i(164100);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.FavoriteImgDetailUI", "save image fail, path is null");
            AppMethodBeat.o(164100);
            return;
        }
        com.tencent.mm.platformtools.p.a(context, str, new p.a() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass3 */

            @Override // com.tencent.mm.platformtools.p.a
            public final void bP(String str, final String str2) {
                AppMethodBeat.i(235334);
                Toast.makeText(context, context.getString(R.string.bjr, AndroidMediaUtil.getFriendlySdcardPath(str2)), 1).show();
                com.tencent.f.h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(235333);
                        String bhK = s.bhK(str2);
                        v vVar = v.jNy;
                        v.bR(bhK, str3);
                        AppMethodBeat.o(235333);
                    }
                });
                AppMethodBeat.o(235334);
            }

            @Override // com.tencent.mm.platformtools.p.a
            public final void bQ(String str, String str2) {
                AppMethodBeat.i(235335);
                Toast.makeText(context, str2, 1).show();
                AppMethodBeat.o(235335);
            }
        });
        AppMethodBeat.o(164100);
    }

    private Bitmap n(aml aml) {
        boolean z = true;
        AppMethodBeat.i(107199);
        Bitmap a2 = com.tencent.mm.plugin.fav.ui.o.a(aml, this.tcP);
        Object[] objArr = new Object[1];
        if (a2 == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.d("MicroMsg.FavoriteImgDetailUI", "get thumb ok ? %B", objArr);
        if (a2 != null) {
            AppMethodBeat.o(107199);
            return a2;
        }
        if (this.tir == null) {
            this.tir = com.tencent.mm.compatible.f.a.decodeResource(getResources(), R.raw.fav_list_img_default);
        }
        Bitmap bitmap = this.tir;
        AppMethodBeat.o(107199);
        return bitmap;
    }

    @Override // com.tencent.mm.plugin.fav.a.p
    public final void e(com.tencent.mm.plugin.fav.a.c cVar) {
        AppMethodBeat.i(107200);
        if (cVar == null || !cVar.isFinished()) {
            AppMethodBeat.o(107200);
            return;
        }
        Log.d("MicroMsg.FavoriteImgDetailUI", "on cdn status change, dataid[%s]", cVar.field_dataId);
        a aVar = this.tiq.get(cVar.field_dataId);
        if (aVar != null) {
            a(aVar);
        }
        AppMethodBeat.o(107200);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(107201);
        if (1 == i2) {
            if (-1 != i3) {
                AppMethodBeat.o(107201);
                return;
            }
            new k();
            if (k.v(this.tcP)) {
                com.tencent.mm.ui.base.h.cD(getContext(), getString(R.string.f3146c));
                AppMethodBeat.o(107201);
                return;
            }
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            Log.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", stringExtra);
            final q a2 = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.c_m), false, (DialogInterface.OnCancelListener) null);
            l.a(getContext(), stringExtra, stringExtra2, this.tcP, new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(164097);
                    a2.dismiss();
                    com.tencent.mm.ui.widget.snackbar.b.r(FavoriteImgDetailUI.this, FavoriteImgDetailUI.this.getString(R.string.c8o));
                    AppMethodBeat.o(164097);
                }
            });
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(107201);
    }

    static /* synthetic */ void a(FavoriteImgDetailUI favoriteImgDetailUI, final a aVar) {
        AppMethodBeat.i(107202);
        final e eVar = aVar.tiF;
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass12 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(107186);
                mVar.clear();
                eVar.setFooterView(null);
                if (FavoriteImgDetailUI.this.tis) {
                    if (FavoriteImgDetailUI.this.tcP.cUu()) {
                        mVar.d(2, FavoriteImgDetailUI.this.getContext().getString(R.string.cc8));
                    }
                    if (FavoriteImgDetailUI.this.tcP.cUv()) {
                        mVar.d(1, FavoriteImgDetailUI.this.getContext().getString(R.string.cau));
                    }
                    mVar.d(3, FavoriteImgDetailUI.this.getContext().getString(R.string.cc1));
                    if (!Util.isNullOrNil(aVar.tiH)) {
                        eVar.setFooterView(FavoriteImgDetailUI.b(FavoriteImgDetailUI.this, aVar));
                    }
                }
                AppMethodBeat.o(107186);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass13 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(107187);
                String d2 = com.tencent.mm.plugin.fav.a.b.d(aVar.dKT);
                if (!s.YS(d2)) {
                    Log.w("MicroMsg.FavoriteImgDetailUI", "file not exists");
                    AppMethodBeat.o(107187);
                    return;
                }
                switch (menuItem.getItemId()) {
                    case 1:
                        com.tencent.mm.plugin.fav.a.b.b(d2, FavoriteImgDetailUI.this.getContext());
                        com.tencent.mm.plugin.fav.a.h.w(FavoriteImgDetailUI.this.tcP.field_localId, 0);
                        AppMethodBeat.o(107187);
                        return;
                    case 2:
                        if (ImgUtil.isGif(d2)) {
                            Intent intent = new Intent();
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("select_is_ret", true);
                            c.c(FavoriteImgDetailUI.this, ".ui.transmit.SelectConversationUI", intent, 1);
                        } else {
                            com.tencent.mm.plugin.fav.a.b.a(d2, FavoriteImgDetailUI.this.getContext(), aVar.dKT.jsz);
                        }
                        com.tencent.mm.plugin.fav.a.h.w(FavoriteImgDetailUI.this.tcP.field_localId, 1);
                        AppMethodBeat.o(107187);
                        return;
                    case 3:
                        FavoriteImgDetailUI.a(d2, FavoriteImgDetailUI.this.getString(R.string.cc0), FavoriteImgDetailUI.this.getContext(), aVar.dKT.jsz);
                        break;
                }
                AppMethodBeat.o(107187);
            }
        };
        eVar.PGl = new e.b() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass14 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                AppMethodBeat.i(107188);
                FavoriteImgDetailUI.c(aVar);
                FavoriteImgDetailUI.this.mHu.onDismiss();
                AppMethodBeat.o(107188);
            }
        };
        if (!favoriteImgDetailUI.getContext().isFinishing()) {
            eVar.dGm();
        }
        AppMethodBeat.o(107202);
    }

    static /* synthetic */ void a(FavoriteImgDetailUI favoriteImgDetailUI, a aVar, Bitmap bitmap) {
        AppMethodBeat.i(107204);
        if (bitmap == null) {
            bitmap = favoriteImgDetailUI.n(aVar.dKT);
        }
        if (bitmap != null) {
            Log.d("MicroMsg.FavoriteImgDetailUI", "update view bmp[%d, %d], displayWidth %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(favoriteImgDetailUI.displayWidth));
            aVar.tiK = bitmap.getWidth();
            aVar.tiL = bitmap.getHeight();
        }
        try {
            ViewGroup.LayoutParams layoutParams = aVar.dKU.getLayoutParams();
            layoutParams.width = -1;
            if (bitmap.getWidth() > favoriteImgDetailUI.displayWidth / 3) {
                layoutParams.height = (int) ((((float) favoriteImgDetailUI.displayWidth) / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight()));
                if (layoutParams.height <= ForceGpuUtil.getMaxTextureSize()) {
                    aVar.dKU.setScaleType(ImageView.ScaleType.FIT_XY);
                } else if (!ForceGpuUtil.canUseHardwareAcceleration(bitmap.getWidth(), bitmap.getHeight())) {
                    layoutParams.height = ForceGpuUtil.getMaxTextureSize() >> 2;
                    aVar.dKU.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    aVar.dKU.setScaleType(ImageView.ScaleType.FIT_XY);
                }
            } else if (bitmap.getHeight() > ForceGpuUtil.getMaxTextureSize()) {
                layoutParams.height = ForceGpuUtil.getMaxTextureSize() >> 2;
                aVar.dKU.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                if (aVar.dKU.getMinimumWidth() > bitmap.getWidth()) {
                    layoutParams.width = aVar.dKU.getMinimumWidth();
                }
                aVar.dKU.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            ForceGpuUtil.decideLayerType(aVar.dKU, bitmap.getWidth(), bitmap.getHeight());
            String d2 = com.tencent.mm.plugin.fav.a.b.d(aVar.dKT);
            if (ImgUtil.isGif(d2)) {
                try {
                    com.tencent.mm.plugin.gif.b hT = com.tencent.mm.plugin.gif.c.dXx().hT(d2 + "_detail", d2);
                    aVar.dKU.setImageDrawable(hT);
                    hT.stop();
                    hT.start();
                    AppMethodBeat.o(107204);
                } catch (Exception e2) {
                    aVar.dKU.setImageBitmap(bitmap);
                    AppMethodBeat.o(107204);
                }
            } else {
                aVar.dKU.setImageBitmap(bitmap);
                AppMethodBeat.o(107204);
            }
        } catch (Throwable th) {
            AppMethodBeat.o(107204);
        }
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(107205);
        qx qxVar = new qx();
        qxVar.dXu.filePath = com.tencent.mm.plugin.fav.a.b.d(aVar.dKT);
        qxVar.dXu.dDZ = System.currentTimeMillis();
        EventCenter.instance.publish(qxVar);
        aVar.tiG = true;
        AppMethodBeat.o(107205);
    }

    static /* synthetic */ View b(FavoriteImgDetailUI favoriteImgDetailUI, final a aVar) {
        AppMethodBeat.i(107206);
        AnonymousClass2 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(107171);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.FavoriteImgDetailUI", "request deal QBAR string");
                if (aVar.tiF.isShowing()) {
                    aVar.tiF.bMo();
                }
                cr crVar = new cr();
                crVar.dFK.activity = FavoriteImgDetailUI.this;
                crVar.dFK.dDX = aVar.tiH;
                crVar.dFK.dFL = aVar.dFL;
                crVar.dFK.sourceType = 7;
                if (aVar.dKT != null) {
                    crVar.dFK.imagePath = aVar.dKT.KuR;
                    crVar.dFK.dFO = aVar.dKT.Lvp;
                }
                crVar.dFK.dFM = aVar.dFM;
                Bundle bundle = new Bundle(1);
                bundle.putInt("stat_scene", 5);
                crVar.dFK.dFP = bundle;
                EventCenter.instance.publish(crVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(107171);
            }
        };
        Log.i("MicroMsg.FavoriteImgDetailUI", "alvinluo fetchCodeInfo code: %s, hasGet: %b", aVar.tiH, Boolean.valueOf(aVar.tiJ));
        if (!aVar.tiJ) {
            aVar.tiJ = true;
            favoriteImgDetailUI.mHu.cm(aVar.dFL, aVar.tiH);
        }
        View a2 = favoriteImgDetailUI.mHu.a(r0, aVar.dFL, aVar.tiH, 4);
        AppMethodBeat.o(107206);
        return a2;
    }
}
