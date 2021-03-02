package com.tencent.mm.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.a.xe;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.w.c;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.ui.FinderPostRouterUI;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.api.AbsStoryMuteView;
import com.tencent.mm.plugin.story.api.g;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.NormalIconTipPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.y.a;
import com.tencent.smtt.sdk.TbsListener;
import java.util.LinkedHashMap;
import java.util.UUID;

public class MoreTabUI extends AbstractTabChildPreference implements g, e, MStorageEx.IOnStorageChange {
    private AbsStoryGallery BdF = null;
    private AbsStoryMuteView BdG = null;
    private com.tencent.mm.plugin.textstatus.a.b BdM = null;
    private View BdR;
    private boolean Bgv = false;
    private boolean Bgw = false;
    private byte[] CYQ = null;
    private a.AbstractC2176a DeE = new a.AbstractC2176a() {
        /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass1 */

        @Override // com.tencent.mm.y.a.AbstractC2176a
        public final void D(int i2, String str) {
            AppMethodBeat.i(33523);
            if (i2 == 262145 || i2 == 266260 || i2 == 262157 || i2 == 266267 || i2 == 262158 || i2 == 262164) {
                MoreTabUI.a(MoreTabUI.this);
                MoreTabUI.b(MoreTabUI.this);
            } else if (i2 == 262147) {
                MoreTabUI.c(MoreTabUI.this);
            } else if (i2 == 262156) {
                MoreTabUI.d(MoreTabUI.this);
            } else if (i2 == 262152) {
                MoreTabUI.e(MoreTabUI.this);
            } else if (i2 == 352279) {
                MoreTabUI.a(MoreTabUI.this, str);
            } else if (i2 == 352280 && MoreTabUI.this.OIQ && com.tencent.mm.y.c.axV().axS()) {
                com.tencent.mm.y.c.axV().B(352280, false);
            }
            MoreTabUI.this.screen.notifyDataSetChanged();
            AppMethodBeat.o(33523);
        }

        @Override // com.tencent.mm.y.a.AbstractC2176a
        public final void b(ar.a aVar) {
            AppMethodBeat.i(33524);
            if (aVar == ar.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC) {
                MoreTabUI.e(MoreTabUI.this);
            } else if (aVar == ar.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC) {
                MoreTabUI.e(MoreTabUI.this);
            } else if (aVar == ar.a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC || aVar == ar.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC) {
                MoreTabUI.d(MoreTabUI.this);
            } else if (aVar == ar.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC) {
                MoreTabUI.a(MoreTabUI.this);
            }
            MoreTabUI.this.screen.notifyDataSetChanged();
            AppMethodBeat.o(33524);
        }
    };
    private Bitmap FNn = null;
    private RelativeLayout KoQ = null;
    private FrameLayout KoR = null;
    private LinearLayout KoS = null;
    private boolean KoT = false;
    PullDownListView OIC;
    private View OID = null;
    private View OIE = null;
    private b OIF = new b(this, (byte) 0);
    private boolean OIG = false;
    private boolean OIH = false;
    private boolean OII = false;
    private AccountInfoPreference OIJ = null;
    private RelativeLayout OIK = null;
    private int OIL = 0;
    private int OIM = 0;
    private int OIN = 0;
    private int OIO = 0;
    private boolean OIP = false;
    private boolean OIQ = false;
    private boolean OIR = false;
    private boolean OIS = false;
    private h OIT = new h() {
        /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass8 */

        @Override // com.tencent.mm.av.a.c.h
        public final void b(String str, View view) {
            AppMethodBeat.i(33542);
            final NormalIconNewTipPreference normalIconNewTipPreference = (NormalIconNewTipPreference) MoreTabUI.this.screen.bmg("settings_mm_cardpackage");
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass8.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(33539);
                    normalIconNewTipPreference.alH(0);
                    normalIconNewTipPreference.alG(R.drawable.ci4);
                    AppMethodBeat.o(33539);
                }
            });
            AppMethodBeat.o(33542);
        }

        @Override // com.tencent.mm.av.a.c.h
        public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
            return null;
        }

        @Override // com.tencent.mm.av.a.c.h
        public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
            AppMethodBeat.i(33543);
            final NormalIconNewTipPreference normalIconNewTipPreference = (NormalIconNewTipPreference) MoreTabUI.this.screen.bmg("settings_mm_cardpackage");
            if (bVar.bitmap != null) {
                final Bitmap bitmap = bVar.bitmap;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass8.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(33540);
                        normalIconNewTipPreference.aL(bitmap);
                        normalIconNewTipPreference.alH(0);
                        AppMethodBeat.o(33540);
                    }
                });
                AppMethodBeat.o(33543);
                return;
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass8.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(33541);
                    normalIconNewTipPreference.aL(null);
                    normalIconNewTipPreference.alH(8);
                    AppMethodBeat.o(33541);
                }
            });
            AppMethodBeat.o(33543);
        }
    };
    public boolean OIU = true;
    private boolean OIV = true;
    public boolean OIW = true;
    private int OIX = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 48);
    private int OIY = com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), 120);
    private a OIZ = new a();
    private c Vlt;
    private boolean Vlu = false;
    private View contentView;
    public PullDownListView.IPullDownCallback mPullDownCallback = new PullDownListView.IPullDownCallback() {
        /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass3 */

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void onPostOpen(boolean z) {
            d dVar;
            AppMethodBeat.i(232653);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.en(z);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$11", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V", this, bVar.axR());
            if (MoreTabUI.this.OIG) {
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(MoreTabUI.this.BdM == null);
                Log.i("MicroMsg.MoreTabUI", "status_cat onPostOpen, statusBackPreview is null?:%s", objArr);
                if (MoreTabUI.this.BdM != null) {
                    MoreTabUI.this.BdM.onPostOpen(z);
                }
                if (!(MoreTabUI.this.OIJ == null || (dVar = MoreTabUI.this.OIJ.BgU) == null)) {
                    dVar.onPostOpen(z);
                }
                MoreTabUI.a(MoreTabUI.this, 8);
            } else {
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(MoreTabUI.this.BdF == null);
                Log.i("MicroMsg.MoreTabUI", "story_cat onPostOpen, storyGallery is null?:%s", objArr2);
                if (MoreTabUI.this.BdF != null) {
                    com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
                    com.tencent.mm.plugin.story.h.h.fqi().eQv = 1;
                    com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
                    com.tencent.mm.plugin.story.h.h.fqi().eRT = 1;
                    MoreTabUI.this.BdF.ar(z, true);
                    MoreTabUI.a(MoreTabUI.this, 8);
                    MoreTabUI.t(MoreTabUI.this);
                    MoreTabUI.u(MoreTabUI.this);
                }
                MoreTabUI.this.OII = true;
                if (!MoreTabUI.this.Bgv && !MoreTabUI.this.OIP) {
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_STORY_PULL_DOWN_COUNT_INT, Integer.valueOf(com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.USERINFO_STORY_PULL_DOWN_COUNT_INT, 0) + 1));
                    MoreTabUI.w(MoreTabUI.this);
                }
            }
            if (MoreTabUI.this.OIJ != null) {
                MoreTabUI.this.OIJ.grF();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$11", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostOpen", "(Z)V");
            AppMethodBeat.o(232653);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void onPostClose() {
            d dVar;
            boolean z = true;
            AppMethodBeat.i(232654);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$11", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostClose", "()V", this);
            if (MoreTabUI.this.OIG) {
                Object[] objArr = new Object[1];
                if (MoreTabUI.this.BdM != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                Log.i("MicroMsg.MoreTabUI", "status_cat onPostClose, statusBackPreview is null?:%s", objArr);
                if (MoreTabUI.this.BdM != null) {
                    MoreTabUI.this.BdM.onPostClose();
                }
                if (!(MoreTabUI.this.OIJ == null || (dVar = MoreTabUI.this.OIJ.BgU) == null)) {
                    dVar.onPostClose();
                }
            } else {
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(MoreTabUI.this.BdF == null);
                Log.i("MicroMsg.MoreTabUI", "story_cat onPostClose, storyGallery is null?:%s", objArr2);
                if (MoreTabUI.this.BdF != null) {
                    MoreTabUI.this.BdF.vI(true);
                    MoreTabUI.this.BdF.post(new Runnable() {
                        /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(232652);
                            MoreTabUI.x(MoreTabUI.this);
                            MoreTabUI.a(MoreTabUI.this, 0);
                            MoreTabUI.b(MoreTabUI.this, MoreTabUI.this.Bgv);
                            if (MoreTabUI.this.OID != null) {
                                MoreTabUI.this.OID.setTranslationY(0.0f);
                            }
                            AppMethodBeat.o(232652);
                        }
                    });
                }
                MoreTabUI.this.OII = false;
                MoreTabUI.this.OIF.eEj();
                if (MoreTabUI.this.OIQ && !MoreTabUI.this.Bgv) {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
                    com.tencent.mm.plugin.story.h.h.Kv(currentTimeMillis);
                    com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
                    com.tencent.mm.plugin.story.h.h.fqB().eQM = currentTimeMillis;
                }
            }
            if (!(MoreTabUI.this.OIJ == null || MoreTabUI.this.OIC == null)) {
                MoreTabUI.this.OIJ.grG();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$11", "com/tencent/mm/ui/MoreTabUI$com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", "onPostClose", "()V");
            AppMethodBeat.o(232654);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void eEk() {
            d dVar;
            boolean z = true;
            AppMethodBeat.i(232655);
            if (MoreTabUI.this.OIG) {
                Object[] objArr = new Object[1];
                if (MoreTabUI.this.BdM != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                Log.i("MicroMsg.MoreTabUI", "status_cat onPreOpen, statusBackPreview is null?:%s", objArr);
                if (MoreTabUI.this.BdM != null) {
                    MoreTabUI.this.BdM.eEk();
                    if (!(MoreTabUI.this.OIJ == null || (dVar = MoreTabUI.this.OIJ.BgU) == null)) {
                        dVar.eEk();
                    }
                }
            } else {
                if (MoreTabUI.this.BdF != null) {
                    MoreTabUI.this.BdF.fmO();
                }
                if (MoreTabUI.this.OIQ && !MoreTabUI.this.Bgv) {
                    com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
                    com.tencent.mm.plugin.story.h.h.fqB().eRY = System.currentTimeMillis();
                    com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
                    com.tencent.mm.plugin.story.h.h.fqC();
                }
            }
            if (!(MoreTabUI.this.OIJ == null || MoreTabUI.this.OIC == null)) {
                MoreTabUI.this.OIJ.KoU = MoreTabUI.this.OIC.isVisible;
            }
            AppMethodBeat.o(232655);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void eEl() {
            d dVar;
            boolean z = true;
            AppMethodBeat.i(232656);
            if (MoreTabUI.this.OIG) {
                Object[] objArr = new Object[1];
                if (MoreTabUI.this.BdM != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                Log.i("MicroMsg.MoreTabUI", "status_cat onPreClose, statusBackPreview is null?:%s", objArr);
                if (MoreTabUI.this.BdM != null) {
                    MoreTabUI.this.BdM.eEl();
                    if (!(MoreTabUI.this.OIJ == null || (dVar = MoreTabUI.this.OIJ.BgU) == null)) {
                        dVar.eEl();
                    }
                }
            } else if (MoreTabUI.this.BdF != null) {
                MoreTabUI.this.BdF.fmP();
            }
            if (!(MoreTabUI.this.OIJ == null || MoreTabUI.this.OIC == null)) {
                MoreTabUI.this.OIJ.KoU = MoreTabUI.this.OIC.isVisible;
            }
            AppMethodBeat.o(232656);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void eEm() {
            AppMethodBeat.i(232657);
            Log.i("MicroMsg.MoreTabUI", "story_cat onMuteIn");
            MoreTabUI.this.BdG.fmV();
            AppMethodBeat.o(232657);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void eEn() {
            AppMethodBeat.i(232658);
            MoreTabUI.this.BdG.fmW();
            AppMethodBeat.o(232658);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void UC(int i2) {
            AppMethodBeat.i(232659);
            if (!MoreTabUI.this.OIG && MoreTabUI.this.BdF != null) {
                MoreTabUI.this.BdF.aaB(i2);
            }
            AppMethodBeat.o(232659);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void UD(int i2) {
            AppMethodBeat.i(232660);
            if (!MoreTabUI.this.OIG && MoreTabUI.this.BdF != null) {
                MoreTabUI.this.BdF.aaC(i2);
            }
            AppMethodBeat.o(232660);
        }

        @Override // com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
        public final void UE(int i2) {
            AppMethodBeat.i(232661);
            if (!MoreTabUI.this.OIG && MoreTabUI.this.BdF != null) {
                MoreTabUI.this.BdF.UE(i2);
            }
            AppMethodBeat.o(232661);
        }
    };
    private boolean nmu = false;
    private f screen;
    private Observer<h.a> tFo = null;
    private RelativeLayout zWu = null;

    public MoreTabUI() {
        AppMethodBeat.i(33555);
        AppMethodBeat.o(33555);
    }

    static /* synthetic */ void a(MoreTabUI moreTabUI) {
        AppMethodBeat.i(33594);
        moreTabUI.gJl();
        AppMethodBeat.o(33594);
    }

    static /* synthetic */ void a(MoreTabUI moreTabUI, int i2) {
        AppMethodBeat.i(232674);
        moreTabUI.alh(i2);
        AppMethodBeat.o(232674);
    }

    static /* synthetic */ void b(MoreTabUI moreTabUI) {
        AppMethodBeat.i(33595);
        moreTabUI.gJj();
        AppMethodBeat.o(33595);
    }

    static /* synthetic */ void b(MoreTabUI moreTabUI, boolean z) {
        AppMethodBeat.i(232679);
        moreTabUI.Bn(z);
        AppMethodBeat.o(232679);
    }

    static /* synthetic */ void c(MoreTabUI moreTabUI) {
        AppMethodBeat.i(33596);
        moreTabUI.gJn();
        AppMethodBeat.o(33596);
    }

    static /* synthetic */ void d(MoreTabUI moreTabUI) {
        AppMethodBeat.i(33597);
        moreTabUI.gJp();
        AppMethodBeat.o(33597);
    }

    static /* synthetic */ void e(MoreTabUI moreTabUI) {
        AppMethodBeat.i(33598);
        moreTabUI.gJk();
        AppMethodBeat.o(33598);
    }

    static /* synthetic */ void w(MoreTabUI moreTabUI) {
        AppMethodBeat.i(232677);
        moreTabUI.gJi();
        AppMethodBeat.o(232677);
    }

    static /* synthetic */ void x(MoreTabUI moreTabUI) {
        AppMethodBeat.i(232678);
        moreTabUI.eEh();
        AppMethodBeat.o(232678);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.MMFragment
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33556);
        super.onCreate(bundle);
        Log.i("MicroMsg.MoreTabUI", "onCreate:  %s", Integer.valueOf(hashCode()));
        if (!bg.aAc() || bg.azj()) {
            Log.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", Boolean.valueOf(bg.aAc()), Boolean.valueOf(bg.azj()));
            AppMethodBeat.o(33556);
            return;
        }
        this.OIG = p.fvC();
        gJi();
        Bm(false);
        try {
            Activity context = getContext();
            if (context == null) {
                AppMethodBeat.o(33556);
                return;
            }
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((SecDataUIC) com.tencent.mm.ui.component.a.ko(context).get(SecDataUIC.class)).a(new com.tencent.mm.plugin.secdata.c(y.class, 9));
            SecDataUIC.a aVar2 = SecDataUIC.CWq;
            y yVar = (y) SecDataUIC.a.a(getContext(), 9, y.class);
            if (yVar != null) {
                yVar.sessionId = com.tencent.mm.plugin.fts.a.d.Nj(1);
            }
            AppMethodBeat.o(33556);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.MoreTabUI", th, "[initStatusReportData]err", new Object[0]);
            AppMethodBeat.o(33556);
        }
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.AbstractTabChildPreference, com.tencent.mm.ui.base.preference.MMPreferenceFragment, com.tencent.mm.ui.MMFragment
    public void onResume() {
        AppMethodBeat.i(33557);
        super.onResume();
        Log.i("MicroMsg.MoreTabUI", "onResume:  %s", Integer.valueOf(hashCode()));
        gJi();
        if (this.OIQ) {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.Kv(currentTimeMillis);
            com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqB().eQM = currentTimeMillis;
        }
        AppMethodBeat.o(33557);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.AbstractTabChildPreference, com.tencent.mm.ui.MMFragment
    public void onPause() {
        AppMethodBeat.i(33558);
        super.onPause();
        Log.i("MicroMsg.MoreTabUI", "onPause:  %s", Integer.valueOf(hashCode()));
        if (this.OIQ) {
            com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
            com.tencent.mm.plugin.story.h.h.fqC();
        }
        if (this.BdM != null) {
            this.BdM.fvx();
        }
        AppMethodBeat.o(33558);
    }

    private void gJi() {
        int aH;
        AppMethodBeat.i(33559);
        if (!this.OIP) {
            if (!com.tencent.mm.kernel.g.aAc()) {
                AppMethodBeat.o(33559);
                return;
            }
            int i2 = com.tencent.mm.kernel.g.aAh().azQ().getInt(ar.a.USERINFO_STORY_PULL_DOWN_COUNT_INT, 0);
            boolean z = com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, false);
            Log.i("MicroMsg.MoreTabUI", "checkSmallHead: %s", Integer.valueOf(i2));
            if (!this.Bgv && (z || i2 > 0)) {
                this.OIP = true;
                if (this.OIJ != null) {
                    this.OIJ.p(this.Bgv, this.OIP, this.Bgw);
                }
                if (this.OIP) {
                    aH = com.tencent.mm.cb.a.aH(getContext(), R.dimen.agw);
                } else {
                    aH = com.tencent.mm.cb.a.aH(getContext(), R.dimen.agv);
                }
                this.OIN = aH;
            }
        }
        AppMethodBeat.o(33559);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreferenceFragment
    public final int getResourceId() {
        return R.xml.bl;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public boolean supportNavigationSwipeBack() {
        return false;
    }

    @Override // com.tencent.mm.ui.MMFragment
    public boolean noActionBar() {
        return true;
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, android.support.v4.app.Fragment, com.tencent.mm.ui.AbstractTabChildPreference, com.tencent.mm.ui.MMFragment
    public void onDestroy() {
        AppMethodBeat.i(33560);
        super.onDestroy();
        Log.i("MicroMsg.MoreTabUI", "onDestroy:  %s", Integer.valueOf(hashCode()));
        com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.daM().removeObserver(this.tFo);
        AppMethodBeat.o(33560);
    }

    @Override // android.support.v4.app.Fragment, com.tencent.mm.ui.AbstractTabChildPreference, com.tencent.mm.ui.base.preference.MMPreferenceFragment
    public void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(33561);
        Log.i("MicroMsg.MoreTabUI", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.screen = this.adapter;
        this.screen.m38do("more_setting", true);
        this.screen.m38do("settings_emoji_store", true);
        this.screen.m38do("settings_mm_wallet", true);
        this.screen.m38do("settings_mm_cardpackage", true);
        this.screen.m38do("settings_mm_favorite", true);
        this.screen.m38do("settings_my_album", true);
        this.screen.m38do("settings_my_finder_album", true);
        this.screen.m38do("settings_my_address", true);
        this.screen.m38do("more_tab_setting_personal_info", true);
        this.screen.m38do("more_uishow", true);
        this.screen.m38do("settings_privacy_agreements", true);
        this.OID = getView().getRootView().findViewById(R.id.e8y);
        this.zWu = (RelativeLayout) findViewById(R.id.gg3);
        this.OIC = (PullDownListView) this.list;
        this.OIC.setTabView(this.OID);
        this.OIC.setBackground(at.aN(getContext(), R.attr.v2));
        this.OIC.setOnScrollListener(new AbsListView.OnScrollListener() {
            /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass9 */

            public final void onScrollStateChanged(AbsListView absListView, int i2) {
            }

            public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            }
        });
        AppMethodBeat.o(33561);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreferenceFragment
    public final boolean onPreferenceTreeLongClick(f fVar, Preference preference, View view) {
        AppMethodBeat.i(33562);
        if (!com.tencent.mm.kernel.g.aAc()) {
            Log.w("MicroMsg.MoreTabUI", "account has not already!");
            AppMethodBeat.o(33562);
            return true;
        }
        try {
            if (WeChatEnvironment.isMonkeyEnv() || WeChatEnvironment.isCoolassistEnv() || WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED) {
                if (Util.nullAsNil(preference.mKey).equals("settings_emoji_store")) {
                    boolean Bl = Bl(true);
                    AppMethodBeat.o(33562);
                    return Bl;
                } else if (Util.nullAsNil(preference.mKey).equals("more_setting")) {
                    boolean Bl2 = Bl(false);
                    AppMethodBeat.o(33562);
                    return Bl2;
                }
            }
        } catch (ActivityNotFoundException e2) {
        }
        try {
            if ("more_uishow".equals(preference.mKey) && WeChatEnvironment.isCoolassistEnv()) {
                ((com.tencent.mm.plugin.festival.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.festival.a.a.class)).fQ(getContext());
                AppMethodBeat.o(33562);
                return true;
            }
        } catch (Exception e3) {
        }
        boolean onPreferenceTreeLongClick = super.onPreferenceTreeLongClick(fVar, preference, view);
        AppMethodBeat.o(33562);
        return onPreferenceTreeLongClick;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreferenceFragment
    public final boolean onPreferenceTreeClick(f fVar, Preference preference) {
        String str;
        AppMethodBeat.i(33563);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(fVar);
        bVar.bm(preference);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", this, bVar.axR());
        StringBuilder sb = new StringBuilder();
        if (preference == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = preference.mKey;
        }
        Log.i("MicroMsg.MoreTabUI", sb.append(str).append(" item has been clicked!").toString());
        if (!com.tencent.mm.kernel.g.aAc()) {
            Log.w("MicroMsg.MoreTabUI", "account has not already!");
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33563);
            return true;
        } else if (preference.mKey.equals("settings_my_address")) {
            Intent intent = new Intent(getContext(), AddressUI.class);
            intent.putExtra("Contact_GroupFilter_Type", "@biz.contact");
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33563);
            return true;
        } else if (preference.mKey.equals("settings_my_add_contact")) {
            com.tencent.mm.br.c.b(getContext(), "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33563);
            return true;
        } else if (preference.mKey.equals("settings_mm_wallet")) {
            if (!WeChatBrands.Business.Entries.MePayment.checkAvailable(getActivity())) {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33563);
                return true;
            }
            com.tencent.mm.plugin.newtips.a.exl().TC(13);
            boolean cO = com.tencent.mm.y.c.axV().cO(262156, 266248);
            boolean cP = com.tencent.mm.y.c.axV().cP(262156, 266248);
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10958, "9");
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf((cO || cP) ? 1 : 0);
            hVar.a(13341, objArr);
            String uuid = UUID.randomUUID().toString();
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14419, uuid, 0);
            sd sdVar = new sd();
            sdVar.dYH.context = getContext();
            Intent intent2 = new Intent();
            intent2.putExtra("key_wallet_has_red", cP);
            intent2.putExtra("key_uuid", uuid);
            sdVar.dYH.intent = intent2;
            EventCenter.instance.publish(sdVar);
            com.tencent.mm.y.c.axV().cQ(262156, 266248);
            com.tencent.mm.y.c.axV().c(ar.a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, "");
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_LQT_WALLET_RED_DOT_INT, (Object) -1);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_MY_ENTRY_REDDOT_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_ENTRY_WORDING_STRING_SYNC, "");
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.y.c.axV().c(ar.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, ar.a.USERINFO_NEW_BANDAGE_WATCHER_PAY_ENTRANCE_STRING_SYNC);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MY_ENTRY_WORDING_STRING_SYNC, "");
            com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr2 = new Object[5];
            objArr2[0] = 6;
            objArr2[1] = Integer.valueOf(cP ? 1 : 0);
            objArr2[2] = "";
            objArr2[3] = "";
            objArr2[4] = 0;
            hVar2.a(14872, objArr2);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33563);
            return true;
        } else if (preference.mKey.equals("settings_mm_cardpackage")) {
            if (!WeChatBrands.Business.Entries.MeCouponCard.checkAvailable(getActivity())) {
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
                AppMethodBeat.o(33563);
                return true;
            }
            com.tencent.mm.plugin.newtips.a.exl().TC(14);
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, "");
            new Intent().putExtra("key_from_scene", 22);
            Log.i("MicroMsg.MoreTabUI", "enter to cardhome");
            kl klVar = new kl();
            klVar.dPA.context = getContext();
            klVar.dPA.enterScene = 1;
            EventCenter.instance.publish(klVar);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33563);
            return true;
        } else if (preference.mKey.equals("settings_my_album")) {
            bg.aVF();
            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                u.g(getContext(), null);
            } else {
                bg.aVF();
                String str2 = (String) com.tencent.mm.model.c.azQ().get(2, (Object) null);
                Intent intent3 = new Intent(getContext(), AlbumUI.class);
                intent3.putExtra("sns_userName", str2);
                intent3.putExtra(ch.COL_USERNAME, str2);
                intent3.putExtra("story_dot", this.OIR);
                intent3.setFlags(536870912);
                intent3.addFlags(67108864);
                bg.aVF();
                int i2 = af.i((Integer) com.tencent.mm.model.c.azQ().get(68389, (Object) null));
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(68389, Integer.valueOf(i2 + 1));
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI", "setAlbum", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((com.tencent.mm.plugin.textstatus.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).report22208(12, "");
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33563);
            return true;
        } else if (preference.mKey.equals("settings_my_finder_album")) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(21908, 1, 1, 2);
            bdo asW = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getRedDotManager().asW("ProfileEntrance");
            k asX = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getRedDotManager().asX("ProfileEntrance");
            if (!(asW == null || asX == null)) {
                j jVar = j.vft;
                j.a("12", asX, asW, 2, "", 0);
            }
            ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getRedDotManager().asV("ProfileEntrance");
            ((aj) com.tencent.mm.kernel.g.ah(aj.class)).enterFinderSelfProfile(getContext(), new Intent(), 13, 2);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33563);
            return true;
        } else if (preference.mKey.equals("settings_mm_favorite")) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10958, "8");
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14103, 0);
            com.tencent.mm.plugin.fav.a.b.b(getContext(), ".ui.FavoriteIndexUI", new Intent());
            com.tencent.mm.cr.d.hiy();
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33563);
            return true;
        } else if (preference.mKey.equals("settings_emoji_store")) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10958, "7");
            com.tencent.mm.y.c.axV().cQ(262147, 266244);
            com.tencent.mm.y.c.axV().cQ(262149, 266244);
            Intent intent4 = new Intent();
            intent4.putExtra("preceding_scence", 2);
            com.tencent.mm.br.c.b(getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", intent4);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(12065, 1);
            ((com.tencent.mm.plugin.boots.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.boots.a.c.class)).fb(com.tencent.mm.plugin.boots.a.b.pkp, 881);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33563);
            return true;
        } else if (preference.mKey.equals("more_setting")) {
            boolean cO2 = com.tencent.mm.y.c.axV().cO(262145, 266242);
            com.tencent.mm.y.c.axV().cQ(262145, 266242);
            com.tencent.mm.y.c.axV().cQ(262157, 266261);
            com.tencent.mm.y.c.axV().cQ(262158, 266264);
            com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266242);
            com.tencent.mm.y.c.axV().cQ(262164, 266268);
            com.tencent.mm.br.c.b(getContext(), "setting", ".ui.setting.SettingsUI", new Intent());
            bg.aVF();
            int intValue = ((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_SETTING_RED_DOT_WILL_SHOW_ID_INT, (Object) 0)).intValue();
            bg.aVF();
            int intValue2 = ((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_SETTING_RED_DOT_DID_SHOW_ID_INT, (Object) 0)).intValue();
            if (!cO2 && intValue > intValue2) {
                bg.aVF();
                com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_SETTING_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(intValue));
                IconPreference iconPreference = (IconPreference) fVar.bmg("more_setting");
                if (iconPreference != null) {
                    iconPreference.alF(8);
                }
                com.tencent.mm.y.c.axV().cQ(266260, 266241);
            }
            ((com.tencent.mm.plugin.updater.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.updater.a.a.class)).clickSettingTabRedDot();
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33563);
            return true;
        } else if (preference.mKey.equals("more_uishow")) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) getContext(), 1, false);
            eVar.HLX = new o.f() {
                /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass10 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(33544);
                    mVar.d(0, "LiteAppList");
                    mVar.d(1, "VideoEditor");
                    mVar.d(3, "weui");
                    AppMethodBeat.o(33544);
                }
            };
            eVar.HLY = new o.g() {
                /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass11 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(33545);
                    switch (menuItem.getItemId()) {
                        case 0:
                            MoreTabUI.h(MoreTabUI.this);
                            AppMethodBeat.o(33545);
                            return;
                        case 1:
                            MoreTabUI.i(MoreTabUI.this);
                            AppMethodBeat.o(33545);
                            return;
                        case 2:
                            MoreTabUI.j(MoreTabUI.this);
                            AppMethodBeat.o(33545);
                            return;
                        case 3:
                            MoreTabUI.k(MoreTabUI.this);
                            break;
                    }
                    AppMethodBeat.o(33545);
                }
            };
            eVar.dGm();
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33563);
            return true;
        } else if (preference.mKey.equals("settings_privacy_agreements")) {
            com.tencent.mm.plugin.account.a.b.a.b(getActivity(), getString(R.string.ee8, LocaleUtil.getApplicationLanguage(), com.tencent.mm.kernel.g.aAh().azQ().get(274436, (Object) null), "setting", 0, 0), 0, true);
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33563);
            return true;
        } else {
            com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/MoreTabUI", "com/tencent/mm/ui/AbstractTabChildPreference", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z");
            AppMethodBeat.o(33563);
            return false;
        }
    }

    private void gJj() {
        AppMethodBeat.i(33564);
        if (!com.tencent.mm.br.c.aZU("sns")) {
            this.screen.m38do("settings_my_album", true);
            AppMethodBeat.o(33564);
            return;
        }
        this.screen.m38do("settings_my_album", false);
        IconPreference iconPreference = (IconPreference) this.screen.bmg("settings_my_album");
        if (iconPreference != null) {
            if (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_STORY_NEED_DISPLAY_ALBUM_GUIDE_BOOLEAN_SYNC, true) || !this.OIR) {
                this.OIR = false;
                iconPreference.alF(8);
            } else {
                iconPreference.alF(0);
                AppMethodBeat.o(33564);
                return;
            }
        }
        AppMethodBeat.o(33564);
    }

    private void gJk() {
        String str;
        boolean z;
        AppMethodBeat.i(33565);
        com.tencent.mm.plugin.card.c.b bVar = (com.tencent.mm.plugin.card.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.card.c.b.class);
        if (bVar == null || ((!bVar.cuq() && !bVar.cur()) || !com.tencent.mm.br.c.aZU("card"))) {
            this.screen.m38do("settings_mm_cardpackage", true);
            AppMethodBeat.o(33565);
            return;
        }
        if (bVar != null) {
            str = bVar.cus();
        } else {
            str = "";
        }
        this.screen.m38do("settings_mm_cardpackage", false);
        NormalIconNewTipPreference normalIconNewTipPreference = (NormalIconNewTipPreference) this.screen.bmg("settings_mm_cardpackage");
        if (normalIconNewTipPreference == null) {
            AppMethodBeat.o(33565);
            return;
        }
        boolean cP = com.tencent.mm.y.c.axV().cP(262152, 266256);
        boolean cO = com.tencent.mm.y.c.axV().cO(262152, 266256);
        boolean a2 = com.tencent.mm.y.c.axV().a(ar.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC);
        boolean a3 = com.tencent.mm.y.c.axV().a(ar.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC);
        bg.aVF();
        String str2 = (String) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, "");
        normalIconNewTipPreference.setTitle(R.string.gq_);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16322, 1);
        normalIconNewTipPreference.a(this.screen);
        com.tencent.mm.plugin.newtips.a.exl().h(normalIconNewTipPreference);
        normalIconNewTipPreference.Akx = this.OIT;
        com.tencent.mm.plugin.newtips.a.g.a(normalIconNewTipPreference);
        if (cO || ((a3 && !TextUtils.isEmpty(str2)) || cP || a2)) {
            z = true;
        } else {
            z = false;
        }
        if (com.tencent.mm.plugin.newtips.a.g.a(z, normalIconNewTipPreference)) {
            AppMethodBeat.o(33565);
        } else if (cO) {
            normalIconNewTipPreference.alD(0);
            normalIconNewTipPreference.gY(getString(R.string.x4), R.drawable.amr);
            normalIconNewTipPreference.alF(8);
            normalIconNewTipPreference.setSummary((CharSequence) null);
            normalIconNewTipPreference.aL(null);
            normalIconNewTipPreference.alH(8);
            normalIconNewTipPreference.gZ("", -1);
            normalIconNewTipPreference.alE(8);
            com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_NEW, true);
            AppMethodBeat.o(33565);
        } else {
            if (!a3 || TextUtils.isEmpty(str2)) {
                normalIconNewTipPreference.aL(null);
                normalIconNewTipPreference.alH(8);
            } else {
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.v5);
                c.a aVar = new c.a();
                aVar.prefixPath = com.tencent.mm.loader.j.b.aKJ();
                q.bcW();
                aVar.jbw = null;
                aVar.jbf = true;
                aVar.iaT = true;
                aVar.jbd = true;
                aVar.hZA = dimensionPixelOffset;
                aVar.hZz = dimensionPixelOffset;
                q.bcV().a(str2, normalIconNewTipPreference.gLG(), aVar.bdv(), this.OIT);
                com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_REDPOINT_ICON, true);
            }
            if (cP) {
                normalIconNewTipPreference.alF(0);
                com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_REDPOINT, true);
            } else {
                normalIconNewTipPreference.alF(8);
            }
            if (a2) {
                normalIconNewTipPreference.gY("", -1);
                normalIconNewTipPreference.alD(8);
                if (a3) {
                    normalIconNewTipPreference.setSummary((CharSequence) null);
                    if (!af.isNullOrNil(str)) {
                        normalIconNewTipPreference.aS(str, -1, getResources().getColor(R.color.uj));
                        normalIconNewTipPreference.alE(0);
                        com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE, true);
                        AppMethodBeat.o(33565);
                        return;
                    }
                    normalIconNewTipPreference.gZ("", -1);
                    normalIconNewTipPreference.alE(8);
                    AppMethodBeat.o(33565);
                    return;
                }
                normalIconNewTipPreference.gZ("", -1);
                normalIconNewTipPreference.alE(8);
                if (!af.isNullOrNil(str)) {
                    normalIconNewTipPreference.setSummary(str);
                    com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE, true);
                    AppMethodBeat.o(33565);
                    return;
                }
                normalIconNewTipPreference.setSummary((CharSequence) null);
                AppMethodBeat.o(33565);
                return;
            }
            normalIconNewTipPreference.alE(8);
            normalIconNewTipPreference.alD(8);
            normalIconNewTipPreference.setSummary((CharSequence) null);
            AppMethodBeat.o(33565);
        }
    }

    private void gJl() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(33566);
        this.screen.m38do("more_setting", false);
        IconPreference iconPreference = (IconPreference) this.screen.bmg("more_setting");
        if (iconPreference != null) {
            iconPreference.alI(8);
            boolean cO = com.tencent.mm.y.c.axV().cO(262145, 266242);
            if (cO) {
                iconPreference.alD(0);
                iconPreference.gY(getString(R.string.x4), R.drawable.amr);
            } else {
                iconPreference.alD(8);
                iconPreference.gY("", -1);
            }
            iconPreference.alF(8);
            if (cO) {
                AppMethodBeat.o(33566);
                return;
            }
            bg.aVF();
            int intValue = ((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_SETTING_RED_DOT_WILL_SHOW_ID_INT, (Object) 0)).intValue();
            bg.aVF();
            int intValue2 = ((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_SETTING_RED_DOT_DID_SHOW_ID_INT, (Object) 0)).intValue();
            if ((((com.tencent.mm.plugin.welab.a.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.welab.a.a.c.class)).gji() || ((com.tencent.mm.plugin.welab.a.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.welab.a.a.c.class)).gjj() || intValue > intValue2) && !cO) {
                iconPreference.alF(0);
                iconPreference.alD(8);
                iconPreference.gY("", -1);
                AppMethodBeat.o(33566);
                return;
            }
            iconPreference.alF(8);
            if (com.tencent.mm.y.c.axV().cP(262157, 266261)) {
                iconPreference.alF(0);
                iconPreference.alD(8);
                iconPreference.gY("", -1);
                AppMethodBeat.o(33566);
                return;
            }
            iconPreference.alF(8);
            if (com.tencent.mm.y.c.axV().cP(262164, 266268)) {
                iconPreference.alF(0);
                iconPreference.alD(8);
                iconPreference.gY("", -1);
                AppMethodBeat.o(33566);
                return;
            }
            iconPreference.alF(8);
            if (com.tencent.mm.y.c.axV().cP(262158, 266264)) {
                iconPreference.alF(0);
                iconPreference.alD(8);
                iconPreference.gY("", -1);
                AppMethodBeat.o(33566);
                return;
            } else if (com.tencent.mm.y.c.axV().a(ar.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266242)) {
                iconPreference.alF(0);
                AppMethodBeat.o(33566);
                return;
            } else {
                iconPreference.alF(8);
                bg.aVF();
                if ((com.tencent.mm.model.c.azQ().getInt(40, 0) & 131072) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VoiceprintEntry"), 0) == 1) {
                    bg.aVF();
                    z2 = ((Boolean) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN, Boolean.TRUE)).booleanValue();
                } else {
                    z2 = false;
                }
                if (!z2 || !z) {
                    iconPreference.alF(8);
                    com.tencent.mm.plugin.newtips.b.a TF = com.tencent.mm.plugin.newtips.a.exm().TF(com.tencent.mm.plugin.newtips.a.d.ADb);
                    if (TF == null || TF.field_isExit) {
                        com.tencent.mm.plugin.newtips.a.exo();
                        if (com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADb)) {
                            iconPreference.alF(0);
                            iconPreference.alD(8);
                            iconPreference.gY("", -1);
                            AppMethodBeat.o(33566);
                            return;
                        }
                    } else {
                        this.Vlt = new c(iconPreference);
                        com.tencent.mm.plugin.newtips.a.exl().ADB = this.Vlt;
                    }
                    if (((com.tencent.mm.plugin.updater.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.updater.a.a.class)).hasSettingTabRedDot()) {
                        iconPreference.alF(0);
                        AppMethodBeat.o(33566);
                        return;
                    }
                    iconPreference.alF(8);
                } else {
                    Log.i("MicroMsg.MoreTabUI", "show voiceprint dot");
                    iconPreference.alF(0);
                    AppMethodBeat.o(33566);
                    return;
                }
            }
        }
        AppMethodBeat.o(33566);
    }

    /* access modifiers changed from: package-private */
    public static class c implements i.a {
        IconPreference Vlv;

        public c(IconPreference iconPreference) {
            this.Vlv = iconPreference;
        }

        @Override // com.tencent.mm.plugin.newtips.a.i.a
        public final void e(com.tencent.mm.plugin.newtips.b.a aVar) {
            AppMethodBeat.i(258908);
            if (aVar != null && aVar.field_tipId == com.tencent.mm.plugin.newtips.a.d.ADb) {
                com.tencent.mm.plugin.newtips.a.exo();
                if (com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADb)) {
                    this.Vlv.alF(0);
                    this.Vlv.alD(8);
                    this.Vlv.gY("", -1);
                    AppMethodBeat.o(258908);
                    return;
                }
            }
            AppMethodBeat.o(258908);
        }
    }

    private void gJm() {
        AppMethodBeat.i(232665);
        this.screen.m38do("more_tab_setting_personal_info", false);
        this.OIJ = (AccountInfoPreference) this.adapter.bmg("more_tab_setting_personal_info");
        String aTZ = z.aTZ();
        if (af.isNullOrNil(aTZ)) {
            String aTY = z.aTY();
            if (as.bjx(aTY)) {
                this.OIJ.KoH = null;
            } else {
                this.OIJ.KoH = aTY;
            }
        } else {
            this.OIJ.KoH = aTZ;
        }
        this.OIJ.userName = z.aTY();
        String aUa = z.aUa();
        if (af.isNullOrNil(aUa)) {
            aUa = z.aUb();
        }
        this.OIJ.KoG = l.c(getContext(), aUa);
        this.OIJ.p(this.Bgv, this.OIP, this.Bgw);
        this.OIJ.KoV = new View.OnClickListener() {
            /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(33547);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (MoreTabUI.this.OIG) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(33547);
                    return;
                }
                if (MoreTabUI.this.BdF != null && MoreTabUI.this.Bgv && MoreTabUI.this.OIC != null && MoreTabUI.this.OIC.isVisible) {
                    MoreTabUI.this.BdF.fmQ();
                }
                if (MoreTabUI.this.nmu) {
                    u.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(R.string.hiq), 0).show();
                } else if (MoreTabUI.this.OIC != null) {
                    MoreTabUI.this.OIC.hbY();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(33547);
            }
        };
        ((AccountInfoPreference) this.screen.bmg("more_tab_setting_personal_info")).AmH = new View.OnClickListener() {
            /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass14 */

            public final void onClick(View view) {
                AppMethodBeat.i(33548);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11264, 1);
                MoreTabUI moreTabUI = MoreTabUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(MoreTabUI.this.getContext(), SelfQRCodeUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(moreTabUI, bl.axQ(), "com/tencent/mm/ui/MoreTabUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                moreTabUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(moreTabUI, "com/tencent/mm/ui/MoreTabUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(33548);
            }
        };
        AppMethodBeat.o(232665);
    }

    private void gJn() {
        AppMethodBeat.i(33567);
        if (com.tencent.mm.br.c.aZU("emoji")) {
            com.tencent.mm.br.c.gsX();
            this.screen.m38do("settings_emoji_store", false);
            boolean cO = com.tencent.mm.y.c.axV().cO(262147, 266244);
            boolean cO2 = com.tencent.mm.y.c.axV().cO(262149, 266244);
            final IconPreference iconPreference = (IconPreference) this.screen.bmg("settings_emoji_store");
            if (iconPreference == null) {
                AppMethodBeat.o(33567);
                return;
            }
            if (cO) {
                iconPreference.alD(0);
                iconPreference.gY(getString(R.string.x4), R.drawable.amr);
            } else if (cO2) {
                iconPreference.alD(0);
                iconPreference.gY(getString(R.string.vn), R.drawable.amr);
            } else {
                iconPreference.alD(8);
                iconPreference.gY("", -1);
            }
            if (cO2 || cO) {
                bg.aVF();
                q.bcV().a((String) com.tencent.mm.model.c.azQ().get(229633, (Object) null), iconPreference.gLG(), new com.tencent.mm.av.a.c.h() {
                    /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass15 */

                    @Override // com.tencent.mm.av.a.c.h
                    public final void b(String str, View view) {
                    }

                    @Override // com.tencent.mm.av.a.c.h
                    public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                        return null;
                    }

                    @Override // com.tencent.mm.av.a.c.h
                    public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                        AppMethodBeat.i(33551);
                        if (bVar.status != 0 || bVar.bitmap == null) {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass15.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(33550);
                                    iconPreference.alH(8);
                                    AppMethodBeat.o(33550);
                                }
                            });
                            AppMethodBeat.o(33551);
                            return;
                        }
                        final Bitmap bitmap = bVar.bitmap;
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass15.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(33549);
                                iconPreference.aL(bitmap);
                                iconPreference.alH(0);
                                AppMethodBeat.o(33549);
                            }
                        });
                        AppMethodBeat.o(33551);
                    }
                });
                AppMethodBeat.o(33567);
                return;
            }
            iconPreference.alH(8);
            AppMethodBeat.o(33567);
            return;
        }
        this.screen.m38do("settings_emoji_store", false);
        AppMethodBeat.o(33567);
    }

    private void gJo() {
        boolean z;
        AppMethodBeat.i(33568);
        boolean aUj = z.aUj();
        Log.d("MicroMsg.MoreTabUI", "wallet status: is open".concat(String.valueOf(aUj)));
        f fVar = this.screen;
        if (!aUj) {
            z = true;
        } else {
            z = false;
        }
        fVar.m38do("settings_mm_wallet", z);
        this.adapter.notifyDataSetChanged();
        int userInfoPluginSwitch = PluginAuth.getUserInfoPluginSwitch();
        if (!Util.isEqual(userInfoPluginSwitch, -1)) {
            boolean z2 = (userInfoPluginSwitch & 32768) != 0;
            Log.i("MicroMsg.MoreTabUI", "wallet status entrance idkey[isOpen:%s, isOpenCurScene:%s]", Boolean.valueOf(aUj), Boolean.valueOf(z2));
            if (aUj != z2) {
                if (aUj) {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1056, 1, 1, false);
                    AppMethodBeat.o(33568);
                    return;
                }
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1056, 0, 1, false);
            }
        }
        AppMethodBeat.o(33568);
    }

    private void gJp() {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(33569);
        bg.aVF();
        int i2 = af.i((Integer) com.tencent.mm.model.c.azQ().get(204820, (Object) null));
        bg.aVF();
        int i3 = i2 + af.i((Integer) com.tencent.mm.model.c.azQ().get(204817, (Object) null));
        boolean cO = com.tencent.mm.y.c.axV().cO(262156, 266248);
        boolean cP = com.tencent.mm.y.c.axV().cP(262156, 266248);
        boolean b2 = com.tencent.mm.y.c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
        bg.aVF();
        String str = (String) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_WALLET_MORE_TAB_REDDOT_WORDING_STRING_SYNC, "");
        NormalIconNewTipPreference normalIconNewTipPreference = (NormalIconNewTipPreference) this.screen.bmg("settings_mm_wallet");
        if (normalIconNewTipPreference == null) {
            AppMethodBeat.o(33569);
            return;
        }
        Log.d("MicroMsg.MoreTabUI", "isShowNew : ".concat(String.valueOf(cO)));
        Log.d("MicroMsg.MoreTabUI", "isShowDot : ".concat(String.valueOf(cP)));
        normalIconNewTipPreference.a(this.screen);
        com.tencent.mm.plugin.newtips.a.exl().h(normalIconNewTipPreference);
        com.tencent.mm.plugin.newtips.a.g.a(normalIconNewTipPreference);
        bg.aVF();
        String str2 = (String) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, "");
        bg.aVF();
        int intValue = ((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_LQT_WALLET_RED_DOT_INT, (Object) -1)).intValue();
        if (cO || cP) {
            bg.aVF();
            long longValue = ((Long) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, (Object) -1L)).longValue();
            long Fk = af.Fk(com.tencent.mm.n.h.aqJ().getValue("PayWalletRedDotExpire"));
            long j2 = Util.MILLSECONDS_OF_DAY * Fk;
            long currentTimeMillis = System.currentTimeMillis();
            double d2 = (((double) currentTimeMillis) - ((double) longValue)) / 8.64E7d;
            Log.i("MicroMsg.MoreTabUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", Long.valueOf(longValue), Long.valueOf(Fk), Long.valueOf(j2), Long.valueOf(currentTimeMillis), Double.valueOf(d2));
            if (longValue > 0 && Fk > 0 && d2 >= ((double) Fk)) {
                cO = false;
                com.tencent.mm.y.c.axV().A(262156, false);
                cP = false;
            }
        }
        com.tencent.mm.kernel.g.aAi();
        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_MY_ENTRY_REDDOT_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        com.tencent.mm.kernel.g.aAi();
        long longValue2 = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, (Object) 0L)).longValue();
        if (!booleanValue || longValue2 <= 0 || System.currentTimeMillis() <= longValue2) {
            z = booleanValue;
        } else {
            Log.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
            z = false;
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_MY_ENTRY_REDDOT_BOOLEAN_SYNC, Boolean.FALSE);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, (Object) 0L);
        }
        boolean z4 = cP | z;
        com.tencent.mm.kernel.g.aAi();
        String str3 = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_ENTRY_WORDING_STRING_SYNC, "");
        Log.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", Boolean.valueOf(cO), Boolean.valueOf(z4), str3);
        boolean b3 = com.tencent.mm.y.c.axV().b(ar.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, ar.a.USERINFO_NEW_BANDAGE_WATCHER_PAY_ENTRANCE_STRING_SYNC);
        com.tencent.mm.kernel.g.aAi();
        long longValue3 = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_New_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, (Object) 0L)).longValue();
        if (!b3 || longValue3 <= 0 || System.currentTimeMillis() <= longValue3) {
            z2 = b3;
        } else {
            Log.i("MicroMsg.MoreTabUI", "walletMyEntryRedDot expire, ignore redDot");
            z2 = false;
            com.tencent.mm.y.c.axV().c(ar.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, ar.a.USERINFO_NEW_BANDAGE_WATCHER_PAY_ENTRANCE_STRING_SYNC);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_New_MY_ENTRY_REDDOT_EXPIRETIME_LONG_SYNC, (Object) 0L);
        }
        boolean z5 = z4 | z2;
        com.tencent.mm.kernel.g.aAi();
        String str4 = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_New_MY_ENTRY_WORDING_STRING_SYNC, "");
        Log.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s, walletEntryWording: %s", Boolean.valueOf(cO), Boolean.valueOf(z5), str4);
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        Object[] objArr = new Object[5];
        objArr[0] = 6;
        objArr[1] = Integer.valueOf(z5 ? 1 : 0);
        objArr[2] = "";
        objArr[3] = "";
        objArr[4] = 1;
        hVar.a(14872, objArr);
        Log.d("MicroMsg.MoreTabUI", "bankcardDot : ".concat(String.valueOf(b2)));
        if (b2 || cO || i3 > 0 || z5 || intValue == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (com.tencent.mm.plugin.newtips.a.g.a(z3, normalIconNewTipPreference)) {
            AppMethodBeat.o(33569);
            return;
        }
        if (b2) {
            if (!Util.isNullOrNil(str)) {
                normalIconNewTipPreference.alE(0);
                normalIconNewTipPreference.aS(str, -1, -7566196);
                normalIconNewTipPreference.BB(true);
                normalIconNewTipPreference.alF(8);
                com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE, true);
            } else {
                normalIconNewTipPreference.gZ("", -1);
                normalIconNewTipPreference.alE(8);
                normalIconNewTipPreference.alF(0);
                com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_REDPOINT, true);
            }
        } else if (cO) {
            normalIconNewTipPreference.alD(0);
            normalIconNewTipPreference.gY(getString(R.string.x4), R.drawable.amr);
            normalIconNewTipPreference.alF(8);
            com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_NEW, true);
        } else if (i3 > 99) {
            normalIconNewTipPreference.alD(0);
            normalIconNewTipPreference.gY(getString(R.string.hk6), v.kH(getContext()));
            normalIconNewTipPreference.alF(8);
            com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_COUNTER, true);
        } else if (i3 > 0) {
            normalIconNewTipPreference.alD(0);
            normalIconNewTipPreference.gY(String.valueOf(i3), v.aQ(getContext(), i3));
            normalIconNewTipPreference.alF(8);
            com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_COUNTER, true);
        } else if (z5) {
            normalIconNewTipPreference.gY("", -1);
            normalIconNewTipPreference.alD(8);
            normalIconNewTipPreference.alF(0);
            com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_REDPOINT, true);
        } else if (intValue == 1) {
            normalIconNewTipPreference.gY("", -1);
            normalIconNewTipPreference.alD(8);
            normalIconNewTipPreference.alE(0);
            normalIconNewTipPreference.BB(true);
            if (!af.isNullOrNil(str2)) {
                normalIconNewTipPreference.aS(str2, -1, Color.parseColor("#888888"));
            }
            normalIconNewTipPreference.alI(8);
            com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a) normalIconNewTipPreference, com.tencent.mm.plugin.newtips.a.k.MMNEWTIPS_SHOWTYPE_REDPOINT_TITLE, true);
        } else {
            normalIconNewTipPreference.gY("", -1);
            normalIconNewTipPreference.alD(8);
            normalIconNewTipPreference.alF(8);
            normalIconNewTipPreference.alE(8);
            normalIconNewTipPreference.gZ("", -1);
            com.tencent.mm.plugin.newtips.a.g.a(normalIconNewTipPreference);
        }
        if (Util.isNullOrNil(str4)) {
            str4 = str3;
        }
        if (af.isNullOrNil(str4) || !z5) {
            normalIconNewTipPreference.setSummary("");
            AppMethodBeat.o(33569);
            return;
        }
        normalIconNewTipPreference.setSummary(str4);
        AppMethodBeat.o(33569);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(33570);
        int cm = af.cm(obj);
        Log.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(cm), mStorageEx);
        bg.aVF();
        if (mStorageEx != com.tencent.mm.model.c.azQ() || cm <= 0) {
            Log.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(cm), mStorageEx);
            AppMethodBeat.o(33570);
        } else if (204817 == cm || 204820 == cm) {
            gJp();
            AppMethodBeat.o(33570);
        } else if (40 == cm) {
            gJo();
            AppMethodBeat.o(33570);
        } else {
            if ("208899".equals(Integer.valueOf(i2))) {
                gJn();
            }
            AppMethodBeat.o(33570);
        }
    }

    private boolean Bl(boolean z) {
        AppMethodBeat.i(33572);
        com.tencent.mm.plugin.appbrand.w.c.INSTANCE.a(c.a.AppStart);
        com.tencent.mm.plugin.appbrand.w.c.INSTANCE.a(c.a.StartUp);
        Intent intent = new Intent();
        intent.putExtra("preceding_scence", 2);
        intent.putExtra("isNativeView", z);
        com.tencent.mm.br.c.b(getContext(), "appbrand", ".functions.emojistore.LFEmojiStoreContainerActivity", intent);
        AppMethodBeat.o(33572);
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onConfigurationChanged(Configuration configuration) {
        boolean z = true;
        AppMethodBeat.i(33573);
        super.onConfigurationChanged(configuration);
        Log.d("MicroMsg.MoreTabUI", "onConfigurationChanged");
        if (this.OIG) {
            if (this.OIE != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.OIE.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                layoutParams.topMargin = au.az(getContext()).x;
            }
            updateStatus();
            AppMethodBeat.o(33573);
            return;
        }
        if (configuration.orientation == 1) {
            this.nmu = false;
            if (this.OIC != null) {
                this.OIF.gJs();
            }
        } else if (configuration.orientation == 2) {
            this.nmu = true;
            if (this.OIC != null) {
                if (!this.OIC.isVisible) {
                    this.OIC.hbX();
                }
                this.OIF.ali(2);
            }
        }
        if ((configuration.screenLayout & 3) == 0 || (configuration.screenLayout & 16) == 0) {
            z = false;
        }
        if (z != this.OIS) {
            this.OIS = z;
            if (!(this.BdF == null || this.zWu == null || this.OIC == null)) {
                this.BdF.onDestroy();
                this.zWu.removeView(this.BdF);
                gJr();
                this.BdF.onResume();
                if (!this.OIC.isVisible) {
                    this.OIC.postDelayed(new Runnable() {
                        /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass7 */

                        public final void run() {
                            AppMethodBeat.i(232664);
                            MoreTabUI.this.OIC.hbX();
                            AppMethodBeat.o(232664);
                        }
                    }, 200);
                    AppMethodBeat.o(33573);
                    return;
                } else if (this.OIC.isVisible && this.OIC.getTranslationY() != 0.0f) {
                    this.OIC.setTranslationY(0.0f);
                }
            }
        }
        AppMethodBeat.o(33573);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.AbstractTabChildPreference
    public final void gGu() {
        boolean z = true;
        AppMethodBeat.i(33574);
        Log.i("MicroMsg.MoreTabUI", "onTabCreate:  %s", Integer.valueOf(hashCode()));
        Configuration configuration = getResources().getConfiguration();
        this.nmu = configuration.orientation == 2;
        if ((configuration.screenLayout & 3) == 0 || (configuration.screenLayout & 16) == 0) {
            z = false;
        }
        this.OIS = z;
        this.screen = this.adapter;
        this.contentView = getContentView();
        com.tencent.mm.compatible.util.a.cy(getContext());
        com.tencent.mm.kernel.g.aAi();
        this.BdG = ((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().hh(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.tencent.mm.cb.a.aH(getContext(), R.dimen.agu), com.tencent.mm.cb.a.aH(getContext(), R.dimen.agu));
        layoutParams.gravity = 83;
        ((ViewGroup) getContext().findViewById(R.id.g8f).getParent()).addView(this.BdG, 0, layoutParams);
        this.OIC.QRK = this.mPullDownCallback;
        this.OIC.setPadding(this.OIC.getPaddingLeft(), this.OIC.getPaddingTop(), this.OIC.getPaddingRight(), this.OID.getHeight());
        if (this.zWu != null) {
            Log.d("MicroMsg.MoreTabUI", "dancy test add view !");
            gJr();
        }
        AppMethodBeat.o(33574);
    }

    private void gJq() {
        AppMethodBeat.i(232666);
        if (getActivity() == null) {
            AppMethodBeat.o(232666);
            return;
        }
        boolean fvC = p.fvC();
        if (fvC == this.OIG) {
            AppMethodBeat.o(232666);
            return;
        }
        this.OIG = fvC;
        if (this.BdF != null) {
            this.zWu.removeView(this.BdF);
            this.BdF.onDestroy();
            this.OIC.y(null, 0, 0);
            this.BdF = null;
        }
        if (this.BdM != null) {
            this.zWu.removeView(this.OIE);
            this.zWu.removeView(this.BdM.getView());
            this.BdM.fvv();
            this.BdM = null;
            if (this.OIJ != null) {
                AccountInfoPreference accountInfoPreference = this.OIJ;
                if (accountInfoPreference.BgU != null) {
                    accountInfoPreference.BgU.fvv();
                    accountInfoPreference.BgU = null;
                }
            }
        }
        this.OIH = false;
        gJr();
        gJi();
        if (this.OIJ != null) {
            gJm();
        }
        AppMethodBeat.o(232666);
    }

    private void gJr() {
        int aH;
        AppMethodBeat.i(33575);
        if (this.OIH) {
            AppMethodBeat.o(33575);
            return;
        }
        this.OIH = true;
        if (this.OIG) {
            this.OIE = new View(getContext());
            this.zWu.addView(this.OIE, 0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.OIE.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.topMargin = au.az(getContext()).x;
            this.OIE.setBackgroundColor(getResources().getColor(R.color.f3043a));
            final float f2 = ((float) ah.jS(getContext()).width) * 0.6666667f;
            this.OIC.setTranslationListener(new PullDownListView.a() {
                /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass2 */

                @Override // com.tencent.mm.ui.widget.listview.PullDownListView.a
                public final void bI(float f2) {
                    View view;
                    float f3 = 0.0f;
                    AppMethodBeat.i(232651);
                    if (!MoreTabUI.this.OIG) {
                        AppMethodBeat.o(232651);
                        return;
                    }
                    float f4 = f2 / f2;
                    if (f2 >= 0.0f) {
                        f3 = f4;
                    }
                    if (f2 > f2) {
                        f3 = 1.0f;
                    }
                    MoreTabUI.this.OIE.setTranslationY(f2);
                    if (MoreTabUI.this.BdM != null) {
                        MoreTabUI.this.BdM.cd(f3);
                    }
                    if (!(MoreTabUI.this.OIJ == null || (view = MoreTabUI.this.OIJ.KoL) == null)) {
                        view.setAlpha((1.0f - f3) * 1.0f);
                    }
                    AppMethodBeat.o(232651);
                }
            });
            this.BdM = ((com.tencent.mm.plugin.textstatus.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).getBackPreview(getContext());
            this.zWu.addView(this.BdM.getView(), 0);
            this.BdM.a(this);
            this.BdM.DV(com.tencent.mm.plugin.auth.a.a.ceA());
        } else {
            this.BdF = ((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().a(getContext(), n.a.SelfTabGallery, null);
            if (this.BdF != null) {
                this.BdF.fmS();
                this.OIO = -(au.az(getContext()).y / 10);
                if (this.OIP) {
                    aH = com.tencent.mm.cb.a.aH(getContext(), R.dimen.agw);
                } else {
                    aH = com.tencent.mm.cb.a.aH(getContext(), R.dimen.agv);
                }
                this.OIN = aH;
                this.OIM = -com.tencent.mm.cb.a.fromDPToPix((Context) getContext(), (int) TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE);
                this.OIL = 0;
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, au.az(getContext()).y);
                layoutParams2.topMargin = this.OIO;
                layoutParams2.bottomMargin = -au.aD(getContext());
                this.zWu.addView(this.BdF, 0, layoutParams2);
                this.OIC.y(this.BdF, this.OIN, this.OIO);
                this.OIC.setNavigationBarHeight(au.aD(getActivity()));
                this.OIC.setTranslationListener(null);
                this.BdF.setDataSeed(z.aTY());
                this.BdF.a(this.OIC);
                this.BdF.setStoryBrowseUIListener(this);
            }
        }
        this.OIF.gJs();
        AppMethodBeat.o(33575);
    }

    private void alh(int i2) {
        AppMethodBeat.i(33576);
        View findViewById = findViewById(R.id.c_);
        if (findViewById != null) {
            findViewById.setVisibility(i2);
            Log.i("MicroMsg.MoreTabUI", "setActionbarContainer type:%s", Integer.valueOf(i2));
            AppMethodBeat.o(33576);
            return;
        }
        Log.i("MicroMsg.MoreTabUI", "setActionbarContainer is null!!");
        AppMethodBeat.o(33576);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.AbstractTabChildPreference
    public final void gGv() {
        boolean z;
        AppMethodBeat.i(33577);
        Log.i("MicroMsg.MoreTabUI", "onTabResume:  %s", Integer.valueOf(hashCode()));
        if ((this.screen instanceof com.tencent.mm.ui.base.preference.h) && ((com.tencent.mm.ui.base.preference.h) this.screen).OZd == 0) {
            ((com.tencent.mm.ui.base.preference.h) this.screen).OZd = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.screen = this.adapter;
        gJq();
        bg.aVF();
        com.tencent.mm.model.c.azQ().add(this);
        com.tencent.mm.y.c.axV().a(this.DeE);
        gJm();
        IconPreference iconPreference = (IconPreference) this.screen.bmg("settings_my_address");
        if (iconPreference != null) {
            int gCR = com.tencent.mm.bj.d.bgN().gCR();
            if (gCR > 0) {
                iconPreference.alD(0);
                iconPreference.gY(String.valueOf(gCR), R.drawable.amr);
            } else {
                iconPreference.alD(8);
                iconPreference.gY("", -1);
            }
        }
        gJj();
        if (((aj) com.tencent.mm.kernel.g.ah(aj.class)).getFinderSwitchApi().dCs()) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(21908, 1, 1, 1);
            this.screen.m38do("settings_my_finder_album", false);
            NormalIconTipPreference normalIconTipPreference = (NormalIconTipPreference) this.screen.bmg("settings_my_finder_album");
            if (af.isNullOrNil(z.aUg())) {
                normalIconTipPreference.bml(getString(R.string.gr_));
            } else {
                normalIconTipPreference.bml("");
            }
            if (this.tFo == null) {
                this.tFo = new Observer<h.a>() {
                    /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass12 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.arch.lifecycle.Observer
                    public final /* synthetic */ void onChanged(h.a aVar) {
                        AppMethodBeat.i(258907);
                        h.a aVar2 = aVar;
                        NormalIconTipPreference normalIconTipPreference = (NormalIconTipPreference) MoreTabUI.this.screen.bmg("settings_my_finder_album");
                        if (aVar2 != null) {
                            Log.i("MicroMsg.MoreTabUI", "[onChanged] result=%s", aVar2);
                            if (aVar2.dEF) {
                                if (aVar2.tKS == null || !TextUtils.isEmpty(aVar2.tKS.title)) {
                                    normalIconTipPreference.aS(aVar2.tKS.title, -1, -7566196);
                                    normalIconTipPreference.alE(0);
                                } else {
                                    normalIconTipPreference.alE(8);
                                }
                                normalIconTipPreference.BB(true);
                                normalIconTipPreference.bml("");
                                bdo asW = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getRedDotManager().asW("ProfileEntrance");
                                k asX = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getRedDotManager().asX("ProfileEntrance");
                                if (!(asW == null || asX == null)) {
                                    j jVar = j.vft;
                                    j.a("12", asX, asW, 1, "", 0);
                                }
                                AppMethodBeat.o(258907);
                                return;
                            }
                            normalIconTipPreference.BB(false);
                            normalIconTipPreference.alE(8);
                            AppMethodBeat.o(258907);
                            return;
                        }
                        normalIconTipPreference.BB(false);
                        normalIconTipPreference.alE(8);
                        AppMethodBeat.o(258907);
                    }
                };
                com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
                com.tencent.mm.plugin.finder.extension.reddot.h.daM().observe(this, this.tFo);
            }
            com.tencent.mm.plugin.finder.extension.reddot.h hVar2 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
            com.tencent.mm.plugin.finder.extension.reddot.h.bxB("ProfileEntrance");
        } else {
            this.screen.m38do("settings_my_finder_album", true);
        }
        gJn();
        gJl();
        if (!com.tencent.mm.br.c.aZU("favorite")) {
            this.screen.m38do("settings_mm_favorite", true);
        } else {
            this.screen.m38do("settings_mm_favorite", false);
        }
        gJp();
        gJo();
        gJk();
        if (com.tencent.mm.kernel.g.aAd().ae(com.tencent.mm.plugin.y.a.a.class)) {
            this.screen.m38do("more_uishow", false);
        } else {
            this.screen.m38do("more_uishow", true);
        }
        Preference bmg = this.screen.bmg("settings_privacy_agreements");
        if (com.tencent.mm.aw.b.Pi((String) com.tencent.mm.kernel.g.aAh().azQ().get(274436, (Object) null))) {
            String string = getString(R.string.fp8);
            Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(string);
            newSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.x0)), newSpannable.length() - string.length(), newSpannable.length(), 33);
            bmg.setTitle(newSpannable);
            this.screen.m38do("settings_privacy_agreements", false);
        } else {
            this.screen.m38do("settings_privacy_agreements", true);
        }
        thisActivity().supportInvalidateOptionsMenu();
        this.screen.notifyDataSetChanged();
        final View findViewById = findViewById(R.id.epv);
        if (!(findViewById == null || findViewById.getVisibility() == 8)) {
            new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(33536);
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(MoreTabUI.this.getContext(), R.anim.bs));
                    AppMethodBeat.o(33536);
                }
            });
        }
        if (this.OIC != null && this.OIC.isVisible) {
            alh(0);
            Log.i("MicroMsg.MoreTabUI", "onTabResume force set actionbar visible!!");
        }
        if (this.BdF != null) {
            this.BdF.onResume();
            this.BdF.fmR();
        }
        updateStatus();
        if (this.OIJ != null) {
            AccountInfoPreference accountInfoPreference = this.OIJ;
            if (!((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck() || !com.tencent.mm.y.c.axV().cO(352279, 266241)) {
                z = false;
            } else {
                z = true;
            }
            accountInfoPreference.KoT = z;
            this.OIJ.grG();
        }
        Log.i("MicroMsg.MoreTabUI", "[onTabResume] cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(33577);
    }

    private void updateStatus() {
        d dVar;
        AppMethodBeat.i(232667);
        if (!(this.OIJ == null || (dVar = this.OIJ.BgU) == null)) {
            dVar.DV(com.tencent.mm.plugin.auth.a.a.ceA());
        }
        if (this.BdM != null) {
            this.BdM.DV(com.tencent.mm.plugin.auth.a.a.ceA());
        }
        AppMethodBeat.o(232667);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.AbstractTabChildPreference
    public final void gGw() {
        AppMethodBeat.i(33578);
        if (this.BdF != null) {
            this.BdF.onStart();
        }
        AppMethodBeat.o(33578);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.AbstractTabChildPreference
    public final void gGx() {
        AppMethodBeat.i(33579);
        Log.d("MicroMsg.MoreTabUI", "onTabPause %s", Integer.valueOf(hashCode()));
        com.tencent.mm.y.c.axV().b(this.DeE);
        bg.aVF();
        com.tencent.mm.model.c.azQ().remove(this);
        if (this.BdF != null) {
            this.BdF.onPause();
        }
        if (this.OIC != null) {
            if (!this.OIC.isVisible && !this.Bgv) {
                this.OIC.postDelayed(new Runnable() {
                    /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(232662);
                        MoreTabUI.this.OIC.hbX();
                        AppMethodBeat.o(232662);
                    }
                }, 200);
            } else if (this.OIC.isVisible && this.OIC.getTranslationY() != 0.0f) {
                this.OIC.setTranslationY(0.0f);
            }
        }
        if (this.OIJ != null) {
            this.OIJ.grF();
        }
        Bm(false);
        if (this.Vlt != null) {
            this.Vlt.Vlv = null;
            this.Vlt = null;
        }
        AppMethodBeat.o(33579);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.AbstractTabChildPreference
    public final void gGy() {
        AppMethodBeat.i(33580);
        if (this.BdF != null) {
            this.BdF.onStop();
        }
        AppMethodBeat.o(33580);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.AbstractTabChildPreference
    public final void gGz() {
        AppMethodBeat.i(33581);
        Log.i("MicroMsg.MoreTabUI", "onTabDestroy:  %s", Integer.valueOf(hashCode()));
        if (this.BdF != null) {
            this.BdF.onDestroy();
        }
        if (this.OIJ != null) {
            AccountInfoPreference accountInfoPreference = this.OIJ;
            if (accountInfoPreference.rFe) {
                ((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().fP(accountInfoPreference.KoP);
            }
        }
        AppMethodBeat.o(33581);
    }

    @Override // com.tencent.mm.ui.n
    public final void gGB() {
    }

    @Override // com.tencent.mm.ui.n
    public final void gGC() {
    }

    @Override // com.tencent.mm.ui.n
    public final void gGE() {
    }

    @Override // com.tencent.mm.ui.n
    public final void gHE() {
        boolean z;
        AppMethodBeat.i(33582);
        Log.d("MicroMsg.MoreTabUI", "onTabSwitchIn");
        this.OIQ = true;
        gJq();
        if (getContext() != null) {
            Configuration configuration = getResources().getConfiguration();
            this.nmu = configuration.orientation == 2;
            if ((configuration.screenLayout & 3) == 0 || (configuration.screenLayout & 16) == 0) {
                z = false;
            } else {
                z = true;
            }
            this.OIS = z;
        }
        if (this.OIC != null) {
            PullDownListView pullDownListView = this.OIC;
            as.i("MicroMsg.PullDownListView", "onResume", new Object[0]);
            pullDownListView.QRG = true;
            if (this.OIC.isVisible && this.OIC.getTranslationY() != 0.0f) {
                this.OIC.setTranslationY(0.0f);
            } else if (!this.OIC.isVisible) {
                this.OIC.hbX();
            }
        }
        if (this.BdF != null) {
            this.BdF.fmR();
        }
        if (this.Vlu) {
            try {
                SecDataUIC.a aVar = SecDataUIC.CWq;
                y yVar = (y) SecDataUIC.a.a(getContext(), 9, y.class);
                if (yVar != null) {
                    yVar.sessionId = com.tencent.mm.plugin.fts.a.d.Nj(1);
                }
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.MoreTabUI", th, "[handleTabSwitchOutForStatus]err", new Object[0]);
            }
            updateStatus();
        }
        this.Vlu = false;
        Bm(true);
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.Kv(currentTimeMillis);
        com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqB().eQM = currentTimeMillis;
        com.tencent.mm.plugin.story.h.h hVar3 = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqB().eRW = System.currentTimeMillis();
        if (!(getActivity() == null || getActivity().getWindow() == null)) {
            getActivity().getWindow().setSoftInputMode(34);
        }
        ((com.tencent.mm.plugin.updater.a.a) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.updater.a.a.class)).clickBottomTabRedDot();
        AppMethodBeat.o(33582);
    }

    @Override // com.tencent.mm.ui.n
    public final void gHF() {
        AppMethodBeat.i(33583);
        Log.d("MicroMsg.MoreTabUI", "onTabSwitchOut");
        this.OIQ = false;
        if (this.OIC != null) {
            PullDownListView pullDownListView = this.OIC;
            as.i("MicroMsg.PullDownListView", "onPause", new Object[0]);
            pullDownListView.QRG = false;
            if (!this.OIC.isVisible) {
                this.OIC.hbX();
            }
        }
        if (this.BdG != null) {
            this.BdG.setVisibility(8);
        }
        alh(0);
        EventCenter.instance.publish(new xe());
        Bm(false);
        com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqC();
        if (!(getActivity() == null || getActivity().getWindow() == null)) {
            getActivity().getWindow().setSoftInputMode(50);
        }
        this.Vlu = true;
        AppMethodBeat.o(33583);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.e
    public final void eEe() {
        AppMethodBeat.i(232669);
        Log.i("MicroMsg.MoreTabUI", "status statusUINoStatus");
        this.Bgw = false;
        this.OIC.setSupportOverscroll(false);
        if (this.OIC != null && !this.OIC.isVisible) {
            this.OIC.hbX();
        }
        this.OIF.ali(2);
        if (this.OIJ != null) {
            this.OIJ.grF();
        }
        AppMethodBeat.o(232669);
    }

    @Override // com.tencent.mm.plugin.textstatus.a.e
    public final void eEf() {
        AppMethodBeat.i(232670);
        Log.i("MicroMsg.MoreTabUI", "statusUIHasStatus");
        this.Bgw = true;
        if (this.OIC != null && this.OIC.isVisible && this.OIQ) {
            if (this.Bgw) {
                this.OIF.ali(3);
                AppMethodBeat.o(232670);
                return;
            }
            this.OIF.ali(2);
        }
        AppMethodBeat.o(232670);
    }

    @Override // com.tencent.mm.plugin.story.api.g
    public final void eEb() {
        AppMethodBeat.i(33584);
        Log.i("MicroMsg.MoreTabUI", "story_cat storyUINoStory");
        if (this.OIC != null && !this.OIC.isVisible) {
            this.OIC.hbX();
        }
        if (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck() || this.nmu) {
            this.OIF.ali(2);
        } else {
            this.OIF.ali(1);
        }
        if (this.OIJ != null) {
            this.OIJ.grF();
        }
        AppMethodBeat.o(33584);
    }

    @Override // com.tencent.mm.plugin.story.api.g
    public final void eEc() {
        AppMethodBeat.i(33585);
        Log.i("MicroMsg.MoreTabUI", "story_cat storyUIHasStory");
        if (this.OIC != null && this.OIC.isVisible && this.OIQ) {
            if (this.nmu) {
                this.OIF.ali(2);
            } else {
                this.OIF.ali(0);
            }
        }
        IconPreference iconPreference = (IconPreference) this.screen.bmg("settings_my_album");
        if (iconPreference != null) {
            if (com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.USERINFO_STORY_NEED_DISPLAY_ALBUM_GUIDE_BOOLEAN_SYNC, true)) {
                this.OIR = true;
                iconPreference.alF(0);
                AppMethodBeat.o(33585);
                return;
            }
            this.OIR = false;
            iconPreference.alF(8);
        }
        AppMethodBeat.o(33585);
    }

    @Override // com.tencent.mm.plugin.story.api.g
    public final void eEd() {
        AppMethodBeat.i(33586);
        Log.i("MicroMsg.MoreTabUI", "story_cat storyUIBackPressed");
        if (this.OIC != null && !this.OIC.isVisible) {
            this.OIC.hbX();
        }
        alh(0);
        Bn(this.Bgv);
        AppMethodBeat.o(33586);
    }

    private void Bm(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(33587);
        if (getActivity() != null) {
            if (this.BdR == null) {
                View findViewById = findViewById(R.id.c_);
                if (findViewById != null) {
                    this.BdR = findViewById.findViewById(R.id.c7);
                }
                Object[] objArr = new Object[1];
                if (this.BdR == null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                Log.i("MicroMsg.MoreTabUI", "checkActionBarClick: findActionBar %s", objArr);
            }
            if (this.BdR != null) {
                if (!z || this.OIG) {
                    this.BdR.setOnClickListener(null);
                } else {
                    this.BdR.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.ui.MoreTabUI.AnonymousClass6 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(232663);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MoreTabUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.MoreTabUI", "onClick: mActionBarRoot");
                            if (MoreTabUI.this.nmu) {
                                u.makeText(MoreTabUI.this.getContext(), MoreTabUI.this.getResources().getString(R.string.hiq), 0).show();
                            } else if (MoreTabUI.this.OIC != null && MoreTabUI.this.OIC.isVisible) {
                                MoreTabUI.this.OIC.hbY();
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MoreTabUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(232663);
                        }
                    });
                    AppMethodBeat.o(33587);
                    return;
                }
            }
        }
        AppMethodBeat.o(33587);
    }

    @Override // com.tencent.mm.ui.FragmentActivitySupport, com.tencent.mm.ui.AbstractTabChildPreference, com.tencent.mm.ui.MMFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z;
        AppMethodBeat.i(33588);
        if (i2 == 4 && keyEvent.getAction() == 0 && this.BdF != null) {
            z = this.BdF.onBackPressed();
        } else {
            z = false;
        }
        Log.d("MicroMsg.MoreTabUI", "onBackPressed: %b", Boolean.valueOf(z));
        if (z || super.onKeyDown(i2, keyEvent)) {
            AppMethodBeat.o(33588);
            return true;
        }
        AppMethodBeat.o(33588);
        return false;
    }

    private void Bn(boolean z) {
        AppMethodBeat.i(33589);
        if ((getContext() instanceof LauncherUI) && this.OIC != null && this.OIC.isVisible) {
            ((LauncherUI) getContext()).getHomeUI().Bf(z);
        }
        AppMethodBeat.o(33589);
    }

    /* access modifiers changed from: package-private */
    public final void eEh() {
        AppMethodBeat.i(33590);
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            getWindow().clearFlags(201327616);
            AppMethodBeat.o(33590);
            return;
        }
        getWindow().clearFlags(1024);
        AppMethodBeat.o(33590);
    }

    /* access modifiers changed from: package-private */
    public class b {
        private int status;

        private b() {
            this.status = 2;
        }

        /* synthetic */ b(MoreTabUI moreTabUI, byte b2) {
            this();
        }

        @SuppressLint({"ResourceType"})
        public final void eEj() {
            AppMethodBeat.i(33552);
            Log.i("MicroMsg.MoreTabUI", "updateUIByStory status:%s", Integer.valueOf(this.status));
            if (MoreTabUI.this.getActivity() == null) {
                AppMethodBeat.o(33552);
                return;
            }
            if (this.status == 3) {
                MoreTabUI.this.OIC.setSelector(R.color.f3043a);
            } else {
                MoreTabUI.this.OIC.setSelector(R.color.ac_);
            }
            switch (this.status) {
                case 0:
                    MoreTabUI.this.OIC.setBackground(at.aN(MoreTabUI.this.getContext(), R.attr.v2));
                    MoreTabUI.this.OIC.setSupportOverscroll(MoreTabUI.this.Bgv);
                    MoreTabUI.this.OIP = false;
                    MoreTabUI.this.OIN = com.tencent.mm.cb.a.aH(MoreTabUI.this.getContext(), R.dimen.agv);
                    if (MoreTabUI.this.BdF != null) {
                        ((RelativeLayout.LayoutParams) MoreTabUI.this.BdF.getLayoutParams()).topMargin = MoreTabUI.this.OIO;
                        MoreTabUI.this.OIC.y(MoreTabUI.this.BdF, MoreTabUI.this.OIN, MoreTabUI.this.OIO);
                    }
                    MoreTabUI.this.OIC.setMuteView(MoreTabUI.this.BdG);
                    MoreTabUI.c(MoreTabUI.this, MoreTabUI.this.Bgv);
                    MoreTabUI.a(MoreTabUI.this, 0);
                    MoreTabUI.b(MoreTabUI.this, MoreTabUI.this.Bgv);
                    MoreTabUI.this.OIC.setNeedHover(false);
                    if (MoreTabUI.this.OIJ != null) {
                        MoreTabUI.this.OIJ.p(MoreTabUI.this.Bgv, MoreTabUI.this.OIP, MoreTabUI.this.Bgw);
                        AppMethodBeat.o(33552);
                        return;
                    }
                    break;
                case 1:
                    MoreTabUI.this.OIC.setSupportOverscroll(true);
                    MoreTabUI.w(MoreTabUI.this);
                    if (MoreTabUI.this.OIP) {
                        MoreTabUI.this.OIC.setBackground(at.aN(MoreTabUI.this.getContext(), R.attr.v3));
                    } else {
                        MoreTabUI.this.OIC.setBackground(at.aN(MoreTabUI.this.getContext(), R.attr.v2));
                    }
                    if (MoreTabUI.this.BdF != null) {
                        ((RelativeLayout.LayoutParams) MoreTabUI.this.BdF.getLayoutParams()).topMargin = MoreTabUI.this.OIM;
                        MoreTabUI.this.OIC.y(MoreTabUI.this.BdF, MoreTabUI.this.OIN, MoreTabUI.this.OIM);
                    }
                    MoreTabUI.this.OIC.setMuteView(null);
                    MoreTabUI.c(MoreTabUI.this, MoreTabUI.this.Bgv);
                    MoreTabUI.a(MoreTabUI.this, 0);
                    MoreTabUI.b(MoreTabUI.this, MoreTabUI.this.Bgv);
                    if (MoreTabUI.this.OIJ != null) {
                        MoreTabUI.this.OIJ.p(MoreTabUI.this.Bgv, MoreTabUI.this.OIP, MoreTabUI.this.Bgw);
                    }
                    MoreTabUI.this.OIC.setNeedHover(false);
                    AppMethodBeat.o(33552);
                    return;
                case 2:
                    MoreTabUI.this.OIC.setBackground(at.aN(MoreTabUI.this.getContext(), R.attr.v3));
                    MoreTabUI.this.OIC.setSupportOverscroll(MoreTabUI.this.Bgv);
                    MoreTabUI.this.OIC.setNeedHover(false);
                    MoreTabUI.c(MoreTabUI.this, MoreTabUI.this.Bgv);
                    MoreTabUI.t(MoreTabUI.this);
                    if (MoreTabUI.this.OIJ != null) {
                        MoreTabUI.this.OIJ.p(MoreTabUI.this.Bgv, MoreTabUI.this.OIP, MoreTabUI.this.Bgw);
                        break;
                    }
                    break;
                case 3:
                    MoreTabUI.this.OIC.setSupportOverscroll(((com.tencent.mm.plugin.textstatus.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).isHasStatusThumb(com.tencent.mm.plugin.auth.a.a.ceA()));
                    MoreTabUI.this.OIC.setBackground(null);
                    MoreTabUI.this.OIC.setMuteView(null);
                    MoreTabUI.this.OIC.setNeedHover(true);
                    MoreTabUI.c(MoreTabUI.this, MoreTabUI.this.Bgw);
                    if (MoreTabUI.this.OIJ != null) {
                        MoreTabUI.this.OIJ.p(MoreTabUI.this.Bgv, MoreTabUI.this.OIP, MoreTabUI.this.Bgw);
                        AppMethodBeat.o(33552);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(33552);
        }

        public final void gJs() {
            AppMethodBeat.i(33553);
            MoreTabUI.this.Bgw = ((com.tencent.mm.plugin.textstatus.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).hasStatus(com.tencent.mm.plugin.auth.a.a.ceA());
            if (MoreTabUI.this.OIG) {
                if (!MoreTabUI.this.Bgw) {
                    this.status = 2;
                } else {
                    this.status = 3;
                }
                MoreTabUI.this.Bgv = false;
            } else if (com.tencent.mm.plugin.story.api.o.isShowStoryCheck() || MoreTabUI.this.nmu) {
                MoreTabUI.this.Bgv = false;
                this.status = 2;
            } else if (((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(z.aTY())) {
                MoreTabUI.this.Bgv = true;
                this.status = 0;
            } else {
                MoreTabUI.this.Bgv = false;
                this.status = 1;
            }
            Log.i("MicroMsg.MoreTabUI", "checkStoryStatus status=%s", Integer.valueOf(this.status));
            eEj();
            AppMethodBeat.o(33553);
        }

        public final void ali(int i2) {
            AppMethodBeat.i(33554);
            Log.i("MicroMsg.MoreTabUI", "forceToStatus %s", Integer.valueOf(i2));
            if (i2 == 0) {
                MoreTabUI.this.Bgv = true;
            } else {
                MoreTabUI.this.Bgv = false;
            }
            this.status = i2;
            eEj();
            AppMethodBeat.o(33554);
        }
    }

    class a implements com.tencent.mm.ak.i {
        a() {
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        }
    }

    static /* synthetic */ void a(MoreTabUI moreTabUI, String str) {
        AppMethodBeat.i(33599);
        Log.i("MicroMsg.MoreTabUI", "updateBubbleTip %s", str);
        boolean z = ((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).isShowStoryCheck() && Util.isEqual("1", str);
        if (moreTabUI.OIJ != null) {
            moreTabUI.OIJ.KoT = z;
        }
        Log.i("MicroMsg.MoreTabUI", "hasUnreadComment: %s", Boolean.valueOf(z));
        if (!(moreTabUI.OII || moreTabUI.OIJ == null || moreTabUI.OIC == null)) {
            moreTabUI.OIJ.grG();
        }
        AppMethodBeat.o(33599);
    }

    static /* synthetic */ void h(MoreTabUI moreTabUI) {
        AppMethodBeat.i(33601);
        ((com.tencent.mm.plugin.lite.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.lite.a.a.class)).gr(moreTabUI.getContext());
        AppMethodBeat.o(33601);
    }

    static /* synthetic */ void i(MoreTabUI moreTabUI) {
        AppMethodBeat.i(232671);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.setClass(moreTabUI.getContext(), FinderPostRouterUI.class);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.drH()) {
            intent.putExtra("key_can_select_video_and_pic", true);
        }
        intent.putExtra("is_hide_album_footer", true);
        intent.putExtra("show_header_view", false);
        intent.putExtra("max_select_count", 9);
        intent.putExtra("query_source_type", 25);
        intent.putExtra("query_media_type", 3);
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        intent.putExtra("album_video_max_duration", com.tencent.mm.plugin.finder.storage.c.dqA());
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        intent.putExtra("album_video_min_duration", com.tencent.mm.plugin.finder.storage.c.dqw().minDuration);
        intent.putExtra("key_finder_post_router", 10);
        Activity context = moreTabUI.getContext();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/MoreTabUI", "startFlutterVideoEditorChoosePic", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/MoreTabUI", "startFlutterVideoEditorChoosePic", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(232671);
    }

    static /* synthetic */ boolean j(MoreTabUI moreTabUI) {
        AppMethodBeat.i(232672);
        ((com.tencent.mm.plugin.flutter.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.flutter.a.a.class)).a(moreTabUI.getContext(), new com.tencent.mm.plugin.flutter.a.c("emoticon", "store", new LinkedHashMap()));
        AppMethodBeat.o(232672);
        return true;
    }

    static /* synthetic */ void k(MoreTabUI moreTabUI) {
        AppMethodBeat.i(232673);
        com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.y.a.a.a.class);
        moreTabUI.getContext();
        new Intent();
        AppMethodBeat.o(232673);
    }

    static /* synthetic */ void t(MoreTabUI moreTabUI) {
        AppMethodBeat.i(232675);
        if (moreTabUI.getContext() instanceof LauncherUI) {
            HomeUI homeUI = ((LauncherUI) moreTabUI.getContext()).getHomeUI();
            if (homeUI.ODh != null) {
                homeUI.ODh.setVisible(false);
                homeUI.ODh.setEnabled(false);
            }
        }
        AppMethodBeat.o(232675);
    }

    static /* synthetic */ void u(MoreTabUI moreTabUI) {
        AppMethodBeat.i(232676);
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            moreTabUI.getWindow().setFlags(201327616, 201327616);
            AppMethodBeat.o(232676);
            return;
        }
        moreTabUI.getWindow().setFlags(1024, 1024);
        AppMethodBeat.o(232676);
    }

    static /* synthetic */ void c(MoreTabUI moreTabUI, boolean z) {
        FragmentActivity activity;
        Window window;
        View decorView;
        int i2;
        AppMethodBeat.i(232680);
        Log.i("MicroMsg.MoreTabUI", "updateStatusBarCell %s stack: %s", Boolean.valueOf(z), af.blN().toString());
        if (!(Build.VERSION.SDK_INT < 23 || (activity = moreTabUI.getActivity()) == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null)) {
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z || ao.isDarkMode()) {
                i2 = systemUiVisibility & -8193;
            } else {
                i2 = systemUiVisibility | 8192;
            }
            decorView.setSystemUiVisibility(i2);
        }
        AppMethodBeat.o(232680);
    }
}
